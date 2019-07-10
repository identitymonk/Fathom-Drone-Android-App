package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class AsyncTimeout extends Timeout
{
  private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60L);
  private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
  private static final int TIMEOUT_WRITE_SIZE = 65536;

  @Nullable
  static AsyncTimeout head;
  private boolean inQueue;

  @Nullable
  private AsyncTimeout next;
  private long timeoutAt;

  @Nullable
  static AsyncTimeout awaitTimeout()
    throws InterruptedException
  {
    Object localObject2 = null;
    Object localObject1 = head.next;
    if (localObject1 == null)
    {
      l1 = System.nanoTime();
      AsyncTimeout.class.wait(IDLE_TIMEOUT_MILLIS);
      localObject1 = localObject2;
      if (head.next == null)
      {
        localObject1 = localObject2;
        if (System.nanoTime() - l1 >= IDLE_TIMEOUT_NANOS)
          localObject1 = head;
      }
      return localObject1;
    }
    long l1 = ((AsyncTimeout)localObject1).remainingNanos(System.nanoTime());
    if (l1 > 0L)
    {
      long l2 = l1 / 1000000L;
      AsyncTimeout.class.wait(l2, (int)(l1 - l2 * 1000000L));
      return null;
    }
    head.next = ((AsyncTimeout)localObject1).next;
    ((AsyncTimeout)localObject1).next = null;
    return (AsyncTimeout)localObject1;
  }

  private static boolean cancelScheduledTimeout(AsyncTimeout paramAsyncTimeout)
  {
    monitorenter;
    try
    {
      AsyncTimeout localAsyncTimeout = head;
      if (localAsyncTimeout != null)
        if (localAsyncTimeout.next == paramAsyncTimeout)
        {
          localAsyncTimeout.next = paramAsyncTimeout.next;
          paramAsyncTimeout.next = null;
        }
      for (int i = 0; ; i = 1)
      {
        return i;
        localAsyncTimeout = localAsyncTimeout.next;
        break;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramAsyncTimeout;
  }

  private long remainingNanos(long paramLong)
  {
    return this.timeoutAt - paramLong;
  }

  private static void scheduleTimeout(AsyncTimeout paramAsyncTimeout, long paramLong, boolean paramBoolean)
  {
    monitorenter;
    while (true)
    {
      try
      {
        if (head != null)
          continue;
        head = new AsyncTimeout();
        new Watchdog().start();
        long l = System.nanoTime();
        if ((paramLong == 0L) || (!paramBoolean))
          continue;
        paramAsyncTimeout.timeoutAt = (Math.min(paramLong, paramAsyncTimeout.deadlineNanoTime() - l) + l);
        paramLong = paramAsyncTimeout.remainingNanos(l);
        localAsyncTimeout = head;
        if ((localAsyncTimeout.next != null) && (paramLong >= localAsyncTimeout.next.remainingNanos(l)))
          break label175;
        paramAsyncTimeout.next = localAsyncTimeout.next;
        localAsyncTimeout.next = paramAsyncTimeout;
        if (localAsyncTimeout != head)
          continue;
        AsyncTimeout.class.notify();
        return;
        if (paramLong != 0L)
        {
          paramAsyncTimeout.timeoutAt = (l + paramLong);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      if (paramBoolean)
      {
        paramAsyncTimeout.timeoutAt = paramAsyncTimeout.deadlineNanoTime();
        continue;
      }
      throw new AssertionError();
      label175: AsyncTimeout localAsyncTimeout = localAsyncTimeout.next;
    }
  }

  public final void enter()
  {
    if (this.inQueue)
      throw new IllegalStateException("Unbalanced enter/exit");
    long l = timeoutNanos();
    boolean bool = hasDeadline();
    if ((l == 0L) && (!bool))
      return;
    this.inQueue = true;
    scheduleTimeout(this, l, bool);
  }

  final IOException exit(IOException paramIOException)
    throws IOException
  {
    if (!exit())
      return paramIOException;
    return newTimeoutException(paramIOException);
  }

  final void exit(boolean paramBoolean)
    throws IOException
  {
    if ((exit()) && (paramBoolean))
      throw newTimeoutException(null);
  }

  public final boolean exit()
  {
    if (!this.inQueue)
      return false;
    this.inQueue = false;
    return cancelScheduledTimeout(this);
  }

  protected IOException newTimeoutException(@Nullable IOException paramIOException)
  {
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null)
      localInterruptedIOException.initCause(paramIOException);
    return localInterruptedIOException;
  }

  public final Sink sink(Sink paramSink)
  {
    return new Sink(paramSink)
    {
      public void close()
        throws IOException
      {
        AsyncTimeout.this.enter();
        try
        {
          this.val$sink.close();
          AsyncTimeout.this.exit(true);
          return;
        }
        catch (IOException localIOException)
        {
          throw AsyncTimeout.this.exit(localIOException);
        }
        finally
        {
          AsyncTimeout.this.exit(false);
        }
        throw localObject;
      }

      public void flush()
        throws IOException
      {
        AsyncTimeout.this.enter();
        try
        {
          this.val$sink.flush();
          AsyncTimeout.this.exit(true);
          return;
        }
        catch (IOException localIOException)
        {
          throw AsyncTimeout.this.exit(localIOException);
        }
        finally
        {
          AsyncTimeout.this.exit(false);
        }
        throw localObject;
      }

      public Timeout timeout()
      {
        return AsyncTimeout.this;
      }

      public String toString()
      {
        return "AsyncTimeout.sink(" + this.val$sink + ")";
      }

      public void write(Buffer paramBuffer, long paramLong)
        throws IOException
      {
        Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
        while (paramLong > 0L)
        {
          long l1 = 0L;
          Segment localSegment = paramBuffer.head;
          label24: long l2 = l1;
          if (l1 < 65536L)
          {
            l1 += paramBuffer.head.limit - paramBuffer.head.pos;
            if (l1 >= paramLong)
              l2 = paramLong;
          }
          else
          {
            AsyncTimeout.this.enter();
          }
          try
          {
            this.val$sink.write(paramBuffer, l2);
            paramLong -= l2;
            AsyncTimeout.this.exit(true);
            continue;
            localSegment = localSegment.next;
            break label24;
          }
          catch (IOException paramBuffer)
          {
            throw AsyncTimeout.this.exit(paramBuffer);
          }
          finally
          {
            AsyncTimeout.this.exit(false);
          }
        }
      }
    };
  }

  public final Source source(Source paramSource)
  {
    return new Source(paramSource)
    {
      public void close()
        throws IOException
      {
        try
        {
          this.val$source.close();
          AsyncTimeout.this.exit(true);
          return;
        }
        catch (IOException localIOException)
        {
          throw AsyncTimeout.this.exit(localIOException);
        }
        finally
        {
          AsyncTimeout.this.exit(false);
        }
        throw localObject;
      }

      public long read(Buffer paramBuffer, long paramLong)
        throws IOException
      {
        AsyncTimeout.this.enter();
        try
        {
          paramLong = this.val$source.read(paramBuffer, paramLong);
          AsyncTimeout.this.exit(true);
          return paramLong;
        }
        catch (IOException paramBuffer)
        {
          throw AsyncTimeout.this.exit(paramBuffer);
        }
        finally
        {
          AsyncTimeout.this.exit(false);
        }
        throw paramBuffer;
      }

      public Timeout timeout()
      {
        return AsyncTimeout.this;
      }

      public String toString()
      {
        return "AsyncTimeout.source(" + this.val$source + ")";
      }
    };
  }

  protected void timedOut()
  {
  }

  private static final class Watchdog extends Thread
  {
    Watchdog()
    {
      super();
      setDaemon(true);
    }

    public void run()
    {
      while (true)
      {
        try
        {
          monitorenter;
          try
          {
            AsyncTimeout localAsyncTimeout = AsyncTimeout.awaitTimeout();
            if (localAsyncTimeout != null)
              break label27;
            monitorexit;
            continue;
          }
          finally
          {
            monitorexit;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
        }
        continue;
        label27: if (localInterruptedException == AsyncTimeout.head)
        {
          AsyncTimeout.head = null;
          monitorexit;
          return;
        }
        monitorexit;
        localInterruptedException.timedOut();
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okio.AsyncTimeout
 * JD-Core Version:    0.6.0
 */
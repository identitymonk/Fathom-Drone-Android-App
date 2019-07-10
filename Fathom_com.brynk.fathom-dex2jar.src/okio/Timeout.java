package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class Timeout
{
  public static final Timeout NONE = new Timeout()
  {
    public Timeout deadlineNanoTime(long paramLong)
    {
      return this;
    }

    public void throwIfReached()
      throws IOException
    {
    }

    public Timeout timeout(long paramLong, TimeUnit paramTimeUnit)
    {
      return this;
    }
  };
  private long deadlineNanoTime;
  private boolean hasDeadline;
  private long timeoutNanos;

  public Timeout clearDeadline()
  {
    this.hasDeadline = false;
    return this;
  }

  public Timeout clearTimeout()
  {
    this.timeoutNanos = 0L;
    return this;
  }

  public final Timeout deadline(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("duration <= 0: " + paramLong);
    if (paramTimeUnit == null)
      throw new IllegalArgumentException("unit == null");
    return deadlineNanoTime(System.nanoTime() + paramTimeUnit.toNanos(paramLong));
  }

  public long deadlineNanoTime()
  {
    if (!this.hasDeadline)
      throw new IllegalStateException("No deadline");
    return this.deadlineNanoTime;
  }

  public Timeout deadlineNanoTime(long paramLong)
  {
    this.hasDeadline = true;
    this.deadlineNanoTime = paramLong;
    return this;
  }

  public boolean hasDeadline()
  {
    return this.hasDeadline;
  }

  public void throwIfReached()
    throws IOException
  {
    if (Thread.interrupted())
      throw new InterruptedIOException("thread interrupted");
    if ((this.hasDeadline) && (this.deadlineNanoTime - System.nanoTime() <= 0L))
      throw new InterruptedIOException("deadline reached");
  }

  public Timeout timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("timeout < 0: " + paramLong);
    if (paramTimeUnit == null)
      throw new IllegalArgumentException("unit == null");
    this.timeoutNanos = paramTimeUnit.toNanos(paramLong);
    return this;
  }

  public long timeoutNanos()
  {
    return this.timeoutNanos;
  }

  public final void waitUntilNotified(Object paramObject)
    throws InterruptedIOException
  {
    while (true)
    {
      boolean bool;
      long l1;
      long l3;
      try
      {
        bool = hasDeadline();
        l1 = timeoutNanos();
        if ((bool) || (l1 != 0L))
          continue;
        paramObject.wait();
        return;
        l3 = System.nanoTime();
        if ((bool) && (l1 != 0L))
        {
          l1 = Math.min(l1, deadlineNanoTime() - l3);
          long l2 = 0L;
          if (l1 <= 0L)
            continue;
          l2 = l1 / 1000000L;
          paramObject.wait(l2, (int)(l1 - 1000000L * l2));
          l2 = System.nanoTime() - l3;
          if (l2 < l1)
            break;
          throw new InterruptedIOException("timeout");
        }
      }
      catch (java.lang.InterruptedException paramObject)
      {
        throw new InterruptedIOException("interrupted");
      }
      if (bool)
      {
        l1 = deadlineNanoTime();
        l1 -= l3;
        continue;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okio.Timeout
 * JD-Core Version:    0.6.0
 */
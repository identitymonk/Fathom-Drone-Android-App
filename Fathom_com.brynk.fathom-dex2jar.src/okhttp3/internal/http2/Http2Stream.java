package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http2Stream
{
  long bytesLeftInWriteWindow;
  final Http2Connection connection;
  ErrorCode errorCode = null;
  private boolean hasResponseHeaders;
  final int id;
  final StreamTimeout readTimeout = new StreamTimeout();
  private final List<Header> requestHeaders;
  private List<Header> responseHeaders;
  final FramingSink sink;
  private final FramingSource source;
  long unacknowledgedBytesRead = 0L;
  final StreamTimeout writeTimeout = new StreamTimeout();

  static
  {
    if (!Http2Stream.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }

  Http2Stream(int paramInt, Http2Connection paramHttp2Connection, boolean paramBoolean1, boolean paramBoolean2, List<Header> paramList)
  {
    if (paramHttp2Connection == null)
      throw new NullPointerException("connection == null");
    if (paramList == null)
      throw new NullPointerException("requestHeaders == null");
    this.id = paramInt;
    this.connection = paramHttp2Connection;
    this.bytesLeftInWriteWindow = paramHttp2Connection.peerSettings.getInitialWindowSize();
    this.source = new FramingSource(paramHttp2Connection.okHttpSettings.getInitialWindowSize());
    this.sink = new FramingSink();
    this.source.finished = paramBoolean2;
    this.sink.finished = paramBoolean1;
    this.requestHeaders = paramList;
  }

  private boolean closeInternal(ErrorCode paramErrorCode)
  {
    assert (!Thread.holdsLock(this));
    monitorenter;
    try
    {
      if (this.errorCode != null)
        return false;
      if ((this.source.finished) && (this.sink.finished))
        return false;
    }
    finally
    {
      monitorexit;
    }
    this.errorCode = paramErrorCode;
    notifyAll();
    monitorexit;
    this.connection.removeStream(this.id);
    return true;
  }

  void addBytesToWriteWindow(long paramLong)
  {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L)
      notifyAll();
  }

  void cancelStreamIfNecessary()
    throws IOException
  {
    assert (!Thread.holdsLock(this));
    monitorenter;
    while (true)
    {
      boolean bool;
      try
      {
        if ((this.source.finished) || (!this.source.closed))
          continue;
        if (this.sink.finished)
          break label112;
        if (!this.sink.closed)
          continue;
        break label112;
        bool = isOpen();
        monitorexit;
        if (i != 0)
        {
          close(ErrorCode.CANCEL);
          return;
          i = 0;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      if (bool)
        continue;
      this.connection.removeStream(this.id);
      return;
      label112: int i = 1;
    }
  }

  void checkOutNotClosed()
    throws IOException
  {
    if (this.sink.closed)
      throw new IOException("stream closed");
    if (this.sink.finished)
      throw new IOException("stream finished");
    if (this.errorCode != null)
      throw new StreamResetException(this.errorCode);
  }

  public void close(ErrorCode paramErrorCode)
    throws IOException
  {
    if (!closeInternal(paramErrorCode))
      return;
    this.connection.writeSynReset(this.id, paramErrorCode);
  }

  public void closeLater(ErrorCode paramErrorCode)
  {
    if (!closeInternal(paramErrorCode))
      return;
    this.connection.writeSynResetLater(this.id, paramErrorCode);
  }

  public Http2Connection getConnection()
  {
    return this.connection;
  }

  public ErrorCode getErrorCode()
  {
    monitorenter;
    try
    {
      ErrorCode localErrorCode = this.errorCode;
      monitorexit;
      return localErrorCode;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int getId()
  {
    return this.id;
  }

  public List<Header> getRequestHeaders()
  {
    return this.requestHeaders;
  }

  public Sink getSink()
  {
    monitorenter;
    try
    {
      if ((!this.hasResponseHeaders) && (!isLocallyInitiated()))
        throw new IllegalStateException("reply before requesting the sink");
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
    return this.sink;
  }

  public Source getSource()
  {
    return this.source;
  }

  public boolean isLocallyInitiated()
  {
    if ((this.id & 0x1) == 1);
    for (int i = 1; this.connection.client == i; i = 0)
      return true;
    return false;
  }

  public boolean isOpen()
  {
    int i = 0;
    monitorenter;
    try
    {
      ErrorCode localErrorCode = this.errorCode;
      if (localErrorCode != null);
      while (true)
      {
        return i;
        if (((this.source.finished) || (this.source.closed)) && ((this.sink.finished) || (this.sink.closed)))
        {
          boolean bool = this.hasResponseHeaders;
          if (bool)
            continue;
        }
        i = 1;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public Timeout readTimeout()
  {
    return this.readTimeout;
  }

  void receiveData(BufferedSource paramBufferedSource, int paramInt)
    throws IOException
  {
    assert (!Thread.holdsLock(this));
    this.source.receive(paramBufferedSource, paramInt);
  }

  void receiveFin()
  {
    assert (!Thread.holdsLock(this));
    monitorenter;
    try
    {
      this.source.finished = true;
      boolean bool = isOpen();
      notifyAll();
      monitorexit;
      if (!bool)
        this.connection.removeStream(this.id);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  void receiveHeaders(List<Header> paramList)
  {
    assert (!Thread.holdsLock(this));
    boolean bool = true;
    monitorenter;
    try
    {
      this.hasResponseHeaders = true;
      if (this.responseHeaders == null)
      {
        this.responseHeaders = paramList;
        bool = isOpen();
        notifyAll();
      }
      while (true)
      {
        monitorexit;
        if (!bool)
          this.connection.removeStream(this.id);
        return;
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(this.responseHeaders);
        localArrayList.add(null);
        localArrayList.addAll(paramList);
        this.responseHeaders = localArrayList;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramList;
  }

  void receiveRstStream(ErrorCode paramErrorCode)
  {
    monitorenter;
    try
    {
      if (this.errorCode == null)
      {
        this.errorCode = paramErrorCode;
        notifyAll();
      }
      monitorexit;
      return;
    }
    finally
    {
      paramErrorCode = finally;
      monitorexit;
    }
    throw paramErrorCode;
  }

  public void sendResponseHeaders(List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    assert (!Thread.holdsLock(this));
    if (paramList == null)
      throw new NullPointerException("responseHeaders == null");
    boolean bool = false;
    monitorenter;
    try
    {
      this.hasResponseHeaders = true;
      if (!paramBoolean)
      {
        this.sink.finished = true;
        bool = true;
      }
      monitorexit;
      this.connection.writeSynReply(this.id, bool, paramList);
      if (bool)
        this.connection.flush();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw paramList;
  }

  public List<Header> takeResponseHeaders()
    throws IOException
  {
    monitorenter;
    try
    {
      if (!isLocallyInitiated())
        throw new IllegalStateException("servers cannot read response headers");
    }
    finally
    {
      monitorexit;
    }
    this.readTimeout.enter();
    try
    {
      if ((this.responseHeaders == null) && (this.errorCode == null))
        waitForIo();
    }
    finally
    {
      this.readTimeout.exitAndThrowIfTimedOut();
    }
    List localList = this.responseHeaders;
    if (localList != null)
    {
      this.responseHeaders = null;
      monitorexit;
      return localList;
    }
    throw new StreamResetException(this.errorCode);
  }

  void waitForIo()
    throws InterruptedIOException
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    throw new InterruptedIOException();
  }

  public Timeout writeTimeout()
  {
    return this.writeTimeout;
  }

  final class FramingSink
    implements Sink
  {
    private static final long EMIT_BUFFER_SIZE = 16384L;
    boolean closed;
    boolean finished;
    private final Buffer sendBuffer = new Buffer();

    static
    {
      if (!Http2Stream.class.desiredAssertionStatus());
      for (boolean bool = true; ; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }

    FramingSink()
    {
    }

    private void emitFrame(boolean paramBoolean)
      throws IOException
    {
      synchronized (Http2Stream.this)
      {
        Http2Stream.this.writeTimeout.enter();
      }
      Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
      Http2Stream.this.checkOutNotClosed();
      long l = Math.min(Http2Stream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
      Http2Stream localHttp2Stream = Http2Stream.this;
      localHttp2Stream.bytesLeftInWriteWindow -= l;
      monitorexit;
      Http2Stream.this.writeTimeout.enter();
      try
      {
        ??? = Http2Stream.this.connection;
        int i = Http2Stream.this.id;
        if ((paramBoolean) && (l == this.sendBuffer.size()));
        for (paramBoolean = true; ; paramBoolean = false)
        {
          ((Http2Connection)???).writeData(i, paramBoolean, this.sendBuffer, l);
          return;
        }
      }
      finally
      {
        Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
      }
      throw localObject2;
    }

    public void close()
      throws IOException
    {
      assert (!Thread.holdsLock(Http2Stream.this));
      synchronized (Http2Stream.this)
      {
        if (this.closed)
          return;
        if (Http2Stream.this.sink.finished)
          break label113;
        if (this.sendBuffer.size() > 0L)
        {
          if (this.sendBuffer.size() <= 0L)
            break label113;
          emitFrame(true);
        }
      }
      Http2Stream.this.connection.writeData(Http2Stream.this.id, true, null, 0L);
      label113: synchronized (Http2Stream.this)
      {
        this.closed = true;
        Http2Stream.this.connection.flush();
        Http2Stream.this.cancelStreamIfNecessary();
        return;
      }
    }

    public void flush()
      throws IOException
    {
      assert (!Thread.holdsLock(Http2Stream.this));
      synchronized (Http2Stream.this)
      {
        Http2Stream.this.checkOutNotClosed();
        if (this.sendBuffer.size() > 0L)
        {
          emitFrame(false);
          Http2Stream.this.connection.flush();
        }
      }
    }

    public Timeout timeout()
    {
      return Http2Stream.this.writeTimeout;
    }

    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      assert (!Thread.holdsLock(Http2Stream.this));
      this.sendBuffer.write(paramBuffer, paramLong);
      while (this.sendBuffer.size() >= 16384L)
        emitFrame(false);
    }
  }

  private final class FramingSource
    implements Source
  {
    boolean closed;
    boolean finished;
    private final long maxByteCount;
    private final Buffer readBuffer = new Buffer();
    private final Buffer receiveBuffer = new Buffer();

    static
    {
      if (!Http2Stream.class.desiredAssertionStatus());
      for (boolean bool = true; ; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }

    FramingSource(long arg2)
    {
      Object localObject;
      this.maxByteCount = localObject;
    }

    private void checkNotClosed()
      throws IOException
    {
      if (this.closed)
        throw new IOException("stream closed");
      if (Http2Stream.this.errorCode != null)
        throw new StreamResetException(Http2Stream.this.errorCode);
    }

    private void waitUntilReadable()
      throws IOException
    {
      Http2Stream.this.readTimeout.enter();
      try
      {
        if (this.readBuffer.size() == 0L)
          if ((!this.finished) && (!this.closed) && (Http2Stream.this.errorCode == null))
            Http2Stream.this.waitForIo();
      }
      finally
      {
        Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
      }
    }

    public void close()
      throws IOException
    {
      synchronized (Http2Stream.this)
      {
        this.closed = true;
        this.readBuffer.clear();
        Http2Stream.this.notifyAll();
        Http2Stream.this.cancelStreamIfNecessary();
        return;
      }
    }

    public long read(Buffer arg1, long paramLong)
      throws IOException
    {
      if (paramLong < 0L)
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      synchronized (Http2Stream.this)
      {
        waitUntilReadable();
        checkNotClosed();
        if (this.readBuffer.size() == 0L)
          return -1L;
        paramLong = this.readBuffer.read(???, Math.min(paramLong, this.readBuffer.size()));
        ??? = Http2Stream.this;
        ???.unacknowledgedBytesRead += paramLong;
        if (Http2Stream.this.unacknowledgedBytesRead >= Http2Stream.this.connection.okHttpSettings.getInitialWindowSize() / 2)
        {
          Http2Stream.this.connection.writeWindowUpdateLater(Http2Stream.this.id, Http2Stream.this.unacknowledgedBytesRead);
          Http2Stream.this.unacknowledgedBytesRead = 0L;
        }
        synchronized (Http2Stream.this.connection)
        {
          ??? = Http2Stream.this.connection;
          ((Http2Connection)???).unacknowledgedBytesRead += paramLong;
          if (Http2Stream.this.connection.unacknowledgedBytesRead >= Http2Stream.this.connection.okHttpSettings.getInitialWindowSize() / 2)
          {
            Http2Stream.this.connection.writeWindowUpdateLater(0, Http2Stream.this.connection.unacknowledgedBytesRead);
            Http2Stream.this.connection.unacknowledgedBytesRead = 0L;
          }
          return paramLong;
        }
      }
    }

    void receive(BufferedSource paramBufferedSource, long paramLong)
      throws IOException
    {
      long l = paramLong;
      if (!$assertionsDisabled)
      {
        l = paramLong;
        if (Thread.holdsLock(Http2Stream.this))
          throw new AssertionError();
      }
      while (true)
      {
        l -= paramLong;
        synchronized (Http2Stream.this)
        {
          if (this.readBuffer.size() == 0L)
          {
            i = 1;
            this.readBuffer.writeAll(this.receiveBuffer);
            if (i != 0)
              Http2Stream.this.notifyAll();
            if (l > 0L);
            boolean bool;
            synchronized (Http2Stream.this)
            {
              bool = this.finished;
              if (this.readBuffer.size() + l > this.maxByteCount)
              {
                i = 1;
                if (i != 0)
                {
                  paramBufferedSource.skip(l);
                  Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                  return;
                }
              }
              else
              {
                i = 0;
              }
            }
            if (bool)
            {
              paramBufferedSource.skip(l);
              return;
            }
            paramLong = paramBufferedSource.read(this.receiveBuffer, l);
            if (paramLong != -1L)
              continue;
            throw new EOFException();
          }
          int i = 0;
        }
      }
    }

    public Timeout timeout()
    {
      return Http2Stream.this.readTimeout;
    }
  }

  class StreamTimeout extends AsyncTimeout
  {
    StreamTimeout()
    {
    }

    public void exitAndThrowIfTimedOut()
      throws IOException
    {
      if (exit())
        throw newTimeoutException(null);
    }

    protected IOException newTimeoutException(IOException paramIOException)
    {
      SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
      if (paramIOException != null)
        localSocketTimeoutException.initCause(paramIOException);
      return localSocketTimeoutException;
    }

    protected void timedOut()
    {
      Http2Stream.this.closeLater(ErrorCode.CANCEL);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Stream
 * JD-Core Version:    0.6.0
 */
package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class Http2Connection
  implements Closeable
{
  private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
  static final ExecutorService executor;
  long bytesLeftInWriteWindow;
  final boolean client;
  final Set<Integer> currentPushRequests = new LinkedHashSet();
  final String hostname;
  int lastGoodStreamId;
  final Listener listener;
  private int nextPingId;
  int nextStreamId;
  Settings okHttpSettings = new Settings();
  final Settings peerSettings = new Settings();
  private Map<Integer, Ping> pings;
  private final ExecutorService pushExecutor;
  final PushObserver pushObserver;
  final ReaderRunnable readerRunnable;
  boolean receivedInitialPeerSettings = false;
  boolean shutdown;
  final Socket socket;
  final Map<Integer, Http2Stream> streams = new LinkedHashMap();
  long unacknowledgedBytesRead = 0L;
  final Http2Writer writer;

  static
  {
    if (!Http2Connection.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      executor = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
      return;
    }
  }

  Http2Connection(Builder paramBuilder)
  {
    this.pushObserver = paramBuilder.pushObserver;
    this.client = paramBuilder.client;
    this.listener = paramBuilder.listener;
    if (paramBuilder.client);
    for (int i = 1; ; i = 2)
    {
      this.nextStreamId = i;
      if (paramBuilder.client)
        this.nextStreamId += 2;
      i = j;
      if (paramBuilder.client)
        i = 1;
      this.nextPingId = i;
      if (paramBuilder.client)
        this.okHttpSettings.set(7, 16777216);
      this.hostname = paramBuilder.hostname;
      this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", new Object[] { this.hostname }), true));
      this.peerSettings.set(7, 65535);
      this.peerSettings.set(5, 16384);
      this.bytesLeftInWriteWindow = this.peerSettings.getInitialWindowSize();
      this.socket = paramBuilder.socket;
      this.writer = new Http2Writer(paramBuilder.sink, this.client);
      this.readerRunnable = new ReaderRunnable(new Http2Reader(paramBuilder.source, this.client));
      return;
    }
  }

  private Http2Stream newStream(int paramInt, List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
      synchronized (this.writer)
      {
        monitorenter;
        try
        {
          if (!this.shutdown)
            break;
          throw new ConnectionShutdownException();
        }
        finally
        {
          monitorexit;
        }
      }
    int j = this.nextStreamId;
    this.nextStreamId += 2;
    Http2Stream localHttp2Stream = new Http2Stream(j, this, bool, false, paramList);
    if ((paramBoolean) && (this.bytesLeftInWriteWindow != 0L))
      if (localHttp2Stream.bytesLeftInWriteWindow == 0L)
        break label207;
    while (true)
    {
      if (localHttp2Stream.isOpen())
        this.streams.put(Integer.valueOf(j), localHttp2Stream);
      monitorexit;
      if (paramInt == 0)
        this.writer.synStream(bool, j, paramInt, paramList);
      while (true)
      {
        monitorexit;
        if (i != 0)
          this.writer.flush();
        return localHttp2Stream;
        i = 0;
        break;
        if (this.client)
          throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
        this.writer.pushPromise(paramInt, j, paramList);
      }
      label207: int i = 1;
    }
  }

  void addBytesToWriteWindow(long paramLong)
  {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L)
      notifyAll();
  }

  public void close()
    throws IOException
  {
    close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
  }

  // ERROR //
  void close(ErrorCode paramErrorCode1, ErrorCode paramErrorCode2)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 87	okhttp3/internal/http2/Http2Connection:$assertionsDisabled	Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: invokestatic 281	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +11 -> 21
    //   13: new 283	java/lang/AssertionError
    //   16: dup
    //   17: invokespecial 284	java/lang/AssertionError:<init>	()V
    //   20: athrow
    //   21: aconst_null
    //   22: astore 5
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 287	okhttp3/internal/http2/Http2Connection:shutdown	(Lokhttp3/internal/http2/ErrorCode;)V
    //   29: aload 5
    //   31: astore_1
    //   32: aconst_null
    //   33: astore 6
    //   35: aconst_null
    //   36: astore 7
    //   38: aload_0
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 124	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   44: invokeinterface 290 1 0
    //   49: ifne +43 -> 92
    //   52: aload_0
    //   53: getfield 124	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   56: invokeinterface 294 1 0
    //   61: aload_0
    //   62: getfield 124	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   65: invokeinterface 297 1 0
    //   70: anewarray 217	okhttp3/internal/http2/Http2Stream
    //   73: invokeinterface 303 2 0
    //   78: checkcast 305	[Lokhttp3/internal/http2/Http2Stream;
    //   81: astore 6
    //   83: aload_0
    //   84: getfield 124	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   87: invokeinterface 308 1 0
    //   92: aload_0
    //   93: getfield 310	okhttp3/internal/http2/Http2Connection:pings	Ljava/util/Map;
    //   96: ifnull +39 -> 135
    //   99: aload_0
    //   100: getfield 310	okhttp3/internal/http2/Http2Connection:pings	Ljava/util/Map;
    //   103: invokeinterface 294 1 0
    //   108: aload_0
    //   109: getfield 310	okhttp3/internal/http2/Http2Connection:pings	Ljava/util/Map;
    //   112: invokeinterface 297 1 0
    //   117: anewarray 312	okhttp3/internal/http2/Ping
    //   120: invokeinterface 303 2 0
    //   125: checkcast 314	[Lokhttp3/internal/http2/Ping;
    //   128: astore 7
    //   130: aload_0
    //   131: aconst_null
    //   132: putfield 310	okhttp3/internal/http2/Http2Connection:pings	Ljava/util/Map;
    //   135: aload_0
    //   136: monitorexit
    //   137: aload_1
    //   138: astore 5
    //   140: aload 6
    //   142: ifnull +69 -> 211
    //   145: aload 6
    //   147: arraylength
    //   148: istore 4
    //   150: iconst_0
    //   151: istore_3
    //   152: aload_1
    //   153: astore 5
    //   155: iload_3
    //   156: iload 4
    //   158: if_icmpge +53 -> 211
    //   161: aload 6
    //   163: iload_3
    //   164: aaload
    //   165: astore 5
    //   167: aload 5
    //   169: aload_2
    //   170: invokevirtual 316	okhttp3/internal/http2/Http2Stream:close	(Lokhttp3/internal/http2/ErrorCode;)V
    //   173: aload_1
    //   174: astore 5
    //   176: iload_3
    //   177: iconst_1
    //   178: iadd
    //   179: istore_3
    //   180: aload 5
    //   182: astore_1
    //   183: goto -31 -> 152
    //   186: astore_1
    //   187: goto -155 -> 32
    //   190: astore_1
    //   191: aload_0
    //   192: monitorexit
    //   193: aload_1
    //   194: athrow
    //   195: astore 8
    //   197: aload_1
    //   198: astore 5
    //   200: aload_1
    //   201: ifnull -25 -> 176
    //   204: aload 8
    //   206: astore 5
    //   208: goto -32 -> 176
    //   211: aload 7
    //   213: ifnull +30 -> 243
    //   216: aload 7
    //   218: arraylength
    //   219: istore 4
    //   221: iconst_0
    //   222: istore_3
    //   223: iload_3
    //   224: iload 4
    //   226: if_icmpge +17 -> 243
    //   229: aload 7
    //   231: iload_3
    //   232: aaload
    //   233: invokevirtual 319	okhttp3/internal/http2/Ping:cancel	()V
    //   236: iload_3
    //   237: iconst_1
    //   238: iadd
    //   239: istore_3
    //   240: goto -17 -> 223
    //   243: aload_0
    //   244: getfield 192	okhttp3/internal/http2/Http2Connection:writer	Lokhttp3/internal/http2/Http2Writer;
    //   247: invokevirtual 321	okhttp3/internal/http2/Http2Writer:close	()V
    //   250: aload 5
    //   252: astore_1
    //   253: aload_0
    //   254: getfield 181	okhttp3/internal/http2/Http2Connection:socket	Ljava/net/Socket;
    //   257: invokevirtual 324	java/net/Socket:close	()V
    //   260: aload_1
    //   261: ifnull +23 -> 284
    //   264: aload_1
    //   265: athrow
    //   266: astore_2
    //   267: aload 5
    //   269: astore_1
    //   270: aload 5
    //   272: ifnonnull -19 -> 253
    //   275: aload_2
    //   276: astore_1
    //   277: goto -24 -> 253
    //   280: astore_1
    //   281: goto -21 -> 260
    //   284: return
    //
    // Exception table:
    //   from	to	target	type
    //   24	29	186	java/io/IOException
    //   40	92	190	finally
    //   92	135	190	finally
    //   135	137	190	finally
    //   191	193	190	finally
    //   167	173	195	java/io/IOException
    //   243	250	266	java/io/IOException
    //   253	260	280	java/io/IOException
  }

  public void flush()
    throws IOException
  {
    this.writer.flush();
  }

  public Protocol getProtocol()
  {
    return Protocol.HTTP_2;
  }

  Http2Stream getStream(int paramInt)
  {
    monitorenter;
    try
    {
      Http2Stream localHttp2Stream = (Http2Stream)this.streams.get(Integer.valueOf(paramInt));
      monitorexit;
      return localHttp2Stream;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean isShutdown()
  {
    monitorenter;
    try
    {
      boolean bool = this.shutdown;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int maxConcurrentStreams()
  {
    monitorenter;
    try
    {
      int i = this.peerSettings.getMaxConcurrentStreams(2147483647);
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public Http2Stream newStream(List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    return newStream(0, paramList, paramBoolean);
  }

  public int openStreamCount()
  {
    monitorenter;
    try
    {
      int i = this.streams.size();
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public Ping ping()
    throws IOException
  {
    Ping localPing = new Ping();
    monitorenter;
    try
    {
      if (this.shutdown)
        throw new ConnectionShutdownException();
    }
    finally
    {
      monitorexit;
    }
    int i = this.nextPingId;
    this.nextPingId += 2;
    if (this.pings == null)
      this.pings = new LinkedHashMap();
    this.pings.put(Integer.valueOf(i), localObject);
    monitorexit;
    writePing(false, i, 1330343787, localObject);
    return localObject;
  }

  void pushDataLater(int paramInt1, BufferedSource paramBufferedSource, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    Buffer localBuffer = new Buffer();
    paramBufferedSource.require(paramInt2);
    paramBufferedSource.read(localBuffer, paramInt2);
    if (localBuffer.size() != paramInt2)
      throw new IOException(localBuffer.size() + " != " + paramInt2);
    this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[] { this.hostname, Integer.valueOf(paramInt1) }, paramInt1, localBuffer, paramInt2, paramBoolean)
    {
      public void execute()
      {
        try
        {
          boolean bool = Http2Connection.this.pushObserver.onData(this.val$streamId, this.val$buffer, this.val$byteCount, this.val$inFinished);
          if (bool)
            Http2Connection.this.writer.rstStream(this.val$streamId, ErrorCode.CANCEL);
          if ((bool) || (this.val$inFinished))
            synchronized (Http2Connection.this)
            {
              Http2Connection.this.currentPushRequests.remove(Integer.valueOf(this.val$streamId));
              return;
            }
        }
        catch (IOException localIOException)
        {
        }
      }
    });
  }

  void pushHeadersLater(int paramInt, List<Header> paramList, boolean paramBoolean)
  {
    this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[] { this.hostname, Integer.valueOf(paramInt) }, paramInt, paramList, paramBoolean)
    {
      public void execute()
      {
        boolean bool = Http2Connection.this.pushObserver.onHeaders(this.val$streamId, this.val$requestHeaders, this.val$inFinished);
        if (bool);
        try
        {
          Http2Connection.this.writer.rstStream(this.val$streamId, ErrorCode.CANCEL);
          if ((bool) || (this.val$inFinished))
            synchronized (Http2Connection.this)
            {
              Http2Connection.this.currentPushRequests.remove(Integer.valueOf(this.val$streamId));
              return;
            }
        }
        catch (IOException localIOException)
        {
        }
      }
    });
  }

  void pushRequestLater(int paramInt, List<Header> paramList)
  {
    monitorenter;
    try
    {
      if (this.currentPushRequests.contains(Integer.valueOf(paramInt)))
      {
        writeSynResetLater(paramInt, ErrorCode.PROTOCOL_ERROR);
        return;
      }
      this.currentPushRequests.add(Integer.valueOf(paramInt));
      monitorexit;
      this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[] { this.hostname, Integer.valueOf(paramInt) }, paramInt, paramList)
      {
        public void execute()
        {
          if (Http2Connection.this.pushObserver.onRequest(this.val$streamId, this.val$requestHeaders))
            try
            {
              Http2Connection.this.writer.rstStream(this.val$streamId, ErrorCode.CANCEL);
              synchronized (Http2Connection.this)
              {
                Http2Connection.this.currentPushRequests.remove(Integer.valueOf(this.val$streamId));
                return;
              }
            }
            catch (IOException localIOException)
            {
            }
        }
      });
      return;
    }
    finally
    {
      monitorexit;
    }
    throw paramList;
  }

  void pushResetLater(int paramInt, ErrorCode paramErrorCode)
  {
    this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[] { this.hostname, Integer.valueOf(paramInt) }, paramInt, paramErrorCode)
    {
      public void execute()
      {
        Http2Connection.this.pushObserver.onReset(this.val$streamId, this.val$errorCode);
        synchronized (Http2Connection.this)
        {
          Http2Connection.this.currentPushRequests.remove(Integer.valueOf(this.val$streamId));
          return;
        }
      }
    });
  }

  public Http2Stream pushStream(int paramInt, List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    if (this.client)
      throw new IllegalStateException("Client cannot push requests.");
    return newStream(paramInt, paramList, paramBoolean);
  }

  boolean pushedStream(int paramInt)
  {
    return (paramInt != 0) && ((paramInt & 0x1) == 0);
  }

  Ping removePing(int paramInt)
  {
    monitorenter;
    try
    {
      if (this.pings != null)
      {
        localPing = (Ping)this.pings.remove(Integer.valueOf(paramInt));
        return localPing;
      }
      Ping localPing = null;
    }
    finally
    {
      monitorexit;
    }
  }

  Http2Stream removeStream(int paramInt)
  {
    monitorenter;
    try
    {
      Http2Stream localHttp2Stream = (Http2Stream)this.streams.remove(Integer.valueOf(paramInt));
      notifyAll();
      monitorexit;
      return localHttp2Stream;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void setSettings(Settings paramSettings)
    throws IOException
  {
    synchronized (this.writer)
    {
      monitorenter;
      try
      {
        if (this.shutdown)
          throw new ConnectionShutdownException();
      }
      finally
      {
        monitorexit;
      }
    }
    this.okHttpSettings.merge(paramSettings);
    this.writer.settings(paramSettings);
    monitorexit;
    monitorexit;
  }

  public void shutdown(ErrorCode paramErrorCode)
    throws IOException
  {
    synchronized (this.writer)
    {
      monitorenter;
    }
    try
    {
      if (this.shutdown)
      {
        monitorexit;
        return;
      }
      this.shutdown = true;
      int i = this.lastGoodStreamId;
      monitorexit;
      this.writer.goAway(i, paramErrorCode, Util.EMPTY_BYTE_ARRAY);
      return;
      paramErrorCode = finally;
      throw paramErrorCode;
    }
    finally
    {
      monitorexit;
    }
    throw paramErrorCode;
  }

  public void start()
    throws IOException
  {
    start(true);
  }

  void start(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
    {
      this.writer.connectionPreface();
      this.writer.settings(this.okHttpSettings);
      int i = this.okHttpSettings.getInitialWindowSize();
      if (i != 65535)
        this.writer.windowUpdate(0, i - 65535);
    }
    new Thread(this.readerRunnable).start();
  }

  public void writeData(int paramInt, boolean paramBoolean, Buffer paramBuffer, long paramLong)
    throws IOException
  {
    long l = paramLong;
    if (paramLong == 0L)
    {
      this.writer.data(paramBoolean, paramInt, paramBuffer, 0);
      return;
    }
    while (true)
    {
      try
      {
        int i = Math.min((int)Math.min(l, this.bytesLeftInWriteWindow), this.writer.maxDataLength());
        this.bytesLeftInWriteWindow -= i;
        monitorexit;
        l -= i;
        Http2Writer localHttp2Writer = this.writer;
        if ((!paramBoolean) || (l != 0L))
          break label164;
        bool = true;
        localHttp2Writer.data(bool, paramInt, paramBuffer, i);
        if (l <= 0L)
          break;
        monitorenter;
        try
        {
          if (this.bytesLeftInWriteWindow > 0L)
            continue;
          if (!this.streams.containsKey(Integer.valueOf(paramInt)))
            throw new IOException("stream closed");
        }
        catch (java.lang.InterruptedException paramBuffer)
        {
          throw new InterruptedIOException();
        }
      }
      finally
      {
        monitorexit;
      }
      wait();
      continue;
      label164: boolean bool = false;
    }
  }

  void writePing(boolean paramBoolean, int paramInt1, int paramInt2, Ping paramPing)
    throws IOException
  {
    Http2Writer localHttp2Writer = this.writer;
    monitorenter;
    if (paramPing != null);
    try
    {
      paramPing.send();
      this.writer.ping(paramBoolean, paramInt1, paramInt2);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw paramPing;
  }

  void writePingLater(boolean paramBoolean, int paramInt1, int paramInt2, Ping paramPing)
  {
    executor.execute(new NamedRunnable("OkHttp %s ping %08x%08x", new Object[] { this.hostname, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, paramBoolean, paramInt1, paramInt2, paramPing)
    {
      public void execute()
      {
        try
        {
          Http2Connection.this.writePing(this.val$reply, this.val$payload1, this.val$payload2, this.val$ping);
          return;
        }
        catch (IOException localIOException)
        {
        }
      }
    });
  }

  void writeSynReply(int paramInt, boolean paramBoolean, List<Header> paramList)
    throws IOException
  {
    this.writer.synReply(paramBoolean, paramInt, paramList);
  }

  void writeSynReset(int paramInt, ErrorCode paramErrorCode)
    throws IOException
  {
    this.writer.rstStream(paramInt, paramErrorCode);
  }

  void writeSynResetLater(int paramInt, ErrorCode paramErrorCode)
  {
    executor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[] { this.hostname, Integer.valueOf(paramInt) }, paramInt, paramErrorCode)
    {
      public void execute()
      {
        try
        {
          Http2Connection.this.writeSynReset(this.val$streamId, this.val$errorCode);
          return;
        }
        catch (IOException localIOException)
        {
        }
      }
    });
  }

  void writeWindowUpdateLater(int paramInt, long paramLong)
  {
    executor.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[] { this.hostname, Integer.valueOf(paramInt) }, paramInt, paramLong)
    {
      public void execute()
      {
        try
        {
          Http2Connection.this.writer.windowUpdate(this.val$streamId, this.val$unacknowledgedBytesRead);
          return;
        }
        catch (IOException localIOException)
        {
        }
      }
    });
  }

  public static class Builder
  {
    boolean client;
    String hostname;
    Http2Connection.Listener listener = Http2Connection.Listener.REFUSE_INCOMING_STREAMS;
    PushObserver pushObserver = PushObserver.CANCEL;
    BufferedSink sink;
    Socket socket;
    BufferedSource source;

    public Builder(boolean paramBoolean)
    {
      this.client = paramBoolean;
    }

    public Http2Connection build()
      throws IOException
    {
      return new Http2Connection(this);
    }

    public Builder listener(Http2Connection.Listener paramListener)
    {
      this.listener = paramListener;
      return this;
    }

    public Builder pushObserver(PushObserver paramPushObserver)
    {
      this.pushObserver = paramPushObserver;
      return this;
    }

    public Builder socket(Socket paramSocket)
      throws IOException
    {
      return socket(paramSocket, ((InetSocketAddress)paramSocket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(paramSocket)), Okio.buffer(Okio.sink(paramSocket)));
    }

    public Builder socket(Socket paramSocket, String paramString, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
    {
      this.socket = paramSocket;
      this.hostname = paramString;
      this.source = paramBufferedSource;
      this.sink = paramBufferedSink;
      return this;
    }
  }

  public static abstract class Listener
  {
    public static final Listener REFUSE_INCOMING_STREAMS = new Listener()
    {
      public void onStream(Http2Stream paramHttp2Stream)
        throws IOException
      {
        paramHttp2Stream.close(ErrorCode.REFUSED_STREAM);
      }
    };

    public void onSettings(Http2Connection paramHttp2Connection)
    {
    }

    public abstract void onStream(Http2Stream paramHttp2Stream)
      throws IOException;
  }

  class ReaderRunnable extends NamedRunnable
    implements Http2Reader.Handler
  {
    final Http2Reader reader;

    ReaderRunnable(Http2Reader arg2)
    {
      super(new Object[] { Http2Connection.this.hostname });
      Object localObject;
      this.reader = localObject;
    }

    private void applyAndAckSettings(Settings paramSettings)
    {
      Http2Connection.executor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[] { Http2Connection.this.hostname }, paramSettings)
      {
        public void execute()
        {
          try
          {
            Http2Connection.this.writer.applyAndAckSettings(this.val$peerSettings);
            return;
          }
          catch (IOException localIOException)
          {
          }
        }
      });
    }

    public void ackSettings()
    {
    }

    public void alternateService(int paramInt1, String paramString1, ByteString paramByteString, String paramString2, int paramInt2, long paramLong)
    {
    }

    public void data(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
      throws IOException
    {
      if (Http2Connection.this.pushedStream(paramInt1))
        Http2Connection.this.pushDataLater(paramInt1, paramBufferedSource, paramInt2, paramBoolean);
      Http2Stream localHttp2Stream;
      do
      {
        return;
        localHttp2Stream = Http2Connection.this.getStream(paramInt1);
        if (localHttp2Stream == null)
        {
          Http2Connection.this.writeSynResetLater(paramInt1, ErrorCode.PROTOCOL_ERROR);
          paramBufferedSource.skip(paramInt2);
          return;
        }
        localHttp2Stream.receiveData(paramBufferedSource, paramInt2);
      }
      while (!paramBoolean);
      localHttp2Stream.receiveFin();
    }

    // ERROR //
    protected void execute()
    {
      // Byte code:
      //   0: getstatic 103	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   3: astore_3
      //   4: getstatic 103	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   7: astore 4
      //   9: aload_3
      //   10: astore_2
      //   11: aload_3
      //   12: astore_1
      //   13: aload_0
      //   14: getfield 36	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   17: aload_0
      //   18: invokevirtual 109	okhttp3/internal/http2/Http2Reader:readConnectionPreface	(Lokhttp3/internal/http2/Http2Reader$Handler;)V
      //   21: aload_3
      //   22: astore_2
      //   23: aload_3
      //   24: astore_1
      //   25: aload_0
      //   26: getfield 36	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   29: iconst_0
      //   30: aload_0
      //   31: invokevirtual 113	okhttp3/internal/http2/Http2Reader:nextFrame	(ZLokhttp3/internal/http2/Http2Reader$Handler;)Z
      //   34: ifne -13 -> 21
      //   37: aload_3
      //   38: astore_2
      //   39: aload_3
      //   40: astore_1
      //   41: getstatic 116	okhttp3/internal/http2/ErrorCode:NO_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   44: astore_3
      //   45: aload_3
      //   46: astore_2
      //   47: aload_3
      //   48: astore_1
      //   49: getstatic 119	okhttp3/internal/http2/ErrorCode:CANCEL	Lokhttp3/internal/http2/ErrorCode;
      //   52: astore 5
      //   54: aload_0
      //   55: getfield 23	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   58: aload_3
      //   59: aload 5
      //   61: invokevirtual 123	okhttp3/internal/http2/Http2Connection:close	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
      //   64: aload_0
      //   65: getfield 36	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   68: invokestatic 129	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   71: return
      //   72: astore_1
      //   73: aload_2
      //   74: astore_1
      //   75: getstatic 80	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   78: astore_2
      //   79: aload_2
      //   80: astore_1
      //   81: getstatic 80	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   84: astore_3
      //   85: aload_0
      //   86: getfield 23	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   89: aload_2
      //   90: aload_3
      //   91: invokevirtual 123	okhttp3/internal/http2/Http2Connection:close	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
      //   94: aload_0
      //   95: getfield 36	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   98: invokestatic 129	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   101: return
      //   102: astore_2
      //   103: aload_0
      //   104: getfield 23	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   107: aload_1
      //   108: aload 4
      //   110: invokevirtual 123	okhttp3/internal/http2/Http2Connection:close	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
      //   113: aload_0
      //   114: getfield 36	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   117: invokestatic 129	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   120: aload_2
      //   121: athrow
      //   122: astore_1
      //   123: goto -10 -> 113
      //   126: astore_1
      //   127: goto -33 -> 94
      //   130: astore_1
      //   131: goto -67 -> 64
      //
      // Exception table:
      //   from	to	target	type
      //   13	21	72	java/io/IOException
      //   25	37	72	java/io/IOException
      //   41	45	72	java/io/IOException
      //   49	54	72	java/io/IOException
      //   13	21	102	finally
      //   25	37	102	finally
      //   41	45	102	finally
      //   49	54	102	finally
      //   75	79	102	finally
      //   81	85	102	finally
      //   103	113	122	java/io/IOException
      //   85	94	126	java/io/IOException
      //   54	64	130	java/io/IOException
    }

    public void goAway(int paramInt, ErrorCode arg2, ByteString paramByteString)
    {
      if (paramByteString.size() > 0);
      synchronized (Http2Connection.this)
      {
        paramByteString = (Http2Stream[])Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
        Http2Connection.this.shutdown = true;
        int j = paramByteString.length;
        int i = 0;
        if (i < j)
        {
          ??? = paramByteString[i];
          if ((???.getId() > paramInt) && (???.isLocallyInitiated()))
          {
            ???.receiveRstStream(ErrorCode.REFUSED_STREAM);
            Http2Connection.this.removeStream(???.getId());
          }
          i += 1;
        }
      }
    }

    public void headers(boolean paramBoolean, int paramInt1, int paramInt2, List<Header> paramList)
    {
      if (Http2Connection.this.pushedStream(paramInt1))
        Http2Connection.this.pushHeadersLater(paramInt1, paramList, paramBoolean);
      Http2Stream localHttp2Stream;
      do
      {
        return;
        synchronized (Http2Connection.this)
        {
          if (Http2Connection.this.shutdown)
            return;
        }
        localHttp2Stream = Http2Connection.this.getStream(paramInt1);
        if (localHttp2Stream == null)
        {
          if (paramInt1 <= Http2Connection.this.lastGoodStreamId)
          {
            monitorexit;
            return;
          }
          if (paramInt1 % 2 == Http2Connection.this.nextStreamId % 2)
          {
            monitorexit;
            return;
          }
          paramList = new Http2Stream(paramInt1, Http2Connection.this, false, paramBoolean, paramList);
          Http2Connection.this.lastGoodStreamId = paramInt1;
          Http2Connection.this.streams.put(Integer.valueOf(paramInt1), paramList);
          Http2Connection.executor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[] { Http2Connection.this.hostname, Integer.valueOf(paramInt1) }, paramList)
          {
            public void execute()
            {
              try
              {
                Http2Connection.this.listener.onStream(this.val$newStream);
                return;
              }
              catch (IOException localIOException2)
              {
                Platform.get().log(4, "Http2Connection.Listener failure for " + Http2Connection.this.hostname, localIOException1);
                try
                {
                  this.val$newStream.close(ErrorCode.PROTOCOL_ERROR);
                  return;
                }
                catch (IOException localIOException2)
                {
                }
              }
            }
          });
          monitorexit;
          return;
        }
        monitorexit;
        localHttp2Stream.receiveHeaders(paramList);
      }
      while (!paramBoolean);
      localHttp2Stream.receiveFin();
    }

    public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      if (paramBoolean)
      {
        Ping localPing = Http2Connection.this.removePing(paramInt1);
        if (localPing != null)
          localPing.receive();
        return;
      }
      Http2Connection.this.writePingLater(true, paramInt1, paramInt2, null);
    }

    public void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
    }

    public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
    {
      Http2Connection.this.pushRequestLater(paramInt2, paramList);
    }

    public void rstStream(int paramInt, ErrorCode paramErrorCode)
    {
      if (Http2Connection.this.pushedStream(paramInt))
        Http2Connection.this.pushResetLater(paramInt, paramErrorCode);
      Http2Stream localHttp2Stream;
      do
      {
        return;
        localHttp2Stream = Http2Connection.this.removeStream(paramInt);
      }
      while (localHttp2Stream == null);
      localHttp2Stream.receiveRstStream(paramErrorCode);
    }

    public void settings(boolean paramBoolean, Settings paramSettings)
    {
      long l2 = 0L;
      ??? = null;
      while (true)
      {
        int i;
        long l1;
        synchronized (Http2Connection.this)
        {
          i = Http2Connection.this.peerSettings.getInitialWindowSize();
          if (!paramBoolean)
            continue;
          Http2Connection.this.peerSettings.clear();
          Http2Connection.this.peerSettings.merge(paramSettings);
          applyAndAckSettings(paramSettings);
          int j = Http2Connection.this.peerSettings.getInitialWindowSize();
          l1 = l2;
          paramSettings = ???;
          if (j == -1)
            continue;
          l1 = l2;
          paramSettings = ???;
          if (j == i)
            continue;
          l2 = j - i;
          if (Http2Connection.this.receivedInitialPeerSettings)
            continue;
          Http2Connection.this.addBytesToWriteWindow(l2);
          Http2Connection.this.receivedInitialPeerSettings = true;
          l1 = l2;
          paramSettings = ???;
          if (Http2Connection.this.streams.isEmpty())
            continue;
          paramSettings = (Http2Stream[])Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
          l1 = l2;
          Http2Connection.executor.execute(new NamedRunnable("OkHttp %s settings", new Object[] { Http2Connection.this.hostname })
          {
            public void execute()
            {
              Http2Connection.this.listener.onSettings(Http2Connection.this);
            }
          });
          if ((paramSettings == null) || (l1 == 0L))
            break;
          j = paramSettings.length;
          i = 0;
          if (i >= j)
            break;
        }
        synchronized (paramSettings[i])
        {
          ???.addBytesToWriteWindow(l1);
          i += 1;
          continue;
          paramSettings = finally;
          monitorexit;
          throw paramSettings;
        }
      }
    }

    public void windowUpdate(int paramInt, long paramLong)
    {
      if (paramInt == 0)
        synchronized (Http2Connection.this)
        {
          Http2Connection localHttp2Connection = Http2Connection.this;
          localHttp2Connection.bytesLeftInWriteWindow += paramLong;
          Http2Connection.this.notifyAll();
          return;
        }
      ??? = Http2Connection.this.getStream(paramInt);
      if (??? != null)
      {
        monitorenter;
        try
        {
          ((Http2Stream)???).addBytesToWriteWindow(paramLong);
          return;
        }
        finally
        {
          monitorexit;
        }
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.http2.Http2Connection
 * JD-Core Version:    0.6.0
 */
package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

public final class RealWebSocket
  implements WebSocket, WebSocketReader.FrameCallback
{
  private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000L;
  private static final long MAX_QUEUE_SIZE = 16777216L;
  private static final List<Protocol> ONLY_HTTP1;
  private Call call;
  private ScheduledFuture<?> cancelFuture;
  private boolean enqueuedClose;
  private ScheduledExecutorService executor;
  private boolean failed;
  private final String key;
  final WebSocketListener listener;
  private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque();
  private final Request originalRequest;
  int pingCount;
  int pongCount;
  private final ArrayDeque<ByteString> pongQueue = new ArrayDeque();
  private long queueSize;
  private final Random random;
  private WebSocketReader reader;
  private int receivedCloseCode = -1;
  private String receivedCloseReason;
  private Streams streams;
  private WebSocketWriter writer;
  private final Runnable writerRunnable;

  static
  {
    if (!RealWebSocket.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
      return;
    }
  }

  public RealWebSocket(Request paramRequest, WebSocketListener paramWebSocketListener, Random paramRandom)
  {
    if (!"GET".equals(paramRequest.method()))
      throw new IllegalArgumentException("Request must be GET: " + paramRequest.method());
    this.originalRequest = paramRequest;
    this.listener = paramWebSocketListener;
    this.random = paramRandom;
    paramRequest = new byte[16];
    paramRandom.nextBytes(paramRequest);
    this.key = ByteString.of(paramRequest).base64();
    this.writerRunnable = new Runnable()
    {
      public void run()
      {
        try
        {
          boolean bool;
          do
            bool = RealWebSocket.this.writeOneFrame();
          while (bool);
          return;
        }
        catch (IOException localIOException)
        {
          RealWebSocket.this.failWebSocket(localIOException, null);
        }
      }
    };
  }

  private void runWriter()
  {
    assert (Thread.holdsLock(this));
    if (this.executor != null)
      this.executor.execute(this.writerRunnable);
  }

  private boolean send(ByteString paramByteString, int paramInt)
  {
    boolean bool2 = false;
    monitorenter;
    for (boolean bool1 = bool2; ; bool1 = true)
    {
      try
      {
        if (!this.failed)
        {
          bool1 = this.enqueuedClose;
          if (!bool1)
            break label31;
        }
        for (bool1 = bool2; ; bool1 = bool2)
        {
          return bool1;
          label31: if (this.queueSize + paramByteString.size() <= 16777216L)
            break;
          close(1001, null);
        }
      }
      finally
      {
        monitorexit;
      }
      this.queueSize += paramByteString.size();
      this.messageAndCloseQueue.add(new Message(paramInt, paramByteString));
      runWriter();
    }
  }

  void awaitTermination(int paramInt, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    this.executor.awaitTermination(paramInt, paramTimeUnit);
  }

  public void cancel()
  {
    this.call.cancel();
  }

  void checkResponse(Response paramResponse)
    throws ProtocolException
  {
    if (paramResponse.code() != 101)
      throw new ProtocolException("Expected HTTP 101 response but was '" + paramResponse.code() + " " + paramResponse.message() + "'");
    String str = paramResponse.header("Connection");
    if (!"Upgrade".equalsIgnoreCase(str))
      throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + str + "'");
    str = paramResponse.header("Upgrade");
    if (!"websocket".equalsIgnoreCase(str))
      throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + str + "'");
    paramResponse = paramResponse.header("Sec-WebSocket-Accept");
    str = ByteString.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
    if (!str.equals(paramResponse))
      throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + str + "' but was '" + paramResponse + "'");
  }

  public boolean close(int paramInt, String paramString)
  {
    return close(paramInt, paramString, 60000L);
  }

  boolean close(int paramInt, String paramString, long paramLong)
  {
    int i = 1;
    monitorenter;
    Object localObject;
    try
    {
      WebSocketProtocol.validateCloseCode(paramInt);
      localObject = null;
      if (paramString != null)
      {
        ByteString localByteString = ByteString.encodeUtf8(paramString);
        localObject = localByteString;
        if (localByteString.size() > 123L)
          throw new IllegalArgumentException("reason.size() > 123: " + paramString);
      }
    }
    finally
    {
      monitorexit;
    }
    if (!this.failed)
    {
      boolean bool = this.enqueuedClose;
      if (!bool);
    }
    else
    {
      i = 0;
    }
    while (true)
    {
      monitorexit;
      return i;
      this.enqueuedClose = true;
      this.messageAndCloseQueue.add(new Close(paramInt, localObject, paramLong));
      runWriter();
    }
  }

  public void connect(OkHttpClient paramOkHttpClient)
  {
    paramOkHttpClient = paramOkHttpClient.newBuilder().protocols(ONLY_HTTP1).build();
    int i = paramOkHttpClient.pingIntervalMillis();
    Request localRequest = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
    this.call = Internal.instance.newWebSocketCall(paramOkHttpClient, localRequest);
    this.call.enqueue(new Callback(localRequest, i)
    {
      public void onFailure(Call paramCall, IOException paramIOException)
      {
        RealWebSocket.this.failWebSocket(paramIOException, null);
      }

      // ERROR //
      public void onResponse(Call paramCall, Response paramResponse)
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 21	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   4: aload_2
        //   5: invokevirtual 45	okhttp3/internal/ws/RealWebSocket:checkResponse	(Lokhttp3/Response;)V
        //   8: getstatic 51	okhttp3/internal/Internal:instance	Lokhttp3/internal/Internal;
        //   11: aload_1
        //   12: invokevirtual 55	okhttp3/internal/Internal:streamAllocation	(Lokhttp3/Call;)Lokhttp3/internal/connection/StreamAllocation;
        //   15: astore_1
        //   16: aload_1
        //   17: invokevirtual 60	okhttp3/internal/connection/StreamAllocation:noNewStreams	()V
        //   20: aload_1
        //   21: invokevirtual 64	okhttp3/internal/connection/StreamAllocation:connection	()Lokhttp3/internal/connection/RealConnection;
        //   24: aload_1
        //   25: invokevirtual 70	okhttp3/internal/connection/RealConnection:newWebSocketStreams	(Lokhttp3/internal/connection/StreamAllocation;)Lokhttp3/internal/ws/RealWebSocket$Streams;
        //   28: astore_3
        //   29: aload_0
        //   30: getfield 21	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   33: getfield 74	okhttp3/internal/ws/RealWebSocket:listener	Lokhttp3/WebSocketListener;
        //   36: aload_0
        //   37: getfield 21	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   40: aload_2
        //   41: invokevirtual 80	okhttp3/WebSocketListener:onOpen	(Lokhttp3/WebSocket;Lokhttp3/Response;)V
        //   44: new 82	java/lang/StringBuilder
        //   47: dup
        //   48: invokespecial 83	java/lang/StringBuilder:<init>	()V
        //   51: ldc 85
        //   53: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   56: aload_0
        //   57: getfield 23	okhttp3/internal/ws/RealWebSocket$2:val$request	Lokhttp3/Request;
        //   60: invokevirtual 95	okhttp3/Request:url	()Lokhttp3/HttpUrl;
        //   63: invokevirtual 101	okhttp3/HttpUrl:redact	()Ljava/lang/String;
        //   66: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   69: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   72: astore_2
        //   73: aload_0
        //   74: getfield 21	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   77: aload_2
        //   78: aload_0
        //   79: getfield 25	okhttp3/internal/ws/RealWebSocket$2:val$pingIntervalMillis	I
        //   82: i2l
        //   83: aload_3
        //   84: invokevirtual 108	okhttp3/internal/ws/RealWebSocket:initReaderAndWriter	(Ljava/lang/String;JLokhttp3/internal/ws/RealWebSocket$Streams;)V
        //   87: aload_1
        //   88: invokevirtual 64	okhttp3/internal/connection/StreamAllocation:connection	()Lokhttp3/internal/connection/RealConnection;
        //   91: invokevirtual 112	okhttp3/internal/connection/RealConnection:socket	()Ljava/net/Socket;
        //   94: iconst_0
        //   95: invokevirtual 118	java/net/Socket:setSoTimeout	(I)V
        //   98: aload_0
        //   99: getfield 21	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   102: invokevirtual 121	okhttp3/internal/ws/RealWebSocket:loopReader	()V
        //   105: return
        //   106: astore_1
        //   107: aload_0
        //   108: getfield 21	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   111: aload_1
        //   112: aload_2
        //   113: invokevirtual 35	okhttp3/internal/ws/RealWebSocket:failWebSocket	(Ljava/lang/Exception;Lokhttp3/Response;)V
        //   116: aload_2
        //   117: invokestatic 127	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
        //   120: return
        //   121: astore_1
        //   122: aload_0
        //   123: getfield 21	okhttp3/internal/ws/RealWebSocket$2:this$0	Lokhttp3/internal/ws/RealWebSocket;
        //   126: aload_1
        //   127: aconst_null
        //   128: invokevirtual 35	okhttp3/internal/ws/RealWebSocket:failWebSocket	(Ljava/lang/Exception;Lokhttp3/Response;)V
        //   131: return
        //
        // Exception table:
        //   from	to	target	type
        //   0	8	106	java/net/ProtocolException
        //   29	105	121	java/lang/Exception
      }
    });
  }

  // ERROR //
  public void failWebSocket(Exception paramException, Response paramResponse)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 193	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 193	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   17: aload_0
    //   18: getfield 359	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   21: astore_3
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield 359	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   27: aload_0
    //   28: getfield 361	okhttp3/internal/ws/RealWebSocket:cancelFuture	Ljava/util/concurrent/ScheduledFuture;
    //   31: ifnull +14 -> 45
    //   34: aload_0
    //   35: getfield 361	okhttp3/internal/ws/RealWebSocket:cancelFuture	Ljava/util/concurrent/ScheduledFuture;
    //   38: iconst_0
    //   39: invokeinterface 366 2 0
    //   44: pop
    //   45: aload_0
    //   46: getfield 183	okhttp3/internal/ws/RealWebSocket:executor	Ljava/util/concurrent/ScheduledExecutorService;
    //   49: ifnull +12 -> 61
    //   52: aload_0
    //   53: getfield 183	okhttp3/internal/ws/RealWebSocket:executor	Ljava/util/concurrent/ScheduledExecutorService;
    //   56: invokeinterface 369 1 0
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_0
    //   64: getfield 148	okhttp3/internal/ws/RealWebSocket:listener	Lokhttp3/WebSocketListener;
    //   67: aload_0
    //   68: aload_1
    //   69: aload_2
    //   70: invokevirtual 375	okhttp3/WebSocketListener:onFailure	(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V
    //   73: aload_3
    //   74: invokestatic 381	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    //   83: astore_1
    //   84: aload_3
    //   85: invokestatic 381	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   88: aload_1
    //   89: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	11	78	finally
    //   12	45	78	finally
    //   45	61	78	finally
    //   61	63	78	finally
    //   79	81	78	finally
    //   63	73	83	finally
  }

  public void initReaderAndWriter(String paramString, long paramLong, Streams paramStreams)
    throws IOException
  {
    monitorenter;
    try
    {
      this.streams = paramStreams;
      this.writer = new WebSocketWriter(paramStreams.client, paramStreams.sink, this.random);
      this.executor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(paramString, false));
      if (paramLong != 0L)
        this.executor.scheduleAtFixedRate(new PingRunnable(), paramLong, paramLong, TimeUnit.MILLISECONDS);
      if (!this.messageAndCloseQueue.isEmpty())
        runWriter();
      monitorexit;
      this.reader = new WebSocketReader(paramStreams.client, paramStreams.source, this);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw paramString;
  }

  public void loopReader()
    throws IOException
  {
    while (this.receivedCloseCode == -1)
      this.reader.processNextFrame();
  }

  public void onReadClose(int paramInt, String paramString)
  {
    if (paramInt == -1)
      throw new IllegalArgumentException();
    Object localObject2 = null;
    monitorenter;
    try
    {
      if (this.receivedCloseCode != -1)
        throw new IllegalStateException("already closed");
    }
    finally
    {
      monitorexit;
    }
    this.receivedCloseCode = paramInt;
    this.receivedCloseReason = paramString;
    Object localObject1 = localObject2;
    if (this.enqueuedClose)
    {
      localObject1 = localObject2;
      if (this.messageAndCloseQueue.isEmpty())
      {
        localObject1 = this.streams;
        this.streams = null;
        if (this.cancelFuture != null)
          this.cancelFuture.cancel(false);
        this.executor.shutdown();
      }
    }
    monitorexit;
    try
    {
      this.listener.onClosing(this, paramInt, paramString);
      if (localObject1 != null)
        this.listener.onClosed(this, paramInt, paramString);
      return;
    }
    finally
    {
      Util.closeQuietly((Closeable)localObject1);
    }
    throw paramString;
  }

  public void onReadMessage(String paramString)
    throws IOException
  {
    this.listener.onMessage(this, paramString);
  }

  public void onReadMessage(ByteString paramByteString)
    throws IOException
  {
    this.listener.onMessage(this, paramByteString);
  }

  public void onReadPing(ByteString paramByteString)
  {
    monitorenter;
    try
    {
      if (!this.failed)
      {
        if (!this.enqueuedClose)
          break label31;
        boolean bool = this.messageAndCloseQueue.isEmpty();
        if (!bool)
          break label31;
      }
      while (true)
      {
        return;
        label31: this.pongQueue.add(paramByteString);
        runWriter();
        this.pingCount += 1;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramByteString;
  }

  public void onReadPong(ByteString paramByteString)
  {
    monitorenter;
    try
    {
      this.pongCount += 1;
      monitorexit;
      return;
    }
    finally
    {
      paramByteString = finally;
      monitorexit;
    }
    throw paramByteString;
  }

  int pingCount()
  {
    monitorenter;
    try
    {
      int i = this.pingCount;
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

  boolean pong(ByteString paramByteString)
  {
    monitorenter;
    try
    {
      if (!this.failed)
      {
        if (!this.enqueuedClose)
          break label34;
        bool = this.messageAndCloseQueue.isEmpty();
        if (!bool)
          break label34;
      }
      for (boolean bool = false; ; bool = true)
      {
        return bool;
        label34: this.pongQueue.add(paramByteString);
        runWriter();
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramByteString;
  }

  int pongCount()
  {
    monitorenter;
    try
    {
      int i = this.pongCount;
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

  boolean processNextFrame()
    throws IOException
  {
    int j = 0;
    try
    {
      this.reader.processNextFrame();
      int i = this.receivedCloseCode;
      if (i == -1)
        j = 1;
      return j;
    }
    catch (Exception localException)
    {
      failWebSocket(localException, null);
    }
    return false;
  }

  public long queueSize()
  {
    monitorenter;
    try
    {
      long l = this.queueSize;
      monitorexit;
      return l;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public Request request()
  {
    return this.originalRequest;
  }

  public boolean send(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException("text == null");
    return send(ByteString.encodeUtf8(paramString), 1);
  }

  public boolean send(ByteString paramByteString)
  {
    if (paramByteString == null)
      throw new NullPointerException("bytes == null");
    return send(paramByteString, 2);
  }

  void tearDown()
    throws InterruptedException
  {
    if (this.cancelFuture != null)
      this.cancelFuture.cancel(false);
    this.executor.shutdown();
    this.executor.awaitTermination(10L, TimeUnit.SECONDS);
  }

  // ERROR //
  boolean writeOneFrame()
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_m1
    //   4: istore_2
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 6
    //   11: aload_0
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield 193	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   17: ifeq +7 -> 24
    //   20: aload_0
    //   21: monitorexit
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_0
    //   25: getfield 399	okhttp3/internal/ws/RealWebSocket:writer	Lokhttp3/internal/ws/WebSocketWriter;
    //   28: astore 9
    //   30: aload_0
    //   31: getfield 109	okhttp3/internal/ws/RealWebSocket:pongQueue	Ljava/util/ArrayDeque;
    //   34: invokevirtual 497	java/util/ArrayDeque:poll	()Ljava/lang/Object;
    //   37: checkcast 158	okio/ByteString
    //   40: astore 10
    //   42: iload_2
    //   43: istore_1
    //   44: aload 8
    //   46: astore 5
    //   48: aload 6
    //   50: astore_3
    //   51: aload 10
    //   53: ifnonnull +59 -> 112
    //   56: aload_0
    //   57: getfield 111	okhttp3/internal/ws/RealWebSocket:messageAndCloseQueue	Ljava/util/ArrayDeque;
    //   60: invokevirtual 497	java/util/ArrayDeque:poll	()Ljava/lang/Object;
    //   63: astore 7
    //   65: aload 7
    //   67: instanceof 17
    //   70: ifeq +109 -> 179
    //   73: aload_0
    //   74: getfield 113	okhttp3/internal/ws/RealWebSocket:receivedCloseCode	I
    //   77: istore_1
    //   78: aload_0
    //   79: getfield 447	okhttp3/internal/ws/RealWebSocket:receivedCloseReason	Ljava/lang/String;
    //   82: astore 5
    //   84: iload_1
    //   85: iconst_m1
    //   86: if_icmpeq +46 -> 132
    //   89: aload_0
    //   90: getfield 359	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   93: astore_3
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield 359	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   99: aload_0
    //   100: getfield 183	okhttp3/internal/ws/RealWebSocket:executor	Ljava/util/concurrent/ScheduledExecutorService;
    //   103: invokeinterface 369 1 0
    //   108: aload 7
    //   110: astore 4
    //   112: aload_0
    //   113: monitorexit
    //   114: aload 10
    //   116: ifnull +85 -> 201
    //   119: aload 9
    //   121: aload 10
    //   123: invokevirtual 500	okhttp3/internal/ws/WebSocketWriter:writePong	(Lokio/ByteString;)V
    //   126: aload_3
    //   127: invokestatic 381	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   130: iconst_1
    //   131: ireturn
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 183	okhttp3/internal/ws/RealWebSocket:executor	Ljava/util/concurrent/ScheduledExecutorService;
    //   137: new 14	okhttp3/internal/ws/RealWebSocket$CancelRunnable
    //   140: dup
    //   141: aload_0
    //   142: invokespecial 501	okhttp3/internal/ws/RealWebSocket$CancelRunnable:<init>	(Lokhttp3/internal/ws/RealWebSocket;)V
    //   145: aload 7
    //   147: checkcast 17	okhttp3/internal/ws/RealWebSocket$Close
    //   150: getfield 504	okhttp3/internal/ws/RealWebSocket$Close:cancelAfterCloseMillis	J
    //   153: getstatic 415	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   156: invokeinterface 508 5 0
    //   161: putfield 361	okhttp3/internal/ws/RealWebSocket:cancelFuture	Ljava/util/concurrent/ScheduledFuture;
    //   164: aload 7
    //   166: astore 4
    //   168: aload 6
    //   170: astore_3
    //   171: goto -59 -> 112
    //   174: astore_3
    //   175: aload_0
    //   176: monitorexit
    //   177: aload_3
    //   178: athrow
    //   179: aload 7
    //   181: astore 4
    //   183: iload_2
    //   184: istore_1
    //   185: aload 8
    //   187: astore 5
    //   189: aload 6
    //   191: astore_3
    //   192: aload 7
    //   194: ifnonnull -82 -> 112
    //   197: aload_0
    //   198: monitorexit
    //   199: iconst_0
    //   200: ireturn
    //   201: aload 4
    //   203: instanceof 20
    //   206: ifeq +92 -> 298
    //   209: aload 4
    //   211: checkcast 20	okhttp3/internal/ws/RealWebSocket$Message
    //   214: getfield 512	okhttp3/internal/ws/RealWebSocket$Message:data	Lokio/ByteString;
    //   217: astore 5
    //   219: aload 9
    //   221: aload 4
    //   223: checkcast 20	okhttp3/internal/ws/RealWebSocket$Message
    //   226: getfield 515	okhttp3/internal/ws/RealWebSocket$Message:formatOpcode	I
    //   229: aload 5
    //   231: invokevirtual 201	okio/ByteString:size	()I
    //   234: i2l
    //   235: invokevirtual 519	okhttp3/internal/ws/WebSocketWriter:newMessageSink	(IJ)Lokio/Sink;
    //   238: invokestatic 525	okio/Okio:buffer	(Lokio/Sink;)Lokio/BufferedSink;
    //   241: astore 4
    //   243: aload 4
    //   245: aload 5
    //   247: invokeinterface 531 2 0
    //   252: pop
    //   253: aload 4
    //   255: invokeinterface 533 1 0
    //   260: aload_0
    //   261: monitorenter
    //   262: aload_0
    //   263: aload_0
    //   264: getfield 197	okhttp3/internal/ws/RealWebSocket:queueSize	J
    //   267: aload 5
    //   269: invokevirtual 201	okio/ByteString:size	()I
    //   272: i2l
    //   273: lsub
    //   274: putfield 197	okhttp3/internal/ws/RealWebSocket:queueSize	J
    //   277: aload_0
    //   278: monitorexit
    //   279: goto -153 -> 126
    //   282: astore 4
    //   284: aload_0
    //   285: monitorexit
    //   286: aload 4
    //   288: athrow
    //   289: astore 4
    //   291: aload_3
    //   292: invokestatic 381	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   295: aload 4
    //   297: athrow
    //   298: aload 4
    //   300: instanceof 17
    //   303: ifeq +43 -> 346
    //   306: aload 4
    //   308: checkcast 17	okhttp3/internal/ws/RealWebSocket$Close
    //   311: astore 4
    //   313: aload 9
    //   315: aload 4
    //   317: getfield 535	okhttp3/internal/ws/RealWebSocket$Close:code	I
    //   320: aload 4
    //   322: getfield 538	okhttp3/internal/ws/RealWebSocket$Close:reason	Lokio/ByteString;
    //   325: invokevirtual 541	okhttp3/internal/ws/WebSocketWriter:writeClose	(ILokio/ByteString;)V
    //   328: aload_3
    //   329: ifnull -203 -> 126
    //   332: aload_0
    //   333: getfield 148	okhttp3/internal/ws/RealWebSocket:listener	Lokhttp3/WebSocketListener;
    //   336: aload_0
    //   337: iload_1
    //   338: aload 5
    //   340: invokevirtual 454	okhttp3/WebSocketListener:onClosed	(Lokhttp3/WebSocket;ILjava/lang/String;)V
    //   343: goto -217 -> 126
    //   346: new 180	java/lang/AssertionError
    //   349: dup
    //   350: invokespecial 181	java/lang/AssertionError:<init>	()V
    //   353: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   13	22	174	finally
    //   24	42	174	finally
    //   56	84	174	finally
    //   89	108	174	finally
    //   112	114	174	finally
    //   132	164	174	finally
    //   175	177	174	finally
    //   197	199	174	finally
    //   262	279	282	finally
    //   284	286	282	finally
    //   119	126	289	finally
    //   201	262	289	finally
    //   286	289	289	finally
    //   298	328	289	finally
    //   332	343	289	finally
    //   346	354	289	finally
  }

  void writePingFrame()
  {
    monitorenter;
    try
    {
      if (this.failed)
        return;
      WebSocketWriter localWebSocketWriter = this.writer;
      monitorexit;
      try
      {
        localWebSocketWriter.writePing(ByteString.EMPTY);
        return;
      }
      catch (IOException localIOException)
      {
        failWebSocket(localIOException, null);
        return;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  final class CancelRunnable
    implements Runnable
  {
    CancelRunnable()
    {
    }

    public void run()
    {
      RealWebSocket.this.cancel();
    }
  }

  static final class Close
  {
    final long cancelAfterCloseMillis;
    final int code;
    final ByteString reason;

    Close(int paramInt, ByteString paramByteString, long paramLong)
    {
      this.code = paramInt;
      this.reason = paramByteString;
      this.cancelAfterCloseMillis = paramLong;
    }
  }

  static final class Message
  {
    final ByteString data;
    final int formatOpcode;

    Message(int paramInt, ByteString paramByteString)
    {
      this.formatOpcode = paramInt;
      this.data = paramByteString;
    }
  }

  private final class PingRunnable
    implements Runnable
  {
    PingRunnable()
    {
    }

    public void run()
    {
      RealWebSocket.this.writePingFrame();
    }
  }

  public static abstract class Streams
    implements Closeable
  {
    public final boolean client;
    public final BufferedSink sink;
    public final BufferedSource source;

    public Streams(boolean paramBoolean, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
    {
      this.client = paramBoolean;
      this.source = paramBufferedSource;
      this.sink = paramBufferedSink;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.ws.RealWebSocket
 * JD-Core Version:    0.6.0
 */
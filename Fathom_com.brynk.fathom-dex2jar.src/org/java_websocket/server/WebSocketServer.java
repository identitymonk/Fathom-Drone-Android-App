package org.java_websocket.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketFactory;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.Handshakedata;

public abstract class WebSocketServer extends WebSocketAdapter
  implements Runnable
{
  public static int DECODERS = Runtime.getRuntime().availableProcessors();
  private final InetSocketAddress address;
  private BlockingQueue<ByteBuffer> buffers;
  private final Collection<WebSocket> connections;
  private List<WebSocketWorker> decoders;
  private List<Draft> drafts;
  private List<WebSocketImpl> iqueue;
  private volatile AtomicBoolean isclosed = new AtomicBoolean(false);
  private int queueinvokes = 0;
  private AtomicInteger queuesize = new AtomicInteger(0);
  private Selector selector;
  private Thread selectorthread;
  private ServerSocketChannel server;
  private WebSocketServerFactory wsf = new DefaultWebSocketServerFactory();

  public WebSocketServer()
    throws UnknownHostException
  {
    this(new InetSocketAddress(80), DECODERS, null);
  }

  public WebSocketServer(InetSocketAddress paramInetSocketAddress)
  {
    this(paramInetSocketAddress, DECODERS, null);
  }

  public WebSocketServer(InetSocketAddress paramInetSocketAddress, int paramInt)
  {
    this(paramInetSocketAddress, paramInt, null);
  }

  public WebSocketServer(InetSocketAddress paramInetSocketAddress, int paramInt, List<Draft> paramList)
  {
    this(paramInetSocketAddress, paramInt, paramList, new HashSet());
  }

  public WebSocketServer(InetSocketAddress paramInetSocketAddress, int paramInt, List<Draft> paramList, Collection<WebSocket> paramCollection)
  {
    if ((paramInetSocketAddress == null) || (paramInt < 1) || (paramCollection == null))
      throw new IllegalArgumentException("address and connectionscontainer must not be null and you need at least 1 decoder");
    if (paramList == null);
    for (this.drafts = Collections.emptyList(); ; this.drafts = paramList)
    {
      this.address = paramInetSocketAddress;
      this.connections = paramCollection;
      this.iqueue = new LinkedList();
      this.decoders = new ArrayList(paramInt);
      this.buffers = new LinkedBlockingQueue();
      int i = 0;
      while (i < paramInt)
      {
        paramInetSocketAddress = new WebSocketWorker();
        this.decoders.add(paramInetSocketAddress);
        paramInetSocketAddress.start();
        i += 1;
      }
    }
  }

  public WebSocketServer(InetSocketAddress paramInetSocketAddress, List<Draft> paramList)
  {
    this(paramInetSocketAddress, DECODERS, paramList);
  }

  private Socket getSocket(WebSocket paramWebSocket)
  {
    return ((SocketChannel)((WebSocketImpl)paramWebSocket).key.channel()).socket();
  }

  private void handleFatal(WebSocket paramWebSocket, Exception paramException)
  {
    onError(paramWebSocket, paramException);
    try
    {
      stop();
      return;
    }
    catch (IOException paramWebSocket)
    {
      onError(null, paramWebSocket);
      return;
    }
    catch (InterruptedException paramWebSocket)
    {
      Thread.currentThread().interrupt();
      onError(null, paramWebSocket);
    }
  }

  private void handleIOException(SelectionKey paramSelectionKey, WebSocket paramWebSocket, IOException paramIOException)
  {
    onWebsocketError(paramWebSocket, paramIOException);
    if (paramWebSocket != null)
      paramWebSocket.closeConnection(1006, paramIOException.getMessage());
    while (true)
    {
      return;
      if (paramSelectionKey == null)
        continue;
      paramSelectionKey = paramSelectionKey.channel();
      if ((paramSelectionKey == null) || (!paramSelectionKey.isOpen()))
        break;
      try
      {
        paramSelectionKey.close();
        label48: if (!WebSocketImpl.DEBUG)
          continue;
        System.out.println("Connection closed because of" + paramIOException);
        return;
      }
      catch (IOException paramSelectionKey)
      {
        break label48;
      }
    }
  }

  private void pushBuffer(ByteBuffer paramByteBuffer)
    throws InterruptedException
  {
    if (this.buffers.size() > this.queuesize.intValue())
      return;
    this.buffers.put(paramByteBuffer);
  }

  private void queue(WebSocketImpl paramWebSocketImpl)
    throws InterruptedException
  {
    if (paramWebSocketImpl.workerThread == null)
    {
      paramWebSocketImpl.workerThread = ((WebSocketWorker)this.decoders.get(this.queueinvokes % this.decoders.size()));
      this.queueinvokes += 1;
    }
    paramWebSocketImpl.workerThread.put(paramWebSocketImpl);
  }

  private ByteBuffer takeBuffer()
    throws InterruptedException
  {
    return (ByteBuffer)this.buffers.take();
  }

  protected boolean addConnection(WebSocket paramWebSocket)
  {
    synchronized (this.connections)
    {
      boolean bool = this.connections.add(paramWebSocket);
      return bool;
    }
  }

  protected void allocateBuffers(WebSocket paramWebSocket)
    throws InterruptedException
  {
    if (this.queuesize.get() >= this.decoders.size() * 2 + 1)
      return;
    this.queuesize.incrementAndGet();
    this.buffers.put(createBuffer());
  }

  public Collection<WebSocket> connections()
  {
    return this.connections;
  }

  public ByteBuffer createBuffer()
  {
    return ByteBuffer.allocate(WebSocketImpl.RCVBUF);
  }

  public InetSocketAddress getAddress()
  {
    return this.address;
  }

  public List<Draft> getDraft()
  {
    return Collections.unmodifiableList(this.drafts);
  }

  protected String getFlashSecurityPolicy()
  {
    return "<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"" + getPort() + "\" /></cross-domain-policy>";
  }

  public InetSocketAddress getLocalSocketAddress(WebSocket paramWebSocket)
  {
    return (InetSocketAddress)getSocket(paramWebSocket).getLocalSocketAddress();
  }

  public int getPort()
  {
    int j = getAddress().getPort();
    int i = j;
    if (j == 0)
    {
      i = j;
      if (this.server != null)
        i = this.server.socket().getLocalPort();
    }
    return i;
  }

  public InetSocketAddress getRemoteSocketAddress(WebSocket paramWebSocket)
  {
    return (InetSocketAddress)getSocket(paramWebSocket).getRemoteSocketAddress();
  }

  public final WebSocketFactory getWebSocketFactory()
  {
    return this.wsf;
  }

  public abstract void onClose(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean);

  public void onCloseInitiated(WebSocket paramWebSocket, int paramInt, String paramString)
  {
  }

  public void onClosing(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
  {
  }

  protected boolean onConnect(SelectionKey paramSelectionKey)
  {
    return true;
  }

  public abstract void onError(WebSocket paramWebSocket, Exception paramException);

  public abstract void onMessage(WebSocket paramWebSocket, String paramString);

  public void onMessage(WebSocket paramWebSocket, ByteBuffer paramByteBuffer)
  {
  }

  public abstract void onOpen(WebSocket paramWebSocket, ClientHandshake paramClientHandshake);

  public final void onWebsocketClose(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
  {
    this.selector.wakeup();
    try
    {
      if (removeConnection(paramWebSocket))
        onClose(paramWebSocket, paramInt, paramString, paramBoolean);
      try
      {
        releaseBuffers(paramWebSocket);
        return;
      }
      catch (InterruptedException paramWebSocket)
      {
        Thread.currentThread().interrupt();
        return;
      }
    }
    finally
    {
    }
    try
    {
      releaseBuffers(paramWebSocket);
      throw paramString;
    }
    catch (InterruptedException paramWebSocket)
    {
      while (true)
        Thread.currentThread().interrupt();
    }
  }

  public void onWebsocketCloseInitiated(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    onCloseInitiated(paramWebSocket, paramInt, paramString);
  }

  public void onWebsocketClosing(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
  {
    onClosing(paramWebSocket, paramInt, paramString, paramBoolean);
  }

  public final void onWebsocketError(WebSocket paramWebSocket, Exception paramException)
  {
    onError(paramWebSocket, paramException);
  }

  public final void onWebsocketMessage(WebSocket paramWebSocket, String paramString)
  {
    onMessage(paramWebSocket, paramString);
  }

  public final void onWebsocketMessage(WebSocket paramWebSocket, ByteBuffer paramByteBuffer)
  {
    onMessage(paramWebSocket, paramByteBuffer);
  }

  public final void onWebsocketOpen(WebSocket paramWebSocket, Handshakedata paramHandshakedata)
  {
    if (addConnection(paramWebSocket))
      onOpen(paramWebSocket, (ClientHandshake)paramHandshakedata);
  }

  public final void onWriteDemand(WebSocket paramWebSocket)
  {
    paramWebSocket = (WebSocketImpl)paramWebSocket;
    try
    {
      paramWebSocket.key.interestOps(5);
      this.selector.wakeup();
      return;
    }
    catch (CancelledKeyException localCancelledKeyException)
    {
      while (true)
        paramWebSocket.outQueue.clear();
    }
  }

  protected void releaseBuffers(WebSocket paramWebSocket)
    throws InterruptedException
  {
  }

  protected boolean removeConnection(WebSocket paramWebSocket)
  {
    synchronized (this.connections)
    {
      boolean bool = this.connections.remove(paramWebSocket);
      return bool;
    }
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 430	org/java_websocket/server/WebSocketServer:selectorthread	Ljava/lang/Thread;
    //   6: ifnull +42 -> 48
    //   9: new 432	java/lang/IllegalStateException
    //   12: dup
    //   13: new 238	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   20: aload_0
    //   21: invokevirtual 438	java/lang/Object:getClass	()Ljava/lang/Class;
    //   24: invokevirtual 443	java/lang/Class:getName	()Ljava/lang/String;
    //   27: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 445
    //   33: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 446	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   42: athrow
    //   43: astore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: athrow
    //   48: aload_0
    //   49: invokestatic 199	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   52: putfield 430	org/java_websocket/server/WebSocketServer:selectorthread	Ljava/lang/Thread;
    //   55: aload_0
    //   56: getfield 90	org/java_websocket/server/WebSocketServer:isclosed	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   59: invokevirtual 448	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   62: ifeq +6 -> 68
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_0
    //   71: getfield 430	org/java_websocket/server/WebSocketServer:selectorthread	Ljava/lang/Thread;
    //   74: new 238	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 450
    //   84: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: getfield 430	org/java_websocket/server/WebSocketServer:selectorthread	Ljava/lang/Thread;
    //   91: invokevirtual 454	java/lang/Thread:getId	()J
    //   94: invokevirtual 457	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   97: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokevirtual 460	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   103: aload_0
    //   104: invokestatic 464	java/nio/channels/ServerSocketChannel:open	()Ljava/nio/channels/ServerSocketChannel;
    //   107: putfield 346	org/java_websocket/server/WebSocketServer:server	Ljava/nio/channels/ServerSocketChannel;
    //   110: aload_0
    //   111: getfield 346	org/java_websocket/server/WebSocketServer:server	Ljava/nio/channels/ServerSocketChannel;
    //   114: iconst_0
    //   115: invokevirtual 468	java/nio/channels/ServerSocketChannel:configureBlocking	(Z)Ljava/nio/channels/SelectableChannel;
    //   118: pop
    //   119: aload_0
    //   120: getfield 346	org/java_websocket/server/WebSocketServer:server	Ljava/nio/channels/ServerSocketChannel;
    //   123: invokevirtual 351	java/nio/channels/ServerSocketChannel:socket	()Ljava/net/ServerSocket;
    //   126: astore_2
    //   127: aload_2
    //   128: getstatic 309	org/java_websocket/WebSocketImpl:RCVBUF	I
    //   131: invokevirtual 471	java/net/ServerSocket:setReceiveBufferSize	(I)V
    //   134: aload_2
    //   135: aload_0
    //   136: getfield 119	org/java_websocket/server/WebSocketServer:address	Ljava/net/InetSocketAddress;
    //   139: invokevirtual 475	java/net/ServerSocket:bind	(Ljava/net/SocketAddress;)V
    //   142: aload_0
    //   143: invokestatic 477	java/nio/channels/Selector:open	()Ljava/nio/channels/Selector;
    //   146: putfield 376	org/java_websocket/server/WebSocketServer:selector	Ljava/nio/channels/Selector;
    //   149: aload_0
    //   150: getfield 346	org/java_websocket/server/WebSocketServer:server	Ljava/nio/channels/ServerSocketChannel;
    //   153: aload_0
    //   154: getfield 376	org/java_websocket/server/WebSocketServer:selector	Ljava/nio/channels/Selector;
    //   157: aload_0
    //   158: getfield 346	org/java_websocket/server/WebSocketServer:server	Ljava/nio/channels/ServerSocketChannel;
    //   161: invokevirtual 480	java/nio/channels/ServerSocketChannel:validOps	()I
    //   164: invokevirtual 484	java/nio/channels/ServerSocketChannel:register	(Ljava/nio/channels/Selector;I)Ljava/nio/channels/SelectionKey;
    //   167: pop
    //   168: aload_0
    //   169: getfield 430	org/java_websocket/server/WebSocketServer:selectorthread	Ljava/lang/Thread;
    //   172: invokevirtual 487	java/lang/Thread:isInterrupted	()Z
    //   175: istore_1
    //   176: iload_1
    //   177: ifne +777 -> 954
    //   180: aconst_null
    //   181: astore 6
    //   183: aconst_null
    //   184: astore 5
    //   186: aconst_null
    //   187: astore 7
    //   189: aconst_null
    //   190: astore_3
    //   191: aload 7
    //   193: astore_2
    //   194: aload 6
    //   196: astore 4
    //   198: aload_0
    //   199: getfield 376	org/java_websocket/server/WebSocketServer:selector	Ljava/nio/channels/Selector;
    //   202: invokevirtual 490	java/nio/channels/Selector:select	()I
    //   205: pop
    //   206: aload 7
    //   208: astore_2
    //   209: aload 6
    //   211: astore 4
    //   213: aload_0
    //   214: getfield 376	org/java_websocket/server/WebSocketServer:selector	Ljava/nio/channels/Selector;
    //   217: invokevirtual 494	java/nio/channels/Selector:selectedKeys	()Ljava/util/Set;
    //   220: invokeinterface 500 1 0
    //   225: astore 8
    //   227: aload_3
    //   228: astore_2
    //   229: aload 5
    //   231: astore 4
    //   233: aload_3
    //   234: astore 6
    //   236: aload 8
    //   238: invokeinterface 505 1 0
    //   243: ifeq +562 -> 805
    //   246: aload_3
    //   247: astore_2
    //   248: aload 5
    //   250: astore 4
    //   252: aload 8
    //   254: invokeinterface 508 1 0
    //   259: checkcast 175	java/nio/channels/SelectionKey
    //   262: astore 7
    //   264: aload 7
    //   266: astore 5
    //   268: aload_3
    //   269: astore_2
    //   270: aload 7
    //   272: astore 4
    //   274: aload 7
    //   276: invokevirtual 511	java/nio/channels/SelectionKey:isValid	()Z
    //   279: ifeq -52 -> 227
    //   282: aload_3
    //   283: astore_2
    //   284: aload 7
    //   286: astore 4
    //   288: aload 7
    //   290: invokevirtual 514	java/nio/channels/SelectionKey:isAcceptable	()Z
    //   293: ifeq +215 -> 508
    //   296: aload_3
    //   297: astore_2
    //   298: aload 7
    //   300: astore 4
    //   302: aload_0
    //   303: aload 7
    //   305: invokevirtual 516	org/java_websocket/server/WebSocketServer:onConnect	(Ljava/nio/channels/SelectionKey;)Z
    //   308: ifne +33 -> 341
    //   311: aload_3
    //   312: astore_2
    //   313: aload 7
    //   315: astore 4
    //   317: aload 7
    //   319: invokevirtual 519	java/nio/channels/SelectionKey:cancel	()V
    //   322: aload 7
    //   324: astore 5
    //   326: goto -99 -> 227
    //   329: astore_2
    //   330: goto -162 -> 168
    //   333: astore_2
    //   334: aload_0
    //   335: aconst_null
    //   336: aload_2
    //   337: invokespecial 165	org/java_websocket/server/WebSocketServer:handleFatal	(Lorg/java_websocket/WebSocket;Ljava/lang/Exception;)V
    //   340: return
    //   341: aload_3
    //   342: astore_2
    //   343: aload 7
    //   345: astore 4
    //   347: aload_0
    //   348: getfield 346	org/java_websocket/server/WebSocketServer:server	Ljava/nio/channels/ServerSocketChannel;
    //   351: invokevirtual 523	java/nio/channels/ServerSocketChannel:accept	()Ljava/nio/channels/SocketChannel;
    //   354: astore 5
    //   356: aload_3
    //   357: astore_2
    //   358: aload 7
    //   360: astore 4
    //   362: aload 5
    //   364: iconst_0
    //   365: invokevirtual 524	java/nio/channels/SocketChannel:configureBlocking	(Z)Ljava/nio/channels/SelectableChannel;
    //   368: pop
    //   369: aload_3
    //   370: astore_2
    //   371: aload 7
    //   373: astore 4
    //   375: aload_0
    //   376: getfield 102	org/java_websocket/server/WebSocketServer:wsf	Lorg/java_websocket/server/WebSocketServer$WebSocketServerFactory;
    //   379: aload_0
    //   380: aload_0
    //   381: getfield 117	org/java_websocket/server/WebSocketServer:drafts	Ljava/util/List;
    //   384: aload 5
    //   386: invokevirtual 185	java/nio/channels/SocketChannel:socket	()Ljava/net/Socket;
    //   389: invokeinterface 528 4 0
    //   394: astore 6
    //   396: aload_3
    //   397: astore_2
    //   398: aload 7
    //   400: astore 4
    //   402: aload 6
    //   404: aload 5
    //   406: aload_0
    //   407: getfield 376	org/java_websocket/server/WebSocketServer:selector	Ljava/nio/channels/Selector;
    //   410: iconst_1
    //   411: aload 6
    //   413: invokevirtual 531	java/nio/channels/SocketChannel:register	(Ljava/nio/channels/Selector;ILjava/lang/Object;)Ljava/nio/channels/SelectionKey;
    //   416: putfield 173	org/java_websocket/WebSocketImpl:key	Ljava/nio/channels/SelectionKey;
    //   419: aload_3
    //   420: astore_2
    //   421: aload 7
    //   423: astore 4
    //   425: aload 6
    //   427: aload_0
    //   428: getfield 102	org/java_websocket/server/WebSocketServer:wsf	Lorg/java_websocket/server/WebSocketServer$WebSocketServerFactory;
    //   431: aload 5
    //   433: aload 6
    //   435: getfield 173	org/java_websocket/WebSocketImpl:key	Ljava/nio/channels/SelectionKey;
    //   438: invokeinterface 535 3 0
    //   443: putfield 538	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   446: aload_3
    //   447: astore_2
    //   448: aload 7
    //   450: astore 4
    //   452: aload 8
    //   454: invokeinterface 540 1 0
    //   459: aload_3
    //   460: astore_2
    //   461: aload 7
    //   463: astore 4
    //   465: aload_0
    //   466: aload 6
    //   468: invokevirtual 542	org/java_websocket/server/WebSocketServer:allocateBuffers	(Lorg/java_websocket/WebSocket;)V
    //   471: aload 7
    //   473: astore 5
    //   475: goto -248 -> 227
    //   478: astore_3
    //   479: aload 4
    //   481: ifnull +8 -> 489
    //   484: aload 4
    //   486: invokevirtual 519	java/nio/channels/SelectionKey:cancel	()V
    //   489: aload_0
    //   490: aload 4
    //   492: aload_2
    //   493: aload_3
    //   494: invokespecial 544	org/java_websocket/server/WebSocketServer:handleIOException	(Ljava/nio/channels/SelectionKey;Lorg/java_websocket/WebSocket;Ljava/io/IOException;)V
    //   497: goto -329 -> 168
    //   500: astore_2
    //   501: aload_0
    //   502: aconst_null
    //   503: aload_2
    //   504: invokespecial 165	org/java_websocket/server/WebSocketServer:handleFatal	(Lorg/java_websocket/WebSocket;Ljava/lang/Exception;)V
    //   507: return
    //   508: aload_3
    //   509: astore_2
    //   510: aload 7
    //   512: astore 4
    //   514: aload_3
    //   515: astore 6
    //   517: aload 7
    //   519: invokevirtual 547	java/nio/channels/SelectionKey:isReadable	()Z
    //   522: ifeq +111 -> 633
    //   525: aload_3
    //   526: astore_2
    //   527: aload 7
    //   529: astore 4
    //   531: aload 7
    //   533: invokevirtual 550	java/nio/channels/SelectionKey:attachment	()Ljava/lang/Object;
    //   536: checkcast 169	org/java_websocket/WebSocketImpl
    //   539: astore_3
    //   540: aload_3
    //   541: astore_2
    //   542: aload 7
    //   544: astore 4
    //   546: aload_0
    //   547: invokespecial 552	org/java_websocket/server/WebSocketServer:takeBuffer	()Ljava/nio/ByteBuffer;
    //   550: astore 5
    //   552: aload 5
    //   554: aload_3
    //   555: aload_3
    //   556: getfield 538	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   559: invokestatic 558	org/java_websocket/SocketChannelIOHelper:read	(Ljava/nio/ByteBuffer;Lorg/java_websocket/WebSocketImpl;Ljava/nio/channels/ByteChannel;)Z
    //   562: ifeq +185 -> 747
    //   565: aload_3
    //   566: getfield 561	org/java_websocket/WebSocketImpl:inQueue	Ljava/util/concurrent/BlockingQueue;
    //   569: aload 5
    //   571: invokeinterface 268 2 0
    //   576: aload_0
    //   577: aload_3
    //   578: invokespecial 563	org/java_websocket/server/WebSocketServer:queue	(Lorg/java_websocket/WebSocketImpl;)V
    //   581: aload 8
    //   583: invokeinterface 540 1 0
    //   588: aload_3
    //   589: astore 6
    //   591: aload_3
    //   592: getfield 538	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   595: instanceof 565
    //   598: ifeq +35 -> 633
    //   601: aload_3
    //   602: astore 6
    //   604: aload_3
    //   605: getfield 538	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   608: checkcast 565	org/java_websocket/WrappedByteChannel
    //   611: invokeinterface 568 1 0
    //   616: ifeq +17 -> 633
    //   619: aload_0
    //   620: getfield 126	org/java_websocket/server/WebSocketServer:iqueue	Ljava/util/List;
    //   623: aload_3
    //   624: invokeinterface 145 2 0
    //   629: pop
    //   630: aload_3
    //   631: astore 6
    //   633: aload 6
    //   635: astore_3
    //   636: aload 7
    //   638: astore 5
    //   640: aload 6
    //   642: astore_2
    //   643: aload 7
    //   645: astore 4
    //   647: aload 7
    //   649: invokevirtual 571	java/nio/channels/SelectionKey:isWritable	()Z
    //   652: ifeq -425 -> 227
    //   655: aload 6
    //   657: astore_2
    //   658: aload 7
    //   660: astore 4
    //   662: aload 7
    //   664: invokevirtual 550	java/nio/channels/SelectionKey:attachment	()Ljava/lang/Object;
    //   667: checkcast 169	org/java_websocket/WebSocketImpl
    //   670: astore 6
    //   672: aload 6
    //   674: astore_3
    //   675: aload 7
    //   677: astore 5
    //   679: aload 6
    //   681: astore_2
    //   682: aload 7
    //   684: astore 4
    //   686: aload 6
    //   688: aload 6
    //   690: getfield 538	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   693: invokestatic 575	org/java_websocket/SocketChannelIOHelper:batch	(Lorg/java_websocket/WebSocketImpl;Ljava/nio/channels/ByteChannel;)Z
    //   696: ifeq -469 -> 227
    //   699: aload 6
    //   701: astore_3
    //   702: aload 7
    //   704: astore 5
    //   706: aload 6
    //   708: astore_2
    //   709: aload 7
    //   711: astore 4
    //   713: aload 7
    //   715: invokevirtual 511	java/nio/channels/SelectionKey:isValid	()Z
    //   718: ifeq -491 -> 227
    //   721: aload 6
    //   723: astore_2
    //   724: aload 7
    //   726: astore 4
    //   728: aload 7
    //   730: iconst_1
    //   731: invokevirtual 416	java/nio/channels/SelectionKey:interestOps	(I)Ljava/nio/channels/SelectionKey;
    //   734: pop
    //   735: aload 6
    //   737: astore_3
    //   738: aload 7
    //   740: astore 5
    //   742: goto -515 -> 227
    //   745: astore_2
    //   746: return
    //   747: aload_0
    //   748: aload 5
    //   750: invokespecial 159	org/java_websocket/server/WebSocketServer:pushBuffer	(Ljava/nio/ByteBuffer;)V
    //   753: aload_3
    //   754: astore 6
    //   756: goto -123 -> 633
    //   759: astore 6
    //   761: aload_3
    //   762: astore_2
    //   763: aload 7
    //   765: astore 4
    //   767: aload_0
    //   768: aload 5
    //   770: invokespecial 159	org/java_websocket/server/WebSocketServer:pushBuffer	(Ljava/nio/ByteBuffer;)V
    //   773: aload_3
    //   774: astore_2
    //   775: aload 7
    //   777: astore 4
    //   779: aload 6
    //   781: athrow
    //   782: astore 6
    //   784: aload_3
    //   785: astore_2
    //   786: aload 7
    //   788: astore 4
    //   790: aload_0
    //   791: aload 5
    //   793: invokespecial 159	org/java_websocket/server/WebSocketServer:pushBuffer	(Ljava/nio/ByteBuffer;)V
    //   796: aload_3
    //   797: astore_2
    //   798: aload 7
    //   800: astore 4
    //   802: aload 6
    //   804: athrow
    //   805: aload 6
    //   807: astore_2
    //   808: aload 5
    //   810: astore 4
    //   812: aload_0
    //   813: getfield 126	org/java_websocket/server/WebSocketServer:iqueue	Ljava/util/List;
    //   816: invokeinterface 578 1 0
    //   821: ifne -653 -> 168
    //   824: aload 6
    //   826: astore_2
    //   827: aload 5
    //   829: astore 4
    //   831: aload_0
    //   832: getfield 126	org/java_websocket/server/WebSocketServer:iqueue	Ljava/util/List;
    //   835: iconst_0
    //   836: invokeinterface 580 2 0
    //   841: checkcast 169	org/java_websocket/WebSocketImpl
    //   844: astore 6
    //   846: aload 6
    //   848: astore_2
    //   849: aload 5
    //   851: astore 4
    //   853: aload 6
    //   855: getfield 538	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   858: checkcast 565	org/java_websocket/WrappedByteChannel
    //   861: astore 7
    //   863: aload 6
    //   865: astore_2
    //   866: aload 5
    //   868: astore 4
    //   870: aload_0
    //   871: invokespecial 552	org/java_websocket/server/WebSocketServer:takeBuffer	()Ljava/nio/ByteBuffer;
    //   874: astore_3
    //   875: aload_3
    //   876: aload 6
    //   878: aload 7
    //   880: invokestatic 584	org/java_websocket/SocketChannelIOHelper:readMore	(Ljava/nio/ByteBuffer;Lorg/java_websocket/WebSocketImpl;Lorg/java_websocket/WrappedByteChannel;)Z
    //   883: ifeq +15 -> 898
    //   886: aload_0
    //   887: getfield 126	org/java_websocket/server/WebSocketServer:iqueue	Ljava/util/List;
    //   890: aload 6
    //   892: invokeinterface 145 2 0
    //   897: pop
    //   898: aload 6
    //   900: getfield 561	org/java_websocket/WebSocketImpl:inQueue	Ljava/util/concurrent/BlockingQueue;
    //   903: aload_3
    //   904: invokeinterface 268 2 0
    //   909: aload_0
    //   910: aload 6
    //   912: invokespecial 563	org/java_websocket/server/WebSocketServer:queue	(Lorg/java_websocket/WebSocketImpl;)V
    //   915: aload 6
    //   917: astore_2
    //   918: aload 5
    //   920: astore 4
    //   922: aload_0
    //   923: aload_3
    //   924: invokespecial 159	org/java_websocket/server/WebSocketServer:pushBuffer	(Ljava/nio/ByteBuffer;)V
    //   927: goto -122 -> 805
    //   930: astore 7
    //   932: aload 6
    //   934: astore_2
    //   935: aload 5
    //   937: astore 4
    //   939: aload_0
    //   940: aload_3
    //   941: invokespecial 159	org/java_websocket/server/WebSocketServer:pushBuffer	(Ljava/nio/ByteBuffer;)V
    //   944: aload 6
    //   946: astore_2
    //   947: aload 5
    //   949: astore 4
    //   951: aload 7
    //   953: athrow
    //   954: return
    //
    // Exception table:
    //   from	to	target	type
    //   2	43	43	finally
    //   44	46	43	finally
    //   48	67	43	finally
    //   68	70	43	finally
    //   198	206	329	java/nio/channels/CancelledKeyException
    //   213	227	329	java/nio/channels/CancelledKeyException
    //   236	246	329	java/nio/channels/CancelledKeyException
    //   252	264	329	java/nio/channels/CancelledKeyException
    //   274	282	329	java/nio/channels/CancelledKeyException
    //   288	296	329	java/nio/channels/CancelledKeyException
    //   302	311	329	java/nio/channels/CancelledKeyException
    //   317	322	329	java/nio/channels/CancelledKeyException
    //   347	356	329	java/nio/channels/CancelledKeyException
    //   362	369	329	java/nio/channels/CancelledKeyException
    //   375	396	329	java/nio/channels/CancelledKeyException
    //   402	419	329	java/nio/channels/CancelledKeyException
    //   425	446	329	java/nio/channels/CancelledKeyException
    //   452	459	329	java/nio/channels/CancelledKeyException
    //   465	471	329	java/nio/channels/CancelledKeyException
    //   517	525	329	java/nio/channels/CancelledKeyException
    //   531	540	329	java/nio/channels/CancelledKeyException
    //   546	552	329	java/nio/channels/CancelledKeyException
    //   552	588	329	java/nio/channels/CancelledKeyException
    //   591	601	329	java/nio/channels/CancelledKeyException
    //   604	630	329	java/nio/channels/CancelledKeyException
    //   647	655	329	java/nio/channels/CancelledKeyException
    //   662	672	329	java/nio/channels/CancelledKeyException
    //   686	699	329	java/nio/channels/CancelledKeyException
    //   713	721	329	java/nio/channels/CancelledKeyException
    //   728	735	329	java/nio/channels/CancelledKeyException
    //   747	753	329	java/nio/channels/CancelledKeyException
    //   767	773	329	java/nio/channels/CancelledKeyException
    //   779	782	329	java/nio/channels/CancelledKeyException
    //   790	796	329	java/nio/channels/CancelledKeyException
    //   802	805	329	java/nio/channels/CancelledKeyException
    //   812	824	329	java/nio/channels/CancelledKeyException
    //   831	846	329	java/nio/channels/CancelledKeyException
    //   853	863	329	java/nio/channels/CancelledKeyException
    //   870	875	329	java/nio/channels/CancelledKeyException
    //   922	927	329	java/nio/channels/CancelledKeyException
    //   939	944	329	java/nio/channels/CancelledKeyException
    //   951	954	329	java/nio/channels/CancelledKeyException
    //   103	168	333	java/io/IOException
    //   198	206	478	java/io/IOException
    //   213	227	478	java/io/IOException
    //   236	246	478	java/io/IOException
    //   252	264	478	java/io/IOException
    //   274	282	478	java/io/IOException
    //   288	296	478	java/io/IOException
    //   302	311	478	java/io/IOException
    //   317	322	478	java/io/IOException
    //   347	356	478	java/io/IOException
    //   362	369	478	java/io/IOException
    //   375	396	478	java/io/IOException
    //   402	419	478	java/io/IOException
    //   425	446	478	java/io/IOException
    //   452	459	478	java/io/IOException
    //   465	471	478	java/io/IOException
    //   517	525	478	java/io/IOException
    //   531	540	478	java/io/IOException
    //   546	552	478	java/io/IOException
    //   647	655	478	java/io/IOException
    //   662	672	478	java/io/IOException
    //   686	699	478	java/io/IOException
    //   713	721	478	java/io/IOException
    //   728	735	478	java/io/IOException
    //   767	773	478	java/io/IOException
    //   779	782	478	java/io/IOException
    //   790	796	478	java/io/IOException
    //   802	805	478	java/io/IOException
    //   812	824	478	java/io/IOException
    //   831	846	478	java/io/IOException
    //   853	863	478	java/io/IOException
    //   870	875	478	java/io/IOException
    //   922	927	478	java/io/IOException
    //   939	944	478	java/io/IOException
    //   951	954	478	java/io/IOException
    //   168	176	500	java/lang/RuntimeException
    //   198	206	500	java/lang/RuntimeException
    //   213	227	500	java/lang/RuntimeException
    //   236	246	500	java/lang/RuntimeException
    //   252	264	500	java/lang/RuntimeException
    //   274	282	500	java/lang/RuntimeException
    //   288	296	500	java/lang/RuntimeException
    //   302	311	500	java/lang/RuntimeException
    //   317	322	500	java/lang/RuntimeException
    //   347	356	500	java/lang/RuntimeException
    //   362	369	500	java/lang/RuntimeException
    //   375	396	500	java/lang/RuntimeException
    //   402	419	500	java/lang/RuntimeException
    //   425	446	500	java/lang/RuntimeException
    //   452	459	500	java/lang/RuntimeException
    //   465	471	500	java/lang/RuntimeException
    //   484	489	500	java/lang/RuntimeException
    //   489	497	500	java/lang/RuntimeException
    //   517	525	500	java/lang/RuntimeException
    //   531	540	500	java/lang/RuntimeException
    //   546	552	500	java/lang/RuntimeException
    //   647	655	500	java/lang/RuntimeException
    //   662	672	500	java/lang/RuntimeException
    //   686	699	500	java/lang/RuntimeException
    //   713	721	500	java/lang/RuntimeException
    //   728	735	500	java/lang/RuntimeException
    //   767	773	500	java/lang/RuntimeException
    //   779	782	500	java/lang/RuntimeException
    //   790	796	500	java/lang/RuntimeException
    //   802	805	500	java/lang/RuntimeException
    //   812	824	500	java/lang/RuntimeException
    //   831	846	500	java/lang/RuntimeException
    //   853	863	500	java/lang/RuntimeException
    //   870	875	500	java/lang/RuntimeException
    //   922	927	500	java/lang/RuntimeException
    //   939	944	500	java/lang/RuntimeException
    //   951	954	500	java/lang/RuntimeException
    //   198	206	745	java/lang/InterruptedException
    //   213	227	745	java/lang/InterruptedException
    //   236	246	745	java/lang/InterruptedException
    //   252	264	745	java/lang/InterruptedException
    //   274	282	745	java/lang/InterruptedException
    //   288	296	745	java/lang/InterruptedException
    //   302	311	745	java/lang/InterruptedException
    //   317	322	745	java/lang/InterruptedException
    //   347	356	745	java/lang/InterruptedException
    //   362	369	745	java/lang/InterruptedException
    //   375	396	745	java/lang/InterruptedException
    //   402	419	745	java/lang/InterruptedException
    //   425	446	745	java/lang/InterruptedException
    //   452	459	745	java/lang/InterruptedException
    //   465	471	745	java/lang/InterruptedException
    //   517	525	745	java/lang/InterruptedException
    //   531	540	745	java/lang/InterruptedException
    //   546	552	745	java/lang/InterruptedException
    //   552	588	745	java/lang/InterruptedException
    //   591	601	745	java/lang/InterruptedException
    //   604	630	745	java/lang/InterruptedException
    //   647	655	745	java/lang/InterruptedException
    //   662	672	745	java/lang/InterruptedException
    //   686	699	745	java/lang/InterruptedException
    //   713	721	745	java/lang/InterruptedException
    //   728	735	745	java/lang/InterruptedException
    //   747	753	745	java/lang/InterruptedException
    //   767	773	745	java/lang/InterruptedException
    //   779	782	745	java/lang/InterruptedException
    //   790	796	745	java/lang/InterruptedException
    //   802	805	745	java/lang/InterruptedException
    //   812	824	745	java/lang/InterruptedException
    //   831	846	745	java/lang/InterruptedException
    //   853	863	745	java/lang/InterruptedException
    //   870	875	745	java/lang/InterruptedException
    //   922	927	745	java/lang/InterruptedException
    //   939	944	745	java/lang/InterruptedException
    //   951	954	745	java/lang/InterruptedException
    //   552	588	759	java/io/IOException
    //   591	601	759	java/io/IOException
    //   604	630	759	java/io/IOException
    //   747	753	759	java/io/IOException
    //   552	588	782	java/lang/RuntimeException
    //   591	601	782	java/lang/RuntimeException
    //   604	630	782	java/lang/RuntimeException
    //   747	753	782	java/lang/RuntimeException
    //   875	898	930	finally
    //   898	915	930	finally
  }

  public final void setWebSocketFactory(WebSocketServerFactory paramWebSocketServerFactory)
  {
    this.wsf = paramWebSocketServerFactory;
  }

  public void start()
  {
    if (this.selectorthread != null)
      throw new IllegalStateException(getClass().getName() + " can only be started once.");
    new Thread(this).start();
  }

  public void stop()
    throws IOException, InterruptedException
  {
    stop(0);
  }

  public void stop(int paramInt)
    throws IOException, InterruptedException
  {
    if (!this.isclosed.compareAndSet(false, true))
      return;
    synchronized (this.connections)
    {
      Iterator localIterator = this.connections.iterator();
      if (localIterator.hasNext())
        ((WebSocket)localIterator.next()).close(1001);
    }
    monitorexit;
    monitorenter;
    try
    {
      if ((this.selectorthread != null) && ((Thread.currentThread() == this.selectorthread) || (this.selectorthread != Thread.currentThread())))
      {
        this.selectorthread.interrupt();
        this.selectorthread.join();
      }
      if (this.decoders != null)
      {
        ??? = this.decoders.iterator();
        while (((Iterator)???).hasNext())
          ((WebSocketWorker)((Iterator)???).next()).interrupt();
      }
    }
    finally
    {
      monitorexit;
    }
    if (this.server != null)
      this.server.close();
    monitorexit;
  }

  public static abstract interface WebSocketServerFactory extends WebSocketFactory
  {
    public abstract WebSocketImpl createWebSocket(WebSocketAdapter paramWebSocketAdapter, List<Draft> paramList, Socket paramSocket);

    public abstract WebSocketImpl createWebSocket(WebSocketAdapter paramWebSocketAdapter, Draft paramDraft, Socket paramSocket);

    public abstract ByteChannel wrapChannel(SocketChannel paramSocketChannel, SelectionKey paramSelectionKey)
      throws IOException;
  }

  public class WebSocketWorker extends Thread
  {
    private BlockingQueue<WebSocketImpl> iqueue = new LinkedBlockingQueue();

    static
    {
      if (!WebSocketServer.class.desiredAssertionStatus());
      for (boolean bool = true; ; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }

    public WebSocketWorker()
    {
      setName("WebSocketWorker-" + getId());
      setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(WebSocketServer.this)
      {
        public void uncaughtException(Thread paramThread, Throwable paramThrowable)
        {
          Thread.getDefaultUncaughtExceptionHandler().uncaughtException(paramThread, paramThrowable);
        }
      });
    }

    public void put(WebSocketImpl paramWebSocketImpl)
      throws InterruptedException
    {
      this.iqueue.put(paramWebSocketImpl);
    }

    // ERROR //
    public void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: aload_0
      //   3: getfield 38	org/java_websocket/server/WebSocketServer$WebSocketWorker:iqueue	Ljava/util/concurrent/BlockingQueue;
      //   6: invokeinterface 86 1 0
      //   11: checkcast 88	org/java_websocket/WebSocketImpl
      //   14: astore_2
      //   15: aload_2
      //   16: astore_1
      //   17: aload_2
      //   18: getfield 91	org/java_websocket/WebSocketImpl:inQueue	Ljava/util/concurrent/BlockingQueue;
      //   21: invokeinterface 94 1 0
      //   26: checkcast 96	java/nio/ByteBuffer
      //   29: astore_3
      //   30: aload_2
      //   31: astore_1
      //   32: getstatic 26	org/java_websocket/server/WebSocketServer$WebSocketWorker:$assertionsDisabled	Z
      //   35: ifne +19 -> 54
      //   38: aload_3
      //   39: ifnonnull +15 -> 54
      //   42: aload_2
      //   43: astore_1
      //   44: new 98	java/lang/AssertionError
      //   47: dup
      //   48: invokespecial 99	java/lang/AssertionError:<init>	()V
      //   51: athrow
      //   52: astore_1
      //   53: return
      //   54: aload_2
      //   55: aload_3
      //   56: invokevirtual 103	org/java_websocket/WebSocketImpl:decode	(Ljava/nio/ByteBuffer;)V
      //   59: aload_2
      //   60: astore_1
      //   61: aload_0
      //   62: getfield 31	org/java_websocket/server/WebSocketServer$WebSocketWorker:this$0	Lorg/java_websocket/server/WebSocketServer;
      //   65: aload_3
      //   66: invokestatic 107	org/java_websocket/server/WebSocketServer:access$000	(Lorg/java_websocket/server/WebSocketServer;Ljava/nio/ByteBuffer;)V
      //   69: aload_2
      //   70: astore_1
      //   71: goto -69 -> 2
      //   74: astore_2
      //   75: aload_0
      //   76: getfield 31	org/java_websocket/server/WebSocketServer$WebSocketWorker:this$0	Lorg/java_websocket/server/WebSocketServer;
      //   79: aload_1
      //   80: aload_2
      //   81: invokestatic 111	org/java_websocket/server/WebSocketServer:access$100	(Lorg/java_websocket/server/WebSocketServer;Lorg/java_websocket/WebSocket;Ljava/lang/Exception;)V
      //   84: return
      //   85: astore 4
      //   87: aload_2
      //   88: astore_1
      //   89: aload_0
      //   90: getfield 31	org/java_websocket/server/WebSocketServer$WebSocketWorker:this$0	Lorg/java_websocket/server/WebSocketServer;
      //   93: aload_3
      //   94: invokestatic 107	org/java_websocket/server/WebSocketServer:access$000	(Lorg/java_websocket/server/WebSocketServer;Ljava/nio/ByteBuffer;)V
      //   97: aload_2
      //   98: astore_1
      //   99: aload 4
      //   101: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   2	15	52	java/lang/InterruptedException
      //   17	30	52	java/lang/InterruptedException
      //   32	38	52	java/lang/InterruptedException
      //   44	52	52	java/lang/InterruptedException
      //   61	69	52	java/lang/InterruptedException
      //   89	97	52	java/lang/InterruptedException
      //   99	102	52	java/lang/InterruptedException
      //   2	15	74	java/lang/RuntimeException
      //   17	30	74	java/lang/RuntimeException
      //   32	38	74	java/lang/RuntimeException
      //   44	52	74	java/lang/RuntimeException
      //   61	69	74	java/lang/RuntimeException
      //   89	97	74	java/lang/RuntimeException
      //   99	102	74	java/lang/RuntimeException
      //   54	59	85	finally
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.server.WebSocketServer
 * JD-Core Version:    0.6.0
 */
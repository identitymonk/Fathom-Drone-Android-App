package org.java_websocket.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.java_websocket.SocketChannelIOHelper;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocket.READYSTATE;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketFactory;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_10;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;

public abstract class WebSocketClient extends WebSocketAdapter
  implements Runnable
{
  private SocketChannel channel = null;
  private CountDownLatch closeLatch = new CountDownLatch(1);
  private WebSocketImpl conn = null;
  private CountDownLatch connectLatch = new CountDownLatch(1);
  private Draft draft;
  private Map<String, String> headers;
  private InetSocketAddress proxyAddress = null;
  private Thread readthread;
  private int timeout = 0;
  protected URI uri = null;
  private ByteChannel wrappedchannel = null;
  private Thread writethread;
  private WebSocketClientFactory wsfactory = new DefaultWebSocketClientFactory(this);

  static
  {
    if (!WebSocketClient.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }

  public WebSocketClient(URI paramURI)
  {
    this(paramURI, new Draft_10());
  }

  public WebSocketClient(URI paramURI, Draft paramDraft)
  {
    this(paramURI, paramDraft, null, 0);
  }

  public WebSocketClient(URI paramURI, Draft paramDraft, Map<String, String> paramMap, int paramInt)
  {
    if (paramURI == null)
      throw new IllegalArgumentException();
    if (paramDraft == null)
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    this.uri = paramURI;
    this.draft = paramDraft;
    this.headers = paramMap;
    this.timeout = paramInt;
    try
    {
      this.channel = SelectorProvider.provider().openSocketChannel();
      this.channel.configureBlocking(true);
      if (this.channel == null)
      {
        this.conn = ((WebSocketImpl)this.wsfactory.createWebSocket(this, paramDraft, null));
        this.conn.close(-1, "Failed to create or configure SocketChannel.");
        return;
      }
    }
    catch (IOException paramURI)
    {
      while (true)
      {
        this.channel = null;
        onWebsocketError(null, paramURI);
      }
      this.conn = ((WebSocketImpl)this.wsfactory.createWebSocket(this, paramDraft, this.channel.socket()));
    }
  }

  private int getPort()
  {
    int j = this.uri.getPort();
    int i = j;
    String str;
    if (j == -1)
    {
      str = this.uri.getScheme();
      if (str.equals("wss"))
        i = 443;
    }
    else
    {
      return i;
    }
    if (str.equals("ws"))
      return 80;
    throw new RuntimeException("unkonow scheme" + str);
  }

  // ERROR //
  private final void interruptableRun()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 76	org/java_websocket/client/WebSocketClient:channel	Ljava/nio/channels/SocketChannel;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 98	org/java_websocket/client/WebSocketClient:proxyAddress	Ljava/net/InetSocketAddress;
    //   12: ifnull +207 -> 219
    //   15: aload_0
    //   16: getfield 98	org/java_websocket/client/WebSocketClient:proxyAddress	Ljava/net/InetSocketAddress;
    //   19: invokevirtual 202	java/net/InetSocketAddress:getHostName	()Ljava/lang/String;
    //   22: astore_2
    //   23: aload_0
    //   24: getfield 98	org/java_websocket/client/WebSocketClient:proxyAddress	Ljava/net/InetSocketAddress;
    //   27: invokevirtual 203	java/net/InetSocketAddress:getPort	()I
    //   30: istore_1
    //   31: aload_0
    //   32: getfield 76	org/java_websocket/client/WebSocketClient:channel	Ljava/nio/channels/SocketChannel;
    //   35: new 199	java/net/InetSocketAddress
    //   38: dup
    //   39: aload_2
    //   40: iload_1
    //   41: invokespecial 206	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   44: invokevirtual 210	java/nio/channels/SocketChannel:connect	(Ljava/net/SocketAddress;)Z
    //   47: pop
    //   48: aload_0
    //   49: getfield 74	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   52: astore_3
    //   53: aload_0
    //   54: aload_0
    //   55: getfield 96	org/java_websocket/client/WebSocketClient:wsfactory	Lorg/java_websocket/client/WebSocketClient$WebSocketClientFactory;
    //   58: aload_0
    //   59: getfield 76	org/java_websocket/client/WebSocketClient:channel	Ljava/nio/channels/SocketChannel;
    //   62: aconst_null
    //   63: aload_2
    //   64: iload_1
    //   65: invokeinterface 214 5 0
    //   70: invokevirtual 218	org/java_websocket/client/WebSocketClient:createProxyChannel	(Ljava/nio/channels/ByteChannel;)Ljava/nio/channels/ByteChannel;
    //   73: astore_2
    //   74: aload_0
    //   75: aload_2
    //   76: putfield 78	org/java_websocket/client/WebSocketClient:wrappedchannel	Ljava/nio/channels/ByteChannel;
    //   79: aload_3
    //   80: aload_2
    //   81: putfield 220	org/java_websocket/WebSocketImpl:channel	Ljava/nio/channels/ByteChannel;
    //   84: aload_0
    //   85: iconst_0
    //   86: putfield 89	org/java_websocket/client/WebSocketClient:timeout	I
    //   89: aload_0
    //   90: invokespecial 223	org/java_websocket/client/WebSocketClient:sendHandshake	()V
    //   93: aload_0
    //   94: new 225	java/lang/Thread
    //   97: dup
    //   98: new 16	org/java_websocket/client/WebSocketClient$WebsocketWriteThread
    //   101: dup
    //   102: aload_0
    //   103: aconst_null
    //   104: invokespecial 228	org/java_websocket/client/WebSocketClient$WebsocketWriteThread:<init>	(Lorg/java_websocket/client/WebSocketClient;Lorg/java_websocket/client/WebSocketClient$1;)V
    //   107: invokespecial 231	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   110: putfield 233	org/java_websocket/client/WebSocketClient:readthread	Ljava/lang/Thread;
    //   113: aload_0
    //   114: getfield 233	org/java_websocket/client/WebSocketClient:readthread	Ljava/lang/Thread;
    //   117: invokevirtual 236	java/lang/Thread:start	()V
    //   120: getstatic 239	org/java_websocket/WebSocketImpl:RCVBUF	I
    //   123: invokestatic 245	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   126: astore_2
    //   127: aload_0
    //   128: getfield 76	org/java_websocket/client/WebSocketClient:channel	Ljava/nio/channels/SocketChannel;
    //   131: invokevirtual 248	java/nio/channels/SocketChannel:isOpen	()Z
    //   134: ifeq -127 -> 7
    //   137: aload_2
    //   138: aload_0
    //   139: getfield 74	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   142: aload_0
    //   143: getfield 78	org/java_websocket/client/WebSocketClient:wrappedchannel	Ljava/nio/channels/ByteChannel;
    //   146: invokestatic 254	org/java_websocket/SocketChannelIOHelper:read	(Ljava/nio/ByteBuffer;Lorg/java_websocket/WebSocketImpl;Ljava/nio/channels/ByteChannel;)Z
    //   149: ifeq +117 -> 266
    //   152: aload_0
    //   153: getfield 74	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   156: aload_2
    //   157: invokevirtual 258	org/java_websocket/WebSocketImpl:decode	(Ljava/nio/ByteBuffer;)V
    //   160: aload_0
    //   161: getfield 78	org/java_websocket/client/WebSocketClient:wrappedchannel	Ljava/nio/channels/ByteChannel;
    //   164: instanceof 260
    //   167: ifeq -40 -> 127
    //   170: aload_0
    //   171: getfield 78	org/java_websocket/client/WebSocketClient:wrappedchannel	Ljava/nio/channels/ByteChannel;
    //   174: checkcast 260	org/java_websocket/WrappedByteChannel
    //   177: astore_3
    //   178: aload_3
    //   179: invokeinterface 263 1 0
    //   184: ifeq -57 -> 127
    //   187: aload_2
    //   188: aload_0
    //   189: getfield 74	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   192: aload_3
    //   193: invokestatic 267	org/java_websocket/SocketChannelIOHelper:readMore	(Ljava/nio/ByteBuffer;Lorg/java_websocket/WebSocketImpl;Lorg/java_websocket/WrappedByteChannel;)Z
    //   196: ifeq +89 -> 285
    //   199: aload_0
    //   200: getfield 74	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   203: aload_2
    //   204: invokevirtual 258	org/java_websocket/WebSocketImpl:decode	(Ljava/nio/ByteBuffer;)V
    //   207: goto -20 -> 187
    //   210: astore_2
    //   211: aload_0
    //   212: getfield 74	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   215: invokevirtual 270	org/java_websocket/WebSocketImpl:eot	()V
    //   218: return
    //   219: aload_0
    //   220: getfield 72	org/java_websocket/client/WebSocketClient:uri	Ljava/net/URI;
    //   223: invokevirtual 273	java/net/URI:getHost	()Ljava/lang/String;
    //   226: astore_2
    //   227: aload_0
    //   228: invokespecial 154	org/java_websocket/client/WebSocketClient:getPort	()I
    //   231: istore_1
    //   232: goto -201 -> 31
    //   235: astore_2
    //   236: aload_0
    //   237: aconst_null
    //   238: aload_2
    //   239: invokevirtual 142	org/java_websocket/client/WebSocketClient:onWebsocketError	(Lorg/java_websocket/WebSocket;Ljava/lang/Exception;)V
    //   242: return
    //   243: astore_2
    //   244: aload_0
    //   245: aload_0
    //   246: getfield 74	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   249: aload_2
    //   250: invokevirtual 142	org/java_websocket/client/WebSocketClient:onWebsocketError	(Lorg/java_websocket/WebSocket;Ljava/lang/Exception;)V
    //   253: aload_0
    //   254: getfield 74	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   257: iconst_m1
    //   258: aload_2
    //   259: invokevirtual 276	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   262: invokevirtual 279	org/java_websocket/WebSocketImpl:closeConnection	(ILjava/lang/String;)V
    //   265: return
    //   266: aload_0
    //   267: getfield 74	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   270: invokevirtual 270	org/java_websocket/WebSocketImpl:eot	()V
    //   273: goto -113 -> 160
    //   276: astore_2
    //   277: aload_0
    //   278: getfield 74	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   281: invokevirtual 270	org/java_websocket/WebSocketImpl:eot	()V
    //   284: return
    //   285: aload_0
    //   286: getfield 74	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   289: aload_2
    //   290: invokevirtual 258	org/java_websocket/WebSocketImpl:decode	(Ljava/nio/ByteBuffer;)V
    //   293: goto -166 -> 127
    //   296: astore_2
    //   297: aload_0
    //   298: aload_2
    //   299: invokevirtual 283	org/java_websocket/client/WebSocketClient:onError	(Ljava/lang/Exception;)V
    //   302: aload_0
    //   303: getfield 74	org/java_websocket/client/WebSocketClient:conn	Lorg/java_websocket/WebSocketImpl;
    //   306: sipush 1006
    //   309: aload_2
    //   310: invokevirtual 284	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   313: invokevirtual 279	org/java_websocket/WebSocketImpl:closeConnection	(ILjava/lang/String;)V
    //   316: return
    //
    // Exception table:
    //   from	to	target	type
    //   127	160	210	java/nio/channels/CancelledKeyException
    //   160	187	210	java/nio/channels/CancelledKeyException
    //   187	207	210	java/nio/channels/CancelledKeyException
    //   266	273	210	java/nio/channels/CancelledKeyException
    //   285	293	210	java/nio/channels/CancelledKeyException
    //   8	31	235	java/nio/channels/ClosedByInterruptException
    //   31	120	235	java/nio/channels/ClosedByInterruptException
    //   219	232	235	java/nio/channels/ClosedByInterruptException
    //   8	31	243	java/lang/Exception
    //   31	120	243	java/lang/Exception
    //   219	232	243	java/lang/Exception
    //   127	160	276	java/io/IOException
    //   160	187	276	java/io/IOException
    //   187	207	276	java/io/IOException
    //   266	273	276	java/io/IOException
    //   285	293	276	java/io/IOException
    //   127	160	296	java/lang/RuntimeException
    //   160	187	296	java/lang/RuntimeException
    //   187	207	296	java/lang/RuntimeException
    //   266	273	296	java/lang/RuntimeException
    //   285	293	296	java/lang/RuntimeException
  }

  private void sendHandshake()
    throws InvalidHandshakeException
  {
    Object localObject1 = this.uri.getPath();
    Object localObject3 = this.uri.getQuery();
    Object localObject2;
    int i;
    if ((localObject1 == null) || (((String)localObject1).length() == 0))
    {
      localObject1 = "/";
      localObject2 = localObject1;
      if (localObject3 != null)
        localObject2 = (String)localObject1 + "?" + (String)localObject3;
      i = getPort();
      localObject3 = new StringBuilder().append(this.uri.getHost());
      if (i == 80)
        break label221;
    }
    label221: for (localObject1 = ":" + i; ; localObject1 = "")
    {
      localObject3 = (String)localObject1;
      localObject1 = new HandshakeImpl1Client();
      ((HandshakeImpl1Client)localObject1).setResourceDescriptor((String)localObject2);
      ((HandshakeImpl1Client)localObject1).put("Host", (String)localObject3);
      if (this.headers == null)
        break label228;
      localObject2 = this.headers.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((HandshakeImpl1Client)localObject1).put((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
      }
      break;
    }
    label228: this.conn.startHandshake((ClientHandshakeBuilder)localObject1);
  }

  public void close()
  {
    if (this.writethread != null)
      this.conn.close(1000);
  }

  public void closeBlocking()
    throws InterruptedException
  {
    close();
    this.closeLatch.await();
  }

  public void connect()
  {
    if (this.writethread != null)
      throw new IllegalStateException("WebSocketClient objects are not reuseable");
    this.writethread = new Thread(this);
    this.writethread.start();
  }

  public boolean connectBlocking()
    throws InterruptedException
  {
    connect();
    this.connectLatch.await();
    return this.conn.isOpen();
  }

  public ByteChannel createProxyChannel(ByteChannel paramByteChannel)
  {
    Object localObject = paramByteChannel;
    if (this.proxyAddress != null)
      localObject = new DefaultClientProxyChannel(paramByteChannel);
    return (ByteChannel)localObject;
  }

  public WebSocket getConnection()
  {
    return this.conn;
  }

  public Draft getDraft()
  {
    return this.draft;
  }

  public InetSocketAddress getLocalSocketAddress(WebSocket paramWebSocket)
  {
    if (this.channel != null)
      return (InetSocketAddress)this.channel.socket().getLocalSocketAddress();
    return null;
  }

  public WebSocket.READYSTATE getReadyState()
  {
    return this.conn.getReadyState();
  }

  public InetSocketAddress getRemoteSocketAddress(WebSocket paramWebSocket)
  {
    if (this.channel != null)
      return (InetSocketAddress)this.channel.socket().getLocalSocketAddress();
    return null;
  }

  public URI getURI()
  {
    return this.uri;
  }

  public final WebSocketFactory getWebSocketFactory()
  {
    return this.wsfactory;
  }

  public abstract void onClose(int paramInt, String paramString, boolean paramBoolean);

  public void onCloseInitiated(int paramInt, String paramString)
  {
  }

  public void onClosing(int paramInt, String paramString, boolean paramBoolean)
  {
  }

  public abstract void onError(Exception paramException);

  public abstract void onMessage(String paramString);

  public void onMessage(ByteBuffer paramByteBuffer)
  {
  }

  public abstract void onOpen(ServerHandshake paramServerHandshake);

  public final void onWebsocketClose(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
  {
    this.connectLatch.countDown();
    this.closeLatch.countDown();
    if (this.readthread != null)
      this.readthread.interrupt();
    onClose(paramInt, paramString, paramBoolean);
  }

  public void onWebsocketCloseInitiated(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    onCloseInitiated(paramInt, paramString);
  }

  public void onWebsocketClosing(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
  {
    onClosing(paramInt, paramString, paramBoolean);
  }

  public final void onWebsocketError(WebSocket paramWebSocket, Exception paramException)
  {
    onError(paramException);
  }

  public final void onWebsocketMessage(WebSocket paramWebSocket, String paramString)
  {
    onMessage(paramString);
  }

  public final void onWebsocketMessage(WebSocket paramWebSocket, ByteBuffer paramByteBuffer)
  {
    onMessage(paramByteBuffer);
  }

  public final void onWebsocketOpen(WebSocket paramWebSocket, Handshakedata paramHandshakedata)
  {
    this.connectLatch.countDown();
    onOpen((ServerHandshake)paramHandshakedata);
  }

  public final void onWriteDemand(WebSocket paramWebSocket)
  {
  }

  public void run()
  {
    if (this.writethread == null)
      this.writethread = Thread.currentThread();
    interruptableRun();
    assert (!this.channel.isOpen());
  }

  public void send(String paramString)
    throws NotYetConnectedException
  {
    this.conn.send(paramString);
  }

  public void send(byte[] paramArrayOfByte)
    throws NotYetConnectedException
  {
    this.conn.send(paramArrayOfByte);
  }

  public void setProxy(InetSocketAddress paramInetSocketAddress)
  {
    this.proxyAddress = paramInetSocketAddress;
  }

  public final void setWebSocketFactory(WebSocketClientFactory paramWebSocketClientFactory)
  {
    this.wsfactory = paramWebSocketClientFactory;
  }

  public class DefaultClientProxyChannel extends AbstractClientProxyChannel
  {
    public DefaultClientProxyChannel(ByteChannel arg2)
    {
      super();
    }

    public String buildHandShake()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str = WebSocketClient.this.uri.getHost();
      localStringBuilder.append("CONNECT ");
      localStringBuilder.append(str);
      localStringBuilder.append(":");
      localStringBuilder.append(WebSocketClient.this.getPort());
      localStringBuilder.append(" HTTP/1.1\n");
      localStringBuilder.append("Host: ");
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
      return localStringBuilder.toString();
    }
  }

  public static abstract interface WebSocketClientFactory extends WebSocketFactory
  {
    public abstract ByteChannel wrapChannel(SocketChannel paramSocketChannel, SelectionKey paramSelectionKey, String paramString, int paramInt)
      throws IOException;
  }

  private class WebsocketWriteThread
    implements Runnable
  {
    private WebsocketWriteThread()
    {
    }

    public void run()
    {
      Thread.currentThread().setName("WebsocketWriteThread");
      try
      {
        while (!Thread.interrupted())
          SocketChannelIOHelper.writeBlocking(WebSocketClient.this.conn, WebSocketClient.this.wrappedchannel);
      }
      catch (IOException localIOException)
      {
        WebSocketClient.this.conn.eot();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     org.java_websocket.client.WebSocketClient
 * JD-Core Version:    0.6.0
 */
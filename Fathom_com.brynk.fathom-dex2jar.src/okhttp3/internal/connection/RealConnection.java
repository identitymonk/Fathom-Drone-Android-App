package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.Http1Codec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Connection.Builder;
import okhttp3.internal.http2.Http2Connection.Listener;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket.Streams;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

public final class RealConnection extends Http2Connection.Listener
  implements Connection
{
  public int allocationLimit = 1;
  public final List<Reference<StreamAllocation>> allocations = new ArrayList();
  private final ConnectionPool connectionPool;
  private Handshake handshake;
  private Http2Connection http2Connection;
  public long idleAtNanos = 9223372036854775807L;
  public boolean noNewStreams;
  private Protocol protocol;
  private Socket rawSocket;
  private final Route route;
  private BufferedSink sink;
  private Socket socket;
  private BufferedSource source;
  public int successCount;

  public RealConnection(ConnectionPool paramConnectionPool, Route paramRoute)
  {
    this.connectionPool = paramConnectionPool;
    this.route = paramRoute;
  }

  private void connectSocket(int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject1 = this.route.proxy();
    Object localObject2 = this.route.address();
    if ((((Proxy)localObject1).type() == Proxy.Type.DIRECT) || (((Proxy)localObject1).type() == Proxy.Type.HTTP))
      localObject1 = ((Address)localObject2).socketFactory().createSocket();
    while (true)
    {
      this.rawSocket = ((Socket)localObject1);
      this.rawSocket.setSoTimeout(paramInt2);
      try
      {
        Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), paramInt1);
        this.source = Okio.buffer(Okio.source(this.rawSocket));
        this.sink = Okio.buffer(Okio.sink(this.rawSocket));
        return;
        localObject1 = new Socket((Proxy)localObject1);
      }
      catch (ConnectException localConnectException)
      {
        localObject2 = new ConnectException("Failed to connect to " + this.route.socketAddress());
        ((ConnectException)localObject2).initCause(localConnectException);
      }
    }
    throw ((Throwable)localObject2);
  }

  private void connectTls(ConnectionSpecSelector paramConnectionSpecSelector)
    throws IOException
  {
    Address localAddress = this.route.address();
    Object localObject3 = localAddress.sslSocketFactory();
    Object localObject2 = null;
    Object localObject1 = null;
    Handshake localHandshake;
    try
    {
      localObject3 = (SSLSocket)((SSLSocketFactory)localObject3).createSocket(this.rawSocket, localAddress.url().host(), localAddress.url().port(), true);
      localObject1 = localObject3;
      localObject2 = localObject3;
      paramConnectionSpecSelector = paramConnectionSpecSelector.configureSecureSocket((SSLSocket)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      if (paramConnectionSpecSelector.supportsTlsExtensions())
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        Platform.get().configureTlsExtensions((SSLSocket)localObject3, localAddress.url().host(), localAddress.protocols());
      }
      localObject1 = localObject3;
      localObject2 = localObject3;
      ((SSLSocket)localObject3).startHandshake();
      localObject1 = localObject3;
      localObject2 = localObject3;
      localHandshake = Handshake.get(((SSLSocket)localObject3).getSession());
      localObject1 = localObject3;
      localObject2 = localObject3;
      if (!localAddress.hostnameVerifier().verify(localAddress.url().host(), ((SSLSocket)localObject3).getSession()))
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        paramConnectionSpecSelector = (X509Certificate)localHandshake.peerCertificates().get(0);
        localObject1 = localObject3;
        localObject2 = localObject3;
        throw new SSLPeerUnverifiedException("Hostname " + localAddress.url().host() + " not verified:\n    certificate: " + CertificatePinner.pin(paramConnectionSpecSelector) + "\n    DN: " + paramConnectionSpecSelector.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(paramConnectionSpecSelector));
      }
    }
    catch (java.lang.AssertionError paramConnectionSpecSelector)
    {
      localObject2 = localObject1;
      if (!Util.isAndroidGetsocknameError(paramConnectionSpecSelector))
        break label496;
      localObject2 = localObject1;
      throw new IOException(paramConnectionSpecSelector);
    }
    finally
    {
      if (localObject2 != null)
        Platform.get().afterHandshake(localObject2);
      if (0 == 0)
        Util.closeQuietly(localObject2);
    }
    localObject1 = localObject3;
    localObject2 = localObject3;
    localAddress.certificatePinner().check(localAddress.url().host(), localHandshake.peerCertificates());
    localObject1 = localObject3;
    localObject2 = localObject3;
    if (paramConnectionSpecSelector.supportsTlsExtensions())
    {
      localObject1 = localObject3;
      localObject2 = localObject3;
      paramConnectionSpecSelector = Platform.get().getSelectedProtocol((SSLSocket)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      this.socket = ((Socket)localObject3);
      localObject1 = localObject3;
      localObject2 = localObject3;
      this.source = Okio.buffer(Okio.source(this.socket));
      localObject1 = localObject3;
      localObject2 = localObject3;
      this.sink = Okio.buffer(Okio.sink(this.socket));
      localObject1 = localObject3;
      localObject2 = localObject3;
      this.handshake = localHandshake;
      if (paramConnectionSpecSelector == null)
        break label483;
      localObject1 = localObject3;
      localObject2 = localObject3;
    }
    for (paramConnectionSpecSelector = Protocol.get(paramConnectionSpecSelector); ; paramConnectionSpecSelector = Protocol.HTTP_1_1)
    {
      localObject1 = localObject3;
      localObject2 = localObject3;
      this.protocol = paramConnectionSpecSelector;
      if (localObject3 != null)
        Platform.get().afterHandshake((SSLSocket)localObject3);
      if (1 == 0)
        Util.closeQuietly((Socket)localObject3);
      return;
      paramConnectionSpecSelector = null;
      break;
      label483: localObject1 = localObject3;
      localObject2 = localObject3;
    }
    label496: localObject2 = localObject1;
    throw paramConnectionSpecSelector;
  }

  private void connectTunnel(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    Request localRequest = createTunnelRequest();
    HttpUrl localHttpUrl = localRequest.url();
    int i = 0;
    while (true)
    {
      i += 1;
      if (i > 21)
        throw new ProtocolException("Too many tunnel connections attempted: " + 21);
      connectSocket(paramInt1, paramInt2);
      localRequest = createTunnel(paramInt2, paramInt3, localRequest, localHttpUrl);
      if (localRequest == null)
        return;
      Util.closeQuietly(this.rawSocket);
      this.rawSocket = null;
      this.sink = null;
      this.source = null;
    }
  }

  private Request createTunnel(int paramInt1, int paramInt2, Request paramRequest, HttpUrl paramHttpUrl)
    throws IOException
  {
    Object localObject = null;
    String str = "CONNECT " + Util.hostHeader(paramHttpUrl, true) + " HTTP/1.1";
    Response localResponse;
    do
    {
      paramHttpUrl = new Http1Codec(null, null, this.source, this.sink);
      this.source.timeout().timeout(paramInt1, TimeUnit.MILLISECONDS);
      this.sink.timeout().timeout(paramInt2, TimeUnit.MILLISECONDS);
      paramHttpUrl.writeRequest(paramRequest.headers(), str);
      paramHttpUrl.finishRequest();
      localResponse = paramHttpUrl.readResponseHeaders(false).request(paramRequest).build();
      long l2 = HttpHeaders.contentLength(localResponse);
      long l1 = l2;
      if (l2 == -1L)
        l1 = 0L;
      paramRequest = paramHttpUrl.newFixedLengthSource(l1);
      Util.skipAll(paramRequest, 2147483647, TimeUnit.MILLISECONDS);
      paramRequest.close();
      switch (localResponse.code())
      {
      default:
        throw new IOException("Unexpected response code for CONNECT: " + localResponse.code());
      case 200:
        if (this.source.buffer().exhausted())
        {
          paramHttpUrl = localObject;
          if (this.sink.buffer().exhausted())
            break;
        }
        throw new IOException("TLS tunnel buffered too many bytes!");
      case 407:
        paramHttpUrl = this.route.address().proxyAuthenticator().authenticate(this.route, localResponse);
        if (paramHttpUrl == null)
          throw new IOException("Failed to authenticate with proxy");
        paramRequest = paramHttpUrl;
      }
    }
    while (!"close".equalsIgnoreCase(localResponse.header("Connection")));
    return paramHttpUrl;
  }

  private Request createTunnelRequest()
  {
    return new Request.Builder().url(this.route.address().url()).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
  }

  private void establishProtocol(ConnectionSpecSelector paramConnectionSpecSelector)
    throws IOException
  {
    if (this.route.address().sslSocketFactory() == null)
    {
      this.protocol = Protocol.HTTP_1_1;
      this.socket = this.rawSocket;
    }
    do
    {
      return;
      connectTls(paramConnectionSpecSelector);
    }
    while (this.protocol != Protocol.HTTP_2);
    this.socket.setSoTimeout(0);
    this.http2Connection = new Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).build();
    this.http2Connection.start();
  }

  public static RealConnection testConnection(ConnectionPool paramConnectionPool, Route paramRoute, Socket paramSocket, long paramLong)
  {
    paramConnectionPool = new RealConnection(paramConnectionPool, paramRoute);
    paramConnectionPool.socket = paramSocket;
    paramConnectionPool.idleAtNanos = paramLong;
    return paramConnectionPool;
  }

  public void cancel()
  {
    Util.closeQuietly(this.rawSocket);
  }

  public void connect(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (this.protocol != null)
      throw new IllegalStateException("already connected");
    Object localObject2 = null;
    Object localObject4 = this.route.address().connectionSpecs();
    ConnectionSpecSelector localConnectionSpecSelector = new ConnectionSpecSelector((List)localObject4);
    ??? = localObject2;
    if (this.route.address().sslSocketFactory() == null)
    {
      if (!((List)localObject4).contains(ConnectionSpec.CLEARTEXT))
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
      localObject4 = this.route.address().url().host();
      ??? = localObject2;
      if (!Platform.get().isCleartextTrafficPermitted((String)localObject4))
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + (String)localObject4 + " not permitted by network security policy"));
    }
    try
    {
      if (this.route.requiresTunnel())
      {
        connectTunnel(paramInt1, paramInt2, paramInt3);
        establishProtocol(localConnectionSpecSelector);
        if (this.http2Connection == null);
      }
    }
    catch (IOException localIOException)
    {
      synchronized (this.connectionPool)
      {
        while (true)
        {
          this.allocationLimit = this.http2Connection.maxConcurrentStreams();
          return;
          connectSocket(paramInt1, paramInt2);
          continue;
          localIOException = localIOException;
          Util.closeQuietly(this.socket);
          Util.closeQuietly(this.rawSocket);
          this.socket = null;
          this.rawSocket = null;
          this.source = null;
          this.sink = null;
          this.handshake = null;
          this.protocol = null;
          this.http2Connection = null;
          if (??? != null)
            break;
          localObject2 = new RouteException(localIOException);
          if (paramBoolean)
          {
            ??? = localObject2;
            if (localConnectionSpecSelector.connectionFailed(localIOException))
              continue;
          }
          throw ((Throwable)localObject2);
        }
        ((RouteException)???).addConnectException(localIOException);
        localObject2 = ???;
      }
    }
  }

  public Handshake handshake()
  {
    return this.handshake;
  }

  public boolean isEligible(Address paramAddress)
  {
    return (this.allocations.size() < this.allocationLimit) && (paramAddress.equals(route().address())) && (!this.noNewStreams);
  }

  public boolean isHealthy(boolean paramBoolean)
  {
    int j = 1;
    if ((this.socket.isClosed()) || (this.socket.isInputShutdown()) || (this.socket.isOutputShutdown()))
      j = 0;
    do
      while (true)
      {
        return j;
        if (this.http2Connection == null)
          break;
        if (this.http2Connection.isShutdown())
          return false;
      }
    while (!paramBoolean);
    try
    {
      int i = this.socket.getSoTimeout();
      try
      {
        this.socket.setSoTimeout(1);
        paramBoolean = this.source.exhausted();
        return !paramBoolean;
      }
      finally
      {
        this.socket.setSoTimeout(i);
      }
    }
    catch (IOException localIOException)
    {
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
    }
    return true;
  }

  public boolean isMultiplexed()
  {
    return this.http2Connection != null;
  }

  public HttpCodec newCodec(OkHttpClient paramOkHttpClient, StreamAllocation paramStreamAllocation)
    throws SocketException
  {
    if (this.http2Connection != null)
      return new Http2Codec(paramOkHttpClient, paramStreamAllocation, this.http2Connection);
    this.socket.setSoTimeout(paramOkHttpClient.readTimeoutMillis());
    this.source.timeout().timeout(paramOkHttpClient.readTimeoutMillis(), TimeUnit.MILLISECONDS);
    this.sink.timeout().timeout(paramOkHttpClient.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
    return new Http1Codec(paramOkHttpClient, paramStreamAllocation, this.source, this.sink);
  }

  public RealWebSocket.Streams newWebSocketStreams(StreamAllocation paramStreamAllocation)
  {
    return new RealWebSocket.Streams(true, this.source, this.sink, paramStreamAllocation)
    {
      public void close()
        throws IOException
      {
        this.val$streamAllocation.streamFinished(true, this.val$streamAllocation.codec());
      }
    };
  }

  public void onSettings(Http2Connection paramHttp2Connection)
  {
    synchronized (this.connectionPool)
    {
      this.allocationLimit = paramHttp2Connection.maxConcurrentStreams();
      return;
    }
  }

  public void onStream(Http2Stream paramHttp2Stream)
    throws IOException
  {
    paramHttp2Stream.close(ErrorCode.REFUSED_STREAM);
  }

  public Protocol protocol()
  {
    return this.protocol;
  }

  public Route route()
  {
    return this.route;
  }

  public Socket socket()
  {
    return this.socket;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Connection{").append(this.route.address().url().host()).append(":").append(this.route.address().url().port()).append(", proxy=").append(this.route.proxy()).append(" hostAddress=").append(this.route.socketAddress()).append(" cipherSuite=");
    if (this.handshake != null);
    for (Object localObject = this.handshake.cipherSuite(); ; localObject = "none")
      return localObject + " protocol=" + this.protocol + '}';
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.connection.RealConnection
 * JD-Core Version:    0.6.0
 */
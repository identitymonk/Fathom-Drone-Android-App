package okhttp3;

import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;

public class OkHttpClient
  implements Cloneable, Call.Factory, WebSocket.Factory
{
  static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS;
  static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList(new Protocol[] { Protocol.HTTP_2, Protocol.HTTP_1_1 });
  final Authenticator authenticator;
  final Cache cache;
  final CertificateChainCleaner certificateChainCleaner;
  final CertificatePinner certificatePinner;
  final int connectTimeout;
  final ConnectionPool connectionPool;
  final List<ConnectionSpec> connectionSpecs;
  final CookieJar cookieJar;
  final Dispatcher dispatcher;
  final Dns dns;
  final boolean followRedirects;
  final boolean followSslRedirects;
  final HostnameVerifier hostnameVerifier;
  final List<Interceptor> interceptors;
  final InternalCache internalCache;
  final List<Interceptor> networkInterceptors;
  final int pingInterval;
  final List<Protocol> protocols;
  final Proxy proxy;
  final Authenticator proxyAuthenticator;
  final ProxySelector proxySelector;
  final int readTimeout;
  final boolean retryOnConnectionFailure;
  final SocketFactory socketFactory;
  final SSLSocketFactory sslSocketFactory;
  final int writeTimeout;

  static
  {
    DEFAULT_CONNECTION_SPECS = Util.immutableList(new ConnectionSpec[] { ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT });
    Internal.instance = new Internal()
    {
      public void addLenient(Headers.Builder paramBuilder, String paramString)
      {
        paramBuilder.addLenient(paramString);
      }

      public void addLenient(Headers.Builder paramBuilder, String paramString1, String paramString2)
      {
        paramBuilder.addLenient(paramString1, paramString2);
      }

      public void apply(ConnectionSpec paramConnectionSpec, SSLSocket paramSSLSocket, boolean paramBoolean)
      {
        paramConnectionSpec.apply(paramSSLSocket, paramBoolean);
      }

      public int code(Response.Builder paramBuilder)
      {
        return paramBuilder.code;
      }

      public boolean connectionBecameIdle(ConnectionPool paramConnectionPool, RealConnection paramRealConnection)
      {
        return paramConnectionPool.connectionBecameIdle(paramRealConnection);
      }

      public Socket deduplicate(ConnectionPool paramConnectionPool, Address paramAddress, StreamAllocation paramStreamAllocation)
      {
        return paramConnectionPool.deduplicate(paramAddress, paramStreamAllocation);
      }

      public RealConnection get(ConnectionPool paramConnectionPool, Address paramAddress, StreamAllocation paramStreamAllocation)
      {
        return paramConnectionPool.get(paramAddress, paramStreamAllocation);
      }

      public HttpUrl getHttpUrlChecked(String paramString)
        throws MalformedURLException, UnknownHostException
      {
        return HttpUrl.getChecked(paramString);
      }

      public Call newWebSocketCall(OkHttpClient paramOkHttpClient, Request paramRequest)
      {
        return new RealCall(paramOkHttpClient, paramRequest, true);
      }

      public void put(ConnectionPool paramConnectionPool, RealConnection paramRealConnection)
      {
        paramConnectionPool.put(paramRealConnection);
      }

      public RouteDatabase routeDatabase(ConnectionPool paramConnectionPool)
      {
        return paramConnectionPool.routeDatabase;
      }

      public void setCache(OkHttpClient.Builder paramBuilder, InternalCache paramInternalCache)
      {
        paramBuilder.setInternalCache(paramInternalCache);
      }

      public StreamAllocation streamAllocation(Call paramCall)
      {
        return ((RealCall)paramCall).streamAllocation();
      }
    };
  }

  public OkHttpClient()
  {
    this(new Builder());
  }

  OkHttpClient(Builder paramBuilder)
  {
    this.dispatcher = paramBuilder.dispatcher;
    this.proxy = paramBuilder.proxy;
    this.protocols = paramBuilder.protocols;
    this.connectionSpecs = paramBuilder.connectionSpecs;
    this.interceptors = Util.immutableList(paramBuilder.interceptors);
    this.networkInterceptors = Util.immutableList(paramBuilder.networkInterceptors);
    this.proxySelector = paramBuilder.proxySelector;
    this.cookieJar = paramBuilder.cookieJar;
    this.cache = paramBuilder.cache;
    this.internalCache = paramBuilder.internalCache;
    this.socketFactory = paramBuilder.socketFactory;
    int i = 0;
    Object localObject = this.connectionSpecs.iterator();
    if (((Iterator)localObject).hasNext())
    {
      ConnectionSpec localConnectionSpec = (ConnectionSpec)((Iterator)localObject).next();
      if ((i != 0) || (localConnectionSpec.isTls()));
      for (i = 1; ; i = 0)
        break;
    }
    if ((paramBuilder.sslSocketFactory != null) || (i == 0))
      this.sslSocketFactory = paramBuilder.sslSocketFactory;
    for (this.certificateChainCleaner = paramBuilder.certificateChainCleaner; ; this.certificateChainCleaner = CertificateChainCleaner.get((X509TrustManager)localObject))
    {
      this.hostnameVerifier = paramBuilder.hostnameVerifier;
      this.certificatePinner = paramBuilder.certificatePinner.withCertificateChainCleaner(this.certificateChainCleaner);
      this.proxyAuthenticator = paramBuilder.proxyAuthenticator;
      this.authenticator = paramBuilder.authenticator;
      this.connectionPool = paramBuilder.connectionPool;
      this.dns = paramBuilder.dns;
      this.followSslRedirects = paramBuilder.followSslRedirects;
      this.followRedirects = paramBuilder.followRedirects;
      this.retryOnConnectionFailure = paramBuilder.retryOnConnectionFailure;
      this.connectTimeout = paramBuilder.connectTimeout;
      this.readTimeout = paramBuilder.readTimeout;
      this.writeTimeout = paramBuilder.writeTimeout;
      this.pingInterval = paramBuilder.pingInterval;
      return;
      localObject = systemDefaultTrustManager();
      this.sslSocketFactory = systemDefaultSslSocketFactory((X509TrustManager)localObject);
    }
  }

  private SSLSocketFactory systemDefaultSslSocketFactory(X509TrustManager paramX509TrustManager)
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localSSLContext.init(null, new TrustManager[] { paramX509TrustManager }, null);
      paramX509TrustManager = localSSLContext.getSocketFactory();
      return paramX509TrustManager;
    }
    catch (GeneralSecurityException paramX509TrustManager)
    {
    }
    throw new AssertionError();
  }

  private X509TrustManager systemDefaultTrustManager()
  {
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init((KeyStore)null);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      if ((localObject.length != 1) || (!(localObject[0] instanceof X509TrustManager)))
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(localObject));
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      throw new AssertionError();
    }
    X509TrustManager localX509TrustManager = (X509TrustManager)localGeneralSecurityException[0];
    return (X509TrustManager)localX509TrustManager;
  }

  public Authenticator authenticator()
  {
    return this.authenticator;
  }

  public Cache cache()
  {
    return this.cache;
  }

  public CertificatePinner certificatePinner()
  {
    return this.certificatePinner;
  }

  public int connectTimeoutMillis()
  {
    return this.connectTimeout;
  }

  public ConnectionPool connectionPool()
  {
    return this.connectionPool;
  }

  public List<ConnectionSpec> connectionSpecs()
  {
    return this.connectionSpecs;
  }

  public CookieJar cookieJar()
  {
    return this.cookieJar;
  }

  public Dispatcher dispatcher()
  {
    return this.dispatcher;
  }

  public Dns dns()
  {
    return this.dns;
  }

  public boolean followRedirects()
  {
    return this.followRedirects;
  }

  public boolean followSslRedirects()
  {
    return this.followSslRedirects;
  }

  public HostnameVerifier hostnameVerifier()
  {
    return this.hostnameVerifier;
  }

  public List<Interceptor> interceptors()
  {
    return this.interceptors;
  }

  InternalCache internalCache()
  {
    if (this.cache != null)
      return this.cache.internalCache;
    return this.internalCache;
  }

  public List<Interceptor> networkInterceptors()
  {
    return this.networkInterceptors;
  }

  public Builder newBuilder()
  {
    return new Builder(this);
  }

  public Call newCall(Request paramRequest)
  {
    return new RealCall(this, paramRequest, false);
  }

  public WebSocket newWebSocket(Request paramRequest, WebSocketListener paramWebSocketListener)
  {
    paramRequest = new RealWebSocket(paramRequest, paramWebSocketListener, new SecureRandom());
    paramRequest.connect(this);
    return paramRequest;
  }

  public int pingIntervalMillis()
  {
    return this.pingInterval;
  }

  public List<Protocol> protocols()
  {
    return this.protocols;
  }

  public Proxy proxy()
  {
    return this.proxy;
  }

  public Authenticator proxyAuthenticator()
  {
    return this.proxyAuthenticator;
  }

  public ProxySelector proxySelector()
  {
    return this.proxySelector;
  }

  public int readTimeoutMillis()
  {
    return this.readTimeout;
  }

  public boolean retryOnConnectionFailure()
  {
    return this.retryOnConnectionFailure;
  }

  public SocketFactory socketFactory()
  {
    return this.socketFactory;
  }

  public SSLSocketFactory sslSocketFactory()
  {
    return this.sslSocketFactory;
  }

  public int writeTimeoutMillis()
  {
    return this.writeTimeout;
  }

  public static final class Builder
  {
    Authenticator authenticator;
    Cache cache;
    CertificateChainCleaner certificateChainCleaner;
    CertificatePinner certificatePinner;
    int connectTimeout;
    ConnectionPool connectionPool;
    List<ConnectionSpec> connectionSpecs;
    CookieJar cookieJar;
    Dispatcher dispatcher;
    Dns dns;
    boolean followRedirects;
    boolean followSslRedirects;
    HostnameVerifier hostnameVerifier;
    final List<Interceptor> interceptors = new ArrayList();
    InternalCache internalCache;
    final List<Interceptor> networkInterceptors = new ArrayList();
    int pingInterval;
    List<Protocol> protocols;
    Proxy proxy;
    Authenticator proxyAuthenticator;
    ProxySelector proxySelector;
    int readTimeout;
    boolean retryOnConnectionFailure;
    SocketFactory socketFactory;
    SSLSocketFactory sslSocketFactory;
    int writeTimeout;

    public Builder()
    {
      this.dispatcher = new Dispatcher();
      this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
      this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
      this.proxySelector = ProxySelector.getDefault();
      this.cookieJar = CookieJar.NO_COOKIES;
      this.socketFactory = SocketFactory.getDefault();
      this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
      this.certificatePinner = CertificatePinner.DEFAULT;
      this.proxyAuthenticator = Authenticator.NONE;
      this.authenticator = Authenticator.NONE;
      this.connectionPool = new ConnectionPool();
      this.dns = Dns.SYSTEM;
      this.followSslRedirects = true;
      this.followRedirects = true;
      this.retryOnConnectionFailure = true;
      this.connectTimeout = 10000;
      this.readTimeout = 10000;
      this.writeTimeout = 10000;
      this.pingInterval = 0;
    }

    Builder(OkHttpClient paramOkHttpClient)
    {
      this.dispatcher = paramOkHttpClient.dispatcher;
      this.proxy = paramOkHttpClient.proxy;
      this.protocols = paramOkHttpClient.protocols;
      this.connectionSpecs = paramOkHttpClient.connectionSpecs;
      this.interceptors.addAll(paramOkHttpClient.interceptors);
      this.networkInterceptors.addAll(paramOkHttpClient.networkInterceptors);
      this.proxySelector = paramOkHttpClient.proxySelector;
      this.cookieJar = paramOkHttpClient.cookieJar;
      this.internalCache = paramOkHttpClient.internalCache;
      this.cache = paramOkHttpClient.cache;
      this.socketFactory = paramOkHttpClient.socketFactory;
      this.sslSocketFactory = paramOkHttpClient.sslSocketFactory;
      this.certificateChainCleaner = paramOkHttpClient.certificateChainCleaner;
      this.hostnameVerifier = paramOkHttpClient.hostnameVerifier;
      this.certificatePinner = paramOkHttpClient.certificatePinner;
      this.proxyAuthenticator = paramOkHttpClient.proxyAuthenticator;
      this.authenticator = paramOkHttpClient.authenticator;
      this.connectionPool = paramOkHttpClient.connectionPool;
      this.dns = paramOkHttpClient.dns;
      this.followSslRedirects = paramOkHttpClient.followSslRedirects;
      this.followRedirects = paramOkHttpClient.followRedirects;
      this.retryOnConnectionFailure = paramOkHttpClient.retryOnConnectionFailure;
      this.connectTimeout = paramOkHttpClient.connectTimeout;
      this.readTimeout = paramOkHttpClient.readTimeout;
      this.writeTimeout = paramOkHttpClient.writeTimeout;
      this.pingInterval = paramOkHttpClient.pingInterval;
    }

    private static int checkDuration(String paramString, long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong < 0L)
        throw new IllegalArgumentException(paramString + " < 0");
      if (paramTimeUnit == null)
        throw new NullPointerException("unit == null");
      long l = paramTimeUnit.toMillis(paramLong);
      if (l > 2147483647L)
        throw new IllegalArgumentException(paramString + " too large.");
      if ((l == 0L) && (paramLong > 0L))
        throw new IllegalArgumentException(paramString + " too small.");
      return (int)l;
    }

    public Builder addInterceptor(Interceptor paramInterceptor)
    {
      this.interceptors.add(paramInterceptor);
      return this;
    }

    public Builder addNetworkInterceptor(Interceptor paramInterceptor)
    {
      this.networkInterceptors.add(paramInterceptor);
      return this;
    }

    public Builder authenticator(Authenticator paramAuthenticator)
    {
      if (paramAuthenticator == null)
        throw new NullPointerException("authenticator == null");
      this.authenticator = paramAuthenticator;
      return this;
    }

    public OkHttpClient build()
    {
      return new OkHttpClient(this);
    }

    public Builder cache(Cache paramCache)
    {
      this.cache = paramCache;
      this.internalCache = null;
      return this;
    }

    public Builder certificatePinner(CertificatePinner paramCertificatePinner)
    {
      if (paramCertificatePinner == null)
        throw new NullPointerException("certificatePinner == null");
      this.certificatePinner = paramCertificatePinner;
      return this;
    }

    public Builder connectTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      this.connectTimeout = checkDuration("timeout", paramLong, paramTimeUnit);
      return this;
    }

    public Builder connectionPool(ConnectionPool paramConnectionPool)
    {
      if (paramConnectionPool == null)
        throw new NullPointerException("connectionPool == null");
      this.connectionPool = paramConnectionPool;
      return this;
    }

    public Builder connectionSpecs(List<ConnectionSpec> paramList)
    {
      this.connectionSpecs = Util.immutableList(paramList);
      return this;
    }

    public Builder cookieJar(CookieJar paramCookieJar)
    {
      if (paramCookieJar == null)
        throw new NullPointerException("cookieJar == null");
      this.cookieJar = paramCookieJar;
      return this;
    }

    public Builder dispatcher(Dispatcher paramDispatcher)
    {
      if (paramDispatcher == null)
        throw new IllegalArgumentException("dispatcher == null");
      this.dispatcher = paramDispatcher;
      return this;
    }

    public Builder dns(Dns paramDns)
    {
      if (paramDns == null)
        throw new NullPointerException("dns == null");
      this.dns = paramDns;
      return this;
    }

    public Builder followRedirects(boolean paramBoolean)
    {
      this.followRedirects = paramBoolean;
      return this;
    }

    public Builder followSslRedirects(boolean paramBoolean)
    {
      this.followSslRedirects = paramBoolean;
      return this;
    }

    public Builder hostnameVerifier(HostnameVerifier paramHostnameVerifier)
    {
      if (paramHostnameVerifier == null)
        throw new NullPointerException("hostnameVerifier == null");
      this.hostnameVerifier = paramHostnameVerifier;
      return this;
    }

    public List<Interceptor> interceptors()
    {
      return this.interceptors;
    }

    public List<Interceptor> networkInterceptors()
    {
      return this.networkInterceptors;
    }

    public Builder pingInterval(long paramLong, TimeUnit paramTimeUnit)
    {
      this.pingInterval = checkDuration("interval", paramLong, paramTimeUnit);
      return this;
    }

    public Builder protocols(List<Protocol> paramList)
    {
      paramList = new ArrayList(paramList);
      if (!paramList.contains(Protocol.HTTP_1_1))
        throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + paramList);
      if (paramList.contains(Protocol.HTTP_1_0))
        throw new IllegalArgumentException("protocols must not contain http/1.0: " + paramList);
      if (paramList.contains(null))
        throw new IllegalArgumentException("protocols must not contain null");
      if (paramList.contains(Protocol.SPDY_3))
        paramList.remove(Protocol.SPDY_3);
      this.protocols = Collections.unmodifiableList(paramList);
      return this;
    }

    public Builder proxy(Proxy paramProxy)
    {
      this.proxy = paramProxy;
      return this;
    }

    public Builder proxyAuthenticator(Authenticator paramAuthenticator)
    {
      if (paramAuthenticator == null)
        throw new NullPointerException("proxyAuthenticator == null");
      this.proxyAuthenticator = paramAuthenticator;
      return this;
    }

    public Builder proxySelector(ProxySelector paramProxySelector)
    {
      this.proxySelector = paramProxySelector;
      return this;
    }

    public Builder readTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      this.readTimeout = checkDuration("timeout", paramLong, paramTimeUnit);
      return this;
    }

    public Builder retryOnConnectionFailure(boolean paramBoolean)
    {
      this.retryOnConnectionFailure = paramBoolean;
      return this;
    }

    void setInternalCache(InternalCache paramInternalCache)
    {
      this.internalCache = paramInternalCache;
      this.cache = null;
    }

    public Builder socketFactory(SocketFactory paramSocketFactory)
    {
      if (paramSocketFactory == null)
        throw new NullPointerException("socketFactory == null");
      this.socketFactory = paramSocketFactory;
      return this;
    }

    public Builder sslSocketFactory(SSLSocketFactory paramSSLSocketFactory)
    {
      if (paramSSLSocketFactory == null)
        throw new NullPointerException("sslSocketFactory == null");
      X509TrustManager localX509TrustManager = Platform.get().trustManager(paramSSLSocketFactory);
      if (localX509TrustManager == null)
        throw new IllegalStateException("Unable to extract the trust manager on " + Platform.get() + ", sslSocketFactory is " + paramSSLSocketFactory.getClass());
      this.sslSocketFactory = paramSSLSocketFactory;
      this.certificateChainCleaner = CertificateChainCleaner.get(localX509TrustManager);
      return this;
    }

    public Builder sslSocketFactory(SSLSocketFactory paramSSLSocketFactory, X509TrustManager paramX509TrustManager)
    {
      if (paramSSLSocketFactory == null)
        throw new NullPointerException("sslSocketFactory == null");
      if (paramX509TrustManager == null)
        throw new NullPointerException("trustManager == null");
      this.sslSocketFactory = paramSSLSocketFactory;
      this.certificateChainCleaner = CertificateChainCleaner.get(paramX509TrustManager);
      return this;
    }

    public Builder writeTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      this.writeTimeout = checkDuration("timeout", paramLong, paramTimeUnit);
      return this;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.OkHttpClient
 * JD-Core Version:    0.6.0
 */
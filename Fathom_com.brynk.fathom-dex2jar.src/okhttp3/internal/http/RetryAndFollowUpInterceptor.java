package okhttp3.internal.http;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.connection.StreamAllocation;

public final class RetryAndFollowUpInterceptor
  implements Interceptor
{
  private static final int MAX_FOLLOW_UPS = 20;
  private Object callStackTrace;
  private volatile boolean canceled;
  private final OkHttpClient client;
  private final boolean forWebSocket;
  private StreamAllocation streamAllocation;

  public RetryAndFollowUpInterceptor(OkHttpClient paramOkHttpClient, boolean paramBoolean)
  {
    this.client = paramOkHttpClient;
    this.forWebSocket = paramBoolean;
  }

  private Address createAddress(HttpUrl paramHttpUrl)
  {
    SSLSocketFactory localSSLSocketFactory = null;
    HostnameVerifier localHostnameVerifier = null;
    CertificatePinner localCertificatePinner = null;
    if (paramHttpUrl.isHttps())
    {
      localSSLSocketFactory = this.client.sslSocketFactory();
      localHostnameVerifier = this.client.hostnameVerifier();
      localCertificatePinner = this.client.certificatePinner();
    }
    return new Address(paramHttpUrl.host(), paramHttpUrl.port(), this.client.dns(), this.client.socketFactory(), localSSLSocketFactory, localHostnameVerifier, localCertificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
  }

  private Request followUpRequest(Response paramResponse)
    throws IOException
  {
    if (paramResponse == null)
      throw new IllegalStateException();
    Object localObject1 = this.streamAllocation.connection();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((Connection)localObject1).route();
      int i = paramResponse.code();
      localObject2 = paramResponse.request().method();
      switch (i)
      {
      default:
      case 407:
      case 401:
      case 307:
      case 308:
      case 300:
      case 301:
      case 302:
      case 303:
      case 408:
      }
    }
    label407: 
    do
    {
      HttpUrl localHttpUrl;
      do
      {
        do
        {
          do
          {
            return null;
            localObject1 = null;
            break;
            if (localObject1 != null);
            for (localObject2 = ((Route)localObject1).proxy(); ((Proxy)localObject2).type() != Proxy.Type.HTTP; localObject2 = this.client.proxy())
              throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            return this.client.proxyAuthenticator().authenticate((Route)localObject1, paramResponse);
            return this.client.authenticator().authenticate((Route)localObject1, paramResponse);
          }
          while (((!((String)localObject2).equals("GET")) && (!((String)localObject2).equals("HEAD"))) || (!this.client.followRedirects()));
          localObject1 = paramResponse.header("Location");
        }
        while (localObject1 == null);
        localHttpUrl = paramResponse.request().url().resolve((String)localObject1);
      }
      while ((localHttpUrl == null) || ((!localHttpUrl.scheme().equals(paramResponse.request().url().scheme())) && (!this.client.followSslRedirects())));
      Request.Builder localBuilder = paramResponse.request().newBuilder();
      boolean bool;
      if (HttpMethod.permitsRequestBody((String)localObject2))
      {
        bool = HttpMethod.redirectsWithBody((String)localObject2);
        if (!HttpMethod.redirectsToGet((String)localObject2))
          break label407;
        localBuilder.method("GET", null);
        if (!bool)
        {
          localBuilder.removeHeader("Transfer-Encoding");
          localBuilder.removeHeader("Content-Length");
          localBuilder.removeHeader("Content-Type");
        }
      }
      if (!sameConnection(paramResponse, localHttpUrl))
        localBuilder.removeHeader("Authorization");
      return localBuilder.url(localHttpUrl).build();
      if (bool);
      for (localObject1 = paramResponse.request().body(); ; localObject1 = null)
      {
        localBuilder.method((String)localObject2, (RequestBody)localObject1);
        break;
      }
    }
    while ((paramResponse.request().body() instanceof UnrepeatableRequestBody));
    return (Request)(Request)paramResponse.request();
  }

  private boolean isRecoverable(IOException paramIOException, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramIOException instanceof ProtocolException));
    do
    {
      return false;
      if (!(paramIOException instanceof InterruptedIOException))
        continue;
      if (((paramIOException instanceof SocketTimeoutException)) && (!paramBoolean));
      for (paramBoolean = bool; ; paramBoolean = false)
        return paramBoolean;
    }
    while ((((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) || ((paramIOException instanceof SSLPeerUnverifiedException)));
    return true;
  }

  private boolean recover(IOException paramIOException, boolean paramBoolean, Request paramRequest)
  {
    this.streamAllocation.streamFailed(paramIOException);
    if (!this.client.retryOnConnectionFailure());
    do
      return false;
    while (((paramBoolean) && ((paramRequest.body() instanceof UnrepeatableRequestBody))) || (!isRecoverable(paramIOException, paramBoolean)) || (!this.streamAllocation.hasMoreRoutes()));
    return true;
  }

  private boolean sameConnection(Response paramResponse, HttpUrl paramHttpUrl)
  {
    paramResponse = paramResponse.request().url();
    return (paramResponse.host().equals(paramHttpUrl.host())) && (paramResponse.port() == paramHttpUrl.port()) && (paramResponse.scheme().equals(paramHttpUrl.scheme()));
  }

  public void cancel()
  {
    this.canceled = true;
    StreamAllocation localStreamAllocation = this.streamAllocation;
    if (localStreamAllocation != null)
      localStreamAllocation.cancel();
  }

  // ERROR //
  public Response intercept(okhttp3.Interceptor.Chain paramChain)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 281 1 0
    //   6: astore 4
    //   8: aload_0
    //   9: new 101	okhttp3/internal/connection/StreamAllocation
    //   12: dup
    //   13: aload_0
    //   14: getfield 25	okhttp3/internal/http/RetryAndFollowUpInterceptor:client	Lokhttp3/OkHttpClient;
    //   17: invokevirtual 285	okhttp3/OkHttpClient:connectionPool	()Lokhttp3/ConnectionPool;
    //   20: aload_0
    //   21: aload 4
    //   23: invokevirtual 179	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   26: invokespecial 287	okhttp3/internal/http/RetryAndFollowUpInterceptor:createAddress	(Lokhttp3/HttpUrl;)Lokhttp3/Address;
    //   29: aload_0
    //   30: getfield 289	okhttp3/internal/http/RetryAndFollowUpInterceptor:callStackTrace	Ljava/lang/Object;
    //   33: invokespecial 292	okhttp3/internal/connection/StreamAllocation:<init>	(Lokhttp3/ConnectionPool;Lokhttp3/Address;Ljava/lang/Object;)V
    //   36: putfield 99	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   39: iconst_0
    //   40: istore_2
    //   41: aconst_null
    //   42: astore 5
    //   44: aload_0
    //   45: getfield 272	okhttp3/internal/http/RetryAndFollowUpInterceptor:canceled	Z
    //   48: ifeq +21 -> 69
    //   51: aload_0
    //   52: getfield 99	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   55: invokevirtual 295	okhttp3/internal/connection/StreamAllocation:release	()V
    //   58: new 94	java/io/IOException
    //   61: dup
    //   62: ldc_w 297
    //   65: invokespecial 298	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   68: athrow
    //   69: aload_1
    //   70: checkcast 300	okhttp3/internal/http/RealInterceptorChain
    //   73: aload 4
    //   75: aload_0
    //   76: getfield 99	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   79: aconst_null
    //   80: aconst_null
    //   81: invokevirtual 304	okhttp3/internal/http/RealInterceptorChain:proceed	(Lokhttp3/Request;Lokhttp3/internal/connection/StreamAllocation;Lokhttp3/internal/http/HttpCodec;Lokhttp3/Connection;)Lokhttp3/Response;
    //   84: astore 6
    //   86: iconst_0
    //   87: ifeq +18 -> 105
    //   90: aload_0
    //   91: getfield 99	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   94: aconst_null
    //   95: invokevirtual 261	okhttp3/internal/connection/StreamAllocation:streamFailed	(Ljava/io/IOException;)V
    //   98: aload_0
    //   99: getfield 99	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   102: invokevirtual 295	okhttp3/internal/connection/StreamAllocation:release	()V
    //   105: aload 6
    //   107: astore 4
    //   109: aload 5
    //   111: ifnull +28 -> 139
    //   114: aload 6
    //   116: invokevirtual 307	okhttp3/Response:newBuilder	()Lokhttp3/Response$Builder;
    //   119: aload 5
    //   121: invokevirtual 307	okhttp3/Response:newBuilder	()Lokhttp3/Response$Builder;
    //   124: aconst_null
    //   125: invokevirtual 312	okhttp3/Response$Builder:body	(Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;
    //   128: invokevirtual 315	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   131: invokevirtual 319	okhttp3/Response$Builder:priorResponse	(Lokhttp3/Response;)Lokhttp3/Response$Builder;
    //   134: invokevirtual 315	okhttp3/Response$Builder:build	()Lokhttp3/Response;
    //   137: astore 4
    //   139: aload_0
    //   140: aload 4
    //   142: invokespecial 321	okhttp3/internal/http/RetryAndFollowUpInterceptor:followUpRequest	(Lokhttp3/Response;)Lokhttp3/Request;
    //   145: astore 6
    //   147: aload 6
    //   149: ifnonnull +141 -> 290
    //   152: aload_0
    //   153: getfield 27	okhttp3/internal/http/RetryAndFollowUpInterceptor:forWebSocket	Z
    //   156: ifne +10 -> 166
    //   159: aload_0
    //   160: getfield 99	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   163: invokevirtual 295	okhttp3/internal/connection/StreamAllocation:release	()V
    //   166: aload 4
    //   168: areturn
    //   169: astore 6
    //   171: aload_0
    //   172: aload 6
    //   174: invokevirtual 325	okhttp3/internal/connection/RouteException:getLastConnectException	()Ljava/io/IOException;
    //   177: iconst_0
    //   178: aload 4
    //   180: invokespecial 327	okhttp3/internal/http/RetryAndFollowUpInterceptor:recover	(Ljava/io/IOException;ZLokhttp3/Request;)Z
    //   183: ifne +31 -> 214
    //   186: aload 6
    //   188: invokevirtual 325	okhttp3/internal/connection/RouteException:getLastConnectException	()Ljava/io/IOException;
    //   191: athrow
    //   192: astore_1
    //   193: iconst_1
    //   194: ifeq +18 -> 212
    //   197: aload_0
    //   198: getfield 99	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   201: aconst_null
    //   202: invokevirtual 261	okhttp3/internal/connection/StreamAllocation:streamFailed	(Ljava/io/IOException;)V
    //   205: aload_0
    //   206: getfield 99	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   209: invokevirtual 295	okhttp3/internal/connection/StreamAllocation:release	()V
    //   212: aload_1
    //   213: athrow
    //   214: iconst_0
    //   215: ifeq -171 -> 44
    //   218: aload_0
    //   219: getfield 99	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   222: aconst_null
    //   223: invokevirtual 261	okhttp3/internal/connection/StreamAllocation:streamFailed	(Ljava/io/IOException;)V
    //   226: aload_0
    //   227: getfield 99	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   230: invokevirtual 295	okhttp3/internal/connection/StreamAllocation:release	()V
    //   233: goto -189 -> 44
    //   236: astore 6
    //   238: aload 6
    //   240: instanceof 329
    //   243: ifne +20 -> 263
    //   246: iconst_1
    //   247: istore_3
    //   248: aload_0
    //   249: aload 6
    //   251: iload_3
    //   252: aload 4
    //   254: invokespecial 327	okhttp3/internal/http/RetryAndFollowUpInterceptor:recover	(Ljava/io/IOException;ZLokhttp3/Request;)Z
    //   257: ifne +11 -> 268
    //   260: aload 6
    //   262: athrow
    //   263: iconst_0
    //   264: istore_3
    //   265: goto -17 -> 248
    //   268: iconst_0
    //   269: ifeq -225 -> 44
    //   272: aload_0
    //   273: getfield 99	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   276: aconst_null
    //   277: invokevirtual 261	okhttp3/internal/connection/StreamAllocation:streamFailed	(Ljava/io/IOException;)V
    //   280: aload_0
    //   281: getfield 99	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   284: invokevirtual 295	okhttp3/internal/connection/StreamAllocation:release	()V
    //   287: goto -243 -> 44
    //   290: aload 4
    //   292: invokevirtual 332	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   295: invokestatic 338	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   298: iload_2
    //   299: iconst_1
    //   300: iadd
    //   301: istore_2
    //   302: iload_2
    //   303: bipush 20
    //   305: if_icmple +38 -> 343
    //   308: aload_0
    //   309: getfield 99	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   312: invokevirtual 295	okhttp3/internal/connection/StreamAllocation:release	()V
    //   315: new 142	java/net/ProtocolException
    //   318: dup
    //   319: new 340	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 341	java/lang/StringBuilder:<init>	()V
    //   326: ldc_w 343
    //   329: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: iload_2
    //   333: invokevirtual 350	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   336: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokespecial 147	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   342: athrow
    //   343: aload 6
    //   345: invokevirtual 236	okhttp3/Request:body	()Lokhttp3/RequestBody;
    //   348: instanceof 238
    //   351: ifeq +26 -> 377
    //   354: aload_0
    //   355: getfield 99	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   358: invokevirtual 295	okhttp3/internal/connection/StreamAllocation:release	()V
    //   361: new 355	java/net/HttpRetryException
    //   364: dup
    //   365: ldc_w 357
    //   368: aload 4
    //   370: invokevirtual 116	okhttp3/Response:code	()I
    //   373: invokespecial 360	java/net/HttpRetryException:<init>	(Ljava/lang/String;I)V
    //   376: athrow
    //   377: aload_0
    //   378: aload 4
    //   380: aload 6
    //   382: invokevirtual 179	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   385: invokespecial 224	okhttp3/internal/http/RetryAndFollowUpInterceptor:sameConnection	(Lokhttp3/Response;Lokhttp3/HttpUrl;)Z
    //   388: ifne +52 -> 440
    //   391: aload_0
    //   392: getfield 99	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   395: invokevirtual 295	okhttp3/internal/connection/StreamAllocation:release	()V
    //   398: aload_0
    //   399: new 101	okhttp3/internal/connection/StreamAllocation
    //   402: dup
    //   403: aload_0
    //   404: getfield 25	okhttp3/internal/http/RetryAndFollowUpInterceptor:client	Lokhttp3/OkHttpClient;
    //   407: invokevirtual 285	okhttp3/OkHttpClient:connectionPool	()Lokhttp3/ConnectionPool;
    //   410: aload_0
    //   411: aload 6
    //   413: invokevirtual 179	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   416: invokespecial 287	okhttp3/internal/http/RetryAndFollowUpInterceptor:createAddress	(Lokhttp3/HttpUrl;)Lokhttp3/Address;
    //   419: aload_0
    //   420: getfield 289	okhttp3/internal/http/RetryAndFollowUpInterceptor:callStackTrace	Ljava/lang/Object;
    //   423: invokespecial 292	okhttp3/internal/connection/StreamAllocation:<init>	(Lokhttp3/ConnectionPool;Lokhttp3/Address;Ljava/lang/Object;)V
    //   426: putfield 99	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   429: aload 4
    //   431: astore 5
    //   433: aload 6
    //   435: astore 4
    //   437: goto -393 -> 44
    //   440: aload_0
    //   441: getfield 99	okhttp3/internal/http/RetryAndFollowUpInterceptor:streamAllocation	Lokhttp3/internal/connection/StreamAllocation;
    //   444: invokevirtual 364	okhttp3/internal/connection/StreamAllocation:codec	()Lokhttp3/internal/http/HttpCodec;
    //   447: ifnull -18 -> 429
    //   450: new 96	java/lang/IllegalStateException
    //   453: dup
    //   454: new 340	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 341	java/lang/StringBuilder:<init>	()V
    //   461: ldc_w 366
    //   464: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload 4
    //   469: invokevirtual 369	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   472: ldc_w 371
    //   475: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokespecial 372	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   484: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   69	86	169	okhttp3/internal/connection/RouteException
    //   69	86	192	finally
    //   171	192	192	finally
    //   238	246	192	finally
    //   248	263	192	finally
    //   69	86	236	java/io/IOException
  }

  public boolean isCanceled()
  {
    return this.canceled;
  }

  public void setCallStackTrace(Object paramObject)
  {
    this.callStackTrace = paramObject;
  }

  public StreamAllocation streamAllocation()
  {
    return this.streamAllocation;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.http.RetryAndFollowUpInterceptor
 * JD-Core Version:    0.6.0
 */
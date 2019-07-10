package okhttp3.internal.huc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketPermission;
import java.net.URL;
import java.security.Permission;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Connection;
import okhttp3.Dispatcher;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.JavaNetHeaders;
import okhttp3.internal.URLFilter;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import okio.Timeout;

public final class OkHttpURLConnection extends HttpURLConnection
  implements Callback
{
  private static final Set<String> METHODS;
  public static final String RESPONSE_SOURCE;
  public static final String SELECTED_PROTOCOL = Platform.get().getPrefix() + "-Selected-Protocol";
  Call call;
  private Throwable callFailure;
  OkHttpClient client;
  boolean connectPending = true;
  private boolean executed;
  private long fixedContentLength = -1L;
  Handshake handshake;
  private final Object lock = new Object();
  private final NetworkInterceptor networkInterceptor = new NetworkInterceptor();
  Response networkResponse;
  Proxy proxy;
  private Headers.Builder requestHeaders = new Headers.Builder();
  private Response response;
  private Headers responseHeaders;
  URLFilter urlFilter;

  static
  {
    RESPONSE_SOURCE = Platform.get().getPrefix() + "-Response-Source";
    METHODS = new LinkedHashSet(Arrays.asList(new String[] { "OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE", "PATCH" }));
  }

  public OkHttpURLConnection(URL paramURL, OkHttpClient paramOkHttpClient)
  {
    super(paramURL);
    this.client = paramOkHttpClient;
  }

  public OkHttpURLConnection(URL paramURL, OkHttpClient paramOkHttpClient, URLFilter paramURLFilter)
  {
    this(paramURL, paramOkHttpClient);
    this.urlFilter = paramURLFilter;
  }

  private Call buildCall()
    throws IOException
  {
    int j = 1;
    if (this.call != null)
      return this.call;
    this.connected = true;
    int i;
    label129: long l;
    if (this.doOutput)
    {
      if (this.method.equals("GET"))
        this.method = "POST";
    }
    else
    {
      if (this.requestHeaders.get("User-Agent") == null)
        this.requestHeaders.add("User-Agent", defaultUserAgent());
      localObject = null;
      if (HttpMethod.permitsRequestBody(this.method))
      {
        if (this.requestHeaders.get("Content-Type") == null)
          this.requestHeaders.add("Content-Type", "application/x-www-form-urlencoded");
        i = j;
        if (this.fixedContentLength == -1L)
        {
          if (this.chunkLength <= 0)
            break label422;
          i = j;
        }
        l = -1L;
        localObject = this.requestHeaders.get("Content-Length");
        if (this.fixedContentLength == -1L)
          break label427;
        l = this.fixedContentLength;
        label160: if (i == 0)
          break label441;
      }
    }
    label422: label427: label441: for (Object localObject = new StreamedRequestBody(l); ; localObject = new BufferedRequestBody(l))
    {
      ((OutputStreamRequestBody)localObject).timeout().timeout(this.client.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
      localObject = new Request.Builder().url(Internal.instance.getHttpUrlChecked(getURL().toString())).headers(this.requestHeaders.build()).method(this.method, (RequestBody)localObject).build();
      if (this.urlFilter != null)
        this.urlFilter.checkURLPermitted(((Request)localObject).url().url());
      OkHttpClient.Builder localBuilder = this.client.newBuilder();
      localBuilder.interceptors().clear();
      localBuilder.interceptors().add(UnexpectedException.INTERCEPTOR);
      localBuilder.networkInterceptors().clear();
      localBuilder.networkInterceptors().add(this.networkInterceptor);
      localBuilder.dispatcher(new Dispatcher(this.client.dispatcher().executorService()));
      if (!getUseCaches())
        localBuilder.cache(null);
      localObject = localBuilder.build().newCall((Request)localObject);
      this.call = ((Call)localObject);
      return localObject;
      if (HttpMethod.permitsRequestBody(this.method))
        break;
      throw new ProtocolException(this.method + " does not support writing");
      i = 0;
      break label129;
      if (localObject == null)
        break label160;
      l = Long.parseLong((String)localObject);
      break label160;
    }
  }

  private String defaultUserAgent()
  {
    String str = System.getProperty("http.agent");
    if (str != null)
      return Util.toHumanReadableAscii(str);
    return Version.userAgent();
  }

  private Headers getHeaders()
    throws IOException
  {
    if (this.responseHeaders == null)
    {
      Response localResponse = getResponse(true);
      this.responseHeaders = localResponse.headers().newBuilder().add(SELECTED_PROTOCOL, localResponse.protocol().toString()).add(RESPONSE_SOURCE, responseSourceHeader(localResponse)).build();
    }
    return this.responseHeaders;
  }

  private Response getResponse(boolean paramBoolean)
    throws IOException
  {
    synchronized (this.lock)
    {
      Response localResponse1;
      if (this.response != null)
      {
        localResponse1 = this.response;
        return localResponse1;
      }
      if (this.callFailure == null)
        break label63;
      if ((paramBoolean) && (this.networkResponse != null))
      {
        localResponse1 = this.networkResponse;
        return localResponse1;
      }
    }
    throw propagate(this.callFailure);
    label63: monitorexit;
    ??? = buildCall();
    this.networkInterceptor.proceed();
    OutputStreamRequestBody localOutputStreamRequestBody = (OutputStreamRequestBody)((Call)???).request().body();
    if (localOutputStreamRequestBody != null)
      localOutputStreamRequestBody.outputStream().close();
    if (this.executed)
    {
      synchronized (this.lock)
      {
        try
        {
          while ((this.response == null) && (this.callFailure == null))
            this.lock.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          throw new InterruptedIOException();
        }
      }
      monitorexit;
    }
    while (true)
    {
      synchronized (this.lock)
      {
        if (this.callFailure == null)
          break;
        throw propagate(this.callFailure);
      }
      this.executed = true;
      try
      {
        onResponse((Call)???, ((Call)???).execute());
      }
      catch (IOException localIOException)
      {
        onFailure((Call)???, localIOException);
      }
    }
    if (this.response != null)
    {
      Response localResponse2 = this.response;
      monitorexit;
      return localResponse2;
    }
    monitorexit;
    throw new AssertionError();
  }

  private static IOException propagate(Throwable paramThrowable)
    throws IOException
  {
    if ((paramThrowable instanceof IOException))
      throw ((IOException)paramThrowable);
    if ((paramThrowable instanceof Error))
      throw ((Error)paramThrowable);
    if ((paramThrowable instanceof RuntimeException))
      throw ((RuntimeException)paramThrowable);
    throw new AssertionError();
  }

  private static String responseSourceHeader(Response paramResponse)
  {
    if (paramResponse.networkResponse() == null)
    {
      if (paramResponse.cacheResponse() == null)
        return "NONE";
      return "CACHE " + paramResponse.code();
    }
    if (paramResponse.cacheResponse() == null)
      return "NETWORK " + paramResponse.code();
    return "CONDITIONAL_CACHE " + paramResponse.networkResponse().code();
  }

  public void addRequestProperty(String paramString1, String paramString2)
  {
    if (this.connected)
      throw new IllegalStateException("Cannot add request property after connection is made");
    if (paramString1 == null)
      throw new NullPointerException("field == null");
    if (paramString2 == null)
    {
      Platform.get().log(5, "Ignoring header " + paramString1 + " because its value was null.", null);
      return;
    }
    this.requestHeaders.add(paramString1, paramString2);
  }

  public void connect()
    throws IOException
  {
    if (this.executed)
      return;
    ??? = buildCall();
    this.executed = true;
    ((Call)???).enqueue(this);
    synchronized (this.lock)
    {
      try
      {
        while ((this.connectPending) && (this.response == null) && (this.callFailure == null))
          this.lock.wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new InterruptedIOException();
      }
    }
    if (this.callFailure != null)
      throw propagate(this.callFailure);
    monitorexit;
  }

  public void disconnect()
  {
    if (this.call == null)
      return;
    this.networkInterceptor.proceed();
    this.call.cancel();
  }

  public int getConnectTimeout()
  {
    return this.client.connectTimeoutMillis();
  }

  public InputStream getErrorStream()
  {
    Object localObject2 = null;
    try
    {
      Response localResponse = getResponse(true);
      Object localObject1 = localObject2;
      if (HttpHeaders.hasBody(localResponse))
      {
        localObject1 = localObject2;
        if (localResponse.code() >= 400)
          localObject1 = localResponse.body().byteStream();
      }
      return localObject1;
    }
    catch (IOException localIOException)
    {
    }
    return (InputStream)null;
  }

  public String getHeaderField(int paramInt)
  {
    try
    {
      Object localObject = getHeaders();
      if (paramInt >= 0)
      {
        if (paramInt >= ((Headers)localObject).size())
          return null;
        localObject = ((Headers)localObject).value(paramInt);
        return localObject;
      }
    }
    catch (IOException localIOException)
    {
    }
    return (String)null;
  }

  public String getHeaderField(String paramString)
  {
    if (paramString == null);
    try
    {
      return StatusLine.get(getResponse(true)).toString();
      paramString = getHeaders().get(paramString);
      return paramString;
    }
    catch (IOException paramString)
    {
    }
    return null;
  }

  public String getHeaderFieldKey(int paramInt)
  {
    try
    {
      Object localObject = getHeaders();
      if (paramInt >= 0)
      {
        if (paramInt >= ((Headers)localObject).size())
          return null;
        localObject = ((Headers)localObject).name(paramInt);
        return localObject;
      }
    }
    catch (IOException localIOException)
    {
    }
    return (String)null;
  }

  public Map<String, List<String>> getHeaderFields()
  {
    try
    {
      Map localMap = JavaNetHeaders.toMultimap(getHeaders(), StatusLine.get(getResponse(true)).toString());
      return localMap;
    }
    catch (IOException localIOException)
    {
    }
    return Collections.emptyMap();
  }

  public InputStream getInputStream()
    throws IOException
  {
    if (!this.doInput)
      throw new ProtocolException("This protocol does not support input");
    Response localResponse = getResponse(false);
    if (localResponse.code() >= 400)
      throw new FileNotFoundException(this.url.toString());
    return localResponse.body().byteStream();
  }

  public boolean getInstanceFollowRedirects()
  {
    return this.client.followRedirects();
  }

  public OutputStream getOutputStream()
    throws IOException
  {
    OutputStreamRequestBody localOutputStreamRequestBody = (OutputStreamRequestBody)buildCall().request().body();
    if (localOutputStreamRequestBody == null)
      throw new ProtocolException("method does not support a request body: " + this.method);
    if ((localOutputStreamRequestBody instanceof StreamedRequestBody))
    {
      connect();
      this.networkInterceptor.proceed();
    }
    if (localOutputStreamRequestBody.isClosed())
      throw new ProtocolException("cannot write request body after response has been read");
    return localOutputStreamRequestBody.outputStream();
  }

  public Permission getPermission()
    throws IOException
  {
    Object localObject = getURL();
    String str = ((URL)localObject).getHost();
    if (((URL)localObject).getPort() != -1);
    for (int i = ((URL)localObject).getPort(); ; i = HttpUrl.defaultPort(((URL)localObject).getProtocol()))
    {
      if (usingProxy())
      {
        localObject = (InetSocketAddress)this.client.proxy().address();
        str = ((InetSocketAddress)localObject).getHostName();
        i = ((InetSocketAddress)localObject).getPort();
      }
      return new SocketPermission(str + ":" + i, "connect, resolve");
    }
  }

  public int getReadTimeout()
  {
    return this.client.readTimeoutMillis();
  }

  public Map<String, List<String>> getRequestProperties()
  {
    if (this.connected)
      throw new IllegalStateException("Cannot access request header fields after connection is set");
    return JavaNetHeaders.toMultimap(this.requestHeaders.build(), null);
  }

  public String getRequestProperty(String paramString)
  {
    if (paramString == null)
      return null;
    return this.requestHeaders.get(paramString);
  }

  public int getResponseCode()
    throws IOException
  {
    return getResponse(true).code();
  }

  public String getResponseMessage()
    throws IOException
  {
    return getResponse(true).message();
  }

  public void onFailure(Call paramCall, IOException paramIOException)
  {
    Object localObject = this.lock;
    monitorenter;
    paramCall = paramIOException;
    try
    {
      if ((paramIOException instanceof UnexpectedException))
        paramCall = paramIOException.getCause();
      this.callFailure = paramCall;
      this.lock.notifyAll();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw paramCall;
  }

  public void onResponse(Call arg1, Response paramResponse)
  {
    synchronized (this.lock)
    {
      this.response = paramResponse;
      this.handshake = paramResponse.handshake();
      this.url = paramResponse.request().url().url();
      this.lock.notifyAll();
      return;
    }
  }

  public void setConnectTimeout(int paramInt)
  {
    this.client = this.client.newBuilder().connectTimeout(paramInt, TimeUnit.MILLISECONDS).build();
  }

  public void setFixedLengthStreamingMode(int paramInt)
  {
    setFixedLengthStreamingMode(paramInt);
  }

  public void setFixedLengthStreamingMode(long paramLong)
  {
    if (this.connected)
      throw new IllegalStateException("Already connected");
    if (this.chunkLength > 0)
      throw new IllegalStateException("Already in chunked mode");
    if (paramLong < 0L)
      throw new IllegalArgumentException("contentLength < 0");
    this.fixedContentLength = paramLong;
    this.fixedContentLength = (int)Math.min(paramLong, 2147483647L);
  }

  public void setIfModifiedSince(long paramLong)
  {
    super.setIfModifiedSince(paramLong);
    if (this.ifModifiedSince != 0L)
    {
      this.requestHeaders.set("If-Modified-Since", HttpDate.format(new Date(this.ifModifiedSince)));
      return;
    }
    this.requestHeaders.removeAll("If-Modified-Since");
  }

  public void setInstanceFollowRedirects(boolean paramBoolean)
  {
    this.client = this.client.newBuilder().followRedirects(paramBoolean).build();
  }

  public void setReadTimeout(int paramInt)
  {
    this.client = this.client.newBuilder().readTimeout(paramInt, TimeUnit.MILLISECONDS).build();
  }

  public void setRequestMethod(String paramString)
    throws ProtocolException
  {
    if (!METHODS.contains(paramString))
      throw new ProtocolException("Expected one of " + METHODS + " but was " + paramString);
    this.method = paramString;
  }

  public void setRequestProperty(String paramString1, String paramString2)
  {
    if (this.connected)
      throw new IllegalStateException("Cannot set request property after connection is made");
    if (paramString1 == null)
      throw new NullPointerException("field == null");
    if (paramString2 == null)
    {
      Platform.get().log(5, "Ignoring header " + paramString1 + " because its value was null.", null);
      return;
    }
    this.requestHeaders.set(paramString1, paramString2);
  }

  public boolean usingProxy()
  {
    if (this.proxy != null);
    Proxy localProxy;
    do
    {
      return true;
      localProxy = this.client.proxy();
    }
    while ((localProxy != null) && (localProxy.type() != Proxy.Type.DIRECT));
    return false;
  }

  final class NetworkInterceptor
    implements Interceptor
  {
    private boolean proceed;

    NetworkInterceptor()
    {
    }

    public Response intercept(Interceptor.Chain arg1)
      throws IOException
    {
      Request localRequest = ???.request();
      if (OkHttpURLConnection.this.urlFilter != null)
        OkHttpURLConnection.this.urlFilter.checkURLPermitted(localRequest.url().url());
      synchronized (OkHttpURLConnection.this.lock)
      {
        OkHttpURLConnection.this.connectPending = false;
        OkHttpURLConnection.this.proxy = ???.connection().route().proxy();
        OkHttpURLConnection.this.handshake = ???.connection().handshake();
        OkHttpURLConnection.this.lock.notifyAll();
        try
        {
          while (!this.proceed)
            OkHttpURLConnection.this.lock.wait();
        }
        catch (InterruptedException )
        {
          throw new InterruptedIOException();
        }
      }
      monitorexit;
      ??? = localRequest;
      if ((localRequest.body() instanceof OutputStreamRequestBody))
        ??? = ((OutputStreamRequestBody)localRequest.body()).prepareToSendRequest(localRequest);
      ??? = ???.proceed((Request)???);
      synchronized (OkHttpURLConnection.this.lock)
      {
        OkHttpURLConnection.this.networkResponse = ((Response)???);
        OkHttpURLConnection.access$102(OkHttpURLConnection.this, ((Response)???).request().url().url());
        return ???;
      }
    }

    public void proceed()
    {
      synchronized (OkHttpURLConnection.this.lock)
      {
        this.proceed = true;
        OkHttpURLConnection.this.lock.notifyAll();
        return;
      }
    }
  }

  static final class UnexpectedException extends IOException
  {
    static final Interceptor INTERCEPTOR = new Interceptor()
    {
      public Response intercept(Interceptor.Chain paramChain)
        throws IOException
      {
        try
        {
          paramChain = paramChain.proceed(paramChain.request());
          return paramChain;
        }
        catch (RuntimeException paramChain)
        {
          throw new OkHttpURLConnection.UnexpectedException(paramChain);
        }
        catch (Error paramChain)
        {
          label16: break label16;
        }
      }
    };

    public UnexpectedException(Throwable paramThrowable)
    {
      super();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.huc.OkHttpURLConnection
 * JD-Core Version:    0.6.0
 */
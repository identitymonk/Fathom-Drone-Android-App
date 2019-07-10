package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;

public final class Response
  implements Closeable
{
  final ResponseBody body;
  private volatile CacheControl cacheControl;
  final Response cacheResponse;
  final int code;
  final Handshake handshake;
  final Headers headers;
  final String message;
  final Response networkResponse;
  final Response priorResponse;
  final Protocol protocol;
  final long receivedResponseAtMillis;
  final Request request;
  final long sentRequestAtMillis;

  Response(Builder paramBuilder)
  {
    this.request = paramBuilder.request;
    this.protocol = paramBuilder.protocol;
    this.code = paramBuilder.code;
    this.message = paramBuilder.message;
    this.handshake = paramBuilder.handshake;
    this.headers = paramBuilder.headers.build();
    this.body = paramBuilder.body;
    this.networkResponse = paramBuilder.networkResponse;
    this.cacheResponse = paramBuilder.cacheResponse;
    this.priorResponse = paramBuilder.priorResponse;
    this.sentRequestAtMillis = paramBuilder.sentRequestAtMillis;
    this.receivedResponseAtMillis = paramBuilder.receivedResponseAtMillis;
  }

  public ResponseBody body()
  {
    return this.body;
  }

  public CacheControl cacheControl()
  {
    CacheControl localCacheControl = this.cacheControl;
    if (localCacheControl != null)
      return localCacheControl;
    localCacheControl = CacheControl.parse(this.headers);
    this.cacheControl = localCacheControl;
    return localCacheControl;
  }

  public Response cacheResponse()
  {
    return this.cacheResponse;
  }

  public List<Challenge> challenges()
  {
    if (this.code == 401);
    for (String str = "WWW-Authenticate"; ; str = "Proxy-Authenticate")
    {
      return HttpHeaders.parseChallenges(headers(), str);
      if (this.code != 407)
        break;
    }
    return Collections.emptyList();
  }

  public void close()
  {
    this.body.close();
  }

  public int code()
  {
    return this.code;
  }

  public Handshake handshake()
  {
    return this.handshake;
  }

  public String header(String paramString)
  {
    return header(paramString, null);
  }

  public String header(String paramString1, String paramString2)
  {
    paramString1 = this.headers.get(paramString1);
    if (paramString1 != null)
      return paramString1;
    return paramString2;
  }

  public List<String> headers(String paramString)
  {
    return this.headers.values(paramString);
  }

  public Headers headers()
  {
    return this.headers;
  }

  public boolean isRedirect()
  {
    switch (this.code)
    {
    case 304:
    case 305:
    case 306:
    default:
      return false;
    case 300:
    case 301:
    case 302:
    case 303:
    case 307:
    case 308:
    }
    return true;
  }

  public boolean isSuccessful()
  {
    return (this.code >= 200) && (this.code < 300);
  }

  public String message()
  {
    return this.message;
  }

  public Response networkResponse()
  {
    return this.networkResponse;
  }

  public Builder newBuilder()
  {
    return new Builder(this);
  }

  public ResponseBody peekBody(long paramLong)
    throws IOException
  {
    Object localObject = this.body.source();
    ((BufferedSource)localObject).request(paramLong);
    localObject = ((BufferedSource)localObject).buffer().clone();
    if (((Buffer)localObject).size() > paramLong)
    {
      Buffer localBuffer = new Buffer();
      localBuffer.write((Buffer)localObject, paramLong);
      ((Buffer)localObject).clear();
      localObject = localBuffer;
    }
    while (true)
      return ResponseBody.create(this.body.contentType(), ((Buffer)localObject).size(), (BufferedSource)localObject);
  }

  public Response priorResponse()
  {
    return this.priorResponse;
  }

  public Protocol protocol()
  {
    return this.protocol;
  }

  public long receivedResponseAtMillis()
  {
    return this.receivedResponseAtMillis;
  }

  public Request request()
  {
    return this.request;
  }

  public long sentRequestAtMillis()
  {
    return this.sentRequestAtMillis;
  }

  public String toString()
  {
    return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
  }

  public static class Builder
  {
    ResponseBody body;
    Response cacheResponse;
    int code = -1;
    Handshake handshake;
    Headers.Builder headers;
    String message;
    Response networkResponse;
    Response priorResponse;
    Protocol protocol;
    long receivedResponseAtMillis;
    Request request;
    long sentRequestAtMillis;

    public Builder()
    {
      this.headers = new Headers.Builder();
    }

    Builder(Response paramResponse)
    {
      this.request = paramResponse.request;
      this.protocol = paramResponse.protocol;
      this.code = paramResponse.code;
      this.message = paramResponse.message;
      this.handshake = paramResponse.handshake;
      this.headers = paramResponse.headers.newBuilder();
      this.body = paramResponse.body;
      this.networkResponse = paramResponse.networkResponse;
      this.cacheResponse = paramResponse.cacheResponse;
      this.priorResponse = paramResponse.priorResponse;
      this.sentRequestAtMillis = paramResponse.sentRequestAtMillis;
      this.receivedResponseAtMillis = paramResponse.receivedResponseAtMillis;
    }

    private void checkPriorResponse(Response paramResponse)
    {
      if (paramResponse.body != null)
        throw new IllegalArgumentException("priorResponse.body != null");
    }

    private void checkSupportResponse(String paramString, Response paramResponse)
    {
      if (paramResponse.body != null)
        throw new IllegalArgumentException(paramString + ".body != null");
      if (paramResponse.networkResponse != null)
        throw new IllegalArgumentException(paramString + ".networkResponse != null");
      if (paramResponse.cacheResponse != null)
        throw new IllegalArgumentException(paramString + ".cacheResponse != null");
      if (paramResponse.priorResponse != null)
        throw new IllegalArgumentException(paramString + ".priorResponse != null");
    }

    public Builder addHeader(String paramString1, String paramString2)
    {
      this.headers.add(paramString1, paramString2);
      return this;
    }

    public Builder body(ResponseBody paramResponseBody)
    {
      this.body = paramResponseBody;
      return this;
    }

    public Response build()
    {
      if (this.request == null)
        throw new IllegalStateException("request == null");
      if (this.protocol == null)
        throw new IllegalStateException("protocol == null");
      if (this.code < 0)
        throw new IllegalStateException("code < 0: " + this.code);
      return new Response(this);
    }

    public Builder cacheResponse(Response paramResponse)
    {
      if (paramResponse != null)
        checkSupportResponse("cacheResponse", paramResponse);
      this.cacheResponse = paramResponse;
      return this;
    }

    public Builder code(int paramInt)
    {
      this.code = paramInt;
      return this;
    }

    public Builder handshake(Handshake paramHandshake)
    {
      this.handshake = paramHandshake;
      return this;
    }

    public Builder header(String paramString1, String paramString2)
    {
      this.headers.set(paramString1, paramString2);
      return this;
    }

    public Builder headers(Headers paramHeaders)
    {
      this.headers = paramHeaders.newBuilder();
      return this;
    }

    public Builder message(String paramString)
    {
      this.message = paramString;
      return this;
    }

    public Builder networkResponse(Response paramResponse)
    {
      if (paramResponse != null)
        checkSupportResponse("networkResponse", paramResponse);
      this.networkResponse = paramResponse;
      return this;
    }

    public Builder priorResponse(Response paramResponse)
    {
      if (paramResponse != null)
        checkPriorResponse(paramResponse);
      this.priorResponse = paramResponse;
      return this;
    }

    public Builder protocol(Protocol paramProtocol)
    {
      this.protocol = paramProtocol;
      return this;
    }

    public Builder receivedResponseAtMillis(long paramLong)
    {
      this.receivedResponseAtMillis = paramLong;
      return this;
    }

    public Builder removeHeader(String paramString)
    {
      this.headers.removeAll(paramString);
      return this;
    }

    public Builder request(Request paramRequest)
    {
      this.request = paramRequest;
      return this;
    }

    public Builder sentRequestAtMillis(long paramLong)
    {
      this.sentRequestAtMillis = paramLong;
      return this;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.Response
 * JD-Core Version:    0.6.0
 */
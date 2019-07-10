package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;

public final class CacheStrategy
{
  public final Response cacheResponse;
  public final Request networkRequest;

  CacheStrategy(Request paramRequest, Response paramResponse)
  {
    this.networkRequest = paramRequest;
    this.cacheResponse = paramResponse;
  }

  public static boolean isCacheable(Response paramResponse, Request paramRequest)
  {
    switch (paramResponse.code())
    {
    default:
    case 302:
    case 307:
    case 200:
    case 203:
    case 204:
    case 300:
    case 301:
    case 308:
    case 404:
    case 405:
    case 410:
    case 414:
    case 501:
    }
    do
      return false;
    while (((paramResponse.header("Expires") == null) && (paramResponse.cacheControl().maxAgeSeconds() == -1) && (!paramResponse.cacheControl().isPublic()) && (!paramResponse.cacheControl().isPrivate())) || (paramResponse.cacheControl().noStore()) || (paramRequest.cacheControl().noStore()));
    return true;
  }

  public static class Factory
  {
    private int ageSeconds = -1;
    final Response cacheResponse;
    private String etag;
    private Date expires;
    private Date lastModified;
    private String lastModifiedString;
    final long nowMillis;
    private long receivedResponseMillis;
    final Request request;
    private long sentRequestMillis;
    private Date servedDate;
    private String servedDateString;

    public Factory(long paramLong, Request paramRequest, Response paramResponse)
    {
      this.nowMillis = paramLong;
      this.request = paramRequest;
      this.cacheResponse = paramResponse;
      if (paramResponse != null)
      {
        this.sentRequestMillis = paramResponse.sentRequestAtMillis();
        this.receivedResponseMillis = paramResponse.receivedResponseAtMillis();
        paramRequest = paramResponse.headers();
        int i = 0;
        int j = paramRequest.size();
        if (i < j)
        {
          paramResponse = paramRequest.name(i);
          String str = paramRequest.value(i);
          if ("Date".equalsIgnoreCase(paramResponse))
          {
            this.servedDate = HttpDate.parse(str);
            this.servedDateString = str;
          }
          while (true)
          {
            i += 1;
            break;
            if ("Expires".equalsIgnoreCase(paramResponse))
            {
              this.expires = HttpDate.parse(str);
              continue;
            }
            if ("Last-Modified".equalsIgnoreCase(paramResponse))
            {
              this.lastModified = HttpDate.parse(str);
              this.lastModifiedString = str;
              continue;
            }
            if ("ETag".equalsIgnoreCase(paramResponse))
            {
              this.etag = str;
              continue;
            }
            if (!"Age".equalsIgnoreCase(paramResponse))
              continue;
            this.ageSeconds = HttpHeaders.parseSeconds(str, -1);
          }
        }
      }
    }

    private long cacheResponseAge()
    {
      long l = 0L;
      if (this.servedDate != null)
        l = Math.max(0L, this.receivedResponseMillis - this.servedDate.getTime());
      if (this.ageSeconds != -1)
        l = Math.max(l, TimeUnit.SECONDS.toMillis(this.ageSeconds));
      while (true)
        return l + (this.receivedResponseMillis - this.sentRequestMillis) + (this.nowMillis - this.receivedResponseMillis);
    }

    private long computeFreshnessLifetime()
    {
      long l2 = 0L;
      CacheControl localCacheControl = this.cacheResponse.cacheControl();
      long l1;
      if (localCacheControl.maxAgeSeconds() != -1)
        l1 = TimeUnit.SECONDS.toMillis(localCacheControl.maxAgeSeconds());
      label83: 
      do
      {
        do
        {
          return l1;
          if (this.expires != null)
          {
            if (this.servedDate != null)
            {
              l1 = this.servedDate.getTime();
              l1 = this.expires.getTime() - l1;
              if (l1 <= 0L)
                break label83;
            }
            while (true)
            {
              return l1;
              l1 = this.receivedResponseMillis;
              break;
              l1 = 0L;
            }
          }
          l1 = l2;
        }
        while (this.lastModified == null);
        l1 = l2;
      }
      while (this.cacheResponse.request().url().query() != null);
      if (this.servedDate != null)
        l1 = this.servedDate.getTime();
      while (true)
      {
        long l3 = l1 - this.lastModified.getTime();
        l1 = l2;
        if (l3 <= 0L)
          break;
        return l3 / 10L;
        l1 = this.sentRequestMillis;
      }
    }

    private CacheStrategy getCandidate()
    {
      if (this.cacheResponse == null)
        return new CacheStrategy(this.request, null);
      if ((this.request.isHttps()) && (this.cacheResponse.handshake() == null))
        return new CacheStrategy(this.request, null);
      if (!CacheStrategy.isCacheable(this.cacheResponse, this.request))
        return new CacheStrategy(this.request, null);
      Object localObject1 = this.request.cacheControl();
      if ((((CacheControl)localObject1).noCache()) || (hasConditions(this.request)))
        return new CacheStrategy(this.request, null);
      long l5 = cacheResponseAge();
      long l2 = computeFreshnessLifetime();
      long l1 = l2;
      if (((CacheControl)localObject1).maxAgeSeconds() != -1)
        l1 = Math.min(l2, TimeUnit.SECONDS.toMillis(((CacheControl)localObject1).maxAgeSeconds()));
      l2 = 0L;
      if (((CacheControl)localObject1).minFreshSeconds() != -1)
        l2 = TimeUnit.SECONDS.toMillis(((CacheControl)localObject1).minFreshSeconds());
      long l4 = 0L;
      Object localObject2 = this.cacheResponse.cacheControl();
      long l3 = l4;
      if (!((CacheControl)localObject2).mustRevalidate())
      {
        l3 = l4;
        if (((CacheControl)localObject1).maxStaleSeconds() != -1)
          l3 = TimeUnit.SECONDS.toMillis(((CacheControl)localObject1).maxStaleSeconds());
      }
      if ((!((CacheControl)localObject2).noCache()) && (l5 + l2 < l1 + l3))
      {
        localObject1 = this.cacheResponse.newBuilder();
        if (l5 + l2 >= l1)
          ((Response.Builder)localObject1).addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
        if ((l5 > 86400000L) && (isFreshnessLifetimeHeuristic()))
          ((Response.Builder)localObject1).addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
        return new CacheStrategy(null, ((Response.Builder)localObject1).build());
      }
      if (this.etag != null)
      {
        localObject1 = "If-None-Match";
        localObject2 = this.etag;
      }
      while (true)
      {
        Headers.Builder localBuilder = this.request.headers().newBuilder();
        Internal.instance.addLenient(localBuilder, (String)localObject1, (String)localObject2);
        return new CacheStrategy(this.request.newBuilder().headers(localBuilder.build()).build(), this.cacheResponse);
        if (this.lastModified != null)
        {
          localObject1 = "If-Modified-Since";
          localObject2 = this.lastModifiedString;
          continue;
        }
        if (this.servedDate == null)
          break;
        localObject1 = "If-Modified-Since";
        localObject2 = this.servedDateString;
      }
      return (CacheStrategy)(CacheStrategy)new CacheStrategy(this.request, null);
    }

    private static boolean hasConditions(Request paramRequest)
    {
      return (paramRequest.header("If-Modified-Since") != null) || (paramRequest.header("If-None-Match") != null);
    }

    private boolean isFreshnessLifetimeHeuristic()
    {
      return (this.cacheResponse.cacheControl().maxAgeSeconds() == -1) && (this.expires == null);
    }

    public CacheStrategy get()
    {
      CacheStrategy localCacheStrategy2 = getCandidate();
      CacheStrategy localCacheStrategy1 = localCacheStrategy2;
      if (localCacheStrategy2.networkRequest != null)
      {
        localCacheStrategy1 = localCacheStrategy2;
        if (this.request.cacheControl().onlyIfCached())
          localCacheStrategy1 = new CacheStrategy(null, null);
      }
      return localCacheStrategy1;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.cache.CacheStrategy
 * JD-Core Version:    0.6.0
 */
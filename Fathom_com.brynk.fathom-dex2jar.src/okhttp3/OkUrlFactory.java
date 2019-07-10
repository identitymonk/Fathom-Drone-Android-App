package okhttp3;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import okhttp3.internal.URLFilter;
import okhttp3.internal.huc.OkHttpURLConnection;
import okhttp3.internal.huc.OkHttpsURLConnection;

public final class OkUrlFactory
  implements URLStreamHandlerFactory, Cloneable
{
  private OkHttpClient client;
  private URLFilter urlFilter;

  public OkUrlFactory(OkHttpClient paramOkHttpClient)
  {
    this.client = paramOkHttpClient;
  }

  public OkHttpClient client()
  {
    return this.client;
  }

  public OkUrlFactory clone()
  {
    return new OkUrlFactory(this.client);
  }

  public URLStreamHandler createURLStreamHandler(String paramString)
  {
    if ((!paramString.equals("http")) && (!paramString.equals("https")))
      return null;
    return new URLStreamHandler(paramString)
    {
      protected int getDefaultPort()
      {
        if (this.val$protocol.equals("http"))
          return 80;
        if (this.val$protocol.equals("https"))
          return 443;
        throw new AssertionError();
      }

      protected URLConnection openConnection(URL paramURL)
      {
        return OkUrlFactory.this.open(paramURL);
      }

      protected URLConnection openConnection(URL paramURL, Proxy paramProxy)
      {
        return OkUrlFactory.this.open(paramURL, paramProxy);
      }
    };
  }

  public HttpURLConnection open(URL paramURL)
  {
    return open(paramURL, this.client.proxy());
  }

  HttpURLConnection open(URL paramURL, Proxy paramProxy)
  {
    String str = paramURL.getProtocol();
    paramProxy = this.client.newBuilder().proxy(paramProxy).build();
    if (str.equals("http"))
      return new OkHttpURLConnection(paramURL, paramProxy, this.urlFilter);
    if (str.equals("https"))
      return new OkHttpsURLConnection(paramURL, paramProxy, this.urlFilter);
    throw new IllegalArgumentException("Unexpected protocol: " + str);
  }

  public OkUrlFactory setClient(OkHttpClient paramOkHttpClient)
  {
    this.client = paramOkHttpClient;
    return this;
  }

  void setUrlFilter(URLFilter paramURLFilter)
  {
    this.urlFilter = paramURLFilter;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.OkUrlFactory
 * JD-Core Version:    0.6.0
 */
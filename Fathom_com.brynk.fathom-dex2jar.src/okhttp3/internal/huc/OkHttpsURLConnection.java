package okhttp3.internal.huc;

import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Handshake;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.internal.URLFilter;

public final class OkHttpsURLConnection extends DelegatingHttpsURLConnection
{
  private final OkHttpURLConnection delegate;

  public OkHttpsURLConnection(URL paramURL, OkHttpClient paramOkHttpClient)
  {
    this(new OkHttpURLConnection(paramURL, paramOkHttpClient));
  }

  public OkHttpsURLConnection(URL paramURL, OkHttpClient paramOkHttpClient, URLFilter paramURLFilter)
  {
    this(new OkHttpURLConnection(paramURL, paramOkHttpClient, paramURLFilter));
  }

  public OkHttpsURLConnection(OkHttpURLConnection paramOkHttpURLConnection)
  {
    super(paramOkHttpURLConnection);
    this.delegate = paramOkHttpURLConnection;
  }

  public HostnameVerifier getHostnameVerifier()
  {
    return this.delegate.client.hostnameVerifier();
  }

  public SSLSocketFactory getSSLSocketFactory()
  {
    return this.delegate.client.sslSocketFactory();
  }

  protected Handshake handshake()
  {
    if (this.delegate.call == null)
      throw new IllegalStateException("Connection has not yet been established");
    return this.delegate.handshake;
  }

  public void setHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    this.delegate.client = this.delegate.client.newBuilder().hostnameVerifier(paramHostnameVerifier).build();
  }

  public void setSSLSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    this.delegate.client = this.delegate.client.newBuilder().sslSocketFactory(paramSSLSocketFactory).build();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.huc.OkHttpsURLConnection
 * JD-Core Version:    0.6.0
 */
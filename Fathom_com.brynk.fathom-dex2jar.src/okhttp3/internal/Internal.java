package okhttp3.internal;

import java.net.MalformedURLException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Response.Builder;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;

public abstract class Internal
{
  public static Internal instance;

  public static void initializeInstanceForTests()
  {
    new OkHttpClient();
  }

  public abstract void addLenient(Headers.Builder paramBuilder, String paramString);

  public abstract void addLenient(Headers.Builder paramBuilder, String paramString1, String paramString2);

  public abstract void apply(ConnectionSpec paramConnectionSpec, SSLSocket paramSSLSocket, boolean paramBoolean);

  public abstract int code(Response.Builder paramBuilder);

  public abstract boolean connectionBecameIdle(ConnectionPool paramConnectionPool, RealConnection paramRealConnection);

  public abstract Socket deduplicate(ConnectionPool paramConnectionPool, Address paramAddress, StreamAllocation paramStreamAllocation);

  public abstract RealConnection get(ConnectionPool paramConnectionPool, Address paramAddress, StreamAllocation paramStreamAllocation);

  public abstract HttpUrl getHttpUrlChecked(String paramString)
    throws MalformedURLException, UnknownHostException;

  public abstract Call newWebSocketCall(OkHttpClient paramOkHttpClient, Request paramRequest);

  public abstract void put(ConnectionPool paramConnectionPool, RealConnection paramRealConnection);

  public abstract RouteDatabase routeDatabase(ConnectionPool paramConnectionPool);

  public abstract void setCache(OkHttpClient.Builder paramBuilder, InternalCache paramInternalCache);

  public abstract StreamAllocation streamAllocation(Call paramCall);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.Internal
 * JD-Core Version:    0.6.0
 */
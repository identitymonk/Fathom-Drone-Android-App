package com.facebook.react.modules.network;

import android.os.Build.VERSION;
import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.ConnectionSpec;
import okhttp3.ConnectionSpec.Builder;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.TlsVersion;

public class OkHttpClientProvider
{

  @Nullable
  private static OkHttpClient sClient;

  public static OkHttpClient createClient()
  {
    return enableTls12OnPreLollipop(new OkHttpClient.Builder().connectTimeout(0L, TimeUnit.MILLISECONDS).readTimeout(0L, TimeUnit.MILLISECONDS).writeTimeout(0L, TimeUnit.MILLISECONDS).cookieJar(new ReactCookieJarContainer())).build();
  }

  public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder paramBuilder)
  {
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT <= 19));
    try
    {
      paramBuilder.sslSocketFactory(new TLSSocketFactory());
      ConnectionSpec localConnectionSpec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_2 }).build();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localConnectionSpec);
      localArrayList.add(ConnectionSpec.COMPATIBLE_TLS);
      localArrayList.add(ConnectionSpec.CLEARTEXT);
      paramBuilder.connectionSpecs(localArrayList);
      return paramBuilder;
    }
    catch (Exception localException)
    {
      FLog.e("OkHttpClientProvider", "Error while enabling TLS 1.2", localException);
    }
    return paramBuilder;
  }

  public static OkHttpClient getOkHttpClient()
  {
    if (sClient == null)
      sClient = createClient();
    return sClient;
  }

  public static void replaceOkHttpClient(OkHttpClient paramOkHttpClient)
  {
    sClient = paramOkHttpClient;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.OkHttpClientProvider
 * JD-Core Version:    0.6.0
 */
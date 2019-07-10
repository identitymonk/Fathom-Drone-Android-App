package com.google.android.gms.search;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzxm;
import com.google.android.gms.internal.zzxn;

public class SearchAuth
{
  public static final Api<Api.ApiOptions.NoOptions> API;
  public static final SearchAuthApi SearchAuthApi;
  private static final Api.zza<zzxm, Api.ApiOptions.NoOptions> aCY = new Api.zza()
  {
    public zzxm zzv(Context paramContext, Looper paramLooper, zzf paramzzf, Api.ApiOptions.NoOptions paramNoOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return new zzxm(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzf);
    }
  };
  public static final Api.zzf<zzxm> hg = new Api.zzf();

  static
  {
    API = new Api("SearchAuth.API", aCY, hg);
    SearchAuthApi = new zzxn();
  }

  public static class StatusCodes
  {
    public static final int AUTH_DISABLED = 10000;
    public static final int AUTH_THROTTLED = 10001;
    public static final int DEVELOPER_ERROR = 10;
    public static final int INTERNAL_ERROR = 8;
    public static final int SUCCESS = 0;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.search.SearchAuth
 * JD-Core Version:    0.6.0
 */
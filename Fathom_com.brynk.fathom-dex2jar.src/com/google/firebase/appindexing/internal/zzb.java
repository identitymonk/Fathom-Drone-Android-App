package com.google.firebase.appindexing.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzj;

public class zzb extends zzj<zzf>
{
  static final Api<Api.ApiOptions.NoOptions> API;
  private static final Api.zzf<zzb> hg = new Api.zzf();
  private static final Api.zza<zzb, Api.ApiOptions.NoOptions> hh = new Api.zza()
  {
    public zzb zzw(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzf paramzzf, Api.ApiOptions.NoOptions paramNoOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return new zzb(paramContext, paramLooper, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    }
  };

  static
  {
    API = new Api("AppIndexing.API", hh, hg);
  }

  public zzb(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 113, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }

  protected String zzjx()
  {
    return "com.google.android.gms.icing.APP_INDEXING_SERVICE";
  }

  protected String zzjy()
  {
    return "com.google.firebase.appindexing.internal.IAppIndexingService";
  }

  protected zzf zzly(IBinder paramIBinder)
  {
    return zzf.zza.zzlz(paramIBinder);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.internal.zzb
 * JD-Core Version:    0.6.0
 */
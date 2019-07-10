package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzxm extends zzj<zzxl>
{
  public zzxm(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf)
  {
    super(paramContext, paramContext.getMainLooper(), 73, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }

  protected String zzjx()
  {
    return "com.google.android.gms.search.service.SEARCH_AUTH_START";
  }

  protected String zzjy()
  {
    return "com.google.android.gms.search.internal.ISearchAuthService";
  }

  protected zzxl zzku(IBinder paramIBinder)
  {
    return zzxl.zza.zzkt(paramIBinder);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzxm
 * JD-Core Version:    0.6.0
 */
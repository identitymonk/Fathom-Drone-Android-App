package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.signin.internal.zzg;

public final class zzxo
{
  public static final Api<zzxq> API;
  public static final Api<zza> Jb;
  public static final Api.zzf<zzg> aDi;
  static final Api.zza<zzg, zza> aDj;
  public static final Api.zzf<zzg> hg = new Api.zzf();
  public static final Api.zza<zzg, zzxq> hh;
  public static final Scope jn;
  public static final Scope jo;

  static
  {
    aDi = new Api.zzf();
    hh = new Api.zza()
    {
      public zzg zza(Context paramContext, Looper paramLooper, zzf paramzzf, zzxq paramzzxq, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
      {
        if (paramzzxq == null)
          paramzzxq = zzxq.aDl;
        while (true)
          return new zzg(paramContext, paramLooper, true, paramzzf, paramzzxq, paramConnectionCallbacks, paramOnConnectionFailedListener);
      }
    };
    aDj = new Api.zza()
    {
      public zzg zza(Context paramContext, Looper paramLooper, zzf paramzzf, zzxo.zza paramzza, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
      {
        return new zzg(paramContext, paramLooper, false, paramzzf, paramzza.zzcdb(), paramConnectionCallbacks, paramOnConnectionFailedListener);
      }
    };
    jn = new Scope("profile");
    jo = new Scope("email");
    API = new Api("SignIn.API", hh, hg);
    Jb = new Api("SignIn.INTERNAL_API", aDj, aDi);
  }

  public static class zza
    implements Api.ApiOptions.HasOptions
  {
    private final Bundle aDk;

    public Bundle zzcdb()
    {
      return this.aDk;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzxo
 * JD-Core Version:    0.6.0
 */
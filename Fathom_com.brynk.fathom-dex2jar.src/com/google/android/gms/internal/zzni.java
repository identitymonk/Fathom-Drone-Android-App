package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzni extends zzj<zznf>
{
  public zzni(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 19, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }

  public zznf zzaht()
    throws DeadObjectException
  {
    return (zznf)zzavg();
  }

  protected zznf zzbp(IBinder paramIBinder)
  {
    return zznf.zza.zzbn(paramIBinder);
  }

  protected String zzjx()
  {
    return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
  }

  protected String zzjy()
  {
    return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzni
 * JD-Core Version:    0.6.0
 */
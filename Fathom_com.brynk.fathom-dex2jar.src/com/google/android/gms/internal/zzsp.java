package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class zzsp
  implements zzso
{
  public PendingResult<Status> zzg(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.zzb(new zzsq.zza(paramGoogleApiClient)
    {
      protected void zza(zzsr paramzzsr)
        throws RemoteException
      {
        ((zzst)paramzzsr.zzavg()).zza(new zzsp.zza(this));
      }
    });
  }

  private static class zza extends zzsm
  {
    private final zzqo.zzb<Status> EW;

    public zza(zzqo.zzb<Status> paramzzb)
    {
      this.EW = paramzzb;
    }

    public void zzgv(int paramInt)
      throws RemoteException
    {
      this.EW.setResult(new Status(paramInt));
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzsp
 * JD-Core Version:    0.6.0
 */
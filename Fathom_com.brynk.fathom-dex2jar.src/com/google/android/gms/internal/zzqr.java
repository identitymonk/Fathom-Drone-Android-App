package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzaa;

public class zzqr
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  public final Api<?> vS;
  private final int yU;
  private zzqs yV;

  public zzqr(Api<?> paramApi, int paramInt)
  {
    this.vS = paramApi;
    this.yU = paramInt;
  }

  private void zzary()
  {
    zzaa.zzb(this.yV, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
  }

  public void onConnected(@Nullable Bundle paramBundle)
  {
    zzary();
    this.yV.onConnected(paramBundle);
  }

  public void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult)
  {
    zzary();
    this.yV.zza(paramConnectionResult, this.vS, this.yU);
  }

  public void onConnectionSuspended(int paramInt)
  {
    zzary();
    this.yV.onConnectionSuspended(paramInt);
  }

  public void zza(zzqs paramzzqs)
  {
    this.yV = paramzzqs;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzqr
 * JD-Core Version:    0.6.0
 */
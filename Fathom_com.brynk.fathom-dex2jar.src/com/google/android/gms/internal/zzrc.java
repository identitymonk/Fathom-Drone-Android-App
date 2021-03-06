package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import java.util.Collections;
import java.util.Queue;

public class zzrc
  implements zzre
{
  private final zzrf zA;

  public zzrc(zzrf paramzzrf)
  {
    this.zA = paramzzrf;
  }

  public void begin()
  {
    this.zA.zzate();
    this.zA.yW.Ak = Collections.emptySet();
  }

  public void connect()
  {
    this.zA.zzatc();
  }

  public boolean disconnect()
  {
    return true;
  }

  public void onConnected(Bundle paramBundle)
  {
  }

  public void onConnectionSuspended(int paramInt)
  {
  }

  public <A extends Api.zzb, R extends Result, T extends zzqo.zza<R, A>> T zza(T paramT)
  {
    this.zA.yW.Ad.add(paramT);
    return paramT;
  }

  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
  }

  public <A extends Api.zzb, T extends zzqo.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzrc
 * JD-Core Version:    0.6.0
 */
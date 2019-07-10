package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;

public abstract interface zzre
{
  public abstract void begin();

  public abstract void connect();

  public abstract boolean disconnect();

  public abstract void onConnected(Bundle paramBundle);

  public abstract void onConnectionSuspended(int paramInt);

  public abstract <A extends Api.zzb, R extends Result, T extends zzqo.zza<R, A>> T zza(T paramT);

  public abstract void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt);

  public abstract <A extends Api.zzb, T extends zzqo.zza<? extends Result, A>> T zzb(T paramT);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzre
 * JD-Core Version:    0.6.0
 */
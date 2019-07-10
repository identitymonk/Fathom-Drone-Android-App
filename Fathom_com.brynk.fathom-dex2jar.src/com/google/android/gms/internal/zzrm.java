package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public abstract interface zzrm
{
  public abstract ConnectionResult blockingConnect();

  public abstract ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit);

  public abstract void connect();

  public abstract void disconnect();

  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);

  @Nullable
  public abstract ConnectionResult getConnectionResult(@NonNull Api<?> paramApi);

  public abstract boolean isConnected();

  public abstract boolean isConnecting();

  public abstract <A extends Api.zzb, R extends Result, T extends zzqo.zza<R, A>> T zza(@NonNull T paramT);

  public abstract boolean zza(zzsa paramzzsa);

  public abstract void zzard();

  public abstract void zzarz();

  public abstract <A extends Api.zzb, T extends zzqo.zza<? extends Result, A>> T zzb(@NonNull T paramT);

  public static abstract interface zza
  {
    public abstract void zzc(int paramInt, boolean paramBoolean);

    public abstract void zzc(ConnectionResult paramConnectionResult);

    public abstract void zzn(Bundle paramBundle);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzrm
 * JD-Core Version:    0.6.0
 */
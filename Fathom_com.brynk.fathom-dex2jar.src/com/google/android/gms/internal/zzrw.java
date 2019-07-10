package com.google.android.gms.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzrw<A extends Api.zzb>
{
  private final zzrr<?> Bt;

  protected abstract void zza(A paramA, TaskCompletionSource<Void> paramTaskCompletionSource)
    throws DeadObjectException;

  public zzrr.zzb<?> zzatz()
  {
    return this.Bt.zzatz();
  }

  public void zzaua()
  {
    this.Bt.clear();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzrw
 * JD-Core Version:    0.6.0
 */
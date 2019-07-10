package com.google.android.gms.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzsh<A extends Api.zzb>
{
  private final zzrr.zzb<?> Bm;

  public zzrr.zzb<?> zzatz()
  {
    return this.Bm;
  }

  protected abstract void zzc(A paramA, TaskCompletionSource<Void> paramTaskCompletionSource)
    throws DeadObjectException;
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzsh
 * JD-Core Version:    0.6.0
 */
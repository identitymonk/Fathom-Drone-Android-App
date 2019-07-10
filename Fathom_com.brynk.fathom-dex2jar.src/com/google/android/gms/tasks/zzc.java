package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzc<TResult>
  implements zzf<TResult>
{
  private final Executor aEQ;
  private OnCompleteListener<TResult> aMK;
  private final Object zzako = new Object();

  public zzc(@NonNull Executor paramExecutor, @NonNull OnCompleteListener<TResult> paramOnCompleteListener)
  {
    this.aEQ = paramExecutor;
    this.aMK = paramOnCompleteListener;
  }

  public void cancel()
  {
    synchronized (this.zzako)
    {
      this.aMK = null;
      return;
    }
  }

  public void onComplete(@NonNull Task<TResult> paramTask)
  {
    synchronized (this.zzako)
    {
      if (this.aMK == null)
        return;
      this.aEQ.execute(new Runnable(paramTask)
      {
        public void run()
        {
          synchronized (zzc.zza(zzc.this))
          {
            if (zzc.zzb(zzc.this) != null)
              zzc.zzb(zzc.this).onComplete(this.aMH);
            return;
          }
        }
      });
      return;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzc
 * JD-Core Version:    0.6.0
 */
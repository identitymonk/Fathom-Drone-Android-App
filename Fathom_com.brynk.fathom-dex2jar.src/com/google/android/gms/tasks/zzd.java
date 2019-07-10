package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzd<TResult>
  implements zzf<TResult>
{
  private final Executor aEQ;
  private OnFailureListener aMM;
  private final Object zzako = new Object();

  public zzd(@NonNull Executor paramExecutor, @NonNull OnFailureListener paramOnFailureListener)
  {
    this.aEQ = paramExecutor;
    this.aMM = paramOnFailureListener;
  }

  public void cancel()
  {
    synchronized (this.zzako)
    {
      this.aMM = null;
      return;
    }
  }

  public void onComplete(@NonNull Task<TResult> paramTask)
  {
    if (!paramTask.isSuccessful())
      synchronized (this.zzako)
      {
        if (this.aMM == null)
          return;
        this.aEQ.execute(new Runnable(paramTask)
        {
          public void run()
          {
            synchronized (zzd.zza(zzd.this))
            {
              if (zzd.zzb(zzd.this) != null)
                zzd.zzb(zzd.this).onFailure(this.aMH.getException());
              return;
            }
          }
        });
        return;
      }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzd
 * JD-Core Version:    0.6.0
 */
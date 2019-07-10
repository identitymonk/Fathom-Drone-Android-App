package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zze<TResult>
  implements zzf<TResult>
{
  private final Executor aEQ;
  private OnSuccessListener<? super TResult> aMO;
  private final Object zzako = new Object();

  public zze(@NonNull Executor paramExecutor, @NonNull OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    this.aEQ = paramExecutor;
    this.aMO = paramOnSuccessListener;
  }

  public void cancel()
  {
    synchronized (this.zzako)
    {
      this.aMO = null;
      return;
    }
  }

  public void onComplete(@NonNull Task<TResult> paramTask)
  {
    if (paramTask.isSuccessful())
      synchronized (this.zzako)
      {
        if (this.aMO == null)
          return;
        this.aEQ.execute(new Runnable(paramTask)
        {
          public void run()
          {
            synchronized (zze.zza(zze.this))
            {
              if (zze.zzb(zze.this) != null)
                zze.zzb(zze.this).onSuccess(this.aMH.getResult());
              return;
            }
          }
        });
        return;
      }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zze
 * JD-Core Version:    0.6.0
 */
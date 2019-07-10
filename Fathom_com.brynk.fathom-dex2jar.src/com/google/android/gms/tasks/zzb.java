package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzb<TResult, TContinuationResult>
  implements OnFailureListener, OnSuccessListener<TContinuationResult>, zzf<TResult>
{
  private final Executor aEQ;
  private final Continuation<TResult, Task<TContinuationResult>> aMF;
  private final zzh<TContinuationResult> aMG;

  public zzb(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, Task<TContinuationResult>> paramContinuation, @NonNull zzh<TContinuationResult> paramzzh)
  {
    this.aEQ = paramExecutor;
    this.aMF = paramContinuation;
    this.aMG = paramzzh;
  }

  public void cancel()
  {
    throw new UnsupportedOperationException();
  }

  public void onComplete(@NonNull Task<TResult> paramTask)
  {
    this.aEQ.execute(new Runnable(paramTask)
    {
      public void run()
      {
        try
        {
          Task localTask = (Task)zzb.zza(zzb.this).then(this.aMH);
          if (localTask == null)
          {
            zzb.this.onFailure(new NullPointerException("Continuation returned null"));
            return;
          }
        }
        catch (RuntimeExecutionException localRuntimeExecutionException)
        {
          if ((localRuntimeExecutionException.getCause() instanceof Exception))
          {
            zzb.zzb(zzb.this).setException((Exception)localRuntimeExecutionException.getCause());
            return;
          }
          zzb.zzb(zzb.this).setException(localRuntimeExecutionException);
          return;
        }
        catch (Exception localException)
        {
          zzb.zzb(zzb.this).setException(localException);
          return;
        }
        localException.addOnSuccessListener(TaskExecutors.aMT, zzb.this);
        localException.addOnFailureListener(TaskExecutors.aMT, zzb.this);
      }
    });
  }

  public void onFailure(@NonNull Exception paramException)
  {
    this.aMG.setException(paramException);
  }

  public void onSuccess(TContinuationResult paramTContinuationResult)
  {
    this.aMG.setResult(paramTContinuationResult);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzb
 * JD-Core Version:    0.6.0
 */
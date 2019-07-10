package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zza<TResult, TContinuationResult>
  implements zzf<TResult>
{
  private final Executor aEQ;
  private final Continuation<TResult, TContinuationResult> aMF;
  private final zzh<TContinuationResult> aMG;

  public zza(@NonNull Executor paramExecutor, @NonNull Continuation<TResult, TContinuationResult> paramContinuation, @NonNull zzh<TContinuationResult> paramzzh)
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
          Object localObject = zza.zza(zza.this).then(this.aMH);
          zza.zzb(zza.this).setResult(localObject);
          return;
        }
        catch (RuntimeExecutionException localRuntimeExecutionException)
        {
          if ((localRuntimeExecutionException.getCause() instanceof Exception))
          {
            zza.zzb(zza.this).setException((Exception)localRuntimeExecutionException.getCause());
            return;
          }
          zza.zzb(zza.this).setException(localRuntimeExecutionException);
          return;
        }
        catch (Exception localException)
        {
          zza.zzb(zza.this).setException(localException);
        }
      }
    });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zza
 * JD-Core Version:    0.6.0
 */
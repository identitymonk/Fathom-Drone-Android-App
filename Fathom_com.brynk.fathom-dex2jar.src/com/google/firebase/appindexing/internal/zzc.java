package com.google.firebase.appindexing.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrl.zza;
import com.google.android.gms.internal.zzse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.appindexing.FirebaseAppIndex;
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.zza;
import java.util.concurrent.Executor;

public final class zzc extends FirebaseAppIndex
{
  private zzc aWC;

  public zzc(@NonNull Context paramContext)
  {
    this(paramContext, new zza(paramContext));
  }

  zzc(@NonNull Context paramContext, @NonNull com.google.android.gms.common.api.zzc<Api.ApiOptions.NoOptions> paramzzc)
  {
    this.aWC = new zzc(paramzzc);
  }

  public Task<Void> remove(String[] paramArrayOfString)
  {
    return this.aWC.zzb(new zzb(paramArrayOfString)
    {
      protected void zza(zzf paramzzf)
        throws RemoteException
      {
        paramzzf.zza(zzcom(), this.aWF);
      }
    });
  }

  public Task<Void> removeAll()
  {
    return this.aWC.zzb(new zzb()
    {
      protected void zza(zzf paramzzf)
        throws RemoteException
      {
        paramzzf.zze(zzcom());
      }
    });
  }

  public Task<Void> update(Indexable[] paramArrayOfIndexable)
  {
    if (paramArrayOfIndexable == null)
      return Tasks.forException(new NullPointerException("Indexables cannot be null."));
    Thing[] arrayOfThing = new Thing[paramArrayOfIndexable.length];
    try
    {
      System.arraycopy(paramArrayOfIndexable, 0, arrayOfThing, 0, paramArrayOfIndexable.length);
      return this.aWC.zzb(new zzb(arrayOfThing)
      {
        protected void zza(zzf paramzzf)
          throws RemoteException
        {
          paramzzf.zza(zzcom(), this.aWD);
        }
      });
    }
    catch (java.lang.ArrayStoreException paramArrayOfIndexable)
    {
    }
    return Tasks.forException(new FirebaseAppIndexingInvalidArgumentException("Custom Indexable-objects are not allowed. Please use the 'Indexables'-class for creating the objects."));
  }

  private static class zza extends com.google.android.gms.common.api.zzc<Api.ApiOptions.NoOptions>
  {
    public zza(Context paramContext)
    {
      super(zzb.API, null, Looper.getMainLooper(), new zza());
    }
  }

  private static abstract class zzb extends zzse<zzb, Status>
  {
    private TaskCompletionSource<Status> yg;

    protected final void zza(zzb paramzzb, TaskCompletionSource<Status> paramTaskCompletionSource)
      throws RemoteException
    {
      this.yg = paramTaskCompletionSource;
      zza((zzf)paramzzb.zzavg());
    }

    protected abstract void zza(zzf paramzzf)
      throws RemoteException;

    protected zzrl zzcom()
    {
      return new zzrl.zza()
      {
        public void zzp(Status paramStatus)
          throws RemoteException
        {
          zzc.zzb.zza(zzc.zzb.this).setResult(paramStatus);
        }
      };
    }
  }

  static class zzc
    implements OnCompleteListener<Void>, Executor
  {
    public static int MAX_RETRIES = 10;
    public static long aWH = 250L;
    public static double aWI = 1.5D;
    public static double aWJ = 0.25D;

    @NonNull
    private final com.google.android.gms.common.api.zzc<?> Bs;

    @Nullable
    private Task<Void> aWK = null;

    @NonNull
    private final Handler mHandler;

    public zzc(@NonNull com.google.android.gms.common.api.zzc<?> paramzzc)
    {
      this.Bs = paramzzc;
      this.mHandler = new Handler(paramzzc.getLooper());
    }

    private void zza(@NonNull zzc.zzb paramzzb, @NonNull TaskCompletionSource<Void> paramTaskCompletionSource, int paramInt)
    {
      this.Bs.doWrite(paramzzb).addOnCompleteListener(this, new OnCompleteListener(paramInt, paramzzb, paramTaskCompletionSource)
      {
        public void onComplete(@NonNull Task<Status> paramTask)
        {
          if ((this.aWL < zzc.zzc.MAX_RETRIES) && (zzc.zzc.zzd(paramTask)))
          {
            1 local1 = new Runnable()
            {
              public void run()
              {
                zzc.zzc.zza(zzc.zzc.this, zzc.zzc.1.this.aWM, zzc.zzc.1.this.zw, zzc.zzc.1.this.aWL + 1);
              }
            };
            long l = zzc.zzc.zzafa(this.aWL);
            if (zzc.zzc.zza(zzc.zzc.this).postDelayed(local1, l))
            {
              zzg.zzrr(47 + "Task will be retried in " + l + " ms");
              return;
            }
            zzg.zzrr("Failed to schedule retry -- failing immediately!");
          }
          if (paramTask.isSuccessful())
          {
            paramTask = (Status)paramTask.getResult();
            if (paramTask.isSuccess())
            {
              this.zw.setResult(null);
              return;
            }
            this.zw.setException(zzl.zzb(paramTask, "Indexing error, please try again."));
            return;
          }
          this.zw.setException(paramTask.getException());
        }
      });
    }

    static long zzafa(int paramInt)
    {
      return ()(aWH * Math.pow(aWI, paramInt) * ((Math.random() * 2.0D - 1.0D) * aWJ + 1.0D));
    }

    private static boolean zzc(@NonNull Task<Status> paramTask)
    {
      if (paramTask.isSuccessful())
        return zzd.zzafb(((Status)paramTask.getResult()).getStatusCode());
      return false;
    }

    public void execute(Runnable paramRunnable)
    {
      this.mHandler.post(paramRunnable);
    }

    public void onComplete(@NonNull Task<Void> paramTask)
    {
      monitorenter;
      try
      {
        if (paramTask == this.aWK)
          this.aWK = null;
        monitorexit;
        return;
      }
      finally
      {
        paramTask = finally;
        monitorexit;
      }
      throw paramTask;
    }

    public Task<Void> zzb(@NonNull zzc.zzb paramzzb)
    {
      TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
      Task localTask1 = localTaskCompletionSource.getTask();
      monitorenter;
      Task localTask2;
      try
      {
        localTask2 = this.aWK;
        this.aWK = localTask1;
        monitorexit;
        localTask1.addOnCompleteListener(this, this);
        if (localTask2 == null)
        {
          zza(paramzzb, localTaskCompletionSource, 0);
          return localTask1;
        }
      }
      finally
      {
        monitorexit;
      }
      localTask2.addOnCompleteListener(this, new OnCompleteListener(paramzzb, localTaskCompletionSource)
      {
        public void onComplete(@NonNull Task<Void> paramTask)
        {
          zzc.zzc.zza(zzc.zzc.this, this.aWM, this.zw, 0);
        }
      });
      return localTask1;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.internal.zzc
 * JD-Core Version:    0.6.0
 */
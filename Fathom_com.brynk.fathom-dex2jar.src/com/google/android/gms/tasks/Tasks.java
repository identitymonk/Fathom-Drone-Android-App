package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.tasks.Task<Ljava.lang.Void;>;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks
{
  public static <TResult> TResult await(@NonNull Task<TResult> paramTask)
    throws ExecutionException, InterruptedException
  {
    zzaa.zzawk();
    zzaa.zzb(paramTask, "Task must not be null");
    if (paramTask.isComplete())
      return zzb(paramTask);
    zza localzza = new zza(null);
    zza(paramTask, localzza);
    localzza.await();
    return zzb(paramTask);
  }

  public static <TResult> TResult await(@NonNull Task<TResult> paramTask, long paramLong, @NonNull TimeUnit paramTimeUnit)
    throws ExecutionException, InterruptedException, TimeoutException
  {
    zzaa.zzawk();
    zzaa.zzb(paramTask, "Task must not be null");
    zzaa.zzb(paramTimeUnit, "TimeUnit must not be null");
    if (paramTask.isComplete())
      return zzb(paramTask);
    zza localzza = new zza(null);
    zza(paramTask, localzza);
    if (!localzza.await(paramLong, paramTimeUnit))
      throw new TimeoutException("Timed out waiting for Task");
    return zzb(paramTask);
  }

  public static <TResult> Task<TResult> call(@NonNull Callable<TResult> paramCallable)
  {
    return call(TaskExecutors.MAIN_THREAD, paramCallable);
  }

  public static <TResult> Task<TResult> call(@NonNull Executor paramExecutor, @NonNull Callable<TResult> paramCallable)
  {
    zzaa.zzb(paramExecutor, "Executor must not be null");
    zzaa.zzb(paramCallable, "Callback must not be null");
    zzh localzzh = new zzh();
    paramExecutor.execute(new Runnable(localzzh, paramCallable)
    {
      public void run()
      {
        try
        {
          Tasks.this.setResult(this.zzcvh.call());
          return;
        }
        catch (Exception localException)
        {
          Tasks.this.setException(localException);
        }
      }
    });
    return localzzh;
  }

  public static <TResult> Task<TResult> forException(@NonNull Exception paramException)
  {
    zzh localzzh = new zzh();
    localzzh.setException(paramException);
    return localzzh;
  }

  public static <TResult> Task<TResult> forResult(TResult paramTResult)
  {
    zzh localzzh = new zzh();
    localzzh.setResult(paramTResult);
    return localzzh;
  }

  public static Task<Void> whenAll(Collection<? extends Task<?>> paramCollection)
  {
    if (paramCollection.isEmpty())
      return forResult(null);
    Object localObject = paramCollection.iterator();
    while (((Iterator)localObject).hasNext())
    {
      if ((Task)((Iterator)localObject).next() != null)
        continue;
      throw new NullPointerException("null tasks are not accepted");
    }
    localObject = new zzh();
    zzc localzzc = new zzc(paramCollection.size(), (zzh)localObject);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
      zza((Task)paramCollection.next(), localzzc);
    return (Task<Void>)localObject;
  }

  public static Task<Void> whenAll(Task<?>[] paramArrayOfTask)
  {
    if (paramArrayOfTask.length == 0)
      return forResult(null);
    return whenAll(Arrays.asList(paramArrayOfTask));
  }

  private static void zza(Task<?> paramTask, zzb paramzzb)
  {
    paramTask.addOnSuccessListener(TaskExecutors.aMT, paramzzb);
    paramTask.addOnFailureListener(TaskExecutors.aMT, paramzzb);
  }

  private static <TResult> TResult zzb(Task<TResult> paramTask)
    throws ExecutionException
  {
    if (paramTask.isSuccessful())
      return paramTask.getResult();
    throw new ExecutionException(paramTask.getException());
  }

  private static final class zza
    implements Tasks.zzb
  {
    private final CountDownLatch zzank = new CountDownLatch(1);

    public void await()
      throws InterruptedException
    {
      this.zzank.await();
    }

    public boolean await(long paramLong, TimeUnit paramTimeUnit)
      throws InterruptedException
    {
      return this.zzank.await(paramLong, paramTimeUnit);
    }

    public void onFailure(@NonNull Exception paramException)
    {
      this.zzank.countDown();
    }

    public void onSuccess(Object paramObject)
    {
      this.zzank.countDown();
    }
  }

  static abstract interface zzb extends OnFailureListener, OnSuccessListener<Object>
  {
  }

  private static final class zzc
    implements Tasks.zzb
  {
    private final zzh<Void> aMS;
    private Exception aMX;
    private final int aMZ;
    private int aNa;
    private int aNb;
    private final Object zzako = new Object();

    public zzc(int paramInt, zzh<Void> paramzzh)
    {
      this.aMZ = paramInt;
      this.aMS = paramzzh;
    }

    private void zzclj()
    {
      if (this.aNa + this.aNb == this.aMZ)
      {
        if (this.aMX == null)
          this.aMS.setResult(null);
      }
      else
        return;
      zzh localzzh = this.aMS;
      int i = this.aNb;
      int j = this.aMZ;
      localzzh.setException(new ExecutionException(54 + i + " out of " + j + " underlying tasks failed", this.aMX));
    }

    public void onFailure(@NonNull Exception paramException)
    {
      synchronized (this.zzako)
      {
        this.aNb += 1;
        this.aMX = paramException;
        zzclj();
        return;
      }
    }

    public void onSuccess(Object arg1)
    {
      synchronized (this.zzako)
      {
        this.aNa += 1;
        zzclj();
        return;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.Tasks
 * JD-Core Version:    0.6.0
 */
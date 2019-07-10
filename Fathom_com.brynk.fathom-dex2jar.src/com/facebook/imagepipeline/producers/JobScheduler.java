package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public class JobScheduler
{
  static final String QUEUE_TIME_KEY = "queueTime";
  private final Runnable mDoJobRunnable;

  @VisibleForTesting
  @GuardedBy("this")
  EncodedImage mEncodedImage;
  private final Executor mExecutor;

  @VisibleForTesting
  @GuardedBy("this")
  boolean mIsLast;
  private final JobRunnable mJobRunnable;

  @VisibleForTesting
  @GuardedBy("this")
  long mJobStartTime;

  @VisibleForTesting
  @GuardedBy("this")
  JobState mJobState;

  @VisibleForTesting
  @GuardedBy("this")
  long mJobSubmitTime;
  private final int mMinimumJobIntervalMs;
  private final Runnable mSubmitJobRunnable;

  public JobScheduler(Executor paramExecutor, JobRunnable paramJobRunnable, int paramInt)
  {
    this.mExecutor = paramExecutor;
    this.mJobRunnable = paramJobRunnable;
    this.mMinimumJobIntervalMs = paramInt;
    this.mDoJobRunnable = new Runnable()
    {
      public void run()
      {
        JobScheduler.this.doJob();
      }
    };
    this.mSubmitJobRunnable = new Runnable()
    {
      public void run()
      {
        JobScheduler.this.submitJob();
      }
    };
    this.mEncodedImage = null;
    this.mIsLast = false;
    this.mJobState = JobState.IDLE;
    this.mJobSubmitTime = 0L;
    this.mJobStartTime = 0L;
  }

  // ERROR //
  private void doJob()
  {
    // Byte code:
    //   0: invokestatic 92	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore_1
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 66	com/facebook/imagepipeline/producers/JobScheduler:mEncodedImage	Lcom/facebook/imagepipeline/image/EncodedImage;
    //   10: astore 4
    //   12: aload_0
    //   13: getfield 68	com/facebook/imagepipeline/producers/JobScheduler:mIsLast	Z
    //   16: istore_3
    //   17: aload_0
    //   18: aconst_null
    //   19: putfield 66	com/facebook/imagepipeline/producers/JobScheduler:mEncodedImage	Lcom/facebook/imagepipeline/image/EncodedImage;
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 68	com/facebook/imagepipeline/producers/JobScheduler:mIsLast	Z
    //   27: aload_0
    //   28: getstatic 95	com/facebook/imagepipeline/producers/JobScheduler$JobState:RUNNING	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   31: putfield 73	com/facebook/imagepipeline/producers/JobScheduler:mJobState	Lcom/facebook/imagepipeline/producers/JobScheduler$JobState;
    //   34: aload_0
    //   35: lload_1
    //   36: putfield 77	com/facebook/imagepipeline/producers/JobScheduler:mJobStartTime	J
    //   39: aload_0
    //   40: monitorexit
    //   41: aload 4
    //   43: iload_3
    //   44: invokestatic 99	com/facebook/imagepipeline/producers/JobScheduler:shouldProcess	(Lcom/facebook/imagepipeline/image/EncodedImage;Z)Z
    //   47: ifeq +15 -> 62
    //   50: aload_0
    //   51: getfield 54	com/facebook/imagepipeline/producers/JobScheduler:mJobRunnable	Lcom/facebook/imagepipeline/producers/JobScheduler$JobRunnable;
    //   54: aload 4
    //   56: iload_3
    //   57: invokeinterface 103 3 0
    //   62: aload 4
    //   64: invokestatic 109	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   67: aload_0
    //   68: invokespecial 112	com/facebook/imagepipeline/producers/JobScheduler:onJobFinished	()V
    //   71: return
    //   72: astore 4
    //   74: aload_0
    //   75: monitorexit
    //   76: aload 4
    //   78: athrow
    //   79: astore 5
    //   81: aload 4
    //   83: invokestatic 109	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   86: aload_0
    //   87: invokespecial 112	com/facebook/imagepipeline/producers/JobScheduler:onJobFinished	()V
    //   90: aload 5
    //   92: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   6	41	72	finally
    //   74	76	72	finally
    //   41	62	79	finally
  }

  private void enqueueJob(long paramLong)
  {
    if (paramLong > 0L)
    {
      JobStartExecutorSupplier.get().schedule(this.mSubmitJobRunnable, paramLong, TimeUnit.MILLISECONDS);
      return;
    }
    this.mSubmitJobRunnable.run();
  }

  private void onJobFinished()
  {
    long l2 = SystemClock.uptimeMillis();
    long l1 = 0L;
    int i = 0;
    monitorenter;
    try
    {
      if (this.mJobState == JobState.RUNNING_AND_PENDING)
      {
        l1 = Math.max(this.mJobStartTime + this.mMinimumJobIntervalMs, l2);
        i = 1;
        this.mJobSubmitTime = l2;
      }
      for (this.mJobState = JobState.QUEUED; ; this.mJobState = JobState.IDLE)
      {
        monitorexit;
        if (i != 0)
          enqueueJob(l1 - l2);
        return;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private static boolean shouldProcess(EncodedImage paramEncodedImage, boolean paramBoolean)
  {
    return (paramBoolean) || (EncodedImage.isValid(paramEncodedImage));
  }

  private void submitJob()
  {
    this.mExecutor.execute(this.mDoJobRunnable);
  }

  public void clearJob()
  {
    monitorenter;
    try
    {
      EncodedImage localEncodedImage = this.mEncodedImage;
      this.mEncodedImage = null;
      this.mIsLast = false;
      monitorexit;
      EncodedImage.closeSafely(localEncodedImage);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public long getQueuedTime()
  {
    monitorenter;
    try
    {
      long l1 = this.mJobStartTime;
      long l2 = this.mJobSubmitTime;
      monitorexit;
      return l1 - l2;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean scheduleJob()
  {
    long l3 = SystemClock.uptimeMillis();
    long l2 = 0L;
    int j = 0;
    monitorenter;
    while (true)
    {
      try
      {
        if (!shouldProcess(this.mEncodedImage, this.mIsLast))
          return false;
        i = j;
        l1 = l2;
        switch (3.$SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[this.mJobState.ordinal()])
        {
        case 2:
          monitorexit;
          if (i == 0)
            continue;
          enqueueJob(l1 - l3);
          return true;
        case 1:
          l1 = Math.max(this.mJobStartTime + this.mMinimumJobIntervalMs, l3);
          i = 1;
          this.mJobSubmitTime = l3;
          this.mJobState = JobState.QUEUED;
          continue;
        case 3:
        }
      }
      finally
      {
        monitorexit;
      }
      this.mJobState = JobState.RUNNING_AND_PENDING;
      int i = j;
      long l1 = l2;
      continue;
      i = j;
      l1 = l2;
    }
  }

  public boolean updateJob(EncodedImage paramEncodedImage, boolean paramBoolean)
  {
    if (!shouldProcess(paramEncodedImage, paramBoolean))
      return false;
    monitorenter;
    try
    {
      EncodedImage localEncodedImage = this.mEncodedImage;
      this.mEncodedImage = EncodedImage.cloneOrNull(paramEncodedImage);
      this.mIsLast = paramBoolean;
      monitorexit;
      EncodedImage.closeSafely(localEncodedImage);
      return true;
    }
    finally
    {
      monitorexit;
    }
    throw paramEncodedImage;
  }

  public static abstract interface JobRunnable
  {
    public abstract void run(EncodedImage paramEncodedImage, boolean paramBoolean);
  }

  @VisibleForTesting
  static class JobStartExecutorSupplier
  {
    private static ScheduledExecutorService sJobStarterExecutor;

    static ScheduledExecutorService get()
    {
      if (sJobStarterExecutor == null)
        sJobStarterExecutor = Executors.newSingleThreadScheduledExecutor();
      return sJobStarterExecutor;
    }
  }

  @VisibleForTesting
  static enum JobState
  {
    static
    {
      $VALUES = new JobState[] { IDLE, QUEUED, RUNNING, RUNNING_AND_PENDING };
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.JobScheduler
 * JD-Core Version:    0.6.0
 */
package com.facebook.imagepipeline.core;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DefaultExecutorSupplier
  implements ExecutorSupplier
{
  private static final int NUM_IO_BOUND_THREADS = 2;
  private static final int NUM_LIGHTWEIGHT_BACKGROUND_THREADS = 1;
  private final Executor mBackgroundExecutor;
  private final Executor mDecodeExecutor;
  private final Executor mIoBoundExecutor;
  private final Executor mLightWeightBackgroundExecutor;

  public DefaultExecutorSupplier(int paramInt)
  {
    PriorityThreadFactory localPriorityThreadFactory = new PriorityThreadFactory(10);
    this.mIoBoundExecutor = Executors.newFixedThreadPool(2);
    this.mDecodeExecutor = Executors.newFixedThreadPool(paramInt, localPriorityThreadFactory);
    this.mBackgroundExecutor = Executors.newFixedThreadPool(paramInt, localPriorityThreadFactory);
    this.mLightWeightBackgroundExecutor = Executors.newFixedThreadPool(1, localPriorityThreadFactory);
  }

  public Executor forBackgroundTasks()
  {
    return this.mBackgroundExecutor;
  }

  public Executor forDecode()
  {
    return this.mDecodeExecutor;
  }

  public Executor forLightweightBackgroundTasks()
  {
    return this.mLightWeightBackgroundExecutor;
  }

  public Executor forLocalStorageRead()
  {
    return this.mIoBoundExecutor;
  }

  public Executor forLocalStorageWrite()
  {
    return this.mIoBoundExecutor;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.core.DefaultExecutorSupplier
 * JD-Core Version:    0.6.0
 */
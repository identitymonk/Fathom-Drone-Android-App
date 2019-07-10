package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;

public class ThreadHandoffProducerQueue
{
  private final Executor mExecutor;
  private boolean mQueueing = false;
  private final Deque<Runnable> mRunnableList;

  public ThreadHandoffProducerQueue(Executor paramExecutor)
  {
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mRunnableList = new ArrayDeque();
  }

  private void execInQueue()
  {
    while (!this.mRunnableList.isEmpty())
      this.mExecutor.execute((Runnable)this.mRunnableList.pop());
    this.mRunnableList.clear();
  }

  public void addToQueueOrExecute(Runnable paramRunnable)
  {
    monitorenter;
    try
    {
      if (this.mQueueing)
        this.mRunnableList.add(paramRunnable);
      while (true)
      {
        return;
        this.mExecutor.execute(paramRunnable);
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramRunnable;
  }

  public boolean isQueueing()
  {
    monitorenter;
    try
    {
      boolean bool = this.mQueueing;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void remove(Runnable paramRunnable)
  {
    monitorenter;
    try
    {
      this.mRunnableList.remove(paramRunnable);
      monitorexit;
      return;
    }
    finally
    {
      paramRunnable = finally;
      monitorexit;
    }
    throw paramRunnable;
  }

  public void startQueueing()
  {
    monitorenter;
    try
    {
      this.mQueueing = true;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void stopQueuing()
  {
    monitorenter;
    try
    {
      this.mQueueing = false;
      execInQueue();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
 * JD-Core Version:    0.6.0
 */
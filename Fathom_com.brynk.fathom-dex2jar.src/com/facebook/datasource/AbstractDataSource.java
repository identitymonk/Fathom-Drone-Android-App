package com.facebook.datasource;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public abstract class AbstractDataSource<T>
  implements DataSource<T>
{

  @GuardedBy("this")
  private DataSourceStatus mDataSourceStatus = DataSourceStatus.IN_PROGRESS;

  @GuardedBy("this")
  private Throwable mFailureThrowable = null;

  @GuardedBy("this")
  private boolean mIsClosed = false;

  @GuardedBy("this")
  private float mProgress = 0.0F;

  @Nullable
  @GuardedBy("this")
  private T mResult = null;
  private final ConcurrentLinkedQueue<Pair<DataSubscriber<T>, Executor>> mSubscribers = new ConcurrentLinkedQueue();

  private void notifyDataSubscriber(DataSubscriber<T> paramDataSubscriber, Executor paramExecutor, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramExecutor.execute(new Runnable(paramBoolean1, paramDataSubscriber, paramBoolean2)
    {
      public void run()
      {
        if (this.val$isFailure)
        {
          this.val$dataSubscriber.onFailure(AbstractDataSource.this);
          return;
        }
        if (this.val$isCancellation)
        {
          this.val$dataSubscriber.onCancellation(AbstractDataSource.this);
          return;
        }
        this.val$dataSubscriber.onNewResult(AbstractDataSource.this);
      }
    });
  }

  private void notifyDataSubscribers()
  {
    boolean bool1 = hasFailed();
    boolean bool2 = wasCancelled();
    Iterator localIterator = this.mSubscribers.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      notifyDataSubscriber((DataSubscriber)localPair.first, (Executor)localPair.second, bool1, bool2);
    }
  }

  private boolean setFailureInternal(Throwable paramThrowable)
  {
    monitorenter;
    try
    {
      if (!this.mIsClosed)
      {
        DataSourceStatus localDataSourceStatus1 = this.mDataSourceStatus;
        DataSourceStatus localDataSourceStatus2 = DataSourceStatus.IN_PROGRESS;
        if (localDataSourceStatus1 == localDataSourceStatus2)
          break label31;
      }
      for (int i = 0; ; i = 1)
      {
        return i;
        label31: this.mDataSourceStatus = DataSourceStatus.FAILURE;
        this.mFailureThrowable = paramThrowable;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramThrowable;
  }

  private boolean setProgressInternal(float paramFloat)
  {
    int j = 0;
    monitorenter;
    int i = j;
    try
    {
      if (!this.mIsClosed)
      {
        DataSourceStatus localDataSourceStatus1 = this.mDataSourceStatus;
        DataSourceStatus localDataSourceStatus2 = DataSourceStatus.IN_PROGRESS;
        if (localDataSourceStatus1 == localDataSourceStatus2)
          break label37;
        i = j;
      }
      while (true)
      {
        return i;
        label37: i = j;
        if (paramFloat < this.mProgress)
          continue;
        this.mProgress = paramFloat;
        i = 1;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private boolean setResultInternal(@Nullable T paramT, boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    try
    {
      monitorenter;
      localObject1 = localObject3;
      try
      {
        if (!this.mIsClosed)
        {
          localObject1 = localObject3;
          if (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS);
        }
        else
        {
          boolean bool = false;
          localObject1 = paramT;
          monitorexit;
          paramBoolean = bool;
          if (paramT != null)
          {
            closeResult(paramT);
            paramBoolean = bool;
          }
        }
        do
        {
          return paramBoolean;
          if (paramBoolean)
          {
            localObject1 = localObject3;
            this.mDataSourceStatus = DataSourceStatus.SUCCESS;
            localObject1 = localObject3;
            this.mProgress = 1.0F;
          }
          localObject1 = localObject3;
          if (this.mResult != paramT)
          {
            localObject1 = localObject3;
            localObject2 = this.mResult;
            localObject1 = localObject2;
            this.mResult = paramT;
          }
          paramBoolean = true;
          localObject1 = localObject2;
          monitorexit;
        }
        while (localObject2 == null);
        closeResult(localObject2);
        return true;
      }
      finally
      {
        monitorexit;
      }
    }
    finally
    {
      if (localObject1 != null)
        closeResult(localObject1);
    }
    throw paramT;
  }

  private boolean wasCancelled()
  {
    monitorenter;
    try
    {
      if (isClosed())
      {
        bool = isFinished();
        if (!bool)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
    finally
    {
      monitorexit;
    }
  }

  public boolean close()
  {
    monitorenter;
    try
    {
      if (this.mIsClosed)
        return false;
      this.mIsClosed = true;
      Object localObject1 = this.mResult;
      this.mResult = null;
      monitorexit;
      if (localObject1 != null)
        closeResult(localObject1);
      if (!isFinished())
        notifyDataSubscribers();
      monitorenter;
      try
      {
        this.mSubscribers.clear();
        return true;
      }
      finally
      {
        monitorexit;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject3;
  }

  protected void closeResult(@Nullable T paramT)
  {
  }

  @Nullable
  public Throwable getFailureCause()
  {
    monitorenter;
    try
    {
      Throwable localThrowable = this.mFailureThrowable;
      monitorexit;
      return localThrowable;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public float getProgress()
  {
    monitorenter;
    try
    {
      float f = this.mProgress;
      monitorexit;
      return f;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  @Nullable
  public T getResult()
  {
    monitorenter;
    try
    {
      Object localObject1 = this.mResult;
      monitorexit;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      monitorexit;
    }
    throw localObject2;
  }

  public boolean hasFailed()
  {
    monitorenter;
    try
    {
      DataSourceStatus localDataSourceStatus1 = this.mDataSourceStatus;
      DataSourceStatus localDataSourceStatus2 = DataSourceStatus.FAILURE;
      if (localDataSourceStatus1 == localDataSourceStatus2)
      {
        i = 1;
        return i;
      }
      int i = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  public boolean hasResult()
  {
    monitorenter;
    try
    {
      Object localObject1 = this.mResult;
      if (localObject1 != null)
      {
        i = 1;
        return i;
      }
      int i = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  public boolean isClosed()
  {
    monitorenter;
    try
    {
      boolean bool = this.mIsClosed;
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

  public boolean isFinished()
  {
    monitorenter;
    try
    {
      DataSourceStatus localDataSourceStatus1 = this.mDataSourceStatus;
      DataSourceStatus localDataSourceStatus2 = DataSourceStatus.IN_PROGRESS;
      if (localDataSourceStatus1 != localDataSourceStatus2)
      {
        i = 1;
        return i;
      }
      int i = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  protected void notifyProgressUpdate()
  {
    Iterator localIterator = this.mSubscribers.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      DataSubscriber localDataSubscriber = (DataSubscriber)localPair.first;
      ((Executor)localPair.second).execute(new Runnable(localDataSubscriber)
      {
        public void run()
        {
          this.val$subscriber.onProgressUpdate(AbstractDataSource.this);
        }
      });
    }
  }

  protected boolean setFailure(Throwable paramThrowable)
  {
    boolean bool = setFailureInternal(paramThrowable);
    if (bool)
      notifyDataSubscribers();
    return bool;
  }

  protected boolean setProgress(float paramFloat)
  {
    boolean bool = setProgressInternal(paramFloat);
    if (bool)
      notifyProgressUpdate();
    return bool;
  }

  protected boolean setResult(@Nullable T paramT, boolean paramBoolean)
  {
    paramBoolean = setResultInternal(paramT, paramBoolean);
    if (paramBoolean)
      notifyDataSubscribers();
    return paramBoolean;
  }

  public void subscribe(DataSubscriber<T> paramDataSubscriber, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramDataSubscriber);
    Preconditions.checkNotNull(paramExecutor);
    monitorenter;
    while (true)
    {
      try
      {
        if (this.mIsClosed)
          return;
        if (this.mDataSourceStatus != DataSourceStatus.IN_PROGRESS)
          continue;
        this.mSubscribers.add(Pair.create(paramDataSubscriber, paramExecutor));
        if ((hasResult()) || (isFinished()))
          break label101;
        if (!wasCancelled())
          continue;
        break label101;
        monitorexit;
        if (i != 0)
        {
          notifyDataSubscriber(paramDataSubscriber, paramExecutor, hasFailed(), wasCancelled());
          return;
          i = 0;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      return;
      label101: int i = 1;
    }
  }

  private static enum DataSourceStatus
  {
    static
    {
      FAILURE = new DataSourceStatus("FAILURE", 2);
      $VALUES = new DataSourceStatus[] { IN_PROGRESS, SUCCESS, FAILURE };
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.datasource.AbstractDataSource
 * JD-Core Version:    0.6.0
 */
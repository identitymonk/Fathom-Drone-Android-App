package com.facebook.imagepipeline.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class ListDataSource<T> extends AbstractDataSource<List<CloseableReference<T>>>
{
  private final DataSource<CloseableReference<T>>[] mDataSources;

  @GuardedBy("this")
  private int mFinishedDataSources;

  protected ListDataSource(DataSource<CloseableReference<T>>[] paramArrayOfDataSource)
  {
    this.mDataSources = paramArrayOfDataSource;
    this.mFinishedDataSources = 0;
  }

  public static <T> ListDataSource<T> create(DataSource<CloseableReference<T>>[] paramArrayOfDataSource)
  {
    int i = 0;
    Preconditions.checkNotNull(paramArrayOfDataSource);
    if (paramArrayOfDataSource.length > 0);
    ListDataSource localListDataSource;
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      localListDataSource = new ListDataSource(paramArrayOfDataSource);
      int j = paramArrayOfDataSource.length;
      while (i < j)
      {
        DataSource<CloseableReference<T>> localDataSource = paramArrayOfDataSource[i];
        if (localDataSource != null)
        {
          localListDataSource.getClass();
          localDataSource.subscribe(new InternalDataSubscriber(null), CallerThreadExecutor.getInstance());
        }
        i += 1;
      }
    }
    return localListDataSource;
  }

  private boolean increaseAndCheckIfLast()
  {
    monitorenter;
    try
    {
      int i = this.mFinishedDataSources + 1;
      this.mFinishedDataSources = i;
      int j = this.mDataSources.length;
      if (i == j)
      {
        k = 1;
        return k;
      }
      int k = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  private void onDataSourceCancelled()
  {
    setFailure(new CancellationException());
  }

  private void onDataSourceFailed(DataSource<CloseableReference<T>> paramDataSource)
  {
    setFailure(paramDataSource.getFailureCause());
  }

  private void onDataSourceFinished()
  {
    if (increaseAndCheckIfLast())
      setResult(null, true);
  }

  private void onDataSourceProgress()
  {
    float f = 0.0F;
    DataSource[] arrayOfDataSource = this.mDataSources;
    int j = arrayOfDataSource.length;
    int i = 0;
    while (i < j)
    {
      f += arrayOfDataSource[i].getProgress();
      i += 1;
    }
    setProgress(f / this.mDataSources.length);
  }

  public boolean close()
  {
    int i = 0;
    if (!super.close())
      return false;
    DataSource[] arrayOfDataSource = this.mDataSources;
    int j = arrayOfDataSource.length;
    while (i < j)
    {
      arrayOfDataSource[i].close();
      i += 1;
    }
    return true;
  }

  @Nullable
  public List<CloseableReference<T>> getResult()
  {
    monitorenter;
    try
    {
      boolean bool = hasResult();
      Object localObject1;
      if (!bool)
      {
        localObject1 = null;
        return localObject1;
      }
      ArrayList localArrayList = new ArrayList(this.mDataSources.length);
      DataSource[] arrayOfDataSource = this.mDataSources;
      int j = arrayOfDataSource.length;
      int i = 0;
      while (true)
      {
        localObject1 = localArrayList;
        if (i >= j)
          break;
        localArrayList.add(arrayOfDataSource[i].getResult());
        i += 1;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject2;
  }

  public boolean hasResult()
  {
    monitorenter;
    try
    {
      if (!isClosed())
      {
        int i = this.mFinishedDataSources;
        int j = this.mDataSources.length;
        if (i == j)
        {
          k = 1;
          return k;
        }
      }
      int k = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  private class InternalDataSubscriber
    implements DataSubscriber<CloseableReference<T>>
  {

    @GuardedBy("InternalDataSubscriber.this")
    boolean mFinished = false;

    private InternalDataSubscriber()
    {
    }

    private boolean tryFinish()
    {
      int i = 1;
      monitorenter;
      try
      {
        boolean bool = this.mFinished;
        if (bool)
          i = 0;
        while (true)
        {
          return i;
          this.mFinished = true;
        }
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    public void onCancellation(DataSource<CloseableReference<T>> paramDataSource)
    {
      ListDataSource.this.onDataSourceCancelled();
    }

    public void onFailure(DataSource<CloseableReference<T>> paramDataSource)
    {
      ListDataSource.this.onDataSourceFailed(paramDataSource);
    }

    public void onNewResult(DataSource<CloseableReference<T>> paramDataSource)
    {
      if ((paramDataSource.isFinished()) && (tryFinish()))
        ListDataSource.this.onDataSourceFinished();
    }

    public void onProgressUpdate(DataSource<CloseableReference<T>> paramDataSource)
    {
      ListDataSource.this.onDataSourceProgress();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.datasource.ListDataSource
 * JD-Core Version:    0.6.0
 */
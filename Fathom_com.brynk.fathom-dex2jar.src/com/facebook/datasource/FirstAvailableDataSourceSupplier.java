package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class FirstAvailableDataSourceSupplier<T>
  implements Supplier<DataSource<T>>
{
  private final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

  private FirstAvailableDataSourceSupplier(List<Supplier<DataSource<T>>> paramList)
  {
    if (!paramList.isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "List of suppliers is empty!");
      this.mDataSourceSuppliers = paramList;
      return;
    }
  }

  public static <T> FirstAvailableDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> paramList)
  {
    return new FirstAvailableDataSourceSupplier(paramList);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if (!(paramObject instanceof FirstAvailableDataSourceSupplier))
      return false;
    paramObject = (FirstAvailableDataSourceSupplier)paramObject;
    return Objects.equal(this.mDataSourceSuppliers, paramObject.mDataSourceSuppliers);
  }

  public DataSource<T> get()
  {
    return new FirstAvailableDataSource();
  }

  public int hashCode()
  {
    return this.mDataSourceSuppliers.hashCode();
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("list", this.mDataSourceSuppliers).toString();
  }

  @ThreadSafe
  private class FirstAvailableDataSource extends AbstractDataSource<T>
  {
    private DataSource<T> mCurrentDataSource = null;
    private DataSource<T> mDataSourceWithResult = null;
    private int mIndex = 0;

    public FirstAvailableDataSource()
    {
      if (!startNextDataSource())
        setFailure(new RuntimeException("No data source supplier or supplier returned null."));
    }

    private boolean clearCurrentDataSource(DataSource<T> paramDataSource)
    {
      monitorenter;
      try
      {
        if (!isClosed())
        {
          DataSource localDataSource = this.mCurrentDataSource;
          if (paramDataSource == localDataSource)
            break label25;
        }
        for (int i = 0; ; i = 1)
        {
          return i;
          label25: this.mCurrentDataSource = null;
        }
      }
      finally
      {
        monitorexit;
      }
      throw paramDataSource;
    }

    private void closeSafely(DataSource<T> paramDataSource)
    {
      if (paramDataSource != null)
        paramDataSource.close();
    }

    @Nullable
    private DataSource<T> getDataSourceWithResult()
    {
      monitorenter;
      try
      {
        DataSource localDataSource = this.mDataSourceWithResult;
        monitorexit;
        return localDataSource;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
      throw localObject;
    }

    @Nullable
    private Supplier<DataSource<T>> getNextSupplier()
    {
      monitorenter;
      try
      {
        if ((!isClosed()) && (this.mIndex < FirstAvailableDataSourceSupplier.this.mDataSourceSuppliers.size()))
        {
          localObject1 = FirstAvailableDataSourceSupplier.this.mDataSourceSuppliers;
          int i = this.mIndex;
          this.mIndex = (i + 1);
          localObject1 = (Supplier)((List)localObject1).get(i);
          return localObject1;
        }
        Object localObject1 = null;
      }
      finally
      {
        monitorexit;
      }
    }

    private void maybeSetDataSourceWithResult(DataSource<T> paramDataSource, boolean paramBoolean)
    {
      DataSource localDataSource = null;
      monitorenter;
      try
      {
        if ((paramDataSource != this.mCurrentDataSource) || (paramDataSource == this.mDataSourceWithResult))
          return;
        if ((this.mDataSourceWithResult == null) || (paramBoolean))
        {
          localDataSource = this.mDataSourceWithResult;
          this.mDataSourceWithResult = paramDataSource;
        }
        monitorexit;
        closeSafely(localDataSource);
        return;
      }
      finally
      {
        monitorexit;
      }
      throw paramDataSource;
    }

    private void onDataSourceFailed(DataSource<T> paramDataSource)
    {
      if (!clearCurrentDataSource(paramDataSource));
      do
      {
        return;
        if (paramDataSource == getDataSourceWithResult())
          continue;
        closeSafely(paramDataSource);
      }
      while (startNextDataSource());
      setFailure(paramDataSource.getFailureCause());
    }

    private void onDataSourceNewResult(DataSource<T> paramDataSource)
    {
      maybeSetDataSourceWithResult(paramDataSource, paramDataSource.isFinished());
      if (paramDataSource == getDataSourceWithResult())
        setResult(null, paramDataSource.isFinished());
    }

    private boolean setCurrentDataSource(DataSource<T> paramDataSource)
    {
      monitorenter;
      try
      {
        boolean bool = isClosed();
        if (bool);
        for (bool = false; ; bool = true)
        {
          return bool;
          this.mCurrentDataSource = paramDataSource;
        }
      }
      finally
      {
        monitorexit;
      }
      throw paramDataSource;
    }

    private boolean startNextDataSource()
    {
      Object localObject = getNextSupplier();
      if (localObject != null);
      for (localObject = (DataSource)((Supplier)localObject).get(); (setCurrentDataSource((DataSource)localObject)) && (localObject != null); localObject = null)
      {
        ((DataSource)localObject).subscribe(new InternalDataSubscriber(null), CallerThreadExecutor.getInstance());
        return true;
      }
      closeSafely((DataSource)localObject);
      return false;
    }

    public boolean close()
    {
      monitorenter;
      try
      {
        if (!super.close())
          return false;
        DataSource localDataSource1 = this.mCurrentDataSource;
        this.mCurrentDataSource = null;
        DataSource localDataSource2 = this.mDataSourceWithResult;
        this.mDataSourceWithResult = null;
        monitorexit;
        closeSafely(localDataSource2);
        closeSafely(localDataSource1);
        return true;
      }
      finally
      {
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
        Object localObject1 = getDataSourceWithResult();
        if (localObject1 != null);
        for (localObject1 = ((DataSource)localObject1).getResult(); ; localObject1 = null)
          return localObject1;
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
        DataSource localDataSource = getDataSourceWithResult();
        if (localDataSource != null)
        {
          bool = localDataSource.hasResult();
          if (!bool);
        }
        for (boolean bool = true; ; bool = false)
          return bool;
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    private class InternalDataSubscriber
      implements DataSubscriber<T>
    {
      private InternalDataSubscriber()
      {
      }

      public void onCancellation(DataSource<T> paramDataSource)
      {
      }

      public void onFailure(DataSource<T> paramDataSource)
      {
        FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.onDataSourceFailed(paramDataSource);
      }

      public void onNewResult(DataSource<T> paramDataSource)
      {
        if (paramDataSource.hasResult())
          FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.onDataSourceNewResult(paramDataSource);
        do
          return;
        while (!paramDataSource.isFinished());
        FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.onDataSourceFailed(paramDataSource);
      }

      public void onProgressUpdate(DataSource<T> paramDataSource)
      {
        float f = FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.getProgress();
        FirstAvailableDataSourceSupplier.FirstAvailableDataSource.this.setProgress(Math.max(f, paramDataSource.getProgress()));
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.datasource.FirstAvailableDataSourceSupplier
 * JD-Core Version:    0.6.0
 */
package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class IncreasingQualityDataSourceSupplier<T>
  implements Supplier<DataSource<T>>
{
  private final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

  private IncreasingQualityDataSourceSupplier(List<Supplier<DataSource<T>>> paramList)
  {
    if (!paramList.isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "List of suppliers is empty!");
      this.mDataSourceSuppliers = paramList;
      return;
    }
  }

  public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> paramList)
  {
    return new IncreasingQualityDataSourceSupplier(paramList);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if (!(paramObject instanceof IncreasingQualityDataSourceSupplier))
      return false;
    paramObject = (IncreasingQualityDataSourceSupplier)paramObject;
    return Objects.equal(this.mDataSourceSuppliers, paramObject.mDataSourceSuppliers);
  }

  public DataSource<T> get()
  {
    return new IncreasingQualityDataSource();
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
  private class IncreasingQualityDataSource extends AbstractDataSource<T>
  {

    @Nullable
    @GuardedBy("IncreasingQualityDataSource.this")
    private ArrayList<DataSource<T>> mDataSources;

    @GuardedBy("IncreasingQualityDataSource.this")
    private int mIndexOfDataSourceWithResult;

    public IncreasingQualityDataSource()
    {
      int j = IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.size();
      this.mIndexOfDataSourceWithResult = j;
      this.mDataSources = new ArrayList(j);
      int i = 0;
      while (true)
      {
        if (i < j)
        {
          DataSource localDataSource = (DataSource)((Supplier)IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.get(i)).get();
          this.mDataSources.add(localDataSource);
          localDataSource.subscribe(new InternalDataSubscriber(i), CallerThreadExecutor.getInstance());
          if (!localDataSource.hasResult());
        }
        else
        {
          return;
        }
        i += 1;
      }
    }

    private void closeSafely(DataSource<T> paramDataSource)
    {
      if (paramDataSource != null)
        paramDataSource.close();
    }

    @Nullable
    private DataSource<T> getAndClearDataSource(int paramInt)
    {
      Object localObject3 = null;
      monitorenter;
      Object localObject1 = localObject3;
      try
      {
        if (this.mDataSources != null)
        {
          localObject1 = localObject3;
          if (paramInt < this.mDataSources.size())
            localObject1 = (DataSource)this.mDataSources.set(paramInt, null);
        }
        return localObject1;
      }
      finally
      {
        monitorexit;
      }
      throw localObject2;
    }

    @Nullable
    private DataSource<T> getDataSource(int paramInt)
    {
      monitorenter;
      try
      {
        if ((this.mDataSources != null) && (paramInt < this.mDataSources.size()))
        {
          localDataSource = (DataSource)this.mDataSources.get(paramInt);
          return localDataSource;
        }
        DataSource localDataSource = null;
      }
      finally
      {
        monitorexit;
      }
    }

    @Nullable
    private DataSource<T> getDataSourceWithResult()
    {
      monitorenter;
      try
      {
        DataSource localDataSource = getDataSource(this.mIndexOfDataSourceWithResult);
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

    private void maybeSetIndexOfDataSourceWithResult(int paramInt, DataSource<T> paramDataSource, boolean paramBoolean)
    {
      monitorenter;
      try
      {
        int j = this.mIndexOfDataSourceWithResult;
        int k = this.mIndexOfDataSourceWithResult;
        if ((paramDataSource != getDataSource(paramInt)) || (paramInt == this.mIndexOfDataSourceWithResult))
          return;
        int i;
        if (getDataSourceWithResult() != null)
        {
          i = k;
          if (paramBoolean)
          {
            i = k;
            if (paramInt >= this.mIndexOfDataSourceWithResult);
          }
        }
        else
        {
          i = paramInt;
          this.mIndexOfDataSourceWithResult = paramInt;
        }
        monitorexit;
        paramInt = j;
        while (paramInt > i)
        {
          closeSafely(getAndClearDataSource(paramInt));
          paramInt -= 1;
        }
      }
      finally
      {
        monitorexit;
      }
    }

    private void onDataSourceFailed(int paramInt, DataSource<T> paramDataSource)
    {
      closeSafely(tryGetAndClearDataSource(paramInt, paramDataSource));
      if (paramInt == 0)
        setFailure(paramDataSource.getFailureCause());
    }

    private void onDataSourceNewResult(int paramInt, DataSource<T> paramDataSource)
    {
      maybeSetIndexOfDataSourceWithResult(paramInt, paramDataSource, paramDataSource.isFinished());
      if (paramDataSource == getDataSourceWithResult())
        if ((paramInt != 0) || (!paramDataSource.isFinished()))
          break label43;
      label43: for (boolean bool = true; ; bool = false)
      {
        setResult(null, bool);
        return;
      }
    }

    @Nullable
    private DataSource<T> tryGetAndClearDataSource(int paramInt, DataSource<T> paramDataSource)
    {
      monitorenter;
      try
      {
        Object localObject = getDataSourceWithResult();
        if (paramDataSource == localObject)
          localObject = null;
        while (true)
        {
          return localObject;
          localObject = paramDataSource;
          if (paramDataSource != getDataSource(paramInt))
            continue;
          localObject = getAndClearDataSource(paramInt);
        }
      }
      finally
      {
        monitorexit;
      }
      throw paramDataSource;
    }

    public boolean close()
    {
      monitorenter;
      try
      {
        if (!super.close())
          return false;
        ArrayList localArrayList = this.mDataSources;
        this.mDataSources = null;
        monitorexit;
        if (localArrayList != null)
        {
          int i = 0;
          while (i < localArrayList.size())
          {
            closeSafely((DataSource)localArrayList.get(i));
            i += 1;
          }
        }
      }
      finally
      {
        monitorexit;
      }
      return true;
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
      private int mIndex;

      public InternalDataSubscriber(int arg2)
      {
        int i;
        this.mIndex = i;
      }

      public void onCancellation(DataSource<T> paramDataSource)
      {
      }

      public void onFailure(DataSource<T> paramDataSource)
      {
        IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, paramDataSource);
      }

      public void onNewResult(DataSource<T> paramDataSource)
      {
        if (paramDataSource.hasResult())
          IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.onDataSourceNewResult(this.mIndex, paramDataSource);
        do
          return;
        while (!paramDataSource.isFinished());
        IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, paramDataSource);
      }

      public void onProgressUpdate(DataSource<T> paramDataSource)
      {
        if (this.mIndex == 0)
          IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.this.setProgress(paramDataSource.getProgress());
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.datasource.IncreasingQualityDataSourceSupplier
 * JD-Core Version:    0.6.0
 */
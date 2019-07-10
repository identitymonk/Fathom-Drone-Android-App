package com.facebook.datasource;

import com.facebook.common.internal.Supplier;

public class DataSources
{
  public static <T> Supplier<DataSource<T>> getFailedDataSourceSupplier(Throwable paramThrowable)
  {
    return new Supplier(paramThrowable)
    {
      public DataSource<T> get()
      {
        return DataSources.immediateFailedDataSource(this.val$failure);
      }
    };
  }

  public static <T> DataSource<T> immediateDataSource(T paramT)
  {
    SimpleDataSource localSimpleDataSource = SimpleDataSource.create();
    localSimpleDataSource.setResult(paramT);
    return localSimpleDataSource;
  }

  public static <T> DataSource<T> immediateFailedDataSource(Throwable paramThrowable)
  {
    SimpleDataSource localSimpleDataSource = SimpleDataSource.create();
    localSimpleDataSource.setFailure(paramThrowable);
    return localSimpleDataSource;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.datasource.DataSources
 * JD-Core Version:    0.6.0
 */
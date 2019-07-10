package com.facebook.datasource;

public abstract class BaseDataSubscriber<T>
  implements DataSubscriber<T>
{
  public void onCancellation(DataSource<T> paramDataSource)
  {
  }

  public void onFailure(DataSource<T> paramDataSource)
  {
    try
    {
      onFailureImpl(paramDataSource);
      return;
    }
    finally
    {
      paramDataSource.close();
    }
    throw localObject;
  }

  protected abstract void onFailureImpl(DataSource<T> paramDataSource);

  public void onNewResult(DataSource<T> paramDataSource)
  {
    boolean bool = paramDataSource.isFinished();
    try
    {
      onNewResultImpl(paramDataSource);
      return;
    }
    finally
    {
      if (bool)
        paramDataSource.close();
    }
    throw localObject;
  }

  protected abstract void onNewResultImpl(DataSource<T> paramDataSource);

  public void onProgressUpdate(DataSource<T> paramDataSource)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.datasource.BaseDataSubscriber
 * JD-Core Version:    0.6.0
 */
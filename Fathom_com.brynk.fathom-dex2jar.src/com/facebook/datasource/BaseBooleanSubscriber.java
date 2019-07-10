package com.facebook.datasource;

public abstract class BaseBooleanSubscriber
  implements DataSubscriber<Boolean>
{
  public void onCancellation(DataSource<Boolean> paramDataSource)
  {
  }

  public void onFailure(DataSource<Boolean> paramDataSource)
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

  protected abstract void onFailureImpl(DataSource<Boolean> paramDataSource);

  public void onNewResult(DataSource<Boolean> paramDataSource)
  {
    try
    {
      onNewResultImpl(((Boolean)paramDataSource.getResult()).booleanValue());
      return;
    }
    finally
    {
      paramDataSource.close();
    }
    throw localObject;
  }

  protected abstract void onNewResultImpl(boolean paramBoolean);

  public void onProgressUpdate(DataSource<Boolean> paramDataSource)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.datasource.BaseBooleanSubscriber
 * JD-Core Version:    0.6.0
 */
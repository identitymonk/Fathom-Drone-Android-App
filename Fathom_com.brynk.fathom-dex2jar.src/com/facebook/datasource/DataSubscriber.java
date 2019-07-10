package com.facebook.datasource;

public abstract interface DataSubscriber<T>
{
  public abstract void onCancellation(DataSource<T> paramDataSource);

  public abstract void onFailure(DataSource<T> paramDataSource);

  public abstract void onNewResult(DataSource<T> paramDataSource);

  public abstract void onProgressUpdate(DataSource<T> paramDataSource);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.datasource.DataSubscriber
 * JD-Core Version:    0.6.0
 */
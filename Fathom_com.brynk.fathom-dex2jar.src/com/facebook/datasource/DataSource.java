package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public abstract interface DataSource<T>
{
  public abstract boolean close();

  @Nullable
  public abstract Throwable getFailureCause();

  public abstract float getProgress();

  @Nullable
  public abstract T getResult();

  public abstract boolean hasFailed();

  public abstract boolean hasResult();

  public abstract boolean isClosed();

  public abstract boolean isFinished();

  public abstract void subscribe(DataSubscriber<T> paramDataSubscriber, Executor paramExecutor);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.datasource.DataSource
 * JD-Core Version:    0.6.0
 */
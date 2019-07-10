package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class BaseConsumer<T>
  implements Consumer<T>
{
  private boolean mIsFinished = false;

  public void onCancellation()
  {
    monitorenter;
    try
    {
      boolean bool = this.mIsFinished;
      if (bool);
      while (true)
      {
        return;
        this.mIsFinished = true;
        try
        {
          onCancellationImpl();
        }
        catch (Exception localException)
        {
          onUnhandledException(localException);
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  protected abstract void onCancellationImpl();

  public void onFailure(Throwable paramThrowable)
  {
    monitorenter;
    try
    {
      boolean bool = this.mIsFinished;
      if (bool);
      while (true)
      {
        return;
        this.mIsFinished = true;
        try
        {
          onFailureImpl(paramThrowable);
        }
        catch (Exception paramThrowable)
        {
          onUnhandledException(paramThrowable);
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramThrowable;
  }

  protected abstract void onFailureImpl(Throwable paramThrowable);

  public void onNewResult(@Nullable T paramT, boolean paramBoolean)
  {
    monitorenter;
    try
    {
      boolean bool = this.mIsFinished;
      if (bool);
      while (true)
      {
        return;
        this.mIsFinished = paramBoolean;
        try
        {
          onNewResultImpl(paramT, paramBoolean);
        }
        catch (Exception paramT)
        {
          onUnhandledException(paramT);
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramT;
  }

  protected abstract void onNewResultImpl(T paramT, boolean paramBoolean);

  public void onProgressUpdate(float paramFloat)
  {
    monitorenter;
    try
    {
      boolean bool = this.mIsFinished;
      if (bool);
      while (true)
      {
        return;
        try
        {
          onProgressUpdateImpl(paramFloat);
        }
        catch (Exception localException)
        {
          onUnhandledException(localException);
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  protected void onProgressUpdateImpl(float paramFloat)
  {
  }

  protected void onUnhandledException(Exception paramException)
  {
    FLog.wtf(getClass(), "unhandled exception", paramException);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.BaseConsumer
 * JD-Core Version:    0.6.0
 */
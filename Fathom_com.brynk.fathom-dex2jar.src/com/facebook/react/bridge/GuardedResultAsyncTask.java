package com.facebook.react.bridge;

import android.os.AsyncTask;

public abstract class GuardedResultAsyncTask<Result> extends AsyncTask<Void, Void, Result>
{
  private final ReactContext mReactContext;

  protected GuardedResultAsyncTask(ReactContext paramReactContext)
  {
    this.mReactContext = paramReactContext;
  }

  protected final Result doInBackground(Void[] paramArrayOfVoid)
  {
    try
    {
      paramArrayOfVoid = doInBackgroundGuarded();
      return paramArrayOfVoid;
    }
    catch (java.lang.RuntimeException paramArrayOfVoid)
    {
      this.mReactContext.handleException(paramArrayOfVoid);
    }
    throw paramArrayOfVoid;
  }

  protected abstract Result doInBackgroundGuarded();

  protected final void onPostExecute(Result paramResult)
  {
    try
    {
      onPostExecuteGuarded(paramResult);
      return;
    }
    catch (java.lang.RuntimeException paramResult)
    {
      this.mReactContext.handleException(paramResult);
    }
  }

  protected abstract void onPostExecuteGuarded(Result paramResult);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.GuardedResultAsyncTask
 * JD-Core Version:    0.6.0
 */
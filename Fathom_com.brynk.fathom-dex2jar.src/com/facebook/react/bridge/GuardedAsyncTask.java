package com.facebook.react.bridge;

import android.os.AsyncTask;

public abstract class GuardedAsyncTask<Params, Progress> extends AsyncTask<Params, Progress, Void>
{
  private final ReactContext mReactContext;

  protected GuardedAsyncTask(ReactContext paramReactContext)
  {
    this.mReactContext = paramReactContext;
  }

  protected final Void doInBackground(Params[] paramArrayOfParams)
  {
    try
    {
      doInBackgroundGuarded(paramArrayOfParams);
      return null;
    }
    catch (java.lang.RuntimeException paramArrayOfParams)
    {
      while (true)
        this.mReactContext.handleException(paramArrayOfParams);
    }
  }

  protected abstract void doInBackgroundGuarded(Params[] paramArrayOfParams);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.GuardedAsyncTask
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;

public abstract class GuardedFrameCallback extends ChoreographerCompat.FrameCallback
{
  private final ReactContext mReactContext;

  protected GuardedFrameCallback(ReactContext paramReactContext)
  {
    this.mReactContext = paramReactContext;
  }

  public final void doFrame(long paramLong)
  {
    try
    {
      doFrameGuarded(paramLong);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      this.mReactContext.handleException(localRuntimeException);
    }
  }

  protected abstract void doFrameGuarded(long paramLong);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.GuardedFrameCallback
 * JD-Core Version:    0.6.0
 */
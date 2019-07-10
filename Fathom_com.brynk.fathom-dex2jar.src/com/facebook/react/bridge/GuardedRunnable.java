package com.facebook.react.bridge;

public abstract class GuardedRunnable
  implements Runnable
{
  private final ReactContext mReactContext;

  public GuardedRunnable(ReactContext paramReactContext)
  {
    this.mReactContext = paramReactContext;
  }

  public final void run()
  {
    try
    {
      runGuarded();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      this.mReactContext.handleException(localRuntimeException);
    }
  }

  public abstract void runGuarded();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.GuardedRunnable
 * JD-Core Version:    0.6.0
 */
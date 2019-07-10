package com.facebook.react.uimanager;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import javax.annotation.Nullable;

public class ThemedReactContext extends ReactContext
{
  private final ReactApplicationContext mReactApplicationContext;

  public ThemedReactContext(ReactApplicationContext paramReactApplicationContext, Context paramContext)
  {
    super(paramContext);
    initializeWithInstance(paramReactApplicationContext.getCatalystInstance());
    this.mReactApplicationContext = paramReactApplicationContext;
  }

  public void addLifecycleEventListener(LifecycleEventListener paramLifecycleEventListener)
  {
    this.mReactApplicationContext.addLifecycleEventListener(paramLifecycleEventListener);
  }

  @Nullable
  public Activity getCurrentActivity()
  {
    return this.mReactApplicationContext.getCurrentActivity();
  }

  public boolean hasCurrentActivity()
  {
    return this.mReactApplicationContext.hasCurrentActivity();
  }

  public void removeLifecycleEventListener(LifecycleEventListener paramLifecycleEventListener)
  {
    this.mReactApplicationContext.removeLifecycleEventListener(paramLifecycleEventListener);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ThemedReactContext
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.bridge;

import android.app.Activity;
import javax.annotation.Nullable;

public abstract class ReactContextBaseJavaModule extends BaseJavaModule
{
  private final ReactApplicationContext mReactApplicationContext;

  public ReactContextBaseJavaModule(ReactApplicationContext paramReactApplicationContext)
  {
    this.mReactApplicationContext = paramReactApplicationContext;
  }

  @Nullable
  protected final Activity getCurrentActivity()
  {
    return this.mReactApplicationContext.getCurrentActivity();
  }

  protected final ReactApplicationContext getReactApplicationContext()
  {
    return this.mReactApplicationContext;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReactContextBaseJavaModule
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public abstract class JavaScriptExecutor
{
  private final HybridData mHybridData;

  protected JavaScriptExecutor(HybridData paramHybridData)
  {
    this.mHybridData = paramHybridData;
  }

  public void close()
  {
    this.mHybridData.resetNative();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JavaScriptExecutor
 * JD-Core Version:    0.6.0
 */
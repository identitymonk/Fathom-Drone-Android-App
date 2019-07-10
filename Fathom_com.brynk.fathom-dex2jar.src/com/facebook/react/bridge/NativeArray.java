package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public abstract class NativeArray
{

  @DoNotStrip
  private HybridData mHybridData;

  static
  {
    ReactBridge.staticInit();
  }

  protected NativeArray(HybridData paramHybridData)
  {
    this.mHybridData = paramHybridData;
  }

  public native String toString();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.NativeArray
 * JD-Core Version:    0.6.0
 */
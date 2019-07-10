package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class CxxModuleWrapperBase
  implements NativeModule
{

  @DoNotStrip
  private HybridData mHybridData;

  static
  {
    ReactBridge.staticInit();
  }

  protected CxxModuleWrapperBase(HybridData paramHybridData)
  {
    this.mHybridData = paramHybridData;
  }

  public boolean canOverrideExistingModule()
  {
    return false;
  }

  public native String getName();

  public void initialize()
  {
  }

  public void onCatalystInstanceDestroy()
  {
    this.mHybridData.resetNative();
  }

  protected void resetModule(HybridData paramHybridData)
  {
    if (paramHybridData != this.mHybridData)
    {
      this.mHybridData.resetNative();
      this.mHybridData = paramHybridData;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.CxxModuleWrapperBase
 * JD-Core Version:    0.6.0
 */
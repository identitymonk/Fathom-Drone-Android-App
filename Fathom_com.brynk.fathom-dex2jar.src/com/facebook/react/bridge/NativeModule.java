package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public abstract interface NativeModule
{
  public abstract boolean canOverrideExistingModule();

  public abstract String getName();

  public abstract void initialize();

  public abstract void onCatalystInstanceDestroy();

  public static abstract interface NativeMethod
  {
    public abstract String getType();

    public abstract void invoke(JSInstance paramJSInstance, ReadableNativeArray paramReadableNativeArray);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.NativeModule
 * JD-Core Version:    0.6.0
 */
package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class NativeRunnable
  implements Runnable
{
  private final HybridData mHybridData;

  private NativeRunnable(HybridData paramHybridData)
  {
    this.mHybridData = paramHybridData;
  }

  public native void run();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.jni.NativeRunnable
 * JD-Core Version:    0.6.0
 */
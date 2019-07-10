package com.facebook.react.bridge.queue;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class NativeRunnable
  implements Runnable
{
  private final HybridData mHybridData;

  @DoNotStrip
  private NativeRunnable(HybridData paramHybridData)
  {
    this.mHybridData = paramHybridData;
  }

  public native void run();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.queue.NativeRunnable
 * JD-Core Version:    0.6.0
 */
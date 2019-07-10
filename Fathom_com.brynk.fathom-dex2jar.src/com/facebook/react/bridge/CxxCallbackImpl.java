package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class CxxCallbackImpl
  implements Callback
{

  @DoNotStrip
  private final HybridData mHybridData;

  @DoNotStrip
  private CxxCallbackImpl(HybridData paramHybridData)
  {
    this.mHybridData = paramHybridData;
  }

  private native void nativeInvoke(NativeArray paramNativeArray);

  public void invoke(Object[] paramArrayOfObject)
  {
    nativeInvoke(Arguments.fromJavaArgs(paramArrayOfObject));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.CxxCallbackImpl
 * JD-Core Version:    0.6.0
 */
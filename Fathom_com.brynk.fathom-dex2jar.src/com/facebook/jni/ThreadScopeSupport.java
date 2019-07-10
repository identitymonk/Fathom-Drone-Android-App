package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class ThreadScopeSupport
{
  static
  {
    SoLoader.loadLibrary("fb");
  }

  @DoNotStrip
  private static void runStdFunction(long paramLong)
  {
    runStdFunctionImpl(paramLong);
  }

  private static native void runStdFunctionImpl(long paramLong);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.jni.ThreadScopeSupport
 * JD-Core Version:    0.6.0
 */
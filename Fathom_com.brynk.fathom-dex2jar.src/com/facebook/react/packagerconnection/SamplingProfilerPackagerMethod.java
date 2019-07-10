package com.facebook.react.packagerconnection;

import android.os.Looper;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import javax.annotation.Nullable;

public class SamplingProfilerPackagerMethod extends RequestOnlyHandler
{
  private SamplingProfilerJniMethod mJniMethod;

  static
  {
    SoLoader.loadLibrary("packagerconnectionjnifb");
  }

  public SamplingProfilerPackagerMethod(long paramLong)
  {
    this.mJniMethod = new SamplingProfilerJniMethod(paramLong);
  }

  public void onRequest(@Nullable Object paramObject, Responder paramResponder)
  {
    this.mJniMethod.poke(paramResponder);
  }

  private static final class SamplingProfilerJniMethod
  {

    @DoNotStrip
    private final HybridData mHybridData;

    public SamplingProfilerJniMethod(long paramLong)
    {
      if (Looper.myLooper() == null)
        Looper.prepare();
      this.mHybridData = initHybrid(paramLong);
    }

    @DoNotStrip
    private static native HybridData initHybrid(long paramLong);

    @DoNotStrip
    private native void poke(Responder paramResponder);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.packagerconnection.SamplingProfilerPackagerMethod
 * JD-Core Version:    0.6.0
 */
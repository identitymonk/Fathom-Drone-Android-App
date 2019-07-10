package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class Countable
{

  @DoNotStrip
  private long mInstance = 0L;

  static
  {
    SoLoader.loadLibrary("fb");
  }

  public native void dispose();

  protected void finalize()
    throws Throwable
  {
    dispose();
    super.finalize();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.jni.Countable
 * JD-Core Version:    0.6.0
 */
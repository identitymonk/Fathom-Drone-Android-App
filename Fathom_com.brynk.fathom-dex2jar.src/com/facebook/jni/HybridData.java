package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class HybridData
{

  @DoNotStrip
  private Destructor mDestructor = new Destructor(this);

  static
  {
    SoLoader.loadLibrary("fb");
  }

  public boolean isValid()
  {
    return this.mDestructor.mNativePointer != 0L;
  }

  public void resetNative()
  {
    monitorenter;
    try
    {
      this.mDestructor.destruct();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static class Destructor extends DestructorThread.Destructor
  {

    @DoNotStrip
    private long mNativePointer;

    Destructor(Object paramObject)
    {
      super();
    }

    static native void deleteNative(long paramLong);

    void destruct()
    {
      deleteNative(this.mNativePointer);
      this.mNativePointer = 0L;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.jni.HybridData
 * JD-Core Version:    0.6.0
 */
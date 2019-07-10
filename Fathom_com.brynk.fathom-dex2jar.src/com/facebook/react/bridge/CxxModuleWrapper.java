package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import java.io.File;

@DoNotStrip
public class CxxModuleWrapper extends CxxModuleWrapperBase
{
  protected CxxModuleWrapper(HybridData paramHybridData)
  {
    super(paramHybridData);
  }

  public static CxxModuleWrapper makeDso(String paramString1, String paramString2)
  {
    SoLoader.loadLibrary(paramString1);
    return makeDsoNative(SoLoader.unpackLibraryAndDependencies(paramString1).getAbsolutePath(), paramString2);
  }

  private static native CxxModuleWrapper makeDsoNative(String paramString1, String paramString2);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.CxxModuleWrapper
 * JD-Core Version:    0.6.0
 */
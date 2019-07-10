package com.facebook.react.bridge;

import com.facebook.soloader.SoLoader;

public class ReactBridge
{
  private static boolean sDidInit = false;

  public static void staticInit()
  {
    if (!sDidInit)
    {
      SoLoader.loadLibrary("reactnativejni");
      sDidInit = true;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReactBridge
 * JD-Core Version:    0.6.0
 */
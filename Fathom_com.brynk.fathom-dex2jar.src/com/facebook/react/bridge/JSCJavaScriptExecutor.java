package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
class JSCJavaScriptExecutor extends JavaScriptExecutor
{
  static
  {
    ReactBridge.staticInit();
  }

  JSCJavaScriptExecutor(ReadableNativeMap paramReadableNativeMap)
  {
    super(initHybrid(paramReadableNativeMap));
  }

  private static native HybridData initHybrid(ReadableNativeMap paramReadableNativeMap);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JSCJavaScriptExecutor
 * JD-Core Version:    0.6.0
 */
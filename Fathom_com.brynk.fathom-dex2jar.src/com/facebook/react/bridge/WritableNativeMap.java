package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class WritableNativeMap extends ReadableNativeMap
  implements WritableMap
{
  static
  {
    ReactBridge.staticInit();
  }

  public WritableNativeMap()
  {
    super(initHybrid());
  }

  private static native HybridData initHybrid();

  private native void mergeNativeMap(ReadableNativeMap paramReadableNativeMap);

  private native void putNativeArray(String paramString, WritableNativeArray paramWritableNativeArray);

  private native void putNativeMap(String paramString, WritableNativeMap paramWritableNativeMap);

  public void merge(ReadableMap paramReadableMap)
  {
    Assertions.assertCondition(paramReadableMap instanceof ReadableNativeMap, "Illegal type provided");
    mergeNativeMap((ReadableNativeMap)paramReadableMap);
  }

  public void putArray(String paramString, WritableArray paramWritableArray)
  {
    if ((paramWritableArray == null) || ((paramWritableArray instanceof WritableNativeArray)));
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool, "Illegal type provided");
      putNativeArray(paramString, (WritableNativeArray)paramWritableArray);
      return;
    }
  }

  public native void putBoolean(String paramString, boolean paramBoolean);

  public native void putDouble(String paramString, double paramDouble);

  public native void putInt(String paramString, int paramInt);

  public void putMap(String paramString, WritableMap paramWritableMap)
  {
    if ((paramWritableMap == null) || ((paramWritableMap instanceof WritableNativeMap)));
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool, "Illegal type provided");
      putNativeMap(paramString, (WritableNativeMap)paramWritableMap);
      return;
    }
  }

  public native void putNull(String paramString);

  public native void putString(String paramString1, String paramString2);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.WritableNativeMap
 * JD-Core Version:    0.6.0
 */
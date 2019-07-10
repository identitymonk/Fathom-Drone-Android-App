package com.facebook.react.uimanager;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import javax.annotation.Nullable;

public class ReactStylesDiffMap
{
  final ReadableMap mBackingMap;

  public ReactStylesDiffMap(ReadableMap paramReadableMap)
  {
    this.mBackingMap = paramReadableMap;
  }

  @Nullable
  public ReadableArray getArray(String paramString)
  {
    return this.mBackingMap.getArray(paramString);
  }

  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    if (this.mBackingMap.isNull(paramString))
      return paramBoolean;
    return this.mBackingMap.getBoolean(paramString);
  }

  public double getDouble(String paramString, double paramDouble)
  {
    if (this.mBackingMap.isNull(paramString))
      return paramDouble;
    return this.mBackingMap.getDouble(paramString);
  }

  @Nullable
  public Dynamic getDynamic(String paramString)
  {
    return this.mBackingMap.getDynamic(paramString);
  }

  public float getFloat(String paramString, float paramFloat)
  {
    if (this.mBackingMap.isNull(paramString))
      return paramFloat;
    return (float)this.mBackingMap.getDouble(paramString);
  }

  public int getInt(String paramString, int paramInt)
  {
    if (this.mBackingMap.isNull(paramString))
      return paramInt;
    return this.mBackingMap.getInt(paramString);
  }

  @Nullable
  public ReadableMap getMap(String paramString)
  {
    return this.mBackingMap.getMap(paramString);
  }

  @Nullable
  public String getString(String paramString)
  {
    return this.mBackingMap.getString(paramString);
  }

  public boolean hasKey(String paramString)
  {
    return this.mBackingMap.hasKey(paramString);
  }

  public boolean isNull(String paramString)
  {
    return this.mBackingMap.isNull(paramString);
  }

  public String toString()
  {
    return "{ " + getClass().getSimpleName() + ": " + this.mBackingMap.toString() + " }";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ReactStylesDiffMap
 * JD-Core Version:    0.6.0
 */
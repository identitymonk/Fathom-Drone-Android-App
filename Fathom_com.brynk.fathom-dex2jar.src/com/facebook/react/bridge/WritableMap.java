package com.facebook.react.bridge;

public abstract interface WritableMap extends ReadableMap
{
  public abstract void merge(ReadableMap paramReadableMap);

  public abstract void putArray(String paramString, WritableArray paramWritableArray);

  public abstract void putBoolean(String paramString, boolean paramBoolean);

  public abstract void putDouble(String paramString, double paramDouble);

  public abstract void putInt(String paramString, int paramInt);

  public abstract void putMap(String paramString, WritableMap paramWritableMap);

  public abstract void putNull(String paramString);

  public abstract void putString(String paramString1, String paramString2);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.WritableMap
 * JD-Core Version:    0.6.0
 */
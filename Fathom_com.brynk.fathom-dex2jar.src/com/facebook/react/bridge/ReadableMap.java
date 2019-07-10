package com.facebook.react.bridge;

import java.util.HashMap;

public abstract interface ReadableMap
{
  public abstract ReadableArray getArray(String paramString);

  public abstract boolean getBoolean(String paramString);

  public abstract double getDouble(String paramString);

  public abstract Dynamic getDynamic(String paramString);

  public abstract int getInt(String paramString);

  public abstract ReadableMap getMap(String paramString);

  public abstract String getString(String paramString);

  public abstract ReadableType getType(String paramString);

  public abstract boolean hasKey(String paramString);

  public abstract boolean isNull(String paramString);

  public abstract ReadableMapKeySetIterator keySetIterator();

  public abstract HashMap<String, Object> toHashMap();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReadableMap
 * JD-Core Version:    0.6.0
 */
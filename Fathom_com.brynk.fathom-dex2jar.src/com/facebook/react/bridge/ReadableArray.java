package com.facebook.react.bridge;

import java.util.ArrayList;

public abstract interface ReadableArray
{
  public abstract ReadableArray getArray(int paramInt);

  public abstract boolean getBoolean(int paramInt);

  public abstract double getDouble(int paramInt);

  public abstract Dynamic getDynamic(int paramInt);

  public abstract int getInt(int paramInt);

  public abstract ReadableMap getMap(int paramInt);

  public abstract String getString(int paramInt);

  public abstract ReadableType getType(int paramInt);

  public abstract boolean isNull(int paramInt);

  public abstract int size();

  public abstract ArrayList<Object> toArrayList();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReadableArray
 * JD-Core Version:    0.6.0
 */
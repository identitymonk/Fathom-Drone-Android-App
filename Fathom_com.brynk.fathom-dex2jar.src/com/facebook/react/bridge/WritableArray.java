package com.facebook.react.bridge;

public abstract interface WritableArray extends ReadableArray
{
  public abstract void pushArray(WritableArray paramWritableArray);

  public abstract void pushBoolean(boolean paramBoolean);

  public abstract void pushDouble(double paramDouble);

  public abstract void pushInt(int paramInt);

  public abstract void pushMap(WritableMap paramWritableMap);

  public abstract void pushNull();

  public abstract void pushString(String paramString);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.WritableArray
 * JD-Core Version:    0.6.0
 */
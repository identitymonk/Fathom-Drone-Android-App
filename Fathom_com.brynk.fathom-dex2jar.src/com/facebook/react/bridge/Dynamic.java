package com.facebook.react.bridge;

public abstract interface Dynamic
{
  public abstract ReadableArray asArray();

  public abstract boolean asBoolean();

  public abstract double asDouble();

  public abstract int asInt();

  public abstract ReadableMap asMap();

  public abstract String asString();

  public abstract ReadableType getType();

  public abstract boolean isNull();

  public abstract void recycle();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.Dynamic
 * JD-Core Version:    0.6.0
 */
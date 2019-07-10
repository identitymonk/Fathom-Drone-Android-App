package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public abstract interface ReadableMapKeySetIterator
{
  public abstract boolean hasNextKey();

  public abstract String nextKey();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReadableMapKeySetIterator
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.flat;

abstract interface AndroidView
{
  public abstract float getPadding(int paramInt);

  public abstract boolean isPaddingChanged();

  public abstract boolean needsCustomLayoutForChildren();

  public abstract void resetPaddingChanged();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.AndroidView
 * JD-Core Version:    0.6.0
 */
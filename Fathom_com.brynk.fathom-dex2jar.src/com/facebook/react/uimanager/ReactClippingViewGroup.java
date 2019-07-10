package com.facebook.react.uimanager;

import android.graphics.Rect;

public abstract interface ReactClippingViewGroup
{
  public abstract void getClippingRect(Rect paramRect);

  public abstract boolean getRemoveClippedSubviews();

  public abstract void setRemoveClippedSubviews(boolean paramBoolean);

  public abstract void updateClippingRect();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ReactClippingViewGroup
 * JD-Core Version:    0.6.0
 */
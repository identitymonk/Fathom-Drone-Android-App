package com.facebook.react.flat;

import android.graphics.Rect;

final class HitSlopNodeRegion extends NodeRegion
{
  private final Rect mHitSlop;

  HitSlopNodeRegion(Rect paramRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, boolean paramBoolean)
  {
    super(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, paramBoolean);
    this.mHitSlop = paramRect;
  }

  float getTouchableBottom()
  {
    return getBottom() + this.mHitSlop.bottom;
  }

  float getTouchableLeft()
  {
    return getLeft() - this.mHitSlop.left;
  }

  float getTouchableRight()
  {
    return getRight() + this.mHitSlop.right;
  }

  float getTouchableTop()
  {
    return getTop() - this.mHitSlop.top;
  }

  boolean withinBounds(float paramFloat1, float paramFloat2)
  {
    return (getTouchableLeft() <= paramFloat1) && (paramFloat1 < getTouchableRight()) && (getTouchableTop() <= paramFloat2) && (paramFloat2 < getTouchableBottom());
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.HitSlopNodeRegion
 * JD-Core Version:    0.6.0
 */
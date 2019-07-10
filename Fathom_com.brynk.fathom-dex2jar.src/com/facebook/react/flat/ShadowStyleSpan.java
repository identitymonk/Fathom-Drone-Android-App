package com.facebook.react.flat;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

final class ShadowStyleSpan extends CharacterStyle
{
  static final ShadowStyleSpan INSTANCE = new ShadowStyleSpan(0.0F, 0.0F, 0.0F, 0, true);
  private int mColor;
  private float mDx;
  private float mDy;
  private boolean mFrozen;
  private float mRadius;

  private ShadowStyleSpan(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, boolean paramBoolean)
  {
    this.mDx = paramFloat1;
    this.mDy = paramFloat2;
    this.mRadius = paramFloat3;
    this.mColor = paramInt;
    this.mFrozen = paramBoolean;
  }

  void freeze()
  {
    this.mFrozen = true;
  }

  public int getColor()
  {
    return this.mColor;
  }

  public float getRadius()
  {
    return this.mRadius;
  }

  boolean isFrozen()
  {
    return this.mFrozen;
  }

  ShadowStyleSpan mutableCopy()
  {
    return new ShadowStyleSpan(this.mDx, this.mDy, this.mRadius, this.mColor, false);
  }

  public boolean offsetMatches(float paramFloat1, float paramFloat2)
  {
    return (this.mDx == paramFloat1) && (this.mDy == paramFloat2);
  }

  public void setColor(int paramInt)
  {
    this.mColor = paramInt;
  }

  public void setOffset(float paramFloat1, float paramFloat2)
  {
    this.mDx = paramFloat1;
    this.mDy = paramFloat2;
  }

  public void setRadius(float paramFloat)
  {
    this.mRadius = paramFloat;
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setShadowLayer(this.mRadius, this.mDx, this.mDy, this.mColor);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.ShadowStyleSpan
 * JD-Core Version:    0.6.0
 */
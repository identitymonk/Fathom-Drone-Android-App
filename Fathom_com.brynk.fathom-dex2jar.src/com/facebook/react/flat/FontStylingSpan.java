package com.facebook.react.flat;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import javax.annotation.Nullable;

final class FontStylingSpan extends MetricAffectingSpan
{
  static final FontStylingSpan INSTANCE = new FontStylingSpan(-16777216.0D, 0, -1, -1, -1, false, false, null, true);
  private int mBackgroundColor;

  @Nullable
  private String mFontFamily;
  private int mFontSize;
  private int mFontStyle;
  private int mFontWeight;
  private boolean mFrozen;
  private boolean mHasStrikeThrough;
  private boolean mHasUnderline;
  private double mTextColor;

  FontStylingSpan()
  {
  }

  private FontStylingSpan(double paramDouble, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, @Nullable String paramString, boolean paramBoolean3)
  {
    this.mTextColor = paramDouble;
    this.mBackgroundColor = paramInt1;
    this.mFontSize = paramInt2;
    this.mFontStyle = paramInt3;
    this.mFontWeight = paramInt4;
    this.mHasUnderline = paramBoolean1;
    this.mHasStrikeThrough = paramBoolean2;
    this.mFontFamily = paramString;
    this.mFrozen = paramBoolean3;
  }

  private int getNewStyle(int paramInt)
  {
    int i = paramInt;
    paramInt = i;
    if (this.mFontStyle != -1)
      paramInt = i & 0xFFFFFFFD | this.mFontStyle;
    i = paramInt;
    if (this.mFontWeight != -1)
      i = paramInt & 0xFFFFFFFE | this.mFontWeight;
    return i;
  }

  private void updateTypeface(TextPaint paramTextPaint)
  {
    Typeface localTypeface = paramTextPaint.getTypeface();
    if (localTypeface == null);
    int j;
    for (int i = 0; ; i = localTypeface.getStyle())
    {
      j = getNewStyle(i);
      if ((i != j) || (this.mFontFamily != null))
        break;
      return;
    }
    if (this.mFontFamily != null);
    for (localTypeface = TypefaceCache.getTypeface(this.mFontFamily, j); ; localTypeface = TypefaceCache.getTypeface(localTypeface, j))
    {
      paramTextPaint.setTypeface(localTypeface);
      return;
    }
  }

  void freeze()
  {
    this.mFrozen = true;
  }

  int getBackgroundColor()
  {
    return this.mBackgroundColor;
  }

  @Nullable
  String getFontFamily()
  {
    return this.mFontFamily;
  }

  int getFontSize()
  {
    return this.mFontSize;
  }

  int getFontStyle()
  {
    return this.mFontStyle;
  }

  int getFontWeight()
  {
    return this.mFontWeight;
  }

  double getTextColor()
  {
    return this.mTextColor;
  }

  boolean hasStrikeThrough()
  {
    return this.mHasStrikeThrough;
  }

  boolean hasUnderline()
  {
    return this.mHasUnderline;
  }

  boolean isFrozen()
  {
    return this.mFrozen;
  }

  FontStylingSpan mutableCopy()
  {
    return new FontStylingSpan(this.mTextColor, this.mBackgroundColor, this.mFontSize, this.mFontStyle, this.mFontWeight, this.mHasUnderline, this.mHasStrikeThrough, this.mFontFamily, false);
  }

  void setBackgroundColor(int paramInt)
  {
    this.mBackgroundColor = paramInt;
  }

  void setFontFamily(@Nullable String paramString)
  {
    this.mFontFamily = paramString;
  }

  void setFontSize(int paramInt)
  {
    this.mFontSize = paramInt;
  }

  void setFontStyle(int paramInt)
  {
    this.mFontStyle = paramInt;
  }

  void setFontWeight(int paramInt)
  {
    this.mFontWeight = paramInt;
  }

  void setHasStrikeThrough(boolean paramBoolean)
  {
    this.mHasStrikeThrough = paramBoolean;
  }

  void setHasUnderline(boolean paramBoolean)
  {
    this.mHasUnderline = paramBoolean;
  }

  void setTextColor(double paramDouble)
  {
    this.mTextColor = paramDouble;
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (!Double.isNaN(this.mTextColor))
      paramTextPaint.setColor((int)this.mTextColor);
    paramTextPaint.bgColor = this.mBackgroundColor;
    paramTextPaint.setUnderlineText(this.mHasUnderline);
    paramTextPaint.setStrikeThruText(this.mHasStrikeThrough);
    updateMeasureState(paramTextPaint);
  }

  public void updateMeasureState(TextPaint paramTextPaint)
  {
    if (this.mFontSize != -1)
      paramTextPaint.setTextSize(this.mFontSize);
    updateTypeface(paramTextPaint);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.FontStylingSpan
 * JD-Core Version:    0.6.0
 */
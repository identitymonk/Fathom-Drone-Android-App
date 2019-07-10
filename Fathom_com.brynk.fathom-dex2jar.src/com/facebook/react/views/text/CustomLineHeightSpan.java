package com.facebook.react.views.text;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;

public class CustomLineHeightSpan
  implements LineHeightSpan
{
  private final int mHeight;

  CustomLineHeightSpan(float paramFloat)
  {
    this.mHeight = (int)Math.ceil(paramFloat);
  }

  public void chooseHeight(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (-paramFontMetricsInt.ascent > this.mHeight)
    {
      paramInt1 = -this.mHeight;
      paramFontMetricsInt.ascent = paramInt1;
      paramFontMetricsInt.top = paramInt1;
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.bottom = 0;
      return;
    }
    if (-paramFontMetricsInt.ascent + paramFontMetricsInt.descent > this.mHeight)
    {
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramInt1 = this.mHeight + paramFontMetricsInt.ascent;
      paramFontMetricsInt.descent = paramInt1;
      paramFontMetricsInt.bottom = paramInt1;
      return;
    }
    if (-paramFontMetricsInt.ascent + paramFontMetricsInt.bottom > this.mHeight)
    {
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = (paramFontMetricsInt.ascent + this.mHeight);
      return;
    }
    if (-paramFontMetricsInt.top + paramFontMetricsInt.bottom > this.mHeight)
    {
      paramFontMetricsInt.top = (paramFontMetricsInt.bottom - this.mHeight);
      return;
    }
    paramInt1 = this.mHeight - (-paramFontMetricsInt.top + paramFontMetricsInt.bottom);
    paramFontMetricsInt.top -= paramInt1;
    paramFontMetricsInt.ascent -= paramInt1;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.CustomLineHeightSpan
 * JD-Core Version:    0.6.0
 */
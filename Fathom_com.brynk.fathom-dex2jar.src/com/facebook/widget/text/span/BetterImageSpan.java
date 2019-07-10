package com.facebook.widget.text.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class BetterImageSpan extends ReplacementSpan
{
  public static final int ALIGN_BASELINE = 1;
  public static final int ALIGN_BOTTOM = 0;
  public static final int ALIGN_CENTER = 2;
  private final int mAlignment;
  private Rect mBounds;
  private final Drawable mDrawable;
  private final Paint.FontMetricsInt mFontMetricsInt = new Paint.FontMetricsInt();
  private int mHeight;
  private int mWidth;

  public BetterImageSpan(Drawable paramDrawable)
  {
    this(paramDrawable, 1);
  }

  public BetterImageSpan(Drawable paramDrawable, int paramInt)
  {
    this.mDrawable = paramDrawable;
    this.mAlignment = paramInt;
    updateBounds();
  }

  private int getOffsetAboveBaseline(Paint.FontMetricsInt paramFontMetricsInt)
  {
    switch (this.mAlignment)
    {
    case 1:
    default:
      return -this.mHeight;
    case 0:
      return paramFontMetricsInt.descent - this.mHeight;
    case 2:
    }
    int i = (paramFontMetricsInt.descent - paramFontMetricsInt.ascent - this.mHeight) / 2;
    return paramFontMetricsInt.ascent + i;
  }

  public static final int normalizeAlignment(int paramInt)
  {
    switch (paramInt)
    {
    case 1:
    default:
      return 1;
    case 0:
      return 0;
    case 2:
    }
    return 2;
  }

  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramPaint.getFontMetricsInt(this.mFontMetricsInt);
    paramInt1 = paramInt4 + getOffsetAboveBaseline(this.mFontMetricsInt);
    paramCanvas.translate(paramFloat, paramInt1);
    this.mDrawable.draw(paramCanvas);
    paramCanvas.translate(-paramFloat, -paramInt1);
  }

  public Drawable getDrawable()
  {
    return this.mDrawable;
  }

  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    updateBounds();
    if (paramFontMetricsInt == null)
      return this.mWidth;
    paramInt1 = getOffsetAboveBaseline(paramFontMetricsInt);
    paramInt2 = this.mHeight + paramInt1;
    if (paramInt1 < paramFontMetricsInt.ascent)
      paramFontMetricsInt.ascent = paramInt1;
    if (paramInt1 < paramFontMetricsInt.top)
      paramFontMetricsInt.top = paramInt1;
    if (paramInt2 > paramFontMetricsInt.descent)
      paramFontMetricsInt.descent = paramInt2;
    if (paramInt2 > paramFontMetricsInt.bottom)
      paramFontMetricsInt.descent = paramInt2;
    return this.mWidth;
  }

  public void updateBounds()
  {
    this.mBounds = this.mDrawable.getBounds();
    this.mWidth = this.mBounds.width();
    this.mHeight = this.mBounds.height();
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface BetterImageSpanAlignment
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.widget.text.span.BetterImageSpan
 * JD-Core Version:    0.6.0
 */
package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class ProgressBarDrawable extends Drawable
  implements CloneableDrawable
{
  private int mBackgroundColor = -2147483648;
  private int mBarWidth = 20;
  private int mColor = -2147450625;
  private boolean mHideWhenZero = false;
  private boolean mIsVertical = false;
  private int mLevel = 0;
  private int mPadding = 10;
  private final Paint mPaint = new Paint(1);
  private final Path mPath = new Path();
  private int mRadius = 0;
  private final RectF mRect = new RectF();

  private void drawBar(Canvas paramCanvas, int paramInt)
  {
    this.mPaint.setColor(paramInt);
    this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.mPath.reset();
    this.mPath.setFillType(Path.FillType.EVEN_ODD);
    this.mPath.addRoundRect(this.mRect, Math.min(this.mRadius, this.mBarWidth / 2), Math.min(this.mRadius, this.mBarWidth / 2), Path.Direction.CW);
    paramCanvas.drawPath(this.mPath, this.mPaint);
  }

  private void drawHorizontalBar(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Rect localRect = getBounds();
    paramInt1 = (localRect.width() - this.mPadding * 2) * paramInt1 / 10000;
    int i = localRect.left + this.mPadding;
    int j = localRect.bottom - this.mPadding - this.mBarWidth;
    this.mRect.set(i, j, i + paramInt1, this.mBarWidth + j);
    drawBar(paramCanvas, paramInt2);
  }

  private void drawVerticalBar(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Rect localRect = getBounds();
    paramInt1 = (localRect.height() - this.mPadding * 2) * paramInt1 / 10000;
    int i = localRect.left + this.mPadding;
    int j = localRect.top + this.mPadding;
    this.mRect.set(i, j, this.mBarWidth + i, j + paramInt1);
    drawBar(paramCanvas, paramInt2);
  }

  public Drawable cloneDrawable()
  {
    ProgressBarDrawable localProgressBarDrawable = new ProgressBarDrawable();
    localProgressBarDrawable.mBackgroundColor = this.mBackgroundColor;
    localProgressBarDrawable.mColor = this.mColor;
    localProgressBarDrawable.mPadding = this.mPadding;
    localProgressBarDrawable.mBarWidth = this.mBarWidth;
    localProgressBarDrawable.mLevel = this.mLevel;
    localProgressBarDrawable.mRadius = this.mRadius;
    localProgressBarDrawable.mHideWhenZero = this.mHideWhenZero;
    localProgressBarDrawable.mIsVertical = this.mIsVertical;
    return localProgressBarDrawable;
  }

  public void draw(Canvas paramCanvas)
  {
    if ((this.mHideWhenZero) && (this.mLevel == 0))
      return;
    if (this.mIsVertical)
    {
      drawVerticalBar(paramCanvas, 10000, this.mBackgroundColor);
      drawVerticalBar(paramCanvas, this.mLevel, this.mColor);
      return;
    }
    drawHorizontalBar(paramCanvas, 10000, this.mBackgroundColor);
    drawHorizontalBar(paramCanvas, this.mLevel, this.mColor);
  }

  public int getBackgroundColor()
  {
    return this.mBackgroundColor;
  }

  public int getBarWidth()
  {
    return this.mBarWidth;
  }

  public int getColor()
  {
    return this.mColor;
  }

  public boolean getHideWhenZero()
  {
    return this.mHideWhenZero;
  }

  public boolean getIsVertical()
  {
    return this.mIsVertical;
  }

  public int getOpacity()
  {
    return DrawableUtils.getOpacityFromColor(this.mPaint.getColor());
  }

  public boolean getPadding(Rect paramRect)
  {
    paramRect.set(this.mPadding, this.mPadding, this.mPadding, this.mPadding);
    return this.mPadding != 0;
  }

  public int getRadius()
  {
    return this.mRadius;
  }

  protected boolean onLevelChange(int paramInt)
  {
    this.mLevel = paramInt;
    invalidateSelf();
    return true;
  }

  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }

  public void setBackgroundColor(int paramInt)
  {
    if (this.mBackgroundColor != paramInt)
    {
      this.mBackgroundColor = paramInt;
      invalidateSelf();
    }
  }

  public void setBarWidth(int paramInt)
  {
    if (this.mBarWidth != paramInt)
    {
      this.mBarWidth = paramInt;
      invalidateSelf();
    }
  }

  public void setColor(int paramInt)
  {
    if (this.mColor != paramInt)
    {
      this.mColor = paramInt;
      invalidateSelf();
    }
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }

  public void setHideWhenZero(boolean paramBoolean)
  {
    this.mHideWhenZero = paramBoolean;
  }

  public void setIsVertical(boolean paramBoolean)
  {
    if (this.mIsVertical != paramBoolean)
    {
      this.mIsVertical = paramBoolean;
      invalidateSelf();
    }
  }

  public void setPadding(int paramInt)
  {
    if (this.mPadding != paramInt)
    {
      this.mPadding = paramInt;
      invalidateSelf();
    }
  }

  public void setRadius(int paramInt)
  {
    if (this.mRadius != paramInt)
    {
      this.mRadius = paramInt;
      invalidateSelf();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.ProgressBarDrawable
 * JD-Core Version:    0.6.0
 */
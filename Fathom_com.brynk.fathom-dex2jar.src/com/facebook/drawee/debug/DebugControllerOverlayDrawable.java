package com.facebook.drawee.debug;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import javax.annotation.Nullable;

public class DebugControllerOverlayDrawable extends Drawable
{
  private static final float IMAGE_SIZE_THRESHOLD_NOT_OK = 0.5F;
  private static final float IMAGE_SIZE_THRESHOLD_OK = 0.1F;
  private static final int MAX_LINE_WIDTH_EM = 7;
  private static final int MAX_NUMBER_OF_LINES = 7;
  private static final int MAX_TEXT_SIZE_PX = 40;
  private static final int MIN_TEXT_SIZE_PX = 12;
  private static final String NO_CONTROLLER_ID = "none";
  private static final int OUTLINE_COLOR = -26624;
  private static final int OUTLINE_STROKE_WIDTH_PX = 2;

  @VisibleForTesting
  static final int OVERLAY_COLOR_IMAGE_ALMOST_OK = 1728026624;

  @VisibleForTesting
  static final int OVERLAY_COLOR_IMAGE_NOT_OK = 1727284022;

  @VisibleForTesting
  static final int OVERLAY_COLOR_IMAGE_OK = 1716301648;
  private static final int TEXT_COLOR = -1;
  private static final int TEXT_LINE_SPACING_PX = 8;
  private static final int TEXT_PADDING_PX = 10;
  private String mControllerId;
  private int mCurrentTextXPx;
  private int mCurrentTextYPx;
  private int mFrameCount;
  private int mHeightPx;
  private String mImageFormat;
  private int mImageSizeBytes;
  private int mLineIncrementPx;
  private int mLoopCount;
  private final Matrix mMatrix = new Matrix();
  private final Paint mPaint = new Paint(1);
  private final Rect mRect = new Rect();
  private final RectF mRectF = new RectF();
  private ScalingUtils.ScaleType mScaleType;
  private int mStartTextXPx;
  private int mStartTextYPx;
  private int mTextGravity = 80;
  private int mWidthPx;

  public DebugControllerOverlayDrawable()
  {
    reset();
  }

  private void addDebugText(Canvas paramCanvas, String paramString, @Nullable Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
      paramCanvas.drawText(paramString, this.mCurrentTextXPx, this.mCurrentTextYPx, this.mPaint);
    while (true)
    {
      this.mCurrentTextYPx += this.mLineIncrementPx;
      return;
      paramCanvas.drawText(String.format(paramString, paramArrayOfObject), this.mCurrentTextXPx, this.mCurrentTextYPx, this.mPaint);
    }
  }

  private void prepareDebugTextParameters(Rect paramRect, int paramInt1, int paramInt2)
  {
    paramInt1 = Math.min(40, Math.max(12, Math.min(paramRect.width() / paramInt2, paramRect.height() / paramInt1)));
    this.mPaint.setTextSize(paramInt1);
    this.mLineIncrementPx = (paramInt1 + 8);
    if (this.mTextGravity == 80)
      this.mLineIncrementPx *= -1;
    this.mStartTextXPx = (paramRect.left + 10);
    if (this.mTextGravity == 80);
    for (paramInt1 = paramRect.bottom - 10; ; paramInt1 = paramRect.top + 10 + 12)
    {
      this.mStartTextYPx = paramInt1;
      return;
    }
  }

  @VisibleForTesting
  int determineOverlayColor(int paramInt1, int paramInt2, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    int m = getBounds().width();
    int k = getBounds().height();
    if ((m <= 0) || (k <= 0) || (paramInt1 <= 0) || (paramInt2 <= 0))
      return 1727284022;
    int i = k;
    int j = m;
    if (paramScaleType != null)
    {
      Rect localRect = this.mRect;
      this.mRect.top = 0;
      localRect.left = 0;
      this.mRect.right = m;
      this.mRect.bottom = k;
      this.mMatrix.reset();
      paramScaleType.getTransform(this.mMatrix, this.mRect, paramInt1, paramInt2, 0.0F, 0.0F);
      paramScaleType = this.mRectF;
      this.mRectF.top = 0.0F;
      paramScaleType.left = 0.0F;
      this.mRectF.right = paramInt1;
      this.mRectF.bottom = paramInt2;
      this.mMatrix.mapRect(this.mRectF);
      j = (int)this.mRectF.width();
      i = (int)this.mRectF.height();
      j = Math.min(m, j);
      i = Math.min(k, i);
    }
    float f1 = j;
    float f2 = j;
    float f3 = i;
    float f4 = i;
    paramInt1 = Math.abs(paramInt1 - j);
    paramInt2 = Math.abs(paramInt2 - i);
    if ((paramInt1 < f1 * 0.1F) && (paramInt2 < f3 * 0.1F))
      return 1716301648;
    if ((paramInt1 < f2 * 0.5F) && (paramInt2 < f4 * 0.5F))
      return 1728026624;
    return 1727284022;
  }

  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(2.0F);
    this.mPaint.setColor(-26624);
    paramCanvas.drawRect(localRect.left, localRect.top, localRect.right, localRect.bottom, this.mPaint);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(determineOverlayColor(this.mWidthPx, this.mHeightPx, this.mScaleType));
    paramCanvas.drawRect(localRect.left, localRect.top, localRect.right, localRect.bottom, this.mPaint);
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setStrokeWidth(0.0F);
    this.mPaint.setColor(-1);
    this.mCurrentTextXPx = this.mStartTextXPx;
    this.mCurrentTextYPx = this.mStartTextYPx;
    addDebugText(paramCanvas, "ID: %s", new Object[] { this.mControllerId });
    addDebugText(paramCanvas, "D: %dx%d", new Object[] { Integer.valueOf(localRect.width()), Integer.valueOf(localRect.height()) });
    addDebugText(paramCanvas, "I: %dx%d", new Object[] { Integer.valueOf(this.mWidthPx), Integer.valueOf(this.mHeightPx) });
    addDebugText(paramCanvas, "I: %d KiB", new Object[] { Integer.valueOf(this.mImageSizeBytes / 1024) });
    if (this.mImageFormat != null)
      addDebugText(paramCanvas, "i format: %s", new Object[] { this.mImageFormat });
    if (this.mFrameCount > 0)
      addDebugText(paramCanvas, "anim: f %d, l %d", new Object[] { Integer.valueOf(this.mFrameCount), Integer.valueOf(this.mLoopCount) });
    if (this.mScaleType != null)
      addDebugText(paramCanvas, "scale: %s", new Object[] { this.mScaleType });
  }

  public int getOpacity()
  {
    return -3;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    prepareDebugTextParameters(paramRect, 7, 7);
  }

  public void reset()
  {
    this.mWidthPx = -1;
    this.mHeightPx = -1;
    this.mImageSizeBytes = -1;
    this.mFrameCount = -1;
    this.mLoopCount = -1;
    this.mImageFormat = null;
    setControllerId(null);
    invalidateSelf();
  }

  public void setAlpha(int paramInt)
  {
  }

  public void setAnimationInfo(int paramInt1, int paramInt2)
  {
    this.mFrameCount = paramInt1;
    this.mLoopCount = paramInt2;
    invalidateSelf();
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }

  public void setControllerId(@Nullable String paramString)
  {
    if (paramString != null);
    while (true)
    {
      this.mControllerId = paramString;
      invalidateSelf();
      return;
      paramString = "none";
    }
  }

  public void setDimensions(int paramInt1, int paramInt2)
  {
    this.mWidthPx = paramInt1;
    this.mHeightPx = paramInt2;
    invalidateSelf();
  }

  public void setImageFormat(@Nullable String paramString)
  {
    this.mImageFormat = paramString;
  }

  public void setImageSize(int paramInt)
  {
    this.mImageSizeBytes = paramInt;
  }

  public void setScaleType(ScalingUtils.ScaleType paramScaleType)
  {
    this.mScaleType = paramScaleType;
  }

  public void setTextGravity(int paramInt)
  {
    this.mTextGravity = paramInt;
    invalidateSelf();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.debug.DebugControllerOverlayDrawable
 * JD-Core Version:    0.6.0
 */
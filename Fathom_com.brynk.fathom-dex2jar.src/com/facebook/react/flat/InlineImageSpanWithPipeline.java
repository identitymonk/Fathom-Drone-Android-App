package com.facebook.react.flat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nullable;

final class InlineImageSpanWithPipeline extends ReplacementSpan
  implements AttachDetachListener, BitmapUpdateListener
{
  private static final RectF TMP_RECT = new RectF();

  @Nullable
  private FlatViewGroup.InvalidateCallback mCallback;
  private boolean mFrozen;
  private float mHeight;

  @Nullable
  private PipelineRequestHelper mRequestHelper;
  private float mWidth;

  InlineImageSpanWithPipeline()
  {
    this(null, (0.0F / 0.0F), (0.0F / 0.0F));
  }

  private InlineImageSpanWithPipeline(@Nullable PipelineRequestHelper paramPipelineRequestHelper, float paramFloat1, float paramFloat2)
  {
    this.mRequestHelper = paramPipelineRequestHelper;
    this.mWidth = paramFloat1;
    this.mHeight = paramFloat2;
  }

  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    if (this.mRequestHelper == null);
    do
    {
      return;
      paramCharSequence = this.mRequestHelper.getBitmap();
    }
    while (paramCharSequence == null);
    float f = paramInt5 - paramPaint.getFontMetricsInt().descent;
    TMP_RECT.set(paramFloat, f - this.mHeight, this.mWidth + paramFloat, f);
    paramCanvas.drawBitmap(paramCharSequence, null, TMP_RECT, paramPaint);
  }

  void freeze()
  {
    this.mFrozen = true;
  }

  float getHeight()
  {
    return this.mHeight;
  }

  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramFontMetricsInt != null)
    {
      paramFontMetricsInt.ascent = (-Math.round(this.mHeight));
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = 0;
    }
    return Math.round(this.mWidth);
  }

  float getWidth()
  {
    return this.mWidth;
  }

  boolean hasImageRequest()
  {
    return this.mRequestHelper != null;
  }

  boolean isFrozen()
  {
    return this.mFrozen;
  }

  InlineImageSpanWithPipeline mutableCopy()
  {
    return new InlineImageSpanWithPipeline(this.mRequestHelper, this.mWidth, this.mHeight);
  }

  public void onAttached(FlatViewGroup.InvalidateCallback paramInvalidateCallback)
  {
    this.mCallback = paramInvalidateCallback;
    if (this.mRequestHelper != null)
      this.mRequestHelper.attach(this);
  }

  public void onBitmapReady(Bitmap paramBitmap)
  {
    ((FlatViewGroup.InvalidateCallback)Assertions.assumeNotNull(this.mCallback)).invalidate();
  }

  public void onDetached()
  {
    if (this.mRequestHelper != null)
    {
      this.mRequestHelper.detach();
      if (this.mRequestHelper.isDetached())
        this.mCallback = null;
    }
  }

  public void onImageLoadEvent(int paramInt)
  {
  }

  public void onSecondaryAttach(Bitmap paramBitmap)
  {
    ((FlatViewGroup.InvalidateCallback)Assertions.assumeNotNull(this.mCallback)).invalidate();
  }

  void setHeight(float paramFloat)
  {
    this.mHeight = paramFloat;
  }

  void setImageRequest(@Nullable ImageRequest paramImageRequest)
  {
    if (paramImageRequest == null)
    {
      this.mRequestHelper = null;
      return;
    }
    this.mRequestHelper = new PipelineRequestHelper(paramImageRequest);
  }

  void setWidth(float paramFloat)
  {
    this.mWidth = paramFloat;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.InlineImageSpanWithPipeline
 * JD-Core Version:    0.6.0
 */
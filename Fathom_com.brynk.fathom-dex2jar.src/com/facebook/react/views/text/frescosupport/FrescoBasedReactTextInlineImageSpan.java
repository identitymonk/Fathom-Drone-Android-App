package com.facebook.react.views.text.frescosupport;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.TextView;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.fresco.ReactNetworkImageRequest;
import com.facebook.react.views.text.TextInlineImageSpan;
import javax.annotation.Nullable;

public class FrescoBasedReactTextInlineImageSpan extends TextInlineImageSpan
{

  @Nullable
  private final Object mCallerContext;

  @Nullable
  private Drawable mDrawable;
  private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
  private final DraweeHolder<GenericDraweeHierarchy> mDraweeHolder;
  private ReadableMap mHeaders;
  private int mHeight;

  @Nullable
  private TextView mTextView;
  private Uri mUri;
  private int mWidth;

  public FrescoBasedReactTextInlineImageSpan(Resources paramResources, int paramInt1, int paramInt2, @Nullable Uri paramUri, ReadableMap paramReadableMap, AbstractDraweeControllerBuilder paramAbstractDraweeControllerBuilder, @Nullable Object paramObject)
  {
    this.mDraweeHolder = new DraweeHolder(GenericDraweeHierarchyBuilder.newInstance(paramResources).build());
    this.mDraweeControllerBuilder = paramAbstractDraweeControllerBuilder;
    this.mCallerContext = paramObject;
    this.mHeight = paramInt1;
    this.mWidth = paramInt2;
    if (paramUri != null);
    while (true)
    {
      this.mUri = paramUri;
      this.mHeaders = paramReadableMap;
      return;
      paramUri = Uri.EMPTY;
    }
  }

  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    if (this.mDrawable == null)
    {
      paramCharSequence = ReactNetworkImageRequest.fromBuilderWithHeaders(ImageRequestBuilder.newBuilderWithSource(this.mUri), this.mHeaders);
      paramCharSequence = this.mDraweeControllerBuilder.reset().setOldController(this.mDraweeHolder.getController()).setCallerContext(this.mCallerContext).setImageRequest(paramCharSequence).build();
      this.mDraweeHolder.setController(paramCharSequence);
      this.mDraweeControllerBuilder.reset();
      this.mDrawable = this.mDraweeHolder.getTopLevelDrawable();
      this.mDrawable.setBounds(0, 0, this.mWidth, this.mHeight);
      this.mDrawable.setCallback(this.mTextView);
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat, paramInt4 - this.mDrawable.getBounds().bottom);
    this.mDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }

  @Nullable
  public Drawable getDrawable()
  {
    return this.mDrawable;
  }

  public int getHeight()
  {
    return this.mHeight;
  }

  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramFontMetricsInt != null)
    {
      paramFontMetricsInt.ascent = (-this.mHeight);
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = 0;
    }
    return this.mWidth;
  }

  public int getWidth()
  {
    return this.mWidth;
  }

  public void onAttachedToWindow()
  {
    this.mDraweeHolder.onAttach();
  }

  public void onDetachedFromWindow()
  {
    this.mDraweeHolder.onDetach();
  }

  public void onFinishTemporaryDetach()
  {
    this.mDraweeHolder.onAttach();
  }

  public void onStartTemporaryDetach()
  {
    this.mDraweeHolder.onDetach();
  }

  public void setTextView(TextView paramTextView)
  {
    this.mTextView = paramTextView;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageSpan
 * JD-Core Version:    0.6.0
 */
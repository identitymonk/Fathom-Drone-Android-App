package com.facebook.react.flat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.views.image.GlobalImageLoadListener;
import com.facebook.react.views.image.ImageResizeMode;
import com.facebook.react.views.imagehelper.ImageSource;
import com.facebook.react.views.imagehelper.MultiSourceHelper;
import com.facebook.react.views.imagehelper.MultiSourceHelper.MultiSourceResult;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;

final class DrawImageWithDrawee extends AbstractDrawCommand
  implements DrawImage, ControllerListener
{
  private static final String LOCAL_CONTENT_SCHEME = "content";
  private static final String LOCAL_FILE_SCHEME = "file";
  private int mBorderColor;
  private float mBorderRadius;
  private float mBorderWidth;

  @Nullable
  private FlatViewGroup.InvalidateCallback mCallback;

  @Nullable
  private PorterDuffColorFilter mColorFilter;
  private int mFadeDuration = 300;

  @Nullable
  private final GlobalImageLoadListener mGlobalImageLoadListener;
  private boolean mProgressiveRenderingEnabled;
  private int mReactTag;

  @Nullable
  private DraweeRequestHelper mRequestHelper;
  private ScalingUtils.ScaleType mScaleType = ImageResizeMode.defaultValue();
  private final List<ImageSource> mSources = new LinkedList();

  public DrawImageWithDrawee(@Nullable GlobalImageLoadListener paramGlobalImageLoadListener)
  {
    this.mGlobalImageLoadListener = paramGlobalImageLoadListener;
  }

  private void computeRequestHelper()
  {
    Object localObject1 = MultiSourceHelper.getBestSourceForSize(Math.round(getRight() - getLeft()), Math.round(getBottom() - getTop()), this.mSources);
    Object localObject2 = ((MultiSourceHelper.MultiSourceResult)localObject1).getBestResult();
    ImageSource localImageSource = ((MultiSourceHelper.MultiSourceResult)localObject1).getBestResultInCache();
    if (localObject2 == null)
    {
      this.mRequestHelper = null;
      return;
    }
    localObject1 = null;
    if (shouldResize((ImageSource)localObject2))
      localObject1 = new ResizeOptions((int)(getRight() - getLeft()), (int)(getBottom() - getTop()));
    ImageRequest localImageRequest = ImageRequestBuilder.newBuilderWithSource(((ImageSource)localObject2).getUri()).setResizeOptions((ResizeOptions)localObject1).setProgressiveRenderingEnabled(this.mProgressiveRenderingEnabled).build();
    if (this.mGlobalImageLoadListener != null)
      this.mGlobalImageLoadListener.onLoadAttempt(((ImageSource)localObject2).getUri());
    localObject2 = null;
    if (localImageSource != null)
      localObject2 = ImageRequestBuilder.newBuilderWithSource(localImageSource.getUri()).setResizeOptions((ResizeOptions)localObject1).setProgressiveRenderingEnabled(this.mProgressiveRenderingEnabled).build();
    this.mRequestHelper = new DraweeRequestHelper((ImageRequest)Assertions.assertNotNull(localImageRequest), (ImageRequest)localObject2, this);
  }

  private boolean shouldDisplayBorder()
  {
    return (this.mBorderColor != 0) || (this.mBorderRadius >= 0.5F);
  }

  private static boolean shouldResize(ImageSource paramImageSource)
  {
    paramImageSource = paramImageSource.getUri();
    if (paramImageSource == null);
    for (paramImageSource = null; ("file".equals(paramImageSource)) || ("content".equals(paramImageSource)); paramImageSource = paramImageSource.getScheme())
      return true;
    return false;
  }

  public int getBorderColor()
  {
    return this.mBorderColor;
  }

  public float getBorderRadius()
  {
    return this.mBorderRadius;
  }

  public float getBorderWidth()
  {
    return this.mBorderWidth;
  }

  public ScalingUtils.ScaleType getScaleType()
  {
    return this.mScaleType;
  }

  public boolean hasImageRequest()
  {
    return !this.mSources.isEmpty();
  }

  public void onAttached(FlatViewGroup.InvalidateCallback paramInvalidateCallback)
  {
    this.mCallback = paramInvalidateCallback;
    if (this.mRequestHelper == null)
      throw new RuntimeException("No DraweeRequestHelper - width: " + (getRight() - getLeft()) + " - height: " + (getBottom() - getTop()) + " - number of sources: " + this.mSources.size());
    GenericDraweeHierarchy localGenericDraweeHierarchy = this.mRequestHelper.getHierarchy();
    RoundingParams localRoundingParams2 = localGenericDraweeHierarchy.getRoundingParams();
    if (shouldDisplayBorder())
    {
      RoundingParams localRoundingParams1 = localRoundingParams2;
      if (localRoundingParams2 == null)
        localRoundingParams1 = new RoundingParams();
      localRoundingParams1.setBorder(this.mBorderColor, this.mBorderWidth);
      localRoundingParams1.setCornersRadius(this.mBorderRadius);
      localGenericDraweeHierarchy.setRoundingParams(localRoundingParams1);
    }
    while (true)
    {
      localGenericDraweeHierarchy.setActualImageScaleType(this.mScaleType);
      localGenericDraweeHierarchy.setActualImageColorFilter(this.mColorFilter);
      localGenericDraweeHierarchy.setFadeDuration(this.mFadeDuration);
      localGenericDraweeHierarchy.getTopLevelDrawable().setBounds(Math.round(getLeft()), Math.round(getTop()), Math.round(getRight()), Math.round(getBottom()));
      this.mRequestHelper.attach(paramInvalidateCallback);
      return;
      if (localRoundingParams2 == null)
        continue;
      localGenericDraweeHierarchy.setRoundingParams(null);
    }
  }

  protected void onBoundsChanged()
  {
    super.onBoundsChanged();
    computeRequestHelper();
  }

  protected void onDebugDrawHighlight(Canvas paramCanvas)
  {
    if (this.mCallback != null)
      debugDrawCautionHighlight(paramCanvas, "Invalidate Drawee");
  }

  public void onDetached()
  {
    if (this.mRequestHelper != null)
      this.mRequestHelper.detach();
  }

  public void onDraw(Canvas paramCanvas)
  {
    if (this.mRequestHelper != null)
      this.mRequestHelper.getDrawable().draw(paramCanvas);
  }

  public void onFailure(String paramString, Throwable paramThrowable)
  {
    if ((this.mCallback != null) && (this.mReactTag != 0))
    {
      this.mCallback.dispatchImageLoadEvent(this.mReactTag, 1);
      this.mCallback.dispatchImageLoadEvent(this.mReactTag, 3);
    }
  }

  public void onFinalImageSet(String paramString, @Nullable Object paramObject, @Nullable Animatable paramAnimatable)
  {
    if ((this.mCallback != null) && (this.mReactTag != 0))
    {
      this.mCallback.dispatchImageLoadEvent(this.mReactTag, 2);
      this.mCallback.dispatchImageLoadEvent(this.mReactTag, 3);
    }
  }

  public void onIntermediateImageFailed(String paramString, Throwable paramThrowable)
  {
  }

  public void onIntermediateImageSet(String paramString, @Nullable Object paramObject)
  {
  }

  public void onRelease(String paramString)
  {
  }

  public void onSubmit(String paramString, Object paramObject)
  {
    if ((this.mCallback != null) && (this.mReactTag != 0))
      this.mCallback.dispatchImageLoadEvent(this.mReactTag, 4);
  }

  public void setBorderColor(int paramInt)
  {
    this.mBorderColor = paramInt;
  }

  public void setBorderRadius(float paramFloat)
  {
    this.mBorderRadius = paramFloat;
  }

  public void setBorderWidth(float paramFloat)
  {
    this.mBorderWidth = paramFloat;
  }

  public void setFadeDuration(int paramInt)
  {
    this.mFadeDuration = paramInt;
  }

  public void setProgressiveRenderingEnabled(boolean paramBoolean)
  {
    this.mProgressiveRenderingEnabled = paramBoolean;
  }

  public void setReactTag(int paramInt)
  {
    this.mReactTag = paramInt;
  }

  public void setScaleType(ScalingUtils.ScaleType paramScaleType)
  {
    this.mScaleType = paramScaleType;
  }

  public void setSource(Context paramContext, @Nullable ReadableArray paramReadableArray)
  {
    this.mSources.clear();
    if ((paramReadableArray != null) && (paramReadableArray.size() != 0))
    {
      if (paramReadableArray.size() != 1)
        break label68;
      paramReadableArray = paramReadableArray.getMap(0);
      this.mSources.add(new ImageSource(paramContext, paramReadableArray.getString("uri")));
    }
    while (true)
    {
      return;
      label68: int i = 0;
      while (i < paramReadableArray.size())
      {
        ReadableMap localReadableMap = paramReadableArray.getMap(i);
        this.mSources.add(new ImageSource(paramContext, localReadableMap.getString("uri"), localReadableMap.getDouble("width"), localReadableMap.getDouble("height")));
        i += 1;
      }
    }
  }

  public void setTintColor(int paramInt)
  {
    if (paramInt == 0)
    {
      this.mColorFilter = null;
      return;
    }
    this.mColorFilter = new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.DrawImageWithDrawee
 * JD-Core Version:    0.6.0
 */
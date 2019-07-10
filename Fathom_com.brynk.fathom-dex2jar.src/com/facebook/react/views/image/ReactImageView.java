package com.facebook.react.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.generic.RoundingParams.RoundingMethod;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.fresco.ReactNetworkImageRequest;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.imagehelper.ImageSource;
import com.facebook.react.views.imagehelper.MultiSourceHelper;
import com.facebook.react.views.imagehelper.MultiSourceHelper.MultiSourceResult;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.yoga.YogaConstants;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;

public class ReactImageView extends GenericDraweeView
{
  public static final int REMOTE_IMAGE_FADE_DURATION_MS = 300;
  private static float[] sComputedCornerRadii = new float[4];
  private static final Matrix sInverse;
  private static final Matrix sMatrix = new Matrix();
  private int mBorderColor;

  @Nullable
  private float[] mBorderCornerRadii;
  private float mBorderRadius = (0.0F / 0.0F);
  private float mBorderWidth;

  @Nullable
  private ImageSource mCachedImageSource;

  @Nullable
  private final Object mCallerContext;

  @Nullable
  private ControllerListener mControllerForTesting;

  @Nullable
  private ControllerListener mControllerListener;
  private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
  private int mFadeDurationMs = -1;

  @Nullable
  private GlobalImageLoadListener mGlobalImageLoadListener;
  private ReadableMap mHeaders;

  @Nullable
  private ImageSource mImageSource;
  private boolean mIsDirty;

  @Nullable
  private IterativeBoxBlurPostProcessor mIterativeBoxBlurPostProcessor;

  @Nullable
  private Drawable mLoadingImageDrawable;
  private int mOverlayColor;
  private boolean mProgressiveRenderingEnabled;
  private ImageResizeMethod mResizeMethod = ImageResizeMethod.AUTO;
  private final RoundedCornerPostprocessor mRoundedCornerPostprocessor;
  private ScalingUtils.ScaleType mScaleType = ImageResizeMode.defaultValue();
  private final List<ImageSource> mSources;

  static
  {
    sInverse = new Matrix();
  }

  public ReactImageView(Context paramContext, AbstractDraweeControllerBuilder paramAbstractDraweeControllerBuilder, @Nullable GlobalImageLoadListener paramGlobalImageLoadListener, @Nullable Object paramObject)
  {
    super(paramContext, buildHierarchy(paramContext));
    this.mDraweeControllerBuilder = paramAbstractDraweeControllerBuilder;
    this.mRoundedCornerPostprocessor = new RoundedCornerPostprocessor(null);
    this.mGlobalImageLoadListener = paramGlobalImageLoadListener;
    this.mCallerContext = paramObject;
    this.mSources = new LinkedList();
  }

  private static GenericDraweeHierarchy buildHierarchy(Context paramContext)
  {
    return new GenericDraweeHierarchyBuilder(paramContext.getResources()).setRoundingParams(RoundingParams.fromCornersRadius(0.0F)).build();
  }

  private void cornerRadii(float[] paramArrayOfFloat)
  {
    float f1;
    float f2;
    if (!YogaConstants.isUndefined(this.mBorderRadius))
    {
      f1 = this.mBorderRadius;
      if ((this.mBorderCornerRadii == null) || (YogaConstants.isUndefined(this.mBorderCornerRadii[0])))
        break label145;
      f2 = this.mBorderCornerRadii[0];
      label41: paramArrayOfFloat[0] = f2;
      if ((this.mBorderCornerRadii == null) || (YogaConstants.isUndefined(this.mBorderCornerRadii[1])))
        break label150;
      f2 = this.mBorderCornerRadii[1];
      label71: paramArrayOfFloat[1] = f2;
      if ((this.mBorderCornerRadii == null) || (YogaConstants.isUndefined(this.mBorderCornerRadii[2])))
        break label155;
      f2 = this.mBorderCornerRadii[2];
    }
    while (true)
    {
      paramArrayOfFloat[2] = f2;
      f2 = f1;
      if (this.mBorderCornerRadii != null)
      {
        f2 = f1;
        if (!YogaConstants.isUndefined(this.mBorderCornerRadii[3]))
          f2 = this.mBorderCornerRadii[3];
      }
      paramArrayOfFloat[3] = f2;
      return;
      f1 = 0.0F;
      break;
      label145: f2 = f1;
      break label41;
      label150: f2 = f1;
      break label71;
      label155: f2 = f1;
    }
  }

  private boolean hasMultipleSources()
  {
    return this.mSources.size() > 1;
  }

  private void setSourceImage()
  {
    this.mImageSource = null;
    if (this.mSources.isEmpty())
      return;
    if (hasMultipleSources())
    {
      MultiSourceHelper.MultiSourceResult localMultiSourceResult = MultiSourceHelper.getBestSourceForSize(getWidth(), getHeight(), this.mSources);
      this.mImageSource = localMultiSourceResult.getBestResult();
      this.mCachedImageSource = localMultiSourceResult.getBestResultInCache();
      return;
    }
    this.mImageSource = ((ImageSource)this.mSources.get(0));
  }

  private boolean shouldResize(ImageSource paramImageSource)
  {
    int i = 0;
    if (this.mResizeMethod == ImageResizeMethod.AUTO)
      if ((UriUtil.isLocalContentUri(paramImageSource.getUri())) || (UriUtil.isLocalFileUri(paramImageSource.getUri())))
        i = 1;
    do
      return i;
    while (this.mResizeMethod != ImageResizeMethod.RESIZE);
    return true;
  }

  private void warnImageSource(String paramString)
  {
  }

  public boolean hasOverlappingRendering()
  {
    return false;
  }

  public void maybeUpdateView()
  {
    if (!this.mIsDirty);
    boolean bool;
    do
    {
      do
      {
        do
          return;
        while ((hasMultipleSources()) && ((getWidth() <= 0) || (getHeight() <= 0)));
        setSourceImage();
      }
      while (this.mImageSource == null);
      bool = shouldResize(this.mImageSource);
    }
    while ((bool) && ((getWidth() <= 0) || (getHeight() <= 0)));
    Object localObject1 = (GenericDraweeHierarchy)getHierarchy();
    ((GenericDraweeHierarchy)localObject1).setActualImageScaleType(this.mScaleType);
    if (this.mLoadingImageDrawable != null)
      ((GenericDraweeHierarchy)localObject1).setPlaceholderImage(this.mLoadingImageDrawable, ScalingUtils.ScaleType.CENTER);
    int j;
    Object localObject2;
    label144: label175: int i;
    if ((this.mScaleType != ScalingUtils.ScaleType.CENTER_CROP) && (this.mScaleType != ScalingUtils.ScaleType.FOCUS_CROP))
    {
      j = 1;
      localObject2 = ((GenericDraweeHierarchy)localObject1).getRoundingParams();
      if (j == 0)
        break label467;
      ((RoundingParams)localObject2).setCornersRadius(0.0F);
      ((RoundingParams)localObject2).setBorder(this.mBorderColor, this.mBorderWidth);
      if (this.mOverlayColor == 0)
        break label503;
      ((RoundingParams)localObject2).setOverlayColor(this.mOverlayColor);
      ((GenericDraweeHierarchy)localObject1).setRoundingParams((RoundingParams)localObject2);
      if (this.mFadeDurationMs < 0)
        break label515;
      i = this.mFadeDurationMs;
      label194: ((GenericDraweeHierarchy)localObject1).setFadeDuration(i);
      localObject1 = null;
      if (j == 0)
        break label537;
      localObject1 = this.mRoundedCornerPostprocessor;
      label213: if (!bool)
        break label553;
      localObject2 = new ResizeOptions(getWidth(), getHeight());
      label234: ReactNetworkImageRequest localReactNetworkImageRequest = ReactNetworkImageRequest.fromBuilderWithHeaders(ImageRequestBuilder.newBuilderWithSource(this.mImageSource.getUri()).setPostprocessor((Postprocessor)localObject1).setResizeOptions((ResizeOptions)localObject2).setAutoRotateEnabled(true).setProgressiveRenderingEnabled(this.mProgressiveRenderingEnabled), this.mHeaders);
      if (this.mGlobalImageLoadListener != null)
        this.mGlobalImageLoadListener.onLoadAttempt(this.mImageSource.getUri());
      this.mDraweeControllerBuilder.reset();
      this.mDraweeControllerBuilder.setAutoPlayAnimations(true).setCallerContext(this.mCallerContext).setOldController(getController()).setImageRequest(localReactNetworkImageRequest);
      if (this.mCachedImageSource != null)
      {
        localObject1 = ImageRequestBuilder.newBuilderWithSource(this.mCachedImageSource.getUri()).setPostprocessor((Postprocessor)localObject1).setResizeOptions((ResizeOptions)localObject2).setAutoRotateEnabled(true).setProgressiveRenderingEnabled(this.mProgressiveRenderingEnabled).build();
        this.mDraweeControllerBuilder.setLowResImageRequest(localObject1);
      }
      if ((this.mControllerListener == null) || (this.mControllerForTesting == null))
        break label559;
      localObject1 = new ForwardingControllerListener();
      ((ForwardingControllerListener)localObject1).addListener(this.mControllerListener);
      ((ForwardingControllerListener)localObject1).addListener(this.mControllerForTesting);
      this.mDraweeControllerBuilder.setControllerListener((ControllerListener)localObject1);
    }
    while (true)
    {
      setController(this.mDraweeControllerBuilder.build());
      this.mIsDirty = false;
      this.mDraweeControllerBuilder.reset();
      return;
      j = 0;
      break;
      label467: cornerRadii(sComputedCornerRadii);
      ((RoundingParams)localObject2).setCornersRadii(sComputedCornerRadii[0], sComputedCornerRadii[1], sComputedCornerRadii[2], sComputedCornerRadii[3]);
      break label144;
      label503: ((RoundingParams)localObject2).setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
      break label175;
      label515: if (this.mImageSource.isResource())
      {
        i = 0;
        break label194;
      }
      i = 300;
      break label194;
      label537: if (this.mIterativeBoxBlurPostProcessor == null)
        break label213;
      localObject1 = this.mIterativeBoxBlurPostProcessor;
      break label213;
      label553: localObject2 = null;
      break label234;
      label559: if (this.mControllerForTesting != null)
      {
        this.mDraweeControllerBuilder.setControllerListener(this.mControllerForTesting);
        continue;
      }
      if (this.mControllerListener == null)
        continue;
      this.mDraweeControllerBuilder.setControllerListener(this.mControllerListener);
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 > 0) && (paramInt2 > 0))
      if ((!this.mIsDirty) && (!hasMultipleSources()))
        break label45;
    label45: for (boolean bool = true; ; bool = false)
    {
      this.mIsDirty = bool;
      maybeUpdateView();
      return;
    }
  }

  public void setBlurRadius(float paramFloat)
  {
    if (paramFloat == 0.0F);
    for (this.mIterativeBoxBlurPostProcessor = null; ; this.mIterativeBoxBlurPostProcessor = new IterativeBoxBlurPostProcessor((int)PixelUtil.toPixelFromDIP(paramFloat)))
    {
      this.mIsDirty = true;
      return;
    }
  }

  public void setBorderColor(int paramInt)
  {
    this.mBorderColor = paramInt;
    this.mIsDirty = true;
  }

  public void setBorderRadius(float paramFloat)
  {
    if (!FloatUtil.floatsEqual(this.mBorderRadius, paramFloat))
    {
      this.mBorderRadius = paramFloat;
      this.mIsDirty = true;
    }
  }

  public void setBorderRadius(float paramFloat, int paramInt)
  {
    if (this.mBorderCornerRadii == null)
    {
      this.mBorderCornerRadii = new float[4];
      Arrays.fill(this.mBorderCornerRadii, (0.0F / 0.0F));
    }
    if (!FloatUtil.floatsEqual(this.mBorderCornerRadii[paramInt], paramFloat))
    {
      this.mBorderCornerRadii[paramInt] = paramFloat;
      this.mIsDirty = true;
    }
  }

  public void setBorderWidth(float paramFloat)
  {
    this.mBorderWidth = PixelUtil.toPixelFromDIP(paramFloat);
    this.mIsDirty = true;
  }

  public void setControllerListener(ControllerListener paramControllerListener)
  {
    this.mControllerForTesting = paramControllerListener;
    this.mIsDirty = true;
    maybeUpdateView();
  }

  public void setFadeDuration(int paramInt)
  {
    this.mFadeDurationMs = paramInt;
  }

  public void setHeaders(ReadableMap paramReadableMap)
  {
    this.mHeaders = paramReadableMap;
  }

  public void setLoadingIndicatorSource(@Nullable String paramString)
  {
    paramString = ResourceDrawableIdHelper.getInstance().getResourceDrawable(getContext(), paramString);
    if (paramString != null);
    for (paramString = new AutoRotateDrawable(paramString, 1000); ; paramString = null)
    {
      this.mLoadingImageDrawable = paramString;
      this.mIsDirty = true;
      return;
    }
  }

  public void setOverlayColor(int paramInt)
  {
    this.mOverlayColor = paramInt;
    this.mIsDirty = true;
  }

  public void setProgressiveRenderingEnabled(boolean paramBoolean)
  {
    this.mProgressiveRenderingEnabled = paramBoolean;
  }

  public void setResizeMethod(ImageResizeMethod paramImageResizeMethod)
  {
    this.mResizeMethod = paramImageResizeMethod;
    this.mIsDirty = true;
  }

  public void setScaleType(ScalingUtils.ScaleType paramScaleType)
  {
    this.mScaleType = paramScaleType;
    this.mIsDirty = true;
  }

  public void setShouldNotifyLoadEvents(boolean paramBoolean)
  {
    if (!paramBoolean);
    for (this.mControllerListener = null; ; this.mControllerListener = new BaseControllerListener(((UIManagerModule)((ReactContext)getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher())
    {
      public void onFailure(String paramString, Throwable paramThrowable)
      {
        this.val$mEventDispatcher.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 1));
        this.val$mEventDispatcher.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 3));
      }

      public void onFinalImageSet(String paramString, @Nullable ImageInfo paramImageInfo, @Nullable Animatable paramAnimatable)
      {
        if (paramImageInfo != null)
        {
          this.val$mEventDispatcher.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 2, ReactImageView.this.mImageSource.getSource(), paramImageInfo.getWidth(), paramImageInfo.getHeight()));
          this.val$mEventDispatcher.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 3));
        }
      }

      public void onSubmit(String paramString, Object paramObject)
      {
        this.val$mEventDispatcher.dispatchEvent(new ImageLoadEvent(ReactImageView.this.getId(), 4));
      }
    })
    {
      this.mIsDirty = true;
      return;
    }
  }

  public void setSource(@Nullable ReadableArray paramReadableArray)
  {
    this.mSources.clear();
    Object localObject1;
    if ((paramReadableArray != null) && (paramReadableArray.size() != 0))
    {
      if (paramReadableArray.size() != 1)
        break label96;
      paramReadableArray = paramReadableArray.getMap(0).getString("uri");
      localObject1 = new ImageSource(getContext(), paramReadableArray);
      this.mSources.add(localObject1);
      if (Uri.EMPTY.equals(((ImageSource)localObject1).getUri()))
        warnImageSource(paramReadableArray);
    }
    while (true)
    {
      this.mIsDirty = true;
      return;
      label96: int i = 0;
      while (i < paramReadableArray.size())
      {
        Object localObject2 = paramReadableArray.getMap(i);
        localObject1 = ((ReadableMap)localObject2).getString("uri");
        localObject2 = new ImageSource(getContext(), (String)localObject1, ((ReadableMap)localObject2).getDouble("width"), ((ReadableMap)localObject2).getDouble("height"));
        this.mSources.add(localObject2);
        if (Uri.EMPTY.equals(((ImageSource)localObject2).getUri()))
          warnImageSource((String)localObject1);
        i += 1;
      }
    }
  }

  private class RoundedCornerPostprocessor extends BasePostprocessor
  {
    private RoundedCornerPostprocessor()
    {
    }

    void getRadii(Bitmap paramBitmap, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
    {
      ReactImageView.this.mScaleType.getTransform(ReactImageView.sMatrix, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), paramBitmap.getWidth(), paramBitmap.getHeight(), 0.0F, 0.0F);
      ReactImageView.sMatrix.invert(ReactImageView.sInverse);
      paramArrayOfFloat2[0] = ReactImageView.access$200().mapRadius(paramArrayOfFloat1[0]);
      paramArrayOfFloat2[1] = paramArrayOfFloat2[0];
      paramArrayOfFloat2[2] = ReactImageView.access$200().mapRadius(paramArrayOfFloat1[1]);
      paramArrayOfFloat2[3] = paramArrayOfFloat2[2];
      paramArrayOfFloat2[4] = ReactImageView.access$200().mapRadius(paramArrayOfFloat1[2]);
      paramArrayOfFloat2[5] = paramArrayOfFloat2[4];
      paramArrayOfFloat2[6] = ReactImageView.access$200().mapRadius(paramArrayOfFloat1[3]);
      paramArrayOfFloat2[7] = paramArrayOfFloat2[6];
    }

    public void process(Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      ReactImageView.this.cornerRadii(ReactImageView.sComputedCornerRadii);
      paramBitmap1.setHasAlpha(true);
      if ((FloatUtil.floatsEqual(ReactImageView.sComputedCornerRadii[0], 0.0F)) && (FloatUtil.floatsEqual(ReactImageView.sComputedCornerRadii[1], 0.0F)) && (FloatUtil.floatsEqual(ReactImageView.sComputedCornerRadii[2], 0.0F)) && (FloatUtil.floatsEqual(ReactImageView.sComputedCornerRadii[3], 0.0F)))
      {
        super.process(paramBitmap1, paramBitmap2);
        return;
      }
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setShader(new BitmapShader(paramBitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
      paramBitmap1 = new Canvas(paramBitmap1);
      float[] arrayOfFloat = new float[8];
      getRadii(paramBitmap2, ReactImageView.sComputedCornerRadii, arrayOfFloat);
      Path localPath = new Path();
      localPath.addRoundRect(new RectF(0.0F, 0.0F, paramBitmap2.getWidth(), paramBitmap2.getHeight()), arrayOfFloat, Path.Direction.CW);
      paramBitmap1.drawPath(localPath, localPaint);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.image.ReactImageView
 * JD-Core Version:    0.6.0
 */
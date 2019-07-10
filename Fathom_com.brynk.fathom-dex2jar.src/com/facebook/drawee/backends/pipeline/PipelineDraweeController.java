package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class PipelineDraweeController extends AbstractDraweeController<CloseableReference<CloseableImage>, ImageInfo>
{
  private static final Class<?> TAG = PipelineDraweeController.class;
  private final AnimatedDrawableFactory mAnimatedDrawableFactory;
  private CacheKey mCacheKey;
  private Supplier<DataSource<CloseableReference<CloseableImage>>> mDataSourceSupplier;
  private final DrawableFactory mDefaultDrawableFactory = new DrawableFactory()
  {
    public Drawable createDrawable(CloseableImage paramCloseableImage)
    {
      if ((paramCloseableImage instanceof CloseableStaticBitmap))
      {
        paramCloseableImage = (CloseableStaticBitmap)paramCloseableImage;
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(PipelineDraweeController.this.mResources, paramCloseableImage.getUnderlyingBitmap());
        if ((paramCloseableImage.getRotationAngle() == 0) || (paramCloseableImage.getRotationAngle() == -1))
          return localBitmapDrawable;
        return new OrientedDrawable(localBitmapDrawable, paramCloseableImage.getRotationAngle());
      }
      if (PipelineDraweeController.this.mAnimatedDrawableFactory != null)
        return PipelineDraweeController.this.mAnimatedDrawableFactory.create(paramCloseableImage);
      return null;
    }

    public boolean supportsImageType(CloseableImage paramCloseableImage)
    {
      return true;
    }
  };
  private boolean mDrawDebugOverlay;

  @Nullable
  private final ImmutableList<DrawableFactory> mDrawableFactories;

  @Nullable
  private MemoryCache<CacheKey, CloseableImage> mMemoryCache;
  private final Resources mResources;

  public PipelineDraweeController(Resources paramResources, DeferredReleaser paramDeferredReleaser, AnimatedDrawableFactory paramAnimatedDrawableFactory, Executor paramExecutor, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier, String paramString, CacheKey paramCacheKey, Object paramObject)
  {
    this(paramResources, paramDeferredReleaser, paramAnimatedDrawableFactory, paramExecutor, paramMemoryCache, paramSupplier, paramString, paramCacheKey, paramObject, null);
  }

  public PipelineDraweeController(Resources paramResources, DeferredReleaser paramDeferredReleaser, AnimatedDrawableFactory paramAnimatedDrawableFactory, Executor paramExecutor, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier, String paramString, CacheKey paramCacheKey, Object paramObject, @Nullable ImmutableList<DrawableFactory> paramImmutableList)
  {
    super(paramDeferredReleaser, paramExecutor, paramString, paramObject);
    this.mResources = paramResources;
    this.mAnimatedDrawableFactory = paramAnimatedDrawableFactory;
    this.mMemoryCache = paramMemoryCache;
    this.mCacheKey = paramCacheKey;
    this.mDrawableFactories = paramImmutableList;
    init(paramSupplier);
  }

  private void init(Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier)
  {
    this.mDataSourceSupplier = paramSupplier;
    maybeUpdateDebugOverlay(null);
  }

  private void maybeUpdateDebugOverlay(@Nullable CloseableImage paramCloseableImage)
  {
    if (!this.mDrawDebugOverlay);
    do
    {
      return;
      localObject2 = getControllerOverlay();
      localObject1 = localObject2;
      if (localObject2 != null)
        continue;
      localObject1 = new DebugControllerOverlayDrawable();
      setControllerOverlay((Drawable)localObject1);
    }
    while (!(localObject1 instanceof DebugControllerOverlayDrawable));
    Object localObject2 = (DebugControllerOverlayDrawable)localObject1;
    ((DebugControllerOverlayDrawable)localObject2).setControllerId(getId());
    DraweeHierarchy localDraweeHierarchy = getHierarchy();
    Object localObject1 = null;
    if (localDraweeHierarchy != null)
    {
      localObject1 = ScalingUtils.getActiveScaleTypeDrawable(localDraweeHierarchy.getTopLevelDrawable());
      if (localObject1 == null)
        break label115;
    }
    label115: for (localObject1 = ((ScaleTypeDrawable)localObject1).getScaleType(); ; localObject1 = null)
    {
      ((DebugControllerOverlayDrawable)localObject2).setScaleType((ScalingUtils.ScaleType)localObject1);
      if (paramCloseableImage == null)
        break;
      ((DebugControllerOverlayDrawable)localObject2).setDimensions(paramCloseableImage.getWidth(), paramCloseableImage.getHeight());
      ((DebugControllerOverlayDrawable)localObject2).setImageSize(paramCloseableImage.getSizeInBytes());
      return;
    }
    ((DebugControllerOverlayDrawable)localObject2).reset();
  }

  protected Drawable createDrawable(CloseableReference<CloseableImage> paramCloseableReference)
  {
    Preconditions.checkState(CloseableReference.isValid(paramCloseableReference));
    paramCloseableReference = (CloseableImage)paramCloseableReference.get();
    maybeUpdateDebugOverlay(paramCloseableReference);
    if (this.mDrawableFactories != null)
    {
      localObject1 = this.mDrawableFactories.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (DrawableFactory)((Iterator)localObject1).next();
        if (!((DrawableFactory)localObject2).supportsImageType(paramCloseableReference))
          continue;
        localObject2 = ((DrawableFactory)localObject2).createDrawable(paramCloseableReference);
        if (localObject2 != null)
          return localObject2;
      }
    }
    Object localObject1 = this.mDefaultDrawableFactory.createDrawable(paramCloseableReference);
    if (localObject1 != null)
      return localObject1;
    throw new UnsupportedOperationException("Unrecognized image class: " + paramCloseableReference);
  }

  protected CloseableReference<CloseableImage> getCachedImage()
  {
    Object localObject;
    if ((this.mMemoryCache == null) || (this.mCacheKey == null))
      localObject = null;
    CloseableReference localCloseableReference;
    do
    {
      do
      {
        return localObject;
        localCloseableReference = this.mMemoryCache.get(this.mCacheKey);
        localObject = localCloseableReference;
      }
      while (localCloseableReference == null);
      localObject = localCloseableReference;
    }
    while (((CloseableImage)localCloseableReference.get()).getQualityInfo().isOfFullQuality());
    localCloseableReference.close();
    return null;
  }

  protected DataSource<CloseableReference<CloseableImage>> getDataSource()
  {
    if (FLog.isLoggable(2))
      FLog.v(TAG, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
    return (DataSource)this.mDataSourceSupplier.get();
  }

  protected int getImageHash(@Nullable CloseableReference<CloseableImage> paramCloseableReference)
  {
    if (paramCloseableReference != null)
      return paramCloseableReference.getValueHash();
    return 0;
  }

  protected ImageInfo getImageInfo(CloseableReference<CloseableImage> paramCloseableReference)
  {
    Preconditions.checkState(CloseableReference.isValid(paramCloseableReference));
    return (ImageInfo)paramCloseableReference.get();
  }

  protected Resources getResources()
  {
    return this.mResources;
  }

  public void initialize(Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier, String paramString, CacheKey paramCacheKey, Object paramObject)
  {
    super.initialize(paramString, paramObject);
    init(paramSupplier);
    this.mCacheKey = paramCacheKey;
  }

  protected void releaseDrawable(@Nullable Drawable paramDrawable)
  {
    if ((paramDrawable instanceof DrawableWithCaches))
      ((DrawableWithCaches)paramDrawable).dropCaches();
  }

  protected void releaseImage(@Nullable CloseableReference<CloseableImage> paramCloseableReference)
  {
    CloseableReference.closeSafely(paramCloseableReference);
  }

  public void setDrawDebugOverlay(boolean paramBoolean)
  {
    this.mDrawDebugOverlay = paramBoolean;
  }

  public void setHierarchy(@Nullable DraweeHierarchy paramDraweeHierarchy)
  {
    super.setHierarchy(paramDraweeHierarchy);
    maybeUpdateDebugOverlay(null);
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("super", super.toString()).add("dataSourceSupplier", this.mDataSourceSupplier).toString();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.PipelineDraweeController
 * JD-Core Version:    0.6.0
 */
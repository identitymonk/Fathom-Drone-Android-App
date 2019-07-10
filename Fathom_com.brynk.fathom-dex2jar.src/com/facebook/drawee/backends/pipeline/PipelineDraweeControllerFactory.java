package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class PipelineDraweeControllerFactory
{
  private AnimatedDrawableFactory mAnimatedDrawableFactory;

  @Nullable
  private Supplier<Boolean> mDebugOverlayEnabledSupplier;
  private DeferredReleaser mDeferredReleaser;

  @Nullable
  private ImmutableList<DrawableFactory> mDrawableFactories;
  private MemoryCache<CacheKey, CloseableImage> mMemoryCache;
  private Resources mResources;
  private Executor mUiThreadExecutor;

  public void init(Resources paramResources, DeferredReleaser paramDeferredReleaser, AnimatedDrawableFactory paramAnimatedDrawableFactory, Executor paramExecutor, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, @Nullable ImmutableList<DrawableFactory> paramImmutableList, @Nullable Supplier<Boolean> paramSupplier)
  {
    this.mResources = paramResources;
    this.mDeferredReleaser = paramDeferredReleaser;
    this.mAnimatedDrawableFactory = paramAnimatedDrawableFactory;
    this.mUiThreadExecutor = paramExecutor;
    this.mMemoryCache = paramMemoryCache;
    this.mDrawableFactories = paramImmutableList;
    this.mDebugOverlayEnabledSupplier = paramSupplier;
  }

  protected PipelineDraweeController internalCreateController(Resources paramResources, DeferredReleaser paramDeferredReleaser, AnimatedDrawableFactory paramAnimatedDrawableFactory, Executor paramExecutor, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, @Nullable ImmutableList<DrawableFactory> paramImmutableList, Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier, String paramString, CacheKey paramCacheKey, Object paramObject)
  {
    return new PipelineDraweeController(paramResources, paramDeferredReleaser, paramAnimatedDrawableFactory, paramExecutor, paramMemoryCache, paramSupplier, paramString, paramCacheKey, paramObject, paramImmutableList);
  }

  public PipelineDraweeController newController(Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier, String paramString, CacheKey paramCacheKey, Object paramObject)
  {
    if (this.mResources != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "init() not called");
      paramSupplier = internalCreateController(this.mResources, this.mDeferredReleaser, this.mAnimatedDrawableFactory, this.mUiThreadExecutor, this.mMemoryCache, this.mDrawableFactories, paramSupplier, paramString, paramCacheKey, paramObject);
      if (this.mDebugOverlayEnabledSupplier != null)
        paramSupplier.setDrawDebugOverlay(((Boolean)this.mDebugOverlayEnabledSupplier.get()).booleanValue());
      return paramSupplier;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.PipelineDraweeControllerFactory
 * JD-Core Version:    0.6.0
 */
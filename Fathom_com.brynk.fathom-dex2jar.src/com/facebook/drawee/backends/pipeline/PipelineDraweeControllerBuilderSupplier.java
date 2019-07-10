package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import java.util.Set;
import javax.annotation.Nullable;

public class PipelineDraweeControllerBuilderSupplier
  implements Supplier<PipelineDraweeControllerBuilder>
{
  private final Set<ControllerListener> mBoundControllerListeners;
  private final Context mContext;
  private final ImagePipeline mImagePipeline;
  private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

  public PipelineDraweeControllerBuilderSupplier(Context paramContext)
  {
    this(paramContext, null);
  }

  public PipelineDraweeControllerBuilderSupplier(Context paramContext, @Nullable DraweeConfig paramDraweeConfig)
  {
    this(paramContext, ImagePipelineFactory.getInstance(), paramDraweeConfig);
  }

  public PipelineDraweeControllerBuilderSupplier(Context paramContext, ImagePipelineFactory paramImagePipelineFactory, @Nullable DraweeConfig paramDraweeConfig)
  {
    this(paramContext, paramImagePipelineFactory, null, paramDraweeConfig);
  }

  public PipelineDraweeControllerBuilderSupplier(Context paramContext, ImagePipelineFactory paramImagePipelineFactory, Set<ControllerListener> paramSet, @Nullable DraweeConfig paramDraweeConfig)
  {
    this.mContext = paramContext;
    this.mImagePipeline = paramImagePipelineFactory.getImagePipeline();
    Object localObject = paramImagePipelineFactory.getAnimatedFactory();
    paramImagePipelineFactory = null;
    if (localObject != null)
      paramImagePipelineFactory = ((AnimatedFactory)localObject).getAnimatedDrawableFactory(paramContext);
    Resources localResources;
    DeferredReleaser localDeferredReleaser;
    UiThreadImmediateExecutorService localUiThreadImmediateExecutorService;
    MemoryCache localMemoryCache;
    if ((paramDraweeConfig != null) && (paramDraweeConfig.getPipelineDraweeControllerFactory() != null))
    {
      this.mPipelineDraweeControllerFactory = paramDraweeConfig.getPipelineDraweeControllerFactory();
      localObject = this.mPipelineDraweeControllerFactory;
      localResources = paramContext.getResources();
      localDeferredReleaser = DeferredReleaser.getInstance();
      localUiThreadImmediateExecutorService = UiThreadImmediateExecutorService.getInstance();
      localMemoryCache = this.mImagePipeline.getBitmapMemoryCache();
      if (paramDraweeConfig == null)
        break label155;
    }
    label155: for (paramContext = paramDraweeConfig.getCustomDrawableFactories(); ; paramContext = null)
    {
      if (paramDraweeConfig != null)
        localSupplier = paramDraweeConfig.getDebugOverlayEnabledSupplier();
      ((PipelineDraweeControllerFactory)localObject).init(localResources, localDeferredReleaser, paramImagePipelineFactory, localUiThreadImmediateExecutorService, localMemoryCache, paramContext, localSupplier);
      this.mBoundControllerListeners = paramSet;
      return;
      this.mPipelineDraweeControllerFactory = new PipelineDraweeControllerFactory();
      break;
    }
  }

  public PipelineDraweeControllerBuilder get()
  {
    return new PipelineDraweeControllerBuilder(this.mContext, this.mPipelineDraweeControllerFactory, this.mImagePipeline, this.mBoundControllerListeners);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier
 * JD-Core Version:    0.6.0
 */
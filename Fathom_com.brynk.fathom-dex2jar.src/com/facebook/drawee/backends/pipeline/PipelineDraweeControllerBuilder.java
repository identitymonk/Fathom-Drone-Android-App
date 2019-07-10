package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder.CacheLevel;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Set;
import javax.annotation.Nullable;

public class PipelineDraweeControllerBuilder extends AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo>
{
  private final ImagePipeline mImagePipeline;
  private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

  public PipelineDraweeControllerBuilder(Context paramContext, PipelineDraweeControllerFactory paramPipelineDraweeControllerFactory, ImagePipeline paramImagePipeline, Set<ControllerListener> paramSet)
  {
    super(paramContext, paramSet);
    this.mImagePipeline = paramImagePipeline;
    this.mPipelineDraweeControllerFactory = paramPipelineDraweeControllerFactory;
  }

  public static ImageRequest.RequestLevel convertCacheLevelToRequestLevel(AbstractDraweeControllerBuilder.CacheLevel paramCacheLevel)
  {
    switch (1.$SwitchMap$com$facebook$drawee$controller$AbstractDraweeControllerBuilder$CacheLevel[paramCacheLevel.ordinal()])
    {
    default:
      throw new RuntimeException("Cache level" + paramCacheLevel + "is not supported. ");
    case 1:
      return ImageRequest.RequestLevel.FULL_FETCH;
    case 2:
      return ImageRequest.RequestLevel.DISK_CACHE;
    case 3:
    }
    return ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE;
  }

  private CacheKey getCacheKey()
  {
    ImageRequest localImageRequest = (ImageRequest)getImageRequest();
    CacheKeyFactory localCacheKeyFactory = this.mImagePipeline.getCacheKeyFactory();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localCacheKeyFactory != null)
    {
      localObject1 = localObject2;
      if (localImageRequest != null)
      {
        if (localImageRequest.getPostprocessor() == null)
          break label54;
        localObject1 = localCacheKeyFactory.getPostprocessedBitmapCacheKey(localImageRequest, getCallerContext());
      }
    }
    return localObject1;
    label54: return (CacheKey)localCacheKeyFactory.getBitmapCacheKey(localImageRequest, getCallerContext());
  }

  protected DataSource<CloseableReference<CloseableImage>> getDataSourceForRequest(ImageRequest paramImageRequest, Object paramObject, AbstractDraweeControllerBuilder.CacheLevel paramCacheLevel)
  {
    return this.mImagePipeline.fetchDecodedImage(paramImageRequest, paramObject, convertCacheLevelToRequestLevel(paramCacheLevel));
  }

  protected PipelineDraweeControllerBuilder getThis()
  {
    return this;
  }

  protected PipelineDraweeController obtainController()
  {
    Object localObject = getOldController();
    if ((localObject instanceof PipelineDraweeController))
    {
      localObject = (PipelineDraweeController)localObject;
      ((PipelineDraweeController)localObject).initialize(obtainDataSourceSupplier(), generateUniqueControllerId(), getCacheKey(), getCallerContext());
      return localObject;
    }
    return (PipelineDraweeController)this.mPipelineDraweeControllerFactory.newController(obtainDataSourceSupplier(), generateUniqueControllerId(), getCacheKey(), getCallerContext());
  }

  public PipelineDraweeControllerBuilder setUri(@Nullable Uri paramUri)
  {
    if (paramUri == null)
      return (PipelineDraweeControllerBuilder)super.setImageRequest(null);
    return (PipelineDraweeControllerBuilder)super.setImageRequest(ImageRequestBuilder.newBuilderWithSource(paramUri).setRotationOptions(RotationOptions.autoRotateAtRenderTime()).build());
  }

  public PipelineDraweeControllerBuilder setUri(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
      return (PipelineDraweeControllerBuilder)super.setImageRequest(ImageRequest.fromUri(paramString));
    return setUri(Uri.parse(paramString));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder
 * JD-Core Version:    0.6.0
 */
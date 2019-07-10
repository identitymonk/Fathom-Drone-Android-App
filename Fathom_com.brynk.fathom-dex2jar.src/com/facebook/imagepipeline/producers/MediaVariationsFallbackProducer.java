package com.facebook.imagepipeline.producers;

import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.DiskCachePolicy;
import com.facebook.imagepipeline.cache.MediaIdExtractor;
import com.facebook.imagepipeline.cache.MediaVariationsIndex;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import com.facebook.imagepipeline.request.MediaVariations;
import com.facebook.imagepipeline.request.MediaVariations.Builder;
import com.facebook.imagepipeline.request.MediaVariations.Variant;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

public class MediaVariationsFallbackProducer
  implements Producer<EncodedImage>
{
  public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
  public static final String EXTRA_CACHED_VALUE_USED_AS_LAST = "cached_value_used_as_last";
  public static final String EXTRA_VARIANTS_COUNT = "variants_count";
  public static final String EXTRA_VARIANTS_SOURCE = "variants_source";
  public static final String PRODUCER_NAME = "MediaVariationsFallbackProducer";
  private final CacheKeyFactory mCacheKeyFactory;
  private final BufferedDiskCache mDefaultBufferedDiskCache;
  private final DiskCachePolicy mDiskCachePolicy;
  private final Producer<EncodedImage> mInputProducer;

  @Nullable
  private MediaIdExtractor mMediaIdExtractor;
  private final MediaVariationsIndex mMediaVariationsIndex;
  private final BufferedDiskCache mSmallImageBufferedDiskCache;

  public MediaVariationsFallbackProducer(BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, MediaVariationsIndex paramMediaVariationsIndex, @Nullable MediaIdExtractor paramMediaIdExtractor, DiskCachePolicy paramDiskCachePolicy, Producer<EncodedImage> paramProducer)
  {
    this.mDefaultBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mMediaVariationsIndex = paramMediaVariationsIndex;
    this.mMediaIdExtractor = paramMediaIdExtractor;
    this.mDiskCachePolicy = paramDiskCachePolicy;
    this.mInputProducer = paramProducer;
  }

  private Task attemptCacheReadForVariant(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext, ImageRequest paramImageRequest, MediaVariations paramMediaVariations, List<MediaVariations.Variant> paramList, int paramInt, AtomicBoolean paramAtomicBoolean)
  {
    Object localObject = (MediaVariations.Variant)paramList.get(paramInt);
    CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, ((MediaVariations.Variant)localObject).getUri(), paramProducerContext.getCallerContext());
    if (((MediaVariations.Variant)localObject).getCacheChoice() == null)
    {
      localObject = paramImageRequest.getCacheChoice();
      if (localObject != ImageRequest.CacheChoice.SMALL)
        break label103;
    }
    label103: for (localObject = this.mSmallImageBufferedDiskCache; ; localObject = this.mDefaultBufferedDiskCache)
    {
      return ((BufferedDiskCache)localObject).get(localCacheKey, paramAtomicBoolean).continueWith(onFinishDiskReads(paramConsumer, paramProducerContext, paramImageRequest, paramMediaVariations, paramList, paramInt, paramAtomicBoolean));
      localObject = ((MediaVariations.Variant)localObject).getCacheChoice();
      break;
    }
  }

  private Task chooseFromVariants(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext, ImageRequest paramImageRequest, MediaVariations paramMediaVariations, ResizeOptions paramResizeOptions, AtomicBoolean paramAtomicBoolean)
  {
    if (paramMediaVariations.getVariantsCount() == 0)
    {
      paramConsumer = onFinishDiskReads(paramConsumer, paramProducerContext, paramImageRequest, paramMediaVariations, Collections.emptyList(), 0, paramAtomicBoolean);
      return Task.forResult((EncodedImage)null).continueWith(paramConsumer);
    }
    return attemptCacheReadForVariant(paramConsumer, paramProducerContext, paramImageRequest, paramMediaVariations, paramMediaVariations.getSortedVariants(new VariantComparator(paramResizeOptions)), 0, paramAtomicBoolean);
  }

  @VisibleForTesting
  static Map<String, String> getExtraMap(ProducerListener paramProducerListener, String paramString1, boolean paramBoolean1, int paramInt, String paramString2, boolean paramBoolean2)
  {
    if (!paramProducerListener.requiresExtraMap(paramString1))
      return null;
    if (paramBoolean1)
      return ImmutableMap.of("cached_value_found", String.valueOf(true), "cached_value_used_as_last", String.valueOf(paramBoolean2), "variants_count", String.valueOf(paramInt), "variants_source", paramString2);
    return ImmutableMap.of("cached_value_found", String.valueOf(false), "variants_count", String.valueOf(paramInt), "variants_source", paramString2);
  }

  private static boolean isBigEnoughForRequestedSize(MediaVariations.Variant paramVariant, ResizeOptions paramResizeOptions)
  {
    return (paramVariant.getWidth() >= paramResizeOptions.width) && (paramVariant.getHeight() >= paramResizeOptions.height);
  }

  private static boolean isTaskCancelled(Task<?> paramTask)
  {
    return (paramTask.isCancelled()) || ((paramTask.isFaulted()) && ((paramTask.getError() instanceof CancellationException)));
  }

  private Continuation<EncodedImage, Void> onFinishDiskReads(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext, ImageRequest paramImageRequest, MediaVariations paramMediaVariations, List<MediaVariations.Variant> paramList, int paramInt, AtomicBoolean paramAtomicBoolean)
  {
    String str = paramProducerContext.getId();
    return new Continuation(paramProducerContext.getListener(), str, paramConsumer, paramProducerContext, paramMediaVariations, paramList, paramInt, paramImageRequest, paramAtomicBoolean)
    {
      public Void then(Task<EncodedImage> paramTask)
        throws Exception
      {
        int i;
        if (MediaVariationsFallbackProducer.access$200(paramTask))
        {
          this.val$listener.onProducerFinishWithCancellation(this.val$requestId, "MediaVariationsFallbackProducer", null);
          this.val$consumer.onCancellation();
          i = 0;
        }
        while (true)
        {
          if (i != 0)
            MediaVariationsFallbackProducer.this.startInputProducerWithWrappedConsumer(this.val$consumer, this.val$producerContext, this.val$mediaVariations.getMediaId());
          return null;
          if (paramTask.isFaulted())
          {
            this.val$listener.onProducerFinishWithFailure(this.val$requestId, "MediaVariationsFallbackProducer", paramTask.getError(), null);
            MediaVariationsFallbackProducer.this.startInputProducerWithWrappedConsumer(this.val$consumer, this.val$producerContext, this.val$mediaVariations.getMediaId());
            i = 1;
            continue;
          }
          paramTask = (EncodedImage)paramTask.getResult();
          if (paramTask != null)
          {
            boolean bool;
            if ((!this.val$mediaVariations.shouldForceRequestForSpecifiedUri()) && (MediaVariationsFallbackProducer.access$300((MediaVariations.Variant)this.val$sortedVariants.get(this.val$variantsIndex), this.val$imageRequest.getResizeOptions())))
            {
              bool = true;
              label169: this.val$listener.onProducerFinishWithSuccess(this.val$requestId, "MediaVariationsFallbackProducer", MediaVariationsFallbackProducer.getExtraMap(this.val$listener, this.val$requestId, true, this.val$sortedVariants.size(), this.val$mediaVariations.getSource(), bool));
              if (bool)
              {
                this.val$listener.onUltimateProducerReached(this.val$requestId, "MediaVariationsFallbackProducer", true);
                this.val$consumer.onProgressUpdate(1.0F);
              }
              this.val$consumer.onNewResult(paramTask, bool);
              paramTask.close();
              if (bool)
                break label272;
            }
            label272: for (i = 1; ; i = 0)
            {
              break;
              bool = false;
              break label169;
            }
          }
          if (this.val$variantsIndex < this.val$sortedVariants.size() - 1)
          {
            MediaVariationsFallbackProducer.this.attemptCacheReadForVariant(this.val$consumer, this.val$producerContext, this.val$imageRequest, this.val$mediaVariations, this.val$sortedVariants, this.val$variantsIndex + 1, this.val$isCancelled);
            i = 0;
            continue;
          }
          this.val$listener.onProducerFinishWithSuccess(this.val$requestId, "MediaVariationsFallbackProducer", MediaVariationsFallbackProducer.getExtraMap(this.val$listener, this.val$requestId, false, this.val$sortedVariants.size(), this.val$mediaVariations.getSource(), false));
          i = 1;
        }
      }
    };
  }

  private void startInputProducerWithExistingConsumer(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
  }

  private void startInputProducerWithWrappedConsumer(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext, String paramString)
  {
    this.mInputProducer.produceResults(new MediaVariationsConsumer(paramConsumer, paramProducerContext, paramString), paramProducerContext);
  }

  private void subscribeTaskForRequestCancellation(AtomicBoolean paramAtomicBoolean, ProducerContext paramProducerContext)
  {
    paramProducerContext.addCallbacks(new BaseProducerContextCallbacks(paramAtomicBoolean)
    {
      public void onCancellationRequested()
      {
        this.val$isCancelled.set(true);
      }
    });
  }

  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    ImageRequest localImageRequest = paramProducerContext.getImageRequest();
    ResizeOptions localResizeOptions = localImageRequest.getResizeOptions();
    MediaVariations localMediaVariations = localImageRequest.getMediaVariations();
    if ((!localImageRequest.isDiskCacheEnabled()) || (localResizeOptions == null) || (localResizeOptions.height <= 0) || (localResizeOptions.width <= 0))
    {
      startInputProducerWithExistingConsumer(paramConsumer, paramProducerContext);
      return;
    }
    String str;
    Object localObject;
    if (localMediaVariations == null)
      if (this.mMediaIdExtractor == null)
      {
        str = null;
        localObject = null;
      }
    while ((localMediaVariations == null) && (str == null))
    {
      startInputProducerWithExistingConsumer(paramConsumer, paramProducerContext);
      return;
      str = this.mMediaIdExtractor.getMediaIdFrom(localImageRequest.getSourceUri());
      localObject = "id_extractor";
      continue;
      str = localMediaVariations.getMediaId();
      localObject = "index_db";
    }
    paramProducerContext.getListener().onProducerStart(paramProducerContext.getId(), "MediaVariationsFallbackProducer");
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    if ((localMediaVariations != null) && (localMediaVariations.getVariantsCount() > 0))
    {
      chooseFromVariants(paramConsumer, paramProducerContext, localImageRequest, localMediaVariations, localResizeOptions, localAtomicBoolean);
      subscribeTaskForRequestCancellation(localAtomicBoolean, paramProducerContext);
      return;
    }
    MediaVariations.Builder localBuilder = MediaVariations.newBuilderForMediaId(str);
    if ((localMediaVariations != null) && (localMediaVariations.shouldForceRequestForSpecifiedUri()));
    for (boolean bool = true; ; bool = false)
    {
      localObject = localBuilder.setForceRequestForSpecifiedUri(bool).setSource((String)localObject);
      this.mMediaVariationsIndex.getCachedVariants(str, (MediaVariations.Builder)localObject).continueWith(new Continuation(paramConsumer, paramProducerContext, str, localImageRequest, localResizeOptions, localAtomicBoolean)
      {
        public Object then(Task<MediaVariations> paramTask)
          throws Exception
        {
          if ((paramTask.isCancelled()) || (paramTask.isFaulted()))
            return paramTask;
          try
          {
            if (paramTask.getResult() == null)
            {
              MediaVariationsFallbackProducer.this.startInputProducerWithWrappedConsumer(this.val$consumer, this.val$producerContext, this.val$mediaId);
              return null;
            }
            paramTask = MediaVariationsFallbackProducer.this.chooseFromVariants(this.val$consumer, this.val$producerContext, this.val$imageRequest, (MediaVariations)paramTask.getResult(), this.val$resizeOptions, this.val$isCancelled);
            return paramTask;
          }
          catch (Exception paramTask)
          {
          }
          return null;
        }
      });
      break;
    }
  }

  @VisibleForTesting
  class MediaVariationsConsumer extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private final String mMediaId;
    private final ProducerContext mProducerContext;

    public MediaVariationsConsumer(ProducerContext paramString, String arg3)
    {
      super();
      Object localObject1;
      this.mProducerContext = localObject1;
      Object localObject2;
      this.mMediaId = localObject2;
    }

    private void storeResultInDatabase(EncodedImage paramEncodedImage)
    {
      Object localObject = this.mProducerContext.getImageRequest();
      if ((!((ImageRequest)localObject).isDiskCacheEnabled()) || (this.mMediaId == null))
        return;
      ImageRequest.CacheChoice localCacheChoice = MediaVariationsFallbackProducer.this.mDiskCachePolicy.getCacheChoiceForResult((ImageRequest)localObject, paramEncodedImage);
      localObject = MediaVariationsFallbackProducer.this.mCacheKeyFactory.getEncodedCacheKey((ImageRequest)localObject, this.mProducerContext.getCallerContext());
      MediaVariationsFallbackProducer.this.mMediaVariationsIndex.saveCachedVariant(this.mMediaId, localCacheChoice, (CacheKey)localObject, paramEncodedImage);
    }

    protected void onNewResultImpl(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      if ((paramBoolean) && (paramEncodedImage != null))
        storeResultInDatabase(paramEncodedImage);
      getConsumer().onNewResult(paramEncodedImage, paramBoolean);
    }
  }

  @VisibleForTesting
  static class VariantComparator
    implements Comparator<MediaVariations.Variant>
  {
    private final ResizeOptions mResizeOptions;

    VariantComparator(ResizeOptions paramResizeOptions)
    {
      this.mResizeOptions = paramResizeOptions;
    }

    public int compare(MediaVariations.Variant paramVariant1, MediaVariations.Variant paramVariant2)
    {
      boolean bool1 = MediaVariationsFallbackProducer.access$300(paramVariant1, this.mResizeOptions);
      boolean bool2 = MediaVariationsFallbackProducer.access$300(paramVariant2, this.mResizeOptions);
      if ((bool1) && (bool2))
        return paramVariant1.getWidth() - paramVariant2.getWidth();
      if (bool1)
        return -1;
      if (bool2)
        return 1;
      return paramVariant2.getWidth() - paramVariant1.getWidth();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.MediaVariationsFallbackProducer
 * JD-Core Version:    0.6.0
 */
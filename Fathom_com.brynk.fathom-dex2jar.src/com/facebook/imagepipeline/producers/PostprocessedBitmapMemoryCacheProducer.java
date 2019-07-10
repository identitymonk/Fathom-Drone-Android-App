package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;

public class PostprocessedBitmapMemoryCacheProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  public static final String PRODUCER_NAME = "PostprocessedBitmapMemoryCacheProducer";

  @VisibleForTesting
  static final String VALUE_FOUND = "cached_value_found";
  private final CacheKeyFactory mCacheKeyFactory;
  private final Producer<CloseableReference<CloseableImage>> mInputProducer;
  private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

  public PostprocessedBitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> paramMemoryCache, CacheKeyFactory paramCacheKeyFactory, Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    this.mMemoryCache = paramMemoryCache;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mInputProducer = paramProducer;
  }

  protected String getProducerName()
  {
    return "PostprocessedBitmapMemoryCacheProducer";
  }

  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    String str1 = null;
    CachedPostprocessorConsumer localCachedPostprocessorConsumer = null;
    ProducerListener localProducerListener = paramProducerContext.getListener();
    String str2 = paramProducerContext.getId();
    Object localObject1 = paramProducerContext.getImageRequest();
    Object localObject2 = paramProducerContext.getCallerContext();
    Postprocessor localPostprocessor = ((ImageRequest)localObject1).getPostprocessor();
    if ((localPostprocessor == null) || (localPostprocessor.getPostprocessorCacheKey() == null))
    {
      this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
      return;
    }
    localProducerListener.onProducerStart(str2, getProducerName());
    localObject2 = this.mCacheKeyFactory.getPostprocessedBitmapCacheKey((ImageRequest)localObject1, localObject2);
    localObject1 = this.mMemoryCache.get(localObject2);
    if (localObject1 != null)
    {
      str1 = getProducerName();
      paramProducerContext = localCachedPostprocessorConsumer;
      if (localProducerListener.requiresExtraMap(str2))
        paramProducerContext = ImmutableMap.of("cached_value_found", "true");
      localProducerListener.onProducerFinishWithSuccess(str2, str1, paramProducerContext);
      localProducerListener.onUltimateProducerReached(str2, "PostprocessedBitmapMemoryCacheProducer", true);
      paramConsumer.onProgressUpdate(1.0F);
      paramConsumer.onNewResult(localObject1, true);
      ((CloseableReference)localObject1).close();
      return;
    }
    localCachedPostprocessorConsumer = new CachedPostprocessorConsumer(paramConsumer, (CacheKey)localObject2, localPostprocessor instanceof RepeatedPostprocessor, this.mMemoryCache);
    localObject1 = getProducerName();
    paramConsumer = str1;
    if (localProducerListener.requiresExtraMap(str2))
      paramConsumer = ImmutableMap.of("cached_value_found", "false");
    localProducerListener.onProducerFinishWithSuccess(str2, (String)localObject1, paramConsumer);
    this.mInputProducer.produceResults(localCachedPostprocessorConsumer, paramProducerContext);
  }

  public static class CachedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>
  {
    private final CacheKey mCacheKey;
    private final boolean mIsRepeatedProcessor;
    private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

    public CachedPostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> paramConsumer, CacheKey paramCacheKey, boolean paramBoolean, MemoryCache<CacheKey, CloseableImage> paramMemoryCache)
    {
      super();
      this.mCacheKey = paramCacheKey;
      this.mIsRepeatedProcessor = paramBoolean;
      this.mMemoryCache = paramMemoryCache;
    }

    protected void onNewResultImpl(CloseableReference<CloseableImage> paramCloseableReference, boolean paramBoolean)
    {
      if (paramCloseableReference == null)
        if (paramBoolean)
          getConsumer().onNewResult(null, true);
      do
        return;
      while ((!paramBoolean) && (!this.mIsRepeatedProcessor));
      CloseableReference localCloseableReference = this.mMemoryCache.cache(this.mCacheKey, paramCloseableReference);
      try
      {
        getConsumer().onProgressUpdate(1.0F);
        Consumer localConsumer = getConsumer();
        if (localCloseableReference != null)
          paramCloseableReference = localCloseableReference;
        localConsumer.onNewResult(paramCloseableReference, paramBoolean);
        return;
      }
      finally
      {
        CloseableReference.closeSafely(localCloseableReference);
      }
      throw paramCloseableReference;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer
 * JD-Core Version:    0.6.0
 */
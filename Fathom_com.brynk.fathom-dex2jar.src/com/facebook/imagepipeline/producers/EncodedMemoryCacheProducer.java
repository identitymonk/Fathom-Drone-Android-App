package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;

public class EncodedMemoryCacheProducer
  implements Producer<EncodedImage>
{
  public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
  public static final String PRODUCER_NAME = "EncodedMemoryCacheProducer";
  private final CacheKeyFactory mCacheKeyFactory;
  private final Producer<EncodedImage> mInputProducer;
  private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;

  public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache, CacheKeyFactory paramCacheKeyFactory, Producer<EncodedImage> paramProducer)
  {
    this.mMemoryCache = paramMemoryCache;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mInputProducer = paramProducer;
  }

  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    Object localObject1 = null;
    EncodedImage localEncodedImage = null;
    EncodedMemoryCacheConsumer localEncodedMemoryCacheConsumer = null;
    String str = paramProducerContext.getId();
    ProducerListener localProducerListener = paramProducerContext.getListener();
    localProducerListener.onProducerStart(str, "EncodedMemoryCacheProducer");
    Object localObject2 = paramProducerContext.getImageRequest();
    CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey((ImageRequest)localObject2, paramProducerContext.getCallerContext());
    localObject2 = this.mMemoryCache.get(localCacheKey);
    if (localObject2 != null)
      try
      {
        localEncodedImage = new EncodedImage((CloseableReference)localObject2);
        localEncodedImage.setEncodedCacheKey(localCacheKey);
        paramProducerContext = localEncodedMemoryCacheConsumer;
        try
        {
          if (localProducerListener.requiresExtraMap(str))
            paramProducerContext = ImmutableMap.of("cached_value_found", "true");
          localProducerListener.onProducerFinishWithSuccess(str, "EncodedMemoryCacheProducer", paramProducerContext);
          localProducerListener.onUltimateProducerReached(str, "EncodedMemoryCacheProducer", true);
          paramConsumer.onProgressUpdate(1.0F);
          paramConsumer.onNewResult(localEncodedImage, true);
          EncodedImage.closeSafely(localEncodedImage);
          CloseableReference.closeSafely((CloseableReference)localObject2);
          return;
        }
        finally
        {
          EncodedImage.closeSafely(localEncodedImage);
        }
      }
      finally
      {
        CloseableReference.closeSafely((CloseableReference)localObject2);
      }
    if (paramProducerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue())
    {
      paramProducerContext = localObject1;
      if (localProducerListener.requiresExtraMap(str))
        paramProducerContext = ImmutableMap.of("cached_value_found", "false");
      localProducerListener.onProducerFinishWithSuccess(str, "EncodedMemoryCacheProducer", paramProducerContext);
      localProducerListener.onUltimateProducerReached(str, "EncodedMemoryCacheProducer", false);
      paramConsumer.onNewResult(null, true);
      CloseableReference.closeSafely((CloseableReference)localObject2);
      return;
    }
    localEncodedMemoryCacheConsumer = new EncodedMemoryCacheConsumer(paramConsumer, this.mMemoryCache, localCacheKey);
    paramConsumer = localEncodedImage;
    if (localProducerListener.requiresExtraMap(str))
      paramConsumer = ImmutableMap.of("cached_value_found", "false");
    localProducerListener.onProducerFinishWithSuccess(str, "EncodedMemoryCacheProducer", paramConsumer);
    this.mInputProducer.produceResults(localEncodedMemoryCacheConsumer, paramProducerContext);
    CloseableReference.closeSafely((CloseableReference)localObject2);
  }

  private static class EncodedMemoryCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;
    private final CacheKey mRequestedCacheKey;

    public EncodedMemoryCacheConsumer(Consumer<EncodedImage> paramConsumer, MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache, CacheKey paramCacheKey)
    {
      super();
      this.mMemoryCache = paramMemoryCache;
      this.mRequestedCacheKey = paramCacheKey;
    }

    // ERROR //
    public void onNewResultImpl(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      // Byte code:
      //   0: iload_2
      //   1: ifeq +7 -> 8
      //   4: aload_1
      //   5: ifnonnull +15 -> 20
      //   8: aload_0
      //   9: invokevirtual 31	com/facebook/imagepipeline/producers/EncodedMemoryCacheProducer$EncodedMemoryCacheConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   12: aload_1
      //   13: iload_2
      //   14: invokeinterface 37 3 0
      //   19: return
      //   20: aload_1
      //   21: invokevirtual 43	com/facebook/imagepipeline/image/EncodedImage:getByteBufferRef	()Lcom/facebook/common/references/CloseableReference;
      //   24: astore 4
      //   26: aload 4
      //   28: ifnull +116 -> 144
      //   31: aload_1
      //   32: invokevirtual 47	com/facebook/imagepipeline/image/EncodedImage:getEncodedCacheKey	()Lcom/facebook/cache/common/CacheKey;
      //   35: ifnull +78 -> 113
      //   38: aload_1
      //   39: invokevirtual 47	com/facebook/imagepipeline/image/EncodedImage:getEncodedCacheKey	()Lcom/facebook/cache/common/CacheKey;
      //   42: astore_3
      //   43: aload_0
      //   44: getfield 20	com/facebook/imagepipeline/producers/EncodedMemoryCacheProducer$EncodedMemoryCacheConsumer:mMemoryCache	Lcom/facebook/imagepipeline/cache/MemoryCache;
      //   47: aload_3
      //   48: aload 4
      //   50: invokeinterface 53 3 0
      //   55: astore_3
      //   56: aload 4
      //   58: invokestatic 59	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   61: aload_3
      //   62: ifnull +82 -> 144
      //   65: new 39	com/facebook/imagepipeline/image/EncodedImage
      //   68: dup
      //   69: aload_3
      //   70: invokespecial 61	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
      //   73: astore 4
      //   75: aload 4
      //   77: aload_1
      //   78: invokevirtual 65	com/facebook/imagepipeline/image/EncodedImage:copyMetaDataFrom	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   81: aload_3
      //   82: invokestatic 59	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   85: aload_0
      //   86: invokevirtual 31	com/facebook/imagepipeline/producers/EncodedMemoryCacheProducer$EncodedMemoryCacheConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   89: fconst_1
      //   90: invokeinterface 69 2 0
      //   95: aload_0
      //   96: invokevirtual 31	com/facebook/imagepipeline/producers/EncodedMemoryCacheProducer$EncodedMemoryCacheConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   99: aload 4
      //   101: iconst_1
      //   102: invokeinterface 37 3 0
      //   107: aload 4
      //   109: invokestatic 71	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   112: return
      //   113: aload_0
      //   114: getfield 22	com/facebook/imagepipeline/producers/EncodedMemoryCacheProducer$EncodedMemoryCacheConsumer:mRequestedCacheKey	Lcom/facebook/cache/common/CacheKey;
      //   117: astore_3
      //   118: goto -75 -> 43
      //   121: astore_1
      //   122: aload 4
      //   124: invokestatic 59	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   127: aload_1
      //   128: athrow
      //   129: astore_1
      //   130: aload_3
      //   131: invokestatic 59	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   134: aload_1
      //   135: athrow
      //   136: astore_1
      //   137: aload 4
      //   139: invokestatic 71	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   142: aload_1
      //   143: athrow
      //   144: aload_0
      //   145: invokevirtual 31	com/facebook/imagepipeline/producers/EncodedMemoryCacheProducer$EncodedMemoryCacheConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   148: aload_1
      //   149: iconst_1
      //   150: invokeinterface 37 3 0
      //   155: return
      //
      // Exception table:
      //   from	to	target	type
      //   31	43	121	finally
      //   43	56	121	finally
      //   113	118	121	finally
      //   65	81	129	finally
      //   85	107	136	finally
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer
 * JD-Core Version:    0.6.0
 */
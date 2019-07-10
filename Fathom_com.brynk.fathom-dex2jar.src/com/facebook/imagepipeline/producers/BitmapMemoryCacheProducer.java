package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.Map;

public class BitmapMemoryCacheProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
  public static final String PRODUCER_NAME = "BitmapMemoryCacheProducer";
  private final CacheKeyFactory mCacheKeyFactory;
  private final Producer<CloseableReference<CloseableImage>> mInputProducer;
  private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

  public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> paramMemoryCache, CacheKeyFactory paramCacheKeyFactory, Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    this.mMemoryCache = paramMemoryCache;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mInputProducer = paramProducer;
  }

  protected String getProducerName()
  {
    return "BitmapMemoryCacheProducer";
  }

  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    Object localObject2 = null;
    ProducerListener localProducerListener = paramProducerContext.getListener();
    String str1 = paramProducerContext.getId();
    localProducerListener.onProducerStart(str1, getProducerName());
    Object localObject1 = paramProducerContext.getImageRequest();
    Object localObject3 = paramProducerContext.getCallerContext();
    localObject3 = this.mCacheKeyFactory.getBitmapCacheKey((ImageRequest)localObject1, localObject3);
    CloseableReference localCloseableReference = this.mMemoryCache.get(localObject3);
    if (localCloseableReference != null)
    {
      boolean bool = ((CloseableImage)localCloseableReference.get()).getQualityInfo().isOfFullQuality();
      String str2;
      if (bool)
      {
        str2 = getProducerName();
        if (!localProducerListener.requiresExtraMap(str1))
          break label182;
      }
      label182: for (localObject1 = ImmutableMap.of("cached_value_found", "true"); ; localObject1 = null)
      {
        localProducerListener.onProducerFinishWithSuccess(str1, str2, (Map)localObject1);
        localProducerListener.onUltimateProducerReached(str1, getProducerName(), true);
        paramConsumer.onProgressUpdate(1.0F);
        paramConsumer.onNewResult(localCloseableReference, bool);
        localCloseableReference.close();
        if (!bool)
          break;
        return;
      }
    }
    if (paramProducerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue())
    {
      localObject1 = getProducerName();
      if (localProducerListener.requiresExtraMap(str1));
      for (paramProducerContext = ImmutableMap.of("cached_value_found", "false"); ; paramProducerContext = null)
      {
        localProducerListener.onProducerFinishWithSuccess(str1, (String)localObject1, paramProducerContext);
        localProducerListener.onUltimateProducerReached(str1, getProducerName(), false);
        paramConsumer.onNewResult(null, true);
        return;
      }
    }
    localObject1 = wrapConsumer(paramConsumer, (CacheKey)localObject3);
    localObject3 = getProducerName();
    paramConsumer = localObject2;
    if (localProducerListener.requiresExtraMap(str1))
      paramConsumer = ImmutableMap.of("cached_value_found", "false");
    localProducerListener.onProducerFinishWithSuccess(str1, (String)localObject3, paramConsumer);
    this.mInputProducer.produceResults((Consumer)localObject1, paramProducerContext);
  }

  protected Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> paramConsumer, CacheKey paramCacheKey)
  {
    return new DelegatingConsumer(paramConsumer, paramCacheKey)
    {
      // ERROR //
      public void onNewResultImpl(CloseableReference<CloseableImage> paramCloseableReference, boolean paramBoolean)
      {
        // Byte code:
        //   0: aload_1
        //   1: ifnonnull +19 -> 20
        //   4: iload_2
        //   5: ifeq +14 -> 19
        //   8: aload_0
        //   9: invokevirtual 30	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
        //   12: aconst_null
        //   13: iconst_1
        //   14: invokeinterface 36 3 0
        //   19: return
        //   20: aload_1
        //   21: invokevirtual 42	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
        //   24: checkcast 44	com/facebook/imagepipeline/image/CloseableImage
        //   27: invokevirtual 48	com/facebook/imagepipeline/image/CloseableImage:isStateful	()Z
        //   30: ifeq +15 -> 45
        //   33: aload_0
        //   34: invokevirtual 30	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
        //   37: aload_1
        //   38: iload_2
        //   39: invokeinterface 36 3 0
        //   44: return
        //   45: iload_2
        //   46: ifne +95 -> 141
        //   49: aload_0
        //   50: getfield 18	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:this$0	Lcom/facebook/imagepipeline/producers/BitmapMemoryCacheProducer;
        //   53: invokestatic 52	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer:access$000	(Lcom/facebook/imagepipeline/producers/BitmapMemoryCacheProducer;)Lcom/facebook/imagepipeline/cache/MemoryCache;
        //   56: aload_0
        //   57: getfield 20	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:val$cacheKey	Lcom/facebook/cache/common/CacheKey;
        //   60: invokeinterface 57 2 0
        //   65: astore_3
        //   66: aload_3
        //   67: ifnull +74 -> 141
        //   70: aload_1
        //   71: invokevirtual 42	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
        //   74: checkcast 44	com/facebook/imagepipeline/image/CloseableImage
        //   77: invokevirtual 61	com/facebook/imagepipeline/image/CloseableImage:getQualityInfo	()Lcom/facebook/imagepipeline/image/QualityInfo;
        //   80: astore 4
        //   82: aload_3
        //   83: invokevirtual 42	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
        //   86: checkcast 44	com/facebook/imagepipeline/image/CloseableImage
        //   89: invokevirtual 61	com/facebook/imagepipeline/image/CloseableImage:getQualityInfo	()Lcom/facebook/imagepipeline/image/QualityInfo;
        //   92: astore 5
        //   94: aload 5
        //   96: invokeinterface 66 1 0
        //   101: ifne +20 -> 121
        //   104: aload 5
        //   106: invokeinterface 70 1 0
        //   111: aload 4
        //   113: invokeinterface 70 1 0
        //   118: if_icmplt +19 -> 137
        //   121: aload_0
        //   122: invokevirtual 30	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
        //   125: aload_3
        //   126: iconst_0
        //   127: invokeinterface 36 3 0
        //   132: aload_3
        //   133: invokestatic 74	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
        //   136: return
        //   137: aload_3
        //   138: invokestatic 74	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
        //   141: aload_0
        //   142: getfield 18	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:this$0	Lcom/facebook/imagepipeline/producers/BitmapMemoryCacheProducer;
        //   145: invokestatic 52	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer:access$000	(Lcom/facebook/imagepipeline/producers/BitmapMemoryCacheProducer;)Lcom/facebook/imagepipeline/cache/MemoryCache;
        //   148: aload_0
        //   149: getfield 20	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:val$cacheKey	Lcom/facebook/cache/common/CacheKey;
        //   152: aload_1
        //   153: invokeinterface 78 3 0
        //   158: astore_3
        //   159: iload_2
        //   160: ifeq +13 -> 173
        //   163: aload_0
        //   164: invokevirtual 30	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
        //   167: fconst_1
        //   168: invokeinterface 82 2 0
        //   173: aload_0
        //   174: invokevirtual 30	com/facebook/imagepipeline/producers/BitmapMemoryCacheProducer$1:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
        //   177: astore 4
        //   179: aload_3
        //   180: ifnull +5 -> 185
        //   183: aload_3
        //   184: astore_1
        //   185: aload 4
        //   187: aload_1
        //   188: iload_2
        //   189: invokeinterface 36 3 0
        //   194: aload_3
        //   195: invokestatic 74	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
        //   198: return
        //   199: astore_1
        //   200: aload_3
        //   201: invokestatic 74	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
        //   204: aload_1
        //   205: athrow
        //   206: astore_1
        //   207: aload_3
        //   208: invokestatic 74	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
        //   211: aload_1
        //   212: athrow
        //
        // Exception table:
        //   from	to	target	type
        //   70	121	199	finally
        //   121	132	199	finally
        //   163	173	206	finally
        //   173	179	206	finally
        //   185	194	206	finally
      }
    };
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer
 * JD-Core Version:    0.6.0
 */
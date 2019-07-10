package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;

public class EncodedMemoryCacheFactory
{
  public static MemoryCache<CacheKey, PooledByteBuffer> get(CountingMemoryCache<CacheKey, PooledByteBuffer> paramCountingMemoryCache, ImageCacheStatsTracker paramImageCacheStatsTracker)
  {
    paramImageCacheStatsTracker.registerEncodedMemoryCache(paramCountingMemoryCache);
    return new InstrumentedMemoryCache(paramCountingMemoryCache, new MemoryCacheTracker(paramImageCacheStatsTracker)
    {
      public void onCacheHit(CacheKey paramCacheKey)
      {
        this.val$imageCacheStatsTracker.onMemoryCacheHit(paramCacheKey);
      }

      public void onCacheMiss()
      {
        this.val$imageCacheStatsTracker.onMemoryCacheMiss();
      }

      public void onCachePut()
      {
        this.val$imageCacheStatsTracker.onMemoryCachePut();
      }
    });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory
 * JD-Core Version:    0.6.0
 */
package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.CloseableImage;

public class BitmapMemoryCacheFactory
{
  public static MemoryCache<CacheKey, CloseableImage> get(CountingMemoryCache<CacheKey, CloseableImage> paramCountingMemoryCache, ImageCacheStatsTracker paramImageCacheStatsTracker)
  {
    paramImageCacheStatsTracker.registerBitmapMemoryCache(paramCountingMemoryCache);
    return new InstrumentedMemoryCache(paramCountingMemoryCache, new MemoryCacheTracker(paramImageCacheStatsTracker)
    {
      public void onCacheHit(CacheKey paramCacheKey)
      {
        this.val$imageCacheStatsTracker.onBitmapCacheHit(paramCacheKey);
      }

      public void onCacheMiss()
      {
        this.val$imageCacheStatsTracker.onBitmapCacheMiss();
      }

      public void onCachePut()
      {
        this.val$imageCacheStatsTracker.onBitmapCachePut();
      }
    });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory
 * JD-Core Version:    0.6.0
 */
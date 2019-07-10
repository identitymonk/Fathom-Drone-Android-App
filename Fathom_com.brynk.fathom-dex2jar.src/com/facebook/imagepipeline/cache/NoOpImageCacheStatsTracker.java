package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;

public class NoOpImageCacheStatsTracker
  implements ImageCacheStatsTracker
{
  private static NoOpImageCacheStatsTracker sInstance = null;

  public static NoOpImageCacheStatsTracker getInstance()
  {
    monitorenter;
    try
    {
      if (sInstance == null)
        sInstance = new NoOpImageCacheStatsTracker();
      NoOpImageCacheStatsTracker localNoOpImageCacheStatsTracker = sInstance;
      return localNoOpImageCacheStatsTracker;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void onBitmapCacheHit(CacheKey paramCacheKey)
  {
  }

  public void onBitmapCacheMiss()
  {
  }

  public void onBitmapCachePut()
  {
  }

  public void onDiskCacheGetFail()
  {
  }

  public void onDiskCacheHit()
  {
  }

  public void onDiskCacheMiss()
  {
  }

  public void onMemoryCacheHit(CacheKey paramCacheKey)
  {
  }

  public void onMemoryCacheMiss()
  {
  }

  public void onMemoryCachePut()
  {
  }

  public void onStagingAreaHit(CacheKey paramCacheKey)
  {
  }

  public void onStagingAreaMiss()
  {
  }

  public void registerBitmapMemoryCache(CountingMemoryCache<?, ?> paramCountingMemoryCache)
  {
  }

  public void registerEncodedMemoryCache(CountingMemoryCache<?, ?> paramCountingMemoryCache)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker
 * JD-Core Version:    0.6.0
 */
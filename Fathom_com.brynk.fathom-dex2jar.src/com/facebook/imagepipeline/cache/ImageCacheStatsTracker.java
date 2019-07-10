package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;

public abstract interface ImageCacheStatsTracker
{
  public abstract void onBitmapCacheHit(CacheKey paramCacheKey);

  public abstract void onBitmapCacheMiss();

  public abstract void onBitmapCachePut();

  public abstract void onDiskCacheGetFail();

  public abstract void onDiskCacheHit();

  public abstract void onDiskCacheMiss();

  public abstract void onMemoryCacheHit(CacheKey paramCacheKey);

  public abstract void onMemoryCacheMiss();

  public abstract void onMemoryCachePut();

  public abstract void onStagingAreaHit(CacheKey paramCacheKey);

  public abstract void onStagingAreaMiss();

  public abstract void registerBitmapMemoryCache(CountingMemoryCache<?, ?> paramCountingMemoryCache);

  public abstract void registerEncodedMemoryCache(CountingMemoryCache<?, ?> paramCountingMemoryCache);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.ImageCacheStatsTracker
 * JD-Core Version:    0.6.0
 */
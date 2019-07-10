package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.DiskStorageCache.Params;
import com.facebook.cache.disk.FileCache;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DiskStorageCacheFactory
  implements FileCacheFactory
{
  private DiskStorageFactory mDiskStorageFactory;

  public DiskStorageCacheFactory(DiskStorageFactory paramDiskStorageFactory)
  {
    this.mDiskStorageFactory = paramDiskStorageFactory;
  }

  public static DiskStorageCache buildDiskStorageCache(DiskCacheConfig paramDiskCacheConfig, DiskStorage paramDiskStorage)
  {
    return buildDiskStorageCache(paramDiskCacheConfig, paramDiskStorage, Executors.newSingleThreadExecutor());
  }

  public static DiskStorageCache buildDiskStorageCache(DiskCacheConfig paramDiskCacheConfig, DiskStorage paramDiskStorage, Executor paramExecutor)
  {
    DiskStorageCache.Params localParams = new DiskStorageCache.Params(paramDiskCacheConfig.getMinimumSizeLimit(), paramDiskCacheConfig.getLowDiskSpaceSizeLimit(), paramDiskCacheConfig.getDefaultSizeLimit());
    return new DiskStorageCache(paramDiskStorage, paramDiskCacheConfig.getEntryEvictionComparatorSupplier(), localParams, paramDiskCacheConfig.getCacheEventListener(), paramDiskCacheConfig.getCacheErrorLogger(), paramDiskCacheConfig.getDiskTrimmableRegistry(), paramDiskCacheConfig.getContext(), paramExecutor, paramDiskCacheConfig.getIndexPopulateAtStartupEnabled());
  }

  public FileCache get(DiskCacheConfig paramDiskCacheConfig)
  {
    return buildDiskStorageCache(paramDiskCacheConfig, this.mDiskStorageFactory.get(paramDiskCacheConfig));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.core.DiskStorageCacheFactory
 * JD-Core Version:    0.6.0
 */
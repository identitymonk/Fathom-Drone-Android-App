package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.FileCache;

public abstract interface FileCacheFactory
{
  public abstract FileCache get(DiskCacheConfig paramDiskCacheConfig);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.core.FileCacheFactory
 * JD-Core Version:    0.6.0
 */
package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Supplier;

public class DefaultEncodedMemoryCacheParamsSupplier
  implements Supplier<MemoryCacheParams>
{
  private static final int MAX_CACHE_ENTRIES = 2147483647;
  private static final int MAX_EVICTION_QUEUE_ENTRIES = 2147483647;

  private int getMaxCacheSize()
  {
    int i = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
    if (i < 16777216)
      return 1048576;
    if (i < 33554432)
      return 2097152;
    return 4194304;
  }

  public MemoryCacheParams get()
  {
    int i = getMaxCacheSize();
    return new MemoryCacheParams(i, 2147483647, i, 2147483647, i / 8);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier
 * JD-Core Version:    0.6.0
 */
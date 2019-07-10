package com.facebook.imagepipeline.cache;

public class MemoryCacheParams
{
  public final int maxCacheEntries;
  public final int maxCacheEntrySize;
  public final int maxCacheSize;
  public final int maxEvictionQueueEntries;
  public final int maxEvictionQueueSize;

  public MemoryCacheParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.maxCacheSize = paramInt1;
    this.maxCacheEntries = paramInt2;
    this.maxEvictionQueueSize = paramInt3;
    this.maxEvictionQueueEntries = paramInt4;
    this.maxCacheEntrySize = paramInt5;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.MemoryCacheParams
 * JD-Core Version:    0.6.0
 */
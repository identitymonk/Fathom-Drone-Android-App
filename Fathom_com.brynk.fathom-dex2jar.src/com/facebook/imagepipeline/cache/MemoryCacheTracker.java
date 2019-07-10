package com.facebook.imagepipeline.cache;

public abstract interface MemoryCacheTracker<K>
{
  public abstract void onCacheHit(K paramK);

  public abstract void onCacheMiss();

  public abstract void onCachePut();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.MemoryCacheTracker
 * JD-Core Version:    0.6.0
 */
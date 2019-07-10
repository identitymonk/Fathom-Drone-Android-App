package com.facebook.imagepipeline.cache;

import com.android.internal.util.Predicate;
import com.facebook.common.references.CloseableReference;

public class InstrumentedMemoryCache<K, V>
  implements MemoryCache<K, V>
{
  private final MemoryCache<K, V> mDelegate;
  private final MemoryCacheTracker mTracker;

  public InstrumentedMemoryCache(MemoryCache<K, V> paramMemoryCache, MemoryCacheTracker paramMemoryCacheTracker)
  {
    this.mDelegate = paramMemoryCache;
    this.mTracker = paramMemoryCacheTracker;
  }

  public CloseableReference<V> cache(K paramK, CloseableReference<V> paramCloseableReference)
  {
    this.mTracker.onCachePut();
    return this.mDelegate.cache(paramK, paramCloseableReference);
  }

  public boolean contains(Predicate<K> paramPredicate)
  {
    return this.mDelegate.contains(paramPredicate);
  }

  public CloseableReference<V> get(K paramK)
  {
    CloseableReference localCloseableReference = this.mDelegate.get(paramK);
    if (localCloseableReference == null)
    {
      this.mTracker.onCacheMiss();
      return localCloseableReference;
    }
    this.mTracker.onCacheHit(paramK);
    return localCloseableReference;
  }

  public int removeAll(Predicate<K> paramPredicate)
  {
    return this.mDelegate.removeAll(paramPredicate);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.InstrumentedMemoryCache
 * JD-Core Version:    0.6.0
 */
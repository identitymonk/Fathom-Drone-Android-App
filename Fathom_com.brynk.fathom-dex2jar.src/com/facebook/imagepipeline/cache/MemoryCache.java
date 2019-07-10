package com.facebook.imagepipeline.cache;

import com.android.internal.util.Predicate;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;

public abstract interface MemoryCache<K, V>
{
  @Nullable
  public abstract CloseableReference<V> cache(K paramK, CloseableReference<V> paramCloseableReference);

  public abstract boolean contains(Predicate<K> paramPredicate);

  @Nullable
  public abstract CloseableReference<V> get(K paramK);

  public abstract int removeAll(Predicate<K> paramPredicate);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.MemoryCache
 * JD-Core Version:    0.6.0
 */
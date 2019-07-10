package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.android.internal.util.Predicate;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory.BitmapCreationObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class CountingMemoryCache<K, V>
  implements MemoryCache<K, V>, MemoryTrimmable
{

  @VisibleForTesting
  static final long PARAMS_INTERCHECK_INTERVAL_MS = TimeUnit.MINUTES.toMillis(5L);
  private final CacheTrimStrategy mCacheTrimStrategy;

  @VisibleForTesting
  @GuardedBy("this")
  final CountingLruMap<K, Entry<K, V>> mCachedEntries;

  @VisibleForTesting
  @GuardedBy("this")
  final CountingLruMap<K, Entry<K, V>> mExclusiveEntries;

  @GuardedBy("this")
  private long mLastCacheParamsCheck;

  @GuardedBy("this")
  protected MemoryCacheParams mMemoryCacheParams;
  private final Supplier<MemoryCacheParams> mMemoryCacheParamsSupplier;

  @VisibleForTesting
  @GuardedBy("this")
  final Map<Bitmap, Object> mOtherEntries = new WeakHashMap();
  private final ValueDescriptor<V> mValueDescriptor;

  public CountingMemoryCache(ValueDescriptor<V> paramValueDescriptor, CacheTrimStrategy paramCacheTrimStrategy, Supplier<MemoryCacheParams> paramSupplier, PlatformBitmapFactory paramPlatformBitmapFactory, boolean paramBoolean)
  {
    this.mValueDescriptor = paramValueDescriptor;
    this.mExclusiveEntries = new CountingLruMap(wrapValueDescriptor(paramValueDescriptor));
    this.mCachedEntries = new CountingLruMap(wrapValueDescriptor(paramValueDescriptor));
    this.mCacheTrimStrategy = paramCacheTrimStrategy;
    this.mMemoryCacheParamsSupplier = paramSupplier;
    this.mMemoryCacheParams = ((MemoryCacheParams)this.mMemoryCacheParamsSupplier.get());
    this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
    if (paramBoolean)
      paramPlatformBitmapFactory.setCreationListener(new PlatformBitmapFactory.BitmapCreationObserver()
      {
        public void onBitmapCreated(Bitmap paramBitmap, Object paramObject)
        {
          CountingMemoryCache.this.mOtherEntries.put(paramBitmap, paramObject);
        }
      });
  }

  private boolean canCacheNewValue(V paramV)
  {
    monitorenter;
    try
    {
      int i = this.mValueDescriptor.getSizeInBytes(paramV);
      if ((i <= this.mMemoryCacheParams.maxCacheEntrySize) && (getInUseCount() <= this.mMemoryCacheParams.maxCacheEntries - 1))
      {
        int j = getInUseSizeInBytes();
        int k = this.mMemoryCacheParams.maxCacheSize;
        if (j <= k - i)
        {
          m = 1;
          return m;
        }
      }
      int m = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  private void decreaseClientCount(Entry<K, V> paramEntry)
  {
    monitorenter;
    try
    {
      Preconditions.checkNotNull(paramEntry);
      if (paramEntry.clientCount > 0);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool);
        paramEntry.clientCount -= 1;
        return;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramEntry;
  }

  private void increaseClientCount(Entry<K, V> paramEntry)
  {
    monitorenter;
    try
    {
      Preconditions.checkNotNull(paramEntry);
      if (!paramEntry.isOrphan);
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool);
        paramEntry.clientCount += 1;
        return;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramEntry;
  }

  private void makeOrphan(Entry<K, V> paramEntry)
  {
    boolean bool = true;
    monitorenter;
    try
    {
      Preconditions.checkNotNull(paramEntry);
      if (!paramEntry.isOrphan);
      while (true)
      {
        Preconditions.checkState(bool);
        paramEntry.isOrphan = true;
        return;
        bool = false;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramEntry;
  }

  private void makeOrphans(@Nullable ArrayList<Entry<K, V>> paramArrayList)
  {
    monitorenter;
    if (paramArrayList != null)
      try
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
          makeOrphan((Entry)paramArrayList.next());
      }
      finally
      {
        monitorexit;
      }
    monitorexit;
  }

  private boolean maybeAddToExclusives(Entry<K, V> paramEntry)
  {
    monitorenter;
    try
    {
      if ((!paramEntry.isOrphan) && (paramEntry.clientCount == 0))
      {
        this.mExclusiveEntries.put(paramEntry.key, paramEntry);
        i = 1;
        return i;
      }
      int i = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  private void maybeClose(@Nullable ArrayList<Entry<K, V>> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
        CloseableReference.closeSafely(referenceToClose((Entry)paramArrayList.next()));
    }
  }

  private void maybeEvictEntries()
  {
    monitorenter;
    try
    {
      ArrayList localArrayList = trimExclusivelyOwnedEntries(Math.min(this.mMemoryCacheParams.maxEvictionQueueEntries, this.mMemoryCacheParams.maxCacheEntries - getInUseCount()), Math.min(this.mMemoryCacheParams.maxEvictionQueueSize, this.mMemoryCacheParams.maxCacheSize - getInUseSizeInBytes()));
      makeOrphans(localArrayList);
      monitorexit;
      maybeClose(localArrayList);
      maybeNotifyExclusiveEntryRemoval(localArrayList);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private static <K, V> void maybeNotifyExclusiveEntryInsertion(@Nullable Entry<K, V> paramEntry)
  {
    if ((paramEntry != null) && (paramEntry.observer != null))
      paramEntry.observer.onExclusivityChanged(paramEntry.key, true);
  }

  private static <K, V> void maybeNotifyExclusiveEntryRemoval(@Nullable Entry<K, V> paramEntry)
  {
    if ((paramEntry != null) && (paramEntry.observer != null))
      paramEntry.observer.onExclusivityChanged(paramEntry.key, false);
  }

  private void maybeNotifyExclusiveEntryRemoval(@Nullable ArrayList<Entry<K, V>> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
        maybeNotifyExclusiveEntryRemoval((Entry)paramArrayList.next());
    }
  }

  private void maybeUpdateCacheParams()
  {
    monitorenter;
    try
    {
      long l1 = this.mLastCacheParamsCheck;
      long l2 = PARAMS_INTERCHECK_INTERVAL_MS;
      long l3 = SystemClock.uptimeMillis();
      if (l1 + l2 > l3);
      while (true)
      {
        return;
        this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
        this.mMemoryCacheParams = ((MemoryCacheParams)this.mMemoryCacheParamsSupplier.get());
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private CloseableReference<V> newClientReference(Entry<K, V> paramEntry)
  {
    monitorenter;
    try
    {
      increaseClientCount(paramEntry);
      paramEntry = CloseableReference.of(paramEntry.valueRef.get(), new ResourceReleaser(paramEntry)
      {
        public void release(V paramV)
        {
          CountingMemoryCache.this.releaseClientReference(this.val$entry);
        }
      });
      monitorexit;
      return paramEntry;
    }
    finally
    {
      paramEntry = finally;
      monitorexit;
    }
    throw paramEntry;
  }

  @Nullable
  private CloseableReference<V> referenceToClose(Entry<K, V> paramEntry)
  {
    monitorenter;
    try
    {
      Preconditions.checkNotNull(paramEntry);
      if ((paramEntry.isOrphan) && (paramEntry.clientCount == 0))
      {
        paramEntry = paramEntry.valueRef;
        return paramEntry;
      }
      paramEntry = null;
    }
    finally
    {
      monitorexit;
    }
  }

  private void releaseClientReference(Entry<K, V> paramEntry)
  {
    Preconditions.checkNotNull(paramEntry);
    monitorenter;
    while (true)
    {
      try
      {
        decreaseClientCount(paramEntry);
        boolean bool = maybeAddToExclusives(paramEntry);
        CloseableReference localCloseableReference = referenceToClose(paramEntry);
        monitorexit;
        CloseableReference.closeSafely(localCloseableReference);
        if (bool)
        {
          maybeNotifyExclusiveEntryInsertion(paramEntry);
          maybeUpdateCacheParams();
          maybeEvictEntries();
          return;
        }
      }
      finally
      {
        monitorexit;
      }
      paramEntry = null;
    }
  }

  @Nullable
  private ArrayList<Entry<K, V>> trimExclusivelyOwnedEntries(int paramInt1, int paramInt2)
  {
    monitorenter;
    try
    {
      paramInt1 = Math.max(paramInt1, 0);
      paramInt2 = Math.max(paramInt2, 0);
      Object localObject1;
      if (this.mExclusiveEntries.getCount() <= paramInt1)
      {
        int i = this.mExclusiveEntries.getSizeInBytes();
        if (i <= paramInt2)
        {
          localObject1 = null;
          return localObject1;
        }
      }
      ArrayList localArrayList = new ArrayList();
      while (true)
      {
        if (this.mExclusiveEntries.getCount() <= paramInt1)
        {
          localObject1 = localArrayList;
          if (this.mExclusiveEntries.getSizeInBytes() <= paramInt2)
            break;
        }
        localObject1 = this.mExclusiveEntries.getFirstKey();
        this.mExclusiveEntries.remove(localObject1);
        localArrayList.add(this.mCachedEntries.remove(localObject1));
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject2;
  }

  private ValueDescriptor<Entry<K, V>> wrapValueDescriptor(ValueDescriptor<V> paramValueDescriptor)
  {
    return new ValueDescriptor(paramValueDescriptor)
    {
      public int getSizeInBytes(CountingMemoryCache.Entry<K, V> paramEntry)
      {
        return this.val$evictableValueDescriptor.getSizeInBytes(paramEntry.valueRef.get());
      }
    };
  }

  public CloseableReference<V> cache(K paramK, CloseableReference<V> paramCloseableReference)
  {
    return cache(paramK, paramCloseableReference, null);
  }

  public CloseableReference<V> cache(K paramK, CloseableReference<V> paramCloseableReference, EntryStateObserver<K> paramEntryStateObserver)
  {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramCloseableReference);
    maybeUpdateCacheParams();
    CloseableReference localCloseableReference1 = null;
    CloseableReference localCloseableReference2 = null;
    monitorenter;
    try
    {
      Entry localEntry1 = (Entry)this.mExclusiveEntries.remove(paramK);
      Entry localEntry2 = (Entry)this.mCachedEntries.remove(paramK);
      if (localEntry2 != null)
      {
        makeOrphan(localEntry2);
        localCloseableReference1 = referenceToClose(localEntry2);
      }
      if (canCacheNewValue(paramCloseableReference.get()))
      {
        paramCloseableReference = Entry.of(paramK, paramCloseableReference, paramEntryStateObserver);
        this.mCachedEntries.put(paramK, paramCloseableReference);
        localCloseableReference2 = newClientReference(paramCloseableReference);
      }
      monitorexit;
      CloseableReference.closeSafely(localCloseableReference1);
      maybeNotifyExclusiveEntryRemoval(localEntry1);
      maybeEvictEntries();
      return localCloseableReference2;
    }
    finally
    {
      monitorexit;
    }
    throw paramK;
  }

  public void clear()
  {
    monitorenter;
    try
    {
      ArrayList localArrayList1 = this.mExclusiveEntries.clear();
      ArrayList localArrayList2 = this.mCachedEntries.clear();
      makeOrphans(localArrayList2);
      monitorexit;
      maybeClose(localArrayList2);
      maybeNotifyExclusiveEntryRemoval(localArrayList1);
      maybeUpdateCacheParams();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean contains(Predicate<K> paramPredicate)
  {
    monitorenter;
    try
    {
      boolean bool = this.mCachedEntries.getMatchingEntries(paramPredicate).isEmpty();
      if (!bool)
      {
        bool = true;
        return bool;
      }
      bool = false;
    }
    finally
    {
      monitorexit;
    }
  }

  public boolean contains(K paramK)
  {
    monitorenter;
    try
    {
      boolean bool = this.mCachedEntries.contains(paramK);
      monitorexit;
      return bool;
    }
    finally
    {
      paramK = finally;
      monitorexit;
    }
    throw paramK;
  }

  @Nullable
  public CloseableReference<V> get(K paramK)
  {
    Preconditions.checkNotNull(paramK);
    Object localObject = null;
    monitorenter;
    try
    {
      Entry localEntry1 = (Entry)this.mExclusiveEntries.remove(paramK);
      Entry localEntry2 = (Entry)this.mCachedEntries.get(paramK);
      paramK = localObject;
      if (localEntry2 != null)
        paramK = newClientReference(localEntry2);
      monitorexit;
      maybeNotifyExclusiveEntryRemoval(localEntry1);
      maybeUpdateCacheParams();
      maybeEvictEntries();
      return paramK;
    }
    finally
    {
      monitorexit;
    }
    throw paramK;
  }

  public int getCount()
  {
    monitorenter;
    try
    {
      int i = this.mCachedEntries.getCount();
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int getEvictionQueueCount()
  {
    monitorenter;
    try
    {
      int i = this.mExclusiveEntries.getCount();
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int getEvictionQueueSizeInBytes()
  {
    monitorenter;
    try
    {
      int i = this.mExclusiveEntries.getSizeInBytes();
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int getInUseCount()
  {
    monitorenter;
    try
    {
      int i = this.mCachedEntries.getCount();
      int j = this.mExclusiveEntries.getCount();
      monitorexit;
      return i - j;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int getInUseSizeInBytes()
  {
    monitorenter;
    try
    {
      int i = this.mCachedEntries.getSizeInBytes();
      int j = this.mExclusiveEntries.getSizeInBytes();
      monitorexit;
      return i - j;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int getSizeInBytes()
  {
    monitorenter;
    try
    {
      int i = this.mCachedEntries.getSizeInBytes();
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int removeAll(Predicate<K> paramPredicate)
  {
    monitorenter;
    try
    {
      ArrayList localArrayList = this.mExclusiveEntries.removeAll(paramPredicate);
      paramPredicate = this.mCachedEntries.removeAll(paramPredicate);
      makeOrphans(paramPredicate);
      monitorexit;
      maybeClose(paramPredicate);
      maybeNotifyExclusiveEntryRemoval(localArrayList);
      maybeUpdateCacheParams();
      maybeEvictEntries();
      return paramPredicate.size();
    }
    finally
    {
      monitorexit;
    }
    throw paramPredicate;
  }

  @Nullable
  public CloseableReference<V> reuse(K paramK)
  {
    Preconditions.checkNotNull(paramK);
    CloseableReference localCloseableReference = null;
    int i = 0;
    monitorenter;
    try
    {
      Entry localEntry = (Entry)this.mExclusiveEntries.remove(paramK);
      if (localEntry != null)
      {
        paramK = (Entry)this.mCachedEntries.remove(paramK);
        Preconditions.checkNotNull(paramK);
        if (paramK.clientCount != 0)
          break label82;
      }
      label82: for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkState(bool);
        localCloseableReference = paramK.valueRef;
        i = 1;
        monitorexit;
        if (i != 0)
          maybeNotifyExclusiveEntryRemoval(localEntry);
        return localCloseableReference;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramK;
  }

  public void trim(MemoryTrimType paramMemoryTrimType)
  {
    double d = this.mCacheTrimStrategy.getTrimRatio(paramMemoryTrimType);
    monitorenter;
    try
    {
      paramMemoryTrimType = trimExclusivelyOwnedEntries(2147483647, Math.max(0, (int)(this.mCachedEntries.getSizeInBytes() * (1.0D - d)) - getInUseSizeInBytes()));
      makeOrphans(paramMemoryTrimType);
      monitorexit;
      maybeClose(paramMemoryTrimType);
      maybeNotifyExclusiveEntryRemoval(paramMemoryTrimType);
      maybeUpdateCacheParams();
      maybeEvictEntries();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw paramMemoryTrimType;
  }

  public static abstract interface CacheTrimStrategy
  {
    public abstract double getTrimRatio(MemoryTrimType paramMemoryTrimType);
  }

  @VisibleForTesting
  static class Entry<K, V>
  {
    public int clientCount;
    public boolean isOrphan;
    public final K key;

    @Nullable
    public final CountingMemoryCache.EntryStateObserver<K> observer;
    public final CloseableReference<V> valueRef;

    private Entry(K paramK, CloseableReference<V> paramCloseableReference, @Nullable CountingMemoryCache.EntryStateObserver<K> paramEntryStateObserver)
    {
      this.key = Preconditions.checkNotNull(paramK);
      this.valueRef = ((CloseableReference)Preconditions.checkNotNull(CloseableReference.cloneOrNull(paramCloseableReference)));
      this.clientCount = 0;
      this.isOrphan = false;
      this.observer = paramEntryStateObserver;
    }

    @VisibleForTesting
    static <K, V> Entry<K, V> of(K paramK, CloseableReference<V> paramCloseableReference, @Nullable CountingMemoryCache.EntryStateObserver<K> paramEntryStateObserver)
    {
      return new Entry(paramK, paramCloseableReference, paramEntryStateObserver);
    }
  }

  public static abstract interface EntryStateObserver<K>
  {
    public abstract void onExclusivityChanged(K paramK, boolean paramBoolean);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.CountingMemoryCache
 * JD-Core Version:    0.6.0
 */
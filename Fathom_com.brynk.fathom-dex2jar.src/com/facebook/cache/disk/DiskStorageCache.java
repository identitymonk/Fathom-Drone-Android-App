package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.cache.common.CacheEvent;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheEventListener.EvictionReason;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.CacheKeyUtil;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class DiskStorageCache
  implements FileCache, DiskTrimmable
{
  private static final long FILECACHE_SIZE_UPDATE_PERIOD_MS;
  private static final long FUTURE_TIMESTAMP_THRESHOLD_MS;
  private static final String SHARED_PREFS_FILENAME_PREFIX = "disk_entries_list";
  public static final int START_OF_VERSIONING = 1;
  private static final Class<?> TAG = DiskStorageCache.class;
  private static final double TRIMMING_LOWER_BOUND = 0.02D;
  private static final long UNINITIALIZED = -1L;
  private final CacheErrorLogger mCacheErrorLogger;
  private final CacheEventListener mCacheEventListener;
  private long mCacheSizeLastUpdateTime;
  private long mCacheSizeLimit;
  private final long mCacheSizeLimitMinimum;
  private final CacheStats mCacheStats;
  private final Clock mClock;
  private final CountDownLatch mCountDownLatch;
  private final long mDefaultCacheSizeLimit;
  private final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
  private final boolean mIndexPopulateAtStartupEnabled;
  private boolean mIndexReady;
  private final Object mLock = new Object();
  private final long mLowDiskSpaceCacheSizeLimit;

  @VisibleForTesting
  @GuardedBy("mLock")
  final Set<String> mResourceIndex;
  private final StatFsHelper mStatFsHelper;
  private final DiskStorage mStorage;

  static
  {
    FUTURE_TIMESTAMP_THRESHOLD_MS = TimeUnit.HOURS.toMillis(2L);
    FILECACHE_SIZE_UPDATE_PERIOD_MS = TimeUnit.MINUTES.toMillis(30L);
  }

  public DiskStorageCache(DiskStorage paramDiskStorage, EntryEvictionComparatorSupplier paramEntryEvictionComparatorSupplier, Params paramParams, CacheEventListener paramCacheEventListener, CacheErrorLogger paramCacheErrorLogger, @Nullable DiskTrimmableRegistry paramDiskTrimmableRegistry, Context paramContext, Executor paramExecutor, boolean paramBoolean)
  {
    this.mLowDiskSpaceCacheSizeLimit = paramParams.mLowDiskSpaceCacheSizeLimit;
    this.mDefaultCacheSizeLimit = paramParams.mDefaultCacheSizeLimit;
    this.mCacheSizeLimit = paramParams.mDefaultCacheSizeLimit;
    this.mStatFsHelper = StatFsHelper.getInstance();
    this.mStorage = paramDiskStorage;
    this.mEntryEvictionComparatorSupplier = paramEntryEvictionComparatorSupplier;
    this.mCacheSizeLastUpdateTime = -1L;
    this.mCacheEventListener = paramCacheEventListener;
    this.mCacheSizeLimitMinimum = paramParams.mCacheSizeLimitMinimum;
    this.mCacheErrorLogger = paramCacheErrorLogger;
    this.mCacheStats = new CacheStats();
    if (paramDiskTrimmableRegistry != null)
      paramDiskTrimmableRegistry.registerDiskTrimmable(this);
    this.mClock = SystemClock.get();
    this.mIndexPopulateAtStartupEnabled = paramBoolean;
    this.mResourceIndex = new HashSet();
    if (this.mIndexPopulateAtStartupEnabled)
    {
      this.mCountDownLatch = new CountDownLatch(1);
      paramExecutor.execute(new Runnable()
      {
        public void run()
        {
          synchronized (DiskStorageCache.this.mLock)
          {
            DiskStorageCache.this.maybeUpdateFileCacheSize();
            DiskStorageCache.access$202(DiskStorageCache.this, true);
            DiskStorageCache.this.mCountDownLatch.countDown();
            return;
          }
        }
      });
      return;
    }
    this.mCountDownLatch = new CountDownLatch(0);
  }

  private BinaryResource endInsert(DiskStorage.Inserter paramInserter, CacheKey paramCacheKey, String paramString)
    throws IOException
  {
    synchronized (this.mLock)
    {
      paramInserter = paramInserter.commit(paramCacheKey);
      this.mResourceIndex.add(paramString);
      this.mCacheStats.increment(paramInserter.size(), 1L);
      return paramInserter;
    }
  }

  @GuardedBy("mLock")
  private void evictAboveSize(long paramLong, CacheEventListener.EvictionReason paramEvictionReason)
    throws IOException
  {
    while (true)
    {
      long l2;
      int i;
      long l1;
      try
      {
        Object localObject1 = getSortedEntries(this.mStorage.getEntries());
        l2 = this.mCacheStats.getSize();
        i = 0;
        l1 = 0L;
        localObject1 = ((Collection)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext())
          continue;
        localObject2 = (DiskStorage.Entry)((Iterator)localObject1).next();
        if (l1 > l2 - paramLong)
        {
          this.mCacheStats.increment(-l1, -i);
          this.mStorage.purgeUnexpectedResources();
          return;
        }
      }
      catch (IOException paramEvictionReason)
      {
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "evictAboveSize: " + paramEvictionReason.getMessage(), paramEvictionReason);
        throw paramEvictionReason;
      }
      long l3 = this.mStorage.remove((DiskStorage.Entry)localObject2);
      this.mResourceIndex.remove(((DiskStorage.Entry)localObject2).getId());
      if (l3 <= 0L)
        continue;
      i += 1;
      l1 += l3;
      Object localObject2 = SettableCacheEvent.obtain().setResourceId(((DiskStorage.Entry)localObject2).getId()).setEvictionReason(paramEvictionReason).setItemSize(l3).setCacheSize(l2 - l1).setCacheLimit(paramLong);
      this.mCacheEventListener.onEviction((CacheEvent)localObject2);
      ((SettableCacheEvent)localObject2).recycle();
    }
  }

  private Collection<DiskStorage.Entry> getSortedEntries(Collection<DiskStorage.Entry> paramCollection)
  {
    long l1 = this.mClock.now();
    long l2 = FUTURE_TIMESTAMP_THRESHOLD_MS;
    ArrayList localArrayList1 = new ArrayList(paramCollection.size());
    ArrayList localArrayList2 = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      DiskStorage.Entry localEntry = (DiskStorage.Entry)paramCollection.next();
      if (localEntry.getTimestamp() > l1 + l2)
      {
        localArrayList1.add(localEntry);
        continue;
      }
      localArrayList2.add(localEntry);
    }
    Collections.sort(localArrayList2, this.mEntryEvictionComparatorSupplier.get());
    localArrayList1.addAll(localArrayList2);
    return localArrayList1;
  }

  private void maybeEvictFilesInCacheDir()
    throws IOException
  {
    synchronized (this.mLock)
    {
      boolean bool = maybeUpdateFileCacheSize();
      updateFileCacheSizeLimit();
      long l = this.mCacheStats.getSize();
      if ((l > this.mCacheSizeLimit) && (!bool))
      {
        this.mCacheStats.reset();
        maybeUpdateFileCacheSize();
      }
      if (l > this.mCacheSizeLimit)
        evictAboveSize(this.mCacheSizeLimit * 9L / 10L, CacheEventListener.EvictionReason.CACHE_FULL);
      return;
    }
  }

  @GuardedBy("mLock")
  private boolean maybeUpdateFileCacheSize()
  {
    long l = this.mClock.now();
    if ((!this.mCacheStats.isInitialized()) || (this.mCacheSizeLastUpdateTime == -1L) || (l - this.mCacheSizeLastUpdateTime > FILECACHE_SIZE_UPDATE_PERIOD_MS))
      return maybeUpdateFileCacheSizeAndIndex();
    return false;
  }

  @GuardedBy("mLock")
  private boolean maybeUpdateFileCacheSizeAndIndex()
  {
    long l1 = 0L;
    int k = 0;
    int m = 0;
    int j = 0;
    int i = 0;
    long l2 = -1L;
    long l4 = this.mClock.now();
    long l5 = FUTURE_TIMESTAMP_THRESHOLD_MS;
    Object localObject;
    if ((this.mIndexPopulateAtStartupEnabled) && (this.mResourceIndex.isEmpty()))
      localObject = this.mResourceIndex;
    try
    {
      Iterator localIterator = this.mStorage.getEntries().iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          break label284;
        DiskStorage.Entry localEntry = (DiskStorage.Entry)localIterator.next();
        int n = k + 1;
        long l3 = l1 + localEntry.getSize();
        if (localEntry.getTimestamp() > l4 + l5)
        {
          m = 1;
          j += 1;
          i = (int)(i + localEntry.getSize());
          l2 = Math.max(localEntry.getTimestamp() - l4, l2);
          k = n;
          l1 = l3;
          continue;
          if (this.mIndexPopulateAtStartupEnabled)
          {
            localObject = new HashSet();
            break;
          }
          localObject = null;
          break;
        }
        k = n;
        l1 = l3;
        if (!this.mIndexPopulateAtStartupEnabled)
          continue;
        ((Set)localObject).add(localEntry.getId());
        k = n;
        l1 = l3;
      }
    }
    catch (IOException localIOException)
    {
      this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "calcFileCacheSize: " + localIOException.getMessage(), localIOException);
      return false;
    }
    label284: if (m != 0)
      this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, TAG, "Future timestamp found in " + j + " files , with a total size of " + i + " bytes, and a maximum time delta of " + l2 + "ms", null);
    if ((this.mCacheStats.getCount() != k) || (this.mCacheStats.getSize() != l1))
    {
      if ((this.mIndexPopulateAtStartupEnabled) && (this.mResourceIndex != localIOException))
      {
        this.mResourceIndex.clear();
        this.mResourceIndex.addAll(localIOException);
      }
      this.mCacheStats.set(l1, k);
    }
    this.mCacheSizeLastUpdateTime = l4;
    return true;
  }

  private DiskStorage.Inserter startInsert(String paramString, CacheKey paramCacheKey)
    throws IOException
  {
    maybeEvictFilesInCacheDir();
    return this.mStorage.insert(paramString, paramCacheKey);
  }

  private void trimBy(double paramDouble)
  {
    synchronized (this.mLock)
    {
      try
      {
        this.mCacheStats.reset();
        maybeUpdateFileCacheSize();
        long l = this.mCacheStats.getSize();
        evictAboveSize(l - ()(l * paramDouble), CacheEventListener.EvictionReason.CACHE_MANAGER_TRIMMED);
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "trimBy: " + localIOException.getMessage(), localIOException);
      }
    }
  }

  @GuardedBy("mLock")
  private void updateFileCacheSizeLimit()
  {
    if (this.mStorage.isExternal());
    for (StatFsHelper.StorageType localStorageType = StatFsHelper.StorageType.EXTERNAL; this.mStatFsHelper.testLowDiskSpace(localStorageType, this.mDefaultCacheSizeLimit - this.mCacheStats.getSize()); localStorageType = StatFsHelper.StorageType.INTERNAL)
    {
      this.mCacheSizeLimit = this.mLowDiskSpaceCacheSizeLimit;
      return;
    }
    this.mCacheSizeLimit = this.mDefaultCacheSizeLimit;
  }

  @VisibleForTesting
  protected void awaitIndex()
  {
    try
    {
      this.mCountDownLatch.await();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      FLog.e(TAG, "Memory Index is not ready yet. ");
    }
  }

  public void clearAll()
  {
    synchronized (this.mLock)
    {
      try
      {
        this.mStorage.clearAll();
        this.mResourceIndex.clear();
        this.mCacheEventListener.onCleared();
        this.mCacheStats.reset();
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearAll: " + localIOException.getMessage(), localIOException);
      }
    }
  }

  public long clearOldEntries(long paramLong)
  {
    long l1 = 0L;
    Object localObject1 = this.mLock;
    monitorenter;
    long l2 = l1;
    try
    {
      long l4 = this.mClock.now();
      l2 = l1;
      Object localObject2 = this.mStorage.getEntries();
      l2 = l1;
      long l5 = this.mCacheStats.getSize();
      i = 0;
      l3 = 0L;
      l2 = l1;
      localObject2 = ((Collection)localObject2).iterator();
      while (true)
      {
        l2 = l1;
        if (!((Iterator)localObject2).hasNext())
          break label319;
        l2 = l1;
        Object localObject4 = (DiskStorage.Entry)((Iterator)localObject2).next();
        l2 = l1;
        l6 = Math.max(1L, Math.abs(l4 - ((DiskStorage.Entry)localObject4).getTimestamp()));
        if (l6 < paramLong)
          break;
        l2 = l1;
        l6 = this.mStorage.remove((DiskStorage.Entry)localObject4);
        l2 = l1;
        this.mResourceIndex.remove(((DiskStorage.Entry)localObject4).getId());
        if (l6 <= 0L)
          continue;
        i += 1;
        l3 += l6;
        l2 = l1;
        localObject4 = SettableCacheEvent.obtain().setResourceId(((DiskStorage.Entry)localObject4).getId()).setEvictionReason(CacheEventListener.EvictionReason.CONTENT_STALE).setItemSize(l6).setCacheSize(l5 - l3);
        l2 = l1;
        this.mCacheEventListener.onEviction((CacheEvent)localObject4);
        l2 = l1;
        ((SettableCacheEvent)localObject4).recycle();
      }
    }
    catch (IOException localIOException)
    {
      int i;
      long l3;
      long l6;
      this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "clearOldEntries: " + localIOException.getMessage(), localIOException);
      while (true)
      {
        return l2;
        l2 = l1;
        l1 = Math.max(l1, l6);
        break;
        label319: l2 = l1;
        this.mStorage.purgeUnexpectedResources();
        l2 = l1;
        if (i <= 0)
          continue;
        l2 = l1;
        maybeUpdateFileCacheSize();
        l2 = l1;
        this.mCacheStats.increment(-l3, -i);
        l2 = l1;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject3;
  }

  public long getCount()
  {
    return this.mCacheStats.getCount();
  }

  public DiskStorage.DiskDumpInfo getDumpInfo()
    throws IOException
  {
    return this.mStorage.getDumpInfo();
  }

  public BinaryResource getResource(CacheKey paramCacheKey)
  {
    String str = null;
    SettableCacheEvent localSettableCacheEvent = SettableCacheEvent.obtain().setCacheKey(paramCacheKey);
    try
    {
      Object localObject = this.mLock;
      monitorenter;
      BinaryResource localBinaryResource = null;
      try
      {
        List localList = CacheKeyUtil.getResourceIds(paramCacheKey);
        int i = 0;
        if (i < localList.size())
        {
          str = (String)localList.get(i);
          localSettableCacheEvent.setResourceId(str);
          localBinaryResource = this.mStorage.getResource(str, paramCacheKey);
          if (localBinaryResource == null);
        }
        else
        {
          if (localBinaryResource != null)
            break label124;
          this.mCacheEventListener.onMiss(localSettableCacheEvent);
          this.mResourceIndex.remove(str);
        }
        while (true)
        {
          monitorexit;
          localSettableCacheEvent.recycle();
          return localBinaryResource;
          i += 1;
          break;
          label124: this.mCacheEventListener.onHit(localSettableCacheEvent);
          this.mResourceIndex.add(str);
        }
      }
      finally
      {
        monitorexit;
      }
    }
    catch (IOException paramCacheKey)
    {
      this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "getResource", paramCacheKey);
      localSettableCacheEvent.setException(paramCacheKey);
      this.mCacheEventListener.onReadException(localSettableCacheEvent);
      return null;
    }
    finally
    {
      localSettableCacheEvent.recycle();
    }
    throw paramCacheKey;
  }

  public long getSize()
  {
    return this.mCacheStats.getSize();
  }

  public boolean hasKey(CacheKey paramCacheKey)
  {
    while (true)
    {
      int i;
      synchronized (this.mLock)
      {
        if (hasKeySync(paramCacheKey))
          return true;
        try
        {
          List localList = CacheKeyUtil.getResourceIds(paramCacheKey);
          i = 0;
          if (i >= localList.size())
            continue;
          String str = (String)localList.get(i);
          if (this.mStorage.contains(str, paramCacheKey))
          {
            this.mResourceIndex.add(str);
            return true;
            return false;
          }
        }
        catch (IOException paramCacheKey)
        {
          return false;
        }
      }
      i += 1;
    }
  }

  public boolean hasKeySync(CacheKey paramCacheKey)
  {
    while (true)
    {
      int i;
      synchronized (this.mLock)
      {
        paramCacheKey = CacheKeyUtil.getResourceIds(paramCacheKey);
        i = 0;
        if (i >= paramCacheKey.size())
          continue;
        String str = (String)paramCacheKey.get(i);
        if (this.mResourceIndex.contains(str))
        {
          return true;
          return false;
        }
      }
      i += 1;
    }
  }

  public BinaryResource insert(CacheKey paramCacheKey, WriterCallback paramWriterCallback)
    throws IOException
  {
    SettableCacheEvent localSettableCacheEvent = SettableCacheEvent.obtain().setCacheKey(paramCacheKey);
    this.mCacheEventListener.onWriteAttempt(localSettableCacheEvent);
    String str;
    synchronized (this.mLock)
    {
      str = CacheKeyUtil.getFirstResourceId(paramCacheKey);
      localSettableCacheEvent.setResourceId(str);
    }
    try
    {
      ??? = startInsert(str, paramCacheKey);
      try
      {
        ((DiskStorage.Inserter)???).writeData(paramWriterCallback, paramCacheKey);
        paramCacheKey = endInsert((DiskStorage.Inserter)???, paramCacheKey, str);
        localSettableCacheEvent.setItemSize(paramCacheKey.size()).setCacheSize(this.mCacheStats.getSize());
        this.mCacheEventListener.onWriteSuccess(localSettableCacheEvent);
        if (!((DiskStorage.Inserter)???).cleanUp())
          FLog.e(TAG, "Failed to delete temp file");
        localSettableCacheEvent.recycle();
        return paramCacheKey;
        paramCacheKey = finally;
        monitorexit;
        throw paramCacheKey;
      }
      finally
      {
        if (!((DiskStorage.Inserter)???).cleanUp())
          FLog.e(TAG, "Failed to delete temp file");
      }
    }
    catch (IOException paramCacheKey)
    {
      localSettableCacheEvent.setException(paramCacheKey);
      this.mCacheEventListener.onWriteException(localSettableCacheEvent);
      FLog.e(TAG, "Failed inserting a file into the cache", paramCacheKey);
      throw paramCacheKey;
    }
    finally
    {
      localSettableCacheEvent.recycle();
    }
    throw paramCacheKey;
  }

  public boolean isEnabled()
  {
    return this.mStorage.isEnabled();
  }

  public boolean isIndexReady()
  {
    return (this.mIndexReady) || (!this.mIndexPopulateAtStartupEnabled);
  }

  public boolean probe(CacheKey paramCacheKey)
  {
    List localList = null;
    Object localObject3 = null;
    String str = null;
    Object localObject1 = localObject3;
    while (true)
    {
      int i;
      try
      {
        Object localObject4 = this.mLock;
        localObject1 = localObject3;
        monitorenter;
        localObject1 = localList;
        try
        {
          localList = CacheKeyUtil.getResourceIds(paramCacheKey);
          i = 0;
          localObject1 = str;
          if (i >= localList.size())
            continue;
          localObject1 = str;
          str = (String)localList.get(i);
          localObject1 = str;
          if (this.mStorage.touch(str, paramCacheKey))
          {
            localObject1 = str;
            this.mResourceIndex.add(str);
            localObject1 = str;
            return true;
            localObject1 = str;
            return false;
          }
        }
        finally
        {
          monitorexit;
        }
      }
      catch (IOException localIOException)
      {
        paramCacheKey = SettableCacheEvent.obtain().setCacheKey(paramCacheKey).setResourceId((String)localObject1).setException(localIOException);
        this.mCacheEventListener.onReadException(paramCacheKey);
        paramCacheKey.recycle();
        return false;
      }
      i += 1;
    }
  }

  public void remove(CacheKey paramCacheKey)
  {
    synchronized (this.mLock)
    {
      try
      {
        paramCacheKey = CacheKeyUtil.getResourceIds(paramCacheKey);
        int i = 0;
        while (i < paramCacheKey.size())
        {
          String str = (String)paramCacheKey.get(i);
          this.mStorage.remove(str);
          this.mResourceIndex.remove(str);
          i += 1;
        }
      }
      catch (IOException paramCacheKey)
      {
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, TAG, "delete: " + paramCacheKey.getMessage(), paramCacheKey);
        return;
      }
    }
  }

  public void trimToMinimum()
  {
    synchronized (this.mLock)
    {
      maybeUpdateFileCacheSize();
      long l = this.mCacheStats.getSize();
      if ((this.mCacheSizeLimitMinimum <= 0L) || (l <= 0L) || (l < this.mCacheSizeLimitMinimum))
        return;
      double d = 1.0D - this.mCacheSizeLimitMinimum / l;
      if (d > 0.02D)
        trimBy(d);
      return;
    }
  }

  public void trimToNothing()
  {
    clearAll();
  }

  @VisibleForTesting
  static class CacheStats
  {
    private long mCount = -1L;
    private boolean mInitialized = false;
    private long mSize = -1L;

    public long getCount()
    {
      monitorenter;
      try
      {
        long l = this.mCount;
        monitorexit;
        return l;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
      throw localObject;
    }

    public long getSize()
    {
      monitorenter;
      try
      {
        long l = this.mSize;
        monitorexit;
        return l;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
      throw localObject;
    }

    public void increment(long paramLong1, long paramLong2)
    {
      monitorenter;
      try
      {
        if (this.mInitialized)
        {
          this.mSize += paramLong1;
          this.mCount += paramLong2;
        }
        monitorexit;
        return;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
      throw localObject;
    }

    public boolean isInitialized()
    {
      monitorenter;
      try
      {
        boolean bool = this.mInitialized;
        monitorexit;
        return bool;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
      throw localObject;
    }

    public void reset()
    {
      monitorenter;
      try
      {
        this.mInitialized = false;
        this.mCount = -1L;
        this.mSize = -1L;
        monitorexit;
        return;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
      throw localObject;
    }

    public void set(long paramLong1, long paramLong2)
    {
      monitorenter;
      try
      {
        this.mCount = paramLong2;
        this.mSize = paramLong1;
        this.mInitialized = true;
        monitorexit;
        return;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
      throw localObject;
    }
  }

  public static class Params
  {
    public final long mCacheSizeLimitMinimum;
    public final long mDefaultCacheSizeLimit;
    public final long mLowDiskSpaceCacheSizeLimit;

    public Params(long paramLong1, long paramLong2, long paramLong3)
    {
      this.mCacheSizeLimitMinimum = paramLong1;
      this.mLowDiskSpaceCacheSizeLimit = paramLong2;
      this.mDefaultCacheSizeLimit = paramLong3;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.cache.disk.DiskStorageCache
 * JD-Core Version:    0.6.0
 */
package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.Pool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;

public abstract class BasePool<V>
  implements Pool<V>
{
  private final Class<?> TAG = getClass();
  private boolean mAllowNewBuckets;

  @VisibleForTesting
  final SparseArray<Bucket<V>> mBuckets;

  @VisibleForTesting
  @GuardedBy("this")
  final Counter mFree;

  @VisibleForTesting
  final Set<V> mInUseValues;
  final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
  final PoolParams mPoolParams;
  private final PoolStatsTracker mPoolStatsTracker;

  @VisibleForTesting
  @GuardedBy("this")
  final Counter mUsed;

  public BasePool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams, PoolStatsTracker paramPoolStatsTracker)
  {
    this.mMemoryTrimmableRegistry = ((MemoryTrimmableRegistry)Preconditions.checkNotNull(paramMemoryTrimmableRegistry));
    this.mPoolParams = ((PoolParams)Preconditions.checkNotNull(paramPoolParams));
    this.mPoolStatsTracker = ((PoolStatsTracker)Preconditions.checkNotNull(paramPoolStatsTracker));
    this.mBuckets = new SparseArray();
    initBuckets(new SparseIntArray(0));
    this.mInUseValues = Sets.newIdentityHashSet();
    this.mFree = new Counter();
    this.mUsed = new Counter();
  }

  private void ensurePoolSizeInvariant()
  {
    monitorenter;
    while (true)
    {
      try
      {
        if (isMaxSizeSoftCapExceeded())
        {
          if (this.mFree.mNumBytes != 0)
            continue;
          break label39;
          Preconditions.checkState(bool);
          return;
          bool = false;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      label39: boolean bool = true;
    }
  }

  private void initBuckets(SparseIntArray paramSparseIntArray)
  {
    monitorenter;
    try
    {
      Preconditions.checkNotNull(paramSparseIntArray);
      this.mBuckets.clear();
      SparseIntArray localSparseIntArray = this.mPoolParams.bucketSizes;
      if (localSparseIntArray != null)
      {
        int i = 0;
        while (i < localSparseIntArray.size())
        {
          int j = localSparseIntArray.keyAt(i);
          int k = localSparseIntArray.valueAt(i);
          int m = paramSparseIntArray.get(j, 0);
          this.mBuckets.put(j, new Bucket(getSizeInBytes(j), k, m));
          i += 1;
        }
      }
      for (this.mAllowNewBuckets = false; ; this.mAllowNewBuckets = true)
        return;
    }
    finally
    {
      monitorexit;
    }
    throw paramSparseIntArray;
  }

  @SuppressLint({"InvalidAccessToGuardedField"})
  private void logStats()
  {
    if (FLog.isLoggable(2))
      FLog.v(this.TAG, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mUsed.mCount), Integer.valueOf(this.mUsed.mNumBytes), Integer.valueOf(this.mFree.mCount), Integer.valueOf(this.mFree.mNumBytes));
  }

  protected abstract V alloc(int paramInt);

  @VisibleForTesting
  boolean canAllocate(int paramInt)
  {
    int k = 0;
    monitorenter;
    while (true)
    {
      try
      {
        int i = this.mPoolParams.maxSizeHardCap;
        if (paramInt <= i - this.mUsed.mNumBytes)
          continue;
        this.mPoolStatsTracker.onHardCapReached();
        return k;
        int j = this.mPoolParams.maxSizeSoftCap;
        if (paramInt <= j - (this.mUsed.mNumBytes + this.mFree.mNumBytes))
          continue;
        trimToSize(j - paramInt);
        if (paramInt > i - (this.mUsed.mNumBytes + this.mFree.mNumBytes))
        {
          this.mPoolStatsTracker.onHardCapReached();
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      k = 1;
    }
  }

  @VisibleForTesting
  protected abstract void free(V paramV);

  public V get(int paramInt)
  {
    ensurePoolSizeInvariant();
    paramInt = getBucketedSize(paramInt);
    monitorenter;
    Object localObject5;
    int i;
    try
    {
      Bucket localBucket1 = getBucket(paramInt);
      if (localBucket1 != null)
      {
        localObject5 = localBucket1.get();
        if (localObject5 != null)
        {
          Preconditions.checkState(this.mInUseValues.add(localObject5));
          paramInt = getBucketedSizeForValue(localObject5);
          i = getSizeInBytes(paramInt);
          this.mUsed.increment(i);
          this.mFree.decrement(i);
          this.mPoolStatsTracker.onValueReuse(i);
          logStats();
          if (FLog.isLoggable(2))
            FLog.v(this.TAG, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(localObject5)), Integer.valueOf(paramInt));
          return localObject5;
        }
      }
      i = getSizeInBytes(paramInt);
      if (!canAllocate(i))
        throw new PoolSizeViolationException(this.mPoolParams.maxSizeHardCap, this.mUsed.mNumBytes, this.mFree.mNumBytes, i);
    }
    finally
    {
      monitorexit;
    }
    this.mUsed.increment(i);
    if (localObject1 != null)
      localObject1.incrementInUseCount();
    monitorexit;
    Object localObject2 = null;
    try
    {
      localObject5 = alloc(paramInt);
      localObject2 = localObject5;
      monitorenter;
      try
      {
        Preconditions.checkState(this.mInUseValues.add(localObject2));
        trimToSoftCap();
        this.mPoolStatsTracker.onAlloc(i);
        logStats();
        if (FLog.isLoggable(2))
          FLog.v(this.TAG, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(localObject2)), Integer.valueOf(paramInt));
        return localObject2;
      }
      finally
      {
        monitorexit;
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        monitorenter;
        try
        {
          this.mUsed.decrement(i);
          Bucket localBucket2 = getBucket(paramInt);
          if (localBucket2 != null)
            localBucket2.decrementInUseCount();
          monitorexit;
          Throwables.propagateIfPossible(localThrowable);
          continue;
        }
        finally
        {
          monitorexit;
        }
      }
    }
    throw localObject4;
  }

  @VisibleForTesting
  Bucket<V> getBucket(int paramInt)
  {
    monitorenter;
    try
    {
      Bucket localBucket = (Bucket)this.mBuckets.get(paramInt);
      if (localBucket == null)
      {
        boolean bool = this.mAllowNewBuckets;
        if (bool)
          break label31;
      }
      while (true)
      {
        return localBucket;
        label31: if (FLog.isLoggable(2))
          FLog.v(this.TAG, "creating new bucket %s", Integer.valueOf(paramInt));
        localBucket = newBucket(paramInt);
        this.mBuckets.put(paramInt, localBucket);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  protected abstract int getBucketedSize(int paramInt);

  protected abstract int getBucketedSizeForValue(V paramV);

  protected abstract int getSizeInBytes(int paramInt);

  public Map<String, Integer> getStats()
  {
    monitorenter;
    try
    {
      HashMap localHashMap = new HashMap();
      int i = 0;
      while (i < this.mBuckets.size())
      {
        int j = this.mBuckets.keyAt(i);
        Bucket localBucket = (Bucket)this.mBuckets.valueAt(i);
        localHashMap.put("buckets_used_" + getSizeInBytes(j), Integer.valueOf(localBucket.getInUseCount()));
        i += 1;
      }
      localHashMap.put("soft_cap", Integer.valueOf(this.mPoolParams.maxSizeSoftCap));
      localHashMap.put("hard_cap", Integer.valueOf(this.mPoolParams.maxSizeHardCap));
      localHashMap.put("used_count", Integer.valueOf(this.mUsed.mCount));
      localHashMap.put("used_bytes", Integer.valueOf(this.mUsed.mNumBytes));
      localHashMap.put("free_count", Integer.valueOf(this.mFree.mCount));
      localHashMap.put("free_bytes", Integer.valueOf(this.mFree.mNumBytes));
      return localHashMap;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  protected void initialize()
  {
    this.mMemoryTrimmableRegistry.registerMemoryTrimmable(this);
    this.mPoolStatsTracker.setBasePool(this);
  }

  @VisibleForTesting
  boolean isMaxSizeSoftCapExceeded()
  {
    monitorenter;
    try
    {
      if (this.mUsed.mNumBytes + this.mFree.mNumBytes > this.mPoolParams.maxSizeSoftCap);
      for (int i = 1; ; i = 0)
      {
        if (i != 0)
          this.mPoolStatsTracker.onSoftCapReached();
        return i;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  protected boolean isReusable(V paramV)
  {
    Preconditions.checkNotNull(paramV);
    return true;
  }

  Bucket<V> newBucket(int paramInt)
  {
    return new Bucket(getSizeInBytes(paramInt), 2147483647, 0);
  }

  protected void onParamsChanged()
  {
  }

  public void release(V paramV)
  {
    Preconditions.checkNotNull(paramV);
    int i = getBucketedSizeForValue(paramV);
    int j = getSizeInBytes(i);
    monitorenter;
    while (true)
    {
      Bucket localBucket;
      try
      {
        localBucket = getBucket(i);
        if (this.mInUseValues.remove(paramV))
          continue;
        FLog.e(this.TAG, "release (free, value unrecognized) (object, size) = (%x, %s)", new Object[] { Integer.valueOf(System.identityHashCode(paramV)), Integer.valueOf(i) });
        free(paramV);
        this.mPoolStatsTracker.onFree(j);
        logStats();
        return;
        if ((localBucket == null) || (localBucket.isMaxLengthExceeded()) || (isMaxSizeSoftCapExceeded()) || (!isReusable(paramV)))
        {
          if (localBucket == null)
            continue;
          localBucket.decrementInUseCount();
          if (!FLog.isLoggable(2))
            continue;
          FLog.v(this.TAG, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(paramV)), Integer.valueOf(i));
          free(paramV);
          this.mUsed.decrement(j);
          this.mPoolStatsTracker.onFree(j);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      localBucket.release(paramV);
      this.mFree.increment(j);
      this.mUsed.decrement(j);
      this.mPoolStatsTracker.onValueRelease(j);
      if (!FLog.isLoggable(2))
        continue;
      FLog.v(this.TAG, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(paramV)), Integer.valueOf(i));
    }
  }

  public void trim(MemoryTrimType paramMemoryTrimType)
  {
    trimToNothing();
  }

  @VisibleForTesting
  void trimToNothing()
  {
    ArrayList localArrayList = new ArrayList(this.mBuckets.size());
    Object localObject2 = new SparseIntArray();
    monitorenter;
    int i = 0;
    while (true)
    {
      Object localObject3;
      try
      {
        if (i >= this.mBuckets.size())
          continue;
        localObject3 = (Bucket)this.mBuckets.valueAt(i);
        if (((Bucket)localObject3).getFreeListSize() <= 0)
          continue;
        localArrayList.add(localObject3);
        ((SparseIntArray)localObject2).put(this.mBuckets.keyAt(i), ((Bucket)localObject3).getInUseCount());
        i += 1;
        continue;
        initBuckets((SparseIntArray)localObject2);
        this.mFree.reset();
        logStats();
        monitorexit;
        onParamsChanged();
        i = 0;
        if (i >= localArrayList.size())
          break;
        localObject2 = (Bucket)localArrayList.get(i);
        localObject3 = ((Bucket)localObject2).pop();
        if (localObject3 == null)
        {
          i += 1;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      free(localObject3);
    }
  }

  @VisibleForTesting
  void trimToSize(int paramInt)
  {
    monitorenter;
    while (true)
    {
      int j;
      int i;
      try
      {
        j = Math.min(this.mUsed.mNumBytes + this.mFree.mNumBytes - paramInt, this.mFree.mNumBytes);
        if (j <= 0)
          return;
        if (!FLog.isLoggable(2))
          continue;
        FLog.v(this.TAG, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(paramInt), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes), Integer.valueOf(j));
        logStats();
        i = 0;
        if ((i >= this.mBuckets.size()) || (j <= 0))
        {
          logStats();
          if (!FLog.isLoggable(2))
            continue;
          FLog.v(this.TAG, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(paramInt), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes));
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      Bucket localBucket = (Bucket)this.mBuckets.valueAt(i);
      while (j > 0)
      {
        Object localObject2 = localBucket.pop();
        if (localObject2 == null)
          break;
        free(localObject2);
        j -= localBucket.mItemSize;
        this.mFree.decrement(localBucket.mItemSize);
      }
      i += 1;
    }
  }

  @VisibleForTesting
  void trimToSoftCap()
  {
    monitorenter;
    try
    {
      if (isMaxSizeSoftCapExceeded())
        trimToSize(this.mPoolParams.maxSizeSoftCap);
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

  @VisibleForTesting
  @NotThreadSafe
  static class Counter
  {
    private static final String TAG = "com.facebook.imagepipeline.memory.BasePool.Counter";
    int mCount;
    int mNumBytes;

    public void decrement(int paramInt)
    {
      if ((this.mNumBytes >= paramInt) && (this.mCount > 0))
      {
        this.mCount -= 1;
        this.mNumBytes -= paramInt;
        return;
      }
      FLog.wtf("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mNumBytes), Integer.valueOf(this.mCount) });
    }

    public void increment(int paramInt)
    {
      this.mCount += 1;
      this.mNumBytes += paramInt;
    }

    public void reset()
    {
      this.mCount = 0;
      this.mNumBytes = 0;
    }
  }

  public static class InvalidSizeException extends RuntimeException
  {
    public InvalidSizeException(Object paramObject)
    {
      super();
    }
  }

  public static class InvalidValueException extends RuntimeException
  {
    public InvalidValueException(Object paramObject)
    {
      super();
    }
  }

  public static class PoolSizeViolationException extends RuntimeException
  {
    public PoolSizeViolationException(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super();
    }
  }

  public static class SizeTooLargeException extends BasePool.InvalidSizeException
  {
    public SizeTooLargeException(Object paramObject)
    {
      super();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.BasePool
 * JD-Core Version:    0.6.0
 */
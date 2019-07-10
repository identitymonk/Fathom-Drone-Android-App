package com.facebook.cache.disk;

import com.facebook.cache.common.CacheEvent;
import com.facebook.cache.common.CacheEventListener.EvictionReason;
import com.facebook.cache.common.CacheKey;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.io.IOException;
import javax.annotation.Nullable;

public class SettableCacheEvent
  implements CacheEvent
{
  private static final int MAX_RECYCLED = 5;
  private static final Object RECYCLER_LOCK = new Object();
  private static SettableCacheEvent sFirstRecycledEvent;
  private static int sRecycledCount;
  private CacheKey mCacheKey;
  private long mCacheLimit;
  private long mCacheSize;
  private CacheEventListener.EvictionReason mEvictionReason;
  private IOException mException;
  private long mItemSize;
  private SettableCacheEvent mNextRecycledEvent;
  private String mResourceId;

  @ReturnsOwnership
  public static SettableCacheEvent obtain()
  {
    synchronized (RECYCLER_LOCK)
    {
      if (sFirstRecycledEvent != null)
      {
        SettableCacheEvent localSettableCacheEvent = sFirstRecycledEvent;
        sFirstRecycledEvent = localSettableCacheEvent.mNextRecycledEvent;
        localSettableCacheEvent.mNextRecycledEvent = null;
        sRecycledCount -= 1;
        return localSettableCacheEvent;
      }
      return new SettableCacheEvent();
    }
  }

  private void reset()
  {
    this.mCacheKey = null;
    this.mResourceId = null;
    this.mItemSize = 0L;
    this.mCacheLimit = 0L;
    this.mCacheSize = 0L;
    this.mException = null;
    this.mEvictionReason = null;
  }

  @Nullable
  public CacheKey getCacheKey()
  {
    return this.mCacheKey;
  }

  public long getCacheLimit()
  {
    return this.mCacheLimit;
  }

  public long getCacheSize()
  {
    return this.mCacheSize;
  }

  @Nullable
  public CacheEventListener.EvictionReason getEvictionReason()
  {
    return this.mEvictionReason;
  }

  @Nullable
  public IOException getException()
  {
    return this.mException;
  }

  public long getItemSize()
  {
    return this.mItemSize;
  }

  @Nullable
  public String getResourceId()
  {
    return this.mResourceId;
  }

  public void recycle()
  {
    synchronized (RECYCLER_LOCK)
    {
      if (sRecycledCount < 5)
      {
        reset();
        sRecycledCount += 1;
        if (sFirstRecycledEvent != null)
          this.mNextRecycledEvent = sFirstRecycledEvent;
        sFirstRecycledEvent = this;
      }
      return;
    }
  }

  public SettableCacheEvent setCacheKey(CacheKey paramCacheKey)
  {
    this.mCacheKey = paramCacheKey;
    return this;
  }

  public SettableCacheEvent setCacheLimit(long paramLong)
  {
    this.mCacheLimit = paramLong;
    return this;
  }

  public SettableCacheEvent setCacheSize(long paramLong)
  {
    this.mCacheSize = paramLong;
    return this;
  }

  public SettableCacheEvent setEvictionReason(CacheEventListener.EvictionReason paramEvictionReason)
  {
    this.mEvictionReason = paramEvictionReason;
    return this;
  }

  public SettableCacheEvent setException(IOException paramIOException)
  {
    this.mException = paramIOException;
    return this;
  }

  public SettableCacheEvent setItemSize(long paramLong)
  {
    this.mItemSize = paramLong;
    return this;
  }

  public SettableCacheEvent setResourceId(String paramString)
  {
    this.mResourceId = paramString;
    return this;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.cache.disk.SettableCacheEvent
 * JD-Core Version:    0.6.0
 */
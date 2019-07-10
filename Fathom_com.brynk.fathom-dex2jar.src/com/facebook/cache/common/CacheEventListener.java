package com.facebook.cache.common;

public abstract interface CacheEventListener
{
  public abstract void onCleared();

  public abstract void onEviction(CacheEvent paramCacheEvent);

  public abstract void onHit(CacheEvent paramCacheEvent);

  public abstract void onMiss(CacheEvent paramCacheEvent);

  public abstract void onReadException(CacheEvent paramCacheEvent);

  public abstract void onWriteAttempt(CacheEvent paramCacheEvent);

  public abstract void onWriteException(CacheEvent paramCacheEvent);

  public abstract void onWriteSuccess(CacheEvent paramCacheEvent);

  public static enum EvictionReason
  {
    static
    {
      CACHE_MANAGER_TRIMMED = new EvictionReason("CACHE_MANAGER_TRIMMED", 3);
      $VALUES = new EvictionReason[] { CACHE_FULL, CONTENT_STALE, USER_FORCED, CACHE_MANAGER_TRIMMED };
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.CacheEventListener
 * JD-Core Version:    0.6.0
 */
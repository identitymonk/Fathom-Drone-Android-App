package com.facebook.cache.common;

public class NoOpCacheEventListener
  implements CacheEventListener
{
  private static NoOpCacheEventListener sInstance = null;

  public static NoOpCacheEventListener getInstance()
  {
    monitorenter;
    try
    {
      if (sInstance == null)
        sInstance = new NoOpCacheEventListener();
      NoOpCacheEventListener localNoOpCacheEventListener = sInstance;
      return localNoOpCacheEventListener;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void onCleared()
  {
  }

  public void onEviction(CacheEvent paramCacheEvent)
  {
  }

  public void onHit(CacheEvent paramCacheEvent)
  {
  }

  public void onMiss(CacheEvent paramCacheEvent)
  {
  }

  public void onReadException(CacheEvent paramCacheEvent)
  {
  }

  public void onWriteAttempt(CacheEvent paramCacheEvent)
  {
  }

  public void onWriteException(CacheEvent paramCacheEvent)
  {
  }

  public void onWriteSuccess(CacheEvent paramCacheEvent)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.NoOpCacheEventListener
 * JD-Core Version:    0.6.0
 */
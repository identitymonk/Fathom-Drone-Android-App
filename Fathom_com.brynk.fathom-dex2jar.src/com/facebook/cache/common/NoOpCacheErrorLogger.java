package com.facebook.cache.common;

import javax.annotation.Nullable;

public class NoOpCacheErrorLogger
  implements CacheErrorLogger
{
  private static NoOpCacheErrorLogger sInstance = null;

  public static NoOpCacheErrorLogger getInstance()
  {
    monitorenter;
    try
    {
      if (sInstance == null)
        sInstance = new NoOpCacheErrorLogger();
      NoOpCacheErrorLogger localNoOpCacheErrorLogger = sInstance;
      return localNoOpCacheErrorLogger;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void logError(CacheErrorLogger.CacheErrorCategory paramCacheErrorCategory, Class<?> paramClass, String paramString, @Nullable Throwable paramThrowable)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.NoOpCacheErrorLogger
 * JD-Core Version:    0.6.0
 */
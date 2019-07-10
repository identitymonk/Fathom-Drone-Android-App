package com.facebook.cache.common;

import javax.annotation.Nullable;

public class DebuggingCacheKey extends SimpleCacheKey
{
  private final Object mCallerContext;

  public DebuggingCacheKey(String paramString, @Nullable Object paramObject)
  {
    super(paramString);
    this.mCallerContext = paramObject;
  }

  @Nullable
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.DebuggingCacheKey
 * JD-Core Version:    0.6.0
 */
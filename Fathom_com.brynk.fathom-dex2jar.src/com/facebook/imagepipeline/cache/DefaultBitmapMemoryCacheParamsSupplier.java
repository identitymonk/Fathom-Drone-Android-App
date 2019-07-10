package com.facebook.imagepipeline.cache;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import com.facebook.common.internal.Supplier;

public class DefaultBitmapMemoryCacheParamsSupplier
  implements Supplier<MemoryCacheParams>
{
  private static final int MAX_CACHE_ENTRIES = 256;
  private static final int MAX_CACHE_ENTRY_SIZE = 2147483647;
  private static final int MAX_EVICTION_QUEUE_ENTRIES = 2147483647;
  private static final int MAX_EVICTION_QUEUE_SIZE = 2147483647;
  private final ActivityManager mActivityManager;

  public DefaultBitmapMemoryCacheParamsSupplier(ActivityManager paramActivityManager)
  {
    this.mActivityManager = paramActivityManager;
  }

  private int getMaxCacheSize()
  {
    int i = Math.min(this.mActivityManager.getMemoryClass() * 1048576, 2147483647);
    if (i < 33554432)
      return 4194304;
    if (i < 67108864)
      return 6291456;
    if (Build.VERSION.SDK_INT < 11)
      return 8388608;
    return i / 4;
  }

  public MemoryCacheParams get()
  {
    return new MemoryCacheParams(getMaxCacheSize(), 256, 2147483647, 2147483647, 2147483647);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier
 * JD-Core Version:    0.6.0
 */
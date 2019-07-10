package com.facebook.imagepipeline.cache;

import android.os.Build.VERSION;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;

public class BitmapMemoryCacheTrimStrategy
  implements CountingMemoryCache.CacheTrimStrategy
{
  private static final String TAG = "BitmapMemoryCacheTrimStrategy";

  public double getTrimRatio(MemoryTrimType paramMemoryTrimType)
  {
    switch (1.$SwitchMap$com$facebook$common$memory$MemoryTrimType[paramMemoryTrimType.ordinal()])
    {
    default:
      FLog.wtf("BitmapMemoryCacheTrimStrategy", "unknown trim type: %s", new Object[] { paramMemoryTrimType });
    case 1:
      do
        return 0.0D;
      while (Build.VERSION.SDK_INT < 21);
      return MemoryTrimType.OnCloseToDalvikHeapLimit.getSuggestedTrimRatio();
    case 2:
    case 3:
    case 4:
    }
    return 1.0D;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy
 * JD-Core Version:    0.6.0
 */
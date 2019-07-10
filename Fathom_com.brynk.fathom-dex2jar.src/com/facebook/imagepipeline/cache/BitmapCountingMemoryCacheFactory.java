package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;

public class BitmapCountingMemoryCacheFactory
{
  public static CountingMemoryCache<CacheKey, CloseableImage> get(Supplier<MemoryCacheParams> paramSupplier, MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PlatformBitmapFactory paramPlatformBitmapFactory, boolean paramBoolean)
  {
    paramSupplier = new CountingMemoryCache(new ValueDescriptor()
    {
      public int getSizeInBytes(CloseableImage paramCloseableImage)
      {
        return paramCloseableImage.getSizeInBytes();
      }
    }
    , new BitmapMemoryCacheTrimStrategy(), paramSupplier, paramPlatformBitmapFactory, paramBoolean);
    paramMemoryTrimmableRegistry.registerMemoryTrimmable(paramSupplier);
    return paramSupplier;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory
 * JD-Core Version:    0.6.0
 */
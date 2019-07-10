package com.facebook.imagepipeline.cache;

import bolts.Task;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import java.util.concurrent.atomic.AtomicBoolean;

public class SmallCacheIfRequestedDiskCachePolicy
  implements DiskCachePolicy
{
  private final CacheKeyFactory mCacheKeyFactory;
  private final BufferedDiskCache mDefaultBufferedDiskCache;
  private final BufferedDiskCache mSmallImageBufferedDiskCache;

  public SmallCacheIfRequestedDiskCachePolicy(BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory)
  {
    this.mDefaultBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mCacheKeyFactory = paramCacheKeyFactory;
  }

  public Task<EncodedImage> createAndStartCacheReadTask(ImageRequest paramImageRequest, Object paramObject, AtomicBoolean paramAtomicBoolean)
  {
    paramObject = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, paramObject);
    if (paramImageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL)
      return this.mSmallImageBufferedDiskCache.get(paramObject, paramAtomicBoolean);
    return this.mDefaultBufferedDiskCache.get(paramObject, paramAtomicBoolean);
  }

  public ImageRequest.CacheChoice getCacheChoiceForResult(ImageRequest paramImageRequest, EncodedImage paramEncodedImage)
  {
    if (paramImageRequest.getCacheChoice() == null)
      return ImageRequest.CacheChoice.DEFAULT;
    return paramImageRequest.getCacheChoice();
  }

  public void writeToCache(EncodedImage paramEncodedImage, ImageRequest paramImageRequest, Object paramObject)
  {
    paramObject = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, paramObject);
    if (getCacheChoiceForResult(paramImageRequest, paramEncodedImage) == ImageRequest.CacheChoice.SMALL)
    {
      this.mSmallImageBufferedDiskCache.put(paramObject, paramEncodedImage);
      return;
    }
    this.mDefaultBufferedDiskCache.put(paramObject, paramEncodedImage);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.SmallCacheIfRequestedDiskCachePolicy
 * JD-Core Version:    0.6.0
 */
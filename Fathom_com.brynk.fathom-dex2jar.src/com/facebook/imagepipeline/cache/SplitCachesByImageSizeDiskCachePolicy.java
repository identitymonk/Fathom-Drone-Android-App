package com.facebook.imagepipeline.cache;

import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

public class SplitCachesByImageSizeDiskCachePolicy
  implements DiskCachePolicy
{
  private final CacheKeyFactory mCacheKeyFactory;
  private final BufferedDiskCache mDefaultBufferedDiskCache;
  private final int mForceSmallCacheThresholdBytes;
  private final BufferedDiskCache mSmallImageBufferedDiskCache;

  public SplitCachesByImageSizeDiskCachePolicy(BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, int paramInt)
  {
    this.mDefaultBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mForceSmallCacheThresholdBytes = paramInt;
  }

  private static boolean isTaskCancelled(Task<?> paramTask)
  {
    return (paramTask.isCancelled()) || ((paramTask.isFaulted()) && ((paramTask.getError() instanceof CancellationException)));
  }

  public Task<EncodedImage> createAndStartCacheReadTask(ImageRequest paramImageRequest, Object paramObject, AtomicBoolean paramAtomicBoolean)
  {
    CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, paramObject);
    boolean bool1 = this.mSmallImageBufferedDiskCache.containsSync(localCacheKey);
    boolean bool2 = this.mDefaultBufferedDiskCache.containsSync(localCacheKey);
    if ((bool1) || (!bool2))
      paramImageRequest = this.mSmallImageBufferedDiskCache;
    for (paramObject = this.mDefaultBufferedDiskCache; ; paramObject = this.mSmallImageBufferedDiskCache)
    {
      return paramImageRequest.get(localCacheKey, paramAtomicBoolean).continueWithTask(new Continuation(paramObject, localCacheKey, paramAtomicBoolean)
      {
        public Task<EncodedImage> then(Task<EncodedImage> paramTask)
          throws Exception
        {
          if ((SplitCachesByImageSizeDiskCachePolicy.access$000(paramTask)) || ((!paramTask.isFaulted()) && (paramTask.getResult() != null)))
            return paramTask;
          return this.val$secondCache.get(this.val$cacheKey, this.val$isCancelled);
        }
      });
      paramImageRequest = this.mDefaultBufferedDiskCache;
    }
  }

  public ImageRequest.CacheChoice getCacheChoiceForResult(ImageRequest paramImageRequest, EncodedImage paramEncodedImage)
  {
    int i = paramEncodedImage.getSize();
    if ((i >= 0) && (i < this.mForceSmallCacheThresholdBytes))
      return ImageRequest.CacheChoice.SMALL;
    return ImageRequest.CacheChoice.DEFAULT;
  }

  public void writeToCache(EncodedImage paramEncodedImage, ImageRequest paramImageRequest, Object paramObject)
  {
    paramObject = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, paramObject);
    switch (2.$SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice[getCacheChoiceForResult(paramImageRequest, paramEncodedImage).ordinal()])
    {
    default:
      return;
    case 1:
      this.mDefaultBufferedDiskCache.put(paramObject, paramEncodedImage);
      return;
    case 2:
    }
    this.mSmallImageBufferedDiskCache.put(paramObject, paramEncodedImage);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.SplitCachesByImageSizeDiskCachePolicy
 * JD-Core Version:    0.6.0
 */
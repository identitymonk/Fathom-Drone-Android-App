package com.facebook.imagepipeline.cache;

import bolts.Task;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract interface DiskCachePolicy
{
  public abstract Task<EncodedImage> createAndStartCacheReadTask(ImageRequest paramImageRequest, Object paramObject, AtomicBoolean paramAtomicBoolean);

  public abstract ImageRequest.CacheChoice getCacheChoiceForResult(ImageRequest paramImageRequest, EncodedImage paramEncodedImage);

  public abstract void writeToCache(EncodedImage paramEncodedImage, ImageRequest paramImageRequest, Object paramObject);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.DiskCachePolicy
 * JD-Core Version:    0.6.0
 */
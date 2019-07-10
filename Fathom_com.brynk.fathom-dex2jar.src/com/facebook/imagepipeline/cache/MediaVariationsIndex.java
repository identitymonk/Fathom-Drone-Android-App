package com.facebook.imagepipeline.cache;

import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import com.facebook.imagepipeline.request.MediaVariations;
import com.facebook.imagepipeline.request.MediaVariations.Builder;

public abstract interface MediaVariationsIndex
{
  public abstract Task<MediaVariations> getCachedVariants(String paramString, MediaVariations.Builder paramBuilder);

  public abstract void saveCachedVariant(String paramString, ImageRequest.CacheChoice paramCacheChoice, CacheKey paramCacheKey, EncodedImage paramEncodedImage);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.MediaVariationsIndex
 * JD-Core Version:    0.6.0
 */
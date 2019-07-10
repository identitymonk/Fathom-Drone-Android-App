package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;

public abstract interface CacheKeyFactory
{
  public abstract CacheKey getBitmapCacheKey(ImageRequest paramImageRequest, Object paramObject);

  public abstract CacheKey getEncodedCacheKey(ImageRequest paramImageRequest, Uri paramUri, @Nullable Object paramObject);

  public abstract CacheKey getEncodedCacheKey(ImageRequest paramImageRequest, @Nullable Object paramObject);

  public abstract CacheKey getPostprocessedBitmapCacheKey(ImageRequest paramImageRequest, Object paramObject);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.CacheKeyFactory
 * JD-Core Version:    0.6.0
 */
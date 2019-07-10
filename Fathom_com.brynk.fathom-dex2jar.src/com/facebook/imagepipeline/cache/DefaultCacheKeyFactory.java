package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import javax.annotation.Nullable;

public class DefaultCacheKeyFactory
  implements CacheKeyFactory
{
  private static DefaultCacheKeyFactory sInstance = null;

  public static DefaultCacheKeyFactory getInstance()
  {
    monitorenter;
    try
    {
      if (sInstance == null)
        sInstance = new DefaultCacheKeyFactory();
      DefaultCacheKeyFactory localDefaultCacheKeyFactory = sInstance;
      return localDefaultCacheKeyFactory;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public CacheKey getBitmapCacheKey(ImageRequest paramImageRequest, Object paramObject)
  {
    return new BitmapMemoryCacheKey(getCacheKeySourceUri(paramImageRequest.getSourceUri()).toString(), paramImageRequest.getResizeOptions(), paramImageRequest.getRotationOptions(), paramImageRequest.getImageDecodeOptions(), null, null, paramObject);
  }

  protected Uri getCacheKeySourceUri(Uri paramUri)
  {
    return paramUri;
  }

  public CacheKey getEncodedCacheKey(ImageRequest paramImageRequest, Uri paramUri, @Nullable Object paramObject)
  {
    return new SimpleCacheKey(getCacheKeySourceUri(paramUri).toString());
  }

  public CacheKey getEncodedCacheKey(ImageRequest paramImageRequest, @Nullable Object paramObject)
  {
    return getEncodedCacheKey(paramImageRequest, paramImageRequest.getSourceUri(), paramObject);
  }

  public CacheKey getPostprocessedBitmapCacheKey(ImageRequest paramImageRequest, Object paramObject)
  {
    Object localObject = paramImageRequest.getPostprocessor();
    CacheKey localCacheKey;
    if (localObject != null)
      localCacheKey = ((Postprocessor)localObject).getPostprocessorCacheKey();
    for (localObject = localObject.getClass().getName(); ; localObject = null)
    {
      return new BitmapMemoryCacheKey(getCacheKeySourceUri(paramImageRequest.getSourceUri()).toString(), paramImageRequest.getResizeOptions(), paramImageRequest.getRotationOptions(), paramImageRequest.getImageDecodeOptions(), localCacheKey, (String)localObject, paramObject);
      localCacheKey = null;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.DefaultCacheKeyFactory
 * JD-Core Version:    0.6.0
 */
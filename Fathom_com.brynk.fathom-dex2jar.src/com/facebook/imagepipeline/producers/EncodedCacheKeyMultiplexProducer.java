package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;

public class EncodedCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, ImageRequest.RequestLevel>, EncodedImage>
{
  private final CacheKeyFactory mCacheKeyFactory;

  public EncodedCacheKeyMultiplexProducer(CacheKeyFactory paramCacheKeyFactory, Producer paramProducer)
  {
    super(paramProducer);
    this.mCacheKeyFactory = paramCacheKeyFactory;
  }

  public EncodedImage cloneOrNull(EncodedImage paramEncodedImage)
  {
    return EncodedImage.cloneOrNull(paramEncodedImage);
  }

  protected Pair<CacheKey, ImageRequest.RequestLevel> getKey(ProducerContext paramProducerContext)
  {
    return Pair.create(this.mCacheKeyFactory.getEncodedCacheKey(paramProducerContext.getImageRequest(), paramProducerContext.getCallerContext()), paramProducerContext.getLowestPermittedRequestLevel());
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer
 * JD-Core Version:    0.6.0
 */
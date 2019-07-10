package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.cache.DiskCachePolicy;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;

public class DiskCacheWriteProducer
  implements Producer<EncodedImage>
{
  private final DiskCachePolicy mDiskCachePolicy;
  private final Producer<EncodedImage> mInputProducer;

  public DiskCacheWriteProducer(Producer<EncodedImage> paramProducer, DiskCachePolicy paramDiskCachePolicy)
  {
    this.mInputProducer = paramProducer;
    this.mDiskCachePolicy = paramDiskCachePolicy;
  }

  private void maybeStartInputProducer(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    if (paramProducerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue())
    {
      paramConsumer.onNewResult(null, true);
      return;
    }
    if (paramProducerContext.getImageRequest().isDiskCacheEnabled())
      paramConsumer = new DiskCacheWriteConsumer(paramConsumer, paramProducerContext, this.mDiskCachePolicy, null);
    while (true)
    {
      this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
      return;
    }
  }

  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    maybeStartInputProducer(paramConsumer, paramProducerContext);
  }

  private static class DiskCacheWriteConsumer extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private final DiskCachePolicy mDiskCachePolicy;
    private final ProducerContext mProducerContext;

    private DiskCacheWriteConsumer(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext, DiskCachePolicy paramDiskCachePolicy)
    {
      super();
      this.mProducerContext = paramProducerContext;
      this.mDiskCachePolicy = paramDiskCachePolicy;
    }

    public void onNewResultImpl(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      if ((paramEncodedImage != null) && (paramBoolean))
        this.mDiskCachePolicy.writeToCache(paramEncodedImage, this.mProducerContext.getImageRequest(), this.mProducerContext.getCallerContext());
      getConsumer().onNewResult(paramEncodedImage, paramBoolean);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.DiskCacheWriteProducer
 * JD-Core Version:    0.6.0
 */
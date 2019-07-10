package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;

public class AddImageTransformMetaDataProducer
  implements Producer<EncodedImage>
{
  private final Producer<EncodedImage> mInputProducer;

  public AddImageTransformMetaDataProducer(Producer<EncodedImage> paramProducer)
  {
    this.mInputProducer = paramProducer;
  }

  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    this.mInputProducer.produceResults(new AddImageTransformMetaDataConsumer(paramConsumer, null), paramProducerContext);
  }

  private static class AddImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private AddImageTransformMetaDataConsumer(Consumer<EncodedImage> paramConsumer)
    {
      super();
    }

    protected void onNewResultImpl(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      if (paramEncodedImage == null)
      {
        getConsumer().onNewResult(null, paramBoolean);
        return;
      }
      if (!EncodedImage.isMetaDataAvailable(paramEncodedImage))
        paramEncodedImage.parseMetaData();
      getConsumer().onNewResult(paramEncodedImage, paramBoolean);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer
 * JD-Core Version:    0.6.0
 */
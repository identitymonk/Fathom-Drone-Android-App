package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;

public class RemoveImageTransformMetaDataProducer
  implements Producer<CloseableReference<PooledByteBuffer>>
{
  private final Producer<EncodedImage> mInputProducer;

  public RemoveImageTransformMetaDataProducer(Producer<EncodedImage> paramProducer)
  {
    this.mInputProducer = paramProducer;
  }

  public void produceResults(Consumer<CloseableReference<PooledByteBuffer>> paramConsumer, ProducerContext paramProducerContext)
  {
    this.mInputProducer.produceResults(new RemoveImageTransformMetaDataConsumer(paramConsumer, null), paramProducerContext);
  }

  private class RemoveImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, CloseableReference<PooledByteBuffer>>
  {
    private RemoveImageTransformMetaDataConsumer()
    {
      super();
    }

    protected void onNewResultImpl(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      Object localObject2 = null;
      CloseableReference localCloseableReference = null;
      Object localObject1 = localObject2;
      try
      {
        if (EncodedImage.isValid(paramEncodedImage))
        {
          localObject1 = localObject2;
          localCloseableReference = paramEncodedImage.getByteBufferRef();
        }
        localObject1 = localCloseableReference;
        getConsumer().onNewResult(localCloseableReference, paramBoolean);
        CloseableReference.closeSafely(localCloseableReference);
        return;
      }
      finally
      {
        CloseableReference.closeSafely((CloseableReference)localObject1);
      }
      throw paramEncodedImage;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer
 * JD-Core Version:    0.6.0
 */
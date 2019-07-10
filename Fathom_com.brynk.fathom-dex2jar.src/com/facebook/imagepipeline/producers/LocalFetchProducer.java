package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

public abstract class LocalFetchProducer
  implements Producer<EncodedImage>
{
  private final Executor mExecutor;
  private final PooledByteBufferFactory mPooledByteBufferFactory;

  protected LocalFetchProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory)
  {
    this.mExecutor = paramExecutor;
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
  }

  protected EncodedImage getByteBufferBackedEncodedImage(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    Object localObject2 = null;
    if (paramInt <= 0);
    try
    {
      for (CloseableReference localCloseableReference = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(paramInputStream)); ; localCloseableReference = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(paramInputStream, paramInt)))
      {
        localObject2 = localCloseableReference;
        EncodedImage localEncodedImage = new EncodedImage(localCloseableReference);
        return localEncodedImage;
      }
    }
    finally
    {
      Closeables.closeQuietly(paramInputStream);
      CloseableReference.closeSafely(localObject2);
    }
    throw localObject1;
  }

  protected abstract EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException;

  protected EncodedImage getEncodedImage(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    return getByteBufferBackedEncodedImage(paramInputStream, paramInt);
  }

  protected abstract String getProducerName();

  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    ProducerListener localProducerListener = paramProducerContext.getListener();
    String str = paramProducerContext.getId();
    ImageRequest localImageRequest = paramProducerContext.getImageRequest();
    paramConsumer = new StatefulProducerRunnable(paramConsumer, localProducerListener, getProducerName(), str, localImageRequest, localProducerListener, str)
    {
      protected void disposeResult(EncodedImage paramEncodedImage)
      {
        EncodedImage.closeSafely(paramEncodedImage);
      }

      protected EncodedImage getResult()
        throws Exception
      {
        EncodedImage localEncodedImage = LocalFetchProducer.this.getEncodedImage(this.val$imageRequest);
        if (localEncodedImage == null)
        {
          this.val$listener.onUltimateProducerReached(this.val$requestId, LocalFetchProducer.this.getProducerName(), false);
          return null;
        }
        localEncodedImage.parseMetaData();
        this.val$listener.onUltimateProducerReached(this.val$requestId, LocalFetchProducer.this.getProducerName(), true);
        return localEncodedImage;
      }
    };
    paramProducerContext.addCallbacks(new BaseProducerContextCallbacks(paramConsumer)
    {
      public void onCancellationRequested()
      {
        this.val$cancellableProducerRunnable.cancel();
      }
    });
    this.mExecutor.execute(paramConsumer);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.LocalFetchProducer
 * JD-Core Version:    0.6.0
 */
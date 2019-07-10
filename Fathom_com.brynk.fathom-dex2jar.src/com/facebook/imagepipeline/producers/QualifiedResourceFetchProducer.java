package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

public class QualifiedResourceFetchProducer extends LocalFetchProducer
{
  public static final String PRODUCER_NAME = "QualifiedResourceFetchProducer";
  private final ContentResolver mContentResolver;

  public QualifiedResourceFetchProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, ContentResolver paramContentResolver)
  {
    super(paramExecutor, paramPooledByteBufferFactory);
    this.mContentResolver = paramContentResolver;
  }

  protected EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException
  {
    paramImageRequest = paramImageRequest.getSourceUri();
    return getEncodedImage(this.mContentResolver.openInputStream(paramImageRequest), -1);
  }

  protected String getProducerName()
  {
    return "QualifiedResourceFetchProducer";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer
 * JD-Core Version:    0.6.0
 */
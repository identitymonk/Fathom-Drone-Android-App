package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

public class FetchState
{
  private final Consumer<EncodedImage> mConsumer;
  private final ProducerContext mContext;
  private long mLastIntermediateResultTimeMs;

  public FetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    this.mConsumer = paramConsumer;
    this.mContext = paramProducerContext;
    this.mLastIntermediateResultTimeMs = 0L;
  }

  public Consumer<EncodedImage> getConsumer()
  {
    return this.mConsumer;
  }

  public ProducerContext getContext()
  {
    return this.mContext;
  }

  public String getId()
  {
    return this.mContext.getId();
  }

  public long getLastIntermediateResultTimeMs()
  {
    return this.mLastIntermediateResultTimeMs;
  }

  public ProducerListener getListener()
  {
    return this.mContext.getListener();
  }

  public Uri getUri()
  {
    return this.mContext.getImageRequest().getSourceUri();
  }

  public void setLastIntermediateResultTimeMs(long paramLong)
  {
    this.mLastIntermediateResultTimeMs = paramLong;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.FetchState
 * JD-Core Version:    0.6.0
 */
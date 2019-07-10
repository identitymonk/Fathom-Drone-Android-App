package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class SettableProducerContext extends BaseProducerContext
{
  public SettableProducerContext(ImageRequest paramImageRequest, String paramString, ProducerListener paramProducerListener, Object paramObject, ImageRequest.RequestLevel paramRequestLevel, boolean paramBoolean1, boolean paramBoolean2, Priority paramPriority)
  {
    super(paramImageRequest, paramString, paramProducerListener, paramObject, paramRequestLevel, paramBoolean1, paramBoolean2, paramPriority);
  }

  public void setIsIntermediateResultExpected(boolean paramBoolean)
  {
    BaseProducerContext.callOnIsIntermediateResultExpectedChanged(setIsIntermediateResultExpectedNoCallbacks(paramBoolean));
  }

  public void setIsPrefetch(boolean paramBoolean)
  {
    BaseProducerContext.callOnIsPrefetchChanged(setIsPrefetchNoCallbacks(paramBoolean));
  }

  public void setPriority(Priority paramPriority)
  {
    BaseProducerContext.callOnPriorityChanged(setPriorityNoCallbacks(paramPriority));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.SettableProducerContext
 * JD-Core Version:    0.6.0
 */
package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;

public class BaseRequestListener
  implements RequestListener
{
  public void onProducerEvent(String paramString1, String paramString2, String paramString3)
  {
  }

  public void onProducerFinishWithCancellation(String paramString1, String paramString2, @Nullable Map<String, String> paramMap)
  {
  }

  public void onProducerFinishWithFailure(String paramString1, String paramString2, Throwable paramThrowable, @Nullable Map<String, String> paramMap)
  {
  }

  public void onProducerFinishWithSuccess(String paramString1, String paramString2, @Nullable Map<String, String> paramMap)
  {
  }

  public void onProducerStart(String paramString1, String paramString2)
  {
  }

  public void onRequestCancellation(String paramString)
  {
  }

  public void onRequestFailure(ImageRequest paramImageRequest, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
  }

  public void onRequestStart(ImageRequest paramImageRequest, Object paramObject, String paramString, boolean paramBoolean)
  {
  }

  public void onRequestSuccess(ImageRequest paramImageRequest, String paramString, boolean paramBoolean)
  {
  }

  public void onUltimateProducerReached(String paramString1, String paramString2, boolean paramBoolean)
  {
  }

  public boolean requiresExtraMap(String paramString)
  {
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.listener.BaseRequestListener
 * JD-Core Version:    0.6.0
 */
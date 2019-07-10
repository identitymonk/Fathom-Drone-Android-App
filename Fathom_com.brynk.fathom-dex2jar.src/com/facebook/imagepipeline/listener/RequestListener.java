package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;

public abstract interface RequestListener extends ProducerListener
{
  public abstract void onRequestCancellation(String paramString);

  public abstract void onRequestFailure(ImageRequest paramImageRequest, String paramString, Throwable paramThrowable, boolean paramBoolean);

  public abstract void onRequestStart(ImageRequest paramImageRequest, Object paramObject, String paramString, boolean paramBoolean);

  public abstract void onRequestSuccess(ImageRequest paramImageRequest, String paramString, boolean paramBoolean);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.listener.RequestListener
 * JD-Core Version:    0.6.0
 */
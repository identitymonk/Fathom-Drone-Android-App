package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;

public abstract interface ThumbnailProducer<T> extends Producer<T>
{
  public abstract boolean canProvideImageForSize(ResizeOptions paramResizeOptions);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.ThumbnailProducer
 * JD-Core Version:    0.6.0
 */
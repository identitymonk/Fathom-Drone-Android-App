package com.facebook.imagepipeline.animated.factory;

import android.graphics.Bitmap.Config;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;

public abstract interface AnimatedImageFactory
{
  public abstract CloseableImage decodeGif(EncodedImage paramEncodedImage, ImageDecodeOptions paramImageDecodeOptions, Bitmap.Config paramConfig);

  public abstract CloseableImage decodeWebP(EncodedImage paramEncodedImage, ImageDecodeOptions paramImageDecodeOptions, Bitmap.Config paramConfig);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.animated.factory.AnimatedImageFactory
 * JD-Core Version:    0.6.0
 */
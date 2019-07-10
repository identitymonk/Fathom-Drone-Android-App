package com.facebook.imagepipeline.common;

import android.graphics.Bitmap.Config;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import javax.annotation.Nullable;

public class ImageDecodeOptionsBuilder
{
  private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

  @Nullable
  private ImageDecoder mCustomImageDecoder;
  private boolean mDecodeAllFrames;
  private boolean mDecodePreviewFrame;
  private boolean mForceStaticImage;
  private int mMinDecodeIntervalMs = 100;
  private boolean mUseLastFrameForPreview;

  public ImageDecodeOptions build()
  {
    return new ImageDecodeOptions(this);
  }

  public Bitmap.Config getBitmapConfig()
  {
    return this.mBitmapConfig;
  }

  @Nullable
  public ImageDecoder getCustomImageDecoder()
  {
    return this.mCustomImageDecoder;
  }

  public boolean getDecodeAllFrames()
  {
    return this.mDecodeAllFrames;
  }

  public boolean getDecodePreviewFrame()
  {
    return this.mDecodePreviewFrame;
  }

  public boolean getForceStaticImage()
  {
    return this.mForceStaticImage;
  }

  public int getMinDecodeIntervalMs()
  {
    return this.mMinDecodeIntervalMs;
  }

  public boolean getUseLastFrameForPreview()
  {
    return this.mUseLastFrameForPreview;
  }

  public ImageDecodeOptionsBuilder setBitmapConfig(Bitmap.Config paramConfig)
  {
    this.mBitmapConfig = paramConfig;
    return this;
  }

  public ImageDecodeOptionsBuilder setCustomImageDecoder(@Nullable ImageDecoder paramImageDecoder)
  {
    this.mCustomImageDecoder = paramImageDecoder;
    return this;
  }

  public ImageDecodeOptionsBuilder setDecodeAllFrames(boolean paramBoolean)
  {
    this.mDecodeAllFrames = paramBoolean;
    return this;
  }

  public ImageDecodeOptionsBuilder setDecodePreviewFrame(boolean paramBoolean)
  {
    this.mDecodePreviewFrame = paramBoolean;
    return this;
  }

  public ImageDecodeOptionsBuilder setForceStaticImage(boolean paramBoolean)
  {
    this.mForceStaticImage = paramBoolean;
    return this;
  }

  public ImageDecodeOptionsBuilder setFrom(ImageDecodeOptions paramImageDecodeOptions)
  {
    this.mDecodePreviewFrame = paramImageDecodeOptions.decodePreviewFrame;
    this.mUseLastFrameForPreview = paramImageDecodeOptions.useLastFrameForPreview;
    this.mDecodeAllFrames = paramImageDecodeOptions.decodeAllFrames;
    this.mForceStaticImage = paramImageDecodeOptions.forceStaticImage;
    this.mBitmapConfig = paramImageDecodeOptions.bitmapConfig;
    return this;
  }

  public ImageDecodeOptionsBuilder setMinDecodeIntervalMs(int paramInt)
  {
    this.mMinDecodeIntervalMs = paramInt;
    return this;
  }

  public ImageDecodeOptionsBuilder setUseLastFrameForPreview(boolean paramBoolean)
  {
    this.mUseLastFrameForPreview = paramBoolean;
    return this;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder
 * JD-Core Version:    0.6.0
 */
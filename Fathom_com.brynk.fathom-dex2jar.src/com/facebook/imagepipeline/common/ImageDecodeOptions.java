package com.facebook.imagepipeline.common;

import android.graphics.Bitmap.Config;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class ImageDecodeOptions
{
  private static final ImageDecodeOptions DEFAULTS = newBuilder().build();
  public final Bitmap.Config bitmapConfig;

  @Nullable
  public final ImageDecoder customImageDecoder;
  public final boolean decodeAllFrames;
  public final boolean decodePreviewFrame;
  public final boolean forceStaticImage;
  public final int minDecodeIntervalMs;
  public final boolean useLastFrameForPreview;

  public ImageDecodeOptions(ImageDecodeOptionsBuilder paramImageDecodeOptionsBuilder)
  {
    this.minDecodeIntervalMs = paramImageDecodeOptionsBuilder.getMinDecodeIntervalMs();
    this.decodePreviewFrame = paramImageDecodeOptionsBuilder.getDecodePreviewFrame();
    this.useLastFrameForPreview = paramImageDecodeOptionsBuilder.getUseLastFrameForPreview();
    this.decodeAllFrames = paramImageDecodeOptionsBuilder.getDecodeAllFrames();
    this.forceStaticImage = paramImageDecodeOptionsBuilder.getForceStaticImage();
    this.bitmapConfig = paramImageDecodeOptionsBuilder.getBitmapConfig();
    this.customImageDecoder = paramImageDecodeOptionsBuilder.getCustomImageDecoder();
  }

  public static ImageDecodeOptions defaults()
  {
    return DEFAULTS;
  }

  public static ImageDecodeOptionsBuilder newBuilder()
  {
    return new ImageDecodeOptionsBuilder();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      paramObject = (ImageDecodeOptions)paramObject;
      if (this.decodePreviewFrame != paramObject.decodePreviewFrame)
        return false;
      if (this.useLastFrameForPreview != paramObject.useLastFrameForPreview)
        return false;
      if (this.decodeAllFrames != paramObject.decodeAllFrames)
        return false;
      if (this.forceStaticImage != paramObject.forceStaticImage)
        return false;
      if (this.bitmapConfig != paramObject.bitmapConfig)
        return false;
    }
    while (this.customImageDecoder == paramObject.customImageDecoder);
    return false;
  }

  public int hashCode()
  {
    int m = 1;
    int n = 0;
    int i1 = this.minDecodeIntervalMs;
    int i;
    int j;
    label30: int k;
    if (this.decodePreviewFrame)
    {
      i = 1;
      if (!this.useLastFrameForPreview)
        break label112;
      j = 1;
      if (!this.decodeAllFrames)
        break label117;
      k = 1;
      label39: if (!this.forceStaticImage)
        break label122;
    }
    while (true)
    {
      int i2 = this.bitmapConfig.ordinal();
      if (this.customImageDecoder != null)
        n = this.customImageDecoder.hashCode();
      return (((((i1 * 31 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + i2) * 31 + n;
      i = 0;
      break;
      label112: j = 0;
      break label30;
      label117: k = 0;
      break label39;
      label122: m = 0;
    }
  }

  public String toString()
  {
    return String.format((Locale)null, "%d-%b-%b-%b-%b-%s-%s", new Object[] { Integer.valueOf(this.minDecodeIntervalMs), Boolean.valueOf(this.decodePreviewFrame), Boolean.valueOf(this.useLastFrameForPreview), Boolean.valueOf(this.decodeAllFrames), Boolean.valueOf(this.forceStaticImage), this.bitmapConfig.name(), this.customImageDecoder });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.common.ImageDecodeOptions
 * JD-Core Version:    0.6.0
 */
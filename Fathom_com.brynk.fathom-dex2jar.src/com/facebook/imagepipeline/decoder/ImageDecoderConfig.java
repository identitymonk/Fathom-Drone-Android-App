package com.facebook.imagepipeline.decoder;

import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormat.FormatChecker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageDecoderConfig
{
  private final Map<ImageFormat, ImageDecoder> mCustomImageDecoders;
  private final List<ImageFormat.FormatChecker> mCustomImageFormats;

  private ImageDecoderConfig(Builder paramBuilder)
  {
    this.mCustomImageDecoders = paramBuilder.mCustomImageDecoders;
    this.mCustomImageFormats = paramBuilder.mCustomImageFormats;
  }

  public static Builder newBuilder()
  {
    return new Builder();
  }

  public Map<ImageFormat, ImageDecoder> getCustomImageDecoders()
  {
    return this.mCustomImageDecoders;
  }

  public List<ImageFormat.FormatChecker> getCustomImageFormats()
  {
    return this.mCustomImageFormats;
  }

  public static class Builder
  {
    private Map<ImageFormat, ImageDecoder> mCustomImageDecoders;
    private List<ImageFormat.FormatChecker> mCustomImageFormats;

    public Builder addDecodingCapability(ImageFormat paramImageFormat, ImageFormat.FormatChecker paramFormatChecker, ImageDecoder paramImageDecoder)
    {
      if (this.mCustomImageFormats == null)
        this.mCustomImageFormats = new ArrayList();
      this.mCustomImageFormats.add(paramFormatChecker);
      overrideDecoder(paramImageFormat, paramImageDecoder);
      return this;
    }

    public ImageDecoderConfig build()
    {
      return new ImageDecoderConfig(this, null);
    }

    public Builder overrideDecoder(ImageFormat paramImageFormat, ImageDecoder paramImageDecoder)
    {
      if (this.mCustomImageDecoders == null)
        this.mCustomImageDecoders = new HashMap();
      this.mCustomImageDecoders.put(paramImageFormat, paramImageDecoder);
      return this;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.decoder.ImageDecoderConfig
 * JD-Core Version:    0.6.0
 */
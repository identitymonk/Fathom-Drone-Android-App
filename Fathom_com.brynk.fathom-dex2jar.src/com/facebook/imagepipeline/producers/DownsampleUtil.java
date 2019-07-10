package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

public class DownsampleUtil
{
  private static final int DEFAULT_SAMPLE_SIZE = 1;
  private static final float INTERVAL_ROUNDING = 0.3333333F;

  @VisibleForTesting
  static float determineDownsampleRatio(ImageRequest paramImageRequest, EncodedImage paramEncodedImage)
  {
    Preconditions.checkArgument(EncodedImage.isMetaDataAvailable(paramEncodedImage));
    ResizeOptions localResizeOptions = paramImageRequest.getResizeOptions();
    if ((localResizeOptions == null) || (localResizeOptions.height <= 0) || (localResizeOptions.width <= 0) || (paramEncodedImage.getWidth() == 0) || (paramEncodedImage.getHeight() == 0))
      return 1.0F;
    int i = getRotationAngle(paramImageRequest, paramEncodedImage);
    if ((i == 90) || (i == 270))
    {
      j = 1;
      if (j == 0)
        break label219;
      i = paramEncodedImage.getHeight();
      label86: if (j == 0)
        break label228;
    }
    label219: label228: for (int j = paramEncodedImage.getWidth(); ; j = paramEncodedImage.getHeight())
    {
      float f1 = localResizeOptions.width / i;
      float f2 = localResizeOptions.height / j;
      float f3 = Math.max(f1, f2);
      FLog.v("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", new Object[] { Integer.valueOf(localResizeOptions.width), Integer.valueOf(localResizeOptions.height), Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), paramImageRequest.getSourceUri().toString() });
      return f3;
      j = 0;
      break;
      i = paramEncodedImage.getWidth();
      break label86;
    }
  }

  public static int determineSampleSize(ImageRequest paramImageRequest, EncodedImage paramEncodedImage)
  {
    int j;
    if (!EncodedImage.isMetaDataAvailable(paramEncodedImage))
    {
      j = 1;
      return j;
    }
    float f = determineDownsampleRatio(paramImageRequest, paramEncodedImage);
    int i;
    label34: int k;
    if (paramEncodedImage.getImageFormat() == DefaultImageFormats.JPEG)
    {
      i = ratioToSampleSizeJPEG(f);
      k = Math.max(paramEncodedImage.getHeight(), paramEncodedImage.getWidth());
      paramImageRequest = paramImageRequest.getResizeOptions();
      if (paramImageRequest == null)
        break label99;
      f = paramImageRequest.maxBitmapSize;
    }
    while (true)
    {
      j = i;
      if (k / i <= f)
        break;
      if (paramEncodedImage.getImageFormat() == DefaultImageFormats.JPEG)
      {
        i *= 2;
        continue;
        i = ratioToSampleSize(f);
        break label34;
        label99: f = 2048.0F;
        continue;
      }
      i += 1;
    }
  }

  private static int getRotationAngle(ImageRequest paramImageRequest, EncodedImage paramEncodedImage)
  {
    boolean bool = false;
    if (!paramImageRequest.getRotationOptions().useImageMetadata())
      return 0;
    int i = paramEncodedImage.getRotationAngle();
    if ((i == 0) || (i == 90) || (i == 180) || (i == 270))
      bool = true;
    Preconditions.checkArgument(bool);
    return i;
  }

  @VisibleForTesting
  static int ratioToSampleSize(float paramFloat)
  {
    if (paramFloat > 0.6666667F)
      return 1;
    int i = 2;
    while (true)
    {
      double d = 1.0D / (Math.pow(i, 2.0D) - i);
      if (1.0D / i + 0.333333343267441D * d <= paramFloat)
        return i - 1;
      int j;
      i += 1;
    }
  }

  @VisibleForTesting
  static int ratioToSampleSizeJPEG(float paramFloat)
  {
    int j;
    if (paramFloat > 0.6666667F)
    {
      j = 1;
      return j;
    }
    int i = 2;
    while (true)
    {
      double d = 1.0D / (i * 2);
      j = i;
      if (1.0D / (i * 2) + 0.333333343267441D * d <= paramFloat)
        break;
      i *= 2;
    }
  }

  @VisibleForTesting
  static int roundToPowerOfTwo(int paramInt)
  {
    int i = 1;
    while (true)
    {
      if (i >= paramInt)
        return i;
      i *= 2;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.DownsampleUtil
 * JD-Core Version:    0.6.0
 */
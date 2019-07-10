package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(11)
@ThreadSafe
public class HoneycombBitmapFactory extends PlatformBitmapFactory
{
  private final EmptyJpegGenerator mJpegGenerator;
  private final PlatformDecoder mPurgeableDecoder;

  public HoneycombBitmapFactory(EmptyJpegGenerator paramEmptyJpegGenerator, PlatformDecoder paramPlatformDecoder)
  {
    this.mJpegGenerator = paramEmptyJpegGenerator;
    this.mPurgeableDecoder = paramPlatformDecoder;
  }

  @TargetApi(12)
  public CloseableReference<Bitmap> createBitmapInternal(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    CloseableReference localCloseableReference = this.mJpegGenerator.generate((short)paramInt1, (short)paramInt2);
    try
    {
      EncodedImage localEncodedImage = new EncodedImage(localCloseableReference);
      localEncodedImage.setImageFormat(DefaultImageFormats.JPEG);
      try
      {
        paramConfig = this.mPurgeableDecoder.decodeJPEGFromEncodedImage(localEncodedImage, paramConfig, ((PooledByteBuffer)localCloseableReference.get()).size());
        ((Bitmap)paramConfig.get()).setHasAlpha(true);
        ((Bitmap)paramConfig.get()).eraseColor(0);
        EncodedImage.closeSafely(localEncodedImage);
        localCloseableReference.close();
        return paramConfig;
      }
      finally
      {
        EncodedImage.closeSafely(localEncodedImage);
      }
    }
    finally
    {
      localCloseableReference.close();
    }
    throw paramConfig;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.bitmaps.HoneycombBitmapFactory
 * JD-Core Version:    0.6.0
 */
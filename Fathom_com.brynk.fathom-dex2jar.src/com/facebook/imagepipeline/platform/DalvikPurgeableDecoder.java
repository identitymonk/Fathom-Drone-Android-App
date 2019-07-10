package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapCounter;
import com.facebook.imagepipeline.memory.BitmapCounterProvider;
import com.facebook.imagepipeline.nativecode.Bitmaps;

abstract class DalvikPurgeableDecoder
  implements PlatformDecoder
{
  protected static final byte[] EOI = { -1, -39 };
  private final BitmapCounter mUnpooledBitmapsCounter = BitmapCounterProvider.get();

  protected static boolean endsWithEOI(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt)
  {
    paramCloseableReference = (PooledByteBuffer)paramCloseableReference.get();
    return (paramInt >= 2) && (paramCloseableReference.read(paramInt - 2) == -1) && (paramCloseableReference.read(paramInt - 1) == -39);
  }

  private static BitmapFactory.Options getBitmapFactoryOptions(int paramInt, Bitmap.Config paramConfig)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDither = true;
    localOptions.inPreferredConfig = paramConfig;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    localOptions.inSampleSize = paramInt;
    if (Build.VERSION.SDK_INT >= 11)
      localOptions.inMutable = true;
    return localOptions;
  }

  abstract Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, BitmapFactory.Options paramOptions);

  public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig)
  {
    paramConfig = getBitmapFactoryOptions(paramEncodedImage.getSampleSize(), paramConfig);
    paramEncodedImage = paramEncodedImage.getByteBufferRef();
    Preconditions.checkNotNull(paramEncodedImage);
    try
    {
      paramConfig = pinBitmap(decodeByteArrayAsPurgeable(paramEncodedImage, paramConfig));
      return paramConfig;
    }
    finally
    {
      CloseableReference.closeSafely(paramEncodedImage);
    }
    throw paramConfig;
  }

  abstract Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, BitmapFactory.Options paramOptions);

  public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, int paramInt)
  {
    paramConfig = getBitmapFactoryOptions(paramEncodedImage.getSampleSize(), paramConfig);
    paramEncodedImage = paramEncodedImage.getByteBufferRef();
    Preconditions.checkNotNull(paramEncodedImage);
    try
    {
      paramConfig = pinBitmap(decodeJPEGByteArrayAsPurgeable(paramEncodedImage, paramInt, paramConfig));
      return paramConfig;
    }
    finally
    {
      CloseableReference.closeSafely(paramEncodedImage);
    }
    throw paramConfig;
  }

  public CloseableReference<Bitmap> pinBitmap(Bitmap paramBitmap)
  {
    try
    {
      Bitmaps.pinBitmap(paramBitmap);
      if (!this.mUnpooledBitmapsCounter.increase(paramBitmap))
      {
        paramBitmap.recycle();
        throw new TooManyBitmapsException();
      }
    }
    catch (Exception localException)
    {
      paramBitmap.recycle();
      throw Throwables.propagate(localException);
    }
    return CloseableReference.of(paramBitmap, this.mUnpooledBitmapsCounter.getReleaser());
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.platform.DalvikPurgeableDecoder
 * JD-Core Version:    0.6.0
 */
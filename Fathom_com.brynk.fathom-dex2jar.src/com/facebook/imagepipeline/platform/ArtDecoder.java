package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
public class ArtDecoder
  implements PlatformDecoder
{
  private static final int DECODE_BUFFER_SIZE = 16384;
  private static final byte[] EOI_TAIL = { -1, -39 };
  private final BitmapPool mBitmapPool;

  @VisibleForTesting
  final Pools.SynchronizedPool<ByteBuffer> mDecodeBuffers;

  public ArtDecoder(BitmapPool paramBitmapPool, int paramInt, Pools.SynchronizedPool paramSynchronizedPool)
  {
    this.mBitmapPool = paramBitmapPool;
    this.mDecodeBuffers = paramSynchronizedPool;
    int i = 0;
    while (i < paramInt)
    {
      this.mDecodeBuffers.release(ByteBuffer.allocate(16384));
      i += 1;
    }
  }

  private static BitmapFactory.Options getDecodeOptionsForStream(EncodedImage paramEncodedImage, Bitmap.Config paramConfig)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = paramEncodedImage.getSampleSize();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramEncodedImage.getInputStream(), null, localOptions);
    if ((localOptions.outWidth == -1) || (localOptions.outHeight == -1))
      throw new IllegalArgumentException();
    localOptions.inJustDecodeBounds = false;
    localOptions.inDither = true;
    localOptions.inPreferredConfig = paramConfig;
    localOptions.inMutable = true;
    return localOptions;
  }

  public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig)
  {
    paramConfig = getDecodeOptionsForStream(paramEncodedImage, paramConfig);
    int i;
    if (paramConfig.inPreferredConfig != Bitmap.Config.ARGB_8888)
      i = 1;
    try
    {
      while (true)
      {
        paramConfig = decodeStaticImageFromStream(paramEncodedImage.getInputStream(), paramConfig);
        return paramConfig;
        i = 0;
      }
    }
    catch (java.lang.RuntimeException paramConfig)
    {
      if (i != 0)
        return decodeFromEncodedImage(paramEncodedImage, Bitmap.Config.ARGB_8888);
    }
    throw paramConfig;
  }

  public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, int paramInt)
  {
    boolean bool = paramEncodedImage.isCompleteAt(paramInt);
    BitmapFactory.Options localOptions = getDecodeOptionsForStream(paramEncodedImage, paramConfig);
    paramConfig = paramEncodedImage.getInputStream();
    Preconditions.checkNotNull(paramConfig);
    if (paramEncodedImage.getSize() > paramInt)
      paramConfig = new LimitedInputStream(paramConfig, paramInt);
    while (true)
    {
      if (!bool)
        paramConfig = new TailAppendingInputStream(paramConfig, EOI_TAIL);
      while (true)
      {
        if (localOptions.inPreferredConfig != Bitmap.Config.ARGB_8888)
          paramInt = 1;
        try
        {
          while (true)
          {
            paramConfig = decodeStaticImageFromStream(paramConfig, localOptions);
            return paramConfig;
            paramInt = 0;
          }
        }
        catch (java.lang.RuntimeException paramConfig)
        {
          if (paramInt != 0)
            return decodeFromEncodedImage(paramEncodedImage, Bitmap.Config.ARGB_8888);
          throw paramConfig;
        }
      }
    }
  }

  protected CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream paramInputStream, BitmapFactory.Options paramOptions)
  {
    Preconditions.checkNotNull(paramInputStream);
    int i = BitmapUtil.getSizeInByteForBitmap(paramOptions.outWidth, paramOptions.outHeight, paramOptions.inPreferredConfig);
    Bitmap localBitmap = (Bitmap)this.mBitmapPool.get(i);
    if (localBitmap == null)
      throw new NullPointerException("BitmapPool.get returned null");
    paramOptions.inBitmap = localBitmap;
    ByteBuffer localByteBuffer2 = (ByteBuffer)this.mDecodeBuffers.acquire();
    ByteBuffer localByteBuffer1 = localByteBuffer2;
    if (localByteBuffer2 == null)
      localByteBuffer1 = ByteBuffer.allocate(16384);
    try
    {
      paramOptions.inTempStorage = localByteBuffer1.array();
      paramInputStream = BitmapFactory.decodeStream(paramInputStream, null, paramOptions);
      this.mDecodeBuffers.release(localByteBuffer1);
      if (localBitmap != paramInputStream)
      {
        this.mBitmapPool.release(localBitmap);
        paramInputStream.recycle();
        throw new IllegalStateException();
      }
    }
    catch (java.lang.RuntimeException paramInputStream)
    {
      this.mBitmapPool.release(localBitmap);
      throw paramInputStream;
    }
    finally
    {
      this.mDecodeBuffers.release(localByteBuffer1);
    }
    return CloseableReference.of(paramInputStream, this.mBitmapPool);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.platform.ArtDecoder
 * JD-Core Version:    0.6.0
 */
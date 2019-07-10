package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(19)
@ThreadSafe
public class KitKatPurgeableDecoder extends DalvikPurgeableDecoder
{
  private final FlexByteArrayPool mFlexByteArrayPool;

  public KitKatPurgeableDecoder(FlexByteArrayPool paramFlexByteArrayPool)
  {
    this.mFlexByteArrayPool = paramFlexByteArrayPool;
  }

  private static void putEOI(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = -1;
    paramArrayOfByte[(paramInt + 1)] = -39;
  }

  protected Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, BitmapFactory.Options paramOptions)
  {
    PooledByteBuffer localPooledByteBuffer = (PooledByteBuffer)paramCloseableReference.get();
    int i = localPooledByteBuffer.size();
    paramCloseableReference = this.mFlexByteArrayPool.get(i);
    try
    {
      byte[] arrayOfByte = (byte[])paramCloseableReference.get();
      localPooledByteBuffer.read(0, arrayOfByte, 0, i);
      paramOptions = (Bitmap)Preconditions.checkNotNull(BitmapFactory.decodeByteArray(arrayOfByte, 0, i, paramOptions), "BitmapFactory returned null");
      return paramOptions;
    }
    finally
    {
      CloseableReference.closeSafely(paramCloseableReference);
    }
    throw paramOptions;
  }

  protected Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, BitmapFactory.Options paramOptions)
  {
    boolean bool = false;
    byte[] arrayOfByte1;
    if (endsWithEOI(paramCloseableReference, paramInt))
      arrayOfByte1 = null;
    while (true)
    {
      PooledByteBuffer localPooledByteBuffer = (PooledByteBuffer)paramCloseableReference.get();
      if (paramInt <= localPooledByteBuffer.size())
        bool = true;
      Preconditions.checkArgument(bool);
      paramCloseableReference = this.mFlexByteArrayPool.get(paramInt + 2);
      try
      {
        byte[] arrayOfByte2 = (byte[])paramCloseableReference.get();
        localPooledByteBuffer.read(0, arrayOfByte2, 0, paramInt);
        int i = paramInt;
        if (arrayOfByte1 != null)
        {
          putEOI(arrayOfByte2, paramInt);
          i = paramInt + 2;
        }
        paramOptions = (Bitmap)Preconditions.checkNotNull(BitmapFactory.decodeByteArray(arrayOfByte2, 0, i, paramOptions), "BitmapFactory returned null");
        return paramOptions;
        arrayOfByte1 = EOI;
        continue;
      }
      finally
      {
        CloseableReference.closeSafely(paramCloseableReference);
      }
    }
    throw paramOptions;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.platform.KitKatPurgeableDecoder
 * JD-Core Version:    0.6.0
 */
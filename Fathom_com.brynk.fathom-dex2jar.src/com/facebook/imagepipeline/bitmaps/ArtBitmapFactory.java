package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
public class ArtBitmapFactory extends PlatformBitmapFactory
{
  private final BitmapPool mBitmapPool;

  public ArtBitmapFactory(BitmapPool paramBitmapPool)
  {
    this.mBitmapPool = paramBitmapPool;
  }

  public CloseableReference<Bitmap> createBitmapInternal(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    int i = BitmapUtil.getSizeInByteForBitmap(paramInt1, paramInt2, paramConfig);
    Bitmap localBitmap = (Bitmap)this.mBitmapPool.get(i);
    Bitmaps.reconfigureBitmap(localBitmap, paramInt1, paramInt2, paramConfig);
    return CloseableReference.of(localBitmap, this.mBitmapPool);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.bitmaps.ArtBitmapFactory
 * JD-Core Version:    0.6.0
 */
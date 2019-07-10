package com.facebook.imagepipeline.nativecode;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.imageutils.BitmapUtil;
import java.nio.ByteBuffer;

@DoNotStrip
public class Bitmaps
{
  static
  {
    ImagePipelineNativeLoader.load();
  }

  public static void copyBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    boolean bool2 = true;
    if (paramBitmap2.getConfig() == paramBitmap1.getConfig())
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      Preconditions.checkArgument(paramBitmap1.isMutable());
      if (paramBitmap1.getWidth() != paramBitmap2.getWidth())
        break label83;
      bool1 = true;
      label39: Preconditions.checkArgument(bool1);
      if (paramBitmap1.getHeight() != paramBitmap2.getHeight())
        break label88;
    }
    label83: label88: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      nativeCopyBitmap(paramBitmap1, paramBitmap1.getRowBytes(), paramBitmap2, paramBitmap2.getRowBytes(), paramBitmap1.getHeight());
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label39;
    }
  }

  public static ByteBuffer getByteBuffer(Bitmap paramBitmap, long paramLong1, long paramLong2)
  {
    Preconditions.checkNotNull(paramBitmap);
    return nativeGetByteBuffer(paramBitmap, paramLong1, paramLong2);
  }

  @DoNotStrip
  private static native void nativeCopyBitmap(Bitmap paramBitmap1, int paramInt1, Bitmap paramBitmap2, int paramInt2, int paramInt3);

  @DoNotStrip
  private static native ByteBuffer nativeGetByteBuffer(Bitmap paramBitmap, long paramLong1, long paramLong2);

  @DoNotStrip
  private static native void nativePinBitmap(Bitmap paramBitmap);

  @DoNotStrip
  private static native void nativeReleaseByteBuffer(Bitmap paramBitmap);

  public static void pinBitmap(Bitmap paramBitmap)
  {
    Preconditions.checkNotNull(paramBitmap);
    nativePinBitmap(paramBitmap);
  }

  @TargetApi(19)
  public static void reconfigureBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    if (paramBitmap.getAllocationByteCount() >= paramInt1 * paramInt2 * BitmapUtil.getPixelSizeForBitmapConfig(paramConfig));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      paramBitmap.reconfigure(paramInt1, paramInt2, paramConfig);
      return;
    }
  }

  public static void releaseByteBuffer(Bitmap paramBitmap)
  {
    Preconditions.checkNotNull(paramBitmap);
    nativeReleaseByteBuffer(paramBitmap);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.nativecode.Bitmaps
 * JD-Core Version:    0.6.0
 */
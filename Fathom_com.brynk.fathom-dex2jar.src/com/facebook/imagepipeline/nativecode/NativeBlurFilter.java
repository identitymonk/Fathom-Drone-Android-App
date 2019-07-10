package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;

@DoNotStrip
public class NativeBlurFilter
{
  static
  {
    ImagePipelineNativeLoader.load();
  }

  public static void iterativeBoxBlur(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    Preconditions.checkNotNull(paramBitmap);
    if (paramInt1 > 0)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if (paramInt2 <= 0)
        break label41;
    }
    label41: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      nativeIterativeBoxBlur(paramBitmap, paramInt1, paramInt2);
      return;
      bool1 = false;
      break;
    }
  }

  @DoNotStrip
  private static native void nativeIterativeBoxBlur(Bitmap paramBitmap, int paramInt1, int paramInt2);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.nativecode.NativeBlurFilter
 * JD-Core Version:    0.6.0
 */
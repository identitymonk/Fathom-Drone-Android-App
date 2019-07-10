package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.PoolFactory;

public class HoneycombBitmapCreator
  implements BitmapCreator
{
  private final FlexByteArrayPool mFlexByteArrayPool;
  private final EmptyJpegGenerator mJpegGenerator;

  public HoneycombBitmapCreator(PoolFactory paramPoolFactory)
  {
    this.mFlexByteArrayPool = paramPoolFactory.getFlexByteArrayPool();
    this.mJpegGenerator = new EmptyJpegGenerator(paramPoolFactory.getPooledByteBufferFactory());
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

  // ERROR //
  @android.annotation.TargetApi(12)
  public android.graphics.Bitmap createNakedBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator:mJpegGenerator	Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;
    //   4: iload_1
    //   5: i2s
    //   6: iload_2
    //   7: i2s
    //   8: invokevirtual 75	com/facebook/imagepipeline/bitmaps/EmptyJpegGenerator:generate	(SS)Lcom/facebook/common/references/CloseableReference;
    //   11: astore 8
    //   13: aconst_null
    //   14: astore 7
    //   16: aconst_null
    //   17: astore 6
    //   19: aconst_null
    //   20: astore 4
    //   22: new 77	com/facebook/imagepipeline/image/EncodedImage
    //   25: dup
    //   26: aload 8
    //   28: invokespecial 80	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
    //   31: astore 5
    //   33: aload 6
    //   35: astore 4
    //   37: aload 5
    //   39: getstatic 86	com/facebook/imageformat/DefaultImageFormats:JPEG	Lcom/facebook/imageformat/ImageFormat;
    //   42: invokevirtual 90	com/facebook/imagepipeline/image/EncodedImage:setImageFormat	(Lcom/facebook/imageformat/ImageFormat;)V
    //   45: aload 6
    //   47: astore 4
    //   49: aload 5
    //   51: invokevirtual 94	com/facebook/imagepipeline/image/EncodedImage:getSampleSize	()I
    //   54: aload_3
    //   55: invokestatic 96	com/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator:getBitmapFactoryOptions	(ILandroid/graphics/Bitmap$Config;)Landroid/graphics/BitmapFactory$Options;
    //   58: astore 7
    //   60: aload 6
    //   62: astore 4
    //   64: aload 8
    //   66: invokevirtual 102	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   69: checkcast 104	com/facebook/common/memory/PooledByteBuffer
    //   72: invokeinterface 107 1 0
    //   77: istore_1
    //   78: aload 6
    //   80: astore 4
    //   82: aload 8
    //   84: invokevirtual 102	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   87: checkcast 104	com/facebook/common/memory/PooledByteBuffer
    //   90: astore 9
    //   92: aload 6
    //   94: astore 4
    //   96: aload_0
    //   97: getfield 23	com/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator:mFlexByteArrayPool	Lcom/facebook/imagepipeline/memory/FlexByteArrayPool;
    //   100: iload_1
    //   101: iconst_2
    //   102: iadd
    //   103: invokevirtual 112	com/facebook/imagepipeline/memory/FlexByteArrayPool:get	(I)Lcom/facebook/common/references/CloseableReference;
    //   106: astore_3
    //   107: aload_3
    //   108: astore 4
    //   110: aload_3
    //   111: invokevirtual 102	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   114: checkcast 114	[B
    //   117: astore 6
    //   119: aload_3
    //   120: astore 4
    //   122: aload 9
    //   124: iconst_0
    //   125: aload 6
    //   127: iconst_0
    //   128: iload_1
    //   129: invokeinterface 118 5 0
    //   134: aload_3
    //   135: astore 4
    //   137: aload 6
    //   139: iconst_0
    //   140: iload_1
    //   141: aload 7
    //   143: invokestatic 124	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   146: astore 6
    //   148: aload_3
    //   149: astore 4
    //   151: aload 6
    //   153: iconst_1
    //   154: invokevirtual 130	android/graphics/Bitmap:setHasAlpha	(Z)V
    //   157: aload_3
    //   158: astore 4
    //   160: aload 6
    //   162: iconst_0
    //   163: invokevirtual 134	android/graphics/Bitmap:eraseColor	(I)V
    //   166: aload_3
    //   167: invokestatic 137	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   170: aload 5
    //   172: invokestatic 140	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   175: aload 8
    //   177: invokestatic 137	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   180: aload 6
    //   182: areturn
    //   183: astore 5
    //   185: aload 7
    //   187: astore_3
    //   188: aload 4
    //   190: invokestatic 137	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   193: aload_3
    //   194: invokestatic 140	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   197: aload 8
    //   199: invokestatic 137	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   202: aload 5
    //   204: athrow
    //   205: astore 6
    //   207: aload 5
    //   209: astore_3
    //   210: aload 6
    //   212: astore 5
    //   214: goto -26 -> 188
    //
    // Exception table:
    //   from	to	target	type
    //   22	33	183	finally
    //   37	45	205	finally
    //   49	60	205	finally
    //   64	78	205	finally
    //   82	92	205	finally
    //   96	107	205	finally
    //   110	119	205	finally
    //   122	134	205	finally
    //   137	148	205	finally
    //   151	157	205	finally
    //   160	166	205	finally
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.bitmaps.HoneycombBitmapCreator
 * JD-Core Version:    0.6.0
 */
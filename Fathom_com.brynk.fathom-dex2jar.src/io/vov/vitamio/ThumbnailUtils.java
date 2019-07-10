package io.vov.vitamio;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;

public class ThumbnailUtils
{
  private static final int OPTIONS_NONE = 0;
  public static final int OPTIONS_RECYCLE_INPUT = 2;
  private static final int OPTIONS_SCALE_UP = 1;
  public static final int TARGET_SIZE_MICRO_THUMBNAIL_HEIGHT = 160;
  public static final int TARGET_SIZE_MICRO_THUMBNAIL_WIDTH = 212;
  public static final int TARGET_SIZE_MINI_THUMBNAIL_HEIGHT = 320;
  public static final int TARGET_SIZE_MINI_THUMBNAIL_WIDTH = 426;

  // ERROR //
  public static Bitmap createVideoThumbnail(android.content.Context paramContext, java.lang.String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 36	io/vov/vitamio/Vitamio:isInitialized	(Landroid/content/Context;)Z
    //   4: ifne +7 -> 11
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_1
    //   10: areturn
    //   11: aconst_null
    //   12: astore_3
    //   13: aconst_null
    //   14: astore 4
    //   16: aconst_null
    //   17: astore 5
    //   19: new 38	io/vov/vitamio/MediaMetadataRetriever
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 41	io/vov/vitamio/MediaMetadataRetriever:<init>	(Landroid/content/Context;)V
    //   27: astore_0
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 45	io/vov/vitamio/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: ldc2_w 46
    //   37: invokevirtual 51	io/vov/vitamio/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   40: astore_1
    //   41: aload_0
    //   42: invokevirtual 54	io/vov/vitamio/MediaMetadataRetriever:release	()V
    //   45: aload_1
    //   46: astore_0
    //   47: aload_0
    //   48: astore_1
    //   49: aload_0
    //   50: ifnull -41 -> 9
    //   53: iload_2
    //   54: iconst_3
    //   55: if_icmpne +50 -> 105
    //   58: aload_0
    //   59: sipush 212
    //   62: sipush 160
    //   65: iconst_2
    //   66: invokestatic 58	io/vov/vitamio/ThumbnailUtils:extractThumbnail	(Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;
    //   69: areturn
    //   70: astore_0
    //   71: aload_1
    //   72: astore_0
    //   73: goto -26 -> 47
    //   76: astore_0
    //   77: aload 5
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 54	io/vov/vitamio/MediaMetadataRetriever:release	()V
    //   84: aload_3
    //   85: astore_0
    //   86: goto -39 -> 47
    //   89: astore_0
    //   90: aload_3
    //   91: astore_0
    //   92: goto -45 -> 47
    //   95: astore_0
    //   96: aload 4
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 54	io/vov/vitamio/MediaMetadataRetriever:release	()V
    //   103: aload_0
    //   104: athrow
    //   105: aload_0
    //   106: astore_1
    //   107: iload_2
    //   108: iconst_1
    //   109: if_icmpne -100 -> 9
    //   112: aload_0
    //   113: sipush 426
    //   116: sipush 320
    //   119: iconst_2
    //   120: invokestatic 58	io/vov/vitamio/ThumbnailUtils:extractThumbnail	(Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;
    //   123: areturn
    //   124: astore_1
    //   125: goto -22 -> 103
    //   128: astore_3
    //   129: aload_0
    //   130: astore_1
    //   131: aload_3
    //   132: astore_0
    //   133: goto -34 -> 99
    //   136: astore_1
    //   137: goto -57 -> 80
    //
    // Exception table:
    //   from	to	target	type
    //   41	45	70	java/lang/RuntimeException
    //   19	28	76	java/lang/Exception
    //   80	84	89	java/lang/RuntimeException
    //   19	28	95	finally
    //   99	103	124	java/lang/RuntimeException
    //   28	41	128	finally
    //   28	41	136	java/lang/Exception
  }

  public static Bitmap extractThumbnail(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    return extractThumbnail(paramBitmap, paramInt1, paramInt2, 0);
  }

  public static Bitmap extractThumbnail(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBitmap == null)
      return null;
    float f;
    if (paramBitmap.getWidth() < paramBitmap.getHeight())
      f = paramInt1 / paramBitmap.getWidth();
    while (true)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(f, f);
      return transform(localMatrix, paramBitmap, paramInt1, paramInt2, paramInt3 | 0x1);
      f = paramInt2 / paramBitmap.getHeight();
    }
  }

  private static Bitmap transform(Matrix paramMatrix, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if ((paramInt3 & 0x1) != 0)
    {
      i = 1;
      if ((paramInt3 & 0x2) == 0)
        break label198;
    }
    int j;
    Object localObject;
    label198: for (paramInt3 = 1; ; paramInt3 = 0)
    {
      int k = paramBitmap.getWidth() - paramInt1;
      j = paramBitmap.getHeight() - paramInt2;
      if ((i != 0) || ((k >= 0) && (j >= 0)))
        break label204;
      localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      paramMatrix = new Canvas(localBitmap);
      i = Math.max(0, k / 2);
      j = Math.max(0, j / 2);
      localObject = new Rect(i, j, Math.min(paramInt1, paramBitmap.getWidth()) + i, Math.min(paramInt2, paramBitmap.getHeight()) + j);
      i = (paramInt1 - ((Rect)localObject).width()) / 2;
      j = (paramInt2 - ((Rect)localObject).height()) / 2;
      paramMatrix.drawBitmap(paramBitmap, (Rect)localObject, new Rect(i, j, paramInt1 - i, paramInt2 - j), null);
      paramMatrix = localBitmap;
      if (paramInt3 != 0)
      {
        paramBitmap.recycle();
        paramMatrix = localBitmap;
      }
      return paramMatrix;
      i = 0;
      break;
    }
    label204: float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    if (f1 / f2 > paramInt1 / paramInt2)
    {
      f1 = paramInt2 / f2;
      label239: if ((f1 >= 0.9F) && (f1 <= 1.0F))
        break label384;
      paramMatrix.setScale(f1, f1);
      label262: if (paramMatrix == null)
        break label389;
    }
    label384: label389: for (Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true); ; localBitmap = paramBitmap)
    {
      if ((paramInt3 != 0) && (localBitmap != paramBitmap))
        paramBitmap.recycle();
      i = Math.max(0, localBitmap.getWidth() - paramInt1);
      j = Math.max(0, localBitmap.getHeight() - paramInt2);
      localObject = Bitmap.createBitmap(localBitmap, i / 2, j / 2, paramInt1, paramInt2);
      paramMatrix = (Matrix)localObject;
      if (localObject == localBitmap)
        break;
      if (paramInt3 == 0)
      {
        paramMatrix = (Matrix)localObject;
        if (localBitmap == paramBitmap)
          break;
      }
      localBitmap.recycle();
      return localObject;
      f1 = paramInt1 / f1;
      break label239;
      paramMatrix = null;
      break label262;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.ThumbnailUtils
 * JD-Core Version:    0.6.0
 */
package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;

public abstract class PlatformBitmapFactory
{
  private static BitmapCreationObserver sBitmapCreationObserver;

  private static void checkFinalImageBounds(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = true;
    if (paramInt1 + paramInt3 <= paramBitmap.getWidth())
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "x + width must be <= bitmap.width()");
      if (paramInt2 + paramInt4 > paramBitmap.getHeight())
        break label52;
    }
    label52: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "y + height must be <= bitmap.height()");
      return;
      bool1 = false;
      break;
    }
  }

  private static void checkWidthHeight(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    if (paramInt1 > 0)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "width must be > 0");
      if (paramInt2 <= 0)
        break label32;
    }
    label32: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "height must be > 0");
      return;
      bool1 = false;
      break;
    }
  }

  private static void checkXYSign(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    if (paramInt1 >= 0)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "x must be >= 0");
      if (paramInt2 < 0)
        break label32;
    }
    label32: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "y must be >= 0");
      return;
      bool1 = false;
      break;
    }
  }

  private CloseableReference<Bitmap> createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean)
  {
    return createBitmap(paramInt1, paramInt2, paramConfig, paramBoolean, null);
  }

  private CloseableReference<Bitmap> createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean, @Nullable Object paramObject)
  {
    return createBitmap(null, paramInt1, paramInt2, paramConfig, paramBoolean, paramObject);
  }

  private CloseableReference<Bitmap> createBitmap(DisplayMetrics paramDisplayMetrics, int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean)
  {
    return createBitmap(paramDisplayMetrics, paramInt1, paramInt2, paramConfig, paramBoolean, null);
  }

  private CloseableReference<Bitmap> createBitmap(DisplayMetrics paramDisplayMetrics, int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean, @Nullable Object paramObject)
  {
    checkWidthHeight(paramInt1, paramInt2);
    CloseableReference localCloseableReference = createBitmapInternal(paramInt1, paramInt2, paramConfig);
    Bitmap localBitmap = (Bitmap)localCloseableReference.get();
    if (paramDisplayMetrics != null)
      localBitmap.setDensity(paramDisplayMetrics.densityDpi);
    if (Build.VERSION.SDK_INT >= 12)
      localBitmap.setHasAlpha(paramBoolean);
    if ((paramConfig == Bitmap.Config.ARGB_8888) && (!paramBoolean))
      localBitmap.eraseColor(-16777216);
    addBitmapReference((Bitmap)localCloseableReference.get(), paramObject);
    return localCloseableReference;
  }

  private static Bitmap.Config getSuitableBitmapConfig(Bitmap paramBitmap)
  {
    Bitmap.Config localConfig1 = Bitmap.Config.ARGB_8888;
    Bitmap.Config localConfig2 = paramBitmap.getConfig();
    paramBitmap = localConfig1;
    if (localConfig2 != null);
    switch (1.$SwitchMap$android$graphics$Bitmap$Config[localConfig2.ordinal()])
    {
    default:
      paramBitmap = Bitmap.Config.ARGB_8888;
      return paramBitmap;
    case 1:
      return Bitmap.Config.RGB_565;
    case 2:
    }
    return Bitmap.Config.ALPHA_8;
  }

  public void addBitmapReference(Bitmap paramBitmap, @Nullable Object paramObject)
  {
    if (sBitmapCreationObserver != null)
      sBitmapCreationObserver.onBitmapCreated(paramBitmap, paramObject);
  }

  public CloseableReference<Bitmap> createBitmap(int paramInt1, int paramInt2)
  {
    return createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
  }

  public CloseableReference<Bitmap> createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return createBitmap(paramInt1, paramInt2, paramConfig, null);
  }

  public CloseableReference<Bitmap> createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig, @Nullable Object paramObject)
  {
    paramConfig = createBitmapInternal(paramInt1, paramInt2, paramConfig);
    addBitmapReference((Bitmap)paramConfig.get(), paramObject);
    return paramConfig;
  }

  public CloseableReference<Bitmap> createBitmap(int paramInt1, int paramInt2, @Nullable Object paramObject)
  {
    return createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888, paramObject);
  }

  public CloseableReference<Bitmap> createBitmap(Bitmap paramBitmap)
  {
    return createBitmap(paramBitmap, null);
  }

  public CloseableReference<Bitmap> createBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return createBitmap(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, null);
  }

  public CloseableReference<Bitmap> createBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable Matrix paramMatrix, boolean paramBoolean)
  {
    return createBitmap(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, paramMatrix, paramBoolean, null);
  }

  public CloseableReference<Bitmap> createBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable Matrix paramMatrix, boolean paramBoolean, @Nullable Object paramObject)
  {
    Preconditions.checkNotNull(paramBitmap, "Source bitmap cannot be null");
    checkXYSign(paramInt1, paramInt2);
    checkWidthHeight(paramInt3, paramInt4);
    checkFinalImageBounds(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
    Canvas localCanvas = new Canvas();
    Rect localRect = new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    RectF localRectF = new RectF(0.0F, 0.0F, paramInt3, paramInt4);
    Object localObject1 = getSuitableBitmapConfig(paramBitmap);
    if ((paramMatrix == null) || (paramMatrix.isIdentity()))
    {
      paramObject = createBitmap(paramInt3, paramInt4, (Bitmap.Config)localObject1, paramBitmap.hasAlpha(), paramObject);
      paramMatrix = null;
      localObject1 = (Bitmap)paramObject.get();
      ((Bitmap)localObject1).setDensity(paramBitmap.getDensity());
      if (Build.VERSION.SDK_INT >= 12)
        ((Bitmap)localObject1).setHasAlpha(paramBitmap.hasAlpha());
      if (Build.VERSION.SDK_INT >= 19)
        ((Bitmap)localObject1).setPremultiplied(paramBitmap.isPremultiplied());
      localCanvas.setBitmap((Bitmap)localObject1);
      localCanvas.drawBitmap(paramBitmap, localRect, localRectF, paramMatrix);
      localCanvas.setBitmap(null);
      return paramObject;
    }
    label205: Object localObject2;
    if (!paramMatrix.rectStaysRect())
    {
      paramInt1 = 1;
      localObject2 = new RectF();
      paramMatrix.mapRect((RectF)localObject2, localRectF);
      paramInt2 = Math.round(((RectF)localObject2).width());
      paramInt3 = Math.round(((RectF)localObject2).height());
      if (paramInt1 == 0)
        break label355;
      localObject1 = Bitmap.Config.ARGB_8888;
      label252: if ((paramInt1 == 0) && (!paramBitmap.hasAlpha()))
        break label358;
    }
    label355: label358: for (boolean bool = true; ; bool = false)
    {
      localObject1 = createBitmap(paramInt2, paramInt3, (Bitmap.Config)localObject1, bool, paramObject);
      localCanvas.translate(-((RectF)localObject2).left, -((RectF)localObject2).top);
      localCanvas.concat(paramMatrix);
      localObject2 = new Paint();
      ((Paint)localObject2).setFilterBitmap(paramBoolean);
      paramObject = localObject1;
      paramMatrix = (Matrix)localObject2;
      if (paramInt1 == 0)
        break;
      ((Paint)localObject2).setAntiAlias(true);
      paramObject = localObject1;
      paramMatrix = (Matrix)localObject2;
      break;
      paramInt1 = 0;
      break label205;
      break label252;
    }
  }

  public CloseableReference<Bitmap> createBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable Object paramObject)
  {
    return createBitmap(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, null, false, paramObject);
  }

  public CloseableReference<Bitmap> createBitmap(Bitmap paramBitmap, @Nullable Object paramObject)
  {
    return createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramObject);
  }

  public CloseableReference<Bitmap> createBitmap(DisplayMetrics paramDisplayMetrics, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return createBitmap(paramDisplayMetrics, paramInt1, paramInt2, paramConfig, null);
  }

  public CloseableReference<Bitmap> createBitmap(DisplayMetrics paramDisplayMetrics, int paramInt1, int paramInt2, Bitmap.Config paramConfig, @Nullable Object paramObject)
  {
    return createBitmap(paramDisplayMetrics, paramInt1, paramInt2, paramConfig, true, paramObject);
  }

  public CloseableReference<Bitmap> createBitmap(DisplayMetrics paramDisplayMetrics, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap.Config paramConfig)
  {
    return createBitmap(paramDisplayMetrics, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4, paramConfig, null);
  }

  public CloseableReference<Bitmap> createBitmap(DisplayMetrics paramDisplayMetrics, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap.Config paramConfig, @Nullable Object paramObject)
  {
    paramDisplayMetrics = createBitmap(paramDisplayMetrics, paramInt3, paramInt4, paramConfig, paramObject);
    ((Bitmap)paramDisplayMetrics.get()).setPixels(paramArrayOfInt, paramInt1, paramInt2, 0, 0, paramInt3, paramInt4);
    return paramDisplayMetrics;
  }

  public CloseableReference<Bitmap> createBitmap(DisplayMetrics paramDisplayMetrics, int[] paramArrayOfInt, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return createBitmap(paramDisplayMetrics, paramArrayOfInt, paramInt1, paramInt2, paramConfig, null);
  }

  public CloseableReference<Bitmap> createBitmap(DisplayMetrics paramDisplayMetrics, int[] paramArrayOfInt, int paramInt1, int paramInt2, Bitmap.Config paramConfig, @Nullable Object paramObject)
  {
    return createBitmap(paramDisplayMetrics, paramArrayOfInt, 0, paramInt1, paramInt1, paramInt2, paramConfig, paramObject);
  }

  public CloseableReference<Bitmap> createBitmap(int[] paramArrayOfInt, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return createBitmap(paramArrayOfInt, paramInt1, paramInt2, paramConfig, null);
  }

  public CloseableReference<Bitmap> createBitmap(int[] paramArrayOfInt, int paramInt1, int paramInt2, Bitmap.Config paramConfig, @Nullable Object paramObject)
  {
    paramConfig = createBitmapInternal(paramInt1, paramInt2, paramConfig);
    ((Bitmap)paramConfig.get()).setPixels(paramArrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
    addBitmapReference((Bitmap)paramConfig.get(), paramObject);
    return paramConfig;
  }

  public abstract CloseableReference<Bitmap> createBitmapInternal(int paramInt1, int paramInt2, Bitmap.Config paramConfig);

  public CloseableReference<Bitmap> createScaledBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return createScaledBitmap(paramBitmap, paramInt1, paramInt2, paramBoolean, null);
  }

  public CloseableReference<Bitmap> createScaledBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean, @Nullable Object paramObject)
  {
    checkWidthHeight(paramInt1, paramInt2);
    Matrix localMatrix = new Matrix();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    localMatrix.setScale(paramInt1 / i, paramInt2 / j);
    return createBitmap(paramBitmap, 0, 0, i, j, localMatrix, paramBoolean, paramObject);
  }

  public void setCreationListener(BitmapCreationObserver paramBitmapCreationObserver)
  {
    if (sBitmapCreationObserver == null)
      sBitmapCreationObserver = paramBitmapCreationObserver;
  }

  public static abstract interface BitmapCreationObserver
  {
    public abstract void onBitmapCreated(Bitmap paramBitmap, @Nullable Object paramObject);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
 * JD-Core Version:    0.6.0
 */
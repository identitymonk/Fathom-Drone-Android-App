package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;

class PointerIconCompatApi24
{
  public static Object create(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    return PointerIcon.create(paramBitmap, paramFloat1, paramFloat2);
  }

  public static Object getSystemIcon(Context paramContext, int paramInt)
  {
    return PointerIcon.getSystemIcon(paramContext, paramInt);
  }

  public static Object load(Resources paramResources, int paramInt)
  {
    return PointerIcon.load(paramResources, paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.view.PointerIconCompatApi24
 * JD-Core Version:    0.6.0
 */
package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DrawableUtils
{
  public static final Rect INSETS_NONE = new Rect();
  private static final String TAG = "DrawableUtils";
  private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
  private static Class<?> sInsetsClazz;

  static
  {
    if (Build.VERSION.SDK_INT >= 18);
    try
    {
      sInsetsClazz = Class.forName("android.graphics.Insets");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
  }

  public static boolean canSafelyMutateDrawable(@NonNull Drawable paramDrawable)
  {
    if ((paramDrawable instanceof LayerDrawable))
      if (Build.VERSION.SDK_INT < 16);
    do
    {
      while (true)
      {
        return true;
        return false;
        if ((paramDrawable instanceof InsetDrawable))
          if (Build.VERSION.SDK_INT < 14)
            return false;
        if ((paramDrawable instanceof StateListDrawable))
          if (Build.VERSION.SDK_INT < 8)
            return false;
        if ((paramDrawable instanceof GradientDrawable))
          if (Build.VERSION.SDK_INT < 14)
            return false;
        if (!(paramDrawable instanceof DrawableContainer))
          break;
        paramDrawable = paramDrawable.getConstantState();
        if (!(paramDrawable instanceof DrawableContainer.DrawableContainerState))
          continue;
        paramDrawable = ((DrawableContainer.DrawableContainerState)paramDrawable).getChildren();
        int j = paramDrawable.length;
        int i = 0;
        while (i < j)
        {
          if (!canSafelyMutateDrawable(paramDrawable[i]))
            return false;
          i += 1;
        }
      }
      if ((paramDrawable instanceof android.support.v4.graphics.drawable.DrawableWrapper))
        return canSafelyMutateDrawable(((android.support.v4.graphics.drawable.DrawableWrapper)paramDrawable).getWrappedDrawable());
      if ((paramDrawable instanceof android.support.v7.graphics.drawable.DrawableWrapper))
        return canSafelyMutateDrawable(((android.support.v7.graphics.drawable.DrawableWrapper)paramDrawable).getWrappedDrawable());
    }
    while (!(paramDrawable instanceof ScaleDrawable));
    return canSafelyMutateDrawable(((ScaleDrawable)paramDrawable).getDrawable());
  }

  static void fixDrawable(@NonNull Drawable paramDrawable)
  {
    if ((Build.VERSION.SDK_INT == 21) && ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName())))
      fixVectorDrawableTinting(paramDrawable);
  }

  private static void fixVectorDrawableTinting(Drawable paramDrawable)
  {
    int[] arrayOfInt = paramDrawable.getState();
    if ((arrayOfInt == null) || (arrayOfInt.length == 0))
      paramDrawable.setState(ThemeUtils.CHECKED_STATE_SET);
    while (true)
    {
      paramDrawable.setState(arrayOfInt);
      return;
      paramDrawable.setState(ThemeUtils.EMPTY_STATE_SET);
    }
  }

  public static Rect getOpticalBounds(Drawable paramDrawable)
  {
    if (sInsetsClazz != null);
    while (true)
    {
      Object localObject;
      Rect localRect;
      int j;
      int i;
      try
      {
        paramDrawable = DrawableCompat.unwrap(paramDrawable);
        localObject = paramDrawable.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(paramDrawable, new Object[0]);
        if (localObject != null)
        {
          localRect = new Rect();
          Field[] arrayOfField = sInsetsClazz.getFields();
          int k = arrayOfField.length;
          j = 0;
          paramDrawable = localRect;
          if (j >= k)
            break label219;
          paramDrawable = arrayOfField[j];
          String str = paramDrawable.getName();
          i = -1;
          switch (str.hashCode())
          {
          case 3317767:
            if (!str.equals("left"))
              break;
            i = 0;
            break;
          case 115029:
            if (!str.equals("top"))
              break;
            i = 1;
            break;
          case 108511772:
            if (!str.equals("right"))
              break;
            i = 2;
            break;
          case -1383228885:
            if (!str.equals("bottom"))
              break;
            i = 3;
            break;
            localRect.left = paramDrawable.getInt(localObject);
          }
        }
      }
      catch (java.lang.Exception paramDrawable)
      {
        Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
      }
      paramDrawable = INSETS_NONE;
      label219: return paramDrawable;
      localRect.top = paramDrawable.getInt(localObject);
      break label296;
      localRect.right = paramDrawable.getInt(localObject);
      break label296;
      localRect.bottom = paramDrawable.getInt(localObject);
      break label296;
      switch (i)
      {
      case 0:
      case 1:
      case 2:
      case 3:
      }
      label296: j += 1;
    }
  }

  static PorterDuff.Mode parseTintMode(int paramInt, PorterDuff.Mode paramMode)
  {
    switch (paramInt)
    {
    case 4:
    case 6:
    case 7:
    case 8:
    case 10:
    case 11:
    case 12:
    case 13:
    default:
    case 3:
    case 5:
    case 9:
    case 14:
    case 15:
    case 16:
    }
    do
    {
      return paramMode;
      return PorterDuff.Mode.SRC_OVER;
      return PorterDuff.Mode.SRC_IN;
      return PorterDuff.Mode.SRC_ATOP;
      return PorterDuff.Mode.MULTIPLY;
      return PorterDuff.Mode.SCREEN;
    }
    while (Build.VERSION.SDK_INT < 11);
    return PorterDuff.Mode.valueOf("ADD");
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.DrawableUtils
 * JD-Core Version:    0.6.0
 */
package android.support.design.widget;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class DrawableUtils
{
  private static final String LOG_TAG = "DrawableUtils";
  private static Field sDrawableContainerStateField;
  private static boolean sDrawableContainerStateFieldFetched;
  private static Method sSetConstantStateMethod;
  private static boolean sSetConstantStateMethodFetched;

  static boolean setContainerConstantState(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    if (Build.VERSION.SDK_INT >= 9)
      return setContainerConstantStateV9(paramDrawableContainer, paramConstantState);
    return setContainerConstantStateV7(paramDrawableContainer, paramConstantState);
  }

  private static boolean setContainerConstantStateV7(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    if (!sDrawableContainerStateFieldFetched);
    try
    {
      sDrawableContainerStateField = DrawableContainer.class.getDeclaredField("mDrawableContainerStateField");
      sDrawableContainerStateField.setAccessible(true);
      sDrawableContainerStateFieldFetched = true;
      if (sDrawableContainerStateField == null);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      try
      {
        sDrawableContainerStateField.set(paramDrawableContainer, paramConstantState);
        return true;
        localNoSuchFieldException = localNoSuchFieldException;
        Log.e("DrawableUtils", "Could not fetch mDrawableContainerStateField. Oh well.");
      }
      catch (java.lang.Exception paramDrawableContainer)
      {
        Log.e("DrawableUtils", "Could not set mDrawableContainerStateField. Oh well.");
      }
    }
    return false;
  }

  private static boolean setContainerConstantStateV9(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    if (!sSetConstantStateMethodFetched);
    try
    {
      sSetConstantStateMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[] { DrawableContainer.DrawableContainerState.class });
      sSetConstantStateMethod.setAccessible(true);
      sSetConstantStateMethodFetched = true;
      if (sSetConstantStateMethod == null);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      try
      {
        sSetConstantStateMethod.invoke(paramDrawableContainer, new Object[] { paramConstantState });
        return true;
        localNoSuchMethodException = localNoSuchMethodException;
        Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
      }
      catch (java.lang.Exception paramDrawableContainer)
      {
        Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
      }
    }
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.DrawableUtils
 * JD-Core Version:    0.6.0
 */
package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

class PopupWindowCompatGingerbread
{
  private static Method sGetWindowLayoutTypeMethod;
  private static boolean sGetWindowLayoutTypeMethodAttempted;
  private static Method sSetWindowLayoutTypeMethod;
  private static boolean sSetWindowLayoutTypeMethodAttempted;

  static int getWindowLayoutType(PopupWindow paramPopupWindow)
  {
    if (!sGetWindowLayoutTypeMethodAttempted);
    try
    {
      sGetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
      sGetWindowLayoutTypeMethod.setAccessible(true);
      label27: sGetWindowLayoutTypeMethodAttempted = true;
      if (sGetWindowLayoutTypeMethod != null)
        try
        {
          int i = ((Integer)sGetWindowLayoutTypeMethod.invoke(paramPopupWindow, new Object[0])).intValue();
          return i;
        }
        catch (Exception paramPopupWindow)
        {
        }
      return 0;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }

  static void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt)
  {
    if (!sSetWindowLayoutTypeMethodAttempted);
    try
    {
      sSetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { Integer.TYPE });
      sSetWindowLayoutTypeMethod.setAccessible(true);
      label33: sSetWindowLayoutTypeMethodAttempted = true;
      if (sSetWindowLayoutTypeMethod != null);
      try
      {
        sSetWindowLayoutTypeMethod.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      catch (Exception paramPopupWindow)
      {
        return;
      }
    }
    catch (Exception localException)
    {
      break label33;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.PopupWindowCompatGingerbread
 * JD-Core Version:    0.6.0
 */
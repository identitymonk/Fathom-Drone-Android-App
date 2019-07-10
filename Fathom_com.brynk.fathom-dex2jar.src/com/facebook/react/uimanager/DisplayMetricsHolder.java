package com.facebook.react.uimanager;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.infer.annotation.Assertions;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

public class DisplayMetricsHolder
{

  @Nullable
  private static DisplayMetrics sScreenDisplayMetrics;

  @Nullable
  private static DisplayMetrics sWindowDisplayMetrics;

  public static DisplayMetrics getScreenDisplayMetrics()
  {
    return sScreenDisplayMetrics;
  }

  @Deprecated
  public static DisplayMetrics getWindowDisplayMetrics()
  {
    return sWindowDisplayMetrics;
  }

  public static void initDisplayMetrics(Context paramContext)
  {
    Object localObject = paramContext.getResources().getDisplayMetrics();
    setWindowDisplayMetrics((DisplayMetrics)localObject);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo((DisplayMetrics)localObject);
    paramContext = (WindowManager)paramContext.getSystemService("window");
    Assertions.assertNotNull(paramContext, "WindowManager is null!");
    paramContext = paramContext.getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17)
      paramContext.getRealMetrics(localDisplayMetrics);
    while (true)
    {
      setScreenDisplayMetrics(localDisplayMetrics);
      return;
      try
      {
        localObject = Display.class.getMethod("getRawHeight", new Class[0]);
        localDisplayMetrics.widthPixels = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
        localDisplayMetrics.heightPixels = ((Integer)((Method)localObject).invoke(paramContext, new Object[0])).intValue();
      }
      catch (java.lang.reflect.InvocationTargetException paramContext)
      {
        throw new RuntimeException("Error getting real dimensions for API level < 17", paramContext);
      }
      catch (java.lang.IllegalAccessException paramContext)
      {
        break label131;
      }
      catch (java.lang.NoSuchMethodException paramContext)
      {
        label131: break label131;
      }
    }
  }

  public static void initDisplayMetricsIfNotInitialized(Context paramContext)
  {
    if (getScreenDisplayMetrics() != null)
      return;
    initDisplayMetrics(paramContext);
  }

  public static void setScreenDisplayMetrics(DisplayMetrics paramDisplayMetrics)
  {
    sScreenDisplayMetrics = paramDisplayMetrics;
  }

  public static void setWindowDisplayMetrics(DisplayMetrics paramDisplayMetrics)
  {
    sWindowDisplayMetrics = paramDisplayMetrics;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.DisplayMetricsHolder
 * JD-Core Version:    0.6.0
 */
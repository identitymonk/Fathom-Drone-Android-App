package io.vov.vitamio.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.Pair<Ljava.lang.Integer;Ljava.lang.Integer;>;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;

public class ScreenResolution
{
  @TargetApi(17)
  private static Pair<Integer, Integer> getRealResolution(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getRealMetrics(localDisplayMetrics);
    return new Pair(Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localDisplayMetrics.heightPixels));
  }

  private static Pair<Integer, Integer> getRealResolutionOnOldDevice(Context paramContext)
  {
    try
    {
      Object localObject = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      Method localMethod1 = Display.class.getMethod("getRawWidth", new Class[0]);
      Method localMethod2 = Display.class.getMethod("getRawHeight", new Class[0]);
      localObject = new Pair((Integer)localMethod1.invoke(localObject, new Object[0]), (Integer)localMethod2.invoke(localObject, new Object[0]));
      return localObject;
    }
    catch (Exception localException)
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
    }
    return (Pair<Integer, Integer>)new Pair(Integer.valueOf(paramContext.widthPixels), Integer.valueOf(paramContext.heightPixels));
  }

  public static Pair<Integer, Integer> getResolution(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17)
      return getRealResolution(paramContext);
    return getRealResolutionOnOldDevice(paramContext);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.utils.ScreenResolution
 * JD-Core Version:    0.6.0
 */
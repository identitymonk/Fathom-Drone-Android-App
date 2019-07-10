package com.facebook.react.uimanager;

import android.util.DisplayMetrics;
import android.util.TypedValue;

public class PixelUtil
{
  public static float toDIPFromPixel(float paramFloat)
  {
    return paramFloat / DisplayMetricsHolder.getWindowDisplayMetrics().density;
  }

  public static float toPixelFromDIP(double paramDouble)
  {
    return toPixelFromDIP((float)paramDouble);
  }

  public static float toPixelFromDIP(float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, DisplayMetricsHolder.getWindowDisplayMetrics());
  }

  public static float toPixelFromSP(double paramDouble)
  {
    return toPixelFromSP((float)paramDouble);
  }

  public static float toPixelFromSP(float paramFloat)
  {
    return TypedValue.applyDimension(2, paramFloat, DisplayMetricsHolder.getWindowDisplayMetrics());
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.PixelUtil
 * JD-Core Version:    0.6.0
 */
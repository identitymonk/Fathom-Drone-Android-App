package com.facebook.react.views.view;

import android.view.View.MeasureSpec;
import com.facebook.yoga.YogaMeasureMode;

public class MeasureUtil
{
  public static int getMeasureSpec(float paramFloat, YogaMeasureMode paramYogaMeasureMode)
  {
    if (paramYogaMeasureMode == YogaMeasureMode.EXACTLY)
      return View.MeasureSpec.makeMeasureSpec((int)paramFloat, 1073741824);
    if (paramYogaMeasureMode == YogaMeasureMode.AT_MOST)
      return View.MeasureSpec.makeMeasureSpec((int)paramFloat, -2147483648);
    return View.MeasureSpec.makeMeasureSpec(0, 0);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.view.MeasureUtil
 * JD-Core Version:    0.6.0
 */
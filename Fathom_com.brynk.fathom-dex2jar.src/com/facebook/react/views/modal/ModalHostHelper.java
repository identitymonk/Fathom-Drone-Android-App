package com.facebook.react.views.modal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.infer.annotation.Assertions;

class ModalHostHelper
{
  private static final Point MAX_POINT;
  private static final Point MIN_POINT = new Point();
  private static final Point SIZE_POINT;

  static
  {
    MAX_POINT = new Point();
    SIZE_POINT = new Point();
  }

  @TargetApi(16)
  public static Point getModalHostSize(Context paramContext)
  {
    Display localDisplay = ((WindowManager)Assertions.assertNotNull((WindowManager)paramContext.getSystemService("window"))).getDefaultDisplay();
    localDisplay.getCurrentSizeRange(MIN_POINT, MAX_POINT);
    localDisplay.getSize(SIZE_POINT);
    boolean bool = paramContext.getTheme().obtainStyledAttributes(new int[] { 16843277 }).getBoolean(0, false);
    paramContext = paramContext.getResources();
    int k = paramContext.getIdentifier("status_bar_height", "dimen", "android");
    int j = 0;
    int i = j;
    if (bool)
    {
      i = j;
      if (k > 0)
        i = (int)paramContext.getDimension(k);
    }
    if (SIZE_POINT.x < SIZE_POINT.y)
      return new Point(MIN_POINT.x, MAX_POINT.y + i);
    return new Point(MAX_POINT.x, MIN_POINT.y + i);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.modal.ModalHostHelper
 * JD-Core Version:    0.6.0
 */
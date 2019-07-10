package com.facebook.fbui.textlayoutbuilder.util;

import android.os.Build.VERSION;
import android.text.Layout;
import android.text.StaticLayout;

public class LayoutMeasureUtil
{
  public static int getHeight(Layout paramLayout)
  {
    if (paramLayout == null)
      return 0;
    int j = 0;
    int i = j;
    float f;
    if (Build.VERSION.SDK_INT < 20)
    {
      i = j;
      if ((paramLayout instanceof StaticLayout))
      {
        i = paramLayout.getLineAscent(paramLayout.getLineCount() - 1);
        j = paramLayout.getLineDescent(paramLayout.getLineCount() - 1);
        f = (j - i - paramLayout.getSpacingAdd()) / paramLayout.getSpacingMultiplier();
        f = j - i - f;
        if (f < 0.0F)
          break label92;
      }
    }
    label92: for (i = (int)(f + 0.5D); ; i = -(int)(-f + 0.5D))
      return paramLayout.getHeight() - i;
  }

  public static int getWidth(Layout paramLayout)
  {
    int k;
    if (paramLayout == null)
    {
      k = 0;
      return k;
    }
    int m = paramLayout.getLineCount();
    int i = 0;
    int j = 0;
    while (true)
    {
      k = i;
      if (j >= m)
        break;
      i = Math.max(i, (int)paramLayout.getLineRight(j));
      j += 1;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.fbui.textlayoutbuilder.util.LayoutMeasureUtil
 * JD-Core Version:    0.6.0
 */
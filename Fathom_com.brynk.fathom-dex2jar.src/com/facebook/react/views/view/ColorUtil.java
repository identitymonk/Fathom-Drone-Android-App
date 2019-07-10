package com.facebook.react.views.view;

public class ColorUtil
{
  public static int getOpacityFromColor(int paramInt)
  {
    paramInt >>>= 24;
    if (paramInt == 255)
      return -1;
    if (paramInt == 0)
      return -2;
    return -3;
  }

  public static int multiplyColorAlpha(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 255)
      return paramInt1;
    if (paramInt2 == 0)
      return paramInt1 & 0xFFFFFF;
    return (paramInt1 >>> 24) * (paramInt2 + (paramInt2 >> 7)) >> 8 << 24 | 0xFFFFFF & paramInt1;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.view.ColorUtil
 * JD-Core Version:    0.6.0
 */
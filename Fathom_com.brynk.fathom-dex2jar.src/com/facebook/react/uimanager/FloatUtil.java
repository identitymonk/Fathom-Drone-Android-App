package com.facebook.react.uimanager;

public class FloatUtil
{
  private static final float EPSILON = 1.0E-005F;

  public static boolean floatsEqual(float paramFloat1, float paramFloat2)
  {
    if ((Float.isNaN(paramFloat1)) || (Float.isNaN(paramFloat2)))
      if ((!Float.isNaN(paramFloat1)) || (!Float.isNaN(paramFloat2)));
    do
    {
      return true;
      return false;
    }
    while (Math.abs(paramFloat2 - paramFloat1) < 1.0E-005F);
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.FloatUtil
 * JD-Core Version:    0.6.0
 */
package com.facebook.yoga;

public class YogaConstants
{
  public static final float UNDEFINED = (0.0F / 0.0F);

  public static boolean isUndefined(float paramFloat)
  {
    return Float.compare(paramFloat, (0.0F / 0.0F)) == 0;
  }

  public static boolean isUndefined(YogaValue paramYogaValue)
  {
    return paramYogaValue.unit == YogaUnit.UNDEFINED;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaConstants
 * JD-Core Version:    0.6.0
 */
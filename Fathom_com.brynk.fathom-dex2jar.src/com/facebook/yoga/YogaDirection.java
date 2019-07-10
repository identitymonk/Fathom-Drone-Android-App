package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaDirection
{
  private int mIntValue;

  static
  {
    $VALUES = new YogaDirection[] { INHERIT, LTR, RTL };
  }

  private YogaDirection(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaDirection fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return INHERIT;
    case 1:
      return LTR;
    case 2:
    }
    return RTL;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaDirection
 * JD-Core Version:    0.6.0
 */
package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaUnit
{
  private int mIntValue;

  static
  {
    POINT = new YogaUnit("POINT", 1, 1);
    PERCENT = new YogaUnit("PERCENT", 2, 2);
    AUTO = new YogaUnit("AUTO", 3, 3);
    $VALUES = new YogaUnit[] { UNDEFINED, POINT, PERCENT, AUTO };
  }

  private YogaUnit(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaUnit fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return UNDEFINED;
    case 1:
      return POINT;
    case 2:
      return PERCENT;
    case 3:
    }
    return AUTO;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaUnit
 * JD-Core Version:    0.6.0
 */
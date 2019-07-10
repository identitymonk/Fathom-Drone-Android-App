package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaPositionType
{
  private int mIntValue;

  static
  {
    ABSOLUTE = new YogaPositionType("ABSOLUTE", 1, 1);
    $VALUES = new YogaPositionType[] { RELATIVE, ABSOLUTE };
  }

  private YogaPositionType(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaPositionType fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return RELATIVE;
    case 1:
    }
    return ABSOLUTE;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaPositionType
 * JD-Core Version:    0.6.0
 */
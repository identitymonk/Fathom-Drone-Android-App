package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaFlexDirection
{
  private int mIntValue;

  static
  {
    $VALUES = new YogaFlexDirection[] { COLUMN, COLUMN_REVERSE, ROW, ROW_REVERSE };
  }

  private YogaFlexDirection(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaFlexDirection fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return COLUMN;
    case 1:
      return COLUMN_REVERSE;
    case 2:
      return ROW;
    case 3:
    }
    return ROW_REVERSE;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaFlexDirection
 * JD-Core Version:    0.6.0
 */
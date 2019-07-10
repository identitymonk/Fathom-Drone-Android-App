package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaDisplay
{
  private int mIntValue;

  static
  {
    $VALUES = new YogaDisplay[] { FLEX, NONE };
  }

  private YogaDisplay(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaDisplay fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return FLEX;
    case 1:
    }
    return NONE;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaDisplay
 * JD-Core Version:    0.6.0
 */
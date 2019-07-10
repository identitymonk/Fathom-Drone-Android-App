package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaOverflow
{
  private int mIntValue;

  static
  {
    HIDDEN = new YogaOverflow("HIDDEN", 1, 1);
    SCROLL = new YogaOverflow("SCROLL", 2, 2);
    $VALUES = new YogaOverflow[] { VISIBLE, HIDDEN, SCROLL };
  }

  private YogaOverflow(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaOverflow fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return VISIBLE;
    case 1:
      return HIDDEN;
    case 2:
    }
    return SCROLL;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaOverflow
 * JD-Core Version:    0.6.0
 */
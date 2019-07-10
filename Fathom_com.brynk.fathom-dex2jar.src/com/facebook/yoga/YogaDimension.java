package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaDimension
{
  private int mIntValue;

  static
  {
    HEIGHT = new YogaDimension("HEIGHT", 1, 1);
    $VALUES = new YogaDimension[] { WIDTH, HEIGHT };
  }

  private YogaDimension(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaDimension fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return WIDTH;
    case 1:
    }
    return HEIGHT;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaDimension
 * JD-Core Version:    0.6.0
 */
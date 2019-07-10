package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaPrintOptions
{
  private int mIntValue;

  static
  {
    CHILDREN = new YogaPrintOptions("CHILDREN", 2, 4);
    $VALUES = new YogaPrintOptions[] { LAYOUT, STYLE, CHILDREN };
  }

  private YogaPrintOptions(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaPrintOptions fromInt(int paramInt)
  {
    switch (paramInt)
    {
    case 3:
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 1:
      return LAYOUT;
    case 2:
      return STYLE;
    case 4:
    }
    return CHILDREN;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaPrintOptions
 * JD-Core Version:    0.6.0
 */
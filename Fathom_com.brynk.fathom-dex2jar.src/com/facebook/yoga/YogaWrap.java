package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaWrap
{
  private int mIntValue;

  static
  {
    $VALUES = new YogaWrap[] { NO_WRAP, WRAP, WRAP_REVERSE };
  }

  private YogaWrap(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaWrap fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return NO_WRAP;
    case 1:
      return WRAP;
    case 2:
    }
    return WRAP_REVERSE;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaWrap
 * JD-Core Version:    0.6.0
 */
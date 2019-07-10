package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaNodeType
{
  private int mIntValue;

  static
  {
    $VALUES = new YogaNodeType[] { DEFAULT, TEXT };
  }

  private YogaNodeType(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaNodeType fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return DEFAULT;
    case 1:
    }
    return TEXT;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaNodeType
 * JD-Core Version:    0.6.0
 */
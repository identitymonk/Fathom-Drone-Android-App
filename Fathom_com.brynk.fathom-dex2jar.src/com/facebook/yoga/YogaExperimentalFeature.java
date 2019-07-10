package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaExperimentalFeature
{
  private int mIntValue;

  static
  {
    $VALUES = new YogaExperimentalFeature[] { WEB_FLEX_BASIS };
  }

  private YogaExperimentalFeature(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaExperimentalFeature fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
    }
    return WEB_FLEX_BASIS;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaExperimentalFeature
 * JD-Core Version:    0.6.0
 */
package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaAlign
{
  private int mIntValue;

  static
  {
    CENTER = new YogaAlign("CENTER", 2, 2);
    FLEX_END = new YogaAlign("FLEX_END", 3, 3);
    STRETCH = new YogaAlign("STRETCH", 4, 4);
    BASELINE = new YogaAlign("BASELINE", 5, 5);
    SPACE_BETWEEN = new YogaAlign("SPACE_BETWEEN", 6, 6);
    SPACE_AROUND = new YogaAlign("SPACE_AROUND", 7, 7);
    $VALUES = new YogaAlign[] { AUTO, FLEX_START, CENTER, FLEX_END, STRETCH, BASELINE, SPACE_BETWEEN, SPACE_AROUND };
  }

  private YogaAlign(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaAlign fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return AUTO;
    case 1:
      return FLEX_START;
    case 2:
      return CENTER;
    case 3:
      return FLEX_END;
    case 4:
      return STRETCH;
    case 5:
      return BASELINE;
    case 6:
      return SPACE_BETWEEN;
    case 7:
    }
    return SPACE_AROUND;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaAlign
 * JD-Core Version:    0.6.0
 */
package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaJustify
{
  private int mIntValue;

  static
  {
    CENTER = new YogaJustify("CENTER", 1, 1);
    FLEX_END = new YogaJustify("FLEX_END", 2, 2);
    SPACE_BETWEEN = new YogaJustify("SPACE_BETWEEN", 3, 3);
    SPACE_AROUND = new YogaJustify("SPACE_AROUND", 4, 4);
    $VALUES = new YogaJustify[] { FLEX_START, CENTER, FLEX_END, SPACE_BETWEEN, SPACE_AROUND };
  }

  private YogaJustify(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaJustify fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return FLEX_START;
    case 1:
      return CENTER;
    case 2:
      return FLEX_END;
    case 3:
      return SPACE_BETWEEN;
    case 4:
    }
    return SPACE_AROUND;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaJustify
 * JD-Core Version:    0.6.0
 */
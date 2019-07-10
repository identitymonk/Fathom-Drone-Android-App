package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaMeasureMode
{
  private int mIntValue;

  static
  {
    EXACTLY = new YogaMeasureMode("EXACTLY", 1, 1);
    AT_MOST = new YogaMeasureMode("AT_MOST", 2, 2);
    $VALUES = new YogaMeasureMode[] { UNDEFINED, EXACTLY, AT_MOST };
  }

  private YogaMeasureMode(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaMeasureMode fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return UNDEFINED;
    case 1:
      return EXACTLY;
    case 2:
    }
    return AT_MOST;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaMeasureMode
 * JD-Core Version:    0.6.0
 */
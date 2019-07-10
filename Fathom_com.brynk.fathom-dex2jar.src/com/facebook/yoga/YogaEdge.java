package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaEdge
{
  private int mIntValue;

  static
  {
    RIGHT = new YogaEdge("RIGHT", 2, 2);
    BOTTOM = new YogaEdge("BOTTOM", 3, 3);
    START = new YogaEdge("START", 4, 4);
    END = new YogaEdge("END", 5, 5);
    HORIZONTAL = new YogaEdge("HORIZONTAL", 6, 6);
    VERTICAL = new YogaEdge("VERTICAL", 7, 7);
    ALL = new YogaEdge("ALL", 8, 8);
    $VALUES = new YogaEdge[] { LEFT, TOP, RIGHT, BOTTOM, START, END, HORIZONTAL, VERTICAL, ALL };
  }

  private YogaEdge(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaEdge fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return LEFT;
    case 1:
      return TOP;
    case 2:
      return RIGHT;
    case 3:
      return BOTTOM;
    case 4:
      return START;
    case 5:
      return END;
    case 6:
      return HORIZONTAL;
    case 7:
      return VERTICAL;
    case 8:
    }
    return ALL;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaEdge
 * JD-Core Version:    0.6.0
 */
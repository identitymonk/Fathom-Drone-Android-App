package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaLogLevel
{
  private int mIntValue;

  static
  {
    INFO = new YogaLogLevel("INFO", 2, 2);
    DEBUG = new YogaLogLevel("DEBUG", 3, 3);
    VERBOSE = new YogaLogLevel("VERBOSE", 4, 4);
    FATAL = new YogaLogLevel("FATAL", 5, 5);
    $VALUES = new YogaLogLevel[] { ERROR, WARN, INFO, DEBUG, VERBOSE, FATAL };
  }

  private YogaLogLevel(int paramInt)
  {
    this.mIntValue = paramInt;
  }

  public static YogaLogLevel fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0:
      return ERROR;
    case 1:
      return WARN;
    case 2:
      return INFO;
    case 3:
      return DEBUG;
    case 4:
      return VERBOSE;
    case 5:
    }
    return FATAL;
  }

  public int intValue()
  {
    return this.mIntValue;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaLogLevel
 * JD-Core Version:    0.6.0
 */
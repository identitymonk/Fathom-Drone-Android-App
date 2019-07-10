package com.facebook.react.uimanager.layoutanimation;

 enum InterpolatorType
{
  private final String mName;

  static
  {
    EASE_IN = new InterpolatorType("EASE_IN", 1, "easeIn");
    EASE_OUT = new InterpolatorType("EASE_OUT", 2, "easeOut");
    EASE_IN_EASE_OUT = new InterpolatorType("EASE_IN_EASE_OUT", 3, "easeInEaseOut");
    SPRING = new InterpolatorType("SPRING", 4, "spring");
    $VALUES = new InterpolatorType[] { LINEAR, EASE_IN, EASE_OUT, EASE_IN_EASE_OUT, SPRING };
  }

  private InterpolatorType(String paramString)
  {
    this.mName = paramString;
  }

  public static InterpolatorType fromString(String paramString)
  {
    InterpolatorType[] arrayOfInterpolatorType = values();
    int j = arrayOfInterpolatorType.length;
    int i = 0;
    while (i < j)
    {
      InterpolatorType localInterpolatorType = arrayOfInterpolatorType[i];
      if (localInterpolatorType.toString().equalsIgnoreCase(paramString))
        return localInterpolatorType;
      i += 1;
    }
    throw new IllegalArgumentException("Unsupported interpolation type : " + paramString);
  }

  public String toString()
  {
    return this.mName;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.layoutanimation.InterpolatorType
 * JD-Core Version:    0.6.0
 */
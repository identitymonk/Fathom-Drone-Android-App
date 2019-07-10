package com.facebook.react.uimanager.layoutanimation;

 enum AnimatedPropertyType
{
  private final String mName;

  static
  {
    $VALUES = new AnimatedPropertyType[] { OPACITY, SCALE_XY };
  }

  private AnimatedPropertyType(String paramString)
  {
    this.mName = paramString;
  }

  public static AnimatedPropertyType fromString(String paramString)
  {
    AnimatedPropertyType[] arrayOfAnimatedPropertyType = values();
    int j = arrayOfAnimatedPropertyType.length;
    int i = 0;
    while (i < j)
    {
      AnimatedPropertyType localAnimatedPropertyType = arrayOfAnimatedPropertyType[i];
      if (localAnimatedPropertyType.toString().equalsIgnoreCase(paramString))
        return localAnimatedPropertyType;
      i += 1;
    }
    throw new IllegalArgumentException("Unsupported animated property : " + paramString);
  }

  public String toString()
  {
    return this.mName;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType
 * JD-Core Version:    0.6.0
 */
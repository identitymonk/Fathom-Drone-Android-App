package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class YogaValue
{
  static final YogaValue AUTO;
  static final YogaValue UNDEFINED = new YogaValue((0.0F / 0.0F), YogaUnit.UNDEFINED);
  static final YogaValue ZERO = new YogaValue(0.0F, YogaUnit.POINT);
  public final YogaUnit unit;
  public final float value;

  static
  {
    AUTO = new YogaValue((0.0F / 0.0F), YogaUnit.AUTO);
  }

  @DoNotStrip
  YogaValue(float paramFloat, int paramInt)
  {
    this(paramFloat, YogaUnit.fromInt(paramInt));
  }

  public YogaValue(float paramFloat, YogaUnit paramYogaUnit)
  {
    this.value = paramFloat;
    this.unit = paramYogaUnit;
  }

  public static YogaValue parse(String paramString)
  {
    if (paramString == null)
      return null;
    if ("undefined".equals(paramString))
      return UNDEFINED;
    if ("auto".equals(paramString))
      return AUTO;
    if (paramString.endsWith("%"))
      return new YogaValue(Float.parseFloat(paramString.substring(0, paramString.length() - 1)), YogaUnit.PERCENT);
    return new YogaValue(Float.parseFloat(paramString), YogaUnit.POINT);
  }

  public boolean equals(Object paramObject)
  {
    int j = 0;
    int i = j;
    if ((paramObject instanceof YogaValue))
    {
      paramObject = (YogaValue)paramObject;
      i = j;
      if (this.unit == paramObject.unit)
        if (this.unit != YogaUnit.UNDEFINED)
        {
          i = j;
          if (Float.compare(this.value, paramObject.value) != 0);
        }
        else
        {
          i = 1;
        }
    }
    return i;
  }

  public int hashCode()
  {
    return Float.floatToIntBits(this.value) + this.unit.intValue();
  }

  public String toString()
  {
    switch (1.$SwitchMap$com$facebook$yoga$YogaUnit[this.unit.ordinal()])
    {
    default:
      throw new IllegalStateException();
    case 1:
      return "undefined";
    case 2:
      return Float.toString(this.value);
    case 3:
      return this.value + "%";
    case 4:
    }
    return "auto";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaValue
 * JD-Core Version:    0.6.0
 */
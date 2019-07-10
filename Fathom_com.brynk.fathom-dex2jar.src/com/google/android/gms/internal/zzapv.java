package com.google.android.gms.internal;

import java.math.BigDecimal;

public final class zzapv extends Number
{
  private final String value;

  public zzapv(String paramString)
  {
    this.value = paramString;
  }

  public double doubleValue()
  {
    return Double.parseDouble(this.value);
  }

  public boolean equals(Object paramObject)
  {
    int j = 0;
    int i;
    if (this == paramObject)
      i = 1;
    do
    {
      do
      {
        return i;
        i = j;
      }
      while (!(paramObject instanceof zzapv));
      paramObject = (zzapv)paramObject;
      if (this.value == paramObject.value)
        break;
      i = j;
    }
    while (!this.value.equals(paramObject.value));
    return true;
  }

  public float floatValue()
  {
    return Float.parseFloat(this.value);
  }

  public int hashCode()
  {
    return this.value.hashCode();
  }

  public int intValue()
  {
    try
    {
      int i = Integer.parseInt(this.value);
      return i;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      try
      {
        long l = Long.parseLong(this.value);
        return (int)l;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
      }
    }
    return new BigDecimal(this.value).intValue();
  }

  public long longValue()
  {
    try
    {
      long l = Long.parseLong(this.value);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return new BigDecimal(this.value).longValue();
  }

  public String toString()
  {
    return this.value;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzapv
 * JD-Core Version:    0.6.0
 */
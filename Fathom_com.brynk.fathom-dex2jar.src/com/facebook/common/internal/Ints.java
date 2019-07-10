package com.facebook.common.internal;

public class Ints
{
  public static int max(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length > 0);
    int j;
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      j = paramArrayOfInt[0];
      int i = 1;
      while (i < paramArrayOfInt.length)
      {
        int k = j;
        if (paramArrayOfInt[i] > j)
          k = paramArrayOfInt[i];
        i += 1;
        j = k;
      }
    }
    return j;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.internal.Ints
 * JD-Core Version:    0.6.0
 */
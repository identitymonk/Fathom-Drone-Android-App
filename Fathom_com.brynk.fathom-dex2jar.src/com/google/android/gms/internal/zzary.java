package com.google.android.gms.internal;

import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzary
{
  protected static final Charset ISO_8859_1;
  protected static final Charset UTF_8 = Charset.forName("UTF-8");
  public static final Object btO;

  static
  {
    ISO_8859_1 = Charset.forName("ISO-8859-1");
    btO = new Object();
  }

  public static boolean equals(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((paramArrayOfFloat1 == null) || (paramArrayOfFloat1.length == 0))
      return (paramArrayOfFloat2 == null) || (paramArrayOfFloat2.length == 0);
    return Arrays.equals(paramArrayOfFloat1, paramArrayOfFloat2);
  }

  public static boolean equals(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length == 0))
      return (paramArrayOfInt2 == null) || (paramArrayOfInt2.length == 0);
    return Arrays.equals(paramArrayOfInt1, paramArrayOfInt2);
  }

  public static boolean equals(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if ((paramArrayOfLong1 == null) || (paramArrayOfLong1.length == 0))
      return (paramArrayOfLong2 == null) || (paramArrayOfLong2.length == 0);
    return Arrays.equals(paramArrayOfLong1, paramArrayOfLong2);
  }

  public static boolean equals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    int i3 = 0;
    int k;
    if (paramArrayOfObject1 == null)
    {
      k = 0;
      if (paramArrayOfObject2 != null)
        break label47;
    }
    int j;
    int i;
    label47: for (int m = 0; ; m = paramArrayOfObject2.length)
    {
      j = 0;
      i = 0;
      while ((i < k) && (paramArrayOfObject1[i] == null))
        i += 1;
      k = paramArrayOfObject1.length;
      break;
    }
    while (true)
    {
      if ((j < m) && (paramArrayOfObject2[j] == null))
      {
        j += 1;
        continue;
      }
      int n;
      int i1;
      label91: int i2;
      if (i >= k)
      {
        n = 1;
        if (j < m)
          break label113;
        i1 = 1;
        if ((n == 0) || (i1 == 0))
          break label119;
        i2 = 1;
      }
      label113: label119: 
      do
      {
        do
        {
          return i2;
          n = 0;
          break;
          i1 = 0;
          break label91;
          i2 = i3;
        }
        while (n != i1);
        i2 = i3;
      }
      while (!paramArrayOfObject1[i].equals(paramArrayOfObject2[j]));
      j += 1;
      i += 1;
      break;
    }
  }

  public static int hashCode(float[] paramArrayOfFloat)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0))
      return 0;
    return Arrays.hashCode(paramArrayOfFloat);
  }

  public static int hashCode(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
      return 0;
    return Arrays.hashCode(paramArrayOfInt);
  }

  public static int hashCode(long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0))
      return 0;
    return Arrays.hashCode(paramArrayOfLong);
  }

  public static int hashCode(Object[] paramArrayOfObject)
  {
    int k = 0;
    if (paramArrayOfObject == null);
    for (int i = 0; ; i = paramArrayOfObject.length)
    {
      int j = 0;
      while (j < i)
      {
        Object localObject = paramArrayOfObject[j];
        int m = k;
        if (localObject != null)
          m = k * 31 + localObject.hashCode();
        j += 1;
        k = m;
      }
    }
    return k;
  }

  public static void zza(zzaru paramzzaru1, zzaru paramzzaru2)
  {
    if (paramzzaru1.btG != null)
      paramzzaru2.btG = ((zzarw)paramzzaru1.btG.clone());
  }

  public static boolean zza(byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2)
  {
    int i3 = 0;
    int k;
    if (paramArrayOfByte1 == null)
    {
      k = 0;
      if (paramArrayOfByte2 != null)
        break label47;
    }
    int j;
    int i;
    label47: for (int m = 0; ; m = paramArrayOfByte2.length)
    {
      j = 0;
      i = 0;
      while ((i < k) && (paramArrayOfByte1[i] == null))
        i += 1;
      k = paramArrayOfByte1.length;
      break;
    }
    while (true)
    {
      if ((j < m) && (paramArrayOfByte2[j] == null))
      {
        j += 1;
        continue;
      }
      int n;
      int i1;
      label91: int i2;
      if (i >= k)
      {
        n = 1;
        if (j < m)
          break label113;
        i1 = 1;
        if ((n == 0) || (i1 == 0))
          break label119;
        i2 = 1;
      }
      label113: label119: 
      do
      {
        do
        {
          return i2;
          n = 0;
          break;
          i1 = 0;
          break label91;
          i2 = i3;
        }
        while (n != i1);
        i2 = i3;
      }
      while (!Arrays.equals(paramArrayOfByte1[i], paramArrayOfByte2[j]));
      j += 1;
      i += 1;
      break;
    }
  }

  public static int zzb(byte[][] paramArrayOfByte)
  {
    int k = 0;
    if (paramArrayOfByte == null);
    for (int i = 0; ; i = paramArrayOfByte.length)
    {
      int j = 0;
      while (j < i)
      {
        byte[] arrayOfByte = paramArrayOfByte[j];
        int m = k;
        if (arrayOfByte != null)
          m = k * 31 + Arrays.hashCode(arrayOfByte);
        j += 1;
        k = m;
      }
    }
    return k;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzary
 * JD-Core Version:    0.6.0
 */
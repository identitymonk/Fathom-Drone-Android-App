package android.support.v4.util;

class ContainerHelpers
{
  static final int[] EMPTY_INTS = new int[0];
  static final long[] EMPTY_LONGS = new long[0];
  static final Object[] EMPTY_OBJECTS = new Object[0];

  static int binarySearch(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramInt1 - 1;
    paramInt1 = i;
    i = j;
    while (true)
      if (paramInt1 <= i)
      {
        j = paramInt1 + i >>> 1;
        int k = paramArrayOfInt[j];
        if (k < paramInt2)
        {
          paramInt1 = j + 1;
          continue;
        }
        i = j;
        if (k <= paramInt2)
          break;
        i = j - 1;
        continue;
      }
      else
      {
        i = paramInt1 ^ 0xFFFFFFFF;
      }
    return i;
  }

  static int binarySearch(long[] paramArrayOfLong, int paramInt, long paramLong)
  {
    int i = 0;
    int j = paramInt - 1;
    paramInt = i;
    i = j;
    while (true)
      if (paramInt <= i)
      {
        j = paramInt + i >>> 1;
        long l = paramArrayOfLong[j];
        if (l < paramLong)
        {
          paramInt = j + 1;
          continue;
        }
        i = j;
        if (l <= paramLong)
          break;
        i = j - 1;
        continue;
      }
      else
      {
        i = paramInt ^ 0xFFFFFFFF;
      }
    return i;
  }

  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public static int idealByteArraySize(int paramInt)
  {
    int i = 4;
    while (true)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12)
          j = (1 << i) - 12;
      }
      else
        return j;
      i += 1;
    }
  }

  public static int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }

  public static int idealLongArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 8) / 8;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v4.util.ContainerHelpers
 * JD-Core Version:    0.6.0
 */
package com.facebook.common.internal;

import javax.annotation.Nullable;

public final class Preconditions
{
  private static String badElementIndex(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    if (paramInt1 < 0)
      return format("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) });
    if (paramInt2 < 0)
      throw new IllegalArgumentException("negative size: " + paramInt2);
    return format("%s (%s) must be less than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }

  private static String badPositionIndex(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    if (paramInt1 < 0)
      return format("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) });
    if (paramInt2 < 0)
      throw new IllegalArgumentException("negative size: " + paramInt2);
    return format("%s (%s) must not be greater than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }

  private static String badPositionIndexes(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramInt3))
      return badPositionIndex(paramInt1, paramInt3, "start index");
    if ((paramInt2 < 0) || (paramInt2 > paramInt3))
      return badPositionIndex(paramInt2, paramInt3, "end index");
    return format("end index (%s) must not be less than start index (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
  }

  public static void checkArgument(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException();
  }

  public static void checkArgument(boolean paramBoolean, @Nullable Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(String.valueOf(paramObject));
  }

  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, @Nullable Object[] paramArrayOfObject)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(format(paramString, paramArrayOfObject));
  }

  public static int checkElementIndex(int paramInt1, int paramInt2)
  {
    return checkElementIndex(paramInt1, paramInt2, "index");
  }

  public static int checkElementIndex(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2))
      throw new IndexOutOfBoundsException(badElementIndex(paramInt1, paramInt2, paramString));
    return paramInt1;
  }

  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null)
      throw new NullPointerException();
    return paramT;
  }

  public static <T> T checkNotNull(T paramT, @Nullable Object paramObject)
  {
    if (paramT == null)
      throw new NullPointerException(String.valueOf(paramObject));
    return paramT;
  }

  public static <T> T checkNotNull(T paramT, @Nullable String paramString, @Nullable Object[] paramArrayOfObject)
  {
    if (paramT == null)
      throw new NullPointerException(format(paramString, paramArrayOfObject));
    return paramT;
  }

  public static int checkPositionIndex(int paramInt1, int paramInt2)
  {
    return checkPositionIndex(paramInt1, paramInt2, "index");
  }

  public static int checkPositionIndex(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramInt2))
      throw new IndexOutOfBoundsException(badPositionIndex(paramInt1, paramInt2, paramString));
    return paramInt1;
  }

  public static void checkPositionIndexes(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt2 < paramInt1) || (paramInt2 > paramInt3))
      throw new IndexOutOfBoundsException(badPositionIndexes(paramInt1, paramInt2, paramInt3));
  }

  public static void checkState(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalStateException();
  }

  public static void checkState(boolean paramBoolean, @Nullable Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(String.valueOf(paramObject));
  }

  public static void checkState(boolean paramBoolean, @Nullable String paramString, @Nullable Object[] paramArrayOfObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(format(paramString, paramArrayOfObject));
  }

  static String format(@Nullable String paramString, @Nullable Object[] paramArrayOfObject)
  {
    paramString = String.valueOf(paramString);
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + paramArrayOfObject.length * 16);
    int j = 0;
    int i = 0;
    while (true)
    {
      int k;
      if (i < paramArrayOfObject.length)
      {
        k = paramString.indexOf("%s", j);
        if (k != -1);
      }
      else
      {
        localStringBuilder.append(paramString.substring(j));
        if (i >= paramArrayOfObject.length)
          break;
        localStringBuilder.append(" [");
        localStringBuilder.append(paramArrayOfObject[i]);
        i += 1;
        while (i < paramArrayOfObject.length)
        {
          localStringBuilder.append(", ");
          localStringBuilder.append(paramArrayOfObject[i]);
          i += 1;
        }
      }
      localStringBuilder.append(paramString.substring(j, k));
      localStringBuilder.append(paramArrayOfObject[i]);
      j = k + 2;
      i += 1;
      continue;
      localStringBuilder.append(']');
    }
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.internal.Preconditions
 * JD-Core Version:    0.6.0
 */
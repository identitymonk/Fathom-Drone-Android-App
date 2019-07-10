package com.facebook.common.util;

public class Hex
{
  private static final byte[] DIGITS;
  private static final char[] FIRST_CHAR;
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final char[] SECOND_CHAR;

  static
  {
    FIRST_CHAR = new char[256];
    SECOND_CHAR = new char[256];
    int j = 0;
    while (j < 256)
    {
      FIRST_CHAR[j] = HEX_DIGITS[(j >> 4 & 0xF)];
      SECOND_CHAR[j] = HEX_DIGITS[(j & 0xF)];
      j += 1;
    }
    DIGITS = new byte[103];
    j = 0;
    while (j <= 70)
    {
      DIGITS[j] = -1;
      j += 1;
    }
    for (int i = 0; i < 10; i = (byte)(i + 1))
      DIGITS[(i + 48)] = i;
    for (j = 0; j < 6; j = (byte)(j + 1))
    {
      DIGITS[(j + 65)] = (byte)(j + 10);
      DIGITS[(j + 97)] = (byte)(j + 10);
    }
  }

  public static String byte2Hex(int paramInt)
  {
    if ((paramInt > 255) || (paramInt < 0))
      throw new IllegalArgumentException("The int converting to hex should be in range 0~255");
    return String.valueOf(FIRST_CHAR[paramInt]) + String.valueOf(SECOND_CHAR[paramInt]);
  }

  public static byte[] decodeHex(String paramString)
  {
    int m = paramString.length();
    if ((m & 0x1) != 0)
      throw new IllegalArgumentException("Odd number of characters.");
    int k = 0;
    byte[] arrayOfByte = new byte[m >> 1];
    int i = 0;
    int j = 0;
    int n;
    if (j < m)
    {
      n = j + 1;
      j = paramString.charAt(j);
      if (j > 102)
        i = 1;
    }
    while (true)
    {
      if (i != 0)
      {
        throw new IllegalArgumentException("Invalid hexadecimal digit: " + paramString);
        int i1 = DIGITS[j];
        if (i1 == -1)
        {
          i = 1;
          continue;
        }
        j = n + 1;
        n = paramString.charAt(n);
        if (n > 102)
        {
          i = 1;
          continue;
        }
        n = DIGITS[n];
        if (n == -1)
        {
          i = 1;
          continue;
        }
        arrayOfByte[i] = (byte)(i1 << 4 | n);
        i += 1;
        break;
      }
      return arrayOfByte;
      i = k;
    }
  }

  public static String encodeHex(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int j = 0;
    int i = 0;
    while (true)
    {
      int k;
      if (i < paramArrayOfByte.length)
      {
        k = paramArrayOfByte[i] & 0xFF;
        if ((k != 0) || (!paramBoolean));
      }
      else
      {
        return new String(arrayOfChar, 0, j);
      }
      int m = j + 1;
      arrayOfChar[j] = FIRST_CHAR[k];
      j = m + 1;
      arrayOfChar[m] = SECOND_CHAR[k];
      i += 1;
    }
  }

  public static byte[] hexStringToByteArray(String paramString)
  {
    return decodeHex(paramString.replaceAll(" ", ""));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.Hex
 * JD-Core Version:    0.6.0
 */
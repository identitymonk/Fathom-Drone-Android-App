package com.facebook.imageformat;

import com.facebook.common.internal.Preconditions;

public class ImageFormatCheckerUtils
{
  public static byte[] asciiBytes(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    try
    {
      paramString = paramString.getBytes("ASCII");
      return paramString;
    }
    catch (java.io.UnsupportedEncodingException paramString)
    {
    }
    throw new RuntimeException("ASCII not found!", paramString);
  }

  public static boolean startsWithPattern(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Preconditions.checkNotNull(paramArrayOfByte1);
    Preconditions.checkNotNull(paramArrayOfByte2);
    if (paramArrayOfByte2.length > paramArrayOfByte1.length)
      return false;
    int i = 0;
    while (true)
    {
      if (i >= paramArrayOfByte2.length)
        break label43;
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i])
        break;
      i += 1;
    }
    label43: return true;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imageformat.ImageFormatCheckerUtils
 * JD-Core Version:    0.6.0
 */
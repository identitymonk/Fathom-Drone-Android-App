package com.facebook.common.util;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class SecureHashUtil
{
  static final byte[] HEX_CHAR_TABLE = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };

  public static String convertToHex(byte[] paramArrayOfByte)
    throws UnsupportedEncodingException
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i] & 0xFF;
      localStringBuilder.append((char)HEX_CHAR_TABLE[(k >>> 4)]);
      localStringBuilder.append((char)HEX_CHAR_TABLE[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }

  private static String makeHash(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      paramString.update(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = convertToHex(paramString.digest());
      return paramArrayOfByte;
    }
    catch (java.security.NoSuchAlgorithmException paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
    }
    throw new RuntimeException(paramArrayOfByte);
  }

  public static String makeMD5Hash(String paramString)
  {
    try
    {
      paramString = makeMD5Hash(paramString.getBytes("utf-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
    }
    throw new RuntimeException(paramString);
  }

  public static String makeMD5Hash(byte[] paramArrayOfByte)
  {
    return makeHash(paramArrayOfByte, "MD5");
  }

  public static String makeSHA1Hash(String paramString)
  {
    try
    {
      paramString = makeSHA1Hash(paramString.getBytes("utf-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
    }
    throw new RuntimeException(paramString);
  }

  public static String makeSHA1Hash(byte[] paramArrayOfByte)
  {
    return makeHash(paramArrayOfByte, "SHA-1");
  }

  public static String makeSHA1HashBase64(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = Base64.encodeToString(localMessageDigest.digest(), 11);
      return paramArrayOfByte;
    }
    catch (java.security.NoSuchAlgorithmException paramArrayOfByte)
    {
    }
    throw new RuntimeException(paramArrayOfByte);
  }

  public static String makeSHA256Hash(byte[] paramArrayOfByte)
  {
    return makeHash(paramArrayOfByte, "SHA-256");
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.SecureHashUtil
 * JD-Core Version:    0.6.0
 */
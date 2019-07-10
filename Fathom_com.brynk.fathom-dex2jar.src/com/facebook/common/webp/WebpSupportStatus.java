package com.facebook.common.webp;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Base64;

public class WebpSupportStatus
{
  private static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
  private static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
  private static final String VP8X_WEBP_BASE64 = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";
  private static final byte[] WEBP_NAME_BYTES;
  private static final byte[] WEBP_RIFF_BYTES;
  private static final byte[] WEBP_VP8L_BYTES;
  private static final byte[] WEBP_VP8X_BYTES;
  private static final byte[] WEBP_VP8_BYTES;
  public static final boolean sIsExtendedWebpSupported;
  public static final boolean sIsSimpleWebpSupported;
  public static final boolean sIsWebpSupportRequired;
  public static WebpBitmapFactory sWebpBitmapFactory;
  private static boolean sWebpLibraryChecked;

  static
  {
    boolean bool2 = true;
    if (Build.VERSION.SDK_INT <= 17)
    {
      bool1 = true;
      sIsWebpSupportRequired = bool1;
      if (Build.VERSION.SDK_INT < 14)
        break label90;
    }
    label90: for (boolean bool1 = bool2; ; bool1 = false)
    {
      sIsSimpleWebpSupported = bool1;
      sIsExtendedWebpSupported = isExtendedWebpSupported();
      sWebpBitmapFactory = null;
      sWebpLibraryChecked = false;
      WEBP_RIFF_BYTES = asciiBytes("RIFF");
      WEBP_NAME_BYTES = asciiBytes("WEBP");
      WEBP_VP8_BYTES = asciiBytes("VP8 ");
      WEBP_VP8L_BYTES = asciiBytes("VP8L");
      WEBP_VP8X_BYTES = asciiBytes("VP8X");
      return;
      bool1 = false;
      break;
    }
  }

  private static byte[] asciiBytes(String paramString)
  {
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

  public static boolean isAnimatedWebpHeader(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = matchBytePattern(paramArrayOfByte, paramInt + 12, WEBP_VP8X_BYTES);
    if ((paramArrayOfByte[(paramInt + 20)] & 0x2) == 2);
    for (paramInt = 1; (bool) && (paramInt != 0); paramInt = 0)
      return true;
    return false;
  }

  public static boolean isExtendedWebpHeader(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return (paramInt2 >= 21) && (matchBytePattern(paramArrayOfByte, paramInt1 + 12, WEBP_VP8X_BYTES));
  }

  public static boolean isExtendedWebpHeaderWithAlpha(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = matchBytePattern(paramArrayOfByte, paramInt + 12, WEBP_VP8X_BYTES);
    if ((paramArrayOfByte[(paramInt + 20)] & 0x10) == 16);
    for (paramInt = 1; (bool) && (paramInt != 0); paramInt = 0)
      return true;
    return false;
  }

  private static boolean isExtendedWebpSupported()
  {
    if (Build.VERSION.SDK_INT < 17);
    BitmapFactory.Options localOptions;
    do
    {
      return false;
      if (Build.VERSION.SDK_INT != 17)
        break;
      byte[] arrayOfByte = Base64.decode("UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==", 0);
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
    }
    while ((localOptions.outHeight != 1) || (localOptions.outWidth != 1));
    return true;
  }

  public static boolean isLosslessWebpHeader(byte[] paramArrayOfByte, int paramInt)
  {
    return matchBytePattern(paramArrayOfByte, paramInt + 12, WEBP_VP8L_BYTES);
  }

  public static boolean isSimpleWebpHeader(byte[] paramArrayOfByte, int paramInt)
  {
    return matchBytePattern(paramArrayOfByte, paramInt + 12, WEBP_VP8_BYTES);
  }

  public static boolean isWebpHeader(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return (paramInt2 >= 20) && (matchBytePattern(paramArrayOfByte, paramInt1, WEBP_RIFF_BYTES)) && (matchBytePattern(paramArrayOfByte, paramInt1 + 8, WEBP_NAME_BYTES));
  }

  public static boolean isWebpSupportedByPlatform(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (isSimpleWebpHeader(paramArrayOfByte, paramInt1))
      bool1 = sIsSimpleWebpSupported;
    do
    {
      do
      {
        return bool1;
        if (isLosslessWebpHeader(paramArrayOfByte, paramInt1))
          return sIsExtendedWebpSupported;
        bool1 = bool2;
      }
      while (!isExtendedWebpHeader(paramArrayOfByte, paramInt1, paramInt2));
      bool1 = bool2;
    }
    while (isAnimatedWebpHeader(paramArrayOfByte, paramInt1));
    return sIsExtendedWebpSupported;
  }

  public static WebpBitmapFactory loadWebpBitmapFactoryIfExists()
  {
    if (sWebpLibraryChecked)
      return sWebpBitmapFactory;
    Object localObject = null;
    try
    {
      WebpBitmapFactory localWebpBitmapFactory = (WebpBitmapFactory)Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
      localObject = localWebpBitmapFactory;
      label26: sWebpLibraryChecked = true;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      break label26;
    }
  }

  private static boolean matchBytePattern(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte1 == null));
    do
      return false;
    while (paramArrayOfByte2.length + paramInt > paramArrayOfByte1.length);
    int i = 0;
    while (true)
    {
      if (i >= paramArrayOfByte2.length)
        break label45;
      if (paramArrayOfByte1[(i + paramInt)] != paramArrayOfByte2[i])
        break;
      i += 1;
    }
    label45: return true;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.webp.WebpSupportStatus
 * JD-Core Version:    0.6.0
 */
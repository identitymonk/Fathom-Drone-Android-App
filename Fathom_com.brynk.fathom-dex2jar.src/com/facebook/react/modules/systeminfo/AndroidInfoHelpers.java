package com.facebook.react.modules.systeminfo;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.Locale;

public class AndroidInfoHelpers
{
  private static final int DEBUG_SERVER_HOST_PORT = 8081;
  public static final String DEVICE_LOCALHOST = "localhost";
  public static final String EMULATOR_LOCALHOST = "10.0.2.2";
  public static final String GENYMOTION_LOCALHOST = "10.0.3.2";
  private static final int INSPECTOR_PROXY_PORT = 8082;

  public static String getFriendlyDeviceName()
  {
    if (isRunningOnGenymotion())
      return Build.MODEL;
    return Build.MODEL + " - " + Build.VERSION.RELEASE + " - API " + Build.VERSION.SDK_INT;
  }

  public static String getInspectorProxyHost()
  {
    return getServerIpAddress(8082);
  }

  public static String getServerHost()
  {
    return getServerIpAddress(8081);
  }

  private static String getServerIpAddress(int paramInt)
  {
    String str;
    if (isRunningOnGenymotion())
      str = "10.0.3.2";
    while (true)
    {
      return String.format(Locale.US, "%s:%d", new Object[] { str, Integer.valueOf(paramInt) });
      if (isRunningOnStockEmulator())
      {
        str = "10.0.2.2";
        continue;
      }
      str = "localhost";
    }
  }

  private static boolean isRunningOnGenymotion()
  {
    return Build.FINGERPRINT.contains("vbox");
  }

  private static boolean isRunningOnStockEmulator()
  {
    return Build.FINGERPRINT.contains("generic");
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.systeminfo.AndroidInfoHelpers
 * JD-Core Version:    0.6.0
 */
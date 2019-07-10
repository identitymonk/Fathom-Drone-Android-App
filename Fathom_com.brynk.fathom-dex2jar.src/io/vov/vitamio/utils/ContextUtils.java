package io.vov.vitamio.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class ContextUtils
{
  public static String fixLastSlash(String paramString)
  {
    if (paramString == null);
    for (paramString = "/"; ; paramString = paramString.trim() + "/")
    {
      String str = paramString;
      if (paramString.length() > 2)
      {
        str = paramString;
        if (paramString.charAt(paramString.length() - 2) == '/')
          str = paramString.substring(0, paramString.length() - 1);
      }
      return str;
    }
  }

  public static String getDataDir(Context paramContext)
  {
    paramContext = paramContext.getApplicationInfo();
    if (paramContext.dataDir != null)
      return fixLastSlash(paramContext.dataDir);
    return "/data/data/" + paramContext.packageName + "/";
  }

  public static int getVersionCode(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getApplicationInfo().packageName, 0).versionCode;
      return i;
    }
    catch (java.lang.Exception paramContext)
    {
      Log.e("getVersionInt", paramContext);
    }
    return 0;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.utils.ContextUtils
 * JD-Core Version:    0.6.0
 */
package io.vov.vitamio.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.Locale;

public class Device
{
  public static String getDeviceFeatures(Context paramContext)
  {
    return getIdentifiers(paramContext) + getSystemFeatures() + getScreenFeatures(paramContext);
  }

  @SuppressLint({"NewApi"})
  public static String getIdentifiers(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (Build.VERSION.SDK_INT > 8)
    {
      localStringBuilder.append(getPair("serial", Build.SERIAL));
      localStringBuilder.append(getPair("android_id", Settings.Secure.getString(paramContext.getContentResolver(), "android_id")));
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      localStringBuilder.append(getPair("sim_country_iso", localTelephonyManager.getSimCountryIso()));
      localStringBuilder.append(getPair("network_operator_name", localTelephonyManager.getNetworkOperatorName()));
      localStringBuilder.append(getPair("unique_id", Crypto.md5(localStringBuilder.toString())));
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext.getActiveNetworkInfo() != null)
        break label154;
    }
    label154: for (paramContext = "-1"; ; paramContext = String.valueOf(paramContext.getActiveNetworkInfo().getType()))
    {
      localStringBuilder.append(getPair("network_type", paramContext));
      return localStringBuilder.toString();
      localStringBuilder.append(getPair("serial", "No Serial"));
      break;
    }
  }

  public static String getLocale()
  {
    Object localObject = Locale.getDefault();
    if (localObject != null)
    {
      localObject = ((Locale)localObject).getLanguage();
      Log.i("getLocale " + (String)localObject, new Object[0]);
      if (localObject != null)
        return ((String)localObject).toLowerCase();
    }
    return (String)"en";
  }

  private static String getPair(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      paramString1 = "";
      if (paramString2 != null)
        break label51;
    }
    label51: for (paramString2 = ""; ; paramString2 = paramString2.trim())
    {
      return "&" + paramString1 + "=" + paramString2;
      paramString1 = paramString1.trim();
      break;
    }
  }

  public static String getScreenFeatures(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = paramContext.getResources().getDisplayMetrics();
    localStringBuilder.append(getPair("screen_density", "" + paramContext.density));
    localStringBuilder.append(getPair("screen_density_dpi", "" + paramContext.densityDpi));
    localStringBuilder.append(getPair("screen_height_pixels", "" + paramContext.heightPixels));
    localStringBuilder.append(getPair("screen_width_pixels", "" + paramContext.widthPixels));
    localStringBuilder.append(getPair("screen_scaled_density", "" + paramContext.scaledDensity));
    localStringBuilder.append(getPair("screen_xdpi", "" + paramContext.xdpi));
    localStringBuilder.append(getPair("screen_ydpi", "" + paramContext.ydpi));
    return localStringBuilder.toString();
  }

  public static String getSystemFeatures()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getPair("android_release", Build.VERSION.RELEASE));
    localStringBuilder.append(getPair("android_sdk_int", "" + Build.VERSION.SDK_INT));
    localStringBuilder.append(getPair("device_cpu_abi", Build.CPU_ABI));
    localStringBuilder.append(getPair("device_model", Build.MODEL));
    localStringBuilder.append(getPair("device_manufacturer", Build.MANUFACTURER));
    localStringBuilder.append(getPair("device_board", Build.BOARD));
    localStringBuilder.append(getPair("device_fingerprint", Build.FINGERPRINT));
    localStringBuilder.append(getPair("device_cpu_feature", CPU.getFeatureString()));
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     io.vov.vitamio.utils.Device
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.R.string;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsz;

public final class zzg
{
  private static final SimpleArrayMap<String, String> DO = new SimpleArrayMap();

  public static String zzcb(Context paramContext)
  {
    String str2 = paramContext.getApplicationInfo().name;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str2 = paramContext.getPackageName();
    try
    {
      str1 = zzsz.zzco(paramContext).zzik(paramContext.getPackageName()).toString();
      return str1;
    }
    catch (android.content.pm.PackageManager.NameNotFoundException paramContext)
    {
    }
    return str2;
  }

  @Nullable
  public static String zzg(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    switch (paramInt)
    {
    case 12:
    case 13:
    case 14:
    case 15:
    case 19:
    default:
      Log.e("GoogleApiAvailability", 33 + "Unexpected error code " + paramInt);
    case 4:
    case 6:
    case 18:
      return null;
    case 1:
      return localResources.getString(R.string.common_google_play_services_install_title);
    case 3:
      return localResources.getString(R.string.common_google_play_services_enable_title);
    case 2:
      return localResources.getString(R.string.common_google_play_services_update_title);
    case 9:
      Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
      return null;
    case 7:
      Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
      return zzu(paramContext, "common_google_play_services_network_error_title");
    case 8:
      Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
      return null;
    case 10:
      Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
      return null;
    case 5:
      Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
      return zzu(paramContext, "common_google_play_services_invalid_account_title");
    case 11:
      Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
      return null;
    case 16:
      Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
      return null;
    case 17:
      Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
      return zzu(paramContext, "common_google_play_services_sign_in_failed_title");
    case 20:
    }
    Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
    return zzu(paramContext, "common_google_play_services_restricted_profile_title");
  }

  private static String zzg(Context paramContext, String paramString1, String paramString2)
  {
    Resources localResources = paramContext.getResources();
    paramString1 = zzu(paramContext, paramString1);
    paramContext = paramString1;
    if (paramString1 == null)
      paramContext = localResources.getString(R.string.common_google_play_services_unknown_issue);
    return String.format(localResources.getConfiguration().locale, paramContext, new Object[] { paramString2 });
  }

  @NonNull
  public static String zzh(Context paramContext, int paramInt)
  {
    if (paramInt == 6);
    for (String str1 = zzu(paramContext, "common_google_play_services_resolution_required_title"); ; str1 = zzg(paramContext, paramInt))
    {
      String str2 = str1;
      if (str1 == null)
        str2 = paramContext.getResources().getString(R.string.common_google_play_services_notification_ticker);
      return str2;
    }
  }

  @NonNull
  public static String zzi(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    String str = zzcb(paramContext);
    switch (paramInt)
    {
    case 4:
    case 6:
    case 8:
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    case 19:
    default:
      return localResources.getString(R.string.common_google_play_services_unknown_issue, new Object[] { str });
    case 1:
      return localResources.getString(R.string.common_google_play_services_install_text, new Object[] { str });
    case 3:
      return localResources.getString(R.string.common_google_play_services_enable_text, new Object[] { str });
    case 18:
      return localResources.getString(R.string.common_google_play_services_updating_text, new Object[] { str });
    case 2:
      if (zzi.zzci(paramContext))
        return localResources.getString(R.string.common_google_play_services_wear_update_text);
      return localResources.getString(R.string.common_google_play_services_update_text, new Object[] { str });
    case 9:
      return localResources.getString(R.string.common_google_play_services_unsupported_text, new Object[] { str });
    case 7:
      return zzg(paramContext, "common_google_play_services_network_error_text", str);
    case 5:
      return zzg(paramContext, "common_google_play_services_invalid_account_text", str);
    case 16:
      return zzg(paramContext, "common_google_play_services_api_unavailable_text", str);
    case 17:
      return zzg(paramContext, "common_google_play_services_sign_in_failed_text", str);
    case 20:
    }
    return zzg(paramContext, "common_google_play_services_restricted_profile_text", str);
  }

  @NonNull
  public static String zzj(Context paramContext, int paramInt)
  {
    if (paramInt == 6)
      return zzg(paramContext, "common_google_play_services_resolution_required_text", zzcb(paramContext));
    return zzi(paramContext, paramInt);
  }

  @NonNull
  public static String zzk(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    switch (paramInt)
    {
    default:
      return paramContext.getString(17039370);
    case 1:
      return paramContext.getString(R.string.common_google_play_services_install_button);
    case 3:
      return paramContext.getString(R.string.common_google_play_services_enable_button);
    case 2:
    }
    return paramContext.getString(R.string.common_google_play_services_update_button);
  }

  @Nullable
  private static String zzu(Context paramContext, String paramString)
  {
    int i;
    synchronized (DO)
    {
      String str = (String)DO.get(paramString);
      if (str != null)
        return str;
      paramContext = GooglePlayServicesUtil.getRemoteResource(paramContext);
      if (paramContext == null)
        return null;
      i = paramContext.getIdentifier(paramString, "string", "com.google.android.gms");
      if (i == 0)
      {
        paramContext = String.valueOf(paramString);
        if (paramContext.length() != 0)
        {
          paramContext = "Missing resource: ".concat(paramContext);
          Log.w("GoogleApiAvailability", paramContext);
          return null;
        }
        paramContext = new String("Missing resource: ");
      }
    }
    paramContext = paramContext.getString(i);
    if (TextUtils.isEmpty(paramContext))
    {
      paramContext = String.valueOf(paramString);
      if (paramContext.length() != 0);
      for (paramContext = "Got empty resource: ".concat(paramContext); ; paramContext = new String("Got empty resource: "))
      {
        Log.w("GoogleApiAvailability", paramContext);
        monitorexit;
        return null;
      }
    }
    DO.put(paramString, paramContext);
    monitorexit;
    return paramContext;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzg
 * JD-Core Version:    0.6.0
 */
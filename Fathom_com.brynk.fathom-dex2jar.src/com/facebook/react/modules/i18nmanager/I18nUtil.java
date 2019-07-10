package com.facebook.react.modules.i18nmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.text.TextUtilsCompat;
import java.util.Locale;

public class I18nUtil
{
  private static final String KEY_FOR_PREFS_ALLOWRTL = "RCTI18nUtil_allowRTL";
  private static final String KEY_FOR_PREFS_FORCERTL = "RCTI18nUtil_forceRTL";
  private static final String SHARED_PREFS_NAME = "com.facebook.react.modules.i18nmanager.I18nUtil";
  private static I18nUtil sharedI18nUtilInstance = null;

  public static I18nUtil getInstance()
  {
    if (sharedI18nUtilInstance == null)
      sharedI18nUtilInstance = new I18nUtil();
    return sharedI18nUtilInstance;
  }

  private boolean isDevicePreferredLanguageRTL()
  {
    return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
  }

  private boolean isPrefSet(Context paramContext, String paramString, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences("com.facebook.react.modules.i18nmanager.I18nUtil", 0).getBoolean(paramString, paramBoolean);
  }

  private boolean isRTLAllowed(Context paramContext)
  {
    return isPrefSet(paramContext, "RCTI18nUtil_allowRTL", true);
  }

  private boolean isRTLForced(Context paramContext)
  {
    return isPrefSet(paramContext, "RCTI18nUtil_forceRTL", false);
  }

  private void setPref(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("com.facebook.react.modules.i18nmanager.I18nUtil", 0).edit();
    paramContext.putBoolean(paramString, paramBoolean);
    paramContext.apply();
  }

  public void allowRTL(Context paramContext, boolean paramBoolean)
  {
    setPref(paramContext, "RCTI18nUtil_allowRTL", paramBoolean);
  }

  public void forceRTL(Context paramContext, boolean paramBoolean)
  {
    setPref(paramContext, "RCTI18nUtil_forceRTL", paramBoolean);
  }

  public boolean isRTL(Context paramContext)
  {
    if (isRTLForced(paramContext));
    do
      return true;
    while ((isRTLAllowed(paramContext)) && (isDevicePreferredLanguageRTL()));
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.i18nmanager.I18nUtil
 * JD-Core Version:    0.6.0
 */
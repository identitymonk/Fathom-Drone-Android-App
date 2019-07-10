package com.facebook.react.packagerconnection;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import javax.annotation.Nullable;

public class PackagerConnectionSettings
{
  private static final String PREFS_DEBUG_SERVER_HOST_KEY = "debug_http_host";
  private static final String TAG = PackagerConnectionSettings.class.getSimpleName();
  private final String mPackageName;
  private final SharedPreferences mPreferences;

  public PackagerConnectionSettings(Context paramContext)
  {
    this.mPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    this.mPackageName = paramContext.getPackageName();
  }

  public String getDebugServerHost()
  {
    String str = this.mPreferences.getString("debug_http_host", null);
    if (!TextUtils.isEmpty(str))
      return (String)Assertions.assertNotNull(str);
    str = AndroidInfoHelpers.getServerHost();
    if (str.equals("localhost"))
      FLog.w(TAG, "You seem to be running on device. Run 'adb reverse tcp:8081 tcp:8081' to forward the debug server's port to the device.");
    return str;
  }

  public String getInspectorServerHost()
  {
    return AndroidInfoHelpers.getInspectorProxyHost();
  }

  @Nullable
  public String getPackageName()
  {
    return this.mPackageName;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.packagerconnection.PackagerConnectionSettings
 * JD-Core Version:    0.6.0
 */
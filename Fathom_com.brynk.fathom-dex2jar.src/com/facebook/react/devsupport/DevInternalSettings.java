package com.facebook.react.devsupport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.packagerconnection.PackagerConnectionSettings;

@VisibleForTesting
public class DevInternalSettings
  implements DeveloperSettings, SharedPreferences.OnSharedPreferenceChangeListener
{
  private static final String PREFS_ANIMATIONS_DEBUG_KEY = "animations_debug";
  private static final String PREFS_FPS_DEBUG_KEY = "fps_debug";
  private static final String PREFS_HOT_MODULE_REPLACEMENT_KEY = "hot_module_replacement";
  private static final String PREFS_INSPECTOR_DEBUG_KEY = "inspector_debug";
  private static final String PREFS_JS_DEV_MODE_DEBUG_KEY = "js_dev_mode_debug";
  private static final String PREFS_JS_MINIFY_DEBUG_KEY = "js_minify_debug";
  private static final String PREFS_RELOAD_ON_JS_CHANGE_KEY = "reload_on_js_change";
  private static final String PREFS_REMOTE_JS_DEBUG_KEY = "remote_js_debug";
  private final Listener mListener;
  private final PackagerConnectionSettings mPackagerConnectionSettings;
  private final SharedPreferences mPreferences;

  public DevInternalSettings(Context paramContext, Listener paramListener)
  {
    this.mListener = paramListener;
    this.mPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    this.mPreferences.registerOnSharedPreferenceChangeListener(this);
    this.mPackagerConnectionSettings = new PackagerConnectionSettings(paramContext);
  }

  public PackagerConnectionSettings getPackagerConnectionSettings()
  {
    return this.mPackagerConnectionSettings;
  }

  public boolean isAnimationFpsDebugEnabled()
  {
    return this.mPreferences.getBoolean("animations_debug", false);
  }

  public boolean isElementInspectorEnabled()
  {
    return this.mPreferences.getBoolean("inspector_debug", false);
  }

  public boolean isFpsDebugEnabled()
  {
    return this.mPreferences.getBoolean("fps_debug", false);
  }

  public boolean isHotModuleReplacementEnabled()
  {
    return this.mPreferences.getBoolean("hot_module_replacement", false);
  }

  public boolean isJSDevModeEnabled()
  {
    return this.mPreferences.getBoolean("js_dev_mode_debug", true);
  }

  public boolean isJSMinifyEnabled()
  {
    return this.mPreferences.getBoolean("js_minify_debug", false);
  }

  public boolean isReloadOnJSChangeEnabled()
  {
    return this.mPreferences.getBoolean("reload_on_js_change", false);
  }

  public boolean isRemoteJSDebugEnabled()
  {
    return this.mPreferences.getBoolean("remote_js_debug", false);
  }

  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if ((this.mListener != null) && (("fps_debug".equals(paramString)) || ("reload_on_js_change".equals(paramString)) || ("js_dev_mode_debug".equals(paramString)) || ("js_minify_debug".equals(paramString))))
      this.mListener.onInternalSettingsChanged();
  }

  public void setElementInspectorEnabled(boolean paramBoolean)
  {
    this.mPreferences.edit().putBoolean("inspector_debug", paramBoolean).apply();
  }

  public void setFpsDebugEnabled(boolean paramBoolean)
  {
    this.mPreferences.edit().putBoolean("fps_debug", paramBoolean).apply();
  }

  public void setHotModuleReplacementEnabled(boolean paramBoolean)
  {
    this.mPreferences.edit().putBoolean("hot_module_replacement", paramBoolean).apply();
  }

  public void setReloadOnJSChangeEnabled(boolean paramBoolean)
  {
    this.mPreferences.edit().putBoolean("reload_on_js_change", paramBoolean).apply();
  }

  public void setRemoteJSDebugEnabled(boolean paramBoolean)
  {
    this.mPreferences.edit().putBoolean("remote_js_debug", paramBoolean).apply();
  }

  public static abstract interface Listener
  {
    public abstract void onInternalSettingsChanged();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.DevInternalSettings
 * JD-Core Version:    0.6.0
 */
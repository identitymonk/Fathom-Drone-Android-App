package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.view.SupportActionModeWrapper.CallbackWrapper;
import android.util.Log;
import android.view.ActionMode.Callback;
import android.view.Window;
import android.view.Window.Callback;

class AppCompatDelegateImplV14 extends AppCompatDelegateImplV11
{
  private static final String KEY_LOCAL_NIGHT_MODE = "appcompat:local_night_mode";
  private static TwilightManager sTwilightManager;
  private boolean mApplyDayNightCalled;
  private boolean mHandleNativeActionModes = true;
  private int mLocalNightMode = -100;

  AppCompatDelegateImplV14(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    super(paramContext, paramWindow, paramAppCompatCallback);
  }

  private TwilightManager getTwilightManager()
  {
    if (sTwilightManager == null)
      sTwilightManager = new TwilightManager(this.mContext.getApplicationContext());
    return sTwilightManager;
  }

  private boolean updateConfigurationForNightMode(int paramInt)
  {
    Resources localResources = this.mContext.getResources();
    Configuration localConfiguration = localResources.getConfiguration();
    int i = localConfiguration.uiMode;
    if (paramInt == 2);
    for (paramInt = 32; (i & 0x30) != paramInt; paramInt = 16)
    {
      localConfiguration = new Configuration(localConfiguration);
      localConfiguration.uiMode = (localConfiguration.uiMode & 0xFFFFFFCF | paramInt);
      localResources.updateConfiguration(localConfiguration, null);
      return true;
    }
    return false;
  }

  public boolean applyDayNight()
  {
    this.mApplyDayNightCalled = true;
    if (this.mLocalNightMode == -100);
    for (int i = getDefaultNightMode(); ; i = this.mLocalNightMode)
    {
      i = mapNightMode(i);
      if (i == -1)
        break;
      return updateConfigurationForNightMode(i);
    }
    return false;
  }

  public boolean isHandleNativeActionModesEnabled()
  {
    return this.mHandleNativeActionModes;
  }

  int mapNightMode(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return paramInt;
    case 0:
      if (getTwilightManager().isNight())
        return 2;
      return 1;
    case -100:
    }
    return -1;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((paramBundle != null) && (this.mLocalNightMode == -100))
      this.mLocalNightMode = paramBundle.getInt("appcompat:local_night_mode", -100);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.mLocalNightMode != -100)
      paramBundle.putInt("appcompat:local_night_mode", this.mLocalNightMode);
  }

  public void setHandleNativeActionModesEnabled(boolean paramBoolean)
  {
    this.mHandleNativeActionModes = paramBoolean;
  }

  public void setLocalNightMode(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case -1:
    case 0:
    case 1:
    case 2:
    }
    do
    {
      Log.d("AppCompatDelegate", "setLocalNightMode() called with an unknown mode");
      do
        return;
      while (this.mLocalNightMode == paramInt);
      this.mLocalNightMode = paramInt;
    }
    while (!this.mApplyDayNightCalled);
    applyDayNight();
  }

  Window.Callback wrapWindowCallback(Window.Callback paramCallback)
  {
    return new AppCompatWindowCallbackV14(paramCallback);
  }

  class AppCompatWindowCallbackV14 extends AppCompatDelegateImplBase.AppCompatWindowCallbackBase
  {
    AppCompatWindowCallbackV14(Window.Callback arg2)
    {
      super(localCallback);
    }

    public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      if (AppCompatDelegateImplV14.this.isHandleNativeActionModesEnabled())
        return startAsSupportActionMode(paramCallback);
      return super.onWindowStartingActionMode(paramCallback);
    }

    final android.view.ActionMode startAsSupportActionMode(ActionMode.Callback paramCallback)
    {
      paramCallback = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImplV14.this.mContext, paramCallback);
      android.support.v7.view.ActionMode localActionMode = AppCompatDelegateImplV14.this.startSupportActionMode(paramCallback);
      if (localActionMode != null)
        return paramCallback.getActionModeWrapper(localActionMode);
      return null;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV14
 * JD-Core Version:    0.6.0
 */
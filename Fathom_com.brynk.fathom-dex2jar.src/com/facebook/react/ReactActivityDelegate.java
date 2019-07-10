package com.facebook.react;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.widget.Toast;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Callback;
import com.facebook.react.devsupport.DoubleTapReloadRecognizer;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.PermissionListener;
import javax.annotation.Nullable;

public class ReactActivityDelegate
{
  private static final String REDBOX_PERMISSION_GRANTED_MESSAGE = "Overlay permissions have been granted.";
  private static final String REDBOX_PERMISSION_MESSAGE = "Overlay permissions needs to be granted in order for react native apps to run in dev mode";
  private final int REQUEST_OVERLAY_PERMISSION_CODE = 1111;

  @Nullable
  private final Activity mActivity;

  @Nullable
  private DoubleTapReloadRecognizer mDoubleTapReloadRecognizer;

  @Nullable
  private final FragmentActivity mFragmentActivity;

  @Nullable
  private final String mMainComponentName;

  @Nullable
  private PermissionListener mPermissionListener;

  @Nullable
  private Callback mPermissionsCallback;

  @Nullable
  private ReactRootView mReactRootView;

  public ReactActivityDelegate(Activity paramActivity, @Nullable String paramString)
  {
    this.mActivity = paramActivity;
    this.mMainComponentName = paramString;
    this.mFragmentActivity = null;
  }

  public ReactActivityDelegate(FragmentActivity paramFragmentActivity, @Nullable String paramString)
  {
    this.mFragmentActivity = paramFragmentActivity;
    this.mMainComponentName = paramString;
    this.mActivity = null;
  }

  private Context getContext()
  {
    if (this.mActivity != null)
      return this.mActivity;
    return (Context)Assertions.assertNotNull(this.mFragmentActivity);
  }

  private Activity getPlainActivity()
  {
    return (Activity)getContext();
  }

  protected ReactRootView createRootView()
  {
    return new ReactRootView(getContext());
  }

  @Nullable
  protected Bundle getLaunchOptions()
  {
    return null;
  }

  public ReactInstanceManager getReactInstanceManager()
  {
    return getReactNativeHost().getReactInstanceManager();
  }

  protected ReactNativeHost getReactNativeHost()
  {
    return ((ReactApplication)getPlainActivity().getApplication()).getReactNativeHost();
  }

  protected void loadApp(String paramString)
  {
    if (this.mReactRootView != null)
      throw new IllegalStateException("Cannot loadApp while app is already running.");
    this.mReactRootView = createRootView();
    this.mReactRootView.startReactApplication(getReactNativeHost().getReactInstanceManager(), paramString, getLaunchOptions());
    getPlainActivity().setContentView(this.mReactRootView);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (getReactNativeHost().hasInstance())
      getReactNativeHost().getReactInstanceManager().onActivityResult(getPlainActivity(), paramInt1, paramInt2, paramIntent);
    do
      return;
    while ((paramInt1 != 1111) || (Build.VERSION.SDK_INT < 23) || (!Settings.canDrawOverlays(getContext())));
    if (this.mMainComponentName != null)
      loadApp(this.mMainComponentName);
    Toast.makeText(getContext(), "Overlay permissions have been granted.", 1).show();
  }

  public boolean onBackPressed()
  {
    if (getReactNativeHost().hasInstance())
    {
      getReactNativeHost().getReactInstanceManager().onBackPressed();
      return true;
    }
    return false;
  }

  protected void onCreate(Bundle paramBundle)
  {
    int j = 0;
    int i = j;
    if (getReactNativeHost().getUseDeveloperSupport())
    {
      i = j;
      if (Build.VERSION.SDK_INT >= 23)
      {
        i = j;
        if (!Settings.canDrawOverlays(getContext()))
        {
          i = 1;
          paramBundle = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getContext().getPackageName()));
          FLog.w("ReactNative", "Overlay permissions needs to be granted in order for react native apps to run in dev mode");
          Toast.makeText(getContext(), "Overlay permissions needs to be granted in order for react native apps to run in dev mode", 1).show();
          ((Activity)getContext()).startActivityForResult(paramBundle, 1111);
        }
      }
    }
    if ((this.mMainComponentName != null) && (i == 0))
      loadApp(this.mMainComponentName);
    this.mDoubleTapReloadRecognizer = new DoubleTapReloadRecognizer();
  }

  protected void onDestroy()
  {
    if (this.mReactRootView != null)
    {
      this.mReactRootView.unmountReactApplication();
      this.mReactRootView = null;
    }
    if (getReactNativeHost().hasInstance())
      getReactNativeHost().getReactInstanceManager().onHostDestroy(getPlainActivity());
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((getReactNativeHost().hasInstance()) && (getReactNativeHost().getUseDeveloperSupport()))
    {
      if (paramInt == 82)
      {
        getReactNativeHost().getReactInstanceManager().showDevOptionsDialog();
        return true;
      }
      if (((DoubleTapReloadRecognizer)Assertions.assertNotNull(this.mDoubleTapReloadRecognizer)).didDoubleTapR(paramInt, getPlainActivity().getCurrentFocus()))
      {
        getReactNativeHost().getReactInstanceManager().getDevSupportManager().handleReloadJS();
        return true;
      }
    }
    return false;
  }

  public boolean onNewIntent(Intent paramIntent)
  {
    if (getReactNativeHost().hasInstance())
    {
      getReactNativeHost().getReactInstanceManager().onNewIntent(paramIntent);
      return true;
    }
    return false;
  }

  protected void onPause()
  {
    if (getReactNativeHost().hasInstance())
      getReactNativeHost().getReactInstanceManager().onHostPause(getPlainActivity());
  }

  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.mPermissionsCallback = new Callback(paramInt, paramArrayOfString, paramArrayOfInt)
    {
      public void invoke(Object[] paramArrayOfObject)
      {
        if ((ReactActivityDelegate.this.mPermissionListener != null) && (ReactActivityDelegate.this.mPermissionListener.onRequestPermissionsResult(this.val$requestCode, this.val$permissions, this.val$grantResults)))
          ReactActivityDelegate.access$002(ReactActivityDelegate.this, null);
      }
    };
  }

  protected void onResume()
  {
    if (getReactNativeHost().hasInstance())
      getReactNativeHost().getReactInstanceManager().onHostResume(getPlainActivity(), (DefaultHardwareBackBtnHandler)getPlainActivity());
    if (this.mPermissionsCallback != null)
    {
      this.mPermissionsCallback.invoke(new Object[0]);
      this.mPermissionsCallback = null;
    }
  }

  @TargetApi(23)
  public void requestPermissions(String[] paramArrayOfString, int paramInt, PermissionListener paramPermissionListener)
  {
    this.mPermissionListener = paramPermissionListener;
    getPlainActivity().requestPermissions(paramArrayOfString, paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.ReactActivityDelegate
 * JD-Core Version:    0.6.0
 */
package com.brynk.fathom.controllers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.brynk.fathom.helpers.Constants;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;

public class ReactObserverActivity extends Activity
  implements DefaultHardwareBackBtnHandler
{
  public static int OVERLAY_PERMISSION_REQ_CODE = 1234;
  private ReactInstanceManager mReactInstanceManager;
  private ReactRootView mReactRootView;

  public void invokeDefaultOnBackPressed()
  {
    super.onBackPressed();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == OVERLAY_PERMISSION_REQ_CODE) && (Build.VERSION.SDK_INT >= 23) && (!Settings.canDrawOverlays(this)));
  }

  public void onBackPressed()
  {
    if (this.mReactInstanceManager != null)
    {
      this.mReactInstanceManager.onBackPressed();
      return;
    }
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("drone_ip", new Constants().getDroneIp(getApplicationContext()));
    this.mReactRootView = new ReactRootView(this);
    this.mReactInstanceManager = ReactInstanceManager.builder().setApplication(getApplication()).setBundleAssetName("index.android.bundle").addPackage(new MainReactPackage()).setUseDeveloperSupport(false).setInitialLifecycleState(LifecycleState.RESUMED).build();
    this.mReactRootView.startReactApplication(this.mReactInstanceManager, "HelloWorld", (Bundle)localObject);
    localObject = new FrameLayout(this);
    ((FrameLayout)localObject).setId(2131689636);
    setContentView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    if (paramBundle == null)
    {
      paramBundle = new DebugExampleThreeFragment(this.mReactRootView);
      paramBundle.setArguments(new Bundle());
      getFragmentManager().beginTransaction().add(((FrameLayout)localObject).getId(), paramBundle).commit();
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      Log.e("FATHOM", "Got this far");
      if (!Settings.canDrawOverlays(this))
      {
        paramBundle = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName()));
        Log.e("FATHOM", "Got this far 2");
        startActivityForResult(paramBundle, OVERLAY_PERMISSION_REQ_CODE);
      }
    }
    else
    {
      return;
    }
    Log.e("FATHOM", "Got this far 3");
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mReactInstanceManager != null)
      this.mReactInstanceManager.onHostDestroy();
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) && (this.mReactInstanceManager != null))
    {
      this.mReactInstanceManager.showDevOptionsDialog();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  protected void onPause()
  {
    super.onPause();
    if (this.mReactInstanceManager != null)
      this.mReactInstanceManager.onHostPause(this);
  }

  protected void onResume()
  {
    super.onResume();
    if (this.mReactInstanceManager != null)
      this.mReactInstanceManager.onHostResume(this, this);
  }

  @SuppressLint({"ValidFragment"})
  public static class DebugExampleThreeFragment extends Fragment
  {
    private ReactRootView reactRootView;

    @SuppressLint({"ValidFragment"})
    public DebugExampleThreeFragment(ReactRootView paramReactRootView)
    {
      this.reactRootView = paramReactRootView;
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      return this.reactRootView;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.brynk.fathom.controllers.ReactObserverActivity
 * JD-Core Version:    0.6.0
 */
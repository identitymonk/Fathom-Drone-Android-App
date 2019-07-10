package com.facebook.react;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import javax.annotation.Nullable;

public abstract class ReactActivity extends Activity
  implements DefaultHardwareBackBtnHandler, PermissionAwareActivity
{
  private final ReactActivityDelegate mDelegate = createReactActivityDelegate();

  protected ReactActivityDelegate createReactActivityDelegate()
  {
    return new ReactActivityDelegate(this, getMainComponentName());
  }

  @Nullable
  protected String getMainComponentName()
  {
    return null;
  }

  protected final ReactInstanceManager getReactInstanceManager()
  {
    return this.mDelegate.getReactInstanceManager();
  }

  protected final ReactNativeHost getReactNativeHost()
  {
    return this.mDelegate.getReactNativeHost();
  }

  public void invokeDefaultOnBackPressed()
  {
    super.onBackPressed();
  }

  protected final void loadApp(String paramString)
  {
    this.mDelegate.loadApp(paramString);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mDelegate.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onBackPressed()
  {
    if (!this.mDelegate.onBackPressed())
      super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mDelegate.onCreate(paramBundle);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.mDelegate.onDestroy();
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return (this.mDelegate.onKeyUp(paramInt, paramKeyEvent)) || (super.onKeyUp(paramInt, paramKeyEvent));
  }

  public void onNewIntent(Intent paramIntent)
  {
    if (!this.mDelegate.onNewIntent(paramIntent))
      super.onNewIntent(paramIntent);
  }

  protected void onPause()
  {
    super.onPause();
    this.mDelegate.onPause();
  }

  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.mDelegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }

  protected void onResume()
  {
    super.onResume();
    this.mDelegate.onResume();
  }

  public void requestPermissions(String[] paramArrayOfString, int paramInt, PermissionListener paramPermissionListener)
  {
    this.mDelegate.requestPermissions(paramArrayOfString, paramInt, paramPermissionListener);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.ReactActivity
 * JD-Core Version:    0.6.0
 */
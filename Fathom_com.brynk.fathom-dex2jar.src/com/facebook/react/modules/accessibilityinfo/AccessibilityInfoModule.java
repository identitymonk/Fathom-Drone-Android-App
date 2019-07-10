package com.facebook.react.modules.accessibilityinfo;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import javax.annotation.Nullable;

@ReactModule(name="AccessibilityInfo")
public class AccessibilityInfoModule extends ReactContextBaseJavaModule
  implements LifecycleEventListener
{
  private static final String EVENT_NAME = "touchExplorationDidChange";

  @Nullable
  private AccessibilityManager mAccessibilityManager;
  private boolean mEnabled = false;

  @Nullable
  private ReactTouchExplorationStateChangeListener mTouchExplorationStateChangeListener;

  public AccessibilityInfoModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    this.mAccessibilityManager = ((AccessibilityManager)paramReactApplicationContext.getApplicationContext().getSystemService("accessibility"));
    this.mEnabled = this.mAccessibilityManager.isTouchExplorationEnabled();
    if (Build.VERSION.SDK_INT >= 19)
      this.mTouchExplorationStateChangeListener = new ReactTouchExplorationStateChangeListener(null);
  }

  private void updateAndSendChangeEvent(boolean paramBoolean)
  {
    if (this.mEnabled != paramBoolean)
    {
      this.mEnabled = paramBoolean;
      ((DeviceEventManagerModule.RCTDeviceEventEmitter)getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("touchExplorationDidChange", Boolean.valueOf(this.mEnabled));
    }
  }

  public String getName()
  {
    return "AccessibilityInfo";
  }

  public void initialize()
  {
    getReactApplicationContext().addLifecycleEventListener(this);
    updateAndSendChangeEvent(this.mAccessibilityManager.isTouchExplorationEnabled());
  }

  @ReactMethod
  public void isTouchExplorationEnabled(Callback paramCallback)
  {
    paramCallback.invoke(new Object[] { Boolean.valueOf(this.mEnabled) });
  }

  public void onCatalystInstanceDestroy()
  {
    super.onCatalystInstanceDestroy();
    getReactApplicationContext().removeLifecycleEventListener(this);
  }

  public void onHostDestroy()
  {
  }

  public void onHostPause()
  {
    if (Build.VERSION.SDK_INT >= 19)
      this.mAccessibilityManager.removeTouchExplorationStateChangeListener(this.mTouchExplorationStateChangeListener);
  }

  public void onHostResume()
  {
    if (Build.VERSION.SDK_INT >= 19)
      this.mAccessibilityManager.addTouchExplorationStateChangeListener(this.mTouchExplorationStateChangeListener);
    updateAndSendChangeEvent(this.mAccessibilityManager.isTouchExplorationEnabled());
  }

  @TargetApi(19)
  private class ReactTouchExplorationStateChangeListener
    implements AccessibilityManager.TouchExplorationStateChangeListener
  {
    private ReactTouchExplorationStateChangeListener()
    {
    }

    public void onTouchExplorationStateChanged(boolean paramBoolean)
    {
      AccessibilityInfoModule.this.updateAndSendChangeEvent(paramBoolean);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule
 * JD-Core Version:    0.6.0
 */
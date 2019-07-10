package com.facebook.react.modules.appstate;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;

@ReactModule(name="AppState")
public class AppStateModule extends ReactContextBaseJavaModule
  implements LifecycleEventListener
{
  public static final String APP_STATE_ACTIVE = "active";
  public static final String APP_STATE_BACKGROUND = "background";
  protected static final String NAME = "AppState";
  private String mAppState = "uninitialized";

  public AppStateModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private WritableMap createAppStateEventMap()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putString("app_state", this.mAppState);
    return localWritableMap;
  }

  private void sendAppStateChangeEvent()
  {
    ((DeviceEventManagerModule.RCTDeviceEventEmitter)getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("appStateDidChange", createAppStateEventMap());
  }

  @ReactMethod
  public void getCurrentAppState(Callback paramCallback1, Callback paramCallback2)
  {
    paramCallback1.invoke(new Object[] { createAppStateEventMap() });
  }

  public String getName()
  {
    return "AppState";
  }

  public void initialize()
  {
    getReactApplicationContext().addLifecycleEventListener(this);
  }

  public void onHostDestroy()
  {
  }

  public void onHostPause()
  {
    this.mAppState = "background";
    sendAppStateChangeEvent();
  }

  public void onHostResume()
  {
    this.mAppState = "active";
    sendAppStateChangeEvent();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.appstate.AppStateModule
 * JD-Core Version:    0.6.0
 */
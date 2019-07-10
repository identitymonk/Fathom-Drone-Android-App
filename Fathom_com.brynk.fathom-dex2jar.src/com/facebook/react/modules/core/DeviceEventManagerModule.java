package com.facebook.react.modules.core;

import android.net.Uri;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import javax.annotation.Nullable;

@ReactModule(name="DeviceEventManager")
public class DeviceEventManagerModule extends ReactContextBaseJavaModule
{
  private final Runnable mInvokeDefaultBackPressRunnable;

  public DeviceEventManagerModule(ReactApplicationContext paramReactApplicationContext, DefaultHardwareBackBtnHandler paramDefaultHardwareBackBtnHandler)
  {
    super(paramReactApplicationContext);
    this.mInvokeDefaultBackPressRunnable = new Runnable(paramDefaultHardwareBackBtnHandler)
    {
      public void run()
      {
        UiThreadUtil.assertOnUiThread();
        this.val$backBtnHandler.invokeDefaultOnBackPressed();
      }
    };
  }

  public void emitHardwareBackPressed()
  {
    ((RCTDeviceEventEmitter)getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("hardwareBackPress", null);
  }

  public void emitNewIntentReceived(Uri paramUri)
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putString("url", paramUri.toString());
    ((RCTDeviceEventEmitter)getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("url", localWritableMap);
  }

  public String getName()
  {
    return "DeviceEventManager";
  }

  @ReactMethod
  public void invokeDefaultBackPressHandler()
  {
    getReactApplicationContext().runOnUiQueueThread(this.mInvokeDefaultBackPressRunnable);
  }

  public static abstract interface RCTDeviceEventEmitter extends JavaScriptModule
  {
    public abstract void emit(String paramString, @Nullable Object paramObject);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.core.DeviceEventManagerModule
 * JD-Core Version:    0.6.0
 */
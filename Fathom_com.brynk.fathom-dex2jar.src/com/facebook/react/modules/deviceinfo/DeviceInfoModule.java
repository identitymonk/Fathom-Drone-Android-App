package com.facebook.react.modules.deviceinfo;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="DeviceInfo")
public class DeviceInfoModule extends BaseJavaModule
  implements LifecycleEventListener
{
  private float mFontScale;

  @Nullable
  private ReactApplicationContext mReactApplicationContext = null;

  public DeviceInfoModule(Context paramContext)
  {
    DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(paramContext);
    this.mFontScale = paramContext.getResources().getConfiguration().fontScale;
  }

  public DeviceInfoModule(ReactApplicationContext paramReactApplicationContext)
  {
    this(paramReactApplicationContext);
    this.mReactApplicationContext = paramReactApplicationContext;
  }

  private WritableMap getDimensionsConstants()
  {
    Object localObject2 = DisplayMetricsHolder.getWindowDisplayMetrics();
    Object localObject1 = DisplayMetricsHolder.getScreenDisplayMetrics();
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putInt("width", ((DisplayMetrics)localObject2).widthPixels);
    localWritableMap.putInt("height", ((DisplayMetrics)localObject2).heightPixels);
    localWritableMap.putDouble("scale", ((DisplayMetrics)localObject2).density);
    localWritableMap.putDouble("fontScale", this.mFontScale);
    localWritableMap.putDouble("densityDpi", ((DisplayMetrics)localObject2).densityDpi);
    localObject2 = Arguments.createMap();
    ((WritableMap)localObject2).putInt("width", ((DisplayMetrics)localObject1).widthPixels);
    ((WritableMap)localObject2).putInt("height", ((DisplayMetrics)localObject1).heightPixels);
    ((WritableMap)localObject2).putDouble("scale", ((DisplayMetrics)localObject1).density);
    ((WritableMap)localObject2).putDouble("fontScale", this.mFontScale);
    ((WritableMap)localObject2).putDouble("densityDpi", ((DisplayMetrics)localObject1).densityDpi);
    localObject1 = Arguments.createMap();
    ((WritableMap)localObject1).putMap("windowPhysicalPixels", localWritableMap);
    ((WritableMap)localObject1).putMap("screenPhysicalPixels", (WritableMap)localObject2);
    return (WritableMap)(WritableMap)localObject1;
  }

  public void emitUpdateDimensionsEvent()
  {
    if (this.mReactApplicationContext == null)
      return;
    ((DeviceEventManagerModule.RCTDeviceEventEmitter)this.mReactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("didUpdateDimensions", getDimensionsConstants());
  }

  @Nullable
  public Map<String, Object> getConstants()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Dimensions", getDimensionsConstants());
    return localHashMap;
  }

  public String getName()
  {
    return "DeviceInfo";
  }

  public void onHostDestroy()
  {
  }

  public void onHostPause()
  {
  }

  public void onHostResume()
  {
    if (this.mReactApplicationContext == null);
    float f;
    do
    {
      return;
      f = this.mReactApplicationContext.getResources().getConfiguration().fontScale;
    }
    while (this.mFontScale == f);
    this.mFontScale = f;
    emitUpdateDimensionsEvent();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.deviceinfo.DeviceInfoModule
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.modules.netinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;

@ReactModule(name="NetInfo")
public class NetInfoModule extends ReactContextBaseJavaModule
  implements LifecycleEventListener
{
  private static final String CONNECTION_TYPE_BLUETOOTH = "bluetooth";
  private static final String CONNECTION_TYPE_CELLULAR = "cellular";
  private static final String CONNECTION_TYPE_ETHERNET = "ethernet";
  private static final String CONNECTION_TYPE_NONE = "none";
  private static final String CONNECTION_TYPE_NONE_DEPRECATED = "NONE";
  private static final String CONNECTION_TYPE_UNKNOWN = "unknown";
  private static final String CONNECTION_TYPE_UNKNOWN_DEPRECATED = "UNKNOWN";
  private static final String CONNECTION_TYPE_WIFI = "wifi";
  private static final String CONNECTION_TYPE_WIMAX = "wimax";
  private static final String EFFECTIVE_CONNECTION_TYPE_2G = "2g";
  private static final String EFFECTIVE_CONNECTION_TYPE_3G = "3g";
  private static final String EFFECTIVE_CONNECTION_TYPE_4G = "4g";
  private static final String EFFECTIVE_CONNECTION_TYPE_UNKNOWN = "unknown";
  private static final String ERROR_MISSING_PERMISSION = "E_MISSING_PERMISSION";
  private static final String MISSING_PERMISSION_MESSAGE = "To use NetInfo on Android, add the following to your AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />";
  private String mConnectionType = "unknown";
  private final ConnectivityBroadcastReceiver mConnectivityBroadcastReceiver;
  private String mConnectivityDeprecated = "UNKNOWN";
  private final ConnectivityManager mConnectivityManager;
  private String mEffectiveConnectionType = "unknown";
  private boolean mNoNetworkPermission = false;

  public NetInfoModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    this.mConnectivityManager = ((ConnectivityManager)paramReactApplicationContext.getSystemService("connectivity"));
    this.mConnectivityBroadcastReceiver = new ConnectivityBroadcastReceiver(null);
  }

  private WritableMap createConnectivityEventMap()
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    localWritableNativeMap.putString("network_info", this.mConnectivityDeprecated);
    localWritableNativeMap.putString("connectionType", this.mConnectionType);
    localWritableNativeMap.putString("effectiveConnectionType", this.mEffectiveConnectionType);
    return localWritableNativeMap;
  }

  private String getCurrentConnectionType()
  {
    try
    {
      NetworkInfo localNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
      {
        if (ConnectivityManager.isNetworkTypeValid(localNetworkInfo.getType()))
          return localNetworkInfo.getTypeName().toUpperCase();
        return "UNKNOWN";
      }
    }
    catch (SecurityException localSecurityException)
    {
      this.mNoNetworkPermission = true;
      return "UNKNOWN";
    }
    return "NONE";
  }

  private String getEffectiveConnectionType(NetworkInfo paramNetworkInfo)
  {
    switch (paramNetworkInfo.getSubtype())
    {
    default:
      return "unknown";
    case 1:
    case 2:
    case 4:
    case 7:
    case 11:
      return "2g";
    case 3:
    case 5:
    case 6:
    case 8:
    case 9:
    case 10:
    case 12:
    case 14:
      return "3g";
    case 13:
    case 15:
    }
    return "4g";
  }

  private void registerReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    getReactApplicationContext().registerReceiver(this.mConnectivityBroadcastReceiver, localIntentFilter);
    this.mConnectivityBroadcastReceiver.setRegistered(true);
  }

  private void sendConnectivityChangedEvent()
  {
    ((DeviceEventManagerModule.RCTDeviceEventEmitter)getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("networkStatusDidChange", createConnectivityEventMap());
  }

  private void unregisterReceiver()
  {
    if (this.mConnectivityBroadcastReceiver.isRegistered())
    {
      getReactApplicationContext().unregisterReceiver(this.mConnectivityBroadcastReceiver);
      this.mConnectivityBroadcastReceiver.setRegistered(false);
    }
  }

  private void updateAndSendConnectionType()
  {
    Object localObject1 = "unknown";
    try
    {
      Object localObject2 = this.mConnectivityManager.getActiveNetworkInfo();
      String str1;
      if ((localObject2 == null) || (!((NetworkInfo)localObject2).isConnected()))
        str1 = "none";
      while (true)
      {
        localObject2 = getCurrentConnectionType();
        if ((!str1.equalsIgnoreCase(this.mConnectionType)) || (!((String)localObject1).equalsIgnoreCase(this.mEffectiveConnectionType)) || (!((String)localObject2).equalsIgnoreCase(this.mConnectivityDeprecated)))
        {
          this.mConnectionType = str1;
          this.mEffectiveConnectionType = ((String)localObject1);
          this.mConnectivityDeprecated = ((String)localObject2);
          sendConnectivityChangedEvent();
        }
        return;
        switch (((NetworkInfo)localObject2).getType())
        {
        case 0:
        case 4:
          str1 = "cellular";
          localObject2 = getEffectiveConnectionType((NetworkInfo)localObject2);
          localObject1 = localObject2;
          break;
        case 6:
          str1 = "wimax";
        case 2:
        case 3:
        case 5:
        case 8:
        default:
        case 7:
        case 9:
        case 1:
        }
      }
    }
    catch (SecurityException str2)
    {
      while (true)
      {
        this.mNoNetworkPermission = true;
        String str2 = "unknown";
        continue;
        str2 = "unknown";
        continue;
        str2 = "bluetooth";
        continue;
        str2 = "ethernet";
        continue;
        str2 = "wifi";
      }
    }
  }

  @ReactMethod
  public void getCurrentConnectivity(Promise paramPromise)
  {
    if (this.mNoNetworkPermission)
    {
      paramPromise.reject("E_MISSING_PERMISSION", "To use NetInfo on Android, add the following to your AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />", null);
      return;
    }
    paramPromise.resolve(createConnectivityEventMap());
  }

  public String getName()
  {
    return "NetInfo";
  }

  public void initialize()
  {
    getReactApplicationContext().addLifecycleEventListener(this);
  }

  @ReactMethod
  public void isConnectionMetered(Promise paramPromise)
  {
    if (this.mNoNetworkPermission)
    {
      paramPromise.reject("E_MISSING_PERMISSION", "To use NetInfo on Android, add the following to your AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />", null);
      return;
    }
    paramPromise.resolve(Boolean.valueOf(ConnectivityManagerCompat.isActiveNetworkMetered(this.mConnectivityManager)));
  }

  public void onHostDestroy()
  {
  }

  public void onHostPause()
  {
    unregisterReceiver();
  }

  public void onHostResume()
  {
    registerReceiver();
  }

  private class ConnectivityBroadcastReceiver extends BroadcastReceiver
  {
    private boolean isRegistered = false;

    private ConnectivityBroadcastReceiver()
    {
    }

    public boolean isRegistered()
    {
      return this.isRegistered;
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        NetInfoModule.this.updateAndSendConnectionType();
    }

    public void setRegistered(boolean paramBoolean)
    {
      this.isRegistered = paramBoolean;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.netinfo.NetInfoModule
 * JD-Core Version:    0.6.0
 */
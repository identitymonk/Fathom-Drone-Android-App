package com.facebook.react.modules.location;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.SystemClock;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import javax.annotation.Nullable;

@ReactModule(name="LocationObserver")
public class LocationModule extends ReactContextBaseJavaModule
{
  private static final float RCT_DEFAULT_LOCATION_ACCURACY = 100.0F;
  private final LocationListener mLocationListener = new LocationListener()
  {
    public void onLocationChanged(Location paramLocation)
    {
      ((DeviceEventManagerModule.RCTDeviceEventEmitter)LocationModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("geolocationDidChange", LocationModule.access$000(paramLocation));
    }

    public void onProviderDisabled(String paramString)
    {
    }

    public void onProviderEnabled(String paramString)
    {
    }

    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
    {
      if (paramInt == 0)
        LocationModule.this.emitError(PositionError.POSITION_UNAVAILABLE, "Provider " + paramString + " is out of service.");
      do
        return;
      while (paramInt != 1);
      LocationModule.this.emitError(PositionError.TIMEOUT, "Provider " + paramString + " is temporarily unavailable.");
    }
  };

  @Nullable
  private String mWatchedProvider;

  public LocationModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private void emitError(int paramInt, String paramString)
  {
    ((DeviceEventManagerModule.RCTDeviceEventEmitter)getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("geolocationError", PositionError.buildError(paramInt, paramString));
  }

  @Nullable
  private static String getValidProvider(LocationManager paramLocationManager, boolean paramBoolean)
  {
    String str2;
    if (paramBoolean)
    {
      str1 = "gps";
      str2 = str1;
      if (paramLocationManager.isProviderEnabled(str1))
        break label53;
      if (!str1.equals("gps"))
        break label47;
    }
    label47: for (String str1 = "network"; ; str1 = "gps")
    {
      str2 = str1;
      if (paramLocationManager.isProviderEnabled(str1))
        break label53;
      return null;
      str1 = "network";
      break;
    }
    label53: return str2;
  }

  private static WritableMap locationToMap(Location paramLocation)
  {
    WritableMap localWritableMap1 = Arguments.createMap();
    WritableMap localWritableMap2 = Arguments.createMap();
    localWritableMap2.putDouble("latitude", paramLocation.getLatitude());
    localWritableMap2.putDouble("longitude", paramLocation.getLongitude());
    localWritableMap2.putDouble("altitude", paramLocation.getAltitude());
    localWritableMap2.putDouble("accuracy", paramLocation.getAccuracy());
    localWritableMap2.putDouble("heading", paramLocation.getBearing());
    localWritableMap2.putDouble("speed", paramLocation.getSpeed());
    localWritableMap1.putMap("coords", localWritableMap2);
    localWritableMap1.putDouble("timestamp", paramLocation.getTime());
    if (Build.VERSION.SDK_INT >= 18)
      localWritableMap1.putBoolean("mocked", paramLocation.isFromMockProvider());
    return localWritableMap1;
  }

  private static void throwLocationPermissionMissing(SecurityException paramSecurityException)
  {
    throw new SecurityException("Looks like the app doesn't have the permission to access location.\nAdd the following line to your app's AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_FINE_LOCATION\" />", paramSecurityException);
  }

  @ReactMethod
  public void getCurrentPosition(ReadableMap paramReadableMap, Callback paramCallback1, Callback paramCallback2)
  {
    paramReadableMap = LocationOptions.access$300(paramReadableMap);
    LocationManager localLocationManager;
    String str;
    Location localLocation;
    try
    {
      localLocationManager = (LocationManager)getReactApplicationContext().getSystemService("location");
      str = getValidProvider(localLocationManager, paramReadableMap.highAccuracy);
      if (str == null)
      {
        paramCallback2.invoke(new Object[] { PositionError.buildError(PositionError.PERMISSION_DENIED, "No location provider available.") });
        return;
      }
      localLocation = localLocationManager.getLastKnownLocation(str);
      if ((localLocation != null) && (SystemClock.currentTimeMillis() - localLocation.getTime() < paramReadableMap.maximumAge))
      {
        paramCallback1.invoke(new Object[] { locationToMap(localLocation) });
        return;
      }
    }
    catch (SecurityException paramReadableMap)
    {
      throwLocationPermissionMissing(paramReadableMap);
      return;
    }
    new SingleUpdateRequest(localLocationManager, str, paramReadableMap.timeout, paramCallback1, paramCallback2, null).invoke(localLocation);
  }

  public String getName()
  {
    return "LocationObserver";
  }

  @ReactMethod
  public void startObserving(ReadableMap paramReadableMap)
  {
    if ("gps".equals(this.mWatchedProvider))
      return;
    paramReadableMap = LocationOptions.access$300(paramReadableMap);
    LocationManager localLocationManager;
    String str;
    try
    {
      localLocationManager = (LocationManager)getReactApplicationContext().getSystemService("location");
      str = getValidProvider(localLocationManager, paramReadableMap.highAccuracy);
      if (str == null)
      {
        emitError(PositionError.PERMISSION_DENIED, "No location provider available.");
        return;
      }
    }
    catch (SecurityException paramReadableMap)
    {
      throwLocationPermissionMissing(paramReadableMap);
      return;
    }
    if (!str.equals(this.mWatchedProvider))
    {
      localLocationManager.removeUpdates(this.mLocationListener);
      localLocationManager.requestLocationUpdates(str, 1000L, paramReadableMap.distanceFilter, this.mLocationListener);
    }
    this.mWatchedProvider = str;
  }

  @ReactMethod
  public void stopObserving()
  {
    ((LocationManager)getReactApplicationContext().getSystemService("location")).removeUpdates(this.mLocationListener);
    this.mWatchedProvider = null;
  }

  private static class LocationOptions
  {
    private final float distanceFilter;
    private final boolean highAccuracy;
    private final double maximumAge;
    private final long timeout;

    private LocationOptions(long paramLong, double paramDouble, boolean paramBoolean, float paramFloat)
    {
      this.timeout = paramLong;
      this.maximumAge = paramDouble;
      this.highAccuracy = paramBoolean;
      this.distanceFilter = paramFloat;
    }

    private static LocationOptions fromReactMap(ReadableMap paramReadableMap)
    {
      long l;
      double d;
      label42: boolean bool;
      label67: float f;
      if (paramReadableMap.hasKey("timeout"))
      {
        l = ()paramReadableMap.getDouble("timeout");
        if (!paramReadableMap.hasKey("maximumAge"))
          break label110;
        d = paramReadableMap.getDouble("maximumAge");
        if ((!paramReadableMap.hasKey("enableHighAccuracy")) || (!paramReadableMap.getBoolean("enableHighAccuracy")))
          break label117;
        bool = true;
        if (!paramReadableMap.hasKey("distanceFilter"))
          break label123;
        f = (float)paramReadableMap.getDouble("distanceFilter");
      }
      while (true)
      {
        return new LocationOptions(l, d, bool, f);
        l = 9223372036854775807L;
        break;
        label110: d = (1.0D / 0.0D);
        break label42;
        label117: bool = false;
        break label67;
        label123: f = 100.0F;
      }
    }
  }

  private static class SingleUpdateRequest
  {
    private static final int TWO_MINUTES = 120000;
    private final Callback mError;
    private final Handler mHandler = new Handler();
    private final LocationListener mLocationListener = new LocationListener()
    {
      public void onLocationChanged(Location paramLocation)
      {
        synchronized (LocationModule.SingleUpdateRequest.this)
        {
          if ((!LocationModule.SingleUpdateRequest.this.mTriggered) && (LocationModule.SingleUpdateRequest.this.isBetterLocation(paramLocation, LocationModule.SingleUpdateRequest.this.mOldLocation)))
          {
            LocationModule.SingleUpdateRequest.this.mSuccess.invoke(new Object[] { LocationModule.access$000(paramLocation) });
            LocationModule.SingleUpdateRequest.this.mHandler.removeCallbacks(LocationModule.SingleUpdateRequest.this.mTimeoutRunnable);
            LocationModule.SingleUpdateRequest.access$902(LocationModule.SingleUpdateRequest.this, true);
            LocationModule.SingleUpdateRequest.this.mLocationManager.removeUpdates(LocationModule.SingleUpdateRequest.this.mLocationListener);
          }
          LocationModule.SingleUpdateRequest.access$1302(LocationModule.SingleUpdateRequest.this, paramLocation);
          return;
        }
      }

      public void onProviderDisabled(String paramString)
      {
      }

      public void onProviderEnabled(String paramString)
      {
      }

      public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
      {
      }
    };
    private final LocationManager mLocationManager;
    private Location mOldLocation;
    private final String mProvider;
    private final Callback mSuccess;
    private final long mTimeout;
    private final Runnable mTimeoutRunnable = new Runnable()
    {
      public void run()
      {
        synchronized (LocationModule.SingleUpdateRequest.this)
        {
          if (!LocationModule.SingleUpdateRequest.this.mTriggered)
          {
            LocationModule.SingleUpdateRequest.this.mError.invoke(new Object[] { PositionError.buildError(PositionError.TIMEOUT, "Location request timed out") });
            LocationModule.SingleUpdateRequest.this.mLocationManager.removeUpdates(LocationModule.SingleUpdateRequest.this.mLocationListener);
            FLog.i("ReactNative", "LocationModule: Location request timed out");
            LocationModule.SingleUpdateRequest.access$902(LocationModule.SingleUpdateRequest.this, true);
          }
          return;
        }
      }
    };
    private boolean mTriggered;

    private SingleUpdateRequest(LocationManager paramLocationManager, String paramString, long paramLong, Callback paramCallback1, Callback paramCallback2)
    {
      this.mLocationManager = paramLocationManager;
      this.mProvider = paramString;
      this.mTimeout = paramLong;
      this.mSuccess = paramCallback1;
      this.mError = paramCallback2;
    }

    private boolean isBetterLocation(Location paramLocation1, Location paramLocation2)
    {
      if (paramLocation2 == null)
        return true;
      long l = paramLocation1.getTime() - paramLocation2.getTime();
      int j;
      int k;
      if (l > 120000L)
      {
        j = 1;
        if (l >= -120000L)
          break label63;
        k = 1;
        label41: if (l <= 0L)
          break label69;
      }
      label63: label69: for (int i = 1; ; i = 0)
      {
        if (j == 0)
          break label74;
        return true;
        j = 0;
        break;
        k = 0;
        break label41;
      }
      label74: if (k != 0)
        return false;
      int m = (int)(paramLocation1.getAccuracy() - paramLocation2.getAccuracy());
      if (m > 0)
      {
        j = 1;
        if (m >= 0)
          break label147;
        k = 1;
        label109: if (m <= 200)
          break label153;
      }
      boolean bool;
      label147: label153: for (m = 1; ; m = 0)
      {
        bool = isSameProvider(paramLocation1.getProvider(), paramLocation2.getProvider());
        if (k == 0)
          break label159;
        return true;
        j = 0;
        break;
        k = 0;
        break label109;
      }
      label159: if ((i != 0) && (j == 0))
        return true;
      return (i != 0) && (m == 0) && (bool);
    }

    private boolean isSameProvider(String paramString1, String paramString2)
    {
      if (paramString1 == null)
        return paramString2 == null;
      return paramString1.equals(paramString2);
    }

    public void invoke(Location paramLocation)
    {
      this.mOldLocation = paramLocation;
      this.mLocationManager.requestLocationUpdates(this.mProvider, 100L, 1.0F, this.mLocationListener);
      this.mHandler.postDelayed(this.mTimeoutRunnable, this.mTimeout);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.location.LocationModule
 * JD-Core Version:    0.6.0
 */
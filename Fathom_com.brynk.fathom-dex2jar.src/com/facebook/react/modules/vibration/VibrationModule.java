package com.facebook.react.modules.vibration;

import android.os.Vibrator;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name="Vibration")
public class VibrationModule extends ReactContextBaseJavaModule
{
  public VibrationModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  @ReactMethod
  public void cancel()
  {
    Vibrator localVibrator = (Vibrator)getReactApplicationContext().getSystemService("vibrator");
    if (localVibrator != null)
      localVibrator.cancel();
  }

  public String getName()
  {
    return "Vibration";
  }

  @ReactMethod
  public void vibrate(int paramInt)
  {
    Vibrator localVibrator = (Vibrator)getReactApplicationContext().getSystemService("vibrator");
    if (localVibrator != null)
      localVibrator.vibrate(paramInt);
  }

  @ReactMethod
  public void vibrateByPattern(ReadableArray paramReadableArray, int paramInt)
  {
    long[] arrayOfLong = new long[paramReadableArray.size()];
    int i = 0;
    while (i < paramReadableArray.size())
    {
      arrayOfLong[i] = paramReadableArray.getInt(i);
      i += 1;
    }
    paramReadableArray = (Vibrator)getReactApplicationContext().getSystemService("vibrator");
    if (paramReadableArray != null)
      paramReadableArray.vibrate(arrayOfLong, paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.vibration.VibrationModule
 * JD-Core Version:    0.6.0
 */
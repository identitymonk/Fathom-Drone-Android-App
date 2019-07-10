package com.facebook.react.modules.timepicker;

import android.app.Activity;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TimePicker;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import javax.annotation.Nullable;

@ReactModule(name="TimePickerAndroid")
public class TimePickerDialogModule extends ReactContextBaseJavaModule
{
  static final String ACTION_DISMISSED = "dismissedAction";
  static final String ACTION_TIME_SET = "timeSetAction";
  static final String ARG_HOUR = "hour";
  static final String ARG_IS24HOUR = "is24Hour";
  static final String ARG_MINUTE = "minute";
  static final String ARG_MODE = "mode";
  private static final String ERROR_NO_ACTIVITY = "E_NO_ACTIVITY";

  @VisibleForTesting
  public static final String FRAGMENT_TAG = "TimePickerAndroid";

  public TimePickerDialogModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private Bundle createFragmentArguments(ReadableMap paramReadableMap)
  {
    Bundle localBundle = new Bundle();
    if ((paramReadableMap.hasKey("hour")) && (!paramReadableMap.isNull("hour")))
      localBundle.putInt("hour", paramReadableMap.getInt("hour"));
    if ((paramReadableMap.hasKey("minute")) && (!paramReadableMap.isNull("minute")))
      localBundle.putInt("minute", paramReadableMap.getInt("minute"));
    if ((paramReadableMap.hasKey("is24Hour")) && (!paramReadableMap.isNull("is24Hour")))
      localBundle.putBoolean("is24Hour", paramReadableMap.getBoolean("is24Hour"));
    if ((paramReadableMap.hasKey("mode")) && (!paramReadableMap.isNull("mode")))
      localBundle.putString("mode", paramReadableMap.getString("mode"));
    return localBundle;
  }

  public String getName()
  {
    return "TimePickerAndroid";
  }

  @ReactMethod
  public void open(@Nullable ReadableMap paramReadableMap, Promise paramPromise)
  {
    Object localObject1 = getCurrentActivity();
    if (localObject1 == null)
    {
      paramPromise.reject("E_NO_ACTIVITY", "Tried to open a TimePicker dialog while not attached to an Activity");
      return;
    }
    if ((localObject1 instanceof FragmentActivity))
    {
      localObject1 = ((FragmentActivity)localObject1).getSupportFragmentManager();
      localObject2 = (android.support.v4.app.DialogFragment)((android.support.v4.app.FragmentManager)localObject1).findFragmentByTag("TimePickerAndroid");
      if (localObject2 != null)
        ((android.support.v4.app.DialogFragment)localObject2).dismiss();
      localObject2 = new SupportTimePickerDialogFragment();
      if (paramReadableMap != null)
        ((SupportTimePickerDialogFragment)localObject2).setArguments(createFragmentArguments(paramReadableMap));
      paramReadableMap = new TimePickerDialogListener(paramPromise);
      ((SupportTimePickerDialogFragment)localObject2).setOnDismissListener(paramReadableMap);
      ((SupportTimePickerDialogFragment)localObject2).setOnTimeSetListener(paramReadableMap);
      ((SupportTimePickerDialogFragment)localObject2).show((android.support.v4.app.FragmentManager)localObject1, "TimePickerAndroid");
      return;
    }
    localObject1 = ((Activity)localObject1).getFragmentManager();
    Object localObject2 = (android.app.DialogFragment)((android.app.FragmentManager)localObject1).findFragmentByTag("TimePickerAndroid");
    if (localObject2 != null)
      ((android.app.DialogFragment)localObject2).dismiss();
    localObject2 = new TimePickerDialogFragment();
    if (paramReadableMap != null)
      ((TimePickerDialogFragment)localObject2).setArguments(createFragmentArguments(paramReadableMap));
    paramReadableMap = new TimePickerDialogListener(paramPromise);
    ((TimePickerDialogFragment)localObject2).setOnDismissListener(paramReadableMap);
    ((TimePickerDialogFragment)localObject2).setOnTimeSetListener(paramReadableMap);
    ((TimePickerDialogFragment)localObject2).show((android.app.FragmentManager)localObject1, "TimePickerAndroid");
  }

  private class TimePickerDialogListener
    implements TimePickerDialog.OnTimeSetListener, DialogInterface.OnDismissListener
  {
    private final Promise mPromise;
    private boolean mPromiseResolved = false;

    public TimePickerDialogListener(Promise arg2)
    {
      Object localObject;
      this.mPromise = localObject;
    }

    public void onDismiss(DialogInterface paramDialogInterface)
    {
      if ((!this.mPromiseResolved) && (TimePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()))
      {
        paramDialogInterface = new WritableNativeMap();
        paramDialogInterface.putString("action", "dismissedAction");
        this.mPromise.resolve(paramDialogInterface);
        this.mPromiseResolved = true;
      }
    }

    public void onTimeSet(TimePicker paramTimePicker, int paramInt1, int paramInt2)
    {
      if ((!this.mPromiseResolved) && (TimePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()))
      {
        paramTimePicker = new WritableNativeMap();
        paramTimePicker.putString("action", "timeSetAction");
        paramTimePicker.putInt("hour", paramInt1);
        paramTimePicker.putInt("minute", paramInt2);
        this.mPromise.resolve(paramTimePicker);
        this.mPromiseResolved = true;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.timepicker.TimePickerDialogModule
 * JD-Core Version:    0.6.0
 */
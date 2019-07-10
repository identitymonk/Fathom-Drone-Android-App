package com.facebook.react.modules.datepicker;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.DatePicker;
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

@ReactModule(name="DatePickerAndroid")
public class DatePickerDialogModule extends ReactContextBaseJavaModule
{
  static final String ACTION_DATE_SET = "dateSetAction";
  static final String ACTION_DISMISSED = "dismissedAction";
  static final String ARG_DATE = "date";
  static final String ARG_MAXDATE = "maxDate";
  static final String ARG_MINDATE = "minDate";
  static final String ARG_MODE = "mode";
  private static final String ERROR_NO_ACTIVITY = "E_NO_ACTIVITY";

  @VisibleForTesting
  public static final String FRAGMENT_TAG = "DatePickerAndroid";

  public DatePickerDialogModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private Bundle createFragmentArguments(ReadableMap paramReadableMap)
  {
    Bundle localBundle = new Bundle();
    if ((paramReadableMap.hasKey("date")) && (!paramReadableMap.isNull("date")))
      localBundle.putLong("date", ()paramReadableMap.getDouble("date"));
    if ((paramReadableMap.hasKey("minDate")) && (!paramReadableMap.isNull("minDate")))
      localBundle.putLong("minDate", ()paramReadableMap.getDouble("minDate"));
    if ((paramReadableMap.hasKey("maxDate")) && (!paramReadableMap.isNull("maxDate")))
      localBundle.putLong("maxDate", ()paramReadableMap.getDouble("maxDate"));
    if ((paramReadableMap.hasKey("mode")) && (!paramReadableMap.isNull("mode")))
      localBundle.putString("mode", paramReadableMap.getString("mode"));
    return localBundle;
  }

  public String getName()
  {
    return "DatePickerAndroid";
  }

  @ReactMethod
  public void open(@Nullable ReadableMap paramReadableMap, Promise paramPromise)
  {
    Object localObject1 = getCurrentActivity();
    if (localObject1 == null)
    {
      paramPromise.reject("E_NO_ACTIVITY", "Tried to open a DatePicker dialog while not attached to an Activity");
      return;
    }
    if ((localObject1 instanceof FragmentActivity))
    {
      localObject1 = ((FragmentActivity)localObject1).getSupportFragmentManager();
      localObject2 = (android.support.v4.app.DialogFragment)((android.support.v4.app.FragmentManager)localObject1).findFragmentByTag("DatePickerAndroid");
      if (localObject2 != null)
        ((android.support.v4.app.DialogFragment)localObject2).dismiss();
      localObject2 = new SupportDatePickerDialogFragment();
      if (paramReadableMap != null)
        ((SupportDatePickerDialogFragment)localObject2).setArguments(createFragmentArguments(paramReadableMap));
      paramReadableMap = new DatePickerDialogListener(paramPromise);
      ((SupportDatePickerDialogFragment)localObject2).setOnDismissListener(paramReadableMap);
      ((SupportDatePickerDialogFragment)localObject2).setOnDateSetListener(paramReadableMap);
      ((SupportDatePickerDialogFragment)localObject2).show((android.support.v4.app.FragmentManager)localObject1, "DatePickerAndroid");
      return;
    }
    localObject1 = ((Activity)localObject1).getFragmentManager();
    Object localObject2 = (android.app.DialogFragment)((android.app.FragmentManager)localObject1).findFragmentByTag("DatePickerAndroid");
    if (localObject2 != null)
      ((android.app.DialogFragment)localObject2).dismiss();
    localObject2 = new DatePickerDialogFragment();
    if (paramReadableMap != null)
      ((DatePickerDialogFragment)localObject2).setArguments(createFragmentArguments(paramReadableMap));
    paramReadableMap = new DatePickerDialogListener(paramPromise);
    ((DatePickerDialogFragment)localObject2).setOnDismissListener(paramReadableMap);
    ((DatePickerDialogFragment)localObject2).setOnDateSetListener(paramReadableMap);
    ((DatePickerDialogFragment)localObject2).show((android.app.FragmentManager)localObject1, "DatePickerAndroid");
  }

  private class DatePickerDialogListener
    implements DatePickerDialog.OnDateSetListener, DialogInterface.OnDismissListener
  {
    private final Promise mPromise;
    private boolean mPromiseResolved = false;

    public DatePickerDialogListener(Promise arg2)
    {
      Object localObject;
      this.mPromise = localObject;
    }

    public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((!this.mPromiseResolved) && (DatePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()))
      {
        paramDatePicker = new WritableNativeMap();
        paramDatePicker.putString("action", "dateSetAction");
        paramDatePicker.putInt("year", paramInt1);
        paramDatePicker.putInt("month", paramInt2);
        paramDatePicker.putInt("day", paramInt3);
        this.mPromise.resolve(paramDatePicker);
        this.mPromiseResolved = true;
      }
    }

    public void onDismiss(DialogInterface paramDialogInterface)
    {
      if ((!this.mPromiseResolved) && (DatePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()))
      {
        paramDialogInterface = new WritableNativeMap();
        paramDialogInterface.putString("action", "dismissedAction");
        this.mPromise.resolve(paramDialogInterface);
        this.mPromiseResolved = true;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.datepicker.DatePickerDialogModule
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.modules.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="DialogManagerAndroid")
public class DialogModule extends ReactContextBaseJavaModule
  implements LifecycleEventListener
{
  static final String ACTION_BUTTON_CLICKED = "buttonClicked";
  static final String ACTION_DISMISSED = "dismissed";
  static final Map<String, Object> CONSTANTS = MapBuilder.of("buttonClicked", "buttonClicked", "dismissed", "dismissed", "buttonPositive", Integer.valueOf(-1), "buttonNegative", Integer.valueOf(-2), "buttonNeutral", Integer.valueOf(-3));
  static final String FRAGMENT_TAG = "com.facebook.catalyst.react.dialog.DialogModule";
  static final String KEY_BUTTON_NEGATIVE = "buttonNegative";
  static final String KEY_BUTTON_NEUTRAL = "buttonNeutral";
  static final String KEY_BUTTON_POSITIVE = "buttonPositive";
  static final String KEY_CANCELABLE = "cancelable";
  static final String KEY_ITEMS = "items";
  static final String KEY_MESSAGE = "message";
  static final String KEY_TITLE = "title";
  static final String NAME = "DialogManagerAndroid";
  private boolean mIsInForeground;

  public DialogModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  @Nullable
  private FragmentManagerHelper getFragmentManagerHelper()
  {
    Activity localActivity = getCurrentActivity();
    if (localActivity == null)
      return null;
    if ((localActivity instanceof FragmentActivity))
      return new FragmentManagerHelper(((FragmentActivity)localActivity).getSupportFragmentManager());
    return new FragmentManagerHelper(localActivity.getFragmentManager());
  }

  public Map<String, Object> getConstants()
  {
    return CONSTANTS;
  }

  public String getName()
  {
    return "DialogManagerAndroid";
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
    this.mIsInForeground = false;
  }

  public void onHostResume()
  {
    this.mIsInForeground = true;
    FragmentManagerHelper localFragmentManagerHelper = getFragmentManagerHelper();
    if (localFragmentManagerHelper != null)
    {
      localFragmentManagerHelper.showPendingAlert();
      return;
    }
    FLog.w(DialogModule.class, "onHostResume called but no FragmentManager found");
  }

  @ReactMethod
  public void showAlert(ReadableMap paramReadableMap, Callback paramCallback1, Callback paramCallback2)
  {
    FragmentManagerHelper localFragmentManagerHelper = getFragmentManagerHelper();
    if (localFragmentManagerHelper == null)
    {
      paramCallback1.invoke(new Object[] { "Tried to show an alert while not attached to an Activity" });
      return;
    }
    paramCallback1 = new Bundle();
    if (paramReadableMap.hasKey("title"))
      paramCallback1.putString("title", paramReadableMap.getString("title"));
    if (paramReadableMap.hasKey("message"))
      paramCallback1.putString("message", paramReadableMap.getString("message"));
    if (paramReadableMap.hasKey("buttonPositive"))
      paramCallback1.putString("button_positive", paramReadableMap.getString("buttonPositive"));
    if (paramReadableMap.hasKey("buttonNegative"))
      paramCallback1.putString("button_negative", paramReadableMap.getString("buttonNegative"));
    if (paramReadableMap.hasKey("buttonNeutral"))
      paramCallback1.putString("button_neutral", paramReadableMap.getString("buttonNeutral"));
    if (paramReadableMap.hasKey("items"))
    {
      ReadableArray localReadableArray = paramReadableMap.getArray("items");
      CharSequence[] arrayOfCharSequence = new CharSequence[localReadableArray.size()];
      int i = 0;
      while (i < localReadableArray.size())
      {
        arrayOfCharSequence[i] = localReadableArray.getString(i);
        i += 1;
      }
      paramCallback1.putCharSequenceArray("items", arrayOfCharSequence);
    }
    if (paramReadableMap.hasKey("cancelable"))
      paramCallback1.putBoolean("cancelable", paramReadableMap.getBoolean("cancelable"));
    localFragmentManagerHelper.showNewAlert(this.mIsInForeground, paramCallback1, paramCallback2);
  }

  class AlertFragmentListener
    implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener
  {
    private final Callback mCallback;
    private boolean mCallbackConsumed = false;

    public AlertFragmentListener(Callback arg2)
    {
      Object localObject;
      this.mCallback = localObject;
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      if ((!this.mCallbackConsumed) && (DialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()))
      {
        this.mCallback.invoke(new Object[] { "buttonClicked", Integer.valueOf(paramInt) });
        this.mCallbackConsumed = true;
      }
    }

    public void onDismiss(DialogInterface paramDialogInterface)
    {
      if ((!this.mCallbackConsumed) && (DialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()))
      {
        this.mCallback.invoke(new Object[] { "dismissed" });
        this.mCallbackConsumed = true;
      }
    }
  }

  private class FragmentManagerHelper
  {

    @Nullable
    private final android.app.FragmentManager mFragmentManager;

    @Nullable
    private Object mFragmentToShow;

    @Nullable
    private final android.support.v4.app.FragmentManager mSupportFragmentManager;

    public FragmentManagerHelper(android.app.FragmentManager arg2)
    {
      Object localObject;
      this.mFragmentManager = localObject;
      this.mSupportFragmentManager = null;
    }

    public FragmentManagerHelper(android.support.v4.app.FragmentManager arg2)
    {
      this.mFragmentManager = null;
      Object localObject;
      this.mSupportFragmentManager = localObject;
    }

    private void dismissExisting()
    {
      Object localObject;
      if (isUsingSupportLibrary())
      {
        localObject = (SupportAlertFragment)this.mSupportFragmentManager.findFragmentByTag("com.facebook.catalyst.react.dialog.DialogModule");
        if (localObject != null)
          ((SupportAlertFragment)localObject).dismiss();
      }
      do
      {
        return;
        localObject = (AlertFragment)this.mFragmentManager.findFragmentByTag("com.facebook.catalyst.react.dialog.DialogModule");
      }
      while (localObject == null);
      ((AlertFragment)localObject).dismiss();
    }

    private boolean isUsingSupportLibrary()
    {
      return this.mSupportFragmentManager != null;
    }

    public void showNewAlert(boolean paramBoolean, Bundle paramBundle, Callback paramCallback)
    {
      dismissExisting();
      if (paramCallback != null)
        paramCallback = new DialogModule.AlertFragmentListener(DialogModule.this, paramCallback);
      while (isUsingSupportLibrary())
      {
        paramCallback = new SupportAlertFragment(paramCallback, paramBundle);
        if (paramBoolean)
        {
          if (paramBundle.containsKey("cancelable"))
            paramCallback.setCancelable(paramBundle.getBoolean("cancelable"));
          paramCallback.show(this.mSupportFragmentManager, "com.facebook.catalyst.react.dialog.DialogModule");
          return;
          paramCallback = null;
          continue;
        }
        this.mFragmentToShow = paramCallback;
        return;
      }
      paramCallback = new AlertFragment(paramCallback, paramBundle);
      if (paramBoolean)
      {
        if (paramBundle.containsKey("cancelable"))
          paramCallback.setCancelable(paramBundle.getBoolean("cancelable"));
        paramCallback.show(this.mFragmentManager, "com.facebook.catalyst.react.dialog.DialogModule");
        return;
      }
      this.mFragmentToShow = paramCallback;
    }

    public void showPendingAlert()
    {
      if (this.mFragmentToShow == null)
        return;
      if (isUsingSupportLibrary())
        ((SupportAlertFragment)this.mFragmentToShow).show(this.mSupportFragmentManager, "com.facebook.catalyst.react.dialog.DialogModule");
      while (true)
      {
        this.mFragmentToShow = null;
        return;
        ((AlertFragment)this.mFragmentToShow).show(this.mFragmentManager, "com.facebook.catalyst.react.dialog.DialogModule");
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.dialog.DialogModule
 * JD-Core Version:    0.6.0
 */
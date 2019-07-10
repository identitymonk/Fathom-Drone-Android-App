package com.facebook.react.modules.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name="IntentAndroid")
public class IntentModule extends ReactContextBaseJavaModule
{
  public IntentModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  @ReactMethod
  public void canOpenURL(String paramString, Promise paramPromise)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramPromise.reject(new JSApplicationIllegalArgumentException("Invalid URL: " + paramString));
      return;
    }
    while (true)
    {
      try
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        localIntent.addFlags(268435456);
        if (localIntent.resolveActivity(getReactApplicationContext().getPackageManager()) != null)
        {
          bool = true;
          paramPromise.resolve(Boolean.valueOf(bool));
          return;
        }
      }
      catch (Exception localException)
      {
        paramPromise.reject(new JSApplicationIllegalArgumentException("Could not check if URL '" + paramString + "' can be opened: " + localException.getMessage()));
        return;
      }
      boolean bool = false;
    }
  }

  @ReactMethod
  public void getInitialURL(Promise paramPromise)
  {
    try
    {
      Object localObject3 = getCurrentActivity();
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = ((Activity)localObject3).getIntent();
        localObject3 = ((Intent)localObject1).getAction();
        Uri localUri = ((Intent)localObject1).getData();
        localObject1 = localObject2;
        if ("android.intent.action.VIEW".equals(localObject3))
        {
          localObject1 = localObject2;
          if (localUri != null)
            localObject1 = localUri.toString();
        }
      }
      paramPromise.resolve(localObject1);
      return;
    }
    catch (Exception localException)
    {
      paramPromise.reject(new JSApplicationIllegalArgumentException("Could not get the initial URL : " + localException.getMessage()));
    }
  }

  public String getName()
  {
    return "IntentAndroid";
  }

  @ReactMethod
  public void openURL(String paramString, Promise paramPromise)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramPromise.reject(new JSApplicationIllegalArgumentException("Invalid URL: " + paramString));
      return;
    }
    while (true)
    {
      Intent localIntent;
      try
      {
        Activity localActivity = getCurrentActivity();
        localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        String str2 = getReactApplicationContext().getPackageName();
        Object localObject = localIntent.resolveActivity(getReactApplicationContext().getPackageManager());
        if (localObject != null)
        {
          localObject = ((ComponentName)localObject).getPackageName();
          if ((localActivity != null) && (str2.equals(localObject)))
            continue;
          localIntent.addFlags(268435456);
          if (localActivity == null)
            break label193;
          localActivity.startActivity(localIntent);
          paramPromise.resolve(Boolean.valueOf(true));
          return;
        }
      }
      catch (Exception localException)
      {
        paramPromise.reject(new JSApplicationIllegalArgumentException("Could not open URL '" + paramString + "': " + localException.getMessage()));
        return;
      }
      String str1 = "";
      continue;
      label193: getReactApplicationContext().startActivity(localIntent);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.intent.IntentModule
 * JD-Core Version:    0.6.0
 */
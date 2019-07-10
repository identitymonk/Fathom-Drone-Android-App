package com.facebook.react.modules.share;

import android.app.Activity;
import android.content.Intent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name="ShareModule")
public class ShareModule extends ReactContextBaseJavaModule
{
  static final String ACTION_SHARED = "sharedAction";
  static final String ERROR_INVALID_CONTENT = "E_INVALID_CONTENT";
  static final String ERROR_UNABLE_TO_OPEN_DIALOG = "E_UNABLE_TO_OPEN_DIALOG";

  public ShareModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  public String getName()
  {
    return "ShareModule";
  }

  @ReactMethod
  public void share(ReadableMap paramReadableMap, String paramString, Promise paramPromise)
  {
    if (paramReadableMap == null)
    {
      paramPromise.reject("E_INVALID_CONTENT", "Content cannot be null");
      return;
    }
    while (true)
    {
      try
      {
        Intent localIntent = new Intent("android.intent.action.SEND");
        localIntent.setTypeAndNormalize("text/plain");
        if (!paramReadableMap.hasKey("title"))
          continue;
        localIntent.putExtra("android.intent.extra.SUBJECT", paramReadableMap.getString("title"));
        if (!paramReadableMap.hasKey("message"))
          continue;
        localIntent.putExtra("android.intent.extra.TEXT", paramReadableMap.getString("message"));
        paramReadableMap = Intent.createChooser(localIntent, paramString);
        paramReadableMap.addCategory("android.intent.category.DEFAULT");
        paramString = getCurrentActivity();
        if (paramString != null)
        {
          paramString.startActivity(paramReadableMap);
          paramReadableMap = Arguments.createMap();
          paramReadableMap.putString("action", "sharedAction");
          paramPromise.resolve(paramReadableMap);
          return;
        }
      }
      catch (java.lang.Exception paramReadableMap)
      {
        paramPromise.reject("E_UNABLE_TO_OPEN_DIALOG", "Failed to open share dialog");
        return;
      }
      getReactApplicationContext().startActivity(paramReadableMap);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.share.ShareModule
 * JD-Core Version:    0.6.0
 */
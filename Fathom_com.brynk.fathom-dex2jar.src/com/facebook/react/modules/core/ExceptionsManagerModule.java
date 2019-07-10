package com.facebook.react.modules.core;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.JavascriptException;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.util.JSStackTrace;

@ReactModule(name="ExceptionsManager")
public class ExceptionsManagerModule extends BaseJavaModule
{
  protected static final String NAME = "ExceptionsManager";
  private final DevSupportManager mDevSupportManager;

  public ExceptionsManagerModule(DevSupportManager paramDevSupportManager)
  {
    this.mDevSupportManager = paramDevSupportManager;
  }

  private void showOrThrowError(String paramString, ReadableArray paramReadableArray, int paramInt)
  {
    if (this.mDevSupportManager.getDevSupportEnabled())
    {
      this.mDevSupportManager.showNewJSError(paramString, paramReadableArray, paramInt);
      return;
    }
    throw new JavascriptException(JSStackTrace.format(paramString, paramReadableArray));
  }

  @ReactMethod
  public void dismissRedbox()
  {
    if (this.mDevSupportManager.getDevSupportEnabled())
      this.mDevSupportManager.hideRedboxDialog();
  }

  public String getName()
  {
    return "ExceptionsManager";
  }

  @ReactMethod
  public void reportFatalException(String paramString, ReadableArray paramReadableArray, int paramInt)
  {
    showOrThrowError(paramString, paramReadableArray, paramInt);
  }

  @ReactMethod
  public void reportSoftException(String paramString, ReadableArray paramReadableArray, int paramInt)
  {
    if (this.mDevSupportManager.getDevSupportEnabled())
    {
      this.mDevSupportManager.showNewJSError(paramString, paramReadableArray, paramInt);
      return;
    }
    FLog.e("ReactNative", JSStackTrace.format(paramString, paramReadableArray));
  }

  @ReactMethod
  public void updateExceptionMessage(String paramString, ReadableArray paramReadableArray, int paramInt)
  {
    if (this.mDevSupportManager.getDevSupportEnabled())
      this.mDevSupportManager.updateJSError(paramString, paramReadableArray, paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.core.ExceptionsManagerModule
 * JD-Core Version:    0.6.0
 */
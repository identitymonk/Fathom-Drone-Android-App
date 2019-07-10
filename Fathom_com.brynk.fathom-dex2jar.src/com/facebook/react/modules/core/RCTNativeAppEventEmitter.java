package com.facebook.react.modules.core;

import com.facebook.react.bridge.JavaScriptModule;
import javax.annotation.Nullable;

public abstract interface RCTNativeAppEventEmitter extends JavaScriptModule
{
  public abstract void emit(String paramString, @Nullable Object paramObject);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.core.RCTNativeAppEventEmitter
 * JD-Core Version:    0.6.0
 */
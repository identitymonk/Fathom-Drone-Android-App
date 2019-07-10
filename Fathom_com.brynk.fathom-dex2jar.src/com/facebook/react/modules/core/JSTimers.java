package com.facebook.react.modules.core;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableArray;

public abstract interface JSTimers extends JavaScriptModule
{
  public abstract void callIdleCallbacks(double paramDouble);

  public abstract void callTimers(WritableArray paramWritableArray);

  public abstract void emitTimeDriftWarning(String paramString);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.core.JSTimers
 * JD-Core Version:    0.6.0
 */
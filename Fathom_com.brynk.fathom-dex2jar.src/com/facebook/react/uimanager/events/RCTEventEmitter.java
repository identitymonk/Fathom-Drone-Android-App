package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import javax.annotation.Nullable;

public abstract interface RCTEventEmitter extends JavaScriptModule
{
  public abstract void receiveEvent(int paramInt, String paramString, @Nullable WritableMap paramWritableMap);

  public abstract void receiveTouches(String paramString, WritableArray paramWritableArray1, WritableArray paramWritableArray2);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.events.RCTEventEmitter
 * JD-Core Version:    0.6.0
 */
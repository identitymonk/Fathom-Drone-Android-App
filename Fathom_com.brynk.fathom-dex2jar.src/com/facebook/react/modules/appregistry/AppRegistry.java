package com.facebook.react.modules.appregistry;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableMap;

public abstract interface AppRegistry extends JavaScriptModule
{
  public abstract void runApplication(String paramString, WritableMap paramWritableMap);

  public abstract void startHeadlessTask(int paramInt, String paramString, WritableMap paramWritableMap);

  public abstract void unmountApplicationComponentAtRootTag(int paramInt);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.appregistry.AppRegistry
 * JD-Core Version:    0.6.0
 */
package com.facebook.react;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.List;

public abstract interface ReactPackage
{
  public abstract List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext);

  public abstract List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.ReactPackage
 * JD-Core Version:    0.6.0
 */
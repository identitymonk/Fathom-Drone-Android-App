package com.facebook.react;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.List;

public abstract class ReactInstancePackage
  implements ReactPackage
{
  public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    throw new RuntimeException("ReactInstancePackage must be passed in the ReactInstanceManager.");
  }

  public abstract List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext, ReactInstanceManager paramReactInstanceManager);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.ReactInstancePackage
 * JD-Core Version:    0.6.0
 */
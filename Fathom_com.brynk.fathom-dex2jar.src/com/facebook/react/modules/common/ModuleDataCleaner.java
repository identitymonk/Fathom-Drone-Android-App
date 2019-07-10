package com.facebook.react.modules.common;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.NativeModule;
import java.util.Collection;
import java.util.Iterator;

public class ModuleDataCleaner
{
  public static void cleanDataFromModules(CatalystInstance paramCatalystInstance)
  {
    paramCatalystInstance = paramCatalystInstance.getNativeModules().iterator();
    while (paramCatalystInstance.hasNext())
    {
      NativeModule localNativeModule = (NativeModule)paramCatalystInstance.next();
      if (!(localNativeModule instanceof Cleanable))
        continue;
      FLog.d("ReactNative", "Cleaning data from " + localNativeModule.getName());
      ((Cleanable)localNativeModule).clearSensitiveData();
    }
  }

  public static abstract interface Cleanable
  {
    public abstract void clearSensitiveData();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.common.ModuleDataCleaner
 * JD-Core Version:    0.6.0
 */
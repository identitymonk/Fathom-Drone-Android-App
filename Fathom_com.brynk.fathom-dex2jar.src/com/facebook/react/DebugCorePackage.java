package com.facebook.react;

import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.devsupport.JSCHeapCapture;
import com.facebook.react.devsupport.JSCSamplingProfiler;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Provider;

class DebugCorePackage extends LazyReactPackage
{
  public List<ModuleSpec> getNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ModuleSpec(JSCHeapCapture.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new JSCHeapCapture(this.val$reactContext);
      }
    }));
    localArrayList.add(new ModuleSpec(JSCSamplingProfiler.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new JSCSamplingProfiler(this.val$reactContext);
      }
    }));
    return localArrayList;
  }

  public ReactModuleInfoProvider getReactModuleInfoProvider()
  {
    return LazyReactPackage.getReactModuleInfoProviderViaReflection(this);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.DebugCorePackage
 * JD-Core Version:    0.6.0
 */
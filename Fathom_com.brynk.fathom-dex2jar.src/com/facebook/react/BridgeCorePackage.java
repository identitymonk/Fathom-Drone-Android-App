package com.facebook.react;

import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ExceptionsManagerModule;
import com.facebook.react.modules.core.HeadlessJsTaskSupportModule;
import com.facebook.react.modules.core.Timing;
import com.facebook.react.modules.debug.SourceCodeModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.modules.systeminfo.AndroidInfoModule;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Provider;

class BridgeCorePackage extends LazyReactPackage
{
  private final DefaultHardwareBackBtnHandler mHardwareBackBtnHandler;
  private final ReactInstanceManager mReactInstanceManager;

  BridgeCorePackage(ReactInstanceManager paramReactInstanceManager, DefaultHardwareBackBtnHandler paramDefaultHardwareBackBtnHandler)
  {
    this.mReactInstanceManager = paramReactInstanceManager;
    this.mHardwareBackBtnHandler = paramDefaultHardwareBackBtnHandler;
  }

  public List<ModuleSpec> getNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ModuleSpec(AndroidInfoModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new AndroidInfoModule();
      }
    }));
    localArrayList.add(new ModuleSpec(DeviceEventManagerModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new DeviceEventManagerModule(this.val$reactContext, BridgeCorePackage.this.mHardwareBackBtnHandler);
      }
    }));
    localArrayList.add(new ModuleSpec(ExceptionsManagerModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new ExceptionsManagerModule(BridgeCorePackage.this.mReactInstanceManager.getDevSupportManager());
      }
    }));
    localArrayList.add(new ModuleSpec(HeadlessJsTaskSupportModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new HeadlessJsTaskSupportModule(this.val$reactContext);
      }
    }));
    localArrayList.add(new ModuleSpec(SourceCodeModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new SourceCodeModule(this.val$reactContext);
      }
    }));
    localArrayList.add(new ModuleSpec(Timing.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new Timing(this.val$reactContext, BridgeCorePackage.this.mReactInstanceManager.getDevSupportManager());
      }
    }));
    localArrayList.add(new ModuleSpec(DeviceInfoModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new DeviceInfoModule(this.val$reactContext);
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
 * Qualified Name:     com.facebook.react.BridgeCorePackage
 * JD-Core Version:    0.6.0
 */
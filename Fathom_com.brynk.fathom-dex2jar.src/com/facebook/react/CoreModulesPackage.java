package com.facebook.react;

import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ExceptionsManagerModule;
import com.facebook.react.modules.core.HeadlessJsTaskSupportModule;
import com.facebook.react.modules.core.Timing;
import com.facebook.react.modules.debug.AnimationsDebugModule;
import com.facebook.react.modules.debug.SourceCodeModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.modules.systeminfo.AndroidInfoModule;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModule.ViewManagerResolver;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.systrace.Systrace;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Provider;

class CoreModulesPackage extends LazyReactPackage
  implements ReactPackageLogger
{
  private final DefaultHardwareBackBtnHandler mHardwareBackBtnHandler;
  private final boolean mLazyViewManagersEnabled;
  private final int mMinTimeLeftInFrameForNonBatchedOperationMs;
  private final ReactInstanceManager mReactInstanceManager;
  private final UIImplementationProvider mUIImplementationProvider;

  CoreModulesPackage(ReactInstanceManager paramReactInstanceManager, DefaultHardwareBackBtnHandler paramDefaultHardwareBackBtnHandler, UIImplementationProvider paramUIImplementationProvider, boolean paramBoolean, int paramInt)
  {
    this.mReactInstanceManager = paramReactInstanceManager;
    this.mHardwareBackBtnHandler = paramDefaultHardwareBackBtnHandler;
    this.mUIImplementationProvider = paramUIImplementationProvider;
    this.mLazyViewManagersEnabled = paramBoolean;
    this.mMinTimeLeftInFrameForNonBatchedOperationMs = paramInt;
  }

  private UIManagerModule createUIManager(ReactApplicationContext paramReactApplicationContext)
  {
    ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_START);
    Systrace.beginSection(0L, "createUIManagerModule");
    try
    {
      if (this.mLazyViewManagersEnabled)
      {
        paramReactApplicationContext = new UIManagerModule(paramReactApplicationContext, new UIManagerModule.ViewManagerResolver()
        {
          @Nullable
          public ViewManager getViewManager(String paramString)
          {
            return CoreModulesPackage.this.mReactInstanceManager.createViewManager(paramString);
          }

          public List<String> getViewManagerNames()
          {
            return CoreModulesPackage.this.mReactInstanceManager.getViewManagerNames();
          }
        }
        , this.mUIImplementationProvider, this.mMinTimeLeftInFrameForNonBatchedOperationMs);
        return paramReactApplicationContext;
      }
      paramReactApplicationContext = new UIManagerModule(paramReactApplicationContext, this.mReactInstanceManager.createAllViewManagers(paramReactApplicationContext), this.mUIImplementationProvider, this.mMinTimeLeftInFrameForNonBatchedOperationMs);
      return paramReactApplicationContext;
    }
    finally
    {
      Systrace.endSection(0L);
      ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
    }
    throw paramReactApplicationContext;
  }

  public void endProcessPackage()
  {
    ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_END);
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
    localArrayList.add(new ModuleSpec(AnimationsDebugModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new AnimationsDebugModule(this.val$reactContext, CoreModulesPackage.this.mReactInstanceManager.getDevSupportManager().getDevSettings());
      }
    }));
    localArrayList.add(new ModuleSpec(DeviceEventManagerModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return new DeviceEventManagerModule(this.val$reactContext, CoreModulesPackage.this.mHardwareBackBtnHandler);
      }
    }));
    localArrayList.add(new ModuleSpec(ExceptionsManagerModule.class, new Provider()
    {
      public NativeModule get()
      {
        return new ExceptionsManagerModule(CoreModulesPackage.this.mReactInstanceManager.getDevSupportManager());
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
        return new Timing(this.val$reactContext, CoreModulesPackage.this.mReactInstanceManager.getDevSupportManager());
      }
    }));
    localArrayList.add(new ModuleSpec(UIManagerModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return CoreModulesPackage.this.createUIManager(this.val$reactContext);
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

  public void startProcessPackage()
  {
    ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_START);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.CoreModulesPackage
 * JD-Core Version:    0.6.0
 */
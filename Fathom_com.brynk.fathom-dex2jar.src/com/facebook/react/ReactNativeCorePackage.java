package com.facebook.react;

import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModule.ViewManagerResolver;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.systrace.Systrace;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Provider;

public class ReactNativeCorePackage extends LazyReactPackage
{
  private final boolean mLazyViewManagersEnabled;
  private final int mMinTimeLeftInFrameForNonBatchedOperationMs;
  private final ReactInstanceManager mReactInstanceManager;
  private final UIImplementationProvider mUIImplementationProvider;

  public ReactNativeCorePackage(ReactInstanceManager paramReactInstanceManager, UIImplementationProvider paramUIImplementationProvider, boolean paramBoolean, int paramInt)
  {
    this.mReactInstanceManager = paramReactInstanceManager;
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
            return ReactNativeCorePackage.this.mReactInstanceManager.createViewManager(paramString);
          }

          public List<String> getViewManagerNames()
          {
            return ReactNativeCorePackage.this.mReactInstanceManager.getViewManagerNames();
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

  public List<ModuleSpec> getNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ModuleSpec(UIManagerModule.class, new Provider(paramReactApplicationContext)
    {
      public NativeModule get()
      {
        return ReactNativeCorePackage.this.createUIManager(this.val$reactContext);
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
 * Qualified Name:     com.facebook.react.ReactNativeCorePackage
 * JD-Core Version:    0.6.0
 */
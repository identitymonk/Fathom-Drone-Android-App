package com.facebook.react;

import android.app.Activity;
import android.app.Application;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSCJavaScriptExecutorFactory;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.uimanager.UIImplementationProvider;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class ReactInstanceManagerBuilder
{

  @Nullable
  private Application mApplication;

  @Nullable
  private NotThreadSafeBridgeIdleDebugListener mBridgeIdleDebugListener;

  @Nullable
  private Activity mCurrentActivity;

  @Nullable
  private DefaultHardwareBackBtnHandler mDefaultHardwareBackBtnHandler;

  @Nullable
  private DevBundleDownloadListener mDevBundleDownloadListener;
  private boolean mEnableSplitPackage;

  @Nullable
  private LifecycleState mInitialLifecycleState;

  @Nullable
  private String mJSBundleAssetUrl;

  @Nullable
  private JSBundleLoader mJSBundleLoader;

  @Nullable
  private String mJSMainModulePath;

  @Nullable
  private JavaScriptExecutorFactory mJavaScriptExecutorFactory;
  private boolean mLazyNativeModulesEnabled;
  private boolean mLazyViewManagersEnabled;
  private int mMinNumShakes = 1;
  private int mMinTimeLeftInFrameForNonBatchedOperationMs = -1;

  @Nullable
  private NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
  private final List<ReactPackage> mPackages = new ArrayList();

  @Nullable
  private RedBoxHandler mRedBoxHandler;

  @Nullable
  private UIImplementationProvider mUIImplementationProvider;
  private boolean mUseDeveloperSupport;
  private boolean mUseOnlyDefaultPackages;
  private boolean mUseSeparateUIBackgroundThread;

  public ReactInstanceManagerBuilder addPackage(ReactPackage paramReactPackage)
  {
    this.mPackages.add(paramReactPackage);
    return this;
  }

  public ReactInstanceManagerBuilder addPackages(List<ReactPackage> paramList)
  {
    this.mPackages.addAll(paramList);
    return this;
  }

  public ReactInstanceManager build()
  {
    Assertions.assertNotNull(this.mApplication, "Application property has not been set with this builder");
    boolean bool;
    label62: Object localObject1;
    Application localApplication;
    Activity localActivity;
    DefaultHardwareBackBtnHandler localDefaultHardwareBackBtnHandler;
    if ((this.mUseDeveloperSupport) || (this.mJSBundleAssetUrl != null) || (this.mJSBundleLoader != null))
    {
      bool = true;
      Assertions.assertCondition(bool, "JS Bundle File or Asset URL has to be provided when dev support is disabled");
      if ((this.mJSMainModulePath == null) && (this.mJSBundleAssetUrl == null) && (this.mJSBundleLoader == null))
        break label253;
      bool = true;
      Assertions.assertCondition(bool, "Either MainModulePath or JS Bundle File needs to be provided");
      if (this.mUIImplementationProvider == null)
        this.mUIImplementationProvider = new UIImplementationProvider();
      localObject1 = this.mApplication.getPackageName();
      localObject2 = AndroidInfoHelpers.getFriendlyDeviceName();
      localApplication = this.mApplication;
      localActivity = this.mCurrentActivity;
      localDefaultHardwareBackBtnHandler = this.mDefaultHardwareBackBtnHandler;
      if (this.mJavaScriptExecutorFactory != null)
        break label258;
      localObject1 = new JSCJavaScriptExecutorFactory((String)localObject1, (String)localObject2);
      label133: if ((this.mJSBundleLoader != null) || (this.mJSBundleAssetUrl == null))
        break label266;
    }
    label258: label266: for (Object localObject2 = JSBundleLoader.createAssetLoader(this.mApplication, this.mJSBundleAssetUrl, false); ; localObject2 = this.mJSBundleLoader)
    {
      return new ReactInstanceManager(localApplication, localActivity, localDefaultHardwareBackBtnHandler, (JavaScriptExecutorFactory)localObject1, (JSBundleLoader)localObject2, this.mJSMainModulePath, this.mPackages, this.mUseDeveloperSupport, this.mBridgeIdleDebugListener, (LifecycleState)Assertions.assertNotNull(this.mInitialLifecycleState, "Initial lifecycle state was not set"), this.mUIImplementationProvider, this.mNativeModuleCallExceptionHandler, this.mRedBoxHandler, this.mLazyNativeModulesEnabled, this.mLazyViewManagersEnabled, this.mDevBundleDownloadListener, this.mUseSeparateUIBackgroundThread, this.mMinNumShakes, this.mEnableSplitPackage, this.mUseOnlyDefaultPackages, this.mMinTimeLeftInFrameForNonBatchedOperationMs);
      bool = false;
      break;
      label253: bool = false;
      break label62;
      localObject1 = this.mJavaScriptExecutorFactory;
      break label133;
    }
  }

  public ReactInstanceManagerBuilder setApplication(Application paramApplication)
  {
    this.mApplication = paramApplication;
    return this;
  }

  public ReactInstanceManagerBuilder setBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener)
  {
    this.mBridgeIdleDebugListener = paramNotThreadSafeBridgeIdleDebugListener;
    return this;
  }

  public ReactInstanceManagerBuilder setBundleAssetName(String paramString)
  {
    if (paramString == null);
    for (paramString = null; ; paramString = "assets://" + paramString)
    {
      this.mJSBundleAssetUrl = paramString;
      this.mJSBundleLoader = null;
      return this;
    }
  }

  public ReactInstanceManagerBuilder setCurrentActivity(Activity paramActivity)
  {
    this.mCurrentActivity = paramActivity;
    return this;
  }

  public ReactInstanceManagerBuilder setDefaultHardwareBackBtnHandler(DefaultHardwareBackBtnHandler paramDefaultHardwareBackBtnHandler)
  {
    this.mDefaultHardwareBackBtnHandler = paramDefaultHardwareBackBtnHandler;
    return this;
  }

  public ReactInstanceManagerBuilder setDevBundleDownloadListener(@Nullable DevBundleDownloadListener paramDevBundleDownloadListener)
  {
    this.mDevBundleDownloadListener = paramDevBundleDownloadListener;
    return this;
  }

  public ReactInstanceManagerBuilder setEnableSplitPackage(boolean paramBoolean)
  {
    this.mEnableSplitPackage = paramBoolean;
    return this;
  }

  public ReactInstanceManagerBuilder setInitialLifecycleState(LifecycleState paramLifecycleState)
  {
    this.mInitialLifecycleState = paramLifecycleState;
    return this;
  }

  public ReactInstanceManagerBuilder setJSBundleFile(String paramString)
  {
    if (paramString.startsWith("assets://"))
    {
      this.mJSBundleAssetUrl = paramString;
      this.mJSBundleLoader = null;
      return this;
    }
    return setJSBundleLoader(JSBundleLoader.createFileLoader(paramString));
  }

  public ReactInstanceManagerBuilder setJSBundleLoader(JSBundleLoader paramJSBundleLoader)
  {
    this.mJSBundleLoader = paramJSBundleLoader;
    this.mJSBundleAssetUrl = null;
    return this;
  }

  public ReactInstanceManagerBuilder setJSMainModulePath(String paramString)
  {
    this.mJSMainModulePath = paramString;
    return this;
  }

  public ReactInstanceManagerBuilder setJavaScriptExecutorFactory(@Nullable JavaScriptExecutorFactory paramJavaScriptExecutorFactory)
  {
    this.mJavaScriptExecutorFactory = paramJavaScriptExecutorFactory;
    return this;
  }

  public ReactInstanceManagerBuilder setLazyNativeModulesEnabled(boolean paramBoolean)
  {
    this.mLazyNativeModulesEnabled = paramBoolean;
    return this;
  }

  public ReactInstanceManagerBuilder setLazyViewManagersEnabled(boolean paramBoolean)
  {
    this.mLazyViewManagersEnabled = paramBoolean;
    return this;
  }

  public ReactInstanceManagerBuilder setMinNumShakes(int paramInt)
  {
    this.mMinNumShakes = paramInt;
    return this;
  }

  public ReactInstanceManagerBuilder setMinTimeLeftInFrameForNonBatchedOperationMs(int paramInt)
  {
    this.mMinTimeLeftInFrameForNonBatchedOperationMs = paramInt;
    return this;
  }

  public ReactInstanceManagerBuilder setNativeModuleCallExceptionHandler(NativeModuleCallExceptionHandler paramNativeModuleCallExceptionHandler)
  {
    this.mNativeModuleCallExceptionHandler = paramNativeModuleCallExceptionHandler;
    return this;
  }

  public ReactInstanceManagerBuilder setRedBoxHandler(@Nullable RedBoxHandler paramRedBoxHandler)
  {
    this.mRedBoxHandler = paramRedBoxHandler;
    return this;
  }

  public ReactInstanceManagerBuilder setUIImplementationProvider(@Nullable UIImplementationProvider paramUIImplementationProvider)
  {
    this.mUIImplementationProvider = paramUIImplementationProvider;
    return this;
  }

  public ReactInstanceManagerBuilder setUseDeveloperSupport(boolean paramBoolean)
  {
    this.mUseDeveloperSupport = paramBoolean;
    return this;
  }

  public ReactInstanceManagerBuilder setUseOnlyDefaultPackages(boolean paramBoolean)
  {
    this.mUseOnlyDefaultPackages = paramBoolean;
    return this;
  }

  public ReactInstanceManagerBuilder setUseSeparateUIBackgroundThread(boolean paramBoolean)
  {
    this.mUseSeparateUIBackgroundThread = paramBoolean;
    return this;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.ReactInstanceManagerBuilder
 * JD-Core Version:    0.6.0
 */
package com.facebook.react;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.util.Log;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.Printer;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.infer.annotation.ThreadSafe;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.CatalystInstanceImpl;
import com.facebook.react.bridge.CatalystInstanceImpl.Builder;
import com.facebook.react.bridge.CatalystInstanceImpl.PendingJSCall;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JavaJSExecutor.Factory;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ProxyJavaScriptExecutor.Factory;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.devsupport.DevSupportManagerFactory;
import com.facebook.react.devsupport.ReactInstanceDevCommandsHandler;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.soloader.SoLoader;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Set;
import javax.annotation.Nullable;

@ThreadSafe
public class ReactInstanceManager
{
  private static final String TAG = ReactInstanceManager.class.getSimpleName();
  private final Context mApplicationContext;
  private final List<ReactRootView> mAttachedRootViews = Collections.synchronizedList(new ArrayList());
  private final DefaultHardwareBackBtnHandler mBackBtnHandler = new DefaultHardwareBackBtnHandler()
  {
    public void invokeDefaultOnBackPressed()
    {
      ReactInstanceManager.this.invokeDefaultOnBackPressed();
    }
  };

  @Nullable
  private final NotThreadSafeBridgeIdleDebugListener mBridgeIdleDebugListener;

  @Nullable
  private final JSBundleLoader mBundleLoader;

  @Nullable
  private volatile Thread mCreateReactContextThread;

  @Nullable
  private Activity mCurrentActivity;

  @Nullable
  private volatile ReactContext mCurrentReactContext;

  @Nullable
  @ThreadConfined("UI")
  private DefaultHardwareBackBtnHandler mDefaultBackButtonImpl;
  private final ReactInstanceDevCommandsHandler mDevInterface = new ReactInstanceDevCommandsHandler()
  {
    public void onJSBundleLoadedFromServer()
    {
      ReactInstanceManager.this.onJSBundleLoadedFromServer();
    }

    public void onReloadWithJSDebugger(JavaJSExecutor.Factory paramFactory)
    {
      ReactInstanceManager.this.onReloadWithJSDebugger(paramFactory);
    }

    public void toggleElementInspector()
    {
      ReactInstanceManager.this.toggleElementInspector();
    }
  };
  private final DevSupportManager mDevSupportManager;
  private volatile boolean mHasStartedCreatingInitialContext = false;
  private volatile Boolean mHasStartedDestroying = Boolean.valueOf(false);
  private final List<CatalystInstanceImpl.PendingJSCall> mInitFunctions;

  @Nullable
  private final String mJSMainModulePath;
  private final JavaScriptExecutorFactory mJavaScriptExecutorFactory;
  private final boolean mLazyNativeModulesEnabled;
  private final boolean mLazyViewManagersEnabled;
  private volatile LifecycleState mLifecycleState;
  private final MemoryPressureRouter mMemoryPressureRouter;
  private final int mMinNumShakes;
  private final int mMinTimeLeftInFrameForNonBatchedOperationMs;

  @Nullable
  private final NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
  private final List<ReactPackage> mPackages;

  @Nullable
  @ThreadConfined("UI")
  private ReactContextInitParams mPendingReactContextInitParams;
  private final Object mReactContextLock = new Object();
  private final Collection<ReactInstanceEventListener> mReactInstanceEventListeners = Collections.synchronizedSet(new HashSet());
  private final UIImplementationProvider mUIImplementationProvider;
  private final boolean mUseDeveloperSupport;
  private final boolean mUseSeparateUIBackgroundThread;

  ReactInstanceManager(Context paramContext, @Nullable Activity paramActivity, @Nullable DefaultHardwareBackBtnHandler paramDefaultHardwareBackBtnHandler, JavaScriptExecutorFactory paramJavaScriptExecutorFactory, @Nullable JSBundleLoader paramJSBundleLoader, @Nullable String paramString, List<ReactPackage> paramList, boolean paramBoolean1, @Nullable NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener, LifecycleState paramLifecycleState, UIImplementationProvider paramUIImplementationProvider, NativeModuleCallExceptionHandler paramNativeModuleCallExceptionHandler, @Nullable RedBoxHandler paramRedBoxHandler, boolean paramBoolean2, boolean paramBoolean3, @Nullable DevBundleDownloadListener paramDevBundleDownloadListener, boolean paramBoolean4, int paramInt1, boolean paramBoolean5, boolean paramBoolean6, int paramInt2)
  {
    Log.d("ReactNative", "ReactInstanceManager.ctor()");
    initializeSoLoaderIfNecessary(paramContext);
    DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(paramContext);
    this.mApplicationContext = paramContext;
    this.mCurrentActivity = paramActivity;
    this.mDefaultBackButtonImpl = paramDefaultHardwareBackBtnHandler;
    this.mJavaScriptExecutorFactory = paramJavaScriptExecutorFactory;
    this.mBundleLoader = paramJSBundleLoader;
    this.mJSMainModulePath = paramString;
    this.mPackages = new ArrayList();
    this.mInitFunctions = new ArrayList();
    this.mUseDeveloperSupport = paramBoolean1;
    this.mDevSupportManager = DevSupportManagerFactory.create(paramContext, this.mDevInterface, this.mJSMainModulePath, paramBoolean1, paramRedBoxHandler, paramDevBundleDownloadListener, paramInt1);
    this.mBridgeIdleDebugListener = paramNotThreadSafeBridgeIdleDebugListener;
    this.mLifecycleState = paramLifecycleState;
    this.mUIImplementationProvider = paramUIImplementationProvider;
    this.mMemoryPressureRouter = new MemoryPressureRouter(paramContext);
    this.mNativeModuleCallExceptionHandler = paramNativeModuleCallExceptionHandler;
    this.mLazyNativeModulesEnabled = paramBoolean2;
    this.mLazyViewManagersEnabled = paramBoolean3;
    this.mMinTimeLeftInFrameForNonBatchedOperationMs = paramInt2;
    this.mUseSeparateUIBackgroundThread = paramBoolean4;
    this.mMinNumShakes = paramInt1;
    paramContext = this.mPackages;
    monitorenter;
    if (!paramBoolean5);
    try
    {
      paramActivity = new CoreModulesPackage(this, this.mBackBtnHandler, this.mUIImplementationProvider, this.mLazyViewManagersEnabled, this.mMinTimeLeftInFrameForNonBatchedOperationMs);
      this.mPackages.add(paramActivity);
      while (true)
      {
        this.mPackages.addAll(paramList);
        monitorexit;
        ReactChoreographer.initialize();
        if (this.mUseDeveloperSupport)
          this.mDevSupportManager.startInspector();
        return;
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: Use Split Packages");
        this.mPackages.add(new BridgeCorePackage(this, this.mBackBtnHandler));
        if (this.mUseDeveloperSupport)
          this.mPackages.add(new DebugCorePackage());
        if (paramBoolean6)
          continue;
        this.mPackages.add(new ReactNativeCorePackage(this, this.mUIImplementationProvider, this.mLazyViewManagersEnabled, this.mMinTimeLeftInFrameForNonBatchedOperationMs));
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramActivity;
  }

  private void attachRootViewToInstance(ReactRootView paramReactRootView, CatalystInstance paramCatalystInstance)
  {
    Log.d("ReactNative", "ReactInstanceManager.attachRootViewToInstance()");
    Systrace.beginSection(0L, "attachRootViewToInstance");
    int i = ((UIManagerModule)paramCatalystInstance.getNativeModule(UIManagerModule.class)).addRootView(paramReactRootView);
    paramReactRootView.setRootViewTag(i);
    paramReactRootView.runApplication();
    Systrace.beginAsyncSection(0L, "pre_rootView.onAttachedToReactInstance", i);
    UiThreadUtil.runOnUiThread(new Runnable(i, paramReactRootView)
    {
      public void run()
      {
        Systrace.endAsyncSection(0L, "pre_rootView.onAttachedToReactInstance", this.val$rootTag);
        this.val$rootView.onAttachedToReactInstance();
      }
    });
    Systrace.endSection(0L);
  }

  public static ReactInstanceManagerBuilder builder()
  {
    return new ReactInstanceManagerBuilder();
  }

  private ReactApplicationContext createReactContext(JavaScriptExecutor paramJavaScriptExecutor, JSBundleLoader paramJSBundleLoader)
  {
    Log.d("ReactNative", "ReactInstanceManager.createReactContext()");
    ReactMarker.logMarker(ReactMarkerConstants.CREATE_REACT_CONTEXT_START);
    ReactApplicationContext localReactApplicationContext = new ReactApplicationContext(this.mApplicationContext);
    if (this.mUseDeveloperSupport)
      localReactApplicationContext.setNativeModuleCallExceptionHandler(this.mDevSupportManager);
    NativeModuleRegistry localNativeModuleRegistry = processPackages(localReactApplicationContext, this.mPackages, false);
    Object localObject;
    if (this.mNativeModuleCallExceptionHandler != null)
      localObject = this.mNativeModuleCallExceptionHandler;
    while (true)
    {
      CatalystInstanceImpl.Builder localBuilder = new CatalystInstanceImpl.Builder();
      ReactQueueConfigurationSpec localReactQueueConfigurationSpec;
      if (this.mUseSeparateUIBackgroundThread)
      {
        localReactQueueConfigurationSpec = ReactQueueConfigurationSpec.createWithSeparateUIBackgroundThread();
        paramJavaScriptExecutor = localBuilder.setReactQueueConfigurationSpec(localReactQueueConfigurationSpec).setJSExecutor(paramJavaScriptExecutor).setRegistry(localNativeModuleRegistry).setJSBundleLoader(paramJSBundleLoader).setNativeModuleCallExceptionHandler((NativeModuleCallExceptionHandler)localObject);
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_START);
        Systrace.beginSection(0L, "createCatalystInstance");
      }
      try
      {
        paramJavaScriptExecutor = paramJavaScriptExecutor.build();
        Systrace.endSection(0L);
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
        if (this.mBridgeIdleDebugListener != null)
          paramJavaScriptExecutor.addBridgeIdleDebugListener(this.mBridgeIdleDebugListener);
        if (Systrace.isTracing(0L))
          paramJavaScriptExecutor.setGlobalVariable("__RCTProfileIsProfiling", "true");
        ReactMarker.logMarker(ReactMarkerConstants.PRE_RUN_JS_BUNDLE_START);
        paramJavaScriptExecutor.runJSBundle();
        if (!this.mInitFunctions.isEmpty())
        {
          paramJSBundleLoader = this.mInitFunctions.iterator();
          while (true)
            if (paramJSBundleLoader.hasNext())
            {
              localObject = (CatalystInstanceImpl.PendingJSCall)paramJSBundleLoader.next();
              ((CatalystInstanceImpl)paramJavaScriptExecutor).callFunction((CatalystInstanceImpl.PendingJSCall)localObject);
              continue;
              localObject = this.mDevSupportManager;
              break;
              localReactQueueConfigurationSpec = ReactQueueConfigurationSpec.createDefault();
            }
        }
      }
      finally
      {
        Systrace.endSection(0L);
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
      }
    }
    return (ReactApplicationContext)localReactApplicationContext;
  }

  private void detachViewFromInstance(ReactRootView paramReactRootView, CatalystInstance paramCatalystInstance)
  {
    Log.d("ReactNative", "ReactInstanceManager.detachViewFromInstance()");
    UiThreadUtil.assertOnUiThread();
    ((AppRegistry)paramCatalystInstance.getJSModule(AppRegistry.class)).unmountApplicationComponentAtRootTag(paramReactRootView.getId());
  }

  private static void initializeSoLoaderIfNecessary(Context paramContext)
  {
    SoLoader.init(paramContext, false);
  }

  private void invokeDefaultOnBackPressed()
  {
    UiThreadUtil.assertOnUiThread();
    if (this.mDefaultBackButtonImpl != null)
      this.mDefaultBackButtonImpl.invokeDefaultOnBackPressed();
  }

  private void moveReactContextToCurrentLifecycleState()
  {
    monitorenter;
    try
    {
      if (this.mLifecycleState == LifecycleState.RESUMED)
        moveToResumedLifecycleState(true);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private void moveToBeforeCreateLifecycleState()
  {
    monitorenter;
    try
    {
      ReactContext localReactContext = getCurrentReactContext();
      if (localReactContext != null)
      {
        if (this.mLifecycleState == LifecycleState.RESUMED)
        {
          localReactContext.onHostPause();
          this.mLifecycleState = LifecycleState.BEFORE_RESUME;
        }
        if (this.mLifecycleState == LifecycleState.BEFORE_RESUME)
          localReactContext.onHostDestroy();
      }
      this.mLifecycleState = LifecycleState.BEFORE_CREATE;
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void moveToBeforeResumeLifecycleState()
  {
    monitorenter;
    try
    {
      ReactContext localReactContext = getCurrentReactContext();
      if (localReactContext != null)
      {
        if (this.mLifecycleState != LifecycleState.BEFORE_CREATE)
          break label43;
        localReactContext.onHostResume(this.mCurrentActivity);
        localReactContext.onHostPause();
      }
      while (true)
      {
        this.mLifecycleState = LifecycleState.BEFORE_RESUME;
        return;
        label43: if (this.mLifecycleState != LifecycleState.RESUMED)
          continue;
        localReactContext.onHostPause();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void moveToResumedLifecycleState(boolean paramBoolean)
  {
    monitorenter;
    try
    {
      ReactContext localReactContext = getCurrentReactContext();
      if ((localReactContext != null) && ((paramBoolean) || (this.mLifecycleState == LifecycleState.BEFORE_RESUME) || (this.mLifecycleState == LifecycleState.BEFORE_CREATE)))
        localReactContext.onHostResume(this.mCurrentActivity);
      this.mLifecycleState = LifecycleState.RESUMED;
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  @ThreadConfined("UI")
  private void onJSBundleLoadedFromServer()
  {
    Log.d("ReactNative", "ReactInstanceManager.onJSBundleLoadedFromServer()");
    recreateReactContextInBackground(this.mJavaScriptExecutorFactory, JSBundleLoader.createCachedBundleFromNetworkLoader(this.mDevSupportManager.getSourceUrl(), this.mDevSupportManager.getDownloadedJSBundleFile()));
  }

  @ThreadConfined("UI")
  private void onReloadWithJSDebugger(JavaJSExecutor.Factory paramFactory)
  {
    Log.d("ReactNative", "ReactInstanceManager.onReloadWithJSDebugger()");
    recreateReactContextInBackground(new ProxyJavaScriptExecutor.Factory(paramFactory), JSBundleLoader.createRemoteDebuggerBundleLoader(this.mDevSupportManager.getJSBundleURLForRemoteDebugging(), this.mDevSupportManager.getSourceUrl()));
  }

  private void processPackage(ReactPackage paramReactPackage, NativeModuleRegistryBuilder paramNativeModuleRegistryBuilder)
  {
    SystraceMessage.beginSection(0L, "processPackage").arg("className", paramReactPackage.getClass().getSimpleName()).flush();
    if ((paramReactPackage instanceof ReactPackageLogger))
      ((ReactPackageLogger)paramReactPackage).startProcessPackage();
    paramNativeModuleRegistryBuilder.processPackage(paramReactPackage);
    if ((paramReactPackage instanceof ReactPackageLogger))
      ((ReactPackageLogger)paramReactPackage).endProcessPackage();
    SystraceMessage.endSection(0L).flush();
  }

  private NativeModuleRegistry processPackages(ReactApplicationContext arg1, List<ReactPackage> paramList, boolean paramBoolean)
  {
    NativeModuleRegistryBuilder localNativeModuleRegistryBuilder = new NativeModuleRegistryBuilder(???, this, this.mLazyNativeModulesEnabled);
    ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_START);
    while (true)
    {
      ReactPackage localReactPackage;
      synchronized (this.mPackages)
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext())
          break;
        localReactPackage = (ReactPackage)paramList.next();
        if ((paramBoolean) && (this.mPackages.contains(localReactPackage)))
          continue;
        Systrace.beginSection(0L, "createAndProcessCustomReactPackage");
        if (!paramBoolean);
      }
      try
      {
        this.mPackages.add(localReactPackage);
        processPackage(localReactPackage, localNativeModuleRegistryBuilder);
        Systrace.endSection(0L);
        continue;
        paramList = finally;
        monitorexit;
        throw paramList;
      }
      finally
      {
        Systrace.endSection(0L);
      }
    }
    monitorexit;
    ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_END);
    ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_START);
    Systrace.beginSection(0L, "buildNativeModuleRegistry");
    try
    {
      ??? = localNativeModuleRegistryBuilder.build();
      return ???;
    }
    finally
    {
      Systrace.endSection(0L);
      ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_END);
    }
    throw ???;
  }

  @ThreadConfined("UI")
  private void recreateReactContextInBackground(JavaScriptExecutorFactory paramJavaScriptExecutorFactory, JSBundleLoader paramJSBundleLoader)
  {
    Log.d("ReactNative", "ReactInstanceManager.recreateReactContextInBackground()");
    UiThreadUtil.assertOnUiThread();
    paramJavaScriptExecutorFactory = new ReactContextInitParams(paramJavaScriptExecutorFactory, paramJSBundleLoader);
    if (this.mCreateReactContextThread == null)
    {
      runCreateReactContextOnNewThread(paramJavaScriptExecutorFactory);
      return;
    }
    this.mPendingReactContextInitParams = paramJavaScriptExecutorFactory;
  }

  @ThreadConfined("UI")
  private void recreateReactContextInBackgroundFromBundleLoader()
  {
    Log.d("ReactNative", "ReactInstanceManager.recreateReactContextInBackgroundFromBundleLoader()");
    PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from BundleLoader");
    recreateReactContextInBackground(this.mJavaScriptExecutorFactory, this.mBundleLoader);
  }

  @ThreadConfined("UI")
  private void recreateReactContextInBackgroundInner()
  {
    Log.d("ReactNative", "ReactInstanceManager.recreateReactContextInBackgroundInner()");
    PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: recreateReactContextInBackground");
    UiThreadUtil.assertOnUiThread();
    if ((this.mUseDeveloperSupport) && (this.mJSMainModulePath != null) && (!Systrace.isTracing(0L)))
    {
      DeveloperSettings localDeveloperSettings = this.mDevSupportManager.getDevSettings();
      if ((this.mDevSupportManager.hasUpToDateJSBundleInCache()) && (!localDeveloperSettings.isRemoteJSDebugEnabled()))
      {
        onJSBundleLoadedFromServer();
        return;
      }
      if (this.mBundleLoader == null)
      {
        this.mDevSupportManager.handleReloadJS();
        return;
      }
      this.mDevSupportManager.isPackagerRunning(new PackagerStatusCallback(localDeveloperSettings)
      {
        public void onPackagerStatusFetched(boolean paramBoolean)
        {
          UiThreadUtil.runOnUiThread(new Runnable(paramBoolean)
          {
            public void run()
            {
              if (this.val$packagerIsRunning)
              {
                ReactInstanceManager.this.mDevSupportManager.handleReloadJS();
                return;
              }
              ReactInstanceManager.3.this.val$devSettings.setRemoteJSDebugEnabled(false);
              ReactInstanceManager.this.recreateReactContextInBackgroundFromBundleLoader();
            }
          });
        }
      });
      return;
    }
    recreateReactContextInBackgroundFromBundleLoader();
  }

  @ThreadConfined("UI")
  private void runCreateReactContextOnNewThread(ReactContextInitParams paramReactContextInitParams)
  {
    Log.d("ReactNative", "ReactInstanceManager.runCreateReactContextOnNewThread()");
    UiThreadUtil.assertOnUiThread();
    synchronized (this.mReactContextLock)
    {
      if (this.mCurrentReactContext != null)
      {
        tearDownReactContext(this.mCurrentReactContext);
        this.mCurrentReactContext = null;
      }
      this.mCreateReactContextThread = new Thread(new Runnable(paramReactContextInitParams)
      {
        public void run()
        {
          ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_END);
          synchronized (ReactInstanceManager.this.mHasStartedDestroying)
          {
            while (true)
            {
              boolean bool = ReactInstanceManager.this.mHasStartedDestroying.booleanValue();
              if (!bool)
                break;
              try
              {
                ReactInstanceManager.this.mHasStartedDestroying.wait();
              }
              catch (InterruptedException localInterruptedException)
              {
              }
            }
            ReactInstanceManager.access$702(ReactInstanceManager.this, true);
          }
          try
          {
            Process.setThreadPriority(-4);
            ??? = ReactInstanceManager.this.createReactContext(this.val$initParams.getJsExecutorFactory().create(), this.val$initParams.getJsBundleLoader());
            ReactInstanceManager.access$902(ReactInstanceManager.this, null);
            ReactMarker.logMarker(ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_START);
            1 local1 = new Runnable()
            {
              public void run()
              {
                if (ReactInstanceManager.this.mPendingReactContextInitParams != null)
                {
                  ReactInstanceManager.this.runCreateReactContextOnNewThread(ReactInstanceManager.this.mPendingReactContextInitParams);
                  ReactInstanceManager.access$1002(ReactInstanceManager.this, null);
                }
              }
            };
            ((ReactApplicationContext)???).runOnNativeModulesQueueThread(new Runnable((ReactApplicationContext)???)
            {
              public void run()
              {
                try
                {
                  ReactInstanceManager.this.setupReactContext(this.val$reactApplicationContext);
                  return;
                }
                catch (Exception localException)
                {
                  ReactInstanceManager.this.mDevSupportManager.handleException(localException);
                }
              }
            });
            UiThreadUtil.runOnUiThread(local1);
            return;
            localObject2 = finally;
            monitorexit;
            throw localObject2;
          }
          catch (Exception localException)
          {
            ReactInstanceManager.this.mDevSupportManager.handleException(localException);
          }
        }
      });
      ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_START);
      this.mCreateReactContextThread.start();
      return;
    }
  }

  private void setupReactContext(ReactApplicationContext paramReactApplicationContext)
  {
    Log.d("ReactNative", "ReactInstanceManager.setupReactContext()");
    ReactMarker.logMarker(ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_END);
    ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_START);
    Systrace.beginSection(0L, "setupReactContext");
    synchronized (this.mReactContextLock)
    {
      this.mCurrentReactContext = ((ReactContext)Assertions.assertNotNull(paramReactApplicationContext));
      CatalystInstance localCatalystInstance = (CatalystInstance)Assertions.assertNotNull(paramReactApplicationContext.getCatalystInstance());
      localCatalystInstance.initialize();
      this.mDevSupportManager.onNewReactContextCreated(paramReactApplicationContext);
      this.mMemoryPressureRouter.addMemoryPressureListener(localCatalystInstance);
      moveReactContextToCurrentLifecycleState();
      ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_START);
      synchronized (this.mAttachedRootViews)
      {
        Iterator localIterator = this.mAttachedRootViews.iterator();
        if (localIterator.hasNext())
          attachRootViewToInstance((ReactRootView)localIterator.next(), localCatalystInstance);
      }
    }
    monitorexit;
    ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_END);
    ??? = new ReactInstanceEventListener[this.mReactInstanceEventListeners.size()];
    UiThreadUtil.runOnUiThread(new Runnable((ReactInstanceEventListener[])this.mReactInstanceEventListeners.toArray(???), paramReactApplicationContext)
    {
      public void run()
      {
        ReactInstanceManager.ReactInstanceEventListener[] arrayOfReactInstanceEventListener = this.val$finalListeners;
        int j = arrayOfReactInstanceEventListener.length;
        int i = 0;
        while (i < j)
        {
          arrayOfReactInstanceEventListener[i].onReactContextInitialized(this.val$reactContext);
          i += 1;
        }
      }
    });
    Systrace.endSection(0L);
    ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_END);
    paramReactApplicationContext.runOnJSQueueThread(new Runnable()
    {
      public void run()
      {
        Process.setThreadPriority(0);
      }
    });
    paramReactApplicationContext.runOnNativeModulesQueueThread(new Runnable()
    {
      public void run()
      {
        Process.setThreadPriority(0);
      }
    });
    if (this.mUseSeparateUIBackgroundThread)
      paramReactApplicationContext.runOnUiBackgroundQueueThread(new Runnable()
      {
        public void run()
        {
          Process.setThreadPriority(0);
        }
      });
  }

  private void tearDownReactContext(ReactContext paramReactContext)
  {
    Log.d("ReactNative", "ReactInstanceManager.tearDownReactContext()");
    UiThreadUtil.assertOnUiThread();
    if (this.mLifecycleState == LifecycleState.RESUMED)
      paramReactContext.onHostPause();
    synchronized (this.mAttachedRootViews)
    {
      Iterator localIterator = this.mAttachedRootViews.iterator();
      if (localIterator.hasNext())
      {
        ReactRootView localReactRootView = (ReactRootView)localIterator.next();
        localReactRootView.removeAllViews();
        localReactRootView.setId(-1);
      }
    }
    monitorexit;
    paramReactContext.destroy();
    this.mDevSupportManager.onReactInstanceDestroyed(paramReactContext);
    this.mMemoryPressureRouter.removeMemoryPressureListener(paramReactContext.getCatalystInstance());
  }

  private void toggleElementInspector()
  {
    ReactContext localReactContext = getCurrentReactContext();
    if (localReactContext != null)
      ((DeviceEventManagerModule.RCTDeviceEventEmitter)localReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("toggleElementInspector", null);
  }

  public void addReactInstanceEventListener(ReactInstanceEventListener paramReactInstanceEventListener)
  {
    this.mReactInstanceEventListeners.add(paramReactInstanceEventListener);
  }

  @ThreadConfined("UI")
  public void attachRootView(ReactRootView paramReactRootView)
  {
    UiThreadUtil.assertOnUiThread();
    this.mAttachedRootViews.add(paramReactRootView);
    paramReactRootView.removeAllViews();
    paramReactRootView.setId(-1);
    ReactContext localReactContext = getCurrentReactContext();
    if ((this.mCreateReactContextThread == null) && (localReactContext != null))
      attachRootViewToInstance(paramReactRootView, localReactContext.getCatalystInstance());
  }

  public List<ViewManager> createAllViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_START);
    Systrace.beginSection(0L, "createAllViewManagers");
    ArrayList localArrayList;
    try
    {
      synchronized (this.mPackages)
      {
        localArrayList = new ArrayList();
        Iterator localIterator = this.mPackages.iterator();
        if (localIterator.hasNext())
          localArrayList.addAll(((ReactPackage)localIterator.next()).createViewManagers(paramReactApplicationContext));
      }
    }
    finally
    {
      Systrace.endSection(0L);
      ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
    }
    monitorexit;
    Systrace.endSection(0L);
    ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
    return localArrayList;
  }

  @ThreadConfined("UI")
  public void createReactContextInBackground()
  {
    Log.d("ReactNative", "ReactInstanceManager.createReactContextInBackground()");
    if (!this.mHasStartedCreatingInitialContext);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool, "createReactContextInBackground should only be called when creating the react application for the first time. When reloading JS, e.g. from a new file, explicitlyuse recreateReactContextInBackground");
      this.mHasStartedCreatingInitialContext = true;
      recreateReactContextInBackgroundInner();
      return;
    }
  }

  @Nullable
  public ViewManager createViewManager(String paramString)
  {
    ReactApplicationContext localReactApplicationContext = (ReactApplicationContext)Assertions.assertNotNull((ReactApplicationContext)getCurrentReactContext());
    synchronized (this.mPackages)
    {
      Iterator localIterator = this.mPackages.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ReactPackage)localIterator.next();
        if (!(localObject instanceof ViewManagerOnDemandReactPackage))
          continue;
        localObject = ((ViewManagerOnDemandReactPackage)localObject).createViewManager(localReactApplicationContext, paramString);
        if (localObject != null)
          return localObject;
      }
      return null;
    }
  }

  @ThreadConfined("UI")
  public void destroy()
  {
    UiThreadUtil.assertOnUiThread();
    PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: Destroy");
    this.mHasStartedDestroying = Boolean.valueOf(true);
    if (this.mUseDeveloperSupport)
    {
      this.mDevSupportManager.setDevSupportEnabled(false);
      this.mDevSupportManager.stopInspector();
    }
    moveToBeforeCreateLifecycleState();
    if (this.mCreateReactContextThread != null)
      this.mCreateReactContextThread = null;
    this.mMemoryPressureRouter.destroy(this.mApplicationContext);
    synchronized (this.mReactContextLock)
    {
      if (this.mCurrentReactContext != null)
      {
        this.mCurrentReactContext.destroy();
        this.mCurrentReactContext = null;
      }
      this.mHasStartedCreatingInitialContext = false;
      this.mCurrentActivity = null;
      ResourceDrawableIdHelper.getInstance().clear();
      this.mHasStartedDestroying = Boolean.valueOf(false);
    }
    synchronized (this.mHasStartedDestroying)
    {
      this.mHasStartedDestroying.notifyAll();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }

  @ThreadConfined("UI")
  public void detachRootView(ReactRootView paramReactRootView)
  {
    UiThreadUtil.assertOnUiThread();
    if (this.mAttachedRootViews.remove(paramReactRootView))
    {
      ReactContext localReactContext = getCurrentReactContext();
      if ((localReactContext != null) && (localReactContext.hasActiveCatalystInstance()))
        detachViewFromInstance(paramReactRootView, localReactContext.getCatalystInstance());
    }
  }

  @Nullable
  @VisibleForTesting
  public ReactContext getCurrentReactContext()
  {
    synchronized (this.mReactContextLock)
    {
      ReactContext localReactContext = this.mCurrentReactContext;
      return localReactContext;
    }
  }

  public DevSupportManager getDevSupportManager()
  {
    return this.mDevSupportManager;
  }

  public LifecycleState getLifecycleState()
  {
    return this.mLifecycleState;
  }

  public MemoryPressureRouter getMemoryPressureRouter()
  {
    return this.mMemoryPressureRouter;
  }

  public int getMinNumShakes()
  {
    return this.mMinNumShakes;
  }

  public List<String> getViewManagerNames()
  {
    ReactApplicationContext localReactApplicationContext = (ReactApplicationContext)Assertions.assertNotNull((ReactApplicationContext)getCurrentReactContext());
    HashSet localHashSet;
    synchronized (this.mPackages)
    {
      localHashSet = new HashSet();
      Iterator localIterator = this.mPackages.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (ReactPackage)localIterator.next();
        if (!(localObject2 instanceof ViewManagerOnDemandReactPackage))
          continue;
        localObject2 = ((ViewManagerOnDemandReactPackage)localObject2).getViewManagerNames(localReactApplicationContext);
        if (localObject2 == null)
          continue;
        localHashSet.addAll((Collection)localObject2);
      }
    }
    ArrayList localArrayList = new ArrayList(localHashSet);
    monitorexit;
    return (List<String>)localArrayList;
  }

  public boolean hasStartedCreatingInitialContext()
  {
    return this.mHasStartedCreatingInitialContext;
  }

  @ThreadConfined("UI")
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReactContext localReactContext = getCurrentReactContext();
    if (localReactContext != null)
      localReactContext.onActivityResult(paramActivity, paramInt1, paramInt2, paramIntent);
  }

  public void onBackPressed()
  {
    UiThreadUtil.assertOnUiThread();
    ReactContext localReactContext = this.mCurrentReactContext;
    if (localReactContext == null)
    {
      FLog.w("ReactNative", "Instance detached from instance manager");
      invokeDefaultOnBackPressed();
      return;
    }
    ((DeviceEventManagerModule)localReactContext.getNativeModule(DeviceEventManagerModule.class)).emitHardwareBackPressed();
  }

  @ThreadConfined("UI")
  public void onHostDestroy()
  {
    UiThreadUtil.assertOnUiThread();
    if (this.mUseDeveloperSupport)
      this.mDevSupportManager.setDevSupportEnabled(false);
    moveToBeforeCreateLifecycleState();
    this.mCurrentActivity = null;
  }

  @ThreadConfined("UI")
  public void onHostDestroy(Activity paramActivity)
  {
    if (paramActivity == this.mCurrentActivity)
      onHostDestroy();
  }

  @ThreadConfined("UI")
  public void onHostPause()
  {
    UiThreadUtil.assertOnUiThread();
    this.mDefaultBackButtonImpl = null;
    if (this.mUseDeveloperSupport)
      this.mDevSupportManager.setDevSupportEnabled(false);
    moveToBeforeResumeLifecycleState();
  }

  @ThreadConfined("UI")
  public void onHostPause(Activity paramActivity)
  {
    Assertions.assertNotNull(this.mCurrentActivity);
    if (paramActivity == this.mCurrentActivity);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool, "Pausing an activity that is not the current activity, this is incorrect! Current activity: " + this.mCurrentActivity.getClass().getSimpleName() + " " + "Paused activity: " + paramActivity.getClass().getSimpleName());
      onHostPause();
      return;
    }
  }

  @ThreadConfined("UI")
  public void onHostResume(Activity paramActivity, DefaultHardwareBackBtnHandler paramDefaultHardwareBackBtnHandler)
  {
    UiThreadUtil.assertOnUiThread();
    this.mDefaultBackButtonImpl = paramDefaultHardwareBackBtnHandler;
    if (this.mUseDeveloperSupport)
      this.mDevSupportManager.setDevSupportEnabled(true);
    this.mCurrentActivity = paramActivity;
    moveToResumedLifecycleState(false);
  }

  @ThreadConfined("UI")
  public void onNewIntent(Intent paramIntent)
  {
    UiThreadUtil.assertOnUiThread();
    ReactContext localReactContext = getCurrentReactContext();
    if (localReactContext == null)
    {
      FLog.w("ReactNative", "Instance detached from instance manager");
      return;
    }
    String str = paramIntent.getAction();
    Uri localUri = paramIntent.getData();
    if (("android.intent.action.VIEW".equals(str)) && (localUri != null))
      ((DeviceEventManagerModule)localReactContext.getNativeModule(DeviceEventManagerModule.class)).emitNewIntentReceived(localUri);
    localReactContext.onNewIntent(this.mCurrentActivity, paramIntent);
  }

  @ThreadConfined("UI")
  public void recreateReactContextInBackground()
  {
    Assertions.assertCondition(this.mHasStartedCreatingInitialContext, "recreateReactContextInBackground should only be called after the initial createReactContextInBackground call.");
    recreateReactContextInBackgroundInner();
  }

  @ThreadConfined("UI")
  public void registerAdditionalPackages(List<ReactPackage> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
      return;
    if (!hasStartedCreatingInitialContext())
    {
      synchronized (this.mPackages)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          ReactPackage localReactPackage = (ReactPackage)paramList.next();
          if (this.mPackages.contains(localReactPackage))
            continue;
          this.mPackages.add(localReactPackage);
        }
      }
      monitorexit;
      return;
    }
    ??? = getCurrentReactContext();
    if (??? != null);
    for (??? = ((ReactContext)???).getCatalystInstance(); ; ??? = null)
    {
      Assertions.assertNotNull(???, "CatalystInstance null after hasStartedCreatingInitialContext true.");
      ((CatalystInstance)???).extendNativeModules(processPackages(new ReactApplicationContext(this.mApplicationContext), paramList, true));
      return;
    }
  }

  public void registerInitFunction(String paramString1, String paramString2, @Nullable NativeArray paramNativeArray)
  {
    paramString2 = new CatalystInstanceImpl.PendingJSCall(paramString1, paramString2, paramNativeArray);
    monitorenter;
    while (true)
    {
      try
      {
        this.mInitFunctions.add(paramString2);
        monitorexit;
        paramString1 = getCurrentReactContext();
        if (paramString1 == null)
        {
          paramString1 = null;
          if (paramString1 != null)
            break;
          return;
        }
      }
      finally
      {
        monitorexit;
      }
      paramString1 = paramString1.getCatalystInstance();
    }
    ((CatalystInstanceImpl)paramString1).callFunction(paramString2);
  }

  public void removeReactInstanceEventListener(ReactInstanceEventListener paramReactInstanceEventListener)
  {
    this.mReactInstanceEventListeners.remove(paramReactInstanceEventListener);
  }

  @ThreadConfined("UI")
  public void showDevOptionsDialog()
  {
    UiThreadUtil.assertOnUiThread();
    this.mDevSupportManager.showDevOptionsDialog();
  }

  private class ReactContextInitParams
  {
    private final JSBundleLoader mJsBundleLoader;
    private final JavaScriptExecutorFactory mJsExecutorFactory;

    public ReactContextInitParams(JavaScriptExecutorFactory paramJSBundleLoader, JSBundleLoader arg3)
    {
      this.mJsExecutorFactory = ((JavaScriptExecutorFactory)Assertions.assertNotNull(paramJSBundleLoader));
      Object localObject;
      this.mJsBundleLoader = ((JSBundleLoader)Assertions.assertNotNull(localObject));
    }

    public JSBundleLoader getJsBundleLoader()
    {
      return this.mJsBundleLoader;
    }

    public JavaScriptExecutorFactory getJsExecutorFactory()
    {
      return this.mJsExecutorFactory;
    }
  }

  public static abstract interface ReactInstanceEventListener
  {
    public abstract void onReactContextInitialized(ReactContext paramReactContext);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.ReactInstanceManager
 * JD-Core Version:    0.6.0
 */
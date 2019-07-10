package com.facebook.react.bridge;

import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.Log;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.QueueThreadExceptionHandler;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.bridge.queue.ReactQueueConfigurationImpl;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.systrace.TraceListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@DoNotStrip
public class CatalystInstanceImpl
  implements CatalystInstance
{
  private static final AtomicInteger sNextInstanceIdForTrace;
  private volatile boolean mAcceptCalls = false;
  private final CopyOnWriteArrayList<NotThreadSafeBridgeIdleDebugListener> mBridgeIdleListeners;
  private volatile boolean mDestroyed = false;
  private final HybridData mHybridData;
  private boolean mInitialized = false;
  private boolean mJSBundleHasLoaded;
  private final JSBundleLoader mJSBundleLoader;
  private final ArrayList<PendingJSCall> mJSCallsPendingInit = new ArrayList();
  private final Object mJSCallsPendingInitLock = new Object();
  private final JavaScriptModuleRegistry mJSModuleRegistry;
  private JavaScriptContextHolder mJavaScriptContextHolder;
  private final String mJsPendingCallsTitleForTrace = "pending_js_calls_instance" + sNextInstanceIdForTrace.getAndIncrement();
  private final NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
  private final NativeModuleRegistry mNativeModuleRegistry;
  private final MessageQueueThread mNativeModulesQueueThread;
  private final AtomicInteger mPendingJSCalls = new AtomicInteger(0);
  private final ReactQueueConfigurationImpl mReactQueueConfiguration;

  @Nullable
  private String mSourceURL;
  private final TraceListener mTraceListener;

  @Nullable
  private final MessageQueueThread mUIBackgroundQueueThread;

  static
  {
    ReactBridge.staticInit();
    sNextInstanceIdForTrace = new AtomicInteger(1);
  }

  private CatalystInstanceImpl(ReactQueueConfigurationSpec paramReactQueueConfigurationSpec, JavaScriptExecutor paramJavaScriptExecutor, NativeModuleRegistry paramNativeModuleRegistry, JSBundleLoader paramJSBundleLoader, NativeModuleCallExceptionHandler paramNativeModuleCallExceptionHandler)
  {
    Log.d("ReactNative", "Initializing React Xplat Bridge.");
    this.mHybridData = initHybrid();
    this.mReactQueueConfiguration = ReactQueueConfigurationImpl.create(paramReactQueueConfigurationSpec, new NativeExceptionHandler(null));
    this.mBridgeIdleListeners = new CopyOnWriteArrayList();
    this.mNativeModuleRegistry = paramNativeModuleRegistry;
    this.mJSModuleRegistry = new JavaScriptModuleRegistry();
    this.mJSBundleLoader = paramJSBundleLoader;
    this.mNativeModuleCallExceptionHandler = paramNativeModuleCallExceptionHandler;
    this.mNativeModulesQueueThread = this.mReactQueueConfiguration.getNativeModulesQueueThread();
    this.mUIBackgroundQueueThread = this.mReactQueueConfiguration.getUIBackgroundQueueThread();
    this.mTraceListener = new JSProfilerTraceListener(this);
    Log.d("ReactNative", "Initializing React Xplat Bridge before initializeBridge");
    initializeBridge(new BridgeCallback(this), paramJavaScriptExecutor, this.mReactQueueConfiguration.getJSQueueThread(), this.mNativeModulesQueueThread, this.mUIBackgroundQueueThread, this.mNativeModuleRegistry.getJavaModules(this), this.mNativeModuleRegistry.getCxxModules());
    Log.d("ReactNative", "Initializing React Xplat Bridge after initializeBridge");
    this.mJavaScriptContextHolder = new JavaScriptContextHolder(getJavaScriptContext());
  }

  private void decrementPendingJSCalls()
  {
    int j = this.mPendingJSCalls.decrementAndGet();
    if (j == 0);
    for (int i = 1; ; i = 0)
    {
      com.facebook.systrace.Systrace.traceCounter(0L, this.mJsPendingCallsTitleForTrace, j);
      if ((i != 0) && (!this.mBridgeIdleListeners.isEmpty()))
        this.mNativeModulesQueueThread.runOnQueue(new Runnable()
        {
          public void run()
          {
            Iterator localIterator = CatalystInstanceImpl.this.mBridgeIdleListeners.iterator();
            while (localIterator.hasNext())
              ((NotThreadSafeBridgeIdleDebugListener)localIterator.next()).onTransitionToBridgeIdle();
          }
        });
      return;
    }
  }

  private native long getJavaScriptContext();

  private void incrementPendingJSCalls()
  {
    int j = this.mPendingJSCalls.getAndIncrement();
    if (j == 0);
    for (int i = 1; ; i = 0)
    {
      com.facebook.systrace.Systrace.traceCounter(0L, this.mJsPendingCallsTitleForTrace, j + 1);
      if ((i != 0) && (!this.mBridgeIdleListeners.isEmpty()))
        this.mNativeModulesQueueThread.runOnQueue(new Runnable()
        {
          public void run()
          {
            Iterator localIterator = CatalystInstanceImpl.this.mBridgeIdleListeners.iterator();
            while (localIterator.hasNext())
              ((NotThreadSafeBridgeIdleDebugListener)localIterator.next()).onTransitionToBridgeBusy();
          }
        });
      return;
    }
  }

  private static native HybridData initHybrid();

  private native void initializeBridge(ReactCallback paramReactCallback, JavaScriptExecutor paramJavaScriptExecutor, MessageQueueThread paramMessageQueueThread1, MessageQueueThread paramMessageQueueThread2, MessageQueueThread paramMessageQueueThread3, Collection<JavaModuleWrapper> paramCollection, Collection<ModuleHolder> paramCollection1);

  private native void jniCallJSCallback(int paramInt, NativeArray paramNativeArray);

  private native void jniCallJSFunction(String paramString1, String paramString2, NativeArray paramNativeArray);

  private native void jniExtendNativeModules(Collection<JavaModuleWrapper> paramCollection, Collection<ModuleHolder> paramCollection1);

  private native void jniHandleMemoryPressure(int paramInt);

  private native void jniLoadScriptFromAssets(AssetManager paramAssetManager, String paramString, boolean paramBoolean);

  private native void jniLoadScriptFromFile(String paramString1, String paramString2, boolean paramBoolean);

  private native void jniSetSourceURL(String paramString);

  private void onNativeException(Exception paramException)
  {
    this.mNativeModuleCallExceptionHandler.handleException(paramException);
    this.mReactQueueConfiguration.getUIQueueThread().runOnQueue(new Runnable()
    {
      public void run()
      {
        CatalystInstanceImpl.this.destroy();
      }
    });
  }

  public void addBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener)
  {
    this.mBridgeIdleListeners.add(paramNotThreadSafeBridgeIdleDebugListener);
  }

  public void callFunction(PendingJSCall paramPendingJSCall)
  {
    if (this.mDestroyed)
    {
      paramPendingJSCall = paramPendingJSCall.toString();
      FLog.w("ReactNative", "Calling JS function after bridge has been destroyed: " + paramPendingJSCall);
      return;
    }
    if (!this.mAcceptCalls)
    {
      synchronized (this.mJSCallsPendingInitLock)
      {
        if (!this.mAcceptCalls)
        {
          this.mJSCallsPendingInit.add(paramPendingJSCall);
          return;
        }
      }
      monitorexit;
    }
    paramPendingJSCall.call(this);
  }

  public void callFunction(String paramString1, String paramString2, NativeArray paramNativeArray)
  {
    callFunction(new PendingJSCall(paramString1, paramString2, paramNativeArray));
  }

  public void destroy()
  {
    Log.d("ReactNative", "CatalystInstanceImpl.destroy() start");
    UiThreadUtil.assertOnUiThread();
    if (this.mDestroyed)
      return;
    this.mDestroyed = true;
    this.mNativeModulesQueueThread.runOnQueue(new Runnable()
    {
      public void run()
      {
        int i = 0;
        CatalystInstanceImpl.this.mNativeModuleRegistry.notifyJSInstanceDestroy();
        if (CatalystInstanceImpl.this.mPendingJSCalls.getAndSet(0) == 0)
          i = 1;
        if ((i == 0) && (!CatalystInstanceImpl.this.mBridgeIdleListeners.isEmpty()))
        {
          Iterator localIterator = CatalystInstanceImpl.this.mBridgeIdleListeners.iterator();
          while (localIterator.hasNext())
            ((NotThreadSafeBridgeIdleDebugListener)localIterator.next()).onTransitionToBridgeIdle();
        }
        AsyncTask.execute(new Runnable()
        {
          public void run()
          {
            CatalystInstanceImpl.this.mJavaScriptContextHolder.clear();
            CatalystInstanceImpl.this.mHybridData.resetNative();
            CatalystInstanceImpl.this.getReactQueueConfiguration().destroy();
            Log.d("ReactNative", "CatalystInstanceImpl.destroy() end");
          }
        });
      }
    });
    com.facebook.systrace.Systrace.unregisterListener(this.mTraceListener);
  }

  public void extendNativeModules(NativeModuleRegistry paramNativeModuleRegistry)
  {
    this.mNativeModuleRegistry.registerModules(paramNativeModuleRegistry);
    jniExtendNativeModules(paramNativeModuleRegistry.getJavaModules(this), paramNativeModuleRegistry.getCxxModules());
  }

  public <T extends JavaScriptModule> T getJSModule(Class<T> paramClass)
  {
    return this.mJSModuleRegistry.getJavaScriptModule(this, paramClass);
  }

  public JavaScriptContextHolder getJavaScriptContextHolder()
  {
    return this.mJavaScriptContextHolder;
  }

  public <T extends NativeModule> T getNativeModule(Class<T> paramClass)
  {
    return this.mNativeModuleRegistry.getModule(paramClass);
  }

  public Collection<NativeModule> getNativeModules()
  {
    return this.mNativeModuleRegistry.getAllModules();
  }

  public ReactQueueConfiguration getReactQueueConfiguration()
  {
    return this.mReactQueueConfiguration;
  }

  @Nullable
  public String getSourceURL()
  {
    return this.mSourceURL;
  }

  public void handleMemoryPressure(int paramInt)
  {
    if (this.mDestroyed)
      return;
    jniHandleMemoryPressure(paramInt);
  }

  public <T extends NativeModule> boolean hasNativeModule(Class<T> paramClass)
  {
    return this.mNativeModuleRegistry.hasModule(paramClass);
  }

  public boolean hasRunJSBundle()
  {
    while (true)
    {
      synchronized (this.mJSCallsPendingInitLock)
      {
        if ((this.mJSBundleHasLoaded) && (this.mAcceptCalls))
        {
          i = 1;
          return i;
        }
      }
      int i = 0;
    }
  }

  @VisibleForTesting
  public void initialize()
  {
    Log.d("ReactNative", "CatalystInstanceImpl.initialize()");
    if (!this.mInitialized);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool, "This catalyst instance has already been initialized");
      Assertions.assertCondition(this.mAcceptCalls, "RunJSBundle hasn't completed.");
      this.mInitialized = true;
      this.mNativeModulesQueueThread.runOnQueue(new Runnable()
      {
        public void run()
        {
          CatalystInstanceImpl.this.mNativeModuleRegistry.notifyJSInstanceInitialized();
        }
      });
      return;
    }
  }

  public void invokeCallback(int paramInt, NativeArray paramNativeArray)
  {
    if (this.mDestroyed)
    {
      FLog.w("ReactNative", "Invoking JS callback after bridge has been destroyed.");
      return;
    }
    jniCallJSCallback(paramInt, paramNativeArray);
  }

  public boolean isDestroyed()
  {
    return this.mDestroyed;
  }

  void loadScriptFromAssets(AssetManager paramAssetManager, String paramString, boolean paramBoolean)
  {
    this.mSourceURL = paramString;
    jniLoadScriptFromAssets(paramAssetManager, paramString, paramBoolean);
  }

  void loadScriptFromFile(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.mSourceURL = paramString2;
    jniLoadScriptFromFile(paramString1, paramString2, paramBoolean);
  }

  public void removeBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener)
  {
    this.mBridgeIdleListeners.remove(paramNotThreadSafeBridgeIdleDebugListener);
  }

  public void runJSBundle()
  {
    boolean bool = true;
    Log.d("ReactNative", "CatalystInstanceImpl.runJSBundle()");
    if (!this.mJSBundleHasLoaded);
    while (true)
    {
      Assertions.assertCondition(bool, "JS bundle was already loaded!");
      this.mJSBundleLoader.loadScript(this);
      synchronized (this.mJSCallsPendingInitLock)
      {
        this.mAcceptCalls = true;
        Iterator localIterator = this.mJSCallsPendingInit.iterator();
        if (!localIterator.hasNext())
          break;
        ((PendingJSCall)localIterator.next()).call(this);
      }
      bool = false;
    }
    this.mJSCallsPendingInit.clear();
    this.mJSBundleHasLoaded = true;
    monitorexit;
    com.facebook.systrace.Systrace.registerListener(this.mTraceListener);
  }

  public native void setGlobalVariable(String paramString1, String paramString2);

  void setSourceURLs(String paramString1, String paramString2)
  {
    this.mSourceURL = paramString1;
    jniSetSourceURL(paramString2);
  }

  private static class BridgeCallback
    implements ReactCallback
  {
    private final WeakReference<CatalystInstanceImpl> mOuter;

    public BridgeCallback(CatalystInstanceImpl paramCatalystInstanceImpl)
    {
      this.mOuter = new WeakReference(paramCatalystInstanceImpl);
    }

    public void decrementPendingJSCalls()
    {
      CatalystInstanceImpl localCatalystInstanceImpl = (CatalystInstanceImpl)this.mOuter.get();
      if (localCatalystInstanceImpl != null)
        localCatalystInstanceImpl.decrementPendingJSCalls();
    }

    public void incrementPendingJSCalls()
    {
      CatalystInstanceImpl localCatalystInstanceImpl = (CatalystInstanceImpl)this.mOuter.get();
      if (localCatalystInstanceImpl != null)
        localCatalystInstanceImpl.incrementPendingJSCalls();
    }

    public void onBatchComplete()
    {
      CatalystInstanceImpl localCatalystInstanceImpl = (CatalystInstanceImpl)this.mOuter.get();
      if (localCatalystInstanceImpl != null)
        localCatalystInstanceImpl.mNativeModuleRegistry.onBatchComplete();
    }
  }

  public static class Builder
  {

    @Nullable
    private JSBundleLoader mJSBundleLoader;

    @Nullable
    private JavaScriptExecutor mJSExecutor;

    @Nullable
    private NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;

    @Nullable
    private ReactQueueConfigurationSpec mReactQueueConfigurationSpec;

    @Nullable
    private NativeModuleRegistry mRegistry;

    public CatalystInstanceImpl build()
    {
      return new CatalystInstanceImpl((ReactQueueConfigurationSpec)Assertions.assertNotNull(this.mReactQueueConfigurationSpec), (JavaScriptExecutor)Assertions.assertNotNull(this.mJSExecutor), (NativeModuleRegistry)Assertions.assertNotNull(this.mRegistry), (JSBundleLoader)Assertions.assertNotNull(this.mJSBundleLoader), (NativeModuleCallExceptionHandler)Assertions.assertNotNull(this.mNativeModuleCallExceptionHandler), null);
    }

    public Builder setJSBundleLoader(JSBundleLoader paramJSBundleLoader)
    {
      this.mJSBundleLoader = paramJSBundleLoader;
      return this;
    }

    public Builder setJSExecutor(JavaScriptExecutor paramJavaScriptExecutor)
    {
      this.mJSExecutor = paramJavaScriptExecutor;
      return this;
    }

    public Builder setNativeModuleCallExceptionHandler(NativeModuleCallExceptionHandler paramNativeModuleCallExceptionHandler)
    {
      this.mNativeModuleCallExceptionHandler = paramNativeModuleCallExceptionHandler;
      return this;
    }

    public Builder setReactQueueConfigurationSpec(ReactQueueConfigurationSpec paramReactQueueConfigurationSpec)
    {
      this.mReactQueueConfigurationSpec = paramReactQueueConfigurationSpec;
      return this;
    }

    public Builder setRegistry(NativeModuleRegistry paramNativeModuleRegistry)
    {
      this.mRegistry = paramNativeModuleRegistry;
      return this;
    }
  }

  private static class JSProfilerTraceListener
    implements TraceListener
  {
    private final WeakReference<CatalystInstanceImpl> mOuter;

    public JSProfilerTraceListener(CatalystInstanceImpl paramCatalystInstanceImpl)
    {
      this.mOuter = new WeakReference(paramCatalystInstanceImpl);
    }

    public void onTraceStarted()
    {
      CatalystInstanceImpl localCatalystInstanceImpl = (CatalystInstanceImpl)this.mOuter.get();
      if (localCatalystInstanceImpl != null)
        ((Systrace)localCatalystInstanceImpl.getJSModule(Systrace.class)).setEnabled(true);
    }

    public void onTraceStopped()
    {
      CatalystInstanceImpl localCatalystInstanceImpl = (CatalystInstanceImpl)this.mOuter.get();
      if (localCatalystInstanceImpl != null)
        ((Systrace)localCatalystInstanceImpl.getJSModule(Systrace.class)).setEnabled(false);
    }
  }

  private class NativeExceptionHandler
    implements QueueThreadExceptionHandler
  {
    private NativeExceptionHandler()
    {
    }

    public void handleException(Exception paramException)
    {
      CatalystInstanceImpl.this.onNativeException(paramException);
    }
  }

  public static class PendingJSCall
  {

    @Nullable
    public NativeArray mArguments;
    public String mMethod;
    public String mModule;

    public PendingJSCall(String paramString1, String paramString2, @Nullable NativeArray paramNativeArray)
    {
      this.mModule = paramString1;
      this.mMethod = paramString2;
      this.mArguments = paramNativeArray;
    }

    void call(CatalystInstanceImpl paramCatalystInstanceImpl)
    {
      if (this.mArguments != null);
      for (Object localObject = this.mArguments; ; localObject = new WritableNativeArray())
      {
        paramCatalystInstanceImpl.jniCallJSFunction(this.mModule, this.mMethod, (NativeArray)localObject);
        return;
      }
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append(this.mModule).append(".").append(this.mMethod).append("(");
      if (this.mArguments == null);
      for (String str = ""; ; str = this.mArguments.toString())
        return str + ")";
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.CatalystInstanceImpl
 * JD-Core Version:    0.6.0
 */
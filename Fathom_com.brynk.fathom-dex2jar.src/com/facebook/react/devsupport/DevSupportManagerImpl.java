package com.facebook.react.devsupport;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.hardware.SensorManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.Window;
import android.widget.Toast;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.Printer;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R.string;
import com.facebook.react.bridge.DefaultNativeModuleCallExceptionHandler;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.JavaJSExecutor.Factory;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.common.ShakeDetector;
import com.facebook.react.common.ShakeDetector.ShakeListener;
import com.facebook.react.common.futures.SimpleSettableFuture;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.ErrorCustomizer;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.packagerconnection.Responder;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;

public class DevSupportManagerImpl
  implements DevSupportManager, DevServerHelper.PackagerCommandListener, DevInternalSettings.Listener
{
  private static final String EXOPACKAGE_LOCATION_FORMAT = "/data/local/tmp/exopackage/%s//secondary-dex";
  private static final int JAVA_ERROR_COOKIE = -1;
  private static final int JSEXCEPTION_ERROR_COOKIE = -1;
  private static final String JS_BUNDLE_FILE_NAME = "ReactNativeDevBundle.js";
  private final Context mApplicationContext;

  @Nullable
  private DevBundleDownloadListener mBundleDownloadListener;

  @Nullable
  private ReactContext mCurrentContext;
  private final LinkedHashMap<String, DevOptionHandler> mCustomDevOptions = new LinkedHashMap();

  @Nullable
  private DebugOverlayController mDebugOverlayController;
  private final DefaultNativeModuleCallExceptionHandler mDefaultNativeModuleCallExceptionHandler;
  private final DevLoadingViewController mDevLoadingViewController;
  private boolean mDevLoadingViewVisible = false;

  @Nullable
  private AlertDialog mDevOptionsDialog;
  private final DevServerHelper mDevServerHelper;
  private DevInternalSettings mDevSettings;

  @Nullable
  private List<ErrorCustomizer> mErrorCustomizers;
  private boolean mIsDevSupportEnabled = false;
  private boolean mIsReceiverRegistered = false;
  private boolean mIsShakeDetectorStarted = false;

  @Nullable
  private final String mJSAppBundleName;
  private final File mJSBundleTempFile;
  private int mLastErrorCookie = 0;

  @Nullable
  private StackFrame[] mLastErrorStack;

  @Nullable
  private String mLastErrorTitle;

  @Nullable
  private ErrorType mLastErrorType;
  private final ReactInstanceDevCommandsHandler mReactInstanceCommandsHandler;

  @Nullable
  private RedBoxDialog mRedBoxDialog;

  @Nullable
  private RedBoxHandler mRedBoxHandler;
  private final BroadcastReceiver mReloadAppBroadcastReceiver;
  private final ShakeDetector mShakeDetector;

  public DevSupportManagerImpl(Context paramContext, ReactInstanceDevCommandsHandler paramReactInstanceDevCommandsHandler, @Nullable String paramString, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramReactInstanceDevCommandsHandler, paramString, paramBoolean, null, null, paramInt);
  }

  public DevSupportManagerImpl(Context paramContext, ReactInstanceDevCommandsHandler paramReactInstanceDevCommandsHandler, @Nullable String paramString, boolean paramBoolean, @Nullable RedBoxHandler paramRedBoxHandler, @Nullable DevBundleDownloadListener paramDevBundleDownloadListener, int paramInt)
  {
    this.mReactInstanceCommandsHandler = paramReactInstanceDevCommandsHandler;
    this.mApplicationContext = paramContext;
    this.mJSAppBundleName = paramString;
    this.mDevSettings = new DevInternalSettings(paramContext, this);
    this.mDevServerHelper = new DevServerHelper(this.mDevSettings, this.mApplicationContext.getPackageName());
    this.mBundleDownloadListener = paramDevBundleDownloadListener;
    this.mShakeDetector = new ShakeDetector(new ShakeDetector.ShakeListener()
    {
      public void onShake()
      {
        DevSupportManagerImpl.this.showDevOptionsDialog();
      }
    }
    , paramInt);
    this.mReloadAppBroadcastReceiver = new BroadcastReceiver()
    {
      public void onReceive(Context paramContext, Intent paramIntent)
      {
        String str = paramIntent.getAction();
        if (DevServerHelper.getReloadAppAction(paramContext).equals(str))
        {
          if (!paramIntent.getBooleanExtra("jsproxy", false))
            break label55;
          DevSupportManagerImpl.this.mDevSettings.setRemoteJSDebugEnabled(true);
          DevSupportManagerImpl.this.mDevServerHelper.launchJSDevtools();
        }
        while (true)
        {
          DevSupportManagerImpl.this.handleReloadJS();
          return;
          label55: DevSupportManagerImpl.this.mDevSettings.setRemoteJSDebugEnabled(false);
        }
      }
    };
    this.mJSBundleTempFile = new File(paramContext.getFilesDir(), "ReactNativeDevBundle.js");
    this.mDefaultNativeModuleCallExceptionHandler = new DefaultNativeModuleCallExceptionHandler();
    setDevSupportEnabled(paramBoolean);
    this.mRedBoxHandler = paramRedBoxHandler;
    this.mDevLoadingViewController = new DevLoadingViewController(paramContext);
  }

  private WebsocketJavaScriptExecutor.JSExecutorConnectCallback getExecutorConnectCallback(SimpleSettableFuture<Boolean> paramSimpleSettableFuture)
  {
    return new WebsocketJavaScriptExecutor.JSExecutorConnectCallback(paramSimpleSettableFuture)
    {
      public void onFailure(Throwable paramThrowable)
      {
        DevSupportManagerImpl.this.mDevLoadingViewController.hide();
        DevSupportManagerImpl.access$1602(DevSupportManagerImpl.this, false);
        FLog.e("ReactNative", "Unable to connect to remote debugger", paramThrowable);
        this.val$future.setException(new IOException(DevSupportManagerImpl.this.mApplicationContext.getString(R.string.catalyst_remotedbg_error), paramThrowable));
      }

      public void onSuccess()
      {
        this.val$future.set(Boolean.valueOf(true));
        DevSupportManagerImpl.this.mDevLoadingViewController.hide();
        DevSupportManagerImpl.access$1602(DevSupportManagerImpl.this, false);
      }
    };
  }

  private void handleCaptureHeap(Responder paramResponder)
  {
    if (this.mCurrentContext == null)
      return;
    ((JSCHeapCapture)this.mCurrentContext.getNativeModule(JSCHeapCapture.class)).captureHeap(this.mApplicationContext.getCacheDir().getPath(), new JSCHeapCapture.CaptureCallback(paramResponder)
    {
      public void onFailure(JSCHeapCapture.CaptureException paramCaptureException)
      {
        this.val$responder.error(paramCaptureException.toString());
      }

      public void onSuccess(File paramFile)
      {
        this.val$responder.respond(paramFile.toString());
      }
    });
  }

  private void handlePokeSamplingProfiler()
  {
    while (true)
    {
      try
      {
        Iterator localIterator = JSCSamplingProfiler.poke(60000L).iterator();
        if (localIterator.hasNext())
        {
          String str3 = (String)localIterator.next();
          ReactContext localReactContext = this.mCurrentContext;
          if (str3 != null)
            break label96;
          String str1 = "Started JSC Sampling Profiler";
          Toast.makeText(localReactContext, str1, 1).show();
          new JscProfileTask(getSourceUrl(), null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[] { str3 });
          continue;
        }
      }
      catch (JSCSamplingProfiler.ProfilerException localProfilerException)
      {
        showNewJavaError(localProfilerException.getMessage(), localProfilerException);
      }
      return;
      label96: String str2 = "Stopped JSC Sampling Profiler";
    }
  }

  private Pair<String, StackFrame[]> processErrorCustomizers(Pair<String, StackFrame[]> paramPair)
  {
    if (this.mErrorCustomizers == null)
      return paramPair;
    Iterator localIterator = this.mErrorCustomizers.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = ((ErrorCustomizer)localIterator.next()).customizeErrorInfo(paramPair);
      if (localPair == null)
        continue;
      paramPair = localPair;
    }
    return paramPair;
  }

  private void reload()
  {
    if (this.mIsDevSupportEnabled)
    {
      if (this.mDebugOverlayController != null)
        this.mDebugOverlayController.setFpsDebugViewVisible(this.mDevSettings.isFpsDebugEnabled());
      if (!this.mIsShakeDetectorStarted)
      {
        this.mShakeDetector.start((SensorManager)this.mApplicationContext.getSystemService("sensor"));
        this.mIsShakeDetectorStarted = true;
      }
      if (!this.mIsReceiverRegistered)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction(DevServerHelper.getReloadAppAction(this.mApplicationContext));
        this.mApplicationContext.registerReceiver(this.mReloadAppBroadcastReceiver, localIntentFilter);
        this.mIsReceiverRegistered = true;
      }
      if (this.mDevLoadingViewVisible)
        this.mDevLoadingViewController.show();
      this.mDevServerHelper.openPackagerConnection(getClass().getSimpleName(), this);
      if (this.mDevSettings.isReloadOnJSChangeEnabled())
      {
        this.mDevServerHelper.startPollingOnChangeEndpoint(new DevServerHelper.OnServerContentChangeListener()
        {
          public void onServerContentChanged()
          {
            DevSupportManagerImpl.this.handleReloadJS();
          }
        });
        return;
      }
      this.mDevServerHelper.stopPollingOnChangeEndpoint();
      return;
    }
    if (this.mDebugOverlayController != null)
      this.mDebugOverlayController.setFpsDebugViewVisible(false);
    if (this.mIsShakeDetectorStarted)
    {
      this.mShakeDetector.stop();
      this.mIsShakeDetectorStarted = false;
    }
    if (this.mIsReceiverRegistered)
    {
      this.mApplicationContext.unregisterReceiver(this.mReloadAppBroadcastReceiver);
      this.mIsReceiverRegistered = false;
    }
    if (this.mRedBoxDialog != null)
      this.mRedBoxDialog.dismiss();
    if (this.mDevOptionsDialog != null)
      this.mDevOptionsDialog.dismiss();
    this.mDevLoadingViewController.hide();
    this.mDevServerHelper.closePackagerConnection();
    this.mDevServerHelper.stopPollingOnChangeEndpoint();
  }

  private void reloadJSInProxyMode()
  {
    this.mDevServerHelper.launchJSDevtools();
    20 local20 = new JavaJSExecutor.Factory()
    {
      public JavaJSExecutor create()
        throws Exception
      {
        WebsocketJavaScriptExecutor localWebsocketJavaScriptExecutor = new WebsocketJavaScriptExecutor();
        SimpleSettableFuture localSimpleSettableFuture = new SimpleSettableFuture();
        localWebsocketJavaScriptExecutor.connect(DevSupportManagerImpl.this.mDevServerHelper.getWebsocketProxyURL(), DevSupportManagerImpl.this.getExecutorConnectCallback(localSimpleSettableFuture));
        try
        {
          localSimpleSettableFuture.get(90L, TimeUnit.SECONDS);
          return localWebsocketJavaScriptExecutor;
        }
        catch (ExecutionException localExecutionException)
        {
          throw ((Exception)localExecutionException.getCause());
        }
        catch (InterruptedException localInterruptedException)
        {
          throw new RuntimeException(localInterruptedException);
        }
        catch (TimeoutException localTimeoutException)
        {
          label61: break label61;
        }
      }
    };
    this.mReactInstanceCommandsHandler.onReloadWithJSDebugger(local20);
  }

  private void resetCurrentContext(@Nullable ReactContext paramReactContext)
  {
    if (this.mCurrentContext == paramReactContext)
      return;
    this.mCurrentContext = paramReactContext;
    if (this.mDebugOverlayController != null)
      this.mDebugOverlayController.setFpsDebugViewVisible(false);
    if (paramReactContext != null)
      this.mDebugOverlayController = new DebugOverlayController(paramReactContext);
    if ((this.mDevSettings.isHotModuleReplacementEnabled()) && (this.mCurrentContext != null));
    try
    {
      paramReactContext = new URL(getSourceUrl());
      String str1 = paramReactContext.getPath().substring(1);
      String str2 = paramReactContext.getHost();
      int i = paramReactContext.getPort();
      ((HMRClient)this.mCurrentContext.getJSModule(HMRClient.class)).enable("android", str1, str2, i);
      reloadSettings();
      return;
    }
    catch (MalformedURLException paramReactContext)
    {
      while (true)
        showNewJavaError(paramReactContext.getMessage(), paramReactContext);
    }
  }

  private void showNewError(String paramString, StackFrame[] paramArrayOfStackFrame, int paramInt, ErrorType paramErrorType)
  {
    UiThreadUtil.runOnUiThread(new Runnable(paramString, paramArrayOfStackFrame, paramInt, paramErrorType)
    {
      public void run()
      {
        if (DevSupportManagerImpl.this.mRedBoxDialog == null)
        {
          DevSupportManagerImpl.access$202(DevSupportManagerImpl.this, new RedBoxDialog(DevSupportManagerImpl.this.mApplicationContext, DevSupportManagerImpl.this, DevSupportManagerImpl.this.mRedBoxHandler));
          DevSupportManagerImpl.this.mRedBoxDialog.getWindow().setType(WindowOverlayCompat.TYPE_SYSTEM_ALERT);
        }
        if (DevSupportManagerImpl.this.mRedBoxDialog.isShowing())
          return;
        Pair localPair = DevSupportManagerImpl.this.processErrorCustomizers(Pair.create(this.val$message, this.val$stack));
        DevSupportManagerImpl.this.mRedBoxDialog.setExceptionDetails((String)localPair.first, (StackFrame[])localPair.second);
        DevSupportManagerImpl.this.updateLastErrorInfo(this.val$message, this.val$stack, this.val$errorCookie, this.val$errorType);
        if ((DevSupportManagerImpl.this.mRedBoxHandler != null) && (this.val$errorType == DevSupportManagerImpl.ErrorType.NATIVE))
        {
          DevSupportManagerImpl.this.mRedBoxHandler.handleRedbox(this.val$message, this.val$stack, RedBoxHandler.ErrorType.NATIVE);
          DevSupportManagerImpl.this.mRedBoxDialog.resetReporting(true);
        }
        while (true)
        {
          DevSupportManagerImpl.this.mRedBoxDialog.show();
          return;
          DevSupportManagerImpl.this.mRedBoxDialog.resetReporting(false);
        }
      }
    });
  }

  private void updateLastErrorInfo(String paramString, StackFrame[] paramArrayOfStackFrame, int paramInt, ErrorType paramErrorType)
  {
    this.mLastErrorTitle = paramString;
    this.mLastErrorStack = paramArrayOfStackFrame;
    this.mLastErrorCookie = paramInt;
    this.mLastErrorType = paramErrorType;
  }

  public void addCustomDevOption(String paramString, DevOptionHandler paramDevOptionHandler)
  {
    this.mCustomDevOptions.put(paramString, paramDevOptionHandler);
  }

  @Nullable
  public File downloadBundleResourceFromUrlSync(String paramString, File paramFile)
  {
    return this.mDevServerHelper.downloadBundleResourceFromUrlSync(paramString, paramFile);
  }

  public DeveloperSettings getDevSettings()
  {
    return this.mDevSettings;
  }

  public boolean getDevSupportEnabled()
  {
    return this.mIsDevSupportEnabled;
  }

  public String getDownloadedJSBundleFile()
  {
    return this.mJSBundleTempFile.getAbsolutePath();
  }

  public String getJSBundleURLForRemoteDebugging()
  {
    return this.mDevServerHelper.getJSBundleURLForRemoteDebugging((String)Assertions.assertNotNull(this.mJSAppBundleName));
  }

  @Nullable
  public StackFrame[] getLastErrorStack()
  {
    return this.mLastErrorStack;
  }

  @Nullable
  public String getLastErrorTitle()
  {
    return this.mLastErrorTitle;
  }

  public String getSourceMapUrl()
  {
    if (this.mJSAppBundleName == null)
      return "";
    return this.mDevServerHelper.getSourceMapUrl((String)Assertions.assertNotNull(this.mJSAppBundleName));
  }

  public String getSourceUrl()
  {
    if (this.mJSAppBundleName == null)
      return "";
    return this.mDevServerHelper.getSourceUrl((String)Assertions.assertNotNull(this.mJSAppBundleName));
  }

  public void handleException(Exception paramException)
  {
    if (this.mIsDevSupportEnabled)
    {
      String str = paramException.getMessage();
      for (Object localObject = paramException.getCause(); localObject != null; localObject = ((Throwable)localObject).getCause())
        str = str + "\n\n" + ((Throwable)localObject).getMessage();
      if ((paramException instanceof JSException))
      {
        FLog.e("ReactNative", "Exception in native call from JS", paramException);
        paramException = str + "\n\n" + ((JSException)paramException).getStack();
        localObject = ErrorType.JS;
        showNewError(paramException, new StackFrame[0], -1, (ErrorType)localObject);
        return;
      }
      showNewJavaError(str, paramException);
      return;
    }
    this.mDefaultNativeModuleCallExceptionHandler.handleException(paramException);
  }

  public void handleReloadJS()
  {
    UiThreadUtil.assertOnUiThread();
    ReactMarker.logMarker(ReactMarkerConstants.RELOAD);
    if (this.mRedBoxDialog != null)
      this.mRedBoxDialog.dismiss();
    if (this.mDevSettings.isRemoteJSDebugEnabled())
    {
      PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from Proxy");
      this.mDevLoadingViewController.showForRemoteJSEnabled();
      this.mDevLoadingViewVisible = true;
      reloadJSInProxyMode();
      return;
    }
    PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from Server");
    reloadJSFromServer(this.mDevServerHelper.getDevServerBundleURL((String)Assertions.assertNotNull(this.mJSAppBundleName)));
  }

  public boolean hasBundleInAssets(String paramString)
  {
    try
    {
      String[] arrayOfString = this.mApplicationContext.getAssets().list("");
      int i = 0;
      while (i < arrayOfString.length)
      {
        boolean bool = arrayOfString[i].equals(paramString);
        if (bool)
          return true;
        i += 1;
      }
    }
    catch (IOException paramString)
    {
      FLog.e("ReactNative", "Error while loading assets list");
    }
    return false;
  }

  public boolean hasUpToDateJSBundleInCache()
  {
    if ((this.mIsDevSupportEnabled) && (this.mJSBundleTempFile.exists()))
      try
      {
        Object localObject = this.mApplicationContext.getPackageName();
        PackageInfo localPackageInfo = this.mApplicationContext.getPackageManager().getPackageInfo((String)localObject, 0);
        if (this.mJSBundleTempFile.lastModified() > localPackageInfo.lastUpdateTime)
        {
          localObject = new File(String.format(Locale.US, "/data/local/tmp/exopackage/%s//secondary-dex", new Object[] { localObject }));
          long l1;
          long l2;
          if (((File)localObject).exists())
          {
            l1 = this.mJSBundleTempFile.lastModified();
            l2 = ((File)localObject).lastModified();
          }
          return l1 > l2;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        FLog.e("ReactNative", "DevSupport is unable to get current app info");
      }
    return false;
  }

  public void hideRedboxDialog()
  {
    if (this.mRedBoxDialog != null)
      this.mRedBoxDialog.dismiss();
  }

  public void isPackagerRunning(PackagerStatusCallback paramPackagerStatusCallback)
  {
    this.mDevServerHelper.isPackagerRunning(paramPackagerStatusCallback);
  }

  public void onCaptureHeapCommand(Responder paramResponder)
  {
    UiThreadUtil.runOnUiThread(new Runnable(paramResponder)
    {
      public void run()
      {
        DevSupportManagerImpl.this.handleCaptureHeap(this.val$responder);
      }
    });
  }

  public void onInternalSettingsChanged()
  {
    reloadSettings();
  }

  public void onNewReactContextCreated(ReactContext paramReactContext)
  {
    resetCurrentContext(paramReactContext);
  }

  public void onPackagerDevMenuCommand()
  {
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        DevSupportManagerImpl.this.showDevOptionsDialog();
      }
    });
  }

  public void onPackagerReloadCommand()
  {
    this.mDevServerHelper.disableDebugger();
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        DevSupportManagerImpl.this.handleReloadJS();
      }
    });
  }

  public void onPokeSamplingProfilerCommand(Responder paramResponder)
  {
    UiThreadUtil.runOnUiThread(new Runnable(paramResponder)
    {
      public void run()
      {
        if (DevSupportManagerImpl.this.mCurrentContext == null)
        {
          this.val$responder.error("JSCContext is missing, unable to profile");
          return;
        }
        try
        {
          synchronized (DevSupportManagerImpl.this.mCurrentContext.getJavaScriptContextHolder())
          {
            ((RequestHandler)Class.forName("com.facebook.react.packagerconnection.SamplingProfilerPackagerMethod").getConstructor(new Class[] { Long.TYPE }).newInstance(new Object[] { Long.valueOf(???.get()) })).onRequest(null, this.val$responder);
            return;
          }
        }
        catch (Exception localException)
        {
        }
      }
    });
  }

  public void onReactInstanceDestroyed(ReactContext paramReactContext)
  {
    if (paramReactContext == this.mCurrentContext)
      resetCurrentContext(null);
  }

  public void registerErrorCustomizer(ErrorCustomizer paramErrorCustomizer)
  {
    if (this.mErrorCustomizers == null)
      this.mErrorCustomizers = new ArrayList();
    this.mErrorCustomizers.add(paramErrorCustomizer);
  }

  public void reloadJSFromServer(String paramString)
  {
    ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_START);
    this.mDevLoadingViewController.showForUrl(paramString);
    this.mDevLoadingViewVisible = true;
    BundleDownloader.BundleInfo localBundleInfo = new BundleDownloader.BundleInfo();
    this.mDevServerHelper.getBundleDownloader().downloadBundleFromURL(new DevBundleDownloadListener(localBundleInfo)
    {
      public void onFailure(Exception paramException)
      {
        DevSupportManagerImpl.this.mDevLoadingViewController.hide();
        DevSupportManagerImpl.access$1602(DevSupportManagerImpl.this, false);
        if (DevSupportManagerImpl.this.mBundleDownloadListener != null)
          DevSupportManagerImpl.this.mBundleDownloadListener.onFailure(paramException);
        FLog.e("ReactNative", "Unable to download JS bundle", paramException);
        UiThreadUtil.runOnUiThread(new Runnable(paramException)
        {
          public void run()
          {
            if ((this.val$cause instanceof DebugServerException))
            {
              DebugServerException localDebugServerException = (DebugServerException)this.val$cause;
              DevSupportManagerImpl.this.showNewJavaError(localDebugServerException.getMessage(), this.val$cause);
              return;
            }
            DevSupportManagerImpl.this.showNewJavaError(DevSupportManagerImpl.this.mApplicationContext.getString(R.string.catalyst_jsload_error), this.val$cause);
          }
        });
      }

      public void onProgress(@Nullable String paramString, @Nullable Integer paramInteger1, @Nullable Integer paramInteger2)
      {
        DevSupportManagerImpl.this.mDevLoadingViewController.updateProgress(paramString, paramInteger1, paramInteger2);
        if (DevSupportManagerImpl.this.mBundleDownloadListener != null)
          DevSupportManagerImpl.this.mBundleDownloadListener.onProgress(paramString, paramInteger1, paramInteger2);
      }

      public void onSuccess()
      {
        DevSupportManagerImpl.this.mDevLoadingViewController.hide();
        DevSupportManagerImpl.access$1602(DevSupportManagerImpl.this, false);
        if (DevSupportManagerImpl.this.mBundleDownloadListener != null)
          DevSupportManagerImpl.this.mBundleDownloadListener.onSuccess();
        UiThreadUtil.runOnUiThread(new Runnable()
        {
          public void run()
          {
            ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_END, DevSupportManagerImpl.22.this.val$bundleInfo.toJSONString());
            DevSupportManagerImpl.this.mReactInstanceCommandsHandler.onJSBundleLoadedFromServer();
          }
        });
      }
    }
    , this.mJSBundleTempFile, paramString, localBundleInfo);
  }

  public void reloadSettings()
  {
    reload();
  }

  public void setDevSupportEnabled(boolean paramBoolean)
  {
    this.mIsDevSupportEnabled = paramBoolean;
    reload();
  }

  public void showDevOptionsDialog()
  {
    if ((this.mDevOptionsDialog != null) || (!this.mIsDevSupportEnabled) || (ActivityManager.isUserAMonkey()))
      return;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_reloadjs), new DevOptionHandler()
    {
      public void onOptionSelected()
      {
        DevSupportManagerImpl.this.handleReloadJS();
      }
    });
    if (this.mDevSettings.isRemoteJSDebugEnabled())
    {
      localObject = this.mApplicationContext.getString(R.string.catalyst_debugjs_off);
      localLinkedHashMap.put(localObject, new DevOptionHandler()
      {
        public void onOptionSelected()
        {
          DevInternalSettings localDevInternalSettings = DevSupportManagerImpl.this.mDevSettings;
          if (!DevSupportManagerImpl.this.mDevSettings.isRemoteJSDebugEnabled());
          for (boolean bool = true; ; bool = false)
          {
            localDevInternalSettings.setRemoteJSDebugEnabled(bool);
            DevSupportManagerImpl.this.handleReloadJS();
            return;
          }
        }
      });
      if (!this.mDevSettings.isReloadOnJSChangeEnabled())
        break label388;
      localObject = this.mApplicationContext.getString(R.string.catalyst_live_reload_off);
      label108: localLinkedHashMap.put(localObject, new DevOptionHandler()
      {
        public void onOptionSelected()
        {
          DevInternalSettings localDevInternalSettings = DevSupportManagerImpl.this.mDevSettings;
          if (!DevSupportManagerImpl.this.mDevSettings.isReloadOnJSChangeEnabled());
          for (boolean bool = true; ; bool = false)
          {
            localDevInternalSettings.setReloadOnJSChangeEnabled(bool);
            return;
          }
        }
      });
      if (!this.mDevSettings.isHotModuleReplacementEnabled())
        break label402;
      localObject = this.mApplicationContext.getString(R.string.catalyst_hot_module_replacement_off);
      label143: localLinkedHashMap.put(localObject, new DevOptionHandler()
      {
        public void onOptionSelected()
        {
          DevInternalSettings localDevInternalSettings = DevSupportManagerImpl.this.mDevSettings;
          if (!DevSupportManagerImpl.this.mDevSettings.isHotModuleReplacementEnabled());
          for (boolean bool = true; ; bool = false)
          {
            localDevInternalSettings.setHotModuleReplacementEnabled(bool);
            DevSupportManagerImpl.this.handleReloadJS();
            return;
          }
        }
      });
      localLinkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_element_inspector), new DevOptionHandler()
      {
        public void onOptionSelected()
        {
          DevInternalSettings localDevInternalSettings = DevSupportManagerImpl.this.mDevSettings;
          if (!DevSupportManagerImpl.this.mDevSettings.isElementInspectorEnabled());
          for (boolean bool = true; ; bool = false)
          {
            localDevInternalSettings.setElementInspectorEnabled(bool);
            DevSupportManagerImpl.this.mReactInstanceCommandsHandler.toggleElementInspector();
            return;
          }
        }
      });
      if (!this.mDevSettings.isFpsDebugEnabled())
        break label416;
    }
    label388: label402: label416: for (Object localObject = this.mApplicationContext.getString(R.string.catalyst_perf_monitor_off); ; localObject = this.mApplicationContext.getString(R.string.catalyst_perf_monitor))
    {
      localLinkedHashMap.put(localObject, new DevOptionHandler()
      {
        public void onOptionSelected()
        {
          DevInternalSettings localDevInternalSettings = DevSupportManagerImpl.this.mDevSettings;
          if (!DevSupportManagerImpl.this.mDevSettings.isFpsDebugEnabled());
          for (boolean bool = true; ; bool = false)
          {
            localDevInternalSettings.setFpsDebugEnabled(bool);
            return;
          }
        }
      });
      localLinkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_poke_sampling_profiler), new DevOptionHandler()
      {
        public void onOptionSelected()
        {
          DevSupportManagerImpl.this.handlePokeSamplingProfiler();
        }
      });
      localLinkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_settings), new DevOptionHandler()
      {
        public void onOptionSelected()
        {
          Intent localIntent = new Intent(DevSupportManagerImpl.this.mApplicationContext, DevSettingsActivity.class);
          localIntent.setFlags(268435456);
          DevSupportManagerImpl.this.mApplicationContext.startActivity(localIntent);
        }
      });
      if (this.mCustomDevOptions.size() > 0)
        localLinkedHashMap.putAll(this.mCustomDevOptions);
      localObject = (DevOptionHandler[])localLinkedHashMap.values().toArray(new DevOptionHandler[0]);
      this.mDevOptionsDialog = new AlertDialog.Builder(this.mApplicationContext).setItems((CharSequence[])localLinkedHashMap.keySet().toArray(new String[0]), new DialogInterface.OnClickListener(localObject)
      {
        public void onClick(DialogInterface paramDialogInterface, int paramInt)
        {
          this.val$optionHandlers[paramInt].onOptionSelected();
          DevSupportManagerImpl.access$1002(DevSupportManagerImpl.this, null);
        }
      }).setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramDialogInterface)
        {
          DevSupportManagerImpl.access$1002(DevSupportManagerImpl.this, null);
        }
      }).create();
      this.mDevOptionsDialog.getWindow().setType(WindowOverlayCompat.TYPE_SYSTEM_ALERT);
      this.mDevOptionsDialog.show();
      return;
      localObject = this.mApplicationContext.getString(R.string.catalyst_debugjs);
      break;
      localObject = this.mApplicationContext.getString(R.string.catalyst_live_reload);
      break label108;
      localObject = this.mApplicationContext.getString(R.string.catalyst_hot_module_replacement);
      break label143;
    }
  }

  public void showNewJSError(String paramString, ReadableArray paramReadableArray, int paramInt)
  {
    showNewError(paramString, StackTraceHelper.convertJsStackTrace(paramReadableArray), paramInt, ErrorType.JS);
  }

  public void showNewJavaError(String paramString, Throwable paramThrowable)
  {
    FLog.e("ReactNative", "Exception in native call", paramThrowable);
    showNewError(paramString, StackTraceHelper.convertJavaStackTrace(paramThrowable), -1, ErrorType.NATIVE);
  }

  public void startInspector()
  {
    if (this.mIsDevSupportEnabled)
      this.mDevServerHelper.openInspectorConnection();
  }

  public void stopInspector()
  {
    this.mDevServerHelper.closeInspectorConnection();
  }

  public void updateJSError(String paramString, ReadableArray paramReadableArray, int paramInt)
  {
    UiThreadUtil.runOnUiThread(new Runnable(paramInt, paramReadableArray, paramString)
    {
      public void run()
      {
        if ((DevSupportManagerImpl.this.mRedBoxDialog == null) || (!DevSupportManagerImpl.this.mRedBoxDialog.isShowing()) || (this.val$errorCookie != DevSupportManagerImpl.this.mLastErrorCookie))
          return;
        StackFrame[] arrayOfStackFrame = StackTraceHelper.convertJsStackTrace(this.val$details);
        Pair localPair = DevSupportManagerImpl.this.processErrorCustomizers(Pair.create(this.val$message, arrayOfStackFrame));
        DevSupportManagerImpl.this.mRedBoxDialog.setExceptionDetails((String)localPair.first, (StackFrame[])localPair.second);
        DevSupportManagerImpl.this.updateLastErrorInfo(this.val$message, arrayOfStackFrame, this.val$errorCookie, DevSupportManagerImpl.ErrorType.JS);
        if (DevSupportManagerImpl.this.mRedBoxHandler != null)
        {
          DevSupportManagerImpl.this.mRedBoxHandler.handleRedbox(this.val$message, arrayOfStackFrame, RedBoxHandler.ErrorType.JS);
          DevSupportManagerImpl.this.mRedBoxDialog.resetReporting(true);
        }
        DevSupportManagerImpl.this.mRedBoxDialog.show();
      }
    });
  }

  private static enum ErrorType
  {
    static
    {
      $VALUES = new ErrorType[] { JS, NATIVE };
    }
  }

  private static class JscProfileTask extends AsyncTask<String, Void, Void>
  {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private final String mSourceUrl;

    private JscProfileTask(String paramString)
    {
      this.mSourceUrl = paramString;
    }

    protected Void doInBackground(String[] paramArrayOfString)
    {
      try
      {
        String str = Uri.parse(this.mSourceUrl).buildUpon().path("/jsc-profile").query(null).build().toString();
        OkHttpClient localOkHttpClient = new OkHttpClient();
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramArrayOfString[i];
          localObject = RequestBody.create(JSON, (String)localObject);
          localOkHttpClient.newCall(new Request.Builder().url(str).post((RequestBody)localObject).build()).execute();
          i += 1;
        }
      }
      catch (IOException paramArrayOfString)
      {
        FLog.e("ReactNative", "Failed not talk to server", paramArrayOfString);
      }
      return (Void)null;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.DevSupportManagerImpl
 * JD-Core Version:    0.6.0
 */
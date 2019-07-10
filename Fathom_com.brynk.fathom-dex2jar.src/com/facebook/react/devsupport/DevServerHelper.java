package com.facebook.react.devsupport;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.network.OkHttpCallUtil;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.FileIoHandler;
import com.facebook.react.packagerconnection.JSPackagerClient;
import com.facebook.react.packagerconnection.NotificationOnlyHandler;
import com.facebook.react.packagerconnection.PackagerConnectionSettings;
import com.facebook.react.packagerconnection.RequestOnlyHandler;
import com.facebook.react.packagerconnection.Responder;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DevServerHelper
{
  private static final String BUNDLE_URL_FORMAT = "http://%s/%s.bundle?platform=android&dev=%s&minify=%s";
  private static final String DEBUGGER_MSG_DISABLE = "{ \"id\":1,\"method\":\"Debugger.disable\" }";
  private static final String HEAP_CAPTURE_UPLOAD_URL_FORMAT = "http://%s/jscheapcaptureupload";
  private static final int HTTP_CONNECT_TIMEOUT_MS = 5000;
  private static final String INSPECTOR_DEVICE_URL_FORMAT = "http://%s/inspector/device?name=%s&app=%s";
  private static final String LAUNCH_JS_DEVTOOLS_COMMAND_URL_FORMAT = "http://%s/launch-js-devtools";
  private static final int LONG_POLL_FAILURE_DELAY_MS = 5000;
  private static final int LONG_POLL_KEEP_ALIVE_DURATION_MS = 120000;
  private static final String ONCHANGE_ENDPOINT_URL_FORMAT = "http://%s/onchange";
  private static final String OPEN_STACK_FRAME_URL_FORMAT = "http://%s/open-stack-frame";
  private static final String PACKAGER_OK_STATUS = "packager-status:running";
  private static final String PACKAGER_STATUS_URL_FORMAT = "http://%s/status";
  private static final String RELOAD_APP_ACTION_SUFFIX = ".RELOAD_APP_ACTION";
  public static final String RELOAD_APP_EXTRA_JS_PROXY = "jsproxy";
  private static final String RESOURCE_URL_FORMAT = "http://%s/%s";
  private static final String SOURCE_MAP_URL_FORMAT = "http://%s/%s.bundle?platform=android&dev=%s&minify=%s".replaceFirst("\\.bundle", ".map");
  private static final String SYMBOLICATE_URL_FORMAT = "http://%s/symbolicate";
  private static final String WEBSOCKET_PROXY_URL_FORMAT = "ws://%s/debugger-proxy?role=client";
  private final BundleDownloader mBundleDownloader;
  private final OkHttpClient mClient;

  @Nullable
  private InspectorPackagerConnection mInspectorPackagerConnection;

  @Nullable
  private OkHttpClient mOnChangePollingClient;
  private boolean mOnChangePollingEnabled;

  @Nullable
  private OnServerContentChangeListener mOnServerContentChangeListener;
  private final String mPackageName;

  @Nullable
  private JSPackagerClient mPackagerClient;
  private final Handler mRestartOnChangePollingHandler;
  private final DevInternalSettings mSettings;

  public DevServerHelper(DevInternalSettings paramDevInternalSettings, String paramString)
  {
    this.mSettings = paramDevInternalSettings;
    this.mClient = new OkHttpClient.Builder().connectTimeout(5000L, TimeUnit.MILLISECONDS).readTimeout(0L, TimeUnit.MILLISECONDS).writeTimeout(0L, TimeUnit.MILLISECONDS).build();
    this.mBundleDownloader = new BundleDownloader(this.mClient);
    this.mRestartOnChangePollingHandler = new Handler();
    this.mPackageName = paramString;
  }

  private static String createBundleURL(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return String.format(Locale.US, "http://%s/%s.bundle?platform=android&dev=%s&minify=%s", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }

  private String createLaunchJSDevtoolsCommandUrl()
  {
    return String.format(Locale.US, "http://%s/launch-js-devtools", new Object[] { this.mSettings.getPackagerConnectionSettings().getDebugServerHost() });
  }

  private String createOnChangeEndpointUrl()
  {
    return String.format(Locale.US, "http://%s/onchange", new Object[] { this.mSettings.getPackagerConnectionSettings().getDebugServerHost() });
  }

  private static String createOpenStackFrameURL(String paramString)
  {
    return String.format(Locale.US, "http://%s/open-stack-frame", new Object[] { paramString });
  }

  private static String createPackagerStatusURL(String paramString)
  {
    return String.format(Locale.US, "http://%s/status", new Object[] { paramString });
  }

  private static String createResourceURL(String paramString1, String paramString2)
  {
    return String.format(Locale.US, "http://%s/%s", new Object[] { paramString1, paramString2 });
  }

  private static String createSymbolicateURL(String paramString)
  {
    return String.format(Locale.US, "http://%s/symbolicate", new Object[] { paramString });
  }

  private void enqueueOnChangeEndpointLongPolling()
  {
    Request localRequest = new Request.Builder().url(createOnChangeEndpointUrl()).tag(this).build();
    ((OkHttpClient)Assertions.assertNotNull(this.mOnChangePollingClient)).newCall(localRequest).enqueue(new Callback()
    {
      public void onFailure(Call paramCall, IOException paramIOException)
      {
        if (DevServerHelper.this.mOnChangePollingEnabled)
        {
          FLog.d("ReactNative", "Error while requesting /onchange endpoint", paramIOException);
          DevServerHelper.this.mRestartOnChangePollingHandler.postDelayed(new Runnable()
          {
            public void run()
            {
              DevServerHelper.this.handleOnChangePollingResponse(false);
            }
          }
          , 5000L);
        }
      }

      public void onResponse(Call paramCall, Response paramResponse)
        throws IOException
      {
        paramCall = DevServerHelper.this;
        if (paramResponse.code() == 205);
        for (boolean bool = true; ; bool = false)
        {
          paramCall.handleOnChangePollingResponse(bool);
          return;
        }
      }
    });
  }

  private boolean getDevMode()
  {
    return this.mSettings.isJSDevModeEnabled();
  }

  private String getHostForJSProxy()
  {
    String str = (String)Assertions.assertNotNull(this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    int i = str.lastIndexOf(':');
    if (i > -1)
      return "localhost" + str.substring(i);
    return "localhost";
  }

  private boolean getJSMinifyMode()
  {
    return this.mSettings.isJSMinifyEnabled();
  }

  public static String getReloadAppAction(Context paramContext)
  {
    return paramContext.getPackageName() + ".RELOAD_APP_ACTION";
  }

  private void handleOnChangePollingResponse(boolean paramBoolean)
  {
    if (this.mOnChangePollingEnabled)
    {
      if (paramBoolean)
        UiThreadUtil.runOnUiThread(new Runnable()
        {
          public void run()
          {
            if (DevServerHelper.this.mOnServerContentChangeListener != null)
              DevServerHelper.this.mOnServerContentChangeListener.onServerContentChanged();
          }
        });
      enqueueOnChangeEndpointLongPolling();
    }
  }

  public void closeInspectorConnection()
  {
    new AsyncTask()
    {
      protected Void doInBackground(Void[] paramArrayOfVoid)
      {
        if (DevServerHelper.this.mInspectorPackagerConnection != null)
        {
          DevServerHelper.this.mInspectorPackagerConnection.closeQuietly();
          DevServerHelper.access$202(DevServerHelper.this, null);
        }
        return null;
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  public void closePackagerConnection()
  {
    new AsyncTask()
    {
      protected Void doInBackground(Void[] paramArrayOfVoid)
      {
        if (DevServerHelper.this.mPackagerClient != null)
        {
          DevServerHelper.this.mPackagerClient.close();
          DevServerHelper.access$002(DevServerHelper.this, null);
        }
        return null;
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  public void disableDebugger()
  {
    if (this.mInspectorPackagerConnection != null)
      this.mInspectorPackagerConnection.sendEventToAllConnections("{ \"id\":1,\"method\":\"Debugger.disable\" }");
  }

  // ERROR //
  @Nullable
  public java.io.File downloadBundleResourceFromUrlSync(String paramString, java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 133	com/facebook/react/devsupport/DevServerHelper:mSettings	Lcom/facebook/react/devsupport/DevInternalSettings;
    //   4: invokevirtual 232	com/facebook/react/devsupport/DevInternalSettings:getPackagerConnectionSettings	()Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;
    //   7: invokevirtual 237	com/facebook/react/packagerconnection/PackagerConnectionSettings:getDebugServerHost	()Ljava/lang/String;
    //   10: aload_1
    //   11: invokestatic 359	com/facebook/react/devsupport/DevServerHelper:createResourceURL	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14: astore 4
    //   16: new 246	okhttp3/Request$Builder
    //   19: dup
    //   20: invokespecial 247	okhttp3/Request$Builder:<init>	()V
    //   23: aload 4
    //   25: invokevirtual 253	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   28: invokevirtual 260	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   31: astore 4
    //   33: aload_0
    //   34: getfield 160	com/facebook/react/devsupport/DevServerHelper:mClient	Lokhttp3/OkHttpClient;
    //   37: aload 4
    //   39: invokevirtual 274	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   42: invokeinterface 363 1 0
    //   47: astore 6
    //   49: aload 6
    //   51: invokevirtual 368	okhttp3/Response:isSuccessful	()Z
    //   54: istore_3
    //   55: iload_3
    //   56: ifne +9 -> 65
    //   59: aconst_null
    //   60: astore 4
    //   62: aload 4
    //   64: areturn
    //   65: aconst_null
    //   66: astore 4
    //   68: aload_2
    //   69: invokestatic 374	okio/Okio:sink	(Ljava/io/File;)Lokio/Sink;
    //   72: astore 5
    //   74: aload 5
    //   76: astore 4
    //   78: aload 6
    //   80: invokevirtual 378	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   83: invokevirtual 384	okhttp3/ResponseBody:source	()Lokio/BufferedSource;
    //   86: invokestatic 388	okio/Okio:buffer	(Lokio/Source;)Lokio/BufferedSource;
    //   89: aload 5
    //   91: invokeinterface 394 2 0
    //   96: pop2
    //   97: aload_2
    //   98: astore 4
    //   100: aload 5
    //   102: ifnull -40 -> 62
    //   105: aload 5
    //   107: invokeinterface 399 1 0
    //   112: aload_2
    //   113: areturn
    //   114: astore 4
    //   116: ldc_w 401
    //   119: ldc_w 403
    //   122: iconst_3
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload_1
    //   129: aastore
    //   130: dup
    //   131: iconst_1
    //   132: aload_2
    //   133: invokevirtual 408	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   136: aastore
    //   137: dup
    //   138: iconst_2
    //   139: aload 4
    //   141: aastore
    //   142: invokestatic 414	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aconst_null
    //   146: areturn
    //   147: astore 5
    //   149: aload 4
    //   151: ifnull +10 -> 161
    //   154: aload 4
    //   156: invokeinterface 399 1 0
    //   161: aload 5
    //   163: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   33	55	114	java/lang/Exception
    //   105	112	114	java/lang/Exception
    //   154	161	114	java/lang/Exception
    //   161	164	114	java/lang/Exception
    //   68	74	147	finally
    //   78	97	147	finally
  }

  public BundleDownloader getBundleDownloader()
  {
    return this.mBundleDownloader;
  }

  public String getDevServerBundleURL(String paramString)
  {
    return createBundleURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost(), paramString, getDevMode(), getJSMinifyMode());
  }

  public String getHeapCaptureUploadUrl()
  {
    return String.format(Locale.US, "http://%s/jscheapcaptureupload", new Object[] { this.mSettings.getPackagerConnectionSettings().getDebugServerHost() });
  }

  public String getInspectorDeviceUrl()
  {
    return String.format(Locale.US, "http://%s/inspector/device?name=%s&app=%s", new Object[] { this.mSettings.getPackagerConnectionSettings().getInspectorServerHost(), AndroidInfoHelpers.getFriendlyDeviceName(), this.mPackageName });
  }

  public String getJSBundleURLForRemoteDebugging(String paramString)
  {
    return createBundleURL(getHostForJSProxy(), paramString, getDevMode(), getJSMinifyMode());
  }

  public String getSourceMapUrl(String paramString)
  {
    return String.format(Locale.US, SOURCE_MAP_URL_FORMAT, new Object[] { this.mSettings.getPackagerConnectionSettings().getDebugServerHost(), paramString, Boolean.valueOf(getDevMode()), Boolean.valueOf(getJSMinifyMode()) });
  }

  public String getSourceUrl(String paramString)
  {
    return String.format(Locale.US, "http://%s/%s.bundle?platform=android&dev=%s&minify=%s", new Object[] { this.mSettings.getPackagerConnectionSettings().getDebugServerHost(), paramString, Boolean.valueOf(getDevMode()), Boolean.valueOf(getJSMinifyMode()) });
  }

  public String getWebsocketProxyURL()
  {
    return String.format(Locale.US, "ws://%s/debugger-proxy?role=client", new Object[] { this.mSettings.getPackagerConnectionSettings().getDebugServerHost() });
  }

  public void isPackagerRunning(PackagerStatusCallback paramPackagerStatusCallback)
  {
    Object localObject = createPackagerStatusURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    localObject = new Request.Builder().url((String)localObject).build();
    this.mClient.newCall((Request)localObject).enqueue(new Callback(paramPackagerStatusCallback)
    {
      public void onFailure(Call paramCall, IOException paramIOException)
      {
        FLog.w("ReactNative", "The packager does not seem to be running as we got an IOException requesting its status: " + paramIOException.getMessage());
        this.val$callback.onPackagerStatusFetched(false);
      }

      public void onResponse(Call paramCall, Response paramResponse)
        throws IOException
      {
        if (!paramResponse.isSuccessful())
        {
          FLog.e("ReactNative", "Got non-success http code from packager when requesting status: " + paramResponse.code());
          this.val$callback.onPackagerStatusFetched(false);
          return;
        }
        paramCall = paramResponse.body();
        if (paramCall == null)
        {
          FLog.e("ReactNative", "Got null body response from packager when requesting status");
          this.val$callback.onPackagerStatusFetched(false);
          return;
        }
        if (!"packager-status:running".equals(paramCall.string()))
        {
          FLog.e("ReactNative", "Got unexpected response from packager when requesting status: " + paramCall.string());
          this.val$callback.onPackagerStatusFetched(false);
          return;
        }
        this.val$callback.onPackagerStatusFetched(true);
      }
    });
  }

  public void launchJSDevtools()
  {
    Request localRequest = new Request.Builder().url(createLaunchJSDevtoolsCommandUrl()).build();
    this.mClient.newCall(localRequest).enqueue(new Callback()
    {
      public void onFailure(Call paramCall, IOException paramIOException)
      {
      }

      public void onResponse(Call paramCall, Response paramResponse)
        throws IOException
      {
      }
    });
  }

  public void openInspectorConnection()
  {
    if (this.mInspectorPackagerConnection != null)
    {
      FLog.w("ReactNative", "Inspector connection already open, nooping.");
      return;
    }
    new AsyncTask()
    {
      protected Void doInBackground(Void[] paramArrayOfVoid)
      {
        DevServerHelper.access$202(DevServerHelper.this, new InspectorPackagerConnection(DevServerHelper.this.getInspectorDeviceUrl(), DevServerHelper.this.mPackageName));
        DevServerHelper.this.mInspectorPackagerConnection.connect();
        return null;
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  public void openPackagerConnection(String paramString, PackagerCommandListener paramPackagerCommandListener)
  {
    if (this.mPackagerClient != null)
    {
      FLog.w("ReactNative", "Packager connection already open, nooping.");
      return;
    }
    new AsyncTask(paramPackagerCommandListener, paramString)
    {
      protected Void doInBackground(Void[] paramArrayOfVoid)
      {
        paramArrayOfVoid = new HashMap();
        paramArrayOfVoid.put("reload", new NotificationOnlyHandler()
        {
          public void onNotification(@Nullable Object paramObject)
          {
            DevServerHelper.1.this.val$commandListener.onPackagerReloadCommand();
          }
        });
        paramArrayOfVoid.put("devMenu", new NotificationOnlyHandler()
        {
          public void onNotification(@Nullable Object paramObject)
          {
            DevServerHelper.1.this.val$commandListener.onPackagerDevMenuCommand();
          }
        });
        paramArrayOfVoid.put("captureHeap", new RequestOnlyHandler()
        {
          public void onRequest(@Nullable Object paramObject, Responder paramResponder)
          {
            DevServerHelper.1.this.val$commandListener.onCaptureHeapCommand(paramResponder);
          }
        });
        paramArrayOfVoid.put("pokeSamplingProfiler", new RequestOnlyHandler()
        {
          public void onRequest(@Nullable Object paramObject, Responder paramResponder)
          {
            DevServerHelper.1.this.val$commandListener.onPokeSamplingProfilerCommand(paramResponder);
          }
        });
        paramArrayOfVoid.putAll(new FileIoHandler().handlers());
        DevServerHelper.access$002(DevServerHelper.this, new JSPackagerClient(this.val$clientId, DevServerHelper.this.mSettings.getPackagerConnectionSettings(), paramArrayOfVoid));
        DevServerHelper.this.mPackagerClient.init();
        return null;
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  public void openStackFrameCall(StackFrame paramStackFrame)
  {
    String str = createOpenStackFrameURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    paramStackFrame = new Request.Builder().url(str).post(RequestBody.create(MediaType.parse("application/json"), paramStackFrame.toJSON().toString())).build();
    ((Call)Assertions.assertNotNull(this.mClient.newCall(paramStackFrame))).enqueue(new Callback()
    {
      public void onFailure(Call paramCall, IOException paramIOException)
      {
        FLog.w("ReactNative", "Got IOException when attempting to open stack frame: " + paramIOException.getMessage());
      }

      public void onResponse(Call paramCall, Response paramResponse)
        throws IOException
      {
      }
    });
  }

  public void sendEventToAllConnections(String paramString)
  {
    if (this.mInspectorPackagerConnection != null)
      this.mInspectorPackagerConnection.sendEventToAllConnections(paramString);
  }

  public void startPollingOnChangeEndpoint(OnServerContentChangeListener paramOnServerContentChangeListener)
  {
    if (this.mOnChangePollingEnabled)
      return;
    this.mOnChangePollingEnabled = true;
    this.mOnServerContentChangeListener = paramOnServerContentChangeListener;
    this.mOnChangePollingClient = new OkHttpClient.Builder().connectionPool(new ConnectionPool(1, 120000L, TimeUnit.MINUTES)).connectTimeout(5000L, TimeUnit.MILLISECONDS).build();
    enqueueOnChangeEndpointLongPolling();
  }

  public void stopPollingOnChangeEndpoint()
  {
    this.mOnChangePollingEnabled = false;
    this.mRestartOnChangePollingHandler.removeCallbacksAndMessages(null);
    if (this.mOnChangePollingClient != null)
    {
      OkHttpCallUtil.cancelTag(this.mOnChangePollingClient, this);
      this.mOnChangePollingClient = null;
    }
    this.mOnServerContentChangeListener = null;
  }

  public void symbolicateStackTrace(Iterable<StackFrame> paramIterable, SymbolicationListener paramSymbolicationListener)
  {
    String str;
    JSONArray localJSONArray;
    try
    {
      str = createSymbolicateURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
      localJSONArray = new JSONArray();
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
        localJSONArray.put(((StackFrame)paramIterable.next()).toJSON());
    }
    catch (JSONException paramIterable)
    {
      FLog.w("ReactNative", "Got JSONException when attempting symbolicate stack trace: " + paramIterable.getMessage());
      return;
    }
    paramIterable = new Request.Builder().url(str).post(RequestBody.create(MediaType.parse("application/json"), new JSONObject().put("stack", localJSONArray).toString())).build();
    ((Call)Assertions.assertNotNull(this.mClient.newCall(paramIterable))).enqueue(new Callback(paramSymbolicationListener)
    {
      public void onFailure(Call paramCall, IOException paramIOException)
      {
        FLog.w("ReactNative", "Got IOException when attempting symbolicate stack trace: " + paramIOException.getMessage());
        this.val$listener.onSymbolicationComplete(null);
      }

      public void onResponse(Call paramCall, Response paramResponse)
        throws IOException
      {
        try
        {
          this.val$listener.onSymbolicationComplete(Arrays.asList(StackTraceHelper.convertJsStackTrace(new JSONObject(paramResponse.body().string()).getJSONArray("stack"))));
          return;
        }
        catch (JSONException paramCall)
        {
          this.val$listener.onSymbolicationComplete(null);
        }
      }
    });
  }

  public static abstract interface OnServerContentChangeListener
  {
    public abstract void onServerContentChanged();
  }

  public static abstract interface PackagerCommandListener
  {
    public abstract void onCaptureHeapCommand(Responder paramResponder);

    public abstract void onPackagerDevMenuCommand();

    public abstract void onPackagerReloadCommand();

    public abstract void onPokeSamplingProfilerCommand(Responder paramResponder);
  }

  public static abstract interface SymbolicationListener
  {
    public abstract void onSymbolicationComplete(@Nullable Iterable<StackFrame> paramIterable);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.DevServerHelper
 * JD-Core Version:    0.6.0
 */
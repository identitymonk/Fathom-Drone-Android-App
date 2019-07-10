package com.facebook.react.devsupport;

import android.os.Handler;
import android.os.Looper;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.JavaJSExecutor.ProxyExecutorException;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

public class WebsocketJavaScriptExecutor
  implements JavaJSExecutor
{
  private static final int CONNECT_RETRY_COUNT = 3;
  private static final long CONNECT_TIMEOUT_MS = 5000L;
  private final HashMap<String, String> mInjectedObjects = new HashMap();

  @Nullable
  private JSDebuggerWebSocketClient mWebSocketClient;

  private void connectInternal(String paramString, JSExecutorConnectCallback paramJSExecutorConnectCallback)
  {
    JSDebuggerWebSocketClient localJSDebuggerWebSocketClient = new JSDebuggerWebSocketClient();
    Handler localHandler = new Handler(Looper.getMainLooper());
    localJSDebuggerWebSocketClient.connect(paramString, new JSDebuggerWebSocketClient.JSDebuggerCallback(localJSDebuggerWebSocketClient, localHandler, paramJSExecutorConnectCallback)
    {
      private boolean didSendResult = false;

      public void onFailure(Throwable paramThrowable)
      {
        this.val$timeoutHandler.removeCallbacksAndMessages(null);
        if (!this.didSendResult)
        {
          this.val$callback.onFailure(paramThrowable);
          this.didSendResult = true;
        }
      }

      public void onSuccess(@Nullable String paramString)
      {
        this.val$client.prepareJSRuntime(new JSDebuggerWebSocketClient.JSDebuggerCallback()
        {
          public void onFailure(Throwable paramThrowable)
          {
            WebsocketJavaScriptExecutor.2.this.val$timeoutHandler.removeCallbacksAndMessages(null);
            if (!WebsocketJavaScriptExecutor.2.this.didSendResult)
            {
              WebsocketJavaScriptExecutor.2.this.val$callback.onFailure(paramThrowable);
              WebsocketJavaScriptExecutor.2.access$202(WebsocketJavaScriptExecutor.2.this, true);
            }
          }

          public void onSuccess(@Nullable String paramString)
          {
            WebsocketJavaScriptExecutor.2.this.val$timeoutHandler.removeCallbacksAndMessages(null);
            WebsocketJavaScriptExecutor.access$102(WebsocketJavaScriptExecutor.this, WebsocketJavaScriptExecutor.2.this.val$client);
            if (!WebsocketJavaScriptExecutor.2.this.didSendResult)
            {
              WebsocketJavaScriptExecutor.2.this.val$callback.onSuccess();
              WebsocketJavaScriptExecutor.2.access$202(WebsocketJavaScriptExecutor.2.this, true);
            }
          }
        });
      }
    });
    localHandler.postDelayed(new Runnable(localJSDebuggerWebSocketClient, paramJSExecutorConnectCallback)
    {
      public void run()
      {
        this.val$client.closeQuietly();
        this.val$callback.onFailure(new WebsocketJavaScriptExecutor.WebsocketExecutorTimeoutException("Timeout while connecting to remote debugger"));
      }
    }
    , 5000L);
  }

  public void close()
  {
    if (this.mWebSocketClient != null)
      this.mWebSocketClient.closeQuietly();
  }

  public void connect(String paramString, JSExecutorConnectCallback paramJSExecutorConnectCallback)
  {
    connectInternal(paramString, new JSExecutorConnectCallback(paramJSExecutorConnectCallback, new AtomicInteger(3), paramString)
    {
      public void onFailure(Throwable paramThrowable)
      {
        if (this.val$retryCount.decrementAndGet() <= 0)
        {
          this.val$callback.onFailure(paramThrowable);
          return;
        }
        WebsocketJavaScriptExecutor.this.connectInternal(this.val$webSocketServerUrl, this);
      }

      public void onSuccess()
      {
        this.val$callback.onSuccess();
      }
    });
  }

  @Nullable
  public String executeJSCall(String paramString1, String paramString2)
    throws JavaJSExecutor.ProxyExecutorException
  {
    JSExecutorCallbackFuture localJSExecutorCallbackFuture = new JSExecutorCallbackFuture(null);
    ((JSDebuggerWebSocketClient)Assertions.assertNotNull(this.mWebSocketClient)).executeJSCall(paramString1, paramString2, localJSExecutorCallbackFuture);
    try
    {
      paramString1 = localJSExecutorCallbackFuture.get();
      return paramString1;
    }
    catch (Throwable paramString1)
    {
    }
    throw new JavaJSExecutor.ProxyExecutorException(paramString1);
  }

  public void loadApplicationScript(String paramString)
    throws JavaJSExecutor.ProxyExecutorException
  {
    JSExecutorCallbackFuture localJSExecutorCallbackFuture = new JSExecutorCallbackFuture(null);
    ((JSDebuggerWebSocketClient)Assertions.assertNotNull(this.mWebSocketClient)).loadApplicationScript(paramString, this.mInjectedObjects, localJSExecutorCallbackFuture);
    try
    {
      localJSExecutorCallbackFuture.get();
      return;
    }
    catch (Throwable paramString)
    {
    }
    throw new JavaJSExecutor.ProxyExecutorException(paramString);
  }

  public void setGlobalVariable(String paramString1, String paramString2)
  {
    this.mInjectedObjects.put(paramString1, paramString2);
  }

  private static class JSExecutorCallbackFuture
    implements JSDebuggerWebSocketClient.JSDebuggerCallback
  {

    @Nullable
    private Throwable mCause;

    @Nullable
    private String mResponse;
    private final Semaphore mSemaphore = new Semaphore(0);

    @Nullable
    public String get()
      throws Throwable
    {
      this.mSemaphore.acquire();
      if (this.mCause != null)
        throw this.mCause;
      return this.mResponse;
    }

    public void onFailure(Throwable paramThrowable)
    {
      this.mCause = paramThrowable;
      this.mSemaphore.release();
    }

    public void onSuccess(@Nullable String paramString)
    {
      this.mResponse = paramString;
      this.mSemaphore.release();
    }
  }

  public static abstract interface JSExecutorConnectCallback
  {
    public abstract void onFailure(Throwable paramThrowable);

    public abstract void onSuccess();
  }

  public static class WebsocketExecutorTimeoutException extends Exception
  {
    public WebsocketExecutorTimeoutException(String paramString)
    {
      super();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.WebsocketJavaScriptExecutor
 * JD-Core Version:    0.6.0
 */
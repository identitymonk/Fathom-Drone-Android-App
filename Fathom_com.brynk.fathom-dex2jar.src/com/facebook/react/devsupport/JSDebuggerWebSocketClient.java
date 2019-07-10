package com.facebook.react.devsupport;

import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.JavascriptException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class JSDebuggerWebSocketClient extends WebSocketListener
{
  private static final String TAG = "JSDebuggerWebSocketClient";
  private final ConcurrentHashMap<Integer, JSDebuggerCallback> mCallbacks = new ConcurrentHashMap();

  @Nullable
  private JSDebuggerCallback mConnectCallback;

  @Nullable
  private OkHttpClient mHttpClient;
  private final AtomicInteger mRequestID = new AtomicInteger();

  @Nullable
  private WebSocket mWebSocket;

  private void abort(String paramString, Throwable paramThrowable)
  {
    FLog.e("JSDebuggerWebSocketClient", "Error occurred, shutting down websocket connection: " + paramString, paramThrowable);
    closeQuietly();
    if (this.mConnectCallback != null)
    {
      this.mConnectCallback.onFailure(paramThrowable);
      this.mConnectCallback = null;
    }
    paramString = this.mCallbacks.values().iterator();
    while (paramString.hasNext())
      ((JSDebuggerCallback)paramString.next()).onFailure(paramThrowable);
    this.mCallbacks.clear();
  }

  private void sendMessage(int paramInt, String paramString)
  {
    if (this.mWebSocket == null)
    {
      triggerRequestFailure(paramInt, new IllegalStateException("WebSocket connection no longer valid"));
      return;
    }
    try
    {
      this.mWebSocket.send(paramString);
      return;
    }
    catch (Exception paramString)
    {
      triggerRequestFailure(paramInt, paramString);
    }
  }

  private void triggerRequestFailure(int paramInt, Throwable paramThrowable)
  {
    JSDebuggerCallback localJSDebuggerCallback = (JSDebuggerCallback)this.mCallbacks.get(Integer.valueOf(paramInt));
    if (localJSDebuggerCallback != null)
    {
      this.mCallbacks.remove(Integer.valueOf(paramInt));
      localJSDebuggerCallback.onFailure(paramThrowable);
    }
  }

  private void triggerRequestSuccess(int paramInt, @Nullable String paramString)
  {
    JSDebuggerCallback localJSDebuggerCallback = (JSDebuggerCallback)this.mCallbacks.get(Integer.valueOf(paramInt));
    if (localJSDebuggerCallback != null)
    {
      this.mCallbacks.remove(Integer.valueOf(paramInt));
      localJSDebuggerCallback.onSuccess(paramString);
    }
  }

  public void closeQuietly()
  {
    if (this.mWebSocket != null);
    try
    {
      this.mWebSocket.close(1000, "End of session");
      label22: this.mWebSocket = null;
      return;
    }
    catch (Exception localException)
    {
      break label22;
    }
  }

  public void connect(String paramString, JSDebuggerCallback paramJSDebuggerCallback)
  {
    if (this.mHttpClient != null)
      throw new IllegalStateException("JSDebuggerWebSocketClient is already initialized.");
    this.mConnectCallback = paramJSDebuggerCallback;
    this.mHttpClient = new OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(0L, TimeUnit.MINUTES).build();
    paramString = new Request.Builder().url(paramString).build();
    this.mHttpClient.newWebSocket(paramString, this);
  }

  public void executeJSCall(String paramString1, String paramString2, JSDebuggerCallback paramJSDebuggerCallback)
  {
    int i = this.mRequestID.getAndIncrement();
    this.mCallbacks.put(Integer.valueOf(i), paramJSDebuggerCallback);
    try
    {
      paramJSDebuggerCallback = new StringWriter();
      JsonWriter localJsonWriter = new JsonWriter(paramJSDebuggerCallback);
      localJsonWriter.beginObject().name("id").value(i).name("method").value(paramString1);
      paramJSDebuggerCallback.append(",\"arguments\":").append(paramString2);
      localJsonWriter.endObject().close();
      sendMessage(i, paramJSDebuggerCallback.toString());
      return;
    }
    catch (java.io.IOException paramString1)
    {
      triggerRequestFailure(i, paramString1);
    }
  }

  public void loadApplicationScript(String paramString, HashMap<String, String> paramHashMap, JSDebuggerCallback paramJSDebuggerCallback)
  {
    int i = this.mRequestID.getAndIncrement();
    this.mCallbacks.put(Integer.valueOf(i), paramJSDebuggerCallback);
    try
    {
      paramJSDebuggerCallback = new StringWriter();
      paramString = new JsonWriter(paramJSDebuggerCallback).beginObject().name("id").value(i).name("method").value("executeApplicationScript").name("url").value(paramString).name("inject").beginObject();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramString.name(str).value((String)paramHashMap.get(str));
      }
    }
    catch (java.io.IOException paramString)
    {
      triggerRequestFailure(i, paramString);
      return;
    }
    paramString.endObject().endObject().close();
    sendMessage(i, paramJSDebuggerCallback.toString());
  }

  public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    this.mWebSocket = null;
  }

  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, Response paramResponse)
  {
    abort("Websocket exception", paramThrowable);
  }

  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    String str = null;
    paramWebSocket = null;
    Object localObject = str;
    try
    {
      localJsonReader = new JsonReader(new StringReader(paramString));
      paramString = null;
      localObject = str;
      localJsonReader.beginObject();
      while (true)
      {
        localObject = paramWebSocket;
        if (!localJsonReader.hasNext())
          break label185;
        localObject = paramWebSocket;
        str = localJsonReader.nextName();
        localObject = paramWebSocket;
        if (JsonToken.NULL != localJsonReader.peek())
          break;
        localObject = paramWebSocket;
        localJsonReader.skipValue();
      }
    }
    catch (java.io.IOException paramWebSocket)
    {
      JsonReader localJsonReader;
      if (localObject != null)
      {
        triggerRequestFailure(((Integer)localObject).intValue(), paramWebSocket);
        label185: 
        do
        {
          return;
          localObject = paramWebSocket;
          if ("replyID".equals(str))
          {
            localObject = paramWebSocket;
            paramWebSocket = Integer.valueOf(localJsonReader.nextInt());
            break;
          }
          localObject = paramWebSocket;
          if ("result".equals(str))
          {
            localObject = paramWebSocket;
            paramString = localJsonReader.nextString();
            break;
          }
          localObject = paramWebSocket;
          if (!"error".equals(str))
            break;
          localObject = paramWebSocket;
          str = localJsonReader.nextString();
          localObject = paramWebSocket;
          abort(str, new JavascriptException(str));
          break;
        }
        while (paramWebSocket == null);
        localObject = paramWebSocket;
        triggerRequestSuccess(paramWebSocket.intValue(), paramString);
        return;
      }
      abort("Parsing response message from websocket failed", paramWebSocket);
    }
  }

  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    this.mWebSocket = paramWebSocket;
    ((JSDebuggerCallback)Assertions.assertNotNull(this.mConnectCallback)).onSuccess(null);
    this.mConnectCallback = null;
  }

  public void prepareJSRuntime(JSDebuggerCallback paramJSDebuggerCallback)
  {
    int i = this.mRequestID.getAndIncrement();
    this.mCallbacks.put(Integer.valueOf(i), paramJSDebuggerCallback);
    try
    {
      paramJSDebuggerCallback = new StringWriter();
      new JsonWriter(paramJSDebuggerCallback).beginObject().name("id").value(i).name("method").value("prepareJSRuntime").endObject().close();
      sendMessage(i, paramJSDebuggerCallback.toString());
      return;
    }
    catch (java.io.IOException paramJSDebuggerCallback)
    {
      triggerRequestFailure(i, paramJSDebuggerCallback);
    }
  }

  public static abstract interface JSDebuggerCallback
  {
    public abstract void onFailure(Throwable paramThrowable);

    public abstract void onSuccess(@Nullable String paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.JSDebuggerWebSocketClient
 * JD-Core Version:    0.6.0
 */
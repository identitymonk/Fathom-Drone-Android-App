package com.facebook.react.modules.websocket;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

@ReactModule(hasConstants=false, name="WebSocketModule")
public final class WebSocketModule extends ReactContextBaseJavaModule
{
  private final Map<Integer, ContentHandler> mContentHandlers = new HashMap();
  private ForwardingCookieHandler mCookieHandler;
  private ReactContext mReactContext;
  private final Map<Integer, WebSocket> mWebSocketConnections = new HashMap();

  public WebSocketModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    this.mReactContext = paramReactApplicationContext;
    this.mCookieHandler = new ForwardingCookieHandler(paramReactApplicationContext);
  }

  private String getCookie(String paramString)
  {
    try
    {
      Object localObject = new URI(getDefaultOrigin(paramString));
      localObject = (List)this.mCookieHandler.get((URI)localObject, new HashMap()).get("Cookie");
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = (String)((List)localObject).get(0);
        return localObject;
      }
    }
    catch (URISyntaxException localURISyntaxException)
    {
      throw new IllegalArgumentException("Unable to get cookie from " + paramString);
    }
    catch (IOException localIOException)
    {
      label68: break label68;
    }
    return (String)null;
  }

  private static String getDefaultOrigin(String paramString)
  {
    String str = "";
    try
    {
      URI localURI = new URI(paramString);
      if (localURI.getScheme().equals("wss"))
        str = "" + "https";
      while (localURI.getPort() != -1)
      {
        return String.format("%s://%s:%s", new Object[] { str, localURI.getHost(), Integer.valueOf(localURI.getPort()) });
        if (localURI.getScheme().equals("ws"))
        {
          str = "" + "http";
          continue;
        }
        if ((!localURI.getScheme().equals("http")) && (!localURI.getScheme().equals("https")))
          continue;
        str = "" + localURI.getScheme();
      }
      str = String.format("%s://%s/", new Object[] { str, localURI.getHost() });
      return str;
    }
    catch (URISyntaxException localURISyntaxException)
    {
    }
    throw new IllegalArgumentException("Unable to set " + paramString + " as default origin header");
  }

  private void notifyWebSocketFailed(int paramInt, String paramString)
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putInt("id", paramInt);
    localWritableMap.putString("message", paramString);
    sendEvent("websocketFailed", localWritableMap);
  }

  private void sendEvent(String paramString, WritableMap paramWritableMap)
  {
    ((DeviceEventManagerModule.RCTDeviceEventEmitter)this.mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(paramString, paramWritableMap);
  }

  @ReactMethod
  public void close(int paramInt1, String paramString, int paramInt2)
  {
    WebSocket localWebSocket = (WebSocket)this.mWebSocketConnections.get(Integer.valueOf(paramInt2));
    if (localWebSocket == null)
      return;
    try
    {
      localWebSocket.close(paramInt1, paramString);
      this.mWebSocketConnections.remove(Integer.valueOf(paramInt2));
      this.mContentHandlers.remove(Integer.valueOf(paramInt2));
      return;
    }
    catch (Exception paramString)
    {
      FLog.e("ReactNative", "Could not close WebSocket connection for id " + paramInt2, paramString);
    }
  }

  @ReactMethod
  public void connect(String paramString, @Nullable ReadableArray paramReadableArray, @Nullable ReadableMap paramReadableMap, int paramInt)
  {
    OkHttpClient localOkHttpClient = new OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(0L, TimeUnit.MINUTES).build();
    Request.Builder localBuilder = new Request.Builder().tag(Integer.valueOf(paramInt)).url(paramString);
    Object localObject = getCookie(paramString);
    if (localObject != null)
      localBuilder.addHeader("Cookie", (String)localObject);
    if ((paramReadableMap != null) && (paramReadableMap.hasKey("headers")) && (paramReadableMap.getType("headers").equals(ReadableType.Map)))
    {
      paramReadableMap = paramReadableMap.getMap("headers");
      localObject = paramReadableMap.keySetIterator();
      if (!paramReadableMap.hasKey("origin"))
        localBuilder.addHeader("origin", getDefaultOrigin(paramString));
    }
    while (((ReadableMapKeySetIterator)localObject).hasNextKey())
    {
      paramString = ((ReadableMapKeySetIterator)localObject).nextKey();
      if (ReadableType.String.equals(paramReadableMap.getType(paramString)))
      {
        localBuilder.addHeader(paramString, paramReadableMap.getString(paramString));
        continue;
      }
      FLog.w("ReactNative", "Ignoring: requested " + paramString + ", value not a string");
      continue;
      localBuilder.addHeader("origin", getDefaultOrigin(paramString));
    }
    if ((paramReadableArray != null) && (paramReadableArray.size() > 0))
    {
      paramString = new StringBuilder("");
      int i = 0;
      while (i < paramReadableArray.size())
      {
        paramReadableMap = paramReadableArray.getString(i).trim();
        if ((!paramReadableMap.isEmpty()) && (!paramReadableMap.contains(",")))
        {
          paramString.append(paramReadableMap);
          paramString.append(",");
        }
        i += 1;
      }
      if (paramString.length() > 0)
      {
        paramString.replace(paramString.length() - 1, paramString.length(), "");
        localBuilder.addHeader("Sec-WebSocket-Protocol", paramString.toString());
      }
    }
    localOkHttpClient.newWebSocket(localBuilder.build(), new WebSocketListener(paramInt)
    {
      public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
      {
        paramWebSocket = Arguments.createMap();
        paramWebSocket.putInt("id", this.val$id);
        paramWebSocket.putInt("code", paramInt);
        paramWebSocket.putString("reason", paramString);
        WebSocketModule.this.sendEvent("websocketClosed", paramWebSocket);
      }

      public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, Response paramResponse)
      {
        WebSocketModule.this.notifyWebSocketFailed(this.val$id, paramThrowable.getMessage());
      }

      public void onMessage(WebSocket paramWebSocket, String paramString)
      {
        paramWebSocket = Arguments.createMap();
        paramWebSocket.putInt("id", this.val$id);
        paramWebSocket.putString("type", "text");
        WebSocketModule.ContentHandler localContentHandler = (WebSocketModule.ContentHandler)WebSocketModule.this.mContentHandlers.get(Integer.valueOf(this.val$id));
        if (localContentHandler != null)
          localContentHandler.onMessage(paramString, paramWebSocket);
        while (true)
        {
          WebSocketModule.this.sendEvent("websocketMessage", paramWebSocket);
          return;
          paramWebSocket.putString("data", paramString);
        }
      }

      public void onMessage(WebSocket paramWebSocket, ByteString paramByteString)
      {
        paramWebSocket = Arguments.createMap();
        paramWebSocket.putInt("id", this.val$id);
        paramWebSocket.putString("type", "binary");
        WebSocketModule.ContentHandler localContentHandler = (WebSocketModule.ContentHandler)WebSocketModule.this.mContentHandlers.get(Integer.valueOf(this.val$id));
        if (localContentHandler != null)
          localContentHandler.onMessage(paramByteString, paramWebSocket);
        while (true)
        {
          WebSocketModule.this.sendEvent("websocketMessage", paramWebSocket);
          return;
          paramWebSocket.putString("data", paramByteString.base64());
        }
      }

      public void onOpen(WebSocket paramWebSocket, Response paramResponse)
      {
        WebSocketModule.this.mWebSocketConnections.put(Integer.valueOf(this.val$id), paramWebSocket);
        paramWebSocket = Arguments.createMap();
        paramWebSocket.putInt("id", this.val$id);
        WebSocketModule.this.sendEvent("websocketOpen", paramWebSocket);
      }
    });
    localOkHttpClient.dispatcher().executorService().shutdown();
  }

  public String getName()
  {
    return "WebSocketModule";
  }

  @ReactMethod
  public void ping(int paramInt)
  {
    WebSocket localWebSocket = (WebSocket)this.mWebSocketConnections.get(Integer.valueOf(paramInt));
    if (localWebSocket == null)
      throw new RuntimeException("Cannot send a message. Unknown WebSocket id " + paramInt);
    try
    {
      localWebSocket.send(ByteString.EMPTY);
      return;
    }
    catch (Exception localException)
    {
      notifyWebSocketFailed(paramInt, localException.getMessage());
    }
  }

  @ReactMethod
  public void send(String paramString, int paramInt)
  {
    WebSocket localWebSocket = (WebSocket)this.mWebSocketConnections.get(Integer.valueOf(paramInt));
    if (localWebSocket == null)
      throw new RuntimeException("Cannot send a message. Unknown WebSocket id " + paramInt);
    try
    {
      localWebSocket.send(paramString);
      return;
    }
    catch (Exception paramString)
    {
      notifyWebSocketFailed(paramInt, paramString.getMessage());
    }
  }

  @ReactMethod
  public void sendBinary(String paramString, int paramInt)
  {
    WebSocket localWebSocket = (WebSocket)this.mWebSocketConnections.get(Integer.valueOf(paramInt));
    if (localWebSocket == null)
      throw new RuntimeException("Cannot send a message. Unknown WebSocket id " + paramInt);
    try
    {
      localWebSocket.send(ByteString.decodeBase64(paramString));
      return;
    }
    catch (Exception paramString)
    {
      notifyWebSocketFailed(paramInt, paramString.getMessage());
    }
  }

  public void sendBinary(ByteString paramByteString, int paramInt)
  {
    WebSocket localWebSocket = (WebSocket)this.mWebSocketConnections.get(Integer.valueOf(paramInt));
    if (localWebSocket == null)
      throw new RuntimeException("Cannot send a message. Unknown WebSocket id " + paramInt);
    try
    {
      localWebSocket.send(paramByteString);
      return;
    }
    catch (Exception paramByteString)
    {
      notifyWebSocketFailed(paramInt, paramByteString.getMessage());
    }
  }

  public void setContentHandler(int paramInt, ContentHandler paramContentHandler)
  {
    if (paramContentHandler != null)
    {
      this.mContentHandlers.put(Integer.valueOf(paramInt), paramContentHandler);
      return;
    }
    this.mContentHandlers.remove(Integer.valueOf(paramInt));
  }

  public static abstract interface ContentHandler
  {
    public abstract void onMessage(String paramString, WritableMap paramWritableMap);

    public abstract void onMessage(ByteString paramByteString, WritableMap paramWritableMap);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.websocket.WebSocketModule
 * JD-Core Version:    0.6.0
 */
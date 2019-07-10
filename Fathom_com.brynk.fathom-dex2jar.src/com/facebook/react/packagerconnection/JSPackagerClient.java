package com.facebook.react.packagerconnection;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.logging.FLog;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import java.util.Map;
import okio.ByteString;
import org.json.JSONObject;

public final class JSPackagerClient
  implements ReconnectingWebSocket.MessageCallback
{
  private static final String PACKAGER_CONNECTION_URL_FORMAT = "ws://%s/message?device=%s&app=%s&context=%s";
  private static final int PROTOCOL_VERSION = 2;
  private static final String TAG = JSPackagerClient.class.getSimpleName();
  private Map<String, RequestHandler> mRequestHandlers;
  private ReconnectingWebSocket mWebSocket;

  public JSPackagerClient(String paramString, PackagerConnectionSettings paramPackagerConnectionSettings, Map<String, RequestHandler> paramMap)
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("ws").encodedAuthority(paramPackagerConnectionSettings.getDebugServerHost()).appendPath("message").appendQueryParameter("device", AndroidInfoHelpers.getFriendlyDeviceName()).appendQueryParameter("app", paramPackagerConnectionSettings.getPackageName()).appendQueryParameter("clientid", paramString);
    this.mWebSocket = new ReconnectingWebSocket(localBuilder.build().toString(), this, null);
    this.mRequestHandlers = paramMap;
  }

  private void abortOnMessage(Object paramObject, String paramString)
  {
    if (paramObject != null)
      new ResponderImpl(paramObject).error(paramString);
    FLog.e(TAG, "Handling the message failed with reason: " + paramString);
  }

  public void close()
  {
    this.mWebSocket.closeQuietly();
  }

  public void init()
  {
    this.mWebSocket.connect();
  }

  public void onMessage(String paramString)
  {
    Object localObject2;
    Object localObject1;
    try
    {
      localObject2 = new JSONObject(paramString);
      int i = ((JSONObject)localObject2).optInt("version");
      paramString = ((JSONObject)localObject2).optString("method");
      localObject1 = ((JSONObject)localObject2).opt("id");
      localObject2 = ((JSONObject)localObject2).opt("params");
      if (i != 2)
      {
        FLog.e(TAG, "Message with incompatible or missing version of protocol received: " + i);
        return;
      }
      if (paramString == null)
      {
        abortOnMessage(localObject1, "No method provided");
        return;
      }
    }
    catch (java.lang.Exception paramString)
    {
      FLog.e(TAG, "Handling the message failed", paramString);
      return;
    }
    RequestHandler localRequestHandler = (RequestHandler)this.mRequestHandlers.get(paramString);
    if (localRequestHandler == null)
    {
      abortOnMessage(localObject1, "No request handler for method: " + paramString);
      return;
    }
    if (localObject1 == null)
    {
      localRequestHandler.onNotification(localObject2);
      return;
    }
    localRequestHandler.onRequest(localObject2, new ResponderImpl(localObject1));
  }

  public void onMessage(ByteString paramByteString)
  {
    FLog.w(TAG, "Websocket received message with payload of unexpected type binary");
  }

  private class ResponderImpl
    implements Responder
  {
    private Object mId;

    public ResponderImpl(Object arg2)
    {
      Object localObject;
      this.mId = localObject;
    }

    public void error(Object paramObject)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("version", 2);
        localJSONObject.put("id", this.mId);
        localJSONObject.put("error", paramObject);
        JSPackagerClient.this.mWebSocket.sendMessage(localJSONObject.toString());
        return;
      }
      catch (java.lang.Exception paramObject)
      {
        FLog.e(JSPackagerClient.TAG, "Responding with error failed", paramObject);
      }
    }

    public void respond(Object paramObject)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("version", 2);
        localJSONObject.put("id", this.mId);
        localJSONObject.put("result", paramObject);
        JSPackagerClient.this.mWebSocket.sendMessage(localJSONObject.toString());
        return;
      }
      catch (java.lang.Exception paramObject)
      {
        FLog.e(JSPackagerClient.TAG, "Responding failed", paramObject);
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.packagerconnection.JSPackagerClient
 * JD-Core Version:    0.6.0
 */
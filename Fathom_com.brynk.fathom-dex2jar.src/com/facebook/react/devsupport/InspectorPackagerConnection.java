package com.facebook.react.devsupport;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Inspector;
import com.facebook.react.bridge.Inspector.LocalConnection;
import com.facebook.react.bridge.Inspector.Page;
import com.facebook.react.bridge.Inspector.RemoteConnection;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InspectorPackagerConnection
{
  private static final String TAG = "InspectorPackagerConnection";
  private final Connection mConnection;
  private final Map<String, Inspector.LocalConnection> mInspectorConnections;
  private final String mPackageName;

  public InspectorPackagerConnection(String paramString1, String paramString2)
  {
    this.mConnection = new Connection(paramString1);
    this.mInspectorConnections = new HashMap();
    this.mPackageName = paramString2;
  }

  private JSONArray getPages()
    throws JSONException
  {
    Object localObject = Inspector.getPages();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Inspector.Page localPage = (Inspector.Page)((Iterator)localObject).next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", String.valueOf(localPage.getId()));
      localJSONObject.put("title", localPage.getTitle());
      localJSONObject.put("app", this.mPackageName);
      localJSONArray.put(localJSONObject);
    }
    return (JSONArray)localJSONArray;
  }

  private void handleConnect(JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.getString("pageId");
    if ((Inspector.LocalConnection)this.mInspectorConnections.remove(paramJSONObject) != null)
      throw new IllegalStateException("Already connected: " + paramJSONObject);
    try
    {
      Inspector.LocalConnection localLocalConnection = Inspector.connect(Integer.parseInt(paramJSONObject), new Inspector.RemoteConnection(paramJSONObject)
      {
        public void onDisconnect()
        {
          try
          {
            InspectorPackagerConnection.this.mInspectorConnections.remove(this.val$pageId);
            InspectorPackagerConnection.this.sendEvent("disconnect", InspectorPackagerConnection.access$200(InspectorPackagerConnection.this, this.val$pageId));
            return;
          }
          catch (JSONException localJSONException)
          {
            FLog.w("InspectorPackagerConnection", "Couldn't send event to packager", localJSONException);
          }
        }

        public void onMessage(String paramString)
        {
          try
          {
            InspectorPackagerConnection.this.sendWrappedEvent(this.val$pageId, paramString);
            return;
          }
          catch (JSONException paramString)
          {
            FLog.w("InspectorPackagerConnection", "Couldn't send event to packager", paramString);
          }
        }
      });
      this.mInspectorConnections.put(paramJSONObject, localLocalConnection);
      return;
    }
    catch (Exception localException)
    {
      FLog.w("InspectorPackagerConnection", "Failed to open page: " + paramJSONObject, localException);
      sendEvent("disconnect", makePageIdPayload(paramJSONObject));
    }
  }

  private void handleDisconnect(JSONObject paramJSONObject)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.getString("pageId");
    paramJSONObject = (Inspector.LocalConnection)this.mInspectorConnections.remove(paramJSONObject);
    if (paramJSONObject == null)
      return;
    paramJSONObject.disconnect();
  }

  private void handleWrappedEvent(JSONObject paramJSONObject)
    throws JSONException
  {
    String str = paramJSONObject.getString("pageId");
    paramJSONObject = paramJSONObject.getString("wrappedEvent");
    Inspector.LocalConnection localLocalConnection = (Inspector.LocalConnection)this.mInspectorConnections.get(str);
    if (localLocalConnection == null)
      throw new IllegalStateException("Not connected: " + str);
    localLocalConnection.sendMessage(paramJSONObject);
  }

  private JSONObject makePageIdPayload(String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("pageId", paramString);
    return localJSONObject;
  }

  private void sendEvent(String paramString, Object paramObject)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("event", paramString);
    localJSONObject.put("payload", paramObject);
    this.mConnection.send(localJSONObject);
  }

  private void sendWrappedEvent(String paramString1, String paramString2)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("pageId", paramString1);
    localJSONObject.put("wrappedEvent", paramString2);
    sendEvent("wrappedEvent", localJSONObject);
  }

  void closeAllConnections()
  {
    Iterator localIterator = this.mInspectorConnections.entrySet().iterator();
    while (localIterator.hasNext())
      ((Inspector.LocalConnection)((Map.Entry)localIterator.next()).getValue()).disconnect();
    this.mInspectorConnections.clear();
  }

  public void closeQuietly()
  {
    this.mConnection.close();
  }

  public void connect()
  {
    this.mConnection.connect();
  }

  void handleProxyMessage(JSONObject paramJSONObject)
    throws JSONException, IOException
  {
    String str = paramJSONObject.getString("event");
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case 1962251790:
    case 1328613653:
    case 951351530:
    case 530405532:
    }
    while (true)
      switch (i)
      {
      default:
        throw new IllegalArgumentException("Unknown event: " + str);
        if (!str.equals("getPages"))
          continue;
        i = 0;
        continue;
        if (!str.equals("wrappedEvent"))
          continue;
        i = 1;
        continue;
        if (!str.equals("connect"))
          continue;
        i = 2;
        continue;
        if (!str.equals("disconnect"))
          continue;
        i = 3;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    sendEvent("getPages", getPages());
    return;
    handleWrappedEvent(paramJSONObject.getJSONObject("payload"));
    return;
    handleConnect(paramJSONObject.getJSONObject("payload"));
    return;
    handleDisconnect(paramJSONObject.getJSONObject("payload"));
  }

  public void sendEventToAllConnections(String paramString)
  {
    Iterator localIterator = this.mInspectorConnections.entrySet().iterator();
    while (localIterator.hasNext())
      ((Inspector.LocalConnection)((Map.Entry)localIterator.next()).getValue()).sendMessage(paramString);
  }

  private class Connection extends WebSocketListener
  {
    private static final int RECONNECT_DELAY_MS = 2000;
    private boolean mClosed;
    private final Handler mHandler;
    private OkHttpClient mHttpClient;
    private boolean mSuppressConnectionErrors;
    private final String mUrl;

    @Nullable
    private WebSocket mWebSocket;

    public Connection(String arg2)
    {
      Object localObject;
      this.mUrl = localObject;
      this.mHandler = new Handler(Looper.getMainLooper());
    }

    private void abort(String paramString, Throwable paramThrowable)
    {
      FLog.e("InspectorPackagerConnection", "Error occurred, shutting down websocket connection: " + paramString, paramThrowable);
      InspectorPackagerConnection.this.closeAllConnections();
      closeWebSocketQuietly();
    }

    private void closeWebSocketQuietly()
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

    private void reconnect()
    {
      if (this.mClosed)
        throw new IllegalStateException("Can't reconnect closed client");
      if (!this.mSuppressConnectionErrors)
      {
        FLog.w("InspectorPackagerConnection", "Couldn't connect to packager, will silently retry");
        this.mSuppressConnectionErrors = true;
      }
      this.mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          if (!InspectorPackagerConnection.Connection.this.mClosed)
            InspectorPackagerConnection.Connection.this.connect();
        }
      }
      , 2000L);
    }

    public void close()
    {
      this.mClosed = true;
      if (this.mWebSocket != null);
      try
      {
        this.mWebSocket.close(1000, "End of session");
        label27: this.mWebSocket = null;
        return;
      }
      catch (Exception localException)
      {
        break label27;
      }
    }

    public void connect()
    {
      if (this.mClosed)
        throw new IllegalStateException("Can't connect closed client");
      if (this.mHttpClient == null)
        this.mHttpClient = new OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(0L, TimeUnit.MINUTES).build();
      Request localRequest = new Request.Builder().url(this.mUrl).build();
      this.mHttpClient.newWebSocket(localRequest, this);
    }

    public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
    {
      this.mWebSocket = null;
      InspectorPackagerConnection.this.closeAllConnections();
      if (!this.mClosed)
        reconnect();
    }

    public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, Response paramResponse)
    {
      if (this.mWebSocket != null)
        abort("Websocket exception", paramThrowable);
      if (!this.mClosed)
        reconnect();
    }

    public void onMessage(WebSocket paramWebSocket, String paramString)
    {
      try
      {
        InspectorPackagerConnection.this.handleProxyMessage(new JSONObject(paramString));
        return;
      }
      catch (Exception paramWebSocket)
      {
      }
      throw new RuntimeException(paramWebSocket);
    }

    public void onOpen(WebSocket paramWebSocket, Response paramResponse)
    {
      this.mWebSocket = paramWebSocket;
    }

    public void send(JSONObject paramJSONObject)
    {
      new AsyncTask(paramJSONObject)
      {
        protected Void doInBackground(WebSocket[] paramArrayOfWebSocket)
        {
          if ((paramArrayOfWebSocket == null) || (paramArrayOfWebSocket.length == 0))
            return null;
          try
          {
            paramArrayOfWebSocket[0].send(this.val$object.toString());
            return null;
          }
          catch (Exception paramArrayOfWebSocket)
          {
            FLog.w("InspectorPackagerConnection", "Couldn't send event to packager", paramArrayOfWebSocket);
          }
          return null;
        }
      }
      .execute(new WebSocket[] { this.mWebSocket });
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.InspectorPackagerConnection
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.packagerconnection;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public final class ReconnectingWebSocket extends WebSocketListener
{
  private static final int RECONNECT_DELAY_MS = 2000;
  private static final String TAG = ReconnectingWebSocket.class.getSimpleName();
  private boolean mClosed = false;

  @Nullable
  private ConnectionCallback mConnectionCallback;
  private final Handler mHandler;

  @Nullable
  private MessageCallback mMessageCallback;
  private boolean mSuppressConnectionErrors;
  private final String mUrl;

  @Nullable
  private WebSocket mWebSocket;

  public ReconnectingWebSocket(String paramString, MessageCallback paramMessageCallback, ConnectionCallback paramConnectionCallback)
  {
    this.mUrl = paramString;
    this.mMessageCallback = paramMessageCallback;
    this.mConnectionCallback = paramConnectionCallback;
    this.mHandler = new Handler(Looper.getMainLooper());
  }

  private void abort(String paramString, Throwable paramThrowable)
  {
    FLog.e(TAG, "Error occurred, shutting down websocket connection: " + paramString, paramThrowable);
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

  private void delayedReconnect()
  {
    monitorenter;
    try
    {
      if (!this.mClosed)
        connect();
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

  private void reconnect()
  {
    if (this.mClosed)
      throw new IllegalStateException("Can't reconnect closed client");
    if (!this.mSuppressConnectionErrors)
    {
      FLog.w(TAG, "Couldn't connect to \"" + this.mUrl + "\", will silently retry");
      this.mSuppressConnectionErrors = true;
    }
    this.mHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        ReconnectingWebSocket.this.delayedReconnect();
      }
    }
    , 2000L);
  }

  public void closeQuietly()
  {
    this.mClosed = true;
    closeWebSocketQuietly();
    this.mMessageCallback = null;
    if (this.mConnectionCallback != null)
      this.mConnectionCallback.onDisconnected();
  }

  public void connect()
  {
    if (this.mClosed)
      throw new IllegalStateException("Can't connect closed client");
    new OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(0L, TimeUnit.MINUTES).build().newWebSocket(new Request.Builder().url(this.mUrl).build(), this);
  }

  public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    monitorenter;
    try
    {
      this.mWebSocket = null;
      if (!this.mClosed)
      {
        if (this.mConnectionCallback != null)
          this.mConnectionCallback.onDisconnected();
        reconnect();
      }
      return;
    }
    finally
    {
      monitorexit;
    }
    throw paramWebSocket;
  }

  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, Response paramResponse)
  {
    monitorenter;
    try
    {
      if (this.mWebSocket != null)
        abort("Websocket exception", paramThrowable);
      if (!this.mClosed)
      {
        if (this.mConnectionCallback != null)
          this.mConnectionCallback.onDisconnected();
        reconnect();
      }
      return;
    }
    finally
    {
      monitorexit;
    }
    throw paramWebSocket;
  }

  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    monitorenter;
    try
    {
      if (this.mMessageCallback != null)
        this.mMessageCallback.onMessage(paramString);
      monitorexit;
      return;
    }
    finally
    {
      paramWebSocket = finally;
      monitorexit;
    }
    throw paramWebSocket;
  }

  public void onMessage(WebSocket paramWebSocket, ByteString paramByteString)
  {
    monitorenter;
    try
    {
      if (this.mMessageCallback != null)
        this.mMessageCallback.onMessage(paramByteString);
      monitorexit;
      return;
    }
    finally
    {
      paramWebSocket = finally;
      monitorexit;
    }
    throw paramWebSocket;
  }

  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    monitorenter;
    try
    {
      this.mWebSocket = paramWebSocket;
      this.mSuppressConnectionErrors = false;
      if (this.mConnectionCallback != null)
        this.mConnectionCallback.onConnected();
      monitorexit;
      return;
    }
    finally
    {
      paramWebSocket = finally;
      monitorexit;
    }
    throw paramWebSocket;
  }

  public void sendMessage(String paramString)
    throws IOException
  {
    monitorenter;
    try
    {
      if (this.mWebSocket != null)
      {
        this.mWebSocket.send(paramString);
        return;
      }
      throw new ClosedChannelException();
    }
    finally
    {
      monitorexit;
    }
    throw paramString;
  }

  public void sendMessage(ByteString paramByteString)
    throws IOException
  {
    monitorenter;
    try
    {
      if (this.mWebSocket != null)
      {
        this.mWebSocket.send(paramByteString);
        return;
      }
      throw new ClosedChannelException();
    }
    finally
    {
      monitorexit;
    }
    throw paramByteString;
  }

  public static abstract interface ConnectionCallback
  {
    public abstract void onConnected();

    public abstract void onDisconnected();
  }

  public static abstract interface MessageCallback
  {
    public abstract void onMessage(String paramString);

    public abstract void onMessage(ByteString paramByteString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.packagerconnection.ReconnectingWebSocket
 * JD-Core Version:    0.6.0
 */
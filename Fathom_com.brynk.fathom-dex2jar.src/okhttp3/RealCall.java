package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;

final class RealCall
  implements Call
{
  final OkHttpClient client;
  private boolean executed;
  final boolean forWebSocket;
  final Request originalRequest;
  final RetryAndFollowUpInterceptor retryAndFollowUpInterceptor;

  RealCall(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean)
  {
    this.client = paramOkHttpClient;
    this.originalRequest = paramRequest;
    this.forWebSocket = paramBoolean;
    this.retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(paramOkHttpClient, paramBoolean);
  }

  private void captureCallStackTrace()
  {
    Object localObject = Platform.get().getStackTraceForCloseable("response.body().close()");
    this.retryAndFollowUpInterceptor.setCallStackTrace(localObject);
  }

  public void cancel()
  {
    this.retryAndFollowUpInterceptor.cancel();
  }

  public RealCall clone()
  {
    return new RealCall(this.client, this.originalRequest, this.forWebSocket);
  }

  public void enqueue(Callback paramCallback)
  {
    monitorenter;
    try
    {
      if (this.executed)
        throw new IllegalStateException("Already Executed");
    }
    finally
    {
      monitorexit;
    }
    this.executed = true;
    monitorexit;
    captureCallStackTrace();
    this.client.dispatcher().enqueue(new AsyncCall(paramCallback));
  }

  public Response execute()
    throws IOException
  {
    monitorenter;
    try
    {
      if (this.executed)
        throw new IllegalStateException("Already Executed");
    }
    finally
    {
      monitorexit;
    }
    this.executed = true;
    monitorexit;
    captureCallStackTrace();
    try
    {
      this.client.dispatcher().executed(this);
      Response localResponse = getResponseWithInterceptorChain();
      if (localResponse == null)
        throw new IOException("Canceled");
    }
    finally
    {
      this.client.dispatcher().finished(this);
    }
    this.client.dispatcher().finished(this);
    return localObject2;
  }

  Response getResponseWithInterceptorChain()
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.client.interceptors());
    localArrayList.add(this.retryAndFollowUpInterceptor);
    localArrayList.add(new BridgeInterceptor(this.client.cookieJar()));
    localArrayList.add(new CacheInterceptor(this.client.internalCache()));
    localArrayList.add(new ConnectInterceptor(this.client));
    if (!this.forWebSocket)
      localArrayList.addAll(this.client.networkInterceptors());
    localArrayList.add(new CallServerInterceptor(this.forWebSocket));
    return new RealInterceptorChain(localArrayList, null, null, null, 0, this.originalRequest).proceed(this.originalRequest);
  }

  public boolean isCanceled()
  {
    return this.retryAndFollowUpInterceptor.isCanceled();
  }

  public boolean isExecuted()
  {
    monitorenter;
    try
    {
      boolean bool = this.executed;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  String redactedUrl()
  {
    return this.originalRequest.url().redact();
  }

  public Request request()
  {
    return this.originalRequest;
  }

  StreamAllocation streamAllocation()
  {
    return this.retryAndFollowUpInterceptor.streamAllocation();
  }

  String toLoggableString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (isCanceled())
    {
      str = "canceled ";
      localStringBuilder = localStringBuilder.append(str);
      if (!this.forWebSocket)
        break label61;
    }
    label61: for (String str = "web socket"; ; str = "call")
    {
      return str + " to " + redactedUrl();
      str = "";
      break;
    }
  }

  final class AsyncCall extends NamedRunnable
  {
    private final Callback responseCallback;

    AsyncCall(Callback arg2)
    {
      super(new Object[] { RealCall.this.redactedUrl() });
      Object localObject;
      this.responseCallback = localObject;
    }

    protected void execute()
    {
      int j = 0;
      int i = j;
      try
      {
        Response localResponse = RealCall.this.getResponseWithInterceptorChain();
        i = j;
        if (RealCall.this.retryAndFollowUpInterceptor.isCanceled())
        {
          i = 1;
          this.responseCallback.onFailure(RealCall.this, new IOException("Canceled"));
        }
        while (true)
        {
          return;
          i = 1;
          this.responseCallback.onResponse(RealCall.this, localResponse);
        }
      }
      catch (IOException localIOException)
      {
        if (i != 0)
          Platform.get().log(4, "Callback failure for " + RealCall.this.toLoggableString(), localIOException);
        while (true)
        {
          return;
          this.responseCallback.onFailure(RealCall.this, localIOException);
        }
      }
      finally
      {
        RealCall.this.client.dispatcher().finished(this);
      }
      throw localObject;
    }

    RealCall get()
    {
      return RealCall.this;
    }

    String host()
    {
      return RealCall.this.originalRequest.url().host();
    }

    Request request()
    {
      return RealCall.this.originalRequest;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.RealCall
 * JD-Core Version:    0.6.0
 */
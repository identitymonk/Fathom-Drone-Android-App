package com.facebook.imagepipeline.backends.okhttp3;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher.Callback;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import okhttp3.CacheControl.Builder;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpNetworkFetcher extends BaseNetworkFetcher<OkHttpNetworkFetchState>
{
  private static final String FETCH_TIME = "fetch_time";
  private static final String IMAGE_SIZE = "image_size";
  private static final String QUEUE_TIME = "queue_time";
  private static final String TAG = "OkHttpNetworkFetchProducer";
  private static final String TOTAL_TIME = "total_time";
  private final Call.Factory mCallFactory;
  private Executor mCancellationExecutor;

  public OkHttpNetworkFetcher(Call.Factory paramFactory, Executor paramExecutor)
  {
    this.mCallFactory = paramFactory;
    this.mCancellationExecutor = paramExecutor;
  }

  public OkHttpNetworkFetcher(OkHttpClient paramOkHttpClient)
  {
    this(paramOkHttpClient, paramOkHttpClient.dispatcher().executorService());
  }

  private void handleException(Call paramCall, Exception paramException, NetworkFetcher.Callback paramCallback)
  {
    if (paramCall.isCanceled())
    {
      paramCallback.onCancellation();
      return;
    }
    paramCallback.onFailure(paramException);
  }

  public OkHttpNetworkFetchState createFetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    return new OkHttpNetworkFetchState(paramConsumer, paramProducerContext);
  }

  public void fetch(OkHttpNetworkFetchState paramOkHttpNetworkFetchState, NetworkFetcher.Callback paramCallback)
  {
    paramOkHttpNetworkFetchState.submitTime = SystemClock.elapsedRealtime();
    Uri localUri = paramOkHttpNetworkFetchState.getUri();
    try
    {
      fetchWithRequest(paramOkHttpNetworkFetchState, paramCallback, new Request.Builder().cacheControl(new CacheControl.Builder().noStore().build()).url(localUri.toString()).get().build());
      return;
    }
    catch (Exception paramOkHttpNetworkFetchState)
    {
      paramCallback.onFailure(paramOkHttpNetworkFetchState);
    }
  }

  protected void fetchWithRequest(OkHttpNetworkFetchState paramOkHttpNetworkFetchState, NetworkFetcher.Callback paramCallback, Request paramRequest)
  {
    paramRequest = this.mCallFactory.newCall(paramRequest);
    paramOkHttpNetworkFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks(paramRequest)
    {
      public void onCancellationRequested()
      {
        if (Looper.myLooper() != Looper.getMainLooper())
        {
          this.val$call.cancel();
          return;
        }
        OkHttpNetworkFetcher.this.mCancellationExecutor.execute(new Runnable()
        {
          public void run()
          {
            OkHttpNetworkFetcher.1.this.val$call.cancel();
          }
        });
      }
    });
    paramRequest.enqueue(new Callback(paramOkHttpNetworkFetchState, paramCallback)
    {
      public void onFailure(Call paramCall, IOException paramIOException)
      {
        OkHttpNetworkFetcher.this.handleException(paramCall, paramIOException, this.val$callback);
      }

      public void onResponse(Call paramCall, Response paramResponse)
        throws IOException
      {
        this.val$fetchState.responseTime = SystemClock.elapsedRealtime();
        ResponseBody localResponseBody = paramResponse.body();
        try
        {
          if (!paramResponse.isSuccessful())
          {
            OkHttpNetworkFetcher.this.handleException(paramCall, new IOException("Unexpected HTTP code " + paramResponse), this.val$callback);
            try
            {
              localResponseBody.close();
              return;
            }
            catch (Exception paramCall)
            {
              FLog.w("OkHttpNetworkFetchProducer", "Exception when closing response body", paramCall);
              return;
            }
          }
          long l2 = localResponseBody.contentLength();
          long l1 = l2;
          if (l2 < 0L)
            l1 = 0L;
          this.val$callback.onResponse(localResponseBody.byteStream(), (int)l1);
          try
          {
            localResponseBody.close();
            return;
          }
          catch (Exception paramCall)
          {
            FLog.w("OkHttpNetworkFetchProducer", "Exception when closing response body", paramCall);
            return;
          }
        }
        catch (Exception paramResponse)
        {
          OkHttpNetworkFetcher.this.handleException(paramCall, paramResponse, this.val$callback);
          try
          {
            localResponseBody.close();
            return;
          }
          catch (Exception paramCall)
          {
            FLog.w("OkHttpNetworkFetchProducer", "Exception when closing response body", paramCall);
            return;
          }
        }
        finally
        {
        }
        try
        {
          localResponseBody.close();
          throw paramCall;
        }
        catch (Exception paramResponse)
        {
          while (true)
            FLog.w("OkHttpNetworkFetchProducer", "Exception when closing response body", paramResponse);
        }
      }
    });
  }

  public Map<String, String> getExtraMap(OkHttpNetworkFetchState paramOkHttpNetworkFetchState, int paramInt)
  {
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("queue_time", Long.toString(paramOkHttpNetworkFetchState.responseTime - paramOkHttpNetworkFetchState.submitTime));
    localHashMap.put("fetch_time", Long.toString(paramOkHttpNetworkFetchState.fetchCompleteTime - paramOkHttpNetworkFetchState.responseTime));
    localHashMap.put("total_time", Long.toString(paramOkHttpNetworkFetchState.fetchCompleteTime - paramOkHttpNetworkFetchState.submitTime));
    localHashMap.put("image_size", Integer.toString(paramInt));
    return localHashMap;
  }

  public void onFetchCompletion(OkHttpNetworkFetchState paramOkHttpNetworkFetchState, int paramInt)
  {
    paramOkHttpNetworkFetchState.fetchCompleteTime = SystemClock.elapsedRealtime();
  }

  public static class OkHttpNetworkFetchState extends FetchState
  {
    public long fetchCompleteTime;
    public long responseTime;
    public long submitTime;

    public OkHttpNetworkFetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
    {
      super(paramProducerContext);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher
 * JD-Core Version:    0.6.0
 */
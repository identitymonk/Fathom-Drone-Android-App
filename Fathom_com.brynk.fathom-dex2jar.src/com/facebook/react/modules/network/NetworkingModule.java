package com.facebook.react.modules.network;

import android.util.Base64;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.network.OkHttpCallUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okio.ByteString;

@ReactModule(name="Networking")
public final class NetworkingModule extends ReactContextBaseJavaModule
{
  private static final int CHUNK_TIMEOUT_NS = 100000000;
  private static final String CONTENT_ENCODING_HEADER_NAME = "content-encoding";
  private static final String CONTENT_TYPE_HEADER_NAME = "content-type";
  private static final int MAX_CHUNK_SIZE_BETWEEN_FLUSHES = 8192;
  protected static final String NAME = "Networking";
  private static final String REQUEST_BODY_KEY_BASE64 = "base64";
  private static final String REQUEST_BODY_KEY_FORMDATA = "formData";
  private static final String REQUEST_BODY_KEY_STRING = "string";
  private static final String REQUEST_BODY_KEY_URI = "uri";
  private static final String USER_AGENT_HEADER_NAME = "user-agent";
  private final OkHttpClient mClient;
  private final ForwardingCookieHandler mCookieHandler;
  private final CookieJarContainer mCookieJarContainer;

  @Nullable
  private final String mDefaultUserAgent;
  private final Set<Integer> mRequestIds;
  private boolean mShuttingDown;

  public NetworkingModule(ReactApplicationContext paramReactApplicationContext)
  {
    this(paramReactApplicationContext, null, OkHttpClientProvider.createClient(), null);
  }

  public NetworkingModule(ReactApplicationContext paramReactApplicationContext, String paramString)
  {
    this(paramReactApplicationContext, paramString, OkHttpClientProvider.createClient(), null);
  }

  NetworkingModule(ReactApplicationContext paramReactApplicationContext, @Nullable String paramString, OkHttpClient paramOkHttpClient)
  {
    this(paramReactApplicationContext, paramString, paramOkHttpClient, null);
  }

  NetworkingModule(ReactApplicationContext paramReactApplicationContext, @Nullable String paramString, OkHttpClient paramOkHttpClient, @Nullable List<NetworkInterceptorCreator> paramList)
  {
    super(paramReactApplicationContext);
    OkHttpClient localOkHttpClient = paramOkHttpClient;
    if (paramList != null)
    {
      paramOkHttpClient = paramOkHttpClient.newBuilder();
      paramList = paramList.iterator();
      while (paramList.hasNext())
        paramOkHttpClient.addNetworkInterceptor(((NetworkInterceptorCreator)paramList.next()).create());
      localOkHttpClient = paramOkHttpClient.build();
    }
    this.mClient = localOkHttpClient;
    this.mCookieHandler = new ForwardingCookieHandler(paramReactApplicationContext);
    this.mCookieJarContainer = ((CookieJarContainer)this.mClient.cookieJar());
    this.mShuttingDown = false;
    this.mDefaultUserAgent = paramString;
    this.mRequestIds = new HashSet();
  }

  public NetworkingModule(ReactApplicationContext paramReactApplicationContext, List<NetworkInterceptorCreator> paramList)
  {
    this(paramReactApplicationContext, null, OkHttpClientProvider.createClient(), paramList);
  }

  private void addRequest(int paramInt)
  {
    monitorenter;
    try
    {
      this.mRequestIds.add(Integer.valueOf(paramInt));
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

  private void cancelAllRequests()
  {
    monitorenter;
    try
    {
      Iterator localIterator = this.mRequestIds.iterator();
      while (localIterator.hasNext())
        cancelRequest(((Integer)localIterator.next()).intValue());
    }
    finally
    {
      monitorexit;
    }
    this.mRequestIds.clear();
    monitorexit;
  }

  private void cancelRequest(int paramInt)
  {
    new GuardedAsyncTask(getReactApplicationContext(), paramInt)
    {
      protected void doInBackgroundGuarded(Void[] paramArrayOfVoid)
      {
        OkHttpCallUtil.cancelTag(NetworkingModule.this.mClient, Integer.valueOf(this.val$requestId));
      }
    }
    .execute(new Void[0]);
  }

  @Nullable
  private MultipartBody.Builder constructMultipartBody(ReadableArray paramReadableArray, String paramString, int paramInt)
  {
    DeviceEventManagerModule.RCTDeviceEventEmitter localRCTDeviceEventEmitter = getEventEmitter();
    MultipartBody.Builder localBuilder = new MultipartBody.Builder();
    localBuilder.setType(MediaType.parse(paramString));
    int i = 0;
    int j = paramReadableArray.size();
    paramString = localBuilder;
    Object localObject2;
    Object localObject1;
    if (i < j)
    {
      localObject2 = paramReadableArray.getMap(i);
      localObject1 = extractHeaders(((ReadableMap)localObject2).getArray("headers"), null);
      if (localObject1 == null)
      {
        ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt, "Missing or invalid header format for FormData part.", null);
        paramString = null;
      }
    }
    else
    {
      return paramString;
    }
    MediaType localMediaType = null;
    String str = ((Headers)localObject1).get("content-type");
    paramString = (String)localObject1;
    if (str != null)
    {
      localMediaType = MediaType.parse(str);
      paramString = ((Headers)localObject1).newBuilder().removeAll("content-type").build();
    }
    if (((ReadableMap)localObject2).hasKey("string"))
      localBuilder.addPart(paramString, RequestBody.create(localMediaType, ((ReadableMap)localObject2).getString("string")));
    while (true)
    {
      i += 1;
      break;
      if (((ReadableMap)localObject2).hasKey("uri"))
      {
        if (localMediaType == null)
        {
          ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt, "Binary FormData part needs a content-type header.", null);
          return null;
        }
        localObject1 = ((ReadableMap)localObject2).getString("uri");
        localObject2 = RequestBodyUtil.getFileInputStream(getReactApplicationContext(), (String)localObject1);
        if (localObject2 == null)
        {
          ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt, "Could not retrieve file for uri " + (String)localObject1, null);
          return null;
        }
        localBuilder.addPart(paramString, RequestBodyUtil.create(localMediaType, (InputStream)localObject2));
        continue;
      }
      ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt, "Unrecognized FormData part.", null);
    }
  }

  @Nullable
  private Headers extractHeaders(@Nullable ReadableArray paramReadableArray, @Nullable ReadableMap paramReadableMap)
  {
    int j = 1;
    if (paramReadableArray == null)
      return null;
    Headers.Builder localBuilder = new Headers.Builder();
    int i = 0;
    int k = paramReadableArray.size();
    while (true)
    {
      if (i >= k)
        break label106;
      Object localObject = paramReadableArray.getArray(i);
      if ((localObject == null) || (((ReadableArray)localObject).size() != 2))
        break;
      String str = ((ReadableArray)localObject).getString(0);
      localObject = ((ReadableArray)localObject).getString(1);
      if ((str == null) || (localObject == null))
        break;
      localBuilder.add(str, (String)localObject);
      i += 1;
    }
    label106: if ((localBuilder.get("user-agent") == null) && (this.mDefaultUserAgent != null))
      localBuilder.add("user-agent", this.mDefaultUserAgent);
    if ((paramReadableMap != null) && (paramReadableMap.hasKey("string")));
    for (i = j; ; i = 0)
    {
      if (i == 0)
        localBuilder.removeAll("content-encoding");
      return localBuilder.build();
    }
  }

  private DeviceEventManagerModule.RCTDeviceEventEmitter getEventEmitter()
  {
    return (DeviceEventManagerModule.RCTDeviceEventEmitter)getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
  }

  private void readWithProgress(DeviceEventManagerModule.RCTDeviceEventEmitter paramRCTDeviceEventEmitter, int paramInt, ResponseBody paramResponseBody)
    throws IOException
  {
    long l2 = -1L;
    long l3 = -1L;
    long l1 = l2;
    try
    {
      Object localObject = (ProgressResponseBody)paramResponseBody;
      l1 = l2;
      l2 = ((ProgressResponseBody)localObject).totalBytesRead();
      l1 = l2;
      long l4 = ((ProgressResponseBody)localObject).contentLength();
      l3 = l4;
      l1 = l2;
      label50: paramResponseBody = paramResponseBody.charStream();
      try
      {
        localObject = new char[8192];
        while (true)
        {
          int i = paramResponseBody.read(localObject);
          if (i == -1)
            break;
          ResponseUtil.onIncrementalDataReceived(paramRCTDeviceEventEmitter, paramInt, new String(localObject, 0, i), l1, l3);
        }
      }
      finally
      {
        paramResponseBody.close();
      }
      paramResponseBody.close();
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      break label50;
    }
  }

  private void removeRequest(int paramInt)
  {
    monitorenter;
    try
    {
      this.mRequestIds.remove(Integer.valueOf(paramInt));
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

  private static boolean shouldDispatch(long paramLong1, long paramLong2)
  {
    return 100000000L + paramLong2 < paramLong1;
  }

  private static WritableMap translateHeaders(Headers paramHeaders)
  {
    WritableMap localWritableMap = Arguments.createMap();
    int i = 0;
    if (i < paramHeaders.size())
    {
      String str = paramHeaders.name(i);
      if (localWritableMap.hasKey(str))
        localWritableMap.putString(str, localWritableMap.getString(str) + ", " + paramHeaders.value(i));
      while (true)
      {
        i += 1;
        break;
        localWritableMap.putString(str, paramHeaders.value(i));
      }
    }
    return localWritableMap;
  }

  @ReactMethod
  public void abortRequest(int paramInt)
  {
    cancelRequest(paramInt);
    removeRequest(paramInt);
  }

  @ReactMethod
  public void clearCookies(com.facebook.react.bridge.Callback paramCallback)
  {
    this.mCookieHandler.clearCookies(paramCallback);
  }

  public String getName()
  {
    return "Networking";
  }

  public void initialize()
  {
    this.mCookieJarContainer.setCookieJar(new JavaNetCookieJar(this.mCookieHandler));
  }

  public void onCatalystInstanceDestroy()
  {
    this.mShuttingDown = true;
    cancelAllRequests();
    this.mCookieHandler.destroy();
    this.mCookieJarContainer.removeCookieJar();
  }

  @ReactMethod
  public void sendRequest(String paramString1, String paramString2, int paramInt1, ReadableArray paramReadableArray, ReadableMap paramReadableMap, String paramString3, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    Request.Builder localBuilder = new Request.Builder().url(paramString2);
    if (paramInt1 != 0)
      localBuilder.tag(Integer.valueOf(paramInt1));
    DeviceEventManagerModule.RCTDeviceEventEmitter localRCTDeviceEventEmitter = getEventEmitter();
    paramString2 = this.mClient.newBuilder();
    if (!paramBoolean2)
      paramString2.cookieJar(CookieJar.NO_COOKIES);
    if (paramBoolean1)
      paramString2.addNetworkInterceptor(new Interceptor(paramString3, localRCTDeviceEventEmitter, paramInt1)
      {
        public Response intercept(Interceptor.Chain paramChain)
          throws IOException
        {
          paramChain = paramChain.proceed(paramChain.request());
          ProgressResponseBody localProgressResponseBody = new ProgressResponseBody(paramChain.body(), new ProgressListener()
          {
            long last = System.nanoTime();

            public void onProgress(long paramLong1, long paramLong2, boolean paramBoolean)
            {
              long l = System.nanoTime();
              if ((!paramBoolean) && (!NetworkingModule.access$000(l, this.last)));
              do
                return;
              while (NetworkingModule.1.this.val$responseType.equals("text"));
              ResponseUtil.onDataReceivedProgress(NetworkingModule.1.this.val$eventEmitter, NetworkingModule.1.this.val$requestId, paramLong1, paramLong2);
              this.last = l;
            }
          });
          return paramChain.newBuilder().body(localProgressResponseBody).build();
        }
      });
    if (paramInt2 != this.mClient.connectTimeoutMillis())
      paramString2.readTimeout(paramInt2, TimeUnit.MILLISECONDS);
    OkHttpClient localOkHttpClient = paramString2.build();
    Headers localHeaders = extractHeaders(paramReadableArray, paramReadableMap);
    if (localHeaders == null)
    {
      ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt1, "Unrecognized headers format", null);
      return;
    }
    paramReadableArray = localHeaders.get("content-type");
    paramString2 = localHeaders.get("content-encoding");
    localBuilder.headers(localHeaders);
    if (paramReadableMap == null)
      localBuilder.method(paramString1, RequestBodyUtil.getEmptyBody(paramString1));
    while (true)
    {
      addRequest(paramInt1);
      localOkHttpClient.newCall(localBuilder.build()).enqueue(new okhttp3.Callback(paramInt1, localRCTDeviceEventEmitter, paramBoolean1, paramString3)
      {
        public void onFailure(Call paramCall, IOException paramIOException)
        {
          if (NetworkingModule.this.mShuttingDown)
            return;
          NetworkingModule.this.removeRequest(this.val$requestId);
          if (paramIOException.getMessage() != null);
          for (paramCall = paramIOException.getMessage(); ; paramCall = "Error while executing request: " + paramIOException.getClass().getSimpleName())
          {
            ResponseUtil.onRequestError(this.val$eventEmitter, this.val$requestId, paramCall, paramIOException);
            return;
          }
        }

        public void onResponse(Call paramCall, Response paramResponse)
          throws IOException
        {
          if (NetworkingModule.this.mShuttingDown)
            return;
          NetworkingModule.this.removeRequest(this.val$requestId);
          ResponseUtil.onResponseReceived(this.val$eventEmitter, this.val$requestId, paramResponse.code(), NetworkingModule.access$300(paramResponse.headers()), paramResponse.request().url().toString());
          ResponseBody localResponseBody = paramResponse.body();
          try
          {
            if ((this.val$useIncrementalUpdates) && (this.val$responseType.equals("text")))
            {
              NetworkingModule.this.readWithProgress(this.val$eventEmitter, this.val$requestId, localResponseBody);
              ResponseUtil.onRequestSuccess(this.val$eventEmitter, this.val$requestId);
              return;
            }
          }
          catch (IOException paramCall)
          {
            ResponseUtil.onRequestError(this.val$eventEmitter, this.val$requestId, paramCall.getMessage(), paramCall);
            return;
          }
          String str = "";
          boolean bool = this.val$responseType.equals("text");
          if (bool);
          while (true)
          {
            try
            {
              paramCall = localResponseBody.string();
              ResponseUtil.onDataReceived(this.val$eventEmitter, this.val$requestId, paramCall);
              ResponseUtil.onRequestSuccess(this.val$eventEmitter, this.val$requestId);
              return;
            }
            catch (IOException localIOException)
            {
              paramCall = str;
              if (paramResponse.request().method().equalsIgnoreCase("HEAD"))
                continue;
              ResponseUtil.onRequestError(this.val$eventEmitter, this.val$requestId, localIOException.getMessage(), localIOException);
              paramCall = str;
              continue;
            }
            paramCall = str;
            if (!this.val$responseType.equals("base64"))
              continue;
            paramCall = Base64.encodeToString(localIOException.bytes(), 2);
          }
        }
      });
      return;
      if (paramReadableMap.hasKey("string"))
      {
        if (paramReadableArray == null)
        {
          ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt1, "Payload is set but no content-type header specified", null);
          return;
        }
        paramReadableMap = paramReadableMap.getString("string");
        paramReadableArray = MediaType.parse(paramReadableArray);
        if (RequestBodyUtil.isGzipEncoding(paramString2))
        {
          paramString2 = RequestBodyUtil.createGzip(paramReadableArray, paramReadableMap);
          if (paramString2 == null)
          {
            ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt1, "Failed to gzip request body", null);
            return;
          }
          localBuilder.method(paramString1, paramString2);
          continue;
        }
        localBuilder.method(paramString1, RequestBody.create(paramReadableArray, paramReadableMap));
        continue;
      }
      if (paramReadableMap.hasKey("base64"))
      {
        if (paramReadableArray == null)
        {
          ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt1, "Payload is set but no content-type header specified", null);
          return;
        }
        paramString2 = paramReadableMap.getString("base64");
        localBuilder.method(paramString1, RequestBody.create(MediaType.parse(paramReadableArray), ByteString.decodeBase64(paramString2)));
        continue;
      }
      if (paramReadableMap.hasKey("uri"))
      {
        if (paramReadableArray == null)
        {
          ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt1, "Payload is set but no content-type header specified", null);
          return;
        }
        paramString2 = paramReadableMap.getString("uri");
        paramReadableMap = RequestBodyUtil.getFileInputStream(getReactApplicationContext(), paramString2);
        if (paramReadableMap == null)
        {
          ResponseUtil.onRequestError(localRCTDeviceEventEmitter, paramInt1, "Could not retrieve file for uri " + paramString2, null);
          return;
        }
        localBuilder.method(paramString1, RequestBodyUtil.create(MediaType.parse(paramReadableArray), paramReadableMap));
        continue;
      }
      if (paramReadableMap.hasKey("formData"))
      {
        paramString2 = paramReadableArray;
        if (paramReadableArray == null)
          paramString2 = "multipart/form-data";
        paramString2 = constructMultipartBody(paramReadableMap.getArray("formData"), paramString2, paramInt1);
        if (paramString2 == null)
          break;
        localBuilder.method(paramString1, RequestBodyUtil.createProgressRequest(paramString2.build(), new ProgressListener(localRCTDeviceEventEmitter, paramInt1)
        {
          long last = System.nanoTime();

          public void onProgress(long paramLong1, long paramLong2, boolean paramBoolean)
          {
            long l = System.nanoTime();
            if ((paramBoolean) || (NetworkingModule.access$000(l, this.last)))
            {
              ResponseUtil.onDataSend(this.val$eventEmitter, this.val$requestId, paramLong1, paramLong2);
              this.last = l;
            }
          }
        }));
        continue;
      }
      localBuilder.method(paramString1, RequestBodyUtil.getEmptyBody(paramString1));
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.NetworkingModule
 * JD-Core Version:    0.6.0
 */
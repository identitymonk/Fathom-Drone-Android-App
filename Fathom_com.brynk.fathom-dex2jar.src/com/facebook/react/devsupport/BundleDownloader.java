package com.facebook.react.devsupport;

import android.util.Log;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import org.json.JSONException;
import org.json.JSONObject;

public class BundleDownloader
{
  private static final int FILES_CHANGED_COUNT_NOT_BUILT_BY_BUNDLER = -2;
  private static final String TAG = "BundleDownloader";
  private final OkHttpClient mClient;

  @Nullable
  private Call mDownloadBundleFromURLCall;

  public BundleDownloader(OkHttpClient paramOkHttpClient)
  {
    this.mClient = paramOkHttpClient;
  }

  private static void populateBundleInfo(String paramString, Headers paramHeaders, BundleInfo paramBundleInfo)
  {
    BundleInfo.access$202(paramBundleInfo, paramString);
    paramString = paramHeaders.get("X-Metro-Files-Changed-Count");
    if (paramString != null);
    try
    {
      BundleInfo.access$302(paramBundleInfo, Integer.parseInt(paramString));
      return;
    }
    catch (java.lang.NumberFormatException paramString)
    {
      BundleInfo.access$302(paramBundleInfo, -2);
    }
  }

  private static void processBundleResult(String paramString, int paramInt, Headers paramHeaders, BufferedSource paramBufferedSource, File paramFile, BundleInfo paramBundleInfo, DevBundleDownloadListener paramDevBundleDownloadListener)
    throws IOException
  {
    if (paramInt != 200)
    {
      paramHeaders = paramBufferedSource.readUtf8();
      paramBufferedSource = DebugServerException.parse(paramHeaders);
      if (paramBufferedSource != null)
      {
        paramDevBundleDownloadListener.onFailure(paramBufferedSource);
        return;
      }
      paramBufferedSource = new StringBuilder();
      paramBufferedSource.append("The development server returned response error code: ").append(paramInt).append("\n\n").append("URL: ").append(paramString).append("\n\n").append("Body:\n").append(paramHeaders);
      paramDevBundleDownloadListener.onFailure(new DebugServerException(paramBufferedSource.toString()));
      return;
    }
    if (paramBundleInfo != null)
      populateBundleInfo(paramString, paramHeaders, paramBundleInfo);
    paramBundleInfo = new File(paramFile.getPath() + ".tmp");
    paramString = null;
    try
    {
      paramHeaders = Okio.sink(paramBundleInfo);
      paramString = paramHeaders;
      paramBufferedSource.readAll(paramHeaders);
      if (paramHeaders != null)
        paramHeaders.close();
      if (paramBundleInfo.renameTo(paramFile))
      {
        paramDevBundleDownloadListener.onSuccess();
        return;
      }
    }
    finally
    {
      if (paramString != null)
        paramString.close();
    }
    throw new IOException("Couldn't rename " + paramBundleInfo + " to " + paramFile);
  }

  public void cancelDownloadBundleFromURL()
  {
    if (this.mDownloadBundleFromURLCall != null)
    {
      this.mDownloadBundleFromURLCall.cancel();
      this.mDownloadBundleFromURLCall = null;
    }
  }

  public void downloadBundleFromURL(DevBundleDownloadListener paramDevBundleDownloadListener, File paramFile, String paramString, @Nullable BundleInfo paramBundleInfo)
  {
    paramString = new Request.Builder().url(paramString).build();
    this.mDownloadBundleFromURLCall = ((Call)Assertions.assertNotNull(this.mClient.newCall(paramString)));
    this.mDownloadBundleFromURLCall.enqueue(new Callback(paramDevBundleDownloadListener, paramFile, paramBundleInfo)
    {
      public void onFailure(Call paramCall, IOException paramIOException)
      {
        if ((BundleDownloader.this.mDownloadBundleFromURLCall == null) || (BundleDownloader.this.mDownloadBundleFromURLCall.isCanceled()))
        {
          BundleDownloader.access$002(BundleDownloader.this, null);
          return;
        }
        BundleDownloader.access$002(BundleDownloader.this, null);
        this.val$callback.onFailure(DebugServerException.makeGeneric("Could not connect to development server.", "URL: " + paramCall.request().url().toString(), paramIOException));
      }

      public void onResponse(Call paramCall, Response paramResponse)
        throws IOException
      {
        if ((BundleDownloader.this.mDownloadBundleFromURLCall == null) || (BundleDownloader.this.mDownloadBundleFromURLCall.isCanceled()))
          BundleDownloader.access$002(BundleDownloader.this, null);
        String str;
        while (true)
        {
          return;
          BundleDownloader.access$002(BundleDownloader.this, null);
          str = paramResponse.request().url().toString();
          Object localObject = paramResponse.header("content-type");
          localObject = Pattern.compile("multipart/mixed;.*boundary=\"([^\"]+)\"").matcher((CharSequence)localObject);
          if (!((Matcher)localObject).find())
            break;
          localObject = ((Matcher)localObject).group(1);
          if (new MultipartStreamReader(paramResponse.body().source(), (String)localObject).readAllParts(new MultipartStreamReader.ChunkCallback(paramResponse, str)
          {
            public void execute(Map<String, String> paramMap, Buffer paramBuffer, boolean paramBoolean)
              throws IOException
            {
              if (paramBoolean)
              {
                int i = this.val$response.code();
                if (paramMap.containsKey("X-Http-Status"))
                  i = Integer.parseInt((String)paramMap.get("X-Http-Status"));
                BundleDownloader.access$100(this.val$url, i, Headers.of(paramMap), paramBuffer, BundleDownloader.1.this.val$outputFile, BundleDownloader.1.this.val$bundleInfo, BundleDownloader.1.this.val$callback);
              }
              do
                return;
              while ((!paramMap.containsKey("Content-Type")) || (!((String)paramMap.get("Content-Type")).equals("application/json")));
              try
              {
                JSONObject localJSONObject = new JSONObject(paramBuffer.readUtf8());
                paramMap = null;
                if (localJSONObject.has("status"))
                  paramMap = localJSONObject.getString("status");
                paramBuffer = null;
                if (localJSONObject.has("done"))
                  paramBuffer = Integer.valueOf(localJSONObject.getInt("done"));
                Integer localInteger = null;
                if (localJSONObject.has("total"))
                  localInteger = Integer.valueOf(localJSONObject.getInt("total"));
                BundleDownloader.1.this.val$callback.onProgress(paramMap, paramBuffer, localInteger);
                return;
              }
              catch (JSONException paramMap)
              {
                FLog.e("ReactNative", "Error parsing progress JSON. " + paramMap.toString());
              }
            }
          }))
            continue;
          this.val$callback.onFailure(new DebugServerException("Error while reading multipart response.\n\nResponse code: " + paramResponse.code() + "\n\n" + "URL: " + paramCall.request().url().toString() + "\n\n"));
          return;
        }
        BundleDownloader.access$100(str, paramResponse.code(), paramResponse.headers(), Okio.buffer(paramResponse.body().source()), this.val$outputFile, this.val$bundleInfo, this.val$callback);
      }
    });
  }

  public static class BundleInfo
  {
    private int mFilesChangedCount;

    @Nullable
    private String mUrl;

    @Nullable
    public static BundleInfo fromJSONString(String paramString)
    {
      if (paramString == null)
        return null;
      BundleInfo localBundleInfo = new BundleInfo();
      try
      {
        paramString = new JSONObject(paramString);
        localBundleInfo.mUrl = paramString.getString("url");
        localBundleInfo.mFilesChangedCount = paramString.getInt("filesChangedCount");
        return localBundleInfo;
      }
      catch (JSONException paramString)
      {
        Log.e("BundleDownloader", "Invalid bundle info: ", paramString);
      }
      return null;
    }

    public int getFilesChangedCount()
    {
      return this.mFilesChangedCount;
    }

    public String getUrl()
    {
      if (this.mUrl != null)
        return this.mUrl;
      return "unknown";
    }

    @Nullable
    public String toJSONString()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("url", this.mUrl);
        localJSONObject.put("filesChangedCount", this.mFilesChangedCount);
        return localJSONObject.toString();
      }
      catch (JSONException localJSONException)
      {
        Log.e("BundleDownloader", "Can't serialize bundle info: ", localJSONException);
      }
      return null;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.BundleDownloader
 * JD-Core Version:    0.6.0
 */
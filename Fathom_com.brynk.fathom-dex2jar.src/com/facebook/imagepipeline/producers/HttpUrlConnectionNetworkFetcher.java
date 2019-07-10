package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<FetchState>
{
  public static final int HTTP_PERMANENT_REDIRECT = 308;
  public static final int HTTP_TEMPORARY_REDIRECT = 307;
  private static final int MAX_REDIRECTS = 5;
  private static final int NUM_NETWORK_THREADS = 3;
  private final ExecutorService mExecutorService;

  public HttpUrlConnectionNetworkFetcher()
  {
    this(Executors.newFixedThreadPool(3));
  }

  @VisibleForTesting
  HttpUrlConnectionNetworkFetcher(ExecutorService paramExecutorService)
  {
    this.mExecutorService = paramExecutorService;
  }

  private HttpURLConnection downloadFrom(Uri paramUri, int paramInt)
    throws IOException
  {
    Object localObject = openConnectionTo(paramUri);
    int i = ((HttpURLConnection)localObject).getResponseCode();
    if (isHttpSuccess(i))
      return localObject;
    if (isHttpRedirect(i))
    {
      String str = ((HttpURLConnection)localObject).getHeaderField("Location");
      ((HttpURLConnection)localObject).disconnect();
      if (str == null);
      for (localObject = null; ; localObject = Uri.parse(str))
      {
        str = paramUri.getScheme();
        if ((paramInt <= 0) || (localObject == null) || (((Uri)localObject).getScheme().equals(str)))
          break;
        return downloadFrom((Uri)localObject, paramInt - 1);
      }
      if (paramInt == 0);
      for (paramUri = error("URL %s follows too many redirects", new Object[] { paramUri.toString() }); ; paramUri = error("URL %s returned %d without a valid redirect", new Object[] { paramUri.toString(), Integer.valueOf(i) }))
        throw new IOException(paramUri);
    }
    ((HttpURLConnection)localObject).disconnect();
    throw new IOException(String.format("Image URL %s returned HTTP code %d", new Object[] { paramUri.toString(), Integer.valueOf(i) }));
  }

  private static String error(String paramString, Object[] paramArrayOfObject)
  {
    return String.format(Locale.getDefault(), paramString, paramArrayOfObject);
  }

  private static boolean isHttpRedirect(int paramInt)
  {
    switch (paramInt)
    {
    case 304:
    case 305:
    case 306:
    default:
      return false;
    case 300:
    case 301:
    case 302:
    case 303:
    case 307:
    case 308:
    }
    return true;
  }

  private static boolean isHttpSuccess(int paramInt)
  {
    return (paramInt >= 200) && (paramInt < 300);
  }

  @VisibleForTesting
  static HttpURLConnection openConnectionTo(Uri paramUri)
    throws IOException
  {
    return (HttpURLConnection)new URL(paramUri.toString()).openConnection();
  }

  public FetchState createFetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    return new FetchState(paramConsumer, paramProducerContext);
  }

  public void fetch(FetchState paramFetchState, NetworkFetcher.Callback paramCallback)
  {
    Future localFuture = this.mExecutorService.submit(new Runnable(paramFetchState, paramCallback)
    {
      public void run()
      {
        HttpUrlConnectionNetworkFetcher.this.fetchSync(this.val$fetchState, this.val$callback);
      }
    });
    paramFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks(localFuture, paramCallback)
    {
      public void onCancellationRequested()
      {
        if (this.val$future.cancel(false))
          this.val$callback.onCancellation();
      }
    });
  }

  // ERROR //
  @VisibleForTesting
  void fetchSync(FetchState paramFetchState, NetworkFetcher.Callback paramCallback)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 9
    //   11: aconst_null
    //   12: astore 10
    //   14: aload 8
    //   16: astore 5
    //   18: aload 9
    //   20: astore 6
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 168	com/facebook/imagepipeline/producers/FetchState:getUri	()Landroid/net/Uri;
    //   27: iconst_5
    //   28: invokespecial 82	com/facebook/imagepipeline/producers/HttpUrlConnectionNetworkFetcher:downloadFrom	(Landroid/net/Uri;I)Ljava/net/HttpURLConnection;
    //   31: astore 7
    //   33: aload 10
    //   35: astore_1
    //   36: aload 7
    //   38: ifnull +45 -> 83
    //   41: aload 7
    //   43: astore_3
    //   44: aload 8
    //   46: astore 5
    //   48: aload 7
    //   50: astore 4
    //   52: aload 9
    //   54: astore 6
    //   56: aload 7
    //   58: invokevirtual 172	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   61: astore_1
    //   62: aload 7
    //   64: astore_3
    //   65: aload_1
    //   66: astore 5
    //   68: aload 7
    //   70: astore 4
    //   72: aload_1
    //   73: astore 6
    //   75: aload_2
    //   76: aload_1
    //   77: iconst_m1
    //   78: invokeinterface 178 3 0
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 183	java/io/InputStream:close	()V
    //   91: aload 7
    //   93: ifnull +8 -> 101
    //   96: aload 7
    //   98: invokevirtual 68	java/net/HttpURLConnection:disconnect	()V
    //   101: return
    //   102: astore_1
    //   103: aload_3
    //   104: astore 4
    //   106: aload 5
    //   108: astore 6
    //   110: aload_2
    //   111: aload_1
    //   112: invokeinterface 187 2 0
    //   117: aload 5
    //   119: ifnull +8 -> 127
    //   122: aload 5
    //   124: invokevirtual 183	java/io/InputStream:close	()V
    //   127: aload_3
    //   128: ifnull -27 -> 101
    //   131: aload_3
    //   132: invokevirtual 68	java/net/HttpURLConnection:disconnect	()V
    //   135: return
    //   136: astore_1
    //   137: aload 6
    //   139: ifnull +8 -> 147
    //   142: aload 6
    //   144: invokevirtual 183	java/io/InputStream:close	()V
    //   147: aload 4
    //   149: ifnull +8 -> 157
    //   152: aload 4
    //   154: invokevirtual 68	java/net/HttpURLConnection:disconnect	()V
    //   157: aload_1
    //   158: athrow
    //   159: astore_1
    //   160: goto -69 -> 91
    //   163: astore_1
    //   164: goto -37 -> 127
    //   167: astore_2
    //   168: goto -21 -> 147
    //
    // Exception table:
    //   from	to	target	type
    //   22	33	102	java/io/IOException
    //   56	62	102	java/io/IOException
    //   75	83	102	java/io/IOException
    //   22	33	136	finally
    //   56	62	136	finally
    //   75	83	136	finally
    //   110	117	136	finally
    //   87	91	159	java/io/IOException
    //   122	127	163	java/io/IOException
    //   142	147	167	java/io/IOException
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher
 * JD-Core Version:    0.6.0
 */
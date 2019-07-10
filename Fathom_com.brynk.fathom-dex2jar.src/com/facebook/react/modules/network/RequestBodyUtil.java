package com.facebook.react.modules.network;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.facebook.common.logging.FLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.zip.GZIPOutputStream;
import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

class RequestBodyUtil
{
  private static final String CONTENT_ENCODING_GZIP = "gzip";
  private static final String NAME = "RequestBodyUtil";
  private static final String TEMP_FILE_SUFFIX = "temp";

  public static RequestBody create(MediaType paramMediaType, InputStream paramInputStream)
  {
    return new RequestBody(paramMediaType, paramInputStream)
    {
      public long contentLength()
      {
        try
        {
          int i = this.val$inputStream.available();
          return i;
        }
        catch (IOException localIOException)
        {
        }
        return 0L;
      }

      public MediaType contentType()
      {
        return this.val$mediaType;
      }

      public void writeTo(BufferedSink paramBufferedSink)
        throws IOException
      {
        Object localObject = null;
        try
        {
          Source localSource = Okio.source(this.val$inputStream);
          localObject = localSource;
          paramBufferedSink.writeAll(localSource);
          return;
        }
        finally
        {
          Util.closeQuietly(localObject);
        }
        throw paramBufferedSink;
      }
    };
  }

  @Nullable
  public static RequestBody createGzip(MediaType paramMediaType, String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramString.getBytes());
      localGZIPOutputStream.close();
      return RequestBody.create(paramMediaType, localByteArrayOutputStream.toByteArray());
    }
    catch (IOException paramMediaType)
    {
    }
    return null;
  }

  public static ProgressRequestBody createProgressRequest(RequestBody paramRequestBody, ProgressListener paramProgressListener)
  {
    return new ProgressRequestBody(paramRequestBody, paramProgressListener);
  }

  private static InputStream getDownloadFileInputStream(Context paramContext, Uri paramUri)
    throws IOException
  {
    Object localObject2 = File.createTempFile("RequestBodyUtil", "temp", paramContext.getApplicationContext().getCacheDir());
    ((File)localObject2).deleteOnExit();
    paramContext = new URL(paramUri.toString()).openStream();
    try
    {
      paramUri = Channels.newChannel(paramContext);
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream((File)localObject2);
        try
        {
          localFileOutputStream.getChannel().transferFrom(paramUri, 0L, 9223372036854775807L);
          localObject2 = new FileInputStream((File)localObject2);
          localFileOutputStream.close();
          paramUri.close();
          return localObject2;
        }
        finally
        {
          localFileOutputStream.close();
        }
      }
      finally
      {
        paramUri.close();
      }
    }
    finally
    {
      paramContext.close();
    }
    throw paramUri;
  }

  public static RequestBody getEmptyBody(String paramString)
  {
    RequestBody localRequestBody = null;
    if ((paramString.equals("POST")) || (paramString.equals("PUT")) || (paramString.equals("PATCH")))
      localRequestBody = RequestBody.create(null, ByteString.EMPTY);
    return localRequestBody;
  }

  @Nullable
  public static InputStream getFileInputStream(Context paramContext, String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(paramString);
      if (localUri.getScheme().startsWith("http"))
        return getDownloadFileInputStream(paramContext, localUri);
      paramContext = paramContext.getContentResolver().openInputStream(localUri);
      return paramContext;
    }
    catch (java.lang.Exception paramContext)
    {
      FLog.e("ReactNative", "Could not retrieve file for contentUri " + paramString, paramContext);
    }
    return null;
  }

  public static boolean isGzipEncoding(@Nullable String paramString)
  {
    return "gzip".equalsIgnoreCase(paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.RequestBodyUtil
 * JD-Core Version:    0.6.0
 */
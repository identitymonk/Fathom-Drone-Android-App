package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

public abstract class RequestBody
{
  public static RequestBody create(MediaType paramMediaType, File paramFile)
  {
    if (paramFile == null)
      throw new NullPointerException("content == null");
    return new RequestBody(paramMediaType, paramFile)
    {
      public long contentLength()
      {
        return this.val$file.length();
      }

      public MediaType contentType()
      {
        return this.val$contentType;
      }

      public void writeTo(BufferedSink paramBufferedSink)
        throws IOException
      {
        Object localObject = null;
        try
        {
          Source localSource = Okio.source(this.val$file);
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

  public static RequestBody create(MediaType paramMediaType, String paramString)
  {
    Object localObject = Util.UTF_8;
    MediaType localMediaType = paramMediaType;
    if (paramMediaType != null)
    {
      Charset localCharset = paramMediaType.charset();
      localObject = localCharset;
      localMediaType = paramMediaType;
      if (localCharset == null)
      {
        localObject = Util.UTF_8;
        localMediaType = MediaType.parse(paramMediaType + "; charset=utf-8");
      }
    }
    return (RequestBody)create(localMediaType, paramString.getBytes((Charset)localObject));
  }

  public static RequestBody create(MediaType paramMediaType, ByteString paramByteString)
  {
    return new RequestBody(paramMediaType, paramByteString)
    {
      public long contentLength()
        throws IOException
      {
        return this.val$content.size();
      }

      public MediaType contentType()
      {
        return this.val$contentType;
      }

      public void writeTo(BufferedSink paramBufferedSink)
        throws IOException
      {
        paramBufferedSink.write(this.val$content);
      }
    };
  }

  public static RequestBody create(MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    return create(paramMediaType, paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static RequestBody create(MediaType paramMediaType, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null)
      throw new NullPointerException("content == null");
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    return new RequestBody(paramMediaType, paramInt2, paramArrayOfByte, paramInt1)
    {
      public long contentLength()
      {
        return this.val$byteCount;
      }

      public MediaType contentType()
      {
        return this.val$contentType;
      }

      public void writeTo(BufferedSink paramBufferedSink)
        throws IOException
      {
        paramBufferedSink.write(this.val$content, this.val$offset, this.val$byteCount);
      }
    };
  }

  public long contentLength()
    throws IOException
  {
    return -1L;
  }

  public abstract MediaType contentType();

  public abstract void writeTo(BufferedSink paramBufferedSink)
    throws IOException;
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.RequestBody
 * JD-Core Version:    0.6.0
 */
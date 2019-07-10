package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;

public abstract class ResponseBody
  implements Closeable
{
  private Reader reader;

  private Charset charset()
  {
    MediaType localMediaType = contentType();
    if (localMediaType != null)
      return localMediaType.charset(Util.UTF_8);
    return Util.UTF_8;
  }

  public static ResponseBody create(MediaType paramMediaType, long paramLong, BufferedSource paramBufferedSource)
  {
    if (paramBufferedSource == null)
      throw new NullPointerException("source == null");
    return new ResponseBody(paramMediaType, paramLong, paramBufferedSource)
    {
      public long contentLength()
      {
        return this.val$contentLength;
      }

      public MediaType contentType()
      {
        return this.val$contentType;
      }

      public BufferedSource source()
      {
        return this.val$content;
      }
    };
  }

  public static ResponseBody create(MediaType paramMediaType, String paramString)
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
    paramMediaType = new Buffer().writeString(paramString, (Charset)localObject);
    return (ResponseBody)create(localMediaType, paramMediaType.size(), paramMediaType);
  }

  public static ResponseBody create(MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    Buffer localBuffer = new Buffer().write(paramArrayOfByte);
    return create(paramMediaType, paramArrayOfByte.length, localBuffer);
  }

  public final InputStream byteStream()
  {
    return source().inputStream();
  }

  public final byte[] bytes()
    throws IOException
  {
    long l = contentLength();
    if (l > 2147483647L)
      throw new IOException("Cannot buffer entire body for content length: " + l);
    BufferedSource localBufferedSource = source();
    try
    {
      byte[] arrayOfByte = localBufferedSource.readByteArray();
      Util.closeQuietly(localBufferedSource);
      if ((l != -1L) && (l != arrayOfByte.length))
        throw new IOException("Content-Length (" + l + ") and stream length (" + arrayOfByte.length + ") disagree");
    }
    finally
    {
      Util.closeQuietly(localBufferedSource);
    }
    return localObject;
  }

  public final Reader charStream()
  {
    Object localObject = this.reader;
    if (localObject != null)
      return localObject;
    localObject = new BomAwareReader(source(), charset());
    this.reader = ((Reader)localObject);
    return (Reader)localObject;
  }

  public void close()
  {
    Util.closeQuietly(source());
  }

  public abstract long contentLength();

  public abstract MediaType contentType();

  public abstract BufferedSource source();

  public final String string()
    throws IOException
  {
    BufferedSource localBufferedSource = source();
    try
    {
      String str = localBufferedSource.readString(Util.bomAwareCharset(localBufferedSource, charset()));
      return str;
    }
    finally
    {
      Util.closeQuietly(localBufferedSource);
    }
    throw localObject;
  }

  static final class BomAwareReader extends Reader
  {
    private final Charset charset;
    private boolean closed;
    private Reader delegate;
    private final BufferedSource source;

    BomAwareReader(BufferedSource paramBufferedSource, Charset paramCharset)
    {
      this.source = paramBufferedSource;
      this.charset = paramCharset;
    }

    public void close()
      throws IOException
    {
      this.closed = true;
      if (this.delegate != null)
      {
        this.delegate.close();
        return;
      }
      this.source.close();
    }

    public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws IOException
    {
      if (this.closed)
        throw new IOException("Stream closed");
      Reader localReader = this.delegate;
      Object localObject = localReader;
      if (localReader == null)
      {
        localObject = Util.bomAwareCharset(this.source, this.charset);
        localObject = new InputStreamReader(this.source.inputStream(), (Charset)localObject);
        this.delegate = ((Reader)localObject);
      }
      return ((Reader)localObject).read(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.ResponseBody
 * JD-Core Version:    0.6.0
 */
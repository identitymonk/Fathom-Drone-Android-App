package okhttp3.internal.huc;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Timeout;

abstract class OutputStreamRequestBody extends RequestBody
{
  boolean closed;
  private long expectedContentLength;
  private OutputStream outputStream;
  private Timeout timeout;

  public long contentLength()
    throws IOException
  {
    return this.expectedContentLength;
  }

  public final MediaType contentType()
  {
    return null;
  }

  protected void initOutputStream(BufferedSink paramBufferedSink, long paramLong)
  {
    this.timeout = paramBufferedSink.timeout();
    this.expectedContentLength = paramLong;
    this.outputStream = new OutputStream(paramLong, paramBufferedSink)
    {
      private long bytesReceived;

      public void close()
        throws IOException
      {
        OutputStreamRequestBody.this.closed = true;
        if ((this.val$expectedContentLength != -1L) && (this.bytesReceived < this.val$expectedContentLength))
          throw new ProtocolException("expected " + this.val$expectedContentLength + " bytes but received " + this.bytesReceived);
        this.val$sink.close();
      }

      public void flush()
        throws IOException
      {
        if (OutputStreamRequestBody.this.closed)
          return;
        this.val$sink.flush();
      }

      public void write(int paramInt)
        throws IOException
      {
        write(new byte[] { (byte)paramInt }, 0, 1);
      }

      public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
        throws IOException
      {
        if (OutputStreamRequestBody.this.closed)
          throw new IOException("closed");
        if ((this.val$expectedContentLength != -1L) && (this.bytesReceived + paramInt2 > this.val$expectedContentLength))
          throw new ProtocolException("expected " + this.val$expectedContentLength + " bytes but received " + this.bytesReceived + paramInt2);
        this.bytesReceived += paramInt2;
        try
        {
          this.val$sink.write(paramArrayOfByte, paramInt1, paramInt2);
          return;
        }
        catch (InterruptedIOException paramArrayOfByte)
        {
        }
        throw new SocketTimeoutException(paramArrayOfByte.getMessage());
      }
    };
  }

  public final boolean isClosed()
  {
    return this.closed;
  }

  public final OutputStream outputStream()
  {
    return this.outputStream;
  }

  public Request prepareToSendRequest(Request paramRequest)
    throws IOException
  {
    return paramRequest;
  }

  public final Timeout timeout()
  {
    return this.timeout;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     okhttp3.internal.huc.OutputStreamRequestBody
 * JD-Core Version:    0.6.0
 */
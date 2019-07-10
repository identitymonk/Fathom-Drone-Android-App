package com.facebook.react.modules.network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

public class ProgressRequestBody extends RequestBody
{
  private BufferedSink mBufferedSink;
  private final ProgressListener mProgressListener;
  private final RequestBody mRequestBody;

  public ProgressRequestBody(RequestBody paramRequestBody, ProgressListener paramProgressListener)
  {
    this.mRequestBody = paramRequestBody;
    this.mProgressListener = paramProgressListener;
  }

  private Sink sink(Sink paramSink)
  {
    return new ForwardingSink(paramSink)
    {
      long bytesWritten = 0L;
      long contentLength = 0L;

      public void write(Buffer paramBuffer, long paramLong)
        throws IOException
      {
        super.write(paramBuffer, paramLong);
        if (this.contentLength == 0L)
          this.contentLength = ProgressRequestBody.this.contentLength();
        this.bytesWritten += paramLong;
        paramBuffer = ProgressRequestBody.this.mProgressListener;
        paramLong = this.bytesWritten;
        long l = this.contentLength;
        if (this.bytesWritten == this.contentLength);
        for (boolean bool = true; ; bool = false)
        {
          paramBuffer.onProgress(paramLong, l, bool);
          return;
        }
      }
    };
  }

  public long contentLength()
    throws IOException
  {
    return this.mRequestBody.contentLength();
  }

  public MediaType contentType()
  {
    return this.mRequestBody.contentType();
  }

  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    if (this.mBufferedSink == null)
      this.mBufferedSink = Okio.buffer(sink(paramBufferedSink));
    this.mRequestBody.writeTo(this.mBufferedSink);
    this.mBufferedSink.flush();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.ProgressRequestBody
 * JD-Core Version:    0.6.0
 */
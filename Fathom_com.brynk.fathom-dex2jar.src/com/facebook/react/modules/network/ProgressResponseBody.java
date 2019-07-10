package com.facebook.react.modules.network;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class ProgressResponseBody extends ResponseBody
{

  @Nullable
  private BufferedSource mBufferedSource;
  private final ProgressListener mProgressListener;
  private final ResponseBody mResponseBody;
  private long mTotalBytesRead;

  public ProgressResponseBody(ResponseBody paramResponseBody, ProgressListener paramProgressListener)
  {
    this.mResponseBody = paramResponseBody;
    this.mProgressListener = paramProgressListener;
    this.mTotalBytesRead = 0L;
  }

  private Source source(Source paramSource)
  {
    return new ForwardingSource(paramSource)
    {
      public long read(Buffer paramBuffer, long paramLong)
        throws IOException
      {
        long l1 = super.read(paramBuffer, paramLong);
        paramBuffer = ProgressResponseBody.this;
        long l2 = ProgressResponseBody.this.mTotalBytesRead;
        if (l1 != -1L)
        {
          paramLong = l1;
          ProgressResponseBody.access$002(paramBuffer, paramLong + l2);
          paramBuffer = ProgressResponseBody.this.mProgressListener;
          paramLong = ProgressResponseBody.this.mTotalBytesRead;
          l2 = ProgressResponseBody.this.mResponseBody.contentLength();
          if (l1 != -1L)
            break label102;
        }
        label102: for (boolean bool = true; ; bool = false)
        {
          paramBuffer.onProgress(paramLong, l2, bool);
          return l1;
          paramLong = 0L;
          break;
        }
      }
    };
  }

  public long contentLength()
  {
    return this.mResponseBody.contentLength();
  }

  public MediaType contentType()
  {
    return this.mResponseBody.contentType();
  }

  public BufferedSource source()
  {
    if (this.mBufferedSource == null)
      this.mBufferedSource = Okio.buffer(source(this.mResponseBody.source()));
    return this.mBufferedSource;
  }

  public long totalBytesRead()
  {
    return this.mTotalBytesRead;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.ProgressResponseBody
 * JD-Core Version:    0.6.0
 */
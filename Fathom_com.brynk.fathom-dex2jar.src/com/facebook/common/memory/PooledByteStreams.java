package com.facebook.common.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PooledByteStreams
{
  private static final int DEFAULT_TEMP_BUF_SIZE = 16384;
  private final ByteArrayPool mByteArrayPool;
  private final int mTempBufSize;

  public PooledByteStreams(ByteArrayPool paramByteArrayPool)
  {
    this(paramByteArrayPool, 16384);
  }

  @VisibleForTesting
  public PooledByteStreams(ByteArrayPool paramByteArrayPool, int paramInt)
  {
    if (paramInt > 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.mTempBufSize = paramInt;
      this.mByteArrayPool = paramByteArrayPool;
      return;
    }
  }

  public long copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    long l = 0L;
    byte[] arrayOfByte = (byte[])this.mByteArrayPool.get(this.mTempBufSize);
    try
    {
      while (true)
      {
        int i = paramInputStream.read(arrayOfByte, 0, this.mTempBufSize);
        if (i == -1)
          return l;
        paramOutputStream.write(arrayOfByte, 0, i);
        l += i;
      }
    }
    finally
    {
      this.mByteArrayPool.release(arrayOfByte);
    }
    throw paramInputStream;
  }

  public long copy(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    boolean bool = false;
    if (paramLong > 0L)
      bool = true;
    Preconditions.checkState(bool);
    long l = 0L;
    byte[] arrayOfByte = (byte[])this.mByteArrayPool.get(this.mTempBufSize);
    while (true)
    {
      if (l < paramLong);
      try
      {
        int i = paramInputStream.read(arrayOfByte, 0, (int)Math.min(this.mTempBufSize, paramLong - l));
        if (i == -1)
          return l;
        paramOutputStream.write(arrayOfByte, 0, i);
        l += i;
        continue;
        return l;
      }
      finally
      {
        this.mByteArrayPool.release(arrayOfByte);
      }
    }
    throw paramInputStream;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.memory.PooledByteStreams
 * JD-Core Version:    0.6.0
 */
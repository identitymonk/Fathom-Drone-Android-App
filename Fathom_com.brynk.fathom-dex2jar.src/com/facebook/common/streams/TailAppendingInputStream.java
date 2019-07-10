package com.facebook.common.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TailAppendingInputStream extends FilterInputStream
{
  private int mMarkedTailOffset;
  private final byte[] mTail;
  private int mTailOffset;

  public TailAppendingInputStream(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    super(paramInputStream);
    if (paramInputStream == null)
      throw new NullPointerException();
    if (paramArrayOfByte == null)
      throw new NullPointerException();
    this.mTail = paramArrayOfByte;
  }

  private int readNextTailByte()
  {
    if (this.mTailOffset >= this.mTail.length)
      return -1;
    byte[] arrayOfByte = this.mTail;
    int i = this.mTailOffset;
    this.mTailOffset = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }

  public void mark(int paramInt)
  {
    if (this.in.markSupported())
    {
      super.mark(paramInt);
      this.mMarkedTailOffset = this.mTailOffset;
    }
  }

  public int read()
    throws IOException
  {
    int i = this.in.read();
    if (i != -1)
      return i;
    return readNextTailByte();
  }

  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (i != -1)
      return i;
    if (paramInt2 == 0)
      return 0;
    i = 0;
    int j;
    if (i < paramInt2)
    {
      j = readNextTailByte();
      if (j != -1);
    }
    else
    {
      if (i <= 0)
        break label74;
    }
    while (true)
    {
      return i;
      paramArrayOfByte[(paramInt1 + i)] = (byte)j;
      i += 1;
      break;
      label74: i = -1;
    }
  }

  public void reset()
    throws IOException
  {
    if (this.in.markSupported())
    {
      this.in.reset();
      this.mTailOffset = this.mMarkedTailOffset;
      return;
    }
    throw new IOException("mark is not supported");
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.streams.TailAppendingInputStream
 * JD-Core Version:    0.6.0
 */
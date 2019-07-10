package com.facebook.common.internal;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CountingOutputStream extends FilterOutputStream
{
  private long mCount = 0L;

  public CountingOutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public void close()
    throws IOException
  {
    this.out.close();
  }

  public long getCount()
  {
    return this.mCount;
  }

  public void write(int paramInt)
    throws IOException
  {
    this.out.write(paramInt);
    this.mCount += 1L;
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.mCount += paramInt2;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.internal.CountingOutputStream
 * JD-Core Version:    0.6.0
 */
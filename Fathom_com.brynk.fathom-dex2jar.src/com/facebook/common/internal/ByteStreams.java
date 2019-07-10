package com.facebook.common.internal;

import B;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public final class ByteStreams
{
  private static final int BUF_SIZE = 4096;

  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramOutputStream);
    byte[] arrayOfByte = new byte[4096];
    long l = 0L;
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        return l;
      paramOutputStream.write(arrayOfByte, 0, i);
      l += i;
    }
  }

  public static int read(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramArrayOfByte);
    if (paramInt2 < 0)
      throw new IndexOutOfBoundsException("len is negative");
    int i = 0;
    while (true)
    {
      int j;
      if (i < paramInt2)
      {
        j = paramInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
        if (j != -1);
      }
      else
      {
        return i;
      }
      i += j;
    }
  }

  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = read(paramInputStream, paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != paramInt2)
      throw new EOFException("reached end of stream after reading " + paramInt1 + " bytes; " + paramInt2 + " bytes expected");
  }

  public static byte[] toByteArray(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }

  public static byte[] toByteArray(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = paramInt;
    int k;
    if (i > 0)
    {
      int j = paramInt - i;
      k = paramInputStream.read(arrayOfByte, j, i);
      if (k == -1)
        localObject = Arrays.copyOf(arrayOfByte, j);
    }
    do
    {
      return localObject;
      i -= k;
      break;
      paramInt = paramInputStream.read();
      localObject = arrayOfByte;
    }
    while (paramInt == -1);
    Object localObject = new FastByteArrayOutputStream(null);
    ((FastByteArrayOutputStream)localObject).write(paramInt);
    copy(paramInputStream, (OutputStream)localObject);
    paramInputStream = new byte[arrayOfByte.length + ((FastByteArrayOutputStream)localObject).size()];
    System.arraycopy(arrayOfByte, 0, paramInputStream, 0, arrayOfByte.length);
    ((FastByteArrayOutputStream)localObject).writeTo(paramInputStream, arrayOfByte.length);
    return (B)paramInputStream;
  }

  private static final class FastByteArrayOutputStream extends ByteArrayOutputStream
  {
    void writeTo(byte[] paramArrayOfByte, int paramInt)
    {
      System.arraycopy(this.buf, 0, paramArrayOfByte, paramInt, this.count);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.internal.ByteStreams
 * JD-Core Version:    0.6.0
 */
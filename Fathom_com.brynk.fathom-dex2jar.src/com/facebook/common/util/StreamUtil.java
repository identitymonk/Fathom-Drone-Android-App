package com.facebook.common.util;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtil
{
  public static byte[] getBytesFromStream(InputStream paramInputStream)
    throws IOException
  {
    return getBytesFromStream(paramInputStream, paramInputStream.available());
  }

  public static byte[] getBytesFromStream(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    1 local1 = new ByteArrayOutputStream(paramInt)
    {
      public byte[] toByteArray()
      {
        if (this.count == this.buf.length)
          return this.buf;
        return super.toByteArray();
      }
    };
    ByteStreams.copy(paramInputStream, local1);
    return local1.toByteArray();
  }

  public static long skip(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    boolean bool;
    long l1;
    if (paramLong >= 0L)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      l1 = paramLong;
    }
    while (true)
    {
      l2 = paramLong;
      if (l1 <= 0L)
        break label78;
      l2 = paramInputStream.skip(l1);
      if (l2 > 0L)
      {
        l1 -= l2;
        continue;
        bool = false;
        break;
      }
      if (paramInputStream.read() == -1)
        break label73;
      l1 -= 1L;
    }
    label73: long l2 = paramLong - l1;
    label78: return l2;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.StreamUtil
 * JD-Core Version:    0.6.0
 */
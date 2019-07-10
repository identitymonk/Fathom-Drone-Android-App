package com.facebook.cache.common;

import com.facebook.common.internal.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WriterCallbacks
{
  public static WriterCallback from(InputStream paramInputStream)
  {
    return new WriterCallback(paramInputStream)
    {
      public void write(OutputStream paramOutputStream)
        throws IOException
      {
        ByteStreams.copy(this.val$is, paramOutputStream);
      }
    };
  }

  public static WriterCallback from(byte[] paramArrayOfByte)
  {
    return new WriterCallback(paramArrayOfByte)
    {
      public void write(OutputStream paramOutputStream)
        throws IOException
      {
        paramOutputStream.write(this.val$data);
      }
    };
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.WriterCallbacks
 * JD-Core Version:    0.6.0
 */
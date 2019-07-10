package com.facebook.common.memory;

import com.facebook.common.internal.Throwables;
import java.io.IOException;
import java.io.OutputStream;

public abstract class PooledByteBufferOutputStream extends OutputStream
{
  public void close()
  {
    try
    {
      super.close();
      return;
    }
    catch (IOException localIOException)
    {
      Throwables.propagate(localIOException);
    }
  }

  public abstract int size();

  public abstract PooledByteBuffer toByteBuffer();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.memory.PooledByteBufferOutputStream
 * JD-Core Version:    0.6.0
 */
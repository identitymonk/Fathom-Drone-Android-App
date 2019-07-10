package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;

class StreamProcessor
{
  public static int readPackedInt(InputStream paramInputStream, int paramInt, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (j < paramInt)
    {
      int k = paramInputStream.read();
      if (k == -1)
        throw new IOException("no more bytes");
      if (paramBoolean)
        i |= (k & 0xFF) << j * 8;
      while (true)
      {
        j += 1;
        break;
        i = i << 8 | k & 0xFF;
      }
    }
    return i;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imageutils.StreamProcessor
 * JD-Core Version:    0.6.0
 */
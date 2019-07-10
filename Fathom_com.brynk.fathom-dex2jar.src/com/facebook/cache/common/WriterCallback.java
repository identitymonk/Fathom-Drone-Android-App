package com.facebook.cache.common;

import java.io.IOException;
import java.io.OutputStream;

public abstract interface WriterCallback
{
  public abstract void write(OutputStream paramOutputStream)
    throws IOException;
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.cache.common.WriterCallback
 * JD-Core Version:    0.6.0
 */
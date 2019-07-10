package com.facebook.binaryresource;

import java.io.IOException;
import java.io.InputStream;

public abstract interface BinaryResource
{
  public abstract InputStream openStream()
    throws IOException;

  public abstract byte[] read()
    throws IOException;

  public abstract long size();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.binaryresource.BinaryResource
 * JD-Core Version:    0.6.0
 */
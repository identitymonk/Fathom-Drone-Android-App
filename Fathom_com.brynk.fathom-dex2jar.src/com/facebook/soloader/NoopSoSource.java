package com.facebook.soloader;

import java.io.File;

public class NoopSoSource extends SoSource
{
  public int loadLibrary(String paramString, int paramInt)
  {
    return 1;
  }

  public File unpackLibrary(String paramString)
  {
    throw new UnsupportedOperationException("unpacking not supported in test mode");
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.soloader.NoopSoSource
 * JD-Core Version:    0.6.0
 */
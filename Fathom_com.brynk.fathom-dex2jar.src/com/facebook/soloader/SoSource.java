package com.facebook.soloader;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public abstract class SoSource
{
  public static final int LOAD_FLAG_ALLOW_IMPLICIT_PROVISION = 1;
  public static final int LOAD_RESULT_IMPLICITLY_PROVIDED = 2;
  public static final int LOAD_RESULT_LOADED = 1;
  public static final int LOAD_RESULT_NOT_FOUND = 0;
  public static final int PREPARE_FLAG_ALLOW_ASYNC_INIT = 1;

  public void addToLdLibraryPath(Collection<String> paramCollection)
  {
  }

  public abstract int loadLibrary(String paramString, int paramInt)
    throws IOException;

  protected void prepare(int paramInt)
    throws IOException
  {
  }

  public abstract File unpackLibrary(String paramString)
    throws IOException;
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.soloader.SoSource
 * JD-Core Version:    0.6.0
 */
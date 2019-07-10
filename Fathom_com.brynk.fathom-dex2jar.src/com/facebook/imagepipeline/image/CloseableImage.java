package com.facebook.imagepipeline.image;

import com.facebook.common.logging.FLog;
import java.io.Closeable;

public abstract class CloseableImage
  implements Closeable, ImageInfo
{
  private static final String TAG = "CloseableImage";

  public abstract void close();

  protected void finalize()
    throws Throwable
  {
    if (isClosed())
      return;
    FLog.w("CloseableImage", "finalize: %s %x still open.", new Object[] { getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)) });
    try
    {
      close();
      return;
    }
    finally
    {
      super.finalize();
    }
    throw localObject;
  }

  public QualityInfo getQualityInfo()
  {
    return ImmutableQualityInfo.FULL_QUALITY;
  }

  public abstract int getSizeInBytes();

  public abstract boolean isClosed();

  public boolean isStateful()
  {
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.image.CloseableImage
 * JD-Core Version:    0.6.0
 */
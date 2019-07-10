package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class ImageFormatChecker
{
  private static ImageFormatChecker sInstance;

  @Nullable
  private List<ImageFormat.FormatChecker> mCustomImageFormatCheckers;
  private final ImageFormat.FormatChecker mDefaultFormatChecker = new DefaultImageFormatChecker();
  private int mMaxHeaderLength;

  private ImageFormatChecker()
  {
    updateMaxHeaderLength();
  }

  public static ImageFormat getImageFormat(InputStream paramInputStream)
    throws IOException
  {
    return getInstance().determineImageFormat(paramInputStream);
  }

  // ERROR //
  public static ImageFormat getImageFormat(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: new 42	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 45	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_0
    //   13: aload_0
    //   14: invokestatic 47	com/facebook/imageformat/ImageFormatChecker:getImageFormat	(Ljava/io/InputStream;)Lcom/facebook/imageformat/ImageFormat;
    //   17: astore_1
    //   18: aload_0
    //   19: invokestatic 53	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   22: aload_1
    //   23: areturn
    //   24: astore_0
    //   25: aload_2
    //   26: astore_0
    //   27: aload_0
    //   28: astore_1
    //   29: getstatic 59	com/facebook/imageformat/ImageFormat:UNKNOWN	Lcom/facebook/imageformat/ImageFormat;
    //   32: astore_2
    //   33: aload_0
    //   34: invokestatic 53	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   37: aload_2
    //   38: areturn
    //   39: astore_0
    //   40: aload_1
    //   41: invokestatic 53	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   44: aload_0
    //   45: athrow
    //   46: astore_2
    //   47: aload_0
    //   48: astore_1
    //   49: aload_2
    //   50: astore_0
    //   51: goto -11 -> 40
    //   54: astore_1
    //   55: goto -28 -> 27
    //
    // Exception table:
    //   from	to	target	type
    //   4	13	24	java/io/IOException
    //   4	13	39	finally
    //   29	33	39	finally
    //   13	18	46	finally
    //   13	18	54	java/io/IOException
  }

  public static ImageFormat getImageFormat_WrapIOException(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = getImageFormat(paramInputStream);
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
    }
    throw Throwables.propagate(paramInputStream);
  }

  public static ImageFormatChecker getInstance()
  {
    monitorenter;
    try
    {
      if (sInstance == null)
        sInstance = new ImageFormatChecker();
      ImageFormatChecker localImageFormatChecker = sInstance;
      return localImageFormatChecker;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private static int readHeaderFromStream(int paramInt, InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramArrayOfByte);
    boolean bool;
    if (paramArrayOfByte.length >= paramInt)
      bool = true;
    while (true)
    {
      Preconditions.checkArgument(bool);
      if (!paramInputStream.markSupported())
        break;
      try
      {
        paramInputStream.mark(paramInt);
        paramInt = ByteStreams.read(paramInputStream, paramArrayOfByte, 0, paramInt);
        return paramInt;
        bool = false;
      }
      finally
      {
        paramInputStream.reset();
      }
    }
    return ByteStreams.read(paramInputStream, paramArrayOfByte, 0, paramInt);
  }

  private void updateMaxHeaderLength()
  {
    this.mMaxHeaderLength = this.mDefaultFormatChecker.getHeaderSize();
    if (this.mCustomImageFormatCheckers != null)
    {
      Iterator localIterator = this.mCustomImageFormatCheckers.iterator();
      while (localIterator.hasNext())
      {
        ImageFormat.FormatChecker localFormatChecker = (ImageFormat.FormatChecker)localIterator.next();
        this.mMaxHeaderLength = Math.max(this.mMaxHeaderLength, localFormatChecker.getHeaderSize());
      }
    }
  }

  public ImageFormat determineImageFormat(InputStream paramInputStream)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    Object localObject = new byte[this.mMaxHeaderLength];
    int i = readHeaderFromStream(this.mMaxHeaderLength, paramInputStream, localObject);
    if (this.mCustomImageFormatCheckers != null)
    {
      Iterator localIterator = this.mCustomImageFormatCheckers.iterator();
      do
      {
        if (!localIterator.hasNext())
          break;
        paramInputStream = ((ImageFormat.FormatChecker)localIterator.next()).determineFormat(localObject, i);
      }
      while ((paramInputStream == null) || (paramInputStream == ImageFormat.UNKNOWN));
    }
    do
    {
      return paramInputStream;
      localObject = this.mDefaultFormatChecker.determineFormat(localObject, i);
      paramInputStream = (InputStream)localObject;
    }
    while (localObject != null);
    return (ImageFormat)ImageFormat.UNKNOWN;
  }

  public void setCustomImageFormatCheckers(@Nullable List<ImageFormat.FormatChecker> paramList)
  {
    this.mCustomImageFormatCheckers = paramList;
    updateMaxHeaderLength();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imageformat.ImageFormatChecker
 * JD-Core Version:    0.6.0
 */
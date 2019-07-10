package com.facebook.imagepipeline.image;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.WebpUtil;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class EncodedImage
  implements Closeable
{
  public static final int DEFAULT_SAMPLE_SIZE = 1;
  public static final int UNKNOWN_HEIGHT = -1;
  public static final int UNKNOWN_ROTATION_ANGLE = -1;
  public static final int UNKNOWN_STREAM_SIZE = -1;
  public static final int UNKNOWN_WIDTH = -1;

  @Nullable
  private CacheKey mEncodedCacheKey;
  private int mHeight = -1;
  private ImageFormat mImageFormat = ImageFormat.UNKNOWN;

  @Nullable
  private final Supplier<FileInputStream> mInputStreamSupplier;

  @Nullable
  private final CloseableReference<PooledByteBuffer> mPooledByteBufferRef;
  private int mRotationAngle = -1;
  private int mSampleSize = 1;
  private int mStreamSize = -1;
  private int mWidth = -1;

  public EncodedImage(Supplier<FileInputStream> paramSupplier)
  {
    Preconditions.checkNotNull(paramSupplier);
    this.mPooledByteBufferRef = null;
    this.mInputStreamSupplier = paramSupplier;
  }

  public EncodedImage(Supplier<FileInputStream> paramSupplier, int paramInt)
  {
    this(paramSupplier);
    this.mStreamSize = paramInt;
  }

  public EncodedImage(CloseableReference<PooledByteBuffer> paramCloseableReference)
  {
    Preconditions.checkArgument(CloseableReference.isValid(paramCloseableReference));
    this.mPooledByteBufferRef = paramCloseableReference.clone();
    this.mInputStreamSupplier = null;
  }

  public static EncodedImage cloneOrNull(EncodedImage paramEncodedImage)
  {
    if (paramEncodedImage != null)
      return paramEncodedImage.cloneOrNull();
    return null;
  }

  public static void closeSafely(@Nullable EncodedImage paramEncodedImage)
  {
    if (paramEncodedImage != null)
      paramEncodedImage.close();
  }

  public static boolean isMetaDataAvailable(EncodedImage paramEncodedImage)
  {
    return (paramEncodedImage.mRotationAngle >= 0) && (paramEncodedImage.mWidth >= 0) && (paramEncodedImage.mHeight >= 0);
  }

  public static boolean isValid(@Nullable EncodedImage paramEncodedImage)
  {
    return (paramEncodedImage != null) && (paramEncodedImage.isValid());
  }

  // ERROR //
  private Pair<Integer, Integer> readImageSize()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokevirtual 110	com/facebook/imagepipeline/image/EncodedImage:getInputStream	()Ljava/io/InputStream;
    //   6: astore_2
    //   7: aload_2
    //   8: astore_1
    //   9: aload_2
    //   10: invokestatic 116	com/facebook/imageutils/BitmapUtil:decodeDimensions	(Ljava/io/InputStream;)Landroid/util/Pair;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull +35 -> 50
    //   18: aload_2
    //   19: astore_1
    //   20: aload_0
    //   21: aload_3
    //   22: getfield 122	android/util/Pair:first	Ljava/lang/Object;
    //   25: checkcast 124	java/lang/Integer
    //   28: invokevirtual 128	java/lang/Integer:intValue	()I
    //   31: putfield 47	com/facebook/imagepipeline/image/EncodedImage:mWidth	I
    //   34: aload_2
    //   35: astore_1
    //   36: aload_0
    //   37: aload_3
    //   38: getfield 131	android/util/Pair:second	Ljava/lang/Object;
    //   41: checkcast 124	java/lang/Integer
    //   44: invokevirtual 128	java/lang/Integer:intValue	()I
    //   47: putfield 49	com/facebook/imagepipeline/image/EncodedImage:mHeight	I
    //   50: aload_2
    //   51: ifnull +7 -> 58
    //   54: aload_2
    //   55: invokevirtual 134	java/io/InputStream:close	()V
    //   58: aload_3
    //   59: areturn
    //   60: astore_2
    //   61: aload_1
    //   62: ifnull +7 -> 69
    //   65: aload_1
    //   66: invokevirtual 134	java/io/InputStream:close	()V
    //   69: aload_2
    //   70: athrow
    //   71: astore_1
    //   72: aload_3
    //   73: areturn
    //   74: astore_1
    //   75: goto -6 -> 69
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	60	finally
    //   9	14	60	finally
    //   20	34	60	finally
    //   36	50	60	finally
    //   54	58	71	java/io/IOException
    //   65	69	74	java/io/IOException
  }

  private Pair<Integer, Integer> readWebPImageSize()
  {
    Pair localPair = WebpUtil.getSize(getInputStream());
    if (localPair != null)
    {
      this.mWidth = ((Integer)localPair.first).intValue();
      this.mHeight = ((Integer)localPair.second).intValue();
    }
    return localPair;
  }

  public EncodedImage cloneOrNull()
  {
    EncodedImage localEncodedImage;
    if (this.mInputStreamSupplier != null)
    {
      localEncodedImage = new EncodedImage(this.mInputStreamSupplier, this.mStreamSize);
      if (localEncodedImage != null)
        localEncodedImage.copyMetaDataFrom(this);
      return localEncodedImage;
    }
    CloseableReference localCloseableReference = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
    if (localCloseableReference == null)
      localEncodedImage = null;
    while (true)
    {
      CloseableReference.closeSafely(localCloseableReference);
      break;
      try
      {
        localEncodedImage = new EncodedImage(localCloseableReference);
      }
      finally
      {
        CloseableReference.closeSafely(localCloseableReference);
      }
    }
  }

  public void close()
  {
    CloseableReference.closeSafely(this.mPooledByteBufferRef);
  }

  public void copyMetaDataFrom(EncodedImage paramEncodedImage)
  {
    this.mImageFormat = paramEncodedImage.getImageFormat();
    this.mWidth = paramEncodedImage.getWidth();
    this.mHeight = paramEncodedImage.getHeight();
    this.mRotationAngle = paramEncodedImage.getRotationAngle();
    this.mSampleSize = paramEncodedImage.getSampleSize();
    this.mStreamSize = paramEncodedImage.getSize();
    this.mEncodedCacheKey = paramEncodedImage.getEncodedCacheKey();
  }

  public CloseableReference<PooledByteBuffer> getByteBufferRef()
  {
    return CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
  }

  @Nullable
  public CacheKey getEncodedCacheKey()
  {
    return this.mEncodedCacheKey;
  }

  public int getHeight()
  {
    return this.mHeight;
  }

  public ImageFormat getImageFormat()
  {
    return this.mImageFormat;
  }

  public InputStream getInputStream()
  {
    if (this.mInputStreamSupplier != null)
      return (InputStream)this.mInputStreamSupplier.get();
    CloseableReference localCloseableReference = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
    if (localCloseableReference != null)
      try
      {
        PooledByteBufferInputStream localPooledByteBufferInputStream = new PooledByteBufferInputStream((PooledByteBuffer)localCloseableReference.get());
        return localPooledByteBufferInputStream;
      }
      finally
      {
        CloseableReference.closeSafely(localCloseableReference);
      }
    return null;
  }

  public int getRotationAngle()
  {
    return this.mRotationAngle;
  }

  public int getSampleSize()
  {
    return this.mSampleSize;
  }

  public int getSize()
  {
    if ((this.mPooledByteBufferRef != null) && (this.mPooledByteBufferRef.get() != null))
      return ((PooledByteBuffer)this.mPooledByteBufferRef.get()).size();
    return this.mStreamSize;
  }

  @VisibleForTesting
  public SharedReference<PooledByteBuffer> getUnderlyingReferenceTestOnly()
  {
    monitorenter;
    try
    {
      if (this.mPooledByteBufferRef != null)
      {
        localSharedReference = this.mPooledByteBufferRef.getUnderlyingReferenceTestOnly();
        return localSharedReference;
      }
      SharedReference localSharedReference = null;
    }
    finally
    {
      monitorexit;
    }
  }

  public int getWidth()
  {
    return this.mWidth;
  }

  public boolean isCompleteAt(int paramInt)
  {
    if (this.mImageFormat != DefaultImageFormats.JPEG);
    PooledByteBuffer localPooledByteBuffer;
    do
    {
      do
        return true;
      while (this.mInputStreamSupplier != null);
      Preconditions.checkNotNull(this.mPooledByteBufferRef);
      localPooledByteBuffer = (PooledByteBuffer)this.mPooledByteBufferRef.get();
    }
    while ((localPooledByteBuffer.read(paramInt - 2) == -1) && (localPooledByteBuffer.read(paramInt - 1) == -39));
    return false;
  }

  public boolean isValid()
  {
    monitorenter;
    try
    {
      if (!CloseableReference.isValid(this.mPooledByteBufferRef))
      {
        Supplier localSupplier = this.mInputStreamSupplier;
        if (localSupplier == null);
      }
      else
      {
        i = 1;
        return i;
      }
      int i = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  public void parseMetaData()
  {
    ImageFormat localImageFormat = ImageFormatChecker.getImageFormat_WrapIOException(getInputStream());
    this.mImageFormat = localImageFormat;
    if (DefaultImageFormats.isWebpFormat(localImageFormat));
    for (Pair localPair = readWebPImageSize(); (localImageFormat == DefaultImageFormats.JPEG) && (this.mRotationAngle == -1); localPair = readImageSize())
    {
      if (localPair != null)
        this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(JfifUtil.getOrientation(getInputStream()));
      return;
    }
    this.mRotationAngle = 0;
  }

  public void setEncodedCacheKey(@Nullable CacheKey paramCacheKey)
  {
    this.mEncodedCacheKey = paramCacheKey;
  }

  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }

  public void setImageFormat(ImageFormat paramImageFormat)
  {
    this.mImageFormat = paramImageFormat;
  }

  public void setRotationAngle(int paramInt)
  {
    this.mRotationAngle = paramInt;
  }

  public void setSampleSize(int paramInt)
  {
    this.mSampleSize = paramInt;
  }

  public void setStreamSize(int paramInt)
  {
    this.mStreamSize = paramInt;
  }

  public void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.image.EncodedImage
 * JD-Core Version:    0.6.0
 */
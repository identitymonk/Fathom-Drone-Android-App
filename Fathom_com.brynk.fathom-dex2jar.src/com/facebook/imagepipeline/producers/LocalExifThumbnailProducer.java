package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Pair;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.JfifUtil;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;

public class LocalExifThumbnailProducer
  implements ThumbnailProducer<EncodedImage>
{
  private static final int COMMON_EXIF_THUMBNAIL_MAX_DIMENSION = 512;

  @VisibleForTesting
  static final String CREATED_THUMBNAIL = "createdThumbnail";
  public static final String PRODUCER_NAME = "LocalExifThumbnailProducer";
  private final ContentResolver mContentResolver;
  private final Executor mExecutor;
  private final PooledByteBufferFactory mPooledByteBufferFactory;

  public LocalExifThumbnailProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, ContentResolver paramContentResolver)
  {
    this.mExecutor = paramExecutor;
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    this.mContentResolver = paramContentResolver;
  }

  private EncodedImage buildEncodedImage(PooledByteBuffer paramPooledByteBuffer, ExifInterface paramExifInterface)
  {
    int j = -1;
    Pair localPair = BitmapUtil.decodeDimensions(new PooledByteBufferInputStream(paramPooledByteBuffer));
    int k = getRotationAngle(paramExifInterface);
    int i;
    if (localPair != null)
      i = ((Integer)localPair.first).intValue();
    while (true)
    {
      if (localPair != null)
        j = ((Integer)localPair.second).intValue();
      paramPooledByteBuffer = CloseableReference.of(paramPooledByteBuffer);
      try
      {
        paramExifInterface = new EncodedImage(paramPooledByteBuffer);
        CloseableReference.closeSafely(paramPooledByteBuffer);
        paramExifInterface.setImageFormat(DefaultImageFormats.JPEG);
        paramExifInterface.setRotationAngle(k);
        paramExifInterface.setWidth(i);
        return paramExifInterface;
        i = -1;
      }
      finally
      {
        CloseableReference.closeSafely(paramPooledByteBuffer);
      }
    }
  }

  private int getRotationAngle(ExifInterface paramExifInterface)
  {
    return JfifUtil.getAutoRotateAngleFromOrientation(Integer.parseInt(paramExifInterface.getAttribute("Orientation")));
  }

  public boolean canProvideImageForSize(ResizeOptions paramResizeOptions)
  {
    return ThumbnailSizeChecker.isImageBigEnough(512, 512, paramResizeOptions);
  }

  @VisibleForTesting
  boolean canReadAsFile(String paramString)
    throws IOException
  {
    if (paramString == null);
    do
    {
      return false;
      paramString = new File(paramString);
    }
    while ((!paramString.exists()) || (!paramString.canRead()));
    return true;
  }

  @VisibleForTesting
  ExifInterface getExifInterface(Uri paramUri)
    throws IOException
  {
    paramUri = UriUtil.getRealPathFromUri(this.mContentResolver, paramUri);
    if (canReadAsFile(paramUri))
      return new ExifInterface(paramUri);
    return null;
  }

  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    paramConsumer = new StatefulProducerRunnable(paramConsumer, paramProducerContext.getListener(), "LocalExifThumbnailProducer", paramProducerContext.getId(), paramProducerContext.getImageRequest())
    {
      protected void disposeResult(EncodedImage paramEncodedImage)
      {
        EncodedImage.closeSafely(paramEncodedImage);
      }

      protected Map<String, String> getExtraMapOnSuccess(EncodedImage paramEncodedImage)
      {
        if (paramEncodedImage != null);
        for (boolean bool = true; ; bool = false)
          return ImmutableMap.of("createdThumbnail", Boolean.toString(bool));
      }

      protected EncodedImage getResult()
        throws Exception
      {
        Object localObject1 = this.val$imageRequest.getSourceUri();
        localObject1 = LocalExifThumbnailProducer.this.getExifInterface((Uri)localObject1);
        if ((localObject1 == null) || (!((ExifInterface)localObject1).hasThumbnail()))
          return null;
        Object localObject2 = ((ExifInterface)localObject1).getThumbnail();
        localObject2 = LocalExifThumbnailProducer.this.mPooledByteBufferFactory.newByteBuffer(localObject2);
        return (EncodedImage)(EncodedImage)LocalExifThumbnailProducer.this.buildEncodedImage((PooledByteBuffer)localObject2, (ExifInterface)localObject1);
      }
    };
    paramProducerContext.addCallbacks(new BaseProducerContextCallbacks(paramConsumer)
    {
      public void onCancellationRequested()
      {
        this.val$cancellableProducerRunnable.cancel();
      }
    });
    this.mExecutor.execute(paramConsumer);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.LocalExifThumbnailProducer
 * JD-Core Version:    0.6.0
 */
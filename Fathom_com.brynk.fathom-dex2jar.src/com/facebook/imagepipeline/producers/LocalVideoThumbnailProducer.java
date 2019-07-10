package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;

public class LocalVideoThumbnailProducer
  implements Producer<CloseableReference<CloseableImage>>
{

  @VisibleForTesting
  static final String CREATED_THUMBNAIL = "createdThumbnail";
  public static final String PRODUCER_NAME = "VideoThumbnailProducer";
  private final Executor mExecutor;

  public LocalVideoThumbnailProducer(Executor paramExecutor)
  {
    this.mExecutor = paramExecutor;
  }

  private static int calculateKind(ImageRequest paramImageRequest)
  {
    if ((paramImageRequest.getPreferredWidth() > 96) || (paramImageRequest.getPreferredHeight() > 96))
      return 1;
    return 3;
  }

  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    ProducerListener localProducerListener = paramProducerContext.getListener();
    String str = paramProducerContext.getId();
    paramConsumer = new StatefulProducerRunnable(paramConsumer, localProducerListener, "VideoThumbnailProducer", str, localProducerListener, str, paramProducerContext.getImageRequest())
    {
      protected void disposeResult(CloseableReference<CloseableImage> paramCloseableReference)
      {
        CloseableReference.closeSafely(paramCloseableReference);
      }

      protected Map<String, String> getExtraMapOnSuccess(CloseableReference<CloseableImage> paramCloseableReference)
      {
        if (paramCloseableReference != null);
        for (boolean bool = true; ; bool = false)
          return ImmutableMap.of("createdThumbnail", String.valueOf(bool));
      }

      protected CloseableReference<CloseableImage> getResult()
        throws Exception
      {
        Bitmap localBitmap = ThumbnailUtils.createVideoThumbnail(this.val$imageRequest.getSourceFile().getPath(), LocalVideoThumbnailProducer.access$000(this.val$imageRequest));
        if (localBitmap == null)
          return null;
        return CloseableReference.of(new CloseableStaticBitmap(localBitmap, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0));
      }

      protected void onFailure(Exception paramException)
      {
        super.onFailure(paramException);
        this.val$listener.onUltimateProducerReached(this.val$requestId, "VideoThumbnailProducer", false);
      }

      protected void onSuccess(CloseableReference<CloseableImage> paramCloseableReference)
      {
        super.onSuccess(paramCloseableReference);
        ProducerListener localProducerListener = this.val$listener;
        String str = this.val$requestId;
        if (paramCloseableReference != null);
        for (boolean bool = true; ; bool = false)
        {
          localProducerListener.onUltimateProducerReached(str, "VideoThumbnailProducer", bool);
          return;
        }
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
 * Qualified Name:     com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer
 * JD-Core Version:    0.6.0
 */
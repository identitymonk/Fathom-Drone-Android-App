package com.facebook.imagepipeline.producers;

import bolts.Continuation;
import bolts.Task;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.DiskCachePolicy;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

public class DiskCacheReadProducer
  implements Producer<EncodedImage>
{
  public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
  public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
  public static final String PRODUCER_NAME = "DiskCacheProducer";
  private final DiskCachePolicy mDiskCachePolicy;
  private final Producer<EncodedImage> mInputProducer;

  public DiskCacheReadProducer(Producer<EncodedImage> paramProducer, DiskCachePolicy paramDiskCachePolicy)
  {
    this.mInputProducer = paramProducer;
    this.mDiskCachePolicy = paramDiskCachePolicy;
  }

  @VisibleForTesting
  static Map<String, String> getExtraMap(ProducerListener paramProducerListener, String paramString, boolean paramBoolean, int paramInt)
  {
    if (!paramProducerListener.requiresExtraMap(paramString))
      return null;
    if (paramBoolean)
      return ImmutableMap.of("cached_value_found", String.valueOf(paramBoolean), "encodedImageSize", String.valueOf(paramInt));
    return ImmutableMap.of("cached_value_found", String.valueOf(paramBoolean));
  }

  private static boolean isTaskCancelled(Task<?> paramTask)
  {
    return (paramTask.isCancelled()) || ((paramTask.isFaulted()) && ((paramTask.getError() instanceof CancellationException)));
  }

  private void maybeStartInputProducer(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    if (paramProducerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue())
    {
      paramConsumer.onNewResult(null, true);
      return;
    }
    this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
  }

  private Continuation<EncodedImage, Void> onFinishDiskReads(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    String str = paramProducerContext.getId();
    return new Continuation(paramProducerContext.getListener(), str, paramConsumer, paramProducerContext)
    {
      public Void then(Task<EncodedImage> paramTask)
        throws Exception
      {
        if (DiskCacheReadProducer.access$000(paramTask))
        {
          this.val$listener.onProducerFinishWithCancellation(this.val$requestId, "DiskCacheProducer", null);
          this.val$consumer.onCancellation();
          return null;
        }
        if (paramTask.isFaulted())
        {
          this.val$listener.onProducerFinishWithFailure(this.val$requestId, "DiskCacheProducer", paramTask.getError(), null);
          DiskCacheReadProducer.this.mInputProducer.produceResults(this.val$consumer, this.val$producerContext);
          return null;
        }
        paramTask = (EncodedImage)paramTask.getResult();
        if (paramTask != null)
        {
          this.val$listener.onProducerFinishWithSuccess(this.val$requestId, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(this.val$listener, this.val$requestId, true, paramTask.getSize()));
          this.val$listener.onUltimateProducerReached(this.val$requestId, "DiskCacheProducer", true);
          this.val$consumer.onProgressUpdate(1.0F);
          this.val$consumer.onNewResult(paramTask, true);
          paramTask.close();
          return null;
        }
        this.val$listener.onProducerFinishWithSuccess(this.val$requestId, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(this.val$listener, this.val$requestId, false, 0));
        DiskCacheReadProducer.this.mInputProducer.produceResults(this.val$consumer, this.val$producerContext);
        return null;
      }
    };
  }

  private void subscribeTaskForRequestCancellation(AtomicBoolean paramAtomicBoolean, ProducerContext paramProducerContext)
  {
    paramProducerContext.addCallbacks(new BaseProducerContextCallbacks(paramAtomicBoolean)
    {
      public void onCancellationRequested()
      {
        this.val$isCancelled.set(true);
      }
    });
  }

  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    ImageRequest localImageRequest = paramProducerContext.getImageRequest();
    if (!localImageRequest.isDiskCacheEnabled())
    {
      maybeStartInputProducer(paramConsumer, paramProducerContext);
      return;
    }
    paramProducerContext.getListener().onProducerStart(paramProducerContext.getId(), "DiskCacheProducer");
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    this.mDiskCachePolicy.createAndStartCacheReadTask(localImageRequest, paramProducerContext.getCallerContext(), localAtomicBoolean).continueWith(onFinishDiskReads(paramConsumer, paramProducerContext));
    subscribeTaskForRequestCancellation(localAtomicBoolean, paramProducerContext);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.DiskCacheReadProducer
 * JD-Core Version:    0.6.0
 */
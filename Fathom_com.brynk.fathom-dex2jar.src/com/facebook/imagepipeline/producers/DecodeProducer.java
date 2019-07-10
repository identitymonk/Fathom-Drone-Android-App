package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class DecodeProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
  public static final String EXTRA_BITMAP_SIZE = "bitmapSize";
  public static final String EXTRA_HAS_GOOD_QUALITY = "hasGoodQuality";
  public static final String EXTRA_IMAGE_FORMAT_NAME = "imageFormat";
  public static final String EXTRA_IS_FINAL = "isFinal";
  public static final String PRODUCER_NAME = "DecodeProducer";
  public static final String REQUESTED_IMAGE_SIZE = "requestedImageSize";
  public static final String SAMPLE_SIZE = "sampleSize";
  private final ByteArrayPool mByteArrayPool;
  private final boolean mDecodeCancellationEnabled;
  private final boolean mDownsampleEnabled;
  private final boolean mDownsampleEnabledForNetwork;
  private final Executor mExecutor;
  private final ImageDecoder mImageDecoder;
  private final Producer<EncodedImage> mInputProducer;
  private final ProgressiveJpegConfig mProgressiveJpegConfig;

  public DecodeProducer(ByteArrayPool paramByteArrayPool, Executor paramExecutor, ImageDecoder paramImageDecoder, ProgressiveJpegConfig paramProgressiveJpegConfig, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Producer<EncodedImage> paramProducer)
  {
    this.mByteArrayPool = ((ByteArrayPool)Preconditions.checkNotNull(paramByteArrayPool));
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mImageDecoder = ((ImageDecoder)Preconditions.checkNotNull(paramImageDecoder));
    this.mProgressiveJpegConfig = ((ProgressiveJpegConfig)Preconditions.checkNotNull(paramProgressiveJpegConfig));
    this.mDownsampleEnabled = paramBoolean1;
    this.mDownsampleEnabledForNetwork = paramBoolean2;
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mDecodeCancellationEnabled = paramBoolean3;
  }

  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    if (!UriUtil.isNetworkUri(paramProducerContext.getImageRequest().getSourceUri()));
    for (paramConsumer = new LocalImagesProgressiveDecoder(paramConsumer, paramProducerContext, this.mDecodeCancellationEnabled); ; paramConsumer = new NetworkImagesProgressiveDecoder(paramConsumer, paramProducerContext, new ProgressiveJpegParser(this.mByteArrayPool), this.mProgressiveJpegConfig, this.mDecodeCancellationEnabled))
    {
      this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
      return;
    }
  }

  private class LocalImagesProgressiveDecoder extends DecodeProducer.ProgressiveDecoder
  {
    public LocalImagesProgressiveDecoder(ProducerContext paramBoolean, boolean arg3)
    {
      super(paramBoolean, localProducerContext, bool);
    }

    protected int getIntermediateImageEndOffset(EncodedImage paramEncodedImage)
    {
      return paramEncodedImage.getSize();
    }

    protected QualityInfo getQualityInfo()
    {
      return ImmutableQualityInfo.of(0, false, false);
    }

    protected boolean updateDecodeJob(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      monitorenter;
      if (!paramBoolean)
        paramBoolean = false;
      while (true)
      {
        monitorexit;
        return paramBoolean;
        try
        {
          paramBoolean = super.updateDecodeJob(paramEncodedImage, paramBoolean);
        }
        finally
        {
          monitorexit;
        }
      }
    }
  }

  private class NetworkImagesProgressiveDecoder extends DecodeProducer.ProgressiveDecoder
  {
    private int mLastScheduledScanNumber;
    private final ProgressiveJpegConfig mProgressiveJpegConfig;
    private final ProgressiveJpegParser mProgressiveJpegParser;

    public NetworkImagesProgressiveDecoder(ProducerContext paramProgressiveJpegParser, ProgressiveJpegParser paramProgressiveJpegConfig, ProgressiveJpegConfig paramBoolean, boolean arg5)
    {
      super(paramProgressiveJpegParser, paramProgressiveJpegConfig, bool);
      this.mProgressiveJpegParser = ((ProgressiveJpegParser)Preconditions.checkNotNull(paramBoolean));
      Object localObject;
      this.mProgressiveJpegConfig = ((ProgressiveJpegConfig)Preconditions.checkNotNull(localObject));
      this.mLastScheduledScanNumber = 0;
    }

    protected int getIntermediateImageEndOffset(EncodedImage paramEncodedImage)
    {
      return this.mProgressiveJpegParser.getBestScanEndOffset();
    }

    protected QualityInfo getQualityInfo()
    {
      return this.mProgressiveJpegConfig.getQualityInfo(this.mProgressiveJpegParser.getBestScanNumber());
    }

    protected boolean updateDecodeJob(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      monitorenter;
      try
      {
        boolean bool2 = super.updateDecodeJob(paramEncodedImage, paramBoolean);
        boolean bool1 = bool2;
        if (!paramBoolean)
        {
          bool1 = bool2;
          if (EncodedImage.isValid(paramEncodedImage))
          {
            bool1 = bool2;
            if (paramEncodedImage.getImageFormat() == DefaultImageFormats.JPEG)
            {
              paramBoolean = this.mProgressiveJpegParser.parseMoreData(paramEncodedImage);
              if (paramBoolean)
                break label64;
              bool1 = false;
            }
          }
        }
        while (true)
        {
          return bool1;
          label64: int i = this.mProgressiveJpegParser.getBestScanNumber();
          if (i <= this.mLastScheduledScanNumber)
          {
            bool1 = false;
            continue;
          }
          if ((i < this.mProgressiveJpegConfig.getNextScanNumberToDecode(this.mLastScheduledScanNumber)) && (!this.mProgressiveJpegParser.isEndMarkerRead()))
          {
            bool1 = false;
            continue;
          }
          this.mLastScheduledScanNumber = i;
          bool1 = bool2;
        }
      }
      finally
      {
        monitorexit;
      }
      throw paramEncodedImage;
    }
  }

  private abstract class ProgressiveDecoder extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>>
  {
    private final ImageDecodeOptions mImageDecodeOptions;

    @GuardedBy("this")
    private boolean mIsFinished;
    private final JobScheduler mJobScheduler;
    private final ProducerContext mProducerContext;
    private final ProducerListener mProducerListener;

    public ProgressiveDecoder(ProducerContext paramBoolean, boolean arg3)
    {
      super();
      ProducerContext localProducerContext;
      this.mProducerContext = localProducerContext;
      this.mProducerListener = localProducerContext.getListener();
      this.mImageDecodeOptions = localProducerContext.getImageRequest().getImageDecodeOptions();
      this.mIsFinished = false;
      paramBoolean = new JobScheduler.JobRunnable(DecodeProducer.this, localProducerContext)
      {
        public void run(EncodedImage paramEncodedImage, boolean paramBoolean)
        {
          if (paramEncodedImage != null)
          {
            if (DecodeProducer.this.mDownsampleEnabled)
            {
              ImageRequest localImageRequest = this.val$producerContext.getImageRequest();
              if ((DecodeProducer.this.mDownsampleEnabledForNetwork) || (!UriUtil.isNetworkUri(localImageRequest.getSourceUri())))
                paramEncodedImage.setSampleSize(DownsampleUtil.determineSampleSize(localImageRequest, paramEncodedImage));
            }
            DecodeProducer.ProgressiveDecoder.this.doDecode(paramEncodedImage, paramBoolean);
          }
        }
      };
      this.mJobScheduler = new JobScheduler(DecodeProducer.this.mExecutor, paramBoolean, this.mImageDecodeOptions.minDecodeIntervalMs);
      boolean bool;
      this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks(DecodeProducer.this, bool)
      {
        public void onCancellationRequested()
        {
          if (this.val$decodeCancellationEnabled)
            DecodeProducer.ProgressiveDecoder.this.handleCancellation();
        }

        public void onIsIntermediateResultExpectedChanged()
        {
          if (DecodeProducer.ProgressiveDecoder.this.mProducerContext.isIntermediateResultExpected())
            DecodeProducer.ProgressiveDecoder.this.mJobScheduler.scheduleJob();
        }
      });
    }

    private void doDecode(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      if ((isFinished()) || (!EncodedImage.isValid(paramEncodedImage)))
        return;
      Object localObject1 = paramEncodedImage.getImageFormat();
      if (localObject1 != null)
        localObject1 = ((ImageFormat)localObject1).getName();
      while (true)
      {
        String str1;
        String str2;
        label77: Object localObject3;
        if (paramEncodedImage != null)
        {
          str1 = paramEncodedImage.getWidth() + "x" + paramEncodedImage.getHeight();
          str2 = String.valueOf(paramEncodedImage.getSampleSize());
          localObject3 = this.mProducerContext.getImageRequest().getResizeOptions();
          if (localObject3 == null)
            break label271;
          localObject3 = ((ResizeOptions)localObject3).width + "x" + ((ResizeOptions)localObject3).height;
        }
        try
        {
          label129: long l = this.mJobScheduler.getQueuedTime();
          int i;
          label147: QualityInfo localQualityInfo;
          if (paramBoolean)
          {
            i = paramEncodedImage.getSize();
            if (!paramBoolean)
              break label287;
            localQualityInfo = ImmutableQualityInfo.FULL_QUALITY;
            this.mProducerListener.onProducerStart(this.mProducerContext.getId(), "DecodeProducer");
          }
          try
          {
            CloseableImage localCloseableImage = DecodeProducer.this.mImageDecoder.decode(paramEncodedImage, i, localQualityInfo, this.mImageDecodeOptions);
            localObject1 = getExtraMap(localCloseableImage, l, localQualityInfo, paramBoolean, (String)localObject1, str1, (String)localObject3, str2);
            this.mProducerListener.onProducerFinishWithSuccess(this.mProducerContext.getId(), "DecodeProducer", (Map)localObject1);
            handleResult(localCloseableImage, paramBoolean);
            EncodedImage.closeSafely(paramEncodedImage);
            return;
            localObject1 = "unknown";
            continue;
            str1 = "unknown";
            str2 = "unknown";
            break label77;
            label271: localObject3 = "unknown";
            break label129;
            i = getIntermediateImageEndOffset(paramEncodedImage);
            break label147;
            label287: localQualityInfo = getQualityInfo();
          }
          catch (Exception localException)
          {
            localObject1 = getExtraMap(null, l, localQualityInfo, paramBoolean, (String)localObject1, str1, (String)localObject3, str2);
            this.mProducerListener.onProducerFinishWithFailure(this.mProducerContext.getId(), "DecodeProducer", localException, (Map)localObject1);
            handleError(localException);
            EncodedImage.closeSafely(paramEncodedImage);
            return;
          }
        }
        finally
        {
          EncodedImage.closeSafely(paramEncodedImage);
        }
      }
      throw localObject2;
    }

    private Map<String, String> getExtraMap(@Nullable CloseableImage paramCloseableImage, long paramLong, QualityInfo paramQualityInfo, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      if (!this.mProducerListener.requiresExtraMap(this.mProducerContext.getId()))
        return null;
      String str1 = String.valueOf(paramLong);
      paramQualityInfo = String.valueOf(paramQualityInfo.isOfGoodEnoughQuality());
      String str2 = String.valueOf(paramBoolean);
      if ((paramCloseableImage instanceof CloseableStaticBitmap))
      {
        paramCloseableImage = ((CloseableStaticBitmap)paramCloseableImage).getUnderlyingBitmap();
        paramCloseableImage = paramCloseableImage.getWidth() + "x" + paramCloseableImage.getHeight();
        HashMap localHashMap = new HashMap(8);
        localHashMap.put("bitmapSize", paramCloseableImage);
        localHashMap.put("queueTime", str1);
        localHashMap.put("hasGoodQuality", paramQualityInfo);
        localHashMap.put("isFinal", str2);
        localHashMap.put("encodedImageSize", paramString2);
        localHashMap.put("imageFormat", paramString1);
        localHashMap.put("requestedImageSize", paramString3);
        localHashMap.put("sampleSize", paramString4);
        return ImmutableMap.copyOf(localHashMap);
      }
      paramCloseableImage = new HashMap(7);
      paramCloseableImage.put("queueTime", str1);
      paramCloseableImage.put("hasGoodQuality", paramQualityInfo);
      paramCloseableImage.put("isFinal", str2);
      paramCloseableImage.put("encodedImageSize", paramString2);
      paramCloseableImage.put("imageFormat", paramString1);
      paramCloseableImage.put("requestedImageSize", paramString3);
      paramCloseableImage.put("sampleSize", paramString4);
      return ImmutableMap.copyOf(paramCloseableImage);
    }

    private void handleCancellation()
    {
      maybeFinish(true);
      getConsumer().onCancellation();
    }

    private void handleError(Throwable paramThrowable)
    {
      maybeFinish(true);
      getConsumer().onFailure(paramThrowable);
    }

    private void handleResult(CloseableImage paramCloseableImage, boolean paramBoolean)
    {
      paramCloseableImage = CloseableReference.of(paramCloseableImage);
      try
      {
        maybeFinish(paramBoolean);
        getConsumer().onNewResult(paramCloseableImage, paramBoolean);
        return;
      }
      finally
      {
        CloseableReference.closeSafely(paramCloseableImage);
      }
      throw localObject;
    }

    private boolean isFinished()
    {
      monitorenter;
      try
      {
        boolean bool = this.mIsFinished;
        monitorexit;
        return bool;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
      throw localObject;
    }

    private void maybeFinish(boolean paramBoolean)
    {
      monitorenter;
      if (paramBoolean);
      try
      {
        if (this.mIsFinished)
          return;
        getConsumer().onProgressUpdate(1.0F);
        this.mIsFinished = true;
        monitorexit;
        this.mJobScheduler.clearJob();
        return;
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    protected abstract int getIntermediateImageEndOffset(EncodedImage paramEncodedImage);

    protected abstract QualityInfo getQualityInfo();

    public void onCancellationImpl()
    {
      handleCancellation();
    }

    public void onFailureImpl(Throwable paramThrowable)
    {
      handleError(paramThrowable);
    }

    public void onNewResultImpl(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      if ((paramBoolean) && (!EncodedImage.isValid(paramEncodedImage)))
        handleError(new ExceptionWithNoStacktrace("Encoded image is not valid."));
      do
        return;
      while ((!updateDecodeJob(paramEncodedImage, paramBoolean)) || ((!paramBoolean) && (!this.mProducerContext.isIntermediateResultExpected())));
      this.mJobScheduler.scheduleJob();
    }

    protected void onProgressUpdateImpl(float paramFloat)
    {
      super.onProgressUpdateImpl(0.99F * paramFloat);
    }

    protected boolean updateDecodeJob(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      return this.mJobScheduler.updateJob(paramEncodedImage, paramBoolean);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.DecodeProducer
 * JD-Core Version:    0.6.0
 */
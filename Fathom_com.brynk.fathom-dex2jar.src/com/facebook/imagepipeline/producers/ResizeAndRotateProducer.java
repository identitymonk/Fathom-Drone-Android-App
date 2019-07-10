package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class ResizeAndRotateProducer
  implements Producer<EncodedImage>
{

  @VisibleForTesting
  static final int DEFAULT_JPEG_QUALITY = 85;
  private static final String DOWNSAMPLE_ENUMERATOR_KEY = "downsampleEnumerator";
  private static final String FRACTION_KEY = "Fraction";
  private static final int FULL_ROUND = 360;

  @VisibleForTesting
  static final int MAX_JPEG_SCALE_NUMERATOR = 8;

  @VisibleForTesting
  static final int MIN_TRANSFORM_INTERVAL_MS = 100;
  private static final String ORIGINAL_SIZE_KEY = "Original size";
  public static final String PRODUCER_NAME = "ResizeAndRotateProducer";
  private static final String REQUESTED_SIZE_KEY = "Requested size";
  private static final String ROTATION_ANGLE_KEY = "rotationAngle";
  private static final String SOFTWARE_ENUMERATOR_KEY = "softwareEnumerator";
  private final Executor mExecutor;
  private final Producer<EncodedImage> mInputProducer;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  private final boolean mResizingEnabled;
  private final boolean mUseDownsamplingRatio;

  public ResizeAndRotateProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, boolean paramBoolean1, Producer<EncodedImage> paramProducer, boolean paramBoolean2)
  {
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mPooledByteBufferFactory = ((PooledByteBufferFactory)Preconditions.checkNotNull(paramPooledByteBufferFactory));
    this.mResizingEnabled = paramBoolean1;
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mUseDownsamplingRatio = paramBoolean2;
  }

  @VisibleForTesting
  static int calculateDownsampleNumerator(int paramInt)
  {
    return Math.max(1, 8 / paramInt);
  }

  @VisibleForTesting
  static float determineResizeRatio(ResizeOptions paramResizeOptions, int paramInt1, int paramInt2)
  {
    float f2;
    if (paramResizeOptions == null)
      f2 = 1.0F;
    float f1;
    do
    {
      return f2;
      f2 = Math.max(paramResizeOptions.width / paramInt1, paramResizeOptions.height / paramInt2);
      f1 = f2;
      if (paramInt1 * f2 > paramResizeOptions.maxBitmapSize)
        f1 = paramResizeOptions.maxBitmapSize / paramInt1;
      f2 = f1;
    }
    while (paramInt2 * f1 <= paramResizeOptions.maxBitmapSize);
    return paramResizeOptions.maxBitmapSize / paramInt2;
  }

  private static int extractOrientationFromMetadata(EncodedImage paramEncodedImage)
  {
    switch (paramEncodedImage.getRotationAngle())
    {
    default:
      return 0;
    case 90:
    case 180:
    case 270:
    }
    return paramEncodedImage.getRotationAngle();
  }

  private static int getRotationAngle(RotationOptions paramRotationOptions, EncodedImage paramEncodedImage)
  {
    int i;
    if (!paramRotationOptions.rotationEnabled())
      i = 0;
    int j;
    do
    {
      return i;
      j = extractOrientationFromMetadata(paramEncodedImage);
      i = j;
    }
    while (paramRotationOptions.useImageMetadata());
    return (paramRotationOptions.getForcedAngle() + j) % 360;
  }

  private static int getSoftwareNumerator(ImageRequest paramImageRequest, EncodedImage paramEncodedImage, boolean paramBoolean)
  {
    int i;
    if (!paramBoolean)
      i = 8;
    int j;
    label58: label103: label111: label120: 
    do
    {
      return i;
      ResizeOptions localResizeOptions = paramImageRequest.getResizeOptions();
      if (localResizeOptions == null)
        return 8;
      i = getRotationAngle(paramImageRequest.getRotationOptions(), paramEncodedImage);
      if ((i == 90) || (i == 270))
      {
        j = 1;
        if (j == 0)
          break label103;
        i = paramEncodedImage.getHeight();
        if (j == 0)
          break label111;
      }
      for (j = paramEncodedImage.getWidth(); ; j = paramEncodedImage.getHeight())
      {
        j = roundNumerator(determineResizeRatio(localResizeOptions, i, j), localResizeOptions.roundUpFraction);
        if (j <= 8)
          break label120;
        return 8;
        j = 0;
        break;
        i = paramEncodedImage.getWidth();
        break label58;
      }
      i = j;
    }
    while (j >= 1);
    return 1;
  }

  @VisibleForTesting
  static int roundNumerator(float paramFloat1, float paramFloat2)
  {
    return (int)(8.0F * paramFloat1 + paramFloat2);
  }

  private static boolean shouldResize(int paramInt)
  {
    return paramInt < 8;
  }

  private static boolean shouldRotate(RotationOptions paramRotationOptions, EncodedImage paramEncodedImage)
  {
    return (!paramRotationOptions.canDeferUntilRendered()) && (getRotationAngle(paramRotationOptions, paramEncodedImage) != 0);
  }

  private static TriState shouldTransform(ImageRequest paramImageRequest, EncodedImage paramEncodedImage, boolean paramBoolean)
  {
    if ((paramEncodedImage == null) || (paramEncodedImage.getImageFormat() == ImageFormat.UNKNOWN))
      return TriState.UNSET;
    if (paramEncodedImage.getImageFormat() != DefaultImageFormats.JPEG)
      return TriState.NO;
    if ((shouldRotate(paramImageRequest.getRotationOptions(), paramEncodedImage)) || (shouldResize(getSoftwareNumerator(paramImageRequest, paramEncodedImage, paramBoolean))));
    for (paramBoolean = true; ; paramBoolean = false)
      return TriState.valueOf(paramBoolean);
  }

  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    this.mInputProducer.produceResults(new TransformingConsumer(paramConsumer, paramProducerContext), paramProducerContext);
  }

  private class TransformingConsumer extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private boolean mIsCancelled = false;
    private final JobScheduler mJobScheduler;
    private final ProducerContext mProducerContext;

    public TransformingConsumer(ProducerContext arg2)
    {
      super();
      this.mProducerContext = local1;
      1 local1 = new JobScheduler.JobRunnable(ResizeAndRotateProducer.this)
      {
        public void run(EncodedImage paramEncodedImage, boolean paramBoolean)
        {
          ResizeAndRotateProducer.TransformingConsumer.this.doTransform(paramEncodedImage, paramBoolean);
        }
      };
      this.mJobScheduler = new JobScheduler(ResizeAndRotateProducer.this.mExecutor, local1, 100);
      this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks(ResizeAndRotateProducer.this, localConsumer)
      {
        public void onCancellationRequested()
        {
          ResizeAndRotateProducer.TransformingConsumer.this.mJobScheduler.clearJob();
          ResizeAndRotateProducer.TransformingConsumer.access$402(ResizeAndRotateProducer.TransformingConsumer.this, true);
          this.val$consumer.onCancellation();
        }

        public void onIsIntermediateResultExpectedChanged()
        {
          if (ResizeAndRotateProducer.TransformingConsumer.this.mProducerContext.isIntermediateResultExpected())
            ResizeAndRotateProducer.TransformingConsumer.this.mJobScheduler.scheduleJob();
        }
      });
    }

    // ERROR //
    private void doTransform(EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   4: invokeinterface 75 1 0
      //   9: aload_0
      //   10: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   13: invokeinterface 79 1 0
      //   18: ldc 81
      //   20: invokeinterface 87 3 0
      //   25: aload_0
      //   26: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   29: invokeinterface 91 1 0
      //   34: astore 14
      //   36: aload_0
      //   37: getfield 24	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:this$0	Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;
      //   40: invokestatic 95	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$700	(Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;)Lcom/facebook/common/memory/PooledByteBufferFactory;
      //   43: invokeinterface 101 1 0
      //   48: astore 13
      //   50: aconst_null
      //   51: astore 10
      //   53: aconst_null
      //   54: astore 12
      //   56: aconst_null
      //   57: astore 11
      //   59: aload 10
      //   61: astore 8
      //   63: aload 11
      //   65: astore 9
      //   67: aload 12
      //   69: astore 7
      //   71: aload 14
      //   73: aload_1
      //   74: aload_0
      //   75: getfield 24	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:this$0	Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;
      //   78: invokestatic 105	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$500	(Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;)Z
      //   81: invokestatic 109	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$800	(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;Z)I
      //   84: istore 4
      //   86: aload 10
      //   88: astore 8
      //   90: aload 11
      //   92: astore 9
      //   94: aload 12
      //   96: astore 7
      //   98: aload 14
      //   100: aload_1
      //   101: invokestatic 115	com/facebook/imagepipeline/producers/DownsampleUtil:determineSampleSize	(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/image/EncodedImage;)I
      //   104: invokestatic 119	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:calculateDownsampleNumerator	(I)I
      //   107: istore 5
      //   109: aload 10
      //   111: astore 8
      //   113: aload 11
      //   115: astore 9
      //   117: aload 12
      //   119: astore 7
      //   121: aload_0
      //   122: getfield 24	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:this$0	Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;
      //   125: invokestatic 122	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$900	(Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;)Z
      //   128: ifeq +198 -> 326
      //   131: iload 5
      //   133: istore_3
      //   134: aload 10
      //   136: astore 8
      //   138: aload 11
      //   140: astore 9
      //   142: aload 12
      //   144: astore 7
      //   146: aload 14
      //   148: invokevirtual 128	com/facebook/imagepipeline/request/ImageRequest:getRotationOptions	()Lcom/facebook/imagepipeline/common/RotationOptions;
      //   151: aload_1
      //   152: invokestatic 132	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$1000	(Lcom/facebook/imagepipeline/common/RotationOptions;Lcom/facebook/imagepipeline/image/EncodedImage;)I
      //   155: istore 6
      //   157: aload 10
      //   159: astore 8
      //   161: aload 11
      //   163: astore 9
      //   165: aload 12
      //   167: astore 7
      //   169: aload_0
      //   170: aload_1
      //   171: aload 14
      //   173: iload_3
      //   174: iload 5
      //   176: iload 4
      //   178: iload 6
      //   180: invokespecial 136	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:getExtraMap	(Lcom/facebook/imagepipeline/image/EncodedImage;Lcom/facebook/imagepipeline/request/ImageRequest;IIII)Ljava/util/Map;
      //   183: astore 10
      //   185: aload 10
      //   187: astore 8
      //   189: aload 11
      //   191: astore 9
      //   193: aload 12
      //   195: astore 7
      //   197: aload_1
      //   198: invokevirtual 142	com/facebook/imagepipeline/image/EncodedImage:getInputStream	()Ljava/io/InputStream;
      //   201: astore_1
      //   202: aload 10
      //   204: astore 8
      //   206: aload_1
      //   207: astore 9
      //   209: aload_1
      //   210: astore 7
      //   212: aload_1
      //   213: aload 13
      //   215: iload 6
      //   217: iload_3
      //   218: bipush 85
      //   220: invokestatic 148	com/facebook/imagepipeline/nativecode/JpegTranscoder:transcodeJpeg	(Ljava/io/InputStream;Ljava/io/OutputStream;III)V
      //   223: aload 10
      //   225: astore 8
      //   227: aload_1
      //   228: astore 9
      //   230: aload_1
      //   231: astore 7
      //   233: aload 13
      //   235: invokevirtual 154	com/facebook/common/memory/PooledByteBufferOutputStream:toByteBuffer	()Lcom/facebook/common/memory/PooledByteBuffer;
      //   238: invokestatic 160	com/facebook/common/references/CloseableReference:of	(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
      //   241: astore 12
      //   243: new 138	com/facebook/imagepipeline/image/EncodedImage
      //   246: dup
      //   247: aload 12
      //   249: invokespecial 163	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
      //   252: astore 7
      //   254: aload 7
      //   256: getstatic 169	com/facebook/imageformat/DefaultImageFormats:JPEG	Lcom/facebook/imageformat/ImageFormat;
      //   259: invokevirtual 173	com/facebook/imagepipeline/image/EncodedImage:setImageFormat	(Lcom/facebook/imageformat/ImageFormat;)V
      //   262: aload 7
      //   264: invokevirtual 177	com/facebook/imagepipeline/image/EncodedImage:parseMetaData	()V
      //   267: aload_0
      //   268: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   271: invokeinterface 75 1 0
      //   276: aload_0
      //   277: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   280: invokeinterface 79 1 0
      //   285: ldc 81
      //   287: aload 10
      //   289: invokeinterface 181 4 0
      //   294: aload_0
      //   295: invokevirtual 185	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   298: aload 7
      //   300: iload_2
      //   301: invokeinterface 191 3 0
      //   306: aload 7
      //   308: invokestatic 195	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   311: aload 12
      //   313: invokestatic 197	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   316: aload_1
      //   317: invokestatic 203	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
      //   320: aload 13
      //   322: invokevirtual 206	com/facebook/common/memory/PooledByteBufferOutputStream:close	()V
      //   325: return
      //   326: iload 4
      //   328: istore_3
      //   329: goto -195 -> 134
      //   332: astore 8
      //   334: aload 7
      //   336: invokestatic 195	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   339: aload 8
      //   341: athrow
      //   342: astore 11
      //   344: aload 10
      //   346: astore 8
      //   348: aload_1
      //   349: astore 9
      //   351: aload_1
      //   352: astore 7
      //   354: aload 12
      //   356: invokestatic 197	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   359: aload 10
      //   361: astore 8
      //   363: aload_1
      //   364: astore 9
      //   366: aload_1
      //   367: astore 7
      //   369: aload 11
      //   371: athrow
      //   372: astore 7
      //   374: aload 9
      //   376: astore_1
      //   377: aload 8
      //   379: astore 10
      //   381: aload 7
      //   383: astore 8
      //   385: aload_1
      //   386: astore 7
      //   388: aload_0
      //   389: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   392: invokeinterface 75 1 0
      //   397: aload_0
      //   398: getfield 31	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   401: invokeinterface 79 1 0
      //   406: ldc 81
      //   408: aload 8
      //   410: aload 10
      //   412: invokeinterface 210 5 0
      //   417: aload_1
      //   418: astore 7
      //   420: aload_0
      //   421: invokevirtual 185	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   424: aload 8
      //   426: invokeinterface 214 2 0
      //   431: aload_1
      //   432: invokestatic 203	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
      //   435: aload 13
      //   437: invokevirtual 206	com/facebook/common/memory/PooledByteBufferOutputStream:close	()V
      //   440: return
      //   441: astore 8
      //   443: aload 7
      //   445: astore_1
      //   446: aload 8
      //   448: astore 7
      //   450: aload_1
      //   451: invokestatic 203	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
      //   454: aload 13
      //   456: invokevirtual 206	com/facebook/common/memory/PooledByteBufferOutputStream:close	()V
      //   459: aload 7
      //   461: athrow
      //   462: astore 7
      //   464: goto -14 -> 450
      //   467: astore 8
      //   469: goto -84 -> 385
      //   472: astore 11
      //   474: goto -130 -> 344
      //
      // Exception table:
      //   from	to	target	type
      //   262	306	332	finally
      //   254	262	342	finally
      //   306	311	342	finally
      //   334	342	342	finally
      //   71	86	372	java/lang/Exception
      //   98	109	372	java/lang/Exception
      //   121	131	372	java/lang/Exception
      //   146	157	372	java/lang/Exception
      //   169	185	372	java/lang/Exception
      //   197	202	372	java/lang/Exception
      //   212	223	372	java/lang/Exception
      //   233	243	372	java/lang/Exception
      //   354	359	372	java/lang/Exception
      //   369	372	372	java/lang/Exception
      //   71	86	441	finally
      //   98	109	441	finally
      //   121	131	441	finally
      //   146	157	441	finally
      //   169	185	441	finally
      //   197	202	441	finally
      //   212	223	441	finally
      //   233	243	441	finally
      //   354	359	441	finally
      //   369	372	441	finally
      //   388	417	441	finally
      //   420	431	441	finally
      //   311	316	462	finally
      //   311	316	467	java/lang/Exception
      //   243	254	472	finally
    }

    private Map<String, String> getExtraMap(EncodedImage paramEncodedImage, ImageRequest paramImageRequest, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (!this.mProducerContext.getListener().requiresExtraMap(this.mProducerContext.getId()))
        return null;
      String str = paramEncodedImage.getWidth() + "x" + paramEncodedImage.getHeight();
      if (paramImageRequest.getResizeOptions() != null)
      {
        paramEncodedImage = paramImageRequest.getResizeOptions().width + "x" + paramImageRequest.getResizeOptions().height;
        if (paramInt1 <= 0)
          break label255;
      }
      label255: for (paramImageRequest = paramInt1 + "/8"; ; paramImageRequest = "")
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("Original size", str);
        localHashMap.put("Requested size", paramEncodedImage);
        localHashMap.put("Fraction", paramImageRequest);
        localHashMap.put("queueTime", String.valueOf(this.mJobScheduler.getQueuedTime()));
        localHashMap.put("downsampleEnumerator", Integer.toString(paramInt2));
        localHashMap.put("softwareEnumerator", Integer.toString(paramInt3));
        localHashMap.put("rotationAngle", Integer.toString(paramInt4));
        return ImmutableMap.copyOf(localHashMap);
        paramEncodedImage = "Unspecified";
        break;
      }
    }

    protected void onNewResultImpl(@Nullable EncodedImage paramEncodedImage, boolean paramBoolean)
    {
      if (this.mIsCancelled);
      do
      {
        TriState localTriState;
        do
        {
          while (true)
          {
            return;
            if (paramEncodedImage != null)
              break;
            if (!paramBoolean)
              continue;
            getConsumer().onNewResult(null, true);
            return;
          }
          localTriState = ResizeAndRotateProducer.access$600(this.mProducerContext.getImageRequest(), paramEncodedImage, ResizeAndRotateProducer.this.mResizingEnabled);
        }
        while ((!paramBoolean) && (localTriState == TriState.UNSET));
        if (localTriState == TriState.YES)
          continue;
        getConsumer().onNewResult(paramEncodedImage, paramBoolean);
        return;
      }
      while ((!this.mJobScheduler.updateJob(paramEncodedImage, paramBoolean)) || ((!paramBoolean) && (!this.mProducerContext.isIntermediateResultExpected())));
      this.mJobScheduler.scheduleJob();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.ResizeAndRotateProducer
 * JD-Core Version:    0.6.0
 */
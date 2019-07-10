package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;

public class NetworkFetchProducer
  implements Producer<EncodedImage>
{
  public static final String INTERMEDIATE_RESULT_PRODUCER_EVENT = "intermediate_result";
  public static final String PRODUCER_NAME = "NetworkFetchProducer";
  private static final int READ_SIZE = 16384;

  @VisibleForTesting
  static final long TIME_BETWEEN_PARTIAL_RESULTS_MS = 100L;
  private final ByteArrayPool mByteArrayPool;
  private final NetworkFetcher mNetworkFetcher;
  private final PooledByteBufferFactory mPooledByteBufferFactory;

  public NetworkFetchProducer(PooledByteBufferFactory paramPooledByteBufferFactory, ByteArrayPool paramByteArrayPool, NetworkFetcher paramNetworkFetcher)
  {
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    this.mByteArrayPool = paramByteArrayPool;
    this.mNetworkFetcher = paramNetworkFetcher;
  }

  private static float calculateProgress(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0)
      return paramInt1 / paramInt2;
    return 1.0F - (float)Math.exp(-paramInt1 / 50000.0D);
  }

  @Nullable
  private Map<String, String> getExtraMap(FetchState paramFetchState, int paramInt)
  {
    if (!paramFetchState.getListener().requiresExtraMap(paramFetchState.getId()))
      return null;
    return this.mNetworkFetcher.getExtraMap(paramFetchState, paramInt);
  }

  private void handleFinalResult(PooledByteBufferOutputStream paramPooledByteBufferOutputStream, FetchState paramFetchState)
  {
    Map localMap = getExtraMap(paramFetchState, paramPooledByteBufferOutputStream.size());
    ProducerListener localProducerListener = paramFetchState.getListener();
    localProducerListener.onProducerFinishWithSuccess(paramFetchState.getId(), "NetworkFetchProducer", localMap);
    localProducerListener.onUltimateProducerReached(paramFetchState.getId(), "NetworkFetchProducer", true);
    notifyConsumer(paramPooledByteBufferOutputStream, true, paramFetchState.getConsumer());
  }

  private void maybeHandleIntermediateResult(PooledByteBufferOutputStream paramPooledByteBufferOutputStream, FetchState paramFetchState)
  {
    long l = SystemClock.uptimeMillis();
    if ((shouldPropagateIntermediateResults(paramFetchState)) && (l - paramFetchState.getLastIntermediateResultTimeMs() >= 100L))
    {
      paramFetchState.setLastIntermediateResultTimeMs(l);
      paramFetchState.getListener().onProducerEvent(paramFetchState.getId(), "NetworkFetchProducer", "intermediate_result");
      notifyConsumer(paramPooledByteBufferOutputStream, false, paramFetchState.getConsumer());
    }
  }

  // ERROR //
  private void notifyConsumer(PooledByteBufferOutputStream paramPooledByteBufferOutputStream, boolean paramBoolean, Consumer<EncodedImage> paramConsumer)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 150	com/facebook/common/memory/PooledByteBufferOutputStream:toByteBuffer	()Lcom/facebook/common/memory/PooledByteBuffer;
    //   4: invokestatic 156	com/facebook/common/references/CloseableReference:of	(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_1
    //   11: new 158	com/facebook/imagepipeline/image/EncodedImage
    //   14: dup
    //   15: aload 5
    //   17: invokespecial 161	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
    //   20: astore 4
    //   22: aload 4
    //   24: invokevirtual 164	com/facebook/imagepipeline/image/EncodedImage:parseMetaData	()V
    //   27: aload_3
    //   28: aload 4
    //   30: iload_2
    //   31: invokeinterface 170 3 0
    //   36: aload 4
    //   38: invokestatic 174	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   41: aload 5
    //   43: invokestatic 176	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   46: return
    //   47: astore_3
    //   48: aload_1
    //   49: invokestatic 174	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   52: aload 5
    //   54: invokestatic 176	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   57: aload_3
    //   58: athrow
    //   59: astore_3
    //   60: aload 4
    //   62: astore_1
    //   63: goto -15 -> 48
    //
    // Exception table:
    //   from	to	target	type
    //   11	22	47	finally
    //   22	36	59	finally
  }

  private void onCancellation(FetchState paramFetchState)
  {
    paramFetchState.getListener().onProducerFinishWithCancellation(paramFetchState.getId(), "NetworkFetchProducer", null);
    paramFetchState.getConsumer().onCancellation();
  }

  private void onFailure(FetchState paramFetchState, Throwable paramThrowable)
  {
    paramFetchState.getListener().onProducerFinishWithFailure(paramFetchState.getId(), "NetworkFetchProducer", paramThrowable, null);
    paramFetchState.getListener().onUltimateProducerReached(paramFetchState.getId(), "NetworkFetchProducer", false);
    paramFetchState.getConsumer().onFailure(paramThrowable);
  }

  private void onResponse(FetchState paramFetchState, InputStream paramInputStream, int paramInt)
    throws IOException
  {
    if (paramInt > 0);
    byte[] arrayOfByte;
    for (PooledByteBufferOutputStream localPooledByteBufferOutputStream = this.mPooledByteBufferFactory.newOutputStream(paramInt); ; localPooledByteBufferOutputStream = this.mPooledByteBufferFactory.newOutputStream())
    {
      arrayOfByte = (byte[])this.mByteArrayPool.get(16384);
      try
      {
        while (true)
        {
          int i = paramInputStream.read(arrayOfByte);
          if (i < 0)
            break;
          if (i <= 0)
            continue;
          localPooledByteBufferOutputStream.write(arrayOfByte, 0, i);
          maybeHandleIntermediateResult(localPooledByteBufferOutputStream, paramFetchState);
          float f = calculateProgress(localPooledByteBufferOutputStream.size(), paramInt);
          paramFetchState.getConsumer().onProgressUpdate(f);
        }
      }
      finally
      {
        this.mByteArrayPool.release(arrayOfByte);
        localPooledByteBufferOutputStream.close();
      }
    }
    this.mNetworkFetcher.onFetchCompletion(paramFetchState, localPooledByteBufferOutputStream.size());
    handleFinalResult(localPooledByteBufferOutputStream, paramFetchState);
    this.mByteArrayPool.release(arrayOfByte);
    localPooledByteBufferOutputStream.close();
  }

  private boolean shouldPropagateIntermediateResults(FetchState paramFetchState)
  {
    if (!paramFetchState.getContext().isIntermediateResultExpected())
      return false;
    return this.mNetworkFetcher.shouldPropagate(paramFetchState);
  }

  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    paramProducerContext.getListener().onProducerStart(paramProducerContext.getId(), "NetworkFetchProducer");
    paramConsumer = this.mNetworkFetcher.createFetchState(paramConsumer, paramProducerContext);
    this.mNetworkFetcher.fetch(paramConsumer, new NetworkFetcher.Callback(paramConsumer)
    {
      public void onCancellation()
      {
        NetworkFetchProducer.this.onCancellation(this.val$fetchState);
      }

      public void onFailure(Throwable paramThrowable)
      {
        NetworkFetchProducer.this.onFailure(this.val$fetchState, paramThrowable);
      }

      public void onResponse(InputStream paramInputStream, int paramInt)
        throws IOException
      {
        NetworkFetchProducer.this.onResponse(this.val$fetchState, paramInputStream, paramInt);
      }
    });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.NetworkFetchProducer
 * JD-Core Version:    0.6.0
 */
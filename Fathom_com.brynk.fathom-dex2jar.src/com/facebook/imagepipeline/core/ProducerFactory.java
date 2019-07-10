package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.DiskCachePolicy;
import com.facebook.imagepipeline.cache.MediaIdExtractor;
import com.facebook.imagepipeline.cache.MediaVariationsIndex;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.SmallCacheIfRequestedDiskCachePolicy;
import com.facebook.imagepipeline.cache.SplitCachesByImageSizeDiskCachePolicy;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.DiskCacheWriteProducer;
import com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer;
import com.facebook.imagepipeline.producers.MediaVariationsFallbackProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.NullProducer;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessorProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer;
import com.facebook.imagepipeline.producers.ResizeAndRotateProducer;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThrottlingProducer;
import com.facebook.imagepipeline.producers.ThumbnailBranchProducer;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.producers.WebpTranscodeProducer;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class ProducerFactory
{
  private static final int MAX_SIMULTANEOUS_REQUESTS = 5;
  private AssetManager mAssetManager;
  private final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
  private final ByteArrayPool mByteArrayPool;
  private final CacheKeyFactory mCacheKeyFactory;
  private ContentResolver mContentResolver;
  private final boolean mDecodeCancellationEnabled;
  private final BufferedDiskCache mDefaultBufferedDiskCache;
  private final boolean mDownsampleEnabled;
  private final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
  private final ExecutorSupplier mExecutorSupplier;
  private final ImageDecoder mImageDecoder;
  private final DiskCachePolicy mMainDiskCachePolicy;

  @Nullable
  private final MediaIdExtractor mMediaIdExtractor;
  private final MediaVariationsIndex mMediaVariationsIndex;
  private final PlatformBitmapFactory mPlatformBitmapFactory;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  private final ProgressiveJpegConfig mProgressiveJpegConfig;
  private final boolean mResizeAndRotateEnabledForNetwork;
  private Resources mResources;
  private final BufferedDiskCache mSmallImageBufferedDiskCache;

  public ProducerFactory(Context paramContext, ByteArrayPool paramByteArrayPool, ImageDecoder paramImageDecoder, ProgressiveJpegConfig paramProgressiveJpegConfig, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ExecutorSupplier paramExecutorSupplier, PooledByteBufferFactory paramPooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache1, BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, MediaVariationsIndex paramMediaVariationsIndex, @Nullable MediaIdExtractor paramMediaIdExtractor, CacheKeyFactory paramCacheKeyFactory, PlatformBitmapFactory paramPlatformBitmapFactory, int paramInt)
  {
    this.mContentResolver = paramContext.getApplicationContext().getContentResolver();
    this.mResources = paramContext.getApplicationContext().getResources();
    this.mAssetManager = paramContext.getApplicationContext().getAssets();
    this.mByteArrayPool = paramByteArrayPool;
    this.mImageDecoder = paramImageDecoder;
    this.mProgressiveJpegConfig = paramProgressiveJpegConfig;
    this.mDownsampleEnabled = paramBoolean1;
    this.mResizeAndRotateEnabledForNetwork = paramBoolean2;
    this.mDecodeCancellationEnabled = paramBoolean3;
    this.mExecutorSupplier = paramExecutorSupplier;
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    this.mBitmapMemoryCache = paramMemoryCache;
    this.mEncodedMemoryCache = paramMemoryCache1;
    this.mDefaultBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mMediaVariationsIndex = paramMediaVariationsIndex;
    this.mMediaIdExtractor = paramMediaIdExtractor;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mPlatformBitmapFactory = paramPlatformBitmapFactory;
    if (paramInt > 0)
    {
      this.mMainDiskCachePolicy = new SplitCachesByImageSizeDiskCachePolicy(paramBufferedDiskCache1, paramBufferedDiskCache2, paramCacheKeyFactory, paramInt);
      return;
    }
    this.mMainDiskCachePolicy = new SmallCacheIfRequestedDiskCachePolicy(paramBufferedDiskCache1, paramBufferedDiskCache2, paramCacheKeyFactory);
  }

  public static AddImageTransformMetaDataProducer newAddImageTransformMetaDataProducer(Producer<EncodedImage> paramProducer)
  {
    return new AddImageTransformMetaDataProducer(paramProducer);
  }

  public static BranchOnSeparateImagesProducer newBranchOnSeparateImagesProducer(Producer<EncodedImage> paramProducer1, Producer<EncodedImage> paramProducer2)
  {
    return new BranchOnSeparateImagesProducer(paramProducer1, paramProducer2);
  }

  public static <T> NullProducer<T> newNullProducer()
  {
    return new NullProducer();
  }

  public static <T> SwallowResultProducer<T> newSwallowResultProducer(Producer<T> paramProducer)
  {
    return new SwallowResultProducer(paramProducer);
  }

  public <T> ThreadHandoffProducer<T> newBackgroundThreadHandoffProducer(Producer<T> paramProducer, ThreadHandoffProducerQueue paramThreadHandoffProducerQueue)
  {
    return new ThreadHandoffProducer(paramProducer, paramThreadHandoffProducerQueue);
  }

  public BitmapMemoryCacheGetProducer newBitmapMemoryCacheGetProducer(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    return new BitmapMemoryCacheGetProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, paramProducer);
  }

  public BitmapMemoryCacheKeyMultiplexProducer newBitmapMemoryCacheKeyMultiplexProducer(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    return new BitmapMemoryCacheKeyMultiplexProducer(this.mCacheKeyFactory, paramProducer);
  }

  public BitmapMemoryCacheProducer newBitmapMemoryCacheProducer(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    return new BitmapMemoryCacheProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, paramProducer);
  }

  public DataFetchProducer newDataFetchProducer()
  {
    return new DataFetchProducer(this.mPooledByteBufferFactory);
  }

  public DecodeProducer newDecodeProducer(Producer<EncodedImage> paramProducer)
  {
    return new DecodeProducer(this.mByteArrayPool, this.mExecutorSupplier.forDecode(), this.mImageDecoder, this.mProgressiveJpegConfig, this.mDownsampleEnabled, this.mResizeAndRotateEnabledForNetwork, this.mDecodeCancellationEnabled, paramProducer);
  }

  public DiskCacheReadProducer newDiskCacheReadProducer(Producer<EncodedImage> paramProducer)
  {
    return new DiskCacheReadProducer(paramProducer, this.mMainDiskCachePolicy);
  }

  public DiskCacheWriteProducer newDiskCacheWriteProducer(Producer<EncodedImage> paramProducer)
  {
    return new DiskCacheWriteProducer(paramProducer, this.mMainDiskCachePolicy);
  }

  public EncodedCacheKeyMultiplexProducer newEncodedCacheKeyMultiplexProducer(Producer<EncodedImage> paramProducer)
  {
    return new EncodedCacheKeyMultiplexProducer(this.mCacheKeyFactory, paramProducer);
  }

  public EncodedMemoryCacheProducer newEncodedMemoryCacheProducer(Producer<EncodedImage> paramProducer)
  {
    return new EncodedMemoryCacheProducer(this.mEncodedMemoryCache, this.mCacheKeyFactory, paramProducer);
  }

  public LocalAssetFetchProducer newLocalAssetFetchProducer()
  {
    return new LocalAssetFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mAssetManager);
  }

  public LocalContentUriFetchProducer newLocalContentUriFetchProducer()
  {
    return new LocalContentUriFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mContentResolver);
  }

  public LocalContentUriThumbnailFetchProducer newLocalContentUriThumbnailFetchProducer()
  {
    return new LocalContentUriThumbnailFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mContentResolver);
  }

  public LocalExifThumbnailProducer newLocalExifThumbnailProducer()
  {
    return new LocalExifThumbnailProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mContentResolver);
  }

  public LocalFileFetchProducer newLocalFileFetchProducer()
  {
    return new LocalFileFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory);
  }

  public LocalResourceFetchProducer newLocalResourceFetchProducer()
  {
    return new LocalResourceFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mResources);
  }

  public LocalVideoThumbnailProducer newLocalVideoThumbnailProducer()
  {
    return new LocalVideoThumbnailProducer(this.mExecutorSupplier.forLocalStorageRead());
  }

  public MediaVariationsFallbackProducer newMediaVariationsProducer(Producer<EncodedImage> paramProducer)
  {
    return new MediaVariationsFallbackProducer(this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, this.mMediaVariationsIndex, this.mMediaIdExtractor, this.mMainDiskCachePolicy, paramProducer);
  }

  public NetworkFetchProducer newNetworkFetchProducer(NetworkFetcher paramNetworkFetcher)
  {
    return new NetworkFetchProducer(this.mPooledByteBufferFactory, this.mByteArrayPool, paramNetworkFetcher);
  }

  public PostprocessedBitmapMemoryCacheProducer newPostprocessorBitmapMemoryCacheProducer(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    return new PostprocessedBitmapMemoryCacheProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, paramProducer);
  }

  public PostprocessorProducer newPostprocessorProducer(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    return new PostprocessorProducer(paramProducer, this.mPlatformBitmapFactory, this.mExecutorSupplier.forBackgroundTasks());
  }

  public QualifiedResourceFetchProducer newQualifiedResourceFetchProducer()
  {
    return new QualifiedResourceFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mContentResolver);
  }

  public ResizeAndRotateProducer newResizeAndRotateProducer(Producer<EncodedImage> paramProducer, boolean paramBoolean1, boolean paramBoolean2)
  {
    Executor localExecutor = this.mExecutorSupplier.forBackgroundTasks();
    PooledByteBufferFactory localPooledByteBufferFactory = this.mPooledByteBufferFactory;
    if ((paramBoolean1) && (!this.mDownsampleEnabled));
    for (paramBoolean1 = true; ; paramBoolean1 = false)
      return new ResizeAndRotateProducer(localExecutor, localPooledByteBufferFactory, paramBoolean1, paramProducer, paramBoolean2);
  }

  public <T> ThrottlingProducer<T> newThrottlingProducer(Producer<T> paramProducer)
  {
    return new ThrottlingProducer(5, this.mExecutorSupplier.forLightweightBackgroundTasks(), paramProducer);
  }

  public ThumbnailBranchProducer newThumbnailBranchProducer(ThumbnailProducer<EncodedImage>[] paramArrayOfThumbnailProducer)
  {
    return new ThumbnailBranchProducer(paramArrayOfThumbnailProducer);
  }

  public WebpTranscodeProducer newWebpTranscodeProducer(Producer<EncodedImage> paramProducer)
  {
    return new WebpTranscodeProducer(this.mExecutorSupplier.forBackgroundTasks(), this.mPooledByteBufferFactory, paramProducer);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.core.ProducerFactory
 * JD-Core Version:    0.6.0
 */
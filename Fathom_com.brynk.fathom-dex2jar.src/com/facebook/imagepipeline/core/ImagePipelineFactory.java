package com.facebook.imagepipeline.core;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.AndroidPredicates;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.bitmaps.ArtBitmapFactory;
import com.facebook.imagepipeline.bitmaps.EmptyJpegGenerator;
import com.facebook.imagepipeline.bitmaps.GingerbreadBitmapFactory;
import com.facebook.imagepipeline.bitmaps.HoneycombBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory;
import com.facebook.imagepipeline.cache.MediaVariationsIndex;
import com.facebook.imagepipeline.cache.MediaVariationsIndexDatabase;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.NoOpMediaVariationsIndex;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.platform.ArtDecoder;
import com.facebook.imagepipeline.platform.GingerbreadPurgeableDecoder;
import com.facebook.imagepipeline.platform.KitKatPurgeableDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class ImagePipelineFactory
{
  private static ImagePipelineFactory sInstance = null;
  private AnimatedFactory mAnimatedFactory;
  private CountingMemoryCache<CacheKey, CloseableImage> mBitmapCountingMemoryCache;
  private MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
  private final ImagePipelineConfig mConfig;
  private CountingMemoryCache<CacheKey, PooledByteBuffer> mEncodedCountingMemoryCache;
  private MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
  private ImageDecoder mImageDecoder;
  private ImagePipeline mImagePipeline;
  private BufferedDiskCache mMainBufferedDiskCache;
  private FileCache mMainFileCache;
  private MediaVariationsIndex mMediaVariationsIndex;
  private PlatformBitmapFactory mPlatformBitmapFactory;
  private PlatformDecoder mPlatformDecoder;
  private ProducerFactory mProducerFactory;
  private ProducerSequenceFactory mProducerSequenceFactory;
  private BufferedDiskCache mSmallImageBufferedDiskCache;
  private FileCache mSmallImageFileCache;
  private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

  public ImagePipelineFactory(ImagePipelineConfig paramImagePipelineConfig)
  {
    this.mConfig = ((ImagePipelineConfig)Preconditions.checkNotNull(paramImagePipelineConfig));
    this.mThreadHandoffProducerQueue = new ThreadHandoffProducerQueue(paramImagePipelineConfig.getExecutorSupplier().forLightweightBackgroundTasks());
  }

  public static PlatformBitmapFactory buildPlatformBitmapFactory(PoolFactory paramPoolFactory, PlatformDecoder paramPlatformDecoder)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return new ArtBitmapFactory(paramPoolFactory.getBitmapPool());
    if (Build.VERSION.SDK_INT >= 11)
      return new HoneycombBitmapFactory(new EmptyJpegGenerator(paramPoolFactory.getPooledByteBufferFactory()), paramPlatformDecoder);
    return new GingerbreadBitmapFactory();
  }

  public static PlatformDecoder buildPlatformDecoder(PoolFactory paramPoolFactory, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      int i = paramPoolFactory.getFlexByteArrayPoolMaxNumThreads();
      return new ArtDecoder(paramPoolFactory.getBitmapPool(), i, new Pools.SynchronizedPool(i));
    }
    if ((paramBoolean) && (Build.VERSION.SDK_INT < 19))
      return new GingerbreadPurgeableDecoder();
    return new KitKatPurgeableDecoder(paramPoolFactory.getFlexByteArrayPool());
  }

  private ImageDecoder getImageDecoder()
  {
    if (this.mImageDecoder == null)
    {
      if (this.mConfig.getImageDecoder() == null)
        break label33;
      this.mImageDecoder = this.mConfig.getImageDecoder();
    }
    while (true)
    {
      return this.mImageDecoder;
      label33: if (getAnimatedFactory() != null);
      for (AnimatedImageFactory localAnimatedImageFactory = getAnimatedFactory().getAnimatedImageFactory(); ; localAnimatedImageFactory = null)
      {
        if (this.mConfig.getImageDecoderConfig() != null)
          break label91;
        this.mImageDecoder = new DefaultImageDecoder(localAnimatedImageFactory, getPlatformDecoder(), this.mConfig.getBitmapConfig());
        break;
      }
      label91: this.mImageDecoder = new DefaultImageDecoder(localAnimatedImageFactory, getPlatformDecoder(), this.mConfig.getBitmapConfig(), this.mConfig.getImageDecoderConfig().getCustomImageDecoders());
      ImageFormatChecker.getInstance().setCustomImageFormatCheckers(this.mConfig.getImageDecoderConfig().getCustomImageFormats());
    }
  }

  public static ImagePipelineFactory getInstance()
  {
    return (ImagePipelineFactory)Preconditions.checkNotNull(sInstance, "ImagePipelineFactory was not initialized!");
  }

  private ProducerFactory getProducerFactory()
  {
    if (this.mProducerFactory == null)
      this.mProducerFactory = new ProducerFactory(this.mConfig.getContext(), this.mConfig.getPoolFactory().getSmallByteArrayPool(), getImageDecoder(), this.mConfig.getProgressiveJpegConfig(), this.mConfig.isDownsampleEnabled(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().isDecodeCancellationEnabled(), this.mConfig.getExecutorSupplier(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), getMediaVariationsIndex(), this.mConfig.getExperiments().getMediaIdExtractor(), this.mConfig.getCacheKeyFactory(), getPlatformBitmapFactory(), this.mConfig.getExperiments().getForceSmallCacheThresholdBytes());
    return this.mProducerFactory;
  }

  private ProducerSequenceFactory getProducerSequenceFactory()
  {
    if (this.mProducerSequenceFactory == null)
      this.mProducerSequenceFactory = new ProducerSequenceFactory(getProducerFactory(), this.mConfig.getNetworkFetcher(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().isWebpSupportEnabled(), this.mThreadHandoffProducerQueue, this.mConfig.getExperiments().getUseDownsamplingRatioForResizing());
    return this.mProducerSequenceFactory;
  }

  private BufferedDiskCache getSmallImageBufferedDiskCache()
  {
    if (this.mSmallImageBufferedDiskCache == null)
      this.mSmallImageBufferedDiskCache = new BufferedDiskCache(getSmallImageFileCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
    return this.mSmallImageBufferedDiskCache;
  }

  public static void initialize(Context paramContext)
  {
    initialize(ImagePipelineConfig.newBuilder(paramContext).build());
  }

  public static void initialize(ImagePipelineConfig paramImagePipelineConfig)
  {
    sInstance = new ImagePipelineFactory(paramImagePipelineConfig);
  }

  public static void shutDown()
  {
    if (sInstance != null)
    {
      sInstance.getBitmapMemoryCache().removeAll(AndroidPredicates.True());
      sInstance.getEncodedMemoryCache().removeAll(AndroidPredicates.True());
      sInstance = null;
    }
  }

  public AnimatedFactory getAnimatedFactory()
  {
    if (this.mAnimatedFactory == null)
      this.mAnimatedFactory = AnimatedFactoryProvider.getAnimatedFactory(getPlatformBitmapFactory(), this.mConfig.getExecutorSupplier());
    return this.mAnimatedFactory;
  }

  public CountingMemoryCache<CacheKey, CloseableImage> getBitmapCountingMemoryCache()
  {
    if (this.mBitmapCountingMemoryCache == null)
      this.mBitmapCountingMemoryCache = BitmapCountingMemoryCacheFactory.get(this.mConfig.getBitmapMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry(), getPlatformBitmapFactory(), this.mConfig.getExperiments().isExternalCreatedBitmapLogEnabled());
    return this.mBitmapCountingMemoryCache;
  }

  public MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache()
  {
    if (this.mBitmapMemoryCache == null)
      this.mBitmapMemoryCache = BitmapMemoryCacheFactory.get(getBitmapCountingMemoryCache(), this.mConfig.getImageCacheStatsTracker());
    return this.mBitmapMemoryCache;
  }

  public CountingMemoryCache<CacheKey, PooledByteBuffer> getEncodedCountingMemoryCache()
  {
    if (this.mEncodedCountingMemoryCache == null)
      this.mEncodedCountingMemoryCache = EncodedCountingMemoryCacheFactory.get(this.mConfig.getEncodedMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry(), getPlatformBitmapFactory());
    return this.mEncodedCountingMemoryCache;
  }

  public MemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCache()
  {
    if (this.mEncodedMemoryCache == null)
      this.mEncodedMemoryCache = EncodedMemoryCacheFactory.get(getEncodedCountingMemoryCache(), this.mConfig.getImageCacheStatsTracker());
    return this.mEncodedMemoryCache;
  }

  public ImagePipeline getImagePipeline()
  {
    if (this.mImagePipeline == null)
      this.mImagePipeline = new ImagePipeline(getProducerSequenceFactory(), this.mConfig.getRequestListeners(), this.mConfig.getIsPrefetchEnabledSupplier(), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), this.mConfig.getCacheKeyFactory(), this.mThreadHandoffProducerQueue, Suppliers.of(Boolean.valueOf(false)));
    return this.mImagePipeline;
  }

  public BufferedDiskCache getMainBufferedDiskCache()
  {
    if (this.mMainBufferedDiskCache == null)
      this.mMainBufferedDiskCache = new BufferedDiskCache(getMainFileCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
    return this.mMainBufferedDiskCache;
  }

  public FileCache getMainFileCache()
  {
    if (this.mMainFileCache == null)
    {
      DiskCacheConfig localDiskCacheConfig = this.mConfig.getMainDiskCacheConfig();
      this.mMainFileCache = this.mConfig.getFileCacheFactory().get(localDiskCacheConfig);
    }
    return this.mMainFileCache;
  }

  public MediaVariationsIndex getMediaVariationsIndex()
  {
    if (this.mMediaVariationsIndex == null)
      if (!this.mConfig.getExperiments().getMediaVariationsIndexEnabled())
        break label69;
    label69: for (Object localObject = new MediaVariationsIndexDatabase(this.mConfig.getContext(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite()); ; localObject = new NoOpMediaVariationsIndex())
    {
      this.mMediaVariationsIndex = ((MediaVariationsIndex)localObject);
      return this.mMediaVariationsIndex;
    }
  }

  public PlatformBitmapFactory getPlatformBitmapFactory()
  {
    if (this.mPlatformBitmapFactory == null)
      this.mPlatformBitmapFactory = buildPlatformBitmapFactory(this.mConfig.getPoolFactory(), getPlatformDecoder());
    return this.mPlatformBitmapFactory;
  }

  public PlatformDecoder getPlatformDecoder()
  {
    if (this.mPlatformDecoder == null)
      this.mPlatformDecoder = buildPlatformDecoder(this.mConfig.getPoolFactory(), this.mConfig.getExperiments().isWebpSupportEnabled());
    return this.mPlatformDecoder;
  }

  public FileCache getSmallImageFileCache()
  {
    if (this.mSmallImageFileCache == null)
    {
      DiskCacheConfig localDiskCacheConfig = this.mConfig.getSmallImageDiskCacheConfig();
      this.mSmallImageFileCache = this.mConfig.getFileCacheFactory().get(localDiskCacheConfig);
    }
    return this.mSmallImageFileCache;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.core.ImagePipelineFactory
 * JD-Core Version:    0.6.0
 */
package com.facebook.imagepipeline.core;

import android.net.Uri;
import bolts.Continuation;
import bolts.Task;
import com.android.internal.util.Predicate;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ImagePipeline
{
  private static final CancellationException PREFETCH_EXCEPTION = new CancellationException("Prefetching is not enabled");
  private final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
  private final CacheKeyFactory mCacheKeyFactory;
  private final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
  private AtomicLong mIdCounter = new AtomicLong();
  private final Supplier<Boolean> mIsPrefetchEnabledSupplier;
  private final BufferedDiskCache mMainBufferedDiskCache;
  private final ProducerSequenceFactory mProducerSequenceFactory;
  private final RequestListener mRequestListener;
  private final BufferedDiskCache mSmallImageBufferedDiskCache;
  private final Supplier<Boolean> mSuppressBitmapPrefetchingSupplier;
  private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

  public ImagePipeline(ProducerSequenceFactory paramProducerSequenceFactory, Set<RequestListener> paramSet, Supplier<Boolean> paramSupplier1, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache1, BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, ThreadHandoffProducerQueue paramThreadHandoffProducerQueue, Supplier<Boolean> paramSupplier2)
  {
    this.mProducerSequenceFactory = paramProducerSequenceFactory;
    this.mRequestListener = new ForwardingRequestListener(paramSet);
    this.mIsPrefetchEnabledSupplier = paramSupplier1;
    this.mBitmapMemoryCache = paramMemoryCache;
    this.mEncodedMemoryCache = paramMemoryCache1;
    this.mMainBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mThreadHandoffProducerQueue = paramThreadHandoffProducerQueue;
    this.mSuppressBitmapPrefetchingSupplier = paramSupplier2;
  }

  private String generateUniqueFutureId()
  {
    return String.valueOf(this.mIdCounter.getAndIncrement());
  }

  private RequestListener getRequestListenerForRequest(ImageRequest paramImageRequest)
  {
    if (paramImageRequest.getRequestListener() == null)
      return this.mRequestListener;
    return new ForwardingRequestListener(new RequestListener[] { this.mRequestListener, paramImageRequest.getRequestListener() });
  }

  private Predicate<CacheKey> predicateForUri(Uri paramUri)
  {
    return new Predicate(paramUri)
    {
      public boolean apply(CacheKey paramCacheKey)
      {
        return paramCacheKey.containsUri(this.val$uri);
      }
    };
  }

  private <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> paramProducer, ImageRequest paramImageRequest, ImageRequest.RequestLevel paramRequestLevel, Object paramObject)
  {
    boolean bool = false;
    RequestListener localRequestListener = getRequestListenerForRequest(paramImageRequest);
    while (true)
    {
      try
      {
        paramRequestLevel = ImageRequest.RequestLevel.getMax(paramImageRequest.getLowestPermittedRequestLevel(), paramRequestLevel);
        String str = generateUniqueFutureId();
        if ((!paramImageRequest.getProgressiveRenderingEnabled()) && (paramImageRequest.getMediaVariations() == null) && (UriUtil.isNetworkUri(paramImageRequest.getSourceUri())))
        {
          paramProducer = CloseableProducerToDataSourceAdapter.create(paramProducer, new SettableProducerContext(paramImageRequest, str, localRequestListener, paramObject, paramRequestLevel, false, bool, paramImageRequest.getPriority()), localRequestListener);
          return paramProducer;
        }
      }
      catch (Exception paramProducer)
      {
        return DataSources.immediateFailedDataSource(paramProducer);
      }
      bool = true;
    }
  }

  private DataSource<Void> submitPrefetchRequest(Producer<Void> paramProducer, ImageRequest paramImageRequest, ImageRequest.RequestLevel paramRequestLevel, Object paramObject, Priority paramPriority)
  {
    RequestListener localRequestListener = getRequestListenerForRequest(paramImageRequest);
    try
    {
      paramRequestLevel = ImageRequest.RequestLevel.getMax(paramImageRequest.getLowestPermittedRequestLevel(), paramRequestLevel);
      paramProducer = ProducerToDataSourceAdapter.create(paramProducer, new SettableProducerContext(paramImageRequest, generateUniqueFutureId(), localRequestListener, paramObject, paramRequestLevel, true, false, paramPriority), localRequestListener);
      return paramProducer;
    }
    catch (Exception paramProducer)
    {
    }
    return DataSources.immediateFailedDataSource(paramProducer);
  }

  public void clearCaches()
  {
    clearMemoryCaches();
    clearDiskCaches();
  }

  public void clearDiskCaches()
  {
    this.mMainBufferedDiskCache.clearAll();
    this.mSmallImageBufferedDiskCache.clearAll();
  }

  public void clearMemoryCaches()
  {
    3 local3 = new Predicate()
    {
      public boolean apply(CacheKey paramCacheKey)
      {
        return true;
      }
    };
    this.mBitmapMemoryCache.removeAll(local3);
    this.mEncodedMemoryCache.removeAll(local3);
  }

  public void evictFromCache(Uri paramUri)
  {
    evictFromMemoryCache(paramUri);
    evictFromDiskCache(paramUri);
  }

  public void evictFromDiskCache(Uri paramUri)
  {
    evictFromDiskCache(ImageRequest.fromUri(paramUri));
  }

  public void evictFromDiskCache(ImageRequest paramImageRequest)
  {
    paramImageRequest = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, null);
    this.mMainBufferedDiskCache.remove(paramImageRequest);
    this.mSmallImageBufferedDiskCache.remove(paramImageRequest);
  }

  public void evictFromMemoryCache(Uri paramUri)
  {
    paramUri = predicateForUri(paramUri);
    this.mBitmapMemoryCache.removeAll(paramUri);
    this.mEncodedMemoryCache.removeAll(paramUri);
  }

  public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest paramImageRequest, Object paramObject)
  {
    return fetchDecodedImage(paramImageRequest, paramObject, ImageRequest.RequestLevel.FULL_FETCH);
  }

  public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest paramImageRequest, Object paramObject, ImageRequest.RequestLevel paramRequestLevel)
  {
    try
    {
      paramImageRequest = submitFetchRequest(this.mProducerSequenceFactory.getDecodedImageProducerSequence(paramImageRequest), paramImageRequest, paramRequestLevel, paramObject);
      return paramImageRequest;
    }
    catch (Exception paramImageRequest)
    {
    }
    return DataSources.immediateFailedDataSource(paramImageRequest);
  }

  public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest paramImageRequest, Object paramObject)
  {
    Preconditions.checkNotNull(paramImageRequest.getSourceUri());
    try
    {
      Producer localProducer = this.mProducerSequenceFactory.getEncodedImageProducerSequence(paramImageRequest);
      ImageRequest localImageRequest = paramImageRequest;
      if (paramImageRequest.getResizeOptions() != null)
        localImageRequest = ImageRequestBuilder.fromRequest(paramImageRequest).setResizeOptions(null).build();
      paramImageRequest = submitFetchRequest(localProducer, localImageRequest, ImageRequest.RequestLevel.FULL_FETCH, paramObject);
      return paramImageRequest;
    }
    catch (Exception paramImageRequest)
    {
    }
    return DataSources.immediateFailedDataSource(paramImageRequest);
  }

  public DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache(ImageRequest paramImageRequest, Object paramObject)
  {
    return fetchDecodedImage(paramImageRequest, paramObject, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
  }

  public MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache()
  {
    return this.mBitmapMemoryCache;
  }

  public CacheKeyFactory getCacheKeyFactory()
  {
    return this.mCacheKeyFactory;
  }

  public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(ImageRequest paramImageRequest, Object paramObject, ImageRequest.RequestLevel paramRequestLevel)
  {
    return new Supplier(paramImageRequest, paramObject, paramRequestLevel)
    {
      public DataSource<CloseableReference<CloseableImage>> get()
      {
        return ImagePipeline.this.fetchDecodedImage(this.val$imageRequest, this.val$callerContext, this.val$requestLevel);
      }

      public String toString()
      {
        return Objects.toStringHelper(this).add("uri", this.val$imageRequest.getSourceUri()).toString();
      }
    };
  }

  @Deprecated
  public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(ImageRequest paramImageRequest, Object paramObject, boolean paramBoolean)
  {
    if (paramBoolean);
    for (ImageRequest.RequestLevel localRequestLevel = ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE; ; localRequestLevel = ImageRequest.RequestLevel.FULL_FETCH)
      return getDataSourceSupplier(paramImageRequest, paramObject, localRequestLevel);
  }

  public Supplier<DataSource<CloseableReference<PooledByteBuffer>>> getEncodedImageDataSourceSupplier(ImageRequest paramImageRequest, Object paramObject)
  {
    return new Supplier(paramImageRequest, paramObject)
    {
      public DataSource<CloseableReference<PooledByteBuffer>> get()
      {
        return ImagePipeline.this.fetchEncodedImage(this.val$imageRequest, this.val$callerContext);
      }

      public String toString()
      {
        return Objects.toStringHelper(this).add("uri", this.val$imageRequest.getSourceUri()).toString();
      }
    };
  }

  public boolean isInBitmapMemoryCache(Uri paramUri)
  {
    if (paramUri == null)
      return false;
    paramUri = predicateForUri(paramUri);
    return this.mBitmapMemoryCache.contains(paramUri);
  }

  public boolean isInBitmapMemoryCache(ImageRequest paramImageRequest)
  {
    if (paramImageRequest == null)
      return false;
    paramImageRequest = this.mCacheKeyFactory.getBitmapCacheKey(paramImageRequest, null);
    paramImageRequest = this.mBitmapMemoryCache.get(paramImageRequest);
    try
    {
      boolean bool = CloseableReference.isValid(paramImageRequest);
      return bool;
    }
    finally
    {
      CloseableReference.closeSafely(paramImageRequest);
    }
    throw localObject;
  }

  public DataSource<Boolean> isInDiskCache(Uri paramUri)
  {
    return isInDiskCache(ImageRequest.fromUri(paramUri));
  }

  public DataSource<Boolean> isInDiskCache(ImageRequest paramImageRequest)
  {
    paramImageRequest = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, null);
    SimpleDataSource localSimpleDataSource = SimpleDataSource.create();
    this.mMainBufferedDiskCache.contains(paramImageRequest).continueWithTask(new Continuation(paramImageRequest)
    {
      public Task<Boolean> then(Task<Boolean> paramTask)
        throws Exception
      {
        if ((!paramTask.isCancelled()) && (!paramTask.isFaulted()) && (((Boolean)paramTask.getResult()).booleanValue()))
          return Task.forResult(Boolean.valueOf(true));
        return ImagePipeline.this.mSmallImageBufferedDiskCache.contains(this.val$cacheKey);
      }
    }).continueWith(new Continuation(localSimpleDataSource)
    {
      public Void then(Task<Boolean> paramTask)
        throws Exception
      {
        SimpleDataSource localSimpleDataSource = this.val$dataSource;
        if ((!paramTask.isCancelled()) && (!paramTask.isFaulted()) && (((Boolean)paramTask.getResult()).booleanValue()));
        for (boolean bool = true; ; bool = false)
        {
          localSimpleDataSource.setResult(Boolean.valueOf(bool));
          return null;
        }
      }
    });
    return localSimpleDataSource;
  }

  public boolean isInDiskCacheSync(Uri paramUri)
  {
    return (isInDiskCacheSync(paramUri, ImageRequest.CacheChoice.SMALL)) || (isInDiskCacheSync(paramUri, ImageRequest.CacheChoice.DEFAULT));
  }

  public boolean isInDiskCacheSync(Uri paramUri, ImageRequest.CacheChoice paramCacheChoice)
  {
    return isInDiskCacheSync(ImageRequestBuilder.newBuilderWithSource(paramUri).setCacheChoice(paramCacheChoice).build());
  }

  public boolean isInDiskCacheSync(ImageRequest paramImageRequest)
  {
    CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, null);
    paramImageRequest = paramImageRequest.getCacheChoice();
    switch (7.$SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice[paramImageRequest.ordinal()])
    {
    default:
      return false;
    case 1:
      return this.mMainBufferedDiskCache.diskCheckSync(localCacheKey);
    case 2:
    }
    return this.mSmallImageBufferedDiskCache.diskCheckSync(localCacheKey);
  }

  public boolean isPaused()
  {
    return this.mThreadHandoffProducerQueue.isQueueing();
  }

  public void pause()
  {
    this.mThreadHandoffProducerQueue.startQueueing();
  }

  public DataSource<Void> prefetchToBitmapCache(ImageRequest paramImageRequest, Object paramObject)
  {
    if (!((Boolean)this.mIsPrefetchEnabledSupplier.get()).booleanValue())
      return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
    try
    {
      if (((Boolean)this.mSuppressBitmapPrefetchingSupplier.get()).booleanValue());
      for (Producer localProducer = this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(paramImageRequest); ; localProducer = this.mProducerSequenceFactory.getDecodedImagePrefetchProducerSequence(paramImageRequest))
        return submitPrefetchRequest(localProducer, paramImageRequest, ImageRequest.RequestLevel.FULL_FETCH, paramObject, Priority.MEDIUM);
    }
    catch (Exception paramImageRequest)
    {
    }
    return DataSources.immediateFailedDataSource(paramImageRequest);
  }

  public DataSource<Void> prefetchToDiskCache(ImageRequest paramImageRequest, Object paramObject)
  {
    return prefetchToDiskCache(paramImageRequest, paramObject, Priority.MEDIUM);
  }

  public DataSource<Void> prefetchToDiskCache(ImageRequest paramImageRequest, Object paramObject, Priority paramPriority)
  {
    if (!((Boolean)this.mIsPrefetchEnabledSupplier.get()).booleanValue())
      return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
    try
    {
      paramImageRequest = submitPrefetchRequest(this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(paramImageRequest), paramImageRequest, ImageRequest.RequestLevel.FULL_FETCH, paramObject, paramPriority);
      return paramImageRequest;
    }
    catch (Exception paramImageRequest)
    {
    }
    return DataSources.immediateFailedDataSource(paramImageRequest);
  }

  public void resume()
  {
    this.mThreadHandoffProducerQueue.stopQueuing();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.core.ImagePipeline
 * JD-Core Version:    0.6.0
 */
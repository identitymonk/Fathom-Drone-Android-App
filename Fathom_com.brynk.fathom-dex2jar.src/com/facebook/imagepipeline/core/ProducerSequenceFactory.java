package com.facebook.imagepipeline.core;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.Producer<Lcom.facebook.imagepipeline.image.EncodedImage;>;
import com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.HashMap;
import java.util.Map;

public class ProducerSequenceFactory
{

  @VisibleForTesting
  Producer<EncodedImage> mBackgroundLocalFileFetchToEncodedMemorySequence;

  @VisibleForTesting
  Producer<EncodedImage> mBackgroundNetworkFetchToEncodedMemorySequence;

  @VisibleForTesting
  Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> mCloseableImagePrefetchSequences;
  private Producer<EncodedImage> mCommonNetworkFetchToEncodedMemorySequence;

  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mDataFetchSequence;

  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalAssetFetchSequence;

  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalContentUriFetchSequence;

  @VisibleForTesting
  Producer<CloseableReference<PooledByteBuffer>> mLocalFileEncodedImageProducerSequence;

  @VisibleForTesting
  Producer<Void> mLocalFileFetchToEncodedMemoryPrefetchSequence;

  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalImageFileFetchSequence;

  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalResourceFetchSequence;

  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mLocalVideoFileFetchSequence;

  @VisibleForTesting
  Producer<CloseableReference<PooledByteBuffer>> mNetworkEncodedImageProducerSequence;

  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mNetworkFetchSequence;

  @VisibleForTesting
  Producer<Void> mNetworkFetchToEncodedMemoryPrefetchSequence;
  private final NetworkFetcher mNetworkFetcher;

  @VisibleForTesting
  Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> mPostprocessorSequences;
  private final ProducerFactory mProducerFactory;

  @VisibleForTesting
  Producer<CloseableReference<CloseableImage>> mQualifiedResourceFetchSequence;
  private final boolean mResizeAndRotateEnabledForNetwork;
  private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;
  private final boolean mUseDownsamplingRatio;
  private final boolean mWebpSupportEnabled;

  public ProducerSequenceFactory(ProducerFactory paramProducerFactory, NetworkFetcher paramNetworkFetcher, boolean paramBoolean1, boolean paramBoolean2, ThreadHandoffProducerQueue paramThreadHandoffProducerQueue, boolean paramBoolean3)
  {
    this.mProducerFactory = paramProducerFactory;
    this.mNetworkFetcher = paramNetworkFetcher;
    this.mResizeAndRotateEnabledForNetwork = paramBoolean1;
    this.mWebpSupportEnabled = paramBoolean2;
    this.mPostprocessorSequences = new HashMap();
    this.mCloseableImagePrefetchSequences = new HashMap();
    this.mThreadHandoffProducerQueue = paramThreadHandoffProducerQueue;
    this.mUseDownsamplingRatio = paramBoolean3;
  }

  private Producer<EncodedImage> getBackgroundLocalFileFetchToEncodeMemorySequence()
  {
    monitorenter;
    try
    {
      if (this.mBackgroundLocalFileFetchToEncodedMemorySequence == null)
      {
        localProducer = newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newLocalFileFetchProducer());
        this.mBackgroundLocalFileFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(localProducer, this.mThreadHandoffProducerQueue);
      }
      Producer localProducer = this.mBackgroundLocalFileFetchToEncodedMemorySequence;
      return localProducer;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private Producer<EncodedImage> getBackgroundNetworkFetchToEncodedMemorySequence()
  {
    monitorenter;
    try
    {
      if (this.mBackgroundNetworkFetchToEncodedMemorySequence == null)
        this.mBackgroundNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(getCommonNetworkFetchToEncodedMemorySequence(), this.mThreadHandoffProducerQueue);
      Producer localProducer = this.mBackgroundNetworkFetchToEncodedMemorySequence;
      return localProducer;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private Producer<CloseableReference<CloseableImage>> getBasicDecodedImageSequence(ImageRequest paramImageRequest)
  {
    Preconditions.checkNotNull(paramImageRequest);
    Uri localUri = paramImageRequest.getSourceUri();
    Preconditions.checkNotNull(localUri, "Uri is null.");
    switch (paramImageRequest.getSourceUriType())
    {
    case 1:
    default:
      throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + getShortenedUriString(localUri));
    case 0:
      return getNetworkFetchSequence();
    case 2:
      return getLocalVideoFileFetchSequence();
    case 3:
      return getLocalImageFileFetchSequence();
    case 4:
      return getLocalContentUriFetchSequence();
    case 5:
      return getLocalAssetFetchSequence();
    case 6:
      return getLocalResourceFetchSequence();
    case 8:
      return getQualifiedResourceFetchSequence();
    case 7:
    }
    return getDataFetchSequence();
  }

  private Producer<EncodedImage> getCommonNetworkFetchToEncodedMemorySequence()
  {
    monitorenter;
    try
    {
      if (this.mCommonNetworkFetchToEncodedMemorySequence == null)
      {
        this.mCommonNetworkFetchToEncodedMemorySequence = ProducerFactory.newAddImageTransformMetaDataProducer(newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newNetworkFetchProducer(this.mNetworkFetcher)));
        this.mCommonNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newResizeAndRotateProducer(this.mCommonNetworkFetchToEncodedMemorySequence, this.mResizeAndRotateEnabledForNetwork, this.mUseDownsamplingRatio);
      }
      Producer localProducer = this.mCommonNetworkFetchToEncodedMemorySequence;
      return localProducer;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private Producer<CloseableReference<CloseableImage>> getDataFetchSequence()
  {
    monitorenter;
    try
    {
      if (this.mDataFetchSequence == null)
      {
        Object localObject3 = this.mProducerFactory.newDataFetchProducer();
        localObject1 = localObject3;
        if (WebpSupportStatus.sIsWebpSupportRequired)
          if (this.mWebpSupportEnabled)
          {
            localObject1 = localObject3;
            if (WebpSupportStatus.sWebpBitmapFactory != null);
          }
          else
          {
            localObject1 = this.mProducerFactory.newWebpTranscodeProducer((Producer)localObject3);
          }
        localObject3 = this.mProducerFactory;
        localObject1 = ProducerFactory.newAddImageTransformMetaDataProducer((Producer)localObject1);
        this.mDataFetchSequence = newBitmapCacheGetToDecodeSequence(this.mProducerFactory.newResizeAndRotateProducer((Producer)localObject1, true, this.mUseDownsamplingRatio));
      }
      Object localObject1 = this.mDataFetchSequence;
      return localObject1;
    }
    finally
    {
      monitorexit;
    }
    throw localObject2;
  }

  private Producer<Void> getDecodedImagePrefetchSequence(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    monitorenter;
    try
    {
      if (!this.mCloseableImagePrefetchSequences.containsKey(paramProducer))
      {
        Object localObject = this.mProducerFactory;
        localObject = ProducerFactory.newSwallowResultProducer(paramProducer);
        this.mCloseableImagePrefetchSequences.put(paramProducer, localObject);
      }
      paramProducer = (Producer)this.mCloseableImagePrefetchSequences.get(paramProducer);
      return paramProducer;
    }
    finally
    {
      monitorexit;
    }
    throw paramProducer;
  }

  private Producer<CloseableReference<CloseableImage>> getLocalAssetFetchSequence()
  {
    monitorenter;
    try
    {
      if (this.mLocalAssetFetchSequence == null)
        this.mLocalAssetFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalAssetFetchProducer());
      Producer localProducer = this.mLocalAssetFetchSequence;
      return localProducer;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private Producer<CloseableReference<CloseableImage>> getLocalContentUriFetchSequence()
  {
    monitorenter;
    try
    {
      if (this.mLocalContentUriFetchSequence == null)
        this.mLocalContentUriFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalContentUriFetchProducer(), new ThumbnailProducer[] { this.mProducerFactory.newLocalContentUriThumbnailFetchProducer(), this.mProducerFactory.newLocalExifThumbnailProducer() });
      Producer localProducer = this.mLocalContentUriFetchSequence;
      return localProducer;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private Producer<Void> getLocalFileFetchToEncodedMemoryPrefetchSequence()
  {
    monitorenter;
    try
    {
      if (this.mLocalFileFetchToEncodedMemoryPrefetchSequence == null)
        this.mLocalFileFetchToEncodedMemoryPrefetchSequence = ProducerFactory.newSwallowResultProducer(getBackgroundLocalFileFetchToEncodeMemorySequence());
      Producer localProducer = this.mLocalFileFetchToEncodedMemoryPrefetchSequence;
      return localProducer;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private Producer<CloseableReference<CloseableImage>> getLocalImageFileFetchSequence()
  {
    monitorenter;
    try
    {
      if (this.mLocalImageFileFetchSequence == null)
        this.mLocalImageFileFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalFileFetchProducer());
      Producer localProducer = this.mLocalImageFileFetchSequence;
      return localProducer;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private Producer<CloseableReference<CloseableImage>> getLocalResourceFetchSequence()
  {
    monitorenter;
    try
    {
      if (this.mLocalResourceFetchSequence == null)
        this.mLocalResourceFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalResourceFetchProducer());
      Producer localProducer = this.mLocalResourceFetchSequence;
      return localProducer;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private Producer<CloseableReference<CloseableImage>> getLocalVideoFileFetchSequence()
  {
    monitorenter;
    try
    {
      if (this.mLocalVideoFileFetchSequence == null)
        this.mLocalVideoFileFetchSequence = newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newLocalVideoThumbnailProducer());
      Producer localProducer = this.mLocalVideoFileFetchSequence;
      return localProducer;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private Producer<CloseableReference<CloseableImage>> getNetworkFetchSequence()
  {
    monitorenter;
    try
    {
      if (this.mNetworkFetchSequence == null)
        this.mNetworkFetchSequence = newBitmapCacheGetToDecodeSequence(getCommonNetworkFetchToEncodedMemorySequence());
      Producer localProducer = this.mNetworkFetchSequence;
      return localProducer;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private Producer<Void> getNetworkFetchToEncodedMemoryPrefetchSequence()
  {
    monitorenter;
    try
    {
      if (this.mNetworkFetchToEncodedMemoryPrefetchSequence == null)
        this.mNetworkFetchToEncodedMemoryPrefetchSequence = ProducerFactory.newSwallowResultProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
      Producer localProducer = this.mNetworkFetchToEncodedMemoryPrefetchSequence;
      return localProducer;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private Producer<CloseableReference<CloseableImage>> getPostprocessorSequence(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    monitorenter;
    try
    {
      if (!this.mPostprocessorSequences.containsKey(paramProducer))
      {
        Object localObject = this.mProducerFactory.newPostprocessorProducer(paramProducer);
        localObject = this.mProducerFactory.newPostprocessorBitmapMemoryCacheProducer((Producer)localObject);
        this.mPostprocessorSequences.put(paramProducer, localObject);
      }
      paramProducer = (Producer)this.mPostprocessorSequences.get(paramProducer);
      return paramProducer;
    }
    finally
    {
      monitorexit;
    }
    throw paramProducer;
  }

  private Producer<CloseableReference<CloseableImage>> getQualifiedResourceFetchSequence()
  {
    monitorenter;
    try
    {
      if (this.mQualifiedResourceFetchSequence == null)
        this.mQualifiedResourceFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newQualifiedResourceFetchProducer());
      Producer localProducer = this.mQualifiedResourceFetchSequence;
      return localProducer;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private static String getShortenedUriString(Uri paramUri)
  {
    String str = String.valueOf(paramUri);
    paramUri = str;
    if (str.length() > 30)
      paramUri = str.substring(0, 30) + "...";
    return paramUri;
  }

  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToBitmapCacheSequence(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    paramProducer = this.mProducerFactory.newBitmapMemoryCacheProducer(paramProducer);
    paramProducer = this.mProducerFactory.newBitmapMemoryCacheKeyMultiplexProducer(paramProducer);
    paramProducer = this.mProducerFactory.newBackgroundThreadHandoffProducer(paramProducer, this.mThreadHandoffProducerQueue);
    return this.mProducerFactory.newBitmapMemoryCacheGetProducer(paramProducer);
  }

  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToDecodeSequence(Producer<EncodedImage> paramProducer)
  {
    return newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newDecodeProducer(paramProducer));
  }

  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> paramProducer)
  {
    return newBitmapCacheGetToLocalTransformSequence(paramProducer, new ThumbnailProducer[] { this.mProducerFactory.newLocalExifThumbnailProducer() });
  }

  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> paramProducer, ThumbnailProducer<EncodedImage>[] paramArrayOfThumbnailProducer)
  {
    return newBitmapCacheGetToDecodeSequence(newLocalTransformationsSequence(newEncodedCacheMultiplexToTranscodeSequence(paramProducer), paramArrayOfThumbnailProducer));
  }

  private Producer<EncodedImage> newDiskCacheSequence(Producer<EncodedImage> paramProducer)
  {
    paramProducer = this.mProducerFactory.newDiskCacheWriteProducer(paramProducer);
    paramProducer = this.mProducerFactory.newMediaVariationsProducer(paramProducer);
    return this.mProducerFactory.newDiskCacheReadProducer(paramProducer);
  }

  private Producer<EncodedImage> newEncodedCacheMultiplexToTranscodeSequence(Producer<EncodedImage> paramProducer)
  {
    Object localObject = paramProducer;
    if (WebpSupportStatus.sIsWebpSupportRequired)
      if (this.mWebpSupportEnabled)
      {
        localObject = paramProducer;
        if (WebpSupportStatus.sWebpBitmapFactory != null);
      }
      else
      {
        localObject = this.mProducerFactory.newWebpTranscodeProducer(paramProducer);
      }
    paramProducer = newDiskCacheSequence((Producer)localObject);
    paramProducer = this.mProducerFactory.newEncodedMemoryCacheProducer(paramProducer);
    return (Producer<EncodedImage>)this.mProducerFactory.newEncodedCacheKeyMultiplexProducer(paramProducer);
  }

  private Producer<EncodedImage> newLocalThumbnailProducer(ThumbnailProducer<EncodedImage>[] paramArrayOfThumbnailProducer)
  {
    paramArrayOfThumbnailProducer = this.mProducerFactory.newThumbnailBranchProducer(paramArrayOfThumbnailProducer);
    return this.mProducerFactory.newResizeAndRotateProducer(paramArrayOfThumbnailProducer, true, this.mUseDownsamplingRatio);
  }

  private Producer<EncodedImage> newLocalTransformationsSequence(Producer<EncodedImage> paramProducer, ThumbnailProducer<EncodedImage>[] paramArrayOfThumbnailProducer)
  {
    paramProducer = ProducerFactory.newAddImageTransformMetaDataProducer(paramProducer);
    paramProducer = this.mProducerFactory.newResizeAndRotateProducer(paramProducer, true, this.mUseDownsamplingRatio);
    paramProducer = this.mProducerFactory.newThrottlingProducer(paramProducer);
    ProducerFactory localProducerFactory = this.mProducerFactory;
    return ProducerFactory.newBranchOnSeparateImagesProducer(newLocalThumbnailProducer(paramArrayOfThumbnailProducer), paramProducer);
  }

  private static void validateEncodedImageRequest(ImageRequest paramImageRequest)
  {
    Preconditions.checkNotNull(paramImageRequest);
    if (paramImageRequest.getLowestPermittedRequestLevel().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return;
    }
  }

  public Producer<Void> getDecodedImagePrefetchProducerSequence(ImageRequest paramImageRequest)
  {
    return getDecodedImagePrefetchSequence(getBasicDecodedImageSequence(paramImageRequest));
  }

  public Producer<CloseableReference<CloseableImage>> getDecodedImageProducerSequence(ImageRequest paramImageRequest)
  {
    Producer localProducer2 = getBasicDecodedImageSequence(paramImageRequest);
    Producer localProducer1 = localProducer2;
    if (paramImageRequest.getPostprocessor() != null)
      localProducer1 = getPostprocessorSequence(localProducer2);
    return localProducer1;
  }

  public Producer<Void> getEncodedImagePrefetchProducerSequence(ImageRequest paramImageRequest)
  {
    validateEncodedImageRequest(paramImageRequest);
    switch (paramImageRequest.getSourceUriType())
    {
    case 1:
    default:
      paramImageRequest = paramImageRequest.getSourceUri();
      throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + getShortenedUriString(paramImageRequest));
    case 0:
      return getNetworkFetchToEncodedMemoryPrefetchSequence();
    case 2:
    case 3:
    }
    return getLocalFileFetchToEncodedMemoryPrefetchSequence();
  }

  public Producer<CloseableReference<PooledByteBuffer>> getEncodedImageProducerSequence(ImageRequest paramImageRequest)
  {
    validateEncodedImageRequest(paramImageRequest);
    Uri localUri = paramImageRequest.getSourceUri();
    switch (paramImageRequest.getSourceUriType())
    {
    case 1:
    default:
      throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + getShortenedUriString(localUri));
    case 0:
      return getNetworkFetchEncodedImageProducerSequence();
    case 2:
    case 3:
    }
    return getLocalFileFetchEncodedImageProducerSequence();
  }

  public Producer<CloseableReference<PooledByteBuffer>> getLocalFileFetchEncodedImageProducerSequence()
  {
    monitorenter;
    try
    {
      if (this.mLocalFileEncodedImageProducerSequence == null)
        this.mLocalFileEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundLocalFileFetchToEncodeMemorySequence());
      return this.mLocalFileEncodedImageProducerSequence;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public Producer<CloseableReference<PooledByteBuffer>> getNetworkFetchEncodedImageProducerSequence()
  {
    monitorenter;
    try
    {
      if (this.mNetworkEncodedImageProducerSequence == null)
        this.mNetworkEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
      return this.mNetworkEncodedImageProducerSequence;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.core.ProducerSequenceFactory
 * JD-Core Version:    0.6.0
 */
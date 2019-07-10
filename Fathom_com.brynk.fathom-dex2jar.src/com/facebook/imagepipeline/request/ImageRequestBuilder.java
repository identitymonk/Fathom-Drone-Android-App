package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineConfig.DefaultImageRequestConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import javax.annotation.Nullable;

public class ImageRequestBuilder
{
  private ImageRequest.CacheChoice mCacheChoice = ImageRequest.CacheChoice.DEFAULT;
  private boolean mDiskCacheEnabled = true;
  private ImageDecodeOptions mImageDecodeOptions = ImageDecodeOptions.defaults();
  private boolean mLocalThumbnailPreviewsEnabled = false;
  private ImageRequest.RequestLevel mLowestPermittedRequestLevel = ImageRequest.RequestLevel.FULL_FETCH;

  @Nullable
  private MediaVariations mMediaVariations = null;

  @Nullable
  private Postprocessor mPostprocessor = null;
  private boolean mProgressiveRenderingEnabled = ImagePipelineConfig.getDefaultImageRequestConfig().isProgressiveRenderingEnabled();

  @Nullable
  private RequestListener mRequestListener;
  private Priority mRequestPriority = Priority.HIGH;

  @Nullable
  private ResizeOptions mResizeOptions = null;

  @Nullable
  private RotationOptions mRotationOptions = null;
  private Uri mSourceUri = null;

  public static ImageRequestBuilder fromRequest(ImageRequest paramImageRequest)
  {
    return newBuilderWithSource(paramImageRequest.getSourceUri()).setImageDecodeOptions(paramImageRequest.getImageDecodeOptions()).setCacheChoice(paramImageRequest.getCacheChoice()).setLocalThumbnailPreviewsEnabled(paramImageRequest.getLocalThumbnailPreviewsEnabled()).setLowestPermittedRequestLevel(paramImageRequest.getLowestPermittedRequestLevel()).setMediaVariations(paramImageRequest.getMediaVariations()).setPostprocessor(paramImageRequest.getPostprocessor()).setProgressiveRenderingEnabled(paramImageRequest.getProgressiveRenderingEnabled()).setRequestPriority(paramImageRequest.getPriority()).setResizeOptions(paramImageRequest.getResizeOptions()).setRequestListener(paramImageRequest.getRequestListener()).setRotationOptions(paramImageRequest.getRotationOptions());
  }

  public static ImageRequestBuilder newBuilderWithResourceId(int paramInt)
  {
    return newBuilderWithSource(UriUtil.getUriForResourceId(paramInt));
  }

  public static ImageRequestBuilder newBuilderWithSource(Uri paramUri)
  {
    return new ImageRequestBuilder().setSource(paramUri);
  }

  public ImageRequest build()
  {
    validate();
    return new ImageRequest(this);
  }

  public ImageRequestBuilder disableDiskCache()
  {
    this.mDiskCacheEnabled = false;
    return this;
  }

  public ImageRequest.CacheChoice getCacheChoice()
  {
    return this.mCacheChoice;
  }

  public ImageDecodeOptions getImageDecodeOptions()
  {
    return this.mImageDecodeOptions;
  }

  public ImageRequest.RequestLevel getLowestPermittedRequestLevel()
  {
    return this.mLowestPermittedRequestLevel;
  }

  @Nullable
  public MediaVariations getMediaVariations()
  {
    return this.mMediaVariations;
  }

  @Nullable
  public Postprocessor getPostprocessor()
  {
    return this.mPostprocessor;
  }

  @Nullable
  public RequestListener getRequestListener()
  {
    return this.mRequestListener;
  }

  public Priority getRequestPriority()
  {
    return this.mRequestPriority;
  }

  @Nullable
  public ResizeOptions getResizeOptions()
  {
    return this.mResizeOptions;
  }

  @Nullable
  public RotationOptions getRotationOptions()
  {
    return this.mRotationOptions;
  }

  public Uri getSourceUri()
  {
    return this.mSourceUri;
  }

  public boolean isDiskCacheEnabled()
  {
    return (this.mDiskCacheEnabled) && (UriUtil.isNetworkUri(this.mSourceUri));
  }

  public boolean isLocalThumbnailPreviewsEnabled()
  {
    return this.mLocalThumbnailPreviewsEnabled;
  }

  public boolean isProgressiveRenderingEnabled()
  {
    return this.mProgressiveRenderingEnabled;
  }

  @Deprecated
  public ImageRequestBuilder setAutoRotateEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
      return setRotationOptions(RotationOptions.autoRotate());
    return setRotationOptions(RotationOptions.disableRotation());
  }

  public ImageRequestBuilder setCacheChoice(ImageRequest.CacheChoice paramCacheChoice)
  {
    this.mCacheChoice = paramCacheChoice;
    return this;
  }

  public ImageRequestBuilder setImageDecodeOptions(ImageDecodeOptions paramImageDecodeOptions)
  {
    this.mImageDecodeOptions = paramImageDecodeOptions;
    return this;
  }

  public ImageRequestBuilder setLocalThumbnailPreviewsEnabled(boolean paramBoolean)
  {
    this.mLocalThumbnailPreviewsEnabled = paramBoolean;
    return this;
  }

  public ImageRequestBuilder setLowestPermittedRequestLevel(ImageRequest.RequestLevel paramRequestLevel)
  {
    this.mLowestPermittedRequestLevel = paramRequestLevel;
    return this;
  }

  public ImageRequestBuilder setMediaVariations(MediaVariations paramMediaVariations)
  {
    this.mMediaVariations = paramMediaVariations;
    return this;
  }

  public ImageRequestBuilder setMediaVariationsForMediaId(String paramString)
  {
    return setMediaVariations(MediaVariations.forMediaId(paramString));
  }

  public ImageRequestBuilder setPostprocessor(Postprocessor paramPostprocessor)
  {
    this.mPostprocessor = paramPostprocessor;
    return this;
  }

  public ImageRequestBuilder setProgressiveRenderingEnabled(boolean paramBoolean)
  {
    this.mProgressiveRenderingEnabled = paramBoolean;
    return this;
  }

  public ImageRequestBuilder setRequestListener(RequestListener paramRequestListener)
  {
    this.mRequestListener = paramRequestListener;
    return this;
  }

  public ImageRequestBuilder setRequestPriority(Priority paramPriority)
  {
    this.mRequestPriority = paramPriority;
    return this;
  }

  public ImageRequestBuilder setResizeOptions(@Nullable ResizeOptions paramResizeOptions)
  {
    this.mResizeOptions = paramResizeOptions;
    return this;
  }

  public ImageRequestBuilder setRotationOptions(@Nullable RotationOptions paramRotationOptions)
  {
    this.mRotationOptions = paramRotationOptions;
    return this;
  }

  public ImageRequestBuilder setSource(Uri paramUri)
  {
    Preconditions.checkNotNull(paramUri);
    this.mSourceUri = paramUri;
    return this;
  }

  protected void validate()
  {
    if (this.mSourceUri == null)
      throw new BuilderException("Source must be set!");
    if (UriUtil.isLocalResourceUri(this.mSourceUri))
    {
      if (!this.mSourceUri.isAbsolute())
        throw new BuilderException("Resource URI path must be absolute.");
      if (this.mSourceUri.getPath().isEmpty())
        throw new BuilderException("Resource URI must not be empty");
    }
    try
    {
      Integer.parseInt(this.mSourceUri.getPath().substring(1));
      if ((UriUtil.isLocalAssetUri(this.mSourceUri)) && (!this.mSourceUri.isAbsolute()))
        throw new BuilderException("Asset URI path must be absolute.");
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new BuilderException("Resource URI path must be a resource id.");
    }
  }

  public static class BuilderException extends RuntimeException
  {
    public BuilderException(String paramString)
    {
      super();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.request.ImageRequestBuilder
 * JD-Core Version:    0.6.0
 */
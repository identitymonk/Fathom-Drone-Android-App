package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.listener.RequestListener;
import java.io.File;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class ImageRequest
{
  private final CacheChoice mCacheChoice;
  private final ImageDecodeOptions mImageDecodeOptions;
  private final boolean mIsDiskCacheEnabled;
  private final boolean mLocalThumbnailPreviewsEnabled;
  private final RequestLevel mLowestPermittedRequestLevel;

  @Nullable
  private final MediaVariations mMediaVariations;
  private final Postprocessor mPostprocessor;
  private final boolean mProgressiveRenderingEnabled;

  @Nullable
  private final RequestListener mRequestListener;
  private final Priority mRequestPriority;

  @Nullable
  private final ResizeOptions mResizeOptions;
  private final RotationOptions mRotationOptions;
  private File mSourceFile;
  private final Uri mSourceUri;
  private final int mSourceUriType;

  protected ImageRequest(ImageRequestBuilder paramImageRequestBuilder)
  {
    this.mCacheChoice = paramImageRequestBuilder.getCacheChoice();
    this.mSourceUri = paramImageRequestBuilder.getSourceUri();
    this.mSourceUriType = getSourceUriType(this.mSourceUri);
    this.mMediaVariations = paramImageRequestBuilder.getMediaVariations();
    this.mProgressiveRenderingEnabled = paramImageRequestBuilder.isProgressiveRenderingEnabled();
    this.mLocalThumbnailPreviewsEnabled = paramImageRequestBuilder.isLocalThumbnailPreviewsEnabled();
    this.mImageDecodeOptions = paramImageRequestBuilder.getImageDecodeOptions();
    this.mResizeOptions = paramImageRequestBuilder.getResizeOptions();
    if (paramImageRequestBuilder.getRotationOptions() == null);
    for (RotationOptions localRotationOptions = RotationOptions.autoRotate(); ; localRotationOptions = paramImageRequestBuilder.getRotationOptions())
    {
      this.mRotationOptions = localRotationOptions;
      this.mRequestPriority = paramImageRequestBuilder.getRequestPriority();
      this.mLowestPermittedRequestLevel = paramImageRequestBuilder.getLowestPermittedRequestLevel();
      this.mIsDiskCacheEnabled = paramImageRequestBuilder.isDiskCacheEnabled();
      this.mPostprocessor = paramImageRequestBuilder.getPostprocessor();
      this.mRequestListener = paramImageRequestBuilder.getRequestListener();
      return;
    }
  }

  public static ImageRequest fromFile(@Nullable File paramFile)
  {
    if (paramFile == null)
      return null;
    return fromUri(UriUtil.getUriForFile(paramFile));
  }

  public static ImageRequest fromUri(@Nullable Uri paramUri)
  {
    if (paramUri == null)
      return null;
    return ImageRequestBuilder.newBuilderWithSource(paramUri).build();
  }

  public static ImageRequest fromUri(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return null;
    return fromUri(Uri.parse(paramString));
  }

  private static int getSourceUriType(Uri paramUri)
  {
    if (paramUri == null);
    do
    {
      return -1;
      if (UriUtil.isNetworkUri(paramUri))
        return 0;
      if (UriUtil.isLocalFileUri(paramUri))
      {
        if (MediaUtils.isVideo(MediaUtils.extractMime(paramUri.getPath())))
          return 2;
        return 3;
      }
      if (UriUtil.isLocalContentUri(paramUri))
        return 4;
      if (UriUtil.isLocalAssetUri(paramUri))
        return 5;
      if (UriUtil.isLocalResourceUri(paramUri))
        return 6;
      if (UriUtil.isDataUri(paramUri))
        return 7;
    }
    while (!UriUtil.isQualifiedResourceUri(paramUri));
    return 8;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ImageRequest));
    do
    {
      return false;
      paramObject = (ImageRequest)paramObject;
    }
    while ((!Objects.equal(this.mSourceUri, paramObject.mSourceUri)) || (!Objects.equal(this.mCacheChoice, paramObject.mCacheChoice)) || (!Objects.equal(this.mMediaVariations, paramObject.mMediaVariations)) || (!Objects.equal(this.mSourceFile, paramObject.mSourceFile)));
    return true;
  }

  @Deprecated
  public boolean getAutoRotateEnabled()
  {
    return this.mRotationOptions.useImageMetadata();
  }

  public CacheChoice getCacheChoice()
  {
    return this.mCacheChoice;
  }

  public ImageDecodeOptions getImageDecodeOptions()
  {
    return this.mImageDecodeOptions;
  }

  public boolean getLocalThumbnailPreviewsEnabled()
  {
    return this.mLocalThumbnailPreviewsEnabled;
  }

  public RequestLevel getLowestPermittedRequestLevel()
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

  public int getPreferredHeight()
  {
    if (this.mResizeOptions != null)
      return this.mResizeOptions.height;
    return 2048;
  }

  public int getPreferredWidth()
  {
    if (this.mResizeOptions != null)
      return this.mResizeOptions.width;
    return 2048;
  }

  public Priority getPriority()
  {
    return this.mRequestPriority;
  }

  public boolean getProgressiveRenderingEnabled()
  {
    return this.mProgressiveRenderingEnabled;
  }

  @Nullable
  public RequestListener getRequestListener()
  {
    return this.mRequestListener;
  }

  @Nullable
  public ResizeOptions getResizeOptions()
  {
    return this.mResizeOptions;
  }

  public RotationOptions getRotationOptions()
  {
    return this.mRotationOptions;
  }

  public File getSourceFile()
  {
    monitorenter;
    try
    {
      if (this.mSourceFile == null)
        this.mSourceFile = new File(this.mSourceUri.getPath());
      File localFile = this.mSourceFile;
      return localFile;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public Uri getSourceUri()
  {
    return this.mSourceUri;
  }

  public int getSourceUriType()
  {
    return this.mSourceUriType;
  }

  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.mCacheChoice, this.mSourceUri, this.mMediaVariations, this.mSourceFile });
  }

  public boolean isDiskCacheEnabled()
  {
    return this.mIsDiskCacheEnabled;
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("uri", this.mSourceUri).add("cacheChoice", this.mCacheChoice).add("decodeOptions", this.mImageDecodeOptions).add("postprocessor", this.mPostprocessor).add("priority", this.mRequestPriority).add("resizeOptions", this.mResizeOptions).add("rotationOptions", this.mRotationOptions).add("mediaVariations", this.mMediaVariations).toString();
  }

  public static enum CacheChoice
  {
    static
    {
      DEFAULT = new CacheChoice("DEFAULT", 1);
      $VALUES = new CacheChoice[] { SMALL, DEFAULT };
    }
  }

  public static enum RequestLevel
  {
    private int mValue;

    static
    {
      DISK_CACHE = new RequestLevel("DISK_CACHE", 1, 2);
      ENCODED_MEMORY_CACHE = new RequestLevel("ENCODED_MEMORY_CACHE", 2, 3);
      BITMAP_MEMORY_CACHE = new RequestLevel("BITMAP_MEMORY_CACHE", 3, 4);
      $VALUES = new RequestLevel[] { FULL_FETCH, DISK_CACHE, ENCODED_MEMORY_CACHE, BITMAP_MEMORY_CACHE };
    }

    private RequestLevel(int paramInt)
    {
      this.mValue = paramInt;
    }

    public static RequestLevel getMax(RequestLevel paramRequestLevel1, RequestLevel paramRequestLevel2)
    {
      if (paramRequestLevel1.getValue() > paramRequestLevel2.getValue())
        return paramRequestLevel1;
      return paramRequestLevel2;
    }

    public int getValue()
    {
      return this.mValue;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.request.ImageRequest
 * JD-Core Version:    0.6.0
 */
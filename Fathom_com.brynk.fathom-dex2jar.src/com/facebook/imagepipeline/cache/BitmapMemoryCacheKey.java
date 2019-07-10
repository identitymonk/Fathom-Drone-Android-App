package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.common.util.HashCodeUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class BitmapMemoryCacheKey
  implements CacheKey
{
  private final long mCacheTime;
  private final Object mCallerContext;
  private final int mHash;
  private final ImageDecodeOptions mImageDecodeOptions;

  @Nullable
  private final CacheKey mPostprocessorCacheKey;

  @Nullable
  private final String mPostprocessorName;

  @Nullable
  private final ResizeOptions mResizeOptions;
  private final RotationOptions mRotationOptions;
  private final String mSourceString;

  public BitmapMemoryCacheKey(String paramString1, @Nullable ResizeOptions paramResizeOptions, RotationOptions paramRotationOptions, ImageDecodeOptions paramImageDecodeOptions, @Nullable CacheKey paramCacheKey, @Nullable String paramString2, Object paramObject)
  {
    this.mSourceString = ((String)Preconditions.checkNotNull(paramString1));
    this.mResizeOptions = paramResizeOptions;
    this.mRotationOptions = paramRotationOptions;
    this.mImageDecodeOptions = paramImageDecodeOptions;
    this.mPostprocessorCacheKey = paramCacheKey;
    this.mPostprocessorName = paramString2;
    int j = paramString1.hashCode();
    if (paramResizeOptions != null);
    for (int i = paramResizeOptions.hashCode(); ; i = 0)
    {
      this.mHash = HashCodeUtil.hashCode(Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramRotationOptions.hashCode()), this.mImageDecodeOptions, this.mPostprocessorCacheKey, paramString2);
      this.mCallerContext = paramObject;
      this.mCacheTime = RealtimeSinceBootClock.get().now();
      return;
    }
  }

  public boolean containsUri(Uri paramUri)
  {
    return getUriString().contains(paramUri.toString());
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof BitmapMemoryCacheKey));
    do
    {
      return false;
      paramObject = (BitmapMemoryCacheKey)paramObject;
    }
    while ((this.mHash != paramObject.mHash) || (!this.mSourceString.equals(paramObject.mSourceString)) || (!Objects.equal(this.mResizeOptions, paramObject.mResizeOptions)) || (!Objects.equal(this.mRotationOptions, paramObject.mRotationOptions)) || (!Objects.equal(this.mImageDecodeOptions, paramObject.mImageDecodeOptions)) || (!Objects.equal(this.mPostprocessorCacheKey, paramObject.mPostprocessorCacheKey)) || (!Objects.equal(this.mPostprocessorName, paramObject.mPostprocessorName)));
    return true;
  }

  public Object getCallerContext()
  {
    return this.mCallerContext;
  }

  public long getInBitmapCacheSince()
  {
    return this.mCacheTime;
  }

  @Nullable
  public String getPostprocessorName()
  {
    return this.mPostprocessorName;
  }

  public String getUriString()
  {
    return this.mSourceString;
  }

  public int hashCode()
  {
    return this.mHash;
  }

  public String toString()
  {
    return String.format((Locale)null, "%s_%s_%s_%s_%s_%s_%d", new Object[] { this.mSourceString, this.mResizeOptions, this.mRotationOptions, this.mImageDecodeOptions, this.mPostprocessorCacheKey, this.mPostprocessorName, Integer.valueOf(this.mHash) });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.BitmapMemoryCacheKey
 * JD-Core Version:    0.6.0
 */
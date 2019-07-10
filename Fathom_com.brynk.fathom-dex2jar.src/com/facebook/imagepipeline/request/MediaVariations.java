package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.Objects;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class MediaVariations
{
  public static final String SOURCE_ID_EXTRACTOR = "id_extractor";
  public static final String SOURCE_IMAGE_REQUEST = "request";
  public static final String SOURCE_INDEX_DB = "index_db";
  private final boolean mForceRequestForSpecifiedUri;
  private final String mMediaId;
  private final String mSource;

  @Nullable
  private final List<Variant> mVariants;

  private MediaVariations(Builder paramBuilder)
  {
    this.mMediaId = paramBuilder.mMediaId;
    this.mVariants = paramBuilder.mVariants;
    this.mForceRequestForSpecifiedUri = paramBuilder.mForceRequestForSpecifiedUri;
    this.mSource = paramBuilder.mSource;
  }

  @Nullable
  public static MediaVariations forMediaId(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
      return null;
    return newBuilderForMediaId(paramString).build();
  }

  public static Builder newBuilderForMediaId(String paramString)
  {
    return new Builder(paramString, null);
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MediaVariations));
    do
    {
      return false;
      paramObject = (MediaVariations)paramObject;
    }
    while ((!Objects.equal(this.mMediaId, paramObject.mMediaId)) || (this.mForceRequestForSpecifiedUri != paramObject.mForceRequestForSpecifiedUri) || (!Objects.equal(this.mVariants, paramObject.mVariants)));
    return true;
  }

  public String getMediaId()
  {
    return this.mMediaId;
  }

  public List<Variant> getSortedVariants(Comparator<Variant> paramComparator)
  {
    int j = getVariantsCount();
    if (j == 0)
      return Collections.emptyList();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(this.mVariants.get(i));
      i += 1;
    }
    Collections.sort(localArrayList, paramComparator);
    return localArrayList;
  }

  public String getSource()
  {
    return this.mSource;
  }

  public Variant getVariant(int paramInt)
  {
    return (Variant)this.mVariants.get(paramInt);
  }

  public int getVariantsCount()
  {
    if (this.mVariants == null)
      return 0;
    return this.mVariants.size();
  }

  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.mMediaId, Boolean.valueOf(this.mForceRequestForSpecifiedUri), this.mVariants, this.mSource });
  }

  public boolean shouldForceRequestForSpecifiedUri()
  {
    return this.mForceRequestForSpecifiedUri;
  }

  public String toString()
  {
    return String.format((Locale)null, "%s-%b-%s-%s", new Object[] { this.mMediaId, Boolean.valueOf(this.mForceRequestForSpecifiedUri), this.mVariants, this.mSource });
  }

  public static class Builder
  {
    private boolean mForceRequestForSpecifiedUri = false;
    private final String mMediaId;
    private String mSource = "request";
    private List<MediaVariations.Variant> mVariants;

    private Builder(String paramString)
    {
      this.mMediaId = paramString;
    }

    public Builder addVariant(Uri paramUri, int paramInt1, int paramInt2)
    {
      return addVariant(paramUri, paramInt1, paramInt2, null);
    }

    public Builder addVariant(Uri paramUri, int paramInt1, int paramInt2, ImageRequest.CacheChoice paramCacheChoice)
    {
      if (this.mVariants == null)
        this.mVariants = new ArrayList();
      this.mVariants.add(new MediaVariations.Variant(paramUri, paramInt1, paramInt2, paramCacheChoice));
      return this;
    }

    public MediaVariations build()
    {
      return new MediaVariations(this, null);
    }

    public Builder setForceRequestForSpecifiedUri(boolean paramBoolean)
    {
      this.mForceRequestForSpecifiedUri = paramBoolean;
      return this;
    }

    public Builder setSource(String paramString)
    {
      this.mSource = paramString;
      return this;
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface Source
  {
  }

  public static final class Variant
  {

    @Nullable
    private final ImageRequest.CacheChoice mCacheChoice;
    private final int mHeight;
    private final Uri mUri;
    private final int mWidth;

    public Variant(Uri paramUri, int paramInt1, int paramInt2)
    {
      this(paramUri, paramInt1, paramInt2, null);
    }

    public Variant(Uri paramUri, int paramInt1, int paramInt2, @Nullable ImageRequest.CacheChoice paramCacheChoice)
    {
      this.mUri = paramUri;
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      this.mCacheChoice = paramCacheChoice;
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof Variant));
      do
      {
        return false;
        paramObject = (Variant)paramObject;
      }
      while ((!Objects.equal(this.mUri, paramObject.mUri)) || (this.mWidth != paramObject.mWidth) || (this.mHeight != paramObject.mHeight) || (this.mCacheChoice != paramObject.mCacheChoice));
      return true;
    }

    @Nullable
    public ImageRequest.CacheChoice getCacheChoice()
    {
      return this.mCacheChoice;
    }

    public int getHeight()
    {
      return this.mHeight;
    }

    public Uri getUri()
    {
      return this.mUri;
    }

    public int getWidth()
    {
      return this.mWidth;
    }

    public int hashCode()
    {
      return (this.mUri.hashCode() * 31 + this.mWidth) * 31 + this.mHeight;
    }

    public String toString()
    {
      return String.format((Locale)null, "%dx%d %s %s", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri, this.mCacheChoice });
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.request.MediaVariations
 * JD-Core Version:    0.6.0
 */
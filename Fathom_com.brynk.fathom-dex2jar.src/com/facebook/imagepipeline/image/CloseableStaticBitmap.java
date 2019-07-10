package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class CloseableStaticBitmap extends CloseableBitmap
{
  private volatile Bitmap mBitmap;

  @GuardedBy("this")
  private CloseableReference<Bitmap> mBitmapReference;
  private final QualityInfo mQualityInfo;
  private final int mRotationAngle;

  public CloseableStaticBitmap(Bitmap paramBitmap, ResourceReleaser<Bitmap> paramResourceReleaser, QualityInfo paramQualityInfo, int paramInt)
  {
    this.mBitmap = ((Bitmap)Preconditions.checkNotNull(paramBitmap));
    this.mBitmapReference = CloseableReference.of(this.mBitmap, (ResourceReleaser)Preconditions.checkNotNull(paramResourceReleaser));
    this.mQualityInfo = paramQualityInfo;
    this.mRotationAngle = paramInt;
  }

  public CloseableStaticBitmap(CloseableReference<Bitmap> paramCloseableReference, QualityInfo paramQualityInfo, int paramInt)
  {
    this.mBitmapReference = ((CloseableReference)Preconditions.checkNotNull(paramCloseableReference.cloneOrNull()));
    this.mBitmap = ((Bitmap)this.mBitmapReference.get());
    this.mQualityInfo = paramQualityInfo;
    this.mRotationAngle = paramInt;
  }

  private CloseableReference<Bitmap> detachBitmapReference()
  {
    monitorenter;
    try
    {
      CloseableReference localCloseableReference = this.mBitmapReference;
      this.mBitmapReference = null;
      this.mBitmap = null;
      monitorexit;
      return localCloseableReference;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private static int getBitmapHeight(@Nullable Bitmap paramBitmap)
  {
    if (paramBitmap == null)
      return 0;
    return paramBitmap.getHeight();
  }

  private static int getBitmapWidth(@Nullable Bitmap paramBitmap)
  {
    if (paramBitmap == null)
      return 0;
    return paramBitmap.getWidth();
  }

  public void close()
  {
    CloseableReference localCloseableReference = detachBitmapReference();
    if (localCloseableReference != null)
      localCloseableReference.close();
  }

  public CloseableReference<Bitmap> convertToBitmapReference()
  {
    monitorenter;
    try
    {
      Preconditions.checkNotNull(this.mBitmapReference, "Cannot convert a closed static bitmap");
      CloseableReference localCloseableReference = detachBitmapReference();
      monitorexit;
      return localCloseableReference;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int getHeight()
  {
    if ((this.mRotationAngle == 90) || (this.mRotationAngle == 270))
      return getBitmapWidth(this.mBitmap);
    return getBitmapHeight(this.mBitmap);
  }

  public QualityInfo getQualityInfo()
  {
    return this.mQualityInfo;
  }

  public int getRotationAngle()
  {
    return this.mRotationAngle;
  }

  public int getSizeInBytes()
  {
    return BitmapUtil.getSizeInBytes(this.mBitmap);
  }

  public Bitmap getUnderlyingBitmap()
  {
    return this.mBitmap;
  }

  public int getWidth()
  {
    if ((this.mRotationAngle == 90) || (this.mRotationAngle == 270))
      return getBitmapHeight(this.mBitmap);
    return getBitmapWidth(this.mBitmap);
  }

  public boolean isClosed()
  {
    monitorenter;
    try
    {
      CloseableReference localCloseableReference = this.mBitmapReference;
      if (localCloseableReference == null)
      {
        i = 1;
        return i;
      }
      int i = 0;
    }
    finally
    {
      monitorexit;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.image.CloseableStaticBitmap
 * JD-Core Version:    0.6.0
 */
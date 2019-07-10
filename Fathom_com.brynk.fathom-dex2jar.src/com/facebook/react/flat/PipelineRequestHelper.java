package com.facebook.react.flat;

import android.graphics.Bitmap;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nullable;

final class PipelineRequestHelper
  implements DataSubscriber<CloseableReference<CloseableImage>>
{
  private int mAttachCounter;

  @Nullable
  private BitmapUpdateListener mBitmapUpdateListener;

  @Nullable
  private DataSource<CloseableReference<CloseableImage>> mDataSource;

  @Nullable
  private CloseableReference<CloseableImage> mImageRef;
  private final ImageRequest mImageRequest;

  PipelineRequestHelper(ImageRequest paramImageRequest)
  {
    this.mImageRequest = paramImageRequest;
  }

  void attach(BitmapUpdateListener paramBitmapUpdateListener)
  {
    boolean bool2 = true;
    this.mBitmapUpdateListener = paramBitmapUpdateListener;
    this.mAttachCounter += 1;
    if (this.mAttachCounter != 1)
    {
      Bitmap localBitmap = getBitmap();
      if (localBitmap != null)
        paramBitmapUpdateListener.onSecondaryAttach(localBitmap);
      return;
    }
    paramBitmapUpdateListener.onImageLoadEvent(4);
    if (this.mDataSource == null)
    {
      bool1 = true;
      Assertions.assertCondition(bool1);
      if (this.mImageRef != null)
        break label117;
    }
    label117: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Assertions.assertCondition(bool1);
      this.mDataSource = ImagePipelineFactory.getInstance().getImagePipeline().fetchDecodedImage(this.mImageRequest, RCTImageView.getCallerContext());
      this.mDataSource.subscribe(this, UiThreadImmediateExecutorService.getInstance());
      return;
      bool1 = false;
      break;
    }
  }

  void detach()
  {
    this.mAttachCounter -= 1;
    if (this.mAttachCounter != 0)
      return;
    if (this.mDataSource != null)
    {
      this.mDataSource.close();
      this.mDataSource = null;
    }
    if (this.mImageRef != null)
    {
      this.mImageRef.close();
      this.mImageRef = null;
    }
    this.mBitmapUpdateListener = null;
  }

  @Nullable
  Bitmap getBitmap()
  {
    if (this.mImageRef == null)
      return null;
    CloseableImage localCloseableImage = (CloseableImage)this.mImageRef.get();
    if (!(localCloseableImage instanceof CloseableBitmap))
    {
      this.mImageRef.close();
      this.mImageRef = null;
      return null;
    }
    return ((CloseableBitmap)localCloseableImage).getUnderlyingBitmap();
  }

  boolean isDetached()
  {
    return this.mAttachCounter == 0;
  }

  public void onCancellation(DataSource<CloseableReference<CloseableImage>> paramDataSource)
  {
    if (this.mDataSource == paramDataSource)
      this.mDataSource = null;
    paramDataSource.close();
  }

  public void onFailure(DataSource<CloseableReference<CloseableImage>> paramDataSource)
  {
    if (this.mDataSource == paramDataSource)
    {
      ((BitmapUpdateListener)Assertions.assumeNotNull(this.mBitmapUpdateListener)).onImageLoadEvent(1);
      ((BitmapUpdateListener)Assertions.assumeNotNull(this.mBitmapUpdateListener)).onImageLoadEvent(3);
      this.mDataSource = null;
    }
    paramDataSource.close();
  }

  public void onNewResult(DataSource<CloseableReference<CloseableImage>> paramDataSource)
  {
    if (!paramDataSource.isFinished())
      return;
    try
    {
      Object localObject1 = this.mDataSource;
      if (localObject1 != paramDataSource)
        return;
      this.mDataSource = null;
      localObject1 = (CloseableReference)paramDataSource.getResult();
      if (localObject1 == null)
        return;
      if (!((CloseableImage)((CloseableReference)localObject1).get() instanceof CloseableBitmap))
      {
        ((CloseableReference)localObject1).close();
        return;
      }
      this.mImageRef = ((CloseableReference)localObject1);
      localObject1 = getBitmap();
      if (localObject1 == null)
        return;
      BitmapUpdateListener localBitmapUpdateListener = (BitmapUpdateListener)Assertions.assumeNotNull(this.mBitmapUpdateListener);
      localBitmapUpdateListener.onBitmapReady((Bitmap)localObject1);
      localBitmapUpdateListener.onImageLoadEvent(2);
      localBitmapUpdateListener.onImageLoadEvent(3);
      return;
    }
    finally
    {
      paramDataSource.close();
    }
    throw localObject2;
  }

  public void onProgressUpdate(DataSource<CloseableReference<CloseableImage>> paramDataSource)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.PipelineRequestHelper
 * JD-Core Version:    0.6.0
 */
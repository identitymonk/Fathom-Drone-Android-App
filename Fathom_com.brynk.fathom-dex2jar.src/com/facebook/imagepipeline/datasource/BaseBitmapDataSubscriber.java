package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import javax.annotation.Nullable;

public abstract class BaseBitmapDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>>
{
  protected abstract void onNewResultImpl(@Nullable Bitmap paramBitmap);

  public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> paramDataSource)
  {
    if (!paramDataSource.isFinished())
      return;
    CloseableReference localCloseableReference = (CloseableReference)paramDataSource.getResult();
    Object localObject = null;
    paramDataSource = localObject;
    if (localCloseableReference != null)
    {
      paramDataSource = localObject;
      if ((localCloseableReference.get() instanceof CloseableBitmap))
        paramDataSource = ((CloseableBitmap)localCloseableReference.get()).getUnderlyingBitmap();
    }
    try
    {
      onNewResultImpl(paramDataSource);
      return;
    }
    finally
    {
      CloseableReference.closeSafely(localCloseableReference);
    }
    throw paramDataSource;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
 * JD-Core Version:    0.6.0
 */
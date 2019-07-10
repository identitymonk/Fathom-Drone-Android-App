package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseListBitmapDataSubscriber extends BaseDataSubscriber<List<CloseableReference<CloseableImage>>>
{
  public void onNewResultImpl(DataSource<List<CloseableReference<CloseableImage>>> paramDataSource)
  {
    if (!paramDataSource.isFinished())
      return;
    paramDataSource = (List)paramDataSource.getResult();
    if (paramDataSource == null)
    {
      onNewResultListImpl(null);
      return;
    }
    try
    {
      ArrayList localArrayList = new ArrayList(paramDataSource.size());
      Iterator localIterator = paramDataSource.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          break label151;
        CloseableReference localCloseableReference = (CloseableReference)localIterator.next();
        if ((localCloseableReference == null) || (!(localCloseableReference.get() instanceof CloseableBitmap)))
          break;
        localArrayList.add(((CloseableBitmap)localCloseableReference.get()).getUnderlyingBitmap());
      }
    }
    finally
    {
      while (true)
      {
        paramDataSource = paramDataSource.iterator();
        while (true)
          if (paramDataSource.hasNext())
          {
            CloseableReference.closeSafely((CloseableReference)paramDataSource.next());
            continue;
            localList.add(null);
            break;
            label151: onNewResultListImpl(localList);
            paramDataSource = paramDataSource.iterator();
            while (paramDataSource.hasNext())
              CloseableReference.closeSafely((CloseableReference)paramDataSource.next());
          }
      }
    }
    throw localList;
  }

  protected abstract void onNewResultListImpl(List<Bitmap> paramList);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.datasource.BaseListBitmapDataSubscriber
 * JD-Core Version:    0.6.0
 */
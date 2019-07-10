package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.imageutils.BitmapUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.facebook.common.references.CloseableReference<Landroid.graphics.Bitmap;>;>;
import javax.annotation.concurrent.GuardedBy;

public class BitmapCounter
{

  @GuardedBy("this")
  private int mCount;
  private final int mMaxCount;
  private final int mMaxSize;

  @GuardedBy("this")
  private long mSize;
  private final ResourceReleaser<Bitmap> mUnpooledBitmapsReleaser;

  public BitmapCounter(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if (paramInt2 <= 0)
        break label56;
    }
    label56: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      this.mMaxCount = paramInt1;
      this.mMaxSize = paramInt2;
      this.mUnpooledBitmapsReleaser = new ResourceReleaser()
      {
        public void release(Bitmap paramBitmap)
        {
          try
          {
            BitmapCounter.this.decrease(paramBitmap);
            return;
          }
          finally
          {
            paramBitmap.recycle();
          }
          throw localObject;
        }
      };
      return;
      bool1 = false;
      break;
    }
  }

  public List<CloseableReference<Bitmap>> associateBitmapsWithBitmapCounter(List<Bitmap> paramList)
  {
    int i = 0;
    ArrayList localArrayList;
    try
    {
      if (i < paramList.size())
      {
        Bitmap localBitmap = (Bitmap)paramList.get(i);
        if (Build.VERSION.SDK_INT < 21)
          Bitmaps.pinBitmap(localBitmap);
        if (!increase(localBitmap))
          throw new TooManyBitmapsException();
      }
    }
    catch (Exception localArrayList)
    {
      while (paramList != null)
      {
        paramList = paramList.iterator();
        while (true)
          if (paramList.hasNext())
          {
            Object localObject = (Bitmap)paramList.next();
            if (i > 0)
              decrease((Bitmap)localObject);
            ((Bitmap)localObject).recycle();
            i -= 1;
            continue;
            i += 1;
            break;
            localArrayList = new ArrayList(paramList.size());
            localObject = paramList.iterator();
            while (((Iterator)localObject).hasNext())
              localArrayList.add(CloseableReference.of((Bitmap)((Iterator)localObject).next(), this.mUnpooledBitmapsReleaser));
          }
      }
      throw Throwables.propagate(localArrayList);
    }
    return (List<CloseableReference<Bitmap>>)localArrayList;
  }

  public void decrease(Bitmap paramBitmap)
  {
    boolean bool2 = true;
    monitorenter;
    try
    {
      int i = BitmapUtil.getSizeInBytes(paramBitmap);
      if (this.mCount > 0)
      {
        bool1 = true;
        Preconditions.checkArgument(bool1, "No bitmaps registered.");
        if (i > this.mSize)
          break label94;
      }
      label94: for (boolean bool1 = bool2; ; bool1 = false)
      {
        Preconditions.checkArgument(bool1, "Bitmap size bigger than the total registered size: %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(this.mSize) });
        this.mSize -= i;
        this.mCount -= 1;
        return;
        bool1 = false;
        break;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramBitmap;
  }

  public int getCount()
  {
    monitorenter;
    try
    {
      int i = this.mCount;
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public ResourceReleaser<Bitmap> getReleaser()
  {
    return this.mUnpooledBitmapsReleaser;
  }

  public long getSize()
  {
    monitorenter;
    try
    {
      long l = this.mSize;
      monitorexit;
      return l;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean increase(Bitmap paramBitmap)
  {
    monitorenter;
    try
    {
      int i = BitmapUtil.getSizeInBytes(paramBitmap);
      if (this.mCount < this.mMaxCount)
      {
        long l1 = this.mSize;
        long l2 = i;
        int j = this.mMaxSize;
        if (l1 + l2 <= j)
          break label52;
      }
      for (int k = 0; ; k = 1)
      {
        return k;
        label52: this.mCount += 1;
        this.mSize += i;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramBitmap;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.BitmapCounter
 * JD-Core Version:    0.6.0
 */
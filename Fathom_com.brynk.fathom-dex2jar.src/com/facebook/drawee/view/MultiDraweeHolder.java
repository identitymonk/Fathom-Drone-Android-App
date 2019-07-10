package com.facebook.drawee.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.ArrayList;

public class MultiDraweeHolder<DH extends DraweeHierarchy>
{

  @VisibleForTesting
  ArrayList<DraweeHolder<DH>> mHolders = new ArrayList();

  @VisibleForTesting
  boolean mIsAttached = false;

  public void add(int paramInt, DraweeHolder<DH> paramDraweeHolder)
  {
    Preconditions.checkNotNull(paramDraweeHolder);
    Preconditions.checkElementIndex(paramInt, this.mHolders.size() + 1);
    this.mHolders.add(paramInt, paramDraweeHolder);
    if (this.mIsAttached)
      paramDraweeHolder.onAttach();
  }

  public void add(DraweeHolder<DH> paramDraweeHolder)
  {
    add(this.mHolders.size(), paramDraweeHolder);
  }

  public void clear()
  {
    if (this.mIsAttached)
    {
      int i = 0;
      while (i < this.mHolders.size())
      {
        ((DraweeHolder)this.mHolders.get(i)).onDetach();
        i += 1;
      }
    }
    this.mHolders.clear();
  }

  public void draw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < this.mHolders.size())
    {
      Drawable localDrawable = get(i).getTopLevelDrawable();
      if (localDrawable != null)
        localDrawable.draw(paramCanvas);
      i += 1;
    }
  }

  public DraweeHolder<DH> get(int paramInt)
  {
    return (DraweeHolder)this.mHolders.get(paramInt);
  }

  public void onAttach()
  {
    if (this.mIsAttached);
    while (true)
    {
      return;
      this.mIsAttached = true;
      int i = 0;
      while (i < this.mHolders.size())
      {
        ((DraweeHolder)this.mHolders.get(i)).onAttach();
        i += 1;
      }
    }
  }

  public void onDetach()
  {
    if (!this.mIsAttached);
    while (true)
    {
      return;
      this.mIsAttached = false;
      int i = 0;
      while (i < this.mHolders.size())
      {
        ((DraweeHolder)this.mHolders.get(i)).onDetach();
        i += 1;
      }
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    while (i < this.mHolders.size())
    {
      if (((DraweeHolder)this.mHolders.get(i)).onTouchEvent(paramMotionEvent))
        return true;
      i += 1;
    }
    return false;
  }

  public void remove(int paramInt)
  {
    DraweeHolder localDraweeHolder = (DraweeHolder)this.mHolders.get(paramInt);
    if (this.mIsAttached)
      localDraweeHolder.onDetach();
    this.mHolders.remove(paramInt);
  }

  public int size()
  {
    return this.mHolders.size();
  }

  public boolean verifyDrawable(Drawable paramDrawable)
  {
    int i = 0;
    while (i < this.mHolders.size())
    {
      if (paramDrawable == get(i).getTopLevelDrawable())
        return true;
      i += 1;
    }
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.view.MultiDraweeHolder
 * JD-Core Version:    0.6.0
 */
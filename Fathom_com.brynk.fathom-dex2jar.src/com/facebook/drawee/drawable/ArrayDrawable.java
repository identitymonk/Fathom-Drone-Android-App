package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;

public class ArrayDrawable extends Drawable
  implements Drawable.Callback, TransformCallback, TransformAwareDrawable
{
  private final DrawableParent[] mDrawableParents;
  private final DrawableProperties mDrawableProperties = new DrawableProperties();
  private boolean mIsMutated = false;
  private boolean mIsStateful = false;
  private boolean mIsStatefulCalculated = false;
  private final Drawable[] mLayers;
  private final Rect mTmpRect = new Rect();
  private TransformCallback mTransformCallback;

  public ArrayDrawable(Drawable[] paramArrayOfDrawable)
  {
    Preconditions.checkNotNull(paramArrayOfDrawable);
    this.mLayers = paramArrayOfDrawable;
    int i = 0;
    while (i < this.mLayers.length)
    {
      DrawableUtils.setCallbacks(this.mLayers[i], this, this);
      i += 1;
    }
    this.mDrawableParents = new DrawableParent[this.mLayers.length];
  }

  private DrawableParent createDrawableParentForIndex(int paramInt)
  {
    return new DrawableParent(paramInt)
    {
      public Drawable getDrawable()
      {
        return ArrayDrawable.this.getDrawable(this.val$index);
      }

      public Drawable setDrawable(Drawable paramDrawable)
      {
        return ArrayDrawable.this.setDrawable(this.val$index, paramDrawable);
      }
    };
  }

  public void draw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.draw(paramCanvas);
      i += 1;
    }
  }

  @Nullable
  public Drawable getDrawable(int paramInt)
  {
    boolean bool2 = true;
    if (paramInt >= 0)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if (paramInt >= this.mLayers.length)
        break label39;
    }
    label39: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      return this.mLayers[paramInt];
      bool1 = false;
      break;
    }
  }

  public DrawableParent getDrawableParentForIndex(int paramInt)
  {
    boolean bool2 = true;
    if (paramInt >= 0)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if (paramInt >= this.mDrawableParents.length)
        break label59;
    }
    label59: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      if (this.mDrawableParents[paramInt] == null)
        this.mDrawableParents[paramInt] = createDrawableParentForIndex(paramInt);
      return this.mDrawableParents[paramInt];
      bool1 = false;
      break;
    }
  }

  public int getIntrinsicHeight()
  {
    int j = -1;
    int i = 0;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      int k = j;
      if (localDrawable != null)
        k = Math.max(j, localDrawable.getIntrinsicHeight());
      i += 1;
      j = k;
    }
    if (j > 0)
      return j;
    return -1;
  }

  public int getIntrinsicWidth()
  {
    int j = -1;
    int i = 0;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      int k = j;
      if (localDrawable != null)
        k = Math.max(j, localDrawable.getIntrinsicWidth());
      i += 1;
      j = k;
    }
    if (j > 0)
      return j;
    return -1;
  }

  public int getNumberOfLayers()
  {
    return this.mLayers.length;
  }

  public int getOpacity()
  {
    int k;
    if (this.mLayers.length == 0)
    {
      k = -2;
      return k;
    }
    int i = -1;
    int j = 1;
    while (true)
    {
      k = i;
      if (j >= this.mLayers.length)
        break;
      Drawable localDrawable = this.mLayers[j];
      k = i;
      if (localDrawable != null)
        k = Drawable.resolveOpacity(i, localDrawable.getOpacity());
      j += 1;
      i = k;
    }
  }

  public boolean getPadding(Rect paramRect)
  {
    paramRect.left = 0;
    paramRect.top = 0;
    paramRect.right = 0;
    paramRect.bottom = 0;
    Rect localRect = this.mTmpRect;
    int i = 0;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
      {
        localDrawable.getPadding(localRect);
        paramRect.left = Math.max(paramRect.left, localRect.left);
        paramRect.top = Math.max(paramRect.top, localRect.top);
        paramRect.right = Math.max(paramRect.right, localRect.right);
        paramRect.bottom = Math.max(paramRect.bottom, localRect.bottom);
      }
      i += 1;
    }
    return true;
  }

  public void getRootBounds(RectF paramRectF)
  {
    if (this.mTransformCallback != null)
    {
      this.mTransformCallback.getRootBounds(paramRectF);
      return;
    }
    paramRectF.set(getBounds());
  }

  public void getTransform(Matrix paramMatrix)
  {
    if (this.mTransformCallback != null)
    {
      this.mTransformCallback.getTransform(paramMatrix);
      return;
    }
    paramMatrix.reset();
  }

  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }

  public boolean isStateful()
  {
    if (!this.mIsStatefulCalculated)
    {
      this.mIsStateful = false;
      int i = 0;
      if (i < this.mLayers.length)
      {
        Drawable localDrawable = this.mLayers[i];
        boolean bool2 = this.mIsStateful;
        if ((localDrawable != null) && (localDrawable.isStateful()));
        for (boolean bool1 = true; ; bool1 = false)
        {
          this.mIsStateful = (bool1 | bool2);
          i += 1;
          break;
        }
      }
      this.mIsStatefulCalculated = true;
    }
    return this.mIsStateful;
  }

  public Drawable mutate()
  {
    int i = 0;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.mutate();
      i += 1;
    }
    this.mIsMutated = true;
    return this;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    int i = 0;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.setBounds(paramRect);
      i += 1;
    }
  }

  protected boolean onLevelChange(int paramInt)
  {
    int j = 0;
    int i = 0;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      int k = j;
      if (localDrawable != null)
      {
        k = j;
        if (localDrawable.setLevel(paramInt))
          k = 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }

  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int j = 0;
    int i = 0;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      int k = j;
      if (localDrawable != null)
      {
        k = j;
        if (localDrawable.setState(paramArrayOfInt))
          k = 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }

  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }

  public void setAlpha(int paramInt)
  {
    this.mDrawableProperties.setAlpha(paramInt);
    int i = 0;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.setAlpha(paramInt);
      i += 1;
    }
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mDrawableProperties.setColorFilter(paramColorFilter);
    int i = 0;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.setColorFilter(paramColorFilter);
      i += 1;
    }
  }

  public void setDither(boolean paramBoolean)
  {
    this.mDrawableProperties.setDither(paramBoolean);
    int i = 0;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.setDither(paramBoolean);
      i += 1;
    }
  }

  @Nullable
  public Drawable setDrawable(int paramInt, @Nullable Drawable paramDrawable)
  {
    boolean bool2 = true;
    if (paramInt >= 0)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if (paramInt >= this.mLayers.length)
        break label119;
    }
    label119: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Preconditions.checkArgument(bool1);
      Drawable localDrawable = this.mLayers[paramInt];
      if (paramDrawable != localDrawable)
      {
        if ((paramDrawable != null) && (this.mIsMutated))
          paramDrawable.mutate();
        DrawableUtils.setCallbacks(this.mLayers[paramInt], null, null);
        DrawableUtils.setCallbacks(paramDrawable, null, null);
        DrawableUtils.setDrawableProperties(paramDrawable, this.mDrawableProperties);
        DrawableUtils.copyProperties(paramDrawable, this);
        DrawableUtils.setCallbacks(paramDrawable, this, this);
        this.mIsStatefulCalculated = false;
        this.mLayers[paramInt] = paramDrawable;
        invalidateSelf();
      }
      return localDrawable;
      bool1 = false;
      break;
    }
  }

  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mDrawableProperties.setFilterBitmap(paramBoolean);
    int i = 0;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.setFilterBitmap(paramBoolean);
      i += 1;
    }
  }

  @TargetApi(21)
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    int i = 0;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.setHotspot(paramFloat1, paramFloat2);
      i += 1;
    }
  }

  public void setTransformCallback(TransformCallback paramTransformCallback)
  {
    this.mTransformCallback = paramTransformCallback;
  }

  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    int i = 0;
    while (i < this.mLayers.length)
    {
      Drawable localDrawable = this.mLayers[i];
      if (localDrawable != null)
        localDrawable.setVisible(paramBoolean1, paramBoolean2);
      i += 1;
    }
    return bool;
  }

  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.ArrayDrawable
 * JD-Core Version:    0.6.0
 */
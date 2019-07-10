package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

public class ForwardingDrawable extends Drawable
  implements Drawable.Callback, TransformCallback, TransformAwareDrawable, DrawableParent
{
  private static final Matrix sTempTransform = new Matrix();
  private Drawable mCurrentDelegate;
  private final DrawableProperties mDrawableProperties = new DrawableProperties();
  protected TransformCallback mTransformCallback;

  public ForwardingDrawable(Drawable paramDrawable)
  {
    this.mCurrentDelegate = paramDrawable;
    DrawableUtils.setCallbacks(this.mCurrentDelegate, this, this);
  }

  public void draw(Canvas paramCanvas)
  {
    this.mCurrentDelegate.draw(paramCanvas);
  }

  public Drawable.ConstantState getConstantState()
  {
    return this.mCurrentDelegate.getConstantState();
  }

  public Drawable getCurrent()
  {
    return this.mCurrentDelegate;
  }

  public Drawable getDrawable()
  {
    return getCurrent();
  }

  public int getIntrinsicHeight()
  {
    return this.mCurrentDelegate.getIntrinsicHeight();
  }

  public int getIntrinsicWidth()
  {
    return this.mCurrentDelegate.getIntrinsicWidth();
  }

  public int getOpacity()
  {
    return this.mCurrentDelegate.getOpacity();
  }

  public boolean getPadding(Rect paramRect)
  {
    return this.mCurrentDelegate.getPadding(paramRect);
  }

  protected void getParentTransform(Matrix paramMatrix)
  {
    if (this.mTransformCallback != null)
    {
      this.mTransformCallback.getTransform(paramMatrix);
      return;
    }
    paramMatrix.reset();
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
    getParentTransform(paramMatrix);
  }

  public void getTransformedBounds(RectF paramRectF)
  {
    getParentTransform(sTempTransform);
    paramRectF.set(getBounds());
    sTempTransform.mapRect(paramRectF);
  }

  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }

  public boolean isStateful()
  {
    return this.mCurrentDelegate.isStateful();
  }

  public Drawable mutate()
  {
    this.mCurrentDelegate.mutate();
    return this;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    this.mCurrentDelegate.setBounds(paramRect);
  }

  protected boolean onLevelChange(int paramInt)
  {
    return this.mCurrentDelegate.setLevel(paramInt);
  }

  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    return this.mCurrentDelegate.setState(paramArrayOfInt);
  }

  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }

  public void setAlpha(int paramInt)
  {
    this.mDrawableProperties.setAlpha(paramInt);
    this.mCurrentDelegate.setAlpha(paramInt);
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mDrawableProperties.setColorFilter(paramColorFilter);
    this.mCurrentDelegate.setColorFilter(paramColorFilter);
  }

  public Drawable setCurrent(Drawable paramDrawable)
  {
    paramDrawable = setCurrentWithoutInvalidate(paramDrawable);
    invalidateSelf();
    return paramDrawable;
  }

  protected Drawable setCurrentWithoutInvalidate(Drawable paramDrawable)
  {
    Drawable localDrawable = this.mCurrentDelegate;
    DrawableUtils.setCallbacks(localDrawable, null, null);
    DrawableUtils.setCallbacks(paramDrawable, null, null);
    DrawableUtils.setDrawableProperties(paramDrawable, this.mDrawableProperties);
    DrawableUtils.copyProperties(paramDrawable, this);
    DrawableUtils.setCallbacks(paramDrawable, this, this);
    this.mCurrentDelegate = paramDrawable;
    return localDrawable;
  }

  public void setDither(boolean paramBoolean)
  {
    this.mDrawableProperties.setDither(paramBoolean);
    this.mCurrentDelegate.setDither(paramBoolean);
  }

  public Drawable setDrawable(Drawable paramDrawable)
  {
    return setCurrent(paramDrawable);
  }

  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mDrawableProperties.setFilterBitmap(paramBoolean);
    this.mCurrentDelegate.setFilterBitmap(paramBoolean);
  }

  @TargetApi(21)
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    this.mCurrentDelegate.setHotspot(paramFloat1, paramFloat2);
  }

  public void setTransformCallback(TransformCallback paramTransformCallback)
  {
    this.mTransformCallback = paramTransformCallback;
  }

  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.setVisible(paramBoolean1, paramBoolean2);
    return this.mCurrentDelegate.setVisible(paramBoolean1, paramBoolean2);
  }

  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.ForwardingDrawable
 * JD-Core Version:    0.6.0
 */
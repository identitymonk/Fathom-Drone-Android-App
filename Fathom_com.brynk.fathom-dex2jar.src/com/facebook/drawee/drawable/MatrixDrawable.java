package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;

public class MatrixDrawable extends ForwardingDrawable
{
  private Matrix mDrawMatrix;
  private Matrix mMatrix;
  private int mUnderlyingHeight = 0;
  private int mUnderlyingWidth = 0;

  public MatrixDrawable(Drawable paramDrawable, Matrix paramMatrix)
  {
    super((Drawable)Preconditions.checkNotNull(paramDrawable));
    this.mMatrix = paramMatrix;
  }

  private void configureBounds()
  {
    Drawable localDrawable = getCurrent();
    Rect localRect = getBounds();
    int i = localDrawable.getIntrinsicWidth();
    this.mUnderlyingWidth = i;
    int j = localDrawable.getIntrinsicHeight();
    this.mUnderlyingHeight = j;
    if ((i <= 0) || (j <= 0))
    {
      localDrawable.setBounds(localRect);
      this.mDrawMatrix = null;
      return;
    }
    localDrawable.setBounds(0, 0, i, j);
    this.mDrawMatrix = this.mMatrix;
  }

  private void configureBoundsIfUnderlyingChanged()
  {
    if ((this.mUnderlyingWidth != getCurrent().getIntrinsicWidth()) || (this.mUnderlyingHeight != getCurrent().getIntrinsicHeight()))
      configureBounds();
  }

  public void draw(Canvas paramCanvas)
  {
    configureBoundsIfUnderlyingChanged();
    if (this.mDrawMatrix != null)
    {
      int i = paramCanvas.save();
      paramCanvas.clipRect(getBounds());
      paramCanvas.concat(this.mDrawMatrix);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    }
    super.draw(paramCanvas);
  }

  public Matrix getMatrix()
  {
    return this.mMatrix;
  }

  public void getTransform(Matrix paramMatrix)
  {
    super.getTransform(paramMatrix);
    if (this.mDrawMatrix != null)
      paramMatrix.preConcat(this.mDrawMatrix);
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    configureBounds();
  }

  public Drawable setCurrent(Drawable paramDrawable)
  {
    paramDrawable = super.setCurrent(paramDrawable);
    configureBounds();
    return paramDrawable;
  }

  public void setMatrix(Matrix paramMatrix)
  {
    this.mMatrix = paramMatrix;
    configureBounds();
    invalidateSelf();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.MatrixDrawable
 * JD-Core Version:    0.6.0
 */
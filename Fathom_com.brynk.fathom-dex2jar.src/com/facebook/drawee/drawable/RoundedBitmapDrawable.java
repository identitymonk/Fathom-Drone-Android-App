package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import javax.annotation.Nullable;

public class RoundedBitmapDrawable extends BitmapDrawable
  implements TransformAwareDrawable, Rounded
{

  @VisibleForTesting
  final RectF mBitmapBounds = new RectF();
  private int mBorderColor = 0;
  private final Paint mBorderPaint = new Paint(1);
  private final Path mBorderPath = new Path();

  @VisibleForTesting
  final float[] mBorderRadii = new float[8];
  private float mBorderWidth = 0.0F;

  @VisibleForTesting
  final Matrix mBoundsTransform = new Matrix();
  private final float[] mCornerRadii = new float[8];

  @VisibleForTesting
  final RectF mDrawableBounds = new RectF();

  @VisibleForTesting
  final Matrix mInverseParentTransform = new Matrix();
  private boolean mIsCircle = false;
  private boolean mIsPathDirty = true;
  private boolean mIsShaderTransformDirty = true;
  private WeakReference<Bitmap> mLastBitmap;
  private float mPadding = 0.0F;
  private final Paint mPaint = new Paint();

  @VisibleForTesting
  final Matrix mParentTransform = new Matrix();
  private final Path mPath = new Path();

  @VisibleForTesting
  final Matrix mPrevBoundsTransform = new Matrix();

  @VisibleForTesting
  final Matrix mPrevParentTransform = new Matrix();

  @VisibleForTesting
  final RectF mPrevRootBounds = new RectF();
  private boolean mRadiiNonZero = false;

  @VisibleForTesting
  final RectF mRootBounds = new RectF();

  @VisibleForTesting
  final Matrix mTransform = new Matrix();

  @Nullable
  private TransformCallback mTransformCallback;

  public RoundedBitmapDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    this(paramResources, paramBitmap, null);
  }

  public RoundedBitmapDrawable(Resources paramResources, Bitmap paramBitmap, @Nullable Paint paramPaint)
  {
    super(paramResources, paramBitmap);
    if (paramPaint != null)
      this.mPaint.set(paramPaint);
    this.mPaint.setFlags(1);
    this.mBorderPaint.setStyle(Paint.Style.STROKE);
  }

  public static RoundedBitmapDrawable fromBitmapDrawable(Resources paramResources, BitmapDrawable paramBitmapDrawable)
  {
    return new RoundedBitmapDrawable(paramResources, paramBitmapDrawable.getBitmap(), paramBitmapDrawable.getPaint());
  }

  private void updatePaint()
  {
    Bitmap localBitmap = getBitmap();
    if ((this.mLastBitmap == null) || (this.mLastBitmap.get() != localBitmap))
    {
      this.mLastBitmap = new WeakReference(localBitmap);
      this.mPaint.setShader(new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
      this.mIsShaderTransformDirty = true;
    }
    if (this.mIsShaderTransformDirty)
    {
      this.mPaint.getShader().setLocalMatrix(this.mTransform);
      this.mIsShaderTransformDirty = false;
    }
  }

  private void updatePath()
  {
    if (this.mIsPathDirty)
    {
      this.mBorderPath.reset();
      this.mRootBounds.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
      if (!this.mIsCircle)
        break label211;
      float f = Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0F;
      this.mBorderPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), f, Path.Direction.CW);
      this.mRootBounds.inset(-this.mBorderWidth / 2.0F, -this.mBorderWidth / 2.0F);
      this.mPath.reset();
      this.mRootBounds.inset(this.mPadding, this.mPadding);
      if (!this.mIsCircle)
        break label274;
      this.mPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0F, Path.Direction.CW);
    }
    while (true)
    {
      this.mRootBounds.inset(-this.mPadding, -this.mPadding);
      this.mPath.setFillType(Path.FillType.WINDING);
      this.mIsPathDirty = false;
      return;
      label211: int i = 0;
      while (i < this.mBorderRadii.length)
      {
        this.mBorderRadii[i] = (this.mCornerRadii[i] + this.mPadding - this.mBorderWidth / 2.0F);
        i += 1;
      }
      this.mBorderPath.addRoundRect(this.mRootBounds, this.mBorderRadii, Path.Direction.CW);
      break;
      label274: this.mPath.addRoundRect(this.mRootBounds, this.mCornerRadii, Path.Direction.CW);
    }
  }

  private void updateTransform()
  {
    if (this.mTransformCallback != null)
    {
      this.mTransformCallback.getTransform(this.mParentTransform);
      this.mTransformCallback.getRootBounds(this.mRootBounds);
    }
    while (true)
    {
      this.mBitmapBounds.set(0.0F, 0.0F, getBitmap().getWidth(), getBitmap().getHeight());
      this.mDrawableBounds.set(getBounds());
      this.mBoundsTransform.setRectToRect(this.mBitmapBounds, this.mDrawableBounds, Matrix.ScaleToFit.FILL);
      if ((!this.mParentTransform.equals(this.mPrevParentTransform)) || (!this.mBoundsTransform.equals(this.mPrevBoundsTransform)))
      {
        this.mIsShaderTransformDirty = true;
        this.mParentTransform.invert(this.mInverseParentTransform);
        this.mTransform.set(this.mParentTransform);
        this.mTransform.preConcat(this.mBoundsTransform);
        this.mPrevParentTransform.set(this.mParentTransform);
        this.mPrevBoundsTransform.set(this.mBoundsTransform);
      }
      if (!this.mRootBounds.equals(this.mPrevRootBounds))
      {
        this.mIsPathDirty = true;
        this.mPrevRootBounds.set(this.mRootBounds);
      }
      return;
      this.mParentTransform.reset();
      this.mRootBounds.set(getBounds());
    }
  }

  public void draw(Canvas paramCanvas)
  {
    if (!shouldRound())
    {
      super.draw(paramCanvas);
      return;
    }
    updateTransform();
    updatePath();
    updatePaint();
    int i = paramCanvas.save();
    paramCanvas.concat(this.mInverseParentTransform);
    paramCanvas.drawPath(this.mPath, this.mPaint);
    if (this.mBorderWidth > 0.0F)
    {
      this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
      this.mBorderPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.mPaint.getAlpha()));
      paramCanvas.drawPath(this.mBorderPath, this.mBorderPaint);
    }
    paramCanvas.restoreToCount(i);
  }

  public int getBorderColor()
  {
    return this.mBorderColor;
  }

  public float getBorderWidth()
  {
    return this.mBorderWidth;
  }

  public float getPadding()
  {
    return this.mPadding;
  }

  public float[] getRadii()
  {
    return this.mCornerRadii;
  }

  public boolean isCircle()
  {
    return this.mIsCircle;
  }

  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mPaint.getAlpha())
    {
      this.mPaint.setAlpha(paramInt);
      super.setAlpha(paramInt);
      invalidateSelf();
    }
  }

  public void setBorder(int paramInt, float paramFloat)
  {
    if ((this.mBorderColor != paramInt) || (this.mBorderWidth != paramFloat))
    {
      this.mBorderColor = paramInt;
      this.mBorderWidth = paramFloat;
      this.mIsPathDirty = true;
      invalidateSelf();
    }
  }

  public void setCircle(boolean paramBoolean)
  {
    this.mIsCircle = paramBoolean;
    this.mIsPathDirty = true;
    invalidateSelf();
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    super.setColorFilter(paramColorFilter);
  }

  public void setPadding(float paramFloat)
  {
    if (this.mPadding != paramFloat)
    {
      this.mPadding = paramFloat;
      this.mIsPathDirty = true;
      invalidateSelf();
    }
  }

  public void setRadii(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
    {
      Arrays.fill(this.mCornerRadii, 0.0F);
      this.mRadiiNonZero = false;
      this.mIsPathDirty = true;
      invalidateSelf();
      return;
    }
    boolean bool2;
    label37: int i;
    if (paramArrayOfFloat.length == 8)
    {
      bool2 = true;
      Preconditions.checkArgument(bool2, "radii should have exactly 8 values");
      System.arraycopy(paramArrayOfFloat, 0, this.mCornerRadii, 0, 8);
      this.mRadiiNonZero = false;
      i = 0;
      label64: if (i < 8)
      {
        bool2 = this.mRadiiNonZero;
        if (paramArrayOfFloat[i] <= 0.0F)
          break label107;
      }
    }
    label107: for (boolean bool1 = true; ; bool1 = false)
    {
      this.mRadiiNonZero = (bool1 | bool2);
      i += 1;
      break label64;
      break;
      bool2 = false;
      break label37;
    }
  }

  public void setRadius(float paramFloat)
  {
    boolean bool2 = false;
    if (paramFloat >= 0.0F);
    for (boolean bool1 = true; ; bool1 = false)
    {
      Preconditions.checkState(bool1);
      Arrays.fill(this.mCornerRadii, paramFloat);
      bool1 = bool2;
      if (paramFloat != 0.0F)
        bool1 = true;
      this.mRadiiNonZero = bool1;
      this.mIsPathDirty = true;
      invalidateSelf();
      return;
    }
  }

  public void setTransformCallback(@Nullable TransformCallback paramTransformCallback)
  {
    this.mTransformCallback = paramTransformCallback;
  }

  @VisibleForTesting
  boolean shouldRound()
  {
    return (this.mIsCircle) || (this.mRadiiNonZero) || (this.mBorderWidth > 0.0F);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.RoundedBitmapDrawable
 * JD-Core Version:    0.6.0
 */
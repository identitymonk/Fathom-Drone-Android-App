package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;

public class ScalingUtils
{
  @Nullable
  public static ScaleTypeDrawable getActiveScaleTypeDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null)
      return null;
    if ((paramDrawable instanceof ScaleTypeDrawable))
      return (ScaleTypeDrawable)paramDrawable;
    if ((paramDrawable instanceof DrawableParent))
      return getActiveScaleTypeDrawable(((DrawableParent)paramDrawable).getDrawable());
    if ((paramDrawable instanceof ArrayDrawable))
    {
      paramDrawable = (ArrayDrawable)paramDrawable;
      int j = paramDrawable.getNumberOfLayers();
      int i = 0;
      while (i < j)
      {
        ScaleTypeDrawable localScaleTypeDrawable = getActiveScaleTypeDrawable(paramDrawable.getDrawable(i));
        if (localScaleTypeDrawable != null)
          return localScaleTypeDrawable;
        i += 1;
      }
    }
    return null;
  }

  public static abstract class AbstractScaleType
    implements ScalingUtils.ScaleType
  {
    public Matrix getTransform(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
    {
      getTransformImpl(paramMatrix, paramRect, paramInt1, paramInt2, paramFloat1, paramFloat2, paramRect.width() / paramInt1, paramRect.height() / paramInt2);
      return paramMatrix;
    }

    public abstract void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  }

  public static class InterpolatingScaleType
    implements ScalingUtils.ScaleType, ScalingUtils.StatefulScaleType
  {

    @Nullable
    private final Rect mBoundsFrom;

    @Nullable
    private final Rect mBoundsTo;
    private float mInterpolatingValue;
    private final float[] mMatrixValuesFrom = new float[9];
    private final float[] mMatrixValuesInterpolated = new float[9];
    private final float[] mMatrixValuesTo = new float[9];
    private final ScalingUtils.ScaleType mScaleTypeFrom;
    private final ScalingUtils.ScaleType mScaleTypeTo;

    public InterpolatingScaleType(ScalingUtils.ScaleType paramScaleType1, ScalingUtils.ScaleType paramScaleType2)
    {
      this(paramScaleType1, paramScaleType2, null, null);
    }

    public InterpolatingScaleType(ScalingUtils.ScaleType paramScaleType1, ScalingUtils.ScaleType paramScaleType2, @Nullable Rect paramRect1, @Nullable Rect paramRect2)
    {
      this.mScaleTypeFrom = paramScaleType1;
      this.mScaleTypeTo = paramScaleType2;
      this.mBoundsFrom = paramRect1;
      this.mBoundsTo = paramRect2;
    }

    @Nullable
    public Rect getBoundsFrom()
    {
      return this.mBoundsFrom;
    }

    @Nullable
    public Rect getBoundsTo()
    {
      return this.mBoundsTo;
    }

    public ScalingUtils.ScaleType getScaleTypeFrom()
    {
      return this.mScaleTypeFrom;
    }

    public ScalingUtils.ScaleType getScaleTypeTo()
    {
      return this.mScaleTypeTo;
    }

    public Object getState()
    {
      return Float.valueOf(this.mInterpolatingValue);
    }

    public Matrix getTransform(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
    {
      Rect localRect;
      if (this.mBoundsFrom != null)
      {
        localRect = this.mBoundsFrom;
        if (this.mBoundsTo == null)
          break label132;
        paramRect = this.mBoundsTo;
      }
      label132: 
      while (true)
      {
        this.mScaleTypeFrom.getTransform(paramMatrix, localRect, paramInt1, paramInt2, paramFloat1, paramFloat2);
        paramMatrix.getValues(this.mMatrixValuesFrom);
        this.mScaleTypeTo.getTransform(paramMatrix, paramRect, paramInt1, paramInt2, paramFloat1, paramFloat2);
        paramMatrix.getValues(this.mMatrixValuesTo);
        paramInt1 = 0;
        while (paramInt1 < 9)
        {
          this.mMatrixValuesInterpolated[paramInt1] = (this.mMatrixValuesFrom[paramInt1] * (1.0F - this.mInterpolatingValue) + this.mMatrixValuesTo[paramInt1] * this.mInterpolatingValue);
          paramInt1 += 1;
        }
        localRect = paramRect;
        break;
      }
      paramMatrix.setValues(this.mMatrixValuesInterpolated);
      return paramMatrix;
    }

    public float getValue()
    {
      return this.mInterpolatingValue;
    }

    public void setValue(float paramFloat)
    {
      this.mInterpolatingValue = paramFloat;
    }

    public String toString()
    {
      return String.format("InterpolatingScaleType(%s -> %s)", new Object[] { String.valueOf(this.mScaleTypeFrom), String.valueOf(this.mScaleTypeTo) });
    }
  }

  public static abstract interface ScaleType
  {
    public static final ScaleType CENTER;
    public static final ScaleType CENTER_CROP;
    public static final ScaleType CENTER_INSIDE;
    public static final ScaleType FIT_CENTER;
    public static final ScaleType FIT_END;
    public static final ScaleType FIT_START;
    public static final ScaleType FIT_XY = ScalingUtils.ScaleTypeFitXY.INSTANCE;
    public static final ScaleType FOCUS_CROP;

    static
    {
      FIT_START = ScalingUtils.ScaleTypeFitStart.INSTANCE;
      FIT_CENTER = ScalingUtils.ScaleTypeFitCenter.INSTANCE;
      FIT_END = ScalingUtils.ScaleTypeFitEnd.INSTANCE;
      CENTER = ScalingUtils.ScaleTypeCenter.INSTANCE;
      CENTER_INSIDE = ScalingUtils.ScaleTypeCenterInside.INSTANCE;
      CENTER_CROP = ScalingUtils.ScaleTypeCenterCrop.INSTANCE;
      FOCUS_CROP = ScalingUtils.ScaleTypeFocusCrop.INSTANCE;
    }

    public abstract Matrix getTransform(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2);
  }

  private static class ScaleTypeCenter extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeCenter();

    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      paramFloat1 = paramRect.left;
      paramFloat2 = paramRect.width() - paramInt1;
      paramFloat3 = paramRect.top;
      paramFloat4 = paramRect.height() - paramInt2;
      paramMatrix.setTranslate((int)(paramFloat1 + paramFloat2 * 0.5F + 0.5F), (int)(paramFloat3 + paramFloat4 * 0.5F + 0.5F));
    }

    public String toString()
    {
      return "center";
    }
  }

  private static class ScaleTypeCenterCrop extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeCenterCrop();

    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      if (paramFloat4 > paramFloat3)
      {
        paramFloat3 = paramFloat4;
        paramFloat1 = paramRect.left + (paramRect.width() - paramInt1 * paramFloat3) * 0.5F;
        paramFloat2 = paramRect.top;
      }
      while (true)
      {
        paramMatrix.setScale(paramFloat3, paramFloat3);
        paramMatrix.postTranslate((int)(paramFloat1 + 0.5F), (int)(paramFloat2 + 0.5F));
        return;
        paramFloat1 = paramRect.left;
        paramFloat2 = paramRect.top + (paramRect.height() - paramInt2 * paramFloat3) * 0.5F;
      }
    }

    public String toString()
    {
      return "center_crop";
    }
  }

  private static class ScaleTypeCenterInside extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeCenterInside();

    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      paramFloat1 = Math.min(Math.min(paramFloat3, paramFloat4), 1.0F);
      paramFloat2 = paramRect.left;
      paramFloat3 = paramRect.width();
      paramFloat4 = paramInt1;
      float f1 = paramRect.top;
      float f2 = paramRect.height();
      float f3 = paramInt2;
      paramMatrix.setScale(paramFloat1, paramFloat1);
      paramMatrix.postTranslate((int)(paramFloat2 + (paramFloat3 - paramFloat4 * paramFloat1) * 0.5F + 0.5F), (int)(f1 + (f2 - f3 * paramFloat1) * 0.5F + 0.5F));
    }

    public String toString()
    {
      return "center_inside";
    }
  }

  private static class ScaleTypeFitCenter extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeFitCenter();

    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      paramFloat1 = Math.min(paramFloat3, paramFloat4);
      paramFloat2 = paramRect.left;
      paramFloat3 = paramRect.width();
      paramFloat4 = paramInt1;
      float f1 = paramRect.top;
      float f2 = paramRect.height();
      float f3 = paramInt2;
      paramMatrix.setScale(paramFloat1, paramFloat1);
      paramMatrix.postTranslate((int)(paramFloat2 + (paramFloat3 - paramFloat4 * paramFloat1) * 0.5F + 0.5F), (int)(f1 + (f2 - f3 * paramFloat1) * 0.5F + 0.5F));
    }

    public String toString()
    {
      return "fit_center";
    }
  }

  private static class ScaleTypeFitEnd extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeFitEnd();

    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      paramFloat1 = Math.min(paramFloat3, paramFloat4);
      paramFloat2 = paramRect.left;
      paramFloat3 = paramRect.width();
      paramFloat4 = paramInt1;
      float f1 = paramRect.top;
      float f2 = paramRect.height();
      float f3 = paramInt2;
      paramMatrix.setScale(paramFloat1, paramFloat1);
      paramMatrix.postTranslate((int)(paramFloat2 + (paramFloat3 - paramFloat4 * paramFloat1) + 0.5F), (int)(f1 + (f2 - f3 * paramFloat1) + 0.5F));
    }

    public String toString()
    {
      return "fit_end";
    }
  }

  private static class ScaleTypeFitStart extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeFitStart();

    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      paramFloat1 = Math.min(paramFloat3, paramFloat4);
      paramFloat2 = paramRect.left;
      paramFloat3 = paramRect.top;
      paramMatrix.setScale(paramFloat1, paramFloat1);
      paramMatrix.postTranslate((int)(paramFloat2 + 0.5F), (int)(0.5F + paramFloat3));
    }

    public String toString()
    {
      return "fit_start";
    }
  }

  private static class ScaleTypeFitXY extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeFitXY();

    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      paramFloat1 = paramRect.left;
      paramFloat2 = paramRect.top;
      paramMatrix.setScale(paramFloat3, paramFloat4);
      paramMatrix.postTranslate((int)(paramFloat1 + 0.5F), (int)(0.5F + paramFloat2));
    }

    public String toString()
    {
      return "fit_xy";
    }
  }

  private static class ScaleTypeFocusCrop extends ScalingUtils.AbstractScaleType
  {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeFocusCrop();

    public void getTransformImpl(Matrix paramMatrix, Rect paramRect, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      if (paramFloat4 > paramFloat3)
      {
        paramFloat2 = paramRect.width();
        paramFloat3 = paramInt1;
        paramFloat1 = paramRect.left + Math.max(Math.min(paramFloat2 * 0.5F - paramFloat3 * paramFloat4 * paramFloat1, 0.0F), paramRect.width() - paramInt1 * paramFloat4);
        paramFloat2 = paramRect.top;
        paramFloat3 = paramFloat4;
      }
      while (true)
      {
        paramMatrix.setScale(paramFloat3, paramFloat3);
        paramMatrix.postTranslate((int)(0.5F + paramFloat1), (int)(0.5F + paramFloat2));
        return;
        paramFloat1 = paramRect.left;
        paramFloat4 = paramRect.height();
        float f = paramInt2;
        paramFloat2 = paramRect.top + Math.max(Math.min(paramFloat4 * 0.5F - f * paramFloat3 * paramFloat2, 0.0F), paramRect.height() - paramInt2 * paramFloat3);
      }
    }

    public String toString()
    {
      return "focus_crop";
    }
  }

  public static abstract interface StatefulScaleType
  {
    public abstract Object getState();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.drawee.drawable.ScalingUtils
 * JD-Core Version:    0.6.0
 */
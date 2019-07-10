package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

public abstract class ARTVirtualNode extends ReactShadowNodeImpl
{
  protected static final float MIN_OPACITY_FOR_DRAW = 0.01F;
  private static final float[] sMatrixData = new float[9];
  private static final float[] sRawMatrix = new float[9];

  @Nullable
  private Matrix mMatrix = new Matrix();
  protected float mOpacity = 1.0F;
  protected final float mScale = DisplayMetricsHolder.getWindowDisplayMetrics().density;

  public abstract void draw(Canvas paramCanvas, Paint paramPaint, float paramFloat);

  public boolean isVirtual()
  {
    return true;
  }

  protected void restoreCanvas(Canvas paramCanvas)
  {
    paramCanvas.restore();
  }

  protected final void saveAndSetupCanvas(Canvas paramCanvas)
  {
    paramCanvas.save();
    if (this.mMatrix != null)
      paramCanvas.concat(this.mMatrix);
  }

  @ReactProp(defaultFloat=1.0F, name="opacity")
  public void setOpacity(float paramFloat)
  {
    this.mOpacity = paramFloat;
    markUpdated();
  }

  @ReactProp(name="transform")
  public void setTransform(@Nullable ReadableArray paramReadableArray)
  {
    int i;
    if (paramReadableArray != null)
    {
      i = PropHelper.toFloatArray(paramReadableArray, sMatrixData);
      if (i == 6)
        setupMatrix();
    }
    while (true)
    {
      markUpdated();
      return;
      if (i == -1)
        continue;
      throw new JSApplicationIllegalArgumentException("Transform matrices must be of size 6");
      this.mMatrix = null;
    }
  }

  protected void setupMatrix()
  {
    sRawMatrix[0] = sMatrixData[0];
    sRawMatrix[1] = sMatrixData[2];
    sRawMatrix[2] = (sMatrixData[4] * this.mScale);
    sRawMatrix[3] = sMatrixData[1];
    sRawMatrix[4] = sMatrixData[3];
    sMatrixData[5] *= this.mScale;
    sRawMatrix[6] = 0.0F;
    sRawMatrix[7] = 0.0F;
    sRawMatrix[8] = 1.0F;
    if (this.mMatrix == null)
      this.mMatrix = new Matrix();
    this.mMatrix.setValues(sRawMatrix);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.art.ARTVirtualNode
 * JD-Core Version:    0.6.0
 */
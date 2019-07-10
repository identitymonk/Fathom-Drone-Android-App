package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

public class ARTShapeShadowNode extends ARTVirtualNode
{
  private static final int CAP_BUTT = 0;
  private static final int CAP_ROUND = 1;
  private static final int CAP_SQUARE = 2;
  private static final int COLOR_TYPE_LINEAR_GRADIENT = 1;
  private static final int COLOR_TYPE_PATTERN = 3;
  private static final int COLOR_TYPE_RADIAL_GRADIENT = 2;
  private static final int COLOR_TYPE_SOLID_COLOR = 0;
  private static final int JOIN_BEVEL = 2;
  private static final int JOIN_MITER = 0;
  private static final int JOIN_ROUND = 1;
  private static final int PATH_TYPE_ARC = 4;
  private static final int PATH_TYPE_CLOSE = 1;
  private static final int PATH_TYPE_CURVETO = 3;
  private static final int PATH_TYPE_LINETO = 2;
  private static final int PATH_TYPE_MOVETO = 0;

  @Nullable
  private float[] mBrushData;

  @Nullable
  protected Path mPath;
  private int mStrokeCap = 1;

  @Nullable
  private float[] mStrokeColor;

  @Nullable
  private float[] mStrokeDash;
  private int mStrokeJoin = 1;
  private float mStrokeWidth = 1.0F;

  private Path createPath(float[] paramArrayOfFloat)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      int j = i + 1;
      i = (int)paramArrayOfFloat[i];
      float f1;
      float f2;
      float f3;
      float f4;
      float f5;
      float f6;
      switch (i)
      {
      default:
        throw new JSApplicationIllegalArgumentException("Unrecognized drawing instruction " + i);
      case 0:
        i = j + 1;
        localPath.moveTo(paramArrayOfFloat[j] * this.mScale, paramArrayOfFloat[i] * this.mScale);
        i += 1;
        break;
      case 1:
        localPath.close();
        i = j;
        break;
      case 2:
        i = j + 1;
        localPath.lineTo(paramArrayOfFloat[j] * this.mScale, paramArrayOfFloat[i] * this.mScale);
        i += 1;
        break;
      case 3:
        i = j + 1;
        f1 = paramArrayOfFloat[j];
        f2 = this.mScale;
        j = i + 1;
        f3 = paramArrayOfFloat[i];
        f4 = this.mScale;
        i = j + 1;
        f5 = paramArrayOfFloat[j];
        f6 = this.mScale;
        j = i + 1;
        float f7 = paramArrayOfFloat[i];
        float f8 = this.mScale;
        i = j + 1;
        localPath.cubicTo(f1 * f2, f3 * f4, f5 * f6, f7 * f8, paramArrayOfFloat[j] * this.mScale, paramArrayOfFloat[i] * this.mScale);
        i += 1;
        break;
      case 4:
        i = j + 1;
        f3 = paramArrayOfFloat[j] * this.mScale;
        j = i + 1;
        f4 = paramArrayOfFloat[i] * this.mScale;
        i = j + 1;
        f5 = paramArrayOfFloat[j] * this.mScale;
        j = i + 1;
        f6 = (float)Math.toDegrees(paramArrayOfFloat[i]);
        int k = j + 1;
        f1 = (float)Math.toDegrees(paramArrayOfFloat[j]);
        i = k + 1;
        if (paramArrayOfFloat[k] != 1.0F)
        {
          j = 1;
          label420: f1 -= f6;
          if (Math.abs(f1) < 360.0F)
            break label475;
          if (j == 0)
            break label467;
        }
        label467: for (Path.Direction localDirection = Path.Direction.CCW; ; localDirection = Path.Direction.CW)
        {
          localPath.addCircle(f3, f4, f5, localDirection);
          break;
          j = 0;
          break label420;
        }
        label475: f2 = modulus(f1, 360.0F);
        f1 = f2;
        if (j != 0)
        {
          f1 = f2;
          if (f2 < 360.0F)
            f1 = -1.0F * (360.0F - f2);
        }
        localPath.arcTo(new RectF(f3 - f5, f4 - f5, f3 + f5, f4 + f5), f6, f1);
      }
    }
    return localPath;
  }

  private float modulus(float paramFloat1, float paramFloat2)
  {
    float f2 = paramFloat1 % paramFloat2;
    paramFloat1 = f2;
    float f1 = paramFloat1;
    if (f2 < 0.0F)
      f1 = paramFloat1 + paramFloat2;
    return f1;
  }

  public void draw(Canvas paramCanvas, Paint paramPaint, float paramFloat)
  {
    paramFloat *= this.mOpacity;
    if (paramFloat > 0.01F)
    {
      saveAndSetupCanvas(paramCanvas);
      if (this.mPath == null)
        throw new JSApplicationIllegalArgumentException("Shapes should have a valid path (d) prop");
      if (setupFillPaint(paramPaint, paramFloat))
        paramCanvas.drawPath(this.mPath, paramPaint);
      if (setupStrokePaint(paramPaint, paramFloat))
        paramCanvas.drawPath(this.mPath, paramPaint);
      restoreCanvas(paramCanvas);
    }
    markUpdateSeen();
  }

  @ReactProp(name="fill")
  public void setFill(@Nullable ReadableArray paramReadableArray)
  {
    this.mBrushData = PropHelper.toFloatArray(paramReadableArray);
    markUpdated();
  }

  @ReactProp(name="d")
  public void setShapePath(@Nullable ReadableArray paramReadableArray)
  {
    this.mPath = createPath(PropHelper.toFloatArray(paramReadableArray));
    markUpdated();
  }

  @ReactProp(name="stroke")
  public void setStroke(@Nullable ReadableArray paramReadableArray)
  {
    this.mStrokeColor = PropHelper.toFloatArray(paramReadableArray);
    markUpdated();
  }

  @ReactProp(defaultInt=1, name="strokeCap")
  public void setStrokeCap(int paramInt)
  {
    this.mStrokeCap = paramInt;
    markUpdated();
  }

  @ReactProp(name="strokeDash")
  public void setStrokeDash(@Nullable ReadableArray paramReadableArray)
  {
    this.mStrokeDash = PropHelper.toFloatArray(paramReadableArray);
    markUpdated();
  }

  @ReactProp(defaultInt=1, name="strokeJoin")
  public void setStrokeJoin(int paramInt)
  {
    this.mStrokeJoin = paramInt;
    markUpdated();
  }

  @ReactProp(defaultFloat=1.0F, name="strokeWidth")
  public void setStrokeWidth(float paramFloat)
  {
    this.mStrokeWidth = paramFloat;
    markUpdated();
  }

  protected boolean setupFillPaint(Paint paramPaint, float paramFloat)
  {
    if ((this.mBrushData != null) && (this.mBrushData.length > 0))
    {
      paramPaint.reset();
      paramPaint.setFlags(1);
      paramPaint.setStyle(Paint.Style.FILL);
      int i = (int)this.mBrushData[0];
      switch (i)
      {
      default:
        FLog.w("ReactNative", "ART: Color type " + i + " not supported!");
      case 0:
      case 1:
      }
      while (true)
      {
        return true;
        if (this.mBrushData.length > 4)
          paramFloat = this.mBrushData[4] * paramFloat * 255.0F;
        while (true)
        {
          paramPaint.setARGB((int)paramFloat, (int)(this.mBrushData[1] * 255.0F), (int)(this.mBrushData[2] * 255.0F), (int)(this.mBrushData[3] * 255.0F));
          break;
          paramFloat = 255.0F * paramFloat;
        }
        if (this.mBrushData.length < 5)
        {
          FLog.w("ReactNative", "[ARTShapeShadowNode setupFillPaint] expects 5 elements, received " + this.mBrushData.length);
          return false;
        }
        paramFloat = this.mBrushData[1];
        float f1 = this.mScale;
        float f2 = this.mBrushData[2];
        float f3 = this.mScale;
        float f4 = this.mBrushData[3];
        float f5 = this.mScale;
        float f6 = this.mBrushData[4];
        float f7 = this.mScale;
        int j = (this.mBrushData.length - 5) / 5;
        Object localObject1 = null;
        Object localObject2 = null;
        if (j > 0)
        {
          int[] arrayOfInt = new int[j];
          float[] arrayOfFloat = new float[j];
          i = 0;
          while (true)
          {
            localObject1 = arrayOfInt;
            localObject2 = arrayOfFloat;
            if (i >= j)
              break;
            arrayOfFloat[i] = this.mBrushData[(j * 4 + 5 + i)];
            int k = (int)(255.0F * this.mBrushData[(i * 4 + 5 + 0)]);
            int m = (int)(255.0F * this.mBrushData[(i * 4 + 5 + 1)]);
            int n = (int)(255.0F * this.mBrushData[(i * 4 + 5 + 2)]);
            arrayOfInt[i] = Color.argb((int)(255.0F * this.mBrushData[(i * 4 + 5 + 3)]), k, m, n);
            i += 1;
          }
        }
        paramPaint.setShader(new LinearGradient(paramFloat * f1, f2 * f3, f4 * f5, f6 * f7, localObject1, localObject2, Shader.TileMode.CLAMP));
      }
    }
    return false;
  }

  protected boolean setupStrokePaint(Paint paramPaint, float paramFloat)
  {
    if ((this.mStrokeWidth == 0.0F) || (this.mStrokeColor == null) || (this.mStrokeColor.length == 0))
      return false;
    paramPaint.reset();
    paramPaint.setFlags(1);
    paramPaint.setStyle(Paint.Style.STROKE);
    switch (this.mStrokeCap)
    {
    default:
      throw new JSApplicationIllegalArgumentException("strokeCap " + this.mStrokeCap + " unrecognized");
    case 0:
      paramPaint.setStrokeCap(Paint.Cap.BUTT);
    case 2:
    case 1:
    }
    while (true)
      switch (this.mStrokeJoin)
      {
      default:
        throw new JSApplicationIllegalArgumentException("strokeJoin " + this.mStrokeJoin + " unrecognized");
        paramPaint.setStrokeCap(Paint.Cap.SQUARE);
        continue;
        paramPaint.setStrokeCap(Paint.Cap.ROUND);
      case 0:
      case 2:
      case 1:
      }
    paramPaint.setStrokeJoin(Paint.Join.MITER);
    paramPaint.setStrokeWidth(this.mStrokeWidth * this.mScale);
    if (this.mStrokeColor.length > 3)
      paramFloat = this.mStrokeColor[3] * paramFloat * 255.0F;
    while (true)
    {
      paramPaint.setARGB((int)paramFloat, (int)(this.mStrokeColor[0] * 255.0F), (int)(this.mStrokeColor[1] * 255.0F), (int)(this.mStrokeColor[2] * 255.0F));
      if ((this.mStrokeDash != null) && (this.mStrokeDash.length > 0))
        paramPaint.setPathEffect(new DashPathEffect(this.mStrokeDash, 0.0F));
      return true;
      paramPaint.setStrokeJoin(Paint.Join.BEVEL);
      break;
      paramPaint.setStrokeJoin(Paint.Join.ROUND);
      break;
      paramFloat *= 255.0F;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.art.ARTShapeShadowNode
 * JD-Core Version:    0.6.0
 */
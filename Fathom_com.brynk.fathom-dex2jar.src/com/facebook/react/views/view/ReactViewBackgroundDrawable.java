package com.facebook.react.views.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.Spacing;
import com.facebook.yoga.YogaConstants;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.Nullable;

public class ReactViewBackgroundDrawable extends Drawable
{
  private static final int ALL_BITS_SET = -1;
  private static final int ALL_BITS_UNSET = 0;
  private static final int DEFAULT_BORDER_ALPHA = 255;
  private static final int DEFAULT_BORDER_COLOR = -16777216;
  private static final int DEFAULT_BORDER_RGB = 0;
  private int mAlpha = 255;

  @Nullable
  private Spacing mBorderAlpha;

  @Nullable
  private float[] mBorderCornerRadii;

  @Nullable
  private Spacing mBorderRGB;
  private float mBorderRadius = (0.0F / 0.0F);

  @Nullable
  private BorderStyle mBorderStyle;

  @Nullable
  private Spacing mBorderWidth;
  private int mColor = 0;
  private boolean mNeedUpdatePathForBorderRadius = false;
  private final Paint mPaint = new Paint(1);

  @Nullable
  private PathEffect mPathEffectForBorderStyle;

  @Nullable
  private Path mPathForBorder;

  @Nullable
  private Path mPathForBorderRadius;

  @Nullable
  private Path mPathForBorderRadiusOutline;

  @Nullable
  private RectF mTempRectForBorderRadius;

  @Nullable
  private RectF mTempRectForBorderRadiusOutline;

  private static int colorFromAlphaAndRGBComponents(float paramFloat1, float paramFloat2)
  {
    return 0xFFFFFF & (int)paramFloat2 | 0xFF000000 & (int)paramFloat1 << 24;
  }

  private void drawRectangularBackgroundWithBorders(Canvas paramCanvas)
  {
    int i = ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha);
    if (Color.alpha(i) != 0)
    {
      this.mPaint.setColor(i);
      this.mPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(getBounds(), this.mPaint);
    }
    Rect localRect;
    int j;
    int k;
    int m;
    int i2;
    int i3;
    int i4;
    int i5;
    int n;
    int i1;
    if ((getBorderWidth(0) > 0) || (getBorderWidth(1) > 0) || (getBorderWidth(2) > 0) || (getBorderWidth(3) > 0))
    {
      localRect = getBounds();
      i = getBorderWidth(0);
      j = getBorderWidth(1);
      k = getBorderWidth(2);
      m = getBorderWidth(3);
      i2 = getBorderColor(0);
      i3 = getBorderColor(1);
      i4 = getBorderColor(2);
      i5 = getBorderColor(3);
      n = localRect.left;
      i1 = localRect.top;
      i6 = fastBorderCompatibleColorOrZero(i, j, k, m, i2, i3, i4, i5);
      if (i6 == 0)
        break label329;
      if (Color.alpha(i6) != 0)
      {
        i2 = localRect.right;
        i3 = localRect.bottom;
        this.mPaint.setColor(i6);
        if (i > 0)
          paramCanvas.drawRect(n, i1, n + i, i3 - m, this.mPaint);
        if (j > 0)
          paramCanvas.drawRect(n + i, i1, i2, i1 + j, this.mPaint);
        if (k > 0)
          paramCanvas.drawRect(i2 - k, i1 + j, i2, i3, this.mPaint);
        if (m > 0)
          paramCanvas.drawRect(n, i3 - m, i2 - k, i3, this.mPaint);
      }
    }
    return;
    label329: if (this.mPathForBorder == null)
      this.mPathForBorder = new Path();
    this.mPaint.setAntiAlias(false);
    int i6 = localRect.width();
    int i7 = localRect.height();
    if ((i > 0) && (i2 != 0))
    {
      this.mPaint.setColor(i2);
      this.mPathForBorder.reset();
      this.mPathForBorder.moveTo(n, i1);
      this.mPathForBorder.lineTo(n + i, i1 + j);
      this.mPathForBorder.lineTo(n + i, i1 + i7 - m);
      this.mPathForBorder.lineTo(n, i1 + i7);
      this.mPathForBorder.lineTo(n, i1);
      paramCanvas.drawPath(this.mPathForBorder, this.mPaint);
    }
    if ((j > 0) && (i3 != 0))
    {
      this.mPaint.setColor(i3);
      this.mPathForBorder.reset();
      this.mPathForBorder.moveTo(n, i1);
      this.mPathForBorder.lineTo(n + i, i1 + j);
      this.mPathForBorder.lineTo(n + i6 - k, i1 + j);
      this.mPathForBorder.lineTo(n + i6, i1);
      this.mPathForBorder.lineTo(n, i1);
      paramCanvas.drawPath(this.mPathForBorder, this.mPaint);
    }
    if ((k > 0) && (i4 != 0))
    {
      this.mPaint.setColor(i4);
      this.mPathForBorder.reset();
      this.mPathForBorder.moveTo(n + i6, i1);
      this.mPathForBorder.lineTo(n + i6, i1 + i7);
      this.mPathForBorder.lineTo(n + i6 - k, i1 + i7 - m);
      this.mPathForBorder.lineTo(n + i6 - k, i1 + j);
      this.mPathForBorder.lineTo(n + i6, i1);
      paramCanvas.drawPath(this.mPathForBorder, this.mPaint);
    }
    if ((m > 0) && (i5 != 0))
    {
      this.mPaint.setColor(i5);
      this.mPathForBorder.reset();
      this.mPathForBorder.moveTo(n, i1 + i7);
      this.mPathForBorder.lineTo(n + i6, i1 + i7);
      this.mPathForBorder.lineTo(n + i6 - k, i1 + i7 - m);
      this.mPathForBorder.lineTo(n + i, i1 + i7 - m);
      this.mPathForBorder.lineTo(n, i1 + i7);
      paramCanvas.drawPath(this.mPathForBorder, this.mPaint);
    }
    this.mPaint.setAntiAlias(true);
  }

  private void drawRoundedBackgroundWithBorders(Canvas paramCanvas)
  {
    updatePath();
    int i = ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha);
    if (Color.alpha(i) != 0)
    {
      this.mPaint.setColor(i);
      this.mPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawPath(this.mPathForBorderRadius, this.mPaint);
    }
    float f = getFullBorderWidth();
    if (f > 0.0F)
    {
      i = getFullBorderColor();
      this.mPaint.setColor(ColorUtil.multiplyColorAlpha(i, this.mAlpha));
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeWidth(f);
      paramCanvas.drawPath(this.mPathForBorderRadius, this.mPaint);
    }
  }

  private static int fastBorderCompatibleColorOrZero(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int m = -1;
    int i;
    int j;
    label19: int k;
    if (paramInt1 > 0)
    {
      i = paramInt5;
      if (paramInt2 <= 0)
        break label89;
      j = paramInt6;
      if (paramInt3 <= 0)
        break label95;
      k = paramInt7;
      label27: if (paramInt4 > 0)
        m = paramInt8;
      i = k & (i & j) & m;
      if (paramInt1 <= 0)
        break label101;
      label52: if (paramInt2 <= 0)
        break label107;
      label56: if (paramInt3 <= 0)
        break label113;
      label60: if (paramInt4 <= 0)
        break label119;
    }
    while (true)
    {
      if (i != (paramInt5 | paramInt6 | paramInt7 | paramInt8))
        break label125;
      return i;
      i = -1;
      break;
      label89: j = -1;
      break label19;
      label95: k = -1;
      break label27;
      label101: paramInt5 = 0;
      break label52;
      label107: paramInt6 = 0;
      break label56;
      label113: paramInt7 = 0;
      break label60;
      label119: paramInt8 = 0;
    }
    label125: return 0;
  }

  private int getBorderColor(int paramInt)
  {
    float f1;
    float f2;
    if (this.mBorderRGB != null)
    {
      f1 = this.mBorderRGB.get(paramInt);
      if (this.mBorderAlpha == null)
        break label43;
      f2 = this.mBorderAlpha.get(paramInt);
    }
    while (true)
    {
      return colorFromAlphaAndRGBComponents(f2, f1);
      f1 = 0.0F;
      break;
      label43: f2 = 255.0F;
    }
  }

  private int getBorderWidth(int paramInt)
  {
    if (this.mBorderWidth != null)
      return Math.round(this.mBorderWidth.get(paramInt));
    return 0;
  }

  private int getFullBorderColor()
  {
    float f1;
    float f2;
    if ((this.mBorderRGB != null) && (!YogaConstants.isUndefined(this.mBorderRGB.getRaw(8))))
    {
      f1 = this.mBorderRGB.getRaw(8);
      if ((this.mBorderAlpha == null) || (YogaConstants.isUndefined(this.mBorderAlpha.getRaw(8))))
        break label75;
      f2 = this.mBorderAlpha.getRaw(8);
    }
    while (true)
    {
      return colorFromAlphaAndRGBComponents(f2, f1);
      f1 = 0.0F;
      break;
      label75: f2 = 255.0F;
    }
  }

  private void setBorderAlpha(int paramInt, float paramFloat)
  {
    if (this.mBorderAlpha == null)
      this.mBorderAlpha = new Spacing(255.0F);
    if (!FloatUtil.floatsEqual(this.mBorderAlpha.getRaw(paramInt), paramFloat))
    {
      this.mBorderAlpha.set(paramInt, paramFloat);
      invalidateSelf();
    }
  }

  private void setBorderRGB(int paramInt, float paramFloat)
  {
    if (this.mBorderRGB == null)
      this.mBorderRGB = new Spacing(0.0F);
    if (!FloatUtil.floatsEqual(this.mBorderRGB.getRaw(paramInt), paramFloat))
    {
      this.mBorderRGB.set(paramInt, paramFloat);
      invalidateSelf();
    }
  }

  private void updatePath()
  {
    if (!this.mNeedUpdatePathForBorderRadius)
      return;
    this.mNeedUpdatePathForBorderRadius = false;
    if (this.mPathForBorderRadius == null)
    {
      this.mPathForBorderRadius = new Path();
      this.mTempRectForBorderRadius = new RectF();
      this.mPathForBorderRadiusOutline = new Path();
      this.mTempRectForBorderRadiusOutline = new RectF();
    }
    this.mPathForBorderRadius.reset();
    this.mPathForBorderRadiusOutline.reset();
    this.mTempRectForBorderRadius.set(getBounds());
    this.mTempRectForBorderRadiusOutline.set(getBounds());
    float f1 = getFullBorderWidth();
    if (f1 > 0.0F)
      this.mTempRectForBorderRadius.inset(0.5F * f1, 0.5F * f1);
    float f2;
    label167: float f3;
    label193: float f4;
    if (!YogaConstants.isUndefined(this.mBorderRadius))
    {
      f1 = this.mBorderRadius;
      if ((this.mBorderCornerRadii == null) || (YogaConstants.isUndefined(this.mBorderCornerRadii[0])))
        break label431;
      f2 = this.mBorderCornerRadii[0];
      if ((this.mBorderCornerRadii == null) || (YogaConstants.isUndefined(this.mBorderCornerRadii[1])))
        break label436;
      f3 = this.mBorderCornerRadii[1];
      if ((this.mBorderCornerRadii == null) || (YogaConstants.isUndefined(this.mBorderCornerRadii[2])))
        break label441;
      f4 = this.mBorderCornerRadii[2];
      label220: if ((this.mBorderCornerRadii == null) || (YogaConstants.isUndefined(this.mBorderCornerRadii[3])))
        break label447;
      f1 = this.mBorderCornerRadii[3];
    }
    label431: label436: label441: label447: 
    while (true)
    {
      Path localPath = this.mPathForBorderRadius;
      RectF localRectF = this.mTempRectForBorderRadius;
      Path.Direction localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { f2, f2, f3, f3, f4, f4, f1, f1 }, localDirection);
      float f5 = 0.0F;
      if (this.mBorderWidth != null)
        f5 = this.mBorderWidth.get(8) / 2.0F;
      localPath = this.mPathForBorderRadiusOutline;
      localRectF = this.mTempRectForBorderRadiusOutline;
      localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { f2 + f5, f2 + f5, f3 + f5, f3 + f5, f4 + f5, f4 + f5, f1 + f5, f1 + f5 }, localDirection);
      return;
      f1 = 0.0F;
      break;
      f2 = f1;
      break label167;
      f3 = f1;
      break label193;
      f4 = f1;
      break label220;
    }
  }

  private void updatePathEffect()
  {
    if (this.mBorderStyle != null);
    for (PathEffect localPathEffect = this.mBorderStyle.getPathEffect(getFullBorderWidth()); ; localPathEffect = null)
    {
      this.mPathEffectForBorderStyle = localPathEffect;
      this.mPaint.setPathEffect(this.mPathEffectForBorderStyle);
      return;
    }
  }

  public void draw(Canvas paramCanvas)
  {
    updatePathEffect();
    if ((this.mBorderCornerRadii != null) || ((!YogaConstants.isUndefined(this.mBorderRadius)) && (this.mBorderRadius > 0.0F)));
    for (int i = 1; i == 0; i = 0)
    {
      drawRectangularBackgroundWithBorders(paramCanvas);
      return;
    }
    drawRoundedBackgroundWithBorders(paramCanvas);
  }

  public int getAlpha()
  {
    return this.mAlpha;
  }

  @VisibleForTesting
  public int getColor()
  {
    return this.mColor;
  }

  public float getFullBorderWidth()
  {
    if ((this.mBorderWidth != null) && (!YogaConstants.isUndefined(this.mBorderWidth.getRaw(8))))
      return this.mBorderWidth.getRaw(8);
    return 0.0F;
  }

  public int getOpacity()
  {
    return ColorUtil.getOpacityFromColor(ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha));
  }

  public void getOutline(Outline paramOutline)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      super.getOutline(paramOutline);
      return;
    }
    if (((!YogaConstants.isUndefined(this.mBorderRadius)) && (this.mBorderRadius > 0.0F)) || (this.mBorderCornerRadii != null))
    {
      updatePath();
      paramOutline.setConvexPath(this.mPathForBorderRadiusOutline);
      return;
    }
    paramOutline.setRect(getBounds());
  }

  public float getRadius()
  {
    return this.mBorderRadius;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mNeedUpdatePathForBorderRadius = true;
  }

  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mAlpha)
    {
      this.mAlpha = paramInt;
      invalidateSelf();
    }
  }

  public void setBorderColor(int paramInt, float paramFloat1, float paramFloat2)
  {
    setBorderRGB(paramInt, paramFloat1);
    setBorderAlpha(paramInt, paramFloat2);
  }

  public void setBorderStyle(@Nullable String paramString)
  {
    if (paramString == null);
    for (paramString = null; ; paramString = BorderStyle.valueOf(paramString.toUpperCase(Locale.US)))
    {
      if (this.mBorderStyle != paramString)
      {
        this.mBorderStyle = paramString;
        this.mNeedUpdatePathForBorderRadius = true;
        invalidateSelf();
      }
      return;
    }
  }

  public void setBorderWidth(int paramInt, float paramFloat)
  {
    if (this.mBorderWidth == null)
      this.mBorderWidth = new Spacing();
    if (!FloatUtil.floatsEqual(this.mBorderWidth.getRaw(paramInt), paramFloat))
    {
      this.mBorderWidth.set(paramInt, paramFloat);
      if (paramInt == 8)
        this.mNeedUpdatePathForBorderRadius = true;
      invalidateSelf();
    }
  }

  public void setColor(int paramInt)
  {
    this.mColor = paramInt;
    invalidateSelf();
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }

  public void setRadius(float paramFloat)
  {
    if (!FloatUtil.floatsEqual(this.mBorderRadius, paramFloat))
    {
      this.mBorderRadius = paramFloat;
      this.mNeedUpdatePathForBorderRadius = true;
      invalidateSelf();
    }
  }

  public void setRadius(float paramFloat, int paramInt)
  {
    if (this.mBorderCornerRadii == null)
    {
      this.mBorderCornerRadii = new float[4];
      Arrays.fill(this.mBorderCornerRadii, (0.0F / 0.0F));
    }
    if (!FloatUtil.floatsEqual(this.mBorderCornerRadii[paramInt], paramFloat))
    {
      this.mBorderCornerRadii[paramInt] = paramFloat;
      this.mNeedUpdatePathForBorderRadius = true;
      invalidateSelf();
    }
  }

  private static enum BorderStyle
  {
    static
    {
      DASHED = new BorderStyle("DASHED", 1);
      DOTTED = new BorderStyle("DOTTED", 2);
      $VALUES = new BorderStyle[] { SOLID, DASHED, DOTTED };
    }

    @Nullable
    public PathEffect getPathEffect(float paramFloat)
    {
      switch (ReactViewBackgroundDrawable.1.$SwitchMap$com$facebook$react$views$view$ReactViewBackgroundDrawable$BorderStyle[ordinal()])
      {
      default:
        return null;
      case 1:
        return null;
      case 2:
        return new DashPathEffect(new float[] { paramFloat * 3.0F, paramFloat * 3.0F, paramFloat * 3.0F, 3.0F * paramFloat }, 0.0F);
      case 3:
      }
      return new DashPathEffect(new float[] { paramFloat, paramFloat, paramFloat, paramFloat }, 0.0F);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.view.ReactViewBackgroundDrawable
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.flat;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import javax.annotation.Nullable;

final class DrawBorder extends AbstractDrawBorder
{
  private static final int ALL_BITS_SET = -1;
  private static final int ALL_BITS_UNSET = 0;
  private static final int BORDER_BOTTOM_COLOR_SET = 16;
  private static final int BORDER_LEFT_COLOR_SET = 2;
  private static final int BORDER_PATH_EFFECT_DIRTY = 32;
  private static final int BORDER_RIGHT_COLOR_SET = 8;
  private static final int BORDER_STYLE_DASHED = 2;
  private static final int BORDER_STYLE_DOTTED = 1;
  private static final int BORDER_STYLE_SOLID = 0;
  private static final int BORDER_TOP_COLOR_SET = 4;
  private static final Paint PAINT = new Paint(1);
  private static final float[] TMP_FLOAT_ARRAY = new float[4];
  private int mBackgroundColor;
  private int mBorderBottomColor;
  private float mBorderBottomWidth;
  private int mBorderLeftColor;
  private float mBorderLeftWidth;
  private int mBorderRightColor;
  private float mBorderRightWidth;
  private int mBorderStyle = 0;
  private int mBorderTopColor;
  private float mBorderTopWidth;

  @Nullable
  private DashPathEffect mPathEffectForBorderStyle;

  @Nullable
  private Path mPathForBorder;

  private static DashPathEffect createDashPathEffect(float paramFloat)
  {
    int i = 0;
    while (i < 4)
    {
      TMP_FLOAT_ARRAY[i] = paramFloat;
      i += 1;
    }
    return new DashPathEffect(TMP_FLOAT_ARRAY, 0.0F);
  }

  private void drawRectangularBorders(Canvas paramCanvas)
  {
    int m = getBorderColor();
    float f11 = getBorderWidth();
    float f1 = getTop();
    float f2 = resolveWidth(this.mBorderTopWidth, f11);
    float f3 = f1 + f2;
    int i = resolveBorderColor(4, this.mBorderTopColor, m);
    float f4 = getBottom();
    float f5 = resolveWidth(this.mBorderBottomWidth, f11);
    float f6 = f4 - f5;
    int j = resolveBorderColor(16, this.mBorderBottomColor, m);
    float f7 = getLeft();
    float f8 = resolveWidth(this.mBorderLeftWidth, f11);
    float f9 = f7 + f8;
    int k = resolveBorderColor(2, this.mBorderLeftColor, m);
    float f10 = getRight();
    f11 = resolveWidth(this.mBorderRightWidth, f11);
    float f12 = f10 - f11;
    m = resolveBorderColor(8, this.mBorderRightColor, m);
    int n = fastBorderCompatibleColorOrZero(f8, f2, f11, f5, k, i, m, j);
    if (n != 0)
      if (Color.alpha(n) != 0)
      {
        if (Color.alpha(this.mBackgroundColor) != 0)
        {
          PAINT.setColor(this.mBackgroundColor);
          if (Color.alpha(n) != 255)
            break label341;
          paramCanvas.drawRect(f9, f3, f12, f6, PAINT);
        }
        PAINT.setColor(n);
        if (f8 > 0.0F)
          paramCanvas.drawRect(f7, f1, f9, f4 - f5, PAINT);
        if (f2 > 0.0F)
          paramCanvas.drawRect(f7 + f8, f1, f10, f3, PAINT);
        if (f11 > 0.0F)
          paramCanvas.drawRect(f12, f1 + f2, f10, f4, PAINT);
        if (f5 > 0.0F)
          paramCanvas.drawRect(f7, f6, f10 - f11, f4, PAINT);
      }
    label341: 
    do
    {
      return;
      paramCanvas.drawRect(f7, f1, f10, f4, PAINT);
      break;
      if (this.mPathForBorder == null)
        this.mPathForBorder = new Path();
      if (Color.alpha(this.mBackgroundColor) != 0)
      {
        PAINT.setColor(this.mBackgroundColor);
        paramCanvas.drawRect(f7, f1, f10, f4, PAINT);
      }
      if ((f2 != 0.0F) && (Color.alpha(i) != 0))
      {
        PAINT.setColor(i);
        updatePathForTopBorder(this.mPathForBorder, f1, f3, f7, f9, f10, f12);
        paramCanvas.drawPath(this.mPathForBorder, PAINT);
      }
      if ((f5 != 0.0F) && (Color.alpha(j) != 0))
      {
        PAINT.setColor(j);
        updatePathForBottomBorder(this.mPathForBorder, f4, f6, f7, f9, f10, f12);
        paramCanvas.drawPath(this.mPathForBorder, PAINT);
      }
      if ((f8 == 0.0F) || (Color.alpha(k) == 0))
        continue;
      PAINT.setColor(k);
      updatePathForLeftBorder(this.mPathForBorder, f1, f3, f4, f6, f7, f9);
      paramCanvas.drawPath(this.mPathForBorder, PAINT);
    }
    while ((f11 == 0.0F) || (Color.alpha(m) == 0));
    PAINT.setColor(m);
    updatePathForRightBorder(this.mPathForBorder, f1, f3, f4, f6, f10, f12);
    paramCanvas.drawPath(this.mPathForBorder, PAINT);
  }

  private void drawRoundedBorders(Canvas paramCanvas)
  {
    if (this.mBackgroundColor != 0)
    {
      PAINT.setColor(this.mBackgroundColor);
      paramCanvas.drawPath(getPathForBorderRadius(), PAINT);
    }
    drawBorders(paramCanvas);
  }

  private static int fastBorderCompatibleColorOrZero(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = -1;
    int i;
    int j;
    label23: int k;
    if (paramFloat1 > 0.0F)
    {
      i = paramInt1;
      if (paramFloat2 <= 0.0F)
        break label105;
      j = paramInt2;
      if (paramFloat3 <= 0.0F)
        break label111;
      k = paramInt3;
      label33: if (paramFloat4 > 0.0F)
        m = paramInt4;
      i = k & (i & j) & m;
      if (paramFloat1 <= 0.0F)
        break label117;
      label62: if (paramFloat2 <= 0.0F)
        break label123;
      label68: if (paramFloat3 <= 0.0F)
        break label129;
      label74: if (paramFloat4 <= 0.0F)
        break label135;
    }
    while (true)
    {
      if (i != (paramInt1 | paramInt2 | paramInt3 | paramInt4))
        break label141;
      return i;
      i = -1;
      break;
      label105: j = -1;
      break label23;
      label111: k = -1;
      break label33;
      label117: paramInt1 = 0;
      break label62;
      label123: paramInt2 = 0;
      break label68;
      label129: paramInt3 = 0;
      break label74;
      label135: paramInt4 = 0;
    }
    label141: return 0;
  }

  private int resolveBorderColor(int paramInt1, int paramInt2, int paramInt3)
  {
    if (isFlagSet(paramInt1))
      return paramInt2;
    return paramInt3;
  }

  private static float resolveWidth(float paramFloat1, float paramFloat2)
  {
    float f;
    if (paramFloat1 != 0.0F)
    {
      f = paramFloat1;
      if (paramFloat1 == paramFloat1);
    }
    else
    {
      f = paramFloat2;
    }
    return f;
  }

  private static void updatePathForBottomBorder(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    paramPath.reset();
    paramPath.moveTo(paramFloat3, paramFloat1);
    paramPath.lineTo(paramFloat5, paramFloat1);
    paramPath.lineTo(paramFloat6, paramFloat2);
    paramPath.lineTo(paramFloat4, paramFloat2);
    paramPath.lineTo(paramFloat3, paramFloat1);
  }

  private static void updatePathForLeftBorder(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    paramPath.reset();
    paramPath.moveTo(paramFloat5, paramFloat1);
    paramPath.lineTo(paramFloat6, paramFloat2);
    paramPath.lineTo(paramFloat6, paramFloat4);
    paramPath.lineTo(paramFloat5, paramFloat3);
    paramPath.lineTo(paramFloat5, paramFloat1);
  }

  private static void updatePathForRightBorder(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    paramPath.reset();
    paramPath.moveTo(paramFloat5, paramFloat1);
    paramPath.lineTo(paramFloat5, paramFloat3);
    paramPath.lineTo(paramFloat6, paramFloat4);
    paramPath.lineTo(paramFloat6, paramFloat2);
    paramPath.lineTo(paramFloat5, paramFloat1);
  }

  private static void updatePathForTopBorder(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    paramPath.reset();
    paramPath.moveTo(paramFloat3, paramFloat1);
    paramPath.lineTo(paramFloat4, paramFloat2);
    paramPath.lineTo(paramFloat6, paramFloat2);
    paramPath.lineTo(paramFloat5, paramFloat1);
    paramPath.lineTo(paramFloat3, paramFloat1);
  }

  public int getBackgroundColor()
  {
    return this.mBackgroundColor;
  }

  public int getBorderColor(int paramInt)
  {
    int i = getBorderColor();
    switch (paramInt)
    {
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    default:
      return i;
    case 0:
      return resolveBorderColor(2, this.mBorderLeftColor, i);
    case 1:
      return resolveBorderColor(4, this.mBorderTopColor, i);
    case 2:
      return resolveBorderColor(8, this.mBorderRightColor, i);
    case 3:
    }
    return resolveBorderColor(16, this.mBorderBottomColor, i);
  }

  public float getBorderWidth(int paramInt)
  {
    switch (paramInt)
    {
    case 4:
    case 5:
    case 6:
    case 7:
    default:
      return 0.0F;
    case 0:
      return this.mBorderLeftWidth;
    case 1:
      return this.mBorderTopWidth;
    case 2:
      return this.mBorderRightWidth;
    case 3:
      return this.mBorderBottomWidth;
    case 8:
    }
    return getBorderWidth();
  }

  @Nullable
  protected DashPathEffect getPathEffectForBorderStyle()
  {
    if (isFlagSet(32))
      switch (this.mBorderStyle)
      {
      default:
        this.mPathEffectForBorderStyle = null;
      case 1:
      case 2:
      }
    while (true)
    {
      resetFlag(32);
      return this.mPathEffectForBorderStyle;
      this.mPathEffectForBorderStyle = createDashPathEffect(getBorderWidth());
      continue;
      this.mPathEffectForBorderStyle = createDashPathEffect(getBorderWidth() * 3.0F);
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if ((getBorderRadius() >= 0.5F) || (getPathEffectForBorderStyle() != null))
    {
      drawRoundedBorders(paramCanvas);
      return;
    }
    drawRectangularBorders(paramCanvas);
  }

  public void resetBorderColor(int paramInt)
  {
    switch (paramInt)
    {
    case 4:
    case 5:
    case 6:
    case 7:
    default:
      return;
    case 0:
      resetFlag(2);
      return;
    case 1:
      resetFlag(4);
      return;
    case 2:
      resetFlag(8);
      return;
    case 3:
      resetFlag(16);
      return;
    case 8:
    }
    setBorderColor(-16777216);
  }

  public void setBackgroundColor(int paramInt)
  {
    this.mBackgroundColor = paramInt;
  }

  public void setBorderColor(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 4:
    case 5:
    case 6:
    case 7:
    default:
      return;
    case 0:
      this.mBorderLeftColor = paramInt2;
      setFlag(2);
      return;
    case 1:
      this.mBorderTopColor = paramInt2;
      setFlag(4);
      return;
    case 2:
      this.mBorderRightColor = paramInt2;
      setFlag(8);
      return;
    case 3:
      this.mBorderBottomColor = paramInt2;
      setFlag(16);
      return;
    case 8:
    }
    setBorderColor(paramInt2);
  }

  public void setBorderStyle(@Nullable String paramString)
  {
    if ("dotted".equals(paramString))
      this.mBorderStyle = 1;
    while (true)
    {
      setFlag(32);
      return;
      if ("dashed".equals(paramString))
      {
        this.mBorderStyle = 2;
        continue;
      }
      this.mBorderStyle = 0;
    }
  }

  public void setBorderWidth(int paramInt, float paramFloat)
  {
    switch (paramInt)
    {
    case 4:
    case 5:
    case 6:
    case 7:
    default:
      return;
    case 0:
      this.mBorderLeftWidth = paramFloat;
      return;
    case 1:
      this.mBorderTopWidth = paramFloat;
      return;
    case 2:
      this.mBorderRightWidth = paramFloat;
      return;
    case 3:
      this.mBorderBottomWidth = paramFloat;
      return;
    case 8:
    }
    setBorderWidth(paramFloat);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.DrawBorder
 * JD-Core Version:    0.6.0
 */
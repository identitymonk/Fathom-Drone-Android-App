package com.facebook.react.flat;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import javax.annotation.Nullable;

final class DrawView extends AbstractDrawCommand
{
  public static final DrawView[] EMPTY_ARRAY = new DrawView[0];
  static final float MINIMUM_ROUNDED_CLIPPING_VALUE = 0.5F;
  private final RectF TMP_RECT = new RectF();
  private float mClipRadius;
  float mLogicalBottom;
  float mLogicalLeft;
  float mLogicalRight;
  float mLogicalTop;

  @Nullable
  private Path mPath;
  boolean mWasMounted;
  final int reactTag;

  public DrawView(int paramInt)
  {
    this.reactTag = paramInt;
  }

  private boolean logicalBoundsMatch(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat1 == this.mLogicalLeft) && (paramFloat2 == this.mLogicalTop) && (paramFloat3 == this.mLogicalRight) && (paramFloat4 == this.mLogicalBottom);
  }

  private void setLogicalBounds(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mLogicalLeft = paramFloat1;
    this.mLogicalTop = paramFloat2;
    this.mLogicalRight = paramFloat3;
    this.mLogicalBottom = paramFloat4;
  }

  private void updateClipPath()
  {
    this.mPath = new Path();
    this.TMP_RECT.set(getLeft(), getTop(), getRight(), getBottom());
    this.mPath.addRoundRect(this.TMP_RECT, this.mClipRadius, this.mClipRadius, Path.Direction.CW);
  }

  protected void applyClipping(Canvas paramCanvas)
  {
    if (this.mClipRadius > 0.5F)
    {
      paramCanvas.clipPath(this.mPath);
      return;
    }
    super.applyClipping(paramCanvas);
  }

  public DrawView collectDrawView(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13)
  {
    if (!isFrozen())
    {
      setBounds(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      setClipBounds(paramFloat9, paramFloat10, paramFloat11, paramFloat12);
      setClipRadius(paramFloat13);
      setLogicalBounds(paramFloat5, paramFloat6, paramFloat7, paramFloat8);
      freeze();
      return this;
    }
    boolean bool1 = boundsMatch(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    boolean bool2 = clipBoundsMatch(paramFloat9, paramFloat10, paramFloat11, paramFloat12);
    if (this.mClipRadius == paramFloat13);
    for (int i = 1; ; i = 0)
    {
      boolean bool3 = logicalBoundsMatch(paramFloat5, paramFloat6, paramFloat7, paramFloat8);
      if ((bool1) && (bool2) && (i != 0) && (bool3))
        break;
      DrawView localDrawView = (DrawView)mutableCopy();
      if (!bool1)
        localDrawView.setBounds(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      if (!bool2)
        localDrawView.setClipBounds(paramFloat9, paramFloat10, paramFloat11, paramFloat12);
      if (!bool3)
        localDrawView.setLogicalBounds(paramFloat5, paramFloat6, paramFloat7, paramFloat8);
      if ((i == 0) || (!bool1))
        localDrawView.setClipRadius(paramFloat13);
      localDrawView.mWasMounted = false;
      localDrawView.freeze();
      return localDrawView;
    }
  }

  public void draw(FlatViewGroup paramFlatViewGroup, Canvas paramCanvas)
  {
    onPreDraw(paramFlatViewGroup, paramCanvas);
    if ((this.mNeedsClipping) || (this.mClipRadius > 0.5F))
    {
      paramCanvas.save(2);
      applyClipping(paramCanvas);
      paramFlatViewGroup.drawNextChild(paramCanvas);
      paramCanvas.restore();
      return;
    }
    paramFlatViewGroup.drawNextChild(paramCanvas);
  }

  protected void onDebugDraw(FlatViewGroup paramFlatViewGroup, Canvas paramCanvas)
  {
    paramFlatViewGroup.debugDrawNextChild(paramCanvas);
  }

  protected void onDebugDrawHighlight(Canvas paramCanvas)
  {
    if (this.mPath != null)
      debugDrawWarningHighlight(paramCanvas, "borderRadius: " + this.mClipRadius);
    do
      return;
    while (boundsMatch(this.mLogicalLeft, this.mLogicalTop, this.mLogicalRight, this.mLogicalBottom));
    StringBuilder localStringBuilder = new StringBuilder("Overflow: { ");
    float[] arrayOfFloat = new float[4];
    int j = 0 + 1;
    arrayOfFloat[0] = (getLeft() - this.mLogicalLeft);
    int i = j + 1;
    arrayOfFloat[j] = (getTop() - this.mLogicalTop);
    j = i + 1;
    arrayOfFloat[i] = (this.mLogicalRight - getRight());
    arrayOfFloat[j] = (this.mLogicalBottom - getBottom());
    i = 0;
    while (i < 4)
    {
      if (arrayOfFloat[i] != 0.0F)
      {
        localStringBuilder.append(new java.lang.String[] { "left: ", "top: ", "right: ", "bottom: " }[i]);
        localStringBuilder.append(arrayOfFloat[i]);
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    localStringBuilder.append("}");
    debugDrawCautionHighlight(paramCanvas, localStringBuilder.toString());
  }

  protected void onDraw(Canvas paramCanvas)
  {
  }

  void setClipRadius(float paramFloat)
  {
    this.mClipRadius = paramFloat;
    if (paramFloat > 0.5F)
    {
      updateClipPath();
      return;
    }
    this.mPath = null;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.DrawView
 * JD-Core Version:    0.6.0
 */
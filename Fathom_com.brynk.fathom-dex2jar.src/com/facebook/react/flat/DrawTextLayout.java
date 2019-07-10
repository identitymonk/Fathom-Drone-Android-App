package com.facebook.react.flat;

import android.graphics.Canvas;
import android.text.Layout;
import com.facebook.fbui.textlayoutbuilder.util.LayoutMeasureUtil;

final class DrawTextLayout extends AbstractDrawCommand
{
  private Layout mLayout;
  private float mLayoutHeight;
  private float mLayoutWidth;

  DrawTextLayout(Layout paramLayout)
  {
    setLayout(paramLayout);
  }

  public Layout getLayout()
  {
    return this.mLayout;
  }

  public float getLayoutHeight()
  {
    return this.mLayoutHeight;
  }

  public float getLayoutWidth()
  {
    return this.mLayoutWidth;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = getLeft();
    float f2 = getTop();
    paramCanvas.translate(f1, f2);
    this.mLayout.draw(paramCanvas);
    paramCanvas.translate(-f1, -f2);
  }

  public void setLayout(Layout paramLayout)
  {
    this.mLayout = paramLayout;
    this.mLayoutWidth = paramLayout.getWidth();
    this.mLayoutHeight = LayoutMeasureUtil.getHeight(paramLayout);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.DrawTextLayout
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.flat;

import android.graphics.Canvas;
import android.graphics.Paint;

final class DrawBackgroundColor extends AbstractDrawCommand
{
  private static final Paint PAINT = new Paint();
  private final int mBackgroundColor;

  DrawBackgroundColor(int paramInt)
  {
    this.mBackgroundColor = paramInt;
  }

  public void onDraw(Canvas paramCanvas)
  {
    PAINT.setColor(this.mBackgroundColor);
    paramCanvas.drawRect(getLeft(), getTop(), getRight(), getBottom(), PAINT);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.DrawBackgroundColor
 * JD-Core Version:    0.6.0
 */
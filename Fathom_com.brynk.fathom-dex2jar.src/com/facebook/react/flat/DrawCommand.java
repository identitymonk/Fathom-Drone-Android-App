package com.facebook.react.flat;

import android.graphics.Canvas;

public abstract class DrawCommand
{
  static final DrawCommand[] EMPTY_ARRAY = new DrawCommand[0];

  abstract void debugDraw(FlatViewGroup paramFlatViewGroup, Canvas paramCanvas);

  abstract void draw(FlatViewGroup paramFlatViewGroup, Canvas paramCanvas);

  abstract float getBottom();

  abstract float getLeft();

  abstract float getRight();

  abstract float getTop();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.DrawCommand
 * JD-Core Version:    0.6.0
 */
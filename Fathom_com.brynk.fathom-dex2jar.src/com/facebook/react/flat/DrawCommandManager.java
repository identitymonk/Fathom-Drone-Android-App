package com.facebook.react.flat;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewParent;
import javax.annotation.Nullable;

abstract class DrawCommandManager
{
  protected static void ensureViewHasNoParent(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if (localViewParent != null)
      throw new RuntimeException("Cannot add view " + paramView + " to DrawCommandManager while it has a parent " + localViewParent);
  }

  static DrawCommandManager getVerticalClippingInstance(FlatViewGroup paramFlatViewGroup, DrawCommand[] paramArrayOfDrawCommand)
  {
    return new VerticalDrawCommandManager(paramFlatViewGroup, paramArrayOfDrawCommand);
  }

  @Nullable
  abstract NodeRegion anyNodeRegionWithinBounds(float paramFloat1, float paramFloat2);

  abstract void debugDraw(Canvas paramCanvas);

  abstract void draw(Canvas paramCanvas);

  abstract void getClippingRect(Rect paramRect);

  abstract SparseArray<View> getDetachedViews();

  abstract void mountDrawCommands(DrawCommand[] paramArrayOfDrawCommand, SparseIntArray paramSparseIntArray, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, boolean paramBoolean);

  abstract void mountNodeRegions(NodeRegion[] paramArrayOfNodeRegion, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);

  abstract void mountViews(ViewResolver paramViewResolver, int[] paramArrayOfInt1, int[] paramArrayOfInt2);

  abstract void onClippedViewDropped(View paramView);

  abstract boolean updateClippingRect();

  @Nullable
  abstract NodeRegion virtualNodeRegionWithinBounds(float paramFloat1, float paramFloat2);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.DrawCommandManager
 * JD-Core Version:    0.6.0
 */
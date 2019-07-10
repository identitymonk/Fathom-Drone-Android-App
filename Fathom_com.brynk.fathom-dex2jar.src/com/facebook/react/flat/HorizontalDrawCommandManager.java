package com.facebook.react.flat;

import android.graphics.Rect;
import android.util.SparseIntArray;
import java.util.Arrays;

final class HorizontalDrawCommandManager extends ClippingDrawCommandManager
{
  HorizontalDrawCommandManager(FlatViewGroup paramFlatViewGroup, DrawCommand[] paramArrayOfDrawCommand)
  {
    super(paramFlatViewGroup, paramArrayOfDrawCommand);
  }

  public static void fillMaxMinArrays(DrawCommand[] paramArrayOfDrawCommand, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, SparseIntArray paramSparseIntArray)
  {
    float f = 0.0F;
    int i = 0;
    if (i < paramArrayOfDrawCommand.length)
    {
      if ((paramArrayOfDrawCommand[i] instanceof DrawView))
      {
        DrawView localDrawView = (DrawView)paramArrayOfDrawCommand[i];
        paramSparseIntArray.append(localDrawView.reactTag, i);
        f = Math.max(f, localDrawView.mLogicalRight);
      }
      while (true)
      {
        paramArrayOfFloat1[i] = f;
        i += 1;
        break;
        f = Math.max(f, paramArrayOfDrawCommand[i].getRight());
      }
    }
    i = paramArrayOfDrawCommand.length - 1;
    if (i >= 0)
    {
      if ((paramArrayOfDrawCommand[i] instanceof DrawView))
        f = Math.min(f, ((DrawView)paramArrayOfDrawCommand[i]).mLogicalLeft);
      while (true)
      {
        paramArrayOfFloat2[i] = f;
        i -= 1;
        break;
        f = Math.min(f, paramArrayOfDrawCommand[i].getLeft());
      }
    }
  }

  public static void fillMaxMinArrays(NodeRegion[] paramArrayOfNodeRegion, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f = 0.0F;
    int i = 0;
    while (i < paramArrayOfNodeRegion.length)
    {
      f = Math.max(f, paramArrayOfNodeRegion[i].getTouchableRight());
      paramArrayOfFloat1[i] = f;
      i += 1;
    }
    i = paramArrayOfNodeRegion.length - 1;
    while (i >= 0)
    {
      f = Math.min(f, paramArrayOfNodeRegion[i].getTouchableLeft());
      paramArrayOfFloat2[i] = f;
      i -= 1;
    }
  }

  int commandStartIndex()
  {
    int j = Arrays.binarySearch(this.mCommandMaxBottom, this.mClippingRect.left);
    int i = j;
    if (j < 0)
      i = j ^ 0xFFFFFFFF;
    return i;
  }

  int commandStopIndex(int paramInt)
  {
    int i = Arrays.binarySearch(this.mCommandMinTop, paramInt, this.mCommandMinTop.length, this.mClippingRect.right);
    paramInt = i;
    if (i < 0)
      paramInt = i ^ 0xFFFFFFFF;
    return paramInt;
  }

  boolean regionAboveTouch(int paramInt, float paramFloat1, float paramFloat2)
  {
    return this.mRegionMaxBottom[paramInt] < paramFloat1;
  }

  int regionStopIndex(float paramFloat1, float paramFloat2)
  {
    int j = Arrays.binarySearch(this.mRegionMinTop, 1.0E-004F + paramFloat1);
    int i = j;
    if (j < 0)
      i = j ^ 0xFFFFFFFF;
    return i;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.HorizontalDrawCommandManager
 * JD-Core Version:    0.6.0
 */
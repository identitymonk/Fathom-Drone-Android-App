package com.facebook.react.flat;

import android.graphics.Rect;
import android.util.SparseIntArray;
import java.util.Arrays;

final class VerticalDrawCommandManager extends ClippingDrawCommandManager
{
  VerticalDrawCommandManager(FlatViewGroup paramFlatViewGroup, DrawCommand[] paramArrayOfDrawCommand)
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
        f = Math.max(f, localDrawView.mLogicalBottom);
      }
      while (true)
      {
        paramArrayOfFloat1[i] = f;
        i += 1;
        break;
        f = Math.max(f, paramArrayOfDrawCommand[i].getBottom());
      }
    }
    i = paramArrayOfDrawCommand.length - 1;
    if (i >= 0)
    {
      if ((paramArrayOfDrawCommand[i] instanceof DrawView))
        f = Math.min(f, ((DrawView)paramArrayOfDrawCommand[i]).mLogicalTop);
      while (true)
      {
        paramArrayOfFloat2[i] = f;
        i -= 1;
        break;
        f = Math.min(f, paramArrayOfDrawCommand[i].getTop());
      }
    }
  }

  public static void fillMaxMinArrays(NodeRegion[] paramArrayOfNodeRegion, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f = 0.0F;
    int i = 0;
    while (i < paramArrayOfNodeRegion.length)
    {
      f = Math.max(f, paramArrayOfNodeRegion[i].getTouchableBottom());
      paramArrayOfFloat1[i] = f;
      i += 1;
    }
    i = paramArrayOfNodeRegion.length - 1;
    while (i >= 0)
    {
      f = Math.min(f, paramArrayOfNodeRegion[i].getTouchableTop());
      paramArrayOfFloat2[i] = f;
      i -= 1;
    }
  }

  int commandStartIndex()
  {
    int j = Arrays.binarySearch(this.mCommandMaxBottom, this.mClippingRect.top);
    int i = j;
    if (j < 0)
      i = j ^ 0xFFFFFFFF;
    return i;
  }

  int commandStopIndex(int paramInt)
  {
    int i = Arrays.binarySearch(this.mCommandMinTop, paramInt, this.mCommandMinTop.length, this.mClippingRect.bottom);
    paramInt = i;
    if (i < 0)
      paramInt = i ^ 0xFFFFFFFF;
    return paramInt;
  }

  boolean regionAboveTouch(int paramInt, float paramFloat1, float paramFloat2)
  {
    return this.mRegionMaxBottom[paramInt] < paramFloat2;
  }

  int regionStopIndex(float paramFloat1, float paramFloat2)
  {
    int j = Arrays.binarySearch(this.mRegionMinTop, 1.0E-004F + paramFloat2);
    int i = j;
    if (j < 0)
      i = j ^ 0xFFFFFFFF;
    return i;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.VerticalDrawCommandManager
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.touch.ReactHitSlopView;
import javax.annotation.Nullable;

public class TouchTargetHelper
{
  private static final float[] mEventCoords = new float[2];
  private static final Matrix mInverseMatrix;
  private static final float[] mMatrixTransformCoords;
  private static final PointF mTempPoint = new PointF();

  static
  {
    mMatrixTransformCoords = new float[2];
    mInverseMatrix = new Matrix();
  }

  private static View findClosestReactAncestor(View paramView)
  {
    while ((paramView != null) && (paramView.getId() <= 0))
      paramView = (View)paramView.getParent();
    return paramView;
  }

  public static int findTargetTagAndCoordinatesForTouch(float paramFloat1, float paramFloat2, ViewGroup paramViewGroup, float[] paramArrayOfFloat, @Nullable int[] paramArrayOfInt)
  {
    UiThreadUtil.assertOnUiThread();
    int j = paramViewGroup.getId();
    paramArrayOfFloat[0] = paramFloat1;
    paramArrayOfFloat[1] = paramFloat2;
    paramViewGroup = findTouchTargetView(paramArrayOfFloat, paramViewGroup);
    int i = j;
    if (paramViewGroup != null)
    {
      paramViewGroup = findClosestReactAncestor(paramViewGroup);
      i = j;
      if (paramViewGroup != null)
      {
        if (paramArrayOfInt != null)
          paramArrayOfInt[0] = paramViewGroup.getId();
        i = getTouchTargetForView(paramViewGroup, paramArrayOfFloat[0], paramArrayOfFloat[1]);
      }
    }
    return i;
  }

  public static int findTargetTagForTouch(float paramFloat1, float paramFloat2, ViewGroup paramViewGroup)
  {
    return findTargetTagAndCoordinatesForTouch(paramFloat1, paramFloat2, paramViewGroup, mEventCoords, null);
  }

  public static int findTargetTagForTouch(float paramFloat1, float paramFloat2, ViewGroup paramViewGroup, @Nullable int[] paramArrayOfInt)
  {
    return findTargetTagAndCoordinatesForTouch(paramFloat1, paramFloat2, paramViewGroup, mEventCoords, paramArrayOfInt);
  }

  private static View findTouchTargetView(float[] paramArrayOfFloat, ViewGroup paramViewGroup)
  {
    int i = paramViewGroup.getChildCount();
    ReactZIndexedViewGroup localReactZIndexedViewGroup;
    if ((paramViewGroup instanceof ReactZIndexedViewGroup))
    {
      localReactZIndexedViewGroup = (ReactZIndexedViewGroup)paramViewGroup;
      i -= 1;
    }
    while (true)
    {
      if (i < 0)
        break label146;
      if (localReactZIndexedViewGroup != null);
      float f1;
      float f2;
      for (int j = localReactZIndexedViewGroup.getZIndexMappedChildIndex(i); ; j = i)
      {
        View localView = paramViewGroup.getChildAt(j);
        PointF localPointF = mTempPoint;
        if (!isTransformedTouchPointInView(paramArrayOfFloat[0], paramArrayOfFloat[1], paramViewGroup, localView, localPointF))
          break label137;
        f1 = paramArrayOfFloat[0];
        f2 = paramArrayOfFloat[1];
        paramArrayOfFloat[0] = localPointF.x;
        paramArrayOfFloat[1] = localPointF.y;
        localView = findTouchTargetViewWithPointerEvents(paramArrayOfFloat, localView);
        if (localView == null)
          break label129;
        return localView;
        localReactZIndexedViewGroup = null;
        break;
      }
      label129: paramArrayOfFloat[0] = f1;
      paramArrayOfFloat[1] = f2;
      label137: i -= 1;
    }
    label146: return paramViewGroup;
  }

  @Nullable
  private static View findTouchTargetViewWithPointerEvents(float[] paramArrayOfFloat, View paramView)
  {
    Object localObject2;
    Object localObject1;
    if ((paramView instanceof ReactPointerEventsView))
    {
      localObject2 = ((ReactPointerEventsView)paramView).getPointerEvents();
      localObject1 = localObject2;
      if (!paramView.isEnabled())
      {
        if (localObject2 != PointerEvents.AUTO)
          break label55;
        localObject1 = PointerEvents.BOX_NONE;
      }
      label37: if (localObject1 != PointerEvents.NONE)
        break label71;
      localObject2 = null;
    }
    label55: label71: 
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject2;
            localObject2 = PointerEvents.AUTO;
            break;
            localObject1 = localObject2;
            if (localObject2 != PointerEvents.BOX_ONLY)
              break label37;
            localObject1 = PointerEvents.NONE;
            break label37;
            localObject2 = paramView;
          }
          while (localObject1 == PointerEvents.BOX_ONLY);
          if (localObject1 != PointerEvents.BOX_NONE)
            break label143;
          if (!(paramView instanceof ViewGroup))
            break label141;
          localObject1 = findTouchTargetView(paramArrayOfFloat, (ViewGroup)paramView);
          if (localObject1 != paramView)
            return localObject1;
          if (!(paramView instanceof ReactCompoundView))
            break label141;
          localObject2 = paramView;
        }
        while (((ReactCompoundView)paramView).reactTagForTouch(paramArrayOfFloat[0], paramArrayOfFloat[1]) != paramView.getId());
        return null;
        if (localObject1 != PointerEvents.AUTO)
          break label195;
        if (!(paramView instanceof ReactCompoundViewGroup))
          break label177;
        localObject2 = paramView;
      }
      while (((ReactCompoundViewGroup)paramView).interceptsTouchEvent(paramArrayOfFloat[0], paramArrayOfFloat[1]));
      localObject2 = paramView;
    }
    while (!(paramView instanceof ViewGroup));
    label141: label143: label177: return findTouchTargetView(paramArrayOfFloat, (ViewGroup)paramView);
    label195: throw new JSApplicationIllegalArgumentException("Unknown pointer event type: " + ((PointerEvents)localObject1).toString());
  }

  private static int getTouchTargetForView(View paramView, float paramFloat1, float paramFloat2)
  {
    if ((paramView instanceof ReactCompoundView))
      return ((ReactCompoundView)paramView).reactTagForTouch(paramFloat1, paramFloat2);
    return paramView.getId();
  }

  private static boolean isTransformedTouchPointInView(float paramFloat1, float paramFloat2, ViewGroup paramViewGroup, View paramView, PointF paramPointF)
  {
    float f1 = paramViewGroup.getScrollX() + paramFloat1 - paramView.getLeft();
    float f2 = paramViewGroup.getScrollY() + paramFloat2 - paramView.getTop();
    paramViewGroup = paramView.getMatrix();
    paramFloat2 = f1;
    paramFloat1 = f2;
    if (!paramViewGroup.isIdentity())
    {
      float[] arrayOfFloat = mMatrixTransformCoords;
      arrayOfFloat[0] = f1;
      arrayOfFloat[1] = f2;
      Matrix localMatrix = mInverseMatrix;
      paramViewGroup.invert(localMatrix);
      localMatrix.mapPoints(arrayOfFloat);
      paramFloat2 = arrayOfFloat[0];
      paramFloat1 = arrayOfFloat[1];
    }
    if (((paramView instanceof ReactHitSlopView)) && (((ReactHitSlopView)paramView).getHitSlopRect() != null))
    {
      paramViewGroup = ((ReactHitSlopView)paramView).getHitSlopRect();
      if ((paramFloat2 >= -paramViewGroup.left) && (paramFloat2 < paramView.getRight() - paramView.getLeft() + paramViewGroup.right) && (paramFloat1 >= -paramViewGroup.top) && (paramFloat1 < paramView.getBottom() - paramView.getTop() + paramViewGroup.bottom))
      {
        paramPointF.set(paramFloat2, paramFloat1);
        return true;
      }
      return false;
    }
    if ((paramFloat2 >= 0.0F) && (paramFloat2 < paramView.getRight() - paramView.getLeft()) && (paramFloat1 >= 0.0F) && (paramFloat1 < paramView.getBottom() - paramView.getTop()))
    {
      paramPointF.set(paramFloat2, paramFloat1);
      return true;
    }
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.TouchTargetHelper
 * JD-Core Version:    0.6.0
 */
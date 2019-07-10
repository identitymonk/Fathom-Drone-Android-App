package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.annotation.Nullable;

public class ViewGroupDrawingOrderHelper
{

  @Nullable
  private int[] mDrawingOrderIndices;
  private int mNumberOfChildrenWithZIndex = 0;
  private final ViewGroup mViewGroup;

  public ViewGroupDrawingOrderHelper(ViewGroup paramViewGroup)
  {
    this.mViewGroup = paramViewGroup;
  }

  public int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.mDrawingOrderIndices == null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramInt1)
      {
        localArrayList.add(this.mViewGroup.getChildAt(i));
        i += 1;
      }
      Collections.sort(localArrayList, new Comparator()
      {
        public int compare(View paramView1, View paramView2)
        {
          Integer localInteger = ViewGroupManager.getViewZIndex(paramView1);
          paramView1 = localInteger;
          if (localInteger == null)
            paramView1 = Integer.valueOf(0);
          localInteger = ViewGroupManager.getViewZIndex(paramView2);
          paramView2 = localInteger;
          if (localInteger == null)
            paramView2 = Integer.valueOf(0);
          return paramView1.intValue() - paramView2.intValue();
        }
      });
      this.mDrawingOrderIndices = new int[paramInt1];
      i = 0;
      while (i < paramInt1)
      {
        View localView = (View)localArrayList.get(i);
        this.mDrawingOrderIndices[i] = this.mViewGroup.indexOfChild(localView);
        i += 1;
      }
    }
    return this.mDrawingOrderIndices[paramInt2];
  }

  public void handleAddView(View paramView)
  {
    if (ViewGroupManager.getViewZIndex(paramView) != null)
      this.mNumberOfChildrenWithZIndex += 1;
    this.mDrawingOrderIndices = null;
  }

  public void handleRemoveView(View paramView)
  {
    if (ViewGroupManager.getViewZIndex(paramView) != null)
      this.mNumberOfChildrenWithZIndex -= 1;
    this.mDrawingOrderIndices = null;
  }

  public boolean shouldEnableCustomDrawingOrder()
  {
    return this.mNumberOfChildrenWithZIndex > 0;
  }

  public void update()
  {
    this.mNumberOfChildrenWithZIndex = 0;
    int i = 0;
    while (i < this.mViewGroup.getChildCount())
    {
      if (ViewGroupManager.getViewZIndex(this.mViewGroup.getChildAt(i)) != null)
        this.mNumberOfChildrenWithZIndex += 1;
      i += 1;
    }
    this.mDrawingOrderIndices = null;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ViewGroupDrawingOrderHelper
 * JD-Core Version:    0.6.0
 */
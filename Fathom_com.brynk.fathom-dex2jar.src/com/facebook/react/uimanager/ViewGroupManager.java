package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.WeakHashMap;
import javax.annotation.Nullable;

public abstract class ViewGroupManager<T extends ViewGroup> extends BaseViewManager<T, LayoutShadowNode>
{
  private static WeakHashMap<View, Integer> mZIndexHash = new WeakHashMap();

  @Nullable
  public static Integer getViewZIndex(View paramView)
  {
    return (Integer)mZIndexHash.get(paramView);
  }

  public static void setViewZIndex(View paramView, int paramInt)
  {
    mZIndexHash.put(paramView, Integer.valueOf(paramInt));
  }

  public void addView(T paramT, View paramView, int paramInt)
  {
    paramT.addView(paramView, paramInt);
  }

  public void addViews(T paramT, List<View> paramList)
  {
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      addView(paramT, (View)paramList.get(i), i);
      i += 1;
    }
  }

  public LayoutShadowNode createShadowNodeInstance()
  {
    return new LayoutShadowNode();
  }

  public View getChildAt(T paramT, int paramInt)
  {
    return paramT.getChildAt(paramInt);
  }

  public int getChildCount(T paramT)
  {
    return paramT.getChildCount();
  }

  public Class<? extends LayoutShadowNode> getShadowNodeClass()
  {
    return LayoutShadowNode.class;
  }

  public boolean needsCustomLayoutForChildren()
  {
    return false;
  }

  public void removeAllViews(T paramT)
  {
    int i = getChildCount(paramT) - 1;
    while (i >= 0)
    {
      removeViewAt(paramT, i);
      i -= 1;
    }
  }

  public void removeView(T paramT, View paramView)
  {
    int i = 0;
    while (true)
    {
      if (i < getChildCount(paramT))
      {
        if (getChildAt(paramT, i) == paramView)
          removeViewAt(paramT, i);
      }
      else
        return;
      i += 1;
    }
  }

  public void removeViewAt(T paramT, int paramInt)
  {
    paramT.removeViewAt(paramInt);
  }

  public boolean shouldPromoteGrandchildren()
  {
    return false;
  }

  public void updateExtraData(T paramT, Object paramObject)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ViewGroupManager
 * JD-Core Version:    0.6.0
 */
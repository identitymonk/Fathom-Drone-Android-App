package com.facebook.react.flat;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

abstract class FlatViewManager extends ViewGroupManager<FlatViewGroup>
{
  protected FlatViewGroup createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new FlatViewGroup(paramThemedReactContext);
  }

  public void removeAllViews(FlatViewGroup paramFlatViewGroup)
  {
    paramFlatViewGroup.removeAllViewsInLayout();
  }

  public void setBackgroundColor(FlatViewGroup paramFlatViewGroup, int paramInt)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.FlatViewManager
 * JD-Core Version:    0.6.0
 */
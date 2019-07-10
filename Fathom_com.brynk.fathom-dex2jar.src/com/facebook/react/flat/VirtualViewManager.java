package com.facebook.react.flat;

import android.view.View;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;

abstract class VirtualViewManager<C extends FlatShadowNode> extends ViewManager<View, C>
{
  protected View createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    throw new RuntimeException(getName() + " doesn't map to a View");
  }

  public void updateExtraData(View paramView, Object paramObject)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.VirtualViewManager
 * JD-Core Version:    0.6.0
 */
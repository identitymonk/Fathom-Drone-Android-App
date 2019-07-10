package com.facebook.react.uimanager;

import android.view.View;

public abstract class SimpleViewManager<T extends View> extends BaseViewManager<T, LayoutShadowNode>
{
  public LayoutShadowNode createShadowNodeInstance()
  {
    return new LayoutShadowNode();
  }

  public Class<LayoutShadowNode> getShadowNodeClass()
  {
    return LayoutShadowNode.class;
  }

  public void updateExtraData(T paramT, Object paramObject)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.SimpleViewManager
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.flat;

import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.views.modal.ReactModalHostManager;

public class RCTModalHostManager extends ReactModalHostManager
{
  static final String REACT_CLASS = "RCTModalHostView";

  public LayoutShadowNode createShadowNodeInstance()
  {
    return new FlatReactModalShadowNode();
  }

  public Class<? extends LayoutShadowNode> getShadowNodeClass()
  {
    return FlatReactModalShadowNode.class;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.RCTModalHostManager
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.views.modal;

import android.graphics.Point;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;

class ModalHostShadowNode extends LayoutShadowNode
{
  public void addChildAt(ReactShadowNodeImpl paramReactShadowNodeImpl, int paramInt)
  {
    super.addChildAt(paramReactShadowNodeImpl, paramInt);
    Point localPoint = ModalHostHelper.getModalHostSize(getThemedContext());
    paramReactShadowNodeImpl.setStyleWidth(localPoint.x);
    paramReactShadowNodeImpl.setStyleHeight(localPoint.y);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.modal.ModalHostShadowNode
 * JD-Core Version:    0.6.0
 */
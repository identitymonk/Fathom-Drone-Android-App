package com.facebook.react.views.text;

import android.view.View;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

@ReactModule(name="RCTVirtualText")
public class ReactVirtualTextViewManager extends BaseViewManager<View, ReactVirtualTextShadowNode>
{

  @VisibleForTesting
  public static final String REACT_CLASS = "RCTVirtualText";

  public ReactVirtualTextShadowNode createShadowNodeInstance()
  {
    return new ReactVirtualTextShadowNode();
  }

  public View createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    throw new IllegalStateException("Attempt to create a native view for RCTVirtualText");
  }

  public String getName()
  {
    return "RCTVirtualText";
  }

  public Class<ReactVirtualTextShadowNode> getShadowNodeClass()
  {
    return ReactVirtualTextShadowNode.class;
  }

  public void updateExtraData(View paramView, Object paramObject)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.ReactVirtualTextViewManager
 * JD-Core Version:    0.6.0
 */
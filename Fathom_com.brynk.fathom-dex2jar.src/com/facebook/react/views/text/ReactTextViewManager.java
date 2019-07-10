package com.facebook.react.views.text;

import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;

@ReactModule(name="RCTText")
public class ReactTextViewManager extends ReactTextAnchorViewManager<ReactTextView, ReactTextShadowNode>
{

  @VisibleForTesting
  public static final String REACT_CLASS = "RCTText";

  public ReactTextShadowNode createShadowNodeInstance()
  {
    return new ReactTextShadowNode();
  }

  public ReactTextView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactTextView(paramThemedReactContext);
  }

  public String getName()
  {
    return "RCTText";
  }

  public Class<ReactTextShadowNode> getShadowNodeClass()
  {
    return ReactTextShadowNode.class;
  }

  protected void onAfterUpdateTransaction(ReactTextView paramReactTextView)
  {
    super.onAfterUpdateTransaction(paramReactTextView);
    paramReactTextView.updateView();
  }

  public void updateExtraData(ReactTextView paramReactTextView, Object paramObject)
  {
    paramObject = (ReactTextUpdate)paramObject;
    if (paramObject.containsImages())
      TextInlineImageSpan.possiblyUpdateInlineImageSpans(paramObject.getText(), paramReactTextView);
    paramReactTextView.setText(paramObject);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.ReactTextViewManager
 * JD-Core Version:    0.6.0
 */
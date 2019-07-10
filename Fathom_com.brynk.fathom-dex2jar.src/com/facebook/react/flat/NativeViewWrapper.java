package com.facebook.react.flat;

import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaValue;
import javax.annotation.Nullable;

final class NativeViewWrapper extends FlatShadowNode
  implements AndroidView
{
  private boolean mForceMountGrandChildrenToView;
  private final boolean mNeedsCustomLayoutForChildren;
  private boolean mPaddingChanged = false;

  @Nullable
  private final ReactShadowNode mReactShadowNode;

  NativeViewWrapper(ViewManager paramViewManager)
  {
    ReactShadowNode localReactShadowNode = paramViewManager.createShadowNodeInstance();
    if ((localReactShadowNode instanceof YogaMeasureFunction))
    {
      this.mReactShadowNode = localReactShadowNode;
      setMeasureFunction((YogaMeasureFunction)localReactShadowNode);
      if (!(paramViewManager instanceof ViewGroupManager))
        break label79;
      paramViewManager = (ViewGroupManager)paramViewManager;
      this.mNeedsCustomLayoutForChildren = paramViewManager.needsCustomLayoutForChildren();
      this.mForceMountGrandChildrenToView = paramViewManager.shouldPromoteGrandchildren();
    }
    while (true)
    {
      forceMountToView();
      forceMountChildrenToView();
      return;
      this.mReactShadowNode = null;
      break;
      label79: this.mNeedsCustomLayoutForChildren = false;
    }
  }

  public void addChildAt(ReactShadowNodeImpl paramReactShadowNodeImpl, int paramInt)
  {
    super.addChildAt(paramReactShadowNodeImpl, paramInt);
    if ((this.mForceMountGrandChildrenToView) && ((paramReactShadowNodeImpl instanceof FlatShadowNode)))
      ((FlatShadowNode)paramReactShadowNodeImpl).forceMountChildrenToView();
  }

  void handleUpdateProperties(ReactStylesDiffMap paramReactStylesDiffMap)
  {
    if (this.mReactShadowNode != null)
      this.mReactShadowNode.updateProperties(paramReactStylesDiffMap);
  }

  public boolean isPaddingChanged()
  {
    return this.mPaddingChanged;
  }

  public boolean needsCustomLayoutForChildren()
  {
    return this.mNeedsCustomLayoutForChildren;
  }

  public void onCollectExtraUpdates(UIViewOperationQueue paramUIViewOperationQueue)
  {
    if ((this.mReactShadowNode != null) && (this.mReactShadowNode.hasUnseenUpdates()))
    {
      this.mReactShadowNode.onCollectExtraUpdates(paramUIViewOperationQueue);
      markUpdateSeen();
    }
  }

  public void resetPaddingChanged()
  {
    this.mPaddingChanged = false;
  }

  public void setBackgroundColor(int paramInt)
  {
  }

  public void setPadding(int paramInt, float paramFloat)
  {
    YogaValue localYogaValue = getStylePadding(paramInt);
    if ((localYogaValue.unit != YogaUnit.POINT) || (localYogaValue.value != paramFloat))
    {
      super.setPadding(paramInt, paramFloat);
      this.mPaddingChanged = true;
      markUpdated();
    }
  }

  public void setPaddingPercent(int paramInt, float paramFloat)
  {
    YogaValue localYogaValue = getStylePadding(paramInt);
    if ((localYogaValue.unit != YogaUnit.PERCENT) || (localYogaValue.value != paramFloat))
    {
      super.setPadding(paramInt, paramFloat);
      this.mPaddingChanged = true;
      markUpdated();
    }
  }

  public void setReactTag(int paramInt)
  {
    super.setReactTag(paramInt);
    if (this.mReactShadowNode != null)
      this.mReactShadowNode.setReactTag(paramInt);
  }

  public void setThemedContext(ThemedReactContext paramThemedReactContext)
  {
    super.setThemedContext(paramThemedReactContext);
    if (this.mReactShadowNode != null)
      this.mReactShadowNode.setThemedContext(paramThemedReactContext);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.NativeViewWrapper
 * JD-Core Version:    0.6.0
 */
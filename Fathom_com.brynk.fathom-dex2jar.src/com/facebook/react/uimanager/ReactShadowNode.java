package com.facebook.react.uimanager;

import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaBaselineFunction;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaValue;
import com.facebook.yoga.YogaWrap;
import javax.annotation.Nullable;

public abstract interface ReactShadowNode<T extends ReactShadowNode>
{
  public abstract void addChildAt(T paramT, int paramInt);

  public abstract void addNativeChildAt(T paramT, int paramInt);

  public abstract void calculateLayout();

  public abstract void dirty();

  public abstract boolean dispatchUpdates(float paramFloat1, float paramFloat2, UIViewOperationQueue paramUIViewOperationQueue, NativeViewHierarchyOptimizer paramNativeViewHierarchyOptimizer);

  public abstract void dispose();

  public abstract T getChildAt(int paramInt);

  public abstract int getChildCount();

  public abstract YogaDirection getLayoutDirection();

  public abstract float getLayoutHeight();

  public abstract float getLayoutWidth();

  public abstract float getLayoutX();

  public abstract float getLayoutY();

  public abstract int getNativeChildCount();

  public abstract int getNativeOffsetForChild(T paramT);

  @Nullable
  public abstract T getNativeParent();

  public abstract float getPadding(int paramInt);

  @Nullable
  public abstract T getParent();

  public abstract int getReactTag();

  public abstract T getRootNode();

  public abstract int getScreenHeight();

  public abstract int getScreenWidth();

  public abstract int getScreenX();

  public abstract int getScreenY();

  public abstract YogaValue getStyleHeight();

  public abstract YogaValue getStylePadding(int paramInt);

  public abstract YogaValue getStyleWidth();

  public abstract ThemedReactContext getThemedContext();

  public abstract int getTotalNativeChildren();

  public abstract String getViewClass();

  public abstract boolean hasNewLayout();

  public abstract boolean hasUnseenUpdates();

  public abstract boolean hasUpdates();

  public abstract int indexOf(T paramT);

  public abstract int indexOfNativeChild(T paramT);

  public abstract boolean isDescendantOf(T paramT);

  public abstract boolean isDirty();

  public abstract boolean isLayoutOnly();

  public abstract boolean isMeasureDefined();

  public abstract boolean isVirtual();

  public abstract boolean isVirtualAnchor();

  public abstract boolean isYogaLeafNode();

  public abstract void markLayoutSeen();

  public abstract void markUpdateSeen();

  public abstract void markUpdated();

  public abstract void onAfterUpdateTransaction();

  public abstract void onBeforeLayout();

  public abstract void onCollectExtraUpdates(UIViewOperationQueue paramUIViewOperationQueue);

  public abstract void removeAllNativeChildren();

  public abstract void removeAndDisposeAllChildren();

  public abstract T removeChildAt(int paramInt);

  public abstract T removeNativeChildAt(int paramInt);

  public abstract void setAlignContent(YogaAlign paramYogaAlign);

  public abstract void setAlignItems(YogaAlign paramYogaAlign);

  public abstract void setAlignSelf(YogaAlign paramYogaAlign);

  public abstract void setBaselineFunction(YogaBaselineFunction paramYogaBaselineFunction);

  public abstract void setBorder(int paramInt, float paramFloat);

  public abstract void setDefaultPadding(int paramInt, float paramFloat);

  public abstract void setDisplay(YogaDisplay paramYogaDisplay);

  public abstract void setFlex(float paramFloat);

  public abstract void setFlexBasis(float paramFloat);

  public abstract void setFlexBasisAuto();

  public abstract void setFlexBasisPercent(float paramFloat);

  public abstract void setFlexDirection(YogaFlexDirection paramYogaFlexDirection);

  public abstract void setFlexGrow(float paramFloat);

  public abstract void setFlexShrink(float paramFloat);

  public abstract void setFlexWrap(YogaWrap paramYogaWrap);

  public abstract void setIsLayoutOnly(boolean paramBoolean);

  public abstract void setJustifyContent(YogaJustify paramYogaJustify);

  public abstract void setLayoutDirection(YogaDirection paramYogaDirection);

  public abstract void setLocalData(Object paramObject);

  public abstract void setMargin(int paramInt, float paramFloat);

  public abstract void setMarginAuto(int paramInt);

  public abstract void setMarginPercent(int paramInt, float paramFloat);

  public abstract void setMeasureFunction(YogaMeasureFunction paramYogaMeasureFunction);

  public abstract void setOverflow(YogaOverflow paramYogaOverflow);

  public abstract void setPadding(int paramInt, float paramFloat);

  public abstract void setPaddingPercent(int paramInt, float paramFloat);

  public abstract void setPosition(int paramInt, float paramFloat);

  public abstract void setPositionPercent(int paramInt, float paramFloat);

  public abstract void setPositionType(YogaPositionType paramYogaPositionType);

  public abstract void setReactTag(int paramInt);

  public abstract void setRootNode(T paramT);

  public abstract void setShouldNotifyOnLayout(boolean paramBoolean);

  public abstract void setStyleAspectRatio(float paramFloat);

  public abstract void setStyleHeight(float paramFloat);

  public abstract void setStyleHeightAuto();

  public abstract void setStyleHeightPercent(float paramFloat);

  public abstract void setStyleMaxHeight(float paramFloat);

  public abstract void setStyleMaxHeightPercent(float paramFloat);

  public abstract void setStyleMaxWidth(float paramFloat);

  public abstract void setStyleMaxWidthPercent(float paramFloat);

  public abstract void setStyleMinHeight(float paramFloat);

  public abstract void setStyleMinHeightPercent(float paramFloat);

  public abstract void setStyleMinWidth(float paramFloat);

  public abstract void setStyleMinWidthPercent(float paramFloat);

  public abstract void setStyleWidth(float paramFloat);

  public abstract void setStyleWidthAuto();

  public abstract void setStyleWidthPercent(float paramFloat);

  public abstract void setThemedContext(ThemedReactContext paramThemedReactContext);

  public abstract void setViewClassName(String paramString);

  public abstract boolean shouldNotifyOnLayout();

  public abstract void updateProperties(ReactStylesDiffMap paramReactStylesDiffMap);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ReactShadowNode
 * JD-Core Version:    0.6.0
 */
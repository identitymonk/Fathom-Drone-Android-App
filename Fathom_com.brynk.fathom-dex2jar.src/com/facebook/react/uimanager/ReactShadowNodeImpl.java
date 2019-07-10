package com.facebook.react.uimanager;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.ClearableSynchronizedPool;
import com.facebook.react.uimanager.annotations.ReactPropertyHolder;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaBaselineFunction;
import com.facebook.yoga.YogaConfig;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaValue;
import com.facebook.yoga.YogaWrap;
import java.util.ArrayList;
import java.util.Arrays;
import javax.annotation.Nullable;

@ReactPropertyHolder
public class ReactShadowNodeImpl
  implements ReactShadowNode<ReactShadowNodeImpl>
{
  private static YogaConfig sYogaConfig;

  @Nullable
  private ArrayList<ReactShadowNodeImpl> mChildren;
  private final Spacing mDefaultPadding = new Spacing(0.0F);
  private boolean mIsLayoutOnly;

  @Nullable
  private ArrayList<ReactShadowNodeImpl> mNativeChildren;

  @Nullable
  private ReactShadowNodeImpl mNativeParent;
  private boolean mNodeUpdated = true;
  private final float[] mPadding = new float[9];
  private final boolean[] mPaddingIsPercent = new boolean[9];

  @Nullable
  private ReactShadowNodeImpl mParent;
  private int mReactTag;

  @Nullable
  private ReactShadowNodeImpl mRootNode;
  private int mScreenHeight;
  private int mScreenWidth;
  private int mScreenX;
  private int mScreenY;
  private boolean mShouldNotifyOnLayout;

  @Nullable
  private ThemedReactContext mThemedContext;
  private int mTotalNativeChildren = 0;

  @Nullable
  private String mViewClassName;
  private final YogaNode mYogaNode;

  public ReactShadowNodeImpl()
  {
    if (!isVirtual())
    {
      YogaNode localYogaNode2 = (YogaNode)YogaNodePool.get().acquire();
      if (sYogaConfig == null)
      {
        sYogaConfig = new YogaConfig();
        sYogaConfig.setPointScaleFactor(0.0F);
        sYogaConfig.setUseLegacyStretchBehaviour(true);
      }
      YogaNode localYogaNode1 = localYogaNode2;
      if (localYogaNode2 == null)
        localYogaNode1 = new YogaNode(sYogaConfig);
      this.mYogaNode = localYogaNode1;
      Arrays.fill(this.mPadding, (0.0F / 0.0F));
      return;
    }
    this.mYogaNode = null;
  }

  private void toStringWithIndentation(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append("__");
      i += 1;
    }
    paramStringBuilder.append(getClass().getSimpleName()).append(" ");
    if (this.mYogaNode != null)
    {
      paramStringBuilder.append(getLayoutWidth()).append(",").append(getLayoutHeight());
      paramStringBuilder.append("\n");
      if (getChildCount() != 0)
        break label91;
    }
    while (true)
    {
      return;
      paramStringBuilder.append("(virtual node)");
      break;
      label91: i = 0;
      while (i < getChildCount())
      {
        getChildAt(i).toStringWithIndentation(paramStringBuilder, paramInt + 1);
        i += 1;
      }
    }
  }

  private void updateNativeChildrenCountInParent(int paramInt)
  {
    if (this.mIsLayoutOnly);
    for (ReactShadowNodeImpl localReactShadowNodeImpl = getParent(); ; localReactShadowNodeImpl = localReactShadowNodeImpl.getParent())
      if (localReactShadowNodeImpl != null)
      {
        localReactShadowNodeImpl.mTotalNativeChildren += paramInt;
        if (localReactShadowNodeImpl.isLayoutOnly())
          continue;
      }
      else
      {
        return;
      }
  }

  private void updatePadding()
  {
    int i = 0;
    if (i <= 8)
    {
      if ((i == 0) || (i == 2) || (i == 4) || (i == 5))
      {
        if ((!YogaConstants.isUndefined(this.mPadding[i])) || (!YogaConstants.isUndefined(this.mPadding[6])) || (!YogaConstants.isUndefined(this.mPadding[8])))
          break label195;
        this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mDefaultPadding.getRaw(i));
      }
      while (true)
      {
        i += 1;
        break;
        if ((i == 1) || (i == 3))
        {
          if ((YogaConstants.isUndefined(this.mPadding[i])) && (YogaConstants.isUndefined(this.mPadding[7])) && (YogaConstants.isUndefined(this.mPadding[8])))
          {
            this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mDefaultPadding.getRaw(i));
            continue;
          }
        }
        else if (YogaConstants.isUndefined(this.mPadding[i]))
        {
          this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mDefaultPadding.getRaw(i));
          continue;
        }
        label195: if (this.mPaddingIsPercent[i] != 0)
        {
          this.mYogaNode.setPaddingPercent(YogaEdge.fromInt(i), this.mPadding[i]);
          continue;
        }
        this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mPadding[i]);
      }
    }
  }

  public void addChildAt(ReactShadowNodeImpl paramReactShadowNodeImpl, int paramInt)
  {
    if (paramReactShadowNodeImpl.getParent() != null)
      throw new IllegalViewOperationException("Tried to add child that already has a parent! Remove it from its parent first.");
    if (this.mChildren == null)
      this.mChildren = new ArrayList(4);
    this.mChildren.add(paramInt, paramReactShadowNodeImpl);
    paramReactShadowNodeImpl.mParent = this;
    if ((this.mYogaNode != null) && (!isYogaLeafNode()))
    {
      YogaNode localYogaNode = paramReactShadowNodeImpl.mYogaNode;
      if (localYogaNode == null)
        throw new RuntimeException("Cannot add a child that doesn't have a YogaNode to a parent without a measure function! (Trying to add a '" + paramReactShadowNodeImpl.getClass().getSimpleName() + "' to a '" + getClass().getSimpleName() + "')");
      this.mYogaNode.addChildAt(localYogaNode, paramInt);
    }
    markUpdated();
    if (paramReactShadowNodeImpl.isLayoutOnly());
    for (paramInt = paramReactShadowNodeImpl.getTotalNativeChildren(); ; paramInt = 1)
    {
      this.mTotalNativeChildren += paramInt;
      updateNativeChildrenCountInParent(paramInt);
      return;
    }
  }

  public final void addNativeChildAt(ReactShadowNodeImpl paramReactShadowNodeImpl, int paramInt)
  {
    boolean bool2 = true;
    if (!this.mIsLayoutOnly)
    {
      bool1 = true;
      Assertions.assertCondition(bool1);
      if (paramReactShadowNodeImpl.mIsLayoutOnly)
        break label69;
    }
    label69: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Assertions.assertCondition(bool1);
      if (this.mNativeChildren == null)
        this.mNativeChildren = new ArrayList(4);
      this.mNativeChildren.add(paramInt, paramReactShadowNodeImpl);
      paramReactShadowNodeImpl.mNativeParent = this;
      return;
      bool1 = false;
      break;
    }
  }

  public void calculateLayout()
  {
    this.mYogaNode.calculateLayout((0.0F / 0.0F), (0.0F / 0.0F));
  }

  public void dirty()
  {
    if (!isVirtual())
      this.mYogaNode.dirty();
  }

  public boolean dispatchUpdates(float paramFloat1, float paramFloat2, UIViewOperationQueue paramUIViewOperationQueue, NativeViewHierarchyOptimizer paramNativeViewHierarchyOptimizer)
  {
    if (this.mNodeUpdated)
      onCollectExtraUpdates(paramUIViewOperationQueue);
    if (hasNewLayout())
    {
      float f1 = getLayoutX();
      float f2 = getLayoutY();
      int n = Math.round(paramFloat1 + f1);
      int k = Math.round(paramFloat2 + f2);
      int i1 = Math.round(paramFloat1 + f1 + getLayoutWidth());
      int m = Math.round(paramFloat2 + f2 + getLayoutHeight());
      int i = Math.round(f1);
      int j = Math.round(f2);
      n = i1 - n;
      k = m - k;
      if ((i != this.mScreenX) || (j != this.mScreenY) || (n != this.mScreenWidth) || (k != this.mScreenHeight));
      for (int i2 = 1; ; i2 = 0)
      {
        this.mScreenX = i;
        this.mScreenY = j;
        this.mScreenWidth = n;
        this.mScreenHeight = k;
        if (i2 != 0)
          paramNativeViewHierarchyOptimizer.handleUpdateLayout(this);
        return i2;
      }
    }
    return false;
  }

  public void dispose()
  {
    if (this.mYogaNode != null)
    {
      this.mYogaNode.reset();
      YogaNodePool.get().release(this.mYogaNode);
    }
  }

  public final ReactShadowNodeImpl getChildAt(int paramInt)
  {
    if (this.mChildren == null)
      throw new ArrayIndexOutOfBoundsException("Index " + paramInt + " out of bounds: node has no children");
    return (ReactShadowNodeImpl)this.mChildren.get(paramInt);
  }

  public final int getChildCount()
  {
    if (this.mChildren == null)
      return 0;
    return this.mChildren.size();
  }

  public final YogaDirection getLayoutDirection()
  {
    return this.mYogaNode.getLayoutDirection();
  }

  public final float getLayoutHeight()
  {
    return this.mYogaNode.getLayoutHeight();
  }

  public final float getLayoutWidth()
  {
    return this.mYogaNode.getLayoutWidth();
  }

  public final float getLayoutX()
  {
    return this.mYogaNode.getLayoutX();
  }

  public final float getLayoutY()
  {
    return this.mYogaNode.getLayoutY();
  }

  public final int getNativeChildCount()
  {
    if (this.mNativeChildren == null)
      return 0;
    return this.mNativeChildren.size();
  }

  public final int getNativeOffsetForChild(ReactShadowNodeImpl paramReactShadowNodeImpl)
  {
    int i = 0;
    int m = 0;
    int j = 0;
    int k = m;
    ReactShadowNodeImpl localReactShadowNodeImpl;
    if (j < getChildCount())
    {
      localReactShadowNodeImpl = getChildAt(j);
      if (paramReactShadowNodeImpl == localReactShadowNodeImpl)
        k = 1;
    }
    else
    {
      if (k != 0)
        break label117;
      throw new RuntimeException("Child " + paramReactShadowNodeImpl.getReactTag() + " was not a child of " + this.mReactTag);
    }
    if (localReactShadowNodeImpl.isLayoutOnly());
    for (k = localReactShadowNodeImpl.getTotalNativeChildren(); ; k = 1)
    {
      i += k;
      j += 1;
      break;
    }
    label117: return i;
  }

  @Nullable
  public final ReactShadowNodeImpl getNativeParent()
  {
    return this.mNativeParent;
  }

  public final float getPadding(int paramInt)
  {
    return this.mYogaNode.getLayoutPadding(YogaEdge.fromInt(paramInt));
  }

  @Nullable
  public final ReactShadowNodeImpl getParent()
  {
    return this.mParent;
  }

  public final int getReactTag()
  {
    return this.mReactTag;
  }

  public final ReactShadowNodeImpl getRootNode()
  {
    return (ReactShadowNodeImpl)Assertions.assertNotNull(this.mRootNode);
  }

  public int getScreenHeight()
  {
    return this.mScreenHeight;
  }

  public int getScreenWidth()
  {
    return this.mScreenWidth;
  }

  public int getScreenX()
  {
    return this.mScreenX;
  }

  public int getScreenY()
  {
    return this.mScreenY;
  }

  public final YogaValue getStyleHeight()
  {
    return this.mYogaNode.getHeight();
  }

  public final YogaValue getStylePadding(int paramInt)
  {
    return this.mYogaNode.getPadding(YogaEdge.fromInt(paramInt));
  }

  public final YogaValue getStyleWidth()
  {
    return this.mYogaNode.getWidth();
  }

  public final ThemedReactContext getThemedContext()
  {
    return (ThemedReactContext)Assertions.assertNotNull(this.mThemedContext);
  }

  public final int getTotalNativeChildren()
  {
    return this.mTotalNativeChildren;
  }

  public final String getViewClass()
  {
    return (String)Assertions.assertNotNull(this.mViewClassName);
  }

  public final boolean hasNewLayout()
  {
    return (this.mYogaNode != null) && (this.mYogaNode.hasNewLayout());
  }

  public final boolean hasUnseenUpdates()
  {
    return this.mNodeUpdated;
  }

  public final boolean hasUpdates()
  {
    return (this.mNodeUpdated) || (hasNewLayout()) || (isDirty());
  }

  public final int indexOf(ReactShadowNodeImpl paramReactShadowNodeImpl)
  {
    if (this.mChildren == null)
      return -1;
    return this.mChildren.indexOf(paramReactShadowNodeImpl);
  }

  public final int indexOfNativeChild(ReactShadowNodeImpl paramReactShadowNodeImpl)
  {
    Assertions.assertNotNull(this.mNativeChildren);
    return this.mNativeChildren.indexOf(paramReactShadowNodeImpl);
  }

  public boolean isDescendantOf(ReactShadowNodeImpl paramReactShadowNodeImpl)
  {
    ReactShadowNodeImpl localReactShadowNodeImpl = getParent();
    int j = 0;
    while (true)
    {
      int i = j;
      if (localReactShadowNodeImpl != null)
      {
        if (localReactShadowNodeImpl == paramReactShadowNodeImpl)
          i = 1;
      }
      else
        return i;
      localReactShadowNodeImpl = localReactShadowNodeImpl.getParent();
    }
  }

  public final boolean isDirty()
  {
    return (this.mYogaNode != null) && (this.mYogaNode.isDirty());
  }

  public final boolean isLayoutOnly()
  {
    return this.mIsLayoutOnly;
  }

  public boolean isMeasureDefined()
  {
    return this.mYogaNode.isMeasureDefined();
  }

  public boolean isVirtual()
  {
    return false;
  }

  public boolean isVirtualAnchor()
  {
    return false;
  }

  public boolean isYogaLeafNode()
  {
    return isMeasureDefined();
  }

  public final void markLayoutSeen()
  {
    if (this.mYogaNode != null)
      this.mYogaNode.markLayoutSeen();
  }

  public final void markUpdateSeen()
  {
    this.mNodeUpdated = false;
    if (hasNewLayout())
      markLayoutSeen();
  }

  public void markUpdated()
  {
    if (this.mNodeUpdated);
    ReactShadowNodeImpl localReactShadowNodeImpl;
    do
    {
      return;
      this.mNodeUpdated = true;
      localReactShadowNodeImpl = getParent();
    }
    while (localReactShadowNodeImpl == null);
    localReactShadowNodeImpl.markUpdated();
  }

  public void onAfterUpdateTransaction()
  {
  }

  public void onBeforeLayout()
  {
  }

  public void onCollectExtraUpdates(UIViewOperationQueue paramUIViewOperationQueue)
  {
  }

  public final void removeAllNativeChildren()
  {
    if (this.mNativeChildren != null)
    {
      int i = this.mNativeChildren.size() - 1;
      while (i >= 0)
      {
        ((ReactShadowNodeImpl)this.mNativeChildren.get(i)).mNativeParent = null;
        i -= 1;
      }
      this.mNativeChildren.clear();
    }
  }

  public void removeAndDisposeAllChildren()
  {
    if (getChildCount() == 0)
      return;
    int j = 0;
    int i = getChildCount() - 1;
    if (i >= 0)
    {
      if ((this.mYogaNode != null) && (!isYogaLeafNode()))
        this.mYogaNode.removeChildAt(i);
      ReactShadowNodeImpl localReactShadowNodeImpl = getChildAt(i);
      localReactShadowNodeImpl.mParent = null;
      localReactShadowNodeImpl.dispose();
      if (localReactShadowNodeImpl.isLayoutOnly());
      for (int k = localReactShadowNodeImpl.getTotalNativeChildren(); ; k = 1)
      {
        j += k;
        i -= 1;
        break;
      }
    }
    ((ArrayList)Assertions.assertNotNull(this.mChildren)).clear();
    markUpdated();
    this.mTotalNativeChildren -= j;
    updateNativeChildrenCountInParent(-j);
  }

  public ReactShadowNodeImpl removeChildAt(int paramInt)
  {
    if (this.mChildren == null)
      throw new ArrayIndexOutOfBoundsException("Index " + paramInt + " out of bounds: node has no children");
    ReactShadowNodeImpl localReactShadowNodeImpl = (ReactShadowNodeImpl)this.mChildren.remove(paramInt);
    localReactShadowNodeImpl.mParent = null;
    if ((this.mYogaNode != null) && (!isYogaLeafNode()))
      this.mYogaNode.removeChildAt(paramInt);
    markUpdated();
    if (localReactShadowNodeImpl.isLayoutOnly());
    for (paramInt = localReactShadowNodeImpl.getTotalNativeChildren(); ; paramInt = 1)
    {
      this.mTotalNativeChildren -= paramInt;
      updateNativeChildrenCountInParent(-paramInt);
      return localReactShadowNodeImpl;
    }
  }

  public final ReactShadowNodeImpl removeNativeChildAt(int paramInt)
  {
    Assertions.assertNotNull(this.mNativeChildren);
    ReactShadowNodeImpl localReactShadowNodeImpl = (ReactShadowNodeImpl)this.mNativeChildren.remove(paramInt);
    localReactShadowNodeImpl.mNativeParent = null;
    return localReactShadowNodeImpl;
  }

  public void setAlignContent(YogaAlign paramYogaAlign)
  {
    this.mYogaNode.setAlignContent(paramYogaAlign);
  }

  public void setAlignItems(YogaAlign paramYogaAlign)
  {
    this.mYogaNode.setAlignItems(paramYogaAlign);
  }

  public void setAlignSelf(YogaAlign paramYogaAlign)
  {
    this.mYogaNode.setAlignSelf(paramYogaAlign);
  }

  public void setBaselineFunction(YogaBaselineFunction paramYogaBaselineFunction)
  {
    this.mYogaNode.setBaselineFunction(paramYogaBaselineFunction);
  }

  public void setBorder(int paramInt, float paramFloat)
  {
    this.mYogaNode.setBorder(YogaEdge.fromInt(paramInt), paramFloat);
  }

  public void setDefaultPadding(int paramInt, float paramFloat)
  {
    this.mDefaultPadding.set(paramInt, paramFloat);
    updatePadding();
  }

  public void setDisplay(YogaDisplay paramYogaDisplay)
  {
    this.mYogaNode.setDisplay(paramYogaDisplay);
  }

  public void setFlex(float paramFloat)
  {
    this.mYogaNode.setFlex(paramFloat);
  }

  public void setFlexBasis(float paramFloat)
  {
    this.mYogaNode.setFlexBasis(paramFloat);
  }

  public void setFlexBasisAuto()
  {
    this.mYogaNode.setFlexBasisAuto();
  }

  public void setFlexBasisPercent(float paramFloat)
  {
    this.mYogaNode.setFlexBasisPercent(paramFloat);
  }

  public void setFlexDirection(YogaFlexDirection paramYogaFlexDirection)
  {
    this.mYogaNode.setFlexDirection(paramYogaFlexDirection);
  }

  public void setFlexGrow(float paramFloat)
  {
    this.mYogaNode.setFlexGrow(paramFloat);
  }

  public void setFlexShrink(float paramFloat)
  {
    this.mYogaNode.setFlexShrink(paramFloat);
  }

  public void setFlexWrap(YogaWrap paramYogaWrap)
  {
    this.mYogaNode.setWrap(paramYogaWrap);
  }

  public final void setIsLayoutOnly(boolean paramBoolean)
  {
    boolean bool2 = true;
    if (getParent() == null)
    {
      bool1 = true;
      Assertions.assertCondition(bool1, "Must remove from no opt parent first");
      if (this.mNativeParent != null)
        break label61;
      bool1 = true;
      label27: Assertions.assertCondition(bool1, "Must remove from native parent first");
      if (getNativeChildCount() != 0)
        break label66;
    }
    label61: label66: for (boolean bool1 = bool2; ; bool1 = false)
    {
      Assertions.assertCondition(bool1, "Must remove all native children first");
      this.mIsLayoutOnly = paramBoolean;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label27;
    }
  }

  public void setJustifyContent(YogaJustify paramYogaJustify)
  {
    this.mYogaNode.setJustifyContent(paramYogaJustify);
  }

  public void setLayoutDirection(YogaDirection paramYogaDirection)
  {
    this.mYogaNode.setDirection(paramYogaDirection);
  }

  public void setLocalData(Object paramObject)
  {
  }

  public void setMargin(int paramInt, float paramFloat)
  {
    this.mYogaNode.setMargin(YogaEdge.fromInt(paramInt), paramFloat);
  }

  public void setMarginAuto(int paramInt)
  {
    this.mYogaNode.setMarginAuto(YogaEdge.fromInt(paramInt));
  }

  public void setMarginPercent(int paramInt, float paramFloat)
  {
    this.mYogaNode.setMarginPercent(YogaEdge.fromInt(paramInt), paramFloat);
  }

  public void setMeasureFunction(YogaMeasureFunction paramYogaMeasureFunction)
  {
    if (paramYogaMeasureFunction == null);
    for (int i = 1; ((i ^ this.mYogaNode.isMeasureDefined()) != 0) && (getChildCount() != 0); i = 0)
      throw new RuntimeException("Since a node with a measure function does not add any native yoga children, it's not safe to transition to/from having a measure function unless a node has no children");
    this.mYogaNode.setMeasureFunction(paramYogaMeasureFunction);
  }

  public void setOverflow(YogaOverflow paramYogaOverflow)
  {
    this.mYogaNode.setOverflow(paramYogaOverflow);
  }

  public void setPadding(int paramInt, float paramFloat)
  {
    this.mPadding[paramInt] = paramFloat;
    this.mPaddingIsPercent[paramInt] = false;
    updatePadding();
  }

  public void setPaddingPercent(int paramInt, float paramFloat)
  {
    this.mPadding[paramInt] = paramFloat;
    boolean[] arrayOfBoolean = this.mPaddingIsPercent;
    if (!YogaConstants.isUndefined(paramFloat));
    for (int i = 1; ; i = 0)
    {
      arrayOfBoolean[paramInt] = i;
      updatePadding();
      return;
    }
  }

  public void setPosition(int paramInt, float paramFloat)
  {
    this.mYogaNode.setPosition(YogaEdge.fromInt(paramInt), paramFloat);
  }

  public void setPositionPercent(int paramInt, float paramFloat)
  {
    this.mYogaNode.setPositionPercent(YogaEdge.fromInt(paramInt), paramFloat);
  }

  public void setPositionType(YogaPositionType paramYogaPositionType)
  {
    this.mYogaNode.setPositionType(paramYogaPositionType);
  }

  public void setReactTag(int paramInt)
  {
    this.mReactTag = paramInt;
  }

  public final void setRootNode(ReactShadowNodeImpl paramReactShadowNodeImpl)
  {
    this.mRootNode = paramReactShadowNodeImpl;
  }

  public void setShouldNotifyOnLayout(boolean paramBoolean)
  {
    this.mShouldNotifyOnLayout = paramBoolean;
  }

  public void setStyleAspectRatio(float paramFloat)
  {
    this.mYogaNode.setAspectRatio(paramFloat);
  }

  public void setStyleHeight(float paramFloat)
  {
    this.mYogaNode.setHeight(paramFloat);
  }

  public void setStyleHeightAuto()
  {
    this.mYogaNode.setHeightAuto();
  }

  public void setStyleHeightPercent(float paramFloat)
  {
    this.mYogaNode.setHeightPercent(paramFloat);
  }

  public void setStyleMaxHeight(float paramFloat)
  {
    this.mYogaNode.setMaxHeight(paramFloat);
  }

  public void setStyleMaxHeightPercent(float paramFloat)
  {
    this.mYogaNode.setMaxHeightPercent(paramFloat);
  }

  public void setStyleMaxWidth(float paramFloat)
  {
    this.mYogaNode.setMaxWidth(paramFloat);
  }

  public void setStyleMaxWidthPercent(float paramFloat)
  {
    this.mYogaNode.setMaxWidthPercent(paramFloat);
  }

  public void setStyleMinHeight(float paramFloat)
  {
    this.mYogaNode.setMinHeight(paramFloat);
  }

  public void setStyleMinHeightPercent(float paramFloat)
  {
    this.mYogaNode.setMinHeightPercent(paramFloat);
  }

  public void setStyleMinWidth(float paramFloat)
  {
    this.mYogaNode.setMinWidth(paramFloat);
  }

  public void setStyleMinWidthPercent(float paramFloat)
  {
    this.mYogaNode.setMinWidthPercent(paramFloat);
  }

  public void setStyleWidth(float paramFloat)
  {
    this.mYogaNode.setWidth(paramFloat);
  }

  public void setStyleWidthAuto()
  {
    this.mYogaNode.setWidthAuto();
  }

  public void setStyleWidthPercent(float paramFloat)
  {
    this.mYogaNode.setWidthPercent(paramFloat);
  }

  public void setThemedContext(ThemedReactContext paramThemedReactContext)
  {
    this.mThemedContext = paramThemedReactContext;
  }

  public final void setViewClassName(String paramString)
  {
    this.mViewClassName = paramString;
  }

  public final boolean shouldNotifyOnLayout()
  {
    return this.mShouldNotifyOnLayout;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    toStringWithIndentation(localStringBuilder, 0);
    return localStringBuilder.toString();
  }

  public final void updateProperties(ReactStylesDiffMap paramReactStylesDiffMap)
  {
    ViewManagerPropertyUpdater.updateProps(this, paramReactStylesDiffMap);
    onAfterUpdateTransaction();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ReactShadowNodeImpl
 * JD-Core Version:    0.6.0
 */
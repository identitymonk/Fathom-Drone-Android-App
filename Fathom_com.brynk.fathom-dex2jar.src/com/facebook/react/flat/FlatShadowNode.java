package com.facebook.react.flat;

import android.graphics.Rect;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.OnLayoutEvent;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

class FlatShadowNode extends LayoutShadowNode
{
  static final FlatShadowNode[] EMPTY_ARRAY = new FlatShadowNode[0];
  private static final DrawView EMPTY_DRAW_VIEW;
  private static final Rect LOGICAL_OFFSET_EMPTY = new Rect();
  private static final String PROP_ACCESSIBILITY_COMPONENT_TYPE = "accessibilityComponentType";
  private static final String PROP_ACCESSIBILITY_LABEL = "accessibilityLabel";
  private static final String PROP_ACCESSIBILITY_LIVE_REGION = "accessibilityLiveRegion";
  protected static final String PROP_HORIZONTAL = "horizontal";
  private static final String PROP_IMPORTANT_FOR_ACCESSIBILITY = "importantForAccessibility";
  private static final String PROP_OPACITY = "opacity";
  protected static final String PROP_REMOVE_CLIPPED_SUBVIEWS = "removeClippedSubviews";
  private static final String PROP_RENDER_TO_HARDWARE_TEXTURE = "renderToHardwareTextureAndroid";
  private static final String PROP_TEST_ID = "testID";
  private static final String PROP_TRANSFORM = "transform";
  private AttachDetachListener[] mAttachDetachListeners = AttachDetachListener.EMPTY_ARRAY;
  private boolean mBackingViewIsCreated;
  private float mClipBottom;
  private float mClipLeft;
  float mClipRadius;
  private float mClipRight;
  boolean mClipToBounds = false;
  private float mClipTop;

  @Nullable
  private DrawBackgroundColor mDrawBackground;
  private DrawCommand[] mDrawCommands = DrawCommand.EMPTY_ARRAY;

  @Nullable
  private DrawView mDrawView;
  private boolean mForceMountChildrenToView;
  private boolean mIsUpdated = true;
  private int mLayoutHeight;
  private int mLayoutWidth;
  private int mLayoutX;
  private int mLayoutY;
  private Rect mLogicalOffset = LOGICAL_OFFSET_EMPTY;
  private FlatShadowNode[] mNativeChildren = EMPTY_ARRAY;
  private int mNativeParentTag;
  private NodeRegion mNodeRegion = NodeRegion.EMPTY;
  private NodeRegion[] mNodeRegions = NodeRegion.EMPTY_ARRAY;
  private boolean mOverflowsContainer;
  private int mViewBottom;
  private int mViewLeft;
  private int mViewRight;
  private int mViewTop;

  static
  {
    EMPTY_DRAW_VIEW = new DrawView(0);
  }

  public void addChildAt(ReactShadowNodeImpl paramReactShadowNodeImpl, int paramInt)
  {
    super.addChildAt(paramReactShadowNodeImpl, paramInt);
    if ((this.mForceMountChildrenToView) && ((paramReactShadowNodeImpl instanceof FlatShadowNode)))
      ((FlatShadowNode)paramReactShadowNodeImpl).forceMountToView();
  }

  final boolean clipBoundsChanged(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (this.mClipLeft != paramFloat1) || (this.mClipTop != paramFloat2) || (this.mClipRight != paramFloat3) || (this.mClipBottom != paramFloat4);
  }

  public final boolean clipToBounds()
  {
    return this.mClipToBounds;
  }

  public boolean clipsSubviews()
  {
    return false;
  }

  final DrawView collectDrawView(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    Assertions.assumeNotNull(this.mDrawView);
    if (this.mDrawView == EMPTY_DRAW_VIEW)
      this.mDrawView = new DrawView(getReactTag());
    float f;
    if (this.mClipToBounds)
      f = this.mClipRadius;
    while (true)
    {
      this.mDrawView = this.mDrawView.collectDrawView(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat1 + this.mLogicalOffset.left, paramFloat2 + this.mLogicalOffset.top, paramFloat3 + this.mLogicalOffset.right, paramFloat4 + this.mLogicalOffset.bottom, paramFloat5, paramFloat6, paramFloat7, paramFloat8, f);
      return this.mDrawView;
      f = 0.0F;
    }
  }

  protected void collectState(StateBuilder paramStateBuilder, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    if (this.mDrawBackground != null)
    {
      this.mDrawBackground = ((DrawBackgroundColor)this.mDrawBackground.updateBoundsAndFreeze(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8));
      paramStateBuilder.addDrawCommand(this.mDrawBackground);
    }
  }

  boolean doesDraw()
  {
    return (this.mDrawView != null) || (this.mDrawBackground != null);
  }

  final void forceMountChildrenToView()
  {
    if (this.mForceMountChildrenToView);
    while (true)
    {
      return;
      this.mForceMountChildrenToView = true;
      int i = 0;
      int j = getChildCount();
      while (i != j)
      {
        ReactShadowNodeImpl localReactShadowNodeImpl = getChildAt(i);
        if ((localReactShadowNodeImpl instanceof FlatShadowNode))
          ((FlatShadowNode)localReactShadowNodeImpl).forceMountToView();
        i += 1;
      }
    }
  }

  final void forceMountToView()
  {
    if (isVirtual());
    do
      return;
    while (this.mDrawView != null);
    this.mDrawView = EMPTY_DRAW_VIEW;
    invalidate();
    this.mNodeRegion = NodeRegion.EMPTY;
  }

  final AttachDetachListener[] getAttachDetachListeners()
  {
    return this.mAttachDetachListeners;
  }

  final DrawCommand[] getDrawCommands()
  {
    return this.mDrawCommands;
  }

  final FlatShadowNode[] getNativeChildren()
  {
    return this.mNativeChildren;
  }

  final int getNativeParentTag()
  {
    return this.mNativeParentTag;
  }

  final NodeRegion getNodeRegion()
  {
    return this.mNodeRegion;
  }

  final NodeRegion[] getNodeRegions()
  {
    return this.mNodeRegions;
  }

  public final int getScreenHeight()
  {
    if (mountsToView())
      return this.mViewBottom - this.mViewTop;
    return Math.round(this.mNodeRegion.getBottom() - this.mNodeRegion.getTop());
  }

  public final int getScreenWidth()
  {
    if (mountsToView())
      return this.mViewRight - this.mViewLeft;
    return Math.round(this.mNodeRegion.getRight() - this.mNodeRegion.getLeft());
  }

  public final int getScreenX()
  {
    return this.mViewLeft;
  }

  public final int getScreenY()
  {
    return this.mViewTop;
  }

  final int getViewBottom()
  {
    return this.mViewBottom;
  }

  final int getViewLeft()
  {
    return this.mViewLeft;
  }

  final int getViewRight()
  {
    return this.mViewRight;
  }

  final int getViewTop()
  {
    return this.mViewTop;
  }

  void handleUpdateProperties(ReactStylesDiffMap paramReactStylesDiffMap)
  {
    if ((!mountsToView()) && ((paramReactStylesDiffMap.hasKey("opacity")) || (paramReactStylesDiffMap.hasKey("renderToHardwareTextureAndroid")) || (paramReactStylesDiffMap.hasKey("testID")) || (paramReactStylesDiffMap.hasKey("accessibilityLabel")) || (paramReactStylesDiffMap.hasKey("accessibilityComponentType")) || (paramReactStylesDiffMap.hasKey("accessibilityLiveRegion")) || (paramReactStylesDiffMap.hasKey("transform")) || (paramReactStylesDiffMap.hasKey("importantForAccessibility")) || (paramReactStylesDiffMap.hasKey("removeClippedSubviews"))))
      forceMountToView();
  }

  protected final void invalidate()
  {
    for (Object localObject = this; ; localObject = (FlatShadowNode)localObject)
    {
      if (((FlatShadowNode)localObject).mountsToView())
        if (!((FlatShadowNode)localObject).mIsUpdated);
      do
      {
        return;
        ((FlatShadowNode)localObject).mIsUpdated = true;
        localObject = ((FlatShadowNode)localObject).getParent();
      }
      while (localObject == null);
    }
  }

  final boolean isBackingViewCreated()
  {
    return this.mBackingViewIsCreated;
  }

  public boolean isHorizontal()
  {
    return false;
  }

  final boolean isUpdated()
  {
    return this.mIsUpdated;
  }

  public void markUpdated()
  {
    super.markUpdated();
    this.mIsUpdated = true;
    invalidate();
  }

  final boolean mountsToView()
  {
    return this.mDrawView != null;
  }

  @Nullable
  final OnLayoutEvent obtainLayoutEvent(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.mLayoutX == paramInt1) && (this.mLayoutY == paramInt2) && (this.mLayoutWidth == paramInt3) && (this.mLayoutHeight == paramInt4))
      return null;
    this.mLayoutX = paramInt1;
    this.mLayoutY = paramInt2;
    this.mLayoutWidth = paramInt3;
    this.mLayoutHeight = paramInt4;
    return OnLayoutEvent.obtain(getReactTag(), paramInt1, paramInt2, paramInt3, paramInt4);
  }

  final void resetUpdated()
  {
    this.mIsUpdated = false;
  }

  final void setAttachDetachListeners(AttachDetachListener[] paramArrayOfAttachDetachListener)
  {
    this.mAttachDetachListeners = paramArrayOfAttachDetachListener;
  }

  @ReactProp(name="backgroundColor")
  public void setBackgroundColor(int paramInt)
  {
    if (paramInt == 0);
    for (DrawBackgroundColor localDrawBackgroundColor = null; ; localDrawBackgroundColor = new DrawBackgroundColor(paramInt))
    {
      this.mDrawBackground = localDrawBackgroundColor;
      invalidate();
      return;
    }
  }

  final void setClipBounds(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mClipLeft = paramFloat1;
    this.mClipTop = paramFloat2;
    this.mClipRight = paramFloat3;
    this.mClipBottom = paramFloat4;
  }

  final void setDrawCommands(DrawCommand[] paramArrayOfDrawCommand)
  {
    this.mDrawCommands = paramArrayOfDrawCommand;
  }

  final void setNativeChildren(FlatShadowNode[] paramArrayOfFlatShadowNode)
  {
    this.mNativeChildren = paramArrayOfFlatShadowNode;
  }

  final void setNativeParentTag(int paramInt)
  {
    this.mNativeParentTag = paramInt;
  }

  protected final void setNodeRegion(NodeRegion paramNodeRegion)
  {
    this.mNodeRegion = paramNodeRegion;
    updateOverflowsContainer();
  }

  final void setNodeRegions(NodeRegion[] paramArrayOfNodeRegion)
  {
    this.mNodeRegions = paramArrayOfNodeRegion;
    updateOverflowsContainer();
  }

  public void setOverflow(String paramString)
  {
    super.setOverflow(paramString);
    this.mClipToBounds = "hidden".equals(paramString);
    if (this.mClipToBounds)
    {
      this.mOverflowsContainer = false;
      if (this.mClipRadius > 0.5F)
        forceMountToView();
    }
    while (true)
    {
      invalidate();
      return;
      updateOverflowsContainer();
    }
  }

  final void setViewBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mViewLeft = paramInt1;
    this.mViewTop = paramInt2;
    this.mViewRight = paramInt3;
    this.mViewBottom = paramInt4;
  }

  final void signalBackingViewIsCreated()
  {
    this.mBackingViewIsCreated = true;
  }

  void updateNodeRegion(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    if (!this.mNodeRegion.matches(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBoolean))
      setNodeRegion(new NodeRegion(paramFloat1, paramFloat2, paramFloat3, paramFloat4, getReactTag(), paramBoolean));
  }

  final void updateOverflowsContainer()
  {
    boolean bool3 = false;
    boolean bool2 = false;
    int j = (int)(this.mNodeRegion.getRight() - this.mNodeRegion.getLeft());
    int k = (int)(this.mNodeRegion.getBottom() - this.mNodeRegion.getTop());
    float f7 = 0.0F;
    float f4 = j;
    float f1 = 0.0F;
    float f2 = k;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    boolean bool1 = bool3;
    int i;
    Object localObject3;
    if (!this.mClipToBounds)
    {
      localObject1 = localObject2;
      bool1 = bool3;
      if (k > 0)
      {
        localObject1 = localObject2;
        bool1 = bool3;
        if (j > 0)
        {
          localObject1 = this.mNodeRegions;
          int m = localObject1.length;
          i = 0;
          while (i < m)
          {
            localObject3 = localObject1[i];
            float f3 = f7;
            if (((NodeRegion)localObject3).getLeft() < f7)
            {
              f3 = ((NodeRegion)localObject3).getLeft();
              bool2 = true;
            }
            float f5 = f4;
            if (((NodeRegion)localObject3).getRight() > f4)
            {
              f5 = ((NodeRegion)localObject3).getRight();
              bool2 = true;
            }
            float f6 = f1;
            if (((NodeRegion)localObject3).getTop() < f1)
            {
              f6 = ((NodeRegion)localObject3).getTop();
              bool2 = true;
            }
            f1 = f2;
            if (((NodeRegion)localObject3).getBottom() > f2)
            {
              f1 = ((NodeRegion)localObject3).getBottom();
              bool2 = true;
            }
            i += 1;
            f2 = f1;
            f7 = f3;
            f4 = f5;
            f1 = f6;
          }
          localObject1 = localObject2;
          bool1 = bool2;
          if (bool2)
          {
            localObject1 = new Rect((int)f7, (int)f1, (int)(f4 - j), (int)(f2 - k));
            bool1 = bool2;
          }
        }
      }
    }
    localObject2 = localObject1;
    bool2 = bool1;
    if (!bool1)
    {
      localObject2 = localObject1;
      bool2 = bool1;
      if (this.mNodeRegion != NodeRegion.EMPTY)
      {
        j = getChildCount();
        i = 0;
        while (true)
        {
          localObject2 = localObject1;
          bool2 = bool1;
          if (i >= j)
            break;
          localObject3 = getChildAt(i);
          localObject2 = localObject1;
          bool2 = bool1;
          if ((localObject3 instanceof FlatShadowNode))
          {
            localObject2 = localObject1;
            bool2 = bool1;
            if (((FlatShadowNode)localObject3).mOverflowsContainer)
            {
              localObject3 = ((FlatShadowNode)localObject3).mLogicalOffset;
              localObject2 = localObject1;
              if (localObject1 == null)
                localObject2 = new Rect();
              ((Rect)localObject2).union((Rect)localObject3);
              bool2 = true;
            }
          }
          i += 1;
          localObject1 = localObject2;
          bool1 = bool2;
        }
      }
    }
    if (this.mOverflowsContainer != bool2)
    {
      this.mOverflowsContainer = bool2;
      localObject1 = localObject2;
      if (localObject2 == null)
        localObject1 = LOGICAL_OFFSET_EMPTY;
      this.mLogicalOffset = ((Rect)localObject1);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.FlatShadowNode
 * JD-Core Version:    0.6.0
 */
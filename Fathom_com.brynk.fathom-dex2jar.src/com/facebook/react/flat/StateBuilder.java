package com.facebook.react.flat;

import android.util.SparseIntArray;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.OnLayoutEvent;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.UIViewOperationQueue.UIOperation;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.ArrayList;
import javax.annotation.Nullable;

final class StateBuilder
{
  static final float[] EMPTY_FLOAT_ARRAY = new float[0];
  private static final int[] EMPTY_INT_ARRAY;
  static final SparseIntArray EMPTY_SPARSE_INT = new SparseIntArray();
  private static final boolean SKIP_UP_TO_DATE_NODES = true;
  private final ElementsList<AttachDetachListener> mAttachDetachListeners = new ElementsList(AttachDetachListener.EMPTY_ARRAY);

  @Nullable
  private FlatUIViewOperationQueue.DetachAllChildrenFromViews mDetachAllChildrenFromViews;
  private final ElementsList<DrawCommand> mDrawCommands = new ElementsList(DrawCommand.EMPTY_ARRAY);
  private final ElementsList<FlatShadowNode> mNativeChildren = new ElementsList(FlatShadowNode.EMPTY_ARRAY);
  private final ElementsList<NodeRegion> mNodeRegions = new ElementsList(NodeRegion.EMPTY_ARRAY);
  private final ArrayList<OnLayoutEvent> mOnLayoutEvents = new ArrayList();
  private final FlatUIViewOperationQueue mOperationsQueue;
  private final ArrayList<Integer> mParentsForViewsToDrop = new ArrayList();
  private final ArrayList<UIViewOperationQueue.UIOperation> mUpdateViewBoundsOperations = new ArrayList();
  private final ArrayList<UIViewOperationQueue.UIOperation> mViewManagerCommands = new ArrayList();
  private final ArrayList<FlatShadowNode> mViewsToDetach = new ArrayList();
  private final ArrayList<FlatShadowNode> mViewsToDetachAllChildrenFrom = new ArrayList();
  private final ArrayList<Integer> mViewsToDrop = new ArrayList();

  static
  {
    EMPTY_INT_ARRAY = new int[0];
  }

  StateBuilder(FlatUIViewOperationQueue paramFlatUIViewOperationQueue)
  {
    this.mOperationsQueue = paramFlatUIViewOperationQueue;
  }

  private void addNativeChild(FlatShadowNode paramFlatShadowNode)
  {
    this.mNativeChildren.add(paramFlatShadowNode);
  }

  private void addNodeRegion(FlatShadowNode paramFlatShadowNode, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    if ((paramFloat1 == paramFloat3) || (paramFloat2 == paramFloat4));
    do
    {
      return;
      paramFlatShadowNode.updateNodeRegion(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBoolean);
    }
    while (!paramFlatShadowNode.doesDraw());
    this.mNodeRegions.add(paramFlatShadowNode.getNodeRegion());
  }

  private boolean collectStateForMountableNode(FlatShadowNode paramFlatShadowNode, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    if ((paramFlatShadowNode.hasNewLayout()) || (paramFlatShadowNode.isUpdated()) || (paramFlatShadowNode.hasUnseenUpdates()) || (paramFlatShadowNode.clipBoundsChanged(paramFloat5, paramFloat6, paramFloat7, paramFloat8)));
    for (int j = 1; j == 0; j = 0)
    {
      bool2 = false;
      return bool2;
    }
    paramFlatShadowNode.setClipBounds(paramFloat5, paramFloat6, paramFloat7, paramFloat8);
    this.mDrawCommands.start(paramFlatShadowNode.getDrawCommands());
    this.mAttachDetachListeners.start(paramFlatShadowNode.getAttachDetachListeners());
    this.mNodeRegions.start(paramFlatShadowNode.getNodeRegions());
    this.mNativeChildren.start(paramFlatShadowNode.getNativeChildren());
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject;
    if ((paramFlatShadowNode instanceof AndroidView))
    {
      localObject = (AndroidView)paramFlatShadowNode;
      updateViewPadding((AndroidView)localObject, paramFlatShadowNode.getReactTag());
      bool1 = true;
      bool2 = ((AndroidView)localObject).needsCustomLayoutForChildren();
      paramFloat5 = (1.0F / -1.0F);
      paramFloat6 = (1.0F / -1.0F);
      paramFloat7 = (1.0F / 1.0F);
      paramFloat8 = (1.0F / 1.0F);
    }
    if ((!bool1) && (paramFlatShadowNode.isVirtualAnchor()))
      addNodeRegion(paramFlatShadowNode, paramFloat1, paramFloat2, paramFloat3, paramFloat4, true);
    bool2 = collectStateRecursively(paramFlatShadowNode, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, bool1, bool2);
    int i = 0;
    DrawCommand[] arrayOfDrawCommand = (DrawCommand[])this.mDrawCommands.finish();
    if (arrayOfDrawCommand != null)
    {
      i = 1;
      paramFlatShadowNode.setDrawCommands(arrayOfDrawCommand);
    }
    AttachDetachListener[] arrayOfAttachDetachListener = (AttachDetachListener[])this.mAttachDetachListeners.finish();
    if (arrayOfAttachDetachListener != null)
    {
      i = 1;
      paramFlatShadowNode.setAttachDetachListeners(arrayOfAttachDetachListener);
    }
    NodeRegion[] arrayOfNodeRegion = (NodeRegion[])this.mNodeRegions.finish();
    int k;
    label299: float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    label384: float[] arrayOfFloat3;
    float[] arrayOfFloat4;
    if (arrayOfNodeRegion != null)
    {
      k = 1;
      paramFlatShadowNode.setNodeRegions(arrayOfNodeRegion);
      FlatShadowNode[] arrayOfFlatShadowNode = (FlatShadowNode[])this.mNativeChildren.finish();
      if (k != 0)
      {
        if (!paramFlatShadowNode.clipsSubviews())
          break label625;
        arrayOfFloat1 = EMPTY_FLOAT_ARRAY;
        arrayOfFloat2 = EMPTY_FLOAT_ARRAY;
        localObject = EMPTY_SPARSE_INT;
        if (arrayOfDrawCommand != null)
        {
          localObject = new SparseIntArray();
          arrayOfFloat1 = new float[arrayOfDrawCommand.length];
          arrayOfFloat2 = new float[arrayOfDrawCommand.length];
          if (!paramFlatShadowNode.isHorizontal())
            break label593;
          HorizontalDrawCommandManager.fillMaxMinArrays(arrayOfDrawCommand, arrayOfFloat1, arrayOfFloat2, (SparseIntArray)localObject);
        }
        arrayOfFloat3 = EMPTY_FLOAT_ARRAY;
        arrayOfFloat4 = EMPTY_FLOAT_ARRAY;
        if (arrayOfNodeRegion != null)
        {
          arrayOfFloat3 = new float[arrayOfNodeRegion.length];
          arrayOfFloat4 = new float[arrayOfNodeRegion.length];
          if (!paramFlatShadowNode.isHorizontal())
            break label607;
          HorizontalDrawCommandManager.fillMaxMinArrays(arrayOfNodeRegion, arrayOfFloat3, arrayOfFloat4);
        }
        label429: if (arrayOfFlatShadowNode == null)
          break label619;
        bool1 = true;
        label437: this.mOperationsQueue.enqueueUpdateClippingMountState(paramFlatShadowNode.getReactTag(), arrayOfDrawCommand, (SparseIntArray)localObject, arrayOfFloat1, arrayOfFloat2, arrayOfAttachDetachListener, arrayOfNodeRegion, arrayOfFloat3, arrayOfFloat4, bool1);
      }
      label466: if (paramFlatShadowNode.hasUnseenUpdates())
      {
        paramFlatShadowNode.onCollectExtraUpdates(this.mOperationsQueue);
        paramFlatShadowNode.markUpdateSeen();
      }
      if (arrayOfFlatShadowNode != null)
        updateNativeChildren(paramFlatShadowNode, paramFlatShadowNode.getNativeChildren(), arrayOfFlatShadowNode);
      if ((k == 0) && (arrayOfFlatShadowNode == null) && (!bool2))
        break label645;
    }
    label645: for (bool1 = true; ; bool1 = false)
    {
      bool2 = bool1;
      if (j != 0)
        break;
      bool2 = bool1;
      if (!bool1)
        break;
      throw new RuntimeException("Node " + paramFlatShadowNode.getReactTag() + " updated unexpectedly.");
      k = i;
      if (!bool2)
        break label299;
      paramFlatShadowNode.updateOverflowsContainer();
      k = i;
      break label299;
      label593: VerticalDrawCommandManager.fillMaxMinArrays(arrayOfDrawCommand, arrayOfFloat1, arrayOfFloat2, (SparseIntArray)localObject);
      break label384;
      label607: VerticalDrawCommandManager.fillMaxMinArrays(arrayOfNodeRegion, arrayOfFloat3, arrayOfFloat4);
      break label429;
      label619: bool1 = false;
      break label437;
      label625: this.mOperationsQueue.enqueueUpdateMountState(paramFlatShadowNode.getReactTag(), arrayOfDrawCommand, arrayOfAttachDetachListener, arrayOfNodeRegion);
      break label466;
    }
  }

  private boolean collectStateRecursively(FlatShadowNode paramFlatShadowNode, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramFlatShadowNode.hasNewLayout())
      paramFlatShadowNode.markLayoutSeen();
    float f5 = roundToPixel(paramFloat1);
    float f6 = roundToPixel(paramFloat2);
    float f7 = roundToPixel(paramFloat3);
    float f8 = roundToPixel(paramFloat4);
    Object localObject;
    if (paramFlatShadowNode.shouldNotifyOnLayout())
    {
      localObject = paramFlatShadowNode.obtainLayoutEvent(Math.round(paramFlatShadowNode.getLayoutX()), Math.round(paramFlatShadowNode.getLayoutY()), (int)(f7 - f5), (int)(f8 - f6));
      if (localObject != null)
        this.mOnLayoutEvents.add(localObject);
    }
    float f4 = paramFloat5;
    float f3 = paramFloat6;
    float f2 = paramFloat7;
    float f1 = paramFloat8;
    if (paramFlatShadowNode.clipToBounds())
    {
      f4 = Math.max(paramFloat1, paramFloat5);
      f3 = Math.max(paramFloat2, paramFloat6);
      f2 = Math.min(paramFloat3, paramFloat7);
      f1 = Math.min(paramFloat4, paramFloat8);
    }
    paramFlatShadowNode.collectState(this, f5, f6, f7, f8, roundToPixel(f4), roundToPixel(f3), roundToPixel(f2), f1);
    boolean bool = false;
    int i = 0;
    int j = paramFlatShadowNode.getChildCount();
    if (i != j)
    {
      localObject = paramFlatShadowNode.getChildAt(i);
      if (((ReactShadowNode)localObject).isVirtual());
      while (true)
      {
        i += 1;
        break;
        bool |= processNodeAndCollectState((FlatShadowNode)localObject, paramFloat1, paramFloat2, f4, f3, f2, f1, paramBoolean1, paramBoolean2);
      }
    }
    paramFlatShadowNode.resetUpdated();
    return bool;
  }

  private static int[] collectViewTags(ArrayList<FlatShadowNode> paramArrayList)
  {
    int j = paramArrayList.size();
    Object localObject;
    if (j == 0)
    {
      localObject = EMPTY_INT_ARRAY;
      return localObject;
    }
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (true)
    {
      localObject = arrayOfInt;
      if (i >= j)
        break;
      arrayOfInt[i] = ((FlatShadowNode)paramArrayList.get(i)).getReactTag();
      i += 1;
    }
  }

  private boolean processNodeAndCollectState(FlatShadowNode paramFlatShadowNode, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = paramFlatShadowNode.getLayoutWidth();
    float f1 = paramFlatShadowNode.getLayoutHeight();
    paramFloat1 += paramFlatShadowNode.getLayoutX();
    paramFloat2 += paramFlatShadowNode.getLayoutY();
    f2 = paramFloat1 + f2;
    f1 = paramFloat2 + f1;
    boolean bool2 = paramFlatShadowNode.mountsToView();
    if (!paramBoolean1)
      if (bool2)
        break label167;
    label167: for (boolean bool1 = true; ; bool1 = false)
    {
      addNodeRegion(paramFlatShadowNode, paramFloat1, paramFloat2, f2, f1, bool1);
      if (!bool2)
        break;
      ensureBackingViewIsCreated(paramFlatShadowNode);
      addNativeChild(paramFlatShadowNode);
      bool1 = collectStateForMountableNode(paramFlatShadowNode, 0.0F, 0.0F, f2 - paramFloat1, f1 - paramFloat2, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2, paramFloat5 - paramFloat1, paramFloat6 - paramFloat2);
      if (!paramBoolean1)
        this.mDrawCommands.add(paramFlatShadowNode.collectDrawView(paramFloat1, paramFloat2, f2, f1, paramFloat3, paramFloat4, paramFloat5, paramFloat6));
      if (!paramBoolean2)
        updateViewBounds(paramFlatShadowNode, paramFloat1, paramFloat2, f2, f1);
      return bool1;
    }
    return collectStateRecursively(paramFlatShadowNode, paramFloat1, paramFloat2, f2, f1, paramFloat3, paramFloat4, paramFloat5, paramFloat6, false, false);
  }

  private static float roundToPixel(float paramFloat)
  {
    return (float)Math.floor(0.5F + paramFloat);
  }

  private void updateNativeChildren(FlatShadowNode paramFlatShadowNode, FlatShadowNode[] paramArrayOfFlatShadowNode1, FlatShadowNode[] paramArrayOfFlatShadowNode2)
  {
    int k = 0;
    paramFlatShadowNode.setNativeChildren(paramArrayOfFlatShadowNode2);
    if (this.mDetachAllChildrenFromViews == null)
      this.mDetachAllChildrenFromViews = this.mOperationsQueue.enqueueDetachAllChildrenFromViews();
    if (paramArrayOfFlatShadowNode1.length != 0)
      this.mViewsToDetachAllChildrenFrom.add(paramFlatShadowNode);
    int m = paramFlatShadowNode.getReactTag();
    int i = paramArrayOfFlatShadowNode2.length;
    if (i == 0)
      paramFlatShadowNode = EMPTY_INT_ARRAY;
    while (true)
    {
      j = paramArrayOfFlatShadowNode1.length;
      i = 0;
      while (true)
        if (i < j)
        {
          Object localObject = paramArrayOfFlatShadowNode1[i];
          if (((FlatShadowNode)localObject).getNativeParentTag() == m)
          {
            this.mViewsToDetach.add(localObject);
            ((FlatShadowNode)localObject).setNativeParentTag(-1);
          }
          i += 1;
          continue;
          localObject = new int[i];
          j = 0;
          int n = paramArrayOfFlatShadowNode2.length;
          i = 0;
          paramFlatShadowNode = (FlatShadowNode)localObject;
          if (i >= n)
            break;
          paramFlatShadowNode = paramArrayOfFlatShadowNode2[i];
          if (paramFlatShadowNode.getNativeParentTag() == m)
            localObject[j] = (-paramFlatShadowNode.getReactTag());
          while (true)
          {
            paramFlatShadowNode.setNativeParentTag(-1);
            j += 1;
            i += 1;
            break;
            localObject[j] = paramFlatShadowNode.getReactTag();
          }
        }
    }
    paramArrayOfFlatShadowNode1 = collectViewTags(this.mViewsToDetach);
    this.mViewsToDetach.clear();
    int j = paramArrayOfFlatShadowNode2.length;
    i = k;
    while (i < j)
    {
      paramArrayOfFlatShadowNode2[i].setNativeParentTag(m);
      i += 1;
    }
    this.mOperationsQueue.enqueueUpdateViewGroup(m, paramFlatShadowNode, paramArrayOfFlatShadowNode1);
  }

  private void updateViewBounds(FlatShadowNode paramFlatShadowNode, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = Math.round(paramFloat1);
    int j = Math.round(paramFloat2);
    int k = Math.round(paramFloat3);
    int m = Math.round(paramFloat4);
    if ((paramFlatShadowNode.getViewLeft() == i) && (paramFlatShadowNode.getViewTop() == j) && (paramFlatShadowNode.getViewRight() == k) && (paramFlatShadowNode.getViewBottom() == m))
      return;
    paramFlatShadowNode.setViewBounds(i, j, k, m);
    int n = paramFlatShadowNode.getReactTag();
    this.mUpdateViewBoundsOperations.add(this.mOperationsQueue.createUpdateViewBounds(n, i, j, k, m));
  }

  private void updateViewPadding(AndroidView paramAndroidView, int paramInt)
  {
    if (paramAndroidView.isPaddingChanged())
    {
      this.mOperationsQueue.enqueueSetPadding(paramInt, Math.round(paramAndroidView.getPadding(0)), Math.round(paramAndroidView.getPadding(1)), Math.round(paramAndroidView.getPadding(2)), Math.round(paramAndroidView.getPadding(3)));
      paramAndroidView.resetPaddingChanged();
    }
  }

  void addAttachDetachListener(AttachDetachListener paramAttachDetachListener)
  {
    this.mAttachDetachListeners.add(paramAttachDetachListener);
  }

  void addDrawCommand(AbstractDrawCommand paramAbstractDrawCommand)
  {
    this.mDrawCommands.add(paramAbstractDrawCommand);
  }

  void afterUpdateViewHierarchy(EventDispatcher paramEventDispatcher)
  {
    if (this.mDetachAllChildrenFromViews != null)
    {
      int[] arrayOfInt = collectViewTags(this.mViewsToDetachAllChildrenFrom);
      this.mViewsToDetachAllChildrenFrom.clear();
      this.mDetachAllChildrenFromViews.setViewsToDetachAllChildrenFrom(arrayOfInt);
      this.mDetachAllChildrenFromViews = null;
    }
    int i = 0;
    int j = this.mUpdateViewBoundsOperations.size();
    while (i != j)
    {
      this.mOperationsQueue.enqueueFlatUIOperation((UIViewOperationQueue.UIOperation)this.mUpdateViewBoundsOperations.get(i));
      i += 1;
    }
    this.mUpdateViewBoundsOperations.clear();
    i = 0;
    j = this.mViewManagerCommands.size();
    while (i != j)
    {
      this.mOperationsQueue.enqueueFlatUIOperation((UIViewOperationQueue.UIOperation)this.mViewManagerCommands.get(i));
      i += 1;
    }
    this.mViewManagerCommands.clear();
    i = 0;
    j = this.mOnLayoutEvents.size();
    while (i != j)
    {
      paramEventDispatcher.dispatchEvent((Event)this.mOnLayoutEvents.get(i));
      i += 1;
    }
    this.mOnLayoutEvents.clear();
    if (this.mViewsToDrop.size() > 0)
    {
      this.mOperationsQueue.enqueueDropViews(this.mViewsToDrop, this.mParentsForViewsToDrop);
      this.mViewsToDrop.clear();
      this.mParentsForViewsToDrop.clear();
    }
    this.mOperationsQueue.enqueueProcessLayoutRequests();
  }

  void applyUpdates(FlatShadowNode paramFlatShadowNode)
  {
    float f4 = paramFlatShadowNode.getLayoutWidth();
    float f3 = paramFlatShadowNode.getLayoutHeight();
    float f1 = paramFlatShadowNode.getLayoutX();
    float f2 = paramFlatShadowNode.getLayoutY();
    f4 = f1 + f4;
    f3 = f2 + f3;
    collectStateForMountableNode(paramFlatShadowNode, f1, f2, f4, f3, (1.0F / -1.0F), (1.0F / -1.0F), (1.0F / 1.0F), (1.0F / 1.0F));
    updateViewBounds(paramFlatShadowNode, f1, f2, f4, f3);
  }

  void dropView(FlatShadowNode paramFlatShadowNode, int paramInt)
  {
    this.mViewsToDrop.add(Integer.valueOf(paramFlatShadowNode.getReactTag()));
    this.mParentsForViewsToDrop.add(Integer.valueOf(paramInt));
  }

  void enqueueCreateOrUpdateView(FlatShadowNode paramFlatShadowNode, @Nullable ReactStylesDiffMap paramReactStylesDiffMap)
  {
    if (paramFlatShadowNode.isBackingViewCreated())
    {
      this.mOperationsQueue.enqueueUpdateProperties(paramFlatShadowNode.getReactTag(), paramFlatShadowNode.getViewClass(), paramReactStylesDiffMap);
      return;
    }
    this.mOperationsQueue.enqueueCreateView(paramFlatShadowNode.getThemedContext(), paramFlatShadowNode.getReactTag(), paramFlatShadowNode.getViewClass(), paramReactStylesDiffMap);
    paramFlatShadowNode.signalBackingViewIsCreated();
  }

  void enqueueViewManagerCommand(int paramInt1, int paramInt2, ReadableArray paramReadableArray)
  {
    this.mViewManagerCommands.add(this.mOperationsQueue.createViewManagerCommand(paramInt1, paramInt2, paramReadableArray));
  }

  void ensureBackingViewIsCreated(FlatShadowNode paramFlatShadowNode)
  {
    if (paramFlatShadowNode.isBackingViewCreated())
      return;
    int i = paramFlatShadowNode.getReactTag();
    this.mOperationsQueue.enqueueCreateView(paramFlatShadowNode.getThemedContext(), i, paramFlatShadowNode.getViewClass(), null);
    paramFlatShadowNode.signalBackingViewIsCreated();
  }

  FlatUIViewOperationQueue getOperationsQueue()
  {
    return this.mOperationsQueue;
  }

  void removeRootView(int paramInt)
  {
    this.mViewsToDrop.add(Integer.valueOf(-paramInt));
    this.mParentsForViewsToDrop.add(Integer.valueOf(-1));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.StateBuilder
 * JD-Core Version:    0.6.0
 */
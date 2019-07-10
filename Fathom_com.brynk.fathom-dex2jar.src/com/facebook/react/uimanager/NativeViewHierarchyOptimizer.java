package com.facebook.react.uimanager;

import android.util.SparseBooleanArray;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import javax.annotation.Nullable;

public class NativeViewHierarchyOptimizer
{
  private static final boolean ENABLED = true;
  private final ShadowNodeRegistry mShadowNodeRegistry;
  private final SparseBooleanArray mTagsWithLayoutVisited = new SparseBooleanArray();
  private final UIViewOperationQueue mUIViewOperationQueue;

  public NativeViewHierarchyOptimizer(UIViewOperationQueue paramUIViewOperationQueue, ShadowNodeRegistry paramShadowNodeRegistry)
  {
    this.mUIViewOperationQueue = paramUIViewOperationQueue;
    this.mShadowNodeRegistry = paramShadowNodeRegistry;
  }

  private void addGrandchildren(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2, int paramInt)
  {
    boolean bool;
    int i;
    label20: ReactShadowNode localReactShadowNode;
    if (!paramReactShadowNode1.isLayoutOnly())
    {
      bool = true;
      Assertions.assertCondition(bool);
      i = 0;
      if (i >= paramReactShadowNode2.getChildCount())
        return;
      localReactShadowNode = paramReactShadowNode2.getChildAt(i);
      if (localReactShadowNode.getNativeParent() != null)
        break label112;
      bool = true;
      label54: Assertions.assertCondition(bool);
      if (!localReactShadowNode.isLayoutOnly())
        break label118;
      int j = paramReactShadowNode1.getNativeChildCount();
      addLayoutOnlyNode(paramReactShadowNode1, localReactShadowNode, paramInt);
      paramInt += paramReactShadowNode1.getNativeChildCount() - j;
    }
    while (true)
    {
      i += 1;
      break label20;
      bool = false;
      break;
      label112: bool = false;
      break label54;
      label118: addNonLayoutNode(paramReactShadowNode1, localReactShadowNode, paramInt);
      paramInt += 1;
    }
  }

  private void addLayoutOnlyNode(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2, int paramInt)
  {
    addGrandchildren(paramReactShadowNode1, paramReactShadowNode2, paramInt);
  }

  private void addNodeToNode(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2, int paramInt)
  {
    int i = paramReactShadowNode1.getNativeOffsetForChild(paramReactShadowNode1.getChildAt(paramInt));
    paramInt = i;
    ReactShadowNode localReactShadowNode = paramReactShadowNode1;
    if (paramReactShadowNode1.isLayoutOnly())
    {
      paramReactShadowNode1 = walkUpUntilNonLayoutOnly(paramReactShadowNode1, i);
      if (paramReactShadowNode1 == null)
        return;
      localReactShadowNode = paramReactShadowNode1.node;
      paramInt = paramReactShadowNode1.index;
    }
    if (!paramReactShadowNode2.isLayoutOnly())
    {
      addNonLayoutNode(localReactShadowNode, paramReactShadowNode2, paramInt);
      return;
    }
    addLayoutOnlyNode(localReactShadowNode, paramReactShadowNode2, paramInt);
  }

  private void addNonLayoutNode(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2, int paramInt)
  {
    paramReactShadowNode1.addNativeChildAt(paramReactShadowNode2, paramInt);
    this.mUIViewOperationQueue.enqueueManageChildren(paramReactShadowNode1.getReactTag(), null, new ViewAtIndex[] { new ViewAtIndex(paramReactShadowNode2.getReactTag(), paramInt) }, null);
  }

  private void applyLayoutBase(ReactShadowNode paramReactShadowNode)
  {
    int i = paramReactShadowNode.getReactTag();
    if (this.mTagsWithLayoutVisited.get(i))
      return;
    this.mTagsWithLayoutVisited.put(i, true);
    ReactShadowNode localReactShadowNode = paramReactShadowNode.getParent();
    int j = paramReactShadowNode.getScreenX();
    i = paramReactShadowNode.getScreenY();
    while ((localReactShadowNode != null) && (localReactShadowNode.isLayoutOnly()))
    {
      j += Math.round(localReactShadowNode.getLayoutX());
      i += Math.round(localReactShadowNode.getLayoutY());
      localReactShadowNode = localReactShadowNode.getParent();
    }
    applyLayoutRecursive(paramReactShadowNode, j, i);
  }

  private void applyLayoutRecursive(ReactShadowNode paramReactShadowNode, int paramInt1, int paramInt2)
  {
    if ((!paramReactShadowNode.isLayoutOnly()) && (paramReactShadowNode.getNativeParent() != null))
    {
      i = paramReactShadowNode.getReactTag();
      this.mUIViewOperationQueue.enqueueUpdateLayout(paramReactShadowNode.getNativeParent().getReactTag(), i, paramInt1, paramInt2, paramReactShadowNode.getScreenWidth(), paramReactShadowNode.getScreenHeight());
      return;
    }
    int i = 0;
    label64: ReactShadowNode localReactShadowNode;
    int j;
    if (i < paramReactShadowNode.getChildCount())
    {
      localReactShadowNode = paramReactShadowNode.getChildAt(i);
      j = localReactShadowNode.getReactTag();
      if (!this.mTagsWithLayoutVisited.get(j))
        break label115;
    }
    while (true)
    {
      i += 1;
      break label64;
      break;
      label115: this.mTagsWithLayoutVisited.put(j, true);
      applyLayoutRecursive(localReactShadowNode, localReactShadowNode.getScreenX() + paramInt1, localReactShadowNode.getScreenY() + paramInt2);
    }
  }

  public static void handleRemoveNode(ReactShadowNode paramReactShadowNode)
  {
    paramReactShadowNode.removeAllNativeChildren();
  }

  private static boolean isLayoutOnlyAndCollapsable(@Nullable ReactStylesDiffMap paramReactStylesDiffMap)
  {
    if (paramReactStylesDiffMap == null);
    ReadableMapKeySetIterator localReadableMapKeySetIterator;
    do
      while (!localReadableMapKeySetIterator.hasNextKey())
      {
        return true;
        if ((paramReactStylesDiffMap.hasKey("collapsable")) && (!paramReactStylesDiffMap.getBoolean("collapsable", true)))
          return false;
        localReadableMapKeySetIterator = paramReactStylesDiffMap.mBackingMap.keySetIterator();
      }
    while (ViewProps.isLayoutOnly(paramReactStylesDiffMap.mBackingMap, localReadableMapKeySetIterator.nextKey()));
    return false;
  }

  private void removeNodeFromParent(ReactShadowNode paramReactShadowNode, boolean paramBoolean)
  {
    Object localObject = paramReactShadowNode.getNativeParent();
    int i;
    if (localObject != null)
    {
      i = ((ReactShadowNode)localObject).indexOfNativeChild(paramReactShadowNode);
      ((ReactShadowNode)localObject).removeNativeChildAt(i);
      UIViewOperationQueue localUIViewOperationQueue = this.mUIViewOperationQueue;
      int j = ((ReactShadowNode)localObject).getReactTag();
      if (paramBoolean)
      {
        localObject = new int[1];
        localObject[0] = paramReactShadowNode.getReactTag();
        paramReactShadowNode = (ReactShadowNode)localObject;
        localUIViewOperationQueue.enqueueManageChildren(j, new int[] { i }, null, paramReactShadowNode);
      }
    }
    while (true)
    {
      return;
      paramReactShadowNode = null;
      break;
      i = paramReactShadowNode.getChildCount() - 1;
      while (i >= 0)
      {
        removeNodeFromParent(paramReactShadowNode.getChildAt(i), paramBoolean);
        i -= 1;
      }
    }
  }

  private void transitionLayoutOnlyViewToNativeView(ReactShadowNode paramReactShadowNode, @Nullable ReactStylesDiffMap paramReactStylesDiffMap)
  {
    boolean bool = false;
    ReactShadowNode localReactShadowNode = paramReactShadowNode.getParent();
    if (localReactShadowNode == null)
    {
      paramReactShadowNode.setIsLayoutOnly(false);
      return;
    }
    int i = localReactShadowNode.indexOf(paramReactShadowNode);
    localReactShadowNode.removeChildAt(i);
    removeNodeFromParent(paramReactShadowNode, false);
    paramReactShadowNode.setIsLayoutOnly(false);
    this.mUIViewOperationQueue.enqueueCreateView(paramReactShadowNode.getRootNode().getThemedContext(), paramReactShadowNode.getReactTag(), paramReactShadowNode.getViewClass(), paramReactStylesDiffMap);
    localReactShadowNode.addChildAt(paramReactShadowNode, i);
    addNodeToNode(localReactShadowNode, paramReactShadowNode, i);
    i = 0;
    while (i < paramReactShadowNode.getChildCount())
    {
      addNodeToNode(paramReactShadowNode, paramReactShadowNode.getChildAt(i), i);
      i += 1;
    }
    if (this.mTagsWithLayoutVisited.size() == 0)
      bool = true;
    Assertions.assertCondition(bool);
    applyLayoutBase(paramReactShadowNode);
    i = 0;
    while (i < paramReactShadowNode.getChildCount())
    {
      applyLayoutBase(paramReactShadowNode.getChildAt(i));
      i += 1;
    }
    this.mTagsWithLayoutVisited.clear();
  }

  private NodeIndexPair walkUpUntilNonLayoutOnly(ReactShadowNode paramReactShadowNode, int paramInt)
  {
    while (paramReactShadowNode.isLayoutOnly())
    {
      ReactShadowNode localReactShadowNode = paramReactShadowNode.getParent();
      if (localReactShadowNode == null)
        return null;
      paramInt += localReactShadowNode.getNativeOffsetForChild(paramReactShadowNode);
      paramReactShadowNode = localReactShadowNode;
    }
    return new NodeIndexPair(paramReactShadowNode, paramInt);
  }

  public void handleCreateView(ReactShadowNode paramReactShadowNode, ThemedReactContext paramThemedReactContext, @Nullable ReactStylesDiffMap paramReactStylesDiffMap)
  {
    if ((paramReactShadowNode.getViewClass().equals("RCTView")) && (isLayoutOnlyAndCollapsable(paramReactStylesDiffMap)));
    for (boolean bool = true; ; bool = false)
    {
      paramReactShadowNode.setIsLayoutOnly(bool);
      if (!bool)
        this.mUIViewOperationQueue.enqueueCreateView(paramThemedReactContext, paramReactShadowNode.getReactTag(), paramReactShadowNode.getViewClass(), paramReactStylesDiffMap);
      return;
    }
  }

  public void handleManageChildren(ReactShadowNode paramReactShadowNode, int[] paramArrayOfInt1, int[] paramArrayOfInt2, ViewAtIndex[] paramArrayOfViewAtIndex, int[] paramArrayOfInt3)
  {
    int i = 0;
    if (i < paramArrayOfInt2.length)
    {
      int k = paramArrayOfInt2[i];
      boolean bool2 = false;
      int j = 0;
      while (true)
      {
        boolean bool1 = bool2;
        if (j < paramArrayOfInt3.length)
        {
          if (paramArrayOfInt3[j] == k)
            bool1 = true;
        }
        else
        {
          removeNodeFromParent(this.mShadowNodeRegistry.getNode(k), bool1);
          i += 1;
          break;
        }
        j += 1;
      }
    }
    i = 0;
    while (i < paramArrayOfViewAtIndex.length)
    {
      paramArrayOfInt1 = paramArrayOfViewAtIndex[i];
      addNodeToNode(paramReactShadowNode, this.mShadowNodeRegistry.getNode(paramArrayOfInt1.mTag), paramArrayOfInt1.mIndex);
      i += 1;
    }
  }

  public void handleSetChildren(ReactShadowNode paramReactShadowNode, ReadableArray paramReadableArray)
  {
    int i = 0;
    while (i < paramReadableArray.size())
    {
      addNodeToNode(paramReactShadowNode, this.mShadowNodeRegistry.getNode(paramReadableArray.getInt(i)), i);
      i += 1;
    }
  }

  public void handleUpdateLayout(ReactShadowNode paramReactShadowNode)
  {
    applyLayoutBase(paramReactShadowNode);
  }

  public void handleUpdateView(ReactShadowNode paramReactShadowNode, String paramString, ReactStylesDiffMap paramReactStylesDiffMap)
  {
    int i;
    if ((paramReactShadowNode.isLayoutOnly()) && (!isLayoutOnlyAndCollapsable(paramReactStylesDiffMap)))
    {
      i = 1;
      if (i == 0)
        break label37;
      transitionLayoutOnlyViewToNativeView(paramReactShadowNode, paramReactStylesDiffMap);
    }
    label37: 
    do
    {
      return;
      i = 0;
      break;
    }
    while (paramReactShadowNode.isLayoutOnly());
    this.mUIViewOperationQueue.enqueueUpdateProperties(paramReactShadowNode.getReactTag(), paramString, paramReactStylesDiffMap);
  }

  public void onBatchComplete()
  {
    this.mTagsWithLayoutVisited.clear();
  }

  private static class NodeIndexPair
  {
    public final int index;
    public final ReactShadowNode node;

    NodeIndexPair(ReactShadowNode paramReactShadowNode, int paramInt)
    {
      this.node = paramReactShadowNode;
      this.index = paramInt;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.NativeViewHierarchyOptimizer
 * JD-Core Version:    0.6.0
 */
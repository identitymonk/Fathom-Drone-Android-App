package com.facebook.react.uimanager;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.facebook.react.common.SingleThreadAsserter;

public class ShadowNodeRegistry
{
  private final SparseBooleanArray mRootTags = new SparseBooleanArray();
  private final SparseArray<ReactShadowNode> mTagsToCSSNodes = new SparseArray();
  private final SingleThreadAsserter mThreadAsserter = new SingleThreadAsserter();

  public void addNode(ReactShadowNode paramReactShadowNode)
  {
    this.mThreadAsserter.assertNow();
    this.mTagsToCSSNodes.put(paramReactShadowNode.getReactTag(), paramReactShadowNode);
  }

  public void addRootNode(ReactShadowNode paramReactShadowNode)
  {
    int i = paramReactShadowNode.getReactTag();
    this.mTagsToCSSNodes.put(i, paramReactShadowNode);
    this.mRootTags.put(i, true);
  }

  public ReactShadowNode getNode(int paramInt)
  {
    this.mThreadAsserter.assertNow();
    return (ReactShadowNode)this.mTagsToCSSNodes.get(paramInt);
  }

  public int getRootNodeCount()
  {
    this.mThreadAsserter.assertNow();
    return this.mRootTags.size();
  }

  public int getRootTag(int paramInt)
  {
    this.mThreadAsserter.assertNow();
    return this.mRootTags.keyAt(paramInt);
  }

  public boolean isRootNode(int paramInt)
  {
    this.mThreadAsserter.assertNow();
    return this.mRootTags.get(paramInt);
  }

  public void removeNode(int paramInt)
  {
    this.mThreadAsserter.assertNow();
    if (this.mRootTags.get(paramInt))
      throw new IllegalViewOperationException("Trying to remove root node " + paramInt + " without using removeRootNode!");
    this.mTagsToCSSNodes.remove(paramInt);
  }

  public void removeRootNode(int paramInt)
  {
    this.mThreadAsserter.assertNow();
    if (!this.mRootTags.get(paramInt))
      throw new IllegalViewOperationException("View with tag " + paramInt + " is not registered as a root view");
    this.mTagsToCSSNodes.remove(paramInt);
    this.mRootTags.delete(paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ShadowNodeRegistry
 * JD-Core Version:    0.6.0
 */
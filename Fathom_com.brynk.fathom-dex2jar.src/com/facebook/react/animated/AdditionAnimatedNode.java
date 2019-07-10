package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

class AdditionAnimatedNode extends ValueAnimatedNode
{
  private final int[] mInputNodes;
  private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;

  public AdditionAnimatedNode(ReadableMap paramReadableMap, NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
  {
    this.mNativeAnimatedNodesManager = paramNativeAnimatedNodesManager;
    paramReadableMap = paramReadableMap.getArray("input");
    this.mInputNodes = new int[paramReadableMap.size()];
    int i = 0;
    while (i < this.mInputNodes.length)
    {
      this.mInputNodes[i] = paramReadableMap.getInt(i);
      i += 1;
    }
  }

  public void update()
  {
    this.mValue = 0.0D;
    int i = 0;
    while (i < this.mInputNodes.length)
    {
      AnimatedNode localAnimatedNode = this.mNativeAnimatedNodesManager.getNodeById(this.mInputNodes[i]);
      if ((localAnimatedNode != null) && ((localAnimatedNode instanceof ValueAnimatedNode)))
      {
        this.mValue += ((ValueAnimatedNode)localAnimatedNode).getValue();
        i += 1;
        continue;
      }
      throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.Add node");
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.AdditionAnimatedNode
 * JD-Core Version:    0.6.0
 */
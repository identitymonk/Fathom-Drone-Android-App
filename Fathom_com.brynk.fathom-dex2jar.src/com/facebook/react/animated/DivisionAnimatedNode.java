package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

class DivisionAnimatedNode extends ValueAnimatedNode
{
  private final int[] mInputNodes;
  private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;

  public DivisionAnimatedNode(ReadableMap paramReadableMap, NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
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
    int i = 0;
    if (i < this.mInputNodes.length)
    {
      AnimatedNode localAnimatedNode = this.mNativeAnimatedNodesManager.getNodeById(this.mInputNodes[i]);
      if ((localAnimatedNode != null) && ((localAnimatedNode instanceof ValueAnimatedNode)))
      {
        double d = ((ValueAnimatedNode)localAnimatedNode).getValue();
        if (i == 0)
          this.mValue = d;
        while (true)
        {
          i += 1;
          break;
          if (d == 0.0D)
            throw new JSApplicationCausedNativeException("Detected a division by zero in Animated.divide node");
          this.mValue /= d;
        }
      }
      throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.divide node");
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.DivisionAnimatedNode
 * JD-Core Version:    0.6.0
 */
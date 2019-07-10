package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;

class ModulusAnimatedNode extends ValueAnimatedNode
{
  private final int mInputNode;
  private final int mModulus;
  private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;

  public ModulusAnimatedNode(ReadableMap paramReadableMap, NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
  {
    this.mNativeAnimatedNodesManager = paramNativeAnimatedNodesManager;
    this.mInputNode = paramReadableMap.getInt("input");
    this.mModulus = paramReadableMap.getInt("modulus");
  }

  public void update()
  {
    AnimatedNode localAnimatedNode = this.mNativeAnimatedNodesManager.getNodeById(this.mInputNode);
    if ((localAnimatedNode != null) && ((localAnimatedNode instanceof ValueAnimatedNode)))
    {
      this.mValue = (((ValueAnimatedNode)localAnimatedNode).getValue() % this.mModulus);
      return;
    }
    throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.modulus node");
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.ModulusAnimatedNode
 * JD-Core Version:    0.6.0
 */
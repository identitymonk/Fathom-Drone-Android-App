package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;

class DiffClampAnimatedNode extends ValueAnimatedNode
{
  private final int mInputNodeTag;
  private double mLastValue;
  private final double mMax;
  private final double mMin;
  private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;

  public DiffClampAnimatedNode(ReadableMap paramReadableMap, NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
  {
    this.mNativeAnimatedNodesManager = paramNativeAnimatedNodesManager;
    this.mInputNodeTag = paramReadableMap.getInt("input");
    this.mMin = paramReadableMap.getDouble("min");
    this.mMax = paramReadableMap.getDouble("max");
    this.mLastValue = 0.0D;
    this.mValue = 0.0D;
  }

  private double getInputNodeValue()
  {
    AnimatedNode localAnimatedNode = this.mNativeAnimatedNodesManager.getNodeById(this.mInputNodeTag);
    if ((localAnimatedNode == null) || (!(localAnimatedNode instanceof ValueAnimatedNode)))
      throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.DiffClamp node");
    return ((ValueAnimatedNode)localAnimatedNode).getValue();
  }

  public void update()
  {
    double d1 = getInputNodeValue();
    double d2 = this.mLastValue;
    this.mLastValue = d1;
    this.mValue = Math.min(Math.max(this.mValue + (d1 - d2), this.mMin), this.mMax);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.DiffClampAnimatedNode
 * JD-Core Version:    0.6.0
 */
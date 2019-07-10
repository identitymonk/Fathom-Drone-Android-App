package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.UIImplementation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class PropsAnimatedNode extends AnimatedNode
{
  int mConnectedViewTag = -1;
  private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
  private final Map<String, Integer> mPropMapping;

  PropsAnimatedNode(ReadableMap paramReadableMap, NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
  {
    paramReadableMap = paramReadableMap.getMap("props");
    ReadableMapKeySetIterator localReadableMapKeySetIterator = paramReadableMap.keySetIterator();
    this.mPropMapping = new HashMap();
    while (localReadableMapKeySetIterator.hasNextKey())
    {
      String str = localReadableMapKeySetIterator.nextKey();
      int i = paramReadableMap.getInt(str);
      this.mPropMapping.put(str, Integer.valueOf(i));
    }
    this.mNativeAnimatedNodesManager = paramNativeAnimatedNodesManager;
  }

  public final void updateView(UIImplementation paramUIImplementation)
  {
    if (this.mConnectedViewTag == -1)
      throw new IllegalStateException("Node has not been attached to a view");
    JavaOnlyMap localJavaOnlyMap = new JavaOnlyMap();
    Iterator localIterator = this.mPropMapping.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      AnimatedNode localAnimatedNode = this.mNativeAnimatedNodesManager.getNodeById(((Integer)localEntry.getValue()).intValue());
      if (localAnimatedNode == null)
        throw new IllegalArgumentException("Mapped property node does not exists");
      if ((localAnimatedNode instanceof StyleAnimatedNode))
      {
        ((StyleAnimatedNode)localAnimatedNode).collectViewUpdates(localJavaOnlyMap);
        continue;
      }
      if ((localAnimatedNode instanceof ValueAnimatedNode))
      {
        localJavaOnlyMap.putDouble((String)localEntry.getKey(), ((ValueAnimatedNode)localAnimatedNode).getValue());
        continue;
      }
      throw new IllegalArgumentException("Unsupported type of node used in property node " + localAnimatedNode.getClass());
    }
    paramUIImplementation.synchronouslyUpdateViewOnUIThread(this.mConnectedViewTag, new ReactStylesDiffMap(localJavaOnlyMap));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.PropsAnimatedNode
 * JD-Core Version:    0.6.0
 */
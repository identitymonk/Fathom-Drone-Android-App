package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TransformAnimatedNode extends AnimatedNode
{
  private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
  private final List<TransformConfig> mTransformConfigs;

  TransformAnimatedNode(ReadableMap paramReadableMap, NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
  {
    paramReadableMap = paramReadableMap.getArray("transforms");
    this.mTransformConfigs = new ArrayList(paramReadableMap.size());
    int i = 0;
    if (i < paramReadableMap.size())
    {
      ReadableMap localReadableMap = paramReadableMap.getMap(i);
      String str = localReadableMap.getString("property");
      Object localObject;
      if (localReadableMap.getString("type").equals("animated"))
      {
        localObject = new AnimatedTransformConfig(null);
        ((AnimatedTransformConfig)localObject).mProperty = str;
        ((AnimatedTransformConfig)localObject).mNodeTag = localReadableMap.getInt("nodeTag");
        this.mTransformConfigs.add(localObject);
      }
      while (true)
      {
        i += 1;
        break;
        localObject = new StaticTransformConfig(null);
        ((StaticTransformConfig)localObject).mProperty = str;
        ((StaticTransformConfig)localObject).mValue = localReadableMap.getDouble("value");
        this.mTransformConfigs.add(localObject);
      }
    }
    this.mNativeAnimatedNodesManager = paramNativeAnimatedNodesManager;
  }

  public void collectViewUpdates(JavaOnlyMap paramJavaOnlyMap)
  {
    ArrayList localArrayList = new ArrayList(this.mTransformConfigs.size());
    Iterator localIterator = this.mTransformConfigs.iterator();
    if (localIterator.hasNext())
    {
      TransformConfig localTransformConfig = (TransformConfig)localIterator.next();
      AnimatedNode localAnimatedNode;
      double d;
      if ((localTransformConfig instanceof AnimatedTransformConfig))
      {
        int i = ((AnimatedTransformConfig)localTransformConfig).mNodeTag;
        localAnimatedNode = this.mNativeAnimatedNodesManager.getNodeById(i);
        if (localAnimatedNode == null)
          throw new IllegalArgumentException("Mapped style node does not exists");
        if ((localAnimatedNode instanceof ValueAnimatedNode))
          d = ((ValueAnimatedNode)localAnimatedNode).getValue();
      }
      while (true)
      {
        localArrayList.add(JavaOnlyMap.of(new Object[] { localTransformConfig.mProperty, Double.valueOf(d) }));
        break;
        throw new IllegalArgumentException("Unsupported type of node used as a transform child node " + localAnimatedNode.getClass());
        d = ((StaticTransformConfig)localTransformConfig).mValue;
      }
    }
    paramJavaOnlyMap.putArray("transform", JavaOnlyArray.from(localArrayList));
  }

  private class AnimatedTransformConfig extends TransformAnimatedNode.TransformConfig
  {
    public int mNodeTag;

    private AnimatedTransformConfig()
    {
      super(null);
    }
  }

  private class StaticTransformConfig extends TransformAnimatedNode.TransformConfig
  {
    public double mValue;

    private StaticTransformConfig()
    {
      super(null);
    }
  }

  private class TransformConfig
  {
    public String mProperty;

    private TransformConfig()
    {
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.TransformAnimatedNode
 * JD-Core Version:    0.6.0
 */
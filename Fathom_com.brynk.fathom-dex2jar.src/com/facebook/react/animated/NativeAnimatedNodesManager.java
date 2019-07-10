package com.facebook.react.animated;

import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModule.CustomEventNamesResolver;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import javax.annotation.Nullable;

class NativeAnimatedNodesManager
  implements EventDispatcherListener
{
  private final SparseArray<AnimationDriver> mActiveAnimations = new SparseArray();
  private int mAnimatedGraphBFSColor = 0;
  private final SparseArray<AnimatedNode> mAnimatedNodes = new SparseArray();
  private final UIManagerModule.CustomEventNamesResolver mCustomEventNamesResolver;
  private final Map<String, List<EventAnimationDriver>> mEventDrivers = new HashMap();
  private final List<AnimatedNode> mRunUpdateNodeList = new LinkedList();
  private final UIImplementation mUIImplementation;
  private final SparseArray<AnimatedNode> mUpdatedNodes = new SparseArray();

  public NativeAnimatedNodesManager(UIManagerModule paramUIManagerModule)
  {
    this.mUIImplementation = paramUIManagerModule.getUIImplementation();
    paramUIManagerModule.getEventDispatcher().addListener(this);
    this.mCustomEventNamesResolver = paramUIManagerModule.getDirectEventNamesResolver();
  }

  private void handleEvent(Event paramEvent)
  {
    if (!this.mEventDrivers.isEmpty())
    {
      Object localObject = this.mCustomEventNamesResolver.resolveCustomEventName(paramEvent.getEventName());
      localObject = (List)this.mEventDrivers.get(paramEvent.getViewTag() + (String)localObject);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          EventAnimationDriver localEventAnimationDriver = (EventAnimationDriver)((Iterator)localObject).next();
          stopAnimationsForNode(localEventAnimationDriver.mValueNode);
          paramEvent.dispatch(localEventAnimationDriver);
          this.mRunUpdateNodeList.add(localEventAnimationDriver.mValueNode);
        }
        updateNodes(this.mRunUpdateNodeList);
        this.mRunUpdateNodeList.clear();
      }
    }
  }

  private void stopAnimationsForNode(AnimatedNode paramAnimatedNode)
  {
    int j;
    for (int i = 0; i < this.mActiveAnimations.size(); i = j + 1)
    {
      AnimationDriver localAnimationDriver = (AnimationDriver)this.mActiveAnimations.valueAt(i);
      j = i;
      if (!paramAnimatedNode.equals(localAnimationDriver.mAnimatedValue))
        continue;
      WritableMap localWritableMap = Arguments.createMap();
      localWritableMap.putBoolean("finished", false);
      localAnimationDriver.mEndCallback.invoke(new Object[] { localWritableMap });
      this.mActiveAnimations.removeAt(i);
      j = i - 1;
    }
  }

  private void updateNodes(List<AnimatedNode> paramList)
  {
    int i = 0;
    int m = 0;
    this.mAnimatedGraphBFSColor += 1;
    if (this.mAnimatedGraphBFSColor == 0)
      this.mAnimatedGraphBFSColor += 1;
    ArrayDeque localArrayDeque = new ArrayDeque();
    Object localObject = paramList.iterator();
    int j;
    AnimatedNode localAnimatedNode;
    while (true)
    {
      j = i;
      if (!((Iterator)localObject).hasNext())
        break;
      localAnimatedNode = (AnimatedNode)((Iterator)localObject).next();
      if (localAnimatedNode.mBFSColor == this.mAnimatedGraphBFSColor)
        continue;
      localAnimatedNode.mBFSColor = this.mAnimatedGraphBFSColor;
      i += 1;
      localArrayDeque.add(localAnimatedNode);
    }
    int k;
    while (!localArrayDeque.isEmpty())
    {
      localObject = (AnimatedNode)localArrayDeque.poll();
      if (((AnimatedNode)localObject).mChildren == null)
        continue;
      k = 0;
      for (i = j; ; i = j)
      {
        j = i;
        if (k >= ((AnimatedNode)localObject).mChildren.size())
          break;
        localAnimatedNode = (AnimatedNode)((AnimatedNode)localObject).mChildren.get(k);
        localAnimatedNode.mActiveIncomingNodes += 1;
        j = i;
        if (localAnimatedNode.mBFSColor != this.mAnimatedGraphBFSColor)
        {
          localAnimatedNode.mBFSColor = this.mAnimatedGraphBFSColor;
          j = i + 1;
          localArrayDeque.add(localAnimatedNode);
        }
        k += 1;
      }
    }
    this.mAnimatedGraphBFSColor += 1;
    if (this.mAnimatedGraphBFSColor == 0)
      this.mAnimatedGraphBFSColor += 1;
    paramList = paramList.iterator();
    i = m;
    while (true)
    {
      k = i;
      if (!paramList.hasNext())
        break;
      localObject = (AnimatedNode)paramList.next();
      if ((((AnimatedNode)localObject).mActiveIncomingNodes != 0) || (((AnimatedNode)localObject).mBFSColor == this.mAnimatedGraphBFSColor))
        continue;
      ((AnimatedNode)localObject).mBFSColor = this.mAnimatedGraphBFSColor;
      i += 1;
      localArrayDeque.add(localObject);
    }
    while (true)
      if (!localArrayDeque.isEmpty())
      {
        paramList = (AnimatedNode)localArrayDeque.poll();
        paramList.update();
        if ((paramList instanceof PropsAnimatedNode));
        try
        {
          ((PropsAnimatedNode)paramList).updateView(this.mUIImplementation);
          if ((paramList instanceof ValueAnimatedNode))
            ((ValueAnimatedNode)paramList).onValueUpdate();
          if (paramList.mChildren == null)
            continue;
          i = 0;
          for (m = k; ; m = k)
          {
            k = m;
            if (i >= paramList.mChildren.size())
              break;
            localObject = (AnimatedNode)paramList.mChildren.get(i);
            ((AnimatedNode)localObject).mActiveIncomingNodes -= 1;
            k = m;
            if (((AnimatedNode)localObject).mBFSColor != this.mAnimatedGraphBFSColor)
            {
              k = m;
              if (((AnimatedNode)localObject).mActiveIncomingNodes == 0)
              {
                ((AnimatedNode)localObject).mBFSColor = this.mAnimatedGraphBFSColor;
                k = m + 1;
                localArrayDeque.add(localObject);
              }
            }
            i += 1;
          }
        }
        catch (IllegalViewOperationException localIllegalViewOperationException)
        {
          while (true)
            FLog.e("ReactNative", "Native animation workaround, frame lost as result of race condition", localIllegalViewOperationException);
        }
      }
    if (j != k)
      throw new IllegalStateException("Looks like animated nodes graph has cycles, there are " + j + " but toposort visited only " + k);
  }

  public void addAnimatedEventToView(int paramInt, String paramString, ReadableMap paramReadableMap)
  {
    int i = paramReadableMap.getInt("animatedValueTag");
    Object localObject = (AnimatedNode)this.mAnimatedNodes.get(i);
    if (localObject == null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exists");
    if (!(localObject instanceof ValueAnimatedNode))
      throw new JSApplicationIllegalArgumentException("Animated node connected to event should beof type " + ValueAnimatedNode.class.getName());
    paramReadableMap = paramReadableMap.getArray("nativeEventPath");
    ArrayList localArrayList = new ArrayList(paramReadableMap.size());
    i = 0;
    while (i < paramReadableMap.size())
    {
      localArrayList.add(paramReadableMap.getString(i));
      i += 1;
    }
    paramReadableMap = new EventAnimationDriver(localArrayList, (ValueAnimatedNode)localObject);
    paramString = paramInt + paramString;
    if (this.mEventDrivers.containsKey(paramString))
    {
      ((List)this.mEventDrivers.get(paramString)).add(paramReadableMap);
      return;
    }
    localObject = new ArrayList(1);
    ((List)localObject).add(paramReadableMap);
    this.mEventDrivers.put(paramString, localObject);
  }

  public void connectAnimatedNodeToView(int paramInt1, int paramInt2)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt1);
    if (localAnimatedNode == null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt1 + " does not exists");
    if (!(localAnimatedNode instanceof PropsAnimatedNode))
      throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsAnimatedNode.class.getName());
    PropsAnimatedNode localPropsAnimatedNode = (PropsAnimatedNode)localAnimatedNode;
    if (localPropsAnimatedNode.mConnectedViewTag != -1)
      throw new JSApplicationIllegalArgumentException("Animated node " + paramInt1 + " is " + "already attached to a view");
    localPropsAnimatedNode.mConnectedViewTag = paramInt2;
    this.mUpdatedNodes.put(paramInt1, localAnimatedNode);
  }

  public void connectAnimatedNodes(int paramInt1, int paramInt2)
  {
    AnimatedNode localAnimatedNode1 = (AnimatedNode)this.mAnimatedNodes.get(paramInt1);
    if (localAnimatedNode1 == null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt1 + " does not exists");
    AnimatedNode localAnimatedNode2 = (AnimatedNode)this.mAnimatedNodes.get(paramInt2);
    if (localAnimatedNode2 == null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt2 + " does not exists");
    localAnimatedNode1.addChild(localAnimatedNode2);
    this.mUpdatedNodes.put(paramInt2, localAnimatedNode2);
  }

  public void createAnimatedNode(int paramInt, ReadableMap paramReadableMap)
  {
    if (this.mAnimatedNodes.get(paramInt) != null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt + " already exists");
    String str = paramReadableMap.getString("type");
    if ("style".equals(str))
      paramReadableMap = new StyleAnimatedNode(paramReadableMap, this);
    while (true)
    {
      paramReadableMap.mTag = paramInt;
      this.mAnimatedNodes.put(paramInt, paramReadableMap);
      this.mUpdatedNodes.put(paramInt, paramReadableMap);
      return;
      if ("value".equals(str))
      {
        paramReadableMap = new ValueAnimatedNode(paramReadableMap);
        continue;
      }
      if ("props".equals(str))
      {
        paramReadableMap = new PropsAnimatedNode(paramReadableMap, this);
        continue;
      }
      if ("interpolation".equals(str))
      {
        paramReadableMap = new InterpolationAnimatedNode(paramReadableMap);
        continue;
      }
      if ("addition".equals(str))
      {
        paramReadableMap = new AdditionAnimatedNode(paramReadableMap, this);
        continue;
      }
      if ("division".equals(str))
      {
        paramReadableMap = new DivisionAnimatedNode(paramReadableMap, this);
        continue;
      }
      if ("multiplication".equals(str))
      {
        paramReadableMap = new MultiplicationAnimatedNode(paramReadableMap, this);
        continue;
      }
      if ("modulus".equals(str))
      {
        paramReadableMap = new ModulusAnimatedNode(paramReadableMap, this);
        continue;
      }
      if ("diffclamp".equals(str))
      {
        paramReadableMap = new DiffClampAnimatedNode(paramReadableMap, this);
        continue;
      }
      if (!"transform".equals(str))
        break;
      paramReadableMap = new TransformAnimatedNode(paramReadableMap, this);
    }
    throw new JSApplicationIllegalArgumentException("Unsupported node type: " + str);
  }

  public void disconnectAnimatedNodeFromView(int paramInt1, int paramInt2)
  {
    Object localObject = (AnimatedNode)this.mAnimatedNodes.get(paramInt1);
    if (localObject == null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt1 + " does not exists");
    if (!(localObject instanceof PropsAnimatedNode))
      throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsAnimatedNode.class.getName());
    localObject = (PropsAnimatedNode)localObject;
    if (((PropsAnimatedNode)localObject).mConnectedViewTag != paramInt2)
      throw new JSApplicationIllegalArgumentException("Attempting to disconnect view that has not been connected with the given animated node");
    ((PropsAnimatedNode)localObject).mConnectedViewTag = -1;
  }

  public void disconnectAnimatedNodes(int paramInt1, int paramInt2)
  {
    AnimatedNode localAnimatedNode1 = (AnimatedNode)this.mAnimatedNodes.get(paramInt1);
    if (localAnimatedNode1 == null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt1 + " does not exists");
    AnimatedNode localAnimatedNode2 = (AnimatedNode)this.mAnimatedNodes.get(paramInt2);
    if (localAnimatedNode2 == null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt2 + " does not exists");
    localAnimatedNode1.removeChild(localAnimatedNode2);
    this.mUpdatedNodes.put(paramInt2, localAnimatedNode2);
  }

  public void dropAnimatedNode(int paramInt)
  {
    this.mAnimatedNodes.remove(paramInt);
    this.mUpdatedNodes.remove(paramInt);
  }

  public void extractAnimatedNodeOffset(int paramInt)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt);
    if ((localAnimatedNode == null) || (!(localAnimatedNode instanceof ValueAnimatedNode)))
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt + " does not exists or is not a 'value' node");
    ((ValueAnimatedNode)localAnimatedNode).extractOffset();
  }

  public void flattenAnimatedNodeOffset(int paramInt)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt);
    if ((localAnimatedNode == null) || (!(localAnimatedNode instanceof ValueAnimatedNode)))
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt + " does not exists or is not a 'value' node");
    ((ValueAnimatedNode)localAnimatedNode).flattenOffset();
  }

  @Nullable
  AnimatedNode getNodeById(int paramInt)
  {
    return (AnimatedNode)this.mAnimatedNodes.get(paramInt);
  }

  public boolean hasActiveAnimations()
  {
    return (this.mActiveAnimations.size() > 0) || (this.mUpdatedNodes.size() > 0);
  }

  public void onEventDispatch(Event paramEvent)
  {
    if (UiThreadUtil.isOnUiThread())
    {
      handleEvent(paramEvent);
      return;
    }
    UiThreadUtil.runOnUiThread(new Runnable(paramEvent)
    {
      public void run()
      {
        NativeAnimatedNodesManager.this.handleEvent(this.val$event);
      }
    });
  }

  public void removeAnimatedEventFromView(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = paramInt1 + paramString;
    if (this.mEventDrivers.containsKey(localObject))
    {
      localObject = (List)this.mEventDrivers.get(localObject);
      if (((List)localObject).size() != 1)
        break label90;
    }
    label90: 
    do
    {
      this.mEventDrivers.remove(paramInt1 + paramString);
      return;
      while (!paramString.hasNext())
        paramString = ((List)localObject).listIterator();
    }
    while (((EventAnimationDriver)paramString.next()).mValueNode.mTag != paramInt2);
    paramString.remove();
  }

  public void runUpdates(long paramLong)
  {
    UiThreadUtil.assertOnUiThread();
    int j = 0;
    int i = 0;
    Object localObject1;
    while (i < this.mUpdatedNodes.size())
    {
      localObject1 = (AnimatedNode)this.mUpdatedNodes.valueAt(i);
      this.mRunUpdateNodeList.add(localObject1);
      i += 1;
    }
    this.mUpdatedNodes.clear();
    i = 0;
    Object localObject2;
    while (i < this.mActiveAnimations.size())
    {
      localObject1 = (AnimationDriver)this.mActiveAnimations.valueAt(i);
      ((AnimationDriver)localObject1).runAnimationStep(paramLong);
      localObject2 = ((AnimationDriver)localObject1).mAnimatedValue;
      this.mRunUpdateNodeList.add(localObject2);
      if (((AnimationDriver)localObject1).mHasFinished)
        j = 1;
      i += 1;
    }
    updateNodes(this.mRunUpdateNodeList);
    this.mRunUpdateNodeList.clear();
    if (j != 0)
    {
      i = this.mActiveAnimations.size() - 1;
      while (i >= 0)
      {
        localObject1 = (AnimationDriver)this.mActiveAnimations.valueAt(i);
        if (((AnimationDriver)localObject1).mHasFinished)
        {
          localObject2 = Arguments.createMap();
          ((WritableMap)localObject2).putBoolean("finished", true);
          ((AnimationDriver)localObject1).mEndCallback.invoke(new Object[] { localObject2 });
          this.mActiveAnimations.removeAt(i);
        }
        i -= 1;
      }
    }
  }

  public void setAnimatedNodeOffset(int paramInt, double paramDouble)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt);
    if ((localAnimatedNode == null) || (!(localAnimatedNode instanceof ValueAnimatedNode)))
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt + " does not exists or is not a 'value' node");
    ((ValueAnimatedNode)localAnimatedNode).mOffset = paramDouble;
    this.mUpdatedNodes.put(paramInt, localAnimatedNode);
  }

  public void setAnimatedNodeValue(int paramInt, double paramDouble)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt);
    if ((localAnimatedNode == null) || (!(localAnimatedNode instanceof ValueAnimatedNode)))
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt + " does not exists or is not a 'value' node");
    stopAnimationsForNode(localAnimatedNode);
    ((ValueAnimatedNode)localAnimatedNode).mValue = paramDouble;
    this.mUpdatedNodes.put(paramInt, localAnimatedNode);
  }

  public void startAnimatingNode(int paramInt1, int paramInt2, ReadableMap paramReadableMap, Callback paramCallback)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt2);
    if (localAnimatedNode == null)
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt2 + " does not exists");
    if (!(localAnimatedNode instanceof ValueAnimatedNode))
      throw new JSApplicationIllegalArgumentException("Animated node should be of type " + ValueAnimatedNode.class.getName());
    String str = paramReadableMap.getString("type");
    if ("frames".equals(str))
      paramReadableMap = new FrameBasedAnimationDriver(paramReadableMap);
    while (true)
    {
      paramReadableMap.mId = paramInt1;
      paramReadableMap.mEndCallback = paramCallback;
      paramReadableMap.mAnimatedValue = ((ValueAnimatedNode)localAnimatedNode);
      this.mActiveAnimations.put(paramInt1, paramReadableMap);
      return;
      if ("spring".equals(str))
      {
        paramReadableMap = new SpringAnimation(paramReadableMap);
        continue;
      }
      if (!"decay".equals(str))
        break;
      paramReadableMap = new DecayAnimation(paramReadableMap);
    }
    throw new JSApplicationIllegalArgumentException("Unsupported animation type: " + str);
  }

  public void startListeningToAnimatedNodeValue(int paramInt, AnimatedNodeValueListener paramAnimatedNodeValueListener)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt);
    if ((localAnimatedNode == null) || (!(localAnimatedNode instanceof ValueAnimatedNode)))
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt + " does not exists or is not a 'value' node");
    ((ValueAnimatedNode)localAnimatedNode).setValueListener(paramAnimatedNodeValueListener);
  }

  public void stopAnimation(int paramInt)
  {
    int i = 0;
    while (true)
    {
      if (i < this.mActiveAnimations.size())
      {
        AnimationDriver localAnimationDriver = (AnimationDriver)this.mActiveAnimations.valueAt(i);
        if (localAnimationDriver.mId == paramInt)
        {
          WritableMap localWritableMap = Arguments.createMap();
          localWritableMap.putBoolean("finished", false);
          localAnimationDriver.mEndCallback.invoke(new Object[] { localWritableMap });
          this.mActiveAnimations.removeAt(i);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }

  public void stopListeningToAnimatedNodeValue(int paramInt)
  {
    AnimatedNode localAnimatedNode = (AnimatedNode)this.mAnimatedNodes.get(paramInt);
    if ((localAnimatedNode == null) || (!(localAnimatedNode instanceof ValueAnimatedNode)))
      throw new JSApplicationIllegalArgumentException("Animated node with tag " + paramInt + " does not exists or is not a 'value' node");
    ((ValueAnimatedNode)localAnimatedNode).setValueListener(null);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.NativeAnimatedNodesManager
 * JD-Core Version:    0.6.0
 */
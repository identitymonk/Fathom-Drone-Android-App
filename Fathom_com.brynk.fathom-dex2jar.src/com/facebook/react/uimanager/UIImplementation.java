package com.facebook.react.uimanager;

import android.os.SystemClock;
import android.view.View.MeasureSpec;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.animation.Animation;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import com.facebook.yoga.YogaDirection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public class UIImplementation
{
  protected final EventDispatcher mEventDispatcher;
  private long mLastCalculateLayoutTime = 0L;
  private final int[] mMeasureBuffer = new int[4];
  private final Set<Integer> mMeasuredRootNodes = new HashSet();
  private final NativeViewHierarchyOptimizer mNativeViewHierarchyOptimizer;
  private final UIViewOperationQueue mOperationsQueue;
  protected final ReactApplicationContext mReactContext;
  protected final ShadowNodeRegistry mShadowNodeRegistry = new ShadowNodeRegistry();
  private final ViewManagerRegistry mViewManagers;

  public UIImplementation(ReactApplicationContext paramReactApplicationContext, UIManagerModule.ViewManagerResolver paramViewManagerResolver, EventDispatcher paramEventDispatcher, int paramInt)
  {
    this(paramReactApplicationContext, new ViewManagerRegistry(paramViewManagerResolver), paramEventDispatcher, paramInt);
  }

  protected UIImplementation(ReactApplicationContext paramReactApplicationContext, ViewManagerRegistry paramViewManagerRegistry, UIViewOperationQueue paramUIViewOperationQueue, EventDispatcher paramEventDispatcher)
  {
    this.mReactContext = paramReactApplicationContext;
    this.mViewManagers = paramViewManagerRegistry;
    this.mOperationsQueue = paramUIViewOperationQueue;
    this.mNativeViewHierarchyOptimizer = new NativeViewHierarchyOptimizer(this.mOperationsQueue, this.mShadowNodeRegistry);
    this.mEventDispatcher = paramEventDispatcher;
  }

  private UIImplementation(ReactApplicationContext paramReactApplicationContext, ViewManagerRegistry paramViewManagerRegistry, EventDispatcher paramEventDispatcher, int paramInt)
  {
    this(paramReactApplicationContext, paramViewManagerRegistry, new UIViewOperationQueue(paramReactApplicationContext, new NativeViewHierarchyManager(paramViewManagerRegistry), paramInt), paramEventDispatcher);
  }

  public UIImplementation(ReactApplicationContext paramReactApplicationContext, List<ViewManager> paramList, EventDispatcher paramEventDispatcher, int paramInt)
  {
    this(paramReactApplicationContext, new ViewManagerRegistry(paramList), paramEventDispatcher, paramInt);
  }

  private void assertNodeDoesNotNeedCustomLayoutForChildren(ReactShadowNode paramReactShadowNode)
  {
    Object localObject = (ViewManager)Assertions.assertNotNull(this.mViewManagers.get(paramReactShadowNode.getViewClass()));
    if ((localObject instanceof ViewGroupManager))
    {
      localObject = (ViewGroupManager)localObject;
      if ((localObject != null) && (((ViewGroupManager)localObject).needsCustomLayoutForChildren()))
        throw new IllegalViewOperationException("Trying to measure a view using measureLayout/measureLayoutRelativeToParent relative to an ancestor that requires custom layout for it's children (" + paramReactShadowNode.getViewClass() + "). Use measure instead.");
    }
    else
    {
      throw new IllegalViewOperationException("Trying to use view " + paramReactShadowNode.getViewClass() + " as a parent, but its Manager doesn't extends ViewGroupManager");
    }
  }

  private void assertViewExists(int paramInt, String paramString)
  {
    if (this.mShadowNodeRegistry.getNode(paramInt) == null)
      throw new IllegalViewOperationException("Unable to execute operation " + paramString + " on view with " + "tag: " + paramInt + ", since the view does not exists");
  }

  private void dispatchViewUpdatesIfNeeded()
  {
    if (this.mOperationsQueue.isEmpty())
      dispatchViewUpdates(-1);
  }

  private void measureLayout(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    ReactShadowNode localReactShadowNode2 = this.mShadowNodeRegistry.getNode(paramInt1);
    ReactShadowNode localReactShadowNode3 = this.mShadowNodeRegistry.getNode(paramInt2);
    if ((localReactShadowNode2 == null) || (localReactShadowNode3 == null))
    {
      paramArrayOfInt = new StringBuilder().append("Tag ");
      if (localReactShadowNode2 == null);
      while (true)
      {
        throw new IllegalViewOperationException(paramInt1 + " does not exist");
        paramInt1 = paramInt2;
      }
    }
    if (localReactShadowNode2 != localReactShadowNode3)
      for (ReactShadowNode localReactShadowNode1 = localReactShadowNode2.getParent(); localReactShadowNode1 != localReactShadowNode3; localReactShadowNode1 = localReactShadowNode1.getParent())
      {
        if (localReactShadowNode1 != null)
          continue;
        throw new IllegalViewOperationException("Tag " + paramInt2 + " is not an ancestor of tag " + paramInt1);
      }
    measureLayoutRelativeToVerifiedAncestor(localReactShadowNode2, localReactShadowNode3, paramArrayOfInt);
  }

  private void measureLayoutRelativeToParent(int paramInt, int[] paramArrayOfInt)
  {
    ReactShadowNode localReactShadowNode1 = this.mShadowNodeRegistry.getNode(paramInt);
    if (localReactShadowNode1 == null)
      throw new IllegalViewOperationException("No native view for tag " + paramInt + " exists!");
    ReactShadowNode localReactShadowNode2 = localReactShadowNode1.getParent();
    if (localReactShadowNode2 == null)
      throw new IllegalViewOperationException("View with tag " + paramInt + " doesn't have a parent!");
    measureLayoutRelativeToVerifiedAncestor(localReactShadowNode1, localReactShadowNode2, paramArrayOfInt);
  }

  private void measureLayoutRelativeToVerifiedAncestor(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2, int[] paramArrayOfInt)
  {
    int i = 0;
    int j = 0;
    if (paramReactShadowNode1 != paramReactShadowNode2)
    {
      i = Math.round(paramReactShadowNode1.getLayoutX());
      j = Math.round(paramReactShadowNode1.getLayoutY());
      for (ReactShadowNode localReactShadowNode = paramReactShadowNode1.getParent(); localReactShadowNode != paramReactShadowNode2; localReactShadowNode = localReactShadowNode.getParent())
      {
        Assertions.assertNotNull(localReactShadowNode);
        assertNodeDoesNotNeedCustomLayoutForChildren(localReactShadowNode);
        i += Math.round(localReactShadowNode.getLayoutX());
        j += Math.round(localReactShadowNode.getLayoutY());
      }
      assertNodeDoesNotNeedCustomLayoutForChildren(paramReactShadowNode2);
    }
    paramArrayOfInt[0] = i;
    paramArrayOfInt[1] = j;
    paramArrayOfInt[2] = paramReactShadowNode1.getScreenWidth();
    paramArrayOfInt[3] = paramReactShadowNode1.getScreenHeight();
  }

  private void notifyOnBeforeLayoutRecursive(ReactShadowNode paramReactShadowNode)
  {
    if (!paramReactShadowNode.hasUpdates())
      return;
    int i = 0;
    while (i < paramReactShadowNode.getChildCount())
    {
      notifyOnBeforeLayoutRecursive(paramReactShadowNode.getChildAt(i));
      i += 1;
    }
    paramReactShadowNode.onBeforeLayout();
  }

  private void removeShadowNodeRecursive(ReactShadowNode paramReactShadowNode)
  {
    NativeViewHierarchyOptimizer.handleRemoveNode(paramReactShadowNode);
    this.mShadowNodeRegistry.removeNode(paramReactShadowNode.getReactTag());
    this.mMeasuredRootNodes.remove(Integer.valueOf(paramReactShadowNode.getReactTag()));
    int i = paramReactShadowNode.getChildCount() - 1;
    while (i >= 0)
    {
      removeShadowNodeRecursive(paramReactShadowNode.getChildAt(i));
      i -= 1;
    }
    paramReactShadowNode.removeAndDisposeAllChildren();
  }

  public void addAnimation(int paramInt1, int paramInt2, Callback paramCallback)
  {
    assertViewExists(paramInt1, "addAnimation");
    this.mOperationsQueue.enqueueAddAnimation(paramInt1, paramInt2, paramCallback);
  }

  public void addUIBlock(UIBlock paramUIBlock)
  {
    this.mOperationsQueue.enqueueUIBlock(paramUIBlock);
  }

  protected void applyUpdatesRecursive(ReactShadowNode paramReactShadowNode, float paramFloat1, float paramFloat2)
  {
    if (!paramReactShadowNode.hasUpdates())
      return;
    if (!paramReactShadowNode.isVirtualAnchor())
    {
      i = 0;
      while (i < paramReactShadowNode.getChildCount())
      {
        applyUpdatesRecursive(paramReactShadowNode.getChildAt(i), paramReactShadowNode.getLayoutX() + paramFloat1, paramReactShadowNode.getLayoutY() + paramFloat2);
        i += 1;
      }
    }
    int i = paramReactShadowNode.getReactTag();
    if ((!this.mShadowNodeRegistry.isRootNode(i)) && (paramReactShadowNode.dispatchUpdates(paramFloat1, paramFloat2, this.mOperationsQueue, this.mNativeViewHierarchyOptimizer)) && (paramReactShadowNode.shouldNotifyOnLayout()))
      this.mEventDispatcher.dispatchEvent(OnLayoutEvent.obtain(i, paramReactShadowNode.getScreenX(), paramReactShadowNode.getScreenY(), paramReactShadowNode.getScreenWidth(), paramReactShadowNode.getScreenHeight()));
    paramReactShadowNode.markUpdateSeen();
  }

  protected void calculateRootLayout(ReactShadowNode paramReactShadowNode)
  {
    SystraceMessage.beginSection(0L, "cssRoot.calculateLayout").arg("rootTag", paramReactShadowNode.getReactTag()).flush();
    long l = SystemClock.uptimeMillis();
    try
    {
      paramReactShadowNode.calculateLayout();
      return;
    }
    finally
    {
      Systrace.endSection(0L);
      this.mLastCalculateLayoutTime = (SystemClock.uptimeMillis() - l);
    }
    throw paramReactShadowNode;
  }

  public void clearJSResponder()
  {
    this.mOperationsQueue.enqueueClearJSResponder();
  }

  public void configureNextLayoutAnimation(ReadableMap paramReadableMap, Callback paramCallback1, Callback paramCallback2)
  {
    this.mOperationsQueue.enqueueConfigureLayoutAnimation(paramReadableMap, paramCallback1, paramCallback2);
  }

  protected ReactShadowNode createRootShadowNode()
  {
    ReactShadowNodeImpl localReactShadowNodeImpl = new ReactShadowNodeImpl();
    if (I18nUtil.getInstance().isRTL(this.mReactContext))
      localReactShadowNodeImpl.setLayoutDirection(YogaDirection.RTL);
    localReactShadowNodeImpl.setViewClassName("Root");
    return localReactShadowNodeImpl;
  }

  protected ReactShadowNode createShadowNode(String paramString)
  {
    return this.mViewManagers.get(paramString).createShadowNodeInstance(this.mReactContext);
  }

  public void createView(int paramInt1, String paramString, int paramInt2, ReadableMap paramReadableMap)
  {
    ReactShadowNode localReactShadowNode1 = createShadowNode(paramString);
    ReactShadowNode localReactShadowNode2 = this.mShadowNodeRegistry.getNode(paramInt2);
    localReactShadowNode1.setReactTag(paramInt1);
    localReactShadowNode1.setViewClassName(paramString);
    localReactShadowNode1.setRootNode(localReactShadowNode2);
    localReactShadowNode1.setThemedContext(localReactShadowNode2.getThemedContext());
    this.mShadowNodeRegistry.addNode(localReactShadowNode1);
    paramString = null;
    if (paramReadableMap != null)
    {
      paramString = new ReactStylesDiffMap(paramReadableMap);
      localReactShadowNode1.updateProperties(paramString);
    }
    handleCreateView(localReactShadowNode1, paramInt2, paramString);
  }

  public void dispatchViewManagerCommand(int paramInt1, int paramInt2, ReadableArray paramReadableArray)
  {
    assertViewExists(paramInt1, "dispatchViewManagerCommand");
    this.mOperationsQueue.enqueueDispatchCommand(paramInt1, paramInt2, paramReadableArray);
  }

  public void dispatchViewUpdates(int paramInt)
  {
    SystraceMessage.beginSection(0L, "UIImplementation.dispatchViewUpdates").arg("batchId", paramInt).flush();
    long l = SystemClock.uptimeMillis();
    try
    {
      updateViewHierarchy();
      this.mNativeViewHierarchyOptimizer.onBatchComplete();
      this.mOperationsQueue.dispatchViewUpdates(paramInt, l, this.mLastCalculateLayoutTime);
      return;
    }
    finally
    {
      Systrace.endSection(0L);
    }
    throw localObject;
  }

  public void enableLayoutCalculationForRootNode(int paramInt)
  {
    this.mMeasuredRootNodes.add(Integer.valueOf(paramInt));
  }

  public void findSubviewIn(int paramInt, float paramFloat1, float paramFloat2, Callback paramCallback)
  {
    this.mOperationsQueue.enqueueFindTargetForTouch(paramInt, paramFloat1, paramFloat2, paramCallback);
  }

  public Map<String, Long> getProfiledBatchPerfCounters()
  {
    return this.mOperationsQueue.getProfiledBatchPerfCounters();
  }

  UIViewOperationQueue getUIViewOperationQueue()
  {
    return this.mOperationsQueue;
  }

  protected void handleCreateView(ReactShadowNode paramReactShadowNode, int paramInt, @Nullable ReactStylesDiffMap paramReactStylesDiffMap)
  {
    if (!paramReactShadowNode.isVirtual())
      this.mNativeViewHierarchyOptimizer.handleCreateView(paramReactShadowNode, paramReactShadowNode.getThemedContext(), paramReactStylesDiffMap);
  }

  protected void handleUpdateView(ReactShadowNode paramReactShadowNode, String paramString, ReactStylesDiffMap paramReactStylesDiffMap)
  {
    if (!paramReactShadowNode.isVirtual())
      this.mNativeViewHierarchyOptimizer.handleUpdateView(paramReactShadowNode, paramString, paramReactStylesDiffMap);
  }

  public void manageChildren(int paramInt, @Nullable ReadableArray paramReadableArray1, @Nullable ReadableArray paramReadableArray2, @Nullable ReadableArray paramReadableArray3, @Nullable ReadableArray paramReadableArray4, @Nullable ReadableArray paramReadableArray5)
  {
    ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt);
    int k;
    if (paramReadableArray1 == null)
    {
      i = 0;
      if (paramReadableArray3 != null)
        break label75;
      k = 0;
      label25: if (paramReadableArray5 != null)
        break label87;
    }
    label75: label87: for (int j = 0; ; j = paramReadableArray5.size())
    {
      if ((i == 0) || ((paramReadableArray2 != null) && (i == paramReadableArray2.size())))
        break label99;
      throw new IllegalViewOperationException("Size of moveFrom != size of moveTo!");
      i = paramReadableArray1.size();
      break;
      k = paramReadableArray3.size();
      break label25;
    }
    label99: if ((k != 0) && ((paramReadableArray4 == null) || (k != paramReadableArray4.size())))
      throw new IllegalViewOperationException("Size of addChildTags != size of addAtIndices!");
    ViewAtIndex[] arrayOfViewAtIndex = new ViewAtIndex[i + k];
    int[] arrayOfInt1 = new int[i + j];
    int[] arrayOfInt2 = new int[arrayOfInt1.length];
    int[] arrayOfInt3 = new int[j];
    int m;
    int n;
    if (i > 0)
    {
      Assertions.assertNotNull(paramReadableArray1);
      Assertions.assertNotNull(paramReadableArray2);
      m = 0;
      while (m < i)
      {
        n = paramReadableArray1.getInt(m);
        int i1 = localReactShadowNode.getChildAt(n).getReactTag();
        arrayOfViewAtIndex[m] = new ViewAtIndex(i1, paramReadableArray2.getInt(m));
        arrayOfInt1[m] = n;
        arrayOfInt2[m] = i1;
        m += 1;
      }
    }
    if (k > 0)
    {
      Assertions.assertNotNull(paramReadableArray3);
      Assertions.assertNotNull(paramReadableArray4);
      m = 0;
      while (m < k)
      {
        arrayOfViewAtIndex[(i + m)] = new ViewAtIndex(paramReadableArray3.getInt(m), paramReadableArray4.getInt(m));
        m += 1;
      }
    }
    if (j > 0)
    {
      Assertions.assertNotNull(paramReadableArray5);
      k = 0;
      while (k < j)
      {
        m = paramReadableArray5.getInt(k);
        n = localReactShadowNode.getChildAt(m).getReactTag();
        arrayOfInt1[(i + k)] = m;
        arrayOfInt2[(i + k)] = n;
        arrayOfInt3[k] = n;
        k += 1;
      }
    }
    Arrays.sort(arrayOfViewAtIndex, ViewAtIndex.COMPARATOR);
    Arrays.sort(arrayOfInt1);
    j = -1;
    int i = arrayOfInt1.length - 1;
    while (i >= 0)
    {
      if (arrayOfInt1[i] == j)
        throw new IllegalViewOperationException("Repeated indices in Removal list for view tag: " + paramInt);
      localReactShadowNode.removeChildAt(arrayOfInt1[i]);
      j = arrayOfInt1[i];
      i -= 1;
    }
    paramInt = 0;
    while (paramInt < arrayOfViewAtIndex.length)
    {
      paramReadableArray1 = arrayOfViewAtIndex[paramInt];
      paramReadableArray2 = this.mShadowNodeRegistry.getNode(paramReadableArray1.mTag);
      if (paramReadableArray2 == null)
        throw new IllegalViewOperationException("Trying to add unknown view tag: " + paramReadableArray1.mTag);
      localReactShadowNode.addChildAt(paramReadableArray2, paramReadableArray1.mIndex);
      paramInt += 1;
    }
    if ((!localReactShadowNode.isVirtual()) && (!localReactShadowNode.isVirtualAnchor()))
      this.mNativeViewHierarchyOptimizer.handleManageChildren(localReactShadowNode, arrayOfInt1, arrayOfInt2, arrayOfViewAtIndex, arrayOfInt3);
    paramInt = 0;
    while (paramInt < arrayOfInt3.length)
    {
      removeShadowNode(this.mShadowNodeRegistry.getNode(arrayOfInt3[paramInt]));
      paramInt += 1;
    }
  }

  public void measure(int paramInt, Callback paramCallback)
  {
    this.mOperationsQueue.enqueueMeasure(paramInt, paramCallback);
  }

  public void measureInWindow(int paramInt, Callback paramCallback)
  {
    this.mOperationsQueue.enqueueMeasureInWindow(paramInt, paramCallback);
  }

  public void measureLayout(int paramInt1, int paramInt2, Callback paramCallback1, Callback paramCallback2)
  {
    try
    {
      measureLayout(paramInt1, paramInt2, this.mMeasureBuffer);
      paramCallback2.invoke(new Object[] { Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[0])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[1])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[2])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[3])) });
      return;
    }
    catch (IllegalViewOperationException paramCallback2)
    {
      paramCallback1.invoke(new Object[] { paramCallback2.getMessage() });
    }
  }

  public void measureLayoutRelativeToParent(int paramInt, Callback paramCallback1, Callback paramCallback2)
  {
    try
    {
      measureLayoutRelativeToParent(paramInt, this.mMeasureBuffer);
      paramCallback2.invoke(new Object[] { Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[0])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[1])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[2])), Float.valueOf(PixelUtil.toDIPFromPixel(this.mMeasureBuffer[3])) });
      return;
    }
    catch (IllegalViewOperationException paramCallback2)
    {
      paramCallback1.invoke(new Object[] { paramCallback2.getMessage() });
    }
  }

  public void onHostDestroy()
  {
  }

  public void onHostPause()
  {
    this.mOperationsQueue.pauseFrameCallback();
  }

  public void onHostResume()
  {
    this.mOperationsQueue.resumeFrameCallback();
  }

  public void profileNextBatch()
  {
    this.mOperationsQueue.profileNextBatch();
  }

  public void registerAnimation(Animation paramAnimation)
  {
    this.mOperationsQueue.enqueueRegisterAnimation(paramAnimation);
  }

  public <T extends SizeMonitoringFrameLayout,  extends MeasureSpecProvider> void registerRootView(T paramT, int paramInt, ThemedReactContext paramThemedReactContext)
  {
    ReactShadowNode localReactShadowNode = createRootShadowNode();
    localReactShadowNode.setReactTag(paramInt);
    localReactShadowNode.setThemedContext(paramThemedReactContext);
    updateRootView(localReactShadowNode, ((MeasureSpecProvider)paramT).getWidthMeasureSpec(), ((MeasureSpecProvider)paramT).getHeightMeasureSpec());
    this.mShadowNodeRegistry.addRootNode(localReactShadowNode);
    this.mOperationsQueue.addRootView(paramInt, paramT, paramThemedReactContext);
  }

  public void removeAnimation(int paramInt1, int paramInt2)
  {
    assertViewExists(paramInt1, "removeAnimation");
    this.mOperationsQueue.enqueueRemoveAnimation(paramInt2);
  }

  public void removeRootShadowNode(int paramInt)
  {
    this.mShadowNodeRegistry.removeRootNode(paramInt);
  }

  public void removeRootView(int paramInt)
  {
    removeRootShadowNode(paramInt);
    this.mOperationsQueue.enqueueRemoveRootView(paramInt);
  }

  protected final void removeShadowNode(ReactShadowNode paramReactShadowNode)
  {
    removeShadowNodeRecursive(paramReactShadowNode);
    paramReactShadowNode.dispose();
  }

  public void removeSubviewsFromContainerWithID(int paramInt)
  {
    ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt);
    if (localReactShadowNode == null)
      throw new IllegalViewOperationException("Trying to remove subviews of an unknown view tag: " + paramInt);
    WritableArray localWritableArray = Arguments.createArray();
    int i = 0;
    while (i < localReactShadowNode.getChildCount())
    {
      localWritableArray.pushInt(i);
      i += 1;
    }
    manageChildren(paramInt, null, null, null, null, localWritableArray);
  }

  public void replaceExistingNonRootView(int paramInt1, int paramInt2)
  {
    if ((this.mShadowNodeRegistry.isRootNode(paramInt1)) || (this.mShadowNodeRegistry.isRootNode(paramInt2)))
      throw new IllegalViewOperationException("Trying to add or replace a root tag!");
    Object localObject = this.mShadowNodeRegistry.getNode(paramInt1);
    if (localObject == null)
      throw new IllegalViewOperationException("Trying to replace unknown view tag: " + paramInt1);
    ReactShadowNode localReactShadowNode = ((ReactShadowNode)localObject).getParent();
    if (localReactShadowNode == null)
      throw new IllegalViewOperationException("Node is not attached to a parent: " + paramInt1);
    paramInt1 = localReactShadowNode.indexOf((ReactShadowNode)localObject);
    if (paramInt1 < 0)
      throw new IllegalStateException("Didn't find child tag in parent");
    localObject = Arguments.createArray();
    ((WritableArray)localObject).pushInt(paramInt2);
    WritableArray localWritableArray1 = Arguments.createArray();
    localWritableArray1.pushInt(paramInt1);
    WritableArray localWritableArray2 = Arguments.createArray();
    localWritableArray2.pushInt(paramInt1);
    manageChildren(localReactShadowNode.getReactTag(), null, null, (ReadableArray)localObject, localWritableArray1, localWritableArray2);
  }

  public int resolveRootTagFromReactTag(int paramInt)
  {
    if (this.mShadowNodeRegistry.isRootNode(paramInt))
      return paramInt;
    ReactShadowNode localReactShadowNode = resolveShadowNode(paramInt);
    int i = 0;
    if (localReactShadowNode != null);
    for (paramInt = localReactShadowNode.getRootNode().getReactTag(); ; paramInt = i)
    {
      return paramInt;
      FLog.w("ReactNative", "Warning : attempted to resolve a non-existent react shadow node. reactTag=" + paramInt);
    }
  }

  protected final ReactShadowNode resolveShadowNode(int paramInt)
  {
    return this.mShadowNodeRegistry.getNode(paramInt);
  }

  protected final ViewManager resolveViewManager(String paramString)
  {
    return this.mViewManagers.get(paramString);
  }

  public void sendAccessibilityEvent(int paramInt1, int paramInt2)
  {
    this.mOperationsQueue.enqueueSendAccessibilityEvent(paramInt1, paramInt2);
  }

  public void setChildren(int paramInt, ReadableArray paramReadableArray)
  {
    ReactShadowNode localReactShadowNode1 = this.mShadowNodeRegistry.getNode(paramInt);
    paramInt = 0;
    while (paramInt < paramReadableArray.size())
    {
      ReactShadowNode localReactShadowNode2 = this.mShadowNodeRegistry.getNode(paramReadableArray.getInt(paramInt));
      if (localReactShadowNode2 == null)
        throw new IllegalViewOperationException("Trying to add unknown view tag: " + paramReadableArray.getInt(paramInt));
      localReactShadowNode1.addChildAt(localReactShadowNode2, paramInt);
      paramInt += 1;
    }
    if ((!localReactShadowNode1.isVirtual()) && (!localReactShadowNode1.isVirtualAnchor()))
      this.mNativeViewHierarchyOptimizer.handleSetChildren(localReactShadowNode1, paramReadableArray);
  }

  public void setJSResponder(int paramInt, boolean paramBoolean)
  {
    assertViewExists(paramInt, "setJSResponder");
    for (ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt); (localReactShadowNode.isVirtual()) || (localReactShadowNode.isLayoutOnly()); localReactShadowNode = localReactShadowNode.getParent());
    this.mOperationsQueue.enqueueSetJSResponder(localReactShadowNode.getReactTag(), paramInt, paramBoolean);
  }

  public void setLayoutAnimationEnabledExperimental(boolean paramBoolean)
  {
    this.mOperationsQueue.enqueueSetLayoutAnimationEnabled(paramBoolean);
  }

  public void setViewHierarchyUpdateDebugListener(@Nullable NotThreadSafeViewHierarchyUpdateDebugListener paramNotThreadSafeViewHierarchyUpdateDebugListener)
  {
    this.mOperationsQueue.setViewHierarchyUpdateDebugListener(paramNotThreadSafeViewHierarchyUpdateDebugListener);
  }

  public void setViewLocalData(int paramInt, Object paramObject)
  {
    ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt);
    if (localReactShadowNode == null)
      throw new IllegalViewOperationException("Trying to set local data for view with unknown tag: " + paramInt);
    localReactShadowNode.setLocalData(paramObject);
    dispatchViewUpdatesIfNeeded();
  }

  public void showPopupMenu(int paramInt, ReadableArray paramReadableArray, Callback paramCallback1, Callback paramCallback2)
  {
    assertViewExists(paramInt, "showPopupMenu");
    this.mOperationsQueue.enqueueShowPopupMenu(paramInt, paramReadableArray, paramCallback1, paramCallback2);
  }

  public void synchronouslyUpdateViewOnUIThread(int paramInt, ReactStylesDiffMap paramReactStylesDiffMap)
  {
    UiThreadUtil.assertOnUiThread();
    this.mOperationsQueue.getNativeViewHierarchyManager().updateProperties(paramInt, paramReactStylesDiffMap);
  }

  public void updateNodeSize(int paramInt1, int paramInt2, int paramInt3)
  {
    ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt1);
    if (localReactShadowNode == null)
    {
      FLog.w("ReactNative", "Tried to update size of non-existent tag: " + paramInt1);
      return;
    }
    localReactShadowNode.setStyleWidth(paramInt2);
    localReactShadowNode.setStyleHeight(paramInt3);
    dispatchViewUpdatesIfNeeded();
  }

  public void updateRootView(int paramInt1, int paramInt2, int paramInt3)
  {
    ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt1);
    if (localReactShadowNode == null)
    {
      FLog.w("ReactNative", "Tried to update non-existent root tag: " + paramInt1);
      return;
    }
    updateRootView(localReactShadowNode, paramInt2, paramInt3);
  }

  public void updateRootView(ReactShadowNode paramReactShadowNode, int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    switch (i)
    {
    default:
    case 1073741824:
    case -2147483648:
    case 0:
    }
    while (true)
    {
      paramInt1 = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      switch (paramInt1)
      {
      default:
        return;
        paramReactShadowNode.setStyleWidth(paramInt1);
        continue;
        paramReactShadowNode.setStyleMaxWidth(paramInt1);
        continue;
        paramReactShadowNode.setStyleWidthAuto();
      case 1073741824:
      case -2147483648:
      case 0:
      }
    }
    paramReactShadowNode.setStyleHeight(paramInt2);
    return;
    paramReactShadowNode.setStyleMaxHeight(paramInt2);
    return;
    paramReactShadowNode.setStyleHeightAuto();
  }

  public void updateView(int paramInt, String paramString, ReadableMap paramReadableMap)
  {
    if (this.mViewManagers.get(paramString) == null)
      throw new IllegalViewOperationException("Got unknown view type: " + paramString);
    ReactShadowNode localReactShadowNode = this.mShadowNodeRegistry.getNode(paramInt);
    if (localReactShadowNode == null)
      throw new IllegalViewOperationException("Trying to update non-existent view with tag " + paramInt);
    if (paramReadableMap != null)
    {
      paramReadableMap = new ReactStylesDiffMap(paramReadableMap);
      localReactShadowNode.updateProperties(paramReadableMap);
      handleUpdateView(localReactShadowNode, paramString, paramReadableMap);
    }
  }

  // ERROR //
  protected void updateViewHierarchy()
  {
    // Byte code:
    //   0: lconst_0
    //   1: ldc_w 763
    //   4: invokestatic 766	com/facebook/systrace/Systrace:beginSection	(JLjava/lang/String;)V
    //   7: iconst_0
    //   8: istore_1
    //   9: iload_1
    //   10: aload_0
    //   11: getfield 43	com/facebook/react/uimanager/UIImplementation:mShadowNodeRegistry	Lcom/facebook/react/uimanager/ShadowNodeRegistry;
    //   14: invokevirtual 769	com/facebook/react/uimanager/ShadowNodeRegistry:getRootNodeCount	()I
    //   17: if_icmpge +130 -> 147
    //   20: aload_0
    //   21: getfield 43	com/facebook/react/uimanager/UIImplementation:mShadowNodeRegistry	Lcom/facebook/react/uimanager/ShadowNodeRegistry;
    //   24: iload_1
    //   25: invokevirtual 772	com/facebook/react/uimanager/ShadowNodeRegistry:getRootTag	(I)I
    //   28: istore_2
    //   29: aload_0
    //   30: getfield 43	com/facebook/react/uimanager/UIImplementation:mShadowNodeRegistry	Lcom/facebook/react/uimanager/ShadowNodeRegistry;
    //   33: iload_2
    //   34: invokevirtual 140	com/facebook/react/uimanager/ShadowNodeRegistry:getNode	(I)Lcom/facebook/react/uimanager/ReactShadowNode;
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 48	com/facebook/react/uimanager/UIImplementation:mMeasuredRootNodes	Ljava/util/Set;
    //   42: iload_2
    //   43: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: invokeinterface 775 2 0
    //   51: ifeq +101 -> 152
    //   54: lconst_0
    //   55: ldc_w 777
    //   58: invokestatic 310	com/facebook/systrace/SystraceMessage:beginSection	(JLjava/lang/String;)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   61: ldc_w 312
    //   64: aload_3
    //   65: invokeinterface 229 1 0
    //   70: invokevirtual 318	com/facebook/systrace/SystraceMessage$Builder:arg	(Ljava/lang/String;I)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   73: invokevirtual 321	com/facebook/systrace/SystraceMessage$Builder:flush	()V
    //   76: aload_0
    //   77: aload_3
    //   78: invokespecial 219	com/facebook/react/uimanager/UIImplementation:notifyOnBeforeLayoutRecursive	(Lcom/facebook/react/uimanager/ReactShadowNode;)V
    //   81: lconst_0
    //   82: invokestatic 336	com/facebook/systrace/Systrace:endSection	(J)V
    //   85: aload_0
    //   86: aload_3
    //   87: invokevirtual 779	com/facebook/react/uimanager/UIImplementation:calculateRootLayout	(Lcom/facebook/react/uimanager/ReactShadowNode;)V
    //   90: lconst_0
    //   91: ldc_w 781
    //   94: invokestatic 310	com/facebook/systrace/SystraceMessage:beginSection	(JLjava/lang/String;)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   97: ldc_w 312
    //   100: aload_3
    //   101: invokeinterface 229 1 0
    //   106: invokevirtual 318	com/facebook/systrace/SystraceMessage$Builder:arg	(Ljava/lang/String;I)Lcom/facebook/systrace/SystraceMessage$Builder;
    //   109: invokevirtual 321	com/facebook/systrace/SystraceMessage$Builder:flush	()V
    //   112: aload_0
    //   113: aload_3
    //   114: fconst_0
    //   115: fconst_0
    //   116: invokevirtual 269	com/facebook/react/uimanager/UIImplementation:applyUpdatesRecursive	(Lcom/facebook/react/uimanager/ReactShadowNode;FF)V
    //   119: lconst_0
    //   120: invokestatic 336	com/facebook/systrace/Systrace:endSection	(J)V
    //   123: goto +29 -> 152
    //   126: astore_3
    //   127: lconst_0
    //   128: invokestatic 336	com/facebook/systrace/Systrace:endSection	(J)V
    //   131: aload_3
    //   132: athrow
    //   133: astore_3
    //   134: lconst_0
    //   135: invokestatic 336	com/facebook/systrace/Systrace:endSection	(J)V
    //   138: aload_3
    //   139: athrow
    //   140: astore_3
    //   141: lconst_0
    //   142: invokestatic 336	com/facebook/systrace/Systrace:endSection	(J)V
    //   145: aload_3
    //   146: athrow
    //   147: lconst_0
    //   148: invokestatic 336	com/facebook/systrace/Systrace:endSection	(J)V
    //   151: return
    //   152: iload_1
    //   153: iconst_1
    //   154: iadd
    //   155: istore_1
    //   156: goto -147 -> 9
    //
    // Exception table:
    //   from	to	target	type
    //   76	81	126	finally
    //   9	76	133	finally
    //   81	112	133	finally
    //   119	123	133	finally
    //   127	133	133	finally
    //   141	147	133	finally
    //   112	119	140	finally
  }

  public void viewIsDescendantOf(int paramInt1, int paramInt2, Callback paramCallback)
  {
    ReactShadowNode localReactShadowNode1 = this.mShadowNodeRegistry.getNode(paramInt1);
    ReactShadowNode localReactShadowNode2 = this.mShadowNodeRegistry.getNode(paramInt2);
    if ((localReactShadowNode1 == null) || (localReactShadowNode2 == null))
    {
      paramCallback.invoke(new Object[] { Boolean.valueOf(false) });
      return;
    }
    paramCallback.invoke(new Object[] { Boolean.valueOf(localReactShadowNode1.isDescendantOf(localReactShadowNode2)) });
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.UIImplementation
 * JD-Core Version:    0.6.0
 */
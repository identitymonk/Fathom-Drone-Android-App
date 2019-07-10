package com.facebook.react.flat;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.yoga.YogaDirection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Lcom.facebook.react.uimanager.ViewManager;>;
import java.util.Set;
import javax.annotation.Nullable;

public class FlatUIImplementation extends UIImplementation
{
  private static final Map<String, Class<? extends ViewManager>> flatManagerClassMap = new HashMap();
  private final boolean mMemoryImprovementEnabled;
  private final MoveProxy mMoveProxy = new MoveProxy();

  @Nullable
  private RCTImageViewManager mRCTImageViewManager;
  private final ReactApplicationContext mReactContext;
  private final StateBuilder mStateBuilder;

  static
  {
    flatManagerClassMap.put("RCTView", RCTViewManager.class);
    flatManagerClassMap.put("RCTText", RCTTextManager.class);
    flatManagerClassMap.put("RCTRawText", RCTRawTextManager.class);
    flatManagerClassMap.put("RCTVirtualText", RCTVirtualTextManager.class);
    flatManagerClassMap.put("RCTTextInlineImage", RCTTextInlineImageManager.class);
    flatManagerClassMap.put("RCTImageView", RCTImageViewManager.class);
    flatManagerClassMap.put("AndroidTextInput", RCTTextInputManager.class);
    flatManagerClassMap.put("AndroidViewPager", RCTViewPagerManager.class);
    flatManagerClassMap.put("ARTSurfaceView", FlatARTSurfaceViewManager.class);
    flatManagerClassMap.put("RCTModalHostView", RCTModalHostManager.class);
  }

  private FlatUIImplementation(ReactApplicationContext paramReactApplicationContext, @Nullable RCTImageViewManager paramRCTImageViewManager, ViewManagerRegistry paramViewManagerRegistry, FlatUIViewOperationQueue paramFlatUIViewOperationQueue, EventDispatcher paramEventDispatcher, boolean paramBoolean)
  {
    super(paramReactApplicationContext, paramViewManagerRegistry, paramFlatUIViewOperationQueue, paramEventDispatcher);
    this.mReactContext = paramReactApplicationContext;
    this.mRCTImageViewManager = paramRCTImageViewManager;
    this.mStateBuilder = new StateBuilder(paramFlatUIViewOperationQueue);
    this.mMemoryImprovementEnabled = paramBoolean;
  }

  private static void addChildAt(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
      throw new RuntimeException("Invariant failure, needs sorting! " + paramInt1 + " <= " + paramInt2);
    paramReactShadowNode1.addChildAt(paramReactShadowNode2, paramInt1);
  }

  private void addChildren(ReactShadowNode paramReactShadowNode, @Nullable ReadableArray paramReadableArray1, @Nullable ReadableArray paramReadableArray2)
  {
    int n = -1;
    int m;
    int j;
    int i1;
    int k;
    int i;
    if (this.mMoveProxy.size() == 0)
    {
      m = 2147483647;
      j = 2147483647;
      if (paramReadableArray2 != null)
        break label103;
      i1 = 0;
      k = 2147483647;
      i = 2147483647;
    }
    while (true)
    {
      if (i < j)
      {
        addChildAt(paramReactShadowNode, resolveShadowNode(paramReadableArray1.getInt(k)), i, n);
        n = i;
        k += 1;
        if (k == i1)
        {
          i = 2147483647;
          continue;
          m = 0;
          j = this.mMoveProxy.getMoveTo(0);
          break;
          label103: i1 = paramReadableArray2.size();
          k = 0;
          i = paramReadableArray2.getInt(0);
          continue;
        }
        i = paramReadableArray2.getInt(k);
        continue;
      }
      if (j >= i)
        return;
      addChildAt(paramReactShadowNode, this.mMoveProxy.getChildMoveTo(m), j, n);
      n = j;
      m += 1;
      if (m == this.mMoveProxy.size())
      {
        j = 2147483647;
        continue;
      }
      j = this.mMoveProxy.getMoveTo(m);
    }
  }

  private static Map<String, ViewManager> buildViewManagerMap(List<ViewManager> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (ViewManager)paramList.next();
      localHashMap.put(((ViewManager)localObject1).getName(), localObject1);
    }
    Object localObject1 = flatManagerClassMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      paramList = (String)((Map.Entry)localObject2).getKey();
      ViewManager localViewManager = (ViewManager)localHashMap.get(paramList);
      if (localViewManager == null)
        continue;
      localObject2 = (Class)((Map.Entry)localObject2).getValue();
      if (localViewManager.getClass() == localObject2)
        continue;
      try
      {
        localHashMap.put(paramList, ((Class)localObject2).newInstance());
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Unable to access flat class for " + paramList, localIllegalAccessException);
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new RuntimeException("Unable to instantiate flat class for " + paramList, localInstantiationException);
      }
    }
    return (Map<String, ViewManager>)(Map<String, ViewManager>)localInstantiationException;
  }

  public static FlatUIImplementation createInstance(ReactApplicationContext paramReactApplicationContext, List<ViewManager> paramList, EventDispatcher paramEventDispatcher, boolean paramBoolean, int paramInt)
  {
    Object localObject1 = buildViewManagerMap(paramList);
    paramList = (RCTImageViewManager)((Map)localObject1).get("RCTImageView");
    if (paramList != null)
    {
      Object localObject2 = paramList.getCallerContext();
      if (localObject2 != null)
        RCTImageView.setCallerContext(localObject2);
    }
    DraweeRequestHelper.setResources(paramReactApplicationContext.getResources());
    TypefaceCache.setAssetManager(paramReactApplicationContext.getAssets());
    localObject1 = new ViewManagerRegistry((Map)localObject1);
    return (FlatUIImplementation)new FlatUIImplementation(paramReactApplicationContext, paramList, (ViewManagerRegistry)localObject1, new FlatUIViewOperationQueue(paramReactApplicationContext, new FlatNativeViewHierarchyManager((ViewManagerRegistry)localObject1), paramInt), paramEventDispatcher, paramBoolean);
  }

  private void dropNativeViews(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2)
  {
    int j;
    int i;
    if ((paramReactShadowNode1 instanceof FlatShadowNode))
    {
      FlatShadowNode localFlatShadowNode = (FlatShadowNode)paramReactShadowNode1;
      if ((localFlatShadowNode.mountsToView()) && (localFlatShadowNode.isBackingViewCreated()))
      {
        j = -1;
        paramReactShadowNode1 = paramReactShadowNode2;
        i = j;
        if (paramReactShadowNode1 != null)
        {
          if ((paramReactShadowNode1 instanceof FlatShadowNode))
          {
            paramReactShadowNode2 = (FlatShadowNode)paramReactShadowNode1;
            if ((paramReactShadowNode2.mountsToView()) && (paramReactShadowNode2.isBackingViewCreated()) && (paramReactShadowNode2.getParent() != null))
              i = paramReactShadowNode2.getReactTag();
          }
        }
        else
          this.mStateBuilder.dropView(localFlatShadowNode, i);
      }
    }
    while (true)
    {
      return;
      paramReactShadowNode1 = paramReactShadowNode1.getParent();
      break;
      i = 0;
      j = paramReactShadowNode1.getChildCount();
      while (i != j)
      {
        dropNativeViews(paramReactShadowNode1.getChildAt(i), paramReactShadowNode1);
        i += 1;
      }
    }
  }

  private void ensureMountsToViewAndBackingViewIsCreated(int paramInt)
  {
    FlatShadowNode localFlatShadowNode = (FlatShadowNode)resolveShadowNode(paramInt);
    if (localFlatShadowNode.isBackingViewCreated())
      return;
    localFlatShadowNode.forceMountToView();
    this.mStateBuilder.ensureBackingViewIsCreated(localFlatShadowNode);
  }

  private void measureHelper(int paramInt, boolean paramBoolean, Callback paramCallback)
  {
    FlatShadowNode localFlatShadowNode2 = (FlatShadowNode)resolveShadowNode(paramInt);
    FlatShadowNode localFlatShadowNode1 = localFlatShadowNode2;
    if (localFlatShadowNode2.mountsToView())
    {
      this.mStateBuilder.ensureBackingViewIsCreated(localFlatShadowNode2);
      if (paramBoolean)
        super.measureInWindow(paramInt, paramCallback);
    }
    do
    {
      return;
      super.measure(paramInt, paramCallback);
      return;
      while ((localFlatShadowNode1 != null) && (localFlatShadowNode1.isVirtual()))
        localFlatShadowNode1 = (FlatShadowNode)localFlatShadowNode1.getParent();
    }
    while (localFlatShadowNode1 == null);
    float f5 = localFlatShadowNode1.getLayoutWidth();
    float f6 = localFlatShadowNode1.getLayoutHeight();
    boolean bool = localFlatShadowNode1.mountsToView();
    float f2;
    float f1;
    if (bool)
    {
      f2 = localFlatShadowNode1.getLayoutX();
      if (!bool)
        break label202;
      f1 = localFlatShadowNode1.getLayoutY();
    }
    while (true)
    {
      if (localFlatShadowNode1.mountsToView())
        break label208;
      f4 = f2;
      f3 = f1;
      if (!localFlatShadowNode1.isVirtual())
      {
        f4 = f2 + localFlatShadowNode1.getLayoutX();
        f3 = f1 + localFlatShadowNode1.getLayoutY();
      }
      localFlatShadowNode1 = (FlatShadowNode)Assertions.assumeNotNull((FlatShadowNode)localFlatShadowNode1.getParent());
      f2 = f4;
      f1 = f3;
      continue;
      f2 = 0.0F;
      break;
      label202: f1 = 0.0F;
    }
    label208: float f3 = localFlatShadowNode1.getLayoutWidth();
    float f4 = localFlatShadowNode1.getLayoutHeight();
    this.mStateBuilder.getOperationsQueue().enqueueMeasureVirtualView(localFlatShadowNode1.getReactTag(), f2 / f3, f1 / f4, f5 / f3, f6 / f4, paramBoolean, paramCallback);
  }

  private void moveChild(ReactShadowNode paramReactShadowNode, int paramInt)
  {
    this.mMoveProxy.setChildMoveFrom(paramInt, paramReactShadowNode);
  }

  private void removeChild(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2)
  {
    dropNativeViews(paramReactShadowNode1, paramReactShadowNode2);
    removeShadowNode(paramReactShadowNode1);
  }

  private static ReactShadowNode removeChildAt(ReactShadowNode paramReactShadowNode, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2)
      throw new RuntimeException("Invariant failure, needs sorting! " + paramInt1 + " >= " + paramInt2);
    return paramReactShadowNode.removeChildAt(paramInt1);
  }

  private void removeChildren(ReactShadowNode paramReactShadowNode, @Nullable ReadableArray paramReadableArray1, @Nullable ReadableArray paramReadableArray2, @Nullable ReadableArray paramReadableArray3)
  {
    int m = 2147483647;
    this.mMoveProxy.setup(paramReadableArray1, paramReadableArray2);
    int n = this.mMoveProxy.size() - 1;
    if (n == -1)
    {
      j = -1;
      if (paramReadableArray3 != null)
        break label103;
    }
    int k;
    label103: for (int i = 0; ; i = paramReadableArray3.size())
    {
      paramReadableArray1 = new int[i];
      if (i <= 0)
        break label115;
      Assertions.assertNotNull(paramReadableArray3);
      k = 0;
      while (k < i)
      {
        paramReadableArray1[k] = paramReadableArray3.getInt(k);
        k += 1;
      }
      j = this.mMoveProxy.getMoveFrom(n);
      break;
    }
    label115: Arrays.sort(paramReadableArray1);
    if (paramReadableArray3 == null)
    {
      k = -1;
      i = -1;
      if (j <= i)
        break label202;
      moveChild(removeChildAt(paramReactShadowNode, j, m), n);
      m = j;
      n -= 1;
      if (n != -1)
        break label188;
    }
    label188: for (int j = -1; ; j = this.mMoveProxy.getMoveFrom(n))
    {
      break;
      k = paramReadableArray1.length - 1;
      i = paramReadableArray1[k];
      break;
    }
    label202: if (i > j)
    {
      removeChild(removeChildAt(paramReactShadowNode, i, m), paramReactShadowNode);
      m = i;
      k -= 1;
      if (k == -1);
      for (i = -1; ; i = paramReadableArray1[k])
        break;
    }
  }

  public void addAnimation(int paramInt1, int paramInt2, Callback paramCallback)
  {
    ensureMountsToViewAndBackingViewIsCreated(paramInt1);
    super.addAnimation(paramInt1, paramInt2, paramCallback);
  }

  protected void applyUpdatesRecursive(ReactShadowNode paramReactShadowNode, float paramFloat1, float paramFloat2)
  {
    this.mStateBuilder.applyUpdates((FlatRootShadowNode)paramReactShadowNode);
  }

  protected ReactShadowNode createRootShadowNode()
  {
    if (this.mRCTImageViewManager != null)
    {
      this.mReactContext.getNativeModule(FrescoModule.class);
      DraweeRequestHelper.setDraweeControllerBuilder(this.mRCTImageViewManager.getDraweeControllerBuilder());
      this.mRCTImageViewManager = null;
    }
    FlatRootShadowNode localFlatRootShadowNode = new FlatRootShadowNode();
    if (I18nUtil.getInstance().isRTL(this.mReactContext))
      localFlatRootShadowNode.setLayoutDirection(YogaDirection.RTL);
    return localFlatRootShadowNode;
  }

  protected ReactShadowNode createShadowNode(String paramString)
  {
    ReactShadowNode localReactShadowNode = super.createShadowNode(paramString);
    if (((localReactShadowNode instanceof FlatShadowNode)) || (localReactShadowNode.isVirtual()))
      return localReactShadowNode;
    return new NativeViewWrapper(resolveViewManager(paramString));
  }

  public void dispatchViewManagerCommand(int paramInt1, int paramInt2, ReadableArray paramReadableArray)
  {
    ensureMountsToViewAndBackingViewIsCreated(paramInt1);
    this.mStateBuilder.enqueueViewManagerCommand(paramInt1, paramInt2, paramReadableArray);
  }

  public void findSubviewIn(int paramInt, float paramFloat1, float paramFloat2, Callback paramCallback)
  {
    ensureMountsToViewAndBackingViewIsCreated(paramInt);
    super.findSubviewIn(paramInt, paramFloat1, paramFloat2, paramCallback);
  }

  protected void handleCreateView(ReactShadowNode paramReactShadowNode, int paramInt, @Nullable ReactStylesDiffMap paramReactStylesDiffMap)
  {
    if ((paramReactShadowNode instanceof FlatShadowNode))
    {
      paramReactShadowNode = (FlatShadowNode)paramReactShadowNode;
      if (paramReactStylesDiffMap != null)
        paramReactShadowNode.handleUpdateProperties(paramReactStylesDiffMap);
      if (paramReactShadowNode.mountsToView())
        this.mStateBuilder.enqueueCreateOrUpdateView(paramReactShadowNode, paramReactStylesDiffMap);
      return;
    }
    super.handleCreateView(paramReactShadowNode, paramInt, paramReactStylesDiffMap);
  }

  protected void handleUpdateView(ReactShadowNode paramReactShadowNode, String paramString, ReactStylesDiffMap paramReactStylesDiffMap)
  {
    if ((paramReactShadowNode instanceof FlatShadowNode))
    {
      paramReactShadowNode = (FlatShadowNode)paramReactShadowNode;
      paramReactShadowNode.handleUpdateProperties(paramReactStylesDiffMap);
      if (paramReactShadowNode.mountsToView())
        this.mStateBuilder.enqueueCreateOrUpdateView(paramReactShadowNode, paramReactStylesDiffMap);
      return;
    }
    super.handleUpdateView(paramReactShadowNode, paramString, paramReactStylesDiffMap);
  }

  public void manageChildren(int paramInt, @Nullable ReadableArray paramReadableArray1, @Nullable ReadableArray paramReadableArray2, @Nullable ReadableArray paramReadableArray3, @Nullable ReadableArray paramReadableArray4, @Nullable ReadableArray paramReadableArray5)
  {
    ReactShadowNode localReactShadowNode = resolveShadowNode(paramInt);
    removeChildren(localReactShadowNode, paramReadableArray1, paramReadableArray2, paramReadableArray5);
    addChildren(localReactShadowNode, paramReadableArray3, paramReadableArray4);
  }

  public void measure(int paramInt, Callback paramCallback)
  {
    measureHelper(paramInt, false, paramCallback);
  }

  public void measureInWindow(int paramInt, Callback paramCallback)
  {
    measureHelper(paramInt, true, paramCallback);
  }

  public void removeRootView(int paramInt)
  {
    if (this.mMemoryImprovementEnabled)
      removeRootShadowNode(paramInt);
    this.mStateBuilder.removeRootView(paramInt);
  }

  public void sendAccessibilityEvent(int paramInt1, int paramInt2)
  {
    ensureMountsToViewAndBackingViewIsCreated(paramInt1);
    super.sendAccessibilityEvent(paramInt1, paramInt2);
  }

  public void setChildren(int paramInt, ReadableArray paramReadableArray)
  {
    ReactShadowNode localReactShadowNode = resolveShadowNode(paramInt);
    paramInt = 0;
    while (paramInt < paramReadableArray.size())
    {
      addChildAt(localReactShadowNode, resolveShadowNode(paramReadableArray.getInt(paramInt)), paramInt, paramInt - 1);
      paramInt += 1;
    }
  }

  public void setJSResponder(int paramInt, boolean paramBoolean)
  {
    for (ReactShadowNode localReactShadowNode = resolveShadowNode(paramInt); localReactShadowNode.isVirtual(); localReactShadowNode = localReactShadowNode.getParent());
    int i = localReactShadowNode.getReactTag();
    while (((localReactShadowNode instanceof FlatShadowNode)) && (!((FlatShadowNode)localReactShadowNode).mountsToView()))
      localReactShadowNode = localReactShadowNode.getParent();
    FlatUIViewOperationQueue localFlatUIViewOperationQueue = this.mStateBuilder.getOperationsQueue();
    if (localReactShadowNode == null);
    while (true)
    {
      localFlatUIViewOperationQueue.enqueueSetJSResponder(i, paramInt, paramBoolean);
      return;
      i = localReactShadowNode.getReactTag();
    }
  }

  public void showPopupMenu(int paramInt, ReadableArray paramReadableArray, Callback paramCallback1, Callback paramCallback2)
  {
    ensureMountsToViewAndBackingViewIsCreated(paramInt);
    super.showPopupMenu(paramInt, paramReadableArray, paramCallback1, paramCallback2);
  }

  protected void updateViewHierarchy()
  {
    super.updateViewHierarchy();
    this.mStateBuilder.afterUpdateViewHierarchy(this.mEventDispatcher);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.FlatUIImplementation
 * JD-Core Version:    0.6.0
 */
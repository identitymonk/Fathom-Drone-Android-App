package com.facebook.react.uimanager;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnDismissListener;
import android.widget.PopupMenu.OnMenuItemClickListener;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.animation.Animation;
import com.facebook.react.animation.AnimationListener;
import com.facebook.react.animation.AnimationRegistry;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationController;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationListener;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class NativeViewHierarchyManager
{
  private static final String TAG = NativeViewHierarchyManager.class.getSimpleName();
  private final AnimationRegistry mAnimationRegistry = new AnimationRegistry();
  private final JSResponderHandler mJSResponderHandler = new JSResponderHandler();
  private boolean mLayoutAnimationEnabled;
  private final LayoutAnimationController mLayoutAnimator = new LayoutAnimationController();
  private final SparseBooleanArray mRootTags;
  private final RootViewManager mRootViewManager;
  private final SparseArray<ViewManager> mTagsToViewManagers;
  private final SparseArray<View> mTagsToViews;
  private final ViewManagerRegistry mViewManagers;

  public NativeViewHierarchyManager(ViewManagerRegistry paramViewManagerRegistry)
  {
    this(paramViewManagerRegistry, new RootViewManager());
  }

  public NativeViewHierarchyManager(ViewManagerRegistry paramViewManagerRegistry, RootViewManager paramRootViewManager)
  {
    this.mViewManagers = paramViewManagerRegistry;
    this.mTagsToViews = new SparseArray();
    this.mTagsToViewManagers = new SparseArray();
    this.mRootTags = new SparseBooleanArray();
    this.mRootViewManager = paramRootViewManager;
  }

  private boolean arrayContains(@Nullable int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null);
    while (true)
    {
      return false;
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfInt[i] == paramInt)
          return true;
        i += 1;
      }
    }
  }

  private static String constructManageChildrenErrorMessage(ViewGroup paramViewGroup, ViewGroupManager paramViewGroupManager, @Nullable int[] paramArrayOfInt1, @Nullable ViewAtIndex[] paramArrayOfViewAtIndex, @Nullable int[] paramArrayOfInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    int j;
    if (paramViewGroup != null)
    {
      localStringBuilder.append("View tag:" + paramViewGroup.getId() + "\n");
      localStringBuilder.append("  children(" + paramViewGroupManager.getChildCount(paramViewGroup) + "): [\n");
      i = 0;
      while (i < paramViewGroupManager.getChildCount(paramViewGroup))
      {
        j = 0;
        while ((i + j < paramViewGroupManager.getChildCount(paramViewGroup)) && (j < 16))
        {
          localStringBuilder.append(paramViewGroupManager.getChildAt(paramViewGroup, i + j).getId() + ",");
          j += 1;
        }
        localStringBuilder.append("\n");
        i += 16;
      }
      localStringBuilder.append(" ],\n");
    }
    if (paramArrayOfInt1 != null)
    {
      localStringBuilder.append("  indicesToRemove(" + paramArrayOfInt1.length + "): [\n");
      i = 0;
      while (i < paramArrayOfInt1.length)
      {
        j = 0;
        while ((i + j < paramArrayOfInt1.length) && (j < 16))
        {
          localStringBuilder.append(paramArrayOfInt1[(i + j)] + ",");
          j += 1;
        }
        localStringBuilder.append("\n");
        i += 16;
      }
      localStringBuilder.append(" ],\n");
    }
    if (paramArrayOfViewAtIndex != null)
    {
      localStringBuilder.append("  viewsToAdd(" + paramArrayOfViewAtIndex.length + "): [\n");
      i = 0;
      while (i < paramArrayOfViewAtIndex.length)
      {
        j = 0;
        while ((i + j < paramArrayOfViewAtIndex.length) && (j < 16))
        {
          localStringBuilder.append("[" + paramArrayOfViewAtIndex[(i + j)].mIndex + "," + paramArrayOfViewAtIndex[(i + j)].mTag + "],");
          j += 1;
        }
        localStringBuilder.append("\n");
        i += 16;
      }
      localStringBuilder.append(" ],\n");
    }
    if (paramArrayOfInt2 != null)
    {
      localStringBuilder.append("  tagsToDelete(" + paramArrayOfInt2.length + "): [\n");
      i = 0;
      while (i < paramArrayOfInt2.length)
      {
        j = 0;
        while ((i + j < paramArrayOfInt2.length) && (j < 16))
        {
          localStringBuilder.append(paramArrayOfInt2[(i + j)] + ",");
          j += 1;
        }
        localStringBuilder.append("\n");
        i += 16;
      }
      localStringBuilder.append(" ]\n");
    }
    return localStringBuilder.toString();
  }

  private static String constructSetChildrenErrorMessage(ViewGroup paramViewGroup, ViewGroupManager paramViewGroupManager, ReadableArray paramReadableArray)
  {
    ViewAtIndex[] arrayOfViewAtIndex = new ViewAtIndex[paramReadableArray.size()];
    int i = 0;
    while (i < paramReadableArray.size())
    {
      arrayOfViewAtIndex[i] = new ViewAtIndex(paramReadableArray.getInt(i), i);
      i += 1;
    }
    return constructManageChildrenErrorMessage(paramViewGroup, paramViewGroupManager, null, arrayOfViewAtIndex, null);
  }

  private ThemedReactContext getReactContextForView(int paramInt)
  {
    View localView = (View)this.mTagsToViews.get(paramInt);
    if (localView == null)
      throw new JSApplicationIllegalArgumentException("Could not find view with tag " + paramInt);
    return (ThemedReactContext)localView.getContext();
  }

  private void updateLayout(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.mLayoutAnimationEnabled) && (this.mLayoutAnimator.shouldAnimateLayout(paramView)))
    {
      this.mLayoutAnimator.applyLayoutUpdate(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }

  public void addRootView(int paramInt, SizeMonitoringFrameLayout paramSizeMonitoringFrameLayout, ThemedReactContext paramThemedReactContext)
  {
    monitorenter;
    try
    {
      addRootViewGroup(paramInt, paramSizeMonitoringFrameLayout, paramThemedReactContext);
      monitorexit;
      return;
    }
    finally
    {
      paramSizeMonitoringFrameLayout = finally;
      monitorexit;
    }
    throw paramSizeMonitoringFrameLayout;
  }

  protected final void addRootViewGroup(int paramInt, ViewGroup paramViewGroup, ThemedReactContext paramThemedReactContext)
  {
    monitorenter;
    try
    {
      if (paramViewGroup.getId() != -1)
        throw new IllegalViewOperationException("Trying to add a root view with an explicit id already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.");
    }
    finally
    {
      monitorexit;
    }
    this.mTagsToViews.put(paramInt, paramViewGroup);
    this.mTagsToViewManagers.put(paramInt, this.mRootViewManager);
    this.mRootTags.put(paramInt, true);
    paramViewGroup.setId(paramInt);
    monitorexit;
  }

  public void clearJSResponder()
  {
    this.mJSResponderHandler.clearJSResponder();
  }

  void clearLayoutAnimation()
  {
    this.mLayoutAnimator.reset();
  }

  void configureLayoutAnimation(ReadableMap paramReadableMap)
  {
    this.mLayoutAnimator.initializeFromConfig(paramReadableMap);
  }

  public void createView(ThemedReactContext paramThemedReactContext, int paramInt, String paramString, @Nullable ReactStylesDiffMap paramReactStylesDiffMap)
  {
    monitorenter;
    try
    {
      UiThreadUtil.assertOnUiThread();
      SystraceMessage.beginSection(0L, "NativeViewHierarchyManager_createView").arg("tag", paramInt).arg("className", paramString).flush();
      try
      {
        paramString = this.mViewManagers.get(paramString);
        paramThemedReactContext = paramString.createView(paramThemedReactContext, this.mJSResponderHandler);
        this.mTagsToViews.put(paramInt, paramThemedReactContext);
        this.mTagsToViewManagers.put(paramInt, paramString);
        paramThemedReactContext.setId(paramInt);
        if (paramReactStylesDiffMap != null)
          paramString.updateProperties(paramThemedReactContext, paramReactStylesDiffMap);
        Systrace.endSection(0L);
        monitorexit;
        return;
      }
      finally
      {
        Systrace.endSection(0L);
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramThemedReactContext;
  }

  public void dispatchCommand(int paramInt1, int paramInt2, @Nullable ReadableArray paramReadableArray)
  {
    monitorenter;
    View localView;
    try
    {
      UiThreadUtil.assertOnUiThread();
      localView = (View)this.mTagsToViews.get(paramInt1);
      if (localView == null)
        throw new IllegalViewOperationException("Trying to send command to a non-existing view with tag " + paramInt1);
    }
    finally
    {
      monitorexit;
    }
    resolveViewManager(paramInt1).receiveCommand(localView, paramInt2, paramReadableArray);
    monitorexit;
  }

  protected void dropView(View paramView)
  {
    monitorenter;
    while (true)
    {
      int i;
      try
      {
        UiThreadUtil.assertOnUiThread();
        if (this.mRootTags.get(paramView.getId()))
          continue;
        resolveViewManager(paramView.getId()).onDropViewInstance(paramView);
        Object localObject = (ViewManager)this.mTagsToViewManagers.get(paramView.getId());
        if ((!(paramView instanceof ViewGroup)) || (!(localObject instanceof ViewGroupManager)))
          continue;
        ViewGroup localViewGroup = (ViewGroup)paramView;
        localObject = (ViewGroupManager)localObject;
        i = ((ViewGroupManager)localObject).getChildCount(localViewGroup) - 1;
        if (i < 0)
          continue;
        View localView = ((ViewGroupManager)localObject).getChildAt(localViewGroup, i);
        if (this.mTagsToViews.get(localView.getId()) != null)
        {
          dropView(localView);
          break label156;
          ((ViewGroupManager)localObject).removeAllViews(localViewGroup);
          this.mTagsToViews.remove(paramView.getId());
          this.mTagsToViewManagers.remove(paramView.getId());
          return;
        }
      }
      finally
      {
        monitorexit;
      }
      label156: i -= 1;
    }
  }

  public int findTargetTagForTouch(int paramInt, float paramFloat1, float paramFloat2)
  {
    monitorenter;
    try
    {
      UiThreadUtil.assertOnUiThread();
      View localView = (View)this.mTagsToViews.get(paramInt);
      if (localView == null)
        throw new JSApplicationIllegalArgumentException("Could not find view with tag " + paramInt);
    }
    finally
    {
      monitorexit;
    }
    paramInt = TouchTargetHelper.findTargetTagForTouch(paramFloat1, paramFloat2, (ViewGroup)localObject);
    monitorexit;
    return paramInt;
  }

  public AnimationRegistry getAnimationRegistry()
  {
    return this.mAnimationRegistry;
  }

  public void manageChildren(int paramInt, @Nullable int[] paramArrayOfInt1, @Nullable ViewAtIndex[] paramArrayOfViewAtIndex, @Nullable int[] paramArrayOfInt2)
  {
    monitorenter;
    ViewGroup localViewGroup;
    ViewGroupManager localViewGroupManager;
    try
    {
      UiThreadUtil.assertOnUiThread();
      localViewGroup = (ViewGroup)this.mTagsToViews.get(paramInt);
      localViewGroupManager = (ViewGroupManager)resolveViewManager(paramInt);
      if (localViewGroup == null)
        throw new IllegalViewOperationException("Trying to manageChildren view with tag " + paramInt + " which doesn't exist\n detail: " + constructManageChildrenErrorMessage(localViewGroup, localViewGroupManager, paramArrayOfInt1, paramArrayOfViewAtIndex, paramArrayOfInt2));
    }
    finally
    {
      monitorexit;
    }
    int j = localViewGroupManager.getChildCount(localViewGroup);
    int i;
    int k;
    Object localObject;
    if (paramArrayOfInt1 != null)
    {
      i = paramArrayOfInt1.length - 1;
      if (i >= 0)
      {
        k = paramArrayOfInt1[i];
        if (k < 0)
          throw new IllegalViewOperationException("Trying to remove a negative view index:" + k + " view tag: " + paramInt + "\n detail: " + constructManageChildrenErrorMessage(localViewGroup, localViewGroupManager, paramArrayOfInt1, paramArrayOfViewAtIndex, paramArrayOfInt2));
        if (k >= localViewGroupManager.getChildCount(localViewGroup))
          throw new IllegalViewOperationException("Trying to remove a view index above child count " + k + " view tag: " + paramInt + "\n detail: " + constructManageChildrenErrorMessage(localViewGroup, localViewGroupManager, paramArrayOfInt1, paramArrayOfViewAtIndex, paramArrayOfInt2));
        if (k >= j)
          throw new IllegalViewOperationException("Trying to remove an out of order view index:" + k + " view tag: " + paramInt + "\n detail: " + constructManageChildrenErrorMessage(localViewGroup, localViewGroupManager, paramArrayOfInt1, paramArrayOfViewAtIndex, paramArrayOfInt2));
        localObject = localViewGroupManager.getChildAt(localViewGroup, k);
        if ((!this.mLayoutAnimationEnabled) || (!this.mLayoutAnimator.shouldAnimateLayout((View)localObject)) || (!arrayContains(paramArrayOfInt2, ((View)localObject).getId())))
        {
          localViewGroupManager.removeViewAt(localViewGroup, k);
          break label620;
          label376: 
          while (paramInt < paramArrayOfViewAtIndex.length)
          {
            localObject = paramArrayOfViewAtIndex[paramInt];
            View localView = (View)this.mTagsToViews.get(((ViewAtIndex)localObject).mTag);
            if (localView == null)
              throw new IllegalViewOperationException("Trying to add unknown view tag: " + ((ViewAtIndex)localObject).mTag + "\n detail: " + constructManageChildrenErrorMessage(localViewGroup, localViewGroupManager, paramArrayOfInt1, paramArrayOfViewAtIndex, paramArrayOfInt2));
            localViewGroupManager.addView(localViewGroup, localView, ((ViewAtIndex)localObject).mIndex);
            paramInt += 1;
          }
        }
      }
    }
    while (true)
    {
      if (paramInt < paramArrayOfInt2.length)
      {
        i = paramArrayOfInt2[paramInt];
        localObject = (View)this.mTagsToViews.get(i);
        if (localObject == null)
          throw new IllegalViewOperationException("Trying to destroy unknown view tag: " + i + "\n detail: " + constructManageChildrenErrorMessage(localViewGroup, localViewGroupManager, paramArrayOfInt1, paramArrayOfViewAtIndex, paramArrayOfInt2));
        if ((this.mLayoutAnimationEnabled) && (this.mLayoutAnimator.shouldAnimateLayout((View)localObject)))
          this.mLayoutAnimator.deleteView((View)localObject, new LayoutAnimationListener(localViewGroupManager, localViewGroup, (View)localObject)
          {
            public void onAnimationEnd()
            {
              this.val$viewManager.removeView(this.val$viewToManage, this.val$viewToDestroy);
              NativeViewHierarchyManager.this.dropView(this.val$viewToDestroy);
            }
          });
        else
          dropView((View)localObject);
      }
      else
      {
        label620: 
        do
        {
          monitorexit;
          return;
          j = k;
          i -= 1;
          break;
          if (paramArrayOfViewAtIndex == null)
            continue;
          paramInt = 0;
          break label376;
        }
        while (paramArrayOfInt2 == null);
        paramInt = 0;
        continue;
      }
      paramInt += 1;
    }
  }

  public void measure(int paramInt, int[] paramArrayOfInt)
  {
    monitorenter;
    View localView1;
    try
    {
      UiThreadUtil.assertOnUiThread();
      localView1 = (View)this.mTagsToViews.get(paramInt);
      if (localView1 == null)
        throw new NoSuchNativeViewException("No native view for " + paramInt + " currently exists");
    }
    finally
    {
      monitorexit;
    }
    View localView2 = (View)RootViewUtil.getRootView(localView1);
    if (localView2 == null)
      throw new NoSuchNativeViewException("Native view " + paramInt + " is no longer on screen");
    localView2.getLocationInWindow(paramArrayOfInt);
    paramInt = paramArrayOfInt[0];
    int i = paramArrayOfInt[1];
    localView1.getLocationInWindow(paramArrayOfInt);
    paramArrayOfInt[0] -= paramInt;
    paramArrayOfInt[1] -= i;
    paramArrayOfInt[2] = localView1.getWidth();
    paramArrayOfInt[3] = localView1.getHeight();
    monitorexit;
  }

  public void measureInWindow(int paramInt, int[] paramArrayOfInt)
  {
    monitorenter;
    View localView;
    try
    {
      UiThreadUtil.assertOnUiThread();
      localView = (View)this.mTagsToViews.get(paramInt);
      if (localView == null)
        throw new NoSuchNativeViewException("No native view for " + paramInt + " currently exists");
    }
    finally
    {
      monitorexit;
    }
    localView.getLocationOnScreen(paramArrayOfInt);
    Resources localResources = localView.getContext().getResources();
    paramInt = localResources.getIdentifier("status_bar_height", "dimen", "android");
    if (paramInt > 0)
    {
      paramInt = (int)localResources.getDimension(paramInt);
      paramArrayOfInt[1] -= paramInt;
    }
    paramArrayOfInt[2] = localView.getWidth();
    paramArrayOfInt[3] = localView.getHeight();
    monitorexit;
  }

  public void removeRootView(int paramInt)
  {
    monitorenter;
    try
    {
      UiThreadUtil.assertOnUiThread();
      if (!this.mRootTags.get(paramInt))
        SoftAssertions.assertUnreachable("View with tag " + paramInt + " is not registered as a root view");
      dropView((View)this.mTagsToViews.get(paramInt));
      this.mRootTags.delete(paramInt);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public final View resolveView(int paramInt)
  {
    monitorenter;
    try
    {
      View localView = (View)this.mTagsToViews.get(paramInt);
      if (localView == null)
        throw new IllegalViewOperationException("Trying to resolve view with tag " + paramInt + " which doesn't exist");
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
    return localObject;
  }

  public final ViewManager resolveViewManager(int paramInt)
  {
    monitorenter;
    try
    {
      ViewManager localViewManager = (ViewManager)this.mTagsToViewManagers.get(paramInt);
      if (localViewManager == null)
        throw new IllegalViewOperationException("ViewManager for tag " + paramInt + " could not be found");
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
    return localObject;
  }

  public void sendAccessibilityEvent(int paramInt1, int paramInt2)
  {
    View localView = (View)this.mTagsToViews.get(paramInt1);
    if (localView == null)
      throw new JSApplicationIllegalArgumentException("Could not find view with tag " + paramInt1);
    AccessibilityHelper.sendAccessibilityEvent(localView, paramInt2);
  }

  public void setChildren(int paramInt, ReadableArray paramReadableArray)
  {
    monitorenter;
    while (true)
    {
      ViewGroup localViewGroup;
      ViewGroupManager localViewGroupManager;
      View localView;
      try
      {
        UiThreadUtil.assertOnUiThread();
        localViewGroup = (ViewGroup)this.mTagsToViews.get(paramInt);
        localViewGroupManager = (ViewGroupManager)resolveViewManager(paramInt);
        paramInt = 0;
        if (paramInt >= paramReadableArray.size())
          break;
        localView = (View)this.mTagsToViews.get(paramReadableArray.getInt(paramInt));
        if (localView == null)
          throw new IllegalViewOperationException("Trying to add unknown view tag: " + paramReadableArray.getInt(paramInt) + "\n detail: " + constructSetChildrenErrorMessage(localViewGroup, localViewGroupManager, paramReadableArray));
      }
      finally
      {
        monitorexit;
      }
      localViewGroupManager.addView(localViewGroup, localView, paramInt);
      paramInt += 1;
    }
    monitorexit;
  }

  public void setJSResponder(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    monitorenter;
    if (!paramBoolean);
    while (true)
    {
      try
      {
        this.mJSResponderHandler.setJSResponder(paramInt2, null);
        return;
        View localView = (View)this.mTagsToViews.get(paramInt1);
        if ((paramInt2 != paramInt1) && ((localView instanceof ViewParent)))
        {
          this.mJSResponderHandler.setJSResponder(paramInt2, (ViewParent)localView);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      if (this.mRootTags.get(paramInt1))
        SoftAssertions.assertUnreachable("Cannot block native responder on " + paramInt1 + " that is a root view");
      this.mJSResponderHandler.setJSResponder(paramInt2, localObject.getParent());
    }
  }

  public void setLayoutAnimationEnabled(boolean paramBoolean)
  {
    this.mLayoutAnimationEnabled = paramBoolean;
  }

  public void showPopupMenu(int paramInt, ReadableArray paramReadableArray, Callback paramCallback)
  {
    monitorenter;
    try
    {
      UiThreadUtil.assertOnUiThread();
      localObject = (View)this.mTagsToViews.get(paramInt);
      if (localObject == null)
        throw new JSApplicationIllegalArgumentException("Could not find view with tag " + paramInt);
    }
    finally
    {
      monitorexit;
    }
    Object localObject = new PopupMenu(getReactContextForView(paramInt), (View)localObject);
    Menu localMenu = ((PopupMenu)localObject).getMenu();
    paramInt = 0;
    while (paramInt < paramReadableArray.size())
    {
      localMenu.add(0, 0, paramInt, paramReadableArray.getString(paramInt));
      paramInt += 1;
    }
    paramReadableArray = new PopupMenuCallbackHandler(paramCallback, null);
    ((PopupMenu)localObject).setOnMenuItemClickListener(paramReadableArray);
    ((PopupMenu)localObject).setOnDismissListener(paramReadableArray);
    ((PopupMenu)localObject).show();
    monitorexit;
  }

  void startAnimationForNativeView(int paramInt, Animation paramAnimation, @Nullable Callback paramCallback)
  {
    monitorenter;
    try
    {
      UiThreadUtil.assertOnUiThread();
      View localView = (View)this.mTagsToViews.get(paramInt);
      int i = paramAnimation.getAnimationID();
      if (localView != null)
      {
        paramAnimation.setAnimationListener(new AnimationListener(i, paramCallback)
        {
          public void onCancel()
          {
            Assertions.assertNotNull(NativeViewHierarchyManager.this.mAnimationRegistry.removeAnimation(this.val$animationId), "Animation was already removed somehow!");
            if (this.val$animationCallback != null)
              this.val$animationCallback.invoke(new Object[] { Boolean.valueOf(false) });
          }

          public void onFinished()
          {
            Assertions.assertNotNull(NativeViewHierarchyManager.this.mAnimationRegistry.removeAnimation(this.val$animationId), "Animation was already removed somehow!");
            if (this.val$animationCallback != null)
              this.val$animationCallback.invoke(new Object[] { Boolean.valueOf(true) });
          }
        });
        paramAnimation.start(localView);
        return;
      }
      throw new IllegalViewOperationException("View with tag " + paramInt + " not found");
    }
    finally
    {
      monitorexit;
    }
    throw paramAnimation;
  }

  public void updateLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    monitorenter;
    while (true)
    {
      try
      {
        UiThreadUtil.assertOnUiThread();
        SystraceMessage.beginSection(0L, "NativeViewHierarchyManager_updateLayout").arg("parentTag", paramInt1).arg("tag", paramInt2).flush();
        try
        {
          View localView1 = resolveView(paramInt2);
          localView1.measure(View.MeasureSpec.makeMeasureSpec(paramInt5, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt6, 1073741824));
          Object localObject2 = localView1.getParent();
          if (!(localObject2 instanceof RootView))
            continue;
          ((ViewParent)localObject2).requestLayout();
          if (!this.mRootTags.get(paramInt1))
          {
            localObject2 = (ViewManager)this.mTagsToViewManagers.get(paramInt1);
            if (!(localObject2 instanceof ViewGroupManager))
              continue;
            localObject2 = (ViewGroupManager)localObject2;
            if ((localObject2 == null) || (((ViewGroupManager)localObject2).needsCustomLayoutForChildren()))
              continue;
            updateLayout(localView1, paramInt3, paramInt4, paramInt5, paramInt6);
            Systrace.endSection(0L);
            monitorexit;
            return;
            throw new IllegalViewOperationException("Trying to use view with tag " + paramInt2 + " as a parent, but its Manager doesn't extends ViewGroupManager");
          }
        }
        finally
        {
          Systrace.endSection(0L);
        }
      }
      finally
      {
        monitorexit;
      }
      updateLayout(localView2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
  }

  public void updateProperties(int paramInt, ReactStylesDiffMap paramReactStylesDiffMap)
  {
    monitorenter;
    try
    {
      UiThreadUtil.assertOnUiThread();
      try
      {
        resolveViewManager(paramInt).updateProperties(resolveView(paramInt), paramReactStylesDiffMap);
        monitorexit;
        return;
      }
      catch (IllegalViewOperationException paramReactStylesDiffMap)
      {
        while (true)
          Log.e(TAG, "Unable to update properties for view tag " + paramInt, paramReactStylesDiffMap);
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramReactStylesDiffMap;
  }

  public void updateViewExtraData(int paramInt, Object paramObject)
  {
    monitorenter;
    try
    {
      UiThreadUtil.assertOnUiThread();
      resolveViewManager(paramInt).updateExtraData(resolveView(paramInt), paramObject);
      monitorexit;
      return;
    }
    finally
    {
      paramObject = finally;
      monitorexit;
    }
    throw paramObject;
  }

  private static class PopupMenuCallbackHandler
    implements PopupMenu.OnMenuItemClickListener, PopupMenu.OnDismissListener
  {
    boolean mConsumed = false;
    final Callback mSuccess;

    private PopupMenuCallbackHandler(Callback paramCallback)
    {
      this.mSuccess = paramCallback;
    }

    public void onDismiss(PopupMenu paramPopupMenu)
    {
      if (!this.mConsumed)
      {
        this.mSuccess.invoke(new Object[] { "dismissed" });
        this.mConsumed = true;
      }
    }

    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      if (!this.mConsumed)
      {
        this.mSuccess.invoke(new Object[] { "itemSelected", Integer.valueOf(paramMenuItem.getOrder()) });
        this.mConsumed = true;
        return true;
      }
      return false;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.NativeViewHierarchyManager
 * JD-Core Version:    0.6.0
 */
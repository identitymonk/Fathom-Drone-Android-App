package com.facebook.react.flat;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.SizeMonitoringFrameLayout;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

final class FlatNativeViewHierarchyManager extends NativeViewHierarchyManager
  implements ViewResolver
{
  FlatNativeViewHierarchyManager(ViewManagerRegistry paramViewManagerRegistry)
  {
    super(paramViewManagerRegistry, new FlatRootViewManager());
  }

  public void addRootView(int paramInt, SizeMonitoringFrameLayout paramSizeMonitoringFrameLayout, ThemedReactContext paramThemedReactContext)
  {
    FlatViewGroup localFlatViewGroup = new FlatViewGroup(paramThemedReactContext);
    paramSizeMonitoringFrameLayout.addView(localFlatViewGroup);
    paramSizeMonitoringFrameLayout.setId(paramInt);
    addRootViewGroup(paramInt, localFlatViewGroup, paramThemedReactContext);
  }

  void detachAllChildrenFromViews(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      Object localObject = resolveView(k);
      if ((localObject instanceof FlatViewGroup))
        ((FlatViewGroup)localObject).detachAllViewsFromParent();
      while (true)
      {
        i += 1;
        break;
        localObject = (ViewGroup)localObject;
        ((ViewGroupManager)resolveViewManager(k)).removeAllViews((ViewGroup)localObject);
      }
    }
  }

  protected void dropView(View paramView)
  {
    super.dropView(paramView);
    if ((paramView instanceof FlatViewGroup))
    {
      paramView = (FlatViewGroup)paramView;
      if (paramView.getRemoveClippedSubviews())
      {
        SparseArray localSparseArray = paramView.getDetachedViews();
        int i = 0;
        int j = localSparseArray.size();
        while (true)
          if (i < j)
          {
            View localView = (View)localSparseArray.valueAt(i);
            try
            {
              dropView(localView);
              label60: paramView.removeDetachedView(localView);
              i += 1;
            }
            catch (Exception localException)
            {
              break label60;
            }
          }
      }
    }
  }

  void dropViews(SparseIntArray paramSparseIntArray)
  {
    int i = 0;
    int j = paramSparseIntArray.size();
    while (true)
    {
      int k;
      View localView2;
      View localView1;
      if (i < j)
      {
        k = paramSparseIntArray.keyAt(i);
        localView2 = null;
        localView1 = null;
        if (k > 0)
          localView1 = localView2;
      }
      try
      {
        localView2 = resolveView(k);
        localView1 = localView2;
        dropView(localView2);
        localView1 = localView2;
        while (true)
        {
          label56: k = paramSparseIntArray.valueAt(i);
          if ((k > 0) && (localView1 != null) && (localView1.getParent() == null))
          {
            localView2 = resolveView(k);
            if ((localView2 instanceof FlatViewGroup))
              ((FlatViewGroup)localView2).onViewDropped(localView1);
          }
          i += 1;
          break;
          removeRootView(-k);
        }
        return;
      }
      catch (Exception localException)
      {
        break label56;
      }
    }
  }

  public View getView(int paramInt)
  {
    return super.resolveView(paramInt);
  }

  void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    resolveView(paramInt1).setPadding(paramInt2, paramInt3, paramInt4, paramInt5);
  }

  void updateClippingMountState(int paramInt, @Nullable DrawCommand[] paramArrayOfDrawCommand, SparseIntArray paramSparseIntArray, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, @Nullable AttachDetachListener[] paramArrayOfAttachDetachListener, @Nullable NodeRegion[] paramArrayOfNodeRegion, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, boolean paramBoolean)
  {
    FlatViewGroup localFlatViewGroup = (FlatViewGroup)resolveView(paramInt);
    if (paramArrayOfDrawCommand != null)
      localFlatViewGroup.mountClippingDrawCommands(paramArrayOfDrawCommand, paramSparseIntArray, paramArrayOfFloat1, paramArrayOfFloat2, paramBoolean);
    if (paramArrayOfAttachDetachListener != null)
      localFlatViewGroup.mountAttachDetachListeners(paramArrayOfAttachDetachListener);
    if (paramArrayOfNodeRegion != null)
      localFlatViewGroup.mountClippingNodeRegions(paramArrayOfNodeRegion, paramArrayOfFloat3, paramArrayOfFloat4);
  }

  void updateMountState(int paramInt, @Nullable DrawCommand[] paramArrayOfDrawCommand, @Nullable AttachDetachListener[] paramArrayOfAttachDetachListener, @Nullable NodeRegion[] paramArrayOfNodeRegion)
  {
    FlatViewGroup localFlatViewGroup = (FlatViewGroup)resolveView(paramInt);
    if (paramArrayOfDrawCommand != null)
      localFlatViewGroup.mountDrawCommands(paramArrayOfDrawCommand);
    if (paramArrayOfAttachDetachListener != null)
      localFlatViewGroup.mountAttachDetachListeners(paramArrayOfAttachDetachListener);
    if (paramArrayOfNodeRegion != null)
      localFlatViewGroup.mountNodeRegions(paramArrayOfNodeRegion);
  }

  void updateViewBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    View localView = resolveView(paramInt1);
    paramInt1 = paramInt4 - paramInt2;
    int i = paramInt5 - paramInt3;
    if ((localView.getWidth() != paramInt1) || (localView.getHeight() != i))
    {
      localView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
      localView.layout(paramInt2, paramInt3, paramInt4, paramInt5);
      return;
    }
    localView.offsetLeftAndRight(paramInt2 - localView.getLeft());
    localView.offsetTopAndBottom(paramInt3 - localView.getTop());
  }

  void updateViewGroup(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Object localObject = resolveView(paramInt);
    if ((localObject instanceof FlatViewGroup))
    {
      ((FlatViewGroup)localObject).mountViews(this, paramArrayOfInt1, paramArrayOfInt2);
      return;
    }
    paramArrayOfInt2 = (ViewGroup)localObject;
    localObject = (ViewGroupManager)resolveViewManager(paramInt);
    ArrayList localArrayList = new ArrayList(paramArrayOfInt1.length);
    int i = paramArrayOfInt1.length;
    paramInt = 0;
    while (paramInt < i)
    {
      localArrayList.add(resolveView(Math.abs(paramArrayOfInt1[paramInt])));
      paramInt += 1;
    }
    ((ViewGroupManager)localObject).addViews(paramArrayOfInt2, localArrayList);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.FlatNativeViewHierarchyManager
 * JD-Core Version:    0.6.0
 */
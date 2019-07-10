package com.facebook.react.flat;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.animation.Animation;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import java.util.ArrayList;
import java.util.Arrays;
import javax.annotation.Nullable;

abstract class ClippingDrawCommandManager extends DrawCommandManager
{
  private static final String TAG = ClippingDrawCommandManager.class.getSimpleName();
  private final SparseArray<View> mClippedSubviews = new SparseArray();
  protected final Rect mClippingRect = new Rect();
  private final ArrayList<ReactClippingViewGroup> mClippingViewGroups = new ArrayList();
  protected float[] mCommandMaxBottom = StateBuilder.EMPTY_FLOAT_ARRAY;
  protected float[] mCommandMinTop = StateBuilder.EMPTY_FLOAT_ARRAY;
  private DrawCommand[] mDrawCommands = DrawCommand.EMPTY_ARRAY;
  private SparseIntArray mDrawViewIndexMap = StateBuilder.EMPTY_SPARSE_INT;
  private final FlatViewGroup mFlatViewGroup;
  private NodeRegion[] mNodeRegions = NodeRegion.EMPTY_ARRAY;
  protected float[] mRegionMaxBottom = StateBuilder.EMPTY_FLOAT_ARRAY;
  protected float[] mRegionMinTop = StateBuilder.EMPTY_FLOAT_ARRAY;
  private int mStart;
  private int mStop;
  private final ArrayList<View> mViewsToKeep = new ArrayList();
  private final SparseArray<View> mViewsToRemove = new SparseArray();

  ClippingDrawCommandManager(FlatViewGroup paramFlatViewGroup, DrawCommand[] paramArrayOfDrawCommand)
  {
    this.mFlatViewGroup = paramFlatViewGroup;
    initialSetup(paramArrayOfDrawCommand);
  }

  private static boolean animating(View paramView)
  {
    paramView = paramView.getAnimation();
    return (paramView != null) && (!paramView.hasEnded());
  }

  private void clip(int paramInt, View paramView)
  {
    this.mClippedSubviews.put(paramInt, paramView);
  }

  private void initialSetup(DrawCommand[] paramArrayOfDrawCommand)
  {
    mountDrawCommands(paramArrayOfDrawCommand, this.mDrawViewIndexMap, this.mCommandMaxBottom, this.mCommandMinTop, true);
    updateClippingRect();
  }

  private boolean isClipped(int paramInt)
  {
    return this.mClippedSubviews.get(paramInt) != null;
  }

  private boolean isNotClipped(int paramInt)
  {
    return this.mClippedSubviews.get(paramInt) == null;
  }

  private void unclip(int paramInt)
  {
    this.mClippedSubviews.remove(paramInt);
  }

  private void updateClippingRecursively()
  {
    int i = 0;
    int j = this.mClippingViewGroups.size();
    while (i < j)
    {
      ReactClippingViewGroup localReactClippingViewGroup = (ReactClippingViewGroup)this.mClippingViewGroups.get(i);
      if (isNotClipped(((View)localReactClippingViewGroup).getId()))
        localReactClippingViewGroup.updateClippingRect();
      i += 1;
    }
  }

  private void updateClippingToCurrentRect()
  {
    int i = 0;
    int j = this.mFlatViewGroup.getChildCount();
    Object localObject1;
    if (i < j)
    {
      localObject1 = this.mFlatViewGroup.getChildAt(i);
      if ((withinBounds(this.mDrawViewIndexMap.get(((View)localObject1).getId()))) || (animating((View)localObject1)))
        this.mViewsToKeep.add(localObject1);
      while (true)
      {
        i += 1;
        break;
        this.mViewsToRemove.append(i, localObject1);
        clip(((View)localObject1).getId(), (View)localObject1);
      }
    }
    j = this.mViewsToRemove.size();
    if (j > 2);
    for (int k = 1; ; k = 0)
    {
      if (k == 0)
        break label486;
      this.mFlatViewGroup.detachAllViewsFromParent();
      i = 0;
      while (i < j)
      {
        this.mFlatViewGroup.removeDetachedView((View)this.mViewsToRemove.valueAt(i));
        i += 1;
      }
    }
    while (true)
    {
      j = i - 1;
      if (i > 0)
      {
        this.mFlatViewGroup.removeViewsInLayout(this.mViewsToRemove.keyAt(j), 1);
        i = j;
        continue;
      }
      this.mViewsToRemove.clear();
      j = this.mStart;
      i = 0;
      int m = 0;
      int i2 = this.mViewsToKeep.size();
      int i1;
      int n;
      label258: Object localObject2;
      Object localObject3;
      if (m < i2)
      {
        localObject1 = (View)this.mViewsToKeep.get(m);
        int i3 = this.mDrawViewIndexMap.get(((View)localObject1).getId());
        i1 = i;
        n = j;
        if (j <= i3)
          if (j != i3)
          {
            if (!(this.mDrawCommands[j] instanceof DrawView))
              break label483;
            localObject2 = (DrawView)this.mDrawCommands[j];
            localObject3 = this.mFlatViewGroup;
            View localView = (View)Assertions.assumeNotNull(this.mClippedSubviews.get(((DrawView)localObject2).reactTag));
            n = i + 1;
            ((FlatViewGroup)localObject3).addViewInLayout(localView, i);
            unclip(((DrawView)localObject2).reactTag);
            i = n;
          }
      }
      label480: label483: 
      while (true)
      {
        j += 1;
        break label258;
        n = j + 1;
        i1 = i;
        if (k != 0)
          this.mFlatViewGroup.attachViewToParent((View)localObject1, i1);
        i = i1 + 1;
        m += 1;
        j = n;
        break;
        this.mViewsToKeep.clear();
        if (j < this.mStop)
        {
          if (!(this.mDrawCommands[j] instanceof DrawView))
            break label480;
          localObject1 = (DrawView)this.mDrawCommands[j];
          localObject2 = this.mFlatViewGroup;
          localObject3 = (View)Assertions.assumeNotNull(this.mClippedSubviews.get(((DrawView)localObject1).reactTag));
          k = i + 1;
          ((FlatViewGroup)localObject2).addViewInLayout((View)localObject3, i);
          unclip(((DrawView)localObject1).reactTag);
          i = k;
        }
        while (true)
        {
          j += 1;
          break;
          return;
        }
      }
      label486: i = j;
    }
  }

  private boolean withinBounds(int paramInt)
  {
    return (this.mStart <= paramInt) && (paramInt < this.mStop);
  }

  @Nullable
  public NodeRegion anyNodeRegionWithinBounds(float paramFloat1, float paramFloat2)
  {
    int j;
    for (int i = regionStopIndex(paramFloat1, paramFloat2); ; i = j)
    {
      j = i - 1;
      NodeRegion localNodeRegion2;
      NodeRegion localNodeRegion1;
      if (i > 0)
      {
        localNodeRegion2 = this.mNodeRegions[j];
        if (!regionAboveTouch(j, paramFloat1, paramFloat2));
      }
      else
      {
        localNodeRegion1 = null;
      }
      do
      {
        return localNodeRegion1;
        localNodeRegion1 = localNodeRegion2;
      }
      while (localNodeRegion2.withinBounds(paramFloat1, paramFloat2));
    }
  }

  abstract int commandStartIndex();

  abstract int commandStopIndex(int paramInt);

  void debugDraw(Canvas paramCanvas)
  {
    DrawCommand[] arrayOfDrawCommand = this.mDrawCommands;
    int j = arrayOfDrawCommand.length;
    int i = 0;
    if (i < j)
    {
      DrawCommand localDrawCommand = arrayOfDrawCommand[i];
      if ((localDrawCommand instanceof DrawView))
        if (isNotClipped(((DrawView)localDrawCommand).reactTag))
          localDrawCommand.debugDraw(this.mFlatViewGroup, paramCanvas);
      while (true)
      {
        i += 1;
        break;
        localDrawCommand.debugDraw(this.mFlatViewGroup, paramCanvas);
      }
    }
  }

  public void draw(Canvas paramCanvas)
  {
    int i = this.mStart;
    int m = this.mFlatViewGroup.getChildCount();
    int k = 0;
    int j;
    while (true)
    {
      j = i;
      if (k >= m)
        break;
      int n = this.mDrawViewIndexMap.get(this.mFlatViewGroup.getChildAt(k).getId());
      if (this.mStop < n)
        while (true)
        {
          j = i;
          if (i >= this.mStop)
            break;
          this.mDrawCommands[i].draw(this.mFlatViewGroup, paramCanvas);
          i += 1;
        }
      j = i;
      if (i <= n)
      {
        while (i < n)
        {
          this.mDrawCommands[i].draw(this.mFlatViewGroup, paramCanvas);
          i += 1;
        }
        j = i + 1;
      }
      this.mDrawCommands[n].draw(this.mFlatViewGroup, paramCanvas);
      k += 1;
      i = j;
    }
    while (j < this.mStop)
    {
      Object localObject = this.mDrawCommands;
      i = j + 1;
      localObject = localObject[j];
      if ((localObject instanceof DrawView))
      {
        FLog.w(TAG, "Unexpected DrawView command at index " + (i - 1) + " with mStop=" + this.mStop + ". " + Arrays.toString(this.mDrawCommands));
        j = i;
        continue;
      }
      ((DrawCommand)localObject).draw(this.mFlatViewGroup, paramCanvas);
      j = i;
    }
  }

  public void getClippingRect(Rect paramRect)
  {
    paramRect.set(this.mClippingRect);
  }

  public SparseArray<View> getDetachedViews()
  {
    return this.mClippedSubviews;
  }

  public void mountDrawCommands(DrawCommand[] paramArrayOfDrawCommand, SparseIntArray paramSparseIntArray, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, boolean paramBoolean)
  {
    this.mDrawCommands = paramArrayOfDrawCommand;
    this.mCommandMaxBottom = paramArrayOfFloat1;
    this.mCommandMinTop = paramArrayOfFloat2;
    this.mDrawViewIndexMap = paramSparseIntArray;
    if (this.mClippingRect.bottom != this.mClippingRect.top)
    {
      this.mStart = commandStartIndex();
      this.mStop = commandStopIndex(this.mStart);
      if (!paramBoolean)
        updateClippingToCurrentRect();
    }
  }

  public void mountNodeRegions(NodeRegion[] paramArrayOfNodeRegion, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.mNodeRegions = paramArrayOfNodeRegion;
    this.mRegionMaxBottom = paramArrayOfFloat1;
    this.mRegionMinTop = paramArrayOfFloat2;
  }

  public void mountViews(ViewResolver paramViewResolver, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.mClippingViewGroups.clear();
    int n = paramArrayOfInt1.length;
    int i = 0;
    label35: int k;
    if (i < n)
    {
      int m = paramArrayOfInt1[i];
      DrawView localDrawView;
      View localView;
      if (m > 0)
      {
        j = 1;
        k = m;
        if (j == 0)
          k = -m;
        k = this.mDrawViewIndexMap.get(k);
        localDrawView = (DrawView)this.mDrawCommands[k];
        localView = paramViewResolver.getView(localDrawView.reactTag);
        ensureViewHasNoParent(localView);
        if (((localView instanceof ReactClippingViewGroup)) && (((ReactClippingViewGroup)localView).getRemoveClippedSubviews()))
          this.mClippingViewGroups.add((ReactClippingViewGroup)localView);
        if (j == 0)
          break label190;
        localDrawView.mWasMounted = true;
        if ((!animating(localView)) && (!withinBounds(k)))
          break label176;
        this.mFlatViewGroup.addViewInLayout(localView);
      }
      while (true)
      {
        i += 1;
        break;
        j = 0;
        break label35;
        label176: clip(localDrawView.reactTag, localView);
        continue;
        label190: if (localDrawView.mWasMounted)
        {
          if (!isNotClipped(localDrawView.reactTag))
            continue;
          this.mFlatViewGroup.attachViewToParent(localView);
          continue;
        }
        localDrawView.mWasMounted = true;
        if ((animating(localView)) || (withinBounds(k)))
        {
          if (isClipped(localDrawView.reactTag))
          {
            this.mFlatViewGroup.addViewInLayout(localView);
            unclip(localDrawView.reactTag);
            continue;
          }
          this.mFlatViewGroup.attachViewToParent(localView);
          continue;
        }
        if (!isNotClipped(localDrawView.reactTag))
          continue;
        this.mFlatViewGroup.removeDetachedView(localView);
        clip(localDrawView.reactTag, localView);
      }
    }
    int j = paramArrayOfInt2.length;
    i = 0;
    while (i < j)
    {
      k = paramArrayOfInt2[i];
      paramArrayOfInt1 = paramViewResolver.getView(k);
      if (paramArrayOfInt1.getParent() != null)
        throw new RuntimeException("Trying to remove view not owned by FlatViewGroup");
      this.mFlatViewGroup.removeDetachedView(paramArrayOfInt1);
      unclip(k);
      i += 1;
    }
  }

  void onClippedViewDropped(View paramView)
  {
    unclip(paramView.getId());
    this.mFlatViewGroup.removeDetachedView(paramView);
  }

  abstract boolean regionAboveTouch(int paramInt, float paramFloat1, float paramFloat2);

  abstract int regionStopIndex(float paramFloat1, float paramFloat2);

  public boolean updateClippingRect()
  {
    ReactClippingViewGroupHelper.calculateClippingRect(this.mFlatViewGroup, this.mClippingRect);
    if ((this.mFlatViewGroup.getParent() == null) || (this.mClippingRect.top == this.mClippingRect.bottom))
      return false;
    int i = commandStartIndex();
    int j = commandStopIndex(i);
    if ((this.mStart <= i) && (j <= this.mStop))
    {
      updateClippingRecursively();
      return false;
    }
    this.mStart = i;
    this.mStop = j;
    updateClippingToCurrentRect();
    updateClippingRecursively();
    return true;
  }

  @Nullable
  public NodeRegion virtualNodeRegionWithinBounds(float paramFloat1, float paramFloat2)
  {
    int i = regionStopIndex(paramFloat1, paramFloat2);
    while (true)
    {
      int j = i - 1;
      NodeRegion localNodeRegion2;
      NodeRegion localNodeRegion1;
      if (i > 0)
      {
        localNodeRegion2 = this.mNodeRegions[j];
        if (!localNodeRegion2.mIsVirtual)
        {
          i = j;
          continue;
        }
        if (!regionAboveTouch(j, paramFloat1, paramFloat2));
      }
      else
      {
        localNodeRegion1 = null;
      }
      do
      {
        return localNodeRegion1;
        localNodeRegion1 = localNodeRegion2;
      }
      while (localNodeRegion2.withinBounds(paramFloat1, paramFloat2));
      i = j;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.ClippingDrawCommandManager
 * JD-Core Version:    0.6.0
 */
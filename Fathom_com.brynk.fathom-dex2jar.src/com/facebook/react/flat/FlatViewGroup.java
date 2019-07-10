package com.facebook.react.flat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.touch.OnInterceptTouchEventListener;
import com.facebook.react.touch.ReactHitSlopView;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactCompoundViewGroup;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.image.ImageLoadEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.annotation.Nullable;

final class FlatViewGroup extends ViewGroup
  implements ReactInterceptingViewGroup, ReactClippingViewGroup, ReactCompoundViewGroup, ReactHitSlopView, ReactPointerEventsView, FlatMeasuredViewGroup
{
  private static final boolean DEBUG_DRAW = false;
  private static final boolean DEBUG_DRAW_TEXT = false;
  static final boolean DEBUG_HIGHLIGHT_PERFORMANCE_ISSUES = false;
  private static final SparseArray<View> EMPTY_DETACHED_VIEWS;
  private static final ArrayList<FlatViewGroup> LAYOUT_REQUESTS = new ArrayList();
  private static final Rect VIEW_BOUNDS = new Rect();
  private static Paint sDebugCornerPaint;
  private static Rect sDebugRect;
  private static Paint sDebugRectPaint;
  private static Paint sDebugTextBackgroundPaint;
  private static Paint sDebugTextPaint;
  private boolean mAndroidDebugDraw;
  private AttachDetachListener[] mAttachDetachListeners = AttachDetachListener.EMPTY_ARRAY;
  private int mDrawChildIndex = 0;

  @Nullable
  private DrawCommandManager mDrawCommandManager;
  private DrawCommand[] mDrawCommands = DrawCommand.EMPTY_ARRAY;

  @Nullable
  private Rect mHitSlopRect;
  private Drawable mHotspot;

  @Nullable
  private InvalidateCallback mInvalidateCallback;
  private boolean mIsAttached = false;
  private boolean mIsLayoutRequested = false;
  private long mLastTouchDownTime;
  private boolean mNeedsOffscreenAlphaCompositing = false;
  private NodeRegion[] mNodeRegions = NodeRegion.EMPTY_ARRAY;

  @Nullable
  private OnInterceptTouchEventListener mOnInterceptTouchEventListener;
  private PointerEvents mPointerEvents = PointerEvents.AUTO;

  static
  {
    EMPTY_DETACHED_VIEWS = new SparseArray(0);
  }

  FlatViewGroup(Context paramContext)
  {
    super(paramContext);
    setClipChildren(false);
  }

  @Nullable
  private NodeRegion anyNodeRegionWithinBounds(float paramFloat1, float paramFloat2)
  {
    Object localObject;
    if (this.mDrawCommandManager != null)
    {
      localObject = this.mDrawCommandManager.anyNodeRegionWithinBounds(paramFloat1, paramFloat2);
      return localObject;
    }
    int i = this.mNodeRegions.length - 1;
    while (true)
    {
      if (i < 0)
        break label62;
      NodeRegion localNodeRegion = this.mNodeRegions[i];
      localObject = localNodeRegion;
      if (localNodeRegion.withinBounds(paramFloat1, paramFloat2))
        break;
      i -= 1;
    }
    label62: return (NodeRegion)null;
  }

  private void debugDraw(Canvas paramCanvas)
  {
    if (this.mDrawCommandManager != null)
      this.mDrawCommandManager.debugDraw(paramCanvas);
    while (true)
    {
      this.mDrawChildIndex = 0;
      return;
      DrawCommand[] arrayOfDrawCommand = this.mDrawCommands;
      int j = arrayOfDrawCommand.length;
      int i = 0;
      while (i < j)
      {
        arrayOfDrawCommand[i].debugDraw(this, paramCanvas);
        i += 1;
      }
    }
  }

  private void debugDrawRect(Canvas paramCanvas, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    debugDrawNamedRect(paramCanvas, paramInt, "", paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  private void dispatchOnAttached(AttachDetachListener[] paramArrayOfAttachDetachListener)
  {
    if (paramArrayOfAttachDetachListener.length == 0);
    while (true)
    {
      return;
      InvalidateCallback localInvalidateCallback = getInvalidateCallback();
      int j = paramArrayOfAttachDetachListener.length;
      int i = 0;
      while (i < j)
      {
        paramArrayOfAttachDetachListener[i].onAttached(localInvalidateCallback);
        i += 1;
      }
    }
  }

  private static void dispatchOnDetached(AttachDetachListener[] paramArrayOfAttachDetachListener)
  {
    int j = paramArrayOfAttachDetachListener.length;
    int i = 0;
    while (i < j)
    {
      paramArrayOfAttachDetachListener[i].onDetached();
      i += 1;
    }
  }

  private static void drawCorner(Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    fillRect(paramCanvas, paramPaint, paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat2 + sign(paramFloat4) * paramFloat5);
    fillRect(paramCanvas, paramPaint, paramFloat1, paramFloat2, paramFloat1 + sign(paramFloat3) * paramFloat5, paramFloat2 + paramFloat4);
  }

  private static void drawRectCorners(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Paint paramPaint, int paramInt1, int paramInt2)
  {
    drawCorner(paramCanvas, paramPaint, paramFloat1, paramFloat2, paramInt1, paramInt1, paramInt2);
    drawCorner(paramCanvas, paramPaint, paramFloat1, paramFloat4, paramInt1, -paramInt1, paramInt2);
    drawCorner(paramCanvas, paramPaint, paramFloat3, paramFloat2, -paramInt1, paramInt1, paramInt2);
    drawCorner(paramCanvas, paramPaint, paramFloat3, paramFloat4, -paramInt1, -paramInt1, paramInt2);
  }

  private ViewGroup.LayoutParams ensureLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (checkLayoutParams(paramLayoutParams))
      return paramLayoutParams;
    return generateDefaultLayoutParams();
  }

  private static void ensureViewHasNoParent(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if (localViewParent != null)
      throw new RuntimeException("Cannot add view " + paramView + " to FlatViewGroup while it has a parent " + localViewParent);
  }

  private static void fillRect(Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramFloat1 != paramFloat3) && (paramFloat2 != paramFloat4))
    {
      float f2 = paramFloat1;
      float f1 = paramFloat3;
      if (paramFloat1 > paramFloat3)
      {
        f1 = paramFloat1;
        f2 = paramFloat3;
      }
      paramFloat3 = paramFloat2;
      paramFloat1 = paramFloat4;
      if (paramFloat2 > paramFloat4)
      {
        paramFloat1 = paramFloat2;
        paramFloat3 = paramFloat4;
      }
      paramCanvas.drawRect(f2, paramFloat3, f1, paramFloat1, paramPaint);
    }
  }

  private InvalidateCallback getInvalidateCallback()
  {
    if (this.mInvalidateCallback == null)
      this.mInvalidateCallback = new InvalidateCallback(this, null);
    return this.mInvalidateCallback;
  }

  private void initDebugDrawResources()
  {
    if (sDebugTextPaint == null)
    {
      sDebugTextPaint = new Paint();
      sDebugTextPaint.setTextAlign(Paint.Align.RIGHT);
      sDebugTextPaint.setTextSize(dipsToPixels(9));
      sDebugTextPaint.setTypeface(Typeface.MONOSPACE);
      sDebugTextPaint.setAntiAlias(true);
      sDebugTextPaint.setColor(-65536);
    }
    if (sDebugTextBackgroundPaint == null)
    {
      sDebugTextBackgroundPaint = new Paint();
      sDebugTextBackgroundPaint.setColor(-1);
      sDebugTextBackgroundPaint.setAlpha(200);
      sDebugTextBackgroundPaint.setStyle(Paint.Style.FILL);
    }
    if (sDebugRectPaint == null)
    {
      sDebugRectPaint = new Paint();
      sDebugRectPaint.setAlpha(100);
      sDebugRectPaint.setStyle(Paint.Style.STROKE);
    }
    if (sDebugCornerPaint == null)
    {
      sDebugCornerPaint = new Paint();
      sDebugCornerPaint.setAlpha(200);
      sDebugCornerPaint.setColor(Color.rgb(63, 127, 255));
      sDebugCornerPaint.setStyle(Paint.Style.FILL);
    }
    if (sDebugRect == null)
      sDebugRect = new Rect();
  }

  private void processLayoutRequest()
  {
    this.mIsLayoutRequested = false;
    int i = 0;
    int j = getChildCount();
    if (i != j)
    {
      View localView = getChildAt(i);
      if (!localView.isLayoutRequested());
      while (true)
      {
        i += 1;
        break;
        localView.measure(View.MeasureSpec.makeMeasureSpec(localView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(localView.getHeight(), 1073741824));
        localView.layout(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      }
    }
  }

  static void processLayoutRequests()
  {
    int i = 0;
    int j = LAYOUT_REQUESTS.size();
    while (i != j)
    {
      ((FlatViewGroup)LAYOUT_REQUESTS.get(i)).processLayoutRequest();
      i += 1;
    }
    LAYOUT_REQUESTS.clear();
  }

  private static int sign(float paramFloat)
  {
    if (paramFloat >= 0.0F)
      return 1;
    return -1;
  }

  @Nullable
  private NodeRegion virtualNodeRegionWithinBounds(float paramFloat1, float paramFloat2)
  {
    if (this.mDrawCommandManager != null)
      return this.mDrawCommandManager.virtualNodeRegionWithinBounds(paramFloat1, paramFloat2);
    int i = this.mNodeRegions.length - 1;
    if (i >= 0)
    {
      NodeRegion localNodeRegion = this.mNodeRegions[i];
      if (!localNodeRegion.mIsVirtual);
      do
      {
        i -= 1;
        break;
      }
      while (!localNodeRegion.withinBounds(paramFloat1, paramFloat2));
      return localNodeRegion;
    }
    return null;
  }

  void addViewInLayout(View paramView)
  {
    addViewInLayout(paramView, -1, ensureLayoutParams(paramView.getLayoutParams()), true);
  }

  void addViewInLayout(View paramView, int paramInt)
  {
    addViewInLayout(paramView, paramInt, ensureLayoutParams(paramView.getLayoutParams()), true);
  }

  void attachViewToParent(View paramView)
  {
    attachViewToParent(paramView, -1, ensureLayoutParams(paramView.getLayoutParams()));
  }

  void attachViewToParent(View paramView, int paramInt)
  {
    attachViewToParent(paramView, paramInt, ensureLayoutParams(paramView.getLayoutParams()));
  }

  void debugDrawNamedRect(Canvas paramCanvas, int paramInt, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    sDebugRectPaint.setColor(sDebugRectPaint.getColor() & 0xFF000000 | 0xFFFFFF & paramInt);
    sDebugRectPaint.setAlpha(100);
    paramCanvas.drawRect(paramFloat1, paramFloat2, paramFloat3 - 1.0F, paramFloat4 - 1.0F, sDebugRectPaint);
    drawRectCorners(paramCanvas, paramFloat1, paramFloat2, paramFloat3, paramFloat4, sDebugCornerPaint, dipsToPixels(8), dipsToPixels(1));
  }

  void debugDrawNextChild(Canvas paramCanvas)
  {
    View localView = getChildAt(this.mDrawChildIndex);
    if ((localView instanceof FlatViewGroup));
    for (int i = -12303292; ; i = -65536)
    {
      debugDrawRect(paramCanvas, i, localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      this.mDrawChildIndex += 1;
      return;
    }
  }

  protected void detachAllViewsFromParent()
  {
    super.detachAllViewsFromParent();
  }

  int dipsToPixels(int paramInt)
  {
    float f = getResources().getDisplayMetrics().density;
    return (int)(paramInt * f + 0.5F);
  }

  public void dispatchDraw(Canvas paramCanvas)
  {
    this.mAndroidDebugDraw = false;
    super.dispatchDraw(paramCanvas);
    if (this.mDrawCommandManager != null)
      this.mDrawCommandManager.draw(paramCanvas);
    while (this.mDrawChildIndex != getChildCount())
    {
      throw new RuntimeException("Did not draw all children: " + this.mDrawChildIndex + " / " + getChildCount());
      DrawCommand[] arrayOfDrawCommand = this.mDrawCommands;
      int j = arrayOfDrawCommand.length;
      int i = 0;
      while (i < j)
      {
        arrayOfDrawCommand[i].draw(this, paramCanvas);
        i += 1;
      }
    }
    this.mDrawChildIndex = 0;
    if (this.mAndroidDebugDraw)
    {
      initDebugDrawResources();
      debugDraw(paramCanvas);
    }
    if (this.mHotspot != null)
      this.mHotspot.draw(paramCanvas);
  }

  public void dispatchDrawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    if (this.mHotspot != null)
    {
      this.mHotspot.setHotspot(paramFloat1, paramFloat2);
      invalidate();
    }
  }

  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return false;
  }

  void drawNextChild(Canvas paramCanvas)
  {
    View localView = getChildAt(this.mDrawChildIndex);
    if ((localView instanceof FlatViewGroup))
      super.drawChild(paramCanvas, localView, getDrawingTime());
    while (true)
    {
      this.mDrawChildIndex += 1;
      return;
      paramCanvas.save(2);
      localView.getHitRect(VIEW_BOUNDS);
      paramCanvas.clipRect(VIEW_BOUNDS);
      super.drawChild(paramCanvas, localView, getDrawingTime());
      paramCanvas.restore();
    }
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.mHotspot != null) && (this.mHotspot.isStateful()))
      this.mHotspot.setState(getDrawableState());
  }

  public void getClippingRect(Rect paramRect)
  {
    if (this.mDrawCommandManager == null)
      throw new RuntimeException("Trying to get the clipping rect for a non-clipping FlatViewGroup");
    this.mDrawCommandManager.getClippingRect(paramRect);
  }

  SparseArray<View> getDetachedViews()
  {
    if (this.mDrawCommandManager == null)
      return EMPTY_DETACHED_VIEWS;
    return this.mDrawCommandManager.getDetachedViews();
  }

  @Nullable
  public Rect getHitSlopRect()
  {
    return this.mHitSlopRect;
  }

  NodeRegion getNodeRegionForTag(int paramInt)
  {
    NodeRegion[] arrayOfNodeRegion = this.mNodeRegions;
    int j = arrayOfNodeRegion.length;
    int i = 0;
    while (i < j)
    {
      NodeRegion localNodeRegion = arrayOfNodeRegion[i];
      if (localNodeRegion.matchesTag(paramInt))
        return localNodeRegion;
      i += 1;
    }
    return NodeRegion.EMPTY;
  }

  public PointerEvents getPointerEvents()
  {
    return this.mPointerEvents;
  }

  public boolean getRemoveClippedSubviews()
  {
    return this.mDrawCommandManager != null;
  }

  public boolean hasOverlappingRendering()
  {
    return this.mNeedsOffscreenAlphaCompositing;
  }

  public boolean interceptsTouchEvent(float paramFloat1, float paramFloat2)
  {
    NodeRegion localNodeRegion = anyNodeRegionWithinBounds(paramFloat1, paramFloat2);
    return (localNodeRegion != null) && (localNodeRegion.mIsVirtual);
  }

  public void invalidate()
  {
    invalidate(0, 0, getWidth() + 1, getHeight() + 1);
  }

  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.mHotspot != null)
      this.mHotspot.jumpToCurrentState();
  }

  public Rect measureWithCommands()
  {
    int i1 = getChildCount();
    if ((i1 == 0) && (this.mDrawCommands.length == 0))
      return new Rect(0, 0, 0, 0);
    int j = 2147483647;
    int m = 2147483647;
    int k = -2147483648;
    int i = -2147483648;
    int n = 0;
    while (n < i1)
    {
      localObject = getChildAt(n);
      j = Math.min(j, ((View)localObject).getLeft());
      m = Math.min(m, ((View)localObject).getTop());
      k = Math.max(k, ((View)localObject).getRight());
      i = Math.max(i, ((View)localObject).getBottom());
      n += 1;
    }
    Object localObject = this.mDrawCommands;
    i1 = localObject.length;
    n = 0;
    if (n < i1)
    {
      AbstractDrawCommand localAbstractDrawCommand = localObject[n];
      if (!(localAbstractDrawCommand instanceof AbstractDrawCommand));
      while (true)
      {
        n += 1;
        break;
        localAbstractDrawCommand = (AbstractDrawCommand)localAbstractDrawCommand;
        j = Math.min(j, Math.round(localAbstractDrawCommand.getLeft()));
        m = Math.min(m, Math.round(localAbstractDrawCommand.getTop()));
        k = Math.max(k, Math.round(localAbstractDrawCommand.getRight()));
        i = Math.max(i, Math.round(localAbstractDrawCommand.getBottom()));
      }
    }
    return (Rect)new Rect(j, m, k, i);
  }

  void mountAttachDetachListeners(AttachDetachListener[] paramArrayOfAttachDetachListener)
  {
    if (this.mIsAttached)
    {
      dispatchOnAttached(paramArrayOfAttachDetachListener);
      dispatchOnDetached(this.mAttachDetachListeners);
    }
    this.mAttachDetachListeners = paramArrayOfAttachDetachListener;
  }

  void mountClippingDrawCommands(DrawCommand[] paramArrayOfDrawCommand, SparseIntArray paramSparseIntArray, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, boolean paramBoolean)
  {
    ((DrawCommandManager)Assertions.assertNotNull(this.mDrawCommandManager)).mountDrawCommands(paramArrayOfDrawCommand, paramSparseIntArray, paramArrayOfFloat1, paramArrayOfFloat2, paramBoolean);
    invalidate();
  }

  void mountClippingNodeRegions(NodeRegion[] paramArrayOfNodeRegion, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.mNodeRegions = paramArrayOfNodeRegion;
    ((DrawCommandManager)Assertions.assertNotNull(this.mDrawCommandManager)).mountNodeRegions(paramArrayOfNodeRegion, paramArrayOfFloat1, paramArrayOfFloat2);
  }

  void mountDrawCommands(DrawCommand[] paramArrayOfDrawCommand)
  {
    this.mDrawCommands = paramArrayOfDrawCommand;
    invalidate();
  }

  void mountNodeRegions(NodeRegion[] paramArrayOfNodeRegion)
  {
    this.mNodeRegions = paramArrayOfNodeRegion;
  }

  void mountViews(ViewResolver paramViewResolver, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (this.mDrawCommandManager != null)
      this.mDrawCommandManager.mountViews(paramViewResolver, paramArrayOfInt1, paramArrayOfInt2);
    while (true)
    {
      invalidate();
      return;
      int j = paramArrayOfInt1.length;
      int i = 0;
      if (i < j)
      {
        int k = paramArrayOfInt1[i];
        View localView;
        if (k > 0)
        {
          localView = paramViewResolver.getView(k);
          ensureViewHasNoParent(localView);
          addViewInLayout(localView);
        }
        while (true)
        {
          i += 1;
          break;
          localView = paramViewResolver.getView(-k);
          ensureViewHasNoParent(localView);
          attachViewToParent(localView);
        }
      }
      j = paramArrayOfInt2.length;
      i = 0;
      while (i < j)
      {
        paramArrayOfInt1 = paramViewResolver.getView(paramArrayOfInt2[i]);
        if (paramArrayOfInt1.getParent() != null)
          throw new RuntimeException("Trying to remove view not owned by FlatViewGroup");
        removeDetachedView(paramArrayOfInt1, false);
        i += 1;
      }
    }
  }

  protected void onAttachedToWindow()
  {
    if (this.mIsAttached)
      return;
    this.mIsAttached = true;
    super.onAttachedToWindow();
    dispatchOnAttached(this.mAttachDetachListeners);
    updateClippingRect();
  }

  protected void onDebugDraw(Canvas paramCanvas)
  {
    this.mAndroidDebugDraw = true;
  }

  protected void onDetachedFromWindow()
  {
    if (!this.mIsAttached)
      throw new RuntimeException("Double detach");
    this.mIsAttached = false;
    super.onDetachedFromWindow();
    dispatchOnDetached(this.mAttachDetachListeners);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    long l = paramMotionEvent.getDownTime();
    if (l != this.mLastTouchDownTime)
    {
      this.mLastTouchDownTime = l;
      if (!interceptsTouchEvent(paramMotionEvent.getX(), paramMotionEvent.getY()));
    }
    do
      return true;
    while (((this.mOnInterceptTouchEventListener != null) && (this.mOnInterceptTouchEventListener.onInterceptTouchEvent(this, paramMotionEvent))) || (this.mPointerEvents == PointerEvents.NONE) || (this.mPointerEvents == PointerEvents.BOX_ONLY));
    return super.onInterceptTouchEvent(paramMotionEvent);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mHotspot != null)
    {
      this.mHotspot.setBounds(0, 0, paramInt1, paramInt2);
      invalidate();
    }
    updateClippingRect();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mPointerEvents == PointerEvents.NONE);
    do
      return false;
    while ((this.mPointerEvents == PointerEvents.BOX_NONE) && (virtualNodeRegionWithinBounds(paramMotionEvent.getX(), paramMotionEvent.getY()) == null));
    return true;
  }

  void onViewDropped(View paramView)
  {
    if (this.mDrawCommandManager != null)
      this.mDrawCommandManager.onClippedViewDropped(paramView);
  }

  public int reactTagForTouch(float paramFloat1, float paramFloat2)
  {
    if (this.mPointerEvents != PointerEvents.NONE);
    for (boolean bool = true; ; bool = false)
    {
      SoftAssertions.assertCondition(bool, "TouchTargetHelper should not allow calling this method when pointer events are NONE");
      if (this.mPointerEvents == PointerEvents.BOX_ONLY)
        break;
      NodeRegion localNodeRegion = virtualNodeRegionWithinBounds(paramFloat1, paramFloat2);
      if (localNodeRegion == null)
        break;
      return localNodeRegion.getReactTag(paramFloat1, paramFloat2);
    }
    return getId();
  }

  public void removeAllViewsInLayout()
  {
    this.mDrawCommands = DrawCommand.EMPTY_ARRAY;
    super.removeAllViewsInLayout();
  }

  void removeDetachedView(View paramView)
  {
    removeDetachedView(paramView, false);
  }

  @SuppressLint({"MissingSuperCall"})
  public void requestLayout()
  {
    if (this.mIsLayoutRequested)
      return;
    this.mIsLayoutRequested = true;
    LAYOUT_REQUESTS.add(this);
  }

  void setHitSlopRect(@Nullable Rect paramRect)
  {
    this.mHitSlopRect = paramRect;
  }

  void setHotspot(Drawable paramDrawable)
  {
    if (this.mHotspot != null)
    {
      this.mHotspot.setCallback(null);
      unscheduleDrawable(this.mHotspot);
    }
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful())
        paramDrawable.setState(getDrawableState());
    }
    this.mHotspot = paramDrawable;
    invalidate();
  }

  void setNeedsOffscreenAlphaCompositing(boolean paramBoolean)
  {
    this.mNeedsOffscreenAlphaCompositing = paramBoolean;
  }

  public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener paramOnInterceptTouchEventListener)
  {
    this.mOnInterceptTouchEventListener = paramOnInterceptTouchEventListener;
  }

  void setPointerEvents(PointerEvents paramPointerEvents)
  {
    this.mPointerEvents = paramPointerEvents;
  }

  public void setRemoveClippedSubviews(boolean paramBoolean)
  {
    boolean bool = getRemoveClippedSubviews();
    if (paramBoolean == bool)
      return;
    if (bool)
      throw new RuntimeException("Trying to transition FlatViewGroup from clipping to non-clipping state");
    this.mDrawCommandManager = DrawCommandManager.getVerticalClippingInstance(this, this.mDrawCommands);
    this.mDrawCommands = DrawCommand.EMPTY_ARRAY;
  }

  public void updateClippingRect()
  {
    if (this.mDrawCommandManager == null);
    do
      return;
    while (!this.mDrawCommandManager.updateClippingRect());
    invalidate();
  }

  @SuppressLint({"MissingSuperCall"})
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return true;
  }

  static final class InvalidateCallback extends WeakReference<FlatViewGroup>
  {
    private InvalidateCallback(FlatViewGroup paramFlatViewGroup)
    {
      super();
    }

    public void dispatchImageLoadEvent(int paramInt1, int paramInt2)
    {
      FlatViewGroup localFlatViewGroup = (FlatViewGroup)get();
      if (localFlatViewGroup == null)
        return;
      ((UIManagerModule)((ReactContext)localFlatViewGroup.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ImageLoadEvent(paramInt1, paramInt2));
    }

    public void invalidate()
    {
      FlatViewGroup localFlatViewGroup = (FlatViewGroup)get();
      if (localFlatViewGroup != null)
        localFlatViewGroup.invalidate();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.FlatViewGroup
 * JD-Core Version:    0.6.0
 */
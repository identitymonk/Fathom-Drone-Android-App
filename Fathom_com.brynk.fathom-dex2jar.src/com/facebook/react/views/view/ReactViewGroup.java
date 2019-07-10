package com.facebook.react.views.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.touch.OnInterceptTouchEventListener;
import com.facebook.react.touch.ReactHitSlopView;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ReactZIndexedViewGroup;
import com.facebook.react.uimanager.ViewGroupDrawingOrderHelper;
import com.facebook.yoga.YogaConstants;
import javax.annotation.Nullable;

public class ReactViewGroup extends ViewGroup
  implements ReactInterceptingViewGroup, ReactClippingViewGroup, ReactPointerEventsView, ReactHitSlopView, ReactZIndexedViewGroup
{
  private static final int ARRAY_CAPACITY_INCREMENT = 12;
  private static final int DEFAULT_BACKGROUND_COLOR = 0;
  private static final ViewGroup.LayoutParams sDefaultLayoutParam = new ViewGroup.LayoutParams(0, 0);
  private static final Rect sHelperRect = new Rect();

  @Nullable
  private View[] mAllChildren = null;
  private int mAllChildrenCount;

  @Nullable
  private ChildrenLayoutChangeListener mChildrenLayoutChangeListener;

  @Nullable
  private Rect mClippingRect;
  private final ViewGroupDrawingOrderHelper mDrawingOrderHelper = new ViewGroupDrawingOrderHelper(this);

  @Nullable
  private Rect mHitSlopRect;
  private boolean mNeedsOffscreenAlphaCompositing = false;

  @Nullable
  private OnInterceptTouchEventListener mOnInterceptTouchEventListener;

  @Nullable
  private String mOverflow;

  @Nullable
  private Path mPath;
  private PointerEvents mPointerEvents = PointerEvents.AUTO;

  @Nullable
  private ReactViewBackgroundDrawable mReactBackgroundDrawable;
  private boolean mRemoveClippedSubviews = false;

  public ReactViewGroup(Context paramContext)
  {
    super(paramContext);
  }

  private void addInArray(View paramView, int paramInt)
  {
    View[] arrayOfView1 = (View[])Assertions.assertNotNull(this.mAllChildren);
    int i = this.mAllChildrenCount;
    int j = arrayOfView1.length;
    if (paramInt == i)
    {
      View[] arrayOfView2 = arrayOfView1;
      if (j == i)
      {
        this.mAllChildren = new View[j + 12];
        System.arraycopy(arrayOfView1, 0, this.mAllChildren, 0, j);
        arrayOfView2 = this.mAllChildren;
      }
      paramInt = this.mAllChildrenCount;
      this.mAllChildrenCount = (paramInt + 1);
      arrayOfView2[paramInt] = paramView;
      return;
    }
    if (paramInt < i)
    {
      if (j == i)
      {
        this.mAllChildren = new View[j + 12];
        System.arraycopy(arrayOfView1, 0, this.mAllChildren, 0, paramInt);
        System.arraycopy(arrayOfView1, paramInt, this.mAllChildren, paramInt + 1, i - paramInt);
        arrayOfView1 = this.mAllChildren;
      }
      while (true)
      {
        arrayOfView1[paramInt] = paramView;
        this.mAllChildrenCount += 1;
        return;
        System.arraycopy(arrayOfView1, paramInt, arrayOfView1, paramInt + 1, i - paramInt);
      }
    }
    throw new IndexOutOfBoundsException("index=" + paramInt + " count=" + i);
  }

  private ReactViewBackgroundDrawable getOrCreateReactViewBackground()
  {
    Drawable localDrawable;
    if (this.mReactBackgroundDrawable == null)
    {
      this.mReactBackgroundDrawable = new ReactViewBackgroundDrawable();
      localDrawable = getBackground();
      updateBackgroundDrawable(null);
      if (localDrawable != null)
        break label45;
      updateBackgroundDrawable(this.mReactBackgroundDrawable);
    }
    while (true)
    {
      return this.mReactBackgroundDrawable;
      label45: updateBackgroundDrawable(new LayerDrawable(new Drawable[] { this.mReactBackgroundDrawable, localDrawable }));
    }
  }

  private int indexOfChildInAllChildren(View paramView)
  {
    int j = this.mAllChildrenCount;
    View[] arrayOfView = (View[])Assertions.assertNotNull(this.mAllChildren);
    int i = 0;
    while (i < j)
    {
      if (arrayOfView[i] == paramView)
        return i;
      i += 1;
    }
    return -1;
  }

  private void removeFromArray(int paramInt)
  {
    View[] arrayOfView = (View[])Assertions.assertNotNull(this.mAllChildren);
    int i = this.mAllChildrenCount;
    if (paramInt == i - 1)
    {
      paramInt = this.mAllChildrenCount - 1;
      this.mAllChildrenCount = paramInt;
      arrayOfView[paramInt] = null;
      return;
    }
    if ((paramInt >= 0) && (paramInt < i))
    {
      System.arraycopy(arrayOfView, paramInt + 1, arrayOfView, paramInt, i - paramInt - 1);
      paramInt = this.mAllChildrenCount - 1;
      this.mAllChildrenCount = paramInt;
      arrayOfView[paramInt] = null;
      return;
    }
    throw new IndexOutOfBoundsException();
  }

  private void updateBackgroundDrawable(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.setBackground(paramDrawable);
      return;
    }
    super.setBackgroundDrawable(paramDrawable);
  }

  private void updateClippingToRect(Rect paramRect)
  {
    Assertions.assertNotNull(this.mAllChildren);
    int j = 0;
    int i = 0;
    while (i < this.mAllChildrenCount)
    {
      updateSubviewClipStatus(paramRect, i, j);
      int k = j;
      if (this.mAllChildren[i].getParent() == null)
        k = j + 1;
      i += 1;
      j = k;
    }
  }

  private void updateSubviewClipStatus(Rect paramRect, int paramInt1, int paramInt2)
  {
    View localView = ((View[])Assertions.assertNotNull(this.mAllChildren))[paramInt1];
    sHelperRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
    boolean bool = paramRect.intersects(sHelperRect.left, sHelperRect.top, sHelperRect.right, sHelperRect.bottom);
    int j = 0;
    paramRect = localView.getAnimation();
    int i;
    if ((paramRect != null) && (!paramRect.hasEnded()))
    {
      i = 1;
      if ((bool) || (localView.getParent() == null) || (i != 0))
        break label161;
      super.removeViewsInLayout(paramInt1 - paramInt2, 1);
      paramInt1 = 1;
    }
    while (true)
    {
      if ((paramInt1 != 0) && ((localView instanceof ReactClippingViewGroup)))
      {
        paramRect = (ReactClippingViewGroup)localView;
        if (paramRect.getRemoveClippedSubviews())
          paramRect.updateClippingRect();
      }
      return;
      i = 0;
      break;
      label161: if ((bool) && (localView.getParent() == null))
      {
        super.addViewInLayout(localView, paramInt1 - paramInt2, sDefaultLayoutParam, true);
        invalidate();
        paramInt1 = 1;
        continue;
      }
      paramInt1 = j;
      if (!bool)
        continue;
      paramInt1 = 1;
    }
  }

  private void updateSubviewClipStatus(View paramView)
  {
    if ((!this.mRemoveClippedSubviews) || (getParent() == null));
    label140: label170: 
    while (true)
    {
      return;
      Assertions.assertNotNull(this.mClippingRect);
      Assertions.assertNotNull(this.mAllChildren);
      sHelperRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      boolean bool2 = this.mClippingRect.intersects(sHelperRect.left, sHelperRect.top, sHelperRect.right, sHelperRect.bottom);
      boolean bool1;
      label96: int j;
      int i;
      if (paramView.getParent() != null)
      {
        bool1 = true;
        if (bool2 == bool1)
          break label140;
        j = 0;
        i = 0;
      }
      while (true)
      {
        if (i >= this.mAllChildrenCount)
          break label170;
        if (this.mAllChildren[i] == paramView)
        {
          updateSubviewClipStatus(this.mClippingRect, i, j);
          return;
          bool1 = false;
          break label96;
          break;
        }
        int k = j;
        if (this.mAllChildren[i].getParent() == null)
          k = j + 1;
        i += 1;
        j = k;
      }
    }
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.mDrawingOrderHelper.handleAddView(paramView);
    setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
    super.addView(paramView, paramInt, paramLayoutParams);
  }

  void addViewWithSubviewClippingEnabled(View paramView, int paramInt)
  {
    addViewWithSubviewClippingEnabled(paramView, paramInt, sDefaultLayoutParam);
  }

  void addViewWithSubviewClippingEnabled(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    Assertions.assertCondition(this.mRemoveClippedSubviews);
    Assertions.assertNotNull(this.mClippingRect);
    Assertions.assertNotNull(this.mAllChildren);
    addInArray(paramView, paramInt);
    int j = 0;
    int i = 0;
    while (i < paramInt)
    {
      int k = j;
      if (this.mAllChildren[i].getParent() == null)
        k = j + 1;
      i += 1;
      j = k;
    }
    updateSubviewClipStatus(this.mClippingRect, paramInt, j);
    paramView.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    String str;
    int i;
    if (this.mOverflow != null)
    {
      str = this.mOverflow;
      i = -1;
      switch (str.hashCode())
      {
      default:
        switch (i)
        {
        default:
        case 0:
        case 1:
        }
      case 466743410:
      case -1217487446:
      }
    }
    while (true)
    {
      super.dispatchDraw(paramCanvas);
      return;
      if (!str.equals("visible"))
        break;
      i = 0;
      break;
      if (!str.equals("hidden"))
        break;
      i = 1;
      break;
      if (this.mPath == null)
        continue;
      this.mPath.rewind();
      continue;
      if (this.mReactBackgroundDrawable == null)
        continue;
      float f4 = 0.0F;
      float f2 = 0.0F;
      float f6 = getWidth();
      float f5 = getHeight();
      float f3 = f5;
      float f1 = f6;
      if (this.mReactBackgroundDrawable.getFullBorderWidth() != 0.0F)
      {
        f3 = this.mReactBackgroundDrawable.getFullBorderWidth();
        f4 = 0.0F + f3;
        f2 = 0.0F + f3;
        f1 = f6 - f3;
        f3 = f5 - f3;
      }
      f5 = this.mReactBackgroundDrawable.getRadius();
      if ((YogaConstants.isUndefined(f5)) || (f5 <= 0.5F))
        continue;
      if (this.mPath == null)
        this.mPath = new Path();
      this.mPath.rewind();
      this.mPath.addRoundRect(new RectF(f4, f2, f1, f3), f5, f5, Path.Direction.CW);
      paramCanvas.clipPath(this.mPath);
    }
  }

  protected void dispatchSetPressed(boolean paramBoolean)
  {
  }

  int getAllChildrenCount()
  {
    return this.mAllChildrenCount;
  }

  @VisibleForTesting
  public int getBackgroundColor()
  {
    if (getBackground() != null)
      return ((ReactViewBackgroundDrawable)getBackground()).getColor();
    return 0;
  }

  View getChildAtWithSubviewClippingEnabled(int paramInt)
  {
    return ((View[])Assertions.assertNotNull(this.mAllChildren))[paramInt];
  }

  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    return this.mDrawingOrderHelper.getChildDrawingOrder(paramInt1, paramInt2);
  }

  public void getClippingRect(Rect paramRect)
  {
    paramRect.set(this.mClippingRect);
  }

  @Nullable
  public Rect getHitSlopRect()
  {
    return this.mHitSlopRect;
  }

  public PointerEvents getPointerEvents()
  {
    return this.mPointerEvents;
  }

  public boolean getRemoveClippedSubviews()
  {
    return this.mRemoveClippedSubviews;
  }

  public int getZIndexMappedChildIndex(int paramInt)
  {
    int i = paramInt;
    if (this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder())
      i = this.mDrawingOrderHelper.getChildDrawingOrder(getChildCount(), paramInt);
    return i;
  }

  public boolean hasOverlappingRendering()
  {
    return this.mNeedsOffscreenAlphaCompositing;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mRemoveClippedSubviews)
      updateClippingRect();
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mOnInterceptTouchEventListener != null) && (this.mOnInterceptTouchEventListener.onInterceptTouchEvent(this, paramMotionEvent)));
    do
      return true;
    while ((this.mPointerEvents == PointerEvents.NONE) || (this.mPointerEvents == PointerEvents.BOX_ONLY));
    return super.onInterceptTouchEvent(paramMotionEvent);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    MeasureSpecAssertions.assertExplicitMeasureSpec(paramInt1, paramInt2);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mRemoveClippedSubviews)
      updateClippingRect();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.mPointerEvents != PointerEvents.NONE) && (this.mPointerEvents != PointerEvents.BOX_NONE);
  }

  void removeAllViewsWithSubviewClippingEnabled()
  {
    Assertions.assertCondition(this.mRemoveClippedSubviews);
    Assertions.assertNotNull(this.mAllChildren);
    int i = 0;
    while (i < this.mAllChildrenCount)
    {
      this.mAllChildren[i].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
      i += 1;
    }
    removeAllViewsInLayout();
    this.mAllChildrenCount = 0;
  }

  public void removeView(View paramView)
  {
    this.mDrawingOrderHelper.handleRemoveView(paramView);
    setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
    super.removeView(paramView);
  }

  public void removeViewAt(int paramInt)
  {
    this.mDrawingOrderHelper.handleRemoveView(getChildAt(paramInt));
    setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
    super.removeViewAt(paramInt);
  }

  void removeViewWithSubviewClippingEnabled(View paramView)
  {
    Assertions.assertCondition(this.mRemoveClippedSubviews);
    Assertions.assertNotNull(this.mClippingRect);
    Assertions.assertNotNull(this.mAllChildren);
    paramView.removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
    int m = indexOfChildInAllChildren(paramView);
    if (this.mAllChildren[m].getParent() != null)
    {
      int j = 0;
      int i = 0;
      while (i < m)
      {
        int k = j;
        if (this.mAllChildren[i].getParent() == null)
          k = j + 1;
        i += 1;
        j = k;
      }
      super.removeViewsInLayout(m - j, 1);
    }
    removeFromArray(m);
  }

  public void requestLayout()
  {
  }

  public void setBackground(Drawable paramDrawable)
  {
    throw new UnsupportedOperationException("This method is not supported for ReactViewGroup instances");
  }

  public void setBackgroundColor(int paramInt)
  {
    if ((paramInt == 0) && (this.mReactBackgroundDrawable == null))
      return;
    getOrCreateReactViewBackground().setColor(paramInt);
  }

  public void setBorderColor(int paramInt, float paramFloat1, float paramFloat2)
  {
    getOrCreateReactViewBackground().setBorderColor(paramInt, paramFloat1, paramFloat2);
  }

  public void setBorderRadius(float paramFloat)
  {
    getOrCreateReactViewBackground().setRadius(paramFloat);
  }

  public void setBorderRadius(float paramFloat, int paramInt)
  {
    getOrCreateReactViewBackground().setRadius(paramFloat, paramInt);
  }

  public void setBorderStyle(@Nullable String paramString)
  {
    getOrCreateReactViewBackground().setBorderStyle(paramString);
  }

  public void setBorderWidth(int paramInt, float paramFloat)
  {
    getOrCreateReactViewBackground().setBorderWidth(paramInt, paramFloat);
  }

  public void setHitSlopRect(@Nullable Rect paramRect)
  {
    this.mHitSlopRect = paramRect;
  }

  public void setNeedsOffscreenAlphaCompositing(boolean paramBoolean)
  {
    this.mNeedsOffscreenAlphaCompositing = paramBoolean;
  }

  public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener paramOnInterceptTouchEventListener)
  {
    this.mOnInterceptTouchEventListener = paramOnInterceptTouchEventListener;
  }

  public void setOverflow(String paramString)
  {
    this.mOverflow = paramString;
    invalidate();
  }

  void setPointerEvents(PointerEvents paramPointerEvents)
  {
    this.mPointerEvents = paramPointerEvents;
  }

  public void setRemoveClippedSubviews(boolean paramBoolean)
  {
    if (paramBoolean == this.mRemoveClippedSubviews)
      return;
    this.mRemoveClippedSubviews = paramBoolean;
    if (paramBoolean)
    {
      this.mClippingRect = new Rect();
      ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
      this.mAllChildrenCount = getChildCount();
      this.mAllChildren = new View[Math.max(12, this.mAllChildrenCount)];
      this.mChildrenLayoutChangeListener = new ChildrenLayoutChangeListener(this, null);
      i = 0;
      while (i < this.mAllChildrenCount)
      {
        View localView = getChildAt(i);
        this.mAllChildren[i] = localView;
        localView.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        i += 1;
      }
      updateClippingRect();
      return;
    }
    Assertions.assertNotNull(this.mClippingRect);
    Assertions.assertNotNull(this.mAllChildren);
    Assertions.assertNotNull(this.mChildrenLayoutChangeListener);
    int i = 0;
    while (i < this.mAllChildrenCount)
    {
      this.mAllChildren[i].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
      i += 1;
    }
    getDrawingRect(this.mClippingRect);
    updateClippingToRect(this.mClippingRect);
    this.mAllChildren = null;
    this.mClippingRect = null;
    this.mAllChildrenCount = 0;
    this.mChildrenLayoutChangeListener = null;
  }

  public void setTranslucentBackgroundDrawable(@Nullable Drawable paramDrawable)
  {
    updateBackgroundDrawable(null);
    if ((this.mReactBackgroundDrawable != null) && (paramDrawable != null))
      updateBackgroundDrawable(new LayerDrawable(new Drawable[] { this.mReactBackgroundDrawable, paramDrawable }));
    do
      return;
    while (paramDrawable == null);
    updateBackgroundDrawable(paramDrawable);
  }

  public void updateClippingRect()
  {
    if (!this.mRemoveClippedSubviews)
      return;
    Assertions.assertNotNull(this.mClippingRect);
    Assertions.assertNotNull(this.mAllChildren);
    ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
    updateClippingToRect(this.mClippingRect);
  }

  public void updateDrawingOrder()
  {
    this.mDrawingOrderHelper.update();
    setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
    invalidate();
  }

  private static final class ChildrenLayoutChangeListener
    implements View.OnLayoutChangeListener
  {
    private final ReactViewGroup mParent;

    private ChildrenLayoutChangeListener(ReactViewGroup paramReactViewGroup)
    {
      this.mParent = paramReactViewGroup;
    }

    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      if (this.mParent.getRemoveClippedSubviews())
        this.mParent.updateSubviewClipStatus(paramView);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.view.ReactViewGroup
 * JD-Core Version:    0.6.0
 */
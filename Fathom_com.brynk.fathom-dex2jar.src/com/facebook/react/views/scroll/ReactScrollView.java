package com.facebook.react.views.scroll;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import java.lang.reflect.Field;
import javax.annotation.Nullable;

public class ReactScrollView extends ScrollView
  implements ReactClippingViewGroup, ViewGroup.OnHierarchyChangeListener, View.OnLayoutChangeListener
{
  private static Field sScrollerField;
  private static boolean sTriedToGetScrollerField = false;

  @Nullable
  private Rect mClippingRect;
  private View mContentView;
  private boolean mDoneFlinging;
  private boolean mDragging;

  @Nullable
  private Drawable mEndBackground;
  private int mEndFillColor = 0;
  private boolean mFlinging;

  @Nullable
  private FpsListener mFpsListener = null;
  private final OnScrollDispatchHelper mOnScrollDispatchHelper = new OnScrollDispatchHelper();
  private ReactViewBackgroundManager mReactBackgroundManager;
  private boolean mRemoveClippedSubviews;
  private boolean mScrollEnabled = true;

  @Nullable
  private String mScrollPerfTag;
  private final OverScroller mScroller;
  private boolean mSendMomentumEvents;
  private final VelocityHelper mVelocityHelper = new VelocityHelper();

  public ReactScrollView(ReactContext paramReactContext)
  {
    this(paramReactContext, null);
  }

  public ReactScrollView(ReactContext paramReactContext, @Nullable FpsListener paramFpsListener)
  {
    super(paramReactContext);
    this.mFpsListener = paramFpsListener;
    this.mReactBackgroundManager = new ReactViewBackgroundManager(this);
    if (!sTriedToGetScrollerField)
      sTriedToGetScrollerField = true;
    while (true)
    {
      try
      {
        sScrollerField = ScrollView.class.getDeclaredField("mScroller");
        sScrollerField.setAccessible(true);
        if (sScrollerField == null);
      }
      catch (java.lang.NoSuchFieldException paramReactContext)
      {
        try
        {
          paramReactContext = sScrollerField.get(this);
          if (!(paramReactContext instanceof OverScroller))
            continue;
          this.mScroller = ((OverScroller)paramReactContext);
          setOnHierarchyChangeListener(this);
          setScrollBarStyle(33554432);
          return;
          paramReactContext = paramReactContext;
          Log.w("ReactNative", "Failed to get mScroller field for ScrollView! This app will exhibit the bounce-back scrolling bug :(");
          continue;
          Log.w("ReactNative", "Failed to cast mScroller field in ScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
          this.mScroller = null;
          continue;
        }
        catch (java.lang.IllegalAccessException paramReactContext)
        {
          throw new RuntimeException("Failed to get mScroller from ScrollView!", paramReactContext);
        }
      }
      this.mScroller = null;
    }
  }

  private void disableFpsListener()
  {
    if (isScrollPerfLoggingEnabled())
    {
      Assertions.assertNotNull(this.mFpsListener);
      Assertions.assertNotNull(this.mScrollPerfTag);
      this.mFpsListener.disable(this.mScrollPerfTag);
    }
  }

  private void enableFpsListener()
  {
    if (isScrollPerfLoggingEnabled())
    {
      Assertions.assertNotNull(this.mFpsListener);
      Assertions.assertNotNull(this.mScrollPerfTag);
      this.mFpsListener.enable(this.mScrollPerfTag);
    }
  }

  private int getMaxScrollY()
  {
    return Math.max(0, this.mContentView.getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
  }

  private boolean isScrollPerfLoggingEnabled()
  {
    return (this.mFpsListener != null) && (this.mScrollPerfTag != null) && (!this.mScrollPerfTag.isEmpty());
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.mEndFillColor != 0)
    {
      View localView = getChildAt(0);
      if ((this.mEndBackground != null) && (localView != null) && (localView.getBottom() < getHeight()))
      {
        this.mEndBackground.setBounds(0, localView.getBottom(), getWidth(), getHeight());
        this.mEndBackground.draw(paramCanvas);
      }
    }
    super.draw(paramCanvas);
  }

  public void flashScrollIndicators()
  {
    awakenScrollBars();
  }

  public void fling(int paramInt)
  {
    if (this.mScroller != null)
    {
      int i = getHeight();
      int j = getPaddingBottom();
      int k = getPaddingTop();
      this.mScroller.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, 0, 2147483647, 0, (i - j - k) / 2);
      postInvalidateOnAnimation();
    }
    while (true)
    {
      if ((this.mSendMomentumEvents) || (isScrollPerfLoggingEnabled()))
      {
        this.mFlinging = true;
        enableFpsListener();
        ReactScrollViewHelper.emitScrollMomentumBeginEvent(this);
        postOnAnimationDelayed(new Runnable()
        {
          public void run()
          {
            if (ReactScrollView.this.mDoneFlinging)
            {
              ReactScrollView.access$102(ReactScrollView.this, false);
              ReactScrollView.this.disableFpsListener();
              ReactScrollViewHelper.emitScrollMomentumEndEvent(ReactScrollView.this);
              return;
            }
            ReactScrollView.access$002(ReactScrollView.this, true);
            ReactScrollView.this.postOnAnimationDelayed(this, 20L);
          }
        }
        , 20L);
      }
      return;
      super.fling(paramInt);
    }
  }

  public void getClippingRect(Rect paramRect)
  {
    paramRect.set((Rect)Assertions.assertNotNull(this.mClippingRect));
  }

  public boolean getRemoveClippedSubviews()
  {
    return this.mRemoveClippedSubviews;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mRemoveClippedSubviews)
      updateClippingRect();
  }

  public void onChildViewAdded(View paramView1, View paramView2)
  {
    this.mContentView = paramView2;
    this.mContentView.addOnLayoutChangeListener(this);
  }

  public void onChildViewRemoved(View paramView1, View paramView2)
  {
    this.mContentView.removeOnLayoutChangeListener(this);
    this.mContentView = null;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mScrollEnabled);
    do
      return false;
    while (!super.onInterceptTouchEvent(paramMotionEvent));
    NativeGestureUtil.notifyNativeGestureStarted(this, paramMotionEvent);
    ReactScrollViewHelper.emitScrollBeginDragEvent(this);
    this.mDragging = true;
    enableFpsListener();
    return true;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    scrollTo(getScrollX(), getScrollY());
  }

  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.mContentView == null);
    do
    {
      return;
      paramInt1 = getScrollY();
      paramInt2 = getMaxScrollY();
    }
    while (paramInt1 <= paramInt2);
    scrollTo(getScrollX(), paramInt2);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    MeasureSpecAssertions.assertExplicitMeasureSpec(paramInt1, paramInt2);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }

  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramInt2;
    if (this.mScroller != null)
    {
      i = paramInt2;
      if (!this.mScroller.isFinished())
      {
        i = paramInt2;
        if (this.mScroller.getCurrY() != this.mScroller.getFinalY())
        {
          int j = getMaxScrollY();
          i = paramInt2;
          if (paramInt2 >= j)
          {
            this.mScroller.abortAnimation();
            i = j;
          }
        }
      }
    }
    super.onOverScrolled(paramInt1, i, paramBoolean1, paramBoolean2);
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mOnScrollDispatchHelper.onScrollChanged(paramInt1, paramInt2))
    {
      if (this.mRemoveClippedSubviews)
        updateClippingRect();
      if (this.mFlinging)
        this.mDoneFlinging = false;
      ReactScrollViewHelper.emitScrollEvent(this, this.mOnScrollDispatchHelper.getXFlingVelocity(), this.mOnScrollDispatchHelper.getYFlingVelocity());
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mRemoveClippedSubviews)
      updateClippingRect();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mScrollEnabled)
      return false;
    this.mVelocityHelper.calculateVelocity(paramMotionEvent);
    if (((paramMotionEvent.getAction() & 0xFF) == 1) && (this.mDragging))
    {
      ReactScrollViewHelper.emitScrollEndDragEvent(this, this.mVelocityHelper.getXVelocity(), this.mVelocityHelper.getYVelocity());
      this.mDragging = false;
      disableFpsListener();
    }
    return super.onTouchEvent(paramMotionEvent);
  }

  public void setBackgroundColor(int paramInt)
  {
    this.mReactBackgroundManager.setBackgroundColor(paramInt);
  }

  public void setBorderColor(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.mReactBackgroundManager.setBorderColor(paramInt, paramFloat1, paramFloat2);
  }

  public void setBorderRadius(float paramFloat)
  {
    this.mReactBackgroundManager.setBorderRadius(paramFloat);
  }

  public void setBorderRadius(float paramFloat, int paramInt)
  {
    this.mReactBackgroundManager.setBorderRadius(paramFloat, paramInt);
  }

  public void setBorderStyle(@Nullable String paramString)
  {
    this.mReactBackgroundManager.setBorderStyle(paramString);
  }

  public void setBorderWidth(int paramInt, float paramFloat)
  {
    this.mReactBackgroundManager.setBorderWidth(paramInt, paramFloat);
  }

  public void setEndFillColor(int paramInt)
  {
    if (paramInt != this.mEndFillColor)
    {
      this.mEndFillColor = paramInt;
      this.mEndBackground = new ColorDrawable(this.mEndFillColor);
    }
  }

  public void setRemoveClippedSubviews(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mClippingRect == null))
      this.mClippingRect = new Rect();
    this.mRemoveClippedSubviews = paramBoolean;
    updateClippingRect();
  }

  public void setScrollEnabled(boolean paramBoolean)
  {
    this.mScrollEnabled = paramBoolean;
  }

  public void setScrollPerfTag(String paramString)
  {
    this.mScrollPerfTag = paramString;
  }

  public void setSendMomentumEvents(boolean paramBoolean)
  {
    this.mSendMomentumEvents = paramBoolean;
  }

  public void updateClippingRect()
  {
    if (!this.mRemoveClippedSubviews);
    View localView;
    do
    {
      return;
      Assertions.assertNotNull(this.mClippingRect);
      ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
      localView = getChildAt(0);
    }
    while (!(localView instanceof View.OnLayoutChangeListener));
    ((View.OnLayoutChangeListener)localView).updateClippingRect();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.ReactScrollView
 * JD-Core Version:    0.6.0
 */
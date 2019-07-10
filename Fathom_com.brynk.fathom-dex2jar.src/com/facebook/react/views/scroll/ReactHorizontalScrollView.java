package com.facebook.react.views.scroll;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.HorizontalScrollView;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import javax.annotation.Nullable;

public class ReactHorizontalScrollView extends HorizontalScrollView
  implements ReactClippingViewGroup
{
  private boolean mActivelyScrolling;

  @Nullable
  private Rect mClippingRect;
  private boolean mDragging;

  @Nullable
  private Drawable mEndBackground;
  private int mEndFillColor = 0;

  @Nullable
  private FpsListener mFpsListener = null;
  private final OnScrollDispatchHelper mOnScrollDispatchHelper = new OnScrollDispatchHelper();
  private boolean mPagingEnabled = false;

  @Nullable
  private Runnable mPostTouchRunnable;
  private ReactViewBackgroundManager mReactBackgroundManager = new ReactViewBackgroundManager(this);
  private boolean mRemoveClippedSubviews;
  private boolean mScrollEnabled = true;

  @Nullable
  private String mScrollPerfTag;
  private boolean mSendMomentumEvents;
  private final VelocityHelper mVelocityHelper = new VelocityHelper();

  public ReactHorizontalScrollView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ReactHorizontalScrollView(Context paramContext, @Nullable FpsListener paramFpsListener)
  {
    super(paramContext);
    this.mFpsListener = paramFpsListener;
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

  @TargetApi(16)
  private void handlePostTouchScrolling()
  {
    if ((!this.mSendMomentumEvents) && (!this.mPagingEnabled) && (!isScrollPerfLoggingEnabled()));
    do
      return;
    while (this.mPostTouchRunnable != null);
    if (this.mSendMomentumEvents)
      ReactScrollViewHelper.emitScrollMomentumBeginEvent(this);
    this.mActivelyScrolling = false;
    this.mPostTouchRunnable = new Runnable()
    {
      private boolean mSnappingToPage = false;

      public void run()
      {
        if (ReactHorizontalScrollView.this.mActivelyScrolling)
        {
          ReactHorizontalScrollView.access$002(ReactHorizontalScrollView.this, false);
          ReactHorizontalScrollView.this.postOnAnimationDelayed(this, 20L);
          return;
        }
        if ((ReactHorizontalScrollView.this.mPagingEnabled) && (!this.mSnappingToPage))
        {
          this.mSnappingToPage = true;
          ReactHorizontalScrollView.this.smoothScrollToPage(0);
          ReactHorizontalScrollView.this.postOnAnimationDelayed(this, 20L);
          return;
        }
        if (ReactHorizontalScrollView.this.mSendMomentumEvents)
          ReactScrollViewHelper.emitScrollMomentumEndEvent(ReactHorizontalScrollView.this);
        ReactHorizontalScrollView.access$402(ReactHorizontalScrollView.this, null);
        ReactHorizontalScrollView.this.disableFpsListener();
      }
    };
    postOnAnimationDelayed(this.mPostTouchRunnable, 20L);
  }

  private boolean isScrollPerfLoggingEnabled()
  {
    return (this.mFpsListener != null) && (this.mScrollPerfTag != null) && (!this.mScrollPerfTag.isEmpty());
  }

  private void smoothScrollToPage(int paramInt)
  {
    int k = getWidth();
    int m = getScrollX();
    int j = m / k;
    int i = j;
    if (m + paramInt > j * k + k / 2)
      i = j + 1;
    smoothScrollTo(i * k, getScrollY());
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.mEndFillColor != 0)
    {
      View localView = getChildAt(0);
      if ((this.mEndBackground != null) && (localView != null) && (localView.getRight() < getWidth()))
      {
        this.mEndBackground.setBounds(localView.getRight(), 0, getWidth(), getHeight());
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
    if (this.mPagingEnabled)
      smoothScrollToPage(paramInt);
    while (true)
    {
      handlePostTouchScrolling();
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

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    MeasureSpecAssertions.assertExplicitMeasureSpec(paramInt1, paramInt2);
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mActivelyScrolling = true;
    if (this.mOnScrollDispatchHelper.onScrollChanged(paramInt1, paramInt2))
    {
      if (this.mRemoveClippedSubviews)
        updateClippingRect();
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
      handlePostTouchScrolling();
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

  public void setPagingEnabled(boolean paramBoolean)
  {
    this.mPagingEnabled = paramBoolean;
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

  public void setScrollPerfTag(@Nullable String paramString)
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
    while (!(localView instanceof ReactClippingViewGroup));
    ((ReactClippingViewGroup)localView).updateClippingRect();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.ReactHorizontalScrollView
 * JD-Core Version:    0.6.0
 */
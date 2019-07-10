package com.facebook.react.views.swiperefresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.NativeGestureUtil;

public class ReactSwipeRefreshLayout extends SwipeRefreshLayout
{
  private static final float DEFAULT_CIRCLE_TARGET = 64.0F;
  private boolean mDidLayout = false;
  private boolean mIntercepted;
  private float mPrevTouchX;
  private float mProgressViewOffset = 0.0F;
  private boolean mRefreshing = false;
  private int mTouchSlop;

  public ReactSwipeRefreshLayout(ReactContext paramReactContext)
  {
    super(paramReactContext);
    this.mTouchSlop = ViewConfiguration.get(paramReactContext).getScaledTouchSlop();
  }

  private boolean shouldInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 1:
    default:
    case 0:
    case 2:
    }
    float f;
    do
    {
      while (true)
      {
        return true;
        this.mPrevTouchX = paramMotionEvent.getX();
        this.mIntercepted = false;
      }
      f = Math.abs(paramMotionEvent.getX() - this.mPrevTouchX);
    }
    while ((!this.mIntercepted) && (f <= this.mTouchSlop));
    this.mIntercepted = true;
    return false;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((shouldInterceptTouchEvent(paramMotionEvent)) && (super.onInterceptTouchEvent(paramMotionEvent)))
    {
      NativeGestureUtil.notifyNativeGestureStarted(this, paramMotionEvent);
      return true;
    }
    return false;
  }

  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.mDidLayout)
    {
      this.mDidLayout = true;
      setProgressViewOffset(this.mProgressViewOffset);
      setRefreshing(this.mRefreshing);
    }
  }

  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (getParent() != null)
      getParent().requestDisallowInterceptTouchEvent(paramBoolean);
  }

  public void setProgressViewOffset(float paramFloat)
  {
    this.mProgressViewOffset = paramFloat;
    if (this.mDidLayout)
    {
      int i = getProgressCircleDiameter();
      setProgressViewOffset(false, Math.round(PixelUtil.toPixelFromDIP(paramFloat)) - i, Math.round(PixelUtil.toPixelFromDIP(64.0F + paramFloat) - i));
    }
  }

  public void setRefreshing(boolean paramBoolean)
  {
    this.mRefreshing = paramBoolean;
    if (this.mDidLayout)
      super.setRefreshing(paramBoolean);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.swiperefresh.ReactSwipeRefreshLayout
 * JD-Core Version:    0.6.0
 */
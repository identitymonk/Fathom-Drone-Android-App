package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V>
{
  private static final int INVALID_POINTER = -1;
  private int mActivePointerId = -1;
  private Runnable mFlingRunnable;
  private boolean mIsBeingDragged;
  private int mLastMotionY;
  private ScrollerCompat mScroller;
  private int mTouchSlop = -1;
  private VelocityTracker mVelocityTracker;

  public HeaderBehavior()
  {
  }

  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void ensureVelocityTracker()
  {
    if (this.mVelocityTracker == null)
      this.mVelocityTracker = VelocityTracker.obtain();
  }

  boolean canDragView(V paramV)
  {
    return false;
  }

  final boolean fling(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, float paramFloat)
  {
    if (this.mFlingRunnable != null)
    {
      paramV.removeCallbacks(this.mFlingRunnable);
      this.mFlingRunnable = null;
    }
    if (this.mScroller == null)
      this.mScroller = ScrollerCompat.create(paramV.getContext());
    this.mScroller.fling(0, getTopAndBottomOffset(), 0, Math.round(paramFloat), 0, 0, paramInt1, paramInt2);
    if (this.mScroller.computeScrollOffset())
    {
      this.mFlingRunnable = new FlingRunnable(paramCoordinatorLayout, paramV);
      ViewCompat.postOnAnimation(paramV, this.mFlingRunnable);
      return true;
    }
    onFlingFinished(paramCoordinatorLayout, paramV);
    return false;
  }

  int getMaxDragOffset(V paramV)
  {
    return -paramV.getHeight();
  }

  int getScrollRangeForDragFling(V paramV)
  {
    return paramV.getHeight();
  }

  int getTopBottomOffsetForScrollingSibling()
  {
    return getTopAndBottomOffset();
  }

  void onFlingFinished(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
  }

  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.mTouchSlop < 0)
      this.mTouchSlop = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    if ((paramMotionEvent.getAction() == 2) && (this.mIsBeingDragged))
      return true;
    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
    {
    default:
    case 0:
    case 2:
    case 1:
    case 3:
    }
    while (true)
    {
      if (this.mVelocityTracker != null)
        this.mVelocityTracker.addMovement(paramMotionEvent);
      return this.mIsBeingDragged;
      this.mIsBeingDragged = false;
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((!canDragView(paramV)) || (!paramCoordinatorLayout.isPointInChildBounds(paramV, i, j)))
        continue;
      this.mLastMotionY = j;
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      ensureVelocityTracker();
      continue;
      i = this.mActivePointerId;
      if (i == -1)
        continue;
      i = MotionEventCompat.findPointerIndex(paramMotionEvent, i);
      if (i == -1)
        continue;
      i = (int)MotionEventCompat.getY(paramMotionEvent, i);
      if (Math.abs(i - this.mLastMotionY) <= this.mTouchSlop)
        continue;
      this.mIsBeingDragged = true;
      this.mLastMotionY = i;
      continue;
      this.mIsBeingDragged = false;
      this.mActivePointerId = -1;
      if (this.mVelocityTracker == null)
        continue;
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }

  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.mTouchSlop < 0)
      this.mTouchSlop = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
    {
    default:
    case 0:
    case 2:
    case 1:
    case 3:
    }
    while (true)
    {
      if (this.mVelocityTracker != null)
        this.mVelocityTracker.addMovement(paramMotionEvent);
      return true;
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((paramCoordinatorLayout.isPointInChildBounds(paramV, i, j)) && (canDragView(paramV)))
      {
        this.mLastMotionY = j;
        this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        ensureVelocityTracker();
        continue;
      }
      return false;
      i = MotionEventCompat.findPointerIndex(paramMotionEvent, this.mActivePointerId);
      if (i == -1)
        return false;
      int k = (int)MotionEventCompat.getY(paramMotionEvent, i);
      j = this.mLastMotionY - k;
      i = j;
      if (!this.mIsBeingDragged)
      {
        i = j;
        if (Math.abs(j) > this.mTouchSlop)
        {
          this.mIsBeingDragged = true;
          if (j <= 0)
            break label244;
        }
      }
      label244: for (i = j - this.mTouchSlop; this.mIsBeingDragged; i = j + this.mTouchSlop)
      {
        this.mLastMotionY = k;
        scroll(paramCoordinatorLayout, paramV, i, getMaxDragOffset(paramV), 0);
        break;
      }
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.addMovement(paramMotionEvent);
        this.mVelocityTracker.computeCurrentVelocity(1000);
        float f = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
        fling(paramCoordinatorLayout, paramV, -getScrollRangeForDragFling(paramV), 0, f);
      }
      this.mIsBeingDragged = false;
      this.mActivePointerId = -1;
      if (this.mVelocityTracker == null)
        continue;
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }

  final int scroll(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    return setHeaderTopBottomOffset(paramCoordinatorLayout, paramV, getTopBottomOffsetForScrollingSibling() - paramInt1, paramInt2, paramInt3);
  }

  int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return setHeaderTopBottomOffset(paramCoordinatorLayout, paramV, paramInt, -2147483648, 2147483647);
  }

  int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = getTopAndBottomOffset();
    int j = 0;
    int i = j;
    if (paramInt2 != 0)
    {
      i = j;
      if (k >= paramInt2)
      {
        i = j;
        if (k <= paramInt3)
        {
          paramInt1 = MathUtils.constrain(paramInt1, paramInt2, paramInt3);
          i = j;
          if (k != paramInt1)
          {
            setTopAndBottomOffset(paramInt1);
            i = k - paramInt1;
          }
        }
      }
    }
    return i;
  }

  private class FlingRunnable
    implements Runnable
  {
    private final V mLayout;
    private final CoordinatorLayout mParent;

    FlingRunnable(V arg2)
    {
      Object localObject1;
      this.mParent = localObject1;
      Object localObject2;
      this.mLayout = localObject2;
    }

    public void run()
    {
      if ((this.mLayout != null) && (HeaderBehavior.this.mScroller != null))
      {
        if (HeaderBehavior.this.mScroller.computeScrollOffset())
        {
          HeaderBehavior.this.setHeaderTopBottomOffset(this.mParent, this.mLayout, HeaderBehavior.this.mScroller.getCurrY());
          ViewCompat.postOnAnimation(this.mLayout, this);
        }
      }
      else
        return;
      HeaderBehavior.this.onFlingFinished(this.mParent, this.mLayout);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.HeaderBehavior
 * JD-Core Version:    0.6.0
 */
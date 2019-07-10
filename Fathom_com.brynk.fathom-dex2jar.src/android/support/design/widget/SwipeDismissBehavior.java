package android.support.design.widget;

import android.support.annotation.NonNull;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V>
{
  private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5F;
  private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0F;
  private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5F;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  public static final int SWIPE_DIRECTION_ANY = 2;
  public static final int SWIPE_DIRECTION_END_TO_START = 1;
  public static final int SWIPE_DIRECTION_START_TO_END = 0;
  private float mAlphaEndSwipeDistance = 0.5F;
  private float mAlphaStartSwipeDistance = 0.0F;
  private final ViewDragHelper.Callback mDragCallback = new ViewDragHelper.Callback()
  {
    private static final int INVALID_POINTER_ID = -1;
    private int mActivePointerId = -1;
    private int mOriginalCapturedViewLeft;

    private boolean shouldDismiss(View paramView, float paramFloat)
    {
      int i;
      if (paramFloat != 0.0F)
        if (ViewCompat.getLayoutDirection(paramView) == 1)
        {
          i = 1;
          if (SwipeDismissBehavior.this.mSwipeDirection != 2)
            break label34;
        }
      label34: label56: label64: label87: int j;
      int k;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                i = 0;
                break;
                if (SwipeDismissBehavior.this.mSwipeDirection != 0)
                  break label64;
                if (i == 0)
                  break label56;
              }
              while (paramFloat < 0.0F);
              return false;
            }
            while (paramFloat > 0.0F);
            return false;
            if (SwipeDismissBehavior.this.mSwipeDirection != 1)
              break label138;
            if (i == 0)
              break label87;
          }
          while (paramFloat > 0.0F);
          return false;
        }
        while (paramFloat < 0.0F);
        return false;
        i = paramView.getLeft();
        j = this.mOriginalCapturedViewLeft;
        k = Math.round(paramView.getWidth() * SwipeDismissBehavior.this.mDragDismissThreshold);
      }
      while (Math.abs(i - j) >= k);
      return false;
      label138: return false;
    }

    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      int i;
      if (ViewCompat.getLayoutDirection(paramView) == 1)
      {
        paramInt2 = 1;
        if (SwipeDismissBehavior.this.mSwipeDirection != 0)
          break label72;
        if (paramInt2 == 0)
          break label53;
        i = this.mOriginalCapturedViewLeft - paramView.getWidth();
        paramInt2 = this.mOriginalCapturedViewLeft;
      }
      while (true)
      {
        return SwipeDismissBehavior.access$400(i, paramInt1, paramInt2);
        paramInt2 = 0;
        break;
        label53: i = this.mOriginalCapturedViewLeft;
        paramInt2 = this.mOriginalCapturedViewLeft + paramView.getWidth();
        continue;
        label72: if (SwipeDismissBehavior.this.mSwipeDirection == 1)
        {
          if (paramInt2 != 0)
          {
            i = this.mOriginalCapturedViewLeft;
            paramInt2 = this.mOriginalCapturedViewLeft + paramView.getWidth();
            continue;
          }
          i = this.mOriginalCapturedViewLeft - paramView.getWidth();
          paramInt2 = this.mOriginalCapturedViewLeft;
          continue;
        }
        i = this.mOriginalCapturedViewLeft - paramView.getWidth();
        paramInt2 = this.mOriginalCapturedViewLeft + paramView.getWidth();
      }
    }

    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getTop();
    }

    public int getViewHorizontalDragRange(View paramView)
    {
      return paramView.getWidth();
    }

    public void onViewCaptured(View paramView, int paramInt)
    {
      this.mActivePointerId = paramInt;
      this.mOriginalCapturedViewLeft = paramView.getLeft();
      paramView = paramView.getParent();
      if (paramView != null)
        paramView.requestDisallowInterceptTouchEvent(true);
    }

    public void onViewDragStateChanged(int paramInt)
    {
      if (SwipeDismissBehavior.this.mListener != null)
        SwipeDismissBehavior.this.mListener.onDragStateChanged(paramInt);
    }

    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      float f1 = this.mOriginalCapturedViewLeft + paramView.getWidth() * SwipeDismissBehavior.this.mAlphaStartSwipeDistance;
      float f2 = this.mOriginalCapturedViewLeft + paramView.getWidth() * SwipeDismissBehavior.this.mAlphaEndSwipeDistance;
      if (paramInt1 <= f1)
      {
        ViewCompat.setAlpha(paramView, 1.0F);
        return;
      }
      if (paramInt1 >= f2)
      {
        ViewCompat.setAlpha(paramView, 0.0F);
        return;
      }
      ViewCompat.setAlpha(paramView, SwipeDismissBehavior.access$700(0.0F, 1.0F - SwipeDismissBehavior.fraction(f1, f2, paramInt1), 1.0F));
    }

    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      this.mActivePointerId = -1;
      int i = paramView.getWidth();
      boolean bool = false;
      if (shouldDismiss(paramView, paramFloat1))
        if (paramView.getLeft() < this.mOriginalCapturedViewLeft)
        {
          i = this.mOriginalCapturedViewLeft - i;
          bool = true;
          label46: if (!SwipeDismissBehavior.this.mViewDragHelper.settleCapturedViewAt(i, paramView.getTop()))
            break label105;
          ViewCompat.postOnAnimation(paramView, new SwipeDismissBehavior.SettleRunnable(SwipeDismissBehavior.this, paramView, bool));
        }
      label105: 
      do
      {
        return;
        i = this.mOriginalCapturedViewLeft + i;
        break;
        i = this.mOriginalCapturedViewLeft;
        break label46;
      }
      while ((!bool) || (SwipeDismissBehavior.this.mListener == null));
      SwipeDismissBehavior.this.mListener.onDismiss(paramView);
    }

    public boolean tryCaptureView(View paramView, int paramInt)
    {
      return (this.mActivePointerId == -1) && (SwipeDismissBehavior.this.canSwipeDismissView(paramView));
    }
  };
  private float mDragDismissThreshold = 0.5F;
  private boolean mIgnoreEvents;
  private OnDismissListener mListener;
  private float mSensitivity = 0.0F;
  private boolean mSensitivitySet;
  private int mSwipeDirection = 2;
  private ViewDragHelper mViewDragHelper;

  private static float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.min(Math.max(paramFloat1, paramFloat2), paramFloat3);
  }

  private static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }

  private void ensureViewDragHelper(ViewGroup paramViewGroup)
  {
    if (this.mViewDragHelper == null)
      if (!this.mSensitivitySet)
        break label33;
    label33: for (paramViewGroup = ViewDragHelper.create(paramViewGroup, this.mSensitivity, this.mDragCallback); ; paramViewGroup = ViewDragHelper.create(paramViewGroup, this.mDragCallback))
    {
      this.mViewDragHelper = paramViewGroup;
      return;
    }
  }

  static float fraction(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }

  public boolean canSwipeDismissView(@NonNull View paramView)
  {
    return true;
  }

  public int getDragState()
  {
    if (this.mViewDragHelper != null)
      return this.mViewDragHelper.getViewDragState();
    return 0;
  }

  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
    {
    case 2:
    default:
      if (paramCoordinatorLayout.isPointInChildBounds(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
        break;
    case 1:
    case 3:
    }
    for (boolean bool = true; ; bool = false)
    {
      this.mIgnoreEvents = bool;
      do
      {
        if (!this.mIgnoreEvents)
          break;
        return false;
      }
      while (!this.mIgnoreEvents);
      this.mIgnoreEvents = false;
      return false;
    }
    ensureViewDragHelper(paramCoordinatorLayout);
    return this.mViewDragHelper.shouldInterceptTouchEvent(paramMotionEvent);
  }

  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.mViewDragHelper != null)
    {
      this.mViewDragHelper.processTouchEvent(paramMotionEvent);
      return true;
    }
    return false;
  }

  public void setDragDismissDistance(float paramFloat)
  {
    this.mDragDismissThreshold = clamp(0.0F, paramFloat, 1.0F);
  }

  public void setEndAlphaSwipeDistance(float paramFloat)
  {
    this.mAlphaEndSwipeDistance = clamp(0.0F, paramFloat, 1.0F);
  }

  public void setListener(OnDismissListener paramOnDismissListener)
  {
    this.mListener = paramOnDismissListener;
  }

  public void setSensitivity(float paramFloat)
  {
    this.mSensitivity = paramFloat;
    this.mSensitivitySet = true;
  }

  public void setStartAlphaSwipeDistance(float paramFloat)
  {
    this.mAlphaStartSwipeDistance = clamp(0.0F, paramFloat, 1.0F);
  }

  public void setSwipeDirection(int paramInt)
  {
    this.mSwipeDirection = paramInt;
  }

  public static abstract interface OnDismissListener
  {
    public abstract void onDismiss(View paramView);

    public abstract void onDragStateChanged(int paramInt);
  }

  private class SettleRunnable
    implements Runnable
  {
    private final boolean mDismiss;
    private final View mView;

    SettleRunnable(View paramBoolean, boolean arg3)
    {
      this.mView = paramBoolean;
      boolean bool;
      this.mDismiss = bool;
    }

    public void run()
    {
      if ((SwipeDismissBehavior.this.mViewDragHelper != null) && (SwipeDismissBehavior.this.mViewDragHelper.continueSettling(true)))
        ViewCompat.postOnAnimation(this.mView, this);
      do
        return;
      while ((!this.mDismiss) || (SwipeDismissBehavior.this.mListener == null));
      SwipeDismissBehavior.this.mListener.onDismiss(this.mView);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.SwipeDismissBehavior
 * JD-Core Version:    0.6.0
 */
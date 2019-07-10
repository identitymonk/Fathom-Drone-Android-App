package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.design.R.styleable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V>
{
  private static final float HIDE_FRICTION = 0.1F;
  private static final float HIDE_THRESHOLD = 0.5F;
  public static final int STATE_COLLAPSED = 4;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_EXPANDED = 3;
  public static final int STATE_HIDDEN = 5;
  public static final int STATE_SETTLING = 2;
  private int mActivePointerId;
  private BottomSheetCallback mCallback;
  private final ViewDragHelper.Callback mDragCallback = new ViewDragHelper.Callback()
  {
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getLeft();
    }

    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      int i = BottomSheetBehavior.this.mMinOffset;
      if (BottomSheetBehavior.this.mHideable);
      for (paramInt2 = BottomSheetBehavior.this.mParentHeight; ; paramInt2 = BottomSheetBehavior.this.mMaxOffset)
        return MathUtils.constrain(paramInt1, i, paramInt2);
    }

    public int getViewVerticalDragRange(View paramView)
    {
      if (BottomSheetBehavior.this.mHideable)
        return BottomSheetBehavior.this.mParentHeight - BottomSheetBehavior.this.mMinOffset;
      return BottomSheetBehavior.this.mMaxOffset - BottomSheetBehavior.this.mMinOffset;
    }

    public void onViewDragStateChanged(int paramInt)
    {
      if (paramInt == 1)
        BottomSheetBehavior.this.setStateInternal(1);
    }

    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      BottomSheetBehavior.this.dispatchOnSlide(paramInt2);
    }

    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      int j;
      int i;
      if (paramFloat2 < 0.0F)
      {
        j = BottomSheetBehavior.this.mMinOffset;
        i = 3;
      }
      while (BottomSheetBehavior.this.mViewDragHelper.settleCapturedViewAt(paramView.getLeft(), j))
      {
        BottomSheetBehavior.this.setStateInternal(2);
        ViewCompat.postOnAnimation(paramView, new BottomSheetBehavior.SettleRunnable(BottomSheetBehavior.this, paramView, i));
        return;
        if ((BottomSheetBehavior.this.mHideable) && (BottomSheetBehavior.this.shouldHide(paramView, paramFloat2)))
        {
          j = BottomSheetBehavior.this.mParentHeight;
          i = 5;
          continue;
        }
        if (paramFloat2 == 0.0F)
        {
          i = paramView.getTop();
          if (Math.abs(i - BottomSheetBehavior.this.mMinOffset) < Math.abs(i - BottomSheetBehavior.this.mMaxOffset))
          {
            j = BottomSheetBehavior.this.mMinOffset;
            i = 3;
            continue;
          }
          j = BottomSheetBehavior.this.mMaxOffset;
          i = 4;
          continue;
        }
        j = BottomSheetBehavior.this.mMaxOffset;
        i = 4;
      }
      BottomSheetBehavior.this.setStateInternal(i);
    }

    public boolean tryCaptureView(View paramView, int paramInt)
    {
      int i = 1;
      if (BottomSheetBehavior.this.mState == 1);
      View localView;
      do
      {
        do
          return false;
        while (BottomSheetBehavior.this.mTouchingScrollingChild);
        if ((BottomSheetBehavior.this.mState != 3) || (BottomSheetBehavior.this.mActivePointerId != paramInt))
          break;
        localView = (View)BottomSheetBehavior.this.mNestedScrollingChildRef.get();
      }
      while ((localView != null) && (ViewCompat.canScrollVertically(localView, -1)));
      if ((BottomSheetBehavior.this.mViewRef != null) && (BottomSheetBehavior.this.mViewRef.get() == paramView));
      while (true)
      {
        return i;
        i = 0;
      }
    }
  };
  private boolean mHideable;
  private boolean mIgnoreEvents;
  private int mInitialY;
  private int mLastNestedScrollDy;
  private int mMaxOffset;
  private float mMaximumVelocity;
  private int mMinOffset;
  private boolean mNestedScrolled;
  private WeakReference<View> mNestedScrollingChildRef;
  private int mParentHeight;
  private int mPeekHeight;
  private int mState = 4;
  private boolean mTouchingScrollingChild;
  private VelocityTracker mVelocityTracker;
  private ViewDragHelper mViewDragHelper;
  private WeakReference<V> mViewRef;

  public BottomSheetBehavior()
  {
  }

  public BottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.BottomSheetBehavior_Params);
    setPeekHeight(paramAttributeSet.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Params_behavior_peekHeight, 0));
    setHideable(paramAttributeSet.getBoolean(R.styleable.BottomSheetBehavior_Params_behavior_hideable, false));
    paramAttributeSet.recycle();
    this.mMaximumVelocity = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
  }

  private void dispatchOnSlide(int paramInt)
  {
    View localView = (View)this.mViewRef.get();
    if ((localView != null) && (this.mCallback != null))
    {
      if (paramInt > this.mMaxOffset)
        this.mCallback.onSlide(localView, (this.mMaxOffset - paramInt) / this.mPeekHeight);
    }
    else
      return;
    this.mCallback.onSlide(localView, (this.mMaxOffset - paramInt) / (this.mMaxOffset - this.mMinOffset));
  }

  private View findScrollingChild(View paramView)
  {
    if ((paramView instanceof NestedScrollingChild))
      return paramView;
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      int j = paramView.getChildCount();
      while (i < j)
      {
        View localView = findScrollingChild(paramView.getChildAt(i));
        if (localView != null)
          return localView;
        i += 1;
      }
    }
    return null;
  }

  public static <V extends View> BottomSheetBehavior<V> from(V paramV)
  {
    paramV = paramV.getLayoutParams();
    if (!(paramV instanceof CoordinatorLayout.LayoutParams))
      throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    paramV = ((CoordinatorLayout.LayoutParams)paramV).getBehavior();
    if (!(paramV instanceof BottomSheetBehavior))
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    return (BottomSheetBehavior)paramV;
  }

  private float getYVelocity()
  {
    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
    return VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
  }

  private void reset()
  {
    this.mActivePointerId = -1;
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }

  private void setStateInternal(int paramInt)
  {
    if (this.mState == paramInt);
    View localView;
    do
    {
      return;
      this.mState = paramInt;
      localView = (View)this.mViewRef.get();
    }
    while ((localView == null) || (this.mCallback == null));
    this.mCallback.onStateChanged(localView, paramInt);
  }

  private boolean shouldHide(View paramView, float paramFloat)
  {
    if (paramView.getTop() < this.mMaxOffset);
    do
      return false;
    while (Math.abs(paramView.getTop() + 0.1F * paramFloat - this.mMaxOffset) / this.mPeekHeight <= 0.5F);
    return true;
  }

  public final int getPeekHeight()
  {
    return this.mPeekHeight;
  }

  public final int getState()
  {
    return this.mState;
  }

  public boolean isHideable()
  {
    return this.mHideable;
  }

  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if (!paramV.isShown())
      return false;
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i == 0)
      reset();
    if (this.mVelocityTracker == null)
      this.mVelocityTracker = VelocityTracker.obtain();
    this.mVelocityTracker.addMovement(paramMotionEvent);
    switch (i)
    {
    case 2:
    default:
    case 1:
    case 3:
    case 0:
    }
    while ((!this.mIgnoreEvents) && (this.mViewDragHelper.shouldInterceptTouchEvent(paramMotionEvent)))
    {
      return true;
      this.mTouchingScrollingChild = false;
      this.mActivePointerId = -1;
      if (!this.mIgnoreEvents)
        continue;
      this.mIgnoreEvents = false;
      return false;
      int j = (int)paramMotionEvent.getX();
      this.mInitialY = (int)paramMotionEvent.getY();
      View localView = (View)this.mNestedScrollingChildRef.get();
      if ((localView != null) && (paramCoordinatorLayout.isPointInChildBounds(localView, j, this.mInitialY)))
      {
        this.mActivePointerId = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
        this.mTouchingScrollingChild = true;
      }
      if ((this.mActivePointerId == -1) && (!paramCoordinatorLayout.isPointInChildBounds(paramV, j, this.mInitialY)));
      for (bool1 = true; ; bool1 = false)
      {
        this.mIgnoreEvents = bool1;
        break;
      }
    }
    paramV = (View)this.mNestedScrollingChildRef.get();
    if ((i == 2) && (paramV != null) && (!this.mIgnoreEvents) && (this.mState != 1) && (!paramCoordinatorLayout.isPointInChildBounds(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (Math.abs(this.mInitialY - paramMotionEvent.getY()) > this.mViewDragHelper.getTouchSlop()));
    for (boolean bool1 = bool2; ; bool1 = false)
      return bool1;
  }

  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    if ((this.mState != 1) && (this.mState != 2))
    {
      if ((ViewCompat.getFitsSystemWindows(paramCoordinatorLayout)) && (!ViewCompat.getFitsSystemWindows(paramV)))
        ViewCompat.setFitsSystemWindows(paramV, true);
      paramCoordinatorLayout.onLayoutChild(paramV, paramInt);
    }
    this.mParentHeight = paramCoordinatorLayout.getHeight();
    this.mMinOffset = Math.max(0, this.mParentHeight - paramV.getHeight());
    this.mMaxOffset = Math.max(this.mParentHeight - this.mPeekHeight, this.mMinOffset);
    if (this.mState == 3)
      ViewCompat.offsetTopAndBottom(paramV, this.mMinOffset);
    while (true)
    {
      if (this.mViewDragHelper == null)
        this.mViewDragHelper = ViewDragHelper.create(paramCoordinatorLayout, this.mDragCallback);
      this.mViewRef = new WeakReference(paramV);
      this.mNestedScrollingChildRef = new WeakReference(findScrollingChild(paramV));
      return true;
      if ((this.mHideable) && (this.mState == 5))
      {
        ViewCompat.offsetTopAndBottom(paramV, this.mParentHeight);
        continue;
      }
      if (this.mState != 4)
        continue;
      ViewCompat.offsetTopAndBottom(paramV, this.mMaxOffset);
    }
  }

  public boolean onNestedPreFling(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramView == this.mNestedScrollingChildRef.get()) && ((this.mState != 3) || (super.onNestedPreFling(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)));
  }

  public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (paramView != (View)this.mNestedScrollingChildRef.get())
      return;
    paramInt1 = paramV.getTop();
    int i = paramInt1 - paramInt2;
    if (paramInt2 > 0)
      if (i < this.mMinOffset)
      {
        paramArrayOfInt[1] = (paramInt1 - this.mMinOffset);
        ViewCompat.offsetTopAndBottom(paramV, -paramArrayOfInt[1]);
        setStateInternal(3);
      }
    while (true)
    {
      dispatchOnSlide(paramV.getTop());
      this.mLastNestedScrollDy = paramInt2;
      this.mNestedScrolled = true;
      return;
      paramArrayOfInt[1] = paramInt2;
      ViewCompat.offsetTopAndBottom(paramV, -paramInt2);
      setStateInternal(1);
      continue;
      if ((paramInt2 >= 0) || (ViewCompat.canScrollVertically(paramView, -1)))
        continue;
      if ((i <= this.mMaxOffset) || (this.mHideable))
      {
        paramArrayOfInt[1] = paramInt2;
        ViewCompat.offsetTopAndBottom(paramV, -paramInt2);
        setStateInternal(1);
        continue;
      }
      paramArrayOfInt[1] = (paramInt1 - this.mMaxOffset);
      ViewCompat.offsetTopAndBottom(paramV, -paramArrayOfInt[1]);
      setStateInternal(4);
    }
  }

  public void onRestoreInstanceState(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramCoordinatorLayout, paramV, paramParcelable.getSuperState());
    if ((paramParcelable.state == 1) || (paramParcelable.state == 2))
    {
      this.mState = 4;
      return;
    }
    this.mState = paramParcelable.state;
  }

  public Parcelable onSaveInstanceState(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return new SavedState(super.onSaveInstanceState(paramCoordinatorLayout, paramV), this.mState);
  }

  public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt)
  {
    int i = 0;
    this.mLastNestedScrollDy = 0;
    this.mNestedScrolled = false;
    if ((paramInt & 0x2) != 0)
      i = 1;
    return i;
  }

  public void onStopNestedScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView)
  {
    if (paramV.getTop() == this.mMinOffset)
      setStateInternal(3);
    do
      return;
    while ((paramView != this.mNestedScrollingChildRef.get()) || (!this.mNestedScrolled));
    int j;
    int i;
    if (this.mLastNestedScrollDy > 0)
    {
      j = this.mMinOffset;
      i = 3;
      if (!this.mViewDragHelper.smoothSlideViewTo(paramV, paramV.getLeft(), j))
        break label197;
      setStateInternal(2);
      ViewCompat.postOnAnimation(paramV, new SettleRunnable(paramV, i));
    }
    while (true)
    {
      this.mNestedScrolled = false;
      return;
      if ((this.mHideable) && (shouldHide(paramV, getYVelocity())))
      {
        j = this.mParentHeight;
        i = 5;
        break;
      }
      if (this.mLastNestedScrollDy == 0)
      {
        i = paramV.getTop();
        if (Math.abs(i - this.mMinOffset) < Math.abs(i - this.mMaxOffset))
        {
          j = this.mMinOffset;
          i = 3;
          break;
        }
        j = this.mMaxOffset;
        i = 4;
        break;
      }
      j = this.mMaxOffset;
      i = 4;
      break;
      label197: setStateInternal(i);
    }
  }

  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    int k = 1;
    int j;
    if (!paramV.isShown())
      j = 0;
    do
    {
      int i;
      do
      {
        return j;
        i = MotionEventCompat.getActionMasked(paramMotionEvent);
        if (this.mState != 1)
          break;
        j = k;
      }
      while (i == 0);
      this.mViewDragHelper.processTouchEvent(paramMotionEvent);
      if (i == 0)
        reset();
      if (this.mVelocityTracker == null)
        this.mVelocityTracker = VelocityTracker.obtain();
      this.mVelocityTracker.addMovement(paramMotionEvent);
      if ((i == 2) && (!this.mIgnoreEvents) && (Math.abs(this.mInitialY - paramMotionEvent.getY()) > this.mViewDragHelper.getTouchSlop()))
        this.mViewDragHelper.captureChildView(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      j = k;
    }
    while (!this.mIgnoreEvents);
    return false;
  }

  public void setBottomSheetCallback(BottomSheetCallback paramBottomSheetCallback)
  {
    this.mCallback = paramBottomSheetCallback;
  }

  public void setHideable(boolean paramBoolean)
  {
    this.mHideable = paramBoolean;
  }

  public final void setPeekHeight(int paramInt)
  {
    this.mPeekHeight = Math.max(0, paramInt);
    this.mMaxOffset = (this.mParentHeight - paramInt);
  }

  public final void setState(int paramInt)
  {
    if (paramInt == this.mState);
    View localView;
    do
    {
      while (true)
      {
        return;
        if (this.mViewRef != null)
          break;
        if ((paramInt != 4) && (paramInt != 3) && ((!this.mHideable) || (paramInt != 5)))
          continue;
        this.mState = paramInt;
        return;
      }
      localView = (View)this.mViewRef.get();
    }
    while (localView == null);
    int i;
    if (paramInt == 4)
      i = this.mMaxOffset;
    while (true)
    {
      setStateInternal(2);
      if (!this.mViewDragHelper.smoothSlideViewTo(localView, localView.getLeft(), i))
        break;
      ViewCompat.postOnAnimation(localView, new SettleRunnable(localView, paramInt));
      return;
      if (paramInt == 3)
      {
        i = this.mMinOffset;
        continue;
      }
      if ((!this.mHideable) || (paramInt != 5))
        break label138;
      i = this.mParentHeight;
    }
    label138: throw new IllegalArgumentException("Illegal state argument: " + paramInt);
  }

  public static abstract class BottomSheetCallback
  {
    public abstract void onSlide(@NonNull View paramView, float paramFloat);

    public abstract void onStateChanged(@NonNull View paramView, int paramInt);
  }

  protected static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public BottomSheetBehavior.SavedState createFromParcel(Parcel paramParcel)
      {
        return new BottomSheetBehavior.SavedState(paramParcel);
      }

      public BottomSheetBehavior.SavedState[] newArray(int paramInt)
      {
        return new BottomSheetBehavior.SavedState[paramInt];
      }
    };
    final int state;

    public SavedState(Parcel paramParcel)
    {
      super();
      this.state = paramParcel.readInt();
    }

    public SavedState(Parcelable paramParcelable, int paramInt)
    {
      super();
      this.state = paramInt;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.state);
    }
  }

  private class SettleRunnable
    implements Runnable
  {
    private final int mTargetState;
    private final View mView;

    SettleRunnable(View paramInt, int arg3)
    {
      this.mView = paramInt;
      int i;
      this.mTargetState = i;
    }

    public void run()
    {
      if ((BottomSheetBehavior.this.mViewDragHelper != null) && (BottomSheetBehavior.this.mViewDragHelper.continueSettling(true)))
      {
        ViewCompat.postOnAnimation(this.mView, this);
        return;
      }
      BottomSheetBehavior.this.setStateInternal(this.mTargetState);
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface State
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     android.support.design.widget.BottomSheetBehavior
 * JD-Core Version:    0.6.0
 */
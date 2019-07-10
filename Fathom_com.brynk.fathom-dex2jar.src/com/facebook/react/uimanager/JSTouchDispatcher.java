package com.facebook.react.uimanager;

import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.TouchEvent;
import com.facebook.react.uimanager.events.TouchEventCoalescingKeyHelper;
import com.facebook.react.uimanager.events.TouchEventType;

public class JSTouchDispatcher
{
  private boolean mChildIsHandlingNativeGesture = false;
  private long mGestureStartTime = -9223372036854775808L;
  private final ViewGroup mRootViewGroup;
  private final float[] mTargetCoordinates = new float[2];
  private int mTargetTag = -1;
  private final TouchEventCoalescingKeyHelper mTouchEventCoalescingKeyHelper = new TouchEventCoalescingKeyHelper();

  public JSTouchDispatcher(ViewGroup paramViewGroup)
  {
    this.mRootViewGroup = paramViewGroup;
  }

  private void dispatchCancelEvent(MotionEvent paramMotionEvent, EventDispatcher paramEventDispatcher)
  {
    if (this.mTargetTag == -1)
    {
      FLog.w("ReactNative", "Can't cancel already finished gesture. Is a child View trying to start a gesture from an UP/CANCEL event?");
      return;
    }
    if (!this.mChildIsHandlingNativeGesture);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool, "Expected to not have already sent a cancel for this gesture");
      ((EventDispatcher)Assertions.assertNotNull(paramEventDispatcher)).dispatchEvent(TouchEvent.obtain(this.mTargetTag, TouchEventType.CANCEL, paramMotionEvent, this.mGestureStartTime, this.mTargetCoordinates[0], this.mTargetCoordinates[1], this.mTouchEventCoalescingKeyHelper));
      return;
    }
  }

  private int findTargetTagAndSetCoordinates(MotionEvent paramMotionEvent)
  {
    return TouchTargetHelper.findTargetTagAndCoordinatesForTouch(paramMotionEvent.getX(), paramMotionEvent.getY(), this.mRootViewGroup, this.mTargetCoordinates, null);
  }

  public void handleTouchEvent(MotionEvent paramMotionEvent, EventDispatcher paramEventDispatcher)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0)
    {
      if (this.mTargetTag != -1)
        FLog.e("ReactNative", "Got DOWN touch before receiving UP or CANCEL from last gesture");
      this.mChildIsHandlingNativeGesture = false;
      this.mGestureStartTime = paramMotionEvent.getEventTime();
      this.mTargetTag = findTargetTagAndSetCoordinates(paramMotionEvent);
      paramEventDispatcher.dispatchEvent(TouchEvent.obtain(this.mTargetTag, TouchEventType.START, paramMotionEvent, this.mGestureStartTime, this.mTargetCoordinates[0], this.mTargetCoordinates[1], this.mTouchEventCoalescingKeyHelper));
    }
    do
      return;
    while (this.mChildIsHandlingNativeGesture);
    if (this.mTargetTag == -1)
    {
      FLog.e("ReactNative", "Unexpected state: received touch event but didn't get starting ACTION_DOWN for this gesture before");
      return;
    }
    if (i == 1)
    {
      findTargetTagAndSetCoordinates(paramMotionEvent);
      paramEventDispatcher.dispatchEvent(TouchEvent.obtain(this.mTargetTag, TouchEventType.END, paramMotionEvent, this.mGestureStartTime, this.mTargetCoordinates[0], this.mTargetCoordinates[1], this.mTouchEventCoalescingKeyHelper));
      this.mTargetTag = -1;
      this.mGestureStartTime = -9223372036854775808L;
      return;
    }
    if (i == 2)
    {
      findTargetTagAndSetCoordinates(paramMotionEvent);
      paramEventDispatcher.dispatchEvent(TouchEvent.obtain(this.mTargetTag, TouchEventType.MOVE, paramMotionEvent, this.mGestureStartTime, this.mTargetCoordinates[0], this.mTargetCoordinates[1], this.mTouchEventCoalescingKeyHelper));
      return;
    }
    if (i == 5)
    {
      paramEventDispatcher.dispatchEvent(TouchEvent.obtain(this.mTargetTag, TouchEventType.START, paramMotionEvent, this.mGestureStartTime, this.mTargetCoordinates[0], this.mTargetCoordinates[1], this.mTouchEventCoalescingKeyHelper));
      return;
    }
    if (i == 6)
    {
      paramEventDispatcher.dispatchEvent(TouchEvent.obtain(this.mTargetTag, TouchEventType.END, paramMotionEvent, this.mGestureStartTime, this.mTargetCoordinates[0], this.mTargetCoordinates[1], this.mTouchEventCoalescingKeyHelper));
      return;
    }
    if (i == 3)
    {
      if (this.mTouchEventCoalescingKeyHelper.hasCoalescingKey(paramMotionEvent.getDownTime()))
        dispatchCancelEvent(paramMotionEvent, paramEventDispatcher);
      while (true)
      {
        this.mTargetTag = -1;
        this.mGestureStartTime = -9223372036854775808L;
        return;
        FLog.e("ReactNative", "Received an ACTION_CANCEL touch event for which we have no corresponding ACTION_DOWN");
      }
    }
    FLog.w("ReactNative", "Warning : touch event was ignored. Action=" + i + " Target=" + this.mTargetTag);
  }

  public void onChildStartedNativeGesture(MotionEvent paramMotionEvent, EventDispatcher paramEventDispatcher)
  {
    if (this.mChildIsHandlingNativeGesture)
      return;
    dispatchCancelEvent(paramMotionEvent, paramEventDispatcher);
    this.mChildIsHandlingNativeGesture = true;
    this.mTargetTag = -1;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.JSTouchDispatcher
 * JD-Core Version:    0.6.0
 */
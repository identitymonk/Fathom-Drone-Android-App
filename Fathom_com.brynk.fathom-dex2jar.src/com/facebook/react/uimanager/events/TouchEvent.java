package com.facebook.react.uimanager.events;

import android.support.v4.util.Pools.SynchronizedPool;
import android.view.MotionEvent;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.SoftAssertions;
import javax.annotation.Nullable;

public class TouchEvent extends Event<TouchEvent>
{
  private static final Pools.SynchronizedPool<TouchEvent> EVENTS_POOL = new Pools.SynchronizedPool(3);
  private static final int TOUCH_EVENTS_POOL_SIZE = 3;
  public static final long UNSET = -9223372036854775808L;
  private short mCoalescingKey;

  @Nullable
  private MotionEvent mMotionEvent;

  @Nullable
  private TouchEventType mTouchEventType;
  private float mViewX;
  private float mViewY;

  private void init(int paramInt, TouchEventType paramTouchEventType, MotionEvent paramMotionEvent, long paramLong, float paramFloat1, float paramFloat2, TouchEventCoalescingKeyHelper paramTouchEventCoalescingKeyHelper)
  {
    super.init(paramInt);
    if (paramLong != -9223372036854775808L);
    short s;
    for (boolean bool = true; ; bool = false)
    {
      SoftAssertions.assertCondition(bool, "Gesture start time must be initialized");
      s = 0;
      paramInt = paramMotionEvent.getAction() & 0xFF;
      switch (paramInt)
      {
      case 4:
      default:
        throw new RuntimeException("Unhandled MotionEvent action: " + paramInt);
      case 0:
      case 1:
      case 5:
      case 6:
      case 2:
      case 3:
      }
    }
    paramTouchEventCoalescingKeyHelper.addCoalescingKey(paramLong);
    while (true)
    {
      this.mTouchEventType = paramTouchEventType;
      this.mMotionEvent = MotionEvent.obtain(paramMotionEvent);
      this.mCoalescingKey = s;
      this.mViewX = paramFloat1;
      this.mViewY = paramFloat2;
      return;
      paramTouchEventCoalescingKeyHelper.removeCoalescingKey(paramLong);
      continue;
      paramTouchEventCoalescingKeyHelper.incrementCoalescingKey(paramLong);
      continue;
      s = paramTouchEventCoalescingKeyHelper.getCoalescingKey(paramLong);
      continue;
      paramTouchEventCoalescingKeyHelper.removeCoalescingKey(paramLong);
    }
  }

  public static TouchEvent obtain(int paramInt, TouchEventType paramTouchEventType, MotionEvent paramMotionEvent, long paramLong, float paramFloat1, float paramFloat2, TouchEventCoalescingKeyHelper paramTouchEventCoalescingKeyHelper)
  {
    TouchEvent localTouchEvent2 = (TouchEvent)EVENTS_POOL.acquire();
    TouchEvent localTouchEvent1 = localTouchEvent2;
    if (localTouchEvent2 == null)
      localTouchEvent1 = new TouchEvent();
    localTouchEvent1.init(paramInt, paramTouchEventType, paramMotionEvent, paramLong, paramFloat1, paramFloat2, paramTouchEventCoalescingKeyHelper);
    return localTouchEvent1;
  }

  public boolean canCoalesce()
  {
    switch (1.$SwitchMap$com$facebook$react$uimanager$events$TouchEventType[((TouchEventType)Assertions.assertNotNull(this.mTouchEventType)).ordinal()])
    {
    default:
      throw new RuntimeException("Unknown touch event type: " + this.mTouchEventType);
    case 1:
    case 2:
    case 3:
      return false;
    case 4:
    }
    return true;
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    TouchesHelper.sendTouchEvent(paramRCTEventEmitter, (TouchEventType)Assertions.assertNotNull(this.mTouchEventType), getViewTag(), this);
  }

  public short getCoalescingKey()
  {
    return this.mCoalescingKey;
  }

  public String getEventName()
  {
    return ((TouchEventType)Assertions.assertNotNull(this.mTouchEventType)).getJSEventName();
  }

  public MotionEvent getMotionEvent()
  {
    Assertions.assertNotNull(this.mMotionEvent);
    return this.mMotionEvent;
  }

  public float getViewX()
  {
    return this.mViewX;
  }

  public float getViewY()
  {
    return this.mViewY;
  }

  public void onDispose()
  {
    ((MotionEvent)Assertions.assertNotNull(this.mMotionEvent)).recycle();
    this.mMotionEvent = null;
    EVENTS_POOL.release(this);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.events.TouchEvent
 * JD-Core Version:    0.6.0
 */
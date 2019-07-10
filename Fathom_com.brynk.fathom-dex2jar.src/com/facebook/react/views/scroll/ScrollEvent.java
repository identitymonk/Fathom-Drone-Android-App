package com.facebook.react.views.scroll;

import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import javax.annotation.Nullable;

public class ScrollEvent extends Event<ScrollEvent>
{
  private static final Pools.SynchronizedPool<ScrollEvent> EVENTS_POOL = new Pools.SynchronizedPool(3);
  private int mContentHeight;
  private int mContentWidth;

  @Nullable
  private ScrollEventType mScrollEventType;
  private int mScrollViewHeight;
  private int mScrollViewWidth;
  private int mScrollX;
  private int mScrollY;
  private double mXVelocity;
  private double mYVelocity;

  private void init(int paramInt1, ScrollEventType paramScrollEventType, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    super.init(paramInt1);
    this.mScrollEventType = paramScrollEventType;
    this.mScrollX = paramInt2;
    this.mScrollY = paramInt3;
    this.mXVelocity = paramFloat1;
    this.mYVelocity = paramFloat2;
    this.mContentWidth = paramInt4;
    this.mContentHeight = paramInt5;
    this.mScrollViewWidth = paramInt6;
    this.mScrollViewHeight = paramInt7;
  }

  public static ScrollEvent obtain(int paramInt1, ScrollEventType paramScrollEventType, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    ScrollEvent localScrollEvent2 = (ScrollEvent)EVENTS_POOL.acquire();
    ScrollEvent localScrollEvent1 = localScrollEvent2;
    if (localScrollEvent2 == null)
      localScrollEvent1 = new ScrollEvent();
    localScrollEvent1.init(paramInt1, paramScrollEventType, paramInt2, paramInt3, paramFloat1, paramFloat2, paramInt4, paramInt5, paramInt6, paramInt7);
    return localScrollEvent1;
  }

  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap1 = Arguments.createMap();
    localWritableMap1.putDouble("top", 0.0D);
    localWritableMap1.putDouble("bottom", 0.0D);
    localWritableMap1.putDouble("left", 0.0D);
    localWritableMap1.putDouble("right", 0.0D);
    WritableMap localWritableMap2 = Arguments.createMap();
    localWritableMap2.putDouble("x", PixelUtil.toDIPFromPixel(this.mScrollX));
    localWritableMap2.putDouble("y", PixelUtil.toDIPFromPixel(this.mScrollY));
    WritableMap localWritableMap3 = Arguments.createMap();
    localWritableMap3.putDouble("width", PixelUtil.toDIPFromPixel(this.mContentWidth));
    localWritableMap3.putDouble("height", PixelUtil.toDIPFromPixel(this.mContentHeight));
    WritableMap localWritableMap4 = Arguments.createMap();
    localWritableMap4.putDouble("width", PixelUtil.toDIPFromPixel(this.mScrollViewWidth));
    localWritableMap4.putDouble("height", PixelUtil.toDIPFromPixel(this.mScrollViewHeight));
    WritableMap localWritableMap5 = Arguments.createMap();
    localWritableMap5.putDouble("x", this.mXVelocity);
    localWritableMap5.putDouble("y", this.mYVelocity);
    WritableMap localWritableMap6 = Arguments.createMap();
    localWritableMap6.putMap("contentInset", localWritableMap1);
    localWritableMap6.putMap("contentOffset", localWritableMap2);
    localWritableMap6.putMap("contentSize", localWritableMap3);
    localWritableMap6.putMap("layoutMeasurement", localWritableMap4);
    localWritableMap6.putMap("velocity", localWritableMap5);
    localWritableMap6.putInt("target", getViewTag());
    localWritableMap6.putBoolean("responderIgnoreScroll", true);
    return localWritableMap6;
  }

  public boolean canCoalesce()
  {
    return this.mScrollEventType == ScrollEventType.SCROLL;
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }

  public short getCoalescingKey()
  {
    return 0;
  }

  public String getEventName()
  {
    return ((ScrollEventType)Assertions.assertNotNull(this.mScrollEventType)).getJSEventName();
  }

  public void onDispose()
  {
    EVENTS_POOL.release(this);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.ScrollEvent
 * JD-Core Version:    0.6.0
 */
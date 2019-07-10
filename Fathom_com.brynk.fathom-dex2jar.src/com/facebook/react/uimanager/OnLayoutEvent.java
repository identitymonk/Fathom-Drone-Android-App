package com.facebook.react.uimanager;

import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class OnLayoutEvent extends Event<OnLayoutEvent>
{
  private static final Pools.SynchronizedPool<OnLayoutEvent> EVENTS_POOL = new Pools.SynchronizedPool(20);
  private int mHeight;
  private int mWidth;
  private int mX;
  private int mY;

  public static OnLayoutEvent obtain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    OnLayoutEvent localOnLayoutEvent2 = (OnLayoutEvent)EVENTS_POOL.acquire();
    OnLayoutEvent localOnLayoutEvent1 = localOnLayoutEvent2;
    if (localOnLayoutEvent2 == null)
      localOnLayoutEvent1 = new OnLayoutEvent();
    localOnLayoutEvent1.init(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    return localOnLayoutEvent1;
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    WritableMap localWritableMap1 = Arguments.createMap();
    localWritableMap1.putDouble("x", PixelUtil.toDIPFromPixel(this.mX));
    localWritableMap1.putDouble("y", PixelUtil.toDIPFromPixel(this.mY));
    localWritableMap1.putDouble("width", PixelUtil.toDIPFromPixel(this.mWidth));
    localWritableMap1.putDouble("height", PixelUtil.toDIPFromPixel(this.mHeight));
    WritableMap localWritableMap2 = Arguments.createMap();
    localWritableMap2.putMap("layout", localWritableMap1);
    localWritableMap2.putInt("target", getViewTag());
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), localWritableMap2);
  }

  public String getEventName()
  {
    return "topLayout";
  }

  protected void init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.init(paramInt1);
    this.mX = paramInt2;
    this.mY = paramInt3;
    this.mWidth = paramInt4;
    this.mHeight = paramInt5;
  }

  public void onDispose()
  {
    EVENTS_POOL.release(this);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.OnLayoutEvent
 * JD-Core Version:    0.6.0
 */
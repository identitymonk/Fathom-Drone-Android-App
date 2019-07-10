package com.facebook.react.views.viewpager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class PageScrollEvent extends Event<PageScrollEvent>
{
  public static final String EVENT_NAME = "topPageScroll";
  private final float mOffset;
  private final int mPosition;

  protected PageScrollEvent(int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramInt1);
    this.mPosition = paramInt2;
    float f;
    if (!Float.isInfinite(paramFloat))
    {
      f = paramFloat;
      if (!Float.isNaN(paramFloat));
    }
    else
    {
      f = 0.0F;
    }
    this.mOffset = f;
  }

  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putInt("position", this.mPosition);
    localWritableMap.putDouble("offset", this.mOffset);
    return localWritableMap;
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }

  public String getEventName()
  {
    return "topPageScroll";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.viewpager.PageScrollEvent
 * JD-Core Version:    0.6.0
 */
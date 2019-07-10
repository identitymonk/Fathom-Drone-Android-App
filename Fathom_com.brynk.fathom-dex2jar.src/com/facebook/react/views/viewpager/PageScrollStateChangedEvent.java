package com.facebook.react.views.viewpager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class PageScrollStateChangedEvent extends Event<PageScrollStateChangedEvent>
{
  public static final String EVENT_NAME = "topPageScrollStateChanged";
  private final String mPageScrollState;

  protected PageScrollStateChangedEvent(int paramInt, String paramString)
  {
    super(paramInt);
    this.mPageScrollState = paramString;
  }

  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putString("pageScrollState", this.mPageScrollState);
    return localWritableMap;
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }

  public String getEventName()
  {
    return "topPageScrollStateChanged";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.viewpager.PageScrollStateChangedEvent
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.views.webview.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class TopLoadingErrorEvent extends Event<TopLoadingErrorEvent>
{
  public static final String EVENT_NAME = "topLoadingError";
  private WritableMap mEventData;

  public TopLoadingErrorEvent(int paramInt, WritableMap paramWritableMap)
  {
    super(paramInt);
    this.mEventData = paramWritableMap;
  }

  public boolean canCoalesce()
  {
    return false;
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), this.mEventData);
  }

  public short getCoalescingKey()
  {
    return 0;
  }

  public String getEventName()
  {
    return "topLoadingError";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.webview.events.TopLoadingErrorEvent
 * JD-Core Version:    0.6.0
 */
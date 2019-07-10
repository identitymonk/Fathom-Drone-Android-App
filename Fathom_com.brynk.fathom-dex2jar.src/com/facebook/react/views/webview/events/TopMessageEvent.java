package com.facebook.react.views.webview.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class TopMessageEvent extends Event<TopMessageEvent>
{
  public static final String EVENT_NAME = "topMessage";
  private final String mData;

  public TopMessageEvent(int paramInt, String paramString)
  {
    super(paramInt);
    this.mData = paramString;
  }

  public boolean canCoalesce()
  {
    return false;
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putString("data", this.mData);
    paramRCTEventEmitter.receiveEvent(getViewTag(), "topMessage", localWritableMap);
  }

  public short getCoalescingKey()
  {
    return 0;
  }

  public String getEventName()
  {
    return "topMessage";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.webview.events.TopMessageEvent
 * JD-Core Version:    0.6.0
 */
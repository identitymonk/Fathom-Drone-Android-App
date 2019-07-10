package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class DrawerOpenedEvent extends Event<DrawerOpenedEvent>
{
  public static final String EVENT_NAME = "topDrawerOpened";

  public DrawerOpenedEvent(int paramInt)
  {
    super(paramInt);
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), Arguments.createMap());
  }

  public short getCoalescingKey()
  {
    return 0;
  }

  public String getEventName()
  {
    return "topDrawerOpened";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.drawer.events.DrawerOpenedEvent
 * JD-Core Version:    0.6.0
 */
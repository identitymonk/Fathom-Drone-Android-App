package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class DrawerStateChangedEvent extends Event<DrawerStateChangedEvent>
{
  public static final String EVENT_NAME = "topDrawerStateChanged";
  private final int mDrawerState;

  public DrawerStateChangedEvent(int paramInt1, int paramInt2)
  {
    super(paramInt1);
    this.mDrawerState = paramInt2;
  }

  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putDouble("drawerState", getDrawerState());
    return localWritableMap;
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }

  public short getCoalescingKey()
  {
    return 0;
  }

  public int getDrawerState()
  {
    return this.mDrawerState;
  }

  public String getEventName()
  {
    return "topDrawerStateChanged";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.drawer.events.DrawerStateChangedEvent
 * JD-Core Version:    0.6.0
 */
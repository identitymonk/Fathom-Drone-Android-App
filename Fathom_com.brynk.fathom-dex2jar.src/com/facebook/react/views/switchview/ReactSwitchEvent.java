package com.facebook.react.views.switchview;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class ReactSwitchEvent extends Event<ReactSwitchEvent>
{
  public static final String EVENT_NAME = "topChange";
  private final boolean mIsChecked;

  public ReactSwitchEvent(int paramInt, boolean paramBoolean)
  {
    super(paramInt);
    this.mIsChecked = paramBoolean;
  }

  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putInt("target", getViewTag());
    localWritableMap.putBoolean("value", getIsChecked());
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

  public String getEventName()
  {
    return "topChange";
  }

  public boolean getIsChecked()
  {
    return this.mIsChecked;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.switchview.ReactSwitchEvent
 * JD-Core Version:    0.6.0
 */
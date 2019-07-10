package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class ReactTextInputSelectionEvent extends Event<ReactTextInputSelectionEvent>
{
  private static final String EVENT_NAME = "topSelectionChange";
  private int mSelectionEnd;
  private int mSelectionStart;

  public ReactTextInputSelectionEvent(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.mSelectionStart = paramInt2;
    this.mSelectionEnd = paramInt3;
  }

  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap1 = Arguments.createMap();
    WritableMap localWritableMap2 = Arguments.createMap();
    localWritableMap2.putInt("end", this.mSelectionEnd);
    localWritableMap2.putInt("start", this.mSelectionStart);
    localWritableMap1.putMap("selection", localWritableMap2);
    return localWritableMap1;
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }

  public String getEventName()
  {
    return "topSelectionChange";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.textinput.ReactTextInputSelectionEvent
 * JD-Core Version:    0.6.0
 */
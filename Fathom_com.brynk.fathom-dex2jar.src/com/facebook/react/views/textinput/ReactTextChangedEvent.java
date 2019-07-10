package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ReactTextChangedEvent extends Event<ReactTextChangedEvent>
{
  public static final String EVENT_NAME = "topChange";
  private int mEventCount;
  private String mText;

  public ReactTextChangedEvent(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1);
    this.mText = paramString;
    this.mEventCount = paramInt2;
  }

  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putString("text", this.mText);
    localWritableMap.putInt("eventCount", this.mEventCount);
    localWritableMap.putInt("target", getViewTag());
    return localWritableMap;
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }

  public String getEventName()
  {
    return "topChange";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.textinput.ReactTextChangedEvent
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.views.modal;

import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class RequestCloseEvent extends Event<RequestCloseEvent>
{
  public static final String EVENT_NAME = "topRequestClose";

  protected RequestCloseEvent(int paramInt)
  {
    super(paramInt);
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), null);
  }

  public String getEventName()
  {
    return "topRequestClose";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.modal.RequestCloseEvent
 * JD-Core Version:    0.6.0
 */
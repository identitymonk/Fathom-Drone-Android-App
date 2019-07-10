package com.facebook.react.views.toolbar.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ToolbarClickEvent extends Event<ToolbarClickEvent>
{
  private static final String EVENT_NAME = "topSelect";
  private final int position;

  public ToolbarClickEvent(int paramInt1, int paramInt2)
  {
    super(paramInt1);
    this.position = paramInt2;
  }

  public boolean canCoalesce()
  {
    return false;
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    localWritableNativeMap.putInt("position", getPosition());
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), localWritableNativeMap);
  }

  public String getEventName()
  {
    return "topSelect";
  }

  public int getPosition()
  {
    return this.position;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.toolbar.events.ToolbarClickEvent
 * JD-Core Version:    0.6.0
 */
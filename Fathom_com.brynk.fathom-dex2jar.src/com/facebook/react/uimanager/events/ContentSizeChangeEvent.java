package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;

public class ContentSizeChangeEvent extends Event<ContentSizeChangeEvent>
{
  public static final String EVENT_NAME = "topContentSizeChange";
  private final int mHeight;
  private final int mWidth;

  public ContentSizeChangeEvent(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.mWidth = paramInt2;
    this.mHeight = paramInt3;
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putDouble("width", PixelUtil.toDIPFromPixel(this.mWidth));
    localWritableMap.putDouble("height", PixelUtil.toDIPFromPixel(this.mHeight));
    paramRCTEventEmitter.receiveEvent(getViewTag(), "topContentSizeChange", localWritableMap);
  }

  public String getEventName()
  {
    return "topContentSizeChange";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.events.ContentSizeChangeEvent
 * JD-Core Version:    0.6.0
 */
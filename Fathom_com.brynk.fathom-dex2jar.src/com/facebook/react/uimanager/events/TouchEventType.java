package com.facebook.react.uimanager.events;

public enum TouchEventType
{
  private final String mJSEventName;

  static
  {
    END = new TouchEventType("END", 1, "topTouchEnd");
    MOVE = new TouchEventType("MOVE", 2, "topTouchMove");
    CANCEL = new TouchEventType("CANCEL", 3, "topTouchCancel");
    $VALUES = new TouchEventType[] { START, END, MOVE, CANCEL };
  }

  private TouchEventType(String paramString)
  {
    this.mJSEventName = paramString;
  }

  public String getJSEventName()
  {
    return this.mJSEventName;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.events.TouchEventType
 * JD-Core Version:    0.6.0
 */
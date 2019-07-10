package com.facebook.react.views.scroll;

public enum ScrollEventType
{
  private final String mJSEventName;

  static
  {
    MOMENTUM_BEGIN = new ScrollEventType("MOMENTUM_BEGIN", 3, "topMomentumScrollBegin");
    MOMENTUM_END = new ScrollEventType("MOMENTUM_END", 4, "topMomentumScrollEnd");
    $VALUES = new ScrollEventType[] { BEGIN_DRAG, END_DRAG, SCROLL, MOMENTUM_BEGIN, MOMENTUM_END };
  }

  private ScrollEventType(String paramString)
  {
    this.mJSEventName = paramString;
  }

  public String getJSEventName()
  {
    return this.mJSEventName;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.ScrollEventType
 * JD-Core Version:    0.6.0
 */
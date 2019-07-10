package com.facebook.react.flat;

public final class RCTVirtualTextManager extends VirtualViewManager<RCTVirtualText>
{
  static final String REACT_CLASS = "RCTVirtualText";

  public RCTVirtualText createShadowNodeInstance()
  {
    return new RCTVirtualText();
  }

  public String getName()
  {
    return "RCTVirtualText";
  }

  public Class<RCTVirtualText> getShadowNodeClass()
  {
    return RCTVirtualText.class;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.RCTVirtualTextManager
 * JD-Core Version:    0.6.0
 */
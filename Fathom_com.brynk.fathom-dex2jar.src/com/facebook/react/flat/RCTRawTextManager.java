package com.facebook.react.flat;

public final class RCTRawTextManager extends VirtualViewManager<RCTRawText>
{
  static final String REACT_CLASS = "RCTRawText";

  public RCTRawText createShadowNodeInstance()
  {
    return new RCTRawText();
  }

  public String getName()
  {
    return "RCTRawText";
  }

  public Class<RCTRawText> getShadowNodeClass()
  {
    return RCTRawText.class;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.RCTRawTextManager
 * JD-Core Version:    0.6.0
 */
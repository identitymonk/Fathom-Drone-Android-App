package com.facebook.react.flat;

public final class RCTTextManager extends FlatViewManager
{
  static final String REACT_CLASS = "RCTText";

  public RCTText createShadowNodeInstance()
  {
    return new RCTText();
  }

  public String getName()
  {
    return "RCTText";
  }

  public Class<RCTText> getShadowNodeClass()
  {
    return RCTText.class;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.RCTTextManager
 * JD-Core Version:    0.6.0
 */
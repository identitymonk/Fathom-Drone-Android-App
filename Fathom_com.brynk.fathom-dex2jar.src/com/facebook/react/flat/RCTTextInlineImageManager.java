package com.facebook.react.flat;

public final class RCTTextInlineImageManager extends VirtualViewManager<RCTTextInlineImage>
{
  static final String REACT_CLASS = "RCTTextInlineImage";

  public RCTTextInlineImage createShadowNodeInstance()
  {
    return new RCTTextInlineImage();
  }

  public String getName()
  {
    return "RCTTextInlineImage";
  }

  public Class<RCTTextInlineImage> getShadowNodeClass()
  {
    return RCTTextInlineImage.class;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.RCTTextInlineImageManager
 * JD-Core Version:    0.6.0
 */
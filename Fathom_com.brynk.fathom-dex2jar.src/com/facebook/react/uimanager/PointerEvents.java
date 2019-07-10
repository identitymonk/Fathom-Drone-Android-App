package com.facebook.react.uimanager;

public enum PointerEvents
{
  static
  {
    BOX_NONE = new PointerEvents("BOX_NONE", 1);
    BOX_ONLY = new PointerEvents("BOX_ONLY", 2);
    AUTO = new PointerEvents("AUTO", 3);
    $VALUES = new PointerEvents[] { NONE, BOX_NONE, BOX_ONLY, AUTO };
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.PointerEvents
 * JD-Core Version:    0.6.0
 */
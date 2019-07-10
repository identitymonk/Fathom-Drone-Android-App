package com.facebook.react.flat;

import com.facebook.react.views.textinput.ReactTextInputManager;

public class RCTTextInputManager extends ReactTextInputManager
{
  static final String REACT_CLASS = "AndroidTextInput";

  public RCTTextInput createShadowNodeInstance()
  {
    return new RCTTextInput();
  }

  public Class<RCTTextInput> getShadowNodeClass()
  {
    return RCTTextInput.class;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.RCTTextInputManager
 * JD-Core Version:    0.6.0
 */
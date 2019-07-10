package com.facebook.react.views.picker;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;

@ReactModule(name="AndroidDropdownPicker")
public class ReactDropdownPickerManager extends ReactPickerManager
{
  protected static final String REACT_CLASS = "AndroidDropdownPicker";

  protected ReactPicker createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactPicker(paramThemedReactContext, 1);
  }

  public String getName()
  {
    return "AndroidDropdownPicker";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.picker.ReactDropdownPickerManager
 * JD-Core Version:    0.6.0
 */
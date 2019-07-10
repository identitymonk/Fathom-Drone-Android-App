package com.facebook.react.views.picker;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;

@ReactModule(name="AndroidDialogPicker")
public class ReactDialogPickerManager extends ReactPickerManager
{
  protected static final String REACT_CLASS = "AndroidDialogPicker";

  protected ReactPicker createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactPicker(paramThemedReactContext, 0);
  }

  public String getName()
  {
    return "AndroidDialogPicker";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.picker.ReactDialogPickerManager
 * JD-Core Version:    0.6.0
 */
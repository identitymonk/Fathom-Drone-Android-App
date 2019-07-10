package com.facebook.react.views.checkbox;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;

public class ReactCheckBoxManager extends SimpleViewManager<ReactCheckBox>
{
  private static final CompoundButton.OnCheckedChangeListener ON_CHECKED_CHANGE_LISTENER = new CompoundButton.OnCheckedChangeListener()
  {
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      ((UIManagerModule)((ReactContext)paramCompoundButton.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactCheckBoxEvent(paramCompoundButton.getId(), paramBoolean));
    }
  };
  private static final String REACT_CLASS = "AndroidCheckBox";

  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, ReactCheckBox paramReactCheckBox)
  {
    paramReactCheckBox.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
  }

  protected ReactCheckBox createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactCheckBox(paramThemedReactContext);
  }

  public String getName()
  {
    return "AndroidCheckBox";
  }

  @ReactProp(defaultBoolean=true, name="enabled")
  public void setEnabled(ReactCheckBox paramReactCheckBox, boolean paramBoolean)
  {
    paramReactCheckBox.setEnabled(paramBoolean);
  }

  @ReactProp(name="on")
  public void setOn(ReactCheckBox paramReactCheckBox, boolean paramBoolean)
  {
    paramReactCheckBox.setOnCheckedChangeListener(null);
    paramReactCheckBox.setOn(paramBoolean);
    paramReactCheckBox.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.checkbox.ReactCheckBoxManager
 * JD-Core Version:    0.6.0
 */
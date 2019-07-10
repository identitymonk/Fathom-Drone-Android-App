package com.facebook.react.uimanager;

import android.view.ViewGroup;

public class RootViewManager extends ViewGroupManager<ViewGroup>
{
  public static final String REACT_CLASS = "RootView";

  protected ViewGroup createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new SizeMonitoringFrameLayout(paramThemedReactContext);
  }

  public String getName()
  {
    return "RootView";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.RootViewManager
 * JD-Core Version:    0.6.0
 */
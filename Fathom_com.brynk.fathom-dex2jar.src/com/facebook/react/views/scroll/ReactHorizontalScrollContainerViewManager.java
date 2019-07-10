package com.facebook.react.views.scroll;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

@ReactModule(name="AndroidHorizontalScrollContentView")
public class ReactHorizontalScrollContainerViewManager extends ViewGroupManager<ReactHorizontalScrollContainerView>
{
  protected static final String REACT_CLASS = "AndroidHorizontalScrollContentView";

  public ReactHorizontalScrollContainerView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactHorizontalScrollContainerView(paramThemedReactContext);
  }

  public String getName()
  {
    return "AndroidHorizontalScrollContentView";
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.ReactHorizontalScrollContainerViewManager
 * JD-Core Version:    0.6.0
 */
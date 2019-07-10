package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.List;

public class UIImplementationProvider
{
  public UIImplementation createUIImplementation(ReactApplicationContext paramReactApplicationContext, UIManagerModule.ViewManagerResolver paramViewManagerResolver, EventDispatcher paramEventDispatcher, int paramInt)
  {
    return new UIImplementation(paramReactApplicationContext, paramViewManagerResolver, paramEventDispatcher, paramInt);
  }

  public UIImplementation createUIImplementation(ReactApplicationContext paramReactApplicationContext, List<ViewManager> paramList, EventDispatcher paramEventDispatcher, int paramInt)
  {
    return new UIImplementation(paramReactApplicationContext, paramList, paramEventDispatcher, paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.UIImplementationProvider
 * JD-Core Version:    0.6.0
 */
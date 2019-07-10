package com.facebook.react.flat;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.UIManagerModule.ViewManagerResolver;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.List;

public final class FlatUIImplementationProvider extends UIImplementationProvider
{
  private final boolean mMemoryImprovementEnabled;

  public FlatUIImplementationProvider()
  {
    this.mMemoryImprovementEnabled = true;
  }

  public FlatUIImplementationProvider(boolean paramBoolean)
  {
    this.mMemoryImprovementEnabled = paramBoolean;
  }

  public FlatUIImplementation createUIImplementation(ReactApplicationContext paramReactApplicationContext, UIManagerModule.ViewManagerResolver paramViewManagerResolver, EventDispatcher paramEventDispatcher, int paramInt)
  {
    throw new UnsupportedOperationException("Lazy version of FlatUIImplementations are not supported");
  }

  public FlatUIImplementation createUIImplementation(ReactApplicationContext paramReactApplicationContext, List<ViewManager> paramList, EventDispatcher paramEventDispatcher, int paramInt)
  {
    return FlatUIImplementation.createInstance(paramReactApplicationContext, paramList, paramEventDispatcher, this.mMemoryImprovementEnabled, paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.flat.FlatUIImplementationProvider
 * JD-Core Version:    0.6.0
 */
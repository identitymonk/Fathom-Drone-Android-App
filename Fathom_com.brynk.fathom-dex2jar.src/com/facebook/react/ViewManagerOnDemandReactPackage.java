package com.facebook.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.List;
import javax.annotation.Nullable;

public abstract interface ViewManagerOnDemandReactPackage
{
  @Nullable
  public abstract ViewManager createViewManager(ReactApplicationContext paramReactApplicationContext, String paramString);

  public abstract List<String> getViewManagerNames(ReactApplicationContext paramReactApplicationContext);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.ViewManagerOnDemandReactPackage
 * JD-Core Version:    0.6.0
 */
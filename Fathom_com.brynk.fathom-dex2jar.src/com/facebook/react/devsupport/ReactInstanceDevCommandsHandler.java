package com.facebook.react.devsupport;

import com.facebook.react.bridge.JavaJSExecutor.Factory;

public abstract interface ReactInstanceDevCommandsHandler
{
  public abstract void onJSBundleLoadedFromServer();

  public abstract void onReloadWithJSDebugger(JavaJSExecutor.Factory paramFactory);

  public abstract void toggleElementInspector();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.ReactInstanceDevCommandsHandler
 * JD-Core Version:    0.6.0
 */
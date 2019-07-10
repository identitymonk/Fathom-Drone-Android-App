package com.facebook.react.modules.debug.interfaces;

public abstract interface DeveloperSettings
{
  public abstract boolean isAnimationFpsDebugEnabled();

  public abstract boolean isElementInspectorEnabled();

  public abstract boolean isFpsDebugEnabled();

  public abstract boolean isJSDevModeEnabled();

  public abstract boolean isJSMinifyEnabled();

  public abstract boolean isRemoteJSDebugEnabled();

  public abstract void setRemoteJSDebugEnabled(boolean paramBoolean);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.debug.interfaces.DeveloperSettings
 * JD-Core Version:    0.6.0
 */
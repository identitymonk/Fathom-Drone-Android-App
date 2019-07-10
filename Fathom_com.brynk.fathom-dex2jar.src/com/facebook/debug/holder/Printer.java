package com.facebook.debug.holder;

import com.facebook.debug.debugoverlay.model.DebugOverlayTag;

public abstract interface Printer
{
  public abstract void logMessage(DebugOverlayTag paramDebugOverlayTag, String paramString);

  public abstract void logMessage(DebugOverlayTag paramDebugOverlayTag, String paramString, Object[] paramArrayOfObject);

  public abstract boolean shouldDisplayLogMessage(DebugOverlayTag paramDebugOverlayTag);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.debug.holder.Printer
 * JD-Core Version:    0.6.0
 */
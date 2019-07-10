package com.facebook.debug.holder;

import com.facebook.debug.debugoverlay.model.DebugOverlayTag;

public class NoopPrinter
  implements Printer
{
  public static final NoopPrinter INSTANCE = new NoopPrinter();

  public void logMessage(DebugOverlayTag paramDebugOverlayTag, String paramString)
  {
  }

  public void logMessage(DebugOverlayTag paramDebugOverlayTag, String paramString, Object[] paramArrayOfObject)
  {
  }

  public boolean shouldDisplayLogMessage(DebugOverlayTag paramDebugOverlayTag)
  {
    return false;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.debug.holder.NoopPrinter
 * JD-Core Version:    0.6.0
 */
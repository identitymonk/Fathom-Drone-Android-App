package com.facebook.react.bridge;

public enum MemoryPressure
{
  static
  {
    MODERATE = new MemoryPressure("MODERATE", 1);
    CRITICAL = new MemoryPressure("CRITICAL", 2);
    $VALUES = new MemoryPressure[] { UI_HIDDEN, MODERATE, CRITICAL };
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.MemoryPressure
 * JD-Core Version:    0.6.0
 */
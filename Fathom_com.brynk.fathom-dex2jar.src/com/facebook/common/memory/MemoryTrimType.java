package com.facebook.common.memory;

public enum MemoryTrimType
{
  private double mSuggestedTrimRatio;

  static
  {
    OnSystemLowMemoryWhileAppInBackground = new MemoryTrimType("OnSystemLowMemoryWhileAppInBackground", 2, 1.0D);
    OnAppBackgrounded = new MemoryTrimType("OnAppBackgrounded", 3, 1.0D);
    $VALUES = new MemoryTrimType[] { OnCloseToDalvikHeapLimit, OnSystemLowMemoryWhileAppInForeground, OnSystemLowMemoryWhileAppInBackground, OnAppBackgrounded };
  }

  private MemoryTrimType(double paramDouble)
  {
    this.mSuggestedTrimRatio = paramDouble;
  }

  public double getSuggestedTrimRatio()
  {
    return this.mSuggestedTrimRatio;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.memory.MemoryTrimType
 * JD-Core Version:    0.6.0
 */
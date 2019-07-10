package com.facebook.imagepipeline.memory;

public class BitmapCounterProvider
{
  private static final long KB = 1024L;
  public static final int MAX_BITMAP_COUNT = 384;
  public static final int MAX_BITMAP_TOTAL_SIZE = getMaxSizeHardCap();
  private static final long MB = 1048576L;
  private static BitmapCounter sBitmapCounter;

  public static BitmapCounter get()
  {
    if (sBitmapCounter == null)
      sBitmapCounter = new BitmapCounter(384, MAX_BITMAP_TOTAL_SIZE);
    return sBitmapCounter;
  }

  private static int getMaxSizeHardCap()
  {
    int i = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
    if (i > 16777216L)
      return i / 4 * 3;
    return i / 2;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.BitmapCounterProvider
 * JD-Core Version:    0.6.0
 */
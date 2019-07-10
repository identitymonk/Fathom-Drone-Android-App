package com.facebook.react.common;

public class SystemClock
{
  public static long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }

  public static long nanoTime()
  {
    return System.nanoTime();
  }

  public static long uptimeMillis()
  {
    return android.os.SystemClock.uptimeMillis();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.common.SystemClock
 * JD-Core Version:    0.6.0
 */
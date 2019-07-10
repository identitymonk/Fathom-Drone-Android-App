package com.facebook.common.time;

public class SystemClock
  implements Clock
{
  private static final SystemClock INSTANCE = new SystemClock();

  public static SystemClock get()
  {
    return INSTANCE;
  }

  public long now()
  {
    return System.currentTimeMillis();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.time.SystemClock
 * JD-Core Version:    0.6.0
 */
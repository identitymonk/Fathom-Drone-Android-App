package com.facebook.common.time;

import android.os.SystemClock;

public class CurrentThreadTimeClock
  implements Clock
{
  public long now()
  {
    return SystemClock.currentThreadTimeMillis();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.time.CurrentThreadTimeClock
 * JD-Core Version:    0.6.0
 */
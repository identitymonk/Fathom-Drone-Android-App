package com.facebook.common.time;

import android.os.SystemClock;
import com.facebook.common.internal.DoNotStrip;

@DoNotStrip
public class AwakeTimeSinceBootClock
  implements MonotonicClock
{

  @DoNotStrip
  private static final AwakeTimeSinceBootClock INSTANCE = new AwakeTimeSinceBootClock();

  @DoNotStrip
  public static AwakeTimeSinceBootClock get()
  {
    return INSTANCE;
  }

  @DoNotStrip
  public long now()
  {
    return SystemClock.uptimeMillis();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.time.AwakeTimeSinceBootClock
 * JD-Core Version:    0.6.0
 */
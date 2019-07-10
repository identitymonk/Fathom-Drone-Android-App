package com.facebook.common.time;

import android.os.SystemClock;
import com.facebook.common.internal.DoNotStrip;

@DoNotStrip
public class RealtimeSinceBootClock
  implements MonotonicClock
{
  private static final RealtimeSinceBootClock INSTANCE = new RealtimeSinceBootClock();

  @DoNotStrip
  public static RealtimeSinceBootClock get()
  {
    return INSTANCE;
  }

  public long now()
  {
    return SystemClock.elapsedRealtime();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.time.RealtimeSinceBootClock
 * JD-Core Version:    0.6.0
 */
package com.facebook.common.time;

import com.facebook.common.internal.DoNotStrip;

public abstract interface MonotonicClock
{
  @DoNotStrip
  public abstract long now();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.time.MonotonicClock
 * JD-Core Version:    0.6.0
 */
package com.facebook.common.time;

public abstract interface Clock
{
  public static final long MAX_TIME = 9223372036854775807L;

  public abstract long now();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.time.Clock
 * JD-Core Version:    0.6.0
 */
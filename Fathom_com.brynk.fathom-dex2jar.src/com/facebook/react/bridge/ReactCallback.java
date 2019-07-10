package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
abstract interface ReactCallback
{
  @DoNotStrip
  public abstract void decrementPendingJSCalls();

  @DoNotStrip
  public abstract void incrementPendingJSCalls();

  @DoNotStrip
  public abstract void onBatchComplete();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReactCallback
 * JD-Core Version:    0.6.0
 */
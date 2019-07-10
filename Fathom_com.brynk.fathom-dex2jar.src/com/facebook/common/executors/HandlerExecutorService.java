package com.facebook.common.executors;

import java.util.concurrent.ScheduledExecutorService;

public abstract interface HandlerExecutorService extends ScheduledExecutorService
{
  public abstract boolean isHandlerThread();

  public abstract void quit();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.executors.HandlerExecutorService
 * JD-Core Version:    0.6.0
 */
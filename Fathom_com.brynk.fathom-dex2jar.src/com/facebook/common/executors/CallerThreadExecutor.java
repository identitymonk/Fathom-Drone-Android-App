package com.facebook.common.executors;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

public class CallerThreadExecutor extends AbstractExecutorService
{
  private static final CallerThreadExecutor sInstance = new CallerThreadExecutor();

  public static CallerThreadExecutor getInstance()
  {
    return sInstance;
  }

  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return true;
  }

  public void execute(Runnable paramRunnable)
  {
    paramRunnable.run();
  }

  public boolean isShutdown()
  {
    return false;
  }

  public boolean isTerminated()
  {
    return false;
  }

  public void shutdown()
  {
  }

  public List<Runnable> shutdownNow()
  {
    shutdown();
    return Collections.emptyList();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.executors.CallerThreadExecutor
 * JD-Core Version:    0.6.0
 */
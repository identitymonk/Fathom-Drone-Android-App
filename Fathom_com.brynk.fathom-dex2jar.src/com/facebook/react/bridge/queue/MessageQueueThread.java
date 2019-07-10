package com.facebook.react.bridge.queue;

import com.facebook.proguard.annotations.DoNotStrip;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@DoNotStrip
public abstract interface MessageQueueThread
{
  @DoNotStrip
  public abstract void assertIsOnThread();

  @DoNotStrip
  public abstract void assertIsOnThread(String paramString);

  @DoNotStrip
  public abstract <T> Future<T> callOnQueue(Callable<T> paramCallable);

  @DoNotStrip
  public abstract boolean isOnThread();

  @DoNotStrip
  public abstract void quitSynchronous();

  @DoNotStrip
  public abstract void runOnQueue(Runnable paramRunnable);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.queue.MessageQueueThread
 * JD-Core Version:    0.6.0
 */
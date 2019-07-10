package com.facebook.common.executors;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

public class ScheduledFutureImpl<V>
  implements RunnableFuture<V>, ScheduledFuture<V>
{
  private final Handler mHandler;
  private final FutureTask<V> mListenableFuture;

  public ScheduledFutureImpl(Handler paramHandler, Runnable paramRunnable, @Nullable V paramV)
  {
    this.mHandler = paramHandler;
    this.mListenableFuture = new FutureTask(paramRunnable, paramV);
  }

  public ScheduledFutureImpl(Handler paramHandler, Callable<V> paramCallable)
  {
    this.mHandler = paramHandler;
    this.mListenableFuture = new FutureTask(paramCallable);
  }

  public boolean cancel(boolean paramBoolean)
  {
    return this.mListenableFuture.cancel(paramBoolean);
  }

  public int compareTo(Delayed paramDelayed)
  {
    throw new UnsupportedOperationException();
  }

  public V get()
    throws InterruptedException, ExecutionException
  {
    return this.mListenableFuture.get();
  }

  public V get(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    return this.mListenableFuture.get(paramLong, paramTimeUnit);
  }

  public long getDelay(TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }

  public boolean isCancelled()
  {
    return this.mListenableFuture.isCancelled();
  }

  public boolean isDone()
  {
    return this.mListenableFuture.isDone();
  }

  public void run()
  {
    this.mListenableFuture.run();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.executors.ScheduledFutureImpl
 * JD-Core Version:    0.6.0
 */
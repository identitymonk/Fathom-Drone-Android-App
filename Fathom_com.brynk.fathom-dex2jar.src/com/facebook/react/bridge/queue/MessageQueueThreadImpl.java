package com.facebook.react.bridge.queue;

import android.os.Looper;
import android.os.Process;
import com.facebook.common.logging.FLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.futures.SimpleSettableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@DoNotStrip
public class MessageQueueThreadImpl
  implements MessageQueueThread
{
  private final String mAssertionErrorMessage;
  private final MessageQueueThreadHandler mHandler;
  private volatile boolean mIsFinished = false;
  private final Looper mLooper;
  private final String mName;

  private MessageQueueThreadImpl(String paramString, Looper paramLooper, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    this.mName = paramString;
    this.mLooper = paramLooper;
    this.mHandler = new MessageQueueThreadHandler(paramLooper, paramQueueThreadExceptionHandler);
    this.mAssertionErrorMessage = ("Expected to be called from the '" + getName() + "' thread!");
  }

  public static MessageQueueThreadImpl create(MessageQueueThreadSpec paramMessageQueueThreadSpec, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    switch (4.$SwitchMap$com$facebook$react$bridge$queue$MessageQueueThreadSpec$ThreadType[paramMessageQueueThreadSpec.getThreadType().ordinal()])
    {
    default:
      throw new RuntimeException("Unknown thread type: " + paramMessageQueueThreadSpec.getThreadType());
    case 1:
      return createForMainThread(paramMessageQueueThreadSpec.getName(), paramQueueThreadExceptionHandler);
    case 2:
    }
    return startNewBackgroundThread(paramMessageQueueThreadSpec.getName(), paramMessageQueueThreadSpec.getStackSize(), paramQueueThreadExceptionHandler);
  }

  private static MessageQueueThreadImpl createForMainThread(String paramString, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    paramString = new MessageQueueThreadImpl(paramString, Looper.getMainLooper(), paramQueueThreadExceptionHandler);
    if (UiThreadUtil.isOnUiThread())
    {
      Process.setThreadPriority(-4);
      return paramString;
    }
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        Process.setThreadPriority(-4);
      }
    });
    return paramString;
  }

  private static MessageQueueThreadImpl startNewBackgroundThread(String paramString, long paramLong, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    SimpleSettableFuture localSimpleSettableFuture = new SimpleSettableFuture();
    new Thread(null, new Runnable(localSimpleSettableFuture)
    {
      public void run()
      {
        Process.setThreadPriority(-4);
        Looper.prepare();
        this.val$looperFuture.set(Looper.myLooper());
        Looper.loop();
      }
    }
    , "mqt_" + paramString, paramLong).start();
    return new MessageQueueThreadImpl(paramString, (Looper)localSimpleSettableFuture.getOrThrow(), paramQueueThreadExceptionHandler);
  }

  @DoNotStrip
  public void assertIsOnThread()
  {
    SoftAssertions.assertCondition(isOnThread(), this.mAssertionErrorMessage);
  }

  @DoNotStrip
  public void assertIsOnThread(String paramString)
  {
    SoftAssertions.assertCondition(isOnThread(), this.mAssertionErrorMessage + " " + paramString);
  }

  @DoNotStrip
  public <T> Future<T> callOnQueue(Callable<T> paramCallable)
  {
    SimpleSettableFuture localSimpleSettableFuture = new SimpleSettableFuture();
    runOnQueue(new Runnable(localSimpleSettableFuture, paramCallable)
    {
      public void run()
      {
        try
        {
          this.val$future.set(this.val$callable.call());
          return;
        }
        catch (Exception localException)
        {
          this.val$future.setException(localException);
        }
      }
    });
    return localSimpleSettableFuture;
  }

  public Looper getLooper()
  {
    return this.mLooper;
  }

  public String getName()
  {
    return this.mName;
  }

  @DoNotStrip
  public boolean isOnThread()
  {
    return this.mLooper.getThread() == Thread.currentThread();
  }

  @DoNotStrip
  public void quitSynchronous()
  {
    this.mIsFinished = true;
    this.mLooper.quit();
    if (this.mLooper.getThread() != Thread.currentThread());
    try
    {
      this.mLooper.getThread().join();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    throw new RuntimeException("Got interrupted waiting to join thread " + this.mName);
  }

  @DoNotStrip
  public void runOnQueue(Runnable paramRunnable)
  {
    if (this.mIsFinished)
      FLog.w("ReactNative", "Tried to enqueue runnable on already finished thread: '" + getName() + "... dropping Runnable.");
    this.mHandler.post(paramRunnable);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.queue.MessageQueueThreadImpl
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.modules.core;

import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.SystemClock;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

@ReactModule(name="Timing")
public final class Timing extends ReactContextBaseJavaModule
  implements LifecycleEventListener, HeadlessJsTaskEventListener
{
  private static final float FRAME_DURATION_MS = 16.666666F;
  private static final float IDLE_CALLBACK_FRAME_DEADLINE_MS = 1.0F;
  protected static final String NAME = "Timing";
  private final AtomicBoolean isPaused = new AtomicBoolean(true);
  private final AtomicBoolean isRunningTasks = new AtomicBoolean(false);

  @Nullable
  private IdleCallbackRunnable mCurrentIdleCallbackRunnable;
  private final DevSupportManager mDevSupportManager;
  private boolean mFrameCallbackPosted = false;
  private boolean mFrameIdleCallbackPosted = false;
  private final Object mIdleCallbackGuard = new Object();
  private final IdleFrameCallback mIdleFrameCallback = new IdleFrameCallback(null);
  private final ReactChoreographer mReactChoreographer;
  private boolean mSendIdleEvents = false;
  private final TimerFrameCallback mTimerFrameCallback = new TimerFrameCallback(null);
  private final Object mTimerGuard = new Object();
  private final SparseArray<Timer> mTimerIdsToTimers;
  private final PriorityQueue<Timer> mTimers;

  public Timing(ReactApplicationContext paramReactApplicationContext, DevSupportManager paramDevSupportManager)
  {
    super(paramReactApplicationContext);
    this.mDevSupportManager = paramDevSupportManager;
    this.mTimers = new PriorityQueue(11, new Comparator()
    {
      public int compare(Timing.Timer paramTimer1, Timing.Timer paramTimer2)
      {
        long l = Timing.Timer.access$400(paramTimer1) - Timing.Timer.access$400(paramTimer2);
        if (l == 0L)
          return 0;
        if (l < 0L)
          return -1;
        return 1;
      }
    });
    this.mTimerIdsToTimers = new SparseArray();
    this.mReactChoreographer = ReactChoreographer.getInstance();
  }

  private void clearChoreographerIdleCallback()
  {
    if (this.mFrameIdleCallbackPosted)
    {
      this.mReactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this.mIdleFrameCallback);
      this.mFrameIdleCallbackPosted = false;
    }
  }

  private void clearFrameCallback()
  {
    HeadlessJsTaskContext localHeadlessJsTaskContext = HeadlessJsTaskContext.getInstance(getReactApplicationContext());
    if ((this.mFrameCallbackPosted) && (this.isPaused.get()) && (!localHeadlessJsTaskContext.hasActiveTasks()))
    {
      this.mReactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this.mTimerFrameCallback);
      this.mFrameCallbackPosted = false;
    }
  }

  private void maybeIdleCallback()
  {
    if ((this.isPaused.get()) && (!this.isRunningTasks.get()))
      clearFrameCallback();
  }

  private void maybeSetChoreographerIdleCallback()
  {
    synchronized (this.mIdleCallbackGuard)
    {
      if (this.mSendIdleEvents)
        setChoreographerIdleCallback();
      return;
    }
  }

  private void setChoreographerCallback()
  {
    if (!this.mFrameCallbackPosted)
    {
      this.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this.mTimerFrameCallback);
      this.mFrameCallbackPosted = true;
    }
  }

  private void setChoreographerIdleCallback()
  {
    if (!this.mFrameIdleCallbackPosted)
    {
      this.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this.mIdleFrameCallback);
      this.mFrameIdleCallbackPosted = true;
    }
  }

  @ReactMethod
  public void createTimer(int paramInt1, int paramInt2, double paramDouble, boolean paramBoolean)
  {
    long l1 = SystemClock.currentTimeMillis();
    long l2 = ()paramDouble;
    if ((this.mDevSupportManager.getDevSupportEnabled()) && (Math.abs(l2 - l1) > 60000L))
      ((JSTimers)getReactApplicationContext().getJSModule(JSTimers.class)).emitTimeDriftWarning("Debugger and device times have drifted by more than 60s. Please correct this by running adb shell \"date `date +%m%d%H%M%Y.%S`\" on your debugger machine.");
    l1 = Math.max(0L, l2 - l1 + paramInt2);
    if ((paramInt2 == 0) && (!paramBoolean))
    {
      ??? = Arguments.createArray();
      ((WritableArray)???).pushInt(paramInt1);
      ((JSTimers)getReactApplicationContext().getJSModule(JSTimers.class)).callTimers((WritableArray)???);
      return;
    }
    Timer localTimer = new Timer(paramInt1, SystemClock.nanoTime() / 1000000L + l1, paramInt2, paramBoolean, null);
    synchronized (this.mTimerGuard)
    {
      this.mTimers.add(localTimer);
      this.mTimerIdsToTimers.put(paramInt1, localTimer);
      return;
    }
  }

  @ReactMethod
  public void deleteTimer(int paramInt)
  {
    synchronized (this.mTimerGuard)
    {
      Timer localTimer = (Timer)this.mTimerIdsToTimers.get(paramInt);
      if (localTimer == null)
        return;
      this.mTimerIdsToTimers.remove(paramInt);
      this.mTimers.remove(localTimer);
      return;
    }
  }

  public String getName()
  {
    return "Timing";
  }

  public void initialize()
  {
    getReactApplicationContext().addLifecycleEventListener(this);
    HeadlessJsTaskContext.getInstance(getReactApplicationContext()).addTaskEventListener(this);
  }

  public void onCatalystInstanceDestroy()
  {
    clearFrameCallback();
    clearChoreographerIdleCallback();
    HeadlessJsTaskContext.getInstance(getReactApplicationContext()).removeTaskEventListener(this);
  }

  public void onHeadlessJsTaskFinish(int paramInt)
  {
    if (!HeadlessJsTaskContext.getInstance(getReactApplicationContext()).hasActiveTasks())
    {
      this.isRunningTasks.set(false);
      clearFrameCallback();
      maybeIdleCallback();
    }
  }

  public void onHeadlessJsTaskStart(int paramInt)
  {
    if (!this.isRunningTasks.getAndSet(true))
    {
      setChoreographerCallback();
      maybeSetChoreographerIdleCallback();
    }
  }

  public void onHostDestroy()
  {
    clearFrameCallback();
    maybeIdleCallback();
  }

  public void onHostPause()
  {
    this.isPaused.set(true);
    clearFrameCallback();
    maybeIdleCallback();
  }

  public void onHostResume()
  {
    this.isPaused.set(false);
    setChoreographerCallback();
    maybeSetChoreographerIdleCallback();
  }

  @ReactMethod
  public void setSendIdleEvents(boolean paramBoolean)
  {
    synchronized (this.mIdleCallbackGuard)
    {
      this.mSendIdleEvents = paramBoolean;
      UiThreadUtil.runOnUiThread(new Runnable(paramBoolean)
      {
        public void run()
        {
          synchronized (Timing.this.mIdleCallbackGuard)
          {
            if (this.val$sendIdleEvents)
            {
              Timing.this.setChoreographerIdleCallback();
              return;
            }
            Timing.this.clearChoreographerIdleCallback();
          }
        }
      });
      return;
    }
  }

  private class IdleCallbackRunnable
    implements Runnable
  {
    private volatile boolean mCancelled = false;
    private final long mFrameStartTime;

    public IdleCallbackRunnable(long arg2)
    {
      Object localObject;
      this.mFrameStartTime = localObject;
    }

    public void cancel()
    {
      this.mCancelled = true;
    }

    public void run()
    {
      if (this.mCancelled);
      long l1;
      long l2;
      do
      {
        return;
        l1 = this.mFrameStartTime / 1000000L;
        l1 = SystemClock.uptimeMillis() - l1;
        l2 = SystemClock.currentTimeMillis();
      }
      while (16.666666F - (float)l1 < 1.0F);
      synchronized (Timing.this.mIdleCallbackGuard)
      {
        boolean bool = Timing.this.mSendIdleEvents;
        if (bool)
          ((JSTimers)Timing.this.getReactApplicationContext().getJSModule(JSTimers.class)).callIdleCallbacks(l2 - l1);
        Timing.access$1102(Timing.this, null);
        return;
      }
    }
  }

  private class IdleFrameCallback extends ChoreographerCompat.FrameCallback
  {
    private IdleFrameCallback()
    {
    }

    public void doFrame(long paramLong)
    {
      if ((Timing.this.isPaused.get()) && (!Timing.this.isRunningTasks.get()))
        return;
      if (Timing.this.mCurrentIdleCallbackRunnable != null)
        Timing.this.mCurrentIdleCallbackRunnable.cancel();
      Timing.access$1102(Timing.this, new Timing.IdleCallbackRunnable(Timing.this, paramLong));
      Timing.this.getReactApplicationContext().runOnJSQueueThread(Timing.this.mCurrentIdleCallbackRunnable);
      Timing.this.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this);
    }
  }

  private static class Timer
  {
    private final int mCallbackID;
    private final int mInterval;
    private final boolean mRepeat;
    private long mTargetTime;

    private Timer(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
    {
      this.mCallbackID = paramInt1;
      this.mTargetTime = paramLong;
      this.mInterval = paramInt2;
      this.mRepeat = paramBoolean;
    }
  }

  private class TimerFrameCallback extends ChoreographerCompat.FrameCallback
  {

    @Nullable
    private WritableArray mTimersToCall = null;

    private TimerFrameCallback()
    {
    }

    public void doFrame(long paramLong)
    {
      if ((Timing.this.isPaused.get()) && (!Timing.this.isRunningTasks.get()))
        return;
      paramLong /= 1000000L;
      while (true)
      {
        synchronized (Timing.this.mTimerGuard)
        {
          if ((Timing.this.mTimers.isEmpty()) || (((Timing.Timer)Timing.access$300(Timing.this).peek()).mTargetTime >= paramLong))
            break;
          Timing.Timer localTimer1 = (Timing.Timer)Timing.this.mTimers.poll();
          if (this.mTimersToCall != null)
            continue;
          this.mTimersToCall = Arguments.createArray();
          this.mTimersToCall.pushInt(localTimer1.mCallbackID);
          if (localTimer1.mRepeat)
          {
            Timing.Timer.access$402(localTimer1, localTimer1.mInterval + paramLong);
            Timing.this.mTimers.add(localTimer1);
          }
        }
        Timing.this.mTimerIdsToTimers.remove(localTimer2.mCallbackID);
      }
      monitorexit;
      if (this.mTimersToCall != null)
      {
        ((JSTimers)Timing.this.getReactApplicationContext().getJSModule(JSTimers.class)).callTimers(this.mTimersToCall);
        this.mTimersToCall = null;
      }
      Timing.this.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.core.Timing
 * JD-Core Version:    0.6.0
 */
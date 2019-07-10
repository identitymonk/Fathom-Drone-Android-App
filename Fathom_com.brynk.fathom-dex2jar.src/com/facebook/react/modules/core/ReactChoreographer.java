package com.facebook.react.modules.core;

import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.ArrayDeque;

public class ReactChoreographer
{
  private static ReactChoreographer sInstance;
  private final ArrayDeque<ChoreographerCompat.FrameCallback>[] mCallbackQueues = new ArrayDeque[CallbackType.values().length];
  private final ChoreographerCompat mChoreographer = ChoreographerCompat.getInstance();
  private boolean mHasPostedCallback = false;
  private final ReactChoreographerDispatcher mReactChoreographerDispatcher = new ReactChoreographerDispatcher(null);
  private int mTotalCallbacks = 0;

  private ReactChoreographer()
  {
    int i = 0;
    while (i < this.mCallbackQueues.length)
    {
      this.mCallbackQueues[i] = new ArrayDeque();
      i += 1;
    }
  }

  public static ReactChoreographer getInstance()
  {
    Assertions.assertNotNull(sInstance, "ReactChoreographer needs to be initialized.");
    return sInstance;
  }

  public static void initialize()
  {
    if (sInstance == null)
    {
      UiThreadUtil.assertOnUiThread();
      sInstance = new ReactChoreographer();
    }
  }

  private void maybeRemoveFrameCallback()
  {
    if (this.mTotalCallbacks >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool);
      if ((this.mTotalCallbacks == 0) && (this.mHasPostedCallback))
      {
        this.mChoreographer.removeFrameCallback(this.mReactChoreographerDispatcher);
        this.mHasPostedCallback = false;
      }
      return;
    }
  }

  public void postFrameCallback(CallbackType paramCallbackType, ChoreographerCompat.FrameCallback paramFrameCallback)
  {
    boolean bool = true;
    monitorenter;
    try
    {
      this.mCallbackQueues[paramCallbackType.getOrder()].addLast(paramFrameCallback);
      this.mTotalCallbacks += 1;
      if (this.mTotalCallbacks > 0);
      while (true)
      {
        Assertions.assertCondition(bool);
        if (!this.mHasPostedCallback)
        {
          this.mChoreographer.postFrameCallback(this.mReactChoreographerDispatcher);
          this.mHasPostedCallback = true;
        }
        return;
        bool = false;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramCallbackType;
  }

  public void removeFrameCallback(CallbackType paramCallbackType, ChoreographerCompat.FrameCallback paramFrameCallback)
  {
    monitorenter;
    try
    {
      if (this.mCallbackQueues[paramCallbackType.getOrder()].removeFirstOccurrence(paramFrameCallback))
      {
        this.mTotalCallbacks -= 1;
        maybeRemoveFrameCallback();
      }
      while (true)
      {
        return;
        FLog.e("ReactNative", "Tried to remove non-existent frame callback");
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramCallbackType;
  }

  public static enum CallbackType
  {
    private final int mOrder;

    static
    {
      DISPATCH_UI = new CallbackType("DISPATCH_UI", 1, 1);
      NATIVE_ANIMATED_MODULE = new CallbackType("NATIVE_ANIMATED_MODULE", 2, 2);
      TIMERS_EVENTS = new CallbackType("TIMERS_EVENTS", 3, 3);
      IDLE_EVENT = new CallbackType("IDLE_EVENT", 4, 4);
      $VALUES = new CallbackType[] { PERF_MARKERS, DISPATCH_UI, NATIVE_ANIMATED_MODULE, TIMERS_EVENTS, IDLE_EVENT };
    }

    private CallbackType(int paramInt)
    {
      this.mOrder = paramInt;
    }

    int getOrder()
    {
      return this.mOrder;
    }
  }

  private class ReactChoreographerDispatcher extends ChoreographerCompat.FrameCallback
  {
    private ReactChoreographerDispatcher()
    {
    }

    public void doFrame(long paramLong)
    {
      while (true)
      {
        int i;
        synchronized (ReactChoreographer.this)
        {
          ReactChoreographer.access$102(ReactChoreographer.this, false);
          i = 0;
          if (i >= ReactChoreographer.this.mCallbackQueues.length)
            continue;
          int k = ReactChoreographer.this.mCallbackQueues[i].size();
          int j = 0;
          if (j < k)
          {
            ((ChoreographerCompat.FrameCallback)ReactChoreographer.this.mCallbackQueues[i].removeFirst()).doFrame(paramLong);
            ReactChoreographer.access$310(ReactChoreographer.this);
            j += 1;
            continue;
            ReactChoreographer.this.maybeRemoveFrameCallback();
            return;
          }
        }
        i += 1;
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.core.ReactChoreographer
 * JD-Core Version:    0.6.0
 */
package com.facebook.react.uimanager.events;

import android.util.LongSparseArray;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.facebook.systrace.Systrace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

public class EventDispatcher
  implements LifecycleEventListener
{
  private static final Comparator<Event> EVENT_COMPARATOR = new Comparator()
  {
    public int compare(Event paramEvent1, Event paramEvent2)
    {
      if ((paramEvent1 == null) && (paramEvent2 == null));
      long l;
      do
      {
        return 0;
        if (paramEvent1 == null)
          return -1;
        if (paramEvent2 == null)
          return 1;
        l = paramEvent1.getTimestampMs() - paramEvent2.getTimestampMs();
      }
      while (l == 0L);
      if (l < 0L)
        return -1;
      return 1;
    }
  };
  private final ScheduleDispatchFrameCallback mCurrentFrameCallback = new ScheduleDispatchFrameCallback(null);
  private final DispatchEventsRunnable mDispatchEventsRunnable = new DispatchEventsRunnable(null);
  private final LongSparseArray<Integer> mEventCookieToLastEventIdx = new LongSparseArray();
  private final Map<String, Short> mEventNameToEventId = MapBuilder.newHashMap();
  private final ArrayList<Event> mEventStaging = new ArrayList();
  private final Object mEventsStagingLock = new Object();
  private Event[] mEventsToDispatch = new Event[16];
  private final Object mEventsToDispatchLock = new Object();
  private int mEventsToDispatchSize = 0;
  private volatile boolean mHasDispatchScheduled = false;
  private final AtomicInteger mHasDispatchScheduledCount = new AtomicInteger();
  private final ArrayList<EventDispatcherListener> mListeners = new ArrayList();
  private short mNextEventTypeId = 0;

  @Nullable
  private volatile RCTEventEmitter mRCTEventEmitter;
  private final ReactApplicationContext mReactContext;

  public EventDispatcher(ReactApplicationContext paramReactApplicationContext)
  {
    this.mReactContext = paramReactApplicationContext;
    this.mReactContext.addLifecycleEventListener(this);
  }

  private void addEventToEventsToDispatch(Event paramEvent)
  {
    if (this.mEventsToDispatchSize == this.mEventsToDispatch.length)
      this.mEventsToDispatch = ((Event[])Arrays.copyOf(this.mEventsToDispatch, this.mEventsToDispatch.length * 2));
    Event[] arrayOfEvent = this.mEventsToDispatch;
    int i = this.mEventsToDispatchSize;
    this.mEventsToDispatchSize = (i + 1);
    arrayOfEvent[i] = paramEvent;
  }

  private void clearEventsToDispatch()
  {
    Arrays.fill(this.mEventsToDispatch, 0, this.mEventsToDispatchSize, null);
    this.mEventsToDispatchSize = 0;
  }

  private long getEventCookie(int paramInt, String paramString, short paramShort)
  {
    Short localShort = (Short)this.mEventNameToEventId.get(paramString);
    short s;
    if (localShort != null)
      s = localShort.shortValue();
    while (true)
    {
      return getEventCookie(paramInt, s, paramShort);
      s = this.mNextEventTypeId;
      this.mNextEventTypeId = (short)(s + 1);
      this.mEventNameToEventId.put(paramString, Short.valueOf(s));
    }
  }

  private static long getEventCookie(int paramInt, short paramShort1, short paramShort2)
  {
    return paramInt | (paramShort1 & 0xFFFF) << 32 | (paramShort2 & 0xFFFF) << 48;
  }

  private void moveStagedEventsToDispatchQueue()
  {
    while (true)
    {
      Object localObject7;
      int i;
      long l;
      Object localObject5;
      Integer localInteger;
      synchronized (this.mEventsStagingLock)
      {
        localObject7 = this.mEventsToDispatchLock;
        monitorenter;
        i = 0;
        try
        {
          if (i >= this.mEventStaging.size())
            break label221;
          Event localEvent1 = (Event)this.mEventStaging.get(i);
          if (localEvent1.canCoalesce())
            continue;
          addEventToEventsToDispatch(localEvent1);
          break label235;
          l = getEventCookie(localEvent1.getViewTag(), localEvent1.getEventName(), localEvent1.getCoalescingKey());
          localObject5 = null;
          localObject4 = null;
          localInteger = (Integer)this.mEventCookieToLastEventIdx.get(l);
          if (localInteger == null)
          {
            this.mEventCookieToLastEventIdx.put(l, Integer.valueOf(this.mEventsToDispatchSize));
            if (localEvent1 == null)
              continue;
            addEventToEventsToDispatch(localEvent1);
            if (localObject4 == null)
              break label235;
            ((Event)localObject4).dispose();
          }
        }
        finally
        {
          monitorexit;
        }
      }
      Object localObject4 = this.mEventsToDispatch[localInteger.intValue()];
      Event localEvent2 = localObject2.coalesce((Event)localObject4);
      if (localEvent2 != localObject4)
      {
        localObject3 = localEvent2;
        this.mEventCookieToLastEventIdx.put(l, Integer.valueOf(this.mEventsToDispatchSize));
        this.mEventsToDispatch[localInteger.intValue()] = null;
        continue;
        label221: monitorexit;
        this.mEventStaging.clear();
        monitorexit;
        return;
        label235: i += 1;
        continue;
      }
      localObject4 = localObject3;
      Object localObject3 = localObject5;
    }
  }

  private void stopFrameCallback()
  {
    UiThreadUtil.assertOnUiThread();
    this.mCurrentFrameCallback.stop();
  }

  public void addListener(EventDispatcherListener paramEventDispatcherListener)
  {
    this.mListeners.add(paramEventDispatcherListener);
  }

  public void dispatchEvent(Event paramEvent)
  {
    Assertions.assertCondition(paramEvent.isInitialized(), "Dispatched event hasn't been initialized");
    ??? = this.mListeners.iterator();
    while (((Iterator)???).hasNext())
      ((EventDispatcherListener)((Iterator)???).next()).onEventDispatch(paramEvent);
    synchronized (this.mEventsStagingLock)
    {
      this.mEventStaging.add(paramEvent);
      Systrace.startAsyncFlow(0L, paramEvent.getEventName(), paramEvent.getUniqueID());
      if (this.mRCTEventEmitter != null)
        this.mCurrentFrameCallback.maybePostFromNonUI();
      return;
    }
  }

  public void onCatalystInstanceDestroyed()
  {
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        EventDispatcher.this.stopFrameCallback();
      }
    });
  }

  public void onHostDestroy()
  {
    stopFrameCallback();
  }

  public void onHostPause()
  {
    stopFrameCallback();
  }

  public void onHostResume()
  {
    if (this.mRCTEventEmitter == null)
      this.mRCTEventEmitter = ((RCTEventEmitter)this.mReactContext.getJSModule(RCTEventEmitter.class));
    this.mCurrentFrameCallback.maybePostFromNonUI();
  }

  public void removeListener(EventDispatcherListener paramEventDispatcherListener)
  {
    this.mListeners.remove(paramEventDispatcherListener);
  }

  private class DispatchEventsRunnable
    implements Runnable
  {
    private DispatchEventsRunnable()
    {
    }

    public void run()
    {
      Systrace.beginSection(0L, "DispatchEventsRunnable");
      while (true)
      {
        try
        {
          Systrace.endAsyncFlow(0L, "ScheduleDispatchFrameCallback", EventDispatcher.this.mHasDispatchScheduledCount.getAndIncrement());
          EventDispatcher.access$502(EventDispatcher.this, false);
          Assertions.assertNotNull(EventDispatcher.this.mRCTEventEmitter);
          synchronized (EventDispatcher.this.mEventsToDispatchLock)
          {
            if (EventDispatcher.this.mEventsToDispatchSize <= 1)
              break label181;
            Arrays.sort(EventDispatcher.this.mEventsToDispatch, 0, EventDispatcher.this.mEventsToDispatchSize, EventDispatcher.EVENT_COMPARATOR);
            break label181;
            if (i < EventDispatcher.this.mEventsToDispatchSize)
            {
              Event localEvent = EventDispatcher.this.mEventsToDispatch[i];
              if (localEvent == null)
                break label186;
              Systrace.endAsyncFlow(0L, localEvent.getEventName(), localEvent.getUniqueID());
              localEvent.dispatch(EventDispatcher.this.mRCTEventEmitter);
              localEvent.dispose();
            }
          }
        }
        finally
        {
          Systrace.endSection(0L);
        }
        EventDispatcher.this.clearEventsToDispatch();
        EventDispatcher.this.mEventCookieToLastEventIdx.clear();
        monitorexit;
        Systrace.endSection(0L);
        return;
        label181: int i = 0;
        continue;
        label186: i += 1;
      }
    }
  }

  private class ScheduleDispatchFrameCallback extends ChoreographerCompat.FrameCallback
  {
    private volatile boolean mIsPosted = false;
    private boolean mShouldStop = false;

    private ScheduleDispatchFrameCallback()
    {
    }

    private void post()
    {
      ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, EventDispatcher.this.mCurrentFrameCallback);
    }

    public void doFrame(long paramLong)
    {
      UiThreadUtil.assertOnUiThread();
      if (this.mShouldStop)
        this.mIsPosted = false;
      while (true)
      {
        Systrace.beginSection(0L, "ScheduleDispatchFrameCallback");
        try
        {
          EventDispatcher.this.moveStagedEventsToDispatchQueue();
          if ((EventDispatcher.this.mEventsToDispatchSize > 0) && (!EventDispatcher.this.mHasDispatchScheduled))
          {
            EventDispatcher.access$502(EventDispatcher.this, true);
            Systrace.startAsyncFlow(0L, "ScheduleDispatchFrameCallback", EventDispatcher.this.mHasDispatchScheduledCount.get());
            EventDispatcher.this.mReactContext.runOnJSQueueThread(EventDispatcher.this.mDispatchEventsRunnable);
          }
          return;
          post();
        }
        finally
        {
          Systrace.endSection(0L);
        }
      }
    }

    public void maybePost()
    {
      if (!this.mIsPosted)
      {
        this.mIsPosted = true;
        post();
      }
    }

    public void maybePostFromNonUI()
    {
      if (this.mIsPosted)
        return;
      if (EventDispatcher.this.mReactContext.isOnUiQueueThread())
      {
        maybePost();
        return;
      }
      EventDispatcher.this.mReactContext.runOnUiQueueThread(new Runnable()
      {
        public void run()
        {
          EventDispatcher.ScheduleDispatchFrameCallback.this.maybePost();
        }
      });
    }

    public void stop()
    {
      this.mShouldStop = true;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.events.EventDispatcher
 * JD-Core Version:    0.6.0
 */
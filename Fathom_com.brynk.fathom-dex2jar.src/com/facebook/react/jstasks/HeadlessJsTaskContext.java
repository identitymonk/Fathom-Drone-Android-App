package com.facebook.react.jstasks;

import android.os.Handler;
import android.util.SparseArray;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.appregistry.AppRegistry;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class HeadlessJsTaskContext
{
  private static final WeakHashMap<ReactContext, HeadlessJsTaskContext> INSTANCES = new WeakHashMap();
  private final Set<Integer> mActiveTasks = new CopyOnWriteArraySet();
  private final Handler mHandler = new Handler();
  private final Set<HeadlessJsTaskEventListener> mHeadlessJsTaskEventListeners = new CopyOnWriteArraySet();
  private final AtomicInteger mLastTaskId = new AtomicInteger(0);
  private final WeakReference<ReactContext> mReactContext;
  private final SparseArray<Runnable> mTaskTimeouts = new SparseArray();

  private HeadlessJsTaskContext(ReactContext paramReactContext)
  {
    this.mReactContext = new WeakReference(paramReactContext);
  }

  public static HeadlessJsTaskContext getInstance(ReactContext paramReactContext)
  {
    HeadlessJsTaskContext localHeadlessJsTaskContext2 = (HeadlessJsTaskContext)INSTANCES.get(paramReactContext);
    HeadlessJsTaskContext localHeadlessJsTaskContext1 = localHeadlessJsTaskContext2;
    if (localHeadlessJsTaskContext2 == null)
    {
      localHeadlessJsTaskContext1 = new HeadlessJsTaskContext(paramReactContext);
      INSTANCES.put(paramReactContext, localHeadlessJsTaskContext1);
    }
    return localHeadlessJsTaskContext1;
  }

  private void scheduleTaskTimeout(int paramInt, long paramLong)
  {
    2 local2 = new Runnable(paramInt)
    {
      public void run()
      {
        HeadlessJsTaskContext.this.finishTask(this.val$taskId);
      }
    };
    this.mTaskTimeouts.append(paramInt, local2);
    this.mHandler.postDelayed(local2, paramLong);
  }

  public void addTaskEventListener(HeadlessJsTaskEventListener paramHeadlessJsTaskEventListener)
  {
    this.mHeadlessJsTaskEventListeners.add(paramHeadlessJsTaskEventListener);
  }

  public void finishTask(int paramInt)
  {
    monitorenter;
    try
    {
      Assertions.assertCondition(this.mActiveTasks.remove(Integer.valueOf(paramInt)), "Tried to finish non-existent task with id " + paramInt + ".");
      Runnable localRunnable = (Runnable)this.mTaskTimeouts.get(paramInt);
      if (localRunnable != null)
      {
        this.mHandler.removeCallbacks(localRunnable);
        this.mTaskTimeouts.remove(paramInt);
      }
      UiThreadUtil.runOnUiThread(new Runnable(paramInt)
      {
        public void run()
        {
          Iterator localIterator = HeadlessJsTaskContext.this.mHeadlessJsTaskEventListeners.iterator();
          while (localIterator.hasNext())
            ((HeadlessJsTaskEventListener)localIterator.next()).onHeadlessJsTaskFinish(this.val$taskId);
        }
      });
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean hasActiveTasks()
  {
    return this.mActiveTasks.size() > 0;
  }

  public boolean isTaskRunning(int paramInt)
  {
    monitorenter;
    try
    {
      boolean bool = this.mActiveTasks.contains(Integer.valueOf(paramInt));
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void removeTaskEventListener(HeadlessJsTaskEventListener paramHeadlessJsTaskEventListener)
  {
    this.mHeadlessJsTaskEventListeners.remove(paramHeadlessJsTaskEventListener);
  }

  public int startTask(HeadlessJsTaskConfig paramHeadlessJsTaskConfig)
  {
    monitorenter;
    ReactContext localReactContext;
    try
    {
      UiThreadUtil.assertOnUiThread();
      localReactContext = (ReactContext)Assertions.assertNotNull(this.mReactContext.get(), "Tried to start a task on a react context that has already been destroyed");
      if ((localReactContext.getLifecycleState() == LifecycleState.RESUMED) && (!paramHeadlessJsTaskConfig.isAllowedInForeground()))
        throw new IllegalStateException("Tried to start task " + paramHeadlessJsTaskConfig.getTaskKey() + " while in foreground, but this is not allowed.");
    }
    finally
    {
      monitorexit;
    }
    int i = this.mLastTaskId.incrementAndGet();
    this.mActiveTasks.add(Integer.valueOf(i));
    ((AppRegistry)localReactContext.getJSModule(AppRegistry.class)).startHeadlessTask(i, paramHeadlessJsTaskConfig.getTaskKey(), paramHeadlessJsTaskConfig.getData());
    if (paramHeadlessJsTaskConfig.getTimeout() > 0L)
      scheduleTaskTimeout(i, paramHeadlessJsTaskConfig.getTimeout());
    paramHeadlessJsTaskConfig = this.mHeadlessJsTaskEventListeners.iterator();
    while (paramHeadlessJsTaskConfig.hasNext())
      ((HeadlessJsTaskEventListener)paramHeadlessJsTaskConfig.next()).onHeadlessJsTaskStart(i);
    monitorexit;
    return i;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.jstasks.HeadlessJsTaskContext
 * JD-Core Version:    0.6.0
 */
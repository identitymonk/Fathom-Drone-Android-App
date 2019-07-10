package com.facebook.react.modules.debug;

import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.common.LongArray;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;

public class DidJSUpdateUiDuringFrameDetector
  implements NotThreadSafeBridgeIdleDebugListener, NotThreadSafeViewHierarchyUpdateDebugListener
{
  private final LongArray mTransitionToBusyEvents = LongArray.createWithInitialCapacity(20);
  private final LongArray mTransitionToIdleEvents = LongArray.createWithInitialCapacity(20);
  private final LongArray mViewHierarchyUpdateEnqueuedEvents = LongArray.createWithInitialCapacity(20);
  private final LongArray mViewHierarchyUpdateFinishedEvents = LongArray.createWithInitialCapacity(20);
  private volatile boolean mWasIdleAtEndOfLastFrame = true;

  private static void cleanUp(LongArray paramLongArray, long paramLong)
  {
    int m = paramLongArray.size();
    int i = 0;
    int j = 0;
    while (j < m)
    {
      int k = i;
      if (paramLongArray.get(j) < paramLong)
        k = i + 1;
      j += 1;
      i = k;
    }
    if (i > 0)
    {
      j = 0;
      while (j < m - i)
      {
        paramLongArray.set(j, paramLongArray.get(j + i));
        j += 1;
      }
      paramLongArray.dropTail(i);
    }
  }

  private boolean didEndFrameIdle(long paramLong1, long paramLong2)
  {
    long l = getLastEventBetweenTimestamps(this.mTransitionToIdleEvents, paramLong1, paramLong2);
    paramLong1 = getLastEventBetweenTimestamps(this.mTransitionToBusyEvents, paramLong1, paramLong2);
    if ((l == -1L) && (paramLong1 == -1L))
      return this.mWasIdleAtEndOfLastFrame;
    return l > paramLong1;
  }

  private static long getLastEventBetweenTimestamps(LongArray paramLongArray, long paramLong1, long paramLong2)
  {
    long l1 = -1L;
    int i = 0;
    if (i < paramLongArray.size())
    {
      long l3 = paramLongArray.get(i);
      long l2;
      if ((l3 >= paramLong1) && (l3 < paramLong2))
        l2 = l3;
      do
      {
        i += 1;
        l1 = l2;
        break;
        l2 = l1;
      }
      while (l3 < paramLong2);
    }
    return l1;
  }

  private static boolean hasEventBetweenTimestamps(LongArray paramLongArray, long paramLong1, long paramLong2)
  {
    int i = 0;
    while (i < paramLongArray.size())
    {
      long l = paramLongArray.get(i);
      if ((l >= paramLong1) && (l < paramLong2))
        return true;
      i += 1;
    }
    return false;
  }

  public boolean getDidJSHitFrameAndCleanup(long paramLong1, long paramLong2)
  {
    monitorenter;
    try
    {
      boolean bool1 = hasEventBetweenTimestamps(this.mViewHierarchyUpdateFinishedEvents, paramLong1, paramLong2);
      boolean bool2 = didEndFrameIdle(paramLong1, paramLong2);
      if (bool1)
      {
        bool1 = true;
        cleanUp(this.mTransitionToIdleEvents, paramLong2);
        cleanUp(this.mTransitionToBusyEvents, paramLong2);
        cleanUp(this.mViewHierarchyUpdateEnqueuedEvents, paramLong2);
        cleanUp(this.mViewHierarchyUpdateFinishedEvents, paramLong2);
        this.mWasIdleAtEndOfLastFrame = bool2;
        return bool1;
      }
      if (bool2)
      {
        bool1 = hasEventBetweenTimestamps(this.mViewHierarchyUpdateEnqueuedEvents, paramLong1, paramLong2);
        if (bool1);
      }
      for (bool1 = true; ; bool1 = false)
        break;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void onTransitionToBridgeBusy()
  {
    monitorenter;
    try
    {
      this.mTransitionToBusyEvents.add(System.nanoTime());
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void onTransitionToBridgeIdle()
  {
    monitorenter;
    try
    {
      this.mTransitionToIdleEvents.add(System.nanoTime());
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void onViewHierarchyUpdateEnqueued()
  {
    monitorenter;
    try
    {
      this.mViewHierarchyUpdateEnqueuedEvents.add(System.nanoTime());
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void onViewHierarchyUpdateFinished()
  {
    monitorenter;
    try
    {
      this.mViewHierarchyUpdateFinishedEvents.add(System.nanoTime());
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.debug.DidJSUpdateUiDuringFrameDetector
 * JD-Core Version:    0.6.0
 */
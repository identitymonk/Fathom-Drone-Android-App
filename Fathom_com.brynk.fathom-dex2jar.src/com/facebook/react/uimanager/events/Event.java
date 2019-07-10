package com.facebook.react.uimanager.events;

import com.facebook.react.common.SystemClock;

public abstract class Event<T extends Event>
{
  private static int sUniqueID = 0;
  private boolean mInitialized;
  private long mTimestampMs;
  private int mUniqueID;
  private int mViewTag;

  protected Event()
  {
    int i = sUniqueID;
    sUniqueID = i + 1;
    this.mUniqueID = i;
  }

  protected Event(int paramInt)
  {
    int i = sUniqueID;
    sUniqueID = i + 1;
    this.mUniqueID = i;
    init(paramInt);
  }

  public boolean canCoalesce()
  {
    return true;
  }

  public T coalesce(T paramT)
  {
    if (getTimestampMs() >= paramT.getTimestampMs())
      return this;
    return paramT;
  }

  public abstract void dispatch(RCTEventEmitter paramRCTEventEmitter);

  final void dispose()
  {
    this.mInitialized = false;
    onDispose();
  }

  public short getCoalescingKey()
  {
    return 0;
  }

  public abstract String getEventName();

  public final long getTimestampMs()
  {
    return this.mTimestampMs;
  }

  public int getUniqueID()
  {
    return this.mUniqueID;
  }

  public final int getViewTag()
  {
    return this.mViewTag;
  }

  protected void init(int paramInt)
  {
    this.mViewTag = paramInt;
    this.mTimestampMs = SystemClock.uptimeMillis();
    this.mInitialized = true;
  }

  boolean isInitialized()
  {
    return this.mInitialized;
  }

  public void onDispose()
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.events.Event
 * JD-Core Version:    0.6.0
 */
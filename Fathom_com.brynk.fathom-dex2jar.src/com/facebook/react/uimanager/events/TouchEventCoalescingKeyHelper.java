package com.facebook.react.uimanager.events;

import android.util.SparseIntArray;

public class TouchEventCoalescingKeyHelper
{
  private final SparseIntArray mDownTimeToCoalescingKey = new SparseIntArray();

  public void addCoalescingKey(long paramLong)
  {
    this.mDownTimeToCoalescingKey.put((int)paramLong, 0);
  }

  public short getCoalescingKey(long paramLong)
  {
    int i = this.mDownTimeToCoalescingKey.get((int)paramLong, -1);
    if (i == -1)
      throw new RuntimeException("Tried to get non-existent cookie");
    return (short)(0xFFFF & i);
  }

  public boolean hasCoalescingKey(long paramLong)
  {
    return this.mDownTimeToCoalescingKey.get((int)paramLong, -1) != -1;
  }

  public void incrementCoalescingKey(long paramLong)
  {
    int i = this.mDownTimeToCoalescingKey.get((int)paramLong, -1);
    if (i == -1)
      throw new RuntimeException("Tried to increment non-existent cookie");
    this.mDownTimeToCoalescingKey.put((int)paramLong, i + 1);
  }

  public void removeCoalescingKey(long paramLong)
  {
    this.mDownTimeToCoalescingKey.delete((int)paramLong);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.events.TouchEventCoalescingKeyHelper
 * JD-Core Version:    0.6.0
 */
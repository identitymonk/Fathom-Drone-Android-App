package com.facebook.react.bridge;

import javax.annotation.concurrent.GuardedBy;

public class JavaScriptContextHolder
{

  @GuardedBy("this")
  private long mContext;

  public JavaScriptContextHolder(long paramLong)
  {
    this.mContext = paramLong;
  }

  public void clear()
  {
    monitorenter;
    try
    {
      this.mContext = 0L;
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

  @GuardedBy("this")
  public long get()
  {
    return this.mContext;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JavaScriptContextHolder
 * JD-Core Version:    0.6.0
 */
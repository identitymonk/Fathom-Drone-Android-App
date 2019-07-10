package com.facebook.react.common;

import android.support.v4.util.Pools.Pool;

public class ClearableSynchronizedPool<T>
  implements Pools.Pool<T>
{
  private final Object[] mPool;
  private int mSize = 0;

  public ClearableSynchronizedPool(int paramInt)
  {
    this.mPool = new Object[paramInt];
  }

  public T acquire()
  {
    Object localObject1 = null;
    monitorenter;
    try
    {
      int i = this.mSize;
      if (i == 0);
      while (true)
      {
        return localObject1;
        this.mSize -= 1;
        i = this.mSize;
        localObject1 = this.mPool[i];
        this.mPool[i] = null;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject2;
  }

  public void clear()
  {
    monitorenter;
    int i = 0;
    try
    {
      while (i < this.mSize)
      {
        this.mPool[i] = null;
        i += 1;
      }
      this.mSize = 0;
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean release(T paramT)
  {
    monitorenter;
    try
    {
      int i = this.mSize;
      int j = this.mPool.length;
      if (i == j);
      for (int k = 0; ; k = 1)
      {
        return k;
        this.mPool[this.mSize] = paramT;
        this.mSize += 1;
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramT;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.common.ClearableSynchronizedPool
 * JD-Core Version:    0.6.0
 */
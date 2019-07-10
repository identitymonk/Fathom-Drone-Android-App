package com.facebook.react.uimanager;

import com.facebook.react.common.ClearableSynchronizedPool;
import com.facebook.yoga.YogaNode;

public class YogaNodePool
{
  private static final Object sInitLock = new Object();
  private static ClearableSynchronizedPool<YogaNode> sPool;

  public static ClearableSynchronizedPool<YogaNode> get()
  {
    if (sPool != null)
      return sPool;
    synchronized (sInitLock)
    {
      if (sPool == null)
        sPool = new ClearableSynchronizedPool(1024);
      ClearableSynchronizedPool localClearableSynchronizedPool = sPool;
      return localClearableSynchronizedPool;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.YogaNodePool
 * JD-Core Version:    0.6.0
 */
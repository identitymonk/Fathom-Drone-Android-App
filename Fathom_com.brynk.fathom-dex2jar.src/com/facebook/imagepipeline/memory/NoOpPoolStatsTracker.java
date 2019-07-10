package com.facebook.imagepipeline.memory;

public class NoOpPoolStatsTracker
  implements PoolStatsTracker
{
  private static NoOpPoolStatsTracker sInstance = null;

  public static NoOpPoolStatsTracker getInstance()
  {
    monitorenter;
    try
    {
      if (sInstance == null)
        sInstance = new NoOpPoolStatsTracker();
      NoOpPoolStatsTracker localNoOpPoolStatsTracker = sInstance;
      return localNoOpPoolStatsTracker;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void onAlloc(int paramInt)
  {
  }

  public void onFree(int paramInt)
  {
  }

  public void onHardCapReached()
  {
  }

  public void onSoftCapReached()
  {
  }

  public void onValueRelease(int paramInt)
  {
  }

  public void onValueReuse(int paramInt)
  {
  }

  public void setBasePool(BasePool paramBasePool)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.memory.NoOpPoolStatsTracker
 * JD-Core Version:    0.6.0
 */
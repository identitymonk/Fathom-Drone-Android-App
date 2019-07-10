package com.facebook.common.memory;

public class NoOpMemoryTrimmableRegistry
  implements MemoryTrimmableRegistry
{
  private static NoOpMemoryTrimmableRegistry sInstance = null;

  public static NoOpMemoryTrimmableRegistry getInstance()
  {
    monitorenter;
    try
    {
      if (sInstance == null)
        sInstance = new NoOpMemoryTrimmableRegistry();
      NoOpMemoryTrimmableRegistry localNoOpMemoryTrimmableRegistry = sInstance;
      return localNoOpMemoryTrimmableRegistry;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void registerMemoryTrimmable(MemoryTrimmable paramMemoryTrimmable)
  {
  }

  public void unregisterMemoryTrimmable(MemoryTrimmable paramMemoryTrimmable)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.memory.NoOpMemoryTrimmableRegistry
 * JD-Core Version:    0.6.0
 */
package com.facebook.common.disk;

public class NoOpDiskTrimmableRegistry
  implements DiskTrimmableRegistry
{
  private static NoOpDiskTrimmableRegistry sInstance = null;

  public static NoOpDiskTrimmableRegistry getInstance()
  {
    monitorenter;
    try
    {
      if (sInstance == null)
        sInstance = new NoOpDiskTrimmableRegistry();
      NoOpDiskTrimmableRegistry localNoOpDiskTrimmableRegistry = sInstance;
      return localNoOpDiskTrimmableRegistry;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void registerDiskTrimmable(DiskTrimmable paramDiskTrimmable)
  {
  }

  public void unregisterDiskTrimmable(DiskTrimmable paramDiskTrimmable)
  {
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.disk.NoOpDiskTrimmableRegistry
 * JD-Core Version:    0.6.0
 */
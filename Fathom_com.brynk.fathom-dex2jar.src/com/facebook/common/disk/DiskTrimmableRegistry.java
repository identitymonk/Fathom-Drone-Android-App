package com.facebook.common.disk;

public abstract interface DiskTrimmableRegistry
{
  public abstract void registerDiskTrimmable(DiskTrimmable paramDiskTrimmable);

  public abstract void unregisterDiskTrimmable(DiskTrimmable paramDiskTrimmable);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.disk.DiskTrimmableRegistry
 * JD-Core Version:    0.6.0
 */
package com.facebook.common.memory;

public abstract interface MemoryTrimmableRegistry
{
  public abstract void registerMemoryTrimmable(MemoryTrimmable paramMemoryTrimmable);

  public abstract void unregisterMemoryTrimmable(MemoryTrimmable paramMemoryTrimmable);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.memory.MemoryTrimmableRegistry
 * JD-Core Version:    0.6.0
 */
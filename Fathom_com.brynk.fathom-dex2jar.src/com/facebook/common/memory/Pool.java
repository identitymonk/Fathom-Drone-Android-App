package com.facebook.common.memory;

import com.facebook.common.references.ResourceReleaser;

public abstract interface Pool<V> extends ResourceReleaser<V>, MemoryTrimmable
{
  public abstract V get(int paramInt);

  public abstract void release(V paramV);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.memory.Pool
 * JD-Core Version:    0.6.0
 */
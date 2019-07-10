package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T>
  implements DataBuffer<T>
{
  protected final DataHolder zy;

  protected AbstractDataBuffer(DataHolder paramDataHolder)
  {
    this.zy = paramDataHolder;
    if (this.zy != null);
  }

  @Deprecated
  public final void close()
  {
    release();
  }

  public abstract T get(int paramInt);

  public int getCount()
  {
    if (this.zy == null)
      return 0;
    return this.zy.getCount();
  }

  @Deprecated
  public boolean isClosed()
  {
    return (this.zy == null) || (this.zy.isClosed());
  }

  public Iterator<T> iterator()
  {
    return new zzb(this);
  }

  public void release()
  {
    if (this.zy != null)
      this.zy.close();
  }

  public Iterator<T> singleRefIterator()
  {
    return new zzg(this);
  }

  public Bundle zzaui()
  {
    return this.zy.zzaui();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.AbstractDataBuffer
 * JD-Core Version:    0.6.0
 */
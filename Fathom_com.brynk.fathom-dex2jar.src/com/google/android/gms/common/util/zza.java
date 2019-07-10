package com.google.android.gms.common.util;

import android.support.v4.util.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class zza<E> extends AbstractSet<E>
{
  private final ArrayMap<E, E> Gp;

  public zza()
  {
    this.Gp = new ArrayMap();
  }

  public zza(int paramInt)
  {
    this.Gp = new ArrayMap(paramInt);
  }

  public zza(Collection<E> paramCollection)
  {
    this(paramCollection.size());
    addAll(paramCollection);
  }

  public boolean add(E paramE)
  {
    if (this.Gp.containsKey(paramE))
      return false;
    this.Gp.put(paramE, paramE);
    return true;
  }

  public boolean addAll(Collection<? extends E> paramCollection)
  {
    if ((paramCollection instanceof zza))
      return zza((zza)paramCollection);
    return super.addAll(paramCollection);
  }

  public void clear()
  {
    this.Gp.clear();
  }

  public boolean contains(Object paramObject)
  {
    return this.Gp.containsKey(paramObject);
  }

  public Iterator<E> iterator()
  {
    return this.Gp.keySet().iterator();
  }

  public boolean remove(Object paramObject)
  {
    if (!this.Gp.containsKey(paramObject))
      return false;
    this.Gp.remove(paramObject);
    return true;
  }

  public int size()
  {
    return this.Gp.size();
  }

  public boolean zza(zza<? extends E> paramzza)
  {
    int i = size();
    this.Gp.putAll(paramzza.Gp);
    return size() > i;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.zza
 * JD-Core Version:    0.6.0
 */
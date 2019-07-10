package com.google.android.gms.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class zzapw<K, V> extends AbstractMap<K, V>
  implements Serializable
{
  private static final Comparator<Comparable> bpi;
  Comparator<? super K> bab;
  zzd<K, V> bpj;
  final zzd<K, V> bpk = new zzd();
  private zza bpl;
  private zzb bpm;
  int modCount = 0;
  int size = 0;

  static
  {
    if (!zzapw.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      bpi = new Comparator()
      {
        public int zza(Comparable paramComparable1, Comparable paramComparable2)
        {
          return paramComparable1.compareTo(paramComparable2);
        }
      };
      return;
    }
  }

  public zzapw()
  {
    this(bpi);
  }

  public zzapw(Comparator<? super K> paramComparator)
  {
    if (paramComparator != null);
    while (true)
    {
      this.bab = paramComparator;
      return;
      paramComparator = bpi;
    }
  }

  private boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  private void zza(zzd<K, V> paramzzd)
  {
    int k = 0;
    zzd localzzd1 = paramzzd.bpu;
    zzd localzzd2 = paramzzd.bpv;
    zzd localzzd3 = localzzd2.bpu;
    zzd localzzd4 = localzzd2.bpv;
    paramzzd.bpv = localzzd3;
    if (localzzd3 != null)
      localzzd3.bpt = paramzzd;
    zza(paramzzd, localzzd2);
    localzzd2.bpu = paramzzd;
    paramzzd.bpt = localzzd2;
    int i;
    if (localzzd1 != null)
    {
      i = localzzd1.height;
      if (localzzd3 == null)
        break label135;
    }
    label135: for (int j = localzzd3.height; ; j = 0)
    {
      paramzzd.height = (Math.max(i, j) + 1);
      j = paramzzd.height;
      i = k;
      if (localzzd4 != null)
        i = localzzd4.height;
      localzzd2.height = (Math.max(j, i) + 1);
      return;
      i = 0;
      break;
    }
  }

  private void zza(zzd<K, V> paramzzd1, zzd<K, V> paramzzd2)
  {
    zzd localzzd = paramzzd1.bpt;
    paramzzd1.bpt = null;
    if (paramzzd2 != null)
      paramzzd2.bpt = localzzd;
    if (localzzd != null)
    {
      if (localzzd.bpu == paramzzd1)
      {
        localzzd.bpu = paramzzd2;
        return;
      }
      assert (localzzd.bpv == paramzzd1);
      localzzd.bpv = paramzzd2;
      return;
    }
    this.bpj = paramzzd2;
  }

  private void zzb(zzd<K, V> paramzzd)
  {
    int k = 0;
    zzd localzzd1 = paramzzd.bpu;
    zzd localzzd2 = paramzzd.bpv;
    zzd localzzd3 = localzzd1.bpu;
    zzd localzzd4 = localzzd1.bpv;
    paramzzd.bpu = localzzd4;
    if (localzzd4 != null)
      localzzd4.bpt = paramzzd;
    zza(paramzzd, localzzd1);
    localzzd1.bpv = paramzzd;
    paramzzd.bpt = localzzd1;
    int i;
    if (localzzd2 != null)
    {
      i = localzzd2.height;
      if (localzzd4 == null)
        break label135;
    }
    label135: for (int j = localzzd4.height; ; j = 0)
    {
      paramzzd.height = (Math.max(i, j) + 1);
      j = paramzzd.height;
      i = k;
      if (localzzd3 != null)
        i = localzzd3.height;
      localzzd1.height = (Math.max(j, i) + 1);
      return;
      i = 0;
      break;
    }
  }

  private void zzb(zzd<K, V> paramzzd, boolean paramBoolean)
  {
    zzd localzzd1;
    zzd localzzd2;
    int i;
    int j;
    label39: int k;
    zzd localzzd3;
    if (paramzzd != null)
    {
      localzzd1 = paramzzd.bpu;
      localzzd2 = paramzzd.bpv;
      if (localzzd1 == null)
        break label117;
      i = localzzd1.height;
      if (localzzd2 == null)
        break label122;
      j = localzzd2.height;
      k = i - j;
      if (k != -2)
        break label172;
      localzzd1 = localzzd2.bpu;
      localzzd3 = localzzd2.bpv;
      if (localzzd3 == null)
        break label128;
      i = localzzd3.height;
      label77: if (localzzd1 == null)
        break label133;
      j = localzzd1.height;
      label89: i = j - i;
      if ((i != -1) && ((i != 0) || (paramBoolean)))
        break label139;
      zza(paramzzd);
    }
    while (true)
    {
      if (!paramBoolean)
        break label242;
      label116: return;
      label117: i = 0;
      break;
      label122: j = 0;
      break label39;
      label128: i = 0;
      break label77;
      label133: j = 0;
      break label89;
      label139: assert (i == 1);
      zzb(localzzd2);
      zza(paramzzd);
    }
    label172: if (k == 2)
    {
      localzzd2 = localzzd1.bpu;
      localzzd3 = localzzd1.bpv;
      if (localzzd3 != null)
      {
        i = localzzd3.height;
        label203: if (localzzd2 == null)
          break label255;
        j = localzzd2.height;
        label215: i = j - i;
        if ((i != 1) && ((i != 0) || (paramBoolean)))
          break label261;
        zzb(paramzzd);
        label238: if (paramBoolean)
          break label292;
      }
    }
    label242: label255: 
    do
    {
      do
      {
        paramzzd = paramzzd.bpt;
        break;
        i = 0;
        break label203;
        j = 0;
        break label215;
        assert (i == -1);
        zza(localzzd1);
        zzb(paramzzd);
        break label238;
        break label116;
        if (k != 0)
          break label311;
        paramzzd.height = (i + 1);
      }
      while (!paramBoolean);
      return;
      assert ((k == -1) || (k == 1));
      paramzzd.height = (Math.max(i, j) + 1);
    }
    while (paramBoolean);
    label261: label292: label311: return;
  }

  public void clear()
  {
    this.bpj = null;
    this.size = 0;
    this.modCount += 1;
    zzd localzzd = this.bpk;
    localzzd.bpw = localzzd;
    localzzd.bpq = localzzd;
  }

  public boolean containsKey(Object paramObject)
  {
    return zzcq(paramObject) != null;
  }

  public Set<Map.Entry<K, V>> entrySet()
  {
    zza localzza = this.bpl;
    if (localzza != null)
      return localzza;
    localzza = new zza();
    this.bpl = localzza;
    return localzza;
  }

  public V get(Object paramObject)
  {
    paramObject = zzcq(paramObject);
    if (paramObject != null)
      return paramObject.value;
    return null;
  }

  public Set<K> keySet()
  {
    zzb localzzb = this.bpm;
    if (localzzb != null)
      return localzzb;
    localzzb = new zzb();
    this.bpm = localzzb;
    return localzzb;
  }

  public V put(K paramK, V paramV)
  {
    if (paramK == null)
      throw new NullPointerException("key == null");
    paramK = zza(paramK, true);
    Object localObject = paramK.value;
    paramK.value = paramV;
    return localObject;
  }

  public V remove(Object paramObject)
  {
    paramObject = zzcr(paramObject);
    if (paramObject != null)
      return paramObject.value;
    return null;
  }

  public int size()
  {
    return this.size;
  }

  zzd<K, V> zza(K paramK, boolean paramBoolean)
  {
    Object localObject3 = null;
    Comparator localComparator = this.bab;
    Object localObject1 = this.bpj;
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      Comparable localComparable;
      if (localComparator == bpi)
      {
        localComparable = (Comparable)paramK;
        if (localComparable == null)
          break label69;
      }
      label60: label69: for (i = localComparable.compareTo(((zzd)localObject1).bap); ; i = localComparator.compare(paramK, ((zzd)localObject1).bap))
      {
        if (i != 0)
          break label86;
        localObject2 = localObject1;
        return localObject2;
        localComparable = null;
        break;
      }
      label86: if (i < 0)
      {
        localObject2 = ((zzd)localObject1).bpu;
        label97: if (localObject2 != null)
          break label169;
      }
    }
    while (true)
    {
      localObject2 = localObject3;
      if (!paramBoolean)
        break label60;
      localObject2 = this.bpk;
      if (localObject1 == null)
      {
        if ((localComparator == bpi) && (!(paramK instanceof Comparable)))
        {
          throw new ClassCastException(String.valueOf(paramK.getClass().getName()).concat(" is not Comparable"));
          localObject2 = ((zzd)localObject1).bpv;
          break label97;
          label169: localObject1 = localObject2;
          break;
        }
        paramK = new zzd((zzd)localObject1, paramK, (zzd)localObject2, ((zzd)localObject2).bpw);
        this.bpj = paramK;
        this.size += 1;
        this.modCount += 1;
        return paramK;
      }
      paramK = new zzd((zzd)localObject1, paramK, (zzd)localObject2, ((zzd)localObject2).bpw);
      if (i < 0)
        ((zzd)localObject1).bpu = paramK;
      while (true)
      {
        zzb((zzd)localObject1, true);
        break;
        ((zzd)localObject1).bpv = paramK;
      }
      i = 0;
    }
  }

  void zza(zzd<K, V> paramzzd, boolean paramBoolean)
  {
    int j = 0;
    if (paramBoolean)
    {
      paramzzd.bpw.bpq = paramzzd.bpq;
      paramzzd.bpq.bpw = paramzzd.bpw;
    }
    zzd localzzd1 = paramzzd.bpu;
    zzd localzzd2 = paramzzd.bpv;
    zzd localzzd3 = paramzzd.bpt;
    int i;
    if ((localzzd1 != null) && (localzzd2 != null))
      if (localzzd1.height > localzzd2.height)
      {
        localzzd1 = localzzd1.bn();
        zza(localzzd1, false);
        localzzd2 = paramzzd.bpu;
        if (localzzd2 == null)
          break label262;
        i = localzzd2.height;
        localzzd1.bpu = localzzd2;
        localzzd2.bpt = localzzd1;
        paramzzd.bpu = null;
      }
    while (true)
    {
      localzzd2 = paramzzd.bpv;
      if (localzzd2 != null)
      {
        j = localzzd2.height;
        localzzd1.bpv = localzzd2;
        localzzd2.bpt = localzzd1;
        paramzzd.bpv = null;
      }
      localzzd1.height = (Math.max(i, j) + 1);
      zza(paramzzd, localzzd1);
      return;
      localzzd1 = localzzd2.bm();
      break;
      if (localzzd1 != null)
      {
        zza(paramzzd, localzzd1);
        paramzzd.bpu = null;
      }
      while (true)
      {
        zzb(localzzd3, false);
        this.size -= 1;
        this.modCount += 1;
        return;
        if (localzzd2 != null)
        {
          zza(paramzzd, localzzd2);
          paramzzd.bpv = null;
          continue;
        }
        zza(paramzzd, null);
      }
      label262: i = 0;
    }
  }

  zzd<K, V> zzc(Map.Entry<?, ?> paramEntry)
  {
    zzd localzzd = zzcq(paramEntry.getKey());
    if ((localzzd != null) && (equal(localzzd.value, paramEntry.getValue())));
    for (int i = 1; i != 0; i = 0)
      return localzzd;
    return null;
  }

  zzd<K, V> zzcq(Object paramObject)
  {
    zzd localzzd = null;
    if (paramObject != null);
    try
    {
      localzzd = zza(paramObject, false);
      return localzzd;
    }
    catch (ClassCastException paramObject)
    {
    }
    return null;
  }

  zzd<K, V> zzcr(Object paramObject)
  {
    paramObject = zzcq(paramObject);
    if (paramObject != null)
      zza(paramObject, true);
    return paramObject;
  }

  class zza extends AbstractSet<Map.Entry<K, V>>
  {
    zza()
    {
    }

    public void clear()
    {
      zzapw.this.clear();
    }

    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Map.Entry)) && (zzapw.this.zzc((Map.Entry)paramObject) != null);
    }

    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new zzapw.zzc()
      {
        public Map.Entry<K, V> next()
        {
          return bl();
        }
      };
    }

    public boolean remove(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry));
      do
      {
        return false;
        paramObject = zzapw.this.zzc((Map.Entry)paramObject);
      }
      while (paramObject == null);
      zzapw.this.zza(paramObject, true);
      return true;
    }

    public int size()
    {
      return zzapw.this.size;
    }
  }

  final class zzb extends AbstractSet<K>
  {
    zzb()
    {
    }

    public void clear()
    {
      zzapw.this.clear();
    }

    public boolean contains(Object paramObject)
    {
      return zzapw.this.containsKey(paramObject);
    }

    public Iterator<K> iterator()
    {
      return new zzapw.zzc()
      {
        public K next()
        {
          return bl().bap;
        }
      };
    }

    public boolean remove(Object paramObject)
    {
      return zzapw.this.zzcr(paramObject) != null;
    }

    public int size()
    {
      return zzapw.this.size;
    }
  }

  private abstract class zzc<T>
    implements Iterator<T>
  {
    zzapw.zzd<K, V> bpq = zzapw.this.bpk.bpq;
    zzapw.zzd<K, V> bpr = null;
    int bps = zzapw.this.modCount;

    private zzc()
    {
    }

    final zzapw.zzd<K, V> bl()
    {
      zzapw.zzd localzzd = this.bpq;
      if (localzzd == zzapw.this.bpk)
        throw new NoSuchElementException();
      if (zzapw.this.modCount != this.bps)
        throw new ConcurrentModificationException();
      this.bpq = localzzd.bpq;
      this.bpr = localzzd;
      return localzzd;
    }

    public final boolean hasNext()
    {
      return this.bpq != zzapw.this.bpk;
    }

    public final void remove()
    {
      if (this.bpr == null)
        throw new IllegalStateException();
      zzapw.this.zza(this.bpr, true);
      this.bpr = null;
      this.bps = zzapw.this.modCount;
    }
  }

  static final class zzd<K, V>
    implements Map.Entry<K, V>
  {
    final K bap;
    zzd<K, V> bpq;
    zzd<K, V> bpt;
    zzd<K, V> bpu;
    zzd<K, V> bpv;
    zzd<K, V> bpw;
    int height;
    V value;

    zzd()
    {
      this.bap = null;
      this.bpw = this;
      this.bpq = this;
    }

    zzd(zzd<K, V> paramzzd1, K paramK, zzd<K, V> paramzzd2, zzd<K, V> paramzzd3)
    {
      this.bpt = paramzzd1;
      this.bap = paramK;
      this.height = 1;
      this.bpq = paramzzd2;
      this.bpw = paramzzd3;
      paramzzd3.bpq = this;
      paramzzd2.bpw = this;
    }

    public zzd<K, V> bm()
    {
      Object localObject1 = this.bpu;
      Object localObject2 = this;
      while (localObject1 != null)
      {
        zzd localzzd = ((zzd)localObject1).bpu;
        localObject2 = localObject1;
        localObject1 = localzzd;
      }
      return (zzd<K, V>)(zzd<K, V>)localObject2;
    }

    public zzd<K, V> bn()
    {
      Object localObject1 = this.bpv;
      Object localObject2 = this;
      while (localObject1 != null)
      {
        zzd localzzd = ((zzd)localObject1).bpv;
        localObject2 = localObject1;
        localObject1 = localzzd;
      }
      return (zzd<K, V>)(zzd<K, V>)localObject2;
    }

    public boolean equals(Object paramObject)
    {
      int j = 0;
      int i = j;
      if ((paramObject instanceof Map.Entry))
      {
        paramObject = (Map.Entry)paramObject;
        if (this.bap != null)
          break label56;
        i = j;
        if (paramObject.getKey() == null)
        {
          if (this.value != null)
            break label77;
          i = j;
          if (paramObject.getValue() != null);
        }
      }
      while (true)
      {
        i = 1;
        label56: label77: 
        do
        {
          do
          {
            return i;
            i = j;
          }
          while (!this.bap.equals(paramObject.getKey()));
          break;
          i = j;
        }
        while (!this.value.equals(paramObject.getValue()));
      }
    }

    public K getKey()
    {
      return this.bap;
    }

    public V getValue()
    {
      return this.value;
    }

    public int hashCode()
    {
      int j = 0;
      int i;
      if (this.bap == null)
      {
        i = 0;
        if (this.value != null)
          break label33;
      }
      while (true)
      {
        return i ^ j;
        i = this.bap.hashCode();
        break;
        label33: j = this.value.hashCode();
      }
    }

    public V setValue(V paramV)
    {
      Object localObject = this.value;
      this.value = paramV;
      return localObject;
    }

    public String toString()
    {
      String str1 = String.valueOf(this.bap);
      String str2 = String.valueOf(this.value);
      return String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + "=" + str2;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzapw
 * JD-Core Version:    0.6.0
 */
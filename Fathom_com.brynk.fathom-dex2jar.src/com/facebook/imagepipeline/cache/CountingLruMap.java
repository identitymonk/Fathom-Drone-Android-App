package com.facebook.imagepipeline.cache;

import com.android.internal.util.Predicate;
import com.facebook.common.internal.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class CountingLruMap<K, V>
{

  @GuardedBy("this")
  private final LinkedHashMap<K, V> mMap = new LinkedHashMap();

  @GuardedBy("this")
  private int mSizeInBytes = 0;
  private final ValueDescriptor<V> mValueDescriptor;

  public CountingLruMap(ValueDescriptor<V> paramValueDescriptor)
  {
    this.mValueDescriptor = paramValueDescriptor;
  }

  private int getValueSizeInBytes(V paramV)
  {
    if (paramV == null)
      return 0;
    return this.mValueDescriptor.getSizeInBytes(paramV);
  }

  public ArrayList<V> clear()
  {
    monitorenter;
    try
    {
      ArrayList localArrayList = new ArrayList(this.mMap.values());
      this.mMap.clear();
      this.mSizeInBytes = 0;
      monitorexit;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean contains(K paramK)
  {
    monitorenter;
    try
    {
      boolean bool = this.mMap.containsKey(paramK);
      monitorexit;
      return bool;
    }
    finally
    {
      paramK = finally;
      monitorexit;
    }
    throw paramK;
  }

  @Nullable
  public V get(K paramK)
  {
    monitorenter;
    try
    {
      paramK = this.mMap.get(paramK);
      monitorexit;
      return paramK;
    }
    finally
    {
      paramK = finally;
      monitorexit;
    }
    throw paramK;
  }

  public int getCount()
  {
    monitorenter;
    try
    {
      int i = this.mMap.size();
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  @Nullable
  public K getFirstKey()
  {
    monitorenter;
    try
    {
      boolean bool = this.mMap.isEmpty();
      if (bool);
      for (Object localObject1 = null; ; localObject1 = this.mMap.keySet().iterator().next())
        return localObject1;
    }
    finally
    {
      monitorexit;
    }
    throw localObject2;
  }

  @VisibleForTesting
  ArrayList<K> getKeys()
  {
    monitorenter;
    try
    {
      ArrayList localArrayList = new ArrayList(this.mMap.keySet());
      monitorexit;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public ArrayList<Map.Entry<K, V>> getMatchingEntries(@Nullable Predicate<K> paramPredicate)
  {
    monitorenter;
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList(this.mMap.entrySet().size());
      Iterator localIterator = this.mMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramPredicate != null) && (!paramPredicate.apply(localEntry.getKey())))
          continue;
        localArrayList.add(localEntry);
      }
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
    return localArrayList;
  }

  public int getSizeInBytes()
  {
    monitorenter;
    try
    {
      int i = this.mSizeInBytes;
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  @VisibleForTesting
  ArrayList<V> getValues()
  {
    monitorenter;
    try
    {
      ArrayList localArrayList = new ArrayList(this.mMap.values());
      monitorexit;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  @Nullable
  public V put(K paramK, V paramV)
  {
    monitorenter;
    try
    {
      Object localObject = this.mMap.remove(paramK);
      this.mSizeInBytes -= getValueSizeInBytes(localObject);
      this.mMap.put(paramK, paramV);
      this.mSizeInBytes += getValueSizeInBytes(paramV);
      monitorexit;
      return localObject;
    }
    finally
    {
      paramK = finally;
      monitorexit;
    }
    throw paramK;
  }

  @Nullable
  public V remove(K paramK)
  {
    monitorenter;
    try
    {
      paramK = this.mMap.remove(paramK);
      this.mSizeInBytes -= getValueSizeInBytes(paramK);
      monitorexit;
      return paramK;
    }
    finally
    {
      paramK = finally;
      monitorexit;
    }
    throw paramK;
  }

  public ArrayList<V> removeAll(@Nullable Predicate<K> paramPredicate)
  {
    monitorenter;
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.mMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((paramPredicate != null) && (!paramPredicate.apply(localEntry.getKey())))
          continue;
        localArrayList.add(localEntry.getValue());
        this.mSizeInBytes -= getValueSizeInBytes(localEntry.getValue());
        localIterator.remove();
      }
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
    return localArrayList;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.cache.CountingLruMap
 * JD-Core Version:    0.6.0
 */
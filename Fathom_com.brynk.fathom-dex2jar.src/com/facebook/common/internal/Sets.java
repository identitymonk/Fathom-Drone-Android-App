package com.facebook.common.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class Sets
{
  public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet()
  {
    return new CopyOnWriteArraySet();
  }

  public static <E> HashSet<E> newHashSet()
  {
    return new HashSet();
  }

  public static <E> HashSet<E> newHashSet(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection))
      return new HashSet((Collection)paramIterable);
    return newHashSet(paramIterable.iterator());
  }

  public static <E> HashSet<E> newHashSet(Iterator<? extends E> paramIterator)
  {
    HashSet localHashSet = newHashSet();
    while (paramIterator.hasNext())
      localHashSet.add(paramIterator.next());
    return localHashSet;
  }

  public static <E> HashSet<E> newHashSet(E[] paramArrayOfE)
  {
    HashSet localHashSet = newHashSetWithCapacity(paramArrayOfE.length);
    Collections.addAll(localHashSet, paramArrayOfE);
    return localHashSet;
  }

  public static <E> HashSet<E> newHashSetWithCapacity(int paramInt)
  {
    return new HashSet(paramInt);
  }

  public static <E> Set<E> newIdentityHashSet()
  {
    return newSetFromMap(new IdentityHashMap());
  }

  public static <E> LinkedHashSet<E> newLinkedHashSet()
  {
    return new LinkedHashSet();
  }

  public static <E> Set<E> newSetFromMap(Map<E, Boolean> paramMap)
  {
    return Collections.newSetFromMap(paramMap);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.internal.Sets
 * JD-Core Version:    0.6.0
 */
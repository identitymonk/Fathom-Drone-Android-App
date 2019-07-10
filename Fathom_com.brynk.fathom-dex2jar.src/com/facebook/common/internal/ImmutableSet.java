package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ImmutableSet<E> extends HashSet<E>
{
  private ImmutableSet(Set<E> paramSet)
  {
    super(paramSet);
  }

  public static <E> ImmutableSet<E> copyOf(Set<E> paramSet)
  {
    return new ImmutableSet(paramSet);
  }

  public static <E> ImmutableSet<E> of(E[] paramArrayOfE)
  {
    HashSet localHashSet = new HashSet();
    Collections.addAll(localHashSet, paramArrayOfE);
    return new ImmutableSet(localHashSet);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.internal.ImmutableSet
 * JD-Core Version:    0.6.0
 */
package com.facebook.common.internal;

import com.android.internal.util.Predicate;

public class AndroidPredicates
{
  public static <T> Predicate<T> False()
  {
    return new Predicate()
    {
      public boolean apply(T paramT)
      {
        return false;
      }
    };
  }

  public static <T> Predicate<T> True()
  {
    return new Predicate()
    {
      public boolean apply(T paramT)
      {
        return true;
      }
    };
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.internal.AndroidPredicates
 * JD-Core Version:    0.6.0
 */
package com.facebook.common.internal;

public class Suppliers
{
  public static <T> Supplier<T> of(T paramT)
  {
    return new Supplier(paramT)
    {
      public T get()
      {
        return this.val$instance;
      }
    };
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.facebook.common.internal.Suppliers
 * JD-Core Version:    0.6.0
 */
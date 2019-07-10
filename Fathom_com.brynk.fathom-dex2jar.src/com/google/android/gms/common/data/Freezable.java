package com.google.android.gms.common.data;

public abstract interface Freezable<T>
{
  public abstract T freeze();

  public abstract boolean isDataValid();
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.Freezable
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.internal;

public final class zzvu
{
  private static zzvu WD;
  private final zzvr WE = new zzvr();
  private final zzvs WF = new zzvs();

  static
  {
    zza(new zzvu());
  }

  protected static void zza(zzvu paramzzvu)
  {
    monitorenter;
    try
    {
      WD = paramzzvu;
      return;
    }
    finally
    {
      monitorexit;
    }
    throw paramzzvu;
  }

  private static zzvu zzbhd()
  {
    monitorenter;
    try
    {
      zzvu localzzvu = WD;
      return localzzvu;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static zzvr zzbhe()
  {
    return zzbhd().WE;
  }

  public static zzvs zzbhf()
  {
    return zzbhd().WF;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzvu
 * JD-Core Version:    0.6.0
 */
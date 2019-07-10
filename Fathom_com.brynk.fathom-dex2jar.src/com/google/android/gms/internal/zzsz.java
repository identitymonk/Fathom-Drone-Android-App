package com.google.android.gms.internal;

import android.content.Context;

public class zzsz
{
  private static zzsz GQ = new zzsz();
  private zzsy GP = null;

  public static zzsy zzco(Context paramContext)
  {
    return GQ.zzcn(paramContext);
  }

  public zzsy zzcn(Context paramContext)
  {
    monitorenter;
    try
    {
      if (this.GP == null)
        if (paramContext.getApplicationContext() != null)
          break label37;
      while (true)
      {
        this.GP = new zzsy(paramContext);
        paramContext = this.GP;
        return paramContext;
        label37: paramContext = paramContext.getApplicationContext();
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramContext;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzsz
 * JD-Core Version:    0.6.0
 */
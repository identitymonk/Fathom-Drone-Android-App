package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzvv;
import java.util.concurrent.Callable;

public class zzb
{
  private static SharedPreferences WM = null;

  public static SharedPreferences zzm(Context paramContext)
  {
    monitorenter;
    try
    {
      if (WM == null)
        WM = (SharedPreferences)zzvv.zzb(new Callable(paramContext)
        {
          public SharedPreferences zzbhi()
          {
            return zzb.this.getSharedPreferences("google_sdk_flags", 1);
          }
        });
      paramContext = WM;
      return paramContext;
    }
    finally
    {
      monitorexit;
    }
    throw paramContext;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.flags.impl.zzb
 * JD-Core Version:    0.6.0
 */
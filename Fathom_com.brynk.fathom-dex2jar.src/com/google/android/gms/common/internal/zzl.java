package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzl
{
  private static final Object El = new Object();
  private static zzl Em;

  public static zzl zzcc(Context paramContext)
  {
    synchronized (El)
    {
      if (Em == null)
        Em = new zzm(paramContext.getApplicationContext());
      return Em;
    }
  }

  public abstract boolean zza(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString);

  public abstract boolean zza(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3);

  public abstract void zzb(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString);

  public abstract void zzb(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzl
 * JD-Core Version:    0.6.0
 */
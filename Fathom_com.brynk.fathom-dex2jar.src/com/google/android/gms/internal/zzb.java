package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Map;

public abstract interface zzb
{
  public abstract void initialize();

  public abstract zza zza(String paramString);

  public abstract void zza(String paramString, zza paramzza);

  public static class zza
  {
    public byte[] data;
    public String zza;
    public long zzb;
    public long zzc;
    public long zzd;
    public long zze;
    public Map<String, String> zzf = Collections.emptyMap();

    public boolean zza()
    {
      return this.zzd < System.currentTimeMillis();
    }

    public boolean zzb()
    {
      return this.zze < System.currentTimeMillis();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzb
 * JD-Core Version:    0.6.0
 */
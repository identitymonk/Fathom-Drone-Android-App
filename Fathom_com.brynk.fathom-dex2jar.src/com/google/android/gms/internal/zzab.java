package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;

public class zzab extends zzk<String>
{
  private final zzm.zzb<String> zzcg;

  public zzab(int paramInt, String paramString, zzm.zzb<String> paramzzb, zzm.zza paramzza)
  {
    super(paramInt, paramString, paramzza);
    this.zzcg = paramzzb;
  }

  protected zzm<String> zza(zzi paramzzi)
  {
    try
    {
      String str1 = new String(paramzzi.data, zzx.zza(paramzzi.zzz));
      return zzm.zza(str1, zzx.zzb(paramzzi));
    }
    catch (UnsupportedEncodingException str2)
    {
      while (true)
        String str2 = new String(paramzzi.data);
    }
  }

  protected void zzi(String paramString)
  {
    this.zzcg.zzb(paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzab
 * JD-Core Version:    0.6.0
 */
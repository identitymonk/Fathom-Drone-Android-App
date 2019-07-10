package com.google.android.gms.internal;

public class zzm<T>
{
  public final T result;
  public final zzb.zza zzbf;
  public final zzr zzbg;
  public boolean zzbh = false;

  private zzm(zzr paramzzr)
  {
    this.result = null;
    this.zzbf = null;
    this.zzbg = paramzzr;
  }

  private zzm(T paramT, zzb.zza paramzza)
  {
    this.result = paramT;
    this.zzbf = paramzza;
    this.zzbg = null;
  }

  public static <T> zzm<T> zza(T paramT, zzb.zza paramzza)
  {
    return new zzm(paramT, paramzza);
  }

  public static <T> zzm<T> zzd(zzr paramzzr)
  {
    return new zzm(paramzzr);
  }

  public boolean isSuccess()
  {
    return this.zzbg == null;
  }

  public static abstract interface zza
  {
    public abstract void zze(zzr paramzzr);
  }

  public static abstract interface zzb<T>
  {
    public abstract void zzb(T paramT);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzm
 * JD-Core Version:    0.6.0
 */
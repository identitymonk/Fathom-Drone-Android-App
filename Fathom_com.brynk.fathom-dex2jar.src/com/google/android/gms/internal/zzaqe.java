package com.google.android.gms.internal;

public final class zzaqe
  implements zzapl
{
  private final zzaps bod;

  public zzaqe(zzaps paramzzaps)
  {
    this.bod = paramzzaps;
  }

  static zzapk<?> zza(zzaps paramzzaps, zzaos paramzzaos, zzaqo<?> paramzzaqo, zzapm paramzzapm)
  {
    paramzzapm = paramzzapm.value();
    if (zzapk.class.isAssignableFrom(paramzzapm))
      return (zzapk)paramzzaps.zzb(zzaqo.zzr(paramzzapm)).bj();
    if (zzapl.class.isAssignableFrom(paramzzapm))
      return ((zzapl)paramzzaps.zzb(zzaqo.zzr(paramzzapm)).bj()).zza(paramzzaos, paramzzaqo);
    throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
  }

  public <T> zzapk<T> zza(zzaos paramzzaos, zzaqo<T> paramzzaqo)
  {
    zzapm localzzapm = (zzapm)paramzzaqo.bB().getAnnotation(zzapm.class);
    if (localzzapm == null)
      return null;
    return zza(this.bod, paramzzaos, paramzzaqo, localzzapm);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqe
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.internal;

import java.util.Map.Entry;
import java.util.Set;

public final class zzapb extends zzaoy
{
  private final zzapw<String, zzaoy> bov = new zzapw();

  private zzaoy zzcl(Object paramObject)
  {
    if (paramObject == null)
      return zzapa.bou;
    return new zzape(paramObject);
  }

  public Set<Map.Entry<String, zzaoy>> entrySet()
  {
    return this.bov.entrySet();
  }

  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof zzapb)) && (((zzapb)paramObject).bov.equals(this.bov)));
  }

  public boolean has(String paramString)
  {
    return this.bov.containsKey(paramString);
  }

  public int hashCode()
  {
    return this.bov.hashCode();
  }

  public void zza(String paramString, zzaoy paramzzaoy)
  {
    Object localObject = paramzzaoy;
    if (paramzzaoy == null)
      localObject = zzapa.bou;
    this.bov.put(paramString, localObject);
  }

  public void zzb(String paramString, Boolean paramBoolean)
  {
    zza(paramString, zzcl(paramBoolean));
  }

  public void zzcb(String paramString1, String paramString2)
  {
    zza(paramString1, zzcl(paramString2));
  }

  public zzaoy zzuo(String paramString)
  {
    return (zzaoy)this.bov.get(paramString);
  }

  public zzaov zzup(String paramString)
  {
    return (zzaov)this.bov.get(paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzapb
 * JD-Core Version:    0.6.0
 */
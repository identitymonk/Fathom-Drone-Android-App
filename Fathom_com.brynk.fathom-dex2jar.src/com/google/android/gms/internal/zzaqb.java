package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

public final class zzaqb<E> extends zzapk<Object>
{
  public static final zzapl bpG = new zzapl()
  {
    public <T> zzapk<T> zza(zzaos paramzzaos, zzaqo<T> paramzzaqo)
    {
      paramzzaqo = paramzzaqo.bC();
      if ((!(paramzzaqo instanceof GenericArrayType)) && ((!(paramzzaqo instanceof Class)) || (!((Class)paramzzaqo).isArray())))
        return null;
      paramzzaqo = zzapr.zzh(paramzzaqo);
      return new zzaqb(paramzzaos, paramzzaos.zza(zzaqo.zzl(paramzzaqo)), zzapr.zzf(paramzzaqo));
    }
  };
  private final Class<E> bpH;
  private final zzapk<E> bpI;

  public zzaqb(zzaos paramzzaos, zzapk<E> paramzzapk, Class<E> paramClass)
  {
    this.bpI = new zzaqm(paramzzaos, paramzzapk, paramClass);
    this.bpH = paramClass;
  }

  public void zza(zzaqr paramzzaqr, Object paramObject)
    throws IOException
  {
    if (paramObject == null)
    {
      paramzzaqr.bA();
      return;
    }
    paramzzaqr.bw();
    int i = 0;
    int j = Array.getLength(paramObject);
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      this.bpI.zza(paramzzaqr, localObject);
      i += 1;
    }
    paramzzaqr.bx();
  }

  public Object zzb(zzaqp paramzzaqp)
    throws IOException
  {
    if (paramzzaqp.bq() == zzaqq.brJ)
    {
      paramzzaqp.nextNull();
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramzzaqp.beginArray();
    while (paramzzaqp.hasNext())
      localArrayList.add(this.bpI.zzb(paramzzaqp));
    paramzzaqp.endArray();
    paramzzaqp = Array.newInstance(this.bpH, localArrayList.size());
    int i = 0;
    while (i < localArrayList.size())
    {
      Array.set(paramzzaqp, i, localArrayList.get(i));
      i += 1;
    }
    return paramzzaqp;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqb
 * JD-Core Version:    0.6.0
 */
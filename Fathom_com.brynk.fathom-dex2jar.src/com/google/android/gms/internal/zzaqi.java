package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzaqi extends zzapk<Object>
{
  public static final zzapl bpG = new zzapl()
  {
    public <T> zzapk<T> zza(zzaos paramzzaos, zzaqo<T> paramzzaqo)
    {
      if (paramzzaqo.bB() == Object.class)
        return new zzaqi(paramzzaos, null);
      return null;
    }
  };
  private final zzaos boC;

  private zzaqi(zzaos paramzzaos)
  {
    this.boC = paramzzaos;
  }

  public void zza(zzaqr paramzzaqr, Object paramObject)
    throws IOException
  {
    if (paramObject == null)
    {
      paramzzaqr.bA();
      return;
    }
    zzapk localzzapk = this.boC.zzk(paramObject.getClass());
    if ((localzzapk instanceof zzaqi))
    {
      paramzzaqr.by();
      paramzzaqr.bz();
      return;
    }
    localzzapk.zza(paramzzaqr, paramObject);
  }

  public Object zzb(zzaqp paramzzaqp)
    throws IOException
  {
    Object localObject = paramzzaqp.bq();
    switch (2.bpW[localObject.ordinal()])
    {
    default:
      throw new IllegalStateException();
    case 1:
      localObject = new ArrayList();
      paramzzaqp.beginArray();
      while (paramzzaqp.hasNext())
        ((List)localObject).add(zzb(paramzzaqp));
      paramzzaqp.endArray();
      return localObject;
    case 2:
      localObject = new zzapw();
      paramzzaqp.beginObject();
      while (paramzzaqp.hasNext())
        ((Map)localObject).put(paramzzaqp.nextName(), zzb(paramzzaqp));
      paramzzaqp.endObject();
      return localObject;
    case 3:
      return paramzzaqp.nextString();
    case 4:
      return Double.valueOf(paramzzaqp.nextDouble());
    case 5:
      return Boolean.valueOf(paramzzaqp.nextBoolean());
    case 6:
    }
    paramzzaqp.nextNull();
    return null;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqi
 * JD-Core Version:    0.6.0
 */
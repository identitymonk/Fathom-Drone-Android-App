package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class zzaqm<T> extends zzapk<T>
{
  private final zzapk<T> bol;
  private final zzaos bqh;
  private final Type bqi;

  zzaqm(zzaos paramzzaos, zzapk<T> paramzzapk, Type paramType)
  {
    this.bqh = paramzzaos;
    this.bol = paramzzapk;
    this.bqi = paramType;
  }

  private Type zzb(Type paramType, Object paramObject)
  {
    Object localObject = paramType;
    if (paramObject != null)
      if ((paramType != Object.class) && (!(paramType instanceof TypeVariable)))
      {
        localObject = paramType;
        if (!(paramType instanceof Class));
      }
      else
      {
        localObject = paramObject.getClass();
      }
    return (Type)localObject;
  }

  public void zza(zzaqr paramzzaqr, T paramT)
    throws IOException
  {
    zzapk localzzapk = this.bol;
    Type localType = zzb(this.bqi, paramT);
    if (localType != this.bqi)
    {
      localzzapk = this.bqh.zza(zzaqo.zzl(localType));
      if ((localzzapk instanceof zzaqj.zza))
        break label52;
    }
    while (true)
    {
      localzzapk.zza(paramzzaqr, paramT);
      return;
      label52: if ((this.bol instanceof zzaqj.zza))
        continue;
      localzzapk = this.bol;
    }
  }

  public T zzb(zzaqp paramzzaqp)
    throws IOException
  {
    return this.bol.zzb(paramzzaqp);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqm
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.internal;

import java.lang.reflect.Type;

public class zzaqo<T>
{
  final Type bqi;
  final Class<? super T> brm;
  final int brn;

  protected zzaqo()
  {
    this.bqi = zzq(getClass());
    this.brm = zzapr.zzf(this.bqi);
    this.brn = this.bqi.hashCode();
  }

  zzaqo(Type paramType)
  {
    this.bqi = zzapr.zze((Type)zzapq.zzy(paramType));
    this.brm = zzapr.zzf(this.bqi);
    this.brn = this.bqi.hashCode();
  }

  public static zzaqo<?> zzl(Type paramType)
  {
    return new zzaqo(paramType);
  }

  static Type zzq(Class<?> paramClass)
  {
    paramClass = paramClass.getGenericSuperclass();
    if ((paramClass instanceof Class))
      throw new RuntimeException("Missing type parameter.");
    return zzapr.zze(((java.lang.reflect.ParameterizedType)paramClass).getActualTypeArguments()[0]);
  }

  public static <T> zzaqo<T> zzr(Class<T> paramClass)
  {
    return new zzaqo(paramClass);
  }

  public final Class<? super T> bB()
  {
    return this.brm;
  }

  public final Type bC()
  {
    return this.bqi;
  }

  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof zzaqo)) && (zzapr.zza(this.bqi, ((zzaqo)paramObject).bqi));
  }

  public final int hashCode()
  {
    return this.brn;
  }

  public final String toString()
  {
    return zzapr.zzg(this.bqi);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqo
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public final class zzaop
{
  private final Field bnT;

  public zzaop(Field paramField)
  {
    zzapq.zzy(paramField);
    this.bnT = paramField;
  }

  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    return this.bnT.getAnnotation(paramClass);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzaop
 * JD-Core Version:    0.6.0
 */
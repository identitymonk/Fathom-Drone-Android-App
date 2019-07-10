package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzapk<T>
{
  public abstract void zza(zzaqr paramzzaqr, T paramT)
    throws IOException;

  public abstract T zzb(zzaqp paramzzaqp)
    throws IOException;

  public final zzaoy zzcn(T paramT)
  {
    try
    {
      zzaqg localzzaqg = new zzaqg();
      zza(localzzaqg, paramT);
      paramT = localzzaqg.bu();
      return paramT;
    }
    catch (IOException paramT)
    {
    }
    throw new zzaoz(paramT);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzapk
 * JD-Core Version:    0.6.0
 */
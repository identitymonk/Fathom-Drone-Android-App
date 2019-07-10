package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzaru<M extends zzaru<M>> extends zzasa
{
  protected zzarw btG;

  public M cn()
    throws CloneNotSupportedException
  {
    zzaru localzzaru = (zzaru)super.co();
    zzary.zza(this, localzzaru);
    return localzzaru;
  }

  public final <T> T zza(zzarv<M, T> paramzzarv)
  {
    if (this.btG == null);
    zzarx localzzarx;
    do
    {
      return null;
      localzzarx = this.btG.zzahh(zzasd.zzahl(paramzzarv.tag));
    }
    while (localzzarx == null);
    return localzzarx.zzb(paramzzarv);
  }

  public void zza(zzart paramzzart)
    throws IOException
  {
    if (this.btG == null);
    while (true)
    {
      return;
      int i = 0;
      while (i < this.btG.size())
      {
        this.btG.zzahi(i).zza(paramzzart);
        i += 1;
      }
    }
  }

  protected final boolean zza(zzars paramzzars, int paramInt)
    throws IOException
  {
    int i = paramzzars.getPosition();
    if (!paramzzars.zzagr(paramInt))
      return false;
    int j = zzasd.zzahl(paramInt);
    zzasc localzzasc = new zzasc(paramInt, paramzzars.zzae(i, paramzzars.getPosition() - i));
    paramzzars = null;
    if (this.btG == null)
      this.btG = new zzarw();
    while (true)
    {
      Object localObject = paramzzars;
      if (paramzzars == null)
      {
        localObject = new zzarx();
        this.btG.zza(j, (zzarx)localObject);
      }
      ((zzarx)localObject).zza(localzzasc);
      return true;
      paramzzars = this.btG.zzahh(j);
    }
  }

  protected int zzx()
  {
    int j = 0;
    if (this.btG != null)
    {
      int i = 0;
      while (true)
      {
        k = i;
        if (j >= this.btG.size())
          break;
        i += this.btG.zzahi(j).zzx();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzaru
 * JD-Core Version:    0.6.0
 */
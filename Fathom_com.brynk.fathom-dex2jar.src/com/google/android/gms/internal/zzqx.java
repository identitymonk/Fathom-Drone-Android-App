package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;

public abstract class zzqx<L>
  implements zzrr.zzc<L>
{
  private final DataHolder zy;

  protected zzqx(DataHolder paramDataHolder)
  {
    this.zy = paramDataHolder;
  }

  protected abstract void zza(L paramL, DataHolder paramDataHolder);

  public void zzasm()
  {
    if (this.zy != null)
      this.zy.close();
  }

  public final void zzt(L paramL)
  {
    zza(paramL, this.zy);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzqx
 * JD-Core Version:    0.6.0
 */
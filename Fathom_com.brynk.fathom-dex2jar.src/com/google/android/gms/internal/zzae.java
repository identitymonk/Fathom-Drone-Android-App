package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzae
{
  public static final class zza extends zzaru<zza>
  {
    public String stackTrace = null;
    public String zzcs = null;
    public Long zzct = null;
    public String zzcu = null;
    public String zzcv = null;
    public Long zzcw = null;
    public Long zzcx = null;
    public String zzcy = null;
    public Long zzcz = null;
    public String zzda = null;

    public zza()
    {
      this.btP = -1;
    }

    public void zza(zzart paramzzart)
      throws IOException
    {
      if (this.zzcs != null)
        paramzzart.zzq(1, this.zzcs);
      if (this.zzct != null)
        paramzzart.zzb(2, this.zzct.longValue());
      if (this.stackTrace != null)
        paramzzart.zzq(3, this.stackTrace);
      if (this.zzcu != null)
        paramzzart.zzq(4, this.zzcu);
      if (this.zzcv != null)
        paramzzart.zzq(5, this.zzcv);
      if (this.zzcw != null)
        paramzzart.zzb(6, this.zzcw.longValue());
      if (this.zzcx != null)
        paramzzart.zzb(7, this.zzcx.longValue());
      if (this.zzcy != null)
        paramzzart.zzq(8, this.zzcy);
      if (this.zzcz != null)
        paramzzart.zzb(9, this.zzcz.longValue());
      if (this.zzda != null)
        paramzzart.zzq(10, this.zzda);
      super.zza(paramzzart);
    }

    public zza zze(zzars paramzzars)
      throws IOException
    {
      while (true)
      {
        int i = paramzzars.bU();
        switch (i)
        {
        default:
          if (super.zza(paramzzars, i))
            continue;
        case 0:
          return this;
        case 10:
          this.zzcs = paramzzars.readString();
          break;
        case 16:
          this.zzct = Long.valueOf(paramzzars.bX());
          break;
        case 26:
          this.stackTrace = paramzzars.readString();
          break;
        case 34:
          this.zzcu = paramzzars.readString();
          break;
        case 42:
          this.zzcv = paramzzars.readString();
          break;
        case 48:
          this.zzcw = Long.valueOf(paramzzars.bX());
          break;
        case 56:
          this.zzcx = Long.valueOf(paramzzars.bX());
          break;
        case 66:
          this.zzcy = paramzzars.readString();
          break;
        case 72:
          this.zzcz = Long.valueOf(paramzzars.bX());
          break;
        case 82:
        }
        this.zzda = paramzzars.readString();
      }
    }

    protected int zzx()
    {
      int j = super.zzx();
      int i = j;
      if (this.zzcs != null)
        i = j + zzart.zzr(1, this.zzcs);
      j = i;
      if (this.zzct != null)
        j = i + zzart.zzf(2, this.zzct.longValue());
      i = j;
      if (this.stackTrace != null)
        i = j + zzart.zzr(3, this.stackTrace);
      j = i;
      if (this.zzcu != null)
        j = i + zzart.zzr(4, this.zzcu);
      i = j;
      if (this.zzcv != null)
        i = j + zzart.zzr(5, this.zzcv);
      j = i;
      if (this.zzcw != null)
        j = i + zzart.zzf(6, this.zzcw.longValue());
      i = j;
      if (this.zzcx != null)
        i = j + zzart.zzf(7, this.zzcx.longValue());
      j = i;
      if (this.zzcy != null)
        j = i + zzart.zzr(8, this.zzcy);
      i = j;
      if (this.zzcz != null)
        i = j + zzart.zzf(9, this.zzcz.longValue());
      j = i;
      if (this.zzda != null)
        j = i + zzart.zzr(10, this.zzda);
      return j;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzae
 * JD-Core Version:    0.6.0
 */
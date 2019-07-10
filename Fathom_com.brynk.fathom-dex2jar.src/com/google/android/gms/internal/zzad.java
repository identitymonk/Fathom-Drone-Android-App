package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzad
{
  public static final class zza extends zzasa
  {
    public zzad.zzb zzck;
    public zzad.zzc zzcl;

    public zza()
    {
      zzw();
    }

    public static zza zzc(byte[] paramArrayOfByte)
      throws zzarz
    {
      return (zza)zzasa.zza(new zza(), paramArrayOfByte);
    }

    public zza zza(zzars paramzzars)
      throws IOException
    {
      while (true)
      {
        int i = paramzzars.bU();
        switch (i)
        {
        default:
          if (zzasd.zzb(paramzzars, i))
            continue;
        case 0:
          return this;
        case 10:
          if (this.zzck == null)
            this.zzck = new zzad.zzb();
          paramzzars.zza(this.zzck);
          break;
        case 18:
        }
        if (this.zzcl == null)
          this.zzcl = new zzad.zzc();
        paramzzars.zza(this.zzcl);
      }
    }

    public void zza(zzart paramzzart)
      throws IOException
    {
      if (this.zzck != null)
        paramzzart.zza(1, this.zzck);
      if (this.zzcl != null)
        paramzzart.zza(2, this.zzcl);
      super.zza(paramzzart);
    }

    public zza zzw()
    {
      this.zzck = null;
      this.zzcl = null;
      this.btP = -1;
      return this;
    }

    protected int zzx()
    {
      int j = super.zzx();
      int i = j;
      if (this.zzck != null)
        i = j + zzart.zzc(1, this.zzck);
      j = i;
      if (this.zzcl != null)
        j = i + zzart.zzc(2, this.zzcl);
      return j;
    }
  }

  public static final class zzb extends zzasa
  {
    public Integer zzcm;

    public zzb()
    {
      zzy();
    }

    public void zza(zzart paramzzart)
      throws IOException
    {
      if (this.zzcm != null)
        paramzzart.zzaf(27, this.zzcm.intValue());
      super.zza(paramzzart);
    }

    public zzb zzc(zzars paramzzars)
      throws IOException
    {
      while (true)
      {
        int i = paramzzars.bU();
        switch (i)
        {
        default:
          if (zzasd.zzb(paramzzars, i))
            continue;
        case 0:
          return this;
        case 216:
        }
        i = paramzzars.bY();
        switch (i)
        {
        default:
          break;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        }
        this.zzcm = Integer.valueOf(i);
      }
    }

    protected int zzx()
    {
      int j = super.zzx();
      int i = j;
      if (this.zzcm != null)
        i = j + zzart.zzah(27, this.zzcm.intValue());
      return i;
    }

    public zzb zzy()
    {
      this.btP = -1;
      return this;
    }
  }

  public static final class zzc extends zzasa
  {
    public String zzcn;
    public String zzco;
    public String zzcp;
    public String zzcq;
    public String zzcr;

    public zzc()
    {
      zzz();
    }

    public void zza(zzart paramzzart)
      throws IOException
    {
      if (this.zzcn != null)
        paramzzart.zzq(1, this.zzcn);
      if (this.zzco != null)
        paramzzart.zzq(2, this.zzco);
      if (this.zzcp != null)
        paramzzart.zzq(3, this.zzcp);
      if (this.zzcq != null)
        paramzzart.zzq(4, this.zzcq);
      if (this.zzcr != null)
        paramzzart.zzq(5, this.zzcr);
      super.zza(paramzzart);
    }

    public zzc zzd(zzars paramzzars)
      throws IOException
    {
      while (true)
      {
        int i = paramzzars.bU();
        switch (i)
        {
        default:
          if (zzasd.zzb(paramzzars, i))
            continue;
        case 0:
          return this;
        case 10:
          this.zzcn = paramzzars.readString();
          break;
        case 18:
          this.zzco = paramzzars.readString();
          break;
        case 26:
          this.zzcp = paramzzars.readString();
          break;
        case 34:
          this.zzcq = paramzzars.readString();
          break;
        case 42:
        }
        this.zzcr = paramzzars.readString();
      }
    }

    protected int zzx()
    {
      int j = super.zzx();
      int i = j;
      if (this.zzcn != null)
        i = j + zzart.zzr(1, this.zzcn);
      j = i;
      if (this.zzco != null)
        j = i + zzart.zzr(2, this.zzco);
      i = j;
      if (this.zzcp != null)
        i = j + zzart.zzr(3, this.zzcp);
      j = i;
      if (this.zzcq != null)
        j = i + zzart.zzr(4, this.zzcq);
      i = j;
      if (this.zzcr != null)
        i = j + zzart.zzr(5, this.zzcr);
      return i;
    }

    public zzc zzz()
    {
      this.zzcn = null;
      this.zzco = null;
      this.zzcp = null;
      this.zzcq = null;
      this.zzcr = null;
      this.btP = -1;
      return this;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzad
 * JD-Core Version:    0.6.0
 */
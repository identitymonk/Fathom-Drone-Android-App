package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzvw
{
  public static final class zza extends zzaru<zza>
  {
    public zza[] ahB;

    public zza()
    {
      zzbny();
    }

    public boolean equals(Object paramObject)
    {
      int j = 0;
      int i;
      if (paramObject == this)
        i = 1;
      while (true)
      {
        return i;
        i = j;
        if (!(paramObject instanceof zza))
          continue;
        paramObject = (zza)paramObject;
        i = j;
        if (!zzary.equals(this.ahB, paramObject.ahB))
          continue;
        if ((this.btG != null) && (!this.btG.isEmpty()))
          break;
        if (paramObject.btG != null)
        {
          i = j;
          if (!paramObject.btG.isEmpty())
            continue;
        }
        return true;
      }
      return this.btG.equals(paramObject.btG);
    }

    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = zzary.hashCode(this.ahB);
      if ((this.btG == null) || (this.btG.isEmpty()));
      for (int i = 0; ; i = this.btG.hashCode())
        return i + ((j + 527) * 31 + k) * 31;
    }

    public void zza(zzart paramzzart)
      throws IOException
    {
      if ((this.ahB != null) && (this.ahB.length > 0))
      {
        int i = 0;
        while (i < this.ahB.length)
        {
          zza localzza = this.ahB[i];
          if (localzza != null)
            paramzzart.zza(1, localzza);
          i += 1;
        }
      }
      super.zza(paramzzart);
    }

    public zza zzab(zzars paramzzars)
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
        }
        int j = zzasd.zzc(paramzzars, 10);
        if (this.ahB == null);
        zza[] arrayOfzza;
        for (i = 0; ; i = this.ahB.length)
        {
          arrayOfzza = new zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.ahB, 0, arrayOfzza, 0, i);
            j = i;
          }
          while (j < arrayOfzza.length - 1)
          {
            arrayOfzza[j] = new zza();
            paramzzars.zza(arrayOfzza[j]);
            paramzzars.bU();
            j += 1;
          }
        }
        arrayOfzza[j] = new zza();
        paramzzars.zza(arrayOfzza[j]);
        this.ahB = arrayOfzza;
      }
    }

    public zza zzbny()
    {
      this.ahB = zza.zzbnz();
      this.btG = null;
      this.btP = -1;
      return this;
    }

    protected int zzx()
    {
      int i = super.zzx();
      int k = i;
      if (this.ahB != null)
      {
        k = i;
        if (this.ahB.length > 0)
        {
          int j = 0;
          while (true)
          {
            k = i;
            if (j >= this.ahB.length)
              break;
            zza localzza = this.ahB[j];
            k = i;
            if (localzza != null)
              k = i + zzart.zzc(1, localzza);
            j += 1;
            i = k;
          }
        }
      }
      return k;
    }

    public static final class zza extends zzaru<zza>
    {
      private static volatile zza[] ahC;
      public String ahD;
      public String ahE;
      public int viewId;

      public zza()
      {
        zzboa();
      }

      public static zza[] zzbnz()
      {
        if (ahC == null);
        synchronized (zzary.btO)
        {
          if (ahC == null)
            ahC = new zza[0];
          return ahC;
        }
      }

      public boolean equals(Object paramObject)
      {
        int j = 0;
        int i;
        if (paramObject == this)
          i = 1;
        label41: 
        do
        {
          do
          {
            do
            {
              return i;
              i = j;
            }
            while (!(paramObject instanceof zza));
            paramObject = (zza)paramObject;
            if (this.ahD != null)
              break;
            i = j;
          }
          while (paramObject.ahD != null);
          if (this.ahE != null)
            break label124;
          i = j;
        }
        while (paramObject.ahE != null);
        label124: 
        do
        {
          i = j;
          if (this.viewId != paramObject.viewId)
            break;
          if ((this.btG != null) && (!this.btG.isEmpty()))
            break label140;
          if (paramObject.btG != null)
          {
            i = j;
            if (!paramObject.btG.isEmpty())
              break;
          }
          return true;
          if (this.ahD.equals(paramObject.ahD))
            break label41;
          return false;
        }
        while (this.ahE.equals(paramObject.ahE));
        return false;
        label140: return this.btG.equals(paramObject.btG);
      }

      public int hashCode()
      {
        int m = 0;
        int n = getClass().getName().hashCode();
        int i;
        int j;
        label33: int i1;
        if (this.ahD == null)
        {
          i = 0;
          if (this.ahE != null)
            break label101;
          j = 0;
          i1 = this.viewId;
          k = m;
          if (this.btG != null)
            if (!this.btG.isEmpty())
              break label112;
        }
        label101: label112: for (int k = m; ; k = this.btG.hashCode())
        {
          return ((j + (i + (n + 527) * 31) * 31) * 31 + i1) * 31 + k;
          i = this.ahD.hashCode();
          break;
          j = this.ahE.hashCode();
          break label33;
        }
      }

      public void zza(zzart paramzzart)
        throws IOException
      {
        if ((this.ahD != null) && (!this.ahD.equals("")))
          paramzzart.zzq(1, this.ahD);
        if ((this.ahE != null) && (!this.ahE.equals("")))
          paramzzart.zzq(2, this.ahE);
        if (this.viewId != 0)
          paramzzart.zzaf(3, this.viewId);
        super.zza(paramzzart);
      }

      public zza zzac(zzars paramzzars)
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
            this.ahD = paramzzars.readString();
            break;
          case 18:
            this.ahE = paramzzars.readString();
            break;
          case 24:
          }
          this.viewId = paramzzars.bY();
        }
      }

      public zza zzboa()
      {
        this.ahD = "";
        this.ahE = "";
        this.viewId = 0;
        this.btG = null;
        this.btP = -1;
        return this;
      }

      protected int zzx()
      {
        int j = super.zzx();
        int i = j;
        if (this.ahD != null)
        {
          i = j;
          if (!this.ahD.equals(""))
            i = j + zzart.zzr(1, this.ahD);
        }
        j = i;
        if (this.ahE != null)
        {
          j = i;
          if (!this.ahE.equals(""))
            j = i + zzart.zzr(2, this.ahE);
        }
        i = j;
        if (this.viewId != 0)
          i = j + zzart.zzah(3, this.viewId);
        return i;
      }
    }
  }

  public static final class zzb extends zzaru<zzb>
  {
    private static volatile zzb[] ahF;
    public zzvw.zzd ahG;
    public String name;

    public zzb()
    {
      zzboc();
    }

    public static zzb[] zzbob()
    {
      if (ahF == null);
      synchronized (zzary.btO)
      {
        if (ahF == null)
          ahF = new zzb[0];
        return ahF;
      }
    }

    public boolean equals(Object paramObject)
    {
      int j = 0;
      int i;
      if (paramObject == this)
        i = 1;
      label41: 
      do
      {
        do
        {
          do
          {
            return i;
            i = j;
          }
          while (!(paramObject instanceof zzb));
          paramObject = (zzb)paramObject;
          if (this.name != null)
            break;
          i = j;
        }
        while (paramObject.name != null);
        if (this.ahG != null)
          break label111;
        i = j;
      }
      while (paramObject.ahG != null);
      label111: 
      do
      {
        if ((this.btG != null) && (!this.btG.isEmpty()))
          break label127;
        if (paramObject.btG != null)
        {
          i = j;
          if (!paramObject.btG.isEmpty())
            break;
        }
        return true;
        if (this.name.equals(paramObject.name))
          break label41;
        return false;
      }
      while (this.ahG.equals(paramObject.ahG));
      return false;
      label127: return this.btG.equals(paramObject.btG);
    }

    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int j;
      if (this.name == null)
      {
        i = 0;
        if (this.ahG != null)
          break label89;
        j = 0;
        label33: k = m;
        if (this.btG != null)
          if (!this.btG.isEmpty())
            break label100;
      }
      label89: label100: for (int k = m; ; k = this.btG.hashCode())
      {
        return (j + (i + (n + 527) * 31) * 31) * 31 + k;
        i = this.name.hashCode();
        break;
        j = this.ahG.hashCode();
        break label33;
      }
    }

    public void zza(zzart paramzzart)
      throws IOException
    {
      if ((this.name != null) && (!this.name.equals("")))
        paramzzart.zzq(1, this.name);
      if (this.ahG != null)
        paramzzart.zza(2, this.ahG);
      super.zza(paramzzart);
    }

    public zzb zzad(zzars paramzzars)
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
          this.name = paramzzars.readString();
          break;
        case 18:
        }
        if (this.ahG == null)
          this.ahG = new zzvw.zzd();
        paramzzars.zza(this.ahG);
      }
    }

    public zzb zzboc()
    {
      this.name = "";
      this.ahG = null;
      this.btG = null;
      this.btP = -1;
      return this;
    }

    protected int zzx()
    {
      int j = super.zzx();
      int i = j;
      if (this.name != null)
      {
        i = j;
        if (!this.name.equals(""))
          i = j + zzart.zzr(1, this.name);
      }
      j = i;
      if (this.ahG != null)
        j = i + zzart.zzc(2, this.ahG);
      return j;
    }
  }

  public static final class zzc extends zzaru<zzc>
  {
    public zzvw.zzb[] ahH;
    public String type;

    public zzc()
    {
      zzbod();
    }

    public boolean equals(Object paramObject)
    {
      int j = 0;
      int i;
      if (paramObject == this)
        i = 1;
      do
      {
        do
        {
          return i;
          i = j;
        }
        while (!(paramObject instanceof zzc));
        paramObject = (zzc)paramObject;
        if (this.type != null)
          break;
        i = j;
      }
      while (paramObject.type != null);
      do
      {
        i = j;
        if (!zzary.equals(this.ahH, paramObject.ahH))
          break;
        if ((this.btG != null) && (!this.btG.isEmpty()))
          break label111;
        if (paramObject.btG != null)
        {
          i = j;
          if (!paramObject.btG.isEmpty())
            break;
        }
        return true;
      }
      while (this.type.equals(paramObject.type));
      return false;
      label111: return this.btG.equals(paramObject.btG);
    }

    public int hashCode()
    {
      int k = 0;
      int m = getClass().getName().hashCode();
      int i;
      int n;
      if (this.type == null)
      {
        i = 0;
        n = zzary.hashCode(this.ahH);
        j = k;
        if (this.btG != null)
          if (!this.btG.isEmpty())
            break label87;
      }
      label87: for (int j = k; ; j = this.btG.hashCode())
      {
        return ((i + (m + 527) * 31) * 31 + n) * 31 + j;
        i = this.type.hashCode();
        break;
      }
    }

    public void zza(zzart paramzzart)
      throws IOException
    {
      if ((this.type != null) && (!this.type.equals("")))
        paramzzart.zzq(1, this.type);
      if ((this.ahH != null) && (this.ahH.length > 0))
      {
        int i = 0;
        while (i < this.ahH.length)
        {
          zzvw.zzb localzzb = this.ahH[i];
          if (localzzb != null)
            paramzzart.zza(2, localzzb);
          i += 1;
        }
      }
      super.zza(paramzzart);
    }

    public zzc zzae(zzars paramzzars)
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
          this.type = paramzzars.readString();
          break;
        case 18:
        }
        int j = zzasd.zzc(paramzzars, 18);
        if (this.ahH == null);
        zzvw.zzb[] arrayOfzzb;
        for (i = 0; ; i = this.ahH.length)
        {
          arrayOfzzb = new zzvw.zzb[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.ahH, 0, arrayOfzzb, 0, i);
            j = i;
          }
          while (j < arrayOfzzb.length - 1)
          {
            arrayOfzzb[j] = new zzvw.zzb();
            paramzzars.zza(arrayOfzzb[j]);
            paramzzars.bU();
            j += 1;
          }
        }
        arrayOfzzb[j] = new zzvw.zzb();
        paramzzars.zza(arrayOfzzb[j]);
        this.ahH = arrayOfzzb;
      }
    }

    public zzc zzbod()
    {
      this.type = "";
      this.ahH = zzvw.zzb.zzbob();
      this.btG = null;
      this.btP = -1;
      return this;
    }

    protected int zzx()
    {
      int j = super.zzx();
      int i = j;
      if (this.type != null)
      {
        i = j;
        if (!this.type.equals(""))
          i = j + zzart.zzr(1, this.type);
      }
      j = i;
      if (this.ahH != null)
      {
        j = i;
        if (this.ahH.length > 0)
        {
          j = 0;
          while (j < this.ahH.length)
          {
            zzvw.zzb localzzb = this.ahH[j];
            int k = i;
            if (localzzb != null)
              k = i + zzart.zzc(2, localzzb);
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      return j;
    }
  }

  public static final class zzd extends zzaru<zzd>
  {
    public String Fe;
    public boolean ahI;
    public long ahJ;
    public double ahK;
    public zzvw.zzc ahL;

    public zzd()
    {
      zzboe();
    }

    public boolean equals(Object paramObject)
    {
      int j = 0;
      int i;
      if (paramObject == this)
        i = 1;
      label54: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return i;
                  i = j;
                }
                while (!(paramObject instanceof zzd));
                paramObject = (zzd)paramObject;
                i = j;
              }
              while (this.ahI != paramObject.ahI);
              if (this.Fe != null)
                break;
              i = j;
            }
            while (paramObject.Fe != null);
            i = j;
          }
          while (this.ahJ != paramObject.ahJ);
          i = j;
        }
        while (Double.doubleToLongBits(this.ahK) != Double.doubleToLongBits(paramObject.ahK));
        if (this.ahL != null)
          break label158;
        i = j;
      }
      while (paramObject.ahL != null);
      label158: 
      do
      {
        if ((this.btG != null) && (!this.btG.isEmpty()))
          break label174;
        if (paramObject.btG != null)
        {
          i = j;
          if (!paramObject.btG.isEmpty())
            break;
        }
        return true;
        if (this.Fe.equals(paramObject.Fe))
          break label54;
        return false;
      }
      while (this.ahL.equals(paramObject.ahL));
      return false;
      label174: return this.btG.equals(paramObject.btG);
    }

    public int hashCode()
    {
      int n = 0;
      int i1 = getClass().getName().hashCode();
      int i;
      int j;
      label35: int i2;
      int i3;
      int k;
      if (this.ahI)
      {
        i = 1231;
        if (this.Fe != null)
          break label151;
        j = 0;
        i2 = (int)(this.ahJ ^ this.ahJ >>> 32);
        long l = Double.doubleToLongBits(this.ahK);
        i3 = (int)(l ^ l >>> 32);
        if (this.ahL != null)
          break label162;
        k = 0;
        label79: m = n;
        if (this.btG != null)
          if (!this.btG.isEmpty())
            break label173;
      }
      label151: label162: label173: for (int m = n; ; m = this.btG.hashCode())
      {
        return (k + (((j + (i + (i1 + 527) * 31) * 31) * 31 + i2) * 31 + i3) * 31) * 31 + m;
        i = 1237;
        break;
        j = this.Fe.hashCode();
        break label35;
        k = this.ahL.hashCode();
        break label79;
      }
    }

    public void zza(zzart paramzzart)
      throws IOException
    {
      if (this.ahI)
        paramzzart.zzg(1, this.ahI);
      if ((this.Fe != null) && (!this.Fe.equals("")))
        paramzzart.zzq(2, this.Fe);
      if (this.ahJ != 0L)
        paramzzart.zzb(3, this.ahJ);
      if (Double.doubleToLongBits(this.ahK) != Double.doubleToLongBits(0.0D))
        paramzzart.zza(4, this.ahK);
      if (this.ahL != null)
        paramzzart.zza(5, this.ahL);
      super.zza(paramzzart);
    }

    public zzd zzaf(zzars paramzzars)
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
        case 8:
          this.ahI = paramzzars.ca();
          break;
        case 18:
          this.Fe = paramzzars.readString();
          break;
        case 24:
          this.ahJ = paramzzars.bX();
          break;
        case 33:
          this.ahK = paramzzars.readDouble();
          break;
        case 42:
        }
        if (this.ahL == null)
          this.ahL = new zzvw.zzc();
        paramzzars.zza(this.ahL);
      }
    }

    public zzd zzboe()
    {
      this.ahI = false;
      this.Fe = "";
      this.ahJ = 0L;
      this.ahK = 0.0D;
      this.ahL = null;
      this.btG = null;
      this.btP = -1;
      return this;
    }

    protected int zzx()
    {
      int j = super.zzx();
      int i = j;
      if (this.ahI)
        i = j + zzart.zzh(1, this.ahI);
      j = i;
      if (this.Fe != null)
      {
        j = i;
        if (!this.Fe.equals(""))
          j = i + zzart.zzr(2, this.Fe);
      }
      i = j;
      if (this.ahJ != 0L)
        i = j + zzart.zzf(3, this.ahJ);
      j = i;
      if (Double.doubleToLongBits(this.ahK) != Double.doubleToLongBits(0.0D))
        j = i + zzart.zzb(4, this.ahK);
      i = j;
      if (this.ahL != null)
        i = j + zzart.zzc(5, this.ahL);
      return i;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzvw
 * JD-Core Version:    0.6.0
 */
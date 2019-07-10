package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzase
{
  public static final class zza extends zzaru<zza>
  {
    public boolean btZ;
    public String bua;
    public int score;

    public zza()
    {
      cA();
    }

    public zza cA()
    {
      this.btZ = false;
      this.score = 0;
      this.bua = "";
      this.btG = null;
      this.btP = -1;
      return this;
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
          do
          {
            do
            {
              return i;
              i = j;
            }
            while (!(paramObject instanceof zza));
            paramObject = (zza)paramObject;
            i = j;
          }
          while (this.btZ != paramObject.btZ);
          i = j;
        }
        while (this.score != paramObject.score);
        if (this.bua != null)
          break;
        i = j;
      }
      while (paramObject.bua != null);
      do
      {
        if ((this.btG != null) && (!this.btG.isEmpty()))
          break label121;
        if (paramObject.btG != null)
        {
          i = j;
          if (!paramObject.btG.isEmpty())
            break;
        }
        return true;
      }
      while (this.bua.equals(paramObject.bua));
      return false;
      label121: return this.btG.equals(paramObject.btG);
    }

    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int i1;
      int j;
      if (this.btZ)
      {
        i = 1231;
        i1 = this.score;
        if (this.bua != null)
          break label99;
        j = 0;
        label41: k = m;
        if (this.btG != null)
          if (!this.btG.isEmpty())
            break label110;
      }
      label99: label110: for (int k = m; ; k = this.btG.hashCode())
      {
        return (j + ((i + (n + 527) * 31) * 31 + i1) * 31) * 31 + k;
        i = 1237;
        break;
        j = this.bua.hashCode();
        break label41;
      }
    }

    public void zza(zzart paramzzart)
      throws IOException
    {
      if (this.btZ)
        paramzzart.zzg(1, this.btZ);
      if (this.score != 0)
        paramzzart.zzaf(2, this.score);
      if ((this.bua != null) && (!this.bua.equals("")))
        paramzzart.zzq(3, this.bua);
      super.zza(paramzzart);
    }

    public zza zzcn(zzars paramzzars)
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
          this.btZ = paramzzars.ca();
          break;
        case 16:
          this.score = paramzzars.bY();
          break;
        case 26:
        }
        this.bua = paramzzars.readString();
      }
    }

    protected int zzx()
    {
      int j = super.zzx();
      int i = j;
      if (this.btZ)
        i = j + zzart.zzh(1, this.btZ);
      j = i;
      if (this.score != 0)
        j = i + zzart.zzah(2, this.score);
      i = j;
      if (this.bua != null)
      {
        i = j;
        if (!this.bua.equals(""))
          i = j + zzart.zzr(3, this.bua);
      }
      return i;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzase
 * JD-Core Version:    0.6.0
 */
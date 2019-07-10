package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzz;

public abstract class zzc
{
  protected int BU;
  private int BV;
  protected final DataHolder zy;

  public zzc(DataHolder paramDataHolder, int paramInt)
  {
    this.zy = ((DataHolder)zzaa.zzy(paramDataHolder));
    zzfy(paramInt);
  }

  public boolean equals(Object paramObject)
  {
    int j = 0;
    int i = j;
    if ((paramObject instanceof zzc))
    {
      paramObject = (zzc)paramObject;
      i = j;
      if (zzz.equal(Integer.valueOf(paramObject.BU), Integer.valueOf(this.BU)))
      {
        i = j;
        if (zzz.equal(Integer.valueOf(paramObject.BV), Integer.valueOf(this.BV)))
        {
          i = j;
          if (paramObject.zy == this.zy)
            i = 1;
        }
      }
    }
    return i;
  }

  protected boolean getBoolean(String paramString)
  {
    return this.zy.zze(paramString, this.BU, this.BV);
  }

  protected byte[] getByteArray(String paramString)
  {
    return this.zy.zzg(paramString, this.BU, this.BV);
  }

  protected float getFloat(String paramString)
  {
    return this.zy.zzf(paramString, this.BU, this.BV);
  }

  protected int getInteger(String paramString)
  {
    return this.zy.zzc(paramString, this.BU, this.BV);
  }

  protected long getLong(String paramString)
  {
    return this.zy.zzb(paramString, this.BU, this.BV);
  }

  protected String getString(String paramString)
  {
    return this.zy.zzd(paramString, this.BU, this.BV);
  }

  public int hashCode()
  {
    return zzz.hashCode(new Object[] { Integer.valueOf(this.BU), Integer.valueOf(this.BV), this.zy });
  }

  public boolean isDataValid()
  {
    return !this.zy.isClosed();
  }

  protected void zza(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.zy.zza(paramString, this.BU, this.BV, paramCharArrayBuffer);
  }

  protected int zzaul()
  {
    return this.BU;
  }

  protected void zzfy(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zy.getCount()));
    for (boolean bool = true; ; bool = false)
    {
      zzaa.zzbs(bool);
      this.BU = paramInt;
      this.BV = this.zy.zzga(this.BU);
      return;
    }
  }

  public boolean zzho(String paramString)
  {
    return this.zy.zzho(paramString);
  }

  protected Uri zzhp(String paramString)
  {
    return this.zy.zzh(paramString, this.BU, this.BV);
  }

  protected boolean zzhq(String paramString)
  {
    return this.zy.zzi(paramString, this.BU, this.BV);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.zzc
 * JD-Core Version:    0.6.0
 */
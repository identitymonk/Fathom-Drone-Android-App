package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.common.internal.zzz.zza;

public class zzant
{
  private String hN;

  public zzant(@Nullable String paramString)
  {
    this.hN = paramString;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzant))
      return false;
    paramObject = (zzant)paramObject;
    return zzz.equal(this.hN, paramObject.hN);
  }

  @Nullable
  public String getToken()
  {
    return this.hN;
  }

  public int hashCode()
  {
    return zzz.hashCode(new Object[] { this.hN });
  }

  public String toString()
  {
    return zzz.zzx(this).zzg("token", this.hN).toString();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzant
 * JD-Core Version:    0.6.0
 */
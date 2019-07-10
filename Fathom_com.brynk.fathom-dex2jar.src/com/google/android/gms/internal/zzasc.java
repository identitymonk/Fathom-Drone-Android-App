package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zzasc
{
  final byte[] btQ;
  final int tag;

  zzasc(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.btQ = paramArrayOfByte;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    do
    {
      return true;
      if (!(paramObject instanceof zzasc))
        return false;
      paramObject = (zzasc)paramObject;
    }
    while ((this.tag == paramObject.tag) && (Arrays.equals(this.btQ, paramObject.btQ)));
    return false;
  }

  public int hashCode()
  {
    return (this.tag + 527) * 31 + Arrays.hashCode(this.btQ);
  }

  void zza(zzart paramzzart)
    throws IOException
  {
    paramzzart.zzahd(this.tag);
    paramzzart.zzbh(this.btQ);
  }

  int zzx()
  {
    return zzart.zzahe(this.tag) + 0 + this.btQ.length;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzasc
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class zzaa extends ByteArrayOutputStream
{
  private final zzu zzbq;

  public zzaa(zzu paramzzu, int paramInt)
  {
    this.zzbq = paramzzu;
    this.buf = this.zzbq.zzb(Math.max(paramInt, 256));
  }

  private void zzd(int paramInt)
  {
    if (this.count + paramInt <= this.buf.length)
      return;
    byte[] arrayOfByte = this.zzbq.zzb((this.count + paramInt) * 2);
    System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
    this.zzbq.zza(this.buf);
    this.buf = arrayOfByte;
  }

  public void close()
    throws IOException
  {
    this.zzbq.zza(this.buf);
    this.buf = null;
    super.close();
  }

  public void finalize()
  {
    this.zzbq.zza(this.buf);
  }

  public void write(int paramInt)
  {
    monitorenter;
    try
    {
      zzd(1);
      super.write(paramInt);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    monitorenter;
    try
    {
      zzd(paramInt2);
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      monitorexit;
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      monitorexit;
    }
    throw paramArrayOfByte;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzaa
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class zzu
{
  protected static final Comparator<byte[]> zzbv = new Comparator()
  {
    public int zza(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      return paramArrayOfByte1.length - paramArrayOfByte2.length;
    }
  };
  private List<byte[]> zzbr = new LinkedList();
  private List<byte[]> zzbs = new ArrayList(64);
  private int zzbt = 0;
  private final int zzbu;

  public zzu(int paramInt)
  {
    this.zzbu = paramInt;
  }

  private void zzv()
  {
    monitorenter;
    try
    {
      if (this.zzbt > this.zzbu)
      {
        byte[] arrayOfByte = (byte[])this.zzbr.remove(0);
        this.zzbs.remove(arrayOfByte);
        this.zzbt -= arrayOfByte.length;
      }
    }
    finally
    {
      monitorexit;
    }
  }

  public void zza(byte[] paramArrayOfByte)
  {
    monitorenter;
    if (paramArrayOfByte != null);
    try
    {
      int i = paramArrayOfByte.length;
      int j = this.zzbu;
      if (i > j);
      while (true)
      {
        return;
        this.zzbr.add(paramArrayOfByte);
        j = Collections.binarySearch(this.zzbs, paramArrayOfByte, zzbv);
        i = j;
        if (j < 0)
          i = -j - 1;
        this.zzbs.add(i, paramArrayOfByte);
        this.zzbt += paramArrayOfByte.length;
        zzv();
      }
    }
    finally
    {
      monitorexit;
    }
    throw paramArrayOfByte;
  }

  public byte[] zzb(int paramInt)
  {
    monitorenter;
    int i = 0;
    try
    {
      byte[] arrayOfByte;
      if (i < this.zzbs.size())
      {
        arrayOfByte = (byte[])this.zzbs.get(i);
        if (arrayOfByte.length >= paramInt)
        {
          this.zzbt -= arrayOfByte.length;
          this.zzbs.remove(i);
          this.zzbr.remove(arrayOfByte);
        }
      }
      while (true)
      {
        return arrayOfByte;
        i += 1;
        break;
        arrayOfByte = new byte[paramInt];
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzu
 * JD-Core Version:    0.6.0
 */
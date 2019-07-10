package com.google.android.gms.internal;

public final class zzarw
  implements Cloneable
{
  private static final zzarx btI = new zzarx();
  private boolean btJ = false;
  private int[] btK;
  private zzarx[] btL;
  private int mSize;

  zzarw()
  {
    this(10);
  }

  zzarw(int paramInt)
  {
    paramInt = idealIntArraySize(paramInt);
    this.btK = new int[paramInt];
    this.btL = new zzarx[paramInt];
    this.mSize = 0;
  }

  private int idealByteArraySize(int paramInt)
  {
    int i = 4;
    while (true)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12)
          j = (1 << i) - 12;
      }
      else
        return j;
      i += 1;
    }
  }

  private int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }

  private boolean zza(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i])
        return false;
      i += 1;
    }
    return true;
  }

  private boolean zza(zzarx[] paramArrayOfzzarx1, zzarx[] paramArrayOfzzarx2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (!paramArrayOfzzarx1[i].equals(paramArrayOfzzarx2[i]))
        return false;
      i += 1;
    }
    return true;
  }

  private int zzahj(int paramInt)
  {
    int i = 0;
    int j = this.mSize - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = this.btK[k];
      if (m < paramInt)
      {
        i = k + 1;
        continue;
      }
      if (m > paramInt)
      {
        j = k - 1;
        continue;
      }
      return k;
    }
    return i ^ 0xFFFFFFFF;
  }

  public final zzarw cp()
  {
    int j = size();
    zzarw localzzarw = new zzarw(j);
    System.arraycopy(this.btK, 0, localzzarw.btK, 0, j);
    int i = 0;
    while (i < j)
    {
      if (this.btL[i] != null)
        localzzarw.btL[i] = ((zzarx)this.btL[i].clone());
      i += 1;
    }
    localzzarw.mSize = j;
    return localzzarw;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    do
    {
      return true;
      if (!(paramObject instanceof zzarw))
        return false;
      paramObject = (zzarw)paramObject;
      if (size() != paramObject.size())
        return false;
    }
    while ((zza(this.btK, paramObject.btK, this.mSize)) && (zza(this.btL, paramObject.btL, this.mSize)));
    return false;
  }

  public int hashCode()
  {
    int j = 17;
    int i = 0;
    while (i < this.mSize)
    {
      j = (j * 31 + this.btK[i]) * 31 + this.btL[i].hashCode();
      i += 1;
    }
    return j;
  }

  public boolean isEmpty()
  {
    return size() == 0;
  }

  int size()
  {
    return this.mSize;
  }

  void zza(int paramInt, zzarx paramzzarx)
  {
    int i = zzahj(paramInt);
    if (i >= 0)
    {
      this.btL[i] = paramzzarx;
      return;
    }
    i ^= -1;
    if ((i < this.mSize) && (this.btL[i] == btI))
    {
      this.btK[i] = paramInt;
      this.btL[i] = paramzzarx;
      return;
    }
    if (this.mSize >= this.btK.length)
    {
      int j = idealIntArraySize(this.mSize + 1);
      int[] arrayOfInt = new int[j];
      zzarx[] arrayOfzzarx = new zzarx[j];
      System.arraycopy(this.btK, 0, arrayOfInt, 0, this.btK.length);
      System.arraycopy(this.btL, 0, arrayOfzzarx, 0, this.btL.length);
      this.btK = arrayOfInt;
      this.btL = arrayOfzzarx;
    }
    if (this.mSize - i != 0)
    {
      System.arraycopy(this.btK, i, this.btK, i + 1, this.mSize - i);
      System.arraycopy(this.btL, i, this.btL, i + 1, this.mSize - i);
    }
    this.btK[i] = paramInt;
    this.btL[i] = paramzzarx;
    this.mSize += 1;
  }

  zzarx zzahh(int paramInt)
  {
    paramInt = zzahj(paramInt);
    if ((paramInt < 0) || (this.btL[paramInt] == btI))
      return null;
    return this.btL[paramInt];
  }

  zzarx zzahi(int paramInt)
  {
    return this.btL[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzarw
 * JD-Core Version:    0.6.0
 */
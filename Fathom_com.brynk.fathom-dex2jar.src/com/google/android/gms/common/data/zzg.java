package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class zzg<T> extends zzb<T>
{
  private T Cn;

  public zzg(DataBuffer<T> paramDataBuffer)
  {
    super(paramDataBuffer);
  }

  public T next()
  {
    if (!hasNext())
    {
      int i = this.BS;
      throw new NoSuchElementException(46 + "Cannot advance the iterator beyond " + i);
    }
    this.BS += 1;
    if (this.BS == 0)
    {
      this.Cn = this.BR.get(0);
      if (!(this.Cn instanceof zzc))
      {
        String str = String.valueOf(this.Cn.getClass());
        throw new IllegalStateException(String.valueOf(str).length() + 44 + "DataBuffer reference of type " + str + " is not movable");
      }
    }
    else
    {
      ((zzc)this.Cn).zzfy(this.BS);
    }
    return this.Cn;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.zzg
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T> extends AbstractDataBuffer<T>
{
  private boolean Cl = false;
  private ArrayList<Integer> Cm;

  protected zzf(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }

  private void zzaur()
  {
    monitorenter;
    while (true)
    {
      int i;
      String str2;
      try
      {
        if (this.Cl)
          break label204;
        int j = this.zy.getCount();
        this.Cm = new ArrayList();
        if (j <= 0)
          break label199;
        this.Cm.add(Integer.valueOf(0));
        String str3 = zzauq();
        i = this.zy.zzga(0);
        String str1 = this.zy.zzd(str3, 0, i);
        i = 1;
        if (i >= j)
          break label199;
        int k = this.zy.zzga(i);
        str2 = this.zy.zzd(str3, i, k);
        if (str2 == null)
          throw new NullPointerException(String.valueOf(str3).length() + 78 + "Missing value for markerColumn: " + str3 + ", at row: " + i + ", for window: " + k);
      }
      finally
      {
        monitorexit;
      }
      if (!str2.equals(localObject1))
      {
        this.Cm.add(Integer.valueOf(i));
        Object localObject2 = str2;
        break label207;
        label199: this.Cl = true;
        label204: monitorexit;
        return;
      }
      label207: i += 1;
    }
  }

  public final T get(int paramInt)
  {
    zzaur();
    return zzn(zzge(paramInt), zzgf(paramInt));
  }

  public int getCount()
  {
    zzaur();
    return this.Cm.size();
  }

  protected abstract String zzauq();

  protected String zzaus()
  {
    return null;
  }

  int zzge(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.Cm.size()))
      throw new IllegalArgumentException(53 + "Position " + paramInt + " is out of bounds for this buffer");
    return ((Integer)this.Cm.get(paramInt)).intValue();
  }

  protected int zzgf(int paramInt)
  {
    int j;
    if ((paramInt < 0) || (paramInt == this.Cm.size()))
    {
      j = 0;
      return j;
    }
    if (paramInt == this.Cm.size() - 1);
    for (int i = this.zy.getCount() - ((Integer)this.Cm.get(paramInt)).intValue(); ; i = ((Integer)this.Cm.get(paramInt + 1)).intValue() - ((Integer)this.Cm.get(paramInt)).intValue())
    {
      j = i;
      if (i != 1)
        break;
      paramInt = zzge(paramInt);
      int k = this.zy.zzga(paramInt);
      String str = zzaus();
      j = i;
      if (str == null)
        break;
      j = i;
      if (this.zy.zzd(str, paramInt, k) != null)
        break;
      return 0;
    }
  }

  protected abstract T zzn(int paramInt1, int paramInt2);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.zzf
 * JD-Core Version:    0.6.0
 */
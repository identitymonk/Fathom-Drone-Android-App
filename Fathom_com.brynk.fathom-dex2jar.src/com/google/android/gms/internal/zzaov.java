package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzaov extends zzaoy
  implements Iterable<zzaoy>
{
  private final List<zzaoy> aOH = new ArrayList();

  public Number aT()
  {
    if (this.aOH.size() == 1)
      return ((zzaoy)this.aOH.get(0)).aT();
    throw new IllegalStateException();
  }

  public String aU()
  {
    if (this.aOH.size() == 1)
      return ((zzaoy)this.aOH.get(0)).aU();
    throw new IllegalStateException();
  }

  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof zzaov)) && (((zzaov)paramObject).aOH.equals(this.aOH)));
  }

  public boolean getAsBoolean()
  {
    if (this.aOH.size() == 1)
      return ((zzaoy)this.aOH.get(0)).getAsBoolean();
    throw new IllegalStateException();
  }

  public double getAsDouble()
  {
    if (this.aOH.size() == 1)
      return ((zzaoy)this.aOH.get(0)).getAsDouble();
    throw new IllegalStateException();
  }

  public int getAsInt()
  {
    if (this.aOH.size() == 1)
      return ((zzaoy)this.aOH.get(0)).getAsInt();
    throw new IllegalStateException();
  }

  public long getAsLong()
  {
    if (this.aOH.size() == 1)
      return ((zzaoy)this.aOH.get(0)).getAsLong();
    throw new IllegalStateException();
  }

  public int hashCode()
  {
    return this.aOH.hashCode();
  }

  public Iterator<zzaoy> iterator()
  {
    return this.aOH.iterator();
  }

  public int size()
  {
    return this.aOH.size();
  }

  public zzaoy zzagm(int paramInt)
  {
    return (zzaoy)this.aOH.get(paramInt);
  }

  public void zzc(zzaoy paramzzaoy)
  {
    Object localObject = paramzzaoy;
    if (paramzzaoy == null)
      localObject = zzapa.bou;
    this.aOH.add(localObject);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzaov
 * JD-Core Version:    0.6.0
 */
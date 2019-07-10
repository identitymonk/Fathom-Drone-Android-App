package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzaa;

public class BooleanResult
  implements Result
{
  private final Status hv;
  private final boolean xv;

  public BooleanResult(Status paramStatus, boolean paramBoolean)
  {
    this.hv = ((Status)zzaa.zzb(paramStatus, "Status must not be null"));
    this.xv = paramBoolean;
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    do
    {
      return true;
      if (!(paramObject instanceof BooleanResult))
        return false;
      paramObject = (BooleanResult)paramObject;
    }
    while ((this.hv.equals(paramObject.hv)) && (this.xv == paramObject.xv));
    return false;
  }

  public Status getStatus()
  {
    return this.hv;
  }

  public boolean getValue()
  {
    return this.xv;
  }

  public final int hashCode()
  {
    int j = this.hv.hashCode();
    if (this.xv);
    for (int i = 1; ; i = 0)
      return i + (j + 527) * 31;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.BooleanResult
 * JD-Core Version:    0.6.0
 */
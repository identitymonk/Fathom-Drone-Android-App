package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.zzz;

public final class zzql<O extends Api.ApiOptions>
{
  private final Api<O> vS;
  private final O xw;
  private final boolean yo;
  private final int yp;

  private zzql(Api<O> paramApi)
  {
    this.yo = true;
    this.vS = paramApi;
    this.xw = null;
    this.yp = System.identityHashCode(this);
  }

  private zzql(Api<O> paramApi, O paramO)
  {
    this.yo = false;
    this.vS = paramApi;
    this.xw = paramO;
    this.yp = zzz.hashCode(new Object[] { this.vS, this.xw });
  }

  public static <O extends Api.ApiOptions> zzql<O> zza(Api<O> paramApi, O paramO)
  {
    return new zzql(paramApi, paramO);
  }

  public static <O extends Api.ApiOptions> zzql<O> zzb(Api<O> paramApi)
  {
    return new zzql(paramApi);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    do
    {
      return true;
      if (!(paramObject instanceof zzql))
        return false;
      paramObject = (zzql)paramObject;
    }
    while ((!this.yo) && (!paramObject.yo) && (zzz.equal(this.vS, paramObject.vS)) && (zzz.equal(this.xw, paramObject.xw)));
    return false;
  }

  public int hashCode()
  {
    return this.yp;
  }

  public String zzarl()
  {
    return this.vS.getName();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzql
 * JD-Core Version:    0.6.0
 */
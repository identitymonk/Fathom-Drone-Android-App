package com.google.android.gms.common.api;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzql;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class zzb extends Exception
{
  private final ArrayMap<zzql<?>, ConnectionResult> xo;

  public zzb(ArrayMap<zzql<?>, ConnectionResult> paramArrayMap)
  {
    this.xo = paramArrayMap;
  }

  public String getMessage()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.xo.keySet().iterator();
    int i = 1;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (zzql)((Iterator)localObject1).next();
      Object localObject2 = (ConnectionResult)this.xo.get(localObject3);
      if (((ConnectionResult)localObject2).isSuccess())
        i = 0;
      localObject3 = String.valueOf(((zzql)localObject3).zzarl());
      localObject2 = String.valueOf(localObject2);
      localArrayList.add(String.valueOf(localObject3).length() + 2 + String.valueOf(localObject2).length() + (String)localObject3 + ": " + (String)localObject2);
    }
    localObject1 = new StringBuilder();
    if (i != 0)
      ((StringBuilder)localObject1).append("None of the queried APIs are available. ");
    while (true)
    {
      zzx.zzia("; ").zza((StringBuilder)localObject1, localArrayList);
      return ((StringBuilder)localObject1).toString();
      ((StringBuilder)localObject1).append("Some of the queried APIs are unavailable. ");
    }
  }

  public ArrayMap<zzql<?>, ConnectionResult> zzara()
  {
    return this.xo;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.zzb
 * JD-Core Version:    0.6.0
 */
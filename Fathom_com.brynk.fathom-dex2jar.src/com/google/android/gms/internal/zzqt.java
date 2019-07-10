package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.zzc;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Lcom.google.android.gms.common.api.Api.zzc<*>;Lcom.google.android.gms.common.api.Api.zze;>;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

final class zzqt
  implements zzrm
{
  private final Context mContext;
  private final zzrd yW;
  private final zzrf yX;
  private final zzrf yY;
  private final Map<Api.zzc<?>, zzrf> yZ;
  private final Set<zzsa> za = Collections.newSetFromMap(new WeakHashMap());
  private final Api.zze zb;
  private Bundle zc;
  private ConnectionResult zd = null;
  private ConnectionResult ze = null;
  private boolean zf = false;
  private final Lock zg;
  private int zh = 0;
  private final Looper zzajy;

  private zzqt(Context paramContext, zzrd paramzzrd, Lock paramLock, Looper paramLooper, zzc paramzzc, Map<Api.zzc<?>, Api.zze> paramMap1, Map<Api.zzc<?>, Api.zze> paramMap2, zzf paramzzf, Api.zza<? extends zzxp, zzxq> paramzza, Api.zze paramzze, ArrayList<zzqr> paramArrayList1, ArrayList<zzqr> paramArrayList2, Map<Api<?>, Integer> paramMap3, Map<Api<?>, Integer> paramMap4)
  {
    this.mContext = paramContext;
    this.yW = paramzzrd;
    this.zg = paramLock;
    this.zzajy = paramLooper;
    this.zb = paramzze;
    this.yX = new zzrf(paramContext, this.yW, paramLock, paramLooper, paramzzc, paramMap2, null, paramMap4, null, paramArrayList2, new zza(null));
    this.yY = new zzrf(paramContext, this.yW, paramLock, paramLooper, paramzzc, paramMap1, paramzzf, paramMap3, paramzza, paramArrayList1, new zzb(null));
    paramContext = new ArrayMap();
    paramzzrd = paramMap2.keySet().iterator();
    while (paramzzrd.hasNext())
      paramContext.put((Api.zzc)paramzzrd.next(), this.yX);
    paramzzrd = paramMap1.keySet().iterator();
    while (paramzzrd.hasNext())
      paramContext.put((Api.zzc)paramzzrd.next(), this.yY);
    this.yZ = Collections.unmodifiableMap(paramContext);
  }

  public static zzqt zza(Context paramContext, zzrd paramzzrd, Lock paramLock, Looper paramLooper, zzc paramzzc, Map<Api.zzc<?>, Api.zze> paramMap, zzf paramzzf, Map<Api<?>, Integer> paramMap1, Api.zza<? extends zzxp, zzxq> paramzza, ArrayList<zzqr> paramArrayList)
  {
    Object localObject1 = null;
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    Object localObject2 = paramMap.entrySet().iterator();
    paramMap = (Map<Api.zzc<?>, Api.zze>)localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = (Api.zze)((Map.Entry)localObject3).getValue();
      if (((Api.zze)localObject1).zzajc())
        paramMap = (Map<Api.zzc<?>, Api.zze>)localObject1;
      if (((Api.zze)localObject1).zzain())
      {
        localArrayMap1.put((Api.zzc)((Map.Entry)localObject3).getKey(), localObject1);
        continue;
      }
      localArrayMap2.put((Api.zzc)((Map.Entry)localObject3).getKey(), localObject1);
    }
    boolean bool;
    if (!localArrayMap1.isEmpty())
    {
      bool = true;
      zzaa.zza(bool, "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
      localObject1 = new ArrayMap();
      localObject2 = new ArrayMap();
      localObject3 = paramMap1.keySet().iterator();
    }
    Object localObject4;
    while (true)
    {
      if (!((Iterator)localObject3).hasNext())
        break label314;
      localObject4 = (Api)((Iterator)localObject3).next();
      Api.zzc localzzc = ((Api)localObject4).zzaqv();
      if (localArrayMap1.containsKey(localzzc))
      {
        ((Map)localObject1).put(localObject4, (Integer)paramMap1.get(localObject4));
        continue;
        bool = false;
        break;
      }
      if (!localArrayMap2.containsKey(localzzc))
        break label304;
      ((Map)localObject2).put(localObject4, (Integer)paramMap1.get(localObject4));
    }
    label304: throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
    label314: paramMap1 = new ArrayList();
    Object localObject3 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject4 = (zzqr)paramArrayList.next();
      if (((Map)localObject1).containsKey(((zzqr)localObject4).vS))
      {
        paramMap1.add(localObject4);
        continue;
      }
      if (((Map)localObject2).containsKey(((zzqr)localObject4).vS))
      {
        ((ArrayList)localObject3).add(localObject4);
        continue;
      }
      throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
    }
    return (zzqt)(zzqt)(zzqt)(zzqt)new zzqt(paramContext, paramzzrd, paramLock, paramLooper, paramzzc, localArrayMap1, localArrayMap2, paramzzf, paramzza, paramMap, paramMap1, (ArrayList)localObject3, (Map)localObject1, (Map)localObject2);
  }

  private void zza(ConnectionResult paramConnectionResult)
  {
    switch (this.zh)
    {
    default:
      Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
    case 2:
    case 1:
    }
    while (true)
    {
      this.zh = 0;
      return;
      this.yW.zzc(paramConnectionResult);
      zzase();
    }
  }

  private void zzasb()
  {
    this.ze = null;
    this.zd = null;
    this.yX.connect();
    this.yY.connect();
  }

  private void zzasc()
  {
    if (zzb(this.zd))
      if ((zzb(this.ze)) || (zzasf()))
        zzasd();
    do
    {
      do
        return;
      while (this.ze == null);
      if (this.zh == 1)
      {
        zzase();
        return;
      }
      zza(this.ze);
      this.yX.disconnect();
      return;
      if ((this.zd == null) || (!zzb(this.ze)))
        continue;
      this.yY.disconnect();
      zza(this.zd);
      return;
    }
    while ((this.zd == null) || (this.ze == null));
    ConnectionResult localConnectionResult = this.zd;
    if (this.yY.AB < this.yX.AB)
      localConnectionResult = this.ze;
    zza(localConnectionResult);
  }

  private void zzasd()
  {
    switch (this.zh)
    {
    default:
      Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
    case 2:
    case 1:
    }
    while (true)
    {
      this.zh = 0;
      return;
      this.yW.zzn(this.zc);
      zzase();
    }
  }

  private void zzase()
  {
    Iterator localIterator = this.za.iterator();
    while (localIterator.hasNext())
      ((zzsa)localIterator.next()).zzajb();
    this.za.clear();
  }

  private boolean zzasf()
  {
    return (this.ze != null) && (this.ze.getErrorCode() == 4);
  }

  @Nullable
  private PendingIntent zzasg()
  {
    if (this.zb == null)
      return null;
    return PendingIntent.getActivity(this.mContext, this.yW.getSessionId(), this.zb.zzajd(), 134217728);
  }

  private void zzb(int paramInt, boolean paramBoolean)
  {
    this.yW.zzc(paramInt, paramBoolean);
    this.ze = null;
    this.zd = null;
  }

  private static boolean zzb(ConnectionResult paramConnectionResult)
  {
    return (paramConnectionResult != null) && (paramConnectionResult.isSuccess());
  }

  private boolean zzc(zzqo.zza<? extends Result, ? extends Api.zzb> paramzza)
  {
    paramzza = paramzza.zzaqv();
    zzaa.zzb(this.yZ.containsKey(paramzza), "GoogleApiClient is not configured to use the API required for this call.");
    return ((zzrf)this.yZ.get(paramzza)).equals(this.yY);
  }

  private void zzm(Bundle paramBundle)
  {
    if (this.zc == null)
      this.zc = paramBundle;
    do
      return;
    while (paramBundle == null);
    this.zc.putAll(paramBundle);
  }

  public ConnectionResult blockingConnect()
  {
    throw new UnsupportedOperationException();
  }

  public ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }

  public void connect()
  {
    this.zh = 2;
    this.zf = false;
    zzasb();
  }

  public void disconnect()
  {
    this.ze = null;
    this.zd = null;
    this.zh = 0;
    this.yX.disconnect();
    this.yY.disconnect();
    zzase();
  }

  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("authClient").println(":");
    this.yY.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("anonClient").println(":");
    this.yX.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }

  @Nullable
  public ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    if (((zzrf)this.yZ.get(paramApi.zzaqv())).equals(this.yY))
    {
      if (zzasf())
        return new ConnectionResult(4, zzasg());
      return this.yY.getConnectionResult(paramApi);
    }
    return this.yX.getConnectionResult(paramApi);
  }

  public boolean isConnected()
  {
    int k = 1;
    this.zg.lock();
    try
    {
      if (this.yX.isConnected())
      {
        j = k;
        if (!zzasa())
        {
          j = k;
          if (!zzasf())
          {
            int i = this.zh;
            if (i != 1)
              break label62;
          }
        }
      }
      label62: for (int j = k; ; j = 0)
        return j;
    }
    finally
    {
      this.zg.unlock();
    }
    throw localObject;
  }

  public boolean isConnecting()
  {
    this.zg.lock();
    try
    {
      int i = this.zh;
      if (i == 2)
      {
        j = 1;
        return j;
      }
      int j = 0;
    }
    finally
    {
      this.zg.unlock();
    }
  }

  public <A extends Api.zzb, R extends Result, T extends zzqo.zza<R, A>> T zza(@NonNull T paramT)
  {
    if (zzc(paramT))
    {
      if (zzasf())
      {
        paramT.zzaa(new Status(4, null, zzasg()));
        return paramT;
      }
      return this.yY.zza(paramT);
    }
    return this.yX.zza(paramT);
  }

  public boolean zza(zzsa paramzzsa)
  {
    this.zg.lock();
    try
    {
      if (((isConnecting()) || (isConnected())) && (!zzasa()))
      {
        this.za.add(paramzzsa);
        if (this.zh == 0)
          this.zh = 1;
        this.ze = null;
        this.yY.connect();
        return true;
      }
      return false;
    }
    finally
    {
      this.zg.unlock();
    }
    throw paramzzsa;
  }

  public void zzard()
  {
    this.zg.lock();
    try
    {
      boolean bool = isConnecting();
      this.yY.disconnect();
      this.ze = new ConnectionResult(4);
      if (bool)
        new Handler(this.zzajy).post(new Runnable()
        {
          public void run()
          {
            zzqt.zza(zzqt.this).lock();
            try
            {
              zzqt.zzb(zzqt.this);
              return;
            }
            finally
            {
              zzqt.zza(zzqt.this).unlock();
            }
            throw localObject;
          }
        });
      while (true)
      {
        return;
        zzase();
      }
    }
    finally
    {
      this.zg.unlock();
    }
    throw localObject;
  }

  public void zzarz()
  {
    this.yX.zzarz();
    this.yY.zzarz();
  }

  public boolean zzasa()
  {
    return this.yY.isConnected();
  }

  public <A extends Api.zzb, T extends zzqo.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    if (zzc(paramT))
    {
      if (zzasf())
      {
        paramT.zzaa(new Status(4, null, zzasg()));
        return paramT;
      }
      return this.yY.zzb(paramT);
    }
    return this.yX.zzb(paramT);
  }

  private class zza
    implements zzrm.zza
  {
    private zza()
    {
    }

    public void zzc(int paramInt, boolean paramBoolean)
    {
      zzqt.zza(zzqt.this).lock();
      try
      {
        if ((zzqt.zzc(zzqt.this)) || (zzqt.zzd(zzqt.this) == null) || (!zzqt.zzd(zzqt.this).isSuccess()))
        {
          zzqt.zza(zzqt.this, false);
          zzqt.zza(zzqt.this, paramInt, paramBoolean);
          return;
        }
        zzqt.zza(zzqt.this, true);
        zzqt.zze(zzqt.this).onConnectionSuspended(paramInt);
        return;
      }
      finally
      {
        zzqt.zza(zzqt.this).unlock();
      }
      throw localObject;
    }

    public void zzc(@NonNull ConnectionResult paramConnectionResult)
    {
      zzqt.zza(zzqt.this).lock();
      try
      {
        zzqt.zza(zzqt.this, paramConnectionResult);
        zzqt.zzb(zzqt.this);
        return;
      }
      finally
      {
        zzqt.zza(zzqt.this).unlock();
      }
      throw paramConnectionResult;
    }

    public void zzn(@Nullable Bundle paramBundle)
    {
      zzqt.zza(zzqt.this).lock();
      try
      {
        zzqt.zza(zzqt.this, paramBundle);
        zzqt.zza(zzqt.this, ConnectionResult.wO);
        zzqt.zzb(zzqt.this);
        return;
      }
      finally
      {
        zzqt.zza(zzqt.this).unlock();
      }
      throw paramBundle;
    }
  }

  private class zzb
    implements zzrm.zza
  {
    private zzb()
    {
    }

    public void zzc(int paramInt, boolean paramBoolean)
    {
      zzqt.zza(zzqt.this).lock();
      try
      {
        if (zzqt.zzc(zzqt.this))
        {
          zzqt.zza(zzqt.this, false);
          zzqt.zza(zzqt.this, paramInt, paramBoolean);
          return;
        }
        zzqt.zza(zzqt.this, true);
        zzqt.zzf(zzqt.this).onConnectionSuspended(paramInt);
        return;
      }
      finally
      {
        zzqt.zza(zzqt.this).unlock();
      }
      throw localObject;
    }

    public void zzc(@NonNull ConnectionResult paramConnectionResult)
    {
      zzqt.zza(zzqt.this).lock();
      try
      {
        zzqt.zzb(zzqt.this, paramConnectionResult);
        zzqt.zzb(zzqt.this);
        return;
      }
      finally
      {
        zzqt.zza(zzqt.this).unlock();
      }
      throw paramConnectionResult;
    }

    public void zzn(@Nullable Bundle paramBundle)
    {
      zzqt.zza(zzqt.this).lock();
      try
      {
        zzqt.zzb(zzqt.this, ConnectionResult.wO);
        zzqt.zzb(zzqt.this);
        return;
      }
      finally
      {
        zzqt.zza(zzqt.this).unlock();
      }
      throw paramBundle;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzqt
 * JD-Core Version:    0.6.0
 */
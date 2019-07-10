package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzqu
  implements zzrm
{
  private final zzrh xy;
  private final Lock zg;
  private final Map<Api.zzc<?>, com.google.android.gms.common.api.zzc<?>> zj = new HashMap();
  private final Map<Api<?>, Integer> zk;
  private final zzrd zl;
  private final com.google.android.gms.common.zzc zm;
  private final Condition zn;
  private boolean zo;
  private Map<zzql<?>, ConnectionResult> zp;
  private ConnectionResult zq;
  private final Looper zzajy;

  public zzqu(Context paramContext, Lock paramLock, Looper paramLooper, com.google.android.gms.common.zzc paramzzc, Map<Api.zzc<?>, Api.zze> paramMap, Map<Api<?>, Integer> paramMap1, ArrayList<zzqr> paramArrayList, zzrd paramzzrd)
  {
    this.zg = paramLock;
    this.zzajy = paramLooper;
    this.zn = paramLock.newCondition();
    this.zm = paramzzc;
    this.zl = paramzzrd;
    this.zk = paramMap1;
    paramLock = new HashMap();
    paramzzc = paramMap1.keySet().iterator();
    while (paramzzc.hasNext())
    {
      paramMap1 = (Api)paramzzc.next();
      paramLock.put(paramMap1.zzaqv(), paramMap1);
    }
    paramzzc = new HashMap();
    paramMap1 = paramArrayList.iterator();
    while (paramMap1.hasNext())
    {
      paramArrayList = (zzqr)paramMap1.next();
      paramzzc.put(paramArrayList.vS, paramArrayList);
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      paramMap1 = (Map.Entry)paramMap.next();
      paramArrayList = (Api)paramLock.get(paramMap1.getKey());
      paramArrayList = new com.google.android.gms.common.api.zzc(paramContext, paramArrayList, paramLooper, (Api.zze)paramMap1.getValue(), (zzqr)paramzzc.get(paramArrayList))
      {
      };
      this.zj.put((Api.zzc)paramMap1.getKey(), paramArrayList);
    }
    this.xy = zzrh.zzatg();
  }

  public ConnectionResult blockingConnect()
  {
    connect();
    while (isConnecting())
      try
      {
        this.zn.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        return new ConnectionResult(15, null);
      }
    if (isConnected())
      return ConnectionResult.wO;
    if (this.zq != null)
      return this.zq;
    return new ConnectionResult(13, null);
  }

  public ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    connect();
    paramLong = paramTimeUnit.toNanos(paramLong);
    while (isConnecting())
    {
      if (paramLong <= 0L);
      try
      {
        disconnect();
        return new ConnectionResult(14, null);
        paramLong = this.zn.awaitNanos(paramLong);
      }
      catch (InterruptedException paramTimeUnit)
      {
        Thread.currentThread().interrupt();
        return new ConnectionResult(15, null);
      }
    }
    if (isConnected())
      return ConnectionResult.wO;
    if (this.zq != null)
      return this.zq;
    return new ConnectionResult(13, null);
  }

  public void connect()
  {
    this.zg.lock();
    try
    {
      boolean bool = this.zo;
      if (bool)
        return;
      this.zo = true;
      this.zp = null;
      this.zq = null;
      zza localzza = new zza(null);
      zzsv localzzsv = new zzsv(this.zzajy);
      this.xy.zza(this.zj.values()).addOnSuccessListener(localzzsv, localzza).addOnFailureListener(localzzsv, localzza);
      return;
    }
    finally
    {
      this.zg.unlock();
    }
    throw localObject;
  }

  public void disconnect()
  {
    this.zg.lock();
    try
    {
      this.zo = false;
      this.zp = null;
      this.zq = null;
      this.zn.signalAll();
      return;
    }
    finally
    {
      this.zg.unlock();
    }
    throw localObject;
  }

  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
  }

  @Nullable
  public ConnectionResult getConnectionResult(@NonNull Api<?> paramApi)
  {
    this.zg.lock();
    try
    {
      if (((com.google.android.gms.common.api.zzc)this.zj.get(paramApi.zzaqv())).getClient().isConnected())
      {
        paramApi = ConnectionResult.wO;
        return paramApi;
      }
      if (this.zp != null)
      {
        paramApi = (ConnectionResult)this.zp.get(((com.google.android.gms.common.api.zzc)this.zj.get(paramApi.zzaqv())).getApiKey());
        return paramApi;
      }
      return null;
    }
    finally
    {
      this.zg.unlock();
    }
    throw paramApi;
  }

  public boolean isConnected()
  {
    this.zg.lock();
    try
    {
      if (this.zp != null)
      {
        ConnectionResult localConnectionResult = this.zq;
        if (localConnectionResult == null)
        {
          i = 1;
          return i;
        }
      }
      int i = 0;
    }
    finally
    {
      this.zg.unlock();
    }
  }

  public boolean isConnecting()
  {
    this.zg.lock();
    try
    {
      if (this.zp == null)
      {
        bool = this.zo;
        if (bool)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
    finally
    {
      this.zg.unlock();
    }
  }

  public <A extends Api.zzb, R extends Result, T extends zzqo.zza<R, A>> T zza(@NonNull T paramT)
  {
    this.zl.Ap.zzb(paramT);
    return ((com.google.android.gms.common.api.zzc)this.zj.get(paramT.zzaqv())).doRead(paramT);
  }

  public boolean zza(zzsa paramzzsa)
  {
    throw new UnsupportedOperationException();
  }

  public void zzard()
  {
    throw new UnsupportedOperationException();
  }

  public void zzarz()
  {
  }

  public <A extends Api.zzb, T extends zzqo.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    this.zl.Ap.zzb(paramT);
    return ((com.google.android.gms.common.api.zzc)this.zj.get(paramT.zzaqv())).doWrite(paramT);
  }

  private class zza
    implements OnFailureListener, OnSuccessListener<Void>
  {
    private zza()
    {
    }

    @Nullable
    private ConnectionResult zzash()
    {
      Object localObject1 = null;
      int i = 0;
      Iterator localIterator = zzqu.zzg(zzqu.this).keySet().iterator();
      Object localObject2;
      int j;
      while (true)
        if (localIterator.hasNext())
        {
          localObject2 = (Api)localIterator.next();
          ConnectionResult localConnectionResult = (ConnectionResult)zzqu.zzc(zzqu.this).get(((com.google.android.gms.common.api.zzc)zzqu.zzb(zzqu.this).get(((Api)localObject2).zzaqv())).getApiKey());
          if (localConnectionResult.isSuccess())
            continue;
          j = ((Integer)zzqu.zzg(zzqu.this).get(localObject2)).intValue();
          if ((j == 2) || ((j == 1) && (!localConnectionResult.hasResolution()) && (!zzqu.zzh(zzqu.this).isUserResolvableError(localConnectionResult.getErrorCode()))))
            continue;
          int k = ((Api)localObject2).zzaqs().getPriority();
          j = k;
          localObject2 = localConnectionResult;
          if (localObject1 == null)
            break;
          if (i <= k)
            break label194;
          localObject2 = localConnectionResult;
          j = k;
        }
      while (true)
      {
        i = j;
        localObject1 = localObject2;
        break;
        return localObject1;
        label194: j = i;
        localObject2 = localObject1;
      }
    }

    public void onFailure(@NonNull Exception paramException)
    {
      paramException = (zzb)paramException;
      zzqu.zza(zzqu.this).lock();
      try
      {
        zzqu.zza(zzqu.this, paramException.zzara());
        zzqu.zza(zzqu.this, zzash());
        if (zzqu.zzf(zzqu.this) == null)
          zzqu.zzd(zzqu.this).zzn(null);
        while (true)
        {
          zzqu.zze(zzqu.this).signalAll();
          return;
          zzqu.zza(zzqu.this, false);
          zzqu.zzd(zzqu.this).zzc(zzqu.zzf(zzqu.this));
        }
      }
      finally
      {
        zzqu.zza(zzqu.this).unlock();
      }
      throw paramException;
    }

    public void zza(Void paramVoid)
    {
      zzqu.zza(zzqu.this).lock();
      try
      {
        zzqu.zza(zzqu.this, new ArrayMap(zzqu.zzb(zzqu.this).size()));
        paramVoid = zzqu.zzb(zzqu.this).keySet().iterator();
        while (paramVoid.hasNext())
        {
          Api.zzc localzzc = (Api.zzc)paramVoid.next();
          zzqu.zzc(zzqu.this).put(((com.google.android.gms.common.api.zzc)zzqu.zzb(zzqu.this).get(localzzc)).getApiKey(), ConnectionResult.wO);
        }
      }
      finally
      {
        zzqu.zza(zzqu.this).unlock();
      }
      zzqu.zzd(zzqu.this).zzn(null);
      zzqu.zze(zzqu.this).signalAll();
      zzqu.zza(zzqu.this).unlock();
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzqu
 * JD-Core Version:    0.6.0
 */
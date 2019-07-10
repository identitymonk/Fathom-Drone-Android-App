package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zze.zzf;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zza;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.zzc;
import com.google.android.gms.signin.internal.SignInResponse;
import com.google.android.gms.signin.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzrb
  implements zzre
{
  private final Context mContext;
  private final Api.zza<? extends zzxp, zzxq> xQ;
  private final zzrf zA;
  private int zD;
  private int zE = 0;
  private int zF;
  private final Bundle zG = new Bundle();
  private final Set<Api.zzc> zH = new HashSet();
  private zzxp zI;
  private int zJ;
  private boolean zK;
  private boolean zL;
  private zzp zM;
  private boolean zN;
  private boolean zO;
  private final zzf zP;
  private ArrayList<Future<?>> zQ = new ArrayList();
  private final Lock zg;
  private final Map<Api<?>, Integer> zk;
  private final zzc zm;
  private ConnectionResult zq;

  public zzrb(zzrf paramzzrf, zzf paramzzf, Map<Api<?>, Integer> paramMap, zzc paramzzc, Api.zza<? extends zzxp, zzxq> paramzza, Lock paramLock, Context paramContext)
  {
    this.zA = paramzzrf;
    this.zP = paramzzf;
    this.zk = paramMap;
    this.zm = paramzzc;
    this.xQ = paramzza;
    this.zg = paramLock;
    this.mContext = paramContext;
  }

  private void zza(SignInResponse paramSignInResponse)
  {
    if (!zzft(0))
      return;
    Object localObject = paramSignInResponse.zzawn();
    if (((ConnectionResult)localObject).isSuccess())
    {
      localObject = paramSignInResponse.zzcdn();
      paramSignInResponse = ((ResolveAccountResponse)localObject).zzawn();
      if (!paramSignInResponse.isSuccess())
      {
        localObject = String.valueOf(paramSignInResponse);
        Log.wtf("GoogleApiClientConnecting", String.valueOf(localObject).length() + 48 + "Sign-in succeeded with resolve account failure: " + (String)localObject, new Exception());
        zzf(paramSignInResponse);
        return;
      }
      this.zL = true;
      this.zM = ((ResolveAccountResponse)localObject).zzawm();
      this.zN = ((ResolveAccountResponse)localObject).zzawo();
      this.zO = ((ResolveAccountResponse)localObject).zzawp();
      zzasq();
      return;
    }
    if (zze((ConnectionResult)localObject))
    {
      zzast();
      zzasq();
      return;
    }
    zzf((ConnectionResult)localObject);
  }

  private boolean zza(int paramInt1, int paramInt2, ConnectionResult paramConnectionResult)
  {
    if ((paramInt2 == 1) && (!zzd(paramConnectionResult)));
    do
      return false;
    while ((this.zq != null) && (paramInt1 >= this.zD));
    return true;
  }

  private boolean zzasp()
  {
    this.zF -= 1;
    if (this.zF > 0)
      return false;
    if (this.zF < 0)
    {
      Log.w("GoogleApiClientConnecting", this.zA.yW.zzatb());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      zzf(new ConnectionResult(8, null));
      return false;
    }
    if (this.zq != null)
    {
      this.zA.AB = this.zD;
      zzf(this.zq);
      return false;
    }
    return true;
  }

  private void zzasq()
  {
    if (this.zF != 0);
    do
      return;
    while ((this.zK) && (!this.zL));
    zzasr();
  }

  private void zzasr()
  {
    ArrayList localArrayList = new ArrayList();
    this.zE = 1;
    this.zF = this.zA.Aj.size();
    Iterator localIterator = this.zA.Aj.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api.zzc localzzc = (Api.zzc)localIterator.next();
      if (this.zA.Ay.containsKey(localzzc))
      {
        if (!zzasp())
          continue;
        zzass();
        continue;
      }
      localArrayList.add((Api.zze)this.zA.Aj.get(localzzc));
    }
    if (!localArrayList.isEmpty())
      this.zQ.add(zzrg.zzatf().submit(new zzc(localArrayList)));
  }

  private void zzass()
  {
    this.zA.zzatd();
    zzrg.zzatf().execute(new Runnable()
    {
      public void run()
      {
        zzrb.zzb(zzrb.this).zzbn(zzrb.zza(zzrb.this));
      }
    });
    if (this.zI != null)
    {
      if (this.zN)
        this.zI.zza(this.zM, this.zO);
      zzbr(false);
    }
    Object localObject = this.zA.Ay.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Api.zzc localzzc = (Api.zzc)((Iterator)localObject).next();
      ((Api.zze)this.zA.Aj.get(localzzc)).disconnect();
    }
    if (this.zG.isEmpty());
    for (localObject = null; ; localObject = this.zG)
    {
      this.zA.AC.zzn((Bundle)localObject);
      return;
    }
  }

  private void zzast()
  {
    this.zK = false;
    this.zA.yW.Ak = Collections.emptySet();
    Iterator localIterator = this.zH.iterator();
    while (localIterator.hasNext())
    {
      Api.zzc localzzc = (Api.zzc)localIterator.next();
      if (this.zA.Ay.containsKey(localzzc))
        continue;
      this.zA.Ay.put(localzzc, new ConnectionResult(17, null));
    }
  }

  private void zzasu()
  {
    Iterator localIterator = this.zQ.iterator();
    while (localIterator.hasNext())
      ((Future)localIterator.next()).cancel(true);
    this.zQ.clear();
  }

  private Set<Scope> zzasv()
  {
    if (this.zP == null)
      return Collections.emptySet();
    HashSet localHashSet = new HashSet(this.zP.zzavp());
    Map localMap = this.zP.zzavr();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Api localApi = (Api)localIterator.next();
      if (this.zA.Ay.containsKey(localApi.zzaqv()))
        continue;
      localHashSet.addAll(((zzf.zza)localMap.get(localApi)).jw);
    }
    return localHashSet;
  }

  private void zzb(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
    if (paramInt != 2)
    {
      int i = paramApi.zzaqs().getPriority();
      if (zza(i, paramInt, paramConnectionResult))
      {
        this.zq = paramConnectionResult;
        this.zD = i;
      }
    }
    this.zA.Ay.put(paramApi.zzaqv(), paramConnectionResult);
  }

  private void zzbr(boolean paramBoolean)
  {
    if (this.zI != null)
    {
      if ((this.zI.isConnected()) && (paramBoolean))
        this.zI.zzcdc();
      this.zI.disconnect();
      this.zM = null;
    }
  }

  private boolean zzd(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.hasResolution());
    do
      return true;
    while (this.zm.zzfp(paramConnectionResult.getErrorCode()) != null);
    return false;
  }

  private boolean zze(ConnectionResult paramConnectionResult)
  {
    return (this.zJ == 2) || ((this.zJ == 1) && (!paramConnectionResult.hasResolution()));
  }

  private void zzf(ConnectionResult paramConnectionResult)
  {
    zzasu();
    if (!paramConnectionResult.hasResolution());
    for (boolean bool = true; ; bool = false)
    {
      zzbr(bool);
      this.zA.zzh(paramConnectionResult);
      this.zA.AC.zzc(paramConnectionResult);
      return;
    }
  }

  private boolean zzft(int paramInt)
  {
    if (this.zE != paramInt)
    {
      Log.w("GoogleApiClientConnecting", this.zA.yW.zzatb());
      String str1 = String.valueOf(this);
      Log.w("GoogleApiClientConnecting", String.valueOf(str1).length() + 23 + "Unexpected callback in " + str1);
      int i = this.zF;
      Log.w("GoogleApiClientConnecting", 33 + "mRemainingConnections=" + i);
      str1 = String.valueOf(zzfu(this.zE));
      String str2 = String.valueOf(zzfu(paramInt));
      Log.wtf("GoogleApiClientConnecting", String.valueOf(str1).length() + 70 + String.valueOf(str2).length() + "GoogleApiClient connecting is in step " + str1 + " but received callback for step " + str2, new Exception());
      zzf(new ConnectionResult(8, null));
      return false;
    }
    return true;
  }

  private String zzfu(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "UNKNOWN";
    case 0:
      return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    case 1:
    }
    return "STEP_GETTING_REMOTE_SERVICE";
  }

  public void begin()
  {
    this.zA.Ay.clear();
    this.zK = false;
    this.zq = null;
    this.zE = 0;
    this.zJ = 2;
    this.zL = false;
    this.zN = false;
    HashMap localHashMap = new HashMap();
    Object localObject = this.zk.keySet().iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      Api localApi = (Api)((Iterator)localObject).next();
      Api.zze localzze = (Api.zze)this.zA.Aj.get(localApi.zzaqv());
      int k = ((Integer)this.zk.get(localApi)).intValue();
      if (localApi.zzaqs().getPriority() == 1);
      for (int j = 1; ; j = 0)
      {
        if (localzze.zzain())
        {
          this.zK = true;
          if (k < this.zJ)
            this.zJ = k;
          if (k != 0)
            this.zH.add(localApi.zzaqv());
        }
        localHashMap.put(localzze, new zza(this, localApi, k));
        i = j | i;
        break;
      }
    }
    if (i != 0)
      this.zK = false;
    if (this.zK)
    {
      this.zP.zzc(Integer.valueOf(this.zA.yW.getSessionId()));
      localObject = new zze(null);
      this.zI = ((zzxp)this.xQ.zza(this.mContext, this.zA.yW.getLooper(), this.zP, this.zP.zzavv(), (GoogleApiClient.ConnectionCallbacks)localObject, (GoogleApiClient.OnConnectionFailedListener)localObject));
    }
    this.zF = this.zA.Aj.size();
    this.zQ.add(zzrg.zzatf().submit(new zzb(localHashMap)));
  }

  public void connect()
  {
  }

  public boolean disconnect()
  {
    zzasu();
    zzbr(true);
    this.zA.zzh(null);
    return true;
  }

  public void onConnected(Bundle paramBundle)
  {
    if (!zzft(1));
    do
    {
      return;
      if (paramBundle == null)
        continue;
      this.zG.putAll(paramBundle);
    }
    while (!zzasp());
    zzass();
  }

  public void onConnectionSuspended(int paramInt)
  {
    zzf(new ConnectionResult(8, null));
  }

  public <A extends Api.zzb, R extends Result, T extends zzqo.zza<R, A>> T zza(T paramT)
  {
    this.zA.yW.Ad.add(paramT);
    return paramT;
  }

  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt)
  {
    if (!zzft(1));
    do
    {
      return;
      zzb(paramConnectionResult, paramApi, paramInt);
    }
    while (!zzasp());
    zzass();
  }

  public <A extends Api.zzb, T extends zzqo.zza<? extends Result, A>> T zzb(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }

  private static class zza
    implements zze.zzf
  {
    private final Api<?> vS;
    private final int yU;
    private final WeakReference<zzrb> zS;

    public zza(zzrb paramzzrb, Api<?> paramApi, int paramInt)
    {
      this.zS = new WeakReference(paramzzrb);
      this.vS = paramApi;
      this.yU = paramInt;
    }

    public void zzg(@NonNull ConnectionResult paramConnectionResult)
    {
      boolean bool = false;
      zzrb localzzrb = (zzrb)this.zS.get();
      if (localzzrb == null)
        return;
      if (Looper.myLooper() == zzrb.zzd(localzzrb).yW.getLooper())
        bool = true;
      zzaa.zza(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
      zzrb.zzc(localzzrb).lock();
      try
      {
        bool = zzrb.zza(localzzrb, 0);
        if (!bool)
          return;
        if (!paramConnectionResult.isSuccess())
          zzrb.zza(localzzrb, paramConnectionResult, this.vS, this.yU);
        if (zzrb.zzk(localzzrb))
          zzrb.zzj(localzzrb);
        return;
      }
      finally
      {
        zzrb.zzc(localzzrb).unlock();
      }
      throw paramConnectionResult;
    }
  }

  private class zzb extends zzrb.zzf
  {
    private final Map<Api.zze, zzrb.zza> zT;

    public zzb()
    {
      super(null);
      Object localObject;
      this.zT = localObject;
    }

    @WorkerThread
    public void zzaso()
    {
      int n = 1;
      int m = 0;
      Object localObject = this.zT.keySet().iterator();
      int j = 1;
      int i = 0;
      Api.zze localzze;
      int k;
      if (((Iterator)localObject).hasNext())
      {
        localzze = (Api.zze)((Iterator)localObject).next();
        if (localzze.zzaqx())
        {
          if (zzrb.zza.zza((zzrb.zza)this.zT.get(localzze)) != 0)
            break label301;
          i = 1;
          k = n;
        }
      }
      while (true)
      {
        if (k != 0)
          m = zzrb.zzb(zzrb.this).isGooglePlayServicesAvailable(zzrb.zza(zzrb.this));
        if ((m != 0) && ((i != 0) || (j != 0)))
        {
          localObject = new ConnectionResult(m, null);
          zzrb.zzd(zzrb.this).zza(new zzrf.zza(zzrb.this, (ConnectionResult)localObject)
          {
            public void zzaso()
            {
              zzrb.zza(zzrb.this, this.zU);
            }
          });
          label155: return;
          k = 0;
          j = i;
          i = k;
        }
        while (true)
        {
          k = j;
          j = i;
          i = k;
          break;
          if (zzrb.zze(zzrb.this))
            zzrb.zzf(zzrb.this).connect();
          localObject = this.zT.keySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            localzze = (Api.zze)((Iterator)localObject).next();
            zze.zzf localzzf = (zze.zzf)this.zT.get(localzze);
            if ((localzze.zzaqx()) && (m != 0))
            {
              zzrb.zzd(zzrb.this).zza(new zzrf.zza(zzrb.this, localzzf)
              {
                public void zzaso()
                {
                  this.zW.zzg(new ConnectionResult(16, null));
                }
              });
              continue;
            }
            localzze.zza(localzzf);
          }
          break label155;
          label301: i = j;
          j = 1;
        }
        k = i;
        i = 0;
      }
    }
  }

  private class zzc extends zzrb.zzf
  {
    private final ArrayList<Api.zze> zX;

    public zzc()
    {
      super(null);
      Object localObject;
      this.zX = localObject;
    }

    @WorkerThread
    public void zzaso()
    {
      zzrb.zzd(zzrb.this).yW.Ak = zzrb.zzg(zzrb.this);
      Iterator localIterator = this.zX.iterator();
      while (localIterator.hasNext())
        ((Api.zze)localIterator.next()).zza(zzrb.zzh(zzrb.this), zzrb.zzd(zzrb.this).yW.Ak);
    }
  }

  private static class zzd extends zzb
  {
    private final WeakReference<zzrb> zS;

    zzd(zzrb paramzzrb)
    {
      this.zS = new WeakReference(paramzzrb);
    }

    @BinderThread
    public void zzb(SignInResponse paramSignInResponse)
    {
      zzrb localzzrb = (zzrb)this.zS.get();
      if (localzzrb == null)
        return;
      zzrb.zzd(localzzrb).zza(new zzrf.zza(localzzrb, localzzrb, paramSignInResponse)
      {
        public void zzaso()
        {
          zzrb.zza(this.zY, this.zZ);
        }
      });
    }
  }

  private class zze
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private zze()
    {
    }

    public void onConnected(Bundle paramBundle)
    {
      zzrb.zzf(zzrb.this).zza(new zzrb.zzd(zzrb.this));
    }

    public void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult)
    {
      zzrb.zzc(zzrb.this).lock();
      try
      {
        if (zzrb.zzb(zzrb.this, paramConnectionResult))
        {
          zzrb.zzi(zzrb.this);
          zzrb.zzj(zzrb.this);
        }
        while (true)
        {
          return;
          zzrb.zza(zzrb.this, paramConnectionResult);
        }
      }
      finally
      {
        zzrb.zzc(zzrb.this).unlock();
      }
      throw paramConnectionResult;
    }

    public void onConnectionSuspended(int paramInt)
    {
    }
  }

  private abstract class zzf
    implements Runnable
  {
    private zzf()
    {
    }

    @WorkerThread
    public void run()
    {
      zzrb.zzc(zzrb.this).lock();
      try
      {
        boolean bool = Thread.interrupted();
        if (bool)
          return;
        zzaso();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        zzrb.zzd(zzrb.this).zza(localRuntimeException);
        return;
      }
      finally
      {
        zzrb.zzc(zzrb.this).unlock();
      }
      throw localObject;
    }

    @WorkerThread
    protected abstract void zzaso();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzrb
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzf.zza;
import com.google.android.gms.internal.zzqm;
import com.google.android.gms.internal.zzqo.zza;
import com.google.android.gms.internal.zzqr;
import com.google.android.gms.internal.zzrd;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzrr;
import com.google.android.gms.internal.zzsa;
import com.google.android.gms.internal.zzsf;
import com.google.android.gms.internal.zzxo;
import com.google.android.gms.internal.zzxp;
import com.google.android.gms.internal.zzxq;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient
{
  public static final int SIGN_IN_MODE_OPTIONAL = 2;
  public static final int SIGN_IN_MODE_REQUIRED = 1;
  private static final Set<GoogleApiClient> xE = Collections.newSetFromMap(new WeakHashMap());

  public static void dumpAll(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    synchronized (xE)
    {
      String str = String.valueOf(paramString).concat("  ");
      Iterator localIterator = xE.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        GoogleApiClient localGoogleApiClient = (GoogleApiClient)localIterator.next();
        paramPrintWriter.append(paramString).append("GoogleApiClient#").println(i);
        localGoogleApiClient.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
      return;
    }
  }

  public static Set<GoogleApiClient> zzarc()
  {
    synchronized (xE)
    {
      Set localSet2 = xE;
      return localSet2;
    }
  }

  public abstract ConnectionResult blockingConnect();

  public abstract ConnectionResult blockingConnect(long paramLong, @NonNull TimeUnit paramTimeUnit);

  public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

  public abstract void connect();

  public void connect(int paramInt)
  {
    throw new UnsupportedOperationException();
  }

  public abstract void disconnect();

  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);

  @NonNull
  public abstract ConnectionResult getConnectionResult(@NonNull Api<?> paramApi);

  public Context getContext()
  {
    throw new UnsupportedOperationException();
  }

  public Looper getLooper()
  {
    throw new UnsupportedOperationException();
  }

  public abstract boolean hasConnectedApi(@NonNull Api<?> paramApi);

  public abstract boolean isConnected();

  public abstract boolean isConnecting();

  public abstract boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks paramConnectionCallbacks);

  public abstract boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener paramOnConnectionFailedListener);

  public abstract void reconnect();

  public abstract void registerConnectionCallbacks(@NonNull ConnectionCallbacks paramConnectionCallbacks);

  public abstract void registerConnectionFailedListener(@NonNull OnConnectionFailedListener paramOnConnectionFailedListener);

  public abstract void stopAutoManage(@NonNull FragmentActivity paramFragmentActivity);

  public abstract void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks paramConnectionCallbacks);

  public abstract void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener paramOnConnectionFailedListener);

  @NonNull
  public <C extends Api.zze> C zza(@NonNull Api.zzc<C> paramzzc)
  {
    throw new UnsupportedOperationException();
  }

  public <A extends Api.zzb, R extends Result, T extends zzqo.zza<R, A>> T zza(@NonNull T paramT)
  {
    throw new UnsupportedOperationException();
  }

  public void zza(zzsf paramzzsf)
  {
    throw new UnsupportedOperationException();
  }

  public boolean zza(@NonNull Api<?> paramApi)
  {
    throw new UnsupportedOperationException();
  }

  public boolean zza(zzsa paramzzsa)
  {
    throw new UnsupportedOperationException();
  }

  public void zzard()
  {
    throw new UnsupportedOperationException();
  }

  public <A extends Api.zzb, T extends zzqo.zza<? extends Result, A>> T zzb(@NonNull T paramT)
  {
    throw new UnsupportedOperationException();
  }

  public void zzb(zzsf paramzzsf)
  {
    throw new UnsupportedOperationException();
  }

  public <L> zzrr<L> zzs(@NonNull L paramL)
  {
    throw new UnsupportedOperationException();
  }

  public static final class Builder
  {
    private Account gj;
    private String hu;
    private final Context mContext;
    private final Set<Scope> xF = new HashSet();
    private final Set<Scope> xG = new HashSet();
    private int xH;
    private View xI;
    private String xJ;
    private final Map<Api<?>, zzf.zza> xK = new ArrayMap();
    private final Map<Api<?>, Api.ApiOptions> xL = new ArrayMap();
    private zzrn xM;
    private int xN = -1;
    private GoogleApiClient.OnConnectionFailedListener xO;
    private GoogleApiAvailability xP = GoogleApiAvailability.getInstance();
    private Api.zza<? extends zzxp, zzxq> xQ = zzxo.hh;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> xR = new ArrayList();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> xS = new ArrayList();
    private boolean xT = false;
    private Looper zzajy;

    public Builder(@NonNull Context paramContext)
    {
      this.mContext = paramContext;
      this.zzajy = paramContext.getMainLooper();
      this.hu = paramContext.getPackageName();
      this.xJ = paramContext.getClass().getName();
    }

    public Builder(@NonNull Context paramContext, @NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, @NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this(paramContext);
      zzaa.zzb(paramConnectionCallbacks, "Must provide a connected listener");
      this.xR.add(paramConnectionCallbacks);
      zzaa.zzb(paramOnConnectionFailedListener, "Must provide a connection failed listener");
      this.xS.add(paramOnConnectionFailedListener);
    }

    private static <C extends Api.zze, O> C zza(Api.zza<C, O> paramzza, Object paramObject, Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return paramzza.zza(paramContext, paramLooper, paramzzf, paramObject, paramConnectionCallbacks, paramOnConnectionFailedListener);
    }

    private Builder zza(@NonNull zzrn paramzzrn, int paramInt, @Nullable GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      if (paramInt >= 0);
      for (boolean bool = true; ; bool = false)
      {
        zzaa.zzb(bool, "clientId must be non-negative");
        this.xN = paramInt;
        this.xO = paramOnConnectionFailedListener;
        this.xM = paramzzrn;
        return this;
      }
    }

    private static <C extends Api.zzg, O> zzag zza(Api.zzh<C, O> paramzzh, Object paramObject, Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return new zzag(paramContext, paramLooper, paramzzh.zzaqz(), paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzf, paramzzh.zzr(paramObject));
    }

    private <O extends Api.ApiOptions> void zza(Api<O> paramApi, O paramO, int paramInt, Scope[] paramArrayOfScope)
    {
      boolean bool = true;
      int i = 0;
      if (paramInt == 1);
      while (true)
      {
        paramO = new HashSet(paramApi.zzaqs().zzp(paramO));
        int j = paramArrayOfScope.length;
        paramInt = i;
        while (true)
          if (paramInt < j)
          {
            paramO.add(paramArrayOfScope[paramInt]);
            paramInt += 1;
            continue;
            if (paramInt == 2)
            {
              bool = false;
              break;
            }
            throw new IllegalArgumentException(90 + "Invalid resolution mode: '" + paramInt + "', use a constant from GoogleApiClient.ResolutionMode");
          }
      }
      this.xK.put(paramApi, new zzf.zza(paramO, bool));
    }

    private GoogleApiClient zzarg()
    {
      zzf localzzf = zzarf();
      Object localObject2 = null;
      Map localMap = localzzf.zzavr();
      ArrayMap localArrayMap1 = new ArrayMap();
      ArrayMap localArrayMap2 = new ArrayMap();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.xL.keySet().iterator();
      Object localObject1 = null;
      Api localApi;
      Object localObject3;
      int i;
      label130: zzqr localzzqr;
      Object localObject4;
      if (localIterator.hasNext())
      {
        localApi = (Api)localIterator.next();
        localObject3 = this.xL.get(localApi);
        i = 0;
        if (localMap.get(localApi) != null)
        {
          if (((zzf.zza)localMap.get(localApi)).DN)
            i = 1;
        }
        else
        {
          localArrayMap1.put(localApi, Integer.valueOf(i));
          localzzqr = new zzqr(localApi, i);
          localArrayList.add(localzzqr);
          if (!localApi.zzaqw())
            break label324;
          localObject4 = localApi.zzaqu();
          if (((Api.zzh)localObject4).getPriority() != 1)
            break label591;
          localObject1 = localApi;
        }
      }
      label324: label583: label588: label591: 
      while (true)
      {
        localObject3 = zza((Api.zzh)localObject4, localObject3, this.mContext, this.zzajy, localzzf, localzzqr, localzzqr);
        label214: localArrayMap2.put(localApi.zzaqv(), localObject3);
        if (((Api.zze)localObject3).zzajc())
        {
          localObject3 = localApi;
          if (localObject2 == null)
            break label373;
          localObject1 = String.valueOf(localApi.getName());
          localObject2 = String.valueOf(((Api)localObject2).getName());
          throw new IllegalStateException(String.valueOf(localObject1).length() + 21 + String.valueOf(localObject2).length() + (String)localObject1 + " cannot be used with " + (String)localObject2);
          i = 2;
          break label130;
          localObject4 = localApi.zzaqt();
          if (((Api.zza)localObject4).getPriority() != 1)
            break label588;
          localObject1 = localApi;
        }
        while (true)
        {
          localObject3 = zza((Api.zza)localObject4, localObject3, this.mContext, this.zzajy, localzzf, localzzqr, localzzqr);
          break label214;
          localObject3 = localObject2;
          label373: localObject2 = localObject3;
          break;
          if (localObject2 != null)
          {
            if (localObject1 != null)
            {
              localObject2 = String.valueOf(((Api)localObject2).getName());
              localObject1 = String.valueOf(((Api)localObject1).getName());
              throw new IllegalStateException(String.valueOf(localObject2).length() + 21 + String.valueOf(localObject1).length() + (String)localObject2 + " cannot be used with " + (String)localObject1);
            }
            if (this.gj != null)
              break label583;
          }
          for (boolean bool = true; ; bool = false)
          {
            zzaa.zza(bool, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", new Object[] { ((Api)localObject2).getName() });
            zzaa.zza(this.xF.equals(this.xG), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", new Object[] { ((Api)localObject2).getName() });
            i = zzrd.zza(localArrayMap2.values(), true);
            return new zzrd(this.mContext, new ReentrantLock(), this.zzajy, localzzf, this.xP, this.xQ, localArrayMap1, this.xR, this.xS, localArrayMap2, this.xN, i, localArrayList, false);
          }
        }
      }
    }

    private void zzf(GoogleApiClient paramGoogleApiClient)
    {
      zzqm.zza(this.xM).zza(this.xN, paramGoogleApiClient, this.xO);
    }

    public Builder addApi(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi)
    {
      zzaa.zzb(paramApi, "Api must not be null");
      this.xL.put(paramApi, null);
      paramApi = paramApi.zzaqs().zzp(null);
      this.xG.addAll(paramApi);
      this.xF.addAll(paramApi);
      return this;
    }

    public <O extends Api.ApiOptions.HasOptions> Builder addApi(@NonNull Api<O> paramApi, @NonNull O paramO)
    {
      zzaa.zzb(paramApi, "Api must not be null");
      zzaa.zzb(paramO, "Null options are not permitted for this Api");
      this.xL.put(paramApi, paramO);
      paramApi = paramApi.zzaqs().zzp(paramO);
      this.xG.addAll(paramApi);
      this.xF.addAll(paramApi);
      return this;
    }

    public <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(@NonNull Api<O> paramApi, @NonNull O paramO, Scope[] paramArrayOfScope)
    {
      zzaa.zzb(paramApi, "Api must not be null");
      zzaa.zzb(paramO, "Null options are not permitted for this Api");
      this.xL.put(paramApi, paramO);
      zza(paramApi, paramO, 1, paramArrayOfScope);
      return this;
    }

    public Builder addApiIfAvailable(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi, Scope[] paramArrayOfScope)
    {
      zzaa.zzb(paramApi, "Api must not be null");
      this.xL.put(paramApi, null);
      zza(paramApi, null, 1, paramArrayOfScope);
      return this;
    }

    public Builder addConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      zzaa.zzb(paramConnectionCallbacks, "Listener must not be null");
      this.xR.add(paramConnectionCallbacks);
      return this;
    }

    public Builder addOnConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      zzaa.zzb(paramOnConnectionFailedListener, "Listener must not be null");
      this.xS.add(paramOnConnectionFailedListener);
      return this;
    }

    public Builder addScope(@NonNull Scope paramScope)
    {
      zzaa.zzb(paramScope, "Scope must not be null");
      this.xF.add(paramScope);
      return this;
    }

    public GoogleApiClient build()
    {
      boolean bool;
      if (!this.xL.isEmpty())
        bool = true;
      while (true)
      {
        zzaa.zzb(bool, "must call addApi() to add at least one API");
        GoogleApiClient localGoogleApiClient = zzarg();
        synchronized (GoogleApiClient.zzare())
        {
          GoogleApiClient.zzare().add(localGoogleApiClient);
          if (this.xN >= 0)
            zzf(localGoogleApiClient);
          return localGoogleApiClient;
          bool = false;
        }
      }
    }

    public Builder enableAutoManage(@NonNull FragmentActivity paramFragmentActivity, int paramInt, @Nullable GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return zza(new zzrn(paramFragmentActivity), paramInt, paramOnConnectionFailedListener);
    }

    public Builder enableAutoManage(@NonNull FragmentActivity paramFragmentActivity, @Nullable GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      return enableAutoManage(paramFragmentActivity, 0, paramOnConnectionFailedListener);
    }

    public Builder setAccountName(String paramString)
    {
      if (paramString == null);
      for (paramString = null; ; paramString = new Account(paramString, "com.google"))
      {
        this.gj = paramString;
        return this;
      }
    }

    public Builder setGravityForPopups(int paramInt)
    {
      this.xH = paramInt;
      return this;
    }

    public Builder setHandler(@NonNull Handler paramHandler)
    {
      zzaa.zzb(paramHandler, "Handler must not be null");
      this.zzajy = paramHandler.getLooper();
      return this;
    }

    public Builder setViewForPopups(@NonNull View paramView)
    {
      zzaa.zzb(paramView, "View must not be null");
      this.xI = paramView;
      return this;
    }

    public Builder useDefaultAccount()
    {
      return setAccountName("<<default account>>");
    }

    public zzf zzarf()
    {
      zzxq localzzxq = zzxq.aDl;
      if (this.xL.containsKey(zzxo.API))
        localzzxq = (zzxq)this.xL.get(zzxo.API);
      return new zzf(this.gj, this.xF, this.xK, this.xH, this.xI, this.hu, this.xJ, localzzxq);
    }
  }

  public static abstract interface ConnectionCallbacks
  {
    public static final int CAUSE_NETWORK_LOST = 2;
    public static final int CAUSE_SERVICE_DISCONNECTED = 1;

    public abstract void onConnected(@Nullable Bundle paramBundle);

    public abstract void onConnectionSuspended(int paramInt);
  }

  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.GoogleApiClient
 * JD-Core Version:    0.6.0
 */
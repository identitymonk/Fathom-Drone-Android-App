package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzqk;
import com.google.android.gms.internal.zzql;
import com.google.android.gms.internal.zzqo.zza;
import com.google.android.gms.internal.zzqr;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzrh;
import com.google.android.gms.internal.zzri;
import com.google.android.gms.internal.zzrr;
import com.google.android.gms.internal.zzrr.zzb;
import com.google.android.gms.internal.zzrs;
import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzsb;
import com.google.android.gms.internal.zzse;
import com.google.android.gms.internal.zzsh;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzc<O extends Api.ApiOptions>
{
  private final Context mContext;
  private final int mId;
  private final Api<O> vS;
  private final zzsb xA;
  private final Api.zze xB;
  private final zzqr xC;
  private final O xw;
  private final zzql<O> xx;
  private final zzrh xy;
  private final GoogleApiClient xz;
  private final Looper zzajy;

  @MainThread
  public zzc(@NonNull Activity paramActivity, Api<O> paramApi, O paramO, Looper paramLooper, zzsb paramzzsb)
  {
    zzaa.zzb(paramActivity, "Null activity is not permitted.");
    zzaa.zzb(paramApi, "Api must not be null.");
    zzaa.zzb(paramLooper, "Looper must not be null.");
    this.mContext = paramActivity.getApplicationContext();
    this.vS = paramApi;
    this.xw = paramO;
    this.zzajy = paramLooper;
    this.xx = zzql.zza(this.vS, this.xw);
    this.xz = new zzri(this);
    this.xy = zzrh.zzbx(this.mContext);
    this.mId = this.xy.zzath();
    this.xA = paramzzsb;
    this.xB = null;
    this.xC = null;
    zzqw.zza(paramActivity, this.xy, this.xx);
    this.xy.zza(this);
  }

  public zzc(@NonNull Activity paramActivity, Api<O> paramApi, O paramO, zzsb paramzzsb)
  {
    this(paramActivity, paramApi, paramO, paramActivity.getMainLooper(), paramzzsb);
  }

  protected zzc(@NonNull Context paramContext, Api<O> paramApi, Looper paramLooper, Api.zze paramzze, zzqr paramzzqr)
  {
    zzaa.zzb(paramContext, "Null context is not permitted.");
    zzaa.zzb(paramApi, "Api must not be null.");
    zzaa.zzb(paramLooper, "Looper must not be null.");
    this.mContext = paramContext.getApplicationContext();
    this.vS = paramApi;
    this.xw = null;
    this.zzajy = paramLooper;
    this.xx = zzql.zzb(paramApi);
    this.xz = new zzri(this);
    this.xy = zzrh.zzbx(this.mContext);
    this.mId = this.xy.zzath();
    this.xA = new zzqk();
    this.xB = paramzze;
    this.xC = paramzzqr;
    this.xy.zza(this);
  }

  public zzc(@NonNull Context paramContext, Api<O> paramApi, O paramO, Looper paramLooper, zzsb paramzzsb)
  {
    zzaa.zzb(paramContext, "Null context is not permitted.");
    zzaa.zzb(paramApi, "Api must not be null.");
    zzaa.zzb(paramLooper, "Looper must not be null.");
    this.mContext = paramContext.getApplicationContext();
    this.vS = paramApi;
    this.xw = paramO;
    this.zzajy = paramLooper;
    this.xx = zzql.zza(this.vS, this.xw);
    this.xz = new zzri(this);
    this.xy = zzrh.zzbx(this.mContext);
    this.mId = this.xy.zzath();
    this.xA = paramzzsb;
    this.xB = null;
    this.xC = null;
    this.xy.zza(this);
  }

  public zzc(@NonNull Context paramContext, Api<O> paramApi, O paramO, zzsb paramzzsb)
  {
  }

  private <A extends Api.zzb, T extends zzqo.zza<? extends Result, A>> T zza(int paramInt, @NonNull T paramT)
  {
    paramT.zzarv();
    this.xy.zza(this, paramInt, paramT);
    return paramT;
  }

  private <TResult, A extends Api.zzb> Task<TResult> zza(int paramInt, @NonNull zzse<A, TResult> paramzzse)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    this.xy.zza(this, paramInt, paramzzse, localTaskCompletionSource, this.xA);
    return localTaskCompletionSource.getTask();
  }

  public GoogleApiClient asGoogleApiClient()
  {
    return this.xz;
  }

  @WorkerThread
  public Api.zze buildApiClient(Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (this.xB == null);
    for (boolean bool = true; ; bool = false)
    {
      zzaa.zza(bool, "Client is already built, use getClient(). getClientCallbacks() should also be provided with a helper.");
      if (!this.vS.zzaqw())
        break;
      Api.zzh localzzh = this.vS.zzaqu();
      return new zzag(this.mContext, paramLooper, localzzh.zzaqz(), paramConnectionCallbacks, paramOnConnectionFailedListener, zzf.zzca(this.mContext), localzzh.zzr(this.xw));
    }
    return this.vS.zzaqt().zza(this.mContext, paramLooper, zzf.zzca(this.mContext), this.xw, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }

  public <A extends Api.zzb, T extends zzqo.zza<? extends Result, A>> T doBestEffortWrite(@NonNull T paramT)
  {
    return zza(2, paramT);
  }

  public <TResult, A extends Api.zzb> Task<TResult> doBestEffortWrite(zzse<A, TResult> paramzzse)
  {
    return zza(2, paramzzse);
  }

  public <A extends Api.zzb, T extends zzqo.zza<? extends Result, A>> T doRead(@NonNull T paramT)
  {
    return zza(0, paramT);
  }

  public <TResult, A extends Api.zzb> Task<TResult> doRead(zzse<A, TResult> paramzzse)
  {
    return zza(0, paramzzse);
  }

  public <A extends Api.zzb, T extends zzrw<A>, U extends zzsh<A>> Task<Void> doRegisterEventListener(@NonNull T paramT, U paramU)
  {
    zzaa.zzy(paramT);
    zzaa.zzy(paramU);
    zzaa.zzb(paramT.zzatz(), "Listener has already been released.");
    zzaa.zzb(paramU.zzatz(), "Listener has already been released.");
    zzaa.zzb(paramT.zzatz().equals(paramU.zzatz()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
    return this.xy.zza(this, paramT, paramU);
  }

  public Task<Void> doUnregisterEventListener(@NonNull zzrr.zzb<?> paramzzb)
  {
    zzaa.zzb(paramzzb, "Listener key cannot be null.");
    return this.xy.zza(this, paramzzb);
  }

  public <A extends Api.zzb, T extends zzqo.zza<? extends Result, A>> T doWrite(@NonNull T paramT)
  {
    return zza(1, paramT);
  }

  public <TResult, A extends Api.zzb> Task<TResult> doWrite(zzse<A, TResult> paramzzse)
  {
    return zza(1, paramzzse);
  }

  public Api<O> getApi()
  {
    return this.vS;
  }

  public zzql<O> getApiKey()
  {
    return this.xx;
  }

  public O getApiOptions()
  {
    return this.xw;
  }

  public Context getApplicationContext()
  {
    return this.mContext;
  }

  public Api.zze getClient()
  {
    return (Api.zze)zzaa.zzb(this.xB, "Client is null, buildApiClient() should be used.");
  }

  public zzqr getClientCallbacks()
  {
    return (zzqr)zzaa.zzb(this.xC, "ClientCallbacks is null.");
  }

  public int getInstanceId()
  {
    return this.mId;
  }

  public Looper getLooper()
  {
    return this.zzajy;
  }

  public boolean isConnectionlessGoogleApiClient()
  {
    return (this.xB != null) && (this.xC != null);
  }

  public <L> zzrr<L> registerListener(@NonNull L paramL, String paramString)
  {
    return zzrs.zzb(paramL, this.zzajy, paramString);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.zzc
 * JD-Core Version:    0.6.0
 */
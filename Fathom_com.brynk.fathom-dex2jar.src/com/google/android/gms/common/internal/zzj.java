package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import java.util.Iterator;
import java.util.Set;

public abstract class zzj<T extends IInterface> extends zze<T>
  implements Api.zze, zzk.zza
{
  private final Account gj;
  private final Set<Scope> jw;
  private final zzf zP;

  protected zzj(Context paramContext, Looper paramLooper, int paramInt, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, zzl.zzcc(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramzzf, (GoogleApiClient.ConnectionCallbacks)zzaa.zzy(paramConnectionCallbacks), (GoogleApiClient.OnConnectionFailedListener)zzaa.zzy(paramOnConnectionFailedListener));
  }

  protected zzj(Context paramContext, Looper paramLooper, zzl paramzzl, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramzzl, paramGoogleApiAvailability, paramInt, zza(paramConnectionCallbacks), zza(paramOnConnectionFailedListener), paramzzf.zzavt());
    this.zP = paramzzf;
    this.gj = paramzzf.getAccount();
    this.jw = zzb(paramzzf.zzavq());
  }

  @Nullable
  private static zze.zzb zza(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    if (paramConnectionCallbacks == null)
      return null;
    return new zze.zzb(paramConnectionCallbacks)
    {
      public void onConnected(@Nullable Bundle paramBundle)
      {
        zzj.this.onConnected(paramBundle);
      }

      public void onConnectionSuspended(int paramInt)
      {
        zzj.this.onConnectionSuspended(paramInt);
      }
    };
  }

  @Nullable
  private static zze.zzc zza(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (paramOnConnectionFailedListener == null)
      return null;
    return new zze.zzc(paramOnConnectionFailedListener)
    {
      public void onConnectionFailed(@NonNull ConnectionResult paramConnectionResult)
      {
        zzj.this.onConnectionFailed(paramConnectionResult);
      }
    };
  }

  private Set<Scope> zzb(@NonNull Set<Scope> paramSet)
  {
    Set localSet = zzc(paramSet);
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      if (paramSet.contains((Scope)localIterator.next()))
        continue;
      throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
    }
    return localSet;
  }

  public final Account getAccount()
  {
    return this.gj;
  }

  protected final Set<Scope> zzavi()
  {
    return this.jw;
  }

  protected final zzf zzawb()
  {
    return this.zP;
  }

  @NonNull
  protected Set<Scope> zzc(@NonNull Set<Scope> paramSet)
  {
    return paramSet;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzj
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class zzsq<R extends Result> extends zzqo.zza<R, zzsr>
{
  public zzsq(GoogleApiClient paramGoogleApiClient)
  {
    super(zzsn.API, paramGoogleApiClient);
  }

  static abstract class zza extends zzsq<Status>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }

    public Status zzb(Status paramStatus)
    {
      return paramStatus;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzsq
 * JD-Core Version:    0.6.0
 */
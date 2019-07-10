package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzru;
import com.google.android.gms.internal.zzsc;

public final class PendingResults
{
  public static PendingResult<Status> canceledPendingResult()
  {
    zzsc localzzsc = new zzsc(Looper.getMainLooper());
    localzzsc.cancel();
    return localzzsc;
  }

  public static <R extends Result> PendingResult<R> canceledPendingResult(R paramR)
  {
    zzaa.zzb(paramR, "Result must not be null");
    if (paramR.getStatus().getStatusCode() == 16);
    for (boolean bool = true; ; bool = false)
    {
      zzaa.zzb(bool, "Status code must be CommonStatusCodes.CANCELED");
      paramR = new zza(paramR);
      paramR.cancel();
      return paramR;
    }
  }

  public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R paramR)
  {
    zzaa.zzb(paramR, "Result must not be null");
    zzc localzzc = new zzc(null);
    localzzc.zzc(paramR);
    return new zzru(localzzc);
  }

  public static PendingResult<Status> immediatePendingResult(Status paramStatus)
  {
    zzaa.zzb(paramStatus, "Result must not be null");
    zzsc localzzsc = new zzsc(Looper.getMainLooper());
    localzzsc.zzc(paramStatus);
    return localzzsc;
  }

  public static <R extends Result> PendingResult<R> zza(R paramR, GoogleApiClient paramGoogleApiClient)
  {
    zzaa.zzb(paramR, "Result must not be null");
    if (!paramR.getStatus().isSuccess());
    for (boolean bool = true; ; bool = false)
    {
      zzaa.zzb(bool, "Status code must not be SUCCESS");
      paramGoogleApiClient = new zzb(paramGoogleApiClient, paramR);
      paramGoogleApiClient.zzc(paramR);
      return paramGoogleApiClient;
    }
  }

  public static PendingResult<Status> zza(Status paramStatus, GoogleApiClient paramGoogleApiClient)
  {
    zzaa.zzb(paramStatus, "Result must not be null");
    paramGoogleApiClient = new zzsc(paramGoogleApiClient);
    paramGoogleApiClient.zzc(paramStatus);
    return paramGoogleApiClient;
  }

  public static <R extends Result> OptionalPendingResult<R> zzb(R paramR, GoogleApiClient paramGoogleApiClient)
  {
    zzaa.zzb(paramR, "Result must not be null");
    paramGoogleApiClient = new zzc(paramGoogleApiClient);
    paramGoogleApiClient.zzc(paramR);
    return new zzru(paramGoogleApiClient);
  }

  private static final class zza<R extends Result> extends zzqq<R>
  {
    private final R xU;

    public zza(R paramR)
    {
      super();
      this.xU = paramR;
    }

    protected R zzc(Status paramStatus)
    {
      if (paramStatus.getStatusCode() != this.xU.getStatus().getStatusCode())
        throw new UnsupportedOperationException("Creating failed results is not supported");
      return this.xU;
    }
  }

  private static final class zzb<R extends Result> extends zzqq<R>
  {
    private final R xV;

    public zzb(GoogleApiClient paramGoogleApiClient, R paramR)
    {
      super();
      this.xV = paramR;
    }

    protected R zzc(Status paramStatus)
    {
      return this.xV;
    }
  }

  private static final class zzc<R extends Result> extends zzqq<R>
  {
    public zzc(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }

    protected R zzc(Status paramStatus)
    {
      throw new UnsupportedOperationException("Creating failed results is not supported");
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.PendingResults
 * JD-Core Version:    0.6.0
 */
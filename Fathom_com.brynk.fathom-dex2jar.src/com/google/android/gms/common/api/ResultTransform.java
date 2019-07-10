package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.internal.zzrz;

public abstract class ResultTransform<R extends Result, S extends Result>
{
  @NonNull
  public final PendingResult<S> createFailedResult(@NonNull Status paramStatus)
  {
    return new zzrz(paramStatus);
  }

  @NonNull
  public Status onFailure(@NonNull Status paramStatus)
  {
    return paramStatus;
  }

  @Nullable
  @WorkerThread
  public abstract PendingResult<S> onSuccess(@NonNull R paramR);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.ResultTransform
 * JD-Core Version:    0.6.0
 */
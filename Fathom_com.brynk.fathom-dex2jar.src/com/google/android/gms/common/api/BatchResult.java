package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzaa;
import java.util.concurrent.TimeUnit;

public final class BatchResult
  implements Result
{
  private final Status hv;
  private final PendingResult<?>[] xs;

  BatchResult(Status paramStatus, PendingResult<?>[] paramArrayOfPendingResult)
  {
    this.hv = paramStatus;
    this.xs = paramArrayOfPendingResult;
  }

  public Status getStatus()
  {
    return this.hv;
  }

  public <R extends Result> R take(BatchResultToken<R> paramBatchResultToken)
  {
    if (paramBatchResultToken.mId < this.xs.length);
    for (boolean bool = true; ; bool = false)
    {
      zzaa.zzb(bool, "The result token does not belong to this batch");
      return this.xs[paramBatchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.BatchResult
 * JD-Core Version:    0.6.0
 */
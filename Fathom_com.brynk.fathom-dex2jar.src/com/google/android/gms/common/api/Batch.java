package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzqq;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends zzqq<BatchResult>
{
  private int xp;
  private boolean xq;
  private boolean xr;
  private final PendingResult<?>[] xs;
  private final Object zzako = new Object();

  private Batch(List<PendingResult<?>> paramList, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
    this.xp = paramList.size();
    this.xs = new PendingResult[this.xp];
    if (paramList.isEmpty())
      zzc(new BatchResult(Status.xZ, this.xs));
    while (true)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        paramGoogleApiClient = (PendingResult)paramList.get(i);
        this.xs[i] = paramGoogleApiClient;
        paramGoogleApiClient.zza(new PendingResult.zza()
        {
          public void zzx(Status paramStatus)
          {
            while (true)
            {
              synchronized (Batch.zza(Batch.this))
              {
                if (Batch.this.isCanceled())
                  return;
                if (paramStatus.isCanceled())
                {
                  Batch.zza(Batch.this, true);
                  Batch.zzb(Batch.this);
                  if (Batch.zzc(Batch.this) != 0)
                    continue;
                  if (!Batch.zzd(Batch.this))
                    break;
                  Batch.zze(Batch.this);
                  return;
                }
              }
              if (paramStatus.isSuccess())
                continue;
              Batch.zzb(Batch.this, true);
            }
            if (Batch.zzf(Batch.this));
            for (paramStatus = new Status(13); ; paramStatus = Status.xZ)
            {
              Batch.this.zzc(new BatchResult(paramStatus, Batch.zzg(Batch.this)));
              break;
            }
          }
        });
        i += 1;
      }
    }
  }

  public void cancel()
  {
    super.cancel();
    PendingResult[] arrayOfPendingResult = this.xs;
    int j = arrayOfPendingResult.length;
    int i = 0;
    while (i < j)
    {
      arrayOfPendingResult[i].cancel();
      i += 1;
    }
  }

  public BatchResult createFailedResult(Status paramStatus)
  {
    return new BatchResult(paramStatus, this.xs);
  }

  public static final class Builder
  {
    private GoogleApiClient mD;
    private List<PendingResult<?>> xu = new ArrayList();

    public Builder(GoogleApiClient paramGoogleApiClient)
    {
      this.mD = paramGoogleApiClient;
    }

    public <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
    {
      BatchResultToken localBatchResultToken = new BatchResultToken(this.xu.size());
      this.xu.add(paramPendingResult);
      return localBatchResultToken;
    }

    public Batch build()
    {
      return new Batch(this.xu, this.mD, null);
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Batch
 * JD-Core Version:    0.6.0
 */
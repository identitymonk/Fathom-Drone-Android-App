package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public class zze
  implements zzn
{
  private final Executor zzr;

  public zze(Handler paramHandler)
  {
    this.zzr = new Executor(paramHandler)
    {
      public void execute(Runnable paramRunnable)
      {
        this.zzs.post(paramRunnable);
      }
    };
  }

  public void zza(zzk<?> paramzzk, zzm<?> paramzzm)
  {
    zza(paramzzk, paramzzm, null);
  }

  public void zza(zzk<?> paramzzk, zzm<?> paramzzm, Runnable paramRunnable)
  {
    paramzzk.zzt();
    paramzzk.zzc("post-response");
    this.zzr.execute(new zza(paramzzk, paramzzm, paramRunnable));
  }

  public void zza(zzk<?> paramzzk, zzr paramzzr)
  {
    paramzzk.zzc("post-error");
    paramzzr = zzm.zzd(paramzzr);
    this.zzr.execute(new zza(paramzzk, paramzzr, null));
  }

  private class zza
    implements Runnable
  {
    private final zzk zzu;
    private final zzm zzv;
    private final Runnable zzw;

    public zza(zzk paramzzm, zzm paramRunnable, Runnable arg4)
    {
      this.zzu = paramzzm;
      this.zzv = paramRunnable;
      Object localObject;
      this.zzw = localObject;
    }

    public void run()
    {
      if (this.zzu.isCanceled())
        this.zzu.zzd("canceled-at-delivery");
      label97: label107: 
      while (true)
      {
        return;
        if (this.zzv.isSuccess())
        {
          this.zzu.zza(this.zzv.result);
          if (!this.zzv.zzbh)
            break label97;
          this.zzu.zzc("intermediate-response");
        }
        while (true)
        {
          if (this.zzw == null)
            break label107;
          this.zzw.run();
          return;
          this.zzu.zzc(this.zzv.zzbg);
          break;
          this.zzu.zzd("done");
        }
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zze
 * JD-Core Version:    0.6.0
 */
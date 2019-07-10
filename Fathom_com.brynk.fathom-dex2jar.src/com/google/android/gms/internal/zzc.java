package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class zzc extends Thread
{
  private static final boolean DEBUG = zzs.DEBUG;
  private final BlockingQueue<zzk<?>> zzg;
  private final BlockingQueue<zzk<?>> zzh;
  private final zzb zzi;
  private final zzn zzj;
  private volatile boolean zzk = false;

  public zzc(BlockingQueue<zzk<?>> paramBlockingQueue1, BlockingQueue<zzk<?>> paramBlockingQueue2, zzb paramzzb, zzn paramzzn)
  {
    super("VolleyCacheDispatcher");
    this.zzg = paramBlockingQueue1;
    this.zzh = paramBlockingQueue2;
    this.zzi = paramzzb;
    this.zzj = paramzzn;
  }

  public void quit()
  {
    this.zzk = true;
    interrupt();
  }

  public void run()
  {
    if (DEBUG)
      zzs.zza("start new dispatcher", new Object[0]);
    Process.setThreadPriority(10);
    this.zzi.initialize();
    while (true)
    {
      try
      {
        zzk localzzk = (zzk)this.zzg.take();
        localzzk.zzc("cache-queue-take");
        if (!localzzk.isCanceled())
          break label73;
        localzzk.zzd("cache-discard-canceled");
        continue;
      }
      catch (InterruptedException localInterruptedException)
      {
      }
      if (this.zzk)
      {
        return;
        label73: zzb.zza localzza = this.zzi.zza(localInterruptedException.zzg());
        if (localzza == null)
        {
          localInterruptedException.zzc("cache-miss");
          this.zzh.put(localInterruptedException);
          continue;
        }
        if (localzza.zza())
        {
          localInterruptedException.zzc("cache-hit-expired");
          localInterruptedException.zza(localzza);
          this.zzh.put(localInterruptedException);
          continue;
        }
        localInterruptedException.zzc("cache-hit");
        zzm localzzm = localInterruptedException.zza(new zzi(localzza.data, localzza.zzf));
        localInterruptedException.zzc("cache-hit-parsed");
        if (!localzza.zzb())
        {
          this.zzj.zza(localInterruptedException, localzzm);
          continue;
        }
        localInterruptedException.zzc("cache-hit-refresh-needed");
        localInterruptedException.zza(localzza);
        localzzm.zzbh = true;
        this.zzj.zza(localInterruptedException, localzzm, new Runnable(localInterruptedException)
        {
          public void run()
          {
            try
            {
              zzc.zza(zzc.this).put(this.zzl);
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
            }
          }
        });
      }
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzc
 * JD-Core Version:    0.6.0
 */
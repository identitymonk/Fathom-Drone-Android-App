package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;

class zzg<TResult>
{
  private Queue<zzf<TResult>> aMQ;
  private boolean aMR;
  private final Object zzako = new Object();

  public void zza(@NonNull Task<TResult> paramTask)
  {
    while (true)
    {
      zzf localzzf;
      synchronized (this.zzako)
      {
        if ((this.aMQ == null) || (this.aMR))
          return;
        this.aMR = true;
        synchronized (this.zzako)
        {
          localzzf = (zzf)this.aMQ.poll();
          if (localzzf == null)
          {
            this.aMR = false;
            return;
          }
        }
      }
      monitorexit;
      localzzf.onComplete(paramTask);
    }
  }

  public void zza(@NonNull zzf<TResult> paramzzf)
  {
    synchronized (this.zzako)
    {
      if (this.aMQ == null)
        this.aMQ = new ArrayDeque();
      this.aMQ.add(paramzzf);
      return;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzg
 * JD-Core Version:    0.6.0
 */
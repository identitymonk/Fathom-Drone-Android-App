package com.google.android.gms.internal;

import android.os.Process;

class zzsx
  implements Runnable
{
  private final int mPriority;
  private final Runnable zzw;

  public zzsx(Runnable paramRunnable, int paramInt)
  {
    this.zzw = paramRunnable;
    this.mPriority = paramInt;
  }

  public void run()
  {
    Process.setThreadPriority(this.mPriority);
    this.zzw.run();
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzsx
 * JD-Core Version:    0.6.0
 */
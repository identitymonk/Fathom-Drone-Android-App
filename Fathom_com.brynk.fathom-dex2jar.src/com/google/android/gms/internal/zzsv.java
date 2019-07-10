package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

public class zzsv
  implements Executor
{
  private final Handler mHandler;

  public zzsv(Looper paramLooper)
  {
    this.mHandler = new Handler(paramLooper);
  }

  public void execute(@NonNull Runnable paramRunnable)
  {
    this.mHandler.post(paramRunnable);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzsv
 * JD-Core Version:    0.6.0
 */
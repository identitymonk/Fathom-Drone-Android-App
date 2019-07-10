package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

abstract interface zzf<TResult>
{
  public abstract void cancel();

  public abstract void onComplete(@NonNull Task<TResult> paramTask);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tasks.zzf
 * JD-Core Version:    0.6.0
 */
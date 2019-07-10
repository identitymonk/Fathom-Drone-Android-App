package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzse<A extends Api.zzb, TResult>
{
  protected abstract void zzb(A paramA, TaskCompletionSource<TResult> paramTaskCompletionSource)
    throws RemoteException;
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.zzse
 * JD-Core Version:    0.6.0
 */
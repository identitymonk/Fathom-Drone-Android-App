package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import android.util.Log;

public abstract class ResultCallbacks<R extends Result>
  implements ResultCallback<R>
{
  public abstract void onFailure(@NonNull Status paramStatus);

  public final void onResult(@NonNull R paramR)
  {
    Status localStatus = paramR.getStatus();
    if (localStatus.isSuccess())
      onSuccess(paramR);
    do
    {
      return;
      onFailure(localStatus);
    }
    while (!(paramR instanceof Releasable));
    try
    {
      ((Releasable)paramR).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramR = String.valueOf(paramR);
      Log.w("ResultCallbacks", String.valueOf(paramR).length() + 18 + "Unable to release " + paramR, localRuntimeException);
    }
  }

  public abstract void onSuccess(@NonNull R paramR);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.ResultCallbacks
 * JD-Core Version:    0.6.0
 */
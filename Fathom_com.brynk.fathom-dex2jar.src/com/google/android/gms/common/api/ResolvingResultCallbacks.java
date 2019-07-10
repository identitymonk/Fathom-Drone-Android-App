package com.google.android.gms.common.api;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;

public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R>
{
  private final Activity mActivity;
  private final int xW;

  protected ResolvingResultCallbacks(@NonNull Activity paramActivity, int paramInt)
  {
    this.mActivity = ((Activity)zzaa.zzb(paramActivity, "Activity must not be null"));
    this.xW = paramInt;
  }

  public final void onFailure(@NonNull Status paramStatus)
  {
    if (paramStatus.hasResolution())
      try
      {
        paramStatus.startResolutionForResult(this.mActivity, this.xW);
        return;
      }
      catch (android.content.IntentSender.SendIntentException paramStatus)
      {
        Log.e("ResolvingResultCallback", "Failed to start resolution", paramStatus);
        onUnresolvableFailure(new Status(8));
        return;
      }
    onUnresolvableFailure(paramStatus);
  }

  public abstract void onSuccess(@NonNull R paramR);

  public abstract void onUnresolvableFailure(@NonNull Status paramStatus);
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.ResolvingResultCallbacks
 * JD-Core Version:    0.6.0
 */
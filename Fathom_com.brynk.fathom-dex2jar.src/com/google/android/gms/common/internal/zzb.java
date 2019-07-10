package com.google.android.gms.common.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zzd;

public class zzb
{
  @NonNull
  public static zza zzaf(@NonNull Status paramStatus)
  {
    if (paramStatus.hasResolution())
      return new zzd(paramStatus);
    return new zza(paramStatus);
  }

  @NonNull
  public static zza zzk(@NonNull ConnectionResult paramConnectionResult)
  {
    return zzaf(new Status(paramConnectionResult.getErrorCode(), paramConnectionResult.getErrorMessage(), paramConnectionResult.getResolution()));
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzb
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzai
  implements Parcelable.Creator<ValidateAccountRequest>
{
  static void zza(ValidateAccountRequest paramValidateAccountRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zzc(paramParcel, 1, paramValidateAccountRequest.mVersionCode);
    zzb.zzc(paramParcel, 2, paramValidateAccountRequest.zzawu());
    zzb.zza(paramParcel, 3, paramValidateAccountRequest.Df, false);
    zzb.zza(paramParcel, 4, paramValidateAccountRequest.zzaws(), paramInt, false);
    zzb.zza(paramParcel, 5, paramValidateAccountRequest.zzawv(), false);
    zzb.zza(paramParcel, 6, paramValidateAccountRequest.getCallingPackage(), false);
    zzb.zzaj(paramParcel, i);
  }

  public ValidateAccountRequest zzcp(Parcel paramParcel)
  {
    int i = 0;
    String str = null;
    int k = zza.zzcr(paramParcel);
    Bundle localBundle = null;
    Scope[] arrayOfScope = null;
    IBinder localIBinder = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcq(paramParcel);
      switch (zza.zzgu(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        j = zza.zzg(paramParcel, m);
        break;
      case 2:
        i = zza.zzg(paramParcel, m);
        break;
      case 3:
        localIBinder = zza.zzr(paramParcel, m);
        break;
      case 4:
        arrayOfScope = (Scope[])zza.zzb(paramParcel, m, Scope.CREATOR);
        break;
      case 5:
        localBundle = zza.zzs(paramParcel, m);
        break;
      case 6:
        str = zza.zzq(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    return new ValidateAccountRequest(j, i, localIBinder, arrayOfScope, localBundle, str);
  }

  public ValidateAccountRequest[] zzgt(int paramInt)
  {
    return new ValidateAccountRequest[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzai
 * JD-Core Version:    0.6.0
 */
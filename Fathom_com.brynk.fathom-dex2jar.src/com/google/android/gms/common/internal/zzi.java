package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<GetServiceRequest>
{
  static void zza(GetServiceRequest paramGetServiceRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetServiceRequest.version);
    zzb.zzc(paramParcel, 2, paramGetServiceRequest.DU);
    zzb.zzc(paramParcel, 3, paramGetServiceRequest.DV);
    zzb.zza(paramParcel, 4, paramGetServiceRequest.DW, false);
    zzb.zza(paramParcel, 5, paramGetServiceRequest.DX, false);
    zzb.zza(paramParcel, 6, paramGetServiceRequest.DY, paramInt, false);
    zzb.zza(paramParcel, 7, paramGetServiceRequest.DZ, false);
    zzb.zza(paramParcel, 8, paramGetServiceRequest.Ea, paramInt, false);
    zzb.zza(paramParcel, 9, paramGetServiceRequest.Eb);
    zzb.zzaj(paramParcel, i);
  }

  public GetServiceRequest zzcl(Parcel paramParcel)
  {
    int i = 0;
    Account localAccount = null;
    int m = zza.zzcr(paramParcel);
    long l = 0L;
    Bundle localBundle = null;
    Scope[] arrayOfScope = null;
    IBinder localIBinder = null;
    String str = null;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcq(paramParcel);
      switch (zza.zzgu(n))
      {
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1:
        k = zza.zzg(paramParcel, n);
        break;
      case 2:
        j = zza.zzg(paramParcel, n);
        break;
      case 3:
        i = zza.zzg(paramParcel, n);
        break;
      case 4:
        str = zza.zzq(paramParcel, n);
        break;
      case 5:
        localIBinder = zza.zzr(paramParcel, n);
        break;
      case 6:
        arrayOfScope = (Scope[])zza.zzb(paramParcel, n, Scope.CREATOR);
        break;
      case 7:
        localBundle = zza.zzs(paramParcel, n);
        break;
      case 8:
        localAccount = (Account)zza.zza(paramParcel, n, Account.CREATOR);
        break;
      case 9:
        l = zza.zzi(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza(37 + "Overread allowed size end=" + m, paramParcel);
    return new GetServiceRequest(k, j, i, str, localIBinder, arrayOfScope, localBundle, localAccount, l);
  }

  public GetServiceRequest[] zzgm(int paramInt)
  {
    return new GetServiceRequest[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzi
 * JD-Core Version:    0.6.0
 */
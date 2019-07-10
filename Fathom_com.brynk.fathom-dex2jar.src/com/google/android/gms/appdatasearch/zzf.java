package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<GetRecentContextCall.Request>
{
  static void zza(GetRecentContextCall.Request paramRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zza(paramParcel, 1, paramRequest.gt, paramInt, false);
    zzb.zza(paramParcel, 2, paramRequest.gu);
    zzb.zza(paramParcel, 3, paramRequest.gv);
    zzb.zza(paramParcel, 4, paramRequest.gw);
    zzb.zza(paramParcel, 5, paramRequest.gx, false);
    zzb.zzc(paramParcel, 1000, paramRequest.mVersionCode);
    zzb.zzaj(paramParcel, i);
  }

  public GetRecentContextCall.Request zzab(Parcel paramParcel)
  {
    String str = null;
    boolean bool1 = false;
    int j = zza.zzcr(paramParcel);
    boolean bool2 = false;
    boolean bool3 = false;
    Account localAccount = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcq(paramParcel);
      switch (zza.zzgu(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
        break;
      case 2:
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 3:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 4:
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 5:
        str = zza.zzq(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    return new GetRecentContextCall.Request(i, localAccount, bool3, bool2, bool1, str);
  }

  public GetRecentContextCall.Request[] zzcl(int paramInt)
  {
    return new GetRecentContextCall.Request[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appdatasearch.zzf
 * JD-Core Version:    0.6.0
 */
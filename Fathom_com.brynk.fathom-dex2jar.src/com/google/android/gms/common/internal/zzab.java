package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzab
  implements Parcelable.Creator<ResolveAccountRequest>
{
  static void zza(ResolveAccountRequest paramResolveAccountRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zzc(paramParcel, 1, paramResolveAccountRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramResolveAccountRequest.getAccount(), paramInt, false);
    zzb.zzc(paramParcel, 3, paramResolveAccountRequest.getSessionId());
    zzb.zza(paramParcel, 4, paramResolveAccountRequest.zzawl(), paramInt, false);
    zzb.zzaj(paramParcel, i);
  }

  public ResolveAccountRequest zzcm(Parcel paramParcel)
  {
    GoogleSignInAccount localGoogleSignInAccount = null;
    int j = 0;
    int m = zza.zzcr(paramParcel);
    Account localAccount = null;
    int i = 0;
    if (paramParcel.dataPosition() < m)
    {
      int k = zza.zzcq(paramParcel);
      switch (zza.zzgu(k))
      {
      default:
        zza.zzb(paramParcel, k);
        k = j;
        j = i;
        i = k;
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        k = j;
        j = i;
        i = k;
        break;
        k = zza.zzg(paramParcel, k);
        i = j;
        j = k;
        continue;
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
        k = i;
        i = j;
        j = k;
        continue;
        k = zza.zzg(paramParcel, k);
        j = i;
        i = k;
        continue;
        localGoogleSignInAccount = (GoogleSignInAccount)zza.zza(paramParcel, k, GoogleSignInAccount.CREATOR);
        k = i;
        i = j;
        j = k;
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza(37 + "Overread allowed size end=" + m, paramParcel);
    return new ResolveAccountRequest(i, localAccount, j, localGoogleSignInAccount);
  }

  public ResolveAccountRequest[] zzgq(int paramInt)
  {
    return new ResolveAccountRequest[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzab
 * JD-Core Version:    0.6.0
 */
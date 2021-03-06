package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<SignInResponse>
{
  static void zza(SignInResponse paramSignInResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zzc(paramParcel, 1, paramSignInResponse.mVersionCode);
    zzb.zza(paramParcel, 2, paramSignInResponse.zzawn(), paramInt, false);
    zzb.zza(paramParcel, 3, paramSignInResponse.zzcdn(), paramInt, false);
    zzb.zzaj(paramParcel, i);
  }

  public SignInResponse zzsd(Parcel paramParcel)
  {
    ResolveAccountResponse localResolveAccountResponse = null;
    int j = zza.zzcr(paramParcel);
    int i = 0;
    ConnectionResult localConnectionResult = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcq(paramParcel);
      switch (zza.zzgu(k))
      {
      default:
        zza.zzb(paramParcel, k);
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localConnectionResult = (ConnectionResult)zza.zza(paramParcel, k, ConnectionResult.CREATOR);
        continue;
        localResolveAccountResponse = (ResolveAccountResponse)zza.zza(paramParcel, k, ResolveAccountResponse.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    return new SignInResponse(i, localConnectionResult, localResolveAccountResponse);
  }

  public SignInResponse[] zzzy(int paramInt)
  {
    return new SignInResponse[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.zzi
 * JD-Core Version:    0.6.0
 */
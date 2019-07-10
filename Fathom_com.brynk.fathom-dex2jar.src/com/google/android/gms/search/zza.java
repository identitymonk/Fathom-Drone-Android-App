package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<GoogleNowAuthState>
{
  static void zza(GoogleNowAuthState paramGoogleNowAuthState, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcs(paramParcel);
    zzb.zza(paramParcel, 1, paramGoogleNowAuthState.getAuthCode(), false);
    zzb.zza(paramParcel, 2, paramGoogleNowAuthState.getAccessToken(), false);
    zzb.zza(paramParcel, 3, paramGoogleNowAuthState.getNextAllowedTimeMillis());
    zzb.zzc(paramParcel, 1000, paramGoogleNowAuthState.mVersionCode);
    zzb.zzaj(paramParcel, paramInt);
  }

  public GoogleNowAuthState zzry(Parcel paramParcel)
  {
    String str1 = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzcr(paramParcel);
    int i = 0;
    long l = 0L;
    String str2 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzcq(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzgu(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1:
        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 2:
        str1 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 3:
        l = com.google.android.gms.common.internal.safeparcel.zza.zzi(paramParcel, k);
        break;
      case 1000:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    return new GoogleNowAuthState(i, str2, str1, l);
  }

  public GoogleNowAuthState[] zzzs(int paramInt)
  {
    return new GoogleNowAuthState[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.search.zza
 * JD-Core Version:    0.6.0
 */
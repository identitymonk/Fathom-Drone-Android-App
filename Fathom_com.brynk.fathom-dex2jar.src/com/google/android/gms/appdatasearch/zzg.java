package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<GetRecentContextCall.Response>
{
  static void zza(GetRecentContextCall.Response paramResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zza(paramParcel, 1, paramResponse.gy, paramInt, false);
    zzb.zzc(paramParcel, 2, paramResponse.gz, false);
    zzb.zza(paramParcel, 3, paramResponse.gA, false);
    zzb.zzc(paramParcel, 1000, paramResponse.mVersionCode);
    zzb.zzaj(paramParcel, i);
  }

  public GetRecentContextCall.Response zzac(Parcel paramParcel)
  {
    String[] arrayOfString = null;
    int j = zza.zzcr(paramParcel);
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcq(paramParcel);
      Object localObject3;
      switch (zza.zzgu(k))
      {
      default:
        zza.zzb(paramParcel, k);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      case 1:
      case 2:
      case 3:
      case 1000:
      }
      while (true)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        localObject3 = (Status)zza.zza(paramParcel, k, Status.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = zza.zzc(paramParcel, k, UsageInfo.CREATOR);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        arrayOfString = zza.zzac(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        i = zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    return (GetRecentContextCall.Response)new GetRecentContextCall.Response(i, localObject1, localObject2, arrayOfString);
  }

  public GetRecentContextCall.Response[] zzcm(int paramInt)
  {
    return new GetRecentContextCall.Response[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appdatasearch.zzg
 * JD-Core Version:    0.6.0
 */
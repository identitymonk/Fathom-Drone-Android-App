package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<Feature>
{
  static void zza(Feature paramFeature, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcs(paramParcel);
    zzb.zzc(paramParcel, 1, paramFeature.id);
    zzb.zza(paramParcel, 2, paramFeature.gs, false);
    zzb.zzc(paramParcel, 1000, paramFeature.mVersionCode);
    zzb.zzaj(paramParcel, paramInt);
  }

  public Feature zzaa(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcr(paramParcel);
    Bundle localBundle = null;
    int i = 0;
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
        localBundle = zza.zzs(paramParcel, m);
        break;
      case 1000:
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    return new Feature(i, j, localBundle);
  }

  public Feature[] zzck(int paramInt)
  {
    return new Feature[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appdatasearch.zze
 * JD-Core Version:    0.6.0
 */
package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj
  implements Parcelable.Creator<Thing>
{
  static void zza(Thing paramThing, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zza(paramParcel, 1, paramThing.zzahu(), false);
    zzb.zza(paramParcel, 2, paramThing.zzcon(), paramInt, false);
    zzb.zza(paramParcel, 3, paramThing.getId(), false);
    zzb.zza(paramParcel, 4, paramThing.getType(), false);
    zzb.zzc(paramParcel, 1000, paramThing.getVersionCode());
    zzb.zzaj(paramParcel, i);
  }

  public Thing[] zzafe(int paramInt)
  {
    return new Thing[paramInt];
  }

  public Thing zzwe(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzcr(paramParcel);
    int i = 0;
    String str2 = null;
    Thing.Metadata localMetadata = null;
    Bundle localBundle = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcq(paramParcel);
      switch (zza.zzgu(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        localBundle = zza.zzs(paramParcel, k);
        break;
      case 2:
        localMetadata = (Thing.Metadata)zza.zza(paramParcel, k, Thing.Metadata.CREATOR);
        break;
      case 3:
        str2 = zza.zzq(paramParcel, k);
        break;
      case 4:
        str1 = zza.zzq(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    return new Thing(i, localBundle, localMetadata, str2, str1);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.internal.zzj
 * JD-Core Version:    0.6.0
 */
package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<Thing.Metadata>
{
  static void zza(Thing.Metadata paramMetadata, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcs(paramParcel);
    zzb.zza(paramParcel, 1, paramMetadata.zzcop());
    zzb.zzc(paramParcel, 2, paramMetadata.getScore());
    zzb.zza(paramParcel, 3, paramMetadata.zzcoq(), false);
    zzb.zzc(paramParcel, 1000, paramMetadata.mVersionCode);
    zzb.zzaj(paramParcel, paramInt);
  }

  public Thing.Metadata[] zzafc(int paramInt)
  {
    return new Thing.Metadata[paramInt];
  }

  public Thing.Metadata zzwc(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcr(paramParcel);
    String str = null;
    boolean bool = false;
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
        bool = zza.zzc(paramParcel, m);
        break;
      case 2:
        j = zza.zzg(paramParcel, m);
        break;
      case 3:
        str = zza.zzq(paramParcel, m);
        break;
      case 1000:
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    return new Thing.Metadata(i, bool, j, str);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.internal.zzh
 * JD-Core Version:    0.6.0
 */
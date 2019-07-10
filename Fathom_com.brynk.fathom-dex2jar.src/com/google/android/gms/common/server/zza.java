package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<FavaDiagnosticsEntity>
{
  static void zza(FavaDiagnosticsEntity paramFavaDiagnosticsEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcs(paramParcel);
    zzb.zzc(paramParcel, 1, paramFavaDiagnosticsEntity.mVersionCode);
    zzb.zza(paramParcel, 2, paramFavaDiagnosticsEntity.EY, false);
    zzb.zzc(paramParcel, 3, paramFavaDiagnosticsEntity.EZ);
    zzb.zzaj(paramParcel, paramInt);
  }

  public FavaDiagnosticsEntity zzct(Parcel paramParcel)
  {
    int j = 0;
    int k = com.google.android.gms.common.internal.safeparcel.zza.zzcr(paramParcel);
    String str = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = com.google.android.gms.common.internal.safeparcel.zza.zzcq(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzgu(m))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, m);
        break;
      case 1:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 2:
        str = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, m);
        break;
      case 3:
        j = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    return new FavaDiagnosticsEntity(i, str, j);
  }

  public FavaDiagnosticsEntity[] zzgw(int paramInt)
  {
    return new FavaDiagnosticsEntity[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.server.zza
 * JD-Core Version:    0.6.0
 */
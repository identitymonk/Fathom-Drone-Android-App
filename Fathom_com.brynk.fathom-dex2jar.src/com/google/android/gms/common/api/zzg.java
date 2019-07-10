package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<Status>
{
  static void zza(Status paramStatus, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zzc(paramParcel, 1, paramStatus.getStatusCode());
    zzb.zza(paramParcel, 2, paramStatus.getStatusMessage(), false);
    zzb.zza(paramParcel, 3, paramStatus.zzarj(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramStatus.mVersionCode);
    zzb.zzaj(paramParcel, i);
  }

  public Status zzcf(Parcel paramParcel)
  {
    PendingIntent localPendingIntent = null;
    int j = 0;
    int k = zza.zzcr(paramParcel);
    String str = null;
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
        str = zza.zzq(paramParcel, m);
        break;
      case 3:
        localPendingIntent = (PendingIntent)zza.zza(paramParcel, m, PendingIntent.CREATOR);
        break;
      case 1000:
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    return new Status(i, j, str, localPendingIntent);
  }

  public Status[] zzfr(int paramInt)
  {
    return new Status[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.zzg
 * JD-Core Version:    0.6.0
 */
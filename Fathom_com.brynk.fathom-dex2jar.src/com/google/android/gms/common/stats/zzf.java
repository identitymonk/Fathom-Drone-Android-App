package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf
  implements Parcelable.Creator<WakeLockEvent>
{
  static void zza(WakeLockEvent paramWakeLockEvent, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcs(paramParcel);
    zzb.zzc(paramParcel, 1, paramWakeLockEvent.mVersionCode);
    zzb.zza(paramParcel, 2, paramWakeLockEvent.getTimeMillis());
    zzb.zza(paramParcel, 4, paramWakeLockEvent.zzaxv(), false);
    zzb.zzc(paramParcel, 5, paramWakeLockEvent.zzaxy());
    zzb.zzb(paramParcel, 6, paramWakeLockEvent.zzaxz(), false);
    zzb.zza(paramParcel, 8, paramWakeLockEvent.zzayb());
    zzb.zza(paramParcel, 10, paramWakeLockEvent.zzaxw(), false);
    zzb.zzc(paramParcel, 11, paramWakeLockEvent.getEventType());
    zzb.zza(paramParcel, 12, paramWakeLockEvent.zzaya(), false);
    zzb.zza(paramParcel, 13, paramWakeLockEvent.zzayd(), false);
    zzb.zzc(paramParcel, 14, paramWakeLockEvent.zzayc());
    zzb.zza(paramParcel, 15, paramWakeLockEvent.zzaye());
    zzb.zza(paramParcel, 16, paramWakeLockEvent.zzayf());
    zzb.zza(paramParcel, 17, paramWakeLockEvent.zzaxx(), false);
    zzb.zzaj(paramParcel, paramInt);
  }

  public WakeLockEvent zzdc(Parcel paramParcel)
  {
    int n = zza.zzcr(paramParcel);
    int m = 0;
    long l3 = 0L;
    int k = 0;
    String str5 = null;
    int j = 0;
    ArrayList localArrayList = null;
    String str4 = null;
    long l2 = 0L;
    int i = 0;
    String str3 = null;
    String str2 = null;
    float f = 0.0F;
    long l1 = 0L;
    String str1 = null;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzcq(paramParcel);
      switch (zza.zzgu(i1))
      {
      case 3:
      case 7:
      case 9:
      default:
        zza.zzb(paramParcel, i1);
        break;
      case 1:
        m = zza.zzg(paramParcel, i1);
        break;
      case 2:
        l3 = zza.zzi(paramParcel, i1);
        break;
      case 4:
        str5 = zza.zzq(paramParcel, i1);
        break;
      case 5:
        j = zza.zzg(paramParcel, i1);
        break;
      case 6:
        localArrayList = zza.zzae(paramParcel, i1);
        break;
      case 8:
        l2 = zza.zzi(paramParcel, i1);
        break;
      case 10:
        str3 = zza.zzq(paramParcel, i1);
        break;
      case 11:
        k = zza.zzg(paramParcel, i1);
        break;
      case 12:
        str4 = zza.zzq(paramParcel, i1);
        break;
      case 13:
        str2 = zza.zzq(paramParcel, i1);
        break;
      case 14:
        i = zza.zzg(paramParcel, i1);
        break;
      case 15:
        f = zza.zzl(paramParcel, i1);
        break;
      case 16:
        l1 = zza.zzi(paramParcel, i1);
        break;
      case 17:
        str1 = zza.zzq(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n)
      throw new zza.zza(37 + "Overread allowed size end=" + n, paramParcel);
    return new WakeLockEvent(m, l3, k, str5, j, localArrayList, str4, l2, i, str3, str2, f, l1, str1);
  }

  public WakeLockEvent[] zzhf(int paramInt)
  {
    return new WakeLockEvent[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.stats.zzf
 * JD-Core Version:    0.6.0
 */
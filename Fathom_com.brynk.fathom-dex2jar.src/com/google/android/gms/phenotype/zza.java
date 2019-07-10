package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<Configuration>
{
  static void zza(Configuration paramConfiguration, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zzc(paramParcel, 1, paramConfiguration.mVersionCode);
    zzb.zzc(paramParcel, 2, paramConfiguration.aAs);
    zzb.zza(paramParcel, 3, paramConfiguration.aAt, paramInt, false);
    zzb.zza(paramParcel, 4, paramConfiguration.aAu, false);
    zzb.zzaj(paramParcel, i);
  }

  public Configuration zzrf(Parcel paramParcel)
  {
    String[] arrayOfString = null;
    int j = 0;
    int m = com.google.android.gms.common.internal.safeparcel.zza.zzcr(paramParcel);
    Flag[] arrayOfFlag = null;
    int i = 0;
    if (paramParcel.dataPosition() < m)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzcq(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzgu(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
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
        k = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        i = j;
        j = k;
        continue;
        k = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        j = i;
        i = k;
        continue;
        arrayOfFlag = (Flag[])com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k, Flag.CREATOR);
        k = i;
        i = j;
        j = k;
        continue;
        arrayOfString = com.google.android.gms.common.internal.safeparcel.zza.zzac(paramParcel, k);
        k = i;
        i = j;
        j = k;
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza(37 + "Overread allowed size end=" + m, paramParcel);
    return new Configuration(i, j, arrayOfFlag, arrayOfString);
  }

  public Configuration[] zzyx(int paramInt)
  {
    return new Configuration[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.phenotype.zza
 * JD-Core Version:    0.6.0
 */
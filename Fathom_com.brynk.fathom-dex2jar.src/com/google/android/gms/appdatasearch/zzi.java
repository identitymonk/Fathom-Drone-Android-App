package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<RegisterSectionInfo>
{
  static void zza(RegisterSectionInfo paramRegisterSectionInfo, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zza(paramParcel, 1, paramRegisterSectionInfo.name, false);
    zzb.zza(paramParcel, 2, paramRegisterSectionInfo.gD, false);
    zzb.zza(paramParcel, 3, paramRegisterSectionInfo.gE);
    zzb.zzc(paramParcel, 4, paramRegisterSectionInfo.weight);
    zzb.zza(paramParcel, 5, paramRegisterSectionInfo.gF);
    zzb.zza(paramParcel, 6, paramRegisterSectionInfo.gG, false);
    zzb.zza(paramParcel, 7, paramRegisterSectionInfo.gH, paramInt, false);
    zzb.zzc(paramParcel, 1000, paramRegisterSectionInfo.mVersionCode);
    zzb.zza(paramParcel, 8, paramRegisterSectionInfo.gI, false);
    zzb.zza(paramParcel, 11, paramRegisterSectionInfo.gJ, false);
    zzb.zzaj(paramParcel, i);
  }

  public RegisterSectionInfo zzad(Parcel paramParcel)
  {
    boolean bool1 = false;
    String str1 = null;
    int k = zza.zzcr(paramParcel);
    int i = 1;
    int[] arrayOfInt = null;
    Feature[] arrayOfFeature = null;
    String str2 = null;
    boolean bool2 = false;
    String str3 = null;
    String str4 = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcq(paramParcel);
      switch (zza.zzgu(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        str4 = zza.zzq(paramParcel, m);
        break;
      case 2:
        str3 = zza.zzq(paramParcel, m);
        break;
      case 3:
        bool2 = zza.zzc(paramParcel, m);
        break;
      case 4:
        i = zza.zzg(paramParcel, m);
        break;
      case 5:
        bool1 = zza.zzc(paramParcel, m);
        break;
      case 6:
        str2 = zza.zzq(paramParcel, m);
        break;
      case 7:
        arrayOfFeature = (Feature[])zza.zzb(paramParcel, m, Feature.CREATOR);
        break;
      case 1000:
        j = zza.zzg(paramParcel, m);
        break;
      case 8:
        arrayOfInt = zza.zzw(paramParcel, m);
        break;
      case 11:
        str1 = zza.zzq(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    return new RegisterSectionInfo(j, str4, str3, bool2, i, bool1, str2, arrayOfFeature, arrayOfInt, str1);
  }

  public RegisterSectionInfo[] zzcp(int paramInt)
  {
    return new RegisterSectionInfo[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appdatasearch.zzi
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<DocumentSection>
{
  static void zza(DocumentSection paramDocumentSection, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zza(paramParcel, 1, paramDocumentSection.go, false);
    zzb.zza(paramParcel, 3, paramDocumentSection.gp, paramInt, false);
    zzb.zzc(paramParcel, 4, paramDocumentSection.gq);
    zzb.zza(paramParcel, 5, paramDocumentSection.gr, false);
    zzb.zzc(paramParcel, 1000, paramDocumentSection.mVersionCode);
    zzb.zzaj(paramParcel, i);
  }

  public DocumentSection[] zzcj(int paramInt)
  {
    return new DocumentSection[paramInt];
  }

  public DocumentSection zzz(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
    int k = zza.zzcr(paramParcel);
    int j = 0;
    int i = -1;
    RegisterSectionInfo localRegisterSectionInfo = null;
    String str = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzcq(paramParcel);
      switch (zza.zzgu(m))
      {
      default:
        zza.zzb(paramParcel, m);
        break;
      case 1:
        str = zza.zzq(paramParcel, m);
        break;
      case 3:
        localRegisterSectionInfo = (RegisterSectionInfo)zza.zza(paramParcel, m, RegisterSectionInfo.CREATOR);
        break;
      case 4:
        i = zza.zzg(paramParcel, m);
        break;
      case 5:
        arrayOfByte = zza.zzt(paramParcel, m);
        break;
      case 1000:
        j = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    return new DocumentSection(j, str, localRegisterSectionInfo, i, arrayOfByte);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appdatasearch.zzd
 * JD-Core Version:    0.6.0
 */
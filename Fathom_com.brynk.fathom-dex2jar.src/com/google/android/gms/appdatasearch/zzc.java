package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<DocumentId>
{
  static void zza(DocumentId paramDocumentId, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcs(paramParcel);
    zzb.zza(paramParcel, 1, paramDocumentId.zzcjc, false);
    zzb.zza(paramParcel, 2, paramDocumentId.gk, false);
    zzb.zza(paramParcel, 3, paramDocumentId.gl, false);
    zzb.zzc(paramParcel, 1000, paramDocumentId.mVersionCode);
    zzb.zzaj(paramParcel, paramInt);
  }

  public DocumentId[] zzci(int paramInt)
  {
    return new DocumentId[paramInt];
  }

  public DocumentId zzy(Parcel paramParcel)
  {
    String str3 = null;
    int j = zza.zzcr(paramParcel);
    int i = 0;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcq(paramParcel);
      switch (zza.zzgu(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        str1 = zza.zzq(paramParcel, k);
        break;
      case 2:
        str2 = zza.zzq(paramParcel, k);
        break;
      case 3:
        str3 = zza.zzq(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    return new DocumentId(i, str1, str2, str3);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appdatasearch.zzc
 * JD-Core Version:    0.6.0
 */
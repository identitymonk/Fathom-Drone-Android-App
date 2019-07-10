package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj
  implements Parcelable.Creator<UsageInfo>
{
  static void zza(UsageInfo paramUsageInfo, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zza(paramParcel, 1, paramUsageInfo.gR, paramInt, false);
    zzb.zza(paramParcel, 2, paramUsageInfo.gS);
    zzb.zzc(paramParcel, 3, paramUsageInfo.gT);
    zzb.zza(paramParcel, 4, paramUsageInfo.zzbcj, false);
    zzb.zza(paramParcel, 5, paramUsageInfo.gU, paramInt, false);
    zzb.zza(paramParcel, 6, paramUsageInfo.gV);
    zzb.zzc(paramParcel, 7, paramUsageInfo.gW);
    zzb.zzc(paramParcel, 1000, paramUsageInfo.mVersionCode);
    zzb.zzc(paramParcel, 8, paramUsageInfo.gX);
    zzb.zzaj(paramParcel, i);
  }

  public UsageInfo zzae(Parcel paramParcel)
  {
    DocumentContents localDocumentContents = null;
    int i = 0;
    int n = zza.zzcr(paramParcel);
    long l = 0L;
    int j = -1;
    boolean bool = false;
    String str = null;
    int k = 0;
    DocumentId localDocumentId = null;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzcq(paramParcel);
      switch (zza.zzgu(i1))
      {
      default:
        zza.zzb(paramParcel, i1);
        break;
      case 1:
        localDocumentId = (DocumentId)zza.zza(paramParcel, i1, DocumentId.CREATOR);
        break;
      case 2:
        l = zza.zzi(paramParcel, i1);
        break;
      case 3:
        k = zza.zzg(paramParcel, i1);
        break;
      case 4:
        str = zza.zzq(paramParcel, i1);
        break;
      case 5:
        localDocumentContents = (DocumentContents)zza.zza(paramParcel, i1, DocumentContents.CREATOR);
        break;
      case 6:
        bool = zza.zzc(paramParcel, i1);
        break;
      case 7:
        j = zza.zzg(paramParcel, i1);
        break;
      case 1000:
        m = zza.zzg(paramParcel, i1);
        break;
      case 8:
        i = zza.zzg(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n)
      throw new zza.zza(37 + "Overread allowed size end=" + n, paramParcel);
    return new UsageInfo(m, localDocumentId, l, k, str, localDocumentContents, bool, j, i);
  }

  public UsageInfo[] zzcs(int paramInt)
  {
    return new UsageInfo[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appdatasearch.zzj
 * JD-Core Version:    0.6.0
 */
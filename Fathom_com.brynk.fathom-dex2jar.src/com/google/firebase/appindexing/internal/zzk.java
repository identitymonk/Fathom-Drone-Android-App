package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk
  implements Parcelable.Creator<UpdateTagsRequest>
{
  static void zza(UpdateTagsRequest paramUpdateTagsRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcs(paramParcel);
    zzb.zza(paramParcel, 1, paramUpdateTagsRequest.getUrl(), false);
    zzb.zza(paramParcel, 2, paramUpdateTagsRequest.zzcor(), false);
    zzb.zza(paramParcel, 3, paramUpdateTagsRequest.zzcos(), false);
    zzb.zzc(paramParcel, 1000, paramUpdateTagsRequest.mVersionCode);
    zzb.zzaj(paramParcel, paramInt);
  }

  public UpdateTagsRequest[] zzaff(int paramInt)
  {
    return new UpdateTagsRequest[paramInt];
  }

  public UpdateTagsRequest zzwf(Parcel paramParcel)
  {
    String[] arrayOfString2 = null;
    int j = zza.zzcr(paramParcel);
    int i = 0;
    String[] arrayOfString1 = null;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcq(paramParcel);
      switch (zza.zzgu(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        str = zza.zzq(paramParcel, k);
        break;
      case 2:
        arrayOfString1 = zza.zzac(paramParcel, k);
        break;
      case 3:
        arrayOfString2 = zza.zzac(paramParcel, k);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    return new UpdateTagsRequest(i, str, arrayOfString1, arrayOfString2);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.internal.zzk
 * JD-Core Version:    0.6.0
 */
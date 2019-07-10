package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<ActionImpl>
{
  static void zza(ActionImpl paramActionImpl, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zza(paramParcel, 1, paramActionImpl.zzcob(), false);
    zzb.zza(paramParcel, 2, paramActionImpl.zzcoc(), false);
    zzb.zza(paramParcel, 3, paramActionImpl.zzcod(), false);
    zzb.zza(paramParcel, 4, paramActionImpl.zzcoe(), false);
    zzb.zza(paramParcel, 5, paramActionImpl.zzcof(), paramInt, false);
    zzb.zza(paramParcel, 6, paramActionImpl.zzcog(), false);
    zzb.zzc(paramParcel, 1000, paramActionImpl.mVersionCode);
    zzb.zzaj(paramParcel, i);
  }

  public ActionImpl[] zzaez(int paramInt)
  {
    return new ActionImpl[paramInt];
  }

  public ActionImpl zzwb(Parcel paramParcel)
  {
    String str1 = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzcr(paramParcel);
    int i = 0;
    ActionImpl.MetadataImpl localMetadataImpl = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzcq(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzgu(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1:
        str5 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 2:
        str4 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 3:
        str3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 4:
        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 5:
        localMetadataImpl = (ActionImpl.MetadataImpl)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, ActionImpl.MetadataImpl.CREATOR);
        break;
      case 6:
        str1 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 1000:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    return new ActionImpl(i, str5, str4, str3, str2, localMetadataImpl, str1);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.internal.zza
 * JD-Core Version:    0.6.0
 */
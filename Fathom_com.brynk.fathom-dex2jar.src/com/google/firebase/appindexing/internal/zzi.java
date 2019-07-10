package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<ActionImpl.MetadataImpl>
{
  static void zza(ActionImpl.MetadataImpl paramMetadataImpl, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcs(paramParcel);
    zzb.zzc(paramParcel, 1, paramMetadataImpl.zzcoh());
    zzb.zza(paramParcel, 2, paramMetadataImpl.zzcoi());
    zzb.zza(paramParcel, 3, paramMetadataImpl.zzcoj(), false);
    zzb.zza(paramParcel, 4, paramMetadataImpl.getAccountName(), false);
    zzb.zza(paramParcel, 5, paramMetadataImpl.zzcok(), false);
    zzb.zza(paramParcel, 6, paramMetadataImpl.zzcol());
    zzb.zzc(paramParcel, 1000, paramMetadataImpl.mVersionCode);
    zzb.zzaj(paramParcel, paramInt);
  }

  public ActionImpl.MetadataImpl[] zzafd(int paramInt)
  {
    return new ActionImpl.MetadataImpl[paramInt];
  }

  public ActionImpl.MetadataImpl zzwd(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
    boolean bool1 = false;
    int k = zza.zzcr(paramParcel);
    String str1 = null;
    String str2 = null;
    boolean bool2 = false;
    int i = 0;
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
        i = zza.zzg(paramParcel, m);
        break;
      case 2:
        bool2 = zza.zzc(paramParcel, m);
        break;
      case 3:
        str2 = zza.zzq(paramParcel, m);
        break;
      case 4:
        str1 = zza.zzq(paramParcel, m);
        break;
      case 5:
        arrayOfByte = zza.zzt(paramParcel, m);
        break;
      case 6:
        bool1 = zza.zzc(paramParcel, m);
        break;
      case 1000:
        j = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k)
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    return new ActionImpl.MetadataImpl(j, i, bool2, str2, str1, arrayOfByte, bool1);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.internal.zzi
 * JD-Core Version:    0.6.0
 */
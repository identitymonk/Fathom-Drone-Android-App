package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<DocumentContents>
{
  static void zza(DocumentContents paramDocumentContents, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzcs(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 1, paramDocumentContents.gd, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramDocumentContents.ge, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramDocumentContents.gf);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, paramDocumentContents.account, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, paramDocumentContents.mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zzaj(paramParcel, i);
  }

  public DocumentContents[] zzch(int paramInt)
  {
    return new DocumentContents[paramInt];
  }

  public DocumentContents zzx(Parcel paramParcel)
  {
    boolean bool = false;
    Account localAccount = null;
    int j = zza.zzcr(paramParcel);
    String str = null;
    DocumentSection[] arrayOfDocumentSection = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcq(paramParcel);
      switch (zza.zzgu(k))
      {
      default:
        zza.zzb(paramParcel, k);
        break;
      case 1:
        arrayOfDocumentSection = (DocumentSection[])zza.zzb(paramParcel, k, DocumentSection.CREATOR);
        break;
      case 2:
        str = zza.zzq(paramParcel, k);
        break;
      case 3:
        bool = zza.zzc(paramParcel, k);
        break;
      case 4:
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
        break;
      case 1000:
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    return new DocumentContents(i, arrayOfDocumentSection, str, bool, localAccount);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appdatasearch.zzb
 * JD-Core Version:    0.6.0
 */
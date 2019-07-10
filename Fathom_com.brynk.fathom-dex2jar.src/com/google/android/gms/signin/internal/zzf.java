package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<RecordConsentRequest>
{
  static void zza(RecordConsentRequest paramRecordConsentRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zzc(paramParcel, 1, paramRecordConsentRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramRecordConsentRequest.getAccount(), paramInt, false);
    zzb.zza(paramParcel, 3, paramRecordConsentRequest.zzcdk(), paramInt, false);
    zzb.zza(paramParcel, 4, paramRecordConsentRequest.zzaix(), false);
    zzb.zzaj(paramParcel, i);
  }

  public RecordConsentRequest zzsb(Parcel paramParcel)
  {
    String str = null;
    int j = zza.zzcr(paramParcel);
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzcq(paramParcel);
      Object localObject3;
      switch (zza.zzgu(k))
      {
      default:
        zza.zzb(paramParcel, k);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        i = zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (Account)zza.zza(paramParcel, k, Account.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (Scope[])zza.zzb(paramParcel, k, Scope.CREATOR);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        str = zza.zzq(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    return (RecordConsentRequest)new RecordConsentRequest(i, localObject1, localObject2, str);
  }

  public RecordConsentRequest[] zzzw(int paramInt)
  {
    return new RecordConsentRequest[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.zzf
 * JD-Core Version:    0.6.0
 */
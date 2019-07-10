package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzac
  implements Parcelable.Creator<ResolveAccountResponse>
{
  static void zza(ResolveAccountResponse paramResolveAccountResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zzc(paramParcel, 1, paramResolveAccountResponse.mVersionCode);
    zzb.zza(paramParcel, 2, paramResolveAccountResponse.Df, false);
    zzb.zza(paramParcel, 3, paramResolveAccountResponse.zzawn(), paramInt, false);
    zzb.zza(paramParcel, 4, paramResolveAccountResponse.zzawo());
    zzb.zza(paramParcel, 5, paramResolveAccountResponse.zzawp());
    zzb.zzaj(paramParcel, i);
  }

  public ResolveAccountResponse zzcn(Parcel paramParcel)
  {
    ConnectionResult localConnectionResult = null;
    boolean bool1 = false;
    int j = zza.zzcr(paramParcel);
    boolean bool2 = false;
    IBinder localIBinder = null;
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
        i = zza.zzg(paramParcel, k);
        break;
      case 2:
        localIBinder = zza.zzr(paramParcel, k);
        break;
      case 3:
        localConnectionResult = (ConnectionResult)zza.zza(paramParcel, k, ConnectionResult.CREATOR);
        break;
      case 4:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 5:
        bool1 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    return new ResolveAccountResponse(i, localIBinder, localConnectionResult, bool2, bool1);
  }

  public ResolveAccountResponse[] zzgr(int paramInt)
  {
    return new ResolveAccountResponse[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzac
 * JD-Core Version:    0.6.0
 */
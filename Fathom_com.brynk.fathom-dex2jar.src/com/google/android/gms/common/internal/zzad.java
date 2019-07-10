package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzad
  implements Parcelable.Creator<SignInButtonConfig>
{
  static void zza(SignInButtonConfig paramSignInButtonConfig, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zzc(paramParcel, 1, paramSignInButtonConfig.mVersionCode);
    zzb.zzc(paramParcel, 2, paramSignInButtonConfig.zzawq());
    zzb.zzc(paramParcel, 3, paramSignInButtonConfig.zzawr());
    zzb.zza(paramParcel, 4, paramSignInButtonConfig.zzaws(), paramInt, false);
    zzb.zzaj(paramParcel, i);
  }

  public SignInButtonConfig zzco(Parcel paramParcel)
  {
    int k = 0;
    int m = zza.zzcr(paramParcel);
    Scope[] arrayOfScope = null;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzcq(paramParcel);
      switch (zza.zzgu(n))
      {
      default:
        zza.zzb(paramParcel, n);
        break;
      case 1:
        i = zza.zzg(paramParcel, n);
        break;
      case 2:
        j = zza.zzg(paramParcel, n);
        break;
      case 3:
        k = zza.zzg(paramParcel, n);
        break;
      case 4:
        arrayOfScope = (Scope[])zza.zzb(paramParcel, n, Scope.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m)
      throw new zza.zza(37 + "Overread allowed size end=" + m, paramParcel);
    return new SignInButtonConfig(i, j, k, arrayOfScope);
  }

  public SignInButtonConfig[] zzgs(int paramInt)
  {
    return new SignInButtonConfig[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzad
 * JD-Core Version:    0.6.0
 */
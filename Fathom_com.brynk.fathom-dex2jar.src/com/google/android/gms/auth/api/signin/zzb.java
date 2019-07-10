package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import java.util.ArrayList;

public class zzb
  implements Parcelable.Creator<GoogleSignInOptions>
{
  static void zza(GoogleSignInOptions paramGoogleSignInOptions, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzcs(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramGoogleSignInOptions.versionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, paramGoogleSignInOptions.zzait(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramGoogleSignInOptions.getAccount(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, paramGoogleSignInOptions.zzaiu());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, paramGoogleSignInOptions.zzaiv());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, paramGoogleSignInOptions.zzaiw());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 7, paramGoogleSignInOptions.zzaix(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 8, paramGoogleSignInOptions.zzaiy(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzaj(paramParcel, i);
  }

  public GoogleSignInOptions zzaw(Parcel paramParcel)
  {
    String str1 = null;
    boolean bool1 = false;
    int j = zza.zzcr(paramParcel);
    String str2 = null;
    boolean bool2 = false;
    boolean bool3 = false;
    Account localAccount = null;
    ArrayList localArrayList = null;
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
        localArrayList = zza.zzc(paramParcel, k, Scope.CREATOR);
        break;
      case 3:
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
        break;
      case 4:
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 5:
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 6:
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 7:
        str2 = zza.zzq(paramParcel, k);
        break;
      case 8:
        str1 = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    return new GoogleSignInOptions(i, localArrayList, localAccount, bool3, bool2, bool1, str2, str1);
  }

  public GoogleSignInOptions[] zzdk(int paramInt)
  {
    return new GoogleSignInOptions[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.zzb
 * JD-Core Version:    0.6.0
 */
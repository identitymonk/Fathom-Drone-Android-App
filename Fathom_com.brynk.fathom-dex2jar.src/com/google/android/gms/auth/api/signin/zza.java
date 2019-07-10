package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zza
  implements Parcelable.Creator<GoogleSignInAccount>
{
  static void zza(GoogleSignInAccount paramGoogleSignInAccount, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcs(paramParcel);
    zzb.zzc(paramParcel, 1, paramGoogleSignInAccount.versionCode);
    zzb.zza(paramParcel, 2, paramGoogleSignInAccount.getId(), false);
    zzb.zza(paramParcel, 3, paramGoogleSignInAccount.getIdToken(), false);
    zzb.zza(paramParcel, 4, paramGoogleSignInAccount.getEmail(), false);
    zzb.zza(paramParcel, 5, paramGoogleSignInAccount.getDisplayName(), false);
    zzb.zza(paramParcel, 6, paramGoogleSignInAccount.getPhotoUrl(), paramInt, false);
    zzb.zza(paramParcel, 7, paramGoogleSignInAccount.getServerAuthCode(), false);
    zzb.zza(paramParcel, 8, paramGoogleSignInAccount.zzaio());
    zzb.zza(paramParcel, 9, paramGoogleSignInAccount.zzaip(), false);
    zzb.zzc(paramParcel, 10, paramGoogleSignInAccount.hR, false);
    zzb.zza(paramParcel, 11, paramGoogleSignInAccount.getGivenName(), false);
    zzb.zza(paramParcel, 12, paramGoogleSignInAccount.getFamilyName(), false);
    zzb.zzaj(paramParcel, i);
  }

  public GoogleSignInAccount zzav(Parcel paramParcel)
  {
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzcr(paramParcel);
    int i = 0;
    String str8 = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    Uri localUri = null;
    String str4 = null;
    long l = 0L;
    String str3 = null;
    ArrayList localArrayList = null;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzcq(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzgu(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        break;
      case 2:
        str8 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 3:
        str7 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 4:
        str6 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 5:
        str5 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 6:
        localUri = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, Uri.CREATOR);
        break;
      case 7:
        str4 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 8:
        l = com.google.android.gms.common.internal.safeparcel.zza.zzi(paramParcel, k);
        break;
      case 9:
        str3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 10:
        localArrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, k, Scope.CREATOR);
        break;
      case 11:
        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 12:
        str1 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    return new GoogleSignInAccount(i, str8, str7, str6, str5, localUri, str4, l, str3, localArrayList, str2, str1);
  }

  public GoogleSignInAccount[] zzdj(int paramInt)
  {
    return new GoogleSignInAccount[paramInt];
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.zza
 * JD-Core Version:    0.6.0
 */
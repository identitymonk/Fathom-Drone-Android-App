package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class GoogleNowAuthState extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GoogleNowAuthState> CREATOR = new zza();
  String aCV;
  String aCW;
  long aCX;
  final int mVersionCode;

  GoogleNowAuthState(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    this.mVersionCode = paramInt;
    this.aCV = paramString1;
    this.aCW = paramString2;
    this.aCX = paramLong;
  }

  public String getAccessToken()
  {
    return this.aCW;
  }

  public String getAuthCode()
  {
    return this.aCV;
  }

  public long getNextAllowedTimeMillis()
  {
    return this.aCX;
  }

  public String toString()
  {
    String str1 = this.aCV;
    String str2 = this.aCW;
    long l = this.aCX;
    return String.valueOf(str1).length() + 74 + String.valueOf(str2).length() + "mAuthCode = " + str1 + "\nmAccessToken = " + str2 + "\nmNextAllowedTimeMillis = " + l;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.search.GoogleNowAuthState
 * JD-Core Version:    0.6.0
 */
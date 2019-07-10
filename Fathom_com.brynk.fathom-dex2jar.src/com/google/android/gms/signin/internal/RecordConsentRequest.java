package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class RecordConsentRequest extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<RecordConsentRequest> CREATOR = new zzf();
  private final Scope[] aDu;
  private final Account gj;
  private final String ju;
  final int mVersionCode;

  RecordConsentRequest(int paramInt, Account paramAccount, Scope[] paramArrayOfScope, String paramString)
  {
    this.mVersionCode = paramInt;
    this.gj = paramAccount;
    this.aDu = paramArrayOfScope;
    this.ju = paramString;
  }

  public Account getAccount()
  {
    return this.gj;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }

  public String zzaix()
  {
    return this.ju;
  }

  public Scope[] zzcdk()
  {
    return this.aDu;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.RecordConsentRequest
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInRequest extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<SignInRequest> CREATOR = new zzh();
  final ResolveAccountRequest aDw;
  final int mVersionCode;

  SignInRequest(int paramInt, ResolveAccountRequest paramResolveAccountRequest)
  {
    this.mVersionCode = paramInt;
    this.aDw = paramResolveAccountRequest;
  }

  public SignInRequest(ResolveAccountRequest paramResolveAccountRequest)
  {
    this(1, paramResolveAccountRequest);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }

  public ResolveAccountRequest zzcdm()
  {
    return this.aDw;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.SignInRequest
 * JD-Core Version:    0.6.0
 */
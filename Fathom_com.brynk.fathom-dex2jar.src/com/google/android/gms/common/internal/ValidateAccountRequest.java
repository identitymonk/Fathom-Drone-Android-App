package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public class ValidateAccountRequest extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ValidateAccountRequest> CREATOR = new zzai();
  final IBinder Df;
  private final Scope[] Dg;
  private final int ER;
  private final Bundle ES;
  private final String ET;
  final int mVersionCode;

  ValidateAccountRequest(int paramInt1, int paramInt2, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, String paramString)
  {
    this.mVersionCode = paramInt1;
    this.ER = paramInt2;
    this.Df = paramIBinder;
    this.Dg = paramArrayOfScope;
    this.ES = paramBundle;
    this.ET = paramString;
  }

  public String getCallingPackage()
  {
    return this.ET;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzai.zza(this, paramParcel, paramInt);
  }

  public Scope[] zzaws()
  {
    return this.Dg;
  }

  public int zzawu()
  {
    return this.ER;
  }

  public Bundle zzawv()
  {
    return this.ES;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.ValidateAccountRequest
 * JD-Core Version:    0.6.0
 */
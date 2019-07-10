package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AuthAccountResult extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<AuthAccountResult> CREATOR = new zza();
  private int aDq;
  private Intent aDr;
  final int mVersionCode;

  public AuthAccountResult()
  {
    this(0, null);
  }

  AuthAccountResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mVersionCode = paramInt1;
    this.aDq = paramInt2;
    this.aDr = paramIntent;
  }

  public AuthAccountResult(int paramInt, Intent paramIntent)
  {
    this(2, paramInt, paramIntent);
  }

  public Status getStatus()
  {
    if (this.aDq == 0)
      return Status.xZ;
    return Status.yd;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }

  public int zzcdi()
  {
    return this.aDq;
  }

  public Intent zzcdj()
  {
    return this.aDr;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.AuthAccountResult
 * JD-Core Version:    0.6.0
 */
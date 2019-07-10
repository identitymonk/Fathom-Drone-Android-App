package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ResolveAccountResponse extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zzac();
  IBinder Df;
  private ConnectionResult EJ;
  private boolean EK;
  final int mVersionCode;
  private boolean zN;

  ResolveAccountResponse(int paramInt, IBinder paramIBinder, ConnectionResult paramConnectionResult, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt;
    this.Df = paramIBinder;
    this.EJ = paramConnectionResult;
    this.zN = paramBoolean1;
    this.EK = paramBoolean2;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    do
    {
      return true;
      if (!(paramObject instanceof ResolveAccountResponse))
        return false;
      paramObject = (ResolveAccountResponse)paramObject;
    }
    while ((this.EJ.equals(paramObject.EJ)) && (zzawm().equals(paramObject.zzawm())));
    return false;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzac.zza(this, paramParcel, paramInt);
  }

  public zzp zzawm()
  {
    return zzp.zza.zzdr(this.Df);
  }

  public ConnectionResult zzawn()
  {
    return this.EJ;
  }

  public boolean zzawo()
  {
    return this.zN;
  }

  public boolean zzawp()
  {
    return this.EK;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.ResolveAccountResponse
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.zzc;
import java.util.Collection;

public class GetServiceRequest extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzi();
  final int DU;
  int DV;
  String DW;
  IBinder DX;
  Scope[] DY;
  Bundle DZ;
  Account Ea;
  long Eb;
  final int version;

  public GetServiceRequest(int paramInt)
  {
    this.version = 3;
    this.DV = zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    this.DU = paramInt;
  }

  GetServiceRequest(int paramInt1, int paramInt2, int paramInt3, String paramString, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, Account paramAccount, long paramLong)
  {
    this.version = paramInt1;
    this.DU = paramInt2;
    this.DV = paramInt3;
    if ("com.google.android.gms".equals(paramString))
    {
      this.DW = "com.google.android.gms";
      if (paramInt1 >= 2)
        break label78;
    }
    for (this.Ea = zzdq(paramIBinder); ; this.Ea = paramAccount)
    {
      this.DY = paramArrayOfScope;
      this.DZ = paramBundle;
      this.Eb = paramLong;
      return;
      this.DW = paramString;
      break;
      label78: this.DX = paramIBinder;
    }
  }

  private Account zzdq(IBinder paramIBinder)
  {
    Account localAccount = null;
    if (paramIBinder != null)
      localAccount = zza.zza(zzp.zza.zzdr(paramIBinder));
    return localAccount;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }

  public GetServiceRequest zzb(zzp paramzzp)
  {
    if (paramzzp != null)
      this.DX = paramzzp.asBinder();
    return this;
  }

  public GetServiceRequest zze(Account paramAccount)
  {
    this.Ea = paramAccount;
    return this;
  }

  public GetServiceRequest zzf(Collection<Scope> paramCollection)
  {
    this.DY = ((Scope[])paramCollection.toArray(new Scope[paramCollection.size()]));
    return this;
  }

  public GetServiceRequest zzhv(String paramString)
  {
    this.DW = paramString;
    return this;
  }

  public GetServiceRequest zzo(Bundle paramBundle)
  {
    this.DZ = paramBundle;
    return this;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.GetServiceRequest
 * JD-Core Version:    0.6.0
 */
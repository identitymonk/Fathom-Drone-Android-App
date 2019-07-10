package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInButtonConfig extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new zzad();

  @Deprecated
  private final Scope[] Dg;
  private final int EL;
  private final int EM;
  final int mVersionCode;

  SignInButtonConfig(int paramInt1, int paramInt2, int paramInt3, Scope[] paramArrayOfScope)
  {
    this.mVersionCode = paramInt1;
    this.EL = paramInt2;
    this.EM = paramInt3;
    this.Dg = paramArrayOfScope;
  }

  public SignInButtonConfig(int paramInt1, int paramInt2, Scope[] paramArrayOfScope)
  {
    this(1, paramInt1, paramInt2, null);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzad.zza(this, paramParcel, paramInt);
  }

  public int zzawq()
  {
    return this.EL;
  }

  public int zzawr()
  {
    return this.EM;
  }

  @Deprecated
  public Scope[] zzaws()
  {
    return this.Dg;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.SignInButtonConfig
 * JD-Core Version:    0.6.0
 */
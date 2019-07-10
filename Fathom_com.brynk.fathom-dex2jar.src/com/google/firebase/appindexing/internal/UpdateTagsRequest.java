package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class UpdateTagsRequest extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<UpdateTagsRequest> CREATOR = new zzk();
  private final String[] aWS;
  private final String[] aWT;
  public final int mVersionCode;
  private final String zzae;

  UpdateTagsRequest(int paramInt, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.mVersionCode = paramInt;
    this.zzae = paramString;
    this.aWS = paramArrayOfString1;
    this.aWT = paramArrayOfString2;
  }

  public String getUrl()
  {
    return this.zzae;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }

  public String[] zzcor()
  {
    return this.aWS;
  }

  public String[] zzcos()
  {
    return this.aWT;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.internal.UpdateTagsRequest
 * JD-Core Version:    0.6.0
 */
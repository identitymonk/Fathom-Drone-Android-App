package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class DocumentId extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<DocumentId> CREATOR = new zzc();
  final String gk;
  final String gl;
  final int mVersionCode;
  final String zzcjc;

  DocumentId(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.mVersionCode = paramInt;
    this.zzcjc = paramString1;
    this.gk = paramString2;
    this.gl = paramString3;
  }

  public DocumentId(String paramString1, String paramString2, String paramString3)
  {
    this(1, paramString1, paramString2, paramString3);
  }

  public String toString()
  {
    return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[] { this.zzcjc, this.gk, this.gl });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appdatasearch.DocumentId
 * JD-Core Version:    0.6.0
 */
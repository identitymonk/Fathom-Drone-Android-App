package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;

public class DocumentSection extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<DocumentSection> CREATOR;
  public static final int gm = Integer.parseInt("-1");
  private static final RegisterSectionInfo gn;
  public final String go;
  final RegisterSectionInfo gp;
  public final int gq;
  public final byte[] gr;
  final int mVersionCode;

  static
  {
    CREATOR = new zzd();
    gn = new RegisterSectionInfo.zza("SsbContext").zzaz(true).zzfr("blob").zzahr();
  }

  DocumentSection(int paramInt1, String paramString, RegisterSectionInfo paramRegisterSectionInfo, int paramInt2, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == gm) || (zzh.zzcn(paramInt2) != null));
    for (boolean bool = true; ; bool = false)
    {
      zzaa.zzb(bool, 32 + "Invalid section type " + paramInt2);
      this.mVersionCode = paramInt1;
      this.go = paramString;
      this.gp = paramRegisterSectionInfo;
      this.gq = paramInt2;
      this.gr = paramArrayOfByte;
      paramString = zzahp();
      if (paramString == null)
        break;
      throw new IllegalArgumentException(paramString);
    }
  }

  public DocumentSection(String paramString, RegisterSectionInfo paramRegisterSectionInfo)
  {
    this(1, paramString, paramRegisterSectionInfo, gm, null);
  }

  public DocumentSection(String paramString1, RegisterSectionInfo paramRegisterSectionInfo, String paramString2)
  {
    this(1, paramString1, paramRegisterSectionInfo, zzh.zzfq(paramString2), null);
  }

  public DocumentSection(byte[] paramArrayOfByte, RegisterSectionInfo paramRegisterSectionInfo)
  {
    this(1, null, paramRegisterSectionInfo, gm, paramArrayOfByte);
  }

  public static DocumentSection zzl(byte[] paramArrayOfByte)
  {
    return new DocumentSection(paramArrayOfByte, gn);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }

  public String zzahp()
  {
    if ((this.gq != gm) && (zzh.zzcn(this.gq) == null))
    {
      int i = this.gq;
      return 32 + "Invalid section type " + i;
    }
    if ((this.go != null) && (this.gr != null))
      return "Both content and blobContent set";
    return null;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appdatasearch.DocumentSection
 * JD-Core Version:    0.6.0
 */
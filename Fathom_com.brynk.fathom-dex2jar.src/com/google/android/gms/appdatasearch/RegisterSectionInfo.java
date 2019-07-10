package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class RegisterSectionInfo extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<RegisterSectionInfo> CREATOR = new zzi();
  public final String gD;
  public final boolean gE;
  public final boolean gF;
  public final String gG;
  public final Feature[] gH;
  final int[] gI;
  public final String gJ;
  final int mVersionCode;
  public final String name;
  public final int weight;

  RegisterSectionInfo(int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString3, Feature[] paramArrayOfFeature, int[] paramArrayOfInt, String paramString4)
  {
    this.mVersionCode = paramInt1;
    this.name = paramString1;
    this.gD = paramString2;
    this.gE = paramBoolean1;
    this.weight = paramInt2;
    this.gF = paramBoolean2;
    this.gG = paramString3;
    this.gH = paramArrayOfFeature;
    this.gI = paramArrayOfInt;
    this.gJ = paramString4;
  }

  RegisterSectionInfo(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString3, Feature[] paramArrayOfFeature, int[] paramArrayOfInt, String paramString4)
  {
    this(2, paramString1, paramString2, paramBoolean1, paramInt, paramBoolean2, paramString3, paramArrayOfFeature, paramArrayOfInt, paramString4);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }

  public static final class zza
  {
    private String gK;
    private boolean gL;
    private int gM;
    private boolean gN;
    private final List<Feature> gO;
    private BitSet gP;
    private String gQ;
    private final String mName;

    public zza(String paramString)
    {
      this.mName = paramString;
      this.gM = 1;
      this.gO = new ArrayList();
    }

    public RegisterSectionInfo zzahr()
    {
      int i = 0;
      if (this.gP != null)
      {
        int[] arrayOfInt2 = new int[this.gP.cardinality()];
        int j = this.gP.nextSetBit(0);
        while (true)
        {
          arrayOfInt1 = arrayOfInt2;
          if (j < 0)
            break;
          arrayOfInt2[i] = j;
          j = this.gP.nextSetBit(j + 1);
          i += 1;
        }
      }
      int[] arrayOfInt1 = null;
      return new RegisterSectionInfo(this.mName, this.gK, this.gL, this.gM, this.gN, null, (Feature[])this.gO.toArray(new Feature[this.gO.size()]), arrayOfInt1, this.gQ);
    }

    public zza zzaz(boolean paramBoolean)
    {
      this.gL = paramBoolean;
      return this;
    }

    public zza zzba(boolean paramBoolean)
    {
      this.gN = paramBoolean;
      return this;
    }

    public zza zzco(int paramInt)
    {
      if (this.gP == null)
        this.gP = new BitSet();
      this.gP.set(paramInt);
      return this;
    }

    public zza zzfr(String paramString)
    {
      this.gK = paramString;
      return this;
    }

    public zza zzfs(String paramString)
    {
      this.gQ = paramString;
      return this;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appdatasearch.RegisterSectionInfo
 * JD-Core Version:    0.6.0
 */
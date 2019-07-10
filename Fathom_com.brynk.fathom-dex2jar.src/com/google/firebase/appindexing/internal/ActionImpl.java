package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.appindexing.Action;

public class ActionImpl extends AbstractSafeParcelable
  implements Action
{
  public static final Parcelable.Creator<ActionImpl> CREATOR = new zza();
  private final String aWl;
  private final String aWm;
  private final String aWn;
  private final String aWo;
  private final MetadataImpl aWp;
  private final String aWq;
  public final int mVersionCode;

  ActionImpl(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, MetadataImpl paramMetadataImpl, String paramString5)
  {
    this.mVersionCode = paramInt;
    this.aWl = paramString1;
    this.aWm = paramString2;
    this.aWn = paramString3;
    this.aWo = paramString4;
    this.aWp = paramMetadataImpl;
    this.aWq = paramString5;
  }

  public ActionImpl(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, String paramString4, @NonNull MetadataImpl paramMetadataImpl, String paramString5)
  {
    this.mVersionCode = 1;
    this.aWl = paramString1;
    this.aWm = paramString2;
    this.aWn = paramString3;
    this.aWo = paramString4;
    this.aWp = paramMetadataImpl;
    this.aWq = paramString5;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ActionImpl { ");
    localStringBuilder.append("{ actionType: '").append(this.aWl).append("' } ");
    localStringBuilder.append("{ objectName: '").append(this.aWm).append("' } ");
    localStringBuilder.append("{ objectUrl: '").append(this.aWn).append("' } ");
    if (this.aWo != null)
      localStringBuilder.append("{ objectSameAs: '").append(this.aWo).append("' } ");
    if (this.aWp != null)
      localStringBuilder.append("{ metadata: '").append(this.aWp.toString()).append("' } ");
    if (this.aWq != null)
      localStringBuilder.append("{ actionStatus: '").append(this.aWq).append("' } ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }

  public String zzcob()
  {
    return this.aWl;
  }

  public String zzcoc()
  {
    return this.aWm;
  }

  public String zzcod()
  {
    return this.aWn;
  }

  public String zzcoe()
  {
    return this.aWo;
  }

  public MetadataImpl zzcof()
  {
    return this.aWp;
  }

  public String zzcog()
  {
    return this.aWq;
  }

  public static class MetadataImpl extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<MetadataImpl> CREATOR = new zzi();
    private final String aWA;
    private final byte[] aWB;
    private final boolean aWs;
    private final boolean aWt;
    private int gX = 0;
    private final String hy;
    public final int mVersionCode;

    MetadataImpl(int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2)
    {
      this.mVersionCode = paramInt1;
      this.gX = paramInt2;
      this.aWs = paramBoolean1;
      this.aWA = paramString1;
      this.hy = paramString2;
      this.aWB = paramArrayOfByte;
      this.aWt = paramBoolean2;
    }

    public MetadataImpl(boolean paramBoolean1, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2)
    {
      this.mVersionCode = 1;
      this.aWs = paramBoolean1;
      this.aWA = paramString1;
      this.hy = paramString2;
      this.aWB = paramArrayOfByte;
      this.aWt = paramBoolean2;
    }

    public String getAccountName()
    {
      return this.hy;
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MetadataImpl { ");
      localStringBuilder.append("{ eventStatus: '").append(this.gX).append("' } ");
      localStringBuilder.append("{ uploadable: '").append(this.aWs).append("' } ");
      if (this.aWA != null)
        localStringBuilder.append("{ completionToken: '").append(this.aWA).append("' } ");
      if (this.hy != null)
        localStringBuilder.append("{ accountName: '").append(this.hy).append("' } ");
      if (this.aWB != null)
      {
        localStringBuilder.append("{ ssbContext: [ ");
        byte[] arrayOfByte = this.aWB;
        int j = arrayOfByte.length;
        int i = 0;
        while (i < j)
        {
          int k = arrayOfByte[i];
          localStringBuilder.append("0x").append(Integer.toHexString(k)).append(" ");
          i += 1;
        }
        localStringBuilder.append("] } ");
      }
      localStringBuilder.append("{ contextOnly: '").append(this.aWt).append("' } ");
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzi.zza(this, paramParcel, paramInt);
    }

    public void zzaey(int paramInt)
    {
      this.gX = paramInt;
    }

    public int zzcoh()
    {
      return this.gX;
    }

    public boolean zzcoi()
    {
      return this.aWs;
    }

    public String zzcoj()
    {
      return this.aWA;
    }

    public byte[] zzcok()
    {
      return this.aWB;
    }

    public boolean zzcol()
    {
      return this.aWt;
    }
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.firebase.appindexing.internal.ActionImpl
 * JD-Core Version:    0.6.0
 */
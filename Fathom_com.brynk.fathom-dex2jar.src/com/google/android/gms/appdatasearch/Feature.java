package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzz;

public class Feature extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Feature> CREATOR = new zze();
  final Bundle gs;
  public final int id;
  final int mVersionCode;

  Feature(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.mVersionCode = paramInt1;
    this.id = paramInt2;
    this.gs = paramBundle;
  }

  public boolean equals(Object paramObject)
  {
    int j = 0;
    int i = j;
    if ((paramObject instanceof Feature))
    {
      paramObject = (Feature)paramObject;
      i = j;
      if (zzz.equal(Integer.valueOf(paramObject.id), Integer.valueOf(this.id)))
      {
        i = j;
        if (zzz.equal(paramObject.gs, this.gs))
          i = 1;
      }
    }
    return i;
  }

  public int hashCode()
  {
    return zzz.hashCode(new Object[] { Integer.valueOf(this.id), this.gs });
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appdatasearch.Feature
 * JD-Core Version:    0.6.0
 */
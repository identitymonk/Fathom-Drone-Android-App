package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.common.internal.zzz.zza;

public class PlaceReport extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<PlaceReport> CREATOR = new zzi();
  private final String alV;
  private final String bQ;
  private final String mTag;
  final int mVersionCode;

  PlaceReport(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.mVersionCode = paramInt;
    this.alV = paramString1;
    this.mTag = paramString2;
    this.bQ = paramString3;
  }

  public static PlaceReport create(String paramString1, String paramString2)
  {
    return zzj(paramString1, paramString2, "unknown");
  }

  public static PlaceReport zzj(String paramString1, String paramString2, String paramString3)
  {
    zzaa.zzy(paramString1);
    zzaa.zzib(paramString2);
    zzaa.zzib(paramString3);
    zzaa.zzb(zzla(paramString3), "Invalid source");
    return new PlaceReport(1, paramString1, paramString2, paramString3);
  }

  private static boolean zzla(String paramString)
  {
    int j = 1;
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -284840886:
    case -1194968642:
    case -1436706272:
    case 1287171955:
    case -262743844:
    case 1164924125:
    }
    while (true)
    {
      switch (i)
      {
      default:
        j = 0;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
      return j;
      if (!paramString.equals("unknown"))
        continue;
      i = 0;
      continue;
      if (!paramString.equals("userReported"))
        continue;
      i = 1;
      continue;
      if (!paramString.equals("inferredGeofencing"))
        continue;
      i = 2;
      continue;
      if (!paramString.equals("inferredRadioSignals"))
        continue;
      i = 3;
      continue;
      if (!paramString.equals("inferredReverseGeocoding"))
        continue;
      i = 4;
      continue;
      if (!paramString.equals("inferredSnappedToRoad"))
        continue;
      i = 5;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlaceReport));
    do
    {
      return false;
      paramObject = (PlaceReport)paramObject;
    }
    while ((!zzz.equal(this.alV, paramObject.alV)) || (!zzz.equal(this.mTag, paramObject.mTag)) || (!zzz.equal(this.bQ, paramObject.bQ)));
    return true;
  }

  public String getPlaceId()
  {
    return this.alV;
  }

  public String getSource()
  {
    return this.bQ;
  }

  public String getTag()
  {
    return this.mTag;
  }

  public int hashCode()
  {
    return zzz.hashCode(new Object[] { this.alV, this.mTag, this.bQ });
  }

  public String toString()
  {
    zzz.zza localzza = zzz.zzx(this);
    localzza.zzg("placeId", this.alV);
    localzza.zzg("tag", this.mTag);
    if (!"unknown".equals(this.bQ))
      localzza.zzg("source", this.bQ);
    return localzza.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.places.PlaceReport
 * JD-Core Version:    0.6.0
 */
package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzz;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Configuration extends AbstractSafeParcelable
  implements Comparable<Configuration>
{
  public static final Parcelable.Creator<Configuration> CREATOR = new zza();
  public final int aAs;
  public final Flag[] aAt;
  public final String[] aAu;
  public final Map<String, Flag> aAv;
  final int mVersionCode;

  Configuration(int paramInt1, int paramInt2, Flag[] paramArrayOfFlag, String[] paramArrayOfString)
  {
    this.mVersionCode = paramInt1;
    this.aAs = paramInt2;
    this.aAt = paramArrayOfFlag;
    this.aAv = new TreeMap();
    paramInt2 = paramArrayOfFlag.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      Flag localFlag = paramArrayOfFlag[paramInt1];
      this.aAv.put(localFlag.name, localFlag);
      paramInt1 += 1;
    }
    this.aAu = paramArrayOfString;
    if (this.aAu != null)
      Arrays.sort(this.aAu);
  }

  public boolean equals(Object paramObject)
  {
    int j = 0;
    int i = j;
    if (paramObject != null)
    {
      i = j;
      if ((paramObject instanceof Configuration))
      {
        paramObject = (Configuration)paramObject;
        i = j;
        if (this.mVersionCode == paramObject.mVersionCode)
        {
          i = j;
          if (this.aAs == paramObject.aAs)
          {
            i = j;
            if (zzz.equal(this.aAv, paramObject.aAv))
            {
              i = j;
              if (Arrays.equals(this.aAu, paramObject.aAu))
                i = 1;
            }
          }
        }
      }
    }
    return i;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Configuration(");
    localStringBuilder.append(this.mVersionCode);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.aAs);
    localStringBuilder.append(", ");
    localStringBuilder.append("(");
    Object localObject = this.aAv.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuilder.append((Flag)((Iterator)localObject).next());
      localStringBuilder.append(", ");
    }
    localStringBuilder.append(")");
    localStringBuilder.append(", ");
    localStringBuilder.append("(");
    if (this.aAu != null)
    {
      localObject = this.aAu;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(localObject[i]);
        localStringBuilder.append(", ");
        i += 1;
      }
    }
    localStringBuilder.append("null");
    localStringBuilder.append(")");
    localStringBuilder.append(")");
    return (String)localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }

  public int zza(Configuration paramConfiguration)
  {
    return this.aAs - paramConfiguration.aAs;
  }
}

/* Location:           C:\Users\c_jealom1\Documents\Scripts\Android\Fathom_com.brynk.fathom\Fathom_com.brynk.fathom-dex2jar.jar
 * Qualified Name:     com.google.android.gms.phenotype.Configuration
 * JD-Core Version:    0.6.0
 */